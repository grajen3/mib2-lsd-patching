/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.protocol.message;

import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.tracing.protocol.message.AbstractMessage;
import de.esolutions.fw.util.tracing.protocol.message.MessageType;

public class DroppedDataMessage
extends AbstractMessage {
    private int numDropped;

    public DroppedDataMessage(int n) {
        super(MessageType.DROPPED_DATA);
        this.numDropped = n;
    }

    public DroppedDataMessage() {
        super(MessageType.DROPPED_DATA);
    }

    @Override
    public void serializeElements(ISerializer iSerializer) {
        iSerializer.putInt32(this.numDropped);
    }

    @Override
    public void deserializeElements(IDeserializer iDeserializer) {
        this.numDropped = iDeserializer.getInt32();
    }

    public int getNumDropped() {
        return this.numDropped;
    }

    @Override
    public void toStringBuffer(Buffer buffer) {
        buffer.append(new StringBuffer().append("Dropped Data: num=").append(this.numDropped).toString());
    }
}

