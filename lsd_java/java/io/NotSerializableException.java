/*
 * Decompiled with CFR 0.152.
 */
package java.io;

import java.io.ObjectStreamException;

public class NotSerializableException
extends ObjectStreamException {
    private static final long serialVersionUID;

    public NotSerializableException() {
    }

    public NotSerializableException(String string) {
        super(string);
    }
}

