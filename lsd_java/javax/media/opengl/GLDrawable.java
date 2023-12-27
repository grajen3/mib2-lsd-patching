/*
 * Decompiled with CFR 0.152.
 */
package javax.media.opengl;

import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLContext;

public interface GLDrawable {
    default public GLContext createContext(GLContext gLContext) {
    }

    default public void setRealized(boolean bl) {
    }

    default public void setSize(int n, int n2) {
    }

    default public int getWidth() {
    }

    default public int getHeight() {
    }

    default public void swapBuffers() {
    }

    default public GLCapabilities getChosenGLCapabilities() {
    }

    default public GLContext getContext() {
    }
}

