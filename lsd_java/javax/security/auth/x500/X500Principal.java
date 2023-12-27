/*
 * Decompiled with CFR 0.152.
 */
package javax.security.auth.x500;

import com.ibm.oti.util.ASN1Exception;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.security.Principal;

public final class X500Principal
implements Principal,
Serializable {
    private static final long serialVersionUID;
    public static final String RFC1779;
    public static final String RFC2253;
    public static final String CANONICAL;
    private transient com.ibm.oti.security.provider.X500Principal principal = null;

    public X500Principal(byte[] byArray) {
        try {
            this.principal = new com.ibm.oti.security.provider.X500Principal(byArray);
        }
        catch (ASN1Exception aSN1Exception) {
            throw new IllegalArgumentException(aSN1Exception.getMessage());
        }
    }

    public X500Principal(InputStream inputStream) {
        if (inputStream == null) {
            throw new NullPointerException();
        }
        try {
            this.principal = new com.ibm.oti.security.provider.X500Principal(inputStream);
        }
        catch (ASN1Exception aSN1Exception) {
            throw new IllegalArgumentException(aSN1Exception.getMessage());
        }
    }

    public X500Principal(String string) {
        if (string == null) {
            throw new NullPointerException();
        }
        this.principal = new com.ibm.oti.security.provider.X500Principal(string);
    }

    @Override
    public String getName() {
        return this.getName("RFC2253");
    }

    public String getName(String string) {
        return this.principal.getName(this.mapAPIConstantToInternal(string));
    }

    public byte[] getEncoded() {
        return this.principal.getEncoded();
    }

    @Override
    public String toString() {
        return this.principal.toString();
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof X500Principal)) {
            return false;
        }
        return this.getName("CANONICAL").equals(((X500Principal)object).getName("CANONICAL"));
    }

    @Override
    public int hashCode() {
        return this.getName("CANONICAL").hashCode();
    }

    private int mapAPIConstantToInternal(String string) {
        if (string.equals("RFC1779")) {
            return 0;
        }
        if (string.equals("RFC2253")) {
            return 1;
        }
        if (string.equals("CANONICAL")) {
            return 2;
        }
        throw new IllegalArgumentException();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeObject(this.getEncoded());
    }

    private void readObject(ObjectInputStream objectInputStream) {
        byte[] byArray = (byte[])objectInputStream.readObject();
        this.principal = new com.ibm.oti.security.provider.X500Principal(byArray);
    }
}

