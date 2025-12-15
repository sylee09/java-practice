public class ChooseChampionResurrectStrategy {
    Resurrect resurrect;
    Champion champion;

    public void setResurrect(Resurrect resurrect) {
        this.resurrect = resurrect;
    }

    public void setChampion(Champion champion) {
        this.champion = champion;
    }

    public void resurrect() {
        if (resurrect.resurrect()) {
            champion.resurrect();
        }
    }
}
