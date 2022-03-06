package question;

import java.math.BigDecimal;

/**
 * Description:
 *
 * @author wangyang
 * @since 2022/3/6
 */

public class MyAtoi {


    public int myatoi (String s){
        s = s.trim();
        char[] chars = s.trim().toCharArray();
        int i = 0;
        for (; i < chars.length;i++) {

            if(i == 0 && (chars[i] == '-' || chars[i] == '+')){
                continue;
            }
            if (Character.digit(chars[i], 10) == -1){
                break;
            }
        }

        if  (i ==0 || (i==1 &&(chars[0] == '-' || chars[0] == '+'))){
            return 0;
        }

        BigDecimal bigDecimal = new BigDecimal(s.substring(0, i));

        if (bigDecimal.compareTo(new BigDecimal(Integer.MAX_VALUE))>0){
            return  Integer.MAX_VALUE;
        }
        if (bigDecimal.compareTo(new BigDecimal(Integer.MIN_VALUE))<0){
            return  Integer.MIN_VALUE;
        }


        return bigDecimal.intValue();
    }

    public static void main(String[] args) {
        System.out.println(new MyAtoi().myatoi(" -91283472332"));
    }
}
