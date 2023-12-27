/*
 * Decompiled with CFR 0.152.
 */
package java.io;

import java.io.ObjectStreamException;

public class OptionalDataException
extends ObjectStreamException {
    private static final long serialVersionUID;
    public boolean eof;
    public int length;

    OptionalDataException() {
    }

    OptionalDataException(String string) {
        super(string);
    }
}

