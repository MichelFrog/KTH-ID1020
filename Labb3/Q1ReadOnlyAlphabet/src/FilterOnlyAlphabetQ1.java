import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
/*
 * A filter implementation that receives a text files. All letters, spaces and newlines are 
 * saved. Everything else is replaced by blank, ' '. All new lines of text is stored in a new 
 * text file.
 * @author michelouadria
 */
public class FilterOnlyAlphabetQ1 {

    public static void main(String[] args) throws IOException {

       FileReader inputFile = new FileReader(
                "/Users/michelouadria/Documents/GitHub/KTH-ID1020/Labb3/The Project Gutenberg EBook of A Tale of Two Cities.txt");

       //Allow readLine, not possible with FileReader
       BufferedReader readTxtFile = new BufferedReader(inputFile);
       
       //Write to this.
       FileWriter newFileOnlyAlphabet = new FileWriter(
               "/Users/michelouadria/Documents/GitHub/KTH-ID1020/Labb3/Two Cities with only alphabet.txt");

        String oneLine = readTxtFile.readLine();
        
        
        char charThatHasBeenRead;
        
        while (null != oneLine) {
            char[] charArray = new char[oneLine.length()];
            for(int i = 0; i < oneLine.length();i++) {
                charThatHasBeenRead = oneLine.charAt(i);
                if(oneLine.charAt(i) == ' ' || Character.isLetter(charThatHasBeenRead))
                charArray[i] = oneLine.charAt(i); 
                else
                    charArray[i] = ' ';
            }
            newFileOnlyAlphabet.write(charArray);
            newFileOnlyAlphabet.write('\n'); 
            oneLine = readTxtFile.readLine();
        }
        newFileOnlyAlphabet.close();
    }

}
