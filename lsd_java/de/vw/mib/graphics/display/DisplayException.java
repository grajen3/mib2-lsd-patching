/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.display;

import de.vw.mib.graphics.GraphicsException;

public class DisplayException
extends GraphicsException {
    private static final long serialVersionUID;

    public DisplayException() {
    }

    public DisplayException(String string, Throwable throwable) {
        super(string, throwable);
    }

    public DisplayException(String string) {
        super(string);
    }

    public DisplayException(Throwable throwable) {
        super(throwable);
    }
}

