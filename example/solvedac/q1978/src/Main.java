import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int[][] apt = new int[15][15];

        for(int i=1;i<=14;i++){ // 0층에 몇명 사는지
            apt[0][i] = i;
        }
        for(int i=1;i<=14;i++){
            for(int j = 1;j<=14;j++){
                apt[i][j] = apt[i-1][j] + apt[i][j-1];
            }
        }
        while(T>0){
            int k, n; // k층, n호
            k = scanner.nextInt();
            n = scanner.nextInt();
            System.out.println(apt[k][n]);
            T--;
        }
    }
}
