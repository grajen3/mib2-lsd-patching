/*
 * Decompiled with CFR 0.152.
 */
package com.sun.opengl.impl.qnx;

import com.sun.opengl.impl.qnx.QNXGLContext;
import com.sun.opengl.impl.qnx.QNXOnscreenGLDrawable;
import javax.media.opengl.GLContext;

public class QNXOnscreenGLContext
extends QNXGLContext {
    protected QNXOnscreenGLDrawable drawable;

    public QNXOnscreenGLContext(QNXOnscreenGLDrawable qNXOnscreenGLDrawable, GLContext gLContext) {
        super(qNXOnscreenGLDrawable, gLContext);
        this.drawable = qNXOnscreenGLDrawable;
    }
}

