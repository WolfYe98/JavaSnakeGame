/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakegame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.Math;

/**
 *
 * @author bateye
 */
public class GamePanel extends javax.swing.JPanel implements ActionListener{

    /**
     * Creates new form GamePanel
     */
    private Apple a;
    private Snake s;
    private boolean run = false;
    private Timer t;
    private static final int DELAY = 75;
    private int orient = 0;
    public GamePanel() {
        initComponents(); 
        this.startGame();
    }
    public void paint(Graphics g){
        super.paint(g);
        g.setColor(Color.red);
        if(a != null){
            g.fillOval(a.getX(), a.getY(), 10, 10);
        }
        if(s != null){
            g.setColor(Color.green);
            for(Point i:s.getPoints()){
                g.fillRect((int)i.getX(), (int)i.getY(), 10, 10);
            }
        }
    }
    public void crearManzana(){
        a = new Apple(this.getWidth(),this.getHeight());
        this.repaint();
    }
    public void crearSnake(){
        s = new Snake();
        this.repaint();
    }
    public void startGame(){
        this.crearManzana();
        this.crearSnake();
        run = true;
        t = new Timer (DELAY, this); 
        t.start();
    }
    public void running(){
        this.checkManzanaComida();
        this.checkCollition();
        s.mover(this.getWidth(),this.getHeight(),this.orient);
        this.repaint();
    }
    public void setOrientacion(int orient){
        switch(this.s.getOrientacion()){
            case 0:
                if(orient != 2){
                    this.orient = orient;
                }
                break;
            case 1:
                if(orient != 3){
                    this.orient = orient;
                }
                break;
            case 2:
                if(orient != 0){
                    this.orient = orient;
                }
                break;
            case 3:
                if(orient != 1){
                    this.orient = orient;
                }
                break;
        }
    }
    public Snake getSnake(){
        return s;
    }
    public void checkManzanaComida(){
        if( (Math.abs((int)s.getPoints().get(0).getX()-a.getX())<=7) && (Math.abs((int)s.getPoints().get(0).getY()-a.getY())<=7)){
            s.addbody();
            a.change(this.getWidth(), this.getHeight());
        }
    }
    public void checkCollition(){
        int x = (int)this.s.getPoints().get(0).getX();
        int y = (int)this.s.getPoints().get(0).getY();
        for(int i = this.s.getPoints().size()-1; i > 0; i--){
            if( ((int)this.s.getPoints().get(i).getX() == x) && ((int)this.s.getPoints().get(i).getY() == y)){
                this.run = false;
                this.t.stop();
            }
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(0, 0, 0));
        setSize(new java.awt.Dimension(400, 300));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        setLayout(new java.awt.GridBagLayout());
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_formKeyPressed

    @Override
    public void actionPerformed(ActionEvent e) {
        if(run){
           this.running();
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
