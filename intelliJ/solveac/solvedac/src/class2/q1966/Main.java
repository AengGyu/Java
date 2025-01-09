package class2.q1966;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while(T-- > 0){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            Queue<int[]> queue = new LinkedList<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            }); // 최대 힙으로 구현

            st = new StringTokenizer(br.readLine());
            for(int i=0;i<n;i++){
                int importance = Integer.parseInt(st.nextToken());
                queue.add(new int[] {importance,i}); // {중요도, 인덱스} 배열을 큐에 저장
                pq.add(importance);
            }
            int order = 0;
            while(!queue.isEmpty()){
                int [] arr = queue.poll();

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
