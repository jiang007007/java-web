package annotation.impl;

import annotation.InjectPerson;

/**
 * 通过注解 通过set方法注入值
 */
public class PersonDao {
    private Person person;

    public Person getPerson() {
        return person;
    }

    @InjectPerson(name = "李四",age = 15)
    public void setPerson(Person person) {
        this.person = person;
    }
}
