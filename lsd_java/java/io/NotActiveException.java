/*
 * Decompiled with CFR 0.152.
 */
package java.io;

import java.io.ObjectStreamException;

public class NotActiveException
extends ObjectStreamException {
    private static final long serialVersionUID;

    public NotActiveException() {
    }

    public NotActiveException(String string) {
        super(string);
    }
}

