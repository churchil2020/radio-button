import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PetDisplayApplication {
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Pet Display Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        // Create radio buttons for different pet types
        JRadioButton birdButton = new JRadioButton("Bird");
        JRadioButton catButton = new JRadioButton("Cat");
        JRadioButton dogButton = new JRadioButton("Dog");
        JRadioButton rabbitButton = new JRadioButton("Rabbit");
        JRadioButton pigButton = new JRadioButton("Pig");

        // Create a button group for radio buttons to ensure only one can be selected at a time
        ButtonGroup group = new ButtonGroup();
        group.add(birdButton);
        group.add(catButton);
        group.add(dogButton);
        group.add(rabbitButton);
        group.add(pigButton);

        // Create a panel to hold the radio buttons
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));
        panel.add(birdButton);
        panel.add(catButton);
        panel.add(dogButton);
        panel.add(rabbitButton);
        panel.add(pigButton);

        // Create a label to display the selected pet image
        JLabel petImageLabel = new JLabel();
        frame.add(panel);
        frame.add(petImageLabel);

        // Add action listeners to radio buttons
        birdButton.addActionListener(new PetButtonListener("bird.jpg", petImageLabel));
        catButton.addActionListener(new PetButtonListener("cat.jpg", petImageLabel));
        dogButton.addActionListener(new PetButtonListener("dog.jpg", petImageLabel));
        rabbitButton.addActionListener(new PetButtonListener("rabbit.jpg", petImageLabel));
        pigButton.addActionListener(new PetButtonListener("pig.jpg", petImageLabel));

        // Set up the frame and make it visible
        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    // Action listener for pet type buttons
    private static class PetButtonListener implements ActionListener {
        private final String petImageFileName;
        private final JLabel petImageLabel;

        public PetButtonListener(String petImageFileName, JLabel petImageLabel) {
            this.petImageFileName = petImageFileName;
            this.petImageLabel = petImageLabel;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // Load and display the corresponding pet image
            ImageIcon petImageIcon = new ImageIcon(petImageFileName);
            petImageLabel.setIcon(petImageIcon);
        }
    }
}
