/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.amfm.persistence;

import de.vw.mib.asl.amfm.persistence.AmFmPresetPersistence;
import de.vw.mib.asl.framework.api.persistence2.AbstractPersistableSerializer;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistableSerializer;
import de.vw.mib.asl.framework.api.persistence2.PersistableSerializerFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistenceException;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

class AmFmPresetPersistenceSerializer
extends AbstractPersistableSerializer {
    final PersistableSerializerFactory factory;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$asl$amfm$persistence$AmFmPresetPersistenceSerializer;

    AmFmPresetPersistenceSerializer(PersistableSerializerFactory persistableSerializerFactory) {
        if (!$assertionsDisabled && persistableSerializerFactory == null) {
            throw new AssertionError();
        }
        this.factory = persistableSerializerFactory;
    }

    @Override
    public int getPersistableId() {
        return 3;
    }

    @Override
    public byte[] serializeCommonData(Persistable persistable) {
        this.checkPersistable(persistable);
        if (this.factory == null) {
            throw new PersistenceException("PersistableSerializerFactory must not be null.");
        }
        try {
            return this.serializeCommonData((AmFmPresetPersistence)persistable);
        }
        catch (IOException iOException) {
            throw new PersistenceException("Error while serializing.", iOException);
        }
    }

    @Override
    public byte[] serializeUserSpecificData(Persistable persistable) {
        throw new PersistenceException("AmFmPresetPersistence does not conatain any user specific data");
    }

    private byte[] serializeCommonData(AmFmPresetPersistence amFmPresetPersistence) {
        PersistableSerializer persistableSerializer;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        dataOutputStream.writeBoolean(amFmPresetPersistence.getAmFmStation() == null);
        if (amFmPresetPersistence.getAmFmStation() != null) {
            persistableSerializer = this.factory.createSerializer(2);
            dataOutputStream.write(persistableSerializer.serializeCommonData(amFmPresetPersistence.getAmFmStation()));
        }
        dataOutputStream.writeBoolean(amFmPresetPersistence.isManualAsssignedLogo());
        dataOutputStream.writeBoolean(amFmPresetPersistence.isLogoDeletedIntentionallyForNar());
        dataOutputStream.writeBoolean(amFmPresetPersistence.getStationImage() == null);
        if (amFmPresetPersistence.getStationImage() != null) {
            persistableSerializer = this.factory.createSerializer(4);
            dataOutputStream.write(persistableSerializer.serializeCommonData(amFmPresetPersistence.getStationImage()));
        }
        dataOutputStream.writeInt(amFmPresetPersistence.getAutoStoredLogoState());
        dataOutputStream.writeInt(amFmPresetPersistence.getStationLogoType());
        dataOutputStream.writeLong(amFmPresetPersistence.getDatabaseStationId());
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
        $assertionsDisabled = !(class$de$vw$mib$asl$amfm$persistence$AmFmPresetPersistenceSerializer == null ? (class$de$vw$mib$asl$amfm$persistence$AmFmPresetPersistenceSerializer = AmFmPresetPersistenceSerializer.class$("de.vw.mib.asl.amfm.persistence.AmFmPresetPersistenceSerializer")) : class$de$vw$mib$asl$amfm$persistence$AmFmPresetPersistenceSerializer).desiredAssertionStatus();
    }
}

