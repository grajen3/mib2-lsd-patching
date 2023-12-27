/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.comm.broker.v4.impl;

import de.esolutions.fw.comm.comm.broker.v4.InstanceID;
import de.esolutions.fw.comm.comm.broker.v4.UpdateEvent;
import de.esolutions.fw.comm.comm.broker.v4.impl.InstanceIDSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class UpdateEventSerializer {
    public static void putOptionalUpdateEvent(ISerializer iSerializer, UpdateEvent updateEvent) {
        boolean bl = updateEvent == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = updateEvent.getAction();
            iSerializer.putEnum(n);
            int n2 = updateEvent.getReason();
            iSerializer.putEnum(n2);
            InstanceID instanceID = updateEvent.getSvc_id();
            InstanceIDSerializer.putOptionalInstanceID(iSerializer, instanceID);
            int n3 = updateEvent.getHome_agent_id();
            iSerializer.putUInt16(n3);
        }
    }

    public static void putOptionalUpdateEventVarArray(ISerializer iSerializer, UpdateEvent[] updateEventArray) {
        boolean bl = updateEventArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(updateEventArray.length);
            for (int i2 = 0; i2 < updateEventArray.length; ++i2) {
                UpdateEventSerializer.putOptionalUpdateEvent(iSerializer, updateEventArray[i2]);
            }
        }
    }

    public static UpdateEvent getOptionalUpdateEvent(IDeserializer iDeserializer) {
        UpdateEvent updateEvent = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            InstanceID instanceID;
            int n2;
            int n3;
            updateEvent = new UpdateEvent();
            updateEvent.action = n3 = iDeserializer.getEnum();
            updateEvent.reason = n2 = iDeserializer.getEnum();
            updateEvent.svc_id = instanceID = InstanceIDSerializer.getOptionalInstanceID(iDeserializer);
            updateEvent.home_agent_id = n = iDeserializer.getUInt16();
        }
        return updateEvent;
    }

    public static UpdateEvent[] getOptionalUpdateEventVarArray(IDeserializer iDeserializer) {
        UpdateEvent[] updateEventArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            updateEventArray = new UpdateEvent[n];
            for (int i2 = 0; i2 < n; ++i2) {
                updateEventArray[i2] = UpdateEventSerializer.getOptionalUpdateEvent(iDeserializer);
            }
        }
        return updateEventArray;
    }
}

