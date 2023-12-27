/*
 * Decompiled with CFR 0.152.
 */
package javax.microedition.io;

import java.io.DataInputStream;
import java.io.InputStream;
import javax.microedition.io.Connection;

public interface InputConnection
extends Connection {
    default public DataInputStream openDataInputStream() {
    }

    default public InputStream openInputStream() {
    }
}

