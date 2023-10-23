package Gradle.Dependencies.app.build.app.Dependency;

import java.io.IOException;
import java.io.File;
import java.nio.file.Files;

public class Main {
    public void createFile(){
        String fileName = "newfile.txte";
        File file = new File(fileName);

        String content = "text content";

        try{
            Files.write(content.getBytes(), file);
        } catch (IOException exception){
            return;
        }
    }

    public static void main(String[] args){
        new Main().createFile();
    }
}
