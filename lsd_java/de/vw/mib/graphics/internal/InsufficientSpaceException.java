/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal;

import de.vw.mib.graphics.GraphicsException;

public final class InsufficientSpaceException
extends GraphicsException {
    private static final long serialVersionUID;
    public final int reqWidth;
    public final int reqHeight;

    public InsufficientSpaceException(int n, int n2) {
        this.reqWidth = n;
        this.reqHeight = n2;
    }

    public int getRequiredWidth() {
        return this.reqWidth;
    }

    public int getRequiredHeight() {
        return this.reqHeight;
    }
}

