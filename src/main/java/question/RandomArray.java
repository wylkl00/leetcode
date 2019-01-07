package question;

import java.util.Arrays;
import java.util.Random;

/**
 * Description: 生成一个随机数组 用于验证
 *
 * @author wangyang
 * @since 2018/11/21
 */

public class RandomArray {

    public int[] array;
    private boolean sorted = false;

    public RandomArray(int length){
        this.array = new int[length];
        Random random = new Random();
        for(int i = 0; i < length; i++){
            array[i] = random.nextInt();
        }
    }

    public RandomArray(int length , int Max){
        this.array = new int[length];
        Random random = new Random();
        for(int i = 0; i < length; i++){
            array[i] = random.nextInt(Max);
        }
    }

    public int[] getArray() {
        return array;
    }

    public RandomArray sort() {
        if (!this.sorted){
            Arrays.sort(array);
            this.sorted = true;
        }

        return this;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("[");
        for(int i = 0; i < array.length; i++){
            sb.append(i).append(":").append(array[i]);
            sb.append(",  ");
        }
        sb.trimToSize();
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {

        System.out.println(new RandomArray(100,1000).sort());
        System.out.println(new RandomArray(150,500).sort());
    }
}
