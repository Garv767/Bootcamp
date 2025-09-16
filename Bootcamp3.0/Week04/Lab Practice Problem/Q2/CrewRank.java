public enum CrewRank {
    CADET(1), OFFICER(2), COMMANDER(3), CAPTAIN(4), ADMIRAL(5);

    private final int level;

    CrewRank(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}