package annotation.mvc.impl;

import annotation.impl.Person;
import annotation.permission;
import netscape.security.Privilege;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.LongAdder;

public class ServiceDaoFactory {
    private static final ServiceDaoFactory factory =
            new ServiceDaoFactory();
    private ServiceDaoFactory(){

    }

    public static ServiceDaoFactory getInstance(){
        return factory;
    }

    @Test
    public void  test(){
        //内存泄漏
        Set set = new HashSet<>();
        for (int i=0; i< 10;i++){
            Object obj = new Object();
            set.add(obj);
            obj = null;
        }
        System.out.println(set);
    }

    //需要判断该用户是否有权限
    public <T> T createDao(String className, Class<T> clazz, final Person person){
        System.out.println("添加分类进来!@!!");
        try {
            //得到该类的类型
            final  T t = (T) Class.forName(className);
            //返回该类的类型

            return (T) Proxy.newProxyInstance(ServiceDaoFactory.class.getClassLoader()
                    , t.getClass().getInterfaces(), new InvocationHandler() {
                        @Override
                        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                            //判断用户调用的是什么方法
                            String methodName = method.getName();
                            System.out.println(methodName);

                            //得到用户调用的真实方法,注意参数
                            Method method1 = t.getClass().getMethod(methodName, method.getParameterTypes());
                            //检查方法上是否有注解
                            permission annotation = method1.getAnnotation(permission.class);
                            //如果注解为空,那么该方法并不是需要权限,直接调用方法
                            if (annotation == null){
                                return method.invoke(t,args);
                            }
                            //如果注解不为空,得到注解上的权限
                            String privilege = annotation.value();
                            //设置权限
//                            Privilege privilege1 = new Privilege();
                            return null;
                        }
                    });
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
