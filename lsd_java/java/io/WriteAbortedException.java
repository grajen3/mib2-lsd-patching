/*
 * Decompiled with CFR 0.152.
 */
package java.io;

import java.io.ObjectStreamException;

public class WriteAbortedException
extends ObjectStreamException {
    private static final long serialVersionUID;
    public Exception detail;

    public WriteAbortedException(String string, Exception exception) {
        super(string);
        this.detail = exception;
        this.initCause(exception);
    }

    @Override
    public String getMessage() {
        String string = super.getMessage();
        if (this.detail != null) {
            string = new StringBuffer(String.valueOf(string)).append("; ").append(this.detail.toString()).toString();
        }
        return string;
    }

    @Override
    public Throwable getCause() {
        return this.detail;
    }
}

