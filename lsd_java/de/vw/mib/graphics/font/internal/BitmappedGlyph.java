/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.font.internal;

import de.vw.mib.Disposable;
import de.vw.mib.cache.Cacheable;
import de.vw.mib.graphics.font.GlyphBitmap;
import de.vw.mib.graphics.image.BufferImage;
import de.vw.mib.util.StringBuilder;

public final class BitmappedGlyph
implements GlyphBitmap,
Cacheable,
Disposable {
    private BufferImage bitmap;
    private final int leftOffset;
    private final int topOffset;
    private final int horizontalAdvance;

    public BitmappedGlyph(BufferImage bufferImage, int n, int n2, int n3) {
        this.bitmap = bufferImage;
        this.leftOffset = n;
        this.topOffset = n2;
        this.horizontalAdvance = n3;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[bitmap=").append(this.bitmap);
        stringBuilder.append(",leftOffset='").append(this.leftOffset);
        stringBuilder.append(",topOffset=").append(this.topOffset);
        stringBuilder.append(",horizontalAdvance=").append(this.horizontalAdvance);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public void dispose() {
        this.bitmap.dispose();
        this.bitmap = null;
    }

    @Override
    public int getByteSize() {
        return this.bitmap.getByteSize();
    }

    @Override
    public BufferImage getImage() {
        return this.bitmap;
    }

    @Override
    public int getLeftOffset() {
        return this.leftOffset;
    }

    @Override
    public int getTopOffset() {
        return this.topOffset;
    }

    @Override
    public int getHorizontalAdvance() {
        return this.horizontalAdvance;
    }
}

