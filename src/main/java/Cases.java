public class Cases {
    int x;
    int y;
    String state;
    String value;
    boolean isBomb;

    public Cases(int x, int y, String state,String value, boolean isBomb) {
        this.x = x;
        this.y = y;
        this.state = state;
        this.value = value;
        this.isBomb = isBomb;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public boolean isBomb() {
        return isBomb;
    }

    public void setBomb(boolean bomb) {
        isBomb = bomb;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
