/*
 * Decompiled with CFR 0.152.
 */
package com.sun.opengl.impl.qnx;

import com.sun.opengl.impl.Debug;
import com.sun.opengl.impl.GLDrawableImpl;
import com.sun.opengl.impl.qnx.EGL;
import com.sun.opengl.impl.qnx.QNXGLDrawableFactory;
import com.sun.opengl.util.BufferUtil;
import java.nio.IntBuffer;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLCapabilitiesChooser;
import javax.media.opengl.GLContext;
import javax.media.opengl.GLException;

public abstract class QNXGLDrawable
extends GLDrawableImpl {
    protected static final boolean DEBUG = Debug.debug("QNXGLDrawable");
    private static final boolean USE_COVERAGE_SAMPLING_ANTIALIASING = System.getProperty("csaa") != null;
    private static final int NUM_COVERAGE_SAMPLES_SUPPORTED;
    private static final int NUM_FULLSCREEN_SAMPLES_SUPPORTED;
    protected GLCapabilities capabilities;
    protected GLCapabilitiesChooser chooser;
    protected boolean pixelFormatChosen;
    protected static int eglDisplay;
    protected static int refCounter;
    protected int eglSurface;
    protected int eglConfig;
    protected GLContext context;
    protected int[] kdHandle;

    public QNXGLDrawable(GLCapabilities gLCapabilities, GLCapabilitiesChooser gLCapabilitiesChooser, Object object) {
        this.capabilities = (GLCapabilities)gLCapabilities.clone();
        this.chooser = gLCapabilitiesChooser;
        int n = 16;
        if (object != null && object instanceof Integer) {
            n = (Integer)object;
        }
        this.init(n);
        ++refCounter;
    }

    @Override
    public void setRealized(boolean bl) {
        throw new GLException("Should not call this (should only be called for onscreen GLDrawables)");
    }

    @Override
    public void destroy() {
        EGL.eglMakeCurrent(eglDisplay, 0, 0, 0);
        if (!EGL.eglDestroySurface(eglDisplay, this.eglSurface)) {
            throw new GLException("could not destroy GLDrawable");
        }
        EGL.kdWindowDestroy(this.kdHandle, 0);
        if (--refCounter == 0) {
            if (DEBUG) {
                System.out.println("QNXGLDrawable.destroy(): refCounter == 0 -> cleaning up EGL");
            }
            EGL.eglTerminate(eglDisplay);
            EGL.eglReleaseThread();
            EGL.kdDeinit();
            eglDisplay = 0;
        }
    }

    @Override
    public void swapBuffers() {
        throw new GLException("Should not call this. Must be overwritten in the subclasses.");
    }

    public int getSurface() {
        return this.eglSurface;
    }

    public int getDisplay() {
        return eglDisplay;
    }

    public int getConfig() {
        return this.eglConfig;
    }

    protected GLCapabilities[] getCapabilitiesArray(IntBuffer intBuffer) {
        int n = intBuffer.capacity();
        GLCapabilities[] gLCapabilitiesArray = new GLCapabilities[n];
        for (int i2 = 0; i2 < n; ++i2) {
            gLCapabilitiesArray[i2] = QNXGLDrawable.convertEGLAttribsToGLCapabilities(QNXGLDrawable.queryEGLConfigAttribs(intBuffer.get(i2)), null);
        }
        return gLCapabilitiesArray;
    }

    public void init(int n) {
        EGL.kdInit();
        if (eglDisplay == 0) {
            eglDisplay = EGL.eglGetDisplay(0);
            EGL.eglInitialize(eglDisplay, null, null);
        }
        IntBuffer[] intBufferArray = QNXGLDrawable.convertGLCapabilitiesToEGLAttribs(this.capabilities, false, 0, 0);
        IntBuffer intBuffer = intBufferArray[0];
        IntBuffer intBuffer2 = intBufferArray[1];
        IntBuffer intBuffer3 = BufferUtil.newIntBuffer(1);
        if (!EGL.eglChooseConfig(eglDisplay, intBuffer2, null, 0, intBuffer3)) {
            String string = QNXGLDrawableFactory.eglGetLastError();
            throw new GLException(new StringBuffer().append("eglChooseConfig failed with egl error code ").append(string).toString());
        }
        if (intBuffer3.get(0) == 0) {
            throw new GLException("No suitable eglConfig found.");
        }
        IntBuffer intBuffer4 = BufferUtil.newIntBuffer(intBuffer3.get(0));
        intBuffer2.rewind();
        if (!EGL.eglChooseConfig(eglDisplay, intBuffer2, intBuffer4, intBuffer4.capacity(), intBuffer3)) {
            String string = QNXGLDrawableFactory.eglGetLastError();
            throw new GLException(new StringBuffer().append("eglChooseConfig failed with egl error code ").append(string).toString());
        }
        GLCapabilities[] gLCapabilitiesArray = this.getCapabilitiesArray(intBuffer4);
        int n2 = this.chooser.chooseCapabilities(this.capabilities, gLCapabilitiesArray, -1);
        this.eglConfig = intBuffer4.get(n2);
        if (DEBUG) {
            System.out.println(new StringBuffer().append("Chosen config = ").append(Integer.toHexString(this.eglConfig)).append(" (index ").append(n2).append(")").toString());
            System.out.println(new StringBuffer().append("Chosen capabilities = ").append(gLCapabilitiesArray[n2]).toString());
        }
        this.kdHandle = new int[1];
        int n3 = EGL.kdWindowCreate(eglDisplay, this.eglConfig, n, this.kdHandle, 0);
        this.eglSurface = EGL.eglCreateWindowSurface(eglDisplay, this.eglConfig, n3, intBuffer);
        if (this.eglSurface == 0) {
            String string = QNXGLDrawableFactory.eglGetLastError();
            throw new GLException(new StringBuffer().append("eglCreateWindowSurface failed with egl error code ").append(string).toString());
        }
        int[] nArray = QNXGLDrawable.queryEGLConfigAttribs(this.eglConfig);
        int[] nArray2 = QNXGLDrawable.queryEGLSurfaceAttribs(this.eglSurface);
        GLCapabilities gLCapabilities = QNXGLDrawable.convertEGLAttribsToGLCapabilities(nArray, nArray2);
        super.setChosenGLCapabilities(gLCapabilities);
    }

    protected static String getThreadName() {
        return Thread.currentThread().getName();
    }

    protected static int[] queryEGLConfigAttribs(int n) {
        IntBuffer intBuffer = BufferUtil.newIntBuffer(1);
        int[] nArray = new int[23];
        nArray[0] = 12324;
        EGL.eglGetConfigAttrib(eglDisplay, n, 12324, intBuffer);
        nArray[1] = intBuffer.get(0);
        nArray[2] = 12323;
        EGL.eglGetConfigAttrib(eglDisplay, n, 12323, intBuffer);
        nArray[3] = intBuffer.get(0);
        nArray[4] = 12322;
        EGL.eglGetConfigAttrib(eglDisplay, n, 12322, intBuffer);
        nArray[5] = intBuffer.get(0);
        nArray[6] = 12321;
        EGL.eglGetConfigAttrib(eglDisplay, n, 12321, intBuffer);
        nArray[7] = intBuffer.get(0);
        nArray[8] = 12325;
        EGL.eglGetConfigAttrib(eglDisplay, n, 12325, intBuffer);
        nArray[9] = intBuffer.get(0);
        nArray[10] = 12326;
        EGL.eglGetConfigAttrib(eglDisplay, n, 12326, intBuffer);
        nArray[11] = intBuffer.get(0);
        if (USE_COVERAGE_SAMPLING_ANTIALIASING) {
            nArray[12] = 12512;
            EGL.eglGetConfigAttrib(eglDisplay, n, 12512, intBuffer);
            nArray[13] = intBuffer.get(0);
            nArray[14] = 12513;
            EGL.eglGetConfigAttrib(eglDisplay, n, 12513, intBuffer);
            nArray[15] = intBuffer.get(0);
        } else {
            nArray[12] = 12337;
            EGL.eglGetConfigAttrib(eglDisplay, n, 12337, intBuffer);
            nArray[13] = intBuffer.get(0);
            nArray[14] = 12338;
            EGL.eglGetConfigAttrib(eglDisplay, n, 12338, intBuffer);
            nArray[15] = intBuffer.get(0);
        }
        nArray[16] = 12352;
        EGL.eglGetConfigAttrib(eglDisplay, n, 12352, intBuffer);
        nArray[17] = intBuffer.get(0);
        nArray[18] = 12339;
        EGL.eglGetConfigAttrib(eglDisplay, n, 12339, intBuffer);
        nArray[19] = intBuffer.get(0);
        nArray[20] = 12345;
        EGL.eglGetConfigAttrib(eglDisplay, n, 12345, intBuffer);
        nArray[21] = intBuffer.get(0);
        nArray[22] = 12344;
        return nArray;
    }

    protected static int[] queryEGLSurfaceAttribs(int n) {
        IntBuffer intBuffer = BufferUtil.newIntBuffer(1);
        int[] nArray = new int[13];
        nArray[0] = 12422;
        EGL.eglQuerySurface(eglDisplay, n, 12422, intBuffer);
        nArray[1] = intBuffer.get(0);
        nArray[2] = 12417;
        EGL.eglQuerySurface(eglDisplay, n, 12417, intBuffer);
        nArray[3] = intBuffer.get(0);
        nArray[4] = 12416;
        EGL.eglQuerySurface(eglDisplay, n, 12416, intBuffer);
        nArray[5] = intBuffer.get(0);
        nArray[6] = 12375;
        EGL.eglQuerySurface(eglDisplay, n, 12375, intBuffer);
        nArray[7] = intBuffer.get(0);
        nArray[8] = 12374;
        EGL.eglQuerySurface(eglDisplay, n, 12374, intBuffer);
        nArray[9] = intBuffer.get(0);
        nArray[12] = 12344;
        return nArray;
    }

    protected static GLCapabilities convertEGLAttribsToGLCapabilities(int[] nArray, int[] nArray2) {
        GLCapabilities gLCapabilities = new GLCapabilities();
        int n = 0;
        block25: while (nArray[n] != 12344) {
            switch (nArray[n]) {
                case 12324: {
                    int n2 = ++n;
                    ++n;
                    gLCapabilities.setRedBits(nArray[n2]);
                    continue block25;
                }
                case 12323: {
                    int n3 = ++n;
                    ++n;
                    gLCapabilities.setGreenBits(nArray[n3]);
                    continue block25;
                }
                case 12322: {
                    int n4 = ++n;
                    ++n;
                    gLCapabilities.setBlueBits(nArray[n4]);
                    continue block25;
                }
                case 12321: {
                    int n5 = ++n;
                    ++n;
                    gLCapabilities.setAlphaBits(nArray[n5]);
                    continue block25;
                }
                case 12325: {
                    int n6 = ++n;
                    ++n;
                    gLCapabilities.setDepthBits(nArray[n6]);
                    continue block25;
                }
                case 12326: {
                    int n7 = ++n;
                    ++n;
                    gLCapabilities.setStencilBits(nArray[n7]);
                    continue block25;
                }
                case 12337: {
                    if (USE_COVERAGE_SAMPLING_ANTIALIASING) {
                        ++n;
                        ++n;
                        continue block25;
                    }
                    int n8 = ++n;
                    ++n;
                    int n9 = nArray[n8];
                    if (n9 > 0) {
                        gLCapabilities.setNumSamples(4);
                        gLCapabilities.setSampleBuffers(true);
                        continue block25;
                    }
                    gLCapabilities.setNumSamples(0);
                    gLCapabilities.setSampleBuffers(false);
                    continue block25;
                }
                case 12338: {
                    ++n;
                    ++n;
                    continue block25;
                }
                case 12513: {
                    int n9;
                    if (USE_COVERAGE_SAMPLING_ANTIALIASING) {
                        int n10 = ++n;
                        ++n;
                        n9 = nArray[n10];
                        if (n9 > 0) {
                            gLCapabilities.setNumSamples(5);
                            gLCapabilities.setSampleBuffers(true);
                            continue block25;
                        }
                        gLCapabilities.setNumSamples(0);
                        gLCapabilities.setSampleBuffers(false);
                        continue block25;
                    }
                    ++n;
                    ++n;
                    continue block25;
                }
                case 12512: {
                    ++n;
                    ++n;
                    continue block25;
                }
                case 12352: {
                    ++n;
                    ++n;
                    continue block25;
                }
                case 12339: {
                    ++n;
                    ++n;
                    continue block25;
                }
                case 12345: {
                    int n11 = ++n;
                    ++n;
                    gLCapabilities.setPbufferRenderToTexture(nArray[n11] == 1);
                    continue block25;
                }
                case 12346: {
                    int n12 = ++n;
                    ++n;
                    gLCapabilities.setPbufferRenderToTexture(nArray[n12] == 1);
                    continue block25;
                }
            }
            System.err.println(new StringBuffer().append("ERROR: convertEGLAttribsToGLCapabilities: Unsupported attribute (0x").append(Integer.toHexString(nArray[n])).append(") in the configAttribs.").toString());
            ++n;
            ++n;
        }
        if (nArray2 != null) {
            n = 0;
            block26: while (nArray2[n] != 12344) {
                switch (nArray2[n]) {
                    case 12422: {
                        int n13 = ++n;
                        ++n;
                        gLCapabilities.setDoubleBuffered(nArray2[n13] == 12420);
                        continue block26;
                    }
                    case 12417: {
                        int n14 = ++n;
                        ++n;
                        gLCapabilities.setPbufferRenderToTexture(nArray2[n14] == 12383);
                        continue block26;
                    }
                    case 12339: {
                        ++n;
                        ++n;
                        continue block26;
                    }
                    case 12416: {
                        ++n;
                        ++n;
                        continue block26;
                    }
                    case 12375: {
                        ++n;
                        ++n;
                        continue block26;
                    }
                    case 12374: {
                        ++n;
                        ++n;
                        continue block26;
                    }
                    case 0: {
                        ++n;
                        ++n;
                        continue block26;
                    }
                }
                System.err.println(new StringBuffer().append("ERROR: convertEGLAttribsToGLCapabilities: Unsupported attribute (0x").append(Integer.toHexString(nArray2[n])).append(") in the surfaceAttribs.").toString());
                ++n;
                ++n;
            }
        }
        return gLCapabilities;
    }

    protected static IntBuffer[] convertGLCapabilitiesToEGLAttribs(GLCapabilities gLCapabilities, boolean bl, int n, int n2) {
        IntBuffer intBuffer = BufferUtil.newIntBuffer(32);
        IntBuffer intBuffer2 = BufferUtil.newIntBuffer(32);
        intBuffer.put(12324);
        intBuffer.put(gLCapabilities.getRedBits());
        intBuffer.put(12323);
        intBuffer.put(gLCapabilities.getGreenBits());
        intBuffer.put(12322);
        intBuffer.put(gLCapabilities.getBlueBits());
        intBuffer.put(12321);
        intBuffer.put(gLCapabilities.getAlphaBits());
        intBuffer.put(12325);
        intBuffer.put(gLCapabilities.getDepthBits());
        intBuffer.put(12326);
        intBuffer.put(gLCapabilities.getStencilBits());
        if (gLCapabilities.getSampleBuffers()) {
            if (USE_COVERAGE_SAMPLING_ANTIALIASING) {
                intBuffer.put(12512);
                intBuffer.put(1);
                intBuffer.put(12513);
                intBuffer.put(5);
            } else {
                intBuffer.put(12337);
                intBuffer.put(4);
            }
        }
        intBuffer.put(12352);
        intBuffer.put(4);
        if (bl) {
            intBuffer.put(12339);
            intBuffer.put(1);
            if (gLCapabilities.getPbufferRenderToTexture()) {
                intBuffer.put(12345);
                intBuffer.put(1);
            }
        }
        intBuffer2.put(12422);
        if (gLCapabilities.getDoubleBuffered()) {
            intBuffer2.put(12420);
        } else {
            intBuffer2.put(12421);
        }
        if (bl) {
            if (gLCapabilities.getPbufferRenderToTexture()) {
                intBuffer2.put(12417);
                intBuffer2.put(12383);
                intBuffer2.put(12416);
                intBuffer2.put(12381);
            }
            intBuffer2.put(12375);
            intBuffer2.put(n2);
            intBuffer2.put(12374);
            intBuffer2.put(n);
            intBuffer2.put(12339);
            intBuffer2.put(1);
        }
        intBuffer.put(12344);
        intBuffer.rewind();
        intBuffer2.put(12344);
        intBuffer2.rewind();
        IntBuffer[] intBufferArray = new IntBuffer[]{BufferUtil.copyIntBuffer(intBuffer2), BufferUtil.copyIntBuffer(intBuffer)};
        return intBufferArray;
    }

    @Override
    public GLContext getContext() {
        return this.context;
    }

    static {
        eglDisplay = 0;
        refCounter = 0;
    }
}

