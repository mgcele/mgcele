package com.mgcele.framework.utils;

import java.util.Random;

/**
 * @author mgcele on 2017/4/28.
 */
public class RandomUtil {

    public static int randomInt(int len)
    {
        int min = 1;
        for (int i = 1; i < len; i++) {
            min *= 10;
        }
        int max = min * 10 - 1;
        return randomInt(min, max);
    }

    public static int randomInt(int min, int max)
    {
        Random rand = new Random();
        Integer temp = rand.nextInt();
        if(temp.equals(Integer.MIN_VALUE)){
            temp += 1;
        }
        int tmp = Math.abs(temp);
        return tmp % (max - min + 1) + min;
    }

}
