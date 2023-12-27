/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.drawable;

import de.vw.mib.graphics.GraphicsException;

public class DrawableException
extends GraphicsException {
    private static final long serialVersionUID;

    public DrawableException() {
    }

    public DrawableException(String string, Throwable throwable) {
        super(string, throwable);
    }

    public DrawableException(String string) {
        super(string);
    }

    public DrawableException(Throwable throwable) {
        super(throwable);
    }
}

