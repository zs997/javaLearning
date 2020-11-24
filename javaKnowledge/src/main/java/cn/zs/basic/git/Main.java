package cn.zs.basic.git;

public class Main {

    /**
     * 与GitHub远程仓库关联
     * github远程项目 可以ssh下载 可以https下载
     * https下载不需要本人登录github，下载后 每次push都需要 输入账户密码
     * 这时候如果idea登录了GitHub账户 也可以直接push 也会跳出账户密码输入栏
     *
     * 如果git使用 ssh 关联了GitHub账户（一台计算机一个关联），从此计算机上，使用ssh下载的项目，每次都可以直接push
     *
     * 总之，使用ssh绑定每个本地git，idea集成git
     * 使用ssh下载项目 然后push 就ok
     * idea GitHub登录啥的不用管
     * setting中ignore files 可以选择
     * 只提交java代码 和pom文件 就ok
     *
     *
     * 现在对notebook进行测试
     *
     * 还有问题：如果本地新建一个项目 怎样进行上传
     */

}
