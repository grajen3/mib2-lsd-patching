/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.image;

import de.vw.mib.graphics.GraphicsException;

public class ImageException
extends GraphicsException {
    private static final long serialVersionUID;

    public ImageException() {
    }

    public ImageException(String string, Throwable throwable) {
        super(string, throwable);
    }

    public ImageException(String string) {
        super(string);
    }

    public ImageException(Throwable throwable) {
        super(throwable);
    }
}

