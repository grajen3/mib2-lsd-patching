/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.gl;

import de.vw.mib.graphics.internal.gl.GLSurface;
import de.vw.mib.graphics.surface.PixmapSurface;
import javax.media.opengl.GLDrawable;

public final class GLPixmapSurface
extends GLSurface
implements PixmapSurface {
    private final Object nativeImage;

    public GLPixmapSurface(GLDrawable gLDrawable, Object object) {
        super(4356, gLDrawable);
        this.nativeImage = object;
    }

    public Object getNativeImage() {
        return this.nativeImage;
    }
}

