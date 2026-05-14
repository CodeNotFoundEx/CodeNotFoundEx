package c.prog.ch4;

public class P_32_Propozitia_c_ordine {
    static void main() {
        String body = "Muntele te cheama";
        String word = "Multe";

        int index = 0;
        for (int i = 0; i < body.length() && index<word.length(); i++) {
            if (body.charAt(i) == word.charAt(index)) {
                index++;
            }
        }
        if (index == word.length()) {
            System.out.println("The word is in the body");
        } else {
            System.out.println("The word is not in the body");
        }
    }

}

