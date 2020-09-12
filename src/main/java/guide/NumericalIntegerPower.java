package guide;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.math.BigDecimal;

/**
 * @description: 数值的整数次方（二分幂）
 *              给定一个 double 类型的浮点数 base 和 int 类型的整数 exponent，求 base 的 exponent 次方
 * @author: xuefei
 * @date: 2020/07/22 10:50
 */
public class NumericalIntegerPower {

    boolean invalidInput = false;

    public static void main(String[] args) {


    }

    public double power(double base, int exponent){
        // 如果底数等于 0 ，并且指数小于0
        // 由于 base 为double类型，不能直接用 == 判断
        if(equal(base,0.0) && exponent < 0){
            invalidInput = true;
            return 0.0;
        }
        int absexponent = exponent;
        // 如果指数小于 0 ，将指数转正
        if(exponent < 0){
            absexponent = -exponent;
        }
        // getPower 方法求出base的exponent次方
        double res = getPower(base,absexponent);
        // 如果指数小于0，所得结果为上面求的结果的倒数
        if(exponent < 0){
            res = 1.0 / res;
        }
        return res;

    }

    // 求出 b 的 e次方的方法
    private double getPower(double base, int e) {
        // 如果指数为 0，返回 1
        if(e == 0){
            return 1.0;
        }
        // 如果指数为1，返回b
        if (e == 1){
            return base;
        }
        // e >> 1 相当于 e/2 ，这里就是求a^n =（a^n/2）*（a^n/2）
        double result = getPower(base, e);
        result *= result;
        // 如果指数n为奇数，则要再乘一次底数base
        if((e & 1) == 1){
            result*=base;
        }
        return result;

    }

    private boolean equal(double num1, double num2) {
        if(num1 - num2 > -0.00001 && num1 - num2 < 0.00001){
            return true;
        }else {
            return false;
        }
    }
}
