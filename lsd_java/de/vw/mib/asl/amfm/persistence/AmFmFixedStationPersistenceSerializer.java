/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.amfm.persistence;

import de.vw.mib.asl.amfm.persistence.AmFmFixedStationPersistence;
import de.vw.mib.asl.framework.api.persistence2.AbstractPersistableSerializer;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistableSerializerFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistenceException;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

class AmFmFixedStationPersistenceSerializer
extends AbstractPersistableSerializer {
    final PersistableSerializerFactory factory;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$asl$amfm$persistence$AmFmFixedStationPersistenceSerializer;

    AmFmFixedStationPersistenceSerializer(PersistableSerializerFactory persistableSerializerFactory) {
        if (!$assertionsDisabled && persistableSerializerFactory == null) {
            throw new AssertionError();
        }
        this.factory = persistableSerializerFactory;
    }

    @Override
    public int getPersistableId() {
        return 7;
    }

    @Override
    public byte[] serializeCommonData(Persistable persistable) {
        this.checkPersistable(persistable);
        if (this.factory == null) {
            throw new PersistenceException("PersistableSerializerFactory must not be null.");
        }
        try {
            return this.serializeCommonData((AmFmFixedStationPersistence)persistable);
        }
        catch (IOException iOException) {
            throw new PersistenceException("Error while serializing.", iOException);
        }
    }

    @Override
    public byte[] serializeUserSpecificData(Persistable persistable) {
        throw new PersistenceException("AmFmFixedStationPersistence does not conatain any user specific data");
    }

    private byte[] serializeCommonData(AmFmFixedStationPersistence amFmFixedStationPersistence) {
        byte[] byArray;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        dataOutputStream.writeInt(amFmFixedStationPersistence.getFrequency());
        dataOutputStream.writeInt(amFmFixedStationPersistence.getPi());
        dataOutputStream.writeBoolean(amFmFixedStationPersistence.getName() == null);
        if (amFmFixedStationPersistence.getName() != null) {
            byArray = amFmFixedStationPersistence.getName().getBytes();
            dataOutputStream.writeInt(byArray.length);
            dataOutputStream.write(byArray);
        }
        dataOutputStream.writeBoolean(amFmFixedStationPersistence.getShortName() == null);
        if (amFmFixedStationPersistence.getShortName() != null) {
            byArray = amFmFixedStationPersistence.getShortName().getBytes();
            dataOutputStream.writeInt(byArray.length);
            dataOutputStream.write(byArray);
        }
        dataOutputStream.writeInt(amFmFixedStationPersistence.getSubChannel());
        dataOutputStream.writeShort(amFmFixedStationPersistence.getRatingCounter());
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
        $assertionsDisabled = !(class$de$vw$mib$asl$amfm$persistence$AmFmFixedStationPersistenceSerializer == null ? (class$de$vw$mib$asl$amfm$persistence$AmFmFixedStationPersistenceSerializer = AmFmFixedStationPersistenceSerializer.class$("de.vw.mib.asl.amfm.persistence.AmFmFixedStationPersistenceSerializer")) : class$de$vw$mib$asl$amfm$persistence$AmFmFixedStationPersistenceSerializer).desiredAssertionStatus();
    }
}

