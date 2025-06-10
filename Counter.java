import greenfoot.*;

public class Counter extends Actor {
    private int value = 0;
    private String text;

    public Counter(String prefix) {
        text = prefix;
        updateImage();
    }

    public void setValue(int newValue) {
        value = newValue;
        updateImage();
    }

    private void updateImage() {
        setImage(new GreenfootImage(text + value, 24, Color.WHITE, Color.BLACK));
    }
}
