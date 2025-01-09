package collection.deque.test.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class BrowserHistory {
//    내가 작성한 코드
//    private Deque<String> stack = new ArrayDeque<>();
//    public void visitBrowser(String browser){
//        System.out.println("방문: " + browser);
//        stack.push(browser);
//    }
//
//    public String goBack(){
//        stack.pop();
//        System.out.println("뒤로 가기: " + stack.peek());
//        return stack.peek();
//    }
    private Deque<String> history = new ArrayDeque<>();
    private String currentPage = null;

    public void visitBrowser(String url){
        if(currentPage != null){
            history.push(url);
        }
        currentPage = url;
        System.out.println("방문: " + url);
    }
    public String goBack(){
        if(!history.isEmpty()){
            currentPage = history.pop();
            System.out.println("뒤로 가기: " + currentPage);
            return currentPage;
        }
        return null;
    }
}
