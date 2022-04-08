package com.company;

import java.util.*;

public class Test {

    public static void main(String[] args) {
        // string
        // today it is raining heavily it

        Map<Integer, List<String>> output = new HashMap<>();

        String input = "today it is raining heavily it";

        for (int index = 0; index < input.length(); index++) {
            for (int position = index + 2; position < input.length(); position++) {
                String search = input.substring(index, position);
                int count = match(input, search);
                List<String> values = output.getOrDefault(count, new ArrayList<>());
                values.add(search);
                output.put(count, values);
            }
        }

        Optional<Map.Entry<Integer, List<String>>> answer =
                output.entrySet().stream().sorted((x, y) -> (y.getKey() - x.getKey())).findFirst();
        if (answer.isPresent()) {
            System.out.println(answer.get().getValue());
        }
    }

    private static int match(String input, String search) {
        int count = 0;
        for (int index = 0; index < input.length() - search.length(); index++) {
            String subString = input.substring(index, index+search.length());
            if (subString.equals(search)) {
                count++;
            }
        }
        return count;
    }
}