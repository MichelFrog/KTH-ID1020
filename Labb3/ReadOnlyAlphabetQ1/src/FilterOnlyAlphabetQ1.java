import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FilterOnlyAlphabetQ1 {

    public static void main(String[] args) throws IOException {

        FileReader readTxtFile = new FileReader    
                ("/Users/michelouadria/Documents/GitHub/KTH-ID1020/Labb3/The Project Gutenberg EBook of A Tale of Two Cities.txt"); 
        
                
        FileWriter newFileOnlyAlphabet = new FileWriter 
                ("/Users/michelouadria/Documents/GitHub/KTH-ID1020/Labb3/Two Cities with only alphabet.txt");

            
              int i; 
              char charThatHasBeenRead;
              while ((i=readTxtFile.read()) != -1) {
                  charThatHasBeenRead = (char) i;
                  if(Character.isLetter(charThatHasBeenRead)) {
                      newFileOnlyAlphabet.write(charThatHasBeenRead);
                  }else if(charThatHasBeenRead == ' ') {
                      newFileOnlyAlphabet.write(charThatHasBeenRead);
                  }else if(charThatHasBeenRead == '\n') {
                      newFileOnlyAlphabet.write(charThatHasBeenRead);
                  }else {
                      newFileOnlyAlphabet.write(' ');
                  }
                  
              }
              
              FileReader NewFile = new FileReader    
                      ("/Users/michelouadria/Documents/GitHub/KTH-ID1020/Labb3/The Project Gutenberg EBook of A Tale of Two Cities.txt"); 

              
    }

    
    
}


