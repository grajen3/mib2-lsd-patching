/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.amfm.persistence;

import de.vw.mib.asl.amfm.persistence.DabPresetPersistence;
import de.vw.mib.asl.framework.api.persistence2.AbstractPersistableSerializer;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistableSerializer;
import de.vw.mib.asl.framework.api.persistence2.PersistableSerializerFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistenceException;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

class DabPresetPersistenceSerializer
extends AbstractPersistableSerializer {
    final PersistableSerializerFactory factory;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$asl$amfm$persistence$DabPresetPersistenceSerializer;

    DabPresetPersistenceSerializer(PersistableSerializerFactory persistableSerializerFactory) {
        if (!$assertionsDisabled && persistableSerializerFactory == null) {
            throw new AssertionError();
        }
        this.factory = persistableSerializerFactory;
    }

    @Override
    public int getPersistableId() {
        return 13;
    }

    @Override
    public byte[] serializeCommonData(Persistable persistable) {
        this.checkPersistable(persistable);
        if (this.factory == null) {
            throw new PersistenceException("PersistableSerializerFactory must not be null.");
        }
        try {
            return this.serializeCommonData((DabPresetPersistence)persistable);
        }
        catch (IOException iOException) {
            throw new PersistenceException("Error while serializing.", iOException);
        }
    }

    @Override
    public byte[] serializeUserSpecificData(Persistable persistable) {
        throw new PersistenceException("DabPresetPersistence does not conatain any user specific data");
    }

    private byte[] serializeCommonData(DabPresetPersistence dabPresetPersistence) {
        PersistableSerializer persistableSerializer;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        dataOutputStream.writeBoolean(dabPresetPersistence.getService() == null);
        if (dabPresetPersistence.getService() != null) {
            persistableSerializer = this.factory.createSerializer(11);
            dataOutputStream.write(persistableSerializer.serializeCommonData(dabPresetPersistence.getService()));
        }
        dataOutputStream.writeBoolean(dabPresetPersistence.getEnsemble() == null);
        if (dabPresetPersistence.getEnsemble() != null) {
            persistableSerializer = this.factory.createSerializer(10);
            dataOutputStream.write(persistableSerializer.serializeCommonData(dabPresetPersistence.getEnsemble()));
        }
        dataOutputStream.writeBoolean(dabPresetPersistence.getFrequency() == null);
        if (dabPresetPersistence.getFrequency() != null) {
            persistableSerializer = this.factory.createSerializer(9);
            dataOutputStream.write(persistableSerializer.serializeCommonData(dabPresetPersistence.getFrequency()));
        }
        dataOutputStream.writeBoolean(dabPresetPersistence.getStationImage() == null);
        if (dabPresetPersistence.getStationImage() != null) {
            persistableSerializer = this.factory.createSerializer(4);
            dataOutputStream.write(persistableSerializer.serializeCommonData(dabPresetPersistence.getStationImage()));
        }
        dataOutputStream.writeLong(dabPresetPersistence.getDatabaseStationId());
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
        $assertionsDisabled = !(class$de$vw$mib$asl$amfm$persistence$DabPresetPersistenceSerializer == null ? (class$de$vw$mib$asl$amfm$persistence$DabPresetPersistenceSerializer = DabPresetPersistenceSerializer.class$("de.vw.mib.asl.amfm.persistence.DabPresetPersistenceSerializer")) : class$de$vw$mib$asl$amfm$persistence$DabPresetPersistenceSerializer).desiredAssertionStatus();
    }
}

