package genc;

public class ObjectTool<T> {
    private T obj;

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public <T> void show(T t){
        System.out.println(t);
    }

    public static void main(String[] args){
        //创建对象并指定元素
        ObjectTool<String> tool = new ObjectTool<>();
        tool.setObj(new String("aaa"));
        String obj = tool.getObj();
        System.out.println(obj);

        //创建对象并指定元素类型
        ObjectTool<Integer> objectTool = new ObjectTool<>();
        /**
         * 如果我在这个对象里传入的是String类型的,它在编译时期就通过不了了.
         */
        objectTool.setObj(100);
        Integer obj1 = objectTool.getObj();
        System.out.println(obj1);


        ObjectTool objectObjectTool = new ObjectTool<>();
        objectObjectTool.show("hello");
        objectObjectTool.show(12);
        objectObjectTool.show(12.5);
    }
}
