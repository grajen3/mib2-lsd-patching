/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport.aggregate;

import de.esolutions.fw.util.commons.miniser.BEMiniIntSerializer;
import de.esolutions.fw.util.transport.IWriteable;
import de.esolutions.fw.util.transport.IWriter;
import de.esolutions.fw.util.transport.WriteableWindow;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AggregatedWriters
implements IWriter {
    private Object debugTag;
    protected List writerList = new ArrayList();
    protected int size = 4;
    protected int maxSize;
    public static final int MSG_PREAMBLE_SIZE;
    public static final int MSG_HEADER_SIZE;

    public AggregatedWriters(int n) {
        this.maxSize = n;
    }

    public void addWritable(IWriter iWriter) {
        this.writerList.add(iWriter);
        this.size += 4 + iWriter.size();
    }

    public boolean doesFit(IWriter iWriter) {
        return this.size + iWriter.size() + 4 <= this.maxSize;
    }

    public int sizeLeft() {
        return this.maxSize - this.size - 4;
    }

    public int maxSize() {
        return this.maxSize - 4 - 4;
    }

    public int numEntries() {
        return this.writerList.size();
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void write(IWriteable iWriteable) {
        BEMiniIntSerializer bEMiniIntSerializer = new BEMiniIntSerializer();
        byte[] byArray = new byte[4];
        int n = this.writerList.size();
        bEMiniIntSerializer.storeInt(n, byArray);
        iWriteable.setData(0, byArray);
        int n2 = 4;
        Iterator iterator = this.writerList.iterator();
        while (iterator.hasNext()) {
            IWriter iWriter = (IWriter)iterator.next();
            int n3 = iWriter.size();
            bEMiniIntSerializer.storeInt(n3, byArray);
            iWriteable.setData(n2, byArray);
            WriteableWindow writeableWindow = iWriteable.setLocalWindow(n2 += 4, n3);
            iWriter.write(iWriteable);
            iWriteable.setWindow(writeableWindow);
            n2 += n3;
        }
    }

    @Override
    public void setDebugTag(Object object) {
        this.debugTag = object;
    }

    @Override
    public Object getDebugTag() {
        return this.debugTag;
    }
}

