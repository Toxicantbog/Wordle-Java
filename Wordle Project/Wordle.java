import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
public class Wordle
{
    public static void main(String[]args)
    {
        String filename = "words.txt";

        ArrayList<String> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) 
        {
            String line;
            while ((line = br.readLine()) != null) 
            {
                // Assuming each line in the file contains a 5-letter word
                if (line.length() == 5) 
                {
                    list.add(line);
                }
            }
        } catch (IOException e) 
        {
            e.printStackTrace();
        }

        int length = list.size();

        int randomNum = (int)(Math.random()*length);

        String wordGuess = list.get(randomNum);

        Scanner input = new Scanner(System.in);
        String guess = "";

        for(int i=0;i<6;i++)
        {
            if(guess.equals(wordGuess)==false)
            {
                System.out.print("Enter your word: ");
                guess = input.nextLine();

                for(int a=0;a<5;a++){
                    String letter = guess.substring(a,a+1);
                    if(letter.equals(wordGuess.substring(a,a+1)))
                    {
                        System.out.print("G");
                    }
                    else
                    {
                        boolean isY = false;
                        for(int b=0;b<5;b++)
                        {
                            if(a!=b&&isY!=true)
                            {
                                if(letter.equals(wordGuess.substring(b,b+1)))
                                {
                                    System.out.print("Y");
                                    isY=true;
                                }
                            }
                        }
                        if(isY==false)
                        {
                            System.out.print("R");
                        }
                    }
                }
                System.out.println();
            }
        }
        if(guess.equals(wordGuess))
        {
            System.out.print("YOU WIN");
        }
        else
        {
            System.out.println("Failed");
            System.out.print("Correct word: ");
            System.out.print(wordGuess);
        }
        input.close();
    }
}
