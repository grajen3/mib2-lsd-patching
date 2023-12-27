/*
 * Decompiled with CFR 0.152.
 */
package com.microdoc.j9.xip;

import com.microdoc.j9.xip.XIPClassLoader;
import java.net.URL;

public class FileSPI {
    public ClassLoader createClassLoader(URL[] uRLArray) {
        if (uRLArray == null) {
            throw new IllegalArgumentException("Null classpath");
        }
        return new XIPClassLoader(uRLArray);
    }

    public void destroyClassloader(ClassLoader classLoader) {
        ((XIPClassLoader)classLoader).dispose();
    }

    public Class loadClass(ClassLoader classLoader, String string) {
        try {
            return ((XIPClassLoader)classLoader).loadClass(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            return null;
        }
    }

    public void loadXIPContainer(ClassLoader classLoader, String string) {
        ((XIPClassLoader)classLoader).loadJXE(string);
    }

    public void unloadXIPContainer(ClassLoader classLoader, String string) {
        ((XIPClassLoader)classLoader).unloadJXE(string);
    }

    public String[] getLoadedXIPContainer(ClassLoader classLoader) {
        return ((XIPClassLoader)classLoader).getLoadedJXEs();
    }
}

