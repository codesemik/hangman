import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class Main {
	static Random random=new Random();
	static Scanner input=new Scanner(System.in);
	static int which, score=0,choiceArrays;
	static String retainedWord;
	static String furniture[] = {"banjo","gizmo", "phone", "glasses", "chairs", "icebox" , "flowerpot", "idol"};
	static String animal[]= {"budgie","goldfish","canary","tortoise", "duck","parrot","squirrel"};
	static String country[] = {"france", "germany","british","estonia","mexico","turkey"};
	static int life, correctlyKnownNumber=0;
	static String underline[]=new String[15];
	
	public static void main(String[] args) {
		playAgain();
		while (life>0) {
			System.out.println("\nEnter a letter");
			String letter=input.next().toLowerCase();
			
			boolean trueGuess = false;
			
			for(int i = 0; i<retainedWord.length();i++) {
				if(letter.charAt(0)==retainedWord.charAt(i)) {
					underline[i]=letter.charAt(0)+" ";
					trueGuess = true;
					correctlyKnownNumber++;
				}
			}
			if(!trueGuess) {
			life--;
			}
			System.out.println("Your remaining life: "+life);
			for(int i = 0; i< retainedWord.length();i++) {
			    if (underline[i] == null) {
                    underline[i] = "_ ";
                }
				System.out.print(underline[i]);
			}
			System.out.println();
			if(life==0) {
				System.out.println("\nGame Over!");
				score=0;
				System.out.println("Word: "+ retainedWord);
				System.out.print("Press e to replay...");
				String answer = input.next();
			
				if(answer.equalsIgnoreCase("e")) {
					System.out.println();
					playAgain();
				}else {
					System.out.println("You lost!");
					
					break;
				}
				
			}
			
			if (correctlyKnownNumber==retainedWord.length()) {
				System.out.println("\nGOOD JOB!");
				score = score + (life * correctlyKnownNumber * 5); // Puan hesaplanır.
                System.out.println("Score: " + score); // Puanı ekrana yazar.
                System.out.println("***********************");
                playAgain();
			}
			
		}
		
		
	}
	
	public static void playAgain() {
        life = 5;
        correctlyKnownNumber = 0;
        
        for (int i = 0; i < underline.length; i++) {
            underline[i] = null; 
        }
        
        choiceArrays = random.nextInt(3);
        
        switch (choiceArrays) {
            case 0:
            which = random.nextInt(furniture.length); 
            retainedWord = furniture[which];
            break;
        
            case 1:
            which = random.nextInt(animal.length); 
            retainedWord = animal[which];
            break;
        
            case 2:
            which = random.nextInt(country.length);
            retainedWord = country[which];
            break;
        }
        System.out.println("\nNew game has begun!"); 
	}
}
