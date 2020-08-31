package cn.zs.designPrinciple.dependenceInversion.improve;

public interface IReader {
    //读书器
    default void read(IRead iRead){
         iRead.read();
     }
}
