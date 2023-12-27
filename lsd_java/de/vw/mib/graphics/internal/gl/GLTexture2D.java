/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.gl;

import de.vw.mib.graphics.Dimension;
import de.vw.mib.graphics.image.BufferImage;
import de.vw.mib.graphics.internal.gl.GLTexture;
import de.vw.mib.graphics.internal.gl.GLTextureManager;
import de.vw.mib.graphics.texture.Texture2D;

public final class GLTexture2D
extends GLTexture
implements Texture2D {
    public GLTexture2D(GLTextureManager gLTextureManager, int n, boolean bl, Dimension dimension, Dimension dimension2, int n2) {
        super(gLTextureManager, 0, n, bl, dimension, dimension2, n2);
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    public BufferImage getContent(int n) {
        throw new UnsupportedOperationException("Reading textures is not supported");
    }

    @Override
    public BufferImage getContent(int n, int n2, int n3, int n4, int n5) {
        throw new UnsupportedOperationException("Reading textures is not supported");
    }

    @Override
    public void setContent(int n, BufferImage bufferImage) {
        this.setContent(n, 0, 0, bufferImage);
    }

    @Override
    public void setContent(int n, int n2, int n3, BufferImage bufferImage) {
        this.setContent(n, n2, n3, bufferImage.getWidth(), bufferImage.getHeight(), bufferImage);
    }

    @Override
    public void setContent(int n, int n2, int n3, int n4, int n5, BufferImage bufferImage) {
        this.setContentInternal(this.getGLTarget(), n, n2, n3, n4, n5, bufferImage);
    }
}

