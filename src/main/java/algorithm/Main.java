/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package algorithm;



import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.security.Key;
import java.util.*;
import java.util.concurrent.Callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;

/**
 *
 * @author
 * @version $Id: Main.java, v 0.1 2019年12月16日 11:21
 */
public class Main {

    public static void main(String[] args){



      /*  List<Integer> arrayList = new ArrayList();
        for(int i= 0;i <=100;i++){
            arrayList.add(i);
        }
        List<FutureTask<String>> list = new ArrayList<>();
        for(Integer string : arrayList) {

            list.add(new FutureTask<>(new SyncTask(string)));
        }
       // System.out.println(list.get(0).get(10, TimeUnit.SECONDS));
        for(FutureTask<String> stringFutureTask : list){
            System.out.println(stringFutureTask.get(10, TimeUnit.SECONDS));
        }*/
       /* List<User> list = new ArrayList();
        List<User> list1 = new ArrayList();
        User user = new User();
        user.setName("22");
        list.add(user);
        System.out.println(list.get(0).getName());
        user.setName("3");
        list1.add(user);
        System.out.println(list.get(0).getName());*/




       /* Map<String,Integer> rosterMap = new HashMap();
        rosterMap.put(412723199606205126L + "" + 0L,0);
        Integer integer= rosterMap.get(412723199606205126L + "" + 0L);
        if(integer != null){
            System.out.println(1);
        }*/

     /*   DateTime dateTime =   DateUtil.offsetMonth(DateUtil.parse("2022-01-01", DatePattern.NORM_DATE_PATTERN), -1);
        System.out.println(dateTime);*/
           /* List<Integer> list = Lists.newArrayList(1,2,3);
            list.stream().forEach(System.out :: println);*/



        /*if(!true && true){
            System.out.println("1111");
        }


        List<String> list =generateParenthesis(5);
      *//*  System.out.println(list.size());
        list.forEach(System.out::println);*//*
        List<String> list1 = Hello.append(5, new ArrayList<>());
        for(String str : list){
           if(!list1.contains(str)){
               System.out.println(str);
           }
        }*/


    }

    /*// 做减法

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        // 特判
        if (n == 0) {
            return res;
        }

        // 执行深度优先遍历，搜索可能的结果
        dfs("", n, n, res);
        return res;


     */

    /*static class SyncTask implements Callable<String> {

      public    Integer number;

      public SyncTask(Integer number){
          this.number = number;
      }

        @Override
        public String call() throws Exception {
            try {

            }catch (Exception e){
                return e.getMessage();
            }finally {

            }
            return null;
        }
    }*/

}
