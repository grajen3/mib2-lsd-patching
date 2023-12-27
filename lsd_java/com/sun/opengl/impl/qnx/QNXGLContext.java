/*
 * Decompiled with CFR 0.152.
 */
package com.sun.opengl.impl.qnx;

import com.sun.opengl.impl.GLContextImpl;
import com.sun.opengl.impl.GLContextShareSet;
import com.sun.opengl.impl.qnx.EGL;
import com.sun.opengl.impl.qnx.QNXGLDrawable;
import com.sun.opengl.impl.qnx.QNXGLDrawableFactory;
import com.sun.opengl.util.BufferUtil;
import java.nio.IntBuffer;
import javax.media.opengl.GLContext;
import javax.media.opengl.GLDrawable;
import javax.media.opengl.GLException;

public class QNXGLContext
extends GLContextImpl {
    protected QNXGLDrawable drawable;
    protected int eglContext;

    public QNXGLContext(QNXGLDrawable qNXGLDrawable, GLContext gLContext) {
        super(gLContext);
        this.drawable = qNXGLDrawable;
    }

    @Override
    public GLDrawable getGLDrawable() {
        return this.drawable;
    }

    public int getContext() {
        return this.eglContext;
    }

    protected void create() {
        if (this.drawable.getSurface() == 0) {
            throw new GLException("Internal error: attempted to create OpenGL context without an associated drawable");
        }
        QNXGLContext qNXGLContext = (QNXGLContext)GLContextShareSet.getShareContext(this);
        int n = 0;
        if (qNXGLContext != null) {
            n = qNXGLContext.getContext();
        }
        IntBuffer intBuffer = BufferUtil.newIntBuffer(3);
        intBuffer.put(new int[]{12440, 2, 12344});
        intBuffer.rewind();
        this.eglContext = EGL.eglCreateContext(this.drawable.getDisplay(), this.drawable.getConfig(), n, intBuffer);
        System.out.println(new StringBuffer().append("JOGL: [create] eglContext:").append(QNXGLContext.toHexString(this.eglContext)).append(" in thread ").append(QNXGLContext.getThreadName()).append(" (#").append(Thread.currentThread().hashCode()).append(")").toString());
        if (this.eglContext == 0) {
            String string = QNXGLDrawableFactory.eglGetLastError();
            throw new GLException(new StringBuffer().append("eglCreateContext failed with egl error code ").append(string).toString());
        }
        if (this.eglContext == 0) {
            throw new GLException(new StringBuffer().append("Unable to create OpenGL context for device context ").append(QNXGLContext.toHexString(this.drawable.getSurface())).toString());
        }
        if (DEBUG) {
            System.err.println(new StringBuffer().append(QNXGLContext.getThreadName()).append(": !!! Created OpenGL context ").append(QNXGLContext.toHexString(this.eglContext)).append(" for ").append(this).append(", device context ").append(QNXGLContext.toHexString(this.drawable.getSurface())).append(", not yet sharing").toString());
        }
        GLContextShareSet.contextCreated(this);
        if (DEBUG) {
            System.err.println(new StringBuffer().append(QNXGLContext.getThreadName()).append(": !!! Created OpenGL context ").append(QNXGLContext.toHexString(this.eglContext)).append(" for ").append(this).append(", device context ").append(QNXGLContext.toHexString(this.drawable.getSurface())).append(", sharing with ").append(QNXGLContext.toHexString(n)).toString());
        }
    }

    @Override
    protected int makeCurrentImpl() {
        if (DEBUG) {
            System.out.println("QNXGLContext.makeCurrentImpl()");
        }
        boolean bl = false;
        if (this.eglContext == 0) {
            if (this.drawable.getSurface() == 0) {
                throw new GLException("QNXGLContext.makeCurrent surface is 0");
            }
            this.create();
            if (DEBUG) {
                System.err.println(new StringBuffer().append(QNXGLContext.getThreadName()).append(": !!! Created GL context for ").append(super.getClass().getName()).toString());
            }
            bl = true;
        }
        boolean bl2 = false;
        if (NO_FREE && EGL.eglGetCurrentContext() == this.eglContext) {
            if (DEBUG && VERBOSE) {
                System.err.println(new StringBuffer().append(QNXGLContext.getThreadName()).append(": skipping EGLMakeCurrent because context already current").toString());
            }
            bl2 = true;
        }
        System.out.println(new StringBuffer().append("JOGL: [makeCurrentImpl] eglContext:").append(QNXGLContext.toHexString(this.eglContext)).append(" in thread ").append(QNXGLContext.getThreadName()).append(" (#").append(Thread.currentThread().hashCode()).append(")").toString());
        if (!bl2) {
            if (!EGL.eglMakeCurrent(this.drawable.getDisplay(), this.drawable.getSurface(), this.drawable.getSurface(), this.eglContext)) {
                throw new GLException(new StringBuffer().append("Error making context current: ").append(EGL.eglGetError()).toString());
            }
            if (DEBUG && VERBOSE) {
                System.err.println(new StringBuffer().append(QNXGLContext.getThreadName()).append(": EGLMakeCurrent(surface ").append(QNXGLContext.toHexString(this.drawable.getSurface())).append(", context ").append(QNXGLContext.toHexString(this.eglContext)).append(") succeeded").toString());
            }
        }
        if (bl) {
            return 2;
        }
        return 1;
    }

    @Override
    protected void releaseImpl() {
        System.out.println(new StringBuffer().append("JOGL: [releaseImpl] eglContext:").append(QNXGLContext.toHexString(this.eglContext)).append(" in thread ").append(QNXGLContext.getThreadName()).append(" (#").append(Thread.currentThread().hashCode()).append(")").toString());
        if (!NO_FREE && !EGL.eglMakeCurrent(this.drawable.getDisplay(), 0, 0, 0)) {
            throw new GLException(new StringBuffer().append("Error freeing OpenGL context: ").append(EGL.eglGetError()).toString());
        }
    }

    @Override
    protected void destroyImpl() {
        System.out.println(new StringBuffer().append("JOGL: [destroyImpl] eglContext:").append(QNXGLContext.toHexString(this.eglContext)).append(" in thread ").append(QNXGLContext.getThreadName()).append(" (#").append(Thread.currentThread().hashCode()).append(")").toString());
        if (this.eglContext != 0) {
            if (!EGL.eglDestroyContext(this.drawable.getDisplay(), this.eglContext)) {
                throw new GLException("Unable to delete OpenGL context");
            }
            if (DEBUG) {
                System.err.println(new StringBuffer().append(QNXGLContext.getThreadName()).append(": !!! Destroyed OpenGL context ").append(QNXGLContext.toHexString(this.eglContext)).toString());
            }
            this.eglContext = 0;
            GLContextShareSet.contextDestroyed(this);
        }
    }

    @Override
    public boolean isCreated() {
        return this.eglContext != 0;
    }

    @Override
    public void copy(GLContext gLContext, int n) {
        throw new GLException("Should not call this, not supported by EGL");
    }

    @Override
    public void setSwapInterval(int n) {
        EGL.eglSwapInterval(this.drawable.getDisplay(), n);
    }

    @Override
    public int getOffscreenContextPixelDataType() {
        throw new GLException("Should not call this");
    }

    public int getOffscreenContextReadBuffer() {
        throw new GLException("Should not call this");
    }

    @Override
    public boolean offscreenImageNeedsVerticalFlip() {
        throw new GLException("Should not call this");
    }

    @Override
    public void bindPbufferToTexture() {
        throw new GLException("Should not call this");
    }

    @Override
    public void releasePbufferFromTexture() {
        throw new GLException("Should not call this");
    }

    @Override
    public Object getPlatformGLExtensions() {
        return null;
    }

    @Override
    public String getPlatformExtensionsString() {
        return "";
    }

    @Override
    protected String mapToRealGLFunctionName(String string) {
        return "";
    }

    @Override
    protected String mapToRealGLExtensionName(String string) {
        return "";
    }
}

