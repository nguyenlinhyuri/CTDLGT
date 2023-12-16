package KiemTraGiuaKy;

/**
 Một ngày đầu đông se lạnh trong phòng học tin thân thuộc mến thương của Trường Đại học Công nghệ - Đại học Quốc Gia Hà Nội (viết tắt là UET)
 các bạn sinh viên đang hồi hộp chuẩn bị cho bài kiểm tra giữa kỳ vô cùng căng thẳng và sứt mẻ tình anh em.
 Tuy nhiên sức mạnh của tình bạn sẽ chiến thắng tất cả, các bạn sinh viên quyết tâm đoàn kết lại để vượt qua bài kiểm tra này.
 Trong lớp có N bạn sinh viên, ban đầu các bạn làm bài đọc lập. Nhưng do giám thị buồn ngủ nên các bạn đã tranh thủ nháy mắt với nhau để tạo thành các nhóm.
 Định nghĩa nhóm là tập hợp của 1 số người có chung lợi ích và điểm sẽ có thể giống nhau và bất kì 2 người nào trong nhóm cũng có thể trao đổi với nhau thông qua những người trung gian.
 Đương nhiên ban đầu sẽ có N nhóm. Có M sự kiện xảy ra gồm có 4 loại:
 1 u v: bạn u và bạn v đã "nháy mắt" được với nhau.
 2: hiện tại đang có bao nhiêu nhóm.
 3 u: nhóm đang chứa bạn u đang có bao nhiêu đồng chí.
 4: nhóm đông nhất đang có bao nhiêu bé.
 Là một người siêu cấp vippro với khả năng làm bài siêu hạng và độ rảnh nợ siêu hạng bạn hãy giúp các bạn trong lớp trả lời các sự kiện trên.
 Phần thưởng cho bạn sẽ là 100 điểm.
 Input Format
 10 5 1 1 2 2 3 4 1 2 3 4
 Constraints
 1 <= N <= 100000 1 <= M <= 100000
 Output Format
 9 2 3
 Sample Input 0
 9 7
 3 7
 3 4
 1 1 7
 2
 1 7 4
 3 2
 1 1 4
 Sample Output 0
 1
 1
 8
 1
 */

import java.util.*;

public class Union {
    static int[] parent = new int[100001];
    static int c;

    static int minn;

    public static int find(int u) {
        if (parent[u] <= -1) return u;
        else return parent[u] = find(parent[u]);
    }

    public static void Union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b) return;
        else {
            if (parent[a] < parent[b]) {
                parent[a] += parent[b];
                if (minn < Math.abs(parent[a])) minn = Math.abs(parent[a]);
                parent[b] = a;
                c--;
            } else {
                parent[b] += parent[a];
                if (minn < Math.abs(parent[b])) minn = Math.abs(parent[b]);
                parent[a] = b;
                c--;
            }
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        c = n;
        minn = 1;
        for (int i = 1; i <= n; i++) {
            parent[i] = -1;
        }
        for (int i = 1; i <= m; i++) {
            int ch = sc.nextInt();
            if (ch == 1) {
                int p = sc.nextInt();
                int q = sc.nextInt();
                Union(p, q);
            }
            if (ch == 2) {
                System.out.println(c);
            }
            if (ch == 3) {
                int p = sc.nextInt();
                if (parent[p] < 0)
                    System.out.println(Math.abs(parent[p]));
                else System.out.println(Math.abs(parent[find(p)]));
            }
            if (ch == 4) {
                System.out.println(minn);
            }
        }
    }
}