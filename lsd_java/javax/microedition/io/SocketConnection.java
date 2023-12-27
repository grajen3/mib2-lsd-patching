/*
 * Decompiled with CFR 0.152.
 */
package javax.microedition.io;

import javax.microedition.io.StreamConnection;

public interface SocketConnection
extends StreamConnection {
    public static final byte DELAY;
    public static final byte KEEPALIVE;
    public static final byte LINGER;
    public static final byte RCVBUF;
    public static final byte SNDBUF;

    default public String getAddress() {
    }

    default public String getLocalAddress() {
    }

    default public int getLocalPort() {
    }

    default public int getPort() {
    }

    default public int getSocketOption(byte by) {
    }

    default public void setSocketOption(byte by, int n) {
    }
}

