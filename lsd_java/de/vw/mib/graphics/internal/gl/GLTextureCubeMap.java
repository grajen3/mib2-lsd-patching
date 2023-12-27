/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.gl;

import de.vw.mib.graphics.Dimension;
import de.vw.mib.graphics.image.BufferImage;
import de.vw.mib.graphics.internal.gl.GLTexture;
import de.vw.mib.graphics.internal.gl.GLTextureManager;
import de.vw.mib.graphics.texture.TextureCubeMap;

public final class GLTextureCubeMap
extends GLTexture
implements TextureCubeMap {
    public GLTextureCubeMap(GLTextureManager gLTextureManager, int n, boolean bl, Dimension dimension, Dimension dimension2, int n2) {
        super(gLTextureManager, 2, n, bl, dimension, dimension2, n2);
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    public int getByteSize() {
        return super.getByteSize() * 6;
    }

    @Override
    public BufferImage getContent(int n, int n2) {
        throw new UnsupportedOperationException("Reading textures is not supported");
    }

    @Override
    public BufferImage getContent(int n, int n2, int n3, int n4, int n5, int n6) {
        throw new UnsupportedOperationException("Reading textures is not supported");
    }

    @Override
    public void setContent(int n, int n2, BufferImage bufferImage) {
        this.setContent(n, n2, 0, 0, bufferImage);
    }

    @Override
    public void setContent(int n, int n2, int n3, int n4, BufferImage bufferImage) {
        this.setContent(n, n2, n3, n3, bufferImage.getWidth(), bufferImage.getHeight(), bufferImage);
    }

    @Override
    public void setContent(int n, int n2, int n3, int n4, int n5, int n6, BufferImage bufferImage) {
        this.setContentInternal(GLTextureCubeMap.mapGLFace(n), n2, n3, n4, n5, n6, bufferImage);
    }

    private static int mapGLFace(int n) {
        switch (n) {
            case 0: {
                return 361037824;
            }
            case 1: {
                return 377815040;
            }
            case 2: {
                return 394592256;
            }
            case 3: {
                return 411369472;
            }
            case 4: {
                return 428146688;
            }
            case 5: {
                return 444923904;
            }
        }
        throw new IllegalArgumentException("Invalid face");
    }
}

