/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.lsctng.internal;

import de.vw.mib.log4mib.Logger;
import de.vw.mib.lsctng.internal.CachableSkinClassLoaderInternal;
import de.vw.mib.lsctng.internal.ClassLoaderCache;
import de.vw.mib.lsctng.internal.ServiceManager;
import de.vw.mib.lsctng.internal.SkinClassLoaderInternal;
import de.vw.mib.skin.SkinDatapoolUpdater;
import de.vw.mib.viewmanager.internal.ViewHandler;
import java.io.File;

public class CachingClassloader
implements SkinClassLoaderInternal {
    protected static final int SUB_CLASSIFIER;
    protected static final Logger LOG;
    private final CachableSkinClassLoaderInternal skinClassLoader;
    private final ClassLoaderCache cache;

    public CachingClassloader(CachableSkinClassLoaderInternal cachableSkinClassLoaderInternal, ClassLoaderCache classLoaderCache) {
        if (null == cachableSkinClassLoaderInternal) {
            throw new NullPointerException("skinClassLoader is null!");
        }
        this.skinClassLoader = cachableSkinClassLoaderInternal;
        if (null == classLoaderCache) {
            throw new NullPointerException("cache is null!");
        }
        this.cache = classLoaderCache;
    }

    @Override
    public ViewHandler getViewHandler(String string) {
        return this.skinClassLoader.getViewHandler(string);
    }

    @Override
    public ViewHandler getViewHandler(String string, String string2) {
        return this.skinClassLoader.getViewHandler(string, string2);
    }

    @Override
    public int getSkin() {
        return this.skinClassLoader.getSkin();
    }

    @Override
    public boolean unloadDataForClass(String string) {
        return this.skinClassLoader.unloadDataForClass(string);
    }

    @Override
    public boolean initializeClassLoaderForSkinId(int n) {
        if (n == this.getSkin()) {
            return true;
        }
        ClassLoader classLoader = this.cache.getCachedClassloader(n);
        if (null != classLoader) {
            return this.skinClassLoader.initializeClassLoaderForSkinId(n, classLoader);
        }
        boolean bl = this.skinClassLoader.initializeClassLoaderForSkinId(n);
        if (bl) {
            ClassLoader classLoader2 = this.skinClassLoader.getCurrentClassLoader();
            this.cache.storeClassloader(n, classLoader2);
        }
        return bl;
    }

    @Override
    public SkinDatapoolUpdater getSkinDatapoolUpdater() {
        return this.skinClassLoader.getSkinDatapoolUpdater();
    }

    @Override
    public File getLanguageFile(String string) {
        return this.skinClassLoader.getLanguageFile(string);
    }

    static {
        LOG = ServiceManager.createLogger();
    }
}

