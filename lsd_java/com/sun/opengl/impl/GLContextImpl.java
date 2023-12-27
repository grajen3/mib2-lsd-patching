/*
 * Decompiled with CFR 0.152.
 */
package com.sun.opengl.impl;

import com.sun.gluegen.runtime.ProcAddressHelper;
import com.sun.opengl.impl.Debug;
import com.sun.opengl.impl.ExtensionAvailabilityCache;
import com.sun.opengl.impl.GLBufferSizeTracker;
import com.sun.opengl.impl.GLContextLock;
import com.sun.opengl.impl.GLContextShareSet;
import com.sun.opengl.impl.GLDrawableFactoryImpl;
import com.sun.opengl.impl.GLImpl;
import com.sun.opengl.impl.GLImplCQ;
import com.sun.opengl.impl.GLObjectTracker;
import com.sun.opengl.impl.GLProcAddressTable;
import com.sun.opengl.util.JoglCommon;
import javax.media.opengl.GL;
import javax.media.opengl.GLContext;
import javax.media.opengl.GLException;
import javax.media.opengl.TraceGL;

public abstract class GLContextImpl
extends GLContext {
    protected GLContextLock lock = new GLContextLock();
    protected static final boolean DEBUG = Debug.debug("GLContextImpl");
    protected static final boolean VERBOSE = Debug.verbose();
    protected static final boolean NO_FREE = Debug.isPropertyDefined("jogl.GLContext.nofree");
    protected static final boolean ENABLE_COMMAND_QUEUEING = Debug.isPropertyDefined("jogl.enableCommandQueueing") ? Debug.getBooleanProperty("jogl.enableCommandQueueing") : true;
    protected static final boolean ENABLE_GL_TRACING = Debug.getBooleanProperty("jogl.enableGLTracing");
    protected static final int GL_TRACE_LEVEL = Integer.parseInt(System.getProperty("jogl.GLTracingLevel", "2"));
    protected static final boolean ENABLE_KERNEL_TRACING = Debug.getBooleanProperty("jogl.enableKernelTracing");
    protected static final boolean ENABLE_PERFORMANCE_STATISTICS = Debug.getBooleanProperty("jogl.enablePerformanceStatistics");
    protected static final int PERFORMANCE_STATISTICS_LEVEL = Integer.parseInt(System.getProperty("jogl.performanceStatisticsLevel", "1"));
    protected static final boolean ENABLE_GLFINISH_AFTER_FLUSHQUEUE = Debug.getBooleanProperty("jogl.enableGLFinishAfterFlushQueue");
    protected boolean optimizationEnabled = Debug.isPropertyDefined("jogl.GLContext.optimize");
    protected ExtensionAvailabilityCache extensionAvailability;
    private GLProcAddressTable glProcAddressTable;
    private GLBufferSizeTracker bufferSizeTracker;
    private GLObjectTracker tracker;
    private GLObjectTracker deletedObjectTracker;
    protected GL gl;

    public GLContextImpl(GLContext gLContext) {
        String string = JoglCommon.getNativeVersion();
        String string2 = JoglCommon.getJavaVersion();
        if (!string.equals(string2)) {
            throw new GLException(new StringBuffer().append("JOGL: Java and native library version mismatch (libjogl.so version = ").append(string).append(", jogl.jar version = ").append(string2).append(")").toString());
        }
        System.out.println(new StringBuffer().append("JOGL: JOGL version = ").append(string2).toString());
        this.extensionAvailability = new ExtensionAvailabilityCache(this);
        GLContext gLContext2 = gLContext;
        if (gLContext2 != null) {
            GLContextShareSet.registerSharing(this, gLContext2);
        }
        GLContextShareSet.registerForObjectTracking(gLContext, this, gLContext2);
        GLContextShareSet.registerForBufferObjectSharing(gLContext, this);
        this.setGL(this.createGL());
    }

    @Override
    public int makeCurrent() {
        GLContext gLContext;
        if (DEBUG) {
            System.out.println("GLContextImpl.makeCurrent()");
        }
        if ((gLContext = GLContextImpl.getCurrent()) != null) {
            if (gLContext == this) {
                if (DEBUG) {
                    System.out.println("GLContextImpl.makeCurrent(): current == this");
                }
                this.update();
                return 1;
            }
            gLContext.release();
        }
        this.lock.lock();
        int n = 0;
        try {
            if (DEBUG) {
                System.out.println("GLContextImpl.makeCurrent(): calling makeCurrentImpl()");
            }
            n = this.makeCurrentImpl();
            if (this.tracker != null && n == 2) {
                this.tracker.ref();
            }
        }
        catch (GLException gLException) {
            this.lock.unlock();
            throw gLException;
        }
        if (n == 0) {
            this.lock.unlock();
        } else {
            GLContextImpl.setCurrent(this);
            if (this.deletedObjectTracker != null) {
                this.deletedObjectTracker.clean(this.getGL());
            }
        }
        return n;
    }

    protected abstract int makeCurrentImpl() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void release() {
        if (!this.lock.isHeld()) {
            throw new GLException("Context not current on current thread");
        }
        GLContextImpl.setCurrent(null);
        try {
            this.releaseImpl();
        }
        finally {
            this.lock.unlock();
        }
    }

    protected abstract void releaseImpl() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void destroy() {
        if (this.lock.isHeld()) {
            throw new GLException("Can not destroy context while it is current");
        }
        if (this.tracker != null && this.isCreated()) {
            this.tracker.unref(this.deletedObjectTracker);
        }
        this.bufferSizeTracker.clearCachedBufferSizes();
        this.lock.lock();
        try {
            this.destroyImpl();
        }
        finally {
            this.lock.unlock();
        }
    }

    protected abstract void destroyImpl() {
    }

    protected void update() {
    }

    @Override
    public boolean isSynchronized() {
        return !this.lock.getFailFastMode();
    }

    @Override
    public void setSynchronized(boolean bl) {
        this.lock.setFailFastMode(!bl);
    }

    @Override
    public GL getGL() {
        return this.gl;
    }

    @Override
    public void setGL(GL gL) {
        this.gl = gL;
    }

    public abstract Object getPlatformGLExtensions() {
    }

    protected GL createGL() {
        if (ENABLE_COMMAND_QUEUEING) {
            GLImplCQ gLImplCQ = new GLImplCQ(this);
            if (ENABLE_GL_TRACING) {
                gLImplCQ.setDebuggingEnabled(true);
                gLImplCQ.setDebugLevel(GL_TRACE_LEVEL);
            }
            if (ENABLE_KERNEL_TRACING) {
                gLImplCQ.setKernelTracesEnabled(true);
            }
            if (ENABLE_PERFORMANCE_STATISTICS) {
                gLImplCQ.setPerformanceStatisticsEnabled(true);
                gLImplCQ.setPerformanceStatisticsLevel(PERFORMANCE_STATISTICS_LEVEL);
                gLImplCQ.resetPerformanceStatistics();
            }
            if (ENABLE_GLFINISH_AFTER_FLUSHQUEUE) {
                gLImplCQ.setGLFinishAfterFlushQueueEnabled(true);
            }
            return gLImplCQ;
        }
        GLImpl gLImpl = new GLImpl(this);
        if (this.tracker != null) {
            gLImpl.setObjectTracker(this.tracker);
        }
        if (ENABLE_GL_TRACING) {
            TraceGL traceGL = new TraceGL(gLImpl, System.out);
            return traceGL;
        }
        return gLImpl;
    }

    public GLProcAddressTable getGLProcAddressTable() {
        if (this.glProcAddressTable == null) {
            this.glProcAddressTable = new GLProcAddressTable();
        }
        return this.glProcAddressTable;
    }

    public abstract void bindPbufferToTexture() {
    }

    public abstract void releasePbufferFromTexture() {
    }

    public void setSwapInterval(int n) {
    }

    protected abstract String mapToRealGLFunctionName(String string) {
    }

    protected abstract String mapToRealGLExtensionName(String string) {
    }

    public abstract String getPlatformExtensionsString() {
    }

    protected void resetProcAddressTable(Object object) {
        ProcAddressHelper.resetProcAddressTable(object, GLDrawableFactoryImpl.getFactoryImpl());
    }

    public abstract boolean isCreated() {
    }

    public int getFloatingPointMode() {
        throw new GLException("Not supported on non-pbuffer contexts");
    }

    public abstract boolean offscreenImageNeedsVerticalFlip() {
    }

    public abstract int getOffscreenContextPixelDataType() {
    }

    protected static String getThreadName() {
        return Thread.currentThread().getName();
    }

    public static String toHexString(long l) {
        return new StringBuffer().append("0x").append(Long.toHexString(l)).toString();
    }

    public boolean isExtensionAvailable(String string) {
        return this.extensionAvailability.isExtensionAvailable(string);
    }

    public void setBufferSizeTracker(GLBufferSizeTracker gLBufferSizeTracker) {
        this.bufferSizeTracker = gLBufferSizeTracker;
    }

    public GLBufferSizeTracker getBufferSizeTracker() {
        return this.bufferSizeTracker;
    }

    public void setObjectTracker(GLObjectTracker gLObjectTracker) {
        this.tracker = gLObjectTracker;
    }

    public GLObjectTracker getObjectTracker() {
        return this.tracker;
    }

    public void setDeletedObjectTracker(GLObjectTracker gLObjectTracker) {
        this.deletedObjectTracker = gLObjectTracker;
    }

    public GLObjectTracker getDeletedObjectTracker() {
        return this.deletedObjectTracker;
    }

    public boolean isOptimizable() {
        return this.optimizationEnabled;
    }

    public boolean hasWaiters() {
        return this.lock.hasWaiters();
    }

    protected void finalize() {
        this.destroy();
        super.finalize();
    }
}

