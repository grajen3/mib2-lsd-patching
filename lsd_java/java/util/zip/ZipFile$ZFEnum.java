/*
 * Decompiled with CFR 0.152.
 */
package java.util.zip;

import com.ibm.oti.util.Msg;
import java.util.Enumeration;
import java.util.NoSuchElementException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

class ZipFile$ZFEnum
implements Enumeration {
    private long nextEntryPointer;
    private ZipEntry current;
    final /* synthetic */ ZipFile this$0;

    ZipFile$ZFEnum(ZipFile zipFile) {
        this.this$0 = zipFile;
        this.nextEntryPointer = this.resetZip(zipFile.descriptor);
        this.current = this.getNextEntry(zipFile.descriptor, this.nextEntryPointer);
    }

    private native long resetZip(long l) {
    }

    private native ZipEntry getNextEntry(long l, long l2) {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean hasMoreElements() {
        Object object = ZipFile.access$0(this.this$0);
        synchronized (object) {
            if (this.this$0.descriptor == -1L) {
                throw new IllegalStateException(Msg.getString("K00b7"));
            }
        }
        return this.current != null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object nextElement() {
        if (this.current == null) {
            throw new NoSuchElementException();
        }
        ZipEntry zipEntry = this.current;
        Object object = ZipFile.access$0(this.this$0);
        synchronized (object) {
            if (this.this$0.descriptor == -1L) {
                throw new IllegalStateException(Msg.getString("K00b7"));
            }
            this.current = this.getNextEntry(this.this$0.descriptor, this.nextEntryPointer);
        }
        return zipEntry;
    }
}

