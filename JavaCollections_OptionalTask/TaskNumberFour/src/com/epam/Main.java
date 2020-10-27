package com.epam;

import com.epam.poem.Poem;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        String pathToPoem = "C:\\Users\\Iam\\Documents\\JavaTasks" +
                "\\JavaCollections_OptionalTask\\TaskNumberFour\\poem.txt";

        Poem poem = new Poem(pathToPoem);
        poem.printOutSortedText();
    }
}