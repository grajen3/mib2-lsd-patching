/*
 * Decompiled with CFR 0.152.
 */
package java.io;

import java.io.IOException;

public class InterruptedIOException
extends IOException {
    public int bytesTransferred;

    public InterruptedIOException() {
    }

    public InterruptedIOException(String string) {
        super(string);
    }
}

