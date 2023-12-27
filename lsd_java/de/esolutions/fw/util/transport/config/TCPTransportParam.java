/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport.config;

import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.config.query.IConfigQuery;
import de.esolutions.fw.util.transport.socket.SocketOptions;

public class TCPTransportParam {
    private final String address;
    private final int port;
    private int timeout = 2000;
    private boolean useSSL = false;
    private boolean useClientAuth = false;
    private String keyStorePath;
    private String keyStorePassPhrase;
    private String trustStorePath;
    private String trustStorePassPhrase;
    private String cipherSuiteFilter;

    public static TCPTransportParam create(IConfigQuery iConfigQuery) {
        String string = iConfigQuery.getStringValue("tcpip.address");
        Integer n = iConfigQuery.getIntegerValue("tcpip.port");
        if (string == null || n == null) {
            return null;
        }
        TCPTransportParam tCPTransportParam = new TCPTransportParam(string, n);
        TCPTransportParam.parseOptions(iConfigQuery, tCPTransportParam);
        return tCPTransportParam;
    }

    static void parseOptions(IConfigQuery iConfigQuery, TCPTransportParam tCPTransportParam) {
        Integer n = iConfigQuery.getIntegerValue("tcpip.timeout");
        if (n != null) {
            tCPTransportParam.timeout = n;
        }
        tCPTransportParam.useSSL = iConfigQuery.getBooleanValue("tcpip.use_ssl", false);
        tCPTransportParam.useClientAuth = iConfigQuery.getBooleanValue("tcpip.use_client_auth", false);
        tCPTransportParam.keyStorePath = iConfigQuery.getStringValue("tcpip.keystore_path", null);
        tCPTransportParam.keyStorePassPhrase = iConfigQuery.getStringValue("tcpip.keystore_passphrase", null);
        tCPTransportParam.trustStorePath = iConfigQuery.getStringValue("tcpip.truststore_path", null);
        tCPTransportParam.trustStorePassPhrase = iConfigQuery.getStringValue("tcpip.truststore_passphrase", null);
        tCPTransportParam.cipherSuiteFilter = iConfigQuery.getStringValue("tcpip.cipher_suite_filter", null);
    }

    private TCPTransportParam(String string, int n) {
        this.address = string;
        this.port = n;
    }

    public String getAddress() {
        return this.address;
    }

    public int getPort() {
        return this.port;
    }

    public SocketOptions getOptions() {
        SocketOptions socketOptions = new SocketOptions();
        socketOptions.timeOut = this.timeout;
        socketOptions.useSSL = this.useSSL;
        socketOptions.useClientAuth = this.useClientAuth;
        socketOptions.keyStorePath = this.keyStorePath;
        socketOptions.keyStorePassPhrase = this.keyStorePassPhrase;
        socketOptions.trustStorePath = this.trustStorePath;
        socketOptions.trustStorePassPhrase = this.trustStorePassPhrase;
        socketOptions.cipherSuiteFilter = this.cipherSuiteFilter;
        return socketOptions;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("[TCP:");
        buffer.append(this.address);
        buffer.append(":");
        buffer.append(this.port);
        buffer.append(",timeout=");
        buffer.append(this.timeout);
        buffer.append(",useSSL=");
        buffer.append(this.useSSL);
        if (this.useSSL) {
            buffer.append(",useClientAuth=");
            buffer.append(this.useClientAuth);
            buffer.append(",keyStore=");
            buffer.append(this.keyStorePath);
            buffer.append(":");
            buffer.append(this.keyStorePassPhrase);
            buffer.append(",trustStore=");
            buffer.append(this.trustStorePath);
            buffer.append(":");
            buffer.append(this.trustStorePassPhrase);
            buffer.append(",cipherSuiteFilter=");
            buffer.append(this.cipherSuiteFilter);
        }
        return buffer.toString();
    }

    private boolean equalsString(String string, String string2) {
        if (string == null && string2 == null) {
            return true;
        }
        if (string != null && string2 != null) {
            return string.equals(string2);
        }
        return false;
    }

    public boolean equals(Object object) {
        if (!(object instanceof TCPTransportParam)) {
            return false;
        }
        TCPTransportParam tCPTransportParam = (TCPTransportParam)object;
        return tCPTransportParam.address.equals(this.address) && tCPTransportParam.port == this.port && tCPTransportParam.timeout == this.timeout && tCPTransportParam.useSSL == this.useSSL && tCPTransportParam.useClientAuth == this.useClientAuth && this.equalsString(tCPTransportParam.keyStorePath, this.keyStorePath) && this.equalsString(tCPTransportParam.keyStorePassPhrase, this.keyStorePassPhrase) && this.equalsString(tCPTransportParam.trustStorePath, this.trustStorePath) && this.equalsString(tCPTransportParam.trustStorePassPhrase, this.trustStorePassPhrase) && this.equalsString(tCPTransportParam.cipherSuiteFilter, this.cipherSuiteFilter);
    }

    public int hashCode() {
        int n = 1;
        n = n * 13 + (this.address == null ? 0 : this.address.hashCode());
        n = n * 17 + this.port;
        n = n * 19 + this.timeout;
        n = n * 23 + (this.useSSL ? 1 : 0);
        n = n * 31 + (this.useClientAuth ? 1 : 0);
        n = n * 37 + (this.keyStorePath == null ? 0 : this.keyStorePath.hashCode());
        n = n * 41 + (this.keyStorePassPhrase == null ? 0 : this.keyStorePassPhrase.hashCode());
        n = n * 43 + (this.trustStorePath == null ? 0 : this.trustStorePath.hashCode());
        n = n * 47 + (this.trustStorePassPhrase == null ? 0 : this.trustStorePassPhrase.hashCode());
        n = n * 53 + (this.cipherSuiteFilter == null ? 0 : this.cipherSuiteFilter.hashCode());
        return n;
    }
}

