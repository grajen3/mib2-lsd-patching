/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.texture;

import de.vw.mib.Disposable;
import de.vw.mib.collections.longs.LongObjectMap;
import de.vw.mib.collections.longs.LongObjectOptHashMap;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.image.BufferImage;
import de.vw.mib.graphics.internal.texture.TextureAtlas;
import de.vw.mib.graphics.internal.texture.TextureAtlas$SubTexture;
import de.vw.mib.graphics.internal.util.RectanglePacker;
import de.vw.mib.graphics.texture.Texture2D;
import de.vw.mib.graphics.texture.TextureFormat;
import de.vw.mib.graphics.texture.TextureManager;
import de.vw.mib.graphics.util.NIO;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.util.StringBuilder;
import java.nio.ByteBuffer;

final class TextureAtlas$TexturePage
implements Disposable {
    private static final boolean DEBUG = System.getProperty("de.vw.mib.graphics.textureatlas.fillremoved") != null;
    private static final boolean BATCH_PUT;
    private static ByteBuffer debugBuffer;
    private static ByteBuffer borderBuffer;
    private final Logger logger;
    private final Graphics3D g3d;
    private final TextureFormat textureFormat;
    private final Texture2D texture;
    private final RectanglePacker rectanglePacker;
    private static final int IMAGEID_TO_SUBTEXTURE_MAP_INITIAL_CAPACITY;
    private final LongObjectMap imageIdToSubTextureIndex;
    private BufferImage borderImage;

    public TextureAtlas$TexturePage(Logger logger, Graphics3D graphics3D, TextureFormat textureFormat) {
        this.logger = logger;
        this.g3d = graphics3D;
        this.textureFormat = textureFormat;
        this.texture = graphics3D.getTextureManager().createTexture2D(textureFormat.textureFormat, textureFormat.width, textureFormat.height, 1);
        this.rectanglePacker = new RectanglePacker(textureFormat.width, textureFormat.height);
        this.imageIdToSubTextureIndex = new LongObjectOptHashMap(100);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[textureFormat=").append(this.textureFormat);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public void dispose() {
        this.texture.dispose();
    }

    public TextureFormat getTextureFormat() {
        return this.textureFormat;
    }

    public Texture2D getTexture() {
        return this.texture;
    }

    public int getCoverage() {
        return this.rectanglePacker.getCoverage();
    }

    public TextureAtlas$SubTexture getSubTexture(BufferImage bufferImage) {
        long l = bufferImage.getId();
        return (TextureAtlas$SubTexture)this.imageIdToSubTextureIndex.get(l);
    }

    private static ByteBuffer getBorderBuffer(TextureManager textureManager) {
        if (borderBuffer == null) {
            int n = 4;
            boolean bl = false;
            borderBuffer = NIO.createNativeByteBuffer(textureManager.getMaxTextureSize() * 4);
            byte[] byArray = new byte[borderBuffer.capacity()];
            borderBuffer.put(byArray);
            borderBuffer.flip();
        }
        return borderBuffer;
    }

    private BufferImage getBorderImage() {
        if (this.borderImage == null) {
            TextureManager textureManager = this.g3d.getTextureManager();
            this.borderImage = new BufferImage(0L, TextureAtlas$TexturePage.getBorderBuffer(textureManager), this.textureFormat.textureFormat, textureManager.getMaxTextureSize(), 1);
        }
        return this.borderImage;
    }

    public TextureAtlas$SubTexture insertImage(long l, BufferImage bufferImage, boolean bl) {
        Rectangle rectangle = null;
        Rectangle rectangle2 = null;
        if (bl) {
            int n = this.textureFormat.width == bufferImage.getWidth() ? 0 : 2;
            int n2 = this.textureFormat.height == bufferImage.getHeight() ? 0 : 2;
            rectangle = this.rectanglePacker.insert(bufferImage.getWidth() + n, bufferImage.getHeight() + n2);
            if (rectangle == null) {
                return null;
            }
            BufferImage bufferImage2 = this.getBorderImage();
            if (n > 0) {
                this.texture.setContent(0, rectangle.x + rectangle.width - 1, rectangle.y, 1, rectangle.height, bufferImage2);
                this.texture.setContent(0, rectangle.x, rectangle.y, 1, rectangle.height, bufferImage2);
            }
            if (n2 > 0) {
                this.texture.setContent(0, rectangle.x, rectangle.y, rectangle.width, 1, bufferImage2);
                this.texture.setContent(0, rectangle.x, rectangle.y + rectangle.height - 1, rectangle.width, 1, bufferImage2);
            }
            rectangle2 = new Rectangle(rectangle.x + n / 2, rectangle.y + n2 / 2, bufferImage.getWidth(), bufferImage.getHeight());
        } else {
            rectangle = this.rectanglePacker.insert(bufferImage.getWidth(), bufferImage.getHeight());
            if (rectangle == null) {
                return null;
            }
            rectangle2 = new Rectangle(rectangle.x, rectangle.y, bufferImage.getWidth(), bufferImage.getHeight());
        }
        this.texture.setContent(0, rectangle2.x, rectangle2.y, bufferImage);
        TextureAtlas$SubTexture textureAtlas$SubTexture = (TextureAtlas$SubTexture)TextureAtlas.SUBTEXTURE_POOL.borrowObject();
        if (DEBUG) {
            LogMessage logMessage = this.logger.trace(16384);
            logMessage.append("Current SubTexturePool.size(): ").append(TextureAtlas.SUBTEXTURE_POOL.size()).log();
        }
        textureAtlas$SubTexture.setId(l);
        textureAtlas$SubTexture.setBorder(bl);
        textureAtlas$SubTexture.setTexturePage(this);
        textureAtlas$SubTexture.setRectangle(rectangle2);
        textureAtlas$SubTexture.setBorderRectangle(rectangle);
        this.imageIdToSubTextureIndex.put(textureAtlas$SubTexture.getId(), textureAtlas$SubTexture);
        return textureAtlas$SubTexture;
    }

    public void removeSubTexture(TextureAtlas$SubTexture textureAtlas$SubTexture) {
        this.rectanglePacker.removeRectangle(textureAtlas$SubTexture.getBorderRectangle());
        this.imageIdToSubTextureIndex.remove(textureAtlas$SubTexture.getId());
        if (DEBUG && this.textureFormat.textureFormat == 4356) {
            int n = 4;
            int n2 = this.textureFormat.width * this.textureFormat.height * 4;
            if (debugBuffer == null || debugBuffer.capacity() < n2) {
                int n3 = -1442840406;
                debugBuffer = NIO.createNativeByteBuffer(n2);
                for (int i2 = debugBuffer.capacity() / 4; i2 > 0; i2 -= 4) {
                    debugBuffer.putInt(-1442840406);
                }
                debugBuffer.flip();
            }
            debugBuffer.rewind();
            BufferImage bufferImage = new BufferImage(-1L, debugBuffer, 4356, textureAtlas$SubTexture.getRectangle().width, textureAtlas$SubTexture.getRectangle().height);
            this.texture.setContent(0, textureAtlas$SubTexture.getRectangle().x, textureAtlas$SubTexture.getRectangle().y, bufferImage);
        }
    }

    public void removeImage(BufferImage bufferImage) {
        long l = bufferImage.getId();
        this.removeSubTexture((TextureAtlas$SubTexture)this.imageIdToSubTextureIndex.get(l));
    }

    public void clear() {
        this.rectanglePacker.reset();
        this.imageIdToSubTextureIndex.clear();
    }
}

