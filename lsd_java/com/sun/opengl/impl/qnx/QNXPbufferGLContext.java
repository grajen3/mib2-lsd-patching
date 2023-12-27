/*
 * Decompiled with CFR 0.152.
 */
package com.sun.opengl.impl.qnx;

import com.sun.opengl.impl.Debug;
import com.sun.opengl.impl.qnx.EGL;
import com.sun.opengl.impl.qnx.QNXGLContext;
import com.sun.opengl.impl.qnx.QNXGLDrawableFactory;
import com.sun.opengl.impl.qnx.QNXPbufferGLDrawable;
import javax.media.opengl.GL;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLContext;
import javax.media.opengl.GLException;

public class QNXPbufferGLContext
extends QNXGLContext {
    private static final boolean DEBUG = Debug.debug("QNXPbufferGLContext");
    private QNXPbufferGLDrawable drawable;
    private boolean rtt;
    private int textureTarget;
    private int texture;

    public QNXPbufferGLContext(QNXPbufferGLDrawable qNXPbufferGLDrawable, GLContext gLContext) {
        super(qNXPbufferGLDrawable, gLContext);
        this.drawable = qNXPbufferGLDrawable;
    }

    @Override
    public void bindPbufferToTexture() {
        if (!this.rtt) {
            throw new GLException("Shouldn't try to bind a pbuffer to a texture if render-to-texture hasn't been specified in its GLCapabilities");
        }
        this.getGL();
        if (this.rtt && !EGL.eglBindTexImage(this.drawable.getDisplay(), this.drawable.getSurface(), this.texture)) {
            throw new GLException(new StringBuffer().append("Binding of pbuffer to texture failed: ").append(QNXPbufferGLContext.eglGetLastError()).toString());
        }
    }

    @Override
    public void releasePbufferFromTexture() {
        if (!this.rtt) {
            throw new GLException("Shouldn't try to bind a pbuffer to a texture if render-to-texture hasn't been specified in its GLCapabilities");
        }
        if (this.rtt && !EGL.eglReleaseTexImage(this.drawable.getDisplay(), this.drawable.getSurface(), this.texture)) {
            throw new GLException(new StringBuffer().append("Releasing of pbuffer from texture failed: ").append(QNXPbufferGLContext.eglGetLastError()).toString());
        }
    }

    @Override
    protected int makeCurrentImpl() {
        if (this.drawable.getSurface() == 0) {
            if (DEBUG) {
                System.err.println("pbuffer not instantiated");
            }
            return 0;
        }
        int n = super.makeCurrentImpl();
        if (DEBUG && VERBOSE) {
            System.err.println(new StringBuffer().append("QNXPbufferGLContext: super.makeCurrentImpl() = ").append(n).toString());
        }
        if (n == 2) {
            GLCapabilities gLCapabilities = this.drawable.getCapabilities();
            this.rtt = gLCapabilities.getPbufferRenderToTexture();
            GL gL = this.getGL();
            if (this.rtt) {
                if (DEBUG) {
                    System.err.println("Initializing render-to-texture support");
                }
                this.textureTarget = 3553;
                int[] nArray = new int[1];
                gL.glGenTextures(1, nArray, 0);
                this.texture = nArray[0];
                gL.glBindTexture(this.textureTarget, this.texture);
                gL.glTexParameteri(this.textureTarget, 10241, 9728);
                gL.glTexParameteri(this.textureTarget, 10240, 9728);
                gL.glTexParameteri(this.textureTarget, 10242, 796983296);
                gL.glTexParameteri(this.textureTarget, 10243, 796983296);
                gL.glCopyTexImage2D(this.textureTarget, 0, 6407, 0, 0, this.drawable.getWidth(), this.drawable.getHeight(), 0);
            }
        }
        return n;
    }

    @Override
    public int getFloatingPointMode() {
        return this.drawable.getFloatingPointMode();
    }

    private static String eglGetLastError() {
        return QNXGLDrawableFactory.eglGetLastError();
    }
}

