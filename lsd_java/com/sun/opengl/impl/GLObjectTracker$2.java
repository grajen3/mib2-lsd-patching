/*
 * Decompiled with CFR 0.152.
 */
package com.sun.opengl.impl;

import com.sun.opengl.impl.GLObjectTracker;
import com.sun.opengl.impl.GLObjectTracker$Deleter;
import javax.media.opengl.GL;

class GLObjectTracker$2
extends GLObjectTracker$Deleter {
    private final /* synthetic */ GLObjectTracker this$0;

    GLObjectTracker$2(GLObjectTracker gLObjectTracker) {
        this.this$0 = gLObjectTracker;
    }

    @Override
    public void delete(GL gL, int n) {
        gL.glDeleteFramebuffers(1, new int[]{n}, 0);
    }
}

