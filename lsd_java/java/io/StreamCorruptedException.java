/*
 * Decompiled with CFR 0.152.
 */
package java.io;

import java.io.ObjectStreamException;

public class StreamCorruptedException
extends ObjectStreamException {
    private static final long serialVersionUID;

    public StreamCorruptedException() {
    }

    public StreamCorruptedException(String string) {
        super(string);
    }
}

