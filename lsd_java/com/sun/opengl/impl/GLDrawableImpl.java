/*
 * Decompiled with CFR 0.152.
 */
package com.sun.opengl.impl;

import com.sun.opengl.impl.GLContextImpl;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLDrawable;

public abstract class GLDrawableImpl
implements GLDrawable {
    private GLCapabilities chosenCapabilities;

    public abstract void destroy() {
    }

    public static String toHexString(long l) {
        return GLContextImpl.toHexString(l);
    }

    @Override
    public GLCapabilities getChosenGLCapabilities() {
        if (this.chosenCapabilities == null) {
            return null;
        }
        return (GLCapabilities)this.chosenCapabilities.clone();
    }

    public void setChosenGLCapabilities(GLCapabilities gLCapabilities) {
        this.chosenCapabilities = gLCapabilities;
    }
}

