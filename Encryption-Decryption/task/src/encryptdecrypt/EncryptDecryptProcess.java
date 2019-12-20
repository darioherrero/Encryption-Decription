package encryptdecrypt;

public class EncryptDecryptProcess {
    private EncryptDecrypt method;
    private String message;
    private int n;
    private String alg;

    public void setMethod(EncryptDecrypt method) {
        this.method = method;
    }

    public char[] processMesage(String message, int n, String alg) {
        return this.method.processMessage(message, n, alg);
    }
}
