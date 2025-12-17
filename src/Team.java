import java.util.ArrayList;
import java.util.List;

public class Team<T extends Champion> {
    private List<T> members = new ArrayList<>();

    List<T> getMembers() {
        return members;
    }

    void addMember(T member) {
        members.add(member);
    }
}
