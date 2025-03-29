package com.example.project;

//Enemy only need constructor and getCoords() getRowCol()
public class Enemy extends Sprite { //child  of Sprite
    
    public Enemy(int x, int y) {
        super(x,y, "🧿");
    }

    public Enemy(int x, int y, Grid g) {//initalizes enemy and places it in grid
        super(x,y, "🧿 ");
        g.placeSprite(this);
    }



    //the methods below should override the super class 


    public String getCoords(){ //returns "Enemy:"+coordinates
        return "Enemy:"+ super.getCoords();
    }


    public String getRowCol(int size){ //return "Enemy:"+row col
    return "Enemy:" +super.getRowCol(size);
    }
}