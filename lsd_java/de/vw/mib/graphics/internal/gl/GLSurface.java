/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.gl;

import de.vw.mib.graphics.internal.gl.GLGraphics3D;
import de.vw.mib.graphics.internal.surface.AbstractSurface;
import javax.media.opengl.GLDrawable;

public class GLSurface
extends AbstractSurface {
    private final GLDrawable glDrawable;
    private boolean bound;

    public GLSurface(int n, GLDrawable gLDrawable) {
        super(null, null, n);
        this.glDrawable = gLDrawable;
        this.bound = false;
    }

    @Override
    public void dispose() {
        if (this.isBound()) {
            this.unbind();
        }
        super.dispose();
    }

    @Override
    public final int getWidth() {
        return this.glDrawable.getWidth();
    }

    @Override
    public final int getHeight() {
        return this.glDrawable.getHeight();
    }

    @Override
    public final void setSize(int n, int n2) {
        this.glDrawable.setSize(n, n2);
    }

    protected GLGraphics3D getGLGraphics3D() {
        return (GLGraphics3D)this.getGraphics3D();
    }

    public void bind(GLGraphics3D gLGraphics3D) {
        this.setGraphics3D(gLGraphics3D);
        this.bound = true;
    }

    public void unbind() {
        this.setGraphics3D(null);
        this.bound = false;
    }

    public boolean isBound() {
        return this.bound;
    }

    public final GLDrawable getGLDrawable() {
        return this.glDrawable;
    }
}

