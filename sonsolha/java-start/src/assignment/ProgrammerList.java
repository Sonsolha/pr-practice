package assignment;

class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        
        int a = slicer[0];
        int b = slicer[1];
        int c = slicer[2];

        // 결과 담을 배열
        int[] result;

        // n == 1이면 0부터 b까지 뽑기
        if (n == 1) {
            result = new int[b + 1]; // b까지니까 b+1개 필요함
            for (int i = 0; i <= b; i++) {
                result[i] = num_list[i]; // 그대로 복사
            }

            // n == 2면 a부터 끝까지
        } else if (n == 2) {
            result = new int[num_list.length - a]; // 끝까지니까 전체길이 - 시작점
            for (int i = a; i < num_list.length; i++) {
                result[i - a] = num_list[i]; // 시작점 기준으로 0부터 채우기
            }

            // n == 3이면 a부터 b까지
        } else if (n == 3) {
            result = new int[b - a + 1]; // (끝 - 시작 + 1) 만큼 필요
            for (int i = a; i <= b; i++) {
                result[i - a] = num_list[i]; // a부터 b까지 복사
            }

            // n == 4면 a부터 b까지 c 간격으로
        } else {
            int size = (b - a) / c + 1; // 몇 칸 건너뛰는지 계산해서 크기 구함
            result = new int[size];
            for (int i = 0, j = a; j <= b; j += c, i++) {
                result[i] = num_list[j]; // c 간격으로 뽑아 넣기
            }
        }

        return result; // 만든 결과 배열 반환
    }
}


public class ProgrammerList {
    public static void main(String[] args) {


        }
       }

