package generic.test.ex3.unit;

public class BioUnit {
    private String name;
    private int hp;

    public BioUnit(String name,int hp) {
        this.name = name;
        this.hp = hp;
    }

    public int getHp() {
        return hp;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "BioUnit{" +
                "hp=" + hp +
                ", name='" + name + '\'' +
                '}';
    }
}
