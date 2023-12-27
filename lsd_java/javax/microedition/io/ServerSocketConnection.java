/*
 * Decompiled with CFR 0.152.
 */
package javax.microedition.io;

import javax.microedition.io.StreamConnectionNotifier;

public interface ServerSocketConnection
extends StreamConnectionNotifier {
    default public String getLocalAddress() {
    }

    default public int getLocalPort() {
    }
}

