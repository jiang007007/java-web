package sync;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BadListHelper<E> {
    public List<E> list = Collections.synchronizedList(new ArrayList<>());
//    public synchronized boolean putIfAbsent(E e){
//        /**
//         * 不能这样做,因为list用的锁(contains方法)不是BadListHelper内置锁
//         */
//        boolean absent =!list.contains(e);
//        if (absent){
//            list.add(e);
//        }
//        return absent;
//    }

    //改进 锁住list 但是子类的行为与父类的实现耦合在一起了
    public boolean putIfAbsent(E e){
            synchronized (list){
                boolean absent = !list.contains(e);
                if (absent)
                    list.add(e);
                return absent;
            }
    }

}
