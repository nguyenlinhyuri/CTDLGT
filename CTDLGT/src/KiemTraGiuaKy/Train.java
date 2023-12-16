package KiemTraGiuaKy;
/**
Nhân dịp nhận tháng lương đầu tiên, LuckyBoy đã dành số tiền này để đưa các bạn sinh viên đi Huế du lịch.
 Do số tiền ít ỏi nên LuckyBoy không thể mua đủ vé máy bay cho các bạn nên mọi người đã quyết định đi tàu để tiết kiệm chi phí.
 Khi đến ga tàu, LuckyBoy và các bạn phát hiện ra đoàn tàu gồm có N toa tàu được đánh số từ 1 đến N đi vào ga, toa số 1 là đầu đoàn.
 Ban đầu, đoàn tàu được sắp xếp ở 2 đường ray. Ở đường ray thứ nhất, toa tàu nào vào trước sẽ đi ra trước tuy nhiên ở đường ray thứ hai toa tàu nào vào trước sẽ đi ra sau.
 Có M sự kiện diễn ra ở ga tàu:
1 i: toa tàu đầu đoàn đi vào đường ray i
2 i: 1 toa tàu ở đường ray i đi ra (nếu không có toa này thì không có gì xảy ra cả)
3 i: hỏi đường ray i đang có bao nhiêu toa tàu
4: hỏi đang còn lại bao nhiêu toa tàu chưa đi vào đường ray
5 u v: hỏi toa tàu nào ở đường ray u sẽ xuất phát nếu có v - 1 toa tàu đã xuất phát trước đó
Là một sinh viên ưu tú ngầu lòi bạn hãy trả lời các sự kiện để kiếm fame cho bản thân và 300 điểm cho bài kiểm tra nhé.
Input Format
d
Constraints
d
Output Format
d
Sample Input 0
5 6
5 1 1
1 2
1 1
4
4
5 1 1
Sample Output 0
0
3
3
2
*/
import java.util.*;

public class Train {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int k;
        int id = 1;
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int req = scan.nextInt();
            if (req == 1) {
                k = scan.nextInt();
                if (id > n) continue;
                if (k == 1) {
                    a.add(id);
                    id++;
                } else if (k == 2) {
                    b.add(id);
                    id++;
                }
            } else if (req == 2) {
                k = scan.nextInt();
                if (k == 1) {
                    if (a.size() > 0) {
                        a.remove(0);
                    }
                } else if (k == 2) {
                    if (b.size() > 0) {
                        b.remove(b.size() - 1);
                    }
                }
            } else if (req == 3) {
                k = scan.nextInt();
                if (k == 1) System.out.println(a.size());
                else if (k == 2) System.out.println(b.size());
                else System.out.println(0);
            } else if (req == 4) {
                System.out.println(n - id + 1);
            } else if (req == 5) {
                int u = scan.nextInt();
                int v = scan.nextInt();
                if (u == 1) {
                    if (a.size() > 0 && v > 0 && v < a.size() + 1) System.out.println(a.get(v - 1));
                    else System.out.println(0);
                } else if (u == 2) {
                    if (b.size() > 0 && v > 0 && v < b.size() + 1) System.out.println(b.get(b.size() - v));
                    else System.out.println(0);
                }
            }
        }
    }
}
