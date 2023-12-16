package KiemTraGiuaKy;

/**
Các bạn sinh viên Đại học Công nghệ - Đại học Quốc gia Hà Nội không chỉ học giỏi, chơi game giỏi, có nhiều người yêu mà còn là những người vô cùng yêu thích thể dục thể thao các hoạt động thể chất hay tiếng anh là physical activities hay các hoạt động ngoài trời tiếng anh là outdoor activities.
 Hôm nay dưới sự chỉ đạo dẫn dắt lãnh đạo của sinh viên vừa tốt nghiệp tí thì thất nghiệp LuckyBoy các bạn chơi một trò chơi như sau. Ban đầu trên sân có 3 hàng, các bạn sinh viên cute phô mai que đứng ở hàng 1 và sắp thành 1 hàng được đánh số từ 1 đến N.
 LuckyBoy có các loại hiệu lệnh:
        1 u v: người đứng đầu hàng u chuyển sang đầu hàng v (nếu như không có thì không chuyển)
        2 x y: người đứng thứ 2 của hàng u chuyển sang vị trí thứ 2 của hàng v (nếu như hàng u không có người thì không chuyển, nếu hàng v không có người thì bạn đó đứng đầu hàng)
        3 i: hỏi hiện tại hàng thứ i có bao nhiêu người
        4 j: hỏi người đứng đầu hàng j đang là đồng chí nào (Nếu không có thì in ra 0)
        Là một bạn sinh viên vô cùng nhiệt tình và rảnh nợ hãy giúp các bạn sinh viên trả lời những câu hỏi oái oăm của LuckyBoy nhé. Bạn sẽ được 300 điểm cho bài này.
        Input Format
        1
        Constraints
        1
        Output Format
        1
        Sample Input 0
        8 8
        1 2 1
        1 2 1
        3 2
        3 1
        3 1
        3 1
        4 2
        4 2
        Sample Output 0
        0
        8
        8
        8
        0
        0
*/
import java.util.LinkedList;
import java.util.Scanner;

public class XepHang {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        LinkedList<Integer>[] q = new LinkedList[3];

        for (int i = 0; i < 3; i++) {
            q[i] = new LinkedList<Integer>();
        }
        for (int i = 0; i < n; i++) {
            q[0].add(i + 1);
        }

        int m = s.nextInt();
        while (m-- > 0) {
            int c = s.nextInt();
            switch (c) {
                case 1:
                    int u = s.nextInt() - 1;
                    int v = s.nextInt() - 1;
                    if (!q[u].isEmpty()) {
                        int p = q[u].poll();
                        q[v].addFirst(p);
                    } else {
                        continue;
                    }
                    break;
                case 2:
                    int x = s.nextInt() - 1;
                    int y = s.nextInt() - 1;
                    if (q[x].size() >= 2 && (q[y].size() >= 1 || q[y].isEmpty())) {
                        int z = q[x].remove(1);
                        q[y].add(q[y].isEmpty() ? 0 : 1, z);
                    } else {
                        continue;
                    }
                    break;
                case 3:
                    int i = s.nextInt() - 1;
                    System.out.println(q[i].size());
                    break;
                case 4:
                    int j = s.nextInt() - 1;
                    if (!q[j].isEmpty()) {
                        System.out.println(q[j].getFirst());
                    } else {
                        System.out.println(0);
                    }
                    break;
            }
        }
    }
}
