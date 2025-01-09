import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while(t-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 총 문서
            int m = Integer.parseInt(st.nextToken()); // 궁금한 문서의 위치

            st = new StringTokenizer(br.readLine());
            Queue<int[]> queue = new LinkedList<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

            for(int i= 0;i<n;i++){
                int importance = Integer.parseInt(st.nextToken());
                int [] arr = {importance, i};
                queue.add(arr);
                pq.add(importance);
            }
            int order = 0;
            while(!queue.isEmpty()){
                int[] arr = queue.poll();

                if(arr[0] == pq.peek()){
                    order++;
                    pq.poll();

                    if(arr[1] == m){
                        System.out.println(order);
                        break;
                    }
                }
                else{
                    queue.add(arr);
                }
            }
        }
    }
}
