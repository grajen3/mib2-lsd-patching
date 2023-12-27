/*
 * Decompiled with CFR 0.152.
 */
package java.util.zip;

import com.ibm.oti.util.Msg;
import com.ibm.oti.util.Util;
import com.ibm.oti.vm.ZipStream;
import java.io.File;
import java.io.InputStream;
import java.security.AccessController;
import java.util.Enumeration;
import java.util.zip.ZipConstants;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile$1;
import java.util.zip.ZipFile$ZFEnum;

public class ZipFile
implements ZipConstants {
    private String fileName;
    long descriptor = -1L;
    private int size = -1;
    private int mode;
    private Object lock = new Object();
    public static final int OPEN_READ;
    public static final int OPEN_DELETE;

    static {
        ZipFile.ntvinit();
    }

    public ZipFile(File file) {
        this(file.getPath());
    }

    public ZipFile(File file, int n) {
        if (n == 1 || n == 5) {
            this.fileName = file.getPath();
            SecurityManager securityManager = System.getSecurityManager();
            if (securityManager != null) {
                securityManager.checkRead(this.fileName);
                if ((n & 4) != 0) {
                    securityManager.checkDelete(this.fileName);
                }
            }
        } else {
            throw new IllegalArgumentException();
        }
        this.mode = n;
        this.openZip(this.fileName);
    }

    public ZipFile(String string) {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkRead(string);
        }
        this.fileName = string;
        this.openZip(this.fileName);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void openZip(String string) {
        int n;
        Object object = this.lock;
        synchronized (object) {
            n = this.openZipImpl(Util.getBytes(this.fileName));
        }
        if (n != 0) {
            switch (n) {
                case 1: {
                    throw new ZipException(Msg.getString("K01c3", this.fileName));
                }
                case 2: {
                    throw new ZipException(Msg.getString("K01c4", this.fileName));
                }
            }
            throw new OutOfMemoryError();
        }
    }

    protected void finalize() {
        this.close();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void close() {
        if (this.fileName != null) {
            Object object = this.lock;
            synchronized (object) {
                this.closeZipImpl();
            }
            if ((this.mode & 4) != 0) {
                AccessController.doPrivileged(new ZipFile$1(this));
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Enumeration entries() {
        Object object = this.lock;
        synchronized (object) {
            return new ZipFile$ZFEnum(this);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ZipEntry getEntry(String string) {
        if (string != null) {
            ZipEntry zipEntry;
            Object object = this.lock;
            synchronized (object) {
                zipEntry = this.getEntryImpl(this.descriptor, string);
            }
            return zipEntry;
        }
        throw new NullPointerException();
    }

    public InputStream getInputStream(ZipEntry zipEntry) {
        return ZipStream.getZipStream(this, zipEntry.getName());
    }

    public String getName() {
        return this.fileName;
    }

    private native int openZipImpl(byte[] byArray) {
    }

    private native void closeZipImpl() {
    }

    private native ZipEntry getEntryImpl(long l, String string) {
    }

    public int size() {
        if (this.size != -1) {
            return this.size;
        }
        this.size = 0;
        Enumeration enumeration = this.entries();
        while (enumeration.hasMoreElements()) {
            ++this.size;
            enumeration.nextElement();
        }
        return this.size;
    }

    private static native void ntvinit() {
    }

    static /* synthetic */ Object access$0(ZipFile zipFile) {
        return zipFile.lock;
    }

    static /* synthetic */ String access$1(ZipFile zipFile) {
        return zipFile.fileName;
    }
}

