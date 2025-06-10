import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Platform here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Platform extends Actor {
    public Platform() {
        GreenfootImage img = new GreenfootImage("platform.png");
        img.scale(600, 30); // ubah ukuran sesuai kebutuhan
        setImage(img);
    }
}

