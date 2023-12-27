/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.protocol.message;

import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.tracing.TraceLevels;
import de.esolutions.fw.util.tracing.entity.IExternalTraceEntity;
import de.esolutions.fw.util.tracing.entity.TraceEntityType;
import de.esolutions.fw.util.tracing.entity.TraceEntityURI;
import de.esolutions.fw.util.tracing.protocol.message.AbstractMessage;
import de.esolutions.fw.util.tracing.protocol.message.MessageType;

public class CreateEntityMessage
extends AbstractMessage
implements IExternalTraceEntity {
    private String name;
    private short type;
    private int id;
    private short level;
    private int parentId;
    private short parentType;
    private static final int NO_PARENT_ID;

    public CreateEntityMessage() {
        super(MessageType.CREATE_ENTITY);
    }

    public CreateEntityMessage(IExternalTraceEntity iExternalTraceEntity) {
        super(MessageType.CREATE_ENTITY);
        this.name = iExternalTraceEntity.getName();
        this.type = iExternalTraceEntity.getURI().getType();
        this.id = iExternalTraceEntity.getURI().getId();
        this.level = iExternalTraceEntity.getFilterLevel();
        TraceEntityURI traceEntityURI = iExternalTraceEntity.getParentURI();
        if (traceEntityURI != null) {
            this.parentId = traceEntityURI.getId();
            this.parentType = traceEntityURI.getType();
        } else {
            this.parentId = -1;
        }
    }

    public CreateEntityMessage(String string, short s, int n, short s2) {
        super(MessageType.CREATE_ENTITY);
        this.name = string;
        this.type = s;
        this.id = n;
        this.level = s2;
        this.parentId = -1;
    }

    public CreateEntityMessage(String string, short s, int n, short s2, int n2, short s3) {
        super(MessageType.CREATE_ENTITY);
        this.name = string;
        this.type = s;
        this.id = n;
        this.level = s2;
        this.parentId = n2;
        this.parentType = s3;
    }

    @Override
    public void serializeElements(ISerializer iSerializer) {
        iSerializer.putString(this.name);
        iSerializer.putInt16(this.type);
        iSerializer.putInt32(this.id);
        iSerializer.putInt16(this.level);
        boolean bl = this.parentId != -1;
        iSerializer.putBool(bl);
        if (bl) {
            iSerializer.putInt16(this.parentType);
            iSerializer.putInt32(this.parentId);
        }
    }

    @Override
    public void deserializeElements(IDeserializer iDeserializer) {
        this.name = iDeserializer.getString();
        this.type = iDeserializer.getInt16();
        this.id = iDeserializer.getInt32();
        this.level = iDeserializer.getInt16();
        boolean bl = iDeserializer.getBool();
        if (bl) {
            this.parentType = iDeserializer.getInt16();
            this.parentId = iDeserializer.getInt32();
        } else {
            this.parentId = -1;
        }
    }

    public IExternalTraceEntity getEntity() {
        return this;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public TraceEntityURI getURI() {
        return new TraceEntityURI(this.type, this.id);
    }

    @Override
    public TraceEntityURI getParentURI() {
        if (this.parentId == -1) {
            return null;
        }
        return new TraceEntityURI(this.parentType, this.parentId);
    }

    @Override
    public short getFilterLevel() {
        return this.level;
    }

    @Override
    public short getLevel() {
        return this.level;
    }

    @Override
    public void toStringBuffer(Buffer buffer) {
        buffer.append("CreateEntity: name=");
        buffer.append(this.name);
        buffer.append(" type=");
        buffer.append(this.type);
        buffer.append("/");
        buffer.append(TraceEntityType.getName(this.type));
        buffer.append(" id=");
        buffer.append(this.id);
        buffer.append(" level=");
        buffer.append(this.level);
        buffer.append("/");
        buffer.append(TraceLevels.getName(this.level));
        buffer.append(" parentType=");
        buffer.append(this.parentType);
        buffer.append("/");
        buffer.append(TraceEntityType.getName(this.parentType));
        buffer.append(" parentId=");
        buffer.append(this.parentId);
    }
}

