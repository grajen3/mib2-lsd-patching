/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.gl;

import de.vw.mib.graphics.Configuration;
import de.vw.mib.graphics.ConfigurationAttributes;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.internal.AbstractGraphicsManager;
import de.vw.mib.graphics.internal.ServiceManager;
import de.vw.mib.graphics.internal.gl.GLConfiguration;
import de.vw.mib.graphics.internal.gl.GLGraphics3D;
import de.vw.mib.graphics.internal.gl.GLPBufferSurface;
import de.vw.mib.graphics.internal.gl.GLPixmapSurface;
import de.vw.mib.graphics.internal.gl.GLSurface;
import de.vw.mib.graphics.internal.gl.GLWindowSurface;
import de.vw.mib.graphics.surface.PBufferSurface;
import de.vw.mib.graphics.surface.PixmapSurface;
import de.vw.mib.graphics.surface.Surface;
import de.vw.mib.graphics.surface.WindowSurface;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.log4mib.LoggerFactory;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import javax.media.opengl.GL;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLCapabilitiesChooser;
import javax.media.opengl.GLContext;
import javax.media.opengl.GLDrawable;
import javax.media.opengl.GLDrawableFactory;
import javax.media.opengl.GLPbuffer;
import javax.media.opengl.TraceGL;

public final class GLGraphicsManager
extends AbstractGraphicsManager {
    private static final boolean EXTERNAL_DRAWABLE;
    private static final boolean DEBUG_TRACE_GL_CALLS;
    private static final boolean DEBUG_TRACE_GL_CALLS_CONSOLE;
    private static final String DEBUG_TRACE_GL_CALLS_FILENAME;
    private static final int DEFAULT_SWAP_INTERVAL;
    private static final int SWAP_INTERVAL;
    private GLGraphics3D currentGraphics;
    private GLSurface currentSurface;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$graphics$internal$gl$GLGraphicsManager;

    public GLGraphicsManager(LoggerFactory loggerFactory) {
        super(loggerFactory);
        System.setProperty("opengl.1thread", "false");
    }

    @Override
    public void dispose() {
        if (this.currentGraphics != null) {
            this.currentGraphics.dispose();
            this.currentGraphics = null;
        }
        if (this.currentSurface != null) {
            this.currentSurface.bind(null);
            this.currentSurface.dispose();
            this.currentSurface = null;
        }
    }

    @Override
    public Configuration chooseConfiguration(ConfigurationAttributes configurationAttributes) {
        GLCapabilities gLCapabilities = new GLCapabilities();
        gLCapabilities.setRedBits(configurationAttributes.colorRedBits);
        gLCapabilities.setGreenBits(configurationAttributes.colorGreenBits);
        gLCapabilities.setBlueBits(configurationAttributes.colorBlueBits);
        gLCapabilities.setAlphaBits(configurationAttributes.colorAlphaBits);
        gLCapabilities.setDepthBits(configurationAttributes.depthBits);
        gLCapabilities.setStencilBits(configurationAttributes.stencilBits);
        gLCapabilities.setSampleBuffers(configurationAttributes.samples > 1);
        gLCapabilities.setNumSamples(configurationAttributes.samples);
        gLCapabilities.setDoubleBuffered(true);
        gLCapabilities.setHardwareAccelerated(true);
        return new GLConfiguration(configurationAttributes, gLCapabilities);
    }

    @Override
    public WindowSurface createWindowSurface(Configuration configuration, Object object) {
        GLWindowSurface gLWindowSurface;
        Object object2;
        Object object3;
        long l;
        if (!$assertionsDisabled && !(configuration instanceof GLConfiguration)) {
            throw new AssertionError((Object)"config must be instance of GLConfiguration");
        }
        Logger logger = this.getLogger();
        boolean bl = logger.isTraceEnabled(64) && logger.isTraceEnabled(128);
        long l2 = bl ? GLGraphicsManager.getSystemTimeMicros() : 0L;
        GLDrawableFactory gLDrawableFactory = GLDrawableFactory.getFactory();
        long l3 = l = bl ? GLGraphicsManager.getSystemTimeMicros() : 0L;
        if (bl) {
            object3 = logger.trace(64);
            object3.append("createWindowSurface().getFactory(): ").append(l - l2).append("\u00b5s").log();
        }
        object3 = (GLConfiguration)configuration;
        GLCapabilities gLCapabilities = ((GLConfiguration)object3).getGLCapabilities();
        long l4 = l2 = bl ? GLGraphicsManager.getSystemTimeMicros() : 0L;
        if (EXTERNAL_DRAWABLE && gLDrawableFactory.canCreateExternalGLDrawable()) {
            object2 = gLDrawableFactory.createExternalGLDrawable();
            gLWindowSurface = new GLWindowSurface(4356, (GLDrawable)object2, object);
        } else {
            object2 = gLDrawableFactory.getGLDrawable(object, gLCapabilities, null);
            if (logger.isTraceEnabled(64)) {
                LogMessage logMessage = logger.trace(64);
                logMessage.append("Chose configuration ").append(object2.getChosenGLCapabilities()).log();
            }
            gLWindowSurface = new GLWindowSurface(4356, (GLDrawable)object2, object);
        }
        long l5 = l = bl ? GLGraphicsManager.getSystemTimeMicros() : 0L;
        if (logger.isTraceEnabled(64)) {
            object2 = logger.trace(64);
            object2.append("Created window surface ").append(gLWindowSurface.getWidth()).append("x").append(gLWindowSurface.getHeight()).append(" surfaceFormat 0x").append(Integer.toHexString(gLWindowSurface.getSurfaceFormat()));
            if (bl) {
                object2.append(": ").append(l - l2).append("\u00b5s");
            }
            object2.log();
        }
        return gLWindowSurface;
    }

    @Override
    public PixmapSurface createPixmapSurface(Configuration configuration, Object object) {
        if (!$assertionsDisabled && !(configuration instanceof GLConfiguration)) {
            throw new AssertionError((Object)"config must be instance of GLConfiguration");
        }
        Logger logger = this.getLogger();
        GLDrawableFactory gLDrawableFactory = GLDrawableFactory.getFactory();
        GLConfiguration gLConfiguration = (GLConfiguration)configuration;
        GLCapabilities gLCapabilities = gLConfiguration.getGLCapabilities();
        GLDrawable gLDrawable = gLDrawableFactory.getGLDrawable(object, gLCapabilities, null);
        GLPixmapSurface gLPixmapSurface = new GLPixmapSurface(gLDrawable, object);
        if (logger.isTraceEnabled(64)) {
            LogMessage logMessage = logger.trace(64);
            logMessage.append("Created pixmap surface ").append(gLPixmapSurface.getWidth()).append("x").append(gLPixmapSurface.getHeight()).append(" surfaceFormat 0x").append(Integer.toHexString(gLPixmapSurface.getSurfaceFormat())).log();
        }
        return gLPixmapSurface;
    }

    @Override
    public PBufferSurface createPBufferSurface(Configuration configuration, int n, int n2) {
        if (!$assertionsDisabled && !(configuration instanceof GLConfiguration)) {
            throw new AssertionError((Object)"config must be instance of GLConfiguration");
        }
        Logger logger = this.getLogger();
        GLDrawableFactory gLDrawableFactory = GLDrawableFactory.getFactory();
        GLConfiguration gLConfiguration = (GLConfiguration)configuration;
        GLCapabilities gLCapabilities = gLConfiguration.getGLCapabilities();
        if (!gLDrawableFactory.canCreateGLPbuffer()) {
            throw new UnsupportedOperationException("PBuffers not supported by hardware");
        }
        LogMessage logMessage = null;
        GLPbuffer gLPbuffer = gLDrawableFactory.createGLPbuffer(gLCapabilities, (GLCapabilitiesChooser)((Object)logMessage), n, n2, null);
        GLPBufferSurface gLPBufferSurface = new GLPBufferSurface(4356, gLPbuffer);
        if (logger.isTraceEnabled(64)) {
            logMessage = logger.trace(64);
            logMessage.append("Created pixmap surface ").append(gLPBufferSurface.getWidth()).append("x").append(gLPBufferSurface.getHeight()).append(" surfaceFormat 0x").append(Integer.toHexString(gLPBufferSurface.getSurfaceFormat())).log();
        }
        return gLPBufferSurface;
    }

    @Override
    public Graphics3D createGraphics(Configuration configuration, Surface surface) {
        long l;
        Object object;
        GLContext gLContext;
        long l2;
        if (!$assertionsDisabled && !(configuration instanceof GLConfiguration)) {
            throw new AssertionError((Object)"config must be instance of GLConfiguration");
        }
        if (!$assertionsDisabled && !(surface instanceof GLSurface)) {
            throw new AssertionError((Object)"config must be instance of GLSurface");
        }
        Logger logger = this.getLogger();
        boolean bl = logger.isTraceEnabled(64) && logger.isTraceEnabled(128);
        GLDrawableFactory gLDrawableFactory = GLDrawableFactory.getFactory();
        GLConfiguration gLConfiguration = (GLConfiguration)configuration;
        long l3 = l2 = bl ? GLGraphicsManager.getSystemTimeMicros() : 0L;
        if (EXTERNAL_DRAWABLE && gLDrawableFactory.canCreateExternalGLDrawable()) {
            gLContext = gLDrawableFactory.createExternalGLContext();
        } else {
            object = (GLSurface)surface;
            GLDrawable gLDrawable = ((GLSurface)object).getGLDrawable();
            gLContext = gLDrawable.createContext(null);
            if (DEBUG_TRACE_GL_CALLS) {
                if (DEBUG_TRACE_GL_CALLS_CONSOLE) {
                    gLContext.setGL(new TraceGL(gLContext.getGL(), System.err));
                } else {
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream("gltrace.txt");
                        gLContext.setGL(new TraceGL(gLContext.getGL(), new PrintStream(new BufferedOutputStream(fileOutputStream))));
                    }
                    catch (IOException iOException) {
                        LogMessage logMessage = logger.error(64);
                        logMessage.append("Can't open GL trace file '").append("gltrace.txt").append("): ").attachThrowable(iOException).log();
                    }
                }
            }
        }
        long l4 = l = bl ? GLGraphicsManager.getSystemTimeMicros() : 0L;
        if (logger.isTraceEnabled(64)) {
            object = logger.trace(64);
            object.append("Created graphics context");
            if (bl) {
                object.append(": ").append(l - l2).append("\u00b5s");
            }
            object.log();
        }
        return new GLGraphics3D(logger, gLContext, gLConfiguration);
    }

    @Override
    public Graphics3D cloneGraphics(Graphics3D graphics3D) {
        if (!$assertionsDisabled && !(graphics3D instanceof GLGraphics3D)) {
            throw new AssertionError((Object)"graphics must be instance of GLGraphics3D");
        }
        GLGraphics3D gLGraphics3D = (GLGraphics3D)graphics3D;
        GLSurface gLSurface = gLGraphics3D.getGLSurface();
        GLDrawable gLDrawable = gLSurface.getGLDrawable();
        GLContext gLContext = gLDrawable.createContext(gLGraphics3D.getContext());
        return new GLGraphics3D(gLGraphics3D, gLContext);
    }

    @Override
    public boolean isGraphicsBound(Graphics3D graphics3D, Surface surface) {
        if (!$assertionsDisabled && !(graphics3D instanceof GLGraphics3D)) {
            throw new AssertionError((Object)"graphics must be instance of GLGraphics3D");
        }
        if (!$assertionsDisabled && !(surface instanceof GLSurface)) {
            throw new AssertionError((Object)"surface must be instance of GLSurface");
        }
        GLGraphics3D gLGraphics3D = (GLGraphics3D)graphics3D;
        GLSurface gLSurface = (GLSurface)surface;
        return gLGraphics3D.getGLSurface() == gLSurface;
    }

    @Override
    public void bindGraphics(Graphics3D graphics3D, Surface surface) {
        if (!$assertionsDisabled && !(graphics3D instanceof GLGraphics3D)) {
            throw new AssertionError((Object)"graphics must be instance of GLGraphics3D");
        }
        if (!$assertionsDisabled && !(surface instanceof GLSurface)) {
            throw new AssertionError((Object)"surface must be instance of GLSurface");
        }
        Logger logger = this.getLogger();
        boolean bl = logger.isTraceEnabled(64) && logger.isTraceEnabled(128);
        GLGraphics3D gLGraphics3D = (GLGraphics3D)graphics3D;
        GLSurface gLSurface = (GLSurface)surface;
        if (this.currentGraphics != gLGraphics3D || this.currentSurface != gLSurface) {
            Object object;
            long l;
            GLContext gLContext = gLGraphics3D.getContext();
            if (this.currentGraphics != null) {
                this.currentGraphics.bind(null);
            }
            if (gLContext.makeCurrent() == 0) {
                throw new IllegalStateException("glMakeCurrent() failed");
            }
            long l2 = bl ? GLGraphicsManager.getSystemTimeMicros() : 0L;
            gLGraphics3D.bind(gLSurface);
            long l3 = l = bl ? GLGraphicsManager.getSystemTimeMicros() : 0L;
            if (logger.isTraceEnabled(64)) {
                object = logger.trace(64);
                object.append("Bound graphics context to surface ").append(surface);
                if (bl) {
                    object.append(": ").append(l - l2).append("\u00b5s");
                }
                object.log();
            }
            if (SWAP_INTERVAL != 1) {
                object = gLGraphics3D.getGL();
                object.setSwapInterval(SWAP_INTERVAL);
                if (!$assertionsDisabled && !gLGraphics3D.checkGLError()) {
                    throw new AssertionError((Object)gLGraphics3D.printGLError("setSwapInterval"));
                }
            }
            this.currentGraphics = gLGraphics3D;
            this.currentSurface = gLSurface;
        }
    }

    @Override
    public void unbindGraphics(Graphics3D graphics3D) {
        if (!$assertionsDisabled && !(graphics3D instanceof GLGraphics3D)) {
            throw new AssertionError((Object)"graphics must be instance of GLGraphics3D");
        }
        GLGraphics3D gLGraphics3D = (GLGraphics3D)graphics3D;
        GLContext gLContext = gLGraphics3D.getContext();
        if (gLGraphics3D != this.currentGraphics) {
            throw new IllegalStateException("Graphics not bound");
        }
        gLContext.release();
        gLGraphics3D.bind(null);
        this.currentGraphics = null;
        this.currentSurface = null;
    }

    @Override
    public void beginFrame(Graphics3D graphics3D) {
        if (!$assertionsDisabled && !(graphics3D instanceof GLGraphics3D)) {
            throw new AssertionError((Object)"graphics must be instance of GLGraphics3D");
        }
        GLGraphics3D gLGraphics3D = (GLGraphics3D)graphics3D;
        gLGraphics3D.beginFrame();
    }

    @Override
    public void endFrame(Graphics3D graphics3D) {
        if (!$assertionsDisabled && !(graphics3D instanceof GLGraphics3D)) {
            throw new AssertionError((Object)"graphics must be instance of GLGraphics3D");
        }
        GLGraphics3D gLGraphics3D = (GLGraphics3D)graphics3D;
        gLGraphics3D.endFrame();
    }

    @Override
    public void swapBuffers(Graphics3D graphics3D) {
        long l;
        boolean bl;
        if (!$assertionsDisabled && !(graphics3D instanceof GLGraphics3D)) {
            throw new AssertionError((Object)"graphics must be instance of GLGraphics3D");
        }
        Logger logger = this.getLogger();
        GLGraphics3D gLGraphics3D = (GLGraphics3D)graphics3D;
        GLSurface gLSurface = gLGraphics3D.getGLSurface();
        GLDrawable gLDrawable = gLSurface.getGLDrawable();
        LogMessage logMessage = logger.isTraceEnabled(64) ? logger.trace(64) : null;
        boolean bl2 = bl = logMessage != null && logger.isTraceEnabled(128);
        if (bl) {
            GL gL = gLGraphics3D.getGL();
            gL.glGetError();
        }
        long l2 = bl ? ServiceManager.timerManager.getSystemTimeMicros() : 0L;
        gLDrawable.swapBuffers();
        long l3 = l = bl ? ServiceManager.timerManager.getSystemTimeMicros() : 0L;
        if (logMessage != null) {
            logMessage.append("swapBuffers()");
            if (bl) {
                logMessage.append(": ").append(l - l2).append("\u00b5s");
            }
            logMessage.log();
        }
    }

    protected static long getSystemTimeMicros() {
        return ServiceManager.timerManager.getSystemTimeMicros();
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        $assertionsDisabled = !(class$de$vw$mib$graphics$internal$gl$GLGraphicsManager == null ? (class$de$vw$mib$graphics$internal$gl$GLGraphicsManager = GLGraphicsManager.class$("de.vw.mib.graphics.internal.gl.GLGraphicsManager")) : class$de$vw$mib$graphics$internal$gl$GLGraphicsManager).desiredAssertionStatus();
        EXTERNAL_DRAWABLE = System.getProperty("de.vw.mib.graphics.jsr231.external") != null;
        DEBUG_TRACE_GL_CALLS = System.getProperty("de.vw.mib.graphics.jsr231.tracegl") != null;
        DEBUG_TRACE_GL_CALLS_CONSOLE = System.getProperty("de.vw.mib.graphics.jsr231.tracegl.console") != null;
        SWAP_INTERVAL = Integer.getInteger("de.vw.mib.graphics.gl.swapinterval", 1);
    }
}

