/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.security.provider;

import com.ibm.oti.security.provider.KeyStore$1;
import com.ibm.oti.security.provider.KeyStore$KeyStoreCertificate;
import com.ibm.oti.security.provider.KeyStore$KeyStoreEntry;
import com.ibm.oti.security.provider.KeyStore$KeyStoreKey;
import com.ibm.oti.util.Msg;
import com.ibm.oti.util.PasswordProtectedInputStream;
import com.ibm.oti.util.SHAOutputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.security.AccessController;
import java.security.Key;
import java.security.KeyStoreException;
import java.security.KeyStoreSpi;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.util.Arrays;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;

public class KeyStore
extends KeyStoreSpi {
    static final int RANDOM_BYTES;
    protected Hashtable database = new Hashtable();

    protected int getKeyStoreMagic() {
        return 77;
    }

    protected int getKeyStoreVersion() {
        return 2;
    }

    protected int getKeyStoreOldVeresion() {
        return 1;
    }

    private static byte[] digestPassword(char[] cArray) {
        SHAOutputStream sHAOutputStream = new SHAOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(sHAOutputStream);
        try {
            int n = 0;
            while (n < cArray.length) {
                dataOutputStream.write(cArray[n]);
                ++n;
            }
            dataOutputStream.flush();
            dataOutputStream.close();
        }
        catch (IOException iOException) {}
        return sHAOutputStream.getHashAsBytes();
    }

    protected static void writeCertificate(Certificate certificate, ObjectOutputStream objectOutputStream) {
        byte[] byArray = certificate.getEncoded();
        String string = certificate.getType();
        objectOutputStream.writeObject(string);
        objectOutputStream.writeObject(byArray);
    }

    protected static Certificate readCertificate(ObjectInputStream objectInputStream) {
        String string = (String)objectInputStream.readObject();
        byte[] byArray = (byte[])objectInputStream.readObject();
        CertificateFactory certificateFactory = CertificateFactory.getInstance(string);
        return certificateFactory.generateCertificate(new ByteArrayInputStream(byArray));
    }

    private static byte[] digestHeader(long l, byte[] byArray, char[] cArray) {
        SHAOutputStream sHAOutputStream = new SHAOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(sHAOutputStream);
        try {
            dataOutputStream.writeLong(l);
            dataOutputStream.write(byArray);
            int n = 0;
            while (n < cArray.length) {
                dataOutputStream.write(cArray[n]);
                ++n;
            }
            dataOutputStream.flush();
            dataOutputStream.close();
        }
        catch (IOException iOException) {}
        return sHAOutputStream.getHashAsBytes();
    }

    @Override
    public Enumeration engineAliases() {
        return this.database.keys();
    }

    @Override
    public boolean engineContainsAlias(String string) {
        return this.database.containsKey(string);
    }

    @Override
    public void engineDeleteEntry(String string) {
        this.database.remove(string);
    }

    @Override
    public Certificate engineGetCertificate(String string) {
        KeyStore$KeyStoreEntry keyStore$KeyStoreEntry = (KeyStore$KeyStoreEntry)this.database.get(string);
        if (keyStore$KeyStoreEntry != null) {
            if (keyStore$KeyStoreEntry instanceof KeyStore$KeyStoreCertificate) {
                return ((KeyStore$KeyStoreCertificate)keyStore$KeyStoreEntry).cert;
            }
            if (keyStore$KeyStoreEntry instanceof KeyStore$KeyStoreKey) {
                return ((KeyStore$KeyStoreKey)keyStore$KeyStoreEntry).chain[0];
            }
        }
        return null;
    }

    @Override
    public String engineGetCertificateAlias(Certificate certificate) {
        Enumeration enumeration = this.database.keys();
        while (enumeration.hasMoreElements()) {
            String string = (String)enumeration.nextElement();
            KeyStore$KeyStoreEntry keyStore$KeyStoreEntry = (KeyStore$KeyStoreEntry)this.database.get(string);
            Certificate certificate2 = null;
            if (keyStore$KeyStoreEntry == null) continue;
            if (keyStore$KeyStoreEntry instanceof KeyStore$KeyStoreCertificate) {
                certificate2 = ((KeyStore$KeyStoreCertificate)keyStore$KeyStoreEntry).cert;
            } else if (keyStore$KeyStoreEntry instanceof KeyStore$KeyStoreKey) {
                certificate2 = ((KeyStore$KeyStoreKey)keyStore$KeyStoreEntry).chain[0];
            }
            if (certificate2 == null || !certificate2.equals(certificate)) continue;
            return string;
        }
        return null;
    }

    @Override
    public Certificate[] engineGetCertificateChain(String string) {
        KeyStore$KeyStoreEntry keyStore$KeyStoreEntry = (KeyStore$KeyStoreEntry)this.database.get(string);
        if (keyStore$KeyStoreEntry != null && keyStore$KeyStoreEntry instanceof KeyStore$KeyStoreKey) {
            return ((KeyStore$KeyStoreKey)keyStore$KeyStoreEntry).chain;
        }
        return null;
    }

    @Override
    public Date engineGetCreationDate(String string) {
        KeyStore$KeyStoreEntry keyStore$KeyStoreEntry = (KeyStore$KeyStoreEntry)this.database.get(string);
        if (keyStore$KeyStoreEntry != null) {
            return keyStore$KeyStoreEntry.creationDate;
        }
        return null;
    }

    @Override
    public Key engineGetKey(String string, char[] cArray) {
        KeyStore$KeyStoreEntry keyStore$KeyStoreEntry = (KeyStore$KeyStoreEntry)this.database.get(string);
        if (keyStore$KeyStoreEntry != null && keyStore$KeyStoreEntry instanceof KeyStore$KeyStoreKey) {
            byte[] byArray = KeyStore.digestPassword(cArray);
            KeyStore$KeyStoreKey keyStore$KeyStoreKey = (KeyStore$KeyStoreKey)keyStore$KeyStoreEntry;
            if (keyStore$KeyStoreKey.key instanceof Key) {
                if (Arrays.equals(byArray, keyStore$KeyStoreKey.digest)) {
                    return (Key)keyStore$KeyStoreKey.key;
                }
                throw new UnrecoverableKeyException();
            }
        }
        return null;
    }

    @Override
    public boolean engineIsCertificateEntry(String string) {
        KeyStore$KeyStoreEntry keyStore$KeyStoreEntry = (KeyStore$KeyStoreEntry)this.database.get(string);
        if (keyStore$KeyStoreEntry == null) {
            return false;
        }
        return keyStore$KeyStoreEntry instanceof KeyStore$KeyStoreCertificate;
    }

    @Override
    public boolean engineIsKeyEntry(String string) {
        KeyStore$KeyStoreEntry keyStore$KeyStoreEntry = (KeyStore$KeyStoreEntry)this.database.get(string);
        if (keyStore$KeyStoreEntry == null) {
            return false;
        }
        return keyStore$KeyStoreEntry instanceof KeyStore$KeyStoreKey;
    }

    @Override
    public void engineLoad(InputStream inputStream, char[] cArray) {
        byte[] byArray;
        Object object;
        if (inputStream == null) {
            return;
        }
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        int n = dataInputStream.readInt();
        if (n != this.getKeyStoreMagic()) {
            throw new IOException(Msg.getString("K00fd"));
        }
        int n2 = dataInputStream.readInt();
        if (n2 != this.getKeyStoreVersion() && n2 != this.getKeyStoreOldVeresion()) {
            throw new IOException(Msg.getString("K00fd"));
        }
        long l = dataInputStream.readLong();
        byte[] byArray2 = new byte[32];
        dataInputStream.readFully(byArray2);
        byte[] byArray3 = new byte[20];
        dataInputStream.readFully(byArray3);
        if (cArray != null && !Arrays.equals(byArray3, (byte[])(object = KeyStore.digestHeader(l, byArray2, cArray)))) {
            throw new IOException(Msg.getString("K00fe"));
        }
        if (n2 == this.getKeyStoreOldVeresion()) {
            byArray = new String(cArray).getBytes();
            object = new ObjectInputStream(new PasswordProtectedInputStream(inputStream, byArray));
        } else {
            object = new ObjectInputStream(inputStream);
        }
        try {
            byArray = object;
            this.database = (Hashtable)AccessController.doPrivileged(new KeyStore$1(this, (ObjectInputStream)byArray));
            if (this.database == null) {
                throw new IOException("Error reading keystore");
            }
        }
        finally {
            ((ObjectInputStream)object).close();
        }
    }

    @Override
    public void engineSetCertificateEntry(String string, Certificate certificate) {
        KeyStore$KeyStoreEntry keyStore$KeyStoreEntry = (KeyStore$KeyStoreEntry)this.database.get(string);
        if (keyStore$KeyStoreEntry != null && keyStore$KeyStoreEntry instanceof KeyStore$KeyStoreKey) {
            throw new KeyStoreException(Msg.getString("K0185"));
        }
        this.database.put(string, new KeyStore$KeyStoreCertificate(certificate));
    }

    @Override
    public void engineSetKeyEntry(String string, byte[] byArray, Certificate[] certificateArray) {
        this.database.put(string, new KeyStore$KeyStoreKey(byArray, certificateArray));
    }

    @Override
    public void engineSetKeyEntry(String string, Key key, char[] cArray, Certificate[] certificateArray) {
        KeyStore$KeyStoreKey keyStore$KeyStoreKey = new KeyStore$KeyStoreKey(key, certificateArray);
        keyStore$KeyStoreKey.digest = KeyStore.digestPassword(cArray);
        this.database.put(string, keyStore$KeyStoreKey);
    }

    @Override
    public int engineSize() {
        return this.database.size();
    }

    @Override
    public void engineStore(OutputStream outputStream, char[] cArray) {
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        long l = System.currentTimeMillis();
        byte[] byArray = new byte[32];
        new SecureRandom().nextBytes(byArray);
        byte[] byArray2 = KeyStore.digestHeader(l, byArray, cArray);
        dataOutputStream.writeInt(this.getKeyStoreMagic());
        dataOutputStream.writeInt(this.getKeyStoreVersion());
        dataOutputStream.writeLong(l);
        dataOutputStream.write(byArray);
        dataOutputStream.write(byArray2);
        dataOutputStream.flush();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(this.database);
        objectOutputStream.close();
    }
}

