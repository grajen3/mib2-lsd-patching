/*
 * Decompiled with CFR 0.152.
 */
package de.eso.mib;

import com.sun.gluegen.runtime.BufferFactory;
import com.sun.gluegen.runtime.CPU;
import com.sun.gluegen.runtime.StructAccessor;
import de.eso.mib.FontMetricsInfo32;
import de.eso.mib.FontMetricsInfo64;
import java.nio.ByteBuffer;

public abstract class FontMetricsInfo {
    StructAccessor accessor;

    public static int size() {
        if (CPU.is32Bit()) {
            return FontMetricsInfo32.size();
        }
        return FontMetricsInfo64.size();
    }

    public static FontMetricsInfo create() {
        return FontMetricsInfo.create(BufferFactory.newDirectByteBuffer(FontMetricsInfo.size()));
    }

    public static FontMetricsInfo create(ByteBuffer byteBuffer) {
        if (CPU.is32Bit()) {
            return new FontMetricsInfo32(byteBuffer);
        }
        return new FontMetricsInfo64(byteBuffer);
    }

    FontMetricsInfo(ByteBuffer byteBuffer) {
        this.accessor = new StructAccessor(byteBuffer);
    }

    public ByteBuffer getBuffer() {
        return this.accessor.getBuffer();
    }

    public abstract FontMetricsInfo ascender(int n) {
    }

    public abstract int ascender() {
    }

    public abstract FontMetricsInfo descender(int n) {
    }

    public abstract int descender() {
    }

    public abstract FontMetricsInfo height(int n) {
    }

    public abstract int height() {
    }

    public abstract FontMetricsInfo advanceWidth(int n) {
    }

    public abstract int advanceWidth() {
    }

    public abstract FontMetricsInfo underlinePosition(int n) {
    }

    public abstract int underlinePosition() {
    }

    public abstract FontMetricsInfo underlineThickness(int n) {
    }

    public abstract int underlineThickness() {
    }

    public abstract FontMetricsInfo strikeOutPosition(int n) {
    }

    public abstract int strikeOutPosition() {
    }

    public abstract FontMetricsInfo strikeOutThickness(int n) {
    }

    public abstract int strikeOutThickness() {
    }

    public abstract FontMetricsInfo overlinePosition(int n) {
    }

    public abstract int overlinePosition() {
    }

    public abstract FontMetricsInfo overlineThickness(int n) {
    }

    public abstract int overlineThickness() {
    }

    public abstract FontMetricsInfo state(int n) {
    }

    public abstract int state() {
    }
}

