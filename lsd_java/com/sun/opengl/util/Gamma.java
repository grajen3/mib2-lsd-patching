/*
 * Decompiled with CFR 0.152.
 */
package com.sun.opengl.util;

import com.sun.opengl.impl.GLDrawableFactoryImpl;

public class Gamma {
    private Gamma() {
    }

    public static boolean setDisplayGamma(float f2, float f3, float f4) {
        return GLDrawableFactoryImpl.getFactoryImpl().setDisplayGamma(f2, f3, f4);
    }

    public static void resetDisplayGamma() {
        GLDrawableFactoryImpl.getFactoryImpl().resetDisplayGamma();
    }
}

