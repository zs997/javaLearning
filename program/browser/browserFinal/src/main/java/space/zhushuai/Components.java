package space.zhushuai;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;

/*
基础组件
* **/
public class Components extends  JFrame{

    //三大容器
    JPanel jPanel_operate = null; //装界面操作组件
    JPanel jPanel_title = null; //装 标题的组件
    JPanel jPanel_command_btn = null;//装动态按钮的组件


    JLabel jLabel_title = null; //标题标签

    JButton btn_browse = null; //浏览按钮
    JButton btn_save = null; //保存按钮
    JButton btn_reset = null; //重置按钮
    JButton btn_clear = null; //清空数据按钮

    ActionListener actionListener = null;

    DataSource dataSource = null;

    //绑定数据源和监听器
    public Components(ActionListener actionListener,DataSource dataSource) {
        this.actionListener = actionListener;
        this.dataSource = dataSource;
        init_others();
        init_commandGroup();
        init_overall();
    }


    private Components(){

    }


    /**1、初始化其他  需要事先注入 监听器对象
     * */
    public void init_others(){
        jPanel_title = new JPanel(); //装标题的组件
        jPanel_operate = new JPanel(); //装界面操作组件

        jLabel_title = new JLabel("请选择要执行的文件：");// 标签
        jPanel_title.add(jLabel_title);

        btn_browse = new JButton("新增");// 钮1
        btn_save = new JButton("保存");// 钮2
        btn_reset = new JButton("撤销");
        btn_clear = new JButton("清除数据");

        btn_browse.addActionListener(actionListener);
        btn_save.addActionListener(actionListener);
        btn_reset.addActionListener(actionListener);
        btn_clear.addActionListener(actionListener);

        jPanel_operate.add(btn_browse);
        jPanel_operate.add(btn_save);
        jPanel_operate.add(btn_reset);
        jPanel_operate.add(btn_clear);
    }




    /**
     *  2、初始化命令按钮组整体
     * */
    public void init_commandGroup(){
       // Properties   properties_command = dataSource.getProperties_command();
        GridLayout gLayout_command_btn=new GridLayout(10,1);//按钮组布局 可以自适应吗？
        jPanel_command_btn = new JPanel();//装动态按钮的组件
        jPanel_command_btn.setLayout(gLayout_command_btn);
        refresh_jpanel_commandBtn();
    }



    //3、初始化全局窗口
    public void init_overall(){

        this.setTitle("软件集合工具箱");
        GridLayout layout_overall = new GridLayout(3,1);// 全局布局
        // 设置全局布局
        //layout.setAlignment(FlowLayout.LEFT);// 左对齐
        this.setLayout(layout_overall);
        this.setBounds(400, 200, 300, 500);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.add(jPanel_title);
        this.add(jPanel_command_btn);
        this.add(jPanel_operate);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if(dataSource.ischanged()){
                    int is_update = JOptionPane.showConfirmDialog(null, "是否保存您的更改？", "提示",
                            JOptionPane.YES_NO_OPTION);
                    if(is_update == 0){
                        dataSource.write();
                    }else{

                    }
                }
                super.windowClosing(e);
            }
        });

    }




    /**
     * 新增 程序按钮
     * */
    public void add_jpanel_commandBtn(int no,String fileName){
        JButton jButton_temp = new JButton(no + "_" + fileName);
        jButton_temp.addActionListener(actionListener);
        jPanel_command_btn.add(jButton_temp);// 钮1
        jPanel_command_btn.updateUI();
    }


    /**
     * 刷新命令按钮组
     * */
    public  void refresh_jpanel_commandBtn(){

        Properties properties_command = dataSource.getProperties_command();
        //清空命令按钮
        jPanel_command_btn.removeAll();

        /**遍历properties 初始化按钮         * */
        //键的有序化
        ArrayList<String> command_key_order = new ArrayList<>();
        Iterator<Map.Entry<Object, Object>> it = properties_command.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Object, Object> entry = it.next();
            String key = (String) entry.getKey();
            command_key_order.add(key);
        }
        command_key_order.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2) > 0 ? 1 :-1;
            }
        });
        //按需生成按钮 添加监听器
        JButton jButton_temp = null;
        for (int command_count = 1; command_count <= command_key_order.size(); command_count++) {
            // 新建命令按钮 命名格式 count_command_key
            jButton_temp = new JButton(command_count+"_"+command_key_order.get(command_count-1));
            jButton_temp.addActionListener(actionListener);
            jPanel_command_btn.add(jButton_temp);// 钮1

        }
        jPanel_command_btn.updateUI();
    }


}
