/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.reader;

import java.io.FileInputStream;
import java.security.Key;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import main.writer.SecureWriter;

/**
 *
 * @author Eero
 */
public class SecureReader extends ReaderDecorator {

    private final int cipherMode = Cipher.DECRYPT_MODE;
    private final String cipherProperties = "src/main/cipher.properties";
    private String key;

    public SecureReader(Reader r) {
        super(r);
        Properties p = new Properties();
        try {
            p.load(new FileInputStream(cipherProperties));
            key = p.getProperty("key");
        } catch (Exception ex) {
            Logger.getLogger(SecureWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public byte[] read() {
        return decrypt(super.read());
    }

    private byte[] decrypt(byte[] bArr) {
        try {
            Key secretKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(cipherMode, secretKey);
            return cipher.doFinal(bArr);
        } catch (Exception ex) {
        }
        return "Could not decrypt file.".getBytes();
    }
}
