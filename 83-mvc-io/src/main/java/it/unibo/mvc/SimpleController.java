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
        this.currentString = this.nextString;
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
    public void printCurrentString(String s) throws IllegalStateException {
        this.currentString = s;
        if (currentString == null || currentString.isEmpty()) {
            throw new IllegalStateException("La stringa e' vuota");
        }
        this.addStringOnHistory(currentString);
        System.out.println(currentString);
    }

}
