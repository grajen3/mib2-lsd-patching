/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.amfm.persistence;

import de.vw.mib.asl.amfm.persistence.StationInfoPersistence;
import de.vw.mib.asl.framework.api.persistence2.AbstractPersistableSerializer;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistableSerializerFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistenceException;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

class StationInfoPersistenceSerializer
extends AbstractPersistableSerializer {
    final PersistableSerializerFactory factory;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$asl$amfm$persistence$StationInfoPersistenceSerializer;

    StationInfoPersistenceSerializer(PersistableSerializerFactory persistableSerializerFactory) {
        if (!$assertionsDisabled && persistableSerializerFactory == null) {
            throw new AssertionError();
        }
        this.factory = persistableSerializerFactory;
    }

    @Override
    public int getPersistableId() {
        return 15;
    }

    @Override
    public byte[] serializeCommonData(Persistable persistable) {
        this.checkPersistable(persistable);
        if (this.factory == null) {
            throw new PersistenceException("PersistableSerializerFactory must not be null.");
        }
        try {
            return this.serializeCommonData((StationInfoPersistence)persistable);
        }
        catch (IOException iOException) {
            throw new PersistenceException("Error while serializing.", iOException);
        }
    }

    @Override
    public byte[] serializeUserSpecificData(Persistable persistable) {
        throw new PersistenceException("StationInfoPersistence does not conatain any user specific data");
    }

    private byte[] serializeCommonData(StationInfoPersistence stationInfoPersistence) {
        byte[] byArray;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        dataOutputStream.writeInt(stationInfoPersistence.getCategoryNumber());
        dataOutputStream.writeInt(stationInfoPersistence.getSubscription());
        dataOutputStream.writeInt(stationInfoPersistence.getSid());
        dataOutputStream.writeInt(stationInfoPersistence.getStationNumber());
        dataOutputStream.writeBoolean(stationInfoPersistence.getShortLabel() == null);
        if (stationInfoPersistence.getShortLabel() != null) {
            byArray = stationInfoPersistence.getShortLabel().getBytes();
            dataOutputStream.writeInt(byArray.length);
            dataOutputStream.write(byArray);
        }
        dataOutputStream.writeBoolean(stationInfoPersistence.getFullLabel() == null);
        if (stationInfoPersistence.getFullLabel() != null) {
            byArray = stationInfoPersistence.getFullLabel().getBytes();
            dataOutputStream.writeInt(byArray.length);
            dataOutputStream.write(byArray);
        }
        dataOutputStream.writeBoolean(stationInfoPersistence.isMature());
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
        $assertionsDisabled = !(class$de$vw$mib$asl$amfm$persistence$StationInfoPersistenceSerializer == null ? (class$de$vw$mib$asl$amfm$persistence$StationInfoPersistenceSerializer = StationInfoPersistenceSerializer.class$("de.vw.mib.asl.amfm.persistence.StationInfoPersistenceSerializer")) : class$de$vw$mib$asl$amfm$persistence$StationInfoPersistenceSerializer).desiredAssertionStatus();
    }
}

