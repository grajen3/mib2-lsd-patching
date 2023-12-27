/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.amfm.persistence;

import de.vw.mib.asl.amfm.persistence.SatPersistence;
import de.vw.mib.asl.framework.api.persistence2.AbstractPersistableSerializer;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistableSerializer;
import de.vw.mib.asl.framework.api.persistence2.PersistableSerializerFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistenceException;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

class SatPersistenceSerializer
extends AbstractPersistableSerializer {
    final PersistableSerializerFactory factory;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$asl$amfm$persistence$SatPersistenceSerializer;

    SatPersistenceSerializer(PersistableSerializerFactory persistableSerializerFactory) {
        if (!$assertionsDisabled && persistableSerializerFactory == null) {
            throw new AssertionError();
        }
        this.factory = persistableSerializerFactory;
    }

    @Override
    public int getPersistableId() {
        return 14;
    }

    @Override
    public byte[] serializeCommonData(Persistable persistable) {
        this.checkPersistable(persistable);
        if (this.factory == null) {
            throw new PersistenceException("PersistableSerializerFactory must not be null.");
        }
        try {
            return this.serializeCommonData((SatPersistence)persistable);
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
            return this.serializeUserSpecificData((SatPersistence)persistable);
        }
        catch (IOException iOException) {
            throw new PersistenceException("Error while serializing.", iOException);
        }
    }

    private byte[] serializeCommonData(SatPersistence satPersistence) {
        Object object;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        dataOutputStream.writeShort(1);
        dataOutputStream.writeInt(satPersistence.getSatNoOfPresets());
        dataOutputStream.writeInt(satPersistence.getSubscriptionDay());
        dataOutputStream.writeInt(satPersistence.getSubscriptionMonth());
        dataOutputStream.writeInt(satPersistence.getSubscriptionYear());
        dataOutputStream.writeBoolean(satPersistence.getSubscriptionPhone() == null);
        if (satPersistence.getSubscriptionPhone() != null) {
            object = satPersistence.getSubscriptionPhone().getBytes();
            dataOutputStream.writeInt(((byte[])object).length);
            dataOutputStream.write((byte[])object);
        }
        dataOutputStream.writeInt(satPersistence.getSubscriptionReasonCode());
        dataOutputStream.writeBoolean(satPersistence.getSubscriptionReasonText() == null);
        if (satPersistence.getSubscriptionReasonText() != null) {
            object = satPersistence.getSubscriptionReasonText().getBytes();
            dataOutputStream.writeInt(((byte[])object).length);
            dataOutputStream.write((byte[])object);
        }
        dataOutputStream.writeInt(satPersistence.getSubscriptionState());
        dataOutputStream.writeInt(satPersistence.getSubscriptionTrafficState());
        dataOutputStream.writeBoolean(satPersistence.isSubscriptionShowPopupSubscriptionChanged());
        dataOutputStream.writeInt(satPersistence.getSatImages().size());
        object = satPersistence.getSatImages().iterator();
        while (object.hasNext()) {
            Persistable persistable = (Persistable)object.next();
            dataOutputStream.writeBoolean(persistable == null);
            if (persistable == null) continue;
            PersistableSerializer persistableSerializer = this.factory.createSerializer(16);
            dataOutputStream.write(persistableSerializer.serializeCommonData(persistable));
        }
        return byteArrayOutputStream.toByteArray();
    }

    private byte[] serializeUserSpecificData(SatPersistence satPersistence) {
        Object object;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        dataOutputStream.writeShort(1);
        dataOutputStream.writeBoolean(satPersistence.getUserChannel() == null);
        if (satPersistence.getUserChannel() != null) {
            object = this.factory.createSerializer(15);
            dataOutputStream.write(object.serializeCommonData(satPersistence.getUserChannel()));
        }
        dataOutputStream.writeBoolean(satPersistence.getPlayingChannel() == null);
        if (satPersistence.getPlayingChannel() != null) {
            object = this.factory.createSerializer(15);
            dataOutputStream.write(object.serializeCommonData(satPersistence.getPlayingChannel()));
        }
        dataOutputStream.writeInt(satPersistence.getSorting());
        dataOutputStream.writeBoolean(satPersistence.isSeekEnabled());
        dataOutputStream.writeInt(satPersistence.getViewMode());
        dataOutputStream.writeInt(satPersistence.getSatPresets().size());
        object = satPersistence.getSatPresets().iterator();
        while (object.hasNext()) {
            Persistable persistable = (Persistable)object.next();
            dataOutputStream.writeBoolean(persistable == null);
            if (persistable == null) continue;
            PersistableSerializer persistableSerializer = this.factory.createSerializer(15);
            dataOutputStream.write(persistableSerializer.serializeCommonData(persistable));
        }
        dataOutputStream.writeInt(satPersistence.getCurrentPresetIndex());
        dataOutputStream.writeByte(satPersistence.getCurrentPresetsBankIndex());
        dataOutputStream.writeBoolean(satPersistence.isUseChannelFilter());
        dataOutputStream.writeInt(satPersistence.getSkippedChannels().size());
        object = satPersistence.getSkippedChannels().iterator();
        while (object.hasNext()) {
            int n = object.next();
            dataOutputStream.writeInt(n);
        }
        dataOutputStream.writeInt(satPersistence.getNonSkippedChannels().size());
        object = satPersistence.getNonSkippedChannels().iterator();
        while (object.hasNext()) {
            int n = object.next();
            dataOutputStream.writeInt(n);
        }
        dataOutputStream.writeBoolean(satPersistence.isIsNoneFilterSelected());
        dataOutputStream.writeBoolean(satPersistence.isAllChannelsFilteredOut());
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
        $assertionsDisabled = !(class$de$vw$mib$asl$amfm$persistence$SatPersistenceSerializer == null ? (class$de$vw$mib$asl$amfm$persistence$SatPersistenceSerializer = SatPersistenceSerializer.class$("de.vw.mib.asl.amfm.persistence.SatPersistenceSerializer")) : class$de$vw$mib$asl$amfm$persistence$SatPersistenceSerializer).desiredAssertionStatus();
    }
}

