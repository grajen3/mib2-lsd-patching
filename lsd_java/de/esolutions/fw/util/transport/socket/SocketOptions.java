/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport.socket;

import de.esolutions.fw.util.commons.Buffer;

public class SocketOptions {
    public boolean useSSL;
    public boolean useClientAuth;
    public String keyStorePath;
    public String keyStorePassPhrase;
    public String trustStorePath;
    public String trustStorePassPhrase;
    public String cipherSuiteFilter;
    public int serverBackLog = 1;
    public boolean keepAlive = true;
    public int timeOut = 0;
    public boolean noDelay = true;
    public static final String[] protocols = new String[]{"TLSv1.2", "TLSv1.1", "TLSv1"};

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("(useSSL=");
        buffer.append(this.useSSL);
        buffer.append(",usePeerAuth=");
        buffer.append(this.useClientAuth);
        buffer.append(",keyStorePath=");
        buffer.append(this.keyStorePath);
        buffer.append(",keyStorePassPhrase=");
        buffer.append(this.keyStorePassPhrase);
        buffer.append(",trustStorePath=");
        buffer.append(this.trustStorePath);
        buffer.append(",trustStorePassPhrase=");
        buffer.append(this.trustStorePassPhrase);
        buffer.append(",cipherSuiteFilter=");
        buffer.append(this.cipherSuiteFilter);
        buffer.append(",serverBackLog=");
        buffer.append(this.serverBackLog);
        buffer.append(",keepAlive=");
        buffer.append(this.keepAlive);
        buffer.append(",timeOut=");
        buffer.append(this.timeOut);
        buffer.append(",noDelay=");
        buffer.append(this.noDelay);
        buffer.append(",preferred protocols=");
        for (int i2 = 0; i2 < protocols.length; ++i2) {
            if (i2 != 0) {
                buffer.append(" ");
            }
            buffer.append(protocols[i2]);
        }
        return buffer.toString();
    }
}

