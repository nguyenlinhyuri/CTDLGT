package Week9_Tree;

import java.util.*;

public class JavaHashSet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        HashSet <String> myhash = new HashSet <String>();
        for (int i=0; i<n; i++){
            String in = sc.nextLine();
            myhash.add(in);
            System.out.println(myhash.size());
        }
    }
}