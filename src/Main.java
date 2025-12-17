import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Champion lucian = new Lucian();
        Champion sena = new Sena();
        ChooseChampionResurrectStrategy strategy = new ChooseChampionResurrectStrategy();
        strategy.setResurrect(new ResurrectConditionStrategy1());
//        strategy.setResurrect(new ResurrectConditionStrategy2());

        System.out.println("printTeamMembers 테스트");
        List<Champion> list1 = new ArrayList<>();
        list1.add(lucian);
        list1.add(sena);
        PrintUtil.printTeamMembers(list1);
        List<Lucian> list2 = new ArrayList<>();
        list2.add(new Lucian());
        list2.add(new Lucian());
        PrintUtil.printTeamMembers(list2);
        List<Sena> list3 = new ArrayList<>();
        list3.add(new Sena());
        list3.add(new Sena());
        PrintUtil.printTeamMembers(list3);
        System.out.println();

        System.out.println("*********************");
        System.out.println("Battle.oneVsOne() 테스트");
        Team<Champion> lucians = new Team<>();
        lucians.addMember(new Lucian());
        lucians.addMember(new Lucian());
        lucians.addMember(new Lucian());
        Team<Champion> senas = new Team<>();
        senas.addMember(new Sena());
        senas.addMember(new Sena());
        senas.addMember(new Sena());
        Battle.oneVsOne(lucians, senas);
        System.out.println();

        System.out.println("*********************");
        lucian.attackFunc(sena);
        System.out.println("*********************");
        lucian.q(sena);
        System.out.println("*********************");
        lucian.w(sena);
        System.out.println("*********************");
        lucian.e(sena);
        System.out.println("*********************");
        lucian.r(sena);
        System.out.println();
        System.out.println("*********************");
        sena.attackFunc(lucian);
        System.out.println("*********************");
        sena.q(lucian);
        System.out.println("*********************");
        sena.w(lucian);
        System.out.println("*********************");
        sena.e(lucian);
        System.out.println("*********************");
        sena.r(lucian);

        System.out.println();
        System.out.println();
        System.out.println(lucian.getName() + "이 " + sena.getName() + "가 죽을때까지 r 스킬을 씁니다.");
        while (sena.getHp() > 0) {
            lucian.r(sena);
            if (sena.getHp() == 0) {
                ((Dealer) lucian).levelUp();
            }
        }

        System.out.println("총 전투 횟수: "+GameConstants.BATTLE_COUNT);
        if (sena.getHp() <= 0) {
            strategy.setChampion(sena);
            System.out.println(sena.getName() + "의 현재 체력: " + sena.getHp());
            strategy.resurrect();
        }

        while (sena.getHp() > 0) {
            lucian.r(sena);
            if (sena.getHp() == 0) {
                ((Dealer) lucian).levelUp();
            }
        }

        if (sena.getHp() <= 0) {
            strategy.setChampion(sena);
            System.out.println(sena.getName() + "의 현재 체력: " + sena.getHp());
            strategy.resurrect();
        }

        System.out.println("Lucian 전투기록: " + Lucian.ChampionLog.battleLogs);
    }
}