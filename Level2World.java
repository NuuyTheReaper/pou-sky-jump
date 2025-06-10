// Level2World.java
import greenfoot.*;
import java.util.List;

public class Level2World extends BaseWorld {
    private int poin = 0;
    private int targetPoin = 220; // Lebih tinggi dari level 1
    private Counter poinCounter;

    public Level2World() {
        super(600, 1200, 1); // Lebih tinggi dari level 1
        prepare();
    }

    private void prepare() {
        Player player = new Player();
        addObject(player, getWidth() / 2, getHeight() - 100);
        addObject(new Platform(), 300, getHeight() - 15); // Platform dasar
        
        Platform p1 = new pijakan(); addObject(p1, 150, 1060);
        Platform p2 = new pijakan(); addObject(p2, 380, 930);
        Platform p3 = new pijakan(); addObject(p3, 200, 810);
        Platform p4 = new pijakan(); addObject(p4, 350, 710);
        Platform p5 = new pijakan(); addObject(p5, 100, 610);
        Platform p6 = new pijakan(); addObject(p6, 300, 510);
        Platform p7 = new pijakan(); addObject(p7, 450, 410);
        Platform p8 = new pijakan(); addObject(p8, 300, 310);
        Platform p9 = new pijakan(); addObject(p9, 150, 210);
        Platform p10 = new pijakan(); addObject(p10, 400, 130);

        List<Platform> platforms = getObjects(Platform.class);
        for (Platform platform : platforms) {
            int platformWidth = 150;
            for (int i = 0; i < 2; i++) {
                int xOffset = Greenfoot.getRandomNumber(platformWidth) - platformWidth / 2;
                int x = platform.getX() + xOffset;
                int y = platform.getY() - 40;
                Coin coin = new Coin();
                addObject(coin, x, y);
            }
        }

        poinCounter = new Counter("Poin: ");
        addObject(poinCounter, 70, 30);
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
