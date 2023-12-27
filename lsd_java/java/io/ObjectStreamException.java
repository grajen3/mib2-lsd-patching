/*
 * Decompiled with CFR 0.152.
 */
package java.io;

import java.io.IOException;

public abstract class ObjectStreamException
extends IOException {
    private static final long serialVersionUID;

    protected ObjectStreamException() {
    }

    protected ObjectStreamException(String string) {
        super(string);
    }
}

