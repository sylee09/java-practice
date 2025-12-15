import java.util.Random;

public class ResurrectConditionStrategy1 implements Resurrect {
    // random한 시간뒤에 챔피언 부활하는 전략
    @Override
    public boolean resurrect() {
        Random random = new Random();
        int time = random.nextInt(0, 30) + 1;
        System.out.println(time + "초 후에 부활합니다.");
        return true;
    }
}
