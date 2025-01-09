package generic.test.ex3;

import generic.test.ex3.unit.BioUnit;

public class Shuttle<T extends BioUnit> {
    private T unit ;

    public void in(T unit){
        this.unit = unit;
    }

    public T out(){
        return unit;
    }

    public void showInfo(){
        System.out.println("이름: " + unit.getName() + ", HP: " + unit.getHp());
    }

    @Override
    public String toString() {
        return "Shuttle{" +
                "unit=" + unit +
                '}';
    }
}
