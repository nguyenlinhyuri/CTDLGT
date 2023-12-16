package Week9_Tree;

import java.util.*;

public class JavaMap {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Map<String, String> map = new HashMap<>();

        while (n-- > 0) {
            String name = sc.nextLine();
            String phoneNumber = sc.next();
            sc.nextLine();
            map.put(name, phoneNumber);
        }

        while (sc.hasNext()) {
            String input = sc.nextLine();
            if (!map.containsKey(input)) {
                System.out.println("Not found");
            } else {
                System.out.println(input + "=" + map.get(input));
            }
        }
    }
}
