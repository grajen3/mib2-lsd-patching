/*
 * Decompiled with CFR 0.152.
 */
package com.sun.opengl.impl.qnx;

import com.sun.opengl.impl.Debug;
import com.sun.opengl.impl.GLDrawableFactoryImpl;
import com.sun.opengl.impl.GLDrawableImpl;
import com.sun.opengl.impl.GLPbufferImpl;
import com.sun.opengl.impl.NativeLibLoader;
import com.sun.opengl.impl.qnx.EGL;
import com.sun.opengl.impl.qnx.QNXOnscreenGLDrawable;
import com.sun.opengl.impl.qnx.QNXPbufferGLDrawable;
import javax.media.opengl.AbstractGraphicsConfiguration;
import javax.media.opengl.AbstractGraphicsDevice;
import javax.media.opengl.DefaultGLCapabilitiesChooser;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLCapabilitiesChooser;
import javax.media.opengl.GLContext;
import javax.media.opengl.GLDrawable;
import javax.media.opengl.GLException;
import javax.media.opengl.GLPbuffer;

public class QNXGLDrawableFactory
extends GLDrawableFactoryImpl {
    private static final boolean DEBUG = Debug.debug("QNXGLDrawableFactory");
    private static final boolean VERBOSE = Debug.verbose();

    @Override
    public AbstractGraphicsConfiguration chooseGraphicsConfiguration(GLCapabilities gLCapabilities, GLCapabilitiesChooser gLCapabilitiesChooser, AbstractGraphicsDevice abstractGraphicsDevice) {
        return null;
    }

    @Override
    public GLDrawable getGLDrawable(Object object, GLCapabilities gLCapabilities, GLCapabilitiesChooser gLCapabilitiesChooser) {
        if (gLCapabilities == null) {
            gLCapabilities = new GLCapabilities();
        }
        if (gLCapabilitiesChooser == null) {
            gLCapabilitiesChooser = new DefaultGLCapabilitiesChooser();
        }
        return new QNXOnscreenGLDrawable(gLCapabilities, gLCapabilitiesChooser, object);
    }

    @Override
    public GLDrawableImpl createOffscreenDrawable(GLCapabilities gLCapabilities, GLCapabilitiesChooser gLCapabilitiesChooser) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean canCreateGLPbuffer() {
        return false;
    }

    @Override
    public GLPbuffer createGLPbuffer(GLCapabilities gLCapabilities, GLCapabilitiesChooser gLCapabilitiesChooser, int n, int n2, GLContext gLContext) {
        if (!this.canCreateGLPbuffer()) {
            throw new GLException("Pbuffer support not available with current graphics card");
        }
        if (gLCapabilities == null) {
            gLCapabilities = new GLCapabilities();
        }
        if (gLCapabilitiesChooser == null) {
            gLCapabilitiesChooser = new DefaultGLCapabilitiesChooser();
        }
        QNXPbufferGLDrawable qNXPbufferGLDrawable = new QNXPbufferGLDrawable(gLCapabilities, gLCapabilitiesChooser, n, n2);
        GLPbufferImpl gLPbufferImpl = new GLPbufferImpl(qNXPbufferGLDrawable, gLContext);
        return gLPbufferImpl;
    }

    @Override
    public GLContext createExternalGLContext() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean canCreateExternalGLDrawable() {
        return false;
    }

    @Override
    public GLDrawable createExternalGLDrawable() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void loadGLULibrary() {
        throw new GLException("There is no GLU implementation for the QNX target.");
    }

    @Override
    public long dynamicLookupFunction(String string) {
        throw new UnsupportedOperationException();
    }

    public static String eglGetLastError() {
        long l = EGL.eglGetError();
        String string = null;
        switch ((int)l) {
            case 12289: {
                string = "EGL_NOT_INITIALIZED";
                break;
            }
            case 12290: {
                string = "EGL_BAD_ACCESS";
                break;
            }
            case 12291: {
                string = "EGL_BAD_ALLOC";
                break;
            }
            case 12292: {
                string = "EGL_BAD_ATTRIBUTE";
                break;
            }
            case 12293: {
                string = "EGL_BAD_CONFIG";
                break;
            }
            case 12294: {
                string = "EGL_BAD_CONTEXT";
                break;
            }
            case 12295: {
                string = "EGL_BAD_CURRENT_SURFACE";
                break;
            }
            case 12296: {
                string = "EGL_BAD_DISPLAY";
                break;
            }
            case 12297: {
                string = "EGL_BAD_MATCH";
                break;
            }
            case 12298: {
                string = "EGL_BAD_NATIVE_PIXMAP";
                break;
            }
            case 12299: {
                string = "EGL_BAD_NATIVE_WINDOW";
                break;
            }
            case 12300: {
                string = "EGL_BAD_PARAMETER";
                break;
            }
            case 12301: {
                string = "EGL_BAD_SURFACE";
                break;
            }
            case 12302: {
                string = "EGL_CONTEXT_LOST";
                break;
            }
            case 12288: {
                string = "EGL_SUCCESS";
                break;
            }
            default: {
                string = new StringBuffer().append("(Unknown error code ").append(l).append(")").toString();
            }
        }
        return string;
    }

    static {
        NativeLibLoader.loadCore();
    }
}

