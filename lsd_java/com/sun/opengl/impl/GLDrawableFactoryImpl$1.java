/*
 * Decompiled with CFR 0.152.
 */
package com.sun.opengl.impl;

import com.sun.opengl.impl.GLDrawableFactoryImpl;

class GLDrawableFactoryImpl$1
implements Runnable {
    private final /* synthetic */ GLDrawableFactoryImpl this$0;

    GLDrawableFactoryImpl$1(GLDrawableFactoryImpl gLDrawableFactoryImpl) {
        this.this$0 = gLDrawableFactoryImpl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        GLDrawableFactoryImpl gLDrawableFactoryImpl = this.this$0;
        synchronized (gLDrawableFactoryImpl) {
            this.this$0.resetGammaRamp(GLDrawableFactoryImpl.access$000(this.this$0));
        }
    }
}

