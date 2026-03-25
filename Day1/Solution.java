package AdventofCode25.Day1;

import AdventofCode25.fileParser;
import java.util.Scanner;

public class Solution {

    private static final String FILEPATH = "AdventofCode25/Day1/input.txt";
    //private static final String FILEPATH = "AdventofCode25/Day1/test.txt";
    public static void main(String[] args) {
        int result1 = solutionOne();
        System.out.println("Solution 1 : " + result1);
        int result2 = solutionTwo();
        System.out.println("Solution 2 : " + result2);
        // System.out.println(performLockRotation(82, -240));
    }

    public static int solutionOne() {
        String fileText = fileParser.parseFile(FILEPATH);
        int newLockPosition = 50;
        int result = 0;
        Scanner scan = new Scanner(fileText);
        while(scan.hasNextLine()) {
            int parsedLockRotation = parseLockRotation(scan.nextLine());
            newLockPosition = performLockRotation(newLockPosition, parsedLockRotation);
            if(newLockPosition == 0) result++;
        }
        scan.close();
        return result;
    }

    public static int solutionTwo() {
        String fileText = fileParser.parseFile(FILEPATH);
        int newLockPosition = 50;
        int result = 0;
        Scanner scan = new Scanner(fileText);
        while(scan.hasNextLine()) {
            int parsedLockRotation = parseLockRotation(scan.nextLine());
            int direction = parsedLockRotation > 0 ? 1 : -1;
            int steps = Math.abs(parsedLockRotation);
            for(int i = 0; i < steps; i++) {
                newLockPosition += direction;
                if(newLockPosition < 0) newLockPosition = 99;
                else if(newLockPosition > 99) newLockPosition = 0;
                
                if(newLockPosition == 0) result++;
            }
        }
        scan.close();
        return result;
    }

    public static int performLockRotation(int lock, int rotation) {
        // If turning the lock would result in it going under 0
        // Else, if turning the lock would result in it going over 99
        // Otherwise, turn without any additional logic
        int result;
        if(rotation > 100 || rotation < -100) rotation = rotation % 100; 
        if(lock + rotation < 0) {
            result = 100 - (-rotation - lock);
        } else if (lock + rotation > 99) {
            result = 0 + (rotation - (100 - lock));
        } else {
            result = lock + rotation;
        }
        return result;
    }

    public static int parseLockRotation(String lockRotation) {
        char lockDirection = lockRotation.charAt(0);
        String[] parsedLockRotation = lockRotation.split("L|R");
        int rotationAmount = Integer.parseInt(parsedLockRotation[1]);
        int result;
        if(lockDirection == 'L') {
            result = -rotationAmount;
        } else {
            result = rotationAmount;
        }
        return result;
    }
}
