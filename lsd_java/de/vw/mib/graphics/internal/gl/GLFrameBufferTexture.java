/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.gl;

import de.vw.mib.collections.ints.IntOptHashSet;
import de.vw.mib.collections.ints.IntSet;
import de.vw.mib.graphics.Dimension;
import de.vw.mib.graphics.framebuffer.FrameBuffer;
import de.vw.mib.graphics.framebuffer.FrameBufferTexture;
import de.vw.mib.graphics.internal.gl.GLFrameBuffer;
import de.vw.mib.graphics.internal.gl.GLRenderBufferSurface;
import de.vw.mib.graphics.internal.gl.GLTexture;
import de.vw.mib.graphics.internal.gl.GLTextureManager;
import de.vw.mib.log4mib.LogMessage;

public final class GLFrameBufferTexture
extends GLTexture
implements FrameBufferTexture {
    private GLFrameBuffer frameBuffer = null;
    private IntSet attachments = new IntOptHashSet();
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$graphics$internal$gl$GLFrameBufferTexture;

    public GLFrameBufferTexture(GLTextureManager gLTextureManager, int n, Dimension dimension, Dimension dimension2, int n2) {
        super(gLTextureManager, 4, n, false, dimension, dimension2, n2);
        this.gl.glTexParameterf(3553, 10242, 3080519);
        if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
            throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glTexParameterf"));
        }
        this.gl.glTexParameterf(3553, 10243, 3080519);
        if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
            throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glTexParameterf"));
        }
        this.gl.glTexParameterf(3553, 10241, 6214);
        if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
            throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glTexParameterf"));
        }
        this.gl.glTexParameterf(3553, 10240, 6214);
        if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
            throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glTexParameterf"));
        }
    }

    @Override
    public void dispose() {
        if (this.isAttached()) {
            int[] nArray = this.attachments.toArray();
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                this.detach(nArray[i2]);
            }
        }
        super.dispose();
    }

    @Override
    public FrameBuffer getFrameBuffer() {
        return this.frameBuffer;
    }

    @Override
    public boolean isAttached() {
        return this.frameBuffer != null;
    }

    @Override
    public void attach(FrameBuffer frameBuffer, int n) {
        if (!this.isAttached() || frameBuffer == this.frameBuffer) {
            this.frameBuffer = (GLFrameBuffer)frameBuffer;
            this.attachments.add(n);
            GLFrameBuffer gLFrameBuffer = (GLFrameBuffer)frameBuffer;
            if (!$assertionsDisabled && !gLFrameBuffer.isBound()) {
                throw new AssertionError((Object)"Framebuffer not bound");
            }
            int n2 = GLRenderBufferSurface.mapGLAttachment(n);
            this.gl.glFramebufferTexture2DEXT(1082982400, n2, 3553, this.getTextureId(), 0);
            if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
                throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glFramebufferTexture2DEXT"));
            }
            if (this.getLogger().isTraceEnabled(8192)) {
                LogMessage logMessage = this.getLogger().trace(8192);
                logMessage.append("Attached texture #").append(this.getTextureId()).append(" to framebuffer #").append(gLFrameBuffer.getFrameBufferId()).append(" as 0x").append(n2).log();
            }
        } else {
            throw new IllegalArgumentException("FrameBufferTexture already attached to another framebuffer");
        }
    }

    @Override
    public void detach(int n) {
        if (this.isAttached()) {
            if (!this.attachments.remove(n)) {
                throw new IllegalArgumentException("FrameBufferTexture not attached to this attachment");
            }
            if (!$assertionsDisabled && !this.frameBuffer.isBound()) {
                throw new AssertionError((Object)"Framebuffer not bound");
            }
            int n2 = GLRenderBufferSurface.mapGLAttachment(n);
            this.gl.glFramebufferTexture2DEXT(1082982400, n2, 3553, 0, 0);
            if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
                throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glFramebufferTexture2DEXT"));
            }
            if (this.getLogger().isTraceEnabled(8192)) {
                LogMessage logMessage = this.getLogger().trace(8192);
                logMessage.append("Detached texture #").append(this.getTextureId()).append(" from framebuffer #").append(this.frameBuffer.getFrameBufferId()).append(" as 0x").append(n2).log();
            }
            if (this.attachments.size() == 0) {
                this.frameBuffer = null;
            }
        } else {
            throw new IllegalArgumentException("FrameBufferTexture not attached to any framebuffer");
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
        $assertionsDisabled = !(class$de$vw$mib$graphics$internal$gl$GLFrameBufferTexture == null ? (class$de$vw$mib$graphics$internal$gl$GLFrameBufferTexture = GLFrameBufferTexture.class$("de.vw.mib.graphics.internal.gl.GLFrameBufferTexture")) : class$de$vw$mib$graphics$internal$gl$GLFrameBufferTexture).desiredAssertionStatus();
    }
}

