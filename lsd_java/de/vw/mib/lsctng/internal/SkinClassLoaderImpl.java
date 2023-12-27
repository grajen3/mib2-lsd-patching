/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.lsctng.internal;

import de.vw.mib.log4mib.Logger;
import de.vw.mib.lsctng.internal.CachableSkinClassLoaderInternal;
import de.vw.mib.lsctng.internal.MibUrlClassLoader;
import de.vw.mib.lsctng.internal.ServiceManager;
import de.vw.mib.skin.SkinClassLoader;
import de.vw.mib.skin.SkinDatapoolUpdater;
import de.vw.mib.viewmanager.internal.ViewHandler;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public final class SkinClassLoaderImpl
implements SkinClassLoader,
CachableSkinClassLoaderInternal {
    private static final Logger LOG = ServiceManager.loggerFactory.getLogger(1024);
    private static final int SUB_CLASSIFIER;
    private static final String SKIN_DP_UPDATER;
    private static final String JAR_NAME;
    private static final String INFO_NAME;
    private static final String LANGUAGE_RESOURCE_EXTENSION;
    private final ClassLoader applicationClassloader = super.getClass().getClassLoader() == null ? ClassLoader.getSystemClassLoader() : super.getClass().getClassLoader();
    private int skinId = -1;
    private MibUrlClassLoader mibClassLoader;

    public SkinClassLoaderImpl() {
        if (LOG.isTraceEnabled(4096)) {
            LOG.trace(4096, "SkinClassLoaderImpl instantiated.");
        }
    }

    @Override
    public boolean initializeClassLoaderForSkinId(int n) {
        URL uRL;
        String string;
        String string2;
        if (n == this.skinId) {
            return true;
        }
        if (LOG.isTraceEnabled(4096)) {
            LOG.trace(4096).append("initializeClassLoaderForSkinId(").append(n).append(")").log();
        }
        if (!new File(string2 = new StringBuffer().append(string = ServiceManager.configValueSetter.getSkinPath(n)).append(File.separator).append("info.txt").toString()).isFile()) {
            LOG.error(4096).append("Can't find info.txt in skin path for skin ID ").append(n).append(": ").append(string).log();
            this.mibClassLoader = null;
            this.skinId = -1;
            return false;
        }
        String string3 = new StringBuffer().append(string).append(File.separator).append(JAR_NAME).toString();
        try {
            uRL = new File(string3).toURI().toURL();
        }
        catch (MalformedURLException malformedURLException) {
            LOG.error(4096).append("Can't create URL for skin ").append(n).append("from path: ").append(string3).attachThrowable(malformedURLException).log();
            this.mibClassLoader = null;
            this.skinId = -1;
            return false;
        }
        return this.initializeClassLoaderForSkinId(n, new MibUrlClassLoader(uRL, this.applicationClassloader));
    }

    @Override
    public boolean initializeClassLoaderForSkinId(int n, ClassLoader classLoader) {
        if (!(classLoader instanceof MibUrlClassLoader)) {
            LOG.warn(4096).append("Can't use classloader of class ").append(super.getClass().getName()).log();
            this.mibClassLoader = null;
            this.skinId = -1;
            return false;
        }
        if (LOG.isTraceEnabled(4096)) {
            LOG.trace(4096).append("initializeClassLoaderForSkinId(").append(n).append(", ").append(super.getClass().getName()).append(")").log();
        }
        this.skinId = n;
        this.mibClassLoader = (MibUrlClassLoader)classLoader;
        return true;
    }

    @Override
    public synchronized ViewHandler getViewHandler(String string) {
        try {
            Class clazz = this.loadClass(string);
            return (ViewHandler)clazz.newInstance();
        }
        catch (NullPointerException nullPointerException) {
            LOG.error(4096).append("No class instantiated ").append(string).attachThrowable(nullPointerException).log();
        }
        catch (Exception exception) {
            LOG.error(4096).append("Can't instantiate ViewHandler ").append(string).attachThrowable(exception).log();
        }
        return null;
    }

    @Override
    public synchronized ViewHandler getViewHandler(String string, String string2) {
        if (string2.endsWith(".")) {
            return this.getViewHandler(new StringBuffer().append(string2).append(string).toString());
        }
        return this.getViewHandler(new StringBuffer().append(string2).append(".").append(string).toString());
    }

    Class loadClass(String string) {
        try {
            return this.mibClassLoader.loadClassFromJar(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            LOG.error(4096).append("Can't load Class ").append(string).attachThrowable(classNotFoundException).log();
        }
        catch (NullPointerException nullPointerException) {
            LOG.error(4096).append("No class loader while loading ").append(string).attachThrowable(nullPointerException).log();
        }
        return null;
    }

    @Override
    public int getSkin() {
        return this.skinId;
    }

    @Override
    public synchronized SkinDatapoolUpdater getSkinDatapoolUpdater() {
        return this.getDatapoolUpdater("generated.de.vw.mib.skin.internal.SkinDatapoolUpdaterImpl");
    }

    private SkinDatapoolUpdater getDatapoolUpdater(String string) {
        try {
            Class clazz = this.loadClass(string);
            return (SkinDatapoolUpdater)clazz.newInstance();
        }
        catch (Exception exception) {
            LOG.error(4096, "Can't instantiate skin mode datapool-updater!", exception);
            return null;
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
    public boolean unloadDataForClass(String string) {
        return true;
    }

    @Override
    public ClassLoader getCurrentClassLoader() {
        return this.mibClassLoader;
    }

    static {
        JAR_NAME = System.getProperty("viewhandler.jar", "viewhandler.jar");
    }
}

