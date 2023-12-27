/*
 * Decompiled with CFR 0.152.
 */
package javax.microedition.io;

import java.io.DataOutputStream;
import java.io.OutputStream;
import javax.microedition.io.Connection;

public interface OutputConnection
extends Connection {
    default public DataOutputStream openDataOutputStream() {
    }

    default public OutputStream openOutputStream() {
    }
}

