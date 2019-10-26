package encryptdecrypt;

public class Decrypt implements EncryptDecrypt {

    @Override
    public  char[] processMessage(String message, int n, String alg) {
        char[] array = new char[message.length()];
        if (alg.equals("unicode")) {
            for (int i = 0; i < message.toCharArray().length; i++) {
                int code = message.toCharArray()[i] - n;
                array[i] = (char) code;
            }
        } else {
            char[] alphabet = Services.getAlphabet();
            for (int i = 0; i < message.toCharArray().length; i++) {
                if (Character.isLetter(message.toCharArray()[i])) {
                    int index =  Services.getAlphabetPosition(message, alphabet, i);
                    // check if position requires a backward circle to the alphabet
                    if (index - n < 0) {
                        // if index - n is smaller than one backward circle to the alphabet
                        // calculate how many circles are needed.
                        int difference = Math.abs(index - n) ;
                        if (difference > alphabet.length) {
                            int resto = difference % alphabet.length;
                            array[i] = Character.toLowerCase(alphabet[alphabet.length - resto]);
                            resto = 0;
                        } else {
                            array[i] = Character.toLowerCase(alphabet[alphabet.length - difference]);
                        }
                    } else {
                        array[i] = Character.toLowerCase(alphabet[index - n]);
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
