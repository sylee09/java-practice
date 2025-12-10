import java.util.Random;

public class Sena extends Champion implements Supporter {

    public Sena(int hp, int atk, int mp, int def, int lv, int luck) {
        super("sena", hp, atk, mp, def, lv, luck);
    }

    public Sena(int hp, int atk, int mp, int def) {
        super("sena", hp, atk, mp, def, 1, 10);
    }

    public Sena() {
        super("sena", 580, 28, 280, 22, 1, 10);
    }

    @Override
    public void attackFunc(Champion a) {
        int deal;
        System.out.println(this.getName() + "가 " + a.getName() + "에게 일반공격을 가합니다. ");
        if (criticalOccurred()) {
            System.out.println("치명타 공격 발생");
            deal = this.getAtk() * 2 - a.getDef();
        } else {
            deal = this.getAtk() - a.getDef();
        }
        giveDamage(a, deal);
        if (isDead(a)) {
            System.out.println(a.getName() + " 사망!");
        }
    }

    @Override
    public void giveDamage(Champion a, int dmg) {
        System.out.println(a.getName() + "의 현재 체력: " + a.getHp());
        dmg = Math.max(dmg, 0);
        a.setHp(Math.max(a.getHp() - dmg, 0));
        System.out.println("공격후 " + a.getName() + "의 현재 체력: " + a.getHp());
    }

    @Override
    public boolean isDead(Champion a) {
        if (a.getHp() == 0) {
            return true;
        }
        return false;
    }

    @Override
    public void q(Champion a) {
        System.out.println(this.getName() + "이 q 스킬을 씁니다.");
        int dmg;
        if (criticalOccurred()) {
            System.out.println("치명타 공격 발생");
            dmg = (int) (this.getAtk() * 1.2 * 2 - a.getDef());
        } else {
            dmg =  (int) (this.getAtk() * 1.2 - a.getDef());
        }
        giveDamage(a, dmg);
        if (isDead(a)) {
            System.out.println(a.getName() + " 사망!");
        }
    }

    @Override
    public void w(Champion a) {
        System.out.println(this.getName() + "이 w 스킬을 씁니다.");
        int dmg;
        if (criticalOccurred()) {
            System.out.println("치명타 공격 발생");
            dmg = (int) (this.getAtk() * 1.1 * 2 - a.getDef());
        } else {
            dmg =  (int) (this.getAtk() * 1.1 - a.getDef());
        }
        giveDamage(a, dmg);
        if (isDead(a)) {
            System.out.println(a.getName() + " 사망!");
        }
    }

    @Override
    public void e(Champion a) {
        System.out.println(this.getName() + "이 e 스킬을 씁니다.");
    }

    @Override
    public void r(Champion a) {
        System.out.println(this.getName() + "이 r 스킬을 씁니다.");
        int dmg;
        if (criticalOccurred()) {
            System.out.println("치명타 공격 발생");
            dmg = (int) (this.getAtk() * 1.4 * 2 - a.getDef());
        } else {
            dmg =  (int) (this.getAtk() * 1.4 - a.getDef());
        }
        giveDamage(a, dmg);
        if (isDead(a)) {
            System.out.println(a.getName() + " 사망!");
        }
    }

    @Override
    public boolean criticalOccurred() {
        Random random = new Random();
        int critical = random.nextInt(100) + 1;
        return critical <= this.getLuck();
    }

    @Override
    public void levelUp() {
        System.out.println("levelUp 모든 스탯이 증가합니다.");
        System.out.println("현재 챔피언 정보: " + this);
        this.setHp(this.getHp() + 300);
        this.setAtk(this.getAtk() + 8);
        this.setDef(this.getDef() + 4);
        this.setLv(this.getLv() + 1);
        this.setMp(this.getMp() + 150);
        System.out.println("level Up후 현재 챔피언 정보: " + this);
    }

}
