public abstract class Champion {
    private String name;
    private int hp;
    private int atk;
    private int mp;
    private int def;
    private int lv;
    private int luck;

    public Champion(String name, int hp, int atk, int mp, int def, int lv, int luck) {
        this.name = name;
        this.hp = hp;
        this.atk = atk;
        this.mp = mp;
        this.def = def;
        this.lv = lv;
        this.luck = luck;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getAtk() {
        return atk;
    }

    public int getMp() {
        return mp;
    }

    public int getDef() {
        return def;
    }

    public int getLv() {
        return lv;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public void setLv(int lv) {
        this.lv = lv;
    }

    public int getLuck() {
        return luck;
    }

    public void setLuck(int luck) {
        this.luck = luck;
    }

    public abstract void attackFunc(Champion a);

    public abstract void giveDamage(Champion a, int dmg);

    public abstract void q(Champion a);

    public abstract void w(Champion a);

    public abstract void e(Champion a);

    public abstract void r(Champion a);

    public abstract boolean isDead(Champion a);

    public abstract boolean criticalOccurred();

    public final void resurrect() {
        System.out.println("체력이 1로 부활합니다.");
        buffer();
        this.setHp(1);
    }

    public abstract void buffer();

    @Override
    public String toString() {
        return "Champion{" +
                "name='" + name + '\'' +
                ", hp=" + hp +
                ", atk=" + atk +
                ", mp=" + mp +
                ", def=" + def +
                ", lv=" + lv +
                '}';
    }
}
