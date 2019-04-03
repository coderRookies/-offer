package meettooffer.chapter2;

public class Singleton {
    private static Singleton instance = new Singleton();

    private Singleton() {
    }

    public Singleton getInstance() {
        return instance;
    }
}

class President {

    @SuppressWarnings("unused")
    private static President instance = new President();

    protected President() {
    }
}
