import java.util.ArrayList;
import java.util.Scanner;

class StringArrayList {
    private Scanner scanner = new Scanner(System.in);
    private ArrayList<String> arrayList = new ArrayList<String>(); // 문자열을 저장하는 컬렉션
    public StringArrayList() { }
    public boolean read() {
        arrayList.clear() ; // arrayList 리스트에 있는 모든 것 삭제
        System.out.print("Enter a string>>");String line = scanner.nextLine(); // 한 라인 읽기
        if(line.equals("quit"))
            return false;
        String s [] = line.split(" ") ; // 라인 line 을 빈 칸으로 분리하여 s[]에 저장
        for(int i=0; i<s.length; i++) {
            arrayList.add(s[i]); // 배열 s[]의 문자열을 arrayList 리스트에 저장
        }
        return true;
    }
    private void searchAndRemove(String src, int j) {
// arrayList 리스트의 j번째 위치에서부터 src와 동일한 문자열 모두 제거
        while(j < arrayList.size()) {
            String dest = arrayList.get(j);
            if(src.equals(dest))
                arrayList.remove(j); // arrayList에서 동일한 문자열 제거
            else
                j++; // 다음 원소를 위해 인덱스 증가
        }
    }
    public void removeDuplicate() {
        int i=0;
        while(i<arrayList.size()) {
            String src = arrayList.get(i);
            searchAndRemove(src, i+1); // arrayList 리스트의 i+1번째 원소부터 src와 동일한 문자열 모두 제거
            i++;
        }
    }
    public void showAll() {
        for(int i=0; i<arrayList.size(); i++) {
            System.out.print( arrayList.get(i) + " "); // arrayList 리스트에서 원소 한 개 가져오기
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        StringArrayList list = new StringArrayList();
        while(true) {
            if(list.read() == false) // 사용자가 "quit"을 입력한 경우
                break;
            list.removeDuplicate(); ; //중복 삭제 메서드 호출하기
            list.showAll(); ; //화면에 출력하는 메서드 호출하기
        }
    }
}