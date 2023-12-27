/*
 * Decompiled with CFR 0.152.
 */
package com.microdoc.j9.xip;

import com.ibm.oti.vm.Jxe;
import com.ibm.oti.vm.JxeUtil;
import com.microdoc.j9.xip.Archive;
import com.microdoc.j9.xip.JxeClassLoader;
import com.microdoc.j9.xip.JxeData;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

public final class XIPClassLoader
extends ClassLoader {
    private final Archive[] fClasspath;
    private final Hashtable fJxesByName = new Hashtable();
    private final ArrayList fJxesList = new ArrayList();

    static {
        System.loadLibrary("xip");
        XIPClassLoader.nativeinit();
    }

    public XIPClassLoader(URL[] uRLArray) {
        this.fClasspath = new Archive[uRLArray.length];
        int n = 0;
        while (n < uRLArray.length) {
            String string;
            URL uRL = uRLArray[n];
            if (uRL != null && "file".equals(string = uRL.getProtocol())) {
                String string2 = uRL.getFile();
                String string3 = uRL.getHost();
                if (string3 != null && string3.length() > 0) {
                    string2 = new StringBuffer(string3.length() + string2.length() + 2).append("//").append(string3).append(string2).toString();
                }
                this.fClasspath[n] = new Archive(string2);
            }
            ++n;
        }
    }

    private static native void nativeinit() {
    }

    synchronized void loadJXE(String string) {
        if (this.fJxesByName.contains(string)) {
            throw new IllegalArgumentException(new StringBuffer("Already loaded this container name: ").append(string).toString());
        }
        int n = 0;
        while (n < this.fClasspath.length) {
            File file;
            Archive archive = this.fClasspath[n];
            if (archive != null && (file = new File(archive.getFilename())).exists()) {
                JxeData jxeData = null;
                try {
                    jxeData = this.loadJXEimpl(file.getAbsolutePath(), archive, string);
                    if (jxeData != null) {
                        Jxe jxe = jxeData.getJxe();
                        JxeClassLoader jxeClassLoader = new JxeClassLoader(this, archive, jxeData, string);
                        JxeUtil.romImageLoad(jxe, this);
                        this.fJxesByName.put(string, jxeClassLoader);
                        this.fJxesList.add(jxeClassLoader);
                        return;
                    }
                }
                catch (Exception exception) {
                    throw new IllegalArgumentException(new StringBuffer("Error loading ").append(string).append(": ").append(exception.getMessage()).toString());
                }
            }
            ++n;
        }
        throw new IllegalArgumentException(new StringBuffer("Container name not found in the class path: ").append(string).toString());
    }

    private native JxeData loadJXEimpl(String string, Archive archive, String string2) {
    }

    synchronized void unloadJXE(String string) {
        Object object = this.fJxesByName.remove(string);
        if (object != null) {
            this.fJxesList.remove(object);
        }
    }

    static native void unloadJXEDataimpl(long l) {
    }

    void freeJxeSegment(Jxe jxe) {
        this.freeJxeSegmentImpl(jxe);
    }

    private native void freeJxeSegmentImpl(Jxe jxe) {
    }

    @Override
    public Class loadClass(String string) {
        try {
            Class clazz = super.loadClass(string);
            return clazz;
        }
        catch (ClassNotFoundException classNotFoundException) {
            return this.loadClassFromJxe(string, null);
        }
    }

    public Class loadClassFromJxe(String string, JxeClassLoader jxeClassLoader) {
        Iterator iterator = this.fJxesList.iterator();
        while (iterator.hasNext()) {
            Class clazz;
            JxeClassLoader jxeClassLoader2 = (JxeClassLoader)iterator.next();
            if (jxeClassLoader2 == jxeClassLoader || (clazz = jxeClassLoader2.loadClassFromJxe(string)) == null) continue;
            return clazz;
        }
        return null;
    }

    public String[] getLoadedJXEs() {
        return (String[])this.fJxesByName.keySet().toArray(new String[this.fJxesByName.size()]);
    }

    public void dispose() {
        this.fJxesByName.clear();
    }

    static void unloadArchive(Archive archive) {
        XIPClassLoader.unloadArchiveImpl(archive);
    }

    private static native void unloadArchiveImpl(Archive archive) {
    }
}

