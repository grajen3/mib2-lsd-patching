/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.mirrorlink.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.mirrorlink.Event;

public class EventSerializer {
    public static void putOptionalEvent(ISerializer iSerializer, Event event) {
        boolean bl = event == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = event.getXPosition();
            iSerializer.putInt32(n);
            int n2 = event.getYPosition();
            iSerializer.putInt32(n2);
            int n3 = event.getEventID();
            iSerializer.putInt32(n3);
            int n4 = event.getPressureValue();
            iSerializer.putInt32(n4);
        }
    }

    public static void putOptionalEventVarArray(ISerializer iSerializer, Event[] eventArray) {
        boolean bl = eventArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(eventArray.length);
            for (int i2 = 0; i2 < eventArray.length; ++i2) {
                EventSerializer.putOptionalEvent(iSerializer, eventArray[i2]);
            }
        }
    }

    public static Event getOptionalEvent(IDeserializer iDeserializer) {
        Event event = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            event = new Event();
            event.xPosition = n4 = iDeserializer.getInt32();
            event.yPosition = n3 = iDeserializer.getInt32();
            event.eventID = n2 = iDeserializer.getInt32();
            event.pressureValue = n = iDeserializer.getInt32();
        }
        return event;
    }

    public static Event[] getOptionalEventVarArray(IDeserializer iDeserializer) {
        Event[] eventArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            eventArray = new Event[n];
            for (int i2 = 0; i2 < n; ++i2) {
                eventArray[i2] = EventSerializer.getOptionalEvent(iDeserializer);
            }
        }
        return eventArray;
    }
}

