/*
 * Decompiled with CFR 0.152.
 */
package java.security;

import com.ibm.oti.util.Msg;
import java.io.Serializable;
import java.security.Certificate;
import java.security.IdentityScope;
import java.security.KeyManagementException;
import java.security.Principal;
import java.security.PublicKey;
import java.util.Arrays;
import java.util.Vector;

public abstract class Identity
implements Principal,
Serializable {
    private static final long serialVersionUID;
    String name;
    PublicKey publicKey;
    Vector certificates;
    IdentityScope scope;
    String info;

    protected Identity() {
        this.certificates = new Vector();
    }

    public Identity(String string) {
        this.name = string;
        this.certificates = new Vector();
    }

    public Identity(String string, IdentityScope identityScope) {
        this(string);
        this.scope = identityScope;
        if (identityScope != null) {
            identityScope.addIdentity(this);
        }
    }

    public final IdentityScope getScope() {
        return this.scope;
    }

    public PublicKey getPublicKey() {
        return this.publicKey;
    }

    public void setPublicKey(PublicKey publicKey) {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkSecurityAccess("setIdentityPublicKey");
        }
        if (this.scope != null && this.scope.getIdentity(publicKey) != null) {
            throw new KeyManagementException(Msg.getString("K0194"));
        }
        this.publicKey = publicKey;
        this.certificates = new Vector();
    }

    @Override
    public final String getName() {
        return this.name;
    }

    public String getInfo() {
        return this.info;
    }

    public void setInfo(String string) {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkSecurityAccess("setIdentityInfo");
        }
        this.info = string;
    }

    public Certificate[] certificates() {
        return (Certificate[])this.certificates.toArray(new Certificate[0]);
    }

    public void addCertificate(Certificate certificate) {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkSecurityAccess("addIdentityCertificate");
        }
        PublicKey publicKey = certificate.getPublicKey();
        if (this.publicKey != null && !Arrays.equals(this.publicKey.getEncoded(), publicKey.getEncoded())) {
            throw new KeyManagementException(Msg.getString("K0195"));
        }
        this.publicKey = publicKey;
        this.certificates.add(certificate);
    }

    public void removeCertificate(Certificate certificate) {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkSecurityAccess("removeIdentityCertificate");
        }
        if (!this.certificates.contains(certificate)) {
            throw new KeyManagementException(Msg.getString("K0196"));
        }
        this.certificates.remove(certificate);
    }

    @Override
    public final boolean equals(Object object) {
        boolean bl;
        if (this == object) {
            return true;
        }
        if (!(object instanceof Identity)) {
            return false;
        }
        Identity identity = (Identity)object;
        boolean bl2 = this.getName() == null ? identity.getName() == null : (bl = this.getName().equals(identity.getName()));
        if (bl) {
            boolean bl3;
            boolean bl4 = this.getScope() == null ? identity.getScope() == null : (bl3 = this.getScope().equals(identity.getScope()));
            if (bl3) {
                return true;
            }
        }
        return this.identityEquals(identity);
    }

    protected boolean identityEquals(Identity identity) {
        boolean bl;
        if (identity == null) {
            return false;
        }
        boolean bl2 = this.getName() == null ? identity.getName() == null : (bl = this.getName().equals(identity.getName()));
        if (!bl) {
            return false;
        }
        boolean bl3 = this.getPublicKey() == null ? identity.getPublicKey() == null : this.getPublicKey().equals(identity.getPublicKey());
        return bl3;
    }

    @Override
    public String toString() {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkSecurityAccess("printIdentity");
        }
        return new StringBuffer("Name : ").append(this.getName()).append("\nPublic key : ").append(this.publicKey).toString();
    }

    public String toString(boolean bl) {
        String string = this.toString();
        if (bl) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("\nGeneral information : ");
            stringBuffer.append(this.getInfo());
            stringBuffer.append("\nCertificates :\n");
            Certificate[] certificateArray = this.certificates();
            int n = 0;
            while (n < certificateArray.length) {
                stringBuffer.append(certificateArray[n].toString(false));
                ++n;
            }
            string = new StringBuffer(String.valueOf(string)).append(stringBuffer.toString()).toString();
        }
        return string;
    }

    @Override
    public int hashCode() {
        int n = 0;
        if (this.name != null) {
            n = this.name.hashCode();
        }
        if (this.publicKey != null) {
            n ^= this.publicKey.hashCode();
        }
        if (this.scope != null) {
            n ^= this.scope.hashCode();
        }
        return n;
    }
}

