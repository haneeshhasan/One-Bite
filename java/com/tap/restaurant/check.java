
package com.tap.restaurant;
import com.tap.secret.Decrypt;
import com.tap.secret.Encrypt;
public class check {
    public static void main(String[] args) {
        String original = "John Doe";
        
        // Encrypt the string
        String encrypted = Encrypt.encrypt(original);
        System.out.println("Encrypted: " + encrypted);
        
        // Decrypt the string
        String decrypted = Decrypt.decrypt(encrypted);
        System.out.println("Decrypted: " + decrypted);
        
        // Verify encryption and decryption
        if (original.equals(decrypted)) {
            System.out.println("Encryption and decryption work perfectly!");
        } else {
            System.out.println("Decryption failed. Expected: " + original + ", Got: " + decrypted);
        }
    }
}

