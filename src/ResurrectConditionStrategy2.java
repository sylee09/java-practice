public class ResurrectConditionStrategy2 implements Resurrect {
    static int resurrectCount = 0;

    // 최대 1번만 부활가능한 전략
    @Override
    public boolean resurrect() {
        if (resurrectCount > 0) {
            System.out.println("세나는 1번만 부활 가능합니다. 더 이상 부활할 수 없습니다.");
            return false;
        }
        resurrectCount++;
        return true;
    }
}
