/*
 * Decompiled with CFR 0.152.
 */
package java.security;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.SocketPermission;
import java.net.URL;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.Enumeration;
import java.util.Hashtable;

public class CodeSource
implements Serializable {
    private static final long serialVersionUID;
    private URL location;
    private transient Certificate[] certificates;
    private transient Hashtable certificatesSet;

    public CodeSource(URL uRL, Certificate[] certificateArray) {
        this.location = uRL;
        if (certificateArray != null) {
            this.certificates = (Certificate[])certificateArray.clone();
            this.certificatesSet = new Hashtable(certificateArray.length * 3 / 2);
            int n = 0;
            while (n < certificateArray.length) {
                if (certificateArray[n] != null) {
                    this.certificatesSet.put(certificateArray[n], "ignored");
                }
                ++n;
            }
            if (this.certificatesSet.size() == 0) {
                this.certificatesSet = null;
            }
        }
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (super.getClass() != object.getClass()) {
            return false;
        }
        CodeSource codeSource = (CodeSource)object;
        URL uRL = this.getLocation();
        if (uRL == null ? codeSource.getLocation() != null : !uRL.equals(codeSource.getLocation())) {
            return false;
        }
        if (this.certificatesSet == null) {
            if (codeSource.certificatesSet != null) {
                return false;
            }
        } else {
            if (codeSource.certificatesSet == null) {
                return false;
            }
            if (this.certificatesSet.size() != codeSource.certificatesSet.size()) {
                return false;
            }
            Enumeration enumeration = this.certificatesSet.keys();
            while (enumeration.hasMoreElements()) {
                if (codeSource.certificatesSet.containsKey(enumeration.nextElement())) continue;
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        URL uRL = this.getLocation();
        if (uRL == null) {
            return 1313;
        }
        return uRL.hashCode();
    }

    public final Certificate[] getCertificates() {
        if (this.certificates == null) {
            return null;
        }
        return (Certificate[])this.certificates.clone();
    }

    public final URL getLocation() {
        return this.location;
    }

    public boolean implies(CodeSource codeSource) {
        Object object;
        if (codeSource == null) {
            return false;
        }
        if (this == codeSource) {
            return true;
        }
        if (this.certificatesSet != null) {
            if (codeSource.certificatesSet == null) {
                return false;
            }
            object = this.certificatesSet.keys();
            while (object.hasMoreElements()) {
                if (codeSource.certificatesSet.containsKey(object.nextElement())) continue;
                return false;
            }
        }
        if ((object = this.getLocation()) != null) {
            URL uRL = codeSource.getLocation();
            if (uRL == null) {
                return false;
            }
            if (((URL)object).equals(uRL)) {
                return true;
            }
            if (!((URL)object).getProtocol().equals(uRL.getProtocol())) {
                return false;
            }
            if (!(((URL)object).getHost() == null || uRL.getHost() != null && new SocketPermission(((URL)object).getHost(), "resolve").implies(new SocketPermission(uRL.getHost(), "resolve")))) {
                return false;
            }
            if (((URL)object).getPort() != -1 && ((URL)object).getPort() != uRL.getPort()) {
                return false;
            }
            String string = ((URL)object).getFile();
            String string2 = uRL.getFile();
            if (string != null && !string.equals(string2)) {
                if (string.endsWith("/-")) {
                    if (!string2.startsWith(string.substring(0, string.length() - 1))) {
                        return false;
                    }
                } else if (string.endsWith("/*")) {
                    if (!string2.startsWith(string.substring(0, string.length() - 1)) || string2.indexOf(47, string.length()) > 0) {
                        return false;
                    }
                } else if (!string.endsWith("/")) {
                    if (!string2.equals(new StringBuffer(String.valueOf(string)).append("/").toString())) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
            if (((URL)object).getRef() != null && !((URL)object).getRef().equals(uRL.getRef())) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        if (this.certificates == null || this.certificates.length == 0) {
            return new StringBuffer("(").append(this.location).append(" <no certificates>)").toString();
        }
        return new StringBuffer("(").append(this.location).append(" ").append(this.certificates).append(")").toString();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        if (this.certificates == null) {
            objectOutputStream.writeInt(0);
        } else {
            objectOutputStream.writeInt(this.certificates.length);
            int n = 0;
            while (n < this.certificates.length) {
                objectOutputStream.writeUTF(this.certificates[n].getType());
                try {
                    byte[] byArray = this.certificates[n].getEncoded();
                    objectOutputStream.writeInt(byArray.length);
                    objectOutputStream.write(byArray);
                }
                catch (CertificateEncodingException certificateEncodingException) {
                    objectOutputStream.writeInt(0);
                }
                ++n;
            }
        }
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        int n = objectInputStream.readInt();
        if (n > 0) {
            this.certificates = new Certificate[n];
            int n2 = 0;
            while (n2 < n) {
                String string = objectInputStream.readUTF();
                int n3 = objectInputStream.readInt();
                if (n3 > 0) {
                    byte[] byArray = new byte[n3];
                    objectInputStream.readFully(byArray);
                    try {
                        CertificateFactory certificateFactory = CertificateFactory.getInstance(string);
                        this.certificates[n2] = certificateFactory.generateCertificate(new ByteArrayInputStream(byArray));
                    }
                    catch (CertificateException certificateException) {}
                }
                ++n2;
            }
            this.certificatesSet = new Hashtable(this.certificates.length * 3 / 2);
            n2 = 0;
            while (n2 < this.certificates.length) {
                if (this.certificates[n2] != null) {
                    this.certificatesSet.put(this.certificates[n2], "ignored");
                }
                ++n2;
            }
            if (this.certificatesSet.size() == 0) {
                this.certificatesSet = null;
            }
        }
    }
}

