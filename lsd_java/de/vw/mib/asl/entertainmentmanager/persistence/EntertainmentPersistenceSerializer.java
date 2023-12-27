/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.entertainmentmanager.persistence;

import de.vw.mib.asl.entertainmentmanager.persistence.EntertainmentPersistence;
import de.vw.mib.asl.framework.api.persistence2.AbstractPersistableSerializer;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistableSerializerFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistenceException;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

class EntertainmentPersistenceSerializer
extends AbstractPersistableSerializer {
    final PersistableSerializerFactory factory;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$asl$entertainmentmanager$persistence$EntertainmentPersistenceSerializer;

    EntertainmentPersistenceSerializer(PersistableSerializerFactory persistableSerializerFactory) {
        if (!$assertionsDisabled && persistableSerializerFactory == null) {
            throw new AssertionError();
        }
        this.factory = persistableSerializerFactory;
    }

    @Override
    public int getPersistableId() {
        return 1;
    }

    @Override
    public byte[] serializeCommonData(Persistable persistable) {
        this.checkPersistable(persistable);
        if (this.factory == null) {
            throw new PersistenceException("PersistableSerializerFactory must not be null.");
        }
        try {
            return this.serializeCommonData((EntertainmentPersistence)persistable);
        }
        catch (IOException iOException) {
            throw new PersistenceException("Error while serializing.", iOException);
        }
    }

    @Override
    public byte[] serializeUserSpecificData(Persistable persistable) {
        this.checkPersistable(persistable);
        if (this.factory == null) {
            throw new PersistenceException("PersistableSerializerFactory must not be null.");
        }
        try {
            return this.serializeUserSpecificData((EntertainmentPersistence)persistable);
        }
        catch (IOException iOException) {
            throw new PersistenceException("Error while serializing.", iOException);
        }
    }

    private byte[] serializeCommonData(EntertainmentPersistence entertainmentPersistence) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        dataOutputStream.writeShort(1);
        return byteArrayOutputStream.toByteArray();
    }

    private byte[] serializeUserSpecificData(EntertainmentPersistence entertainmentPersistence) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        dataOutputStream.writeShort(1);
        dataOutputStream.writeInt(entertainmentPersistence.getContext());
        return byteArrayOutputStream.toByteArray();
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        $assertionsDisabled = !(class$de$vw$mib$asl$entertainmentmanager$persistence$EntertainmentPersistenceSerializer == null ? (class$de$vw$mib$asl$entertainmentmanager$persistence$EntertainmentPersistenceSerializer = EntertainmentPersistenceSerializer.class$("de.vw.mib.asl.entertainmentmanager.persistence.EntertainmentPersistenceSerializer")) : class$de$vw$mib$asl$entertainmentmanager$persistence$EntertainmentPersistenceSerializer).desiredAssertionStatus();
    }
}

