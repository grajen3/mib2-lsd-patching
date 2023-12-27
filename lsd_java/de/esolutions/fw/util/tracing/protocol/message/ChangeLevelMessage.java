/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.protocol.message;

import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.tracing.TraceLevels;
import de.esolutions.fw.util.tracing.entity.TraceEntityType;
import de.esolutions.fw.util.tracing.entity.TraceEntityURI;
import de.esolutions.fw.util.tracing.protocol.message.AbstractMessage;
import de.esolutions.fw.util.tracing.protocol.message.MessageType;

public class ChangeLevelMessage
extends AbstractMessage {
    private short type;
    private int id;
    private short level;

    public ChangeLevelMessage() {
        super(MessageType.CHANGE_LEVEL);
    }

    public ChangeLevelMessage(TraceEntityURI traceEntityURI, short s) {
        super(MessageType.CHANGE_LEVEL);
        this.type = traceEntityURI.getType();
        this.id = traceEntityURI.getId();
        this.level = s;
    }

    @Override
    public void serializeElements(ISerializer iSerializer) {
        iSerializer.putInt16(this.type);
        iSerializer.putInt32(this.id);
        iSerializer.putInt16(this.level);
    }

    @Override
    public void deserializeElements(IDeserializer iDeserializer) {
        this.type = iDeserializer.getInt16();
        this.id = iDeserializer.getInt32();
        this.level = iDeserializer.getInt16();
    }

    public TraceEntityURI getUri() {
        return new TraceEntityURI(this.type, this.id);
    }

    @Override
    public short getLevel() {
        return this.level;
    }

    public short getType() {
        return this.type;
    }

    public int getId() {
        return this.id;
    }

    @Override
    public void toStringBuffer(Buffer buffer) {
        buffer.append("ChangeLevel: type=");
        buffer.append(this.type);
        buffer.append("/");
        buffer.append(TraceEntityType.getName(this.type));
        buffer.append(" id=");
        buffer.append(this.id);
        buffer.append(" level=");
        buffer.append(this.level);
        buffer.append("/");
        buffer.append(TraceLevels.getName(this.level));
    }
}

