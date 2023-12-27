/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.core.message;

import de.esolutions.fw.comm.core.message.AbstractMessage;
import de.esolutions.fw.comm.core.message.MessageType;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class SetFeatureMessage
extends AbstractMessage {
    private byte value;

    public SetFeatureMessage(ISerializer iSerializer, byte by) {
        super(MessageType.SET_FEATURE, iSerializer);
        this.value = by;
    }

    public SetFeatureMessage(IDeserializer iDeserializer, boolean bl) {
        super(MessageType.SET_FEATURE, iDeserializer, bl);
    }

    @Override
    public void serializeElements(ISerializer iSerializer) {
        iSerializer.putInt8(this.value);
    }

    @Override
    public void deserializeElements(IDeserializer iDeserializer) {
        this.value = iDeserializer.getInt8();
    }

    public byte getValue() {
        return this.value;
    }
}

