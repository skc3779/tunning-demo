package org.kangchun.jmh;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;

/**
 * Created by seokangchun on 2014. 7. 31..
 */
public class RandomKeyUtil {

    public static String[] generateReandomSetKeySwap(Set<String> set) {

        final int size = set.size();
        Random random = new Random();
        int maxNumber = size;
        Iterator<String> interator = set.iterator();
        int resultPos = 0;
        String result[] = new String[size];

        while(interator.hasNext()) {
            result[resultPos++] = interator.next();
        }

        for(int loop=0; loop < size; loop++) {
            int randomNumber1 = random.nextInt(maxNumber);
            int randomNumber2 = random.nextInt(maxNumber);

            String temp = result[randomNumber2];
            result[randomNumber2] = result[randomNumber1];
            result[randomNumber1] = temp;
        }

        return result;
    }
}
