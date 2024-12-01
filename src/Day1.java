import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Day1 {
    
    public static void main(String[] args) {
        System.out.println("Part 1 or 2?");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        if(answer.equals("1")) {
            task1("input\\day1.txt");
        } else if(answer.equals("2")) {
            task2("input\\day1.txt");
        } else {
            System.out.println("Not an option. Try again. Or don't. I'm not your dad. Probably.");
        }
    }
    
    public static void task1(String path) {
        
        ArrayList<ArrayList<Integer>> bothLists = getLines(path);
        ArrayList<Integer> leftList = bothLists.get(0);
        ArrayList<Integer> rightList = bothLists.get(1);
        
        Collections.sort(leftList);
        Collections.sort(rightList);
        
        int distance = 0;
        int total = leftList.size();
        
        for(int i = 0 ; i < total ; i++) {
            distance += Math.abs(leftList.remove(0) - rightList.remove(0));
        }

        System.out.println(distance);
        
    }
    
    public static void task2(String path) {
        ArrayList<ArrayList<Integer>> bothLists = getLines(path);
        ArrayList<Integer> leftList = bothLists.get(0);
        ArrayList<Integer> rightList = bothLists.get(1);

        HashMap<Integer, Integer> map = new HashMap<>();
        
        int totalSimilarity = 0;
        
        for(int i : leftList) {
            if(map.containsKey(i)) {
                totalSimilarity += i * map.get(i);
            } else {
                int value = 0;
                for(int j : rightList) {
                    if(j == i) {
                        value++;
                    }
                }
                map.put(i, value);
                totalSimilarity += (value * i);
            }
        }

        System.out.println(totalSimilarity);
        
    }
    
    public static ArrayList<ArrayList<Integer>> getLines(String path) {
        
        ArrayList<Integer> leftList = new ArrayList<>();
        ArrayList<Integer> rightList = new ArrayList<>();
        
        ArrayList<String> bothLists = FileReader.readFile(path);
        for(String line : bothLists) {
            String[] linee = line.split("   ");
            rightList.add(Integer.parseInt(linee[1]));
            leftList.add(Integer.parseInt(linee[0]));
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        result.add(leftList);
        result.add(rightList);
        return result;
    }
    
}
