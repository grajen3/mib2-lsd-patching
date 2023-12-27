/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.gl;

import de.vw.mib.graphics.framebuffer.RenderBuffer;
import de.vw.mib.graphics.internal.framebuffer.AbstractFrameBuffer;
import de.vw.mib.graphics.internal.gl.GLFrameBufferManager;
import de.vw.mib.graphics.internal.gl.GLGraphics3D;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.util.StringBuilder;
import javax.media.opengl.GL;

public final class GLFrameBuffer
extends AbstractFrameBuffer {
    private static final int NULL_ID;
    private static GLFrameBuffer bound;
    private final GL gl;
    private final int frameBufferId;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$graphics$internal$gl$GLFrameBuffer;

    public GLFrameBuffer(GLFrameBufferManager gLFrameBufferManager) {
        super(gLFrameBufferManager.getGraphics3D(), gLFrameBufferManager.getLogger(), gLFrameBufferManager);
        GLGraphics3D gLGraphics3D = this.getGLGraphics3D();
        this.gl = gLGraphics3D.getGL();
        int[] nArray = new int[]{0};
        this.gl.glGenFramebuffersEXT(nArray.length, nArray, 0);
        if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
            throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glGenFramebuffersEXT"));
        }
        this.frameBufferId = nArray[0];
        if (!$assertionsDisabled && this.frameBufferId == 0) {
            throw new AssertionError((Object)"FrameBuffer Namespace exhausted");
        }
        if (this.getLogger().isTraceEnabled(512)) {
            LogMessage logMessage = this.getLogger().trace(512);
            logMessage.append("Allocated framebuffer #").append(this.frameBufferId).log();
        }
    }

    public GLFrameBuffer(GLGraphics3D gLGraphics3D, GLFrameBufferManager gLFrameBufferManager, int n) {
        super(gLGraphics3D, gLGraphics3D.getLogger(), gLFrameBufferManager);
        this.gl = gLGraphics3D.getGL();
        this.frameBufferId = n;
        if (n == 0) {
            bound = this;
        }
    }

    @Override
    public void dispose() {
        if (this.isBound()) {
            this.unbind();
        }
        if (this.frameBufferId > 0) {
            int[] nArray = new int[]{this.frameBufferId};
            this.gl.glDeleteFramebuffersEXT(nArray.length, nArray, 0);
            if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
                throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glDeleteFramebuffersEXT"));
            }
            if (this.getLogger().isTraceEnabled(512)) {
                LogMessage logMessage = this.getLogger().trace(512);
                logMessage.append("Released framebuffer #").append(this.frameBufferId).log();
            }
        }
        super.dispose();
    }

    protected GLGraphics3D getGLGraphics3D() {
        return (GLGraphics3D)this.getGraphics3D();
    }

    public int getFrameBufferId() {
        return this.frameBufferId;
    }

    public boolean isBound() {
        return bound == this;
    }

    @Override
    public void bind() {
        RenderBuffer renderBuffer;
        RenderBuffer renderBuffer2;
        if (!this.isBound()) {
            this.gl.glBindFramebufferEXT(1082982400, this.frameBufferId);
            if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
                throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glBindFramebufferEXT"));
            }
            if (this.getLogger().isTraceEnabled(512)) {
                LogMessage logMessage = this.getLogger().trace(512);
                logMessage.append("Bound framebuffer #").append(this.frameBufferId).log();
            }
            bound = this;
            super.bind();
        }
        boolean bl = false;
        RenderBuffer renderBuffer3 = this.getColorBuffer();
        if (renderBuffer3 != null && !renderBuffer3.isAttached()) {
            renderBuffer3.attach(this, 0);
            bl = true;
        }
        if ((renderBuffer2 = this.getDepthBuffer()) != null && !renderBuffer2.isAttached()) {
            renderBuffer2.attach(this, 1);
            bl = true;
        }
        if ((renderBuffer = this.getStencilBuffer()) != null && !renderBuffer.isAttached()) {
            renderBuffer.attach(this, 2);
            bl = true;
        }
        if (bl && this.getLogger().isTraceEnabled(512)) {
            this.validate();
        }
    }

    public void unbind() {
        if (this.isBound()) {
            this.gl.glBindFramebufferEXT(1082982400, 0);
            if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
                throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glBindFramebufferEXT"));
            }
            if (this.getLogger().isTraceEnabled(512)) {
                LogMessage logMessage = this.getLogger().trace(512);
                logMessage.append("Unbound framebuffer #").append(this.frameBufferId).log();
            }
            bound = null;
        }
    }

    @Override
    protected void colorBufferChanged(RenderBuffer renderBuffer, RenderBuffer renderBuffer2) {
    }

    @Override
    protected void depthBufferChanged(RenderBuffer renderBuffer, RenderBuffer renderBuffer2) {
    }

    @Override
    protected void stencilBufferChanged(RenderBuffer renderBuffer, RenderBuffer renderBuffer2) {
    }

    private void validate() {
        Logger logger = this.getLogger();
        int n = this.gl.glCheckFramebufferStatusEXT(1082982400);
        if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
            throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glCheckFramebufferStatusEXT"));
        }
        if (n != -712245248) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Framebuffer validation failed with code: 0x");
            stringBuilder.append(Integer.toHexString(n));
            stringBuilder.append(" (");
            switch (n) {
                case 36054: {
                    stringBuilder.append("Incomplete attachment");
                    break;
                }
                case 36055: {
                    stringBuilder.append("Incomplete missing attachment");
                    break;
                }
                case 36057: {
                    stringBuilder.append("Incomplete dimensions");
                    break;
                }
                case 36059: {
                    stringBuilder.append("Incomplete draw buffer");
                    break;
                }
                case 36060: {
                    stringBuilder.append("Incomplete read buffer");
                    break;
                }
                case 36061: {
                    stringBuilder.append("Unsupported buffer combination");
                    break;
                }
                default: {
                    stringBuilder.append("Unknown");
                }
            }
            stringBuilder.append(")");
            LogMessage logMessage = logger.warn(512);
            logMessage.append(stringBuilder.toString()).log();
        } else if (logger.isTraceEnabled(512)) {
            LogMessage logMessage = logger.trace(512);
            logMessage.append("Successfully validated framebuffer #").append(this.frameBufferId).log();
        }
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
        $assertionsDisabled = !(class$de$vw$mib$graphics$internal$gl$GLFrameBuffer == null ? (class$de$vw$mib$graphics$internal$gl$GLFrameBuffer = GLFrameBuffer.class$("de.vw.mib.graphics.internal.gl.GLFrameBuffer")) : class$de$vw$mib$graphics$internal$gl$GLFrameBuffer).desiredAssertionStatus();
    }
}

