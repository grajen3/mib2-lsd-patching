/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.font.internal;

public final class KernedRasterFont$SizeInfo {
    private final int size;
    private int ascender;
    private int descender;
    private int height;
    private int maxAdvanceWidth;

    public KernedRasterFont$SizeInfo(int n) {
        this.size = n;
        this.ascender = -129;
        this.descender = -129;
        this.height = -129;
        this.maxAdvanceWidth = -129;
    }

    public int getSize() {
        return this.size;
    }

    public boolean hasAscender() {
        return this.ascender != -129;
    }

    public int getAscender() {
        return this.ascender;
    }

    public void setAscender(int n) {
        this.ascender = n;
    }

    public boolean hasDescender() {
        return this.descender != -129;
    }

    public int getDescender() {
        return this.descender;
    }

    public void setDescender(int n) {
        this.descender = n;
    }

    public boolean hasHeight() {
        return this.height != -129;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int n) {
        this.height = n;
    }

    public boolean hasMaxAdvanceWidth() {
        return this.maxAdvanceWidth != -129;
    }

    public int getMaxAdvanceWidth() {
        return this.maxAdvanceWidth;
    }

    public void setMaxAdvanceWidth(int n) {
        this.maxAdvanceWidth = n;
    }
}

