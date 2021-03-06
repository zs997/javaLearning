

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


//主程序 监听与调度
public class Main  implements ActionListener
{
    private static final long serialVersionUID = 1L;

    //
    private Components components = null;
    private DataSource dataSource_main = null;
    /**构造函数
     * */
    public Main()
    {

        //定义数据源 并初始化
        dataSource_main = new DataSource("airplane");
        //定义界面 初始化
        components = new Components(this,dataSource_main);
    }

    public static void main(String[] args)
    {
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
                //新添加的文件名
                String fileNameNow = fileName.substring(fileName.lastIndexOf("\\") + 1);
                //没有此键值对 才新加入
                //考虑运行时 数据区
                if (dataSource_main.getProperties_command().getProperty(fileNameNow) == null) {
                    dataSource_main.add(fileNameNow, file.toString());
                    components.add_jpanel_commandBtn(dataSource_main.getCommand_count(),fileNameNow);
                }
            }

        }else if(command.equals("保存")){
           // System.out.println("保存");
            //运行时 数据区 如果改变了
            if(dataSource_main.ischanged()){
               dataSource_main.write();
            }
        }else if (command.equals("撤销")) {
            //撤销更改
            //如果运行时改变了数据  还原成 刚加载的数据
            if(dataSource_main.ischanged()){
                dataSource_main.rollBack();
                //更新界面
                components.refresh_jpanel_commandBtn();
            }
        }else if(command.equals("清除数据")){
            System.out.println("清除数据");
            dataSource_main.clear();
            components.refresh_jpanel_commandBtn();
        }else{
            //判断是否是命令
            if(Utils.is_command(command)){
                String[] command_strArr = command.split("_");
                String command_path = dataSource_main.getProperties_command().getProperty(command_strArr[1]);
                Utils.RunCommand(command_path);
            }
        }
    }


}
