/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.texture;

import de.vw.mib.Disposable;
import de.vw.mib.cache.Cacheable;
import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.collections.copyonwrite.CowList;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.collections.longs.LongObjectMap;
import de.vw.mib.collections.longs.LongObjectOptHashMap;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.image.BufferImage;
import de.vw.mib.graphics.image.UnsupportedImageFormatException;
import de.vw.mib.graphics.image.UnsupportedImageSizeException;
import de.vw.mib.graphics.internal.AbstractResource;
import de.vw.mib.graphics.internal.InsufficientSpaceException;
import de.vw.mib.graphics.internal.texture.TextureAtlas$SubTexture;
import de.vw.mib.graphics.internal.texture.TextureAtlas$SubTextureCache;
import de.vw.mib.graphics.internal.texture.TextureAtlas$SubTexturePool;
import de.vw.mib.graphics.internal.texture.TextureAtlas$TextureAtlasListener;
import de.vw.mib.graphics.internal.texture.TextureAtlas$TexturePage;
import de.vw.mib.graphics.texture.Texture2D;
import de.vw.mib.graphics.texture.TextureFormat;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import java.util.ArrayList;
import java.util.List;

public final class TextureAtlas
extends AbstractResource {
    private static final int SUBTEXTURE_POOL_MAXIMUM_CAPACITY;
    protected static final TextureAtlas$SubTexturePool SUBTEXTURE_POOL;
    private static final int PAGE_LIST_INITIAL_CAPACITY;
    private static final int TEXTUREFORMAT_INDICES_MAP_INITIAL_CAPACITY;
    private final IntObjectMap textureFormatToPageListIndex = new IntObjectOptHashMap(10);
    private final IntObjectMap textureFormatToSubTextureCacheIndex = new IntObjectOptHashMap(10);
    private static final int LOCKED_SUBTEXTURES_MAP_INITIAL_CAPACITY;
    private final LongObjectMap lockedSubTextures = new LongObjectOptHashMap(100);
    private CowList listeners = CowList.EMPTY;
    private static HashCodeBuilder hcb;

    public TextureAtlas(Graphics3D graphics3D, Logger logger, TextureFormat[] textureFormatArray) {
        super(graphics3D, logger);
        for (int i2 = 0; i2 < textureFormatArray.length; ++i2) {
            TextureFormat textureFormat = textureFormatArray[i2];
            this.addPage(textureFormat);
        }
    }

    @Override
    public void dispose() {
        Object[] objectArray = this.textureFormatToPageListIndex.valuesToArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            List list = (List)objectArray[i2];
            for (int i3 = list.size() - 1; i3 >= 0; --i3) {
                TextureAtlas$TexturePage textureAtlas$TexturePage = (TextureAtlas$TexturePage)list.get(i3);
                textureAtlas$TexturePage.dispose();
            }
        }
        super.dispose();
    }

    public int getNumPages() {
        int n = 0;
        Object[] objectArray = this.textureFormatToPageListIndex.valuesToArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            List list = (List)objectArray[i2];
            n += list.size();
        }
        return n;
    }

    public int getNumPages(int n) {
        List list = (List)this.textureFormatToPageListIndex.get(n);
        return list.size();
    }

    private List getPages(int n) {
        List list = (List)this.textureFormatToPageListIndex.get(n);
        if (list == null) {
            list = new ArrayList(5);
            this.textureFormatToPageListIndex.put(n, list);
        }
        return list;
    }

    private TextureAtlas$SubTextureCache getSubTextures(int n) {
        TextureAtlas$SubTextureCache textureAtlas$SubTextureCache = (TextureAtlas$SubTextureCache)this.textureFormatToSubTextureCacheIndex.get(n);
        if (textureAtlas$SubTextureCache == null) {
            textureAtlas$SubTextureCache = new TextureAtlas$SubTextureCache(this, this);
            this.textureFormatToSubTextureCacheIndex.put(n, textureAtlas$SubTextureCache);
        }
        return textureAtlas$SubTextureCache;
    }

    private TextureAtlas$TexturePage addPage(TextureFormat textureFormat) {
        Object object;
        Logger logger = this.getLogger();
        if (logger.isTraceEnabled(16384)) {
            object = logger.trace(16384);
            object.append("Allocating new texture page ").append(textureFormat).log();
        }
        object = new TextureAtlas$TexturePage(logger, this.getGraphics3D(), textureFormat);
        this.getPages(textureFormat.textureFormat).add(object);
        return object;
    }

    private void removePage(TextureAtlas$TexturePage textureAtlas$TexturePage) {
        Logger logger = this.getLogger();
        TextureFormat textureFormat = textureAtlas$TexturePage.getTextureFormat();
        this.getPages(textureFormat.textureFormat).remove(textureAtlas$TexturePage);
        textureAtlas$TexturePage.dispose();
        if (logger.isTraceEnabled(16384)) {
            LogMessage logMessage = logger.trace(16384);
            logMessage.append("Disposed texture page ").append(textureFormat).log();
        }
    }

    private void clear() {
        Object[] objectArray = this.textureFormatToPageListIndex.valuesToArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            List list = (List)objectArray[i2];
            for (int i3 = list.size() - 1; i3 >= 0; --i3) {
                TextureAtlas$TexturePage textureAtlas$TexturePage = (TextureAtlas$TexturePage)list.get(i3);
                textureAtlas$TexturePage.clear();
            }
        }
        this.lockedSubTextures.clear();
    }

    private TextureAtlas$SubTexture insertImage(long l, BufferImage bufferImage, boolean bl) {
        Disposable disposable;
        Logger logger = this.getLogger();
        int n = bufferImage.getImageFormat();
        List list = this.getPages(n);
        if (list.size() == 0) {
            throw new UnsupportedImageFormatException(bufferImage.getImageFormat());
        }
        boolean bl2 = false;
        for (int i2 = 0; i2 < list.size(); ++i2) {
            disposable = (TextureAtlas$TexturePage)list.get(i2);
            TextureFormat textureFormat = disposable.getTextureFormat();
            if (bl) {
                boolean bl3;
                boolean bl4 = textureFormat.width == bufferImage.getWidth() || textureFormat.width >= bufferImage.getWidth() + 2;
                boolean bl5 = bl3 = textureFormat.height == bufferImage.getHeight() || textureFormat.height >= bufferImage.getHeight() + 2;
                if (!bl4 || !bl3) continue;
                bl2 = true;
                break;
            }
            if (textureFormat.width < bufferImage.getWidth() || textureFormat.height < bufferImage.getHeight()) continue;
            bl2 = true;
            break;
        }
        if (!bl2) {
            throw new UnsupportedImageSizeException(bufferImage.getWidth(), bufferImage.getHeight());
        }
        TextureAtlas$SubTextureCache textureAtlas$SubTextureCache = this.getSubTextures(n);
        disposable = null;
        do {
            for (int i3 = 0; i3 < list.size(); ++i3) {
                TextureAtlas$TexturePage textureAtlas$TexturePage = (TextureAtlas$TexturePage)list.get(i3);
                TextureFormat textureFormat = textureAtlas$TexturePage.getTextureFormat();
                if (textureFormat.textureFormat != n || (disposable = textureAtlas$TexturePage.insertImage(l, bufferImage, bl)) == null) continue;
                textureAtlas$SubTextureCache.put(l, (Cacheable)((Object)disposable));
                if (!logger.isTraceEnabled(16384)) break;
                LogMessage logMessage = logger.trace(16384);
                logMessage.append("Inserted subtexture for image ").append(bufferImage).append(" as ").append(disposable).log();
                break;
            }
            if (disposable != null || textureAtlas$SubTextureCache.evict()) continue;
            LogMessage logMessage = logger.warn(16384);
            logMessage.append("Not enough space for image ").append(bufferImage).log();
            throw new InsufficientSpaceException(bufferImage.getWidth(), bufferImage.getHeight());
        } while (disposable == null);
        return disposable;
    }

    public TextureAtlas$SubTexture getSubTexture(BufferImage bufferImage) {
        return this.getSubTexture(bufferImage, false);
    }

    public TextureAtlas$SubTexture getSubTexture(BufferImage bufferImage, boolean bl) {
        TextureAtlas$SubTextureCache textureAtlas$SubTextureCache = this.getSubTextures(bufferImage.getImageFormat());
        long l = 0L;
        TextureAtlas$SubTexture textureAtlas$SubTexture = null;
        if (!bl) {
            l = TextureAtlas.calculateSubTextureKey(bufferImage, true);
            textureAtlas$SubTexture = (TextureAtlas$SubTexture)textureAtlas$SubTextureCache.get(l);
        }
        if (textureAtlas$SubTexture == null) {
            l = TextureAtlas.calculateSubTextureKey(bufferImage, bl);
            textureAtlas$SubTexture = (TextureAtlas$SubTexture)textureAtlas$SubTextureCache.get(l);
        }
        if (textureAtlas$SubTexture == null) {
            textureAtlas$SubTexture = this.insertImage(l, bufferImage, bl);
        }
        return textureAtlas$SubTexture;
    }

    private static long calculateSubTextureKey(BufferImage bufferImage, boolean bl) {
        hcb.reset();
        hcb.append(bufferImage.getId());
        hcb.append(bl);
        return hcb.longHashCode();
    }

    public void lockSubTexture(TextureAtlas$SubTexture textureAtlas$SubTexture) {
        this.lockedSubTextures.put(textureAtlas$SubTexture.getId(), textureAtlas$SubTexture);
    }

    public void unlockSubTexture(TextureAtlas$SubTexture textureAtlas$SubTexture) {
        this.lockedSubTextures.remove(textureAtlas$SubTexture.getId());
    }

    public void unlockAllSubTextures() {
        this.lockedSubTextures.clear();
    }

    public boolean isSubTextureLocked(TextureAtlas$SubTexture textureAtlas$SubTexture) {
        return this.lockedSubTextures.containsKey(textureAtlas$SubTexture.getId());
    }

    public Texture2D getTexture(int n, int n2) {
        List list = this.getPages(n);
        Texture2D texture2D = null;
        if (n2 < list.size()) {
            texture2D = ((TextureAtlas$TexturePage)list.get(n2)).getTexture();
        }
        return texture2D;
    }

    public float getCoverage(int n, int n2) {
        List list = this.getPages(n);
        float f2 = 0.0f;
        if (n2 < list.size()) {
            TextureAtlas$TexturePage textureAtlas$TexturePage = (TextureAtlas$TexturePage)list.get(n2);
            TextureFormat textureFormat = textureAtlas$TexturePage.getTextureFormat();
            f2 = (float)textureAtlas$TexturePage.getCoverage() / (float)(textureFormat.width * textureFormat.height);
        }
        return f2;
    }

    public void addTextureAtlasListener(TextureAtlas$TextureAtlasListener textureAtlas$TextureAtlasListener) {
        this.listeners = this.listeners.addIfAbsent(textureAtlas$TextureAtlasListener);
    }

    public void removeTextureAtlasListener(TextureAtlas$TextureAtlasListener textureAtlas$TextureAtlasListener) {
        this.listeners = this.listeners.remove(textureAtlas$TextureAtlasListener);
    }

    protected void fireSubTextureRemoved(TextureAtlas$SubTexture textureAtlas$SubTexture) {
        Object object;
        Logger logger = this.getLogger();
        if (logger.isTraceEnabled(16384)) {
            object = logger.trace(16384);
            object.append("Removed sub texture ").append(textureAtlas$SubTexture).log();
        }
        for (object = this.listeners; object != CowList.EMPTY; object = ((CowList)object).tail()) {
            TextureAtlas$TextureAtlasListener textureAtlas$TextureAtlasListener = (TextureAtlas$TextureAtlasListener)((CowList)object).head();
            textureAtlas$TextureAtlasListener.subTextureRemoved(textureAtlas$SubTexture);
        }
    }

    static {
        SUBTEXTURE_POOL = new TextureAtlas$SubTexturePool(100);
        hcb = new HashCodeBuilder();
    }
}

