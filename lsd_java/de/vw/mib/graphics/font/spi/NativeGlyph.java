/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.font.spi;

import de.vw.mib.graphics.image.spi.NativeImage;

public final class NativeGlyph {
    public final char code;
    public final NativeImage bitmap;
    public final int leftOffset;
    public final int topOffset;
    public final int horizontalAdvance;

    public NativeGlyph(char c2, NativeImage nativeImage, int n, int n2, int n3) {
        this.code = c2;
        this.bitmap = nativeImage;
        this.leftOffset = n;
        this.topOffset = n2;
        this.horizontalAdvance = n3;
    }
}

