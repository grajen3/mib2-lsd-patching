/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport;

import de.esolutions.fw.util.transport.IReadable;
import de.esolutions.fw.util.transport.IWriteable;
import de.esolutions.fw.util.transport.IWriter;

public class CopyWriter
implements IWriter {
    protected IReadable readable;

    public CopyWriter(IReadable iReadable) {
        this.readable = iReadable;
    }

    @Override
    public int size() {
        return this.readable.size();
    }

    @Override
    public void write(IWriteable iWriteable) {
        iWriteable.setData(this.readable.getData());
    }

    @Override
    public void setDebugTag(Object object) {
        this.readable.setDebugTag(object);
    }

    @Override
    public Object getDebugTag() {
        return this.readable.getDebugTag();
    }
}

