/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence;

import de.vw.mib.asl.framework.api.persistence.PersistenceReadCallback;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.persistence.AslPersistenceAsyncApi;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventException;

public final class AslPersistenceAsyncApiImpl
implements AslPersistenceAsyncApi {
    public static final AslPersistenceAsyncApiImpl INSTANCE = new AslPersistenceAsyncApiImpl();

    private AslPersistenceAsyncApiImpl() {
    }

    @Override
    public void flushDatabase(int n, int n2) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-1427105536);
        eventGeneric.setSenderTargetId(n);
        eventGeneric.setSenderEventId(n2);
        ServiceManager.eventMain.getEventDispatcher().send(eventGeneric);
    }

    @Override
    public void readInt(int n, int n2, int n3, long l) {
        if (n3 <= 0 || l <= 0L) {
            throw new GenericEventException("Invalid arguments");
        }
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-1561323264);
        eventGeneric.setInt(0, n3);
        eventGeneric.setLong(1, l);
        eventGeneric.setBoolean(4, false);
        eventGeneric.setSenderTargetId(n);
        eventGeneric.setSenderEventId(n2);
        ServiceManager.eventMain.getEventDispatcher().send(eventGeneric);
    }

    @Override
    public void readString(int n, int n2, int n3, long l) {
        if (n3 <= 0 || l <= 0L) {
            throw new GenericEventException("Invalid arguments");
        }
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-1527768832);
        eventGeneric.setInt(0, n3);
        eventGeneric.setLong(1, l);
        eventGeneric.setBoolean(4, false);
        eventGeneric.setSenderTargetId(n);
        eventGeneric.setSenderEventId(n2);
        ServiceManager.eventMain.getEventDispatcher().send(eventGeneric);
    }

    @Override
    public void readByteArray(int n, int n2, int n3, long l) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-1460659968);
        eventGeneric.setInt(0, n3);
        eventGeneric.setLong(1, l);
        eventGeneric.setBoolean(4, false);
        eventGeneric.setObject(5, null);
        eventGeneric.setSenderTargetId(n);
        eventGeneric.setSenderEventId(n2);
        ServiceManager.eventMain.getEventDispatcher().send(eventGeneric);
    }

    @Override
    public void readByteArray(PersistenceReadCallback persistenceReadCallback, int n, long l) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-1460659968);
        eventGeneric.setInt(0, n);
        eventGeneric.setLong(1, l);
        eventGeneric.setBoolean(4, false);
        eventGeneric.setObject(5, persistenceReadCallback);
        ServiceManager.eventMain.getEventDispatcher().send(eventGeneric);
    }

    @Override
    public void readStringArray(int n, int n2, int n3, long l) {
        if (n3 <= 0 || l <= 0L) {
            throw new GenericEventException("Invalid arguments");
        }
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-1494214400);
        eventGeneric.setInt(0, n3);
        eventGeneric.setLong(1, l);
        eventGeneric.setBoolean(4, false);
        eventGeneric.setSenderTargetId(n);
        eventGeneric.setSenderEventId(n2);
        ServiceManager.eventMain.getEventDispatcher().send(eventGeneric);
    }

    @Override
    public void writeInt(int n, int n2, int n3, long l, int n4) {
        if (n3 <= 0 || l <= 0L) {
            throw new GenericEventException("Invalid arguments");
        }
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-1544546048);
        eventGeneric.setInt(0, n3);
        eventGeneric.setLong(1, l);
        eventGeneric.setInt(2, n4);
        eventGeneric.setSenderTargetId(n);
        eventGeneric.setSenderEventId(n2);
        ServiceManager.eventMain.getEventDispatcher().send(eventGeneric);
    }

    @Override
    public void writeString(int n, int n2, int n3, long l, String string) {
        if (n3 <= 0 || l <= 0L) {
            throw new GenericEventException("Invalid arguments");
        }
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-1510991616);
        eventGeneric.setInt(0, n3);
        eventGeneric.setLong(1, l);
        eventGeneric.setString(2, string);
        eventGeneric.setSenderTargetId(n);
        eventGeneric.setSenderEventId(n2);
        ServiceManager.eventMain.getEventDispatcher().send(eventGeneric);
    }

    @Override
    public void writeByteArray(int n, int n2, int n3, long l, byte[] byArray) {
        if (n3 <= 0 || l <= 0L) {
            throw new GenericEventException("Invalid arguments");
        }
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-1443882752);
        eventGeneric.setInt(0, n3);
        eventGeneric.setLong(1, l);
        eventGeneric.setByteArray(2, byArray);
        eventGeneric.setSenderTargetId(n);
        eventGeneric.setSenderEventId(n2);
        ServiceManager.eventMain.getEventDispatcher().send(eventGeneric);
    }

    @Override
    public void writeStringArray(int n, long l, String[] stringArray, int n2, int n3, boolean bl) {
        if (n <= 0 || l <= 0L) {
            throw new GenericEventException("Invalid arguments");
        }
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-1477437184);
        eventGeneric.setInt(0, n);
        eventGeneric.setLong(1, l);
        eventGeneric.setObject(2, stringArray);
        eventGeneric.setSenderTargetId(n2);
        eventGeneric.setSenderEventId(n3);
        ServiceManager.eventMain.getEventDispatcher().send(eventGeneric);
    }
}

