package Task5;

// Создать программу, которая в последовательности от 0 до N, находит все числа-палиндромы (зеркальное значение равно оригинальному).
// Длина последовательности N вводится вручную и не должна превышать 100.

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Task5 {
    public static void main(String[] args){
        System.out.println("Введите длину последовательности от 0 до 100");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> numbers = new ArrayList<>();
        List<Integer> resultNumbers = new ArrayList<>();
        int n = 0;
        try {
            n = Integer.parseInt(reader.readLine());
            System.out.println("Введите числа:");
            if (n < 0 || n > 10000) throw new Exception();
            for (int i = 0; i < n; i++) numbers.add(Integer.parseInt(reader.readLine()));
        } catch (Exception e) {
            System.out.println("Неверный ввод");
        }
        for (int number: numbers)if (isPalindrome(number))resultNumbers.add(number);
        System.out.println(resultNumbers);
    }

    private static boolean isPalindrome(int number) {
        List<Integer> digits = new ArrayList<>();
        while (number >= 1){
            int digit = number % 10;
            digits.add(digit);
            number = (number - digit) / 10;
        }
        for (int i = 0; i < digits.size() / 2; i++){
            if (digits.get(i) != digits.get(digits.size()-1 - i)) return false;
        }
        return true;
    }
}
