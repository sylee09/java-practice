public enum ChampionTypeLevelUpStats {
    DEALER(300,10,3,100),
    SUPPORTER(300, 8, 4, 150);

    int hp;
    int atk;
    int def;
    int mp;

    ChampionTypeLevelUpStats(int hp, int atk, int def, int mp) {
        this.hp = hp;
        this.atk = atk;
        this.def = def;
        this.mp = mp;
    }
}
