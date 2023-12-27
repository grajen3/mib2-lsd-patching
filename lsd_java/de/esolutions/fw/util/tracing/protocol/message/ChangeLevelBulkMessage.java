/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.protocol.message;

import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.tracing.entity.IExternalTraceEntity;
import de.esolutions.fw.util.tracing.model.ExternalTraceEntity;
import de.esolutions.fw.util.tracing.protocol.message.AbstractMessage;
import de.esolutions.fw.util.tracing.protocol.message.ChangeLevelMessage;
import de.esolutions.fw.util.tracing.protocol.message.MessageType;

public class ChangeLevelBulkMessage
extends AbstractMessage {
    private IExternalTraceEntity[] entities;

    public ChangeLevelBulkMessage(IExternalTraceEntity[] iExternalTraceEntityArray) {
        super(MessageType.BULK_CHANGE_LEVEL);
        this.entities = iExternalTraceEntityArray;
    }

    public ChangeLevelBulkMessage() {
        super(MessageType.BULK_CHANGE_LEVEL);
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
            ChangeLevelMessage changeLevelMessage = new ChangeLevelMessage(iExternalTraceEntity.getURI(), iExternalTraceEntity.getFilterLevel());
            changeLevelMessage.serializeElements(iSerializer);
        }
    }

    @Override
    protected void deserializeElements(IDeserializer iDeserializer) {
        int n = iDeserializer.getInt32();
        this.entities = new IExternalTraceEntity[n];
        for (int i2 = 0; i2 < n; ++i2) {
            ChangeLevelMessage changeLevelMessage = new ChangeLevelMessage();
            changeLevelMessage.deserializeElements(iDeserializer);
            this.entities[i2] = new ExternalTraceEntity(null, changeLevelMessage.getUri(), changeLevelMessage.getLevel(), null);
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
            ChangeLevelMessage changeLevelMessage = new ChangeLevelMessage(this.entities[i2].getURI(), this.entities[i2].getFilterLevel());
            changeLevelMessage.toStringBuffer(buffer);
            buffer.append(", ");
        }
        buffer.append("]");
    }
}

