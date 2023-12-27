/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.texture;

import de.vw.mib.graphics.image.BufferImage;
import de.vw.mib.graphics.texture.Texture;

public interface TextureCubeMap
extends Texture {
    public static final int CUBEMAP_FACE_POSITIVE_X;
    public static final int CUBEMAP_FACE_NEGATIVE_X;
    public static final int CUBEMAP_FACE_POSITIVE_Y;
    public static final int CUBEMAP_FACE_NEGATIVE_Y;
    public static final int CUBEMAP_FACE_POSITIVE_Z;
    public static final int CUBEMAP_FACE_NEGATIVE_Z;
    public static final int CUBEMAP_FACE_COUNT;

    default public BufferImage getContent(int n, int n2) {
    }

    default public BufferImage getContent(int n, int n2, int n3, int n4, int n5, int n6) {
    }

    default public void setContent(int n, int n2, BufferImage bufferImage) {
    }

    default public void setContent(int n, int n2, int n3, int n4, BufferImage bufferImage) {
    }

    default public void setContent(int n, int n2, int n3, int n4, int n5, int n6, BufferImage bufferImage) {
    }
}

