
public class Keret {
    private String name;
    private boolean lock;
    private int cnt;
    private int value;

    public Keret(String name, boolean lock, int cnt, int value) {
        this.name = name;
        this.lock = lock;
        this.cnt = cnt;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isLock() {
        return lock;
    }

    public void setLock(boolean lock) {
        this.lock = lock;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }


    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }


}




