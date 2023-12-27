/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.view;

import de.vw.mib.graphics.Color4b;
import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.Dimension;
import de.vw.mib.graphics.image.BufferImage;
import java.nio.ByteBuffer;
import java.util.List;

public interface ViewCompositor {
    default public void getDisplaySize(Dimension dimension) {
    }

    default public BufferImage getBackgroundImage() {
    }

    default public void setBackgroundImage(BufferImage bufferImage) {
    }

    default public void setViewNames(List list) {
    }

    default public void getScreenshot(ByteBuffer byteBuffer) {
    }

    default public void switchViews(List list, List list2) {
    }

    default public void repaintViews(List list) {
    }

    default public void drawPanicMessage(Throwable throwable, Color4b color4b) {
    }

    default public void drawPanicMessage(Throwable throwable, Color4f color4f) {
    }

    default public void drawPanicMessage(String string, Color4b color4b) {
    }

    default public void drawPanicMessage(String string, Color4f color4f) {
    }
}

