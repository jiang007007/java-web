package annotation;

import annotation.impl.Person;
import annotation.impl.PersonDao;
import org.junit.jupiter.api.Test;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnnotationTest {

    @Test
    public void rub() throws Exception{
        //使用内省[后边需要得到属性的写方法],得到想要注入的属性
        PropertyDescriptor descriptor = new PropertyDescriptor("person", PersonDao.class);

        //得到要想注入属性的具体对象
        Person person = (Person) descriptor.getPropertyType().newInstance();

        //得到该属性的写方法[setPerson()]
        Method method = descriptor.getWriteMethod();

        //得到写方法的注解
        Annotation annotation = method.getAnnotation(InjectPerson.class);

        //得到注解上的信息[注解的成员变量就是用方法来定义的]
        Method[] methods = annotation.getClass().getMethods();

        //将注解上的信息填充到Person对象上
        for (Method m : methods){
            //得到注解上属性的名字[age or name]
            String name = m.getName();
            //看看Person对象有没有与之对应的方法[setAge() or  setName()]
            try {
                //假设有 得到写方法
                PropertyDescriptor descriptor1 = new PropertyDescriptor(name, Person.class);
                Method method1 = descriptor1.getWriteMethod();
                Object invoke = m.invoke(annotation, null);
                method1.invoke(person,invoke );
            }catch (Exception e){
               continue;
            }
        }

        PersonDao personDao = new PersonDao();
        method.invoke(personDao,person);
        System.out.println(personDao.getPerson().getName());
        System.out.println(personDao.getPerson().isAge());
    }
    @Test
    public void  test() throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchFieldException {
        Class clazz= PersonDao.class;
        Method setPerson = clazz.getMethod("setPerson", Person.class);
        Person person = (Person) setPerson.getParameterTypes()[0].newInstance();
        Annotation annotation = setPerson.getAnnotation(InjectPerson.class);
        Method[] methods = annotation.getClass().getMethods();
        for (Method method:methods) {
            String name = method.getName();
            try {
                PropertyDescriptor descriptor = new PropertyDescriptor(name, Person.class);
                Method writeMethod = descriptor.getWriteMethod();
                Object invoke = method.invoke(annotation, null);
                writeMethod.invoke(person,invoke);
            } catch (IntrospectionException e) {
                continue;
            }
        }

        PersonDao personDao = new PersonDao();
        setPerson.invoke(personDao,person);
        System.out.println(personDao.getPerson().getName());
        System.out.println(personDao.getPerson().isAge());
    }
}
