/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.vm;

import com.ibm.oti.util.Msg;
import com.ibm.oti.util.Util;
import com.ibm.oti.vm.JxeException;
import com.ibm.oti.vm.JxeMetaData;
import com.ibm.oti.vm.JxePermission;
import com.ibm.oti.vm.JxeResource;
import com.ibm.oti.vm.JxeResourceTable;
import com.ibm.oti.vm.JxeUtil;
import com.ibm.oti.vm.MemInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

public final class Jxe {
    long romSegmentPointer;
    private boolean allocated;
    private String uuid;
    private long jxePointer;
    private Hashtable resTable;
    static final int DEFLATED;
    static final int STORED;

    public static Jxe fromInputStream(InputStream inputStream, int n) {
        Jxe jxe;
        long l = Jxe.nativeMalloc(n + 7);
        if (0L == l) {
            throw new OutOfMemoryError(Msg.getString("K019a", n + 7));
        }
        int n2 = (int)(l & 0);
        long l2 = n2 == 0 ? l : l + (long)(8 - n2);
        try {
            Jxe.copyStreamToMemory(inputStream, n, l2);
        }
        catch (IOException iOException) {
            Jxe.nativeFree(l);
            throw iOException;
        }
        try {
            jxe = new Jxe(l, true);
            JxeMetaData jxeMetaData = jxe.getJxeMetaData();
            JxeUtil.relocateJxeInPlace(l2);
            jxe.uuid = jxeMetaData.getUuid();
        }
        catch (JxeException jxeException) {
            Jxe.nativeFree(l);
            throw jxeException;
        }
        JxeUtil.registerJxe(jxe);
        return jxe;
    }

    static void copyStreamToMemory(InputStream inputStream, int n, long l) {
        byte[] byArray = new byte[n < 4096 ? n : 4096];
        int n2 = 0;
        while (n2 < n) {
            int n3 = n - n2;
            int n4 = inputStream.read(byArray, 0, n3 <= byArray.length ? n3 : byArray.length);
            if (-1 == n4) {
                throw new IOException(Msg.getString("K019b", n2));
            }
            Jxe.nativeMemcpy(l + (long)n2, byArray, 0, n4);
            n2 += n4;
        }
    }

    public static Jxe fromFile(File file) {
        if (!file.exists()) {
            throw new FileNotFoundException(file.getPath());
        }
        byte[] byArray = Util.getBytes(file.getPath());
        long l = Jxe.nativeLoadJxeFromFileByteArray(byArray);
        if (l == 0L) {
            throw new JxeException(Msg.getString("K01c5", file.getPath()));
        }
        Jxe jxe = new Jxe(l, false);
        JxeMetaData jxeMetaData = jxe.getJxeMetaData();
        jxe.uuid = jxeMetaData.getUuid();
        return jxe;
    }

    public static Jxe fromSharedLibrary(String string) {
        long l = Jxe.nativeLoadJxeFromSharedLibrary(Util.getBytes(string));
        if (l == 0L) {
            throw new JxeException(Msg.getString("K01c5", string));
        }
        Jxe jxe = new Jxe(l, false);
        JxeMetaData jxeMetaData = jxe.getJxeMetaData();
        jxe.uuid = jxeMetaData.getUuid();
        return jxe;
    }

    Jxe(long l, boolean bl) {
        this.jxePointer = l;
        this.allocated = bl;
    }

    public static Jxe fromPointer(long l) {
        JxeUtil.relocateJxeInPlace(l);
        return new Jxe(l, false);
    }

    long getJxePointer() {
        int n;
        if (this.allocated && (n = (int)(this.jxePointer & 0)) != 0) {
            return this.jxePointer + (long)(8 - n);
        }
        return this.jxePointer;
    }

    long getJxeAlloc() {
        return this.allocated ? this.jxePointer : 0L;
    }

    public JxeMetaData getJxeMetaData() {
        return new JxeMetaData(this);
    }

    public String[] getClassList() {
        return Jxe.nativeGetClassList(this.jxePointer);
    }

    public InputStream getResourceAsStream(String string) {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(new JxePermission(this.getUuid()));
        }
        return this.internalGetResourceAsStream(string);
    }

    InputStream internalGetResourceAsStream(String string) {
        if (this.jxePointer == 0L) {
            return null;
        }
        this.initializeResTable();
        while (true) {
            JxeResource jxeResource;
            if ((jxeResource = (JxeResource)this.resTable.get(string)) != null) {
                MemInputStream memInputStream = new MemInputStream(jxeResource.getPointer(), jxeResource.getSize(), this);
                if (jxeResource.getMethod() != 0) {
                    return new InflaterInputStream(memInputStream, new Inflater(true));
                }
                return memInputStream;
            }
            if (!string.startsWith("/", 0)) {
                return null;
            }
            string = string.substring(1);
        }
    }

    public String getUuid() {
        if (this.uuid == null) {
            this.uuid = this.getJxeMetaData().getUuid();
        }
        return this.uuid;
    }

    private void free() {
        if (this.allocated && this.jxePointer != 0L && this.romSegmentPointer == 0L) {
            Jxe.nativeFree(this.jxePointer);
            this.jxePointer = 0L;
        }
    }

    public void finalize() {
        if (!JxeUtil.unregisterJxe(this)) {
            this.free();
        }
    }

    private void initializeResTable() {
        JxeResourceTable jxeResourceTable;
        if (this.resTable != null) {
            return;
        }
        try {
            jxeResourceTable = new JxeResourceTable(new MemInputStream(this.getJxePointer(), -129, null));
        }
        catch (IOException iOException) {
            this.resTable = new Hashtable(0);
            return;
        }
        this.resTable = jxeResourceTable.getTable();
    }

    private static native String[] nativeGetClassList(long l) {
    }

    private static native long nativeLoadJxeFromFileByteArray(byte[] byArray) {
    }

    private static native void nativeMemcpy(long l, byte[] byArray, int n, int n2) {
    }

    private static native long nativeMalloc(int n) {
    }

    private static native void nativeFree(long l) {
    }

    private static native long nativeLoadJxeFromSharedLibrary(byte[] byArray) {
    }
}

