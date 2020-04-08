package genc.impl;

import genc.Inter;

/**
 * 子类 不能明确泛型类的类型参数变量:
 *    实现类也要定义出<T>类型的
 * @param <T>
 */
public class InterImpl2<T> implements Inter<T> {
    @Override
    public void show(T t) {
        System.out.println(t);
    }
}
