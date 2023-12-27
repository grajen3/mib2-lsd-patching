/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.drawable;

import de.vw.mib.graphics.GraphicsException;

public class DrawException
extends GraphicsException {
    private static final long serialVersionUID;

    public DrawException() {
    }

    public DrawException(String string, Throwable throwable) {
        super(string, throwable);
    }

    public DrawException(String string) {
        super(string);
    }

    public DrawException(Throwable throwable) {
        super(throwable);
    }
}

