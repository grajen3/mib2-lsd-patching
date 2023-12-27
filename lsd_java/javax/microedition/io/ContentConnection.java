/*
 * Decompiled with CFR 0.152.
 */
package javax.microedition.io;

import javax.microedition.io.StreamConnection;

public interface ContentConnection
extends StreamConnection {
    default public String getEncoding() {
    }

    default public long getLength() {
    }

    default public String getType() {
    }
}

