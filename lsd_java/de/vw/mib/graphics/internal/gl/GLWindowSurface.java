/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.gl;

import de.vw.mib.graphics.internal.gl.GLSurface;
import de.vw.mib.graphics.surface.WindowSurface;
import javax.media.opengl.GLDrawable;

public final class GLWindowSurface
extends GLSurface
implements WindowSurface {
    private final Object nativeWindow;

    public GLWindowSurface(int n, GLDrawable gLDrawable, Object object) {
        super(n, gLDrawable);
        this.nativeWindow = object;
    }

    public Object getNativeWindow() {
        return this.nativeWindow;
    }
}

