package dynamicProxy;

/**
 * @description: 需要动态代理的接口
 * @author: xuefei
 * @date: 2020/07/24 15:14
 */
public interface Subject {
    /**
     * 你好
     *
     * @param name
     * @return
     */
    public String SayHello(String name);

    /**
     * 再见
     *
     * @return
     */
    public String SayGoodBye();
}
