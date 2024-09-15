import java.util.HashMap;
import java.util.Random;

public class dataBaseS {


    static HashMap<String, String> accounts = new HashMap<String,String>();

    static void add_account(){
        Random rand = new Random();


        // create a string of uppercase and lowercase characters and numbers
        String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ$#@!";
        String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz@#$%^&";
        String numbers = "0123456789";

        String all_possible_char = upperAlphabet+lowerAlphabet+numbers;
        int number_max = rand.nextInt(all_possible_char.length());

        System.out.print(number_max);


        accounts.put("admin", "admin123!@#");
        for(int i = 0; i < number_max - 14; i++){
            // Create 100 users with different usernames & password;
            StringBuilder v = new StringBuilder();

            v.append(String.valueOf(all_possible_char.charAt(i)).repeat(10));

//     /*       value += upperAlphabet; */
            accounts.put("User"+i, v.toString());


            /* */
        }

        System.out.print(accounts);




    }
    public static void main(String[] args){
        add_account();

    }




}


