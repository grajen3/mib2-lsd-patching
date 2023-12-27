/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.display.spi;

import de.vw.mib.graphics.image.spi.NativeImage;
import java.nio.ByteBuffer;

public interface DisplaySPI {
    default public Object getNativeDisplayableHandle(int n, int n2) {
    }

    default public NativeImage getDisplayableContent(int n, int n2) {
    }

    default public NativeImage getDisplayableContent(int n, int n2, int n3, int n4, int n5, int n6) {
    }

    default public NativeImage getDisplayContent(int n) {
    }

    default public void releaseContent(NativeImage nativeImage) {
    }

    default public void releaseContent(ByteBuffer byteBuffer) {
    }
}

