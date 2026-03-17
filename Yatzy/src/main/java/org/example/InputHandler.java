package org.example;

import java.util.Scanner;

public class InputHandler {
    private Scanner in ;

    public InputHandler(){
        this.in = new Scanner(System.in);
    }
    public String getString() {
        String input;
        input = in.nextLine();
        return input;
    }

    public String getAndValidateString(String instructions) {
        while (true) {
            System.out.println(instructions);
            String input = this.in.nextLine();
            System.out.println("Is this correct: " + input + " (y/n)");
            String answer = in.nextLine();
            if (answer.charAt(0) == 'y' || answer.charAt(0) == 'Y') {
                return input;
            }
        }
    }

    public int getAndValidateInt(String instruction){
        while (true) {
            System.out.println(instruction);
            String line = in.nextLine();
            int input;
            try {
                input = Integer.parseInt(line);
            } catch (NumberFormatException e) {
               System.out.println("Not an integer");
               continue;
            }
            System.out.println("Is this correct " + input +  " (y/n)");
            String answer = in.nextLine();
            if (answer.charAt(0) == 'y' || answer.charAt(0) == 'Y') {
                return input;
            }
        }

    }

}
