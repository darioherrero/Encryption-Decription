package encryptdecrypt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String mode = "enc";
        String key = "0";
        String data = null;
        String in = null;
        String out = null;
        String alg = "shift";
        for(int i=0; i<args.length; i+=2) {
            if(args[i].equals("-mode")) {
                mode = args[i + 1];
            } else if(args[i].equals("-key")) {
                key = args[i + 1];
            } else if(args[i].equals("-data")){
                data = args[i + 1];
            } else if(args[i].equals("-in")) {
                in = args[i + 1];
            } else if(args[i].equals("-out")) {
                out = args[i + 1];
            } else if(args[i].equals("-alg")) {
                alg = args[i + 1];
            }
        }

        if (data == null && in == null) {
            data = "";
        } else if (data == null && in != null) {
            File file = new File(in);
            try (Scanner scanner = new Scanner(file)) {
                data = scanner.nextLine();
            } catch (FileNotFoundException e) {
                System.out.println("Error - No file found: " + in);
            }
        }

        EncryptDecryptProcess encryptDecryptProcess = new EncryptDecryptProcess();

        char[] message;
        if (mode.equals("enc")) {
            encryptDecryptProcess.setMethod(new Encrypt());
        } else {
            encryptDecryptProcess.setMethod(new Decrypt());
        }
        message = encryptDecryptProcess.processMesage(data, Integer.parseInt(key), alg);

        if(out != null) {
            File file = new File(out);
            try (FileWriter writer = new FileWriter(out)) {
                writer.write(message);
            } catch (IOException e) {
                System.out.printf("Error writing file");
            }
        } else {
            System.out.println(message);
        }
    }
}
