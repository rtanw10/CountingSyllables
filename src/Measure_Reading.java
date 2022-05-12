import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;


public class Measure_Reading {
    public static void main(String[] args) {
        String word = "aditya";
        int syllables = countSyllables(word);
        System.out.println(word + " has " + syllables + " syllables.");
    }
    public static int countSyllables(String word){
        int counter = 0;
        String vowels = "aeiouy";
        for (int i = 0; i < word.length()-1; i++) {
            if(i == 0 && (vowels.contains(word.substring(i,i+1)))){
                counter++;
            }
            else if(vowels.contains(word.substring(i,i+1))){
                for (int j = 0; j < word.indexOf(i)-1; j++) {
                    if(word.substring(j, j+1).contains(vowels)){
                        counter++;
                    }
                }
            }
            else if(!(word.substring(i, i+1).contains(vowels))){
                if(vowels.contains(word.substring(i+1,i+2))){
                    counter++;
                }
            }
        }
        return counter;
    }
    public static String readFileAsString(String filename){
        Scanner scanner;
        StringBuilder output = new StringBuilder();
        try{
            scanner = new Scanner(new FileReader(filename));
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                output.append(line.trim());
            }
        }
        catch(FileNotFoundException e){
            System.out.println("File not found " + filename);
        }
        return output.toString();
    }

}
