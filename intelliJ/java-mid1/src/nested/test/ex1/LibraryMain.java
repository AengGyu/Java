package nested.test.ex1;

public class LibraryMain {
    public static void main(String[] args) {
        Library library = new Library(4);
        library.addBooks("책1", "저자1");
        library.addBooks("책2", "저자2");
        library.addBooks("책3", "저자3");
        library.addBooks("자바 ORM 표준 JPA 프로그래밍", "김영한");
        library.addBooks("OneMoreThing", "잡스");
        library.showBooks();
    }
}
