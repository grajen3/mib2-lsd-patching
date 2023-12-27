/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.service.debuginterface.events;

import de.vw.mib.codec.ByteArrayReader;
import de.vw.mib.debug.service.debuginterface.events.CustomEventSlot;
import de.vw.mib.debug.service.debuginterface.events.EventDispatcherTargetCodec;
import de.vw.mib.debug.service.debuginterface.events.EventDispatcherTargetCodecListener;
import java.util.HashSet;
import java.util.Set;

public class EventDispatcherTargetCodecImpl
implements EventDispatcherTargetCodec {
    private static final byte SEND_HMIEVENT_STATEMECHINE;
    private static final byte SEND_HMIEVENT_SYSTEM;
    private static final byte SEND_HMIEVENT_HARDKEY;
    private static final byte SEND_HMIEVENT_ROTATION;
    private static final byte SEND_VIEWCHANGEEVENT;
    private static final byte SEND_EVENT_GENERIC;

    public void decode(byte[] byArray, EventDispatcherTargetCodecListener eventDispatcherTargetCodecListener) {
        this.decode(new ByteArrayReader(byArray), eventDispatcherTargetCodecListener);
    }

    public void decode(ByteArrayReader byteArrayReader, EventDispatcherTargetCodecListener eventDispatcherTargetCodecListener) {
        byte by = byteArrayReader.readByte();
        switch (by) {
            case 1: {
                eventDispatcherTargetCodecListener.sendHMIStatemachineEvent(byteArrayReader.readInt());
                break;
            }
            case 2: {
                eventDispatcherTargetCodecListener.sendHMISystemEvent(byteArrayReader.readInt());
                break;
            }
            case 3: {
                eventDispatcherTargetCodecListener.sendHardkeyEvent(byteArrayReader.readInt());
                break;
            }
            case 4: {
                eventDispatcherTargetCodecListener.sendDDSRotationEvent(byteArrayReader.readInt(), byteArrayReader.readInt());
                break;
            }
            case 5: {
                eventDispatcherTargetCodecListener.sendViewchangeEvent(byteArrayReader.readString());
                break;
            }
            case 6: {
                eventDispatcherTargetCodecListener.sendEventGeneric(byteArrayReader.readInt(), byteArrayReader.readInt(), byteArrayReader.readInt(), this.readSlots(byteArrayReader));
                break;
            }
        }
    }

    private Set readSlots(ByteArrayReader byteArrayReader) {
        int n = byteArrayReader.readInt();
        HashSet hashSet = new HashSet(n);
        for (int i2 = 0; i2 < n; ++i2) {
            CustomEventSlot customEventSlot = new CustomEventSlot(byteArrayReader.readInt(), byteArrayReader.readInt(), byteArrayReader.readString());
            hashSet.add(customEventSlot);
        }
        return hashSet;
    }
}

