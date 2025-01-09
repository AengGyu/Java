package nested.test.ex1;

public class Library {
    private static class Book{
        private String title;
        private String author;

        public Book(String title, String author) {
            this.title = title;
            this.author = author;
        }
    }

    private int currentBook;
    private Book[] books;

    public Library(int numOfBook) {
        this.currentBook = 0;
        books = new Book[numOfBook];
    }

    public void addBooks(String title, String author){
        if(currentBook >= books.length){
            System.out.println("도서관 저장 공간이 부족합니다.");
            return;
        }
        books[currentBook++] = new Book(title,author);
    }

    public void showBooks(){
        System.out.println("==책 목록 출력==");
        for (int i = 0; i < currentBook; i++) {
            System.out.println("도서 제목: " + books[i].title + ", 저자: " + books[i].author);
        }
    }
}
