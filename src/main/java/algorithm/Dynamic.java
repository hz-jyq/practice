/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package algorithm;

import java.util.Scanner;

public class Dynamic {

    public static void main(String[] args) {
/* 5
7
3   8
8   1   0
2   7   4   4
4   5   2   6   5*/

        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        Integer[][] integers = new Integer[count][count],resultIntegers = new Integer[count][count];
        scanner.nextLine();
        for (int i = 0; i < count; i++) {
            String line = scanner.nextLine();
            String[] arg1 = line.split("  ");
            for (int j = 0; j < arg1.length; j++) {
                Integer integer = Integer.parseInt(arg1[j].trim());
                integers[i][j] = integer;
            }
        }

        for (int i = count-1; i >= 0; i--) {
            for (int j =0; j <= i; j++) {
                if(i == count - 1){
                    resultIntegers[i][j] =   integers[i][j];
                }else{
                    resultIntegers[i][j] =  +  integers[i][j] + max(resultIntegers[i+1][j],resultIntegers[i+1][j+1]) ;
                }
            }
        }

        System.out.print(resultIntegers[0][0]);
    }

    private static Integer max(Integer left, Integer right) {
        return right == null ||  left > right   ? left : right;
    }
}