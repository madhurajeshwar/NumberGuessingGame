import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import java.awt.*;
public class GuessingGame {
    private static final int min =1 , max=10;
    private static int chance =3;

    private static final  int  ourNumber =  min + (int)(Math.random()*(max-min)+1); //ourNumber would be anything between 1 and 100;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        /*Let Us Create a Frame Now and set its size*/
        JFrame ourWindowFrame = new JFrame();
    /*I want my application to close after the user hits  the close button so let us choose EXIT ON CLOSE*/
        ourWindowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //
        ourWindowFrame.setTitle("Guessing Game");
        ourWindowFrame.setSize(500,500);

//        I need a Panel to  choose my Components in the Window.
        JPanel myWindowPanel = new JPanel();
        ourWindowFrame.add(myWindowPanel);
        placeComponents(myWindowPanel);

        // I want my frame to be visible so setting its visibility to True
        ourWindowFrame.setVisible(true);
        myWindowPanel.setBackground(Color.cyan);


        //Displaying my initial Message in the frame
        JOptionPane.showMessageDialog(myWindowPanel,"You Have 3 chances to guess the number  your number range is between 1 and 10 . Number must be an integer");

        System.out.println("The number was "+ ourNumber+ " Better Luck next time");
    }

    private static void placeComponents(JPanel myWindowPanel) {
        myWindowPanel.setLayout(null); // we are designing our own layout so setting this to null
        JLabel myLabel = new JLabel("Enter your guess ");
        myLabel.setBounds(10,20,150,50);
        myWindowPanel.add(myLabel);


        //reading Input using the TextField lets give it a size of 26
        JTextField userInput = new JTextField(26);
        userInput.setBounds(170,20,175,30);
        userInput.setBackground(Color.black);
        userInput.setForeground(Color.white);
        myWindowPanel.add(userInput);

        JButton guess = new JButton("Guess");
        guess.setBounds(10,60,180,50);
        guess.setBorderPainted(true);
        guess.setForeground(Color.RED);
        myWindowPanel.add(guess);
        guess.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{


                        int guessNo = Integer.parseInt(userInput.getText());

                        boolean result = guessCheck(guessNo,ourNumber);
                        if(result){
                            JOptionPane.showMessageDialog(myWindowPanel,"Congrats! You guessed the number correctly.");
                            SwingUtilities.getWindowAncestor(myWindowPanel).dispose();;
                        }
                        else{
                            chance--;
                            if(chance>1) {
                                JOptionPane.showMessageDialog(myWindowPanel,"You have " + chance + " more chances left out of 3");
                            }
                            if(chance ==1){
                                JOptionPane.showMessageDialog(myWindowPanel,"Final chance to guess the number");
                            }

                        }
                    if(chance==0){
                        JOptionPane.showMessageDialog(myWindowPanel,"The number was " + ourNumber + " better Luck Next Time ! ");
                        SwingUtilities.getWindowAncestor(myWindowPanel).dispose();
                    }

                }
                catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(myWindowPanel, "Please enter a valid integer.");
                }finally {
                    userInput.setText("");

                }
            }
        });
    }

    public static boolean guessCheck(Integer guessNo ,Integer ourNumber){
        return guessNo.equals(ourNumber);
    }
}
