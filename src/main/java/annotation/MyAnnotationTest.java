package annotation;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyAnnotationTest {
    @MyAnnotation(username = "24",age = 21)
    public void add(String username,int age){
        System.out.println(username);
        System.out.println(age);
    }

    @Test
    public void run() throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {

       Class clazz= MyAnnotationTest.class;
        Method method = clazz.getMethod("add", String.class, int.class);
        //通过该方法得到注解上的具体信息
        MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
        String username = annotation.username();
        int age = annotation.age();

        //将注解上的信息注入到方法上
        Object o = clazz.newInstance();
        method.invoke(o,username,age);
    }

    @Test
    public void StringTest(){
        String str1 ="hello";
        String str2 = new String("hello");
        System.out.println(str1.equals(str2));
    }
}
