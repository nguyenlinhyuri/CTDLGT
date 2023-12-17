package Vebo;

import java.util.*;

class Start implements Comparable<Start> {
    private int id;
    private int cost;

    public Start(int id, int value) {
        this.id = id;
        this.cost = value;
    }

    public int getId() {
        return id;
    }

    public int getValue() {
        return cost;
    }

    @Override
    public int compareTo(Start other) {
        return Integer.compare(this.cost, other.cost);
    }
}

public class Vebo3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Start> starts = new PriorityQueue<>();
        int n = sc.nextInt();

        for (int i = 1; i < n; i++) {
            int k = sc.nextInt();
            if (k == 1) {
                Start temp = new Start(i, sc.nextInt());
                starts.add(temp);
            } else if (k == 2) {
                int v = sc.nextInt();
                while (starts.size() >= v) {
                    starts.poll();
                }
            }
        }

        sc.nextInt();
        if (starts.size() < sc.nextInt()) {
            System.out.println(-1);
        } else {
            long sum = 0;
            List<Integer> id = new ArrayList<>();

            while (!starts.isEmpty()) {
                Start s = starts.poll();
                id.add(s.getId());
                sum += s.getValue();

            }

            Collections.sort(id);
            System.out.println(sum);
            for (Integer temp : id) {
                System.out.print(temp + " ");
            }
        }
    }
}