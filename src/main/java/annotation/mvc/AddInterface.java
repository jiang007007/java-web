package annotation.mvc;

import annotation.impl.Person;
import annotation.permission;

import java.util.List;

public interface AddInterface {
    @permission("添加分类")
    void addCategory(Person person);

    void  findCategory(String id);

    @permission("查找分类")
    List<Person> getAllCategory();
}
