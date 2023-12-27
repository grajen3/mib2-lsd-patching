/*
 * Decompiled with CFR 0.152.
 */
package javax.media.opengl;

import javax.media.opengl.GLDrawable;

public interface GLPbuffer
extends GLDrawable {
    public static final int APPLE_FLOAT;
    public static final int ATI_FLOAT;
    public static final int NV_FLOAT;

    default public void bindTexture() {
    }

    default public void releaseTexture() {
    }

    default public void destroy() {
    }

    default public int getFloatingPointMode() {
    }
}

