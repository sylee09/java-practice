import java.util.List;
import java.util.Random;

public class Battle {

    private static Random random = new Random();

    public static void oneVsOne(Team<Champion> t1, Team<Champion> t2) {
        Champion c1 = randomPick(t1.getMembers());
        Champion c2 = randomPick(t2.getMembers());

        System.out.println("\n===== 1:1 전투 시작 =====");
        System.out.println(c1.getName() + " vs " + c2.getName());

        c1.attackFunc(c2);
        c2.attackFunc(c1);

        c1.q(c2);
        c2.q(c1);
    }

    private static Champion randomPick(List<Champion> list) {
        return list.get(random.nextInt(list.size()));
    }
}
