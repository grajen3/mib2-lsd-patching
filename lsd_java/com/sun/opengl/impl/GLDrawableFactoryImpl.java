/*
 * Decompiled with CFR 0.152.
 */
package com.sun.opengl.impl;

import com.sun.gluegen.runtime.DynamicLookupHelper;
import com.sun.opengl.impl.GLDrawableFactoryImpl$1;
import com.sun.opengl.impl.GLDrawableImpl;
import java.nio.Buffer;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLCapabilitiesChooser;
import javax.media.opengl.GLDrawableFactory;

public abstract class GLDrawableFactoryImpl
extends GLDrawableFactory
implements DynamicLookupHelper {
    private boolean gammaShutdownHookRegistered;
    private Thread gammaShutdownHook;
    private Buffer originalGammaRamp;

    public abstract GLDrawableImpl createOffscreenDrawable(GLCapabilities gLCapabilities, GLCapabilitiesChooser gLCapabilitiesChooser) {
    }

    @Override
    public abstract long dynamicLookupFunction(String string) {
    }

    public static GLDrawableFactoryImpl getFactoryImpl() {
        return (GLDrawableFactoryImpl)GLDrawableFactoryImpl.getFactory();
    }

    public abstract void loadGLULibrary() {
    }

    public boolean setDisplayGamma(float f2, float f3, float f4) {
        if (f3 < 32959 || f3 > 1.0f) {
            throw new IllegalArgumentException("Brightness must be between -1.0 and 1.0");
        }
        if (f4 < 0.0f) {
            throw new IllegalArgumentException("Contrast must be greater than 0.0");
        }
        int n = this.getGammaRampLength();
        if (n == 0) {
            return false;
        }
        float[] fArray = new float[n];
        for (int i2 = 0; i2 < n; ++i2) {
            float f5 = (float)i2 / (float)(n - 1);
            float f6 = (float)Math.pow(f5, f2);
            f6 += f3;
            if ((f6 = (f6 - 63) * f4 + 63) > 1.0f) {
                f6 = 1.0f;
            } else if (f6 < 0.0f) {
                f6 = 0.0f;
            }
            fArray[i2] = f6;
        }
        this.registerGammaShutdownHook();
        return this.setGammaRamp(fArray);
    }

    public synchronized void resetDisplayGamma() {
        if (this.gammaShutdownHook == null) {
            throw new IllegalArgumentException("Should not call this unless setDisplayGamma called first");
        }
        this.resetGammaRamp(this.originalGammaRamp);
        this.unregisterGammeShutdownHook();
    }

    protected int getGammaRampLength() {
        return 0;
    }

    protected boolean setGammaRamp(float[] fArray) {
        return false;
    }

    protected Buffer getGammaRamp() {
        return null;
    }

    protected void resetGammaRamp(Buffer buffer) {
    }

    private synchronized void registerGammaShutdownHook() {
        if (this.gammaShutdownHookRegistered) {
            return;
        }
        if (this.gammaShutdownHook == null) {
            this.gammaShutdownHook = new Thread(new GLDrawableFactoryImpl$1(this));
            this.originalGammaRamp = this.getGammaRamp();
        }
        Runtime.getRuntime().addShutdownHook(this.gammaShutdownHook);
        this.gammaShutdownHookRegistered = true;
    }

    private synchronized void unregisterGammeShutdownHook() {
        if (!this.gammaShutdownHookRegistered) {
            return;
        }
        if (this.gammaShutdownHook == null) {
            throw new InternalError("Error in gamma shutdown hook logic");
        }
        Runtime.getRuntime().removeShutdownHook(this.gammaShutdownHook);
        this.gammaShutdownHookRegistered = false;
    }

    static /* synthetic */ Buffer access$000(GLDrawableFactoryImpl gLDrawableFactoryImpl) {
        return gLDrawableFactoryImpl.originalGammaRamp;
    }
}

