/*
 * Decompiled with CFR 0.152.
 */
package java.util.jar;

import com.ibm.oti.util.BASE64Decoder;
import com.ibm.oti.util.JarUtils;
import com.ibm.oti.util.Msg;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.util.AbstractList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map$Entry;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.jar.Attributes;
import java.util.jar.InitManifest;
import java.util.jar.JarEntry;
import java.util.jar.JarVerifier$VerifierEntry;
import java.util.jar.Manifest;
import java.util.zip.ZipEntry;

class JarVerifier {
    private String jarName;
    private Manifest man;
    private HashMap metaEntries = new HashMap(5);
    private Hashtable signatures = new Hashtable(5);
    private Hashtable certificates = new Hashtable(5);
    private Hashtable verifiedEntries = new Hashtable();

    JarVerifier(String string) {
        this.jarName = string;
    }

    JarVerifier$VerifierEntry initEntry(String string) {
        Object object;
        Object object2;
        Object object3;
        Object object4;
        Object[] objectArray;
        if (this.man == null || this.signatures.size() == 0) {
            return null;
        }
        Attributes attributes = this.man.getAttributes(string);
        if (attributes == null) {
            return null;
        }
        Vector vector = new Vector();
        Iterator iterator = this.signatures.entrySet().iterator();
        while (iterator.hasNext()) {
            objectArray = (Object[])iterator.next();
            object4 = (HashMap)objectArray.getValue();
            if (((HashMap)object4).get(string) == null) continue;
            object3 = (String)objectArray.getKey();
            object2 = JarVerifier.getSignerCertificates((String)object3, this.certificates);
            object = ((AbstractList)object2).iterator();
            while (object.hasNext()) {
                vector.add(object.next());
            }
        }
        if (vector.size() == 0) {
            return null;
        }
        objectArray = new Certificate[vector.size()];
        vector.toArray(objectArray);
        object4 = attributes.getValue("Digest-Algorithms");
        if (object4 == null) {
            object4 = "SHA SHA1";
        }
        object3 = new StringTokenizer((String)object4);
        while (((StringTokenizer)object3).hasMoreTokens()) {
            byte[] byArray;
            object2 = ((StringTokenizer)object3).nextToken();
            object = attributes.getValue(new StringBuffer(String.valueOf(object2)).append("-Digest").toString());
            if (object == null) continue;
            try {
                byArray = ((String)object).getBytes("ISO8859_1");
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {
                throw new RuntimeException(unsupportedEncodingException.toString());
            }
            try {
                return new JarVerifier$VerifierEntry(MessageDigest.getInstance((String)object2), byArray, (Certificate[])objectArray);
            }
            catch (NoSuchAlgorithmException noSuchAlgorithmException) {}
        }
        return null;
    }

    void addMetaEntry(String string, byte[] byArray) {
        this.metaEntries.put(string.toUpperCase(), byArray);
    }

    synchronized boolean readCertificates() {
        if (this.metaEntries == null) {
            return false;
        }
        Iterator iterator = this.metaEntries.keySet().iterator();
        while (iterator.hasNext()) {
            String string = (String)iterator.next();
            if (!string.endsWith(".DSA") && !string.endsWith(".RSA")) continue;
            this.verifyCertificate(string);
            if (this.metaEntries == null) {
                return false;
            }
            iterator.remove();
        }
        return true;
    }

    private void verifyCertificate(String string) {
        String string2;
        byte[] byArray;
        Object object;
        String string3 = new StringBuffer(String.valueOf(string.substring(0, string.lastIndexOf(46)))).append(".SF").toString();
        byte[] byArray2 = (byte[])this.metaEntries.get(string3);
        if (byArray2 == null) {
            return;
        }
        byte[] byArray3 = (byte[])this.metaEntries.get(string);
        try {
            object = JarUtils.verifySignature(new ByteArrayInputStream(byArray2), new ByteArrayInputStream(byArray3));
            if (object != null) {
                this.certificates.put(string3, object);
            }
        }
        catch (IOException iOException) {
            return;
        }
        catch (GeneralSecurityException generalSecurityException) {
            throw new SecurityException(Msg.getString("K00eb", this.jarName, string3));
        }
        object = new Attributes();
        HashMap hashMap = new HashMap();
        try {
            new InitManifest(new ByteArrayInputStream(byArray2), (Attributes)object, hashMap, null, "Signature-Version");
        }
        catch (IOException iOException) {
            return;
        }
        boolean bl = false;
        String string4 = ((Attributes)object).getValue("Created-By");
        if (string4 != null) {
            boolean bl2 = bl = string4.indexOf("signtool") != -1;
        }
        if ((byArray = (byte[])this.metaEntries.get("META-INF/MANIFEST.MF")) == null) {
            return;
        }
        String string5 = string2 = bl ? "-Digest" : "-Digest-Manifest";
        if (!this.verify((Attributes)object, string2, byArray, false)) {
            Iterator iterator = hashMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Map$Entry map$Entry = (Map$Entry)iterator.next();
                byte[] byArray4 = this.man.getChunk((String)map$Entry.getKey());
                if (byArray4 == null) {
                    return;
                }
                if (this.verify((Attributes)map$Entry.getValue(), "-Digest", byArray4, bl)) continue;
                throw new SecurityException(Msg.getString("K00ec", new Object[]{string3, map$Entry.getKey(), this.jarName}));
            }
        }
        this.metaEntries.put(string3, null);
        this.signatures.put(string3, hashMap);
    }

