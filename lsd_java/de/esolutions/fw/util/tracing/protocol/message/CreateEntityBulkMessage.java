/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.protocol.message;

import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.tracing.entity.IExternalTraceEntity;
import de.esolutions.fw.util.tracing.entity.TraceEntityURI;
import de.esolutions.fw.util.tracing.model.ExternalTraceEntity;
import de.esolutions.fw.util.tracing.protocol.message.AbstractMessage;
import de.esolutions.fw.util.tracing.protocol.message.MessageType;

public class CreateEntityBulkMessage
extends AbstractMessage {
    private IExternalTraceEntity[] entities;

    public CreateEntityBulkMessage(IExternalTraceEntity[] iExternalTraceEntityArray) {
        super(MessageType.BULK_CREATE_ENTITY);
        this.entities = iExternalTraceEntityArray;
    }

    public CreateEntityBulkMessage() {
        super(MessageType.BULK_CREATE_ENTITY);
    }

    @Override
    protected void serializeElements(ISerializer iSerializer) {
        int n = 0;
        if (this.entities != null) {
            n = this.entities.length;
        }
        iSerializer.putInt32(n);
        for (int i2 = 0; i2 < n; ++i2) {
            IExternalTraceEntity iExternalTraceEntity = this.entities[i2];
            iSerializer.putString(iExternalTraceEntity.getName());
            iSerializer.putInt16(iExternalTraceEntity.getURI().getType());
            iSerializer.putInt32(iExternalTraceEntity.getURI().getId());
            iSerializer.putInt16(iExternalTraceEntity.getFilterLevel());
            TraceEntityURI traceEntityURI = iExternalTraceEntity.getParentURI();
            if (traceEntityURI == null) {
                iSerializer.putInt16((short)-1);
                iSerializer.putInt32(-1);
                continue;
            }
            iSerializer.putInt16(traceEntityURI.getType());
            iSerializer.putInt32(traceEntityURI.getId());
        }
    }

    @Override
    protected void deserializeElements(IDeserializer iDeserializer) {
        int n = iDeserializer.getInt32();
        this.entities = new IExternalTraceEntity[n];
        for (int i2 = 0; i2 < n; ++i2) {
            String string = iDeserializer.getString();
            short s = iDeserializer.getInt16();
            int n2 = iDeserializer.getInt32();
            short s2 = iDeserializer.getInt16();
            short s3 = iDeserializer.getInt16();
            int n3 = iDeserializer.getInt32();
            TraceEntityURI traceEntityURI = new TraceEntityURI(s, n2);
            TraceEntityURI traceEntityURI2 = null;
            if (n3 != -1) {
                traceEntityURI2 = new TraceEntityURI(s3, n3);
            }
            this.entities[i2] = new ExternalTraceEntity(string, traceEntityURI, s2, traceEntityURI2);
        }
    }

    public IExternalTraceEntity[] getEntities() {
        return this.entities;
    }

    @Override
    public void toStringBuffer(Buffer buffer) {
        int n = 0;
        if (this.entities != null) {
            n = this.entities.length;
        }
        buffer.append("CreateEntityBulk: n=");
        buffer.append(n);
        buffer.append(" [");
        for (int i2 = 0; i2 < n; ++i2) {
            buffer.append(this.entities[i2]);
            buffer.append(", ");
        }
        buffer.append("]");
    }
}

