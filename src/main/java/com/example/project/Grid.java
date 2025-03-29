package com.example.project;


//DO NOT DELETE ANY METHODS BELOW
public class Grid{
    private Sprite[][] grid;
    private int size;
    private int treasureCount=1;//initalizes minimum of 1 treasures
    private int monsters;
    private Trophy t;

    public Grid(int size) { //initialize and create a grid with all DOT objects
        grid= new Sprite[size][size];
        this.size=size;
        treasureCount+= size/2;//increases treasures in grid proportional to size with a minimum of 1
        monsters=treasureCount/2;
        for (int index = 0; index < grid.length; index++) {
            for (int i = 0; i < grid[0].length; i++) {
                placeSprite(new Dot(i, index));
            }
        }

        for(int i=0; i<=treasureCount; i++){
            int randX= (int)(size*Math.random());
            int randY=(int)(size*Math.random());
            if(grid[randX][randY] instanceof Dot){
            placeSprite(new Treasure(randX,randY));
            if(i==treasureCount){
                placeSprite(new Trophy(randX,randY));
                t=new Trophy(randX,randY);
            }
            }else{
                i--;
            }
        }

        for(int i=0; i<monsters; i++){
            int randX= (int)(size*Math.random());
            int randY=(int)(size*Math.random());
            if(grid[randX][randY] instanceof Dot){
            placeSprite(new Enemy(randX,randY));
            }else{
                i--;
            }
        }
    }

 
    public Sprite[][] getGrid(){return grid;}

    public Object getSpriteAt(int x, int y){//returns the sprite at position based on cordinets
        return grid[y][x];
    }

    public void placeSprite(Sprite s){ //place sprite in new spot
        grid[(size-1)-(s.getY())][s.getX()] = s;
    }

    public void placeSpritePrev(Sprite s, String direction){ //place sprite in new spot
        if(direction.equals("a")){
        grid[(size-1)-(s.getY())][s.getX()+1] = s;
        }
        if(direction.equals("d")){
            grid[(size-1)-(s.getY())][s.getX()-1] = s;
        }
        if(direction.equals("w")){
            grid[(size-1)-(s.getY()-1)][s.getX()] = s;
            }
        if(direction.equals("s")){
            grid[(size-1)-(s.getY()+1)][s.getX()] = s;
        }
    }

    public boolean placeSprite(Sprite s, String direction) { //place sprite in a new spot based on direction
        placeSpritePrev(new Dot(s.getX(), s.getY()), direction);//places dot in previus spot

        if(((s.getX()-1 == t.getX()|| s.getX()+1 == s.getX()) && t.getY() == s.getY())|| ((s.getY()-1 == t.getY()|| s.getY()+1 == s.getY()) && t.getX() == s.getX()))
        if (s instanceof Player){
            if(((Player)s).isValid(size, direction)){
            String condition=((Player)s).interact(size , direction, treasureCount, getSpriteAt(s.getX(), s.getY()));
            if(condition.equals("win")){
                placeSprite(new Dot(s.getX(), s.getY()));
                win();
                return true;
            }else if(condition.equals("lose")){
                gameover();
                return true;
            }
            }
        }
        placeSprite(s);
        return false;
    }


    public void display() { //print out the current grid to the screen 
        System.out.println();
        for (Sprite[] sprites : grid) {
            for (Sprite sprite : sprites) {
                System.out.print(sprite.getSprite() +" ");
            }
            System.out.println();
        }
    }
    
    public void gameover(){ //use this method to display a loss
        System.out.println("YOU LOSE");
    }

    public void win(){ //use this method to display a win 
        System.out.println("YOU WIN");
    }


}