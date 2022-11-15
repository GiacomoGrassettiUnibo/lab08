package it.unibo.mvc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {

    private static final String DEFAULT_FILE_PATH = System.getProperty("user.home") + System.getProperty("file.separator");
    private static final String DEFAULT_FILE_NAME = "output.txt";
    private File currentFile;

    public Controller() {
        this.currentFile = new File(DEFAULT_FILE_PATH + DEFAULT_FILE_NAME);
    }

    public void setCurrentFile(File file){
        this.currentFile = file;
    }

    public File getCurreFile() {
        return this.currentFile;
    }

    public String getFilePath() {
        return this.currentFile.getPath();
    }

    public void writeOnFile(final String content) {
        try (
            BufferedWriter writer = new BufferedWriter( new FileWriter( this.currentFile ) );  
        ) {
            writer.flush();
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage() + "\n" + e.getCause() );
        }
    }

}
