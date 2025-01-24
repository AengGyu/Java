import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] wallpaper = new String[3];

        for (int i = 0; i < 3; i++) {
            wallpaper[i] = scanner.next();
        }

        boolean [][] wall = new boolean[wallpaper.length][wallpaper[0].length()];

        for(int i = 0; i < wallpaper.length; i++){
            char [] row = wallpaper[i].toCharArray();
            for(int j = 0; j < row.length; j++){
                if(row[j] == '#') wall[i][j] = true;
            }
        }

        System.out.println(Arrays.deepToString(wall));

        int startRow = -1, startCol = -1, endRow = -1, endCol = -1;

        for(int i = 0; i < wall[0].length; i++){
            for(int j = 0; j < wall.length; j++){
                if(wall[j][i]){
                    startCol = i;
                    break;
                }
            }
            if(startCol != -1) break;
        }

        System.out.println("startCol = " + startCol);
    }
}