/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.image;

import de.vw.mib.graphics.image.ImageException;

public final class UnsupportedImageSizeException
extends ImageException {
    private static final long serialVersionUID;
    private final int width;
    private final int height;

    public UnsupportedImageSizeException(int n, int n2) {
        this.width = n;
        this.height = n2;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }
}

