/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author
 * @version $Id: Main.java, v 0.1 2019年12月16日 11:21
 */
public class Main {
    static Map<Integer,Boolean> hashMap = new HashMap(200);

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        String string1 = scanner.nextLine();
        change(string + string1);

    }


    private  static  void change(String string){
        for(char cha : string.toCharArray()){
            if(hashMap.get(cha - 0) == null){
                System.out.print(cha);
                hashMap.put(cha - 0 ,true);
            }
        }
    }
}