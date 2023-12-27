/*
 * Decompiled with CFR 0.152.
 */
package javax.microedition.io;

import javax.microedition.io.DatagramConnection;

public interface UDPDatagramConnection
extends DatagramConnection {
    default public String getLocalAddress() {
    }

    default public int getLocalPort() {
    }
}

