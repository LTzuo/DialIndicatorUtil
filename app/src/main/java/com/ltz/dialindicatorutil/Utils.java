package com.ltz.dialindicatorutil;

import android.content.Context;
import android.widget.Toast;


/**
 * Created by 1 on 2017/12/5.
 * 工具类
 */
public class Utils {

    public static String CalculationR2(Context mContext,double D0, double DLR, double V1, double R1, double V2){
        double  a1;
        double  a2;
        if( R1 == 0){
            a1 = 0;
        } else{
            if(R1 + DLR >= Math.abs(D0) / 2){
                a1 = (R1 + DLR) - Sqr((R1 + DLR) ^ 2 - (D0 / 2) ^ 2);
            }else if(R1 + DLR <= -Math.abs(D0) / 2 ){
                a1 = (R1 + DLR) + Sqr((R1 + DLR) ^ 2 - (D0 / 2) ^ 2);
            }else{
                Toast.makeText(mContext,"R1半径错",Toast.LENGTH_SHORT).show();
            }
        }
//        a2 = V2 - V1 + a1
//        If a2 = 0 Then
//                R2 = 0
//        Else
//                R2 = (a2 ^ 2 + (D0 / 2) ^ 2 - 2 * a2 * DLR) / (2 * a2)

    }

    /**
     * public int indexOf(int ch, int fromIndex)
     * 返回在此字符串中第一次出现指定字符处的索引，从指定的索引开始搜索
     *
     * @param srcText
     * @param findText
     * @return
     */
    public static int appearNumber(String srcText, String findText) {
        int count = 0;
        int index = 0;
        while ((index = srcText.indexOf(findText, index)) != -1) {
            index = index + findText.length();
            count++;
        }
        return count;
    }
}
