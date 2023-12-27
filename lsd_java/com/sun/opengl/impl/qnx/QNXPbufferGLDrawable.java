/*
 * Decompiled with CFR 0.152.
 */
package com.sun.opengl.impl.qnx;

import com.sun.opengl.impl.qnx.EGL;
import com.sun.opengl.impl.qnx.QNXGLDrawable;
import com.sun.opengl.impl.qnx.QNXGLDrawableFactory;
import com.sun.opengl.impl.qnx.QNXPbufferGLContext;
import com.sun.opengl.util.BufferUtil;
import java.nio.IntBuffer;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLCapabilitiesChooser;
import javax.media.opengl.GLContext;
import javax.media.opengl.GLException;

public class QNXPbufferGLDrawable
extends QNXGLDrawable {
    private long buffer;
    private int width;
    private int height;
    private int floatMode;

    public QNXPbufferGLDrawable(GLCapabilities gLCapabilities, GLCapabilitiesChooser gLCapabilitiesChooser, int n, int n2) {
        super(gLCapabilities, gLCapabilitiesChooser, null);
        this.setSize(n, n2);
        if (DEBUG) {
            System.out.println(new StringBuffer().append("Pbuffer caps on init: ").append(gLCapabilities).append(gLCapabilities.getPbufferRenderToTexture() ? " [rtt]" : "").append(gLCapabilities.getPbufferRenderToTextureRectangle() ? " [rect]" : "").append(gLCapabilities.getPbufferFloatingPointBuffers() ? " [float]" : "").toString());
        }
    }

    @Override
    public GLContext createContext(GLContext gLContext) {
        return new QNXPbufferGLContext(this, gLContext);
    }

    @Override
    public void setSize(int n, int n2) {
        this.width = n;
        this.height = n2;
        if (n <= 0 || n2 <= 0) {
            throw new GLException(new StringBuffer().append("Width and height of pbuffer must be positive (were (").append(n).append(", ").append(n2).append("))").toString());
        }
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    public GLCapabilities getCapabilities() {
        return this.capabilities;
    }

    public long getPbuffer() {
        return this.buffer;
    }

    public int getFloatingPointMode() {
        return this.floatMode;
    }

    @Override
    public void swapBuffers() {
    }

    public void init() {
        if (eglDisplay == 0) {
            eglDisplay = EGL.eglGetDisplay(0);
            EGL.eglInitialize(eglDisplay, null, null);
        }
        IntBuffer[] intBufferArray = QNXPbufferGLDrawable.convertGLCapabilitiesToEGLAttribs(this.capabilities, true, this.width, this.height);
        IntBuffer intBuffer = intBufferArray[0];
        IntBuffer intBuffer2 = intBufferArray[1];
        IntBuffer intBuffer3 = BufferUtil.newIntBuffer(1);
        if (!EGL.eglChooseConfig(eglDisplay, intBuffer2, null, 0, intBuffer3)) {
            String string = QNXGLDrawableFactory.eglGetLastError();
            throw new GLException(new StringBuffer().append("eglChooseConfig failed with egl error code ").append(string).toString());
        }
        if (intBuffer3.get(0) == 0) {
            throw new GLException("No suitable eglConfig found.");
        }
        IntBuffer intBuffer4 = BufferUtil.newIntBuffer(intBuffer3.get(0));
        intBuffer2.rewind();
        if (!EGL.eglChooseConfig(eglDisplay, intBuffer2, intBuffer4, intBuffer4.capacity(), intBuffer3)) {
            String string = QNXGLDrawableFactory.eglGetLastError();
            throw new GLException(new StringBuffer().append("eglChooseConfig failed with egl error code ").append(string).toString());
        }
        GLCapabilities[] gLCapabilitiesArray = this.getCapabilitiesArray(intBuffer4);
        int n = this.chooser.chooseCapabilities(this.capabilities, gLCapabilitiesArray, -1);
        this.eglConfig = intBuffer4.get(n);
        if (DEBUG) {
            System.out.println(new StringBuffer().append("Chosen config = ").append(this.eglConfig).append(" (index ").append(n).append(")").toString());
            System.out.println(gLCapabilitiesArray[n]);
        }
        this.eglSurface = EGL.eglCreatePbufferSurface(eglDisplay, this.eglConfig, intBuffer);
        if (this.eglSurface == 0) {
            String string = QNXGLDrawableFactory.eglGetLastError();
            throw new GLException(new StringBuffer().append("eglCreatePbufferSurface failed with egl error code ").append(string).toString());
        }
        IntBuffer intBuffer5 = BufferUtil.newIntBuffer(1);
        IntBuffer intBuffer6 = BufferUtil.newIntBuffer(1);
        if (!EGL.eglQuerySurface(eglDisplay, this.eglSurface, 12375, intBuffer5) || !EGL.eglQuerySurface(eglDisplay, this.eglSurface, 12374, intBuffer6)) {
            throw new GLException("Unable to query surface information -> creation of pbuffer has failed.");
        }
    }
}

