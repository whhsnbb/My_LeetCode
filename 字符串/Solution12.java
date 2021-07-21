package 字符串;
//给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
//
//示例 1:
//
//输入: 3
//输出: "III"
//示例 2:
//
//输入: 4
//输出: "IV"
//示例 3:
//
//输入: 9
//输出: "IX"
//示例 4:
//
//输入: 58
//输出: "LVIII"
//解释: L = 50, V = 5, III = 3.
//示例 5:
//
//输入: 1994
//输出: "MCMXCIV"
//解释: M = 1000, CM = 900, XC = 90, IV = 4.
public class Solution12 {
    public String intToRoman(int num) {
        // 把阿拉伯数字与罗马数字可能出现的所有情况和对应关系，放在两个数组中，并且按照阿拉伯数字的大小降序排列
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder stringBuilder = new StringBuilder();
        int index = 0;
        while (index < 13) {
            // 特别注意：这里是等号
            while (num >= nums[index]) {
                stringBuilder.append(romans[index]);
                num -= nums[index];
            }
            index++;
        }
        return stringBuilder.toString();
    }

    //我的解法
    
    //    public String intToRoman(int num) {
    //        switch(num){
    //            case 0:
    //                return "";
    //            case 1:
    //                return "I";
    //            case 4:
    //                return "IV";
    //            case 5:
    //                return "V";
    //            case 9:
    //                return "IX";
    //            case 10:
    //                return "X";
    //            case 40:
    //                return "XL";
    //            case 50:
    //                return "L";
    //            case 90:
    //                return "XC";
    //            case 100:
    //                return "C";
    //            case 400:
    //                return "CD";
    //            case 500:
    //                return "D";
    //            case 900:
    //                return "CM";
    //            default:
    //                StringBuilder sb = new StringBuilder();
    //                if(num >= 1000){
    //                    for(int i = 1 ; i <= num/1000 ; i++){
    //                        sb.append("M");
    //                        num -= 1000;
    //                    }
    //                    return sb.append(intToRoman(num)).toString();
    //                }else if(num > 900 && num < 1000){
    //                    sb.append("CM");
    //                    num -= 900;
    //                    return sb.append(intToRoman(num)).toString();
    //                }else if(num > 500 && num < 900){
    //                    sb.append("D");
    //                    num -= 500;
    //                    return sb.append(intToRoman(num)).toString();
    //                }else if(num > 400 && num < 500){
    //                    sb.append("CD");
    //                    num -= 400;
    //                    return sb.append(intToRoman(num)).toString();
    //                }else if(num > 100 && num < 400){
    //                    sb.append("C");
    //                    num -= 100;
    //                    return sb.append(intToRoman(num)).toString();
    //                }else if(num > 90 && num < 100){
    //                    sb.append("XC");
    //                    num -= 90;
    //                    return sb.append(intToRoman(num)).toString();
    //                }else if(num > 50 && num <90){
    //                    sb.append("L");
    //                    num -= 50;
    //                    return sb.append(intToRoman(num)).toString();
    //                }else if(num > 40 && num < 50){
    //                    sb.append("XL");
    //                    num -= 40;
    //                    return sb.append(intToRoman(num)).toString();
    //                }else if(num > 10 && num < 40){
    //                    sb.append("X");
    //                    num -= 10;
    //                    return sb.append(intToRoman(num)).toString();
    //                }else if(num > 5 && num < 9){
    //                    sb.append("V");
    //                    num -= 5;
    //                    return sb.append(intToRoman(num)).toString();
    //                }else if(num < 4){
    //                    sb.append("I");
    //                    num -= 1;
    //                    return sb.append(intToRoman(num)).toString();
    //                }
    //        }
    //        return null;
    //    }
}
