package cn.zs;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.*;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;

public class Main extends JFrame implements ActionListener
{
    static  String pan_no;
    static int count_command = 0;
    static boolean is_changed = false;  //是否更改过
    static Properties properties_command = new Properties(); //存储命令的键值对
    static  Properties properties_command_backup = new Properties(); //键值对缓冲区
    private static final long serialVersionUID = 1L;
    private Components components = null;

    //GridLayout gLayout = null; //jPanel_command_btn 布局

    static {
        String path_curr = System.getProperty("user.dir");
        pan_no = path_curr.substring(0,2);


    }
    //初始化全局窗口
    public  void init_overall(){

        this.setTitle("软件集合工具箱");
        GridLayout layout_overall = new GridLayout(3,1);// 全局布局
        // 设置全局布局
        //layout.setAlignment(FlowLayout.LEFT);// 左对齐
        this.setLayout(layout_overall);
        this.setBounds(600, 200, 300, 500);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.add(components.jPanel_title);
        this.add(components.jPanel_command_btn);
        this.add(components.jPanel_operate);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if(is_changed){
                    int is_update = javax.swing.JOptionPane.showConfirmDialog(null, "是否保存您的更改？", "提示",
                            javax.swing.JOptionPane.YES_NO_OPTION);
                    if(is_update == 0){
                        Utils.write_pro(properties_command);
                    }else{

                    }
                }
                super.windowClosing(e);
            }
        });
        //添加监听器
    }
    /**
     * 初始化命令按钮组
     * */
    public  void init_jpanel_command(){
        /**遍历properties 初始化按钮
         * */
        JButton jButton_temp = null;
        Iterator<Entry<Object, Object>> it = properties_command.entrySet().iterator();
        while (it.hasNext()) {
            Entry<Object, Object> entry = it.next();
            String key = (String) entry.getKey();
            // String value = (String) entry.getValue();

            // 新建命令按钮 命名格式 count_command_key
            jButton_temp = new JButton(count_command+"_"+key);
            jButton_temp.addActionListener(this);
            components.jPanel_command_btn.add(jButton_temp);// 钮1
       //     components.jPanel_command_btn.setBounds(600,600,300,100);
            count_command ++;
        }
    }
    /**
     *  初始化命令按钮组整体
     * */
    public void init_commandBtn(){

        GridLayout gLayout_command_btn=new GridLayout(10,1);//按钮组布局 可以自适应吗？
        components.jPanel_command_btn = new JPanel();//装动态按钮的组件
        components.jPanel_command_btn.setBounds(600,650,300,100);
        components.jPanel_command_btn.setLayout(gLayout_command_btn);
        init_jpanel_command();

    }
    /**初始化其他  1
     * */
    public void init_others(){

        components = new Components();
        components.jPanel_title = new JPanel(); //装标题的组件
        components.jPanel_operate = new JPanel(); //装界面操作组件
        components.jLabel_title = new JLabel("请选择要执行的文件：");// 标签
        components.jPanel_title.add(components.jLabel_title);

        components.btn_browse = new JButton("新增");// 钮1
        components.btn_save = new JButton("保存");// 钮2
        components.btn_reset = new JButton("重置");
        components.btn_clear = new JButton("清除数据");

        components.jPanel_operate.add(components.btn_browse);
        components.jPanel_operate.add(components.btn_save);
        components.jPanel_operate.add(components.btn_reset);
        components.jPanel_operate.add(components.btn_clear);

        components.btn_browse.addActionListener(this);
        components.btn_save.addActionListener(this);
        components.btn_reset.addActionListener(this);
        components.btn_clear.addActionListener(this);
    }


    /**
     *  遍历propertities  生成按钮
     *  生成布局
     * */
    public void init(){
        init_others();
        init_commandBtn();
        init_overall();
    }


    public Main()
    {
        init();

    }

    public static void main(String[] args)
    {
        //数据读入缓冲区
        Utils.read_pro(properties_command_backup);
        //缓冲区写到运行时数据区
        Utils.properties_command_copy(properties_command_backup,properties_command);
        new Main();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand();
        if(command == null || command.equals("")){return;}
        //监听新增按钮
        if(command.equals("新增")){

            JFileChooser chooser = new JFileChooser();
            chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            chooser.showDialog(new JLabel(), "选择");
            File file = chooser.getSelectedFile();
            if(file != null) {
                String fileName = file.toString();


                //弹出命名窗口
                JDialog jd = new JDialog();
                jd.setBounds(620, 350, 260, 100);
                jd.setTitle("");
                jd.getContentPane().setLayout(new GridLayout(2, 2));
                jd.add(new JLabel("请输入新的名称："));
                JTextField jTextField = new JTextField(80);
                jd.add(jTextField);
                JButton jButton = new JButton("确认");
                jButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        jd.setVisible(false);
                    }
                });

                jd.add(jButton);
                //jd.add(new JLabel("文本框二"));
               // jd.add(new JTextField(80));
                jd.setModal(true);//确保弹出的窗口在其他窗口前面
                jd.setVisible(true);
                //新添加的文件名
                String fileNameNow = fileName.substring(fileName.lastIndexOf("\\") + 1);
                //System.out.println(fileNameNow);
                if(jTextField.getText() != null){
                    fileNameNow = jTextField.getText();
                }
                //没有此键值对 才新加入
                //考虑运行时 数据区
                if (properties_command.getProperty(fileNameNow) == null) {

                    // 命令按钮 命名格式 count_command_key
                    String newBtnName = String.valueOf(count_command) + "_" + fileNameNow;
                    // System.out.println(fileNameNow);
                    String path = file.toString();
                    String [] pathArr = path.split(":");
                    for (int i = 0; i < pathArr.length; i++) {
                        System.out.println(pathArr[i]);
                    }
                    properties_command.setProperty(fileNameNow, pathArr[1]);

                    //设置运行时更改标志  改变运行时数据区
                    is_changed = true;

                    // 新建命令按钮 命名格式 count_command_key
                    JButton jButton_new_command = new JButton(newBtnName);
                    jButton_new_command.addActionListener(this);

                    components.jPanel_command_btn.add(jButton_new_command);

                    components.jPanel_command_btn.updateUI();
                    // System.out.println(count_command);
                    count_command++;
                }
            }

        }else if(command.equals("保存")){
           // System.out.println("保存");
            //运行时 数据区 如果改变了
            if(is_changed){
                //将运行时数据写到缓存数据
                Utils.properties_command_copy(properties_command,properties_command_backup);
                //将缓存数据写入磁盘
                Utils.write_pro(properties_command_backup);
                //保存之后 更改标志 为 没有更改
                is_changed = false;
            }


        }else if (command.equals("重置")) {
            //撤销更改
            //如果运行时改变了数据  还原成 刚加载的数据
            if(is_changed){
                is_changed = false;
               // System.out.println("重置");
                //清空命令按钮
                components.jPanel_command_btn.removeAll();
                // 重新计数
                count_command = 0;
                //从缓存区数据中还原到运行时数据  还原缓存
                Utils.properties_command_copy(properties_command_backup,properties_command);
                //重新初始化按钮组
                init_jpanel_command();
                //更新界面
                components.jPanel_command_btn.updateUI();
            }
        }else if(command.equals("清除数据")){
           // System.out.println("清除数据");
            int is_update = javax.swing.JOptionPane.showConfirmDialog(null, "确定清除数据？", "提示",
                    javax.swing.JOptionPane.YES_NO_OPTION);
            if(is_update == 0){
                is_changed = false;
                //清空命令按钮
                components.jPanel_command_btn.removeAll();
                // 重新计数
                count_command = 0;
                //清空数据区
                properties_command.clear();
                properties_command_backup.clear();

                //写入文件 空数据
                Utils.write_pro(properties_command_backup);
                //重新初始化按钮组
                init_jpanel_command();
                //更新界面
                components.jPanel_command_btn.updateUI();

            }else{

            }

        }else{
            // 要验证的字符串
            //例如 1_qq.exe
            String regEx = "^\\d+_[\\s\\S]*";
            // 编译正则表达式
            Pattern pattern = Pattern.compile(regEx);
            Matcher matcher = pattern.matcher(command);
            // 字符串是否与正则表达式相匹配
            boolean is_command = matcher.matches();

            if(is_command){

                String[] command_strArr = command.split("_");
                String command_path = pan_no +properties_command.getProperty(command_strArr[1]);
                System.out.println(command_path);
                Utils.RunCommand(command_path);

            }

        }


    }


    /**
     * 执行
     * 路径 path下的win exe程序
     *
     * */
   /*
    public  void RunWinExe(String path){
        Runtime rn = Runtime.getRuntime();
        Process p =null;
        try{
            p = rn.exec(path);
        }catch (Exception e){
            System.out.println(e+"it can not be execute");
        }
    }
    */

    /**
     *
     * 执行数组索引的路径
     * */
    /*
    public  void RunWinExe(int command_no){
        try{
            String path = file_list.get(command_no);
            RunWinExe(path);
        }catch (Exception e){
            System.out.println(e+"it can not be execute");
        }
    }
    */


}
