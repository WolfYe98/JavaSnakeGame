/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakegame;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author bateye
 */
public class Snake {
    private ArrayList<Point> puntos = new ArrayList();
    private Random r = new Random();
    private int orientacion = 0;
    
    public Snake(){
        puntos.add(new Point(0,100));
        puntos.add(new Point(0,110));
    }
    public ArrayList<Point> getPoints(){
        return puntos;
    }
    public void mover(int width, int height,int orient){
        Point lastHead = new Point(puntos.get(0));
        
        if(orient == orientacion){
            switch(orientacion){
                case 0:
                    if((int)puntos.get(0).getY()-10 < 0){
                        //puntos.get(0).move((int)puntos.get(0).getX(), height);
                        puntos.set(0, new Point((int)puntos.get(0).getX(), height));
                    }
                    else{
                        puntos.get(0).move((int)puntos.get(0).getX(), (int)puntos.get(0).getY()-10);
                    }
                    break;
                case 1:
                    if((int)puntos.get(0).getX()+10 > width){
                        puntos.get(0).move(0, (int)puntos.get(0).getY());
                    }
                    else{
                        puntos.get(0).move((int)puntos.get(0).getX()+10, (int)puntos.get(0).getY());
                    }
                    break;
                case 2:
                    if((int)puntos.get(0).getY()+10 > height){
                        puntos.get(0).move((int)puntos.get(0).getX(), 0);
                    }
                    else{
                        puntos.get(0).move((int)puntos.get(0).getX(), (int)puntos.get(0).getY()+10);
                    }
                    break;
                case 3:
                    if((int)puntos.get(0).getX()-10 < 0){
                        puntos.get(0).move(width, (int)puntos.get(0).getY());
                    }
                    else{
                        puntos.get(0).move((int)puntos.get(0).getX()-10, (int)puntos.get(0).getY());
                    }
                    break;
            }
        }
        else{
            switch(this.orientacion){
                case 0:
                    if(orient != 2){
                        puntos.get(0).move((int)puntos.get(0).getX(), (int)puntos.get(0).getY()-10);
                        this.orientacion = orient;
                    }
                    break;
                case 1:
                    if(orient != 3){
                        puntos.get(0).move((int)puntos.get(0).getX()+10, (int)puntos.get(0).getY());
                        this.orientacion = orient;
                    }
                    break;
                case 2:
                    if(orient != 0){
                        puntos.get(0).move((int)puntos.get(0).getX(), (int)puntos.get(0).getY()+10);
                        this.orientacion = orient;
                    }
                    break;
                case 3:
                    if(orient != 1){
                        puntos.get(0).move((int)puntos.get(0).getX()-10, (int)puntos.get(0).getY());
                        this.orientacion = orient;
                    }
                    break;
            }
        }
        for(int i = puntos.size()-1; i > 0; i--){
            if(i-1>0){
                puntos.set(i, puntos.get(i-1));
            }
            else{
                puntos.set(i, lastHead);
            }
        }
    }
    public int getOrientacion(){
        return orientacion;
    }
        
    public void addbody(){
        Point last = puntos.get(puntos.size()-1);
        Point beforeLast = puntos.get(puntos.size()-2);
        if( (last.getX() == beforeLast.getX()) && (last.getY() != beforeLast.getY()) ){
            if(last.getY() > beforeLast.getY()){
                puntos.add(new Point((int)last.getX(),(int)last.getY()+10));
            }
            else{
                puntos.add(new Point((int)last.getX(),(int)last.getY()-10));
            }
        }
        else if((last.getX() != beforeLast.getX()) && (last.getY() == beforeLast.getY())){
            if(last.getX() > beforeLast.getX()){
                puntos.add(new Point((int)last.getX()+10,(int)last.getY()));
            }
            else{
                puntos.add(new Point((int)last.getX()-10,(int)last.getY()));
            }
        }
    }
}
