import javax.swing.*;
import java.awt.event.*;

public class startMenu{
    public static void main(String[] args){
        JFrame f = new JFrame("Pick a mode");
        JButton singlePlayer = new JButton("Break the targets");
        JButton multiPlayer = new JButton("Player vs Player");
        singlePlayer.setBounds(50,100,135,30);
        singlePlayer.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                javax.swing.SwingUtilities.invokeLater(new Game());
                f.setVisible(false);
            }
        });


        multiPlayer.setBounds(50,140,135,30);
        multiPlayer.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                javax.swing.SwingUtilities.invokeLater(new PvP());
                f.setVisible(false);
            }
        });


        f.add(singlePlayer);
        f.add(multiPlayer);
        f.setSize(400,400);
        f.setLayout(null);
        f.setVisible(true);
    }




    
}