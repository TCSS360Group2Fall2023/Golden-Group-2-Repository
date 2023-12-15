package view;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Paths;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.DataIO;
import model.Main;
import model.Material;
import model.UserSettings;

/**
 * TCSS 360B
 * Team MVP - Deliverable 3
 * view.EditMaterialScreen.java
 * 
 * @author Nathan Grimsey
 *
 */
public class EditMaterialScreen extends NewScreen {
    private static final String title = "Edit Material";
    private static final JLabel categoryLabel = new JLabel("Category*");
    private final JFileChooser fileChooser = new JFileChooser();
    private JTextField categoryTextField = new JTextField();

    public EditMaterialScreen(int width, int height, Material material) {
        super(width, height, title, 2, "Price*");
        categoryLabel.setFont(Main.HEADING_TWO_FONT);
        categoryLabel.setForeground(Main.TEXT);
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 4;
        c.gridy = 1;
        c.gridwidth = 2;
        add(categoryLabel, c);
        categoryTextField.setFont(Main.BASE_FONT);
        categoryTextField.setBackground(Main.TEXT_BOX_BACKGROUND);
        categoryTextField.setForeground(Main.TEXT);
        c.gridy++;
        add(categoryTextField, c);
        nameTextField.setText(material.getName());
        fieldTwoTextField.setText(String.valueOf(material.getPrice()));
        categoryTextField.setText(material.getCategory());
        String description = material.getDescription();
        if (description != null) {
            descriptionTextField.setText(description);
        }
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String oldName = material.getName();
                String name = nameTextField.getText();
                String priceString = fieldTwoTextField.getText();
                String category = categoryTextField.getText();
                String newDescription = descriptionTextField.getText();
                if (!name.isEmpty() && !priceString.isEmpty() && !category.isEmpty()) {
                    int price;
                    try {
                        price = Integer.parseInt(priceString);
                        material.setName(name);
                        material.setPrice(price);
                        material.setCategory(category);
                        if (!newDescription.isEmpty()) {
                            material.setDescription(newDescription);
                        }
                        fileChooser.setSelectedFile(new File(Main.userSettings.getFilePathFromName(oldName, UserSettings.MATERIAL).toString()));
                        int returnVal;
                        returnVal = fileChooser.showSaveDialog(Main.BASE_FRAME);
                        if (returnVal == JFileChooser.APPROVE_OPTION) {
                            String exportPathString = fileChooser.getSelectedFile().toPath().toString();
                            if (!exportPathString.endsWith(".mat")) {
                                exportPathString += ".mat";
                            }
                            Main.userSettings.removeFromRecent(oldName, UserSettings.MATERIAL);
                            DataIO.saveMaterial(material, Paths.get(exportPathString));
                        }
                        Main.BASE_FRAME.resetToMaterials();
                    }
                    catch (Exception error) {
                        error.printStackTrace();
                    }
                }
                else {
                    inputError();
                }
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.BASE_FRAME.resetToMaterials();
            }
        });
    }

}
