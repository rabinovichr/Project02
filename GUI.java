package Project02;
import javax.swing.*;
import java.awt.*;

public class GUI extends Project02.World {

    public static void main(String[] args) {

        // Builds the frame of the GUI
        JFrame frame = new JFrame(); //creates a frame
        frame.setTitle("Warring Nations"); // sets a title
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit out of gui
        frame.setSize(500, 500); // sets the x-dimension and y-dimension
        frame.setResizable(false); // prevents the frame from being resized
        frame.setLayout(new GridLayout());
        frame.setVisible(true); // makes the frame visible

        // Sets all images used in the game
        ImageIcon gameLogo = new ImageIcon(); // creates an image icon for the game logo

        ImageIcon warrior = new ImageIcon(); // creates an image icon for warriors
        ImageIcon wizard = new ImageIcon(); // creates an image icon for wizards
        ImageIcon healer = new ImageIcon(); // creates an image icon for healers

        ImageIcon shield = new ImageIcon(); // creates an image icon for the shield artifact
        ImageIcon poison = new ImageIcon(); // creates an image icon for the poison artifact
        ImageIcon pit = new ImageIcon(); // creates an image icon for the instakill artifact
        ImageIcon trainer = new ImageIcon(); // creates an image icon for the trainer artifact

        frame.setIconImage(gameLogo.getImage()); // change icon of a frame

        Project02.World.encounter()







    }


}
