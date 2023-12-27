/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.image.spi;

import java.util.EventListener;

public interface NativeImageLoadingListener
extends EventListener {
    default public void imageLoadingProgress(int n, int n2, int n3, int n4) {
    }
}

