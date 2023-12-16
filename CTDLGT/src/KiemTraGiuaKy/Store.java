package KiemTraGiuaKy;

/**
 Do tình hình thế giới bất ổn, kinh tế khó khăn, nên LuckyBoy và các bạn sinh viên rơi vào cảnh đói ăn.
 Vượt lên số phận LuckyBoy cùng các bạn đã đứng lên thành lập quán nhậu với thực đơn: lạc rang, rau muống xàu, lòng xào dưa.
 Tuy nhiên với tư cách là cách sinh viên ưu tú của Đại học Công nghệ - Đại học Quốc gia Hà Nội cách phục vụ khách hàng trong quán sẽ được phục vụ theo thứ tự đặc biệt.
 Các khách hàng vào sẽ được đánh số theo tăng dần từ 1.
 Có M sự kiện diễn ra trong quán ăn:
 1: Có thêm 1 khách vào quán.
 2: Phục vụ khách hàng đứng ở đầu hàng đợi và đưa ra id của khách hàng đó.
 3: Phục vụ khách hàng đứng ở cuối hàng đợi và đưa ra id của khách hàng đó.
 4: Đưa số lượng khách hàng đang đợi.
 5 u: Đưa ra khách hàng đang đứng ở vị trí thứ u trong hàng đợi.
 Với tài năng thiên bẩm, trí tuệ hơn người là một trong số 8 tỉ người thông minh nhất thế giới, khả năng sử dụng ngôn ngữ java siêu hạng bạn được LuckyBoy giao cho nhiệm vụ thực hiện và trả lời các yêu cầu trên
 (Do lỗi của LuckyBoy nên ở bộ test có nhập vào 2 số N, M ở ban đầu của mỗi test nhưng N để cho vui)
 Input Format
 a
 Constraints
 a
 Output Format
 a
 Sample Input 0
 7 7
 5 1
 4
 1
 1
 4
 2
 4
 Sample Output 0
 0
 0
 2
 1
 1
 */
import java.util.*;

public class Store {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> queue = new LinkedList<>();

        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int nexxt = 1;

        for (int i = 0; i < M; i++) {
            int ch = scanner.nextInt();
            if (ch == 1) {
                queue.add(nexxt);
                nexxt++;
            } else if (ch == 2) {
                if (!queue.isEmpty()) {
                    System.out.println(queue.pollFirst());
                } else {
                    System.out.println(0);
                }
            } else if (ch == 3) {
                if (!queue.isEmpty()) {
                    System.out.println(queue.pollLast());
                } else {
                    System.out.println(0);
                }
            } else if (ch == 4) {
                System.out.println(queue.size());
            } else if (ch == 5) {
                int u = scanner.nextInt();
                if (u > 0 && u <= queue.size()) {
                    int x = 1;
                    for (Integer cs : queue) {
                        if (x == u) {
                            System.out.println(cs);
                            break;
                        }
                        x++;
                    }
                } else {
                    System.out.println(0);
                }
            }
        }
    }
}