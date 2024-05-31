package com.czy.jdkProxy;

/**
 * ClassName: Client
 * Package: com.czy
 * Description:
 *
 * @Author Chen Ziyun
 * @Version 1.0
 */
public class Client {
    public static void main(String[] args) {
        //目标对象:程序员
        ISolver developer = new Solver();
        //代理：客服小姐姐
        ISolver csProxy = (ISolver) new ProxyFactory(developer).getProxyInstance();
        //目标方法：解决问题
        csProxy.solve();
    }
}
