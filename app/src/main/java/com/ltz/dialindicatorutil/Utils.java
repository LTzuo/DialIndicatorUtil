package com.ltz.dialindicatorutil;

import android.content.Context;
import android.widget.Toast;
import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * Created by 1 on 2017/12/5.
 * 工具类
 */
public class Utils {

    /**
     * 计算球面半径
     * @param mContext
     * @param d0
     * @param dlr
     * @param v1
     * @param r1
     * @param v2
     * @return
     */
    public static String CalculationR2(Context mContext,String d0, String dlr, String v1, String r1, String v2){
        BigDecimal  D0  = new BigDecimal(d0);
        BigDecimal  DLR = new BigDecimal(dlr);
        BigDecimal  V1  = new BigDecimal(v1);
        BigDecimal  R1  = new BigDecimal(r1);
        BigDecimal  V2  = new BigDecimal(v2);
        BigDecimal  a1 = new BigDecimal(0);
        if(DecCalUtil.compareTo(R1,0) == 0){
            a1 = new BigDecimal(0);
        } else{
//            if(R1 + DLR >= Math.abs(D0) / 2){
//                a1 = (R1 + DLR) - Math.sqrt(Math.pow((R1 + DLR) , 2) - Math.pow((D0 / 2) , 2));
//            }else if(R1 + DLR <= -Math.abs(D0) / 2 ){
//                a1 = (R1 + DLR) + Math.sqrt(Math.pow((R1 + DLR) , 2) - Math.pow((D0 / 2) , 2));
//            }else{
//                Toast.makeText(mContext,"R1半径错",Toast.LENGTH_SHORT).show();
//            }
            if(DecCalUtil.add(R1,DLR) >= DecCalUtil.div(D0.abs(),2)){
              //  a1 = (R1 + DLR) - Sqr((R1 + DLR) ^ 2 - (D0 / 2) ^ 2);
              //  DecCalUtil.add(R1,DLR)
              //  Math.pow(DecCalUtil.add(R1,DLR),2) - Math.pow(DecCalUtil.div(D0,2) , 2)
              //  Math.sqrt(DecCalUtil.sub( Math.pow(DecCalUtil.add(R1,DLR),2) , Math.pow(DecCalUtil.div(D0,2) , 2)));
              //  DecCalUtil.sub( DecCalUtil.add(R1,DLR), Math.sqrt(DecCalUtil.sub( Math.pow(DecCalUtil.add(R1,DLR),2) , Math.pow(DecCalUtil.div(D0,2) , 2))));
                a1 = new BigDecimal(Double.toString(DecCalUtil.sub( DecCalUtil.add(R1,DLR), Math.sqrt(DecCalUtil.sub( Math.pow(DecCalUtil.add(R1,DLR),2) ,
                        Math.pow(DecCalUtil.div(D0,2) , 2))))));
            }else if(DecCalUtil.add(R1,DLR) <= -DecCalUtil.div(D0.abs(),2)){
               // R1 + DLR <= -Abs(D0) / 2
               // a1 = (R1 + DLR) + Sqr((R1 + DLR) ^ 2 - (D0 / 2) ^ 2)
               // DecCalUtil.add(R1,DLR)
               // Math.pow(DecCalUtil.add(R1,DLR),2);
               // Math.pow(DecCalUtil.div(D0,2),2);
               // Math.sqrt(DecCalUtil.sub(Math.pow(DecCalUtil.add(R1,DLR),2),Math.pow(DecCalUtil.div(D0,2),2)));
               // DecCalUtil.add(new BigDecimal(Double.toString(DecCalUtil.add(R1,DLR))),new BigDecimal(Double.toString(Math.sqrt(DecCalUtil.sub(Math.pow(DecCalUtil.add(R1,DLR),2),Math.pow(DecCalUtil.div(D0,2),2))))));
                 a1 = new BigDecimal(Double.toString(DecCalUtil.add(new BigDecimal(Double.toString(DecCalUtil.add(R1,DLR))),new BigDecimal(Double.toString(Math.sqrt(DecCalUtil.sub(Math.pow(DecCalUtil.add(R1,DLR),2),Math.pow(DecCalUtil.div(D0,2),2))))))));
            }else{
                Toast.makeText(mContext,"R1半径错",Toast.LENGTH_SHORT).show();
            }
        }
        double  a2;
        double  R2;
       // a2 = V2 - V1 + a1;
       // a2 = new BigDecimal(Double.toString(DecCalUtil.add(new BigDecimal(Double.toString(DecCalUtil.sub(V2,V1))),a1)));
        a2 = DecCalUtil.add(new BigDecimal(Double.toString(DecCalUtil.sub(V2,V1))),a1);
        if(a2 == 0){
            R2 = 0;
        }else{
           // R2 = (a2 ^ 2 + (D0 / 2) ^ 2 - 2 * a2 * DLR) / (2 * a2)
           // R2 = (Math.pow(a2 , 2) + Math.pow((D0 / 2) ,(2 - 2 * a2 * DLR) / (2 * a2))) ;
           // Math.pow(a2,2)
           // Math.pow(DecCalUtil.div(D0,2),2)
           // DecCalUtil.mul(2*a2,DLR)
           R2 = DecCalUtil.div(new BigDecimal(Double.toString( DecCalUtil.sub(DecCalUtil.add(Math.pow(a2,2),Math.pow(DecCalUtil.div(D0,2),2))
                   ,DecCalUtil.mul(2*a2,DLR)))),2*a2);
        }
        DecimalFormat formater = new DecimalFormat();
        //保留几位小数
        formater.setMaximumFractionDigits(4);
        //模式  四舍五入
        //formater.setRoundingMode(RoundingMode.UP);
        return new DecimalFormat("#,##0.0000").format(R2);
    }

