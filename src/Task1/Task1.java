package Task1;

//Создать программу, которая будет сообщать, является ли целое число, введенное пользователем,
// чётным или нечётным, простым или составным.  Если пользователь введёт не целое число, то сообщать ему об ошибке.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task1 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number;
        String str = reader.readLine();
        reader.close();
        try {
            number = Integer.parseInt(str);
            //if (number < 0) throw new NumberFormatException();
            isOddNumber(number);
            isPrimeNumber(number);
        } catch (NumberFormatException e) {
            System.out.println("Введенные данные не являются целым числом");

        }


    }

    private static void isPrimeNumber(int number) {
        int sqrtNumber = (int) Math.sqrt(number) + 1;
        boolean isPrime = true;
        for (int i  = 2; i <= sqrtNumber; i ++){
            if (number % i == 0){
                isPrime = false;
                break;
            }
        }
        if (isPrime) System.out.println("Число " + number + " простым");
        else System.out.println("Число " + number + " является составным");
    }

    private static void isOddNumber(int number) {
        if ((number % 2) == 1)
            System.out.println("Число " + number + " является нечетным");
        else System.out.println(String.format("Число %d является четным", number));

    }
}

