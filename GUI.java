package Project02;
import Project02.People;
import Project02.PeopleType;
import Project02.World;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class GUI extends Project02.Main implements ActionListener {

    public static boolean RIGHT_TO_LEFT = false;
    public static JButton next_button = new JButton();
    public static JFrame welcome_frame = new JFrame();
    public static JFrame game_frame = new JFrame("Warring Nations");



    public static void createWelcomeGui() {
        JButton artifact1 = new JButton();
        JButton artifact2 = new JButton();
        JButton artifact3 = new JButton();
        JButton artifact4 = new JButton();
        ImageIcon icon1 = new ImageIcon("Snake-pit.jpg");
        ImageIcon icon2 = new ImageIcon("Screen Shot 2021-04-30 at 12.06.54 PM.png");
        ImageIcon icon3 = new ImageIcon("Screen Shot 2021-04-30 at 12.07.16 PM.png");
        ImageIcon icon4 = new ImageIcon("Screen Shot 2021-04-30 at 12.07.43 PM.png");
        artifact1.setIcon(icon1);
        artifact1.setBounds(0, 0, 600, 500);
        artifact1.setVisible(true);
        artifact2.setIcon(icon2);
        artifact2.setBounds(0, 500, 600, 500);
        artifact2.setVisible(true);
        artifact3.setIcon(icon3);
        artifact3.setBounds(1300,0, 600, 500);
        artifact3.setVisible(true);
        artifact4.setIcon(icon4);
        artifact4.setBounds(1300, 500, 600, 900);
        artifact4.setVisible(true);
        welcome_frame.setResizable(true);
        welcome_frame.setSize(10000, 10000);
        welcome_frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        welcome_frame.setVisible(true);
        next_button.setText("Welcome! Click me to start the game");
        next_button.setBounds(800, 500, 250, 50);
        next_button.setVisible(true);
        welcome_frame.add(artifact1);
        welcome_frame.add(artifact2);
        welcome_frame.add(artifact3);
        welcome_frame.add(artifact4);
        welcome_frame.add(next_button);
        next_button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                welcome_frame.setVisible(false);
                //Create and set up the window.
                game_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                game_frame.setResizable(true);
                //Set up the content pane.
                addComponentsToPane(game_frame.getContentPane());
                //Use the content pane's default BorderLayout. No need for
                //setLayout(new BorderLayout());
                //Display the window.
                game_frame.pack();
                game_frame.setVisible(true);
            }
        });

    }


    public Image getScaledImage(Image srcImg, int w, int h) {
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();

        return resizedImg;
    }

    public static void addComponentsToPane(Container pane) {

        if (!(pane.getLayout() instanceof BorderLayout)) {
            pane.add(new JLabel("Container doesn't use BorderLayout!"));
            return;
        }

        if (RIGHT_TO_LEFT) {
            pane.setComponentOrientation(
                    java.awt.ComponentOrientation.RIGHT_TO_LEFT);
        }

        JButton title_button = new JButton("Warring Nations");
        pane.add(title_button, BorderLayout.PAGE_START);

        //Make the center component big, since that's the
        //typical usage of BorderLayout.
        JButton versus_button = new JButton("Damage: ");
        versus_button.setPreferredSize(new Dimension(200, 100));
        pane.add(versus_button, BorderLayout.CENTER);

        JButton person1_button = new JButton("Person: Nation: Tribe: Lifepoints: ");
        pane.add(person1_button, BorderLayout.LINE_START);

        next_button.setText("Next Match-Up!");
        next_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                next_button.setText("Next Match-Up was performed");
            }
        });
        pane.add(next_button, BorderLayout.PAGE_END);

        JButton person2_button = new JButton("Person: %sNation: %sTribe: %sLifepoints: %d");
        pane.add(person2_button, BorderLayout.LINE_END);
    }


    public static void createAndShowGameGUI() {

        //Create and set up the window.
        game_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game_frame.setResizable(true);
    //Set up the content pane.
    addComponentsToPane(game_frame.getContentPane());
    //Use the content pane's default BorderLayout. No need for
    //setLayout(new BorderLayout());
    //Display the window.
        game_frame.pack();
        game_frame.setVisible(true);
}

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
