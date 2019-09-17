package Task6;

//Имеется набор вещей, которые необходимо поместить в рюкзак. Рюкзак обладает заданной грузоподъемностью.
// Вещи в свою очередь обладают двумя параметрами — весом и стоимостью.
// Цель задачи заполнить рюкзак не превысив его грузоподъемность и максимизировать суммарную ценность груза.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Task6 {
    public static void main(String[] args) throws IOException {
        System.out.println("Введите параметры вещей, вес и стоимость через пробел. \n " +
                "сстой ввод заканчивает ввод данных");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Things> things = new ArrayList<>();
        String str;
        while (!(str = reader.readLine()).equals("")){
            int weight = Integer.parseInt(str.split(" ")[0]);
            int cost = Integer.parseInt(str.split(" ")[1]);

            things.add(new Things(weight, cost));
        }
        System.out.println("Введите объем рюкзака");
        int backpack = Integer.parseInt(reader.readLine());
        int backpackWeight = 0;
        List<Things> backpackList = new ArrayList<>();
        while (backpackWeight < backpack && things.size() > 0){
            Things thing = getMaxPriceThing(things);
            if ((backpackWeight + thing.getWeight()) <= backpack){
                backpackList.add(thing);
                backpackWeight += thing.getWeight();
            }
        }
        System.out.println(backpackList);
    }

    private static Things getMaxPriceThing(List<Things> things) {
        Things maxPriceThing = things.get(0);

        for (Things th: things){
            if (th.getPrice() > maxPriceThing.getPrice())maxPriceThing = th;
            else if (th.getPrice() == maxPriceThing.getPrice() && th.getWeight() > maxPriceThing.getWeight())maxPriceThing = th;

        }
        Things buff = maxPriceThing;
        things.remove(maxPriceThing);
        return buff;
    }

    static class Things{

        private int weight;
        private int cost;
        private float price;

        public Things(int weight, int cost) {
            this.weight = weight;
            this.cost = cost;
            this.price = (float)cost / weight;
        }

        public int getWeight() {
            return weight;
        }

        public int getCost() {
            return cost;
        }

        public float getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return weight + " " + cost;
        }
    }
}
