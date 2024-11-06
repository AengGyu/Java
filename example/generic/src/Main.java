class Box<T> {
    private T ob;

    public void set(T o) {
        ob = o;
    }

    public T get() {
        return ob;
    }
}
class BoxFactory{
    public static <T> Box<T> makeBox(T o){
        Box<T> box = new Box<>();
        box.set(o);
        return box;
    }
}
class UnBoxer{
    public static <T> T openBox(Box<T> box){
        return box.get();
    }
}
public class Main {
    public static void main(String[] args){
        Box<String> sBox = BoxFactory.makeBox("Sweet");
        System.out.println(UnBoxer.openBox(sBox));

        Box<Double> dBox = BoxFactory.makeBox(7.59);
        System.out.println(UnBoxer.openBox(dBox));
    }
}
