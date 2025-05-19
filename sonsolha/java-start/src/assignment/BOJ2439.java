    package assignment;
    import java.util.Scanner;

    public class BOJ2439 {
    // N(1 ≤ N ≤ 100)
        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();

            for (int i = 0; i < n; i++) { // 줄 표현 반복문

                for (int j = 1; j < n - i; j++) { //오른쪽 정렬이기에 공백 먼저 출력
                    System.out.print(" ");
                }

                for (int j = 0; j < i; j++) { //줄당 출력되는 별의 개수
                    System.out.print("*");
                }
                System.out.println("*");
            }
        }

    }
