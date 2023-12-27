/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.gl;

import de.vw.mib.graphics.framebuffer.FrameBuffer;
import de.vw.mib.graphics.internal.framebuffer.AbstractRenderBufferSurface;
import de.vw.mib.graphics.internal.gl.GLFrameBuffer;
import de.vw.mib.graphics.internal.gl.GLFrameBufferManager;
import de.vw.mib.graphics.internal.gl.GLGraphics3D;
import de.vw.mib.log4mib.LogMessage;
import javax.media.opengl.GL;

public final class GLRenderBufferSurface
extends AbstractRenderBufferSurface {
    private static final int NULL_ID;
    private final GL gl;
    private final int renderBufferId;
    private final int glFormat;
    private boolean bound;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$graphics$internal$gl$GLRenderBufferSurface;

    public GLRenderBufferSurface(GLFrameBufferManager gLFrameBufferManager, int n, int n2, int n3) {
        super(gLFrameBufferManager.getGraphics3D(), gLFrameBufferManager.getLogger(), gLFrameBufferManager, n, n2, n3);
        GLGraphics3D gLGraphics3D = this.getGLGraphics3D();
        this.gl = gLGraphics3D.getGL();
        int[] nArray = new int[]{0};
        this.gl.glGenRenderbuffersEXT(nArray.length, nArray, 0);
        if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
            throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glGenRenderbuffersEXT"));
        }
        this.renderBufferId = nArray[0];
        if (!$assertionsDisabled && this.renderBufferId == 0) {
            throw new AssertionError((Object)"RenderBuffer Namespace exhausted");
        }
        this.glFormat = GLRenderBufferSurface.mapGLFormat(n);
        if (this.getLogger().isTraceEnabled(512)) {
            LogMessage logMessage = this.getLogger().trace(512);
            logMessage.append("Allocated renderbuffer #").append(this.renderBufferId).append(" format 0x").append(Integer.toHexString(this.glFormat)).append(" size ").append(n2).append("x").append(n3).log();
        }
        this.bound = false;
        this.bind();
        this.gl.glRenderbufferStorageEXT(1099759616, this.glFormat, n2, n3);
        if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
            throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glRenderbufferStorageEXT"));
        }
    }

    public GLRenderBufferSurface(GLFrameBufferManager gLFrameBufferManager, int n, int n2, int n3, int n4) {
        super(gLFrameBufferManager.getGraphics3D(), gLFrameBufferManager.getLogger(), gLFrameBufferManager, n, n2, n3);
        GLGraphics3D gLGraphics3D = this.getGLGraphics3D();
        this.gl = gLGraphics3D.getGL();
        this.renderBufferId = n4;
        this.glFormat = GLRenderBufferSurface.mapGLFormat(n);
    }

    @Override
    public void dispose() {
        if (this.isBound()) {
            this.unbind();
        }
        int[] nArray = new int[]{this.renderBufferId};
        this.gl.glDeleteRenderbuffersEXT(nArray.length, nArray, 0);
        if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
            throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glDeleteRenderbuffersEXT"));
        }
        if (this.getLogger().isTraceEnabled(512)) {
            LogMessage logMessage = this.getLogger().trace(512);
            logMessage.append("Released renderbuffer #").append(this.renderBufferId).log();
        }
        super.dispose();
    }

    protected GLGraphics3D getGLGraphics3D() {
        return (GLGraphics3D)this.getGraphics3D();
    }

    public int getRenderBufferId() {
        return this.renderBufferId;
    }

    @Override
    public void attach(FrameBuffer frameBuffer, int n) {
        super.attach(frameBuffer, n);
        GLFrameBuffer gLFrameBuffer = (GLFrameBuffer)frameBuffer;
        if (!$assertionsDisabled && !gLFrameBuffer.isBound()) {
            throw new AssertionError();
        }
        int n2 = GLRenderBufferSurface.mapGLAttachment(n);
        this.gl.glFramebufferRenderbufferEXT(1082982400, n2, 1099759616, this.getRenderBufferId());
        if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
            throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glFramebufferRenderbufferEXT"));
        }
        if (this.getLogger().isTraceEnabled(512)) {
            LogMessage logMessage = this.getLogger().trace(512);
            logMessage.append("Attached renderbuffer #").append(this.renderBufferId).append(" format 0x").append(this.glFormat).append(" to framebuffer #").append(gLFrameBuffer.getFrameBufferId()).append(" as 0x").append(n2).log();
        }
    }

    @Override
    public void detach(int n) {
        GLFrameBuffer gLFrameBuffer = (GLFrameBuffer)this.getFrameBuffer();
        if (!$assertionsDisabled && !gLFrameBuffer.isBound()) {
            throw new AssertionError();
        }
        super.detach(n);
        int n2 = GLRenderBufferSurface.mapGLAttachment(n);
        this.gl.glFramebufferRenderbufferEXT(1082982400, n2, 1099759616, 0);
        if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
            throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glFramebufferRenderbufferEXT"));
        }
        if (this.getLogger().isTraceEnabled(512)) {
            LogMessage logMessage = this.getLogger().trace(512);
            logMessage.append("Detached renderbuffer #").append(this.renderBufferId).append(" format 0x").append(this.glFormat).append(" from framebuffer #").append(gLFrameBuffer.getFrameBufferId()).append(" as 0x").append(n2).log();
        }
    }

    public boolean isBound() {
        return this.bound;
    }

    public void bind() {
        this.gl.glBindRenderbufferEXT(1099759616, this.renderBufferId);
        if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
            throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glBindRenderbufferEXT"));
        }
        this.bound = true;
        if (this.getLogger().isTraceEnabled(512)) {
            LogMessage logMessage = this.getLogger().trace(512);
            logMessage.append("Bound renderbuffer #").append(this.renderBufferId).log();
        }
    }

    public void unbind() {
        this.gl.glBindRenderbufferEXT(1099759616, 0);
        if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
            throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glBindRenderbufferEXT"));
        }
        this.bound = false;
        if (this.getLogger().isTraceEnabled(512)) {
            LogMessage logMessage = this.getLogger().trace(512);
            logMessage.append("Unbound renderbuffer #").append(this.renderBufferId).log();
        }
    }

    private static int mapGLFormat(int n) {
        switch (n) {
            case 4353: {
                return 1468006400;
            }
            case 4354: {
                return 1451229184;
            }
            case 4355: {
                return 1367343104;
            }
            case 4356: {
                return 0x58800000;
            }
            case 4864: {
                return -1518272512;
            }
            case 4865: {
                return -1501495296;
            }
            case 4866: {
                return -1484718080;
            }
            case 5120: {
                return 1183645696;
            }
            case 5121: {
                return 1200422912;
            }
            case 5122: {
                return 1217200128;
            }
            case 5376: {
                return -259522560;
            }
        }
        throw new IllegalArgumentException("Invalid surface format");
    }

    static int mapGLAttachment(int n) {
        switch (n) {
            case 0: {
                return -527695872;
            }
            case 1: {
                return 0x8D0000;
            }
            case 2: {
                return 546111488;
            }
        }
        throw new IllegalArgumentException("Invalid attachment type");
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
        $assertionsDisabled = !(class$de$vw$mib$graphics$internal$gl$GLRenderBufferSurface == null ? (class$de$vw$mib$graphics$internal$gl$GLRenderBufferSurface = GLRenderBufferSurface.class$("de.vw.mib.graphics.internal.gl.GLRenderBufferSurface")) : class$de$vw$mib$graphics$internal$gl$GLRenderBufferSurface).desiredAssertionStatus();
    }
}

