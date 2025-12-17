import java.util.List;

public class PrintUtil {

    public static void printTeamMembers(List<? extends Champion> team) {
        for (Champion champion : team) {
            System.out.println(champion);
        }
    }
}
