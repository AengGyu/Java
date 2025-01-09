package class2.q1931;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Time {
    public int start, end;

    public Time(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Time> pq = new PriorityQueue<>(new Comparator<Time>() {
            @Override
            public int compare(Time o1, Time o2) {
                if(o1.end == o2.end){
                    return o1.start - o2.start;
                }
                else{
                    return o1.end-o2.end;
                }
            }
        });

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            pq.add(new Time(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Time tmp = new Time(-1, -1);
        int cnt = 0;
        while (!pq.isEmpty()) {
            Time time = pq.poll();
            if (time.start >= tmp.end) {
                tmp = time;
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
