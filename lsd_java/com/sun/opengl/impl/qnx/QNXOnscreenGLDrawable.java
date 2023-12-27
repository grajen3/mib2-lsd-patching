/*
 * Decompiled with CFR 0.152.
 */
package com.sun.opengl.impl.qnx;

import com.sun.opengl.impl.GLImplCQ;
import com.sun.opengl.impl.qnx.EGL;
import com.sun.opengl.impl.qnx.QNXGLDrawable;
import com.sun.opengl.impl.qnx.QNXOnscreenGLContext;
import com.sun.opengl.util.HighPrecisionTimer;
import com.sun.opengl.util.KernelTraceLogger;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLCapabilitiesChooser;
import javax.media.opengl.GLContext;
import javax.media.opengl.GLException;

public class QNXOnscreenGLDrawable
extends QNXGLDrawable {
    protected boolean realized;
    private boolean commandQueueingEnabled;
    private boolean kernelTracesEnabled;
    private boolean firstFrame = true;
    private HighPrecisionTimer hpTimer;

    public QNXOnscreenGLDrawable(GLCapabilities gLCapabilities, GLCapabilitiesChooser gLCapabilitiesChooser, Object object) {
        super(gLCapabilities, gLCapabilitiesChooser, object);
    }

    @Override
    public GLContext createContext(GLContext gLContext) {
        this.context = new QNXOnscreenGLContext(this, gLContext);
        return this.context;
    }

    @Override
    public void setRealized(boolean bl) {
        this.realized = bl;
        if (!bl) {
            this.setChosenGLCapabilities(null);
            this.pixelFormatChosen = false;
        }
    }

    @Override
    public void setSize(int n, int n2) {
        throw new GLException("Not yet implemented");
    }

    @Override
    public int getWidth() {
        return EGL.kdGetDisplayWidth();
    }

    @Override
    public int getHeight() {
        return EGL.kdGetDisplayHeight();
    }

    @Override
    public void swapBuffers() {
        GLImplCQ gLImplCQ;
        long l = 0L;
        if (this.firstFrame) {
            this.commandQueueingEnabled = this.context.getGL() instanceof GLImplCQ;
            if (this.commandQueueingEnabled) {
                this.kernelTracesEnabled = ((GLImplCQ)this.context.getGL()).isKernelTracingEnabled();
                gLImplCQ = (GLImplCQ)this.context.getGL();
                if (gLImplCQ.isPerformanceStatisticsEnabled() && this.hpTimer == null) {
                    this.hpTimer = new HighPrecisionTimer();
                }
            }
            this.firstFrame = false;
        }
        if (this.commandQueueingEnabled) {
            gLImplCQ = (GLImplCQ)this.context.getGL();
            if (gLImplCQ.isDebuggingEnabled() && gLImplCQ.getDebugLevel() >= 2) {
                System.out.println("JOGL: drawable.swapBuffers() -> flushes the queue");
            }
            gLImplCQ.flushQueue();
            if (gLImplCQ.isPerformanceStatisticsEnabled()) {
                l = this.hpTimer.getClockCycles();
            }
        }
        if (this.kernelTracesEnabled) {
            KernelTraceLogger.setKernelTraceUserEvent("java: start of eglSwapBuffers");
        }
        if (!EGL.eglSwapBuffers(eglDisplay, this.eglSurface) && EGL.eglGetError() != 0) {
            throw new GLException("Error swapping buffers");
        }
        if (this.kernelTracesEnabled) {
            KernelTraceLogger.setKernelTraceUserEvent("java: end of eglSwapBuffers");
        }
        if (this.commandQueueingEnabled && (gLImplCQ = (GLImplCQ)this.context.getGL()).isPerformanceStatisticsEnabled()) {
            long l2 = this.hpTimer.getClockCycles();
            gLImplCQ.printPerformanceStatistics(this.hpTimer.calculateMicroSecDiff(l, l2));
            gLImplCQ.resetPerformanceStatistics();
        }
    }
}

