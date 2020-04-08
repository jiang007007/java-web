package xianliu;

import com.google.common.util.concurrent.RateLimiter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/***
 * 分布式限流Redis + Lua的方式
 * local key="rate.limit:"    限流key
 * local limit=tonumber(ARGV[1]) 限流大小
 * local current= tonumber(redis.call('get',key)or "0")
 * if current +1 > limit then  如果超出限流大小
 *     return 0
 *   else  请求书+1  并设置1秒过去
 *    redis.call("INCRBY",key,"1")
 *    reais.call("expire",key,"1")
 *    return current+1
 *    end
 */
public class XianLiu {
    public static void main(String[] args){
        //线程池
        ExecutorService exec = Executors.newCachedThreadPool();
        //单机限流
        final RateLimiter rateLimiter = RateLimiter.create(3.0);
        for (int i=0; i< 100;i++){
            final int no = i;
            Runnable runnable = () -> {
                try {
                    //获取许可
                    rateLimiter.acquire();
                    System.out.println("Accessing: " + no + ",time:"
                            + new SimpleDateFormat("yy-MM-dd HH:mm:ss").format(new Date()));

                } catch (Exception e) {
                    e.printStackTrace();
                }
            };
            exec.execute(runnable);
        }

        exec.shutdown();
    }
}
