package hangman;
//imports --------------------------------
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
//import java.io.*; 
//imports --------------------------------

public class HangMan {
    static String temp;

    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        
        String FinalWord = FindWord();
        String[] Display = new String[FinalWord.length()];
        //first printing the amount of letters to guess
        for (int i = 0; i < Display.length; i++) {
            Display[i]="*";
        }
        
        ArrayList<String> UsedLetters = new ArrayList<>();
        
        
        int guesses = 1;
        // setting the Array for hangman
        int PrintCount = 0;
        String[] HangedMan = new String[9];
        HangedMan[8] = "------- ";
        HangedMan[7] = "|   |   ";
        HangedMan[6] = "|   0   ";
        HangedMan[5] = "|  /||  ";
        HangedMan[4] = "|  / |  ";
        HangedMan[3] = "|       ";
        HangedMan[2] = "|       ";
        HangedMan[1] = "------- ";
        HangedMan[0] = "------- ";
        System.out.println("There are " +FinalWord.length()+ " letters to guess");
        for (String Display1 : Display) {
            System.out.print(Display1 + " ");
        }
        System.out.println();



        while (PrintCount!=9){
            boolean UsedLetter = false;
            while (!UsedLetter){
                System.out.print("Guess a letter: ");
                temp = input.next().toLowerCase();
                System.out.println("");
                int j=0;
                for (int i = 0; i < UsedLetters.size(); i++) {
                    if(UsedLetters.get(i).equals(temp.substring(0, 1))){
                        j++;
                    }
                }
                if (j>0){
                    System.out.println("You've already guessed this letter!");
                }else{
                   
                    UsedLetter=true;
                }
            }
            
            char guess = temp.charAt(0);
            int count = 0;
            
            //checks if the letter you inputted is in the String chosen
            for (int i = 0; i < FinalWord.length(); i++) {
                if (guess == FinalWord.charAt(i)){
                count++;
                Display[i]=temp.substring(0, 1);
                }
            }
            
            //prints 50 lines so you only see new/relevent information printed 
            for (int i = 0; i < 50; i++) {
                System.out.println(" ");
            }
            //---------------------------------------------------------------
            
            
            
            //if the entire word if guessed and breaks if it is 
            int check=0;
            for (String Display1 : Display) {
                if (!"*".equals(Display1)) {
                    check++;
                }
            }
            if (check==Display.length){
                break;
            }
            //------------------------------------------------

            System.out.println();
            if (count==0){
                PrintCount++;
                UsedLetters.add(temp.substring(0, 1));
                System.out.println("WRONG");
            }else{
                System.out.println("CORRECT");
                UsedLetters.add(temp.substring(0,1));
            }
   
            System.out.print("Used letters: ");
            for (int i = 0; i < UsedLetters.size(); i++) {
                System.out.print(UsedLetters.get(i)+" ");
            }
            System.out.println("");
            
            //prints out the letters you've guessed correctly so far
            for (String Display1 : Display) {
                System.out.print(Display1 + " ");
            }
            
            //printing out the hangedman one more line every time you guess somthing wrong 
            //it prints it from the bottom to the top 
            System.out.println();
            for (int i = 0; i < PrintCount; i++) {
                for (int j = 0; j < 50; j++) {
                    System.out.print(" ");
                }
                System.out.println(HangedMan[PrintCount-i-1]);
            }
            guesses++;
        }
        //-----------------------------------------------------------------------------------

        
        if (PrintCount ==9){
            System.out.println("You loose :(");
            System.out.println("the word was "  +FinalWord);
        }else {
            System.out.println("You win well done :)");
            System.out.println("the word was " +FinalWord+ "!");
            
            
            System.out.println("it took you " +guesses+ " guesses");
        }
        
    }
    public static String FindWord(){
        Random rand = new Random();
        Scanner inputFile = null;
        
        
        
        //getting a file with around 200 words to pick from randomly and then return that value
        try {
            //finds the words.txt file within the 'res' file in the folder 
            inputFile = new Scanner (new File("res/Words.txt"));
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
            System.exit(-1);
        }
        
        
        //adding all items in the list to the casted array list 
        ArrayList a = new ArrayList<>();
        while (inputFile.hasNext()){
            a.add(inputFile.next());
        }
        int RandomInt = rand.nextInt(a.size());
        
        
        // making sure that the string is all lowercase because it would ruin the program otherwise
        String Word =((String) a.get(RandomInt)).toLowerCase();
        //casting the list to strings because they're objects by default 
        return Word;
    }
}

