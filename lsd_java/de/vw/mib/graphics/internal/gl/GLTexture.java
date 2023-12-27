/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.gl;

import de.vw.mib.graphics.Dimension;
import de.vw.mib.graphics.image.BufferImage;
import de.vw.mib.graphics.internal.ServiceManager;
import de.vw.mib.graphics.internal.gl.GLGraphics3D;
import de.vw.mib.graphics.internal.gl.GLTextureManager;
import de.vw.mib.graphics.internal.texture.AbstractTexture;
import de.vw.mib.graphics.texture.TextureFormat;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.util.StringBuilder;
import java.nio.ByteBuffer;
import javax.media.opengl.GL;

public abstract class GLTexture
extends AbstractTexture {
    private static final int NULL_ID;
    private static GLTexture[][] targetsBound;
    protected final GL gl;
    private final int target;
    private final int glTarget;
    private final int glFormat;
    private final int glType;
    private final int alignment;
    private final int pixelSize;
    private final int textureId;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$graphics$internal$gl$GLTexture;

    public GLTexture(GLTextureManager gLTextureManager, int n, int n2, boolean bl, Dimension dimension, Dimension dimension2, int n3) {
        super(gLTextureManager.getGraphics3D(), gLTextureManager.getLogger(), gLTextureManager, n, n2, bl, dimension, dimension2, n3);
        GLGraphics3D gLGraphics3D = this.getGLGraphics3D();
        this.gl = gLGraphics3D.getGL();
        if (targetsBound == null) {
            int n4 = gLGraphics3D.getTextureManager().getMaxTextureUnits();
            targetsBound = new GLTexture[n4][5];
        }
        switch (n) {
            case 0: 
            case 3: 
            case 4: {
                this.target = 0;
                break;
            }
            case 2: {
                this.target = 2;
                break;
            }
            default: {
                throw new IllegalArgumentException("Invalid texture type");
            }
        }
        this.glTarget = GLTexture.mapGLTarget(n);
        this.glFormat = GLTexture.mapGLFormat(n2);
        this.glType = GLTexture.mapGLType(n2);
        this.alignment = GLTexture.getAlignment(n2);
        this.pixelSize = GLTexture.getPixelSize(n2);
        int[] nArray = new int[]{0};
        this.gl.glGenTextures(nArray.length, nArray, 0);
        if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
            throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glGenTextures"));
        }
        this.textureId = nArray[0];
        if (!$assertionsDisabled && this.textureId == 0) {
            throw new AssertionError((Object)"Texture Namespace exhausted");
        }
        if (this.getLogger().isTraceEnabled(8192)) {
            LogMessage logMessage = this.getLogger().trace(8192);
            logMessage.append("Allocated texture #").append(this.textureId).append(" target 0x").append(Integer.toHexString(this.glTarget)).append(" format 0x").append(Integer.toHexString(this.glFormat)).append(" type 0x").append(Integer.toHexString(this.glType)).append(" size ").append(dimension2.width).append("x").append(dimension2.height).append("x").append(this.pixelSize).append(" = ").append(this.getByteSize()).append(" bytes");
            logMessage.log();
        }
        this.bind(0);
        int n5 = dimension2.width;
        int n6 = dimension2.height;
        switch (n) {
            case 0: 
            case 3: 
            case 4: {
                for (int i2 = 0; i2 < n3; ++i2) {
                    this.gl.glTexImage2D(this.glTarget, i2, this.glFormat, n5, n6, 0, this.glFormat, this.glType, null);
                    if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
                        throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glTexImage2D"));
                    }
                    n5 = Math.max(1, n5 >> 1);
                    n6 = Math.max(1, n6 >> 1);
                }
                break;
            }
            case 2: {
                for (int i3 = 0; i3 < n3; ++i3) {
                    for (int i4 = 361037824; i4 <= 444923904; ++i4) {
                        this.gl.glTexImage2D(i4, i3, this.glFormat, n5, n6, 0, this.glFormat, this.glType, null);
                        if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
                            throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glTexImage2D"));
                        }
                    }
                    n5 = Math.max(1, n5 >> 1);
                    n6 = Math.max(1, n6 >> 1);
                }
                break;
            }
            default: {
                throw new IllegalArgumentException("Invalid texture type");
            }
        }
        this.filteringChanged();
        this.wrappingChanged();
    }

    @Override
    public void dispose() {
        int[] nArray = new int[]{this.textureId};
        this.gl.glDeleteTextures(nArray.length, nArray, 0);
        if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
            throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glDeleteTextures"));
        }
        if (this.getLogger().isTraceEnabled(8192)) {
            LogMessage logMessage = this.getLogger().trace(8192);
            logMessage.append("Released texture #").append(this.textureId).log();
        }
        super.dispose();
    }

    protected final GLGraphics3D getGLGraphics3D() {
        return (GLGraphics3D)this.getGraphics3D();
    }

    @Override
    public void generateMipMaps() {
        this.bind(0);
        this.gl.glGenerateMipmapEXT(this.glTarget);
        if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
            throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glGenerateMipmapEXT"));
        }
    }

    @Override
    public final boolean isReadable() {
        return false;
    }

    @Override
    protected final void filteringChanged() {
        int n;
        int n2;
        GLGraphics3D gLGraphics3D = this.getGLGraphics3D();
        this.bind(0);
        block0 : switch (this.getMinFilter()) {
            case 0: 
            case 1: {
                switch (this.getMipFilter()) {
                    case 0: {
                        n2 = 9728;
                        break block0;
                    }
                    case 1: {
                        n2 = 9984;
                        break block0;
                    }
                    case 2: {
                        n2 = 9986;
                        break block0;
                    }
                }
                throw new IllegalArgumentException("Invalid texture mipmap filtering mode");
            }
            case 2: {
                switch (this.getMipFilter()) {
                    case 0: {
                        n2 = 9729;
                        break block0;
                    }
                    case 1: {
                        n2 = 9985;
                        break block0;
                    }
                    case 2: {
                        n2 = 9987;
                        break block0;
                    }
                }
                throw new IllegalArgumentException("Invalid texture mipmap filtering mode");
            }
            default: {
                throw new IllegalArgumentException("Invalid texture minification filtering mode");
            }
        }
        this.gl.glTexParameteri(this.glTarget, 10241, n2);
        if (!$assertionsDisabled && !gLGraphics3D.checkGLError()) {
            throw new AssertionError((Object)gLGraphics3D.printGLError("glTexParameteri"));
        }
        switch (this.getMagFilter()) {
            case 0: 
            case 1: {
                n = 9728;
                break;
            }
            case 2: {
                n = 9729;
                break;
            }
            default: {
                throw new IllegalArgumentException("Invalid texture magnification filtering mode");
            }
        }
        this.gl.glTexParameteri(this.glTarget, 10240, n);
        if (!$assertionsDisabled && !gLGraphics3D.checkGLError()) {
            throw new AssertionError((Object)gLGraphics3D.printGLError("glTexParameteri"));
        }
    }

    @Override
    protected final void wrappingChanged() {
        GLGraphics3D gLGraphics3D = this.getGLGraphics3D();
        this.bind(0);
        int n = GLTexture.mapGLWrap(this.getWrapS());
        this.gl.glTexParameteri(this.glTarget, 10242, n);
        if (!$assertionsDisabled && !gLGraphics3D.checkGLError()) {
            throw new AssertionError((Object)gLGraphics3D.printGLError("glTexParameteri"));
        }
        int n2 = GLTexture.mapGLWrap(this.getWrapT());
        this.gl.glTexParameteri(this.glTarget, 10243, n2);
        if (!$assertionsDisabled && !gLGraphics3D.checkGLError()) {
            throw new AssertionError((Object)gLGraphics3D.printGLError("glTexParameteri"));
        }
    }

    public final int getTextureId() {
        return this.textureId;
    }

    public final int getGLFormat() {
        return this.glFormat;
    }

    public final int getGLTarget() {
        return this.glTarget;
    }

    public final boolean isBound(int n) {
        return targetsBound[n][this.target] == this;
    }

    public final void bind(int n) {
        GLGraphics3D gLGraphics3D = this.getGLGraphics3D();
        GLTexture gLTexture = targetsBound[n][this.target];
        gLGraphics3D.selectTextureUnit(n);
        if (gLTexture != this) {
            Logger logger = this.getLogger();
            if (GLGraphics3D.FIXED_FUNCTION_PIPELINE && !GLGraphics3D.GLES20_SUBSET && gLTexture != null && gLTexture.glTarget != this.glTarget) {
                this.gl.glDisable(gLTexture.glTarget);
                if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
                    throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glDisable"));
                }
            }
            this.gl.glBindTexture(this.glTarget, this.textureId);
            if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
                throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glBindTexture"));
            }
            if (GLGraphics3D.FIXED_FUNCTION_PIPELINE && !GLGraphics3D.GLES20_SUBSET && (gLTexture == null || gLTexture.glTarget != this.glTarget)) {
                this.gl.glEnable(this.glTarget);
                if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
                    throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glEnable"));
                }
            }
            if (logger.isTraceEnabled(8192) && logger.isTraceEnabled(64)) {
                LogMessage logMessage = logger.trace(8192);
                logMessage.append("Bound texture #").append(this.textureId).append(" to unit ").append(n).log();
            }
            GLTexture.targetsBound[n][this.target] = this;
            super.bind();
        }
    }

    public final void unbind(int n) {
        GLTexture gLTexture = targetsBound[n][this.target];
        if (gLTexture == this) {
            Logger logger = this.getLogger();
            GLGraphics3D gLGraphics3D = this.getGLGraphics3D();
            gLGraphics3D.selectTextureUnit(n);
            if (GLGraphics3D.FIXED_FUNCTION_PIPELINE && !GLGraphics3D.GLES20_SUBSET) {
                this.gl.glDisable(gLTexture.glTarget);
                if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
                    throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glDisable"));
                }
            }
            this.gl.glBindTexture(this.glTarget, 0);
            if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
                throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glBindTexture"));
            }
            if (logger.isTraceEnabled(8192) && logger.isTraceEnabled(64)) {
                LogMessage logMessage = logger.trace(8192);
                logMessage.append("Unbound texture #").append(this.textureId).log();
            }
            GLTexture.targetsBound[n][this.target] = null;
        }
    }

    protected final void setContentInternal(int n, int n2, int n3, int n4, int n5, int n6, BufferImage bufferImage) {
        Logger logger = this.getLogger();
        if (n5 <= 0 || n6 <= 0 || n5 * n6 > bufferImage.getWidth() * bufferImage.getHeight() || n3 + n5 > this.getSize().width || n4 + n6 > this.getSize().height || bufferImage.getImageFormat() != this.getTextureFormat()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("setContentInternal(target=0x").append(Integer.toHexString(n)).append(",level=").append(n2).append(",x=").append(n3).append(",y=").append(n4).append(",width=").append(n5).append(",height=").append(n6).append(",image=").append(bufferImage).append("): Invalid parameters");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        this.bind(0);
        this.gl.glPixelStorei(3317, 1);
        if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
            throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glPixelStorei"));
        }
        ByteBuffer byteBuffer = bufferImage.getBuffer();
        if (byteBuffer != null) {
            byteBuffer.rewind();
            LogMessage logMessage = logger.isTraceEnabled(8192) ? logger.trace(8192) : null;
            boolean bl = logMessage != null && logger.isTraceEnabled(128);
            long l = bl ? ServiceManager.timerManager.getSystemTimeMicros() : 0L;
            boolean bl2 = this.isCompressed();
            if (bl2) {
                if (!$assertionsDisabled && !TextureFormat.isCompressedFormat(bufferImage.getImageFormat())) {
                    throw new AssertionError();
                }
                this.gl.glCompressedTexSubImage2D(n, n2, n3, n4, n5, n6, this.glFormat, byteBuffer.remaining(), byteBuffer);
                if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
                    throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glCompressedTexSubImage2D"));
                }
            } else {
                this.gl.glTexSubImage2D(n, n2, n3, n4, n5, n6, this.glFormat, this.glType, byteBuffer);
                if (!$assertionsDisabled && !this.getGLGraphics3D().checkGLError()) {
                    throw new AssertionError((Object)this.getGLGraphics3D().printGLError("glTexSubImage2D"));
                }
            }
            if (logMessage != null) {
                logMessage.append(bl2 ? "glCompressedTexSubImage2D" : "glTexSubImage2D").append("(#").append(this.getTextureId()).append(", ").append(n5).append("x").append(n6).append(" px -> ");
                logMessage.append(n3).append(",").append(n4).append("@").append(this.getSize().width).append("x").append(this.getSize().height).append(" px)");
                if (bl) {
                    long l2 = ServiceManager.timerManager.getSystemTimeMicros();
                    logMessage.append(": ").append(l2 - l).append("\u00b5s");
                }
                logMessage.log();
            }
        } else {
            LogMessage logMessage = logger.error(8192);
            logMessage.append("Image is already disposed!");
            logMessage.log();
        }
    }

    private static int mapGLTarget(int n) {
        switch (n) {
            case 0: 
            case 3: 
            case 4: {
                return 3553;
            }
            case 2: {
                return 327483392;
            }
        }
        throw new IllegalArgumentException("Invalid texture type");
    }

    private static int mapGLFormat(int n) {
        switch (n) {
            case 4608: {
                return 6409;
            }
            case 4096: {
                return 6406;
            }
            case 4097: {
                return 6410;
            }
            case 4352: {
                return 6407;
            }
            case 4353: {
                return 6408;
            }
            case 4354: {
                return 6408;
            }
            case 4355: {
                return 6407;
            }
            case 4356: {
                return 6408;
            }
        }
        throw new IllegalArgumentException("Invalid texture format");
    }

    private static int mapGLType(int n) {
        switch (n) {
            case 4608: {
                return 5121;
            }
            case 4096: {
                return 5121;
            }
            case 4097: {
                return 5121;
            }
            case 4352: {
                return 1669529600;
            }
            case 4353: {
                return 880803840;
            }
            case 4354: {
                return 0x33800000;
            }
            case 4355: {
                return 5121;
            }
            case 4356: {
                return 5121;
            }
        }
        throw new IllegalArgumentException("Invalid texture format");
    }

    private static int getAlignment(int n) {
        switch (n) {
            case 4096: 
            case 4608: {
                return 1;
            }
            case 4097: 
            case 4352: 
            case 4353: 
            case 4354: {
                return 2;
            }
            case 4355: {
                return 3;
            }
            case 4356: {
                return 4;
            }
        }
        throw new IllegalArgumentException("Invalid texture format");
    }

    private static int getPixelSize(int n) {
        switch (n) {
            case 4096: 
            case 4608: {
                return 1;
            }
            case 4097: 
            case 4352: 
            case 4353: 
            case 4354: {
                return 2;
            }
            case 4355: {
                return 3;
            }
            case 4356: {
                return 4;
            }
        }
        throw new IllegalArgumentException("Invalid texture format");
    }

    private static int mapGLWrap(int n) {
        switch (n) {
            case 0: {
                return 10497;
            }
            case 1: {
                return 796983296;
            }
            case 2: {
                return 1887633408;
            }
        }
        throw new IllegalArgumentException("Invalid texture wrapping mode");
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
        $assertionsDisabled = !(class$de$vw$mib$graphics$internal$gl$GLTexture == null ? (class$de$vw$mib$graphics$internal$gl$GLTexture = GLTexture.class$("de.vw.mib.graphics.internal.gl.GLTexture")) : class$de$vw$mib$graphics$internal$gl$GLTexture).desiredAssertionStatus();
    }
}

