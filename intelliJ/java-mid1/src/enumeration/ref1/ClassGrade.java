package enumeration.ref1;

public class ClassGrade {
    public static final ClassGrade BASIC = new ClassGrade(10);
    public static final ClassGrade GOLD = new ClassGrade(20);
    public static final ClassGrade DIAMOND = new ClassGrade(30);

    private final int discontPercent;

    public ClassGrade(int discontPercent) {
        this.discontPercent = discontPercent;
    }

    public int getDiscontPercent() {
        return discontPercent;
    }
}
