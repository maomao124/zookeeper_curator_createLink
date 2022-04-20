```java

//重试策略
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(3000, 10);
        //zookeeper创建链接，第一种
        /*
        CuratorFramework client =
                CuratorFrameworkFactory.newClient("127.0.0.1:2181",
                        60 * 1000,
                        15 * 1000,
                        retryPolicy);
        client.start();
        */

        //zookeeper创建链接，第二种
        CuratorFramework client =
                CuratorFrameworkFactory.builder()
                        .connectString("127.0.0.1:2181")
                        .sessionTimeoutMs(60 * 1000)
                        .connectionTimeoutMs(15 * 1000)
                        .retryPolicy(retryPolicy)
                        .namespace("test")
                        .build();
        client.start();

```