/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.image;

import de.vw.mib.graphics.image.InvalidImageFormatException;

public final class UnsupportedImageFormatException
extends InvalidImageFormatException {
    private static final long serialVersionUID;
    private final int format;

    public UnsupportedImageFormatException(int n) {
        this.format = n;
    }

    public int getFormat() {
        return this.format;
    }
}

