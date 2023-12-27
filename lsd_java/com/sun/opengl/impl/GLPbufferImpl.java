/*
 * Decompiled with CFR 0.152.
 */
package com.sun.opengl.impl;

import com.sun.opengl.impl.GLContextImpl;
import com.sun.opengl.impl.GLDrawableImpl;
import javax.media.opengl.GL;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLContext;
import javax.media.opengl.GLDrawable;
import javax.media.opengl.GLException;
import javax.media.opengl.GLPbuffer;

public class GLPbufferImpl
implements GLPbuffer {
    private GLDrawableImpl pbufferDrawable;
    private GLContextImpl context;
    private int floatMode;

    public GLPbufferImpl(GLDrawableImpl gLDrawableImpl, GLContext gLContext) {
        this.pbufferDrawable = gLDrawableImpl;
        this.context = (GLContextImpl)gLDrawableImpl.createContext(gLContext);
        this.context.setSynchronized(true);
    }

    @Override
    public GLContext createContext(GLContext gLContext) {
        return this.pbufferDrawable.createContext(gLContext);
    }

    @Override
    public void setRealized(boolean bl) {
    }

    @Override
    public void setSize(int n, int n2) {
        this.pbufferDrawable.setSize(n, n2);
    }

    @Override
    public int getWidth() {
        return this.pbufferDrawable.getWidth();
    }

    @Override
    public int getHeight() {
        return this.pbufferDrawable.getHeight();
    }

    @Override
    public GLContext getContext() {
        return this.context;
    }

    public GLDrawable getDrawable() {
        return this.pbufferDrawable;
    }

    public GL getGL() {
        return this.getContext().getGL();
    }

    public void setGL(GL gL) {
        this.getContext().setGL(gL);
    }

    @Override
    public void swapBuffers() {
        this.pbufferDrawable.swapBuffers();
    }

    @Override
    public void bindTexture() {
        this.context.bindPbufferToTexture();
    }

    @Override
    public void releaseTexture() {
        this.context.releasePbufferFromTexture();
    }

    @Override
    public GLCapabilities getChosenGLCapabilities() {
        if (this.pbufferDrawable == null) {
            return null;
        }
        return this.pbufferDrawable.getChosenGLCapabilities();
    }

    @Override
    public void destroy() {
        GLContext gLContext = GLContext.getCurrent();
        if (gLContext != null) {
            if (gLContext == this.context) {
                this.context.release();
            }
            this.context.destroy();
        }
        this.pbufferDrawable.destroy();
    }

    @Override
    public int getFloatingPointMode() {
        if (this.floatMode == 0) {
            throw new GLException("Pbuffer not initialized, or floating-point support not requested");
        }
        return this.floatMode;
    }

    protected void finalize() {
        this.destroy();
        super.finalize();
    }
}

