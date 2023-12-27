/*
 * Decompiled with CFR 0.152.
 */
package java.net;

import java.io.InterruptedIOException;

public class SocketTimeoutException
extends InterruptedIOException {
    public SocketTimeoutException() {
    }

    public SocketTimeoutException(String string) {
        super(string);
    }
}

