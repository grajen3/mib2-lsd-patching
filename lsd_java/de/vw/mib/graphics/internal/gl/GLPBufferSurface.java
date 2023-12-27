/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.gl;

import de.vw.mib.graphics.internal.gl.GLSurface;
import de.vw.mib.graphics.surface.PBufferSurface;
import javax.media.opengl.GLDrawable;

public final class GLPBufferSurface
extends GLSurface
implements PBufferSurface {
    private int textureId;

    public GLPBufferSurface(int n, GLDrawable gLDrawable) {
        super(n, gLDrawable);
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    public int getTextureId() {
        return this.textureId;
    }

    public void setTextureId(int n) {
        this.textureId = n;
    }
}

