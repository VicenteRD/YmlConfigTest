package net.coldsherpa.ymlconfigtest;

public enum UserRank {
    NEWBIE(0, "Newbie"),
    BASIC_MEMBER(1, "Basic Member"),
    ADVANCED_MEMBER(2, "Advanced Member"),
    EXPIRED_PREMIUM(3, "Expired Member"),
    PREMIUM_MEMBER(4, "Premium Member"),
    PREMIUM_PLUS_MEMBER(5, "Premium Plus Member");

    private int value;
    private String literal;

    UserRank(int value, String literal) {
        this.value = value;
        this.literal = literal;
    }

    public int getValue() {
        return value;
    }

    public String getLiteral() {
        return literal;
    }
}
