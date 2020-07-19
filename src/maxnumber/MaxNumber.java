package maxnumber;

import java.util.Scanner;

/**
 * 长度n除以段数m  n%m余数分给每段1余数用完为止  即结果每段长度

 * 减余数求平局 余数分给每段1余数用完为止
 */
public class MaxNumber {
    public static void main(String[] args) {
        while (true){
            double maxValue = 0;
            System.out.println("请输入绳子总长度:");
            int totalValue = new Scanner(System.in).nextInt();
            if(totalValue%3==0){
                maxValue =  Math.pow(3,totalValue/3);  // pow(x,y):x的y次方
                System.out.println("最大乘积为:"+maxValue+",绳子分了"+totalValue/3+"段.");
            }else if(totalValue%3==1){
                maxValue =  (Math.pow(3,totalValue/3-1))*(totalValue%3+3);
                System.out.println("最大乘积为:"+maxValue+",绳子分了"+(totalValue/3+1)+"段.");
            }else if(totalValue%3==2){
                maxValue =  (Math.pow(3,totalValue/3))*2;
                System.out.println("最大乘积为:"+maxValue+",绳子分了"+(totalValue/3+1)+"段.");
            }
        }
    }
}
