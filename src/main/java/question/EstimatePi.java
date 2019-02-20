package question;

import java.util.Random;
import java.util.stream.Collectors;

/**
 * Description: TODO
 *
 * @author wangyang
 * @since 2019/2/1
 */

public class EstimatePi {

    public static void main(String[] args) {
        final int times = 10000000;
        int inCircle = 0;
        for (int i = 1; i<=times; i++){
            double x = Math.random();
            double y = Math.random();
            if (x*x + y*y <= 1) inCircle++;
        }
        System.out.println(inCircle*4.0/times);
    }
}
