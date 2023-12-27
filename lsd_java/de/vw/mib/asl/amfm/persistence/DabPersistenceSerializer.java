/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.amfm.persistence;

import de.vw.mib.asl.amfm.persistence.DabPersistence;
import de.vw.mib.asl.framework.api.persistence2.AbstractPersistableSerializer;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistableSerializer;
import de.vw.mib.asl.framework.api.persistence2.PersistableSerializerFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistenceException;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

class DabPersistenceSerializer
extends AbstractPersistableSerializer {
    final PersistableSerializerFactory factory;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$asl$amfm$persistence$DabPersistenceSerializer;

    DabPersistenceSerializer(PersistableSerializerFactory persistableSerializerFactory) {
        if (!$assertionsDisabled && persistableSerializerFactory == null) {
            throw new AssertionError();
        }
        this.factory = persistableSerializerFactory;
    }

    @Override
    public int getPersistableId() {
        return 8;
    }

    @Override
    public byte[] serializeCommonData(Persistable persistable) {
        this.checkPersistable(persistable);
        if (this.factory == null) {
            throw new PersistenceException("PersistableSerializerFactory must not be null.");
        }
        try {
            return this.serializeCommonData((DabPersistence)persistable);
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
            return this.serializeUserSpecificData((DabPersistence)persistable);
        }
        catch (IOException iOException) {
            throw new PersistenceException("Error while serializing.", iOException);
        }
    }

    private byte[] serializeCommonData(DabPersistence dabPersistence) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        dataOutputStream.writeShort(1);
        dataOutputStream.writeInt(dabPersistence.getCurrentBand1());
        dataOutputStream.writeInt(dabPersistence.getCurrentBand2());
        return byteArrayOutputStream.toByteArray();
    }

    private byte[] serializeUserSpecificData(DabPersistence dabPersistence) {
        Object object;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        dataOutputStream.writeShort(1);
        dataOutputStream.writeBoolean(dabPersistence.getCurrentFrequency() == null);
        if (dabPersistence.getCurrentFrequency() != null) {
            object = this.factory.createSerializer(9);
            dataOutputStream.write(object.serializeCommonData(dabPersistence.getCurrentFrequency()));
        }
        dataOutputStream.writeBoolean(dabPersistence.getCurrentEnsemble() == null);
        if (dabPersistence.getCurrentEnsemble() != null) {
            object = this.factory.createSerializer(10);
            dataOutputStream.write(object.serializeCommonData(dabPersistence.getCurrentEnsemble()));
        }
        dataOutputStream.writeBoolean(dabPersistence.getCurrentService() == null);
        if (dabPersistence.getCurrentService() != null) {
            object = this.factory.createSerializer(11);
            dataOutputStream.write(object.serializeCommonData(dabPersistence.getCurrentService()));
        }
        dataOutputStream.writeBoolean(dabPersistence.getCurrentComponent() == null);
        if (dabPersistence.getCurrentComponent() != null) {
            object = this.factory.createSerializer(12);
            dataOutputStream.write(object.serializeCommonData(dabPersistence.getCurrentComponent()));
        }
        dataOutputStream.writeBoolean(dabPersistence.getLinkingEnsemble() == null);
        if (dabPersistence.getLinkingEnsemble() != null) {
            object = this.factory.createSerializer(10);
            dataOutputStream.write(object.serializeCommonData(dabPersistence.getLinkingEnsemble()));
        }
        dataOutputStream.writeBoolean(dabPersistence.getLinkingService() == null);
        if (dabPersistence.getLinkingService() != null) {
            object = this.factory.createSerializer(11);
            dataOutputStream.write(object.serializeCommonData(dabPersistence.getLinkingService()));
        }
        dataOutputStream.writeBoolean(dabPersistence.isLBandOptionState());
        dataOutputStream.writeBoolean(dabPersistence.isOtherAnnouncementOption());
        dataOutputStream.writeBoolean(dabPersistence.isTrafficAnnouncementOption());
        dataOutputStream.writeBoolean(dabPersistence.isDabFollowing());
        dataOutputStream.writeBoolean(dabPersistence.isFmLinking());
        dataOutputStream.writeInt(dabPersistence.getViewMode());
        dataOutputStream.writeBoolean(dabPersistence.isLsmSupportsSlideshow());
        dataOutputStream.writeInt(dabPersistence.getCurrentPresetIndexSelectedByHmi());
        dataOutputStream.writeInt(dabPersistence.getVisibleBankIndex());
        dataOutputStream.writeBoolean(dabPersistence.isSoftLinkingOption());
        dataOutputStream.writeInt(dabPersistence.getDabPresets().size());
        object = dabPersistence.getDabPresets().iterator();
        while (object.hasNext()) {
            Persistable persistable = (Persistable)object.next();
            dataOutputStream.writeBoolean(persistable == null);
            if (persistable == null) continue;
            PersistableSerializer persistableSerializer = this.factory.createSerializer(13);
            dataOutputStream.write(persistableSerializer.serializeCommonData(persistable));
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
        $assertionsDisabled = !(class$de$vw$mib$asl$amfm$persistence$DabPersistenceSerializer == null ? (class$de$vw$mib$asl$amfm$persistence$DabPersistenceSerializer = DabPersistenceSerializer.class$("de.vw.mib.asl.amfm.persistence.DabPersistenceSerializer")) : class$de$vw$mib$asl$amfm$persistence$DabPersistenceSerializer).desiredAssertionStatus();
    }
}

