package Tutorial1.tut01.tanks.enums;

public enum Speed {
    SLOW(1),
    NORMAL(2),
    FAST(3);

    private int value;

    private Speed(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public static Speed getSpeed(int value) {
        switch (value) {
            case 1:
                return SLOW;
            case 2:
                return NORMAL;
            case 3:
                return FAST;
            default:
                return SLOW;
        }
    }
}
