package com.example.project;
import java.util.Scanner;

public class Game{
    private Grid grid;
    private Player player;
    private Enemy[] enemies;
    private Treasure[] treasures;
    private Trophy trophy;
    private int size; 

    public Game(int size){ //the constructor should call initialize() and play()
        this.size=size;
        grid= new Grid(size);
        player= new Player(0,0,grid);
        initialize();
        grid.placeSprite(player);
       // play();
    }

    public static void clearScreen() { //do not modify
        try {
            final String os = System.getProperty("os.name").toLowerCase();
            if (os.contains("win")) {
                // Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Unix-based (Linux, macOS)
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void play(){ //write your game logic here
        Scanner scanner = new Scanner(System.in);
        boolean running=true;

        while(running){
            try {
                Thread.sleep(10); // Wait for 1/100 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            grid.display();
            System.out.println(player.getCoords());
            String directions= (scanner.nextLine());
            if(player.isValid(size, directions)){
            player.move(directions);
            if(grid.placeSprite(player, directions)){
                    break;
            }
        }
            clearScreen(); // Clear the screen at the beggining of the while loop
    }
    }

    public void initialize(){
        grid.display();  
    }

    public static void main(String[] args) {
        Game g= new Game(10);
        g.play();
    }
}