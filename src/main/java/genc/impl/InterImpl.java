package genc.impl;

import genc.Inter;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 *  子类明确了泛型类的类型参数变量
 */
public class InterImpl implements Inter<String> {
    @Override
    public void show(String s) {
        System.out.println(s);
    }


    public void test(List<?> list){
        for (int i=0; i < list.size();i++){
            System.out.println(list.get(i));
            //不能调用add() (不能调用与对象有关的方法,因为 不知道对象的类型)
//            list.add(list.get(i));
        }
    }
}
