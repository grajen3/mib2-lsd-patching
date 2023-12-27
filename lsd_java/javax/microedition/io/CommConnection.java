/*
 * Decompiled with CFR 0.152.
 */
package javax.microedition.io;

import javax.microedition.io.StreamConnection;

public interface CommConnection
extends StreamConnection {
    default public int setBaudRate(int n) {
    }

    default public int getBaudRate() {
    }
}

