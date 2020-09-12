package dynamicProxy;

/**
 * @description: 需要代理的实际对象
 * @author: xuefei
 * @date: 2020/07/24 15:14
 */
public class RealSubject implements Subject {

    /**
     * 你好
     *
     * @param name
     * @return
     */
    public String SayHello(String name) {
        return "hello " + name;
    }

    /**
     * 再见
     *
     * @return
     */
    public String SayGoodBye() {
        return " good bye ";
    }
}
