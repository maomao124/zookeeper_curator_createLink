import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * Project name(项目名称)：zookeeper_curator创建链接
 * Package(包名): PACKAGE_NAME
 * Class(类名): test
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/4/20
 * Time(创建时间)： 20:32
 * Version(版本): 1.0
 * Description(描述)： 建立链接
 */

public class test
{
    public static void main(String[] args) throws Exception
    {
        //重试策略
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(3000, 10);
        //第一种
        /*CuratorFramework client =
                CuratorFrameworkFactory.newClient("127.0.0.1:2181",
                        60 * 1000,
                        15 * 1000,
                        retryPolicy);
        client.start();*/

        //第二种
        CuratorFramework client =
                CuratorFrameworkFactory.builder()
                        .connectString("127.0.0.1:2181")
                        .sessionTimeoutMs(60 * 1000)
                        .connectionTimeoutMs(15 * 1000)
                        .retryPolicy(retryPolicy)
                        .namespace("test")
                        .build();
        client.start();

        String s = client.create().forPath("/app2");
        System.out.println(s);
    }
}
