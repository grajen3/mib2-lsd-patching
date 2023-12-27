/*
 * Decompiled with CFR 0.152.
 */
package com.microdoc.j9.xip;

import com.microdoc.j9.xip.XIPClassLoader;
import java.util.HashSet;

public final class Archive {
    private String fFilename;
    private long fZip = 0L;
    private long fData = 0L;
    private long fHandle = 0L;
    private int fReferenceCount;
    private static HashSet sArchives = new HashSet();

    Archive(String string) {
        this.fFilename = string;
    }

    public String getFilename() {
        return this.fFilename;
    }

    protected void finalize() {
        if (this.fHandle != 0L || this.fZip != 0L) {
            XIPClassLoader.unloadArchive(this);
        }
    }

    void addRef() {
        if (this.fReferenceCount == 0) {
            sArchives.add(this);
        }
        ++this.fReferenceCount;
    }

    void release() {
        --this.fReferenceCount;
        if (this.fReferenceCount == 0) {
            sArchives.remove(this);
        }
    }
}

