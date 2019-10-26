package encryptdecrypt;

public class Services {

    public static char[] getAlphabet() {
        char[] alphabet = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        return alphabet;
    }

    public static int getAlphabetPosition(String message, char[] alphabet, int i) {
        int index = -1;
        for (int ai = 0; ai < alphabet.length; ai++) {
            if (alphabet[ai] == message.toCharArray()[i]) {
                index = ai;
                break;
            }
        }
        return index;
    }
}
