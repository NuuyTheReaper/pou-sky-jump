import greenfoot.*;

public abstract class BaseWorld extends World {
    protected int poin = 0;
    protected int targetPoin;
    protected Counter poinCounter;

    public BaseWorld(int width, int height, int cellSize) {
        super(width, height, cellSize);
    }

    public void tambahPoin(int nilai) {
        poin += nilai;
        poinCounter.setValue(poin);
        if (poin >= targetPoin && getObjects(Gate.class).isEmpty()) {
            addObject(new Gate(), 400, 80);
        }
    }

    public int getPoin() {
        return poin;
    }

    public int getTargetPoin() {
        return targetPoin;
    }
}
