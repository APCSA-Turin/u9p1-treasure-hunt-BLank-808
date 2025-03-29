package com.example.project;

//DO NOT DELETE ANY METHODS BELOW
public class Player extends Sprite{
    private int treasureCount;
    private int numLives;
    private boolean win;

    public Player(int x, int y) { //set treasureCount = 0 and numLives = 2
        super(x, y, "🕴 ");
        treasureCount=0;
        numLives=2;
    }

    public Player(int x, int y, Grid g) { //set treasureCount = 0 and numLives = 2, and places it in created grid
        super(x, y, "🕴 ");
        treasureCount=0;
        numLives=2;
        g.placeSprite(this);
    }

    public int getTreasureCount(){return treasureCount;}
    public int getLives(){return numLives;}
    public boolean getWin(){return win;}

  
    //move method should override parent class, sprite
    @Override
    public void move(String direction) { //move the (x,y) coordinates of the player
    if(direction.equals("w")){//checks imput and if move is valid
        setY(getY()+1);
    }
    if(direction.equals("s")){//checks imput and if move is valid
        setY(getY()-1);
    }
    if(direction.equals("a")){//checks imput and if move is valid
        setX(getX()-1);
    }
    if(direction.equals("d")){//checks imput and if move is valid
        setX(getX()+1);
    }
    }


    public String interact(int size, String direction, int numTreasures, Object obj) { // interact with an object in the position you are moving to 
        if(obj instanceof Trophy){
            if(treasureCount== numTreasures){
                win=true;
                return "win";
            }
        }else if(obj instanceof Treasure){
            treasureCount++;
        }
        if(obj instanceof Enemy){
            numLives--;
            System.out.println("Yo watch out");
            if(numLives==0){
                return "lose";
            }
        }
        return "null";

    }


    public boolean isValid(int size, String direction){ //check grid boundaries
        if(direction.equals("w") && getY()+1 < size){
            return true;
        }
        if(direction.equals("s") && getY()-1 >= 0){
            return true;
        }
        if(direction.equals("a") && getX()-1 >= 0){
            return true;
        }
        if(direction.equals("d") && getX()+1 < size){
            return true;
        }
        return false;
    }

    @Override
    public String getCoords() {
        return "Player:" + super.getCoords();
    }

    @Override
    public String getRowCol(int size) {
        return "Player:" + super.getRowCol(size);
    }

   
}



