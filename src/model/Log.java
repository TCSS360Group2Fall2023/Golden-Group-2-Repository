package model;

import java.awt.Image;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * TCSS 360B
 * Team MVP - Deliverable 3
 * model.Log.java
 *
 * @author Cody Dukes
 * @author Nathan Grimsey
 *
 */
public class Log implements Comparable<Log>, Serializable {
    private String name;
    private Date date;
    private String description;
    private List<Image> images;

    /**
     * Log constructs a Log object that contains a log name and log date.
     * 
     * @param date the date the Log was made.
     * @param name the name of the Log.
     *
     * @author Cody Dukes
     */
    public Log(Date date, String name) {
        this.date = date;
        this.name = name;
    }

    /**
     * getName returns the Log name.
     * 
     * @return the Log name.
     *
     * @author Cody Dukes
     */
    public String getName(){
        return name;
    }

    /**
     * sets the name of a Log.
     * 
     * @param name name to set Log to.
     *
     * @author Cody Dukes
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getDate returns the Log date.
     * 
     * @return the Log date.
     *
     * @author Cody Dukes
     */
    public Date getDate() {
        return date;
    }

    /**
     * sets the date of a Log.
     * 
     * @param date date Log was made.
     *
     * @author Cody Dukes
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * getDescription returns the Log description.
     * 
     * @return description the Log description.
     *
     * @author Cody Dukes
     */
    public String getDescription() {
        return description;
    }

    /**
     * sets the description of a Log.
     * 
     * @param description description of the Log.
     *
     * @author Cody Dukes
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * getImages returns the Log images.
     * 
     * @return images the Log images.
     *
     * @author Cody Dukes
     */
    public List<Image> getImages() {
        return images;
    }

    /**
     * sets the images of a Log.
     * 
     * @param images the images associated with a Log.
     *
     * @author Cody Dukes
     */
    public void setImages(List<Image> images) {
        this.images = images;
    }

    /**
     * Adds image to a Log.
     * 
     * @param image the image to add to the Log.
     *
     * @author Cody Dukes
     */
    public void addImage(Image image) {
        images.add(image);
    }

    /**
     * Compares this Log to another Log.
     * 
     * @param otherLog the Log to compare to.
     * @return result of the comparison.
     * 
     * @author Nathan Grimsey
     */
    @Override
    public int compareTo(Log otherLog) {
        if (otherLog == null) {
            return -1;
        }
        int compareVal = 0;
        compareVal += name.compareTo(otherLog.getName());

        if (compareVal != 0) {
            return compareVal;
        }

        compareVal += date.compareTo(otherLog.getDate());
        if (compareVal != 0) {
            return compareVal;
        }

        compareVal += description.compareTo(otherLog.getDescription());
        return compareVal;
    }
}
