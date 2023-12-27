/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.connection;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import javax.microedition.io.InputConnection;
import javax.microedition.io.OutputConnection;

public abstract class DataConnection
implements InputConnection,
OutputConnection {
    @Override
    public abstract void close() {
    }

    @Override
    public abstract InputStream openInputStream() {
    }

    @Override
    public abstract OutputStream openOutputStream() {
    }

    @Override
    public DataInputStream openDataInputStream() {
        return new DataInputStream(this.openInputStream());
    }

    @Override
    public DataOutputStream openDataOutputStream() {
        return new DataOutputStream(this.openOutputStream());
    }
}

