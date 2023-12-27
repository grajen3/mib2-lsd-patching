/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.texture;

import de.vw.mib.graphics.image.BufferImage;
import de.vw.mib.graphics.texture.Texture;

public interface Texture2D
extends Texture {
    default public BufferImage getContent(int n) {
    }

    default public BufferImage getContent(int n, int n2, int n3, int n4, int n5) {
    }

    default public void setContent(int n, BufferImage bufferImage) {
    }

    default public void setContent(int n, int n2, int n3, BufferImage bufferImage) {
    }

    default public void setContent(int n, int n2, int n3, int n4, int n5, BufferImage bufferImage) {
    }
}

