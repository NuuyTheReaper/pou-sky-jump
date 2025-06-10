import greenfoot.*;

public class Player extends Actor {
    private int speedY = 0;
    private final int GRAVITY = 1;
    private final int JUMP_STRENGTH = -16;
    
    // Tambahkan GreenfootSound untuk jump
    private GreenfootSound jumpSound = new GreenfootSound("jump.wav");

    public Player() {
        GreenfootImage img = new GreenfootImage("pou.png");
        img.scale(50, 50);
        setImage(img);
    }
    
    public void act() {
        applyGravity();
        checkPlatformCollision();
        checkCoinCollision();
        checkGate();
        moveHorizontally();
    }

    private void applyGravity() {
        speedY += GRAVITY;
        setLocation(getX(), getY() + speedY);
    }

    private void jump() {
        speedY = JUMP_STRENGTH;
        jumpSound.play();  // Putar suara jump saat lompat
    }

    private void checkPlatformCollision() {
        Platform platform = (Platform) getOneObjectAtOffset(0, getImage().getHeight() / 2, Platform.class);
        if (platform != null && speedY > 0) {
            jump();
        }
    }

    private void checkCoinCollision() {
        Coin coin = (Coin) getOneIntersectingObject(Coin.class);
        if (coin != null) {
            World world = getWorld();
            if (world instanceof GameWorld) {
                ((GameWorld) world).tambahPoin(10);
            } else if (world instanceof Level2World) {
                ((Level2World) world).tambahPoin(10);
            }
            getWorld().removeObject(coin);
        }
    }

    private void checkGate() {
        Gate gate = (Gate) getOneIntersectingObject(Gate.class);
        if (gate != null) {
            BaseWorld world = (BaseWorld) getWorld();
            if (world.getPoin() >= world.getTargetPoin()) {
                if (world instanceof GameWorld) {
                    Greenfoot.setWorld(new Level2World());
                } else if (world instanceof Level2World) {
                    Greenfoot.setWorld(new YouWinWorld());
                }
            } else {
                getWorld().showText("Poin belum cukup!", getWorld().getWidth() / 2, getWorld().getHeight() / 2);
            }
        }
    }

    private void moveHorizontally() {
        if (Greenfoot.isKeyDown("left")) {
            setLocation(getX() - 5, getY());
        }
        if (Greenfoot.isKeyDown("right")) {
            setLocation(getX() + 5, getY());
        }
    }
}
