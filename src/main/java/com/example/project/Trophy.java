package com.example.project;

//only needs a constructor
public class Trophy extends Treasure { //child of trophy
    public Trophy(int x, int y){
        super(x,y, "📀");
    }

    public Trophy(int x, int y, Grid g){//creates a trophy insance and places it in grid
        super(x,y, "📀");
        g.placeSprite(this);
    }
}
