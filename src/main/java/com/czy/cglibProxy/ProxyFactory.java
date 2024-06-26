package com.czy.cglibProxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * ClassName: ProxyFactory
 * Package: com.czy.cglibProxy
 * Description:
 *
 * @Author Chen Ziyun
 * @Version 1.0
 */
public class ProxyFactory implements MethodInterceptor {
    //维护一个目标对象
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    //为目标对象生成代理对象
    public Object getProxyInstance() {
        //工具类
        Enhancer en = new Enhancer();
        //设置父类
        en.setSuperclass(target.getClass());
        //设置回调函数 setCallback 设置方法拦截器为当前对象（this）
        en.setCallback(this);
        //创建子类对象代理
        return en.create();
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("请问有什么可以帮到您？");
        // 执行目标对象的方法
        Object returnValue = method.invoke(target, args);
        System.out.println("问题已经解决啦！");
        return null;
    }
}
