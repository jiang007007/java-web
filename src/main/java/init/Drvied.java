package init;


import java.nio.Buffer;

class  Base{
    private  String name="a";
    public Base(){
        tellName();//子类 编译优化
        printName();
    }
    public void tellName(){
        System.out.println("Base tell ");
        System.out.println("Base tell name:" + name);
    }

    public void printName(){
        System.out.println("Base print ");
        System.out.println("Base print name:" + name);
    }
}
public class Drvied  extends Base{
    private String name="d";
    public Drvied(){
        tellName();
        printName();
    }

    public void tellName(){
        System.out.println("Drived tell name: " + name);
    }
    public void printName(){
        System.out.println("Drived print name:" + name);
    }
    public static void main(String [] args){
        new Drvied();
    }
}
