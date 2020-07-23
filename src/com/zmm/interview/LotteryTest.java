package com.zmm.interview;

import java.util.*;
import java.util.stream.Collectors;

public class LotteryTest {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User(1,1));
        users.add(new User(2,2));
        users.add(new User(3,3));
        users.add(new User(4,4));
        users.add(new User(5,5));
        users.add(new User(6,6));
        users.add(new User(7,7));
        users.add(new User(8,8));
        int maxWeight = users.stream()
                .mapToInt(User::getWeight)
                .max().getAsInt();
        Map<Integer, Integer> map = new HashMap<>();
        User temp = null;
        int count = 1;
        for(int i = 0; i < 7000; i++){
            temp = lottery(users, maxWeight);
            count = 1;
            if(map.get(temp.getId()) != null){
                count+=map.get(temp.getId());
            }
            map.put(temp.getId(), count);
        }
        map.entrySet().stream().forEach(key -> {
            System.out.println("id:"+ key.getKey() + "_count:"+ key.getValue());
        });
    }

    private static User lottery(List<User> users, int maxWeight){
        User drawn = null;
        Random rd = new Random();
        int random = rd.nextInt(power(maxWeight+1));
        String binary = Integer.toBinaryString(random);
        int drawnWeight = binary.length();
        List<User> us = users.stream().filter(user -> {return user.getWeight() == drawnWeight;})
                .collect(Collectors.toList());
        random = rd.nextInt(us.size());
        drawn = us.get(random);
        return drawn;
    }

    private static int power(int power){
        if(power<=0){
            return 0;
        }
        int result = 1;
        for (int i = 1; i < power; i++){
            result *= 2;
        }
        return result;
    }

    static class User{
        int id, weight;

        public User(int id, int weight) {
            this.id = id;
            this.weight = weight;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }
    }
}
