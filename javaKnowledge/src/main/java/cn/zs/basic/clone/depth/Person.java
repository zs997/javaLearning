package cn.zs.basic.clone.depth;



public class Person implements Cloneable{
    public String pname;
    public int page;
    public Address address;
    public Person() {}
    public Person(String pname, int page){
        this.pname = pname;
        this.page = page;
        this.address = new Address();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        //克隆出新的person 但内部引用类型需要设置新的  浅拷贝只是拷贝一层
        Person p = (Person) super.clone();
        p.address = (Address) address.clone();
        return p;
    }
    public void setAddress(String provices,String city ){
        address.setAddress(provices, city);
    }
    public void display(String name){
        System.out.println(name+":"+"pname=" + pname + ", page=" + page +","+ address);
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

}