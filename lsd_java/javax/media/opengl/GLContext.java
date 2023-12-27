/*
 * Decompiled with CFR 0.152.
 */
package javax.media.opengl;

import javax.media.opengl.GL;
import javax.media.opengl.GLDrawable;

public abstract class GLContext {
    public static final int CONTEXT_NOT_CURRENT;
    public static final int CONTEXT_CURRENT;
    public static final int CONTEXT_CURRENT_NEW;
    private static ThreadLocal currentContext;

    public abstract GLDrawable getGLDrawable() {
    }

    public abstract int makeCurrent() {
    }

    public abstract void release() {
    }

    public abstract void copy(GLContext gLContext, int n) {
    }

    public static GLContext getCurrent() {
        return (GLContext)currentContext.get();
    }

    protected static void setCurrent(GLContext gLContext) {
        currentContext.set(gLContext);
    }

    public abstract void destroy() {
    }

    public abstract boolean isSynchronized() {
    }

    public abstract void setSynchronized(boolean bl) {
    }

    public abstract GL getGL() {
    }

    public abstract void setGL(GL gL) {
    }

    static {
        currentContext = new ThreadLocal();
    }
}

