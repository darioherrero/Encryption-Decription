package encryptdecrypt;

public class Encrypt implements EncryptDecrypt {
    @Override
    public char[] processMessage(String message, int n, String alg) {
        char[] array = new char[message.length()];
        if (alg.equals("unicode")) {
            for (int i = 0; i < message.toCharArray().length; i++) {
                int code = message.toCharArray()[i] + n;
                array[i] = (char) code;
            }
        } else {
            char[] alphabet =  Services.getAlphabet();
            for (int i = 0; i < message.toCharArray().length; i++) {
                if (Character.isLetter(message.toCharArray()[i])) {
                    int index =  Services.getAlphabetPosition(message, alphabet, i);
                    // check if position requires a circle to the alphabet
                    if (index + n >= alphabet.length) {
                        // if index + n is bigger than one circle to the alphabet
                        // calculate how many circles are needed.
                        if ((index + n - alphabet.length) > alphabet.length) {
                            int resto = (index + n) % alphabet.length;
                            array[i] = alphabet[resto];
                            resto = 0;
                        } else {
                            array[i] = alphabet[index + n - alphabet.length];
                        }
                    } else {
                        array[i] = alphabet[index + n];
                    }
                } else {
                    // if it is a number, it is set without conversion.
                    array[i] = message.toCharArray()[i];
                }
            }
        }
        return array;
    }
}
