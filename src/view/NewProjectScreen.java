package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Main;
import model.Project;

/**
 * TCSS 360B
 * Team MVP - Deliverable 3
 * view.NewProjectScreen.java
 * 
 * @author Nathan Grimsey
 *
 */
public class NewProjectScreen extends NewScreen {
    private static final String title = "Create a New Project";

    /**
     * Allows the user to create a new Project.
     * 
     * @param width of the panel.
     * @param height of the panel.
     * 
     * @author Nathan Grimsey
     */
    public NewProjectScreen(int width, int height) {
        super(width, height, title, 3, "Budget*");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fieldTwoTextField.fireAction();
                String name = nameTextField.getText();
                String budgetString = fieldTwoTextField.getText().replaceAll(",", "");
                String description = descriptionTextField.getText();
                if (!name.isEmpty() && !budgetString.isEmpty()) {
                    int budget = 0;
                    try {
                        budget = Integer.parseInt(budgetString);
                    }
                    catch (Exception error) {

                    }
                    Project newProject = new Project(name, budget);
                    if (!description.isEmpty()) {
                        newProject.setDescription(description);
                    }
                    Main.BASE_FRAME.openProject(newProject);
                }
                else {
                    inputError();
                }
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.BASE_FRAME.resetToProjects();
            }
        });
    }

}
