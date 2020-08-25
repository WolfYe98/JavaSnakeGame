/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakegame;
import java.util.Random;
/**
 *
 * @author bateye
 */
public class Apple {
    private int applex;
    private int appley;
    Random r = new Random();
    public Apple(int width, int height){
        applex = r.nextInt(width);
        appley = r.nextInt(height);
    }
    public int getX(){
        return applex;
    }
    public int getY(){
        return appley;
    }
    public void change(int width, int height){
        applex = r.nextInt(width);
        appley = r.nextInt(height);
    }
}
