package nio;

import java.nio.Buffer;
import java.nio.ByteBuffer;

/**
 * nio 三个核心部分组成:
 *  buffer 缓冲区
 *    capacity
 *    position
 *    limit
 *    mark
 *  Channel管道
 *  Selector选择器
 */
public class NIOTest {
    public static void main(String[] args){
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        // 看一下初始时4个核心变量的值
        System.out.println("初始时-->limit--->"+byteBuffer.limit());
        System.out.println("初始时-->position--->"+byteBuffer.position());
        System.out.println("初始时-->capacity--->"+byteBuffer.capacity());
        System.out.println("初始时-->mark--->" + byteBuffer.mark());
        System.out.println("-----------------------------------------");
        Buffer flip = byteBuffer.flip();
        // 看一下初始时4个核心变量的值
        System.out.println("初始时-->limit--->"+flip.limit());
        System.out.println("初始时-->position--->"+flip.position());
        System.out.println("初始时-->capacity--->"+flip.capacity());
        System.out.println("初始时-->mark--->" + flip.mark());
        byte[] bytes= new byte[byteBuffer.limit()];
        byteBuffer.get(bytes);
        System.out.println(new String(bytes,0,bytes.length));
    }
}
