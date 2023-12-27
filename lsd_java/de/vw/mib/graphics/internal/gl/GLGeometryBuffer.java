/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.gl;

import de.vw.mib.graphics.internal.ServiceManager;
import de.vw.mib.graphics.internal.gl.GLGraphics3D;
import de.vw.mib.graphics.internal.gl.GLMeshManager;
import de.vw.mib.graphics.internal.mesh.AbstractGeometryBuffer;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.util.StringBuilder;
import java.nio.ByteBuffer;
import javax.media.opengl.GL;

public abstract class GLGeometryBuffer
extends AbstractGeometryBuffer {
    private static final int NULL_ID;
    private static GLGeometryBuffer[] targetsBound;
    private final GL gl;
    private final int glTarget;
    private final int bufferId;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$graphics$internal$gl$GLGeometryBuffer;

    public GLGeometryBuffer(GLMeshManager gLMeshManager, int n, int n2, int n3) {
        super(gLMeshManager.getGraphics3D(), gLMeshManager.getLogger(), gLMeshManager, n, n2, n3);
        GLGraphics3D gLGraphics3D = this.getGLGraphics3D();
        this.gl = gLGraphics3D.getGL();
        this.glTarget = GLGeometryBuffer.mapGLTarget(n);
        int n4 = GLGeometryBuffer.mapGLUsage(n3);
        int[] nArray = new int[]{0};
        this.gl.glGenBuffers(nArray.length, nArray, 0);
        if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
            throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glGenBuffers"));
        }
        this.bufferId = nArray[0];
        if (!$assertionsDisabled && this.bufferId == 0) {
            throw new AssertionError((Object)"VBO Namespace exhausted");
        }
        if (this.getLogger().isTraceEnabled(1024)) {
            LogMessage logMessage = this.getLogger().trace(1024);
            logMessage.append("Allocated VBO #").append(nArray[0]).append(" type 0x").append(Integer.toHexString(this.glTarget)).append(" usage 0x").append(Integer.toHexString(n4)).append(" size ").append(n2).append(" bytes").log();
        }
        this.bind();
        this.gl.glBufferData(this.glTarget, n2, null, n4);
        if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
            throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glBufferData"));
        }
    }

    @Override
    public final void dispose() {
        if (this.isBound()) {
            this.unbind();
        }
        int[] nArray = new int[]{this.bufferId};
        this.gl.glDeleteBuffers(nArray.length, nArray, 0);
        if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
            throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glDeleteBuffers"));
        }
        if (this.getLogger().isTraceEnabled(1024)) {
            LogMessage logMessage = this.getLogger().trace(1024);
            logMessage.append("Released VBO #").append(this.bufferId).log();
        }
        super.dispose();
    }

    protected final GLGraphics3D getGLGraphics3D() {
        return (GLGraphics3D)this.getGraphics3D();
    }

    public final int getBufferId() {
        return this.bufferId;
    }

    public final boolean isBound() {
        return targetsBound[this.getType()] == this;
    }

    public final void bind() {
        if (!this.isBound()) {
            Logger logger = this.getLogger();
            this.gl.glBindBuffer(this.glTarget, this.bufferId);
            if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
                throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glBindBuffer"));
            }
            if (logger.isTraceEnabled(1024) && logger.isTraceEnabled(64)) {
                LogMessage logMessage = logger.trace(1024);
                logMessage.append("Bound VBO #").append(this.bufferId).append(" type 0x").append(Integer.toHexString(this.glTarget)).log();
            }
            GLGeometryBuffer.targetsBound[this.getType()] = this;
        }
    }

    public final void unbind() {
        if (this.isBound()) {
            Logger logger = this.getLogger();
            this.gl.glBindBuffer(this.glTarget, 0);
            if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
                throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glBindBuffer"));
            }
            if (logger.isTraceEnabled(1024) && logger.isTraceEnabled(64)) {
                LogMessage logMessage = logger.trace(1024);
                logMessage.append("Unbound VBO #").append(this.bufferId).log();
            }
            GLGeometryBuffer.targetsBound[this.getType()] = null;
        }
    }

    @Override
    public final boolean isReadable() {
        return false;
    }

    @Override
    public final ByteBuffer getContent(int n, int n2) {
        throw new UnsupportedOperationException("Reading VBOs is not supported");
    }

    @Override
    public final ByteBuffer getContent() {
        throw new UnsupportedOperationException("Reading VBOs is not supported");
    }

    @Override
    public final void setContent(int n, int n2, ByteBuffer byteBuffer) {
        Logger logger = this.getLogger();
        if (n2 <= 0 || n + n2 > this.getSize() || n2 > byteBuffer.remaining()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("setContent(offset=").append(n).append(",size=").append(n2).append(",buffer=").append(byteBuffer).append("): Invalid parameters");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        this.bind();
        LogMessage logMessage = logger.isTraceEnabled(1024) ? logger.trace(1024) : null;
        boolean bl = logMessage != null && logger.isTraceEnabled(128);
        long l = bl ? ServiceManager.timerManager.getSystemTimeMicros() : 0L;
        this.gl.glBufferSubData(this.glTarget, n, n2, byteBuffer);
        if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
            throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glBufferSubData"));
        }
        if (logMessage != null) {
            logMessage.append("glBufferSubData(#").append(this.getBufferId()).append(", ").append(n2).append("b -> ").append(n).append("@").append(this.getSize()).append("b)");
            if (bl) {
                long l2 = ServiceManager.timerManager.getSystemTimeMicros();
                logMessage.append(": ").append(l2 - l).append("\u00b5s");
            }
            logMessage.log();
        }
    }

    private static int mapGLTarget(int n) {
        switch (n) {
            case 0: {
                return -1836580864;
            }
            case 1: {
                return -1819803648;
            }
        }
        throw new IllegalArgumentException("Invalid buffer type");
    }

    private static int mapGLUsage(int n) {
        switch (n) {
            case 1: {
                return -460849152;
            }
            case 2: {
                return -393740288;
            }
            case 3: {
                return -527958016;
            }
        }
        throw new IllegalArgumentException("Invalid buffer usage");
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
        $assertionsDisabled = !(class$de$vw$mib$graphics$internal$gl$GLGeometryBuffer == null ? (class$de$vw$mib$graphics$internal$gl$GLGeometryBuffer = GLGeometryBuffer.class$("de.vw.mib.graphics.internal.gl.GLGeometryBuffer")) : class$de$vw$mib$graphics$internal$gl$GLGeometryBuffer).desiredAssertionStatus();
        targetsBound = new GLGeometryBuffer[3];
    }
}

