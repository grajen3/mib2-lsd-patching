/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.gl;

import de.vw.mib.graphics.GraphicsException;

public class GLException
extends GraphicsException {
    private static final long serialVersionUID;

    public GLException() {
    }

    public GLException(String string, Throwable throwable) {
        super(string, throwable);
    }

    public GLException(String string) {
        super(string);
    }

    public GLException(Throwable throwable) {
        super(throwable);
    }
}

