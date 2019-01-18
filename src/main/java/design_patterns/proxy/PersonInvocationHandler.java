package design_patterns.proxy;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName PersonInvocationHandler
 * @Author dianXiao2
 * @Date 2018/12/17 21:07
 **/
public class PersonInvocationHandler<T> implements InvocationHandler {

    T target;

    public PersonInvocationHandler(T target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(">> 代理运行 " + method.getName()+ "方法");
        System.out.println(">> args:"+JSON.toJSONString(args));
        System.out.println(">> proxy:"+JSON.toJSONString(proxy));
        Object res = method.invoke(target, args);
        System.out.println(">> 代理运行结束");
        return res;
    }

    public static void main(String[] args) {

        //创建一个实例对象，这个对象是被代理的对象
        IPerson goodPerson = new GoodPerson();
        //创建一个与代理对象关联的invocationHandler
        PersonInvocationHandler<IPerson> handler = new PersonInvocationHandler<IPerson>(goodPerson);
        //穿件一个代理类，每次执行目标类的是方法的时候，都会调用InvocationHandler的invoke方法
        IPerson personProxy = (IPerson) Proxy.newProxyInstance(IPerson.class.getClassLoader(), new Class<?>[]{IPerson.class},handler);

        personProxy.hello("caoyulong");
    }
}
