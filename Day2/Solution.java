package AdventofCode25.Day2;

import AdventofCode25.fileParser;

public class Solution {

    public final static String FILEPATH = "AdventofCode25/Day2/input.txt";
    
    public static void main(String[] args) {
        long solutionOne = solutionOne();
        System.out.println("Solution One : " + solutionOne);
        long solutionTwo = solutionTwo();
        System.out.println("Solution Two : " + solutionTwo);
    }

    public static long solutionOne() {
        String fileText = fileParser.parseFile(FILEPATH);
        String[] idRanges = fileText.split(",");
        long result = 0;
        for(int i = 0; i < idRanges.length; ++i) {
            String[] parts = idRanges[i].split("-");
            long start = Long.parseLong(parts[0]);
            long end = Long.parseLong(parts[1]);
            for(long currentNum = start; currentNum <= end; ++currentNum) {
                String sNum = String.valueOf(currentNum);
                if(sNum.length() % 2 != 0) continue;
                int half = sNum.length() / 2;
                boolean isPattern = true;

                for(int j = 0; j < half; ++j) {
                    if(sNum.charAt(j) != sNum.charAt(j + half)) {
                        isPattern = false;
                        break;
                    }
                }
                if(isPattern == true) result += currentNum;
            }
        }
        return result;
    }

    public static long solutionTwo() {
        String fileText = fileParser.parseFile(FILEPATH);
        String[] idRanges = fileText.split(",");
        long result = 0;
        for(String id : idRanges) {
            String[] parts = id.split("-");
            long start = Long.parseLong(parts[0]);
            long end = Long.parseLong(parts[1]);
            for(long currentNum = start; currentNum <= end; ++currentNum) {
                String sNum = String.valueOf(currentNum);
                String compareNum = sNum + sNum;
                if(compareNum.substring(1, compareNum.length() - 1).contains(sNum)) {
                    result += Long.parseLong(sNum);
                }
                // // If sNum is an odd number, all chars need to be the same
                // boolean isPattern = true;
                // if(sNum.length() % 2 != 0) {
                //     char firstChar = sNum.charAt(0);
                //     for(int i = 1; i < sNum.length(); ++i) {
                //         if(sNum.charAt(i) != firstChar) {
                //             isPattern = false;
                //             break;
                //         }
                //     }
                // } else {
                //     int half = sNum.length() / 2;
                //     for(int i = 0; i < half; ++i) {
                //         if(sNum.charAt(i) != sNum.charAt(i + half)) {
                //             isPattern = false;
                //             break;
                //         }
                //     }
                // }
                // if(isPattern == true) result += currentNum;
            }
        }
        return result;
    }
}
