/*
 * Decompiled with CFR 0.152.
 */
package com.microdoc.j9.xip;

import com.ibm.oti.vm.Jxe;
import com.ibm.oti.vm.JxeUtil;
import com.microdoc.j9.xip.Archive;
import com.microdoc.j9.xip.JxeData;
import com.microdoc.j9.xip.JxeDataUnloader;
import com.microdoc.j9.xip.XIPClassLoader;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.CodeSource;
import java.security.ProtectionDomain;
import java.util.WeakHashMap;

public final class JxeClassLoader
extends ClassLoader {
    private final JxeDataUnloader fJxeDataUnloader;
    private final Jxe fJxe;
    private final String fJxeName;
    private final Archive fArchive;
    private final XIPClassLoader fParent;
    private static WeakHashMap sAllocations = new WeakHashMap();

    public JxeClassLoader(XIPClassLoader xIPClassLoader, Archive archive, JxeData jxeData, String string) {
        super(xIPClassLoader);
        this.fParent = xIPClassLoader;
        this.fArchive = archive;
        this.fJxeDataUnloader = jxeData.isAllocated() ? jxeData.unloader() : null;
        this.fJxe = jxeData.getJxe();
        this.fJxeName = string;
        this.fArchive.addRef();
        if (this.fJxeDataUnloader != null) {
            sAllocations.put(this.fJxe, this.fJxeDataUnloader);
        }
    }

    @Override
    public Class loadClass(String string) {
        try {
            Class clazz = super.loadClass(string);
            return clazz;
        }
        catch (ClassNotFoundException classNotFoundException) {
            Class clazz = this.loadClassFromJxe(string);
            if (clazz != null) {
                return clazz;
            }
            return this.fParent.loadClassFromJxe(string, this);
        }
    }

    public Class loadClassFromJxe(String string) {
        try {
            Class clazz = super.loadClass(string);
            return clazz;
        }
        catch (ClassNotFoundException classNotFoundException) {
            byte[] byArray = JxeUtil.getRomClass(this.fJxe, string);
            if (byArray != null) {
                URL uRL = null;
                try {
                    uRL = new URL(new StringBuffer("jxe://").append(this.fJxeName).toString());
                }
                catch (MalformedURLException malformedURLException) {
                    // empty catch block
                }
                CodeSource codeSource = new CodeSource(uRL, null);
                ProtectionDomain protectionDomain = new ProtectionDomain(codeSource, null);
                Class clazz = this.defineClass(string, byArray, 0, byArray.length, protectionDomain);
                if (this.fJxeDataUnloader != null) {
                    sAllocations.put(clazz, this.fJxeDataUnloader);
                }
                return clazz;
            }
            return null;
        }
    }

    protected void finalize() {
        sAllocations.size();
        this.fArchive.release();
        this.fParent.freeJxeSegment(this.fJxe);
    }

    public String getJxeName() {
        return this.fJxeName;
    }

    public String toString() {
        return this.fJxeName;
    }
}

