/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.gl;

import de.vw.mib.NotYetImplementedException;
import de.vw.mib.graphics.Dimension;
import de.vw.mib.graphics.framebuffer.FrameBufferTexture;
import de.vw.mib.graphics.internal.gl.GLFrameBufferTexture;
import de.vw.mib.graphics.internal.gl.GLGraphics3D;
import de.vw.mib.graphics.internal.gl.GLTexture2D;
import de.vw.mib.graphics.internal.gl.GLTextureCubeMap;
import de.vw.mib.graphics.internal.texture.AbstractTextureManager;
import de.vw.mib.graphics.math.Util;
import de.vw.mib.graphics.surface.PBufferSurface;
import de.vw.mib.graphics.texture.PBufferTexture;
import de.vw.mib.graphics.texture.Texture2D;
import de.vw.mib.graphics.texture.TextureCubeMap;
import javax.media.opengl.GL;

public final class GLTextureManager
extends AbstractTextureManager {
    private final int textureUnitsMax;
    private final int fragmentTextureImageUnitsMax;
    private final int vertexTextureImageUnitsMax;
    private final int combinedTextureUnitsMax;
    private final int maxTextureSize;
    private final int maxCubeTextureSize;
    private final int[] compressedTextureFormats;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$graphics$internal$gl$GLTextureManager;

    public GLTextureManager(GLGraphics3D gLGraphics3D) {
        super(gLGraphics3D, gLGraphics3D.getLogger());
        int[] nArray;
        int[] nArray2;
        int[] nArray3;
        GL gL = gLGraphics3D.getGL();
        if (GLGraphics3D.FIXED_FUNCTION_PIPELINE) {
            nArray3 = new int[]{0};
            gL.glGetIntegerv(-494665728, nArray3, 0);
            if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
                throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glGetIntegerv"));
            }
            this.textureUnitsMax = nArray3[0];
            this.fragmentTextureImageUnitsMax = 0;
            this.vertexTextureImageUnitsMax = 0;
            this.combinedTextureUnitsMax = 0;
        } else {
            nArray3 = new int[]{0};
            gL.glGetIntegerv(1921515520, nArray3, 0);
            if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
                throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glGetIntegerv"));
            }
            this.textureUnitsMax = nArray3[0];
            this.fragmentTextureImageUnitsMax = nArray3[0];
            nArray2 = new int[]{0};
            gL.glGetIntegerv(1284177920, nArray2, 0);
            if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
                throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glGetIntegerv"));
            }
            this.vertexTextureImageUnitsMax = nArray2[0];
            nArray = new int[]{0};
            gL.glGetIntegerv(1300955136, nArray, 0);
            if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
                throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glGetIntegerv"));
            }
            this.combinedTextureUnitsMax = nArray[0];
        }
        nArray3 = new int[]{0};
        gL.glGetIntegerv(3379, nArray3, 0);
        if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
            throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glGetIntegerv"));
        }
        this.maxTextureSize = nArray3[0];
        nArray2 = new int[]{0};
        gL.glGetIntegerv(478478336, nArray2, 0);
        if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
            throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glGetIntegerv"));
        }
        this.maxCubeTextureSize = nArray2[0];
        nArray = new int[]{0};
        gL.glGetIntegerv(-1568276480, nArray, 0);
        if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
            throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glGetIntegerv"));
        }
        this.compressedTextureFormats = new int[nArray[0]];
        if (this.compressedTextureFormats.length > 0) {
            gL.glGetIntegerv(-1551499264, this.compressedTextureFormats, 0);
            if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
                throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glGetIntegerv"));
            }
        }
        gL.glHint(-1837039616, 4353);
        if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
            throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glHint"));
        }
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    public GLGraphics3D getGLGraphics3D() {
        return (GLGraphics3D)this.getGraphics3D();
    }

    @Override
    public int getMaxTextureUnits() {
        return this.textureUnitsMax;
    }

    @Override
    public int getMaxVertexTextureUnits() {
        return this.vertexTextureImageUnitsMax;
    }

    @Override
    public int getMaxFragmentTextureUnits() {
        return this.fragmentTextureImageUnitsMax;
    }

    @Override
    public int getMaxCombinedTextureUnits() {
        return this.combinedTextureUnitsMax;
    }

    @Override
    public int getMaxTextureSize() {
        return this.maxTextureSize;
    }

    @Override
    public int[] getCompressedTextureFormats() {
        return this.compressedTextureFormats;
    }

    @Override
    protected boolean isTextureSizePowerOfTwoRequired() {
        return false;
    }

    @Override
    public PBufferTexture createPBufferTexture(PBufferSurface pBufferSurface) {
        throw new NotYetImplementedException();
    }

    @Override
    public FrameBufferTexture createFrameBufferTexture(int n, int n2, int n3) {
        Dimension dimension;
        Dimension dimension2 = dimension = new Dimension(n2, n3);
        if (this.isTextureSizePowerOfTwoRequired()) {
            int n4 = Util.nextPowerOfTwo(n2);
            int n5 = Util.nextPowerOfTwo(n3);
            if (n4 != n2 || n5 != n3) {
                dimension2 = new Dimension(n4, n5);
            }
        }
        return new GLFrameBufferTexture(this, n, dimension, dimension2, 1);
    }

    @Override
    protected Texture2D createTexture2D(int n, boolean bl, Dimension dimension, Dimension dimension2, int n2) {
        return new GLTexture2D(this, n, bl, dimension, dimension2, n2);
    }

    @Override
    public int getMaxCubeMapTextureSize() {
        return this.maxCubeTextureSize;
    }

    @Override
    protected TextureCubeMap createCubeMapTexture(int n, boolean bl, int n2, int n3) {
        int n4;
        Dimension dimension;
        Dimension dimension2 = dimension = new Dimension(n2, n2);
        if (this.isTextureSizePowerOfTwoRequired() && (n4 = Util.nextPowerOfTwo(n2)) != n2) {
            dimension2 = new Dimension(n4, n4);
        }
        return new GLTextureCubeMap(this, n, bl, dimension, dimension2, n3);
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
        $assertionsDisabled = !(class$de$vw$mib$graphics$internal$gl$GLTextureManager == null ? (class$de$vw$mib$graphics$internal$gl$GLTextureManager = GLTextureManager.class$("de.vw.mib.graphics.internal.gl.GLTextureManager")) : class$de$vw$mib$graphics$internal$gl$GLTextureManager).desiredAssertionStatus();
    }
}

