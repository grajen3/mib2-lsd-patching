/*
 * Decompiled with CFR 0.152.
 */
package com.sun.opengl.impl;

import com.sun.opengl.impl.GLObjectTracker;
import com.sun.opengl.impl.GLObjectTracker$Deleter;
import javax.media.opengl.GL;

class GLObjectTracker$5
extends GLObjectTracker$Deleter {
    private final /* synthetic */ GLObjectTracker this$0;

    GLObjectTracker$5(GLObjectTracker gLObjectTracker) {
        this.this$0 = gLObjectTracker;
    }

    @Override
    public void delete(GL gL, int n) {
        gL.glDeleteShader(n);
    }
}

