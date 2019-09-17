package Task2;

// Создать программу, которая будет вычислять и выводить на экран НОК (наименьшее общее кратное) и НОД (наибольший общий делитель)
// двух целых чисел, введенных пользователем.
// Если пользователь некорректно введёт хотя бы одно из чисел, то сообщать об ошибке.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Task2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number1 = 0;
        int number2 = 0;
        System.out.println("Введите два целых положительных числа через пробел");
        String str = reader.readLine();
        reader.close();
        try {
            number1 = Integer.parseInt(str.split(" ")[0]);
            number2 = Integer.parseInt(str.split(" ")[1]);
            if (number1 < 0 || number2 < 0) throw new NumberFormatException();

        } catch (NumberFormatException e) {
            System.out.println("Введенные данные не являются целыми положительнми числами");
        }

        List<Integer> number1mp = findMPNumbers(number1);
        List<Integer> number2mp  = findMPNumbers(number2);

        calculateNOK(number1mp, number2mp);
        calculateNOD(number1mp, number2mp);

    }

    private static void calculateNOD(List<Integer> number1mp, List<Integer> number2mp) {
        int result = 1;
        List<Integer> buffList = new ArrayList<>();
        buffList.addAll(number2mp);
        for(Integer num: number1mp){
                if (buffList.contains(num)){
                    result *= num;
                    int index = buffList.indexOf(num);
                    buffList.remove(index);
                }
        }
        if (result != 1)System.out.println("НОД: " + result);
        else System.out.println("Нет наименьшего общего делителя");
    }


    private static void calculateNOK(List<Integer> number1mp, List<Integer> number2mp) {
        int result = 1;
        List<Integer> buffList = new ArrayList<>();
        buffList.addAll(number2mp);
        for(Integer num: buffList) result *= num;
        for (Integer num: number1mp){
            if (buffList.contains(num)){
                int index = buffList.indexOf(num);
                buffList.remove(index);
            }else result *= num;
        }
        System.out.println("НОK: " + result);
    }

    static List<Integer> findMPNumbers(int number){
        List<Integer> list = new ArrayList<>();
        findNumber(list, number);
        return list;
    }

    static void  findNumber(List<Integer> lst, int number){
        int count = 2;
        while (count <= number){
            if (number % count == 0){
                number /= count;
                lst.add(count);
                findNumber(lst, number);
                break;
            }
            count ++;
        }


    }


}
