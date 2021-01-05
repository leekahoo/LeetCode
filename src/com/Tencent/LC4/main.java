package com.Tencent.LC4;

import org.jetbrains.annotations.NotNull;

class Solution {
    public int myAtoi(String s) {
        if(s==null)
            return 0;
        boolean noempty = false;
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 32 && noempty == false)
                continue;
            else if (s.charAt(i) == 45 ||s.charAt(i)==43 && noempty == false){
                result += s.charAt(i);
                noempty=true;
            }
            else if (s.charAt(i) > 57 || s.charAt(i) < 48) {
                if (noempty)
                    break;
                else
                    return 0;
            }
            else {
                result+=s.charAt(i);
                noempty=true;
                try{
                    Integer.parseInt(result);
                }catch (NumberFormatException e){
                    if(result.charAt(0)=='-')
                        return 0x80000000;
                    else
                        return 0x7fffffff;
                }
            }
        }
        if(result==null)
            return 0;
        try{
           return Integer.parseInt(result);
        }catch (NumberFormatException e){
            return 0;
        }
    }

    public static void main(String[] args) {
        Solution a=new Solution();
        System.out.println(a.myAtoi("+-12"));
    }
}