    /**
     * 计算千分表读数
     * @param mContext
     * @param d0
     * @param dlr
     * @param v1
     * @param r1
     * @param r2
     */
    public static String CalculationV2(Context mContext,String d0, String dlr, String v1, String r1, String r2){
        BigDecimal  D0  = new BigDecimal(d0);
        BigDecimal  DLR = new BigDecimal(dlr);
        BigDecimal  V1  = new BigDecimal(v1);
        BigDecimal  R1  = new BigDecimal(r1);
        BigDecimal  R2  = new BigDecimal(r2);
        BigDecimal  a1 = new BigDecimal(0);

        if(DecCalUtil.compareTo(R1,0) == 0){
            a1 = new BigDecimal(0);
        } else{
//            If R1 + DLR >= Abs(D0) / 2 Then
//                    a1 = (R1 + DLR) - Sqr((R1 + DLR) ^ 2 - (D0 / 2) ^ 2)
//            Else
//            If R1 + DLR <= -Abs(D0) / 2 Then
//                    a1 = (R1 + DLR) + Sqr((R1 + DLR) ^ 2 - (D0 / 2) ^ 2)
//            Else
//            MsgBox ("R1半径错")
            if(DecCalUtil.add(R1,DLR) >= DecCalUtil.div(D0.abs(),2)){
               // a1 = (R1 + DLR) - Sqr((R1 + DLR) ^ 2 - (D0 / 2) ^ 2)
                //DecCalUtil.add(R1,DLR)
                //Math.pow(DecCalUtil.add(R1,DLR),2)
                //Math.pow(DecCalUtil.div(D0,2),2)
                //Math.sqrt(DecCalUtil.sub(Math.pow(DecCalUtil.add(R1,DLR),2),Math.pow(DecCalUtil.div(D0,2),2)))
               a1 = new BigDecimal(Double.toString( DecCalUtil.sub(DecCalUtil.add(R1,DLR),Math.sqrt(DecCalUtil.sub(Math.pow(DecCalUtil.add(R1,DLR),2),Math.pow(DecCalUtil.div(D0,2),2))))));
            }else if(DecCalUtil.add(R1,DLR) <= -DecCalUtil.div(D0.abs(),2)){
                //a1 = (R1 + DLR) + Sqr((R1 + DLR) ^ 2 - (D0 / 2) ^ 2)
                a1 = new BigDecimal(Double.toString( DecCalUtil.add(DecCalUtil.add(R1,DLR),Math.sqrt(DecCalUtil.sub(Math.pow(DecCalUtil.add(R1,DLR),2),Math.pow(DecCalUtil.div(D0,2),2))))));
            }else{
                Toast.makeText(mContext,"R1半径错",Toast.LENGTH_SHORT).show();
            }
        }
//        if R2 = 0 Then
//                a2 = 0
//        Else
//        If R2 + DLR >= Abs(D0) / 2 Then
//                a2 = (R2 + DLR) - Sqr((R2 + DLR) ^ 2 - (D0 / 2) ^ 2)
//        Else
//        If R2 + DLR <= -Abs(D0) / 2 Then
//                a2 = (R2 + DLR) + Sqr((R2 + DLR) ^ 2 - (D0 / 2) ^ 2)
//        Else
//        MsgBox ("R2半径错")
        double a2 = 0;
        if(DecCalUtil.compareTo(R2,0) == 0){
            a2 = 0;
        }else{
            if(DecCalUtil.add(R2,DLR) >= DecCalUtil.div(D0.abs(),2)){
               // a2 = (R2 + DLR) - Sqr((R2 + DLR) ^ 2 - (D0 / 2) ^ 2)
                a2 =  DecCalUtil.sub(DecCalUtil.add(R2,DLR),Math.sqrt(DecCalUtil.sub(Math.pow(DecCalUtil.add(R2,DLR),2),Math.pow(DecCalUtil.div(D0,2),2))));
            }else if(DecCalUtil.add(R2,DLR) <= -DecCalUtil.div(D0.abs(),2)){
               // a2 = (R2 + DLR) + Sqr((R2 + DLR) ^ 2 - (D0 / 2) ^ 2)
                a2 = DecCalUtil.add(DecCalUtil.add(R2,DLR),Math.sqrt(DecCalUtil.sub(Math.pow(DecCalUtil.add(R2,DLR),2),Math.pow(DecCalUtil.div(D0,2),2))));
            }else{
                Toast.makeText(mContext,"R2半径错",Toast.LENGTH_SHORT).show();
            }

        }
        double V2;
     //   V2 = V1 - a1 + a2
          V2 = DecCalUtil.add(DecCalUtil.add(V1,a1),a2);
        DecimalFormat formater = new DecimalFormat();
        //保留几位小数
        formater.setMaximumFractionDigits(4);
        //模式  四舍五入
        //formater.setRoundingMode(RoundingMode.UP);
        return new DecimalFormat("#,##0.0000").format(V2);
    }

}
