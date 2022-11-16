package it.unibo.mvc;

import java.util.List;

/**
 *
 */
public interface Controller {

    /**
     * 
     * @param string
     */
    public void setNextStringToPrint(String string);

    /**
     * 
     * @return
     */
    public String getNexStringToString();

    /**
     * 
     * @return
     */
    public List<String> getHistoryOfString();

    /**
     * 
     * @throws IllegalStateException
     */
    public void printCurrentString(String s) throws IllegalStateException;
}