    void setManifest(Manifest manifest) {
        this.man = manifest;
    }

    void verifySignatures(JarVerifier$VerifierEntry jarVerifier$VerifierEntry, ZipEntry zipEntry) {
        byte[] byArray = jarVerifier$VerifierEntry.digest.digest();
        if (!MessageDigest.isEqual(byArray, BASE64Decoder.decode(jarVerifier$VerifierEntry.hash))) {
            throw new SecurityException(Msg.getString("K00ec", new Object[]{"META-INF/MANIFEST.MF", zipEntry.getName(), this.jarName}));
        }
        this.verifiedEntries.put(zipEntry.getName(), jarVerifier$VerifierEntry.certificates);
        if (zipEntry instanceof JarEntry) {
            ((JarEntry)zipEntry).certificates = (Certificate[])jarVerifier$VerifierEntry.certificates.clone();
        }
    }

    boolean isSignedJar() {
        return this.certificates.size() > 0;
    }

    private boolean verify(Attributes attributes, String string, byte[] byArray, boolean bl) {
        String string2 = attributes.getValue("Digest-Algorithms");
        if (string2 == null) {
            string2 = "SHA SHA1";
        }
        StringTokenizer stringTokenizer = new StringTokenizer(string2);
        while (stringTokenizer.hasMoreTokens()) {
            byte[] byArray2;
            MessageDigest messageDigest;
            String string3 = stringTokenizer.nextToken();
            String string4 = attributes.getValue(new StringBuffer(String.valueOf(string3)).append(string).toString());
            if (string4 == null) continue;
            try {
                messageDigest = MessageDigest.getInstance(string3);
            }
            catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                continue;
            }
            if (bl && byArray[byArray.length - 1] == 10 && byArray[byArray.length - 2] == 10) {
                messageDigest.update(byArray, 0, byArray.length - 1);
            } else {
                messageDigest.update(byArray, 0, byArray.length);
            }
            byte[] byArray3 = messageDigest.digest();
            try {
                byArray2 = string4.getBytes("ISO8859_1");
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {
                throw new RuntimeException(unsupportedEncodingException.toString());
            }
            return MessageDigest.isEqual(byArray3, BASE64Decoder.decode(byArray2));
        }
        return false;
    }

    Certificate[] getCertificates(String string) {
        Certificate[] certificateArray = (Certificate[])this.verifiedEntries.get(string);
        if (certificateArray == null) {
            return null;
        }
        return (Certificate[])certificateArray.clone();
    }

    void removeMetaEntries() {
        this.metaEntries = null;
    }

    public static Vector getSignerCertificates(String string, Map map) {
        Vector vector = new Vector();
        Certificate[] certificateArray = (Certificate[])map.get(string);
        if (certificateArray != null) {
            int n = 0;
            while (n < certificateArray.length) {
                vector.add(certificateArray[n]);
                ++n;
            }
        }
        return vector;
    }
}

