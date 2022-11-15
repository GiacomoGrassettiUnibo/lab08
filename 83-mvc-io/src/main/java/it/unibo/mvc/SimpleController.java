package it.unibo.mvc;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 *
 */
public final class SimpleController implements Controller {

    
    private String currentString;
    private String nextString;
    private List<String> history = new ArrayList<>();
    
    public SimpleController() {
        this.currentString = null;
        this.nextString = null;
    }

    @Override
    public void setNextStringToPrint(String string) {
        this.nextString = string;
    }

    @Override
    public String getNexStringToString() {
        return this.nextString;
    }

    
    @Override
    public List<String> getHistoryOfString() {
        List<String> tmpList = new ArrayList<>(this.history);
        return tmpList;
    }

    private void addStringOnHistory(String s){
        this.history.add(s);
    }

    @Override
    public String printCurrentString() throws IllegalStateException {
        if (currentString == null) {
            throw new IllegalStateException("La stringa è vuota");
        }
        this.addStringOnHistory(currentString);
        return currentString;
    }

}
