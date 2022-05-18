package algorithm.lightState;

import java.util.StringJoiner;

public class BreakerManager {

    public int failureCount; //失败次数

    public long  timeout;


    public BreakerManager(int failureCount){

    }


    public static void main(String[] args) {
        /*if(("*号税后扣款(我司收费)").contains("*")){
            System.out.println("1");
        }*/
        StringJoiner stringJoiner = new StringJoiner("2");

       String str= "*个税申报地";
       System.out.println(str.trim());
    }

}
