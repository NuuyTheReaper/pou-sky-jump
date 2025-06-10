// GameWorld.java
import greenfoot.*;
import java.util.List;

public class GameWorld extends BaseWorld {
    private int poin = 0;
    private int targetPoin = 100;
    private Counter poinCounter;

    public GameWorld() {
        super(600, 1200, 1);
        prepare();
            GameInitializer.init(); // hanya memulai bgm sekali


    }

    private void prepare() {

        Player player = new Player();
        addObject(player, getWidth() / 2, getHeight() - 100);
        addObject(new Platform(), 300, 1185);

        Platform p1 = new pijakan(); addObject(p1, 100, 1060);
        Platform p2 = new pijakan(); addObject(p2, 250, 930);
        Platform p3 = new pijakan(); addObject(p3, 400, 810);
        Platform p4 = new pijakan(); addObject(p4, 150, 710);
        Platform p5 = new pijakan(); addObject(p5, 300, 610);
        Platform p6 = new pijakan(); addObject(p6, 450, 510);
        Platform p7 = new pijakan(); addObject(p7, 200, 410);
        Platform p8 = new pijakan(); addObject(p8, 350, 310);
        Platform p9 = new pijakan(); addObject(p9, 100, 210);
        Platform p10 = new pijakan(); addObject(p10, 300, 130);

        // Tambahkan koin dengan posisi acak di atas platform (dalam lebar platform 300)
        List<Platform> panjang_pijakan = getObjects(Platform.class);
        for (Platform platform : panjang_pijakan) {
            int platformWidth = 150;
            int xOffset = Greenfoot.getRandomNumber(platformWidth) - platformWidth / 2;
            int x = platform.getX() + xOffset;
            int y = platform.getY() - 40; // sedikit di atas platform
            Coin coin = new Coin();
            addObject(coin, x, y);
        }

        poinCounter = new Counter("Poin: ");
        addObject(poinCounter, 70, 30);
    }

    public void tambahPoin(int nilai) {
        poin += nilai;
        poinCounter.setValue(poin);
        if (poin >= targetPoin && getObjects(Gate.class).isEmpty()) {
            addObject(new Gate(), getWidth() / 2, 80);
        }
    }
    public class GameInitializer {
    private static boolean bgmStarted = false;

    public static void init() {
        if (!bgmStarted) {
            SoundManager.playBGM();
            bgmStarted = true;
        }
    }
}

    public int getPoin() {
        return poin;
    }

    public int getTargetPoin() {
        return targetPoin;
    }
}
