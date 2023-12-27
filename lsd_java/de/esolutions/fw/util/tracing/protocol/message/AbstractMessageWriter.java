/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.protocol.message;

import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import de.esolutions.fw.util.tracing.protocol.message.AbstractMessage;
import de.esolutions.fw.util.transport.IWriteable;
import de.esolutions.fw.util.transport.IWriter;
import de.esolutions.fw.util.transport.exception.TransportException;

public final class AbstractMessageWriter
implements IWriter {
    private Object debugTag;
    private ISerializer serializer;
    private final AbstractMessage message;

    public AbstractMessageWriter(ISerializer iSerializer, AbstractMessage abstractMessage) {
        this.serializer = iSerializer;
        this.message = abstractMessage;
    }

    @Override
    public final int size() {
        try {
            this.serializer.beginSizeCalc();
            this.message.serialize(this.serializer);
            return this.serializer.endSizeCalc();
        }
        catch (SerializerException serializerException) {
            return 0;
        }
    }

    @Override
    public final void write(IWriteable iWriteable) {
        try {
            this.serializer.attachBuffer(iWriteable);
            this.message.serialize(this.serializer);
            this.serializer.detachBuffer();
        }
        catch (SerializerException serializerException) {
            throw new TransportException(new StringBuffer().append("Serializer failed with: ").append(serializerException).toString());
        }
    }

    @Override
    public final void setDebugTag(Object object) {
        this.debugTag = object;
    }

    @Override
    public final Object getDebugTag() {
        return this.debugTag;
    }
}

