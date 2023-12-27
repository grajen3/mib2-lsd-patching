/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.gl;

import de.vw.mib.graphics.framebuffer.FrameBuffer;
import de.vw.mib.graphics.framebuffer.RenderBufferSurface;
import de.vw.mib.graphics.internal.framebuffer.AbstractFrameBufferManager;
import de.vw.mib.graphics.internal.gl.GLFrameBuffer;
import de.vw.mib.graphics.internal.gl.GLGraphics3D;
import de.vw.mib.graphics.internal.gl.GLRenderBufferSurface;
import javax.media.opengl.GL;

public final class GLFrameBufferManager
extends AbstractFrameBufferManager {
    private static final int DEFAULT_ID;
    private final int renderBufferSizeMax;
    private final GLFrameBuffer defaultFrameBuffer;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$graphics$internal$gl$GLFrameBufferManager;

    public GLFrameBufferManager(GLGraphics3D gLGraphics3D) {
        super(gLGraphics3D, gLGraphics3D.getLogger());
        GL gL = gLGraphics3D.getGL();
        int[] nArray = new int[]{0};
        gL.glGetIntegerv(-394002432, nArray, 0);
        if (!$assertionsDisabled && !gLGraphics3D.checkGLError()) {
            throw new AssertionError((Object)gLGraphics3D.printGLError("glGetIntegerv"));
        }
        this.renderBufferSizeMax = nArray[0];
        this.defaultFrameBuffer = new GLFrameBuffer(gLGraphics3D, this, 0);
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    public GLGraphics3D getGLGraphics3D() {
        return (GLGraphics3D)this.getGraphics3D();
    }

    @Override
    public int getMaxRenderBufferSurfaceSize() {
        return this.renderBufferSizeMax;
    }

    @Override
    public RenderBufferSurface createRenderBufferSurface(int n, int n2, int n3) {
        return new GLRenderBufferSurface(this, n, n2, n3);
    }

    @Override
    public FrameBuffer createFrameBuffer() {
        return new GLFrameBuffer(this);
    }

    @Override
    public FrameBuffer getDefaultFrameBuffer() {
        return this.defaultFrameBuffer;
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
        $assertionsDisabled = !(class$de$vw$mib$graphics$internal$gl$GLFrameBufferManager == null ? (class$de$vw$mib$graphics$internal$gl$GLFrameBufferManager = GLFrameBufferManager.class$("de.vw.mib.graphics.internal.gl.GLFrameBufferManager")) : class$de$vw$mib$graphics$internal$gl$GLFrameBufferManager).desiredAssertionStatus();
    }
}

