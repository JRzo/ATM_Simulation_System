import javax.swing.*;

import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class Main extends dataBaseS {
    
    private static boolean flag_bank = false;


    private static void set_bank(Boolean set){
        flag_bank = set;
    }


    public static boolean get_bank(){
        return flag_bank;
    }


    static HashMap<String, String> checking_user(String username, String password){
//        We will be checking the username
        HashMap<String, String> user_checked = new HashMap<String, String>();
        try{
            if(dataBaseS.accounts.containsKey(username)){
                if(dataBaseS.accounts.containsValue(password)){
                    showMessageDialog(null, "Successfull!");
                    set_bank(true);
                    bankApp.bankApp();


                }

            }
            else{
                showMessageDialog(null, "Can't login, talk to IT");
            }
        }
        catch  (Exception e){
            System.out.println("Errors==>" + e);
        }




        return user_checked;
    }

    static void start() {
        JFrame frame_app = new JFrame();

//        The label for the login interface
        JLabel login_label = new JLabel("Please Sign-in to enter your bank!");


        JLabel username_label = new JLabel("Username:");
        JLabel password_label = new JLabel("Password:");

        JTextField username_field = new JTextField("Enter Username");
        JTextField password_field = new JTextField("Enter Password");


        JButton button_submit = new JButton("Submit");

//        Making the frame visually

         username_label.setBounds(150,190,100,100);
         username_label.setVisible(true);
         password_label.setBounds(150,240,100,100);
         password_label.setVisible(true);

         login_label.setBounds(150, 30, 500,200);
         login_label.setVisible(true);

         username_field.setBounds(240, 230, 100,20);
         password_field.setBounds(240, 280, 100,20);
         username_field.setVisible(true);
         password_label.setVisible(true);


         button_submit.setBounds(380,200, 75, 100);
//        Button action listener to retrieve the text of the password & username text

        button_submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    dataBaseS.add_account();
                    checking_user(username_field.getText(), password_field.getText());

            }
        });

         frame_app.add(login_label);
         frame_app.add(username_label);
         frame_app.add(password_label);

         frame_app.add(button_submit);

         frame_app.add(username_field   );
         frame_app.add(password_field);

         frame_app.setTitle("Login Page");

         frame_app.setSize(700,800);
         frame_app.setLayout(null);
         frame_app.setVisible(true);


}

    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        start();



}}