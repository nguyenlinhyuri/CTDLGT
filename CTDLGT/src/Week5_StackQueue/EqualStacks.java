package Week5_StackQueue;

import java.util.Scanner;

public class EqualStacks {
    public static int[] a1 = new int[100005];
    public static int[] a2 = new int[100005];
    public static int[] a3 = new int[100005];

    public static void solve(){
        int n1, n2, n3, h, sum1 = 0, sum2 = 0, sum3 = 0, d1, d2, d3;
        Scanner sc = new Scanner(System.in);
        n1 = sc.nextInt();
        n2 = sc.nextInt();
        n3 = sc.nextInt();

        for (int i=0; i<n1; i++){
            a1[i] = sc.nextInt();
            sum1 += a1[i];
        } d1 = 0;

        for (int i=0; i<n2; i++){
            a2[i] = sc.nextInt();
            sum2 += a2[i];
        } d2 = 0;

        for( int i=0; i<n3; i++){
            a3[i] = sc.nextInt();
            sum3 += a3[i];
        }
        d3 = 0;

        while (true){
            if(d1 == n1 || d2 == n2 || d3 == n3) {
                h = 0;
                break;
            }

            if(sum1 == sum2 && sum2 == sum3) {
                h = sum1;
                break;
            }

            // If height op pile one is highest
            if(sum1 >= sum2 && sum1 >= sum3) {
                sum1 -= a1[d1];
                d1++;
            }
            // If height op pile two is highest
            else if(sum2 >= sum1 && sum2>=sum3) {
                sum2 -= a2[d2];
                d2++;
            }
            // If height op pile three is highest
            else if(sum3 >= sum2 && sum3 >= sum1) {
                sum3 -= a3[d3];
                d3++;
            }
        }
        System.out.println(h);
    }
    public static void main(String[] args) {
        solve();
    }
}
