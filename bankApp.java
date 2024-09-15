
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class bankApp extends Main{

    private static double money = 0;

    public static double printValue(){
        return money;
    }

    public static void withdrawl(double moneyW){
        money -= moneyW;
    }

    public static void Deposit(Double moneyD){
        money = moneyD;
    }

    public static void bankApp(){



        JFrame window_bank = new JFrame();
        window_bank.setSize(500,500);

        showMessageDialog(window_bank,"There is no transfer method as of now!");

        JLabel username = new JLabel("Hello USER!");
        JLabel value = new JLabel("Current Value $" + money);

        JLabel deposit_label = new JLabel("Deposit: ");
        JLabel withdrawl_label = new JLabel("Withdrawl");



        JTextField deposit_amount = new JTextField("Enter amount to deposit");
        JTextField withdrawl_amount = new JTextField("Enter amount to withdrawl");

        JButton button_deposit = new JButton("Submit Deposit");
        JButton button_withdrawl = new JButton("Submit Withdrawl");




        username.setBounds(25, 10, 250, 250);
        value.setBounds(25, 60,250,200);
        deposit_label.setBounds(40, 150, 250,250);
        withdrawl_label.setBounds(40,200,250,250);

        deposit_amount.setBounds(95,260,95,25);
        withdrawl_amount.setBounds(110,310,95,25);

        button_deposit.setBounds(200,260,140,20);
        button_withdrawl.setBounds(220, 310, 140,20);

        button_deposit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double user_deposit_value = Double.parseDouble(deposit_amount.getText());
                Deposit(user_deposit_value);
                showMessageDialog(window_bank, "You have deposit $" + user_deposit_value);
            }
        });

        button_withdrawl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double user_withdrawl_value = Double.parseDouble(withdrawl_amount.getText());
                double value = printValue();
                if(user_withdrawl_value > value){
                    showMessageDialog(window_bank, "Can't withdrawl more money than what you");
                }
                else{
                    withdrawl(user_withdrawl_value);
                    showMessageDialog(window_bank, "You have withdrawl " + user_withdrawl_value);
                }
            }
        });



        window_bank.add(button_deposit);
        window_bank.add(button_withdrawl);
        window_bank.add(withdrawl_label);
        window_bank.add(withdrawl_amount);
        window_bank.add(deposit_amount);
        window_bank.add(deposit_label);


        window_bank.add(username);
        window_bank.add(value);

        window_bank.setTitle("Banking Application");
        window_bank.setLayout(null);
        window_bank.setVisible(true);




    }

    public static void main(String[] args){

        if(true){
            bankApp();
        }

    }
}
