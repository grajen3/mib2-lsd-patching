/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.connection.https;

import com.ibm.j9.ssl.Util;
import com.ibm.oti.connection.https.Connection$1;
import com.ibm.oti.security.provider.X500Principal;
import com.ibm.oti.security.provider.X509Certificate;
import com.ibm.oti.util.ASN1Decoder;
import com.ibm.oti.util.ASN1Decoder$Node;
import com.ibm.oti.util.ASN1Exception;
import com.ibm.oti.util.Msg;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.microedition.io.HttpsConnection;
import javax.microedition.io.SecurityInfo;
import javax.microedition.io.StreamConnection;

public class Connection
extends com.ibm.oti.connection.http.Connection
implements HttpsConnection {
    private com.ibm.oti.connection.ssl.Connection sslConnection = null;

    @Override
    public SecurityInfo getSecurityInfo() {
        if (this.isClosed()) {
            throw new IOException();
        }
        if (this.sslConnection == null) {
            super.connect();
        }
        return this.sslConnection.getSecurityInfo();
    }

    @Override
    public String getProtocol() {
        return "https";
    }

    @Override
    protected int getDefaultPort() {
        return 443;
    }

    @Override
    protected StreamConnection openSocket(boolean bl, String string) {
        if (this.sslConnection != null) {
            return this.sslConnection;
        }
        String string2 = new StringBuffer("//").append(this.getHostName()).append(":").append(this.getHostPort()).append(string).toString();
        com.ibm.oti.connection.socket.Connection connection = new com.ibm.oti.connection.socket.Connection();
        connection.setParameters2(string2, 3, bl);
        try {
            this.sslConnection = new com.ibm.oti.connection.ssl.Connection(connection, this.getHostName());
            this.verifyHostname();
        }
        catch (IOException iOException) {
            connection.close();
            throw iOException;
        }
        return this.sslConnection;
    }

    protected void verifyHostname() {
        String string = this.getSubjectCN(this.sslConnection.getServerCertSubject());
        if (string == null) {
            throw new IOException(Msg.getString("K0201", null, null));
        }
        String string2 = this.getHost();
        int n = string2.length();
        int n2 = string.length();
        while (true) {
            String string3;
            String string4;
            int n3;
            int n4;
            if ((n4 = string2.lastIndexOf(46, n - 1)) == -1) {
                n4 = 0;
            }
            if ((n3 = string.lastIndexOf(46, n2 - 1)) == -1) {
                n3 = 0;
            }
            if (!Util.matchesPattern(string4 = string2.substring(n4, n).toLowerCase(), string3 = string.substring(n3, n2).toLowerCase())) {
                throw new IOException(Msg.getString("K0201", string, string2));
            }
            if (n4 == 0 || n3 == 0) {
                if (n4 == n3) break;
                throw new IOException(Msg.getString("K0201", string, string2));
            }
            n = n4;
            n2 = n3;
        }
    }

    protected String getSubjectAltName(X509Certificate x509Certificate) {
        try {
            byte[] byArray = x509Certificate.getExtensionValue("2.5.29.17");
            if (byArray == null) {
                return null;
            }
            ASN1Decoder aSN1Decoder = new ASN1Decoder(new ByteArrayInputStream(byArray));
            ASN1Decoder$Node aSN1Decoder$Node = aSN1Decoder.readContents();
            if (aSN1Decoder$Node.type != 4) {
                return null;
            }
            aSN1Decoder = new ASN1Decoder(new ByteArrayInputStream((byte[])aSN1Decoder$Node.data));
            ASN1Decoder$Node aSN1Decoder$Node2 = aSN1Decoder.readContents();
            if (aSN1Decoder$Node2.type != 16) {
                return null;
            }
            ASN1Decoder$Node[] aSN1Decoder$NodeArray = (ASN1Decoder$Node[])aSN1Decoder$Node2.data;
            int n = 0;
            while (n < aSN1Decoder$NodeArray.length) {
                if (aSN1Decoder$NodeArray[n].type == 2) {
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream((byte[])aSN1Decoder$Node.data, aSN1Decoder$NodeArray[n].startPosition, aSN1Decoder$NodeArray[n].endPosition);
                    aSN1Decoder = new ASN1Decoder(byteArrayInputStream);
                    aSN1Decoder.configureTypeRedirection(0, new Connection$1(this));
                    ASN1Decoder$Node aSN1Decoder$Node3 = aSN1Decoder.readContents();
                    if (aSN1Decoder$Node3.type != 22) {
                        return null;
                    }
                    return (String)aSN1Decoder$Node3.data;
                }
                ++n;
            }
            return null;
        }
        catch (ASN1Exception aSN1Exception) {
            return null;
        }
    }

    protected String getSubjectCN(String string) {
        X500Principal x500Principal = new X500Principal(string);
        return x500Principal.getValueForKey("CN");
    }
}

