/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.lsctng.internal;

import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.file.FileManager;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.lsctng.internal.CachableSkinClassLoaderInternal;
import de.vw.mib.lsctng.internal.ServiceManager;
import de.vw.mib.skin.SkinClassLoader;
import de.vw.mib.skin.SkinDatapoolUpdater;
import de.vw.mib.viewmanager.internal.ViewHandler;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

public class JxeSkinClassLoader
implements SkinClassLoader,
CachableSkinClassLoaderInternal {
    private static final String COMMON_CLASSES_JXE_NAME;
    private static final String INFO_NAME;
    private static final String LANGUAGE_RESOURCE_EXTENSION;
    private static final String SKIN_DP_UPDATER;
    private static final String ZIP_NAME;
    private ClassLoader classloader = null;
    private final FileManager fileManager = ServiceManager.fileManager;
    private final IntObjectMap loadedContainers = new IntObjectOptHashMap(3);
    protected static final int SUB_CLASSIFIER;
    protected static final Logger LOG;
    private int skinId = -1;

    public JxeSkinClassLoader() {
        if (LOG.isTraceEnabled(4096)) {
            LOG.trace(4096, "JxeSkinClassLoader instantiated.");
        }
    }

    @Override
    public File getLanguageFile(String string) {
        String string2 = ServiceManager.configValueSetter.getCurrentI18nPath();
        File file = new File(new StringBuffer().append(string2).append("/").append(string).append(".res").toString());
        if (LOG.isTraceEnabled(4096)) {
            LOG.trace(4096).append("get language file for language ").append(string).append(": ").append(file.getAbsolutePath()).log();
        }
        return file;
    }

    @Override
    public int getSkin() {
        return this.skinId;
    }

    @Override
    public synchronized SkinDatapoolUpdater getSkinDatapoolUpdater() {
        this.loadCommonJxe();
        Class clazz = this.loadClass("generated.de.vw.mib.skin.internal.SkinDatapoolUpdaterImpl");
        return (SkinDatapoolUpdater)this.instantiateObject(clazz);
    }

    private void loadCommonJxe() {
        this.loadXIPContainer("CommonClasses.jxe");
    }

    @Override
    public synchronized ViewHandler getViewHandler(String string) {
        this.loadViewhandlerJxe(this.getContainerNameForClassName(string));
        Class clazz = this.loadClass(string);
        return (ViewHandler)this.instantiateObject(clazz);
    }

    private void loadViewhandlerJxe(String string) {
        this.loadXIPContainer(string);
    }

    @Override
    public synchronized ViewHandler getViewHandler(String string, String string2) {
        this.loadViewhandlerJxe(new StringBuffer().append(string).append(".jxe").toString());
        Class clazz = this.loadClass(new StringBuffer().append(string2).append(string).toString());
        return (ViewHandler)this.instantiateObject(clazz);
    }

    @Override
    public boolean initializeClassLoaderForSkinId(int n) {
        ClassLoader classLoader;
        if (n == this.skinId) {
            return true;
        }
        if (LOG.isTraceEnabled(4096)) {
            LOG.trace(4096).append("initializeClassLoaderForSkinId(").append(n).append(")").log();
        }
        this.initLoadedContainers(n);
        String string = ServiceManager.configValueSetter.getSkinPath(n);
        String string2 = new StringBuffer().append(string).append(File.separator).append("info.txt").toString();
        if (!new File(string2).isFile()) {
            LOG.error(4096).append("Can't find info.txt in skin path for skin ID ").append(n).append(": ").append(string).log();
            this.classloader = null;
            this.skinId = -1;
            return false;
        }
        String string3 = new StringBuffer().append(string).append(File.separator).append(ZIP_NAME).toString();
        try {
            URL uRL = new File(string3).toURI().toURL();
            classLoader = this.fileManager.createClassLoader(new URL[]{uRL});
        }
        catch (MalformedURLException malformedURLException) {
            LOG.error(4096).append("Can't create URL for skin ").append(n).append("from path: ").append(string3).attachThrowable(malformedURLException).log();
            this.classloader = null;
            this.skinId = -1;
            return false;
        }
        return this.initializeClassLoaderForSkinId(n, classLoader);
    }

    @Override
    public boolean initializeClassLoaderForSkinId(int n, ClassLoader classLoader) {
        if (LOG.isTraceEnabled(4096)) {
            LOG.trace(4096).append("initializeClassLoaderForSkinId(").append(n).append(", ").append(super.getClass().getName()).append(")").log();
        }
        this.unloadAllLoadedXipContainers();
        this.skinId = n;
        this.classloader = classLoader;
        return true;
    }

    private void unloadAllLoadedXipContainers() {
        Set set = this.getLoadedContainersForCurrentSkinId();
        String[] stringArray = (String[])set.toArray(new String[set.size()]);
        for (int i2 = stringArray.length - 1; i2 >= 0; --i2) {
            this.unloadXIPContainer(stringArray[i2]);
        }
    }

    private Set getLoadedContainersForCurrentSkinId() {
        if (!this.loadedContainers.containsKey(this.skinId)) {
            LOG.warn(4096).append("List of loaded containers not initialized for skin ID: ").append(this.skinId).log();
            this.initLoadedContainers(this.skinId);
        }
        return (Set)this.loadedContainers.get(this.skinId);
    }

    private void initLoadedContainers(int n) {
        this.loadedContainers.put(n, new HashSet());
    }

    @Override
    public boolean unloadDataForClass(String string) {
        String string2 = this.getContainerNameForClassName(string);
        return this.unloadXIPContainer(string2);
    }

    private String getContainerNameForClassName(String string) {
        return new StringBuffer().append(string.substring(string.lastIndexOf(".") + 1)).append(".jxe").toString();
    }

    private Object instantiateObject(Class clazz) {
        if (null == clazz) {
            LOG.error(4096, "Can't instantiate null.");
            return null;
        }
        Object object = null;
        try {
            object = clazz.newInstance();
            if (LOG.isTraceEnabled(4096)) {
                LOG.trace(4096).append("view handler instantiated loaded: ").append(clazz.getName()).log();
            }
        }
        catch (IllegalAccessException illegalAccessException) {
            LOG.error(4096).append("No class instantiated: ").append(clazz.getName()).attachThrowable(illegalAccessException).log();
        }
        catch (Exception exception) {
            LOG.error(4096).append("Can't instantiate Object: ").append(clazz.getName()).attachThrowable(exception).log();
        }
        return object;
    }

    private Class loadClass(String string) {
        try {
            Class clazz = this.fileManager.loadClass(this.classloader, string);
            if (LOG.isTraceEnabled(4096)) {
                LOG.trace(4096).append("class loaded: ").append(string).log();
            }
            return clazz;
        }
        catch (Exception exception) {
            LOG.error(4096).append("Can't load class: ").append(string).attachThrowable(exception).log();
            return null;
        }
    }

    private void loadXIPContainer(String string) {
        if (this.getLoadedContainersForCurrentSkinId().contains(string)) {
            return;
        }
        try {
            this.fileManager.loadXIPContainer(this.classloader, string);
            this.getLoadedContainersForCurrentSkinId().add(string);
            if (LOG.isTraceEnabled(4096)) {
                LOG.trace(4096).append("XIP container loaded: ").append(string).log();
            }
        }
        catch (RuntimeException runtimeException) {
            LOG.error(4096).append("Error loading XIP container: ").append(string).attachThrowable(runtimeException).log();
        }
    }

    private boolean unloadXIPContainer(String string) {
        if (!this.getLoadedContainersForCurrentSkinId().contains(string)) {
            LOG.warn(4096).append("Can't unload XIP container").append(string).append(": not loaded").log();
            return true;
        }
        try {
            if (LOG.isTraceEnabled(4096)) {
                LOG.trace(4096).append("XIP container unloading disabled: ").append(string).log();
            }
            return true;
        }
        catch (Exception exception) {
            LOG.warn(4096).append("Error unloading XIP container: ").append(string).attachThrowable(exception).log();
            return false;
        }
    }

    @Override
    public ClassLoader getCurrentClassLoader() {
        return this.classloader;
    }

    static {
        ZIP_NAME = System.getProperty("viewhandler.zip", "viewhandler.zip");
        LOG = ServiceManager.createLogger();
    }
}

