package Task4;

//   Создать программу, которая подсчитывает сколько раз употребляется слово в тексте (без учета регистра).
//   Текст и слово вводится вручную.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Task4 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите текст");
        String str = reader.readLine();
        System.out.println("Введите слово");
        String word = reader.readLine();
        reader.close();

        List<String> list = Arrays.asList(str.split(" "));
        int count = 0;
        for (String st: list) if (st.toUpperCase().equals(word.toUpperCase()))count++;
        System.out.println(count);
    }
}
