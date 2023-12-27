/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.font;

import de.vw.mib.graphics.GraphicsException;

public class FontException
extends GraphicsException {
    private static final long serialVersionUID;

    public FontException() {
    }

    public FontException(String string, Throwable throwable) {
        super(string, throwable);
    }

    public FontException(String string) {
        super(string);
    }

    public FontException(Throwable throwable) {
        super(throwable);
    }
}

