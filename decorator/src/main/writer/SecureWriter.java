/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.writer;

import java.io.FileInputStream;
import java.security.Key;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Eero
 */
public class SecureWriter extends WriterDecorator {
    
    private final int cipherMode = Cipher.ENCRYPT_MODE;
    private final String cipherProperties = "src/main/cipher.properties";
    private String key;
    
    public SecureWriter(Writer w) {
        super(w);
        Properties p = new Properties();
        try {
            p.load(new FileInputStream(cipherProperties));
            key = p.getProperty("key");
        } catch (Exception ex) {
            Logger.getLogger(SecureWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void write(byte[] bArr) {
        super.write(encrypt(bArr));
    }

    private byte[] encrypt(byte[] bArr) {
        try {
            Key secretKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(cipherMode, secretKey);
            bArr = cipher.doFinal(bArr);
            return bArr;
        } catch (Exception ex) {
            Logger.getLogger(SecureWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
