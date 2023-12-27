/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics;

import de.vw.mib.util.StringBuilder;

public final class ConfigurationAttributes {
    public int colorRedBits;
    public int colorGreenBits;
    public int colorBlueBits;
    public int colorAlphaBits;
    public int depthBits;
    public int stencilBits;
    public int samples;
    public boolean windowSurface;
    public boolean imageSurface;
    public boolean bufferSurface;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[colorRedBits=").append(this.colorRedBits);
        stringBuilder.append(",colorGreenBits=").append(this.colorGreenBits);
        stringBuilder.append(",colorBlueBits=").append(this.colorBlueBits);
        stringBuilder.append(",colorAlphaBits=").append(this.colorAlphaBits);
        stringBuilder.append(",depthBits=").append(this.depthBits);
        stringBuilder.append(",stencilBits=").append(this.stencilBits);
        stringBuilder.append(",samples=").append(this.samples);
        stringBuilder.append(",windowSurface=").append(this.windowSurface);
        stringBuilder.append(",imageSurface=").append(this.imageSurface);
        stringBuilder.append(",bufferSurface=").append(this.bufferSurface);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

