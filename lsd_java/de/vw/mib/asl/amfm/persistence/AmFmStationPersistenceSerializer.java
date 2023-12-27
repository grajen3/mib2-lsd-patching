/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.amfm.persistence;

import de.vw.mib.asl.amfm.persistence.AmFmStationPersistence;
import de.vw.mib.asl.framework.api.persistence2.AbstractPersistableSerializer;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistableSerializerFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistenceException;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

class AmFmStationPersistenceSerializer
extends AbstractPersistableSerializer {
    final PersistableSerializerFactory factory;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$asl$amfm$persistence$AmFmStationPersistenceSerializer;

    AmFmStationPersistenceSerializer(PersistableSerializerFactory persistableSerializerFactory) {
        if (!$assertionsDisabled && persistableSerializerFactory == null) {
            throw new AssertionError();
        }
        this.factory = persistableSerializerFactory;
    }

    @Override
    public int getPersistableId() {
        return 2;
    }

    @Override
    public byte[] serializeCommonData(Persistable persistable) {
        this.checkPersistable(persistable);
        if (this.factory == null) {
            throw new PersistenceException("PersistableSerializerFactory must not be null.");
        }
        try {
            return this.serializeCommonData((AmFmStationPersistence)persistable);
        }
        catch (IOException iOException) {
            throw new PersistenceException("Error while serializing.", iOException);
        }
    }

    @Override
    public byte[] serializeUserSpecificData(Persistable persistable) {
        throw new PersistenceException("AmFmStationPersistence does not conatain any user specific data");
    }

    private byte[] serializeCommonData(AmFmStationPersistence amFmStationPersistence) {
        Object object;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        dataOutputStream.writeBoolean(amFmStationPersistence.getStationName() == null);
        if (amFmStationPersistence.getStationName() != null) {
            object = amFmStationPersistence.getStationName().getBytes();
            dataOutputStream.writeInt(((byte[])object).length);
            dataOutputStream.write((byte[])object);
        }
        dataOutputStream.writeLong(amFmStationPersistence.getStationFrequency());
        dataOutputStream.writeInt(amFmStationPersistence.getStationPi());
        dataOutputStream.writeInt(amFmStationPersistence.getStationReceptionQuality());
        dataOutputStream.writeInt(amFmStationPersistence.getStationPtyCode());
        dataOutputStream.writeInt(amFmStationPersistence.getStationWaveband());
        dataOutputStream.writeBoolean(amFmStationPersistence.isStationRds());
        dataOutputStream.writeBoolean(amFmStationPersistence.isStationTp());
        dataOutputStream.writeBoolean(amFmStationPersistence.isStationTa());
        dataOutputStream.writeBoolean(amFmStationPersistence.isStationTmc());
        dataOutputStream.writeBoolean(amFmStationPersistence.isStationScrollingPs());
        dataOutputStream.writeBoolean(amFmStationPersistence.isStationRadioText());
        dataOutputStream.writeBoolean(amFmStationPersistence.getStationRealPs() == null);
        if (amFmStationPersistence.getStationRealPs() != null) {
            object = amFmStationPersistence.getStationRealPs().getBytes();
            dataOutputStream.writeInt(((byte[])object).length);
            dataOutputStream.write((byte[])object);
        }
        dataOutputStream.writeBoolean(amFmStationPersistence.isStationHd());
        dataOutputStream.writeBoolean(amFmStationPersistence.getStationShortNameHd() == null);
        if (amFmStationPersistence.getStationShortNameHd() != null) {
            object = amFmStationPersistence.getStationShortNameHd().getBytes();
            dataOutputStream.writeInt(((byte[])object).length);
            dataOutputStream.write((byte[])object);
        }
        dataOutputStream.writeBoolean(amFmStationPersistence.getStationLongNameHd() == null);
        if (amFmStationPersistence.getStationLongNameHd() != null) {
            object = amFmStationPersistence.getStationLongNameHd().getBytes();
            dataOutputStream.writeInt(((byte[])object).length);
            dataOutputStream.write((byte[])object);
        }
        dataOutputStream.writeBoolean(amFmStationPersistence.isStationFullDigital());
        dataOutputStream.writeInt(amFmStationPersistence.getStationServiceId());
        dataOutputStream.writeInt(amFmStationPersistence.getStationSubscription());
        dataOutputStream.writeBoolean(amFmStationPersistence.isStationEon());
        dataOutputStream.writeBoolean(amFmStationPersistence.isStationCoChannel());
        dataOutputStream.writeBoolean(amFmStationPersistence.getRealName() == null);
        if (amFmStationPersistence.getRealName() != null) {
            object = amFmStationPersistence.getRealName().getBytes();
            dataOutputStream.writeInt(((byte[])object).length);
            dataOutputStream.write((byte[])object);
        }
        dataOutputStream.writeBoolean(amFmStationPersistence.getRegString() == null);
        if (amFmStationPersistence.getRegString() != null) {
            object = amFmStationPersistence.getRegString().getBytes();
            dataOutputStream.writeInt(((byte[])object).length);
            dataOutputStream.write((byte[])object);
        }
        dataOutputStream.writeInt(amFmStationPersistence.getHdStatus());
        dataOutputStream.writeInt(amFmStationPersistence.getSubChannelCount());
        dataOutputStream.writeInt(amFmStationPersistence.getChannelMask());
        dataOutputStream.writeLong(amFmStationPersistence.getUniqueId());
        dataOutputStream.writeBoolean(amFmStationPersistence.isMpsWithSPSAlreadyStored());
        dataOutputStream.writeBoolean(amFmStationPersistence.isMpsWithoutSPSAlreadyStored());
        dataOutputStream.writeBoolean(amFmStationPersistence.getStationImage() == null);
        if (amFmStationPersistence.getStationImage() != null) {
            object = this.factory.createSerializer(4);
            dataOutputStream.write(object.serializeCommonData(amFmStationPersistence.getStationImage()));
        }
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
        $assertionsDisabled = !(class$de$vw$mib$asl$amfm$persistence$AmFmStationPersistenceSerializer == null ? (class$de$vw$mib$asl$amfm$persistence$AmFmStationPersistenceSerializer = AmFmStationPersistenceSerializer.class$("de.vw.mib.asl.amfm.persistence.AmFmStationPersistenceSerializer")) : class$de$vw$mib$asl$amfm$persistence$AmFmStationPersistenceSerializer).desiredAssertionStatus();
    }
}

