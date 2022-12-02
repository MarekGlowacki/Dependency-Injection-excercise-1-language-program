package com.example.demo;

import org.springframework.stereotype.Service;
@Service
public class Encryption {

    public static final int ascii_encrypt = 3;
    public static char letter;
    public static int ascii = 0;
    public static String encrypted_statment = "";
    public static String decrypted_statment = "";


    static String encrypt(String sentence_to_encrypt) {

        encrypted_statment = "";

        for (int i = 0; i < sentence_to_encrypt.length(); i++) {
            letter = sentence_to_encrypt.charAt(i);
            ascii = letter;

            if (ascii > 32 && ascii < 127) {
                ascii += ascii_encrypt;
                if (ascii > 126) {
                    if (ascii == 127) {
                        ascii = 211;
                    } else if (ascii == 128) {
                        ascii = 243;
                    } else {
                        ascii = 260;
                    }
                }
            } else if (ascii == 211) {
                ascii = 261;
            } else if (ascii == 243) {
                ascii = 262;
            } else if (ascii == 260) {
                ascii = 263;
            } else if (ascii == 261) {
                ascii = 280;
            } else if (ascii == 262) {
                ascii = 281;
            } else if (ascii == 263) {
                ascii = 321;
            } else if (ascii == 280) {
                ascii = 322;
            } else if (ascii == 281) {
                ascii = 323;
            } else if (ascii == 321) {
                ascii = 324;
            } else if (ascii == 322) {
                ascii = 346;
            } else if (ascii == 323) {
                ascii = 347;
            } else if (ascii == 324) {
                ascii = 377;
            } else if (ascii == 346) {
                ascii = 378;
            } else if (ascii == 347) {
                ascii = 379;
            } else if (ascii == 377) {
                ascii = 380;
            } else if (ascii == 378) {
                ascii = 33;
            } else if (ascii == 379) {
                ascii = 34;
            } else if (ascii == 380) {
                ascii = 35;
            }
            letterToEncryptedStatment();
        }

        return encrypted_statment;
    }

    static String decrypt(String sentence_to_decrypt) {

        decrypted_statment = "";

        for (int i = 0; i < sentence_to_decrypt.length(); i++) {

            letter = sentence_to_decrypt.charAt(i);
            ascii = letter;

            if (ascii > 32 && ascii < 127) {
                ascii -= ascii_encrypt;
                if (ascii < 33) {
                    if (ascii == 32) {
                        ascii = 380;
                    } else if (ascii == 31) {
                        ascii = 379;
                    } else {
                        ascii = 378;
                    }
                }
            } else if (ascii == 211) {
                ascii = 124;
            } else if (ascii == 243) {
                ascii = 125;
            } else if (ascii == 260) {
                ascii = 126;
            } else if (ascii == 261) {
                ascii = 211;
            } else if (ascii == 262) {
                ascii = 243;
            } else if (ascii == 263) {
                ascii = 260;
            } else if (ascii == 280) {
                ascii = 261;
            } else if (ascii == 281) {
                ascii = 262;
            } else if (ascii == 321) {
                ascii = 263;
            } else if (ascii == 322) {
                ascii = 280;
            } else if (ascii == 323) {
                ascii = 281;
            } else if (ascii == 324) {
                ascii = 321;
            } else if (ascii == 346) {
                ascii = 322;
            } else if (ascii == 347) {
                ascii = 323;
            } else if (ascii == 377) {
                ascii = 324;
            } else if (ascii == 378) {
                ascii = 346;
            } else if (ascii == 379) {
                ascii = 347;
            } else if (ascii == 380) {
                ascii = 377;
            }
            letterToDecryptedStatment();

        }
        System.out.println("Your decykrypt sentence is: " + decrypted_statment + "\n");
        System.out.println("Press \"e\" to encrypt next sentence, \"d\" to decrypt next sentence or \"-\" to end program:");

        return decrypted_statment;
    }

    public static void letterToEncryptedStatment(){
        letter = (char) ascii;
        encrypted_statment += letter;
    }

    public static void letterToDecryptedStatment(){
        letter = (char) ascii;
        decrypted_statment += letter;
    }

}