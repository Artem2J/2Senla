package Task3;

//   Создать программу, которая будет:
//    • подсчитывать количество слов в предложении
//    • выводить их в отсортированном виде
//    • делать первую букву каждого слова заглавной.
//   Предложение вводится вручную. (Разделитель пробел (“ ”)).

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task3 {
    public static void main(String[] args) throws IOException {
        System.out.println("Введите предложение");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] str = reader.readLine().split(" ");
        reader.close();

        System.out.println("Количество слов в предложении: " + str.length );

        List<String> stringList = new ArrayList<>();
        for (String string: str){
            stringList.add(string.substring(0, 1).toUpperCase() + string.substring(1));
        }

        Collections.sort(stringList);

        for (String sortedStr: stringList)System.out.println(sortedStr);
    }
}
