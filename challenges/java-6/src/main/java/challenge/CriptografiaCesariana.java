package challenge;

public class CriptografiaCesariana implements Criptografia {

    public String encryptAndDecrypt(String texto, String mod) {
        int code = mod == "encrypt" ? 122 : 97;
        int newCode = mod == "encrypt" ? 99 : 120;

        String strLower = texto.toLowerCase();
        String result = "";
        if(texto.length() == 0) throw new IllegalArgumentException();
        if(texto == null) throw new NullPointerException();

        for(int i = 0; i < texto.length(); i++) {
            char letter = strLower.charAt(i);
            if(letter == ' '){
                result = result + " ";
            } else if ((letter >= '0') && (letter <= '9')) {
                result = result + letter;
            } else {
                int newAscii;
                int ascii = (int) letter;
                int operator = mod == "encrypt" ? ascii + 3 : ascii - 3;
                if(ascii == code) {
                    newAscii = newCode;
                } else {
                    newAscii = operator;
                }
                result = result + (char)newAscii;
            }
        }
        return result;
    }


    @Override
    public String criptografar(String texto) {
        return encryptAndDecrypt(texto, "encrypt");
    }

    @Override
    public String descriptografar(String texto) {
        return encryptAndDecrypt(texto, "decrypt");
    }
}
