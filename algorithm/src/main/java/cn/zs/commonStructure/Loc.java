package cn.zs.commonStructure;

public class Loc {
   public double x;
   public double y;
    public Loc(int x,int y){
        this.x =x;
        this.y = y;
    }
    public double distance(Loc loc){
        double temp = (loc.x - x) * (loc.x - x) + (loc.y-y) * (loc.y-y);
        double res = Math.sqrt(temp);
        return res;
    }

}