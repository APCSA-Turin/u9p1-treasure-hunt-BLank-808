package com.example.project;

public class Sprite {
    private int x, y;
    public String sprite;

    public Sprite(int x, int y, String Sprite) {
        this.x = x;
        this.y = y;
        sprite= Sprite;
    }
    public Sprite(int x, int y) {
        this.x = x;
        this.y = y;
        sprite= "Sprite";
    }

    public int getX(){return x;}//returns current x pos based on 2d arry not standard
    public int getY(){return y;}
    public String getSprite(){return sprite;}

    public void setX(int X){
        x=X;
    }
    public void setY(int Y){
        y=Y;
    }

    public String getCoords(){ //returns the coordinates of the sprite ->"(x,y)"
        return "("+(x)+","+(y)+")";
    }

    public String getRowCol(int size){ //returns the row and column of the sprite -> "[row][col]"
        return "["+((size-1) -y)+"]["+(x)+"]";
    }
    

    public void move(String direction) { //you can leave this empty
        // Default behavior (can be overridden by subclasses)
    }

    public void interact() { //you can leave this empty
        // Default behavior (can be overridden by subclasses)
    }



}
