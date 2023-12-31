package view;

import java.awt.Image;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;

import model.Main;
import model.Tool;

/**
 * TCSS 360B
 * Team MVP - Deliverable 3
 * view.ProjectEntryRow.java
 * 
 * @author Nathan Grimsey
 *
 */
public class ProjectEntryRow {
    private static Image checkBoxDarkUnchecked;
    private static Image checkBoxDarkChecked;
    private static Image checkBoxLightUnchecked;
    private static Image checkBoxLightChecked;
    public ArrayList<CustomTextField> textFields = new ArrayList<>();
    public CustomButton updateButton = new CustomButton("Update", Main.TABLE_FONT);
    public CustomButton deleteButton = new CustomButton("Delete", Main.TABLE_FONT);
    public JLabel toolName;
    public JLabel toolPrice;
    public JCheckBox checkBox;

    /**
     * Creates a row of column texts fields with update and delete buttons.
     * 
     * @param columns the number of columns.
     * 
     * @author Nathan Grimsey
     */
    public ProjectEntryRow(int columns) {
        for (int i = 0; i < columns; i++) {
            textFields.add(new CustomTextField(Main.TABLE_FONT));
        }
        updateButton.setVisible(false);
    }

    /**
     * Creates a row of column texts fields with update and delete buttons, 
     * where there is a formatted date field at index datePosition.
     * 
     * @param columns the number of columns.
     * @param datePosition the index of the desired date field.
     * 
     * @author Nathan Grimsey
     */
    public ProjectEntryRow(int columns, int datePosition) {
        for (int i = 0; i < columns; i++) {
            if (i == datePosition) {
                textFields.add(new CustomTextField(new SimpleDateFormat("MM/dd/yyyy"), Main.TABLE_FONT));
            }
            else {                
                textFields.add(new CustomTextField(Main.TABLE_FONT));
            }
        }
        updateButton.setVisible(false);
    }

    /**
     * Creates a row of column texts fields with update and delete buttons, 
     * where there are number formatted text fields at quantityPosition and pricePosition.
     * 
     * @param columns the number of columns.
     * @param quantityPosition the index of a number field.
     * @param pricePosition the index of a number field.
     * 
     * @author Nathan Grimsey
     */
    public ProjectEntryRow(int columns, int quantityPosition, int pricePosition) {
        for (int i = 0; i < columns; i++) {
            if (i == quantityPosition || i == pricePosition) {
                textFields.add(new CustomTextField(NumberFormat.getIntegerInstance(), Main.TABLE_FONT));
            }
            else {                
                textFields.add(new CustomTextField(Main.TABLE_FONT));
            }
        }
        updateButton.setVisible(false);
    }

    /**
     * Creates a row of column labels for a Tool with a checkbox and delete button.
     * 
     * @param tool the tool to make labels for.
     * 
     * @author Nathan Grimsey
     */
    public ProjectEntryRow(Tool tool) {
        toolName = new JLabel(tool.getName());
        toolName.setFont(Main.TABLE_FONT);
        toolName.setForeground(Main.TEXT);
        toolPrice = new JLabel(String.valueOf(tool.getPrice()));
        toolPrice.setFont(Main.TABLE_FONT);
        toolPrice.setForeground(Main.TEXT);
        checkBox = new JCheckBox();
        checkBox.setFocusPainted(false);
        checkBox.setOpaque(false);
        try {
            checkBoxDarkUnchecked = ImageIO.read(getClass().getResource("/icons/DarkUnchecked.png"));
            checkBoxDarkChecked = ImageIO.read(getClass().getResource("/icons/DarkChecked.png"));
            checkBoxLightUnchecked = ImageIO.read(getClass().getResource("/icons/LightUnchecked.png"));
            checkBoxLightChecked = ImageIO.read(getClass().getResource("/icons/LightChecked.png"));
            if (Main.userSettings.getDarkMode()) {
                checkBox.setIcon(new ImageIcon(checkBoxDarkUnchecked));
                checkBox.setSelectedIcon(new ImageIcon(checkBoxDarkChecked));
            }
            else {
                checkBox.setIcon(new ImageIcon(checkBoxLightUnchecked));
                checkBox.setSelectedIcon(new ImageIcon(checkBoxLightChecked));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
