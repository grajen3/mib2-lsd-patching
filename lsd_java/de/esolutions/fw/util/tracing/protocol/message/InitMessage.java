/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.protocol.message;

import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.tracing.protocol.message.AbstractMessage;
import de.esolutions.fw.util.tracing.protocol.message.MessageType;

public class InitMessage
extends AbstractMessage {
    private byte protocolRevision;
    private String myName;
    private int maxEntities;
    public static final byte REV_V1;
    public static final byte REV_DEFAULT;
    public static final byte REV_MIN;
    public static final byte REV_MAX;

    public InitMessage(byte by, String string, int n) {
        super(MessageType.INIT);
        this.protocolRevision = by;
        this.myName = string;
        this.maxEntities = n;
    }

    public InitMessage() {
        super(MessageType.INIT);
    }

    @Override
    public void serializeElements(ISerializer iSerializer) {
        iSerializer.putInt8(this.protocolRevision);
        iSerializer.putString(this.myName);
        iSerializer.putInt32(this.maxEntities);
    }

    @Override
    public void deserializeElements(IDeserializer iDeserializer) {
        this.protocolRevision = iDeserializer.getInt8();
        this.myName = iDeserializer.getString();
        this.maxEntities = iDeserializer.getInt32();
    }

    public String getMyName() {
        return this.myName;
    }

    public byte getProtocolRevision() {
        return this.protocolRevision;
    }

    public int getMaxEntities() {
        return this.maxEntities;
    }

    @Override
    public void toStringBuffer(Buffer buffer) {
        buffer.append("INIT: protocolRevision=");
        buffer.append(this.protocolRevision);
        buffer.append(" name=");
        buffer.append(this.myName);
        buffer.append(" maxEntities=");
        buffer.append(this.maxEntities);
    }
}

