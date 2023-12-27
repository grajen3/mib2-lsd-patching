/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.lsctng.internal;

import de.vw.mib.log4mib.Logger;
import de.vw.mib.lsctng.internal.ServiceManager;
import java.net.URL;
import java.net.URLClassLoader;

public final class MibUrlClassLoader
extends URLClassLoader {
    private static final boolean LOGGING;
    private static final boolean NO_LOGGING;
    private static final Logger LOG;
    private static final int SUB_CLASSIFIER;

    public MibUrlClassLoader(URL uRL, ClassLoader classLoader) {
        URL[] uRLArray;
        if (uRL != null) {
            URL[] uRLArray2 = new URL[1];
            uRLArray = uRLArray2;
            uRLArray2[0] = uRL;
        } else {
            uRLArray = new URL[]{};
        }
        super(uRLArray, classLoader);
        if (LOG.isTraceEnabled(4096)) {
            LOG.trace(4096, new StringBuffer().append("New classloader created: URL=").append(uRL).toString());
        }
    }

    @Override
    protected synchronized Class loadClass(String string, boolean bl) {
        return this.loadClassWithLogging(string, bl, false);
    }

    public Class loadClassFromJar(String string) {
        return this.loadClassWithLogging(string, false, true);
    }

    private Class loadClassWithLogging(String string, boolean bl, boolean bl2) {
        Class clazz = this.findLoadedClass(string);
        if (clazz != null) {
            return clazz;
        }
        try {
            clazz = this.findClass(string);
            if (bl2 && LOG.isTraceEnabled(4096)) {
                LOG.trace(4096).append("Class \"").append(string).append("\" loaded from jar \"").append(super.getURLs()[0]).append("\".").log();
            }
        }
        catch (ClassNotFoundException classNotFoundException) {
            if (bl2) {
                LOG.error(4096).append("Class \"").append(string).append("\" not loaded from skin!").log();
            }
            clazz = this.getParent().loadClass(string);
        }
        if (bl) {
            this.resolveClass(clazz);
        }
        return clazz;
    }

    static {
        LOG = ServiceManager.loggerFactory.getLogger(1024);
    }
}

