/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.amfm.persistence;

import de.vw.mib.asl.amfm.persistence.AmFmPresetSettings;
import de.vw.mib.asl.framework.api.persistence2.AbstractPersistableSerializer;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistableSerializer;
import de.vw.mib.asl.framework.api.persistence2.PersistableSerializerFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistenceException;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Iterator;

class AmFmPresetSettingsSerializer
extends AbstractPersistableSerializer {
    final PersistableSerializerFactory factory;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$asl$amfm$persistence$AmFmPresetSettingsSerializer;

    AmFmPresetSettingsSerializer(PersistableSerializerFactory persistableSerializerFactory) {
        if (!$assertionsDisabled && persistableSerializerFactory == null) {
            throw new AssertionError();
        }
        this.factory = persistableSerializerFactory;
    }

    @Override
    public int getPersistableId() {
        return 5;
    }

    @Override
    public byte[] serializeCommonData(Persistable persistable) {
        this.checkPersistable(persistable);
        if (this.factory == null) {
            throw new PersistenceException("PersistableSerializerFactory must not be null.");
        }
        try {
            return this.serializeCommonData((AmFmPresetSettings)persistable);
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
            return this.serializeUserSpecificData((AmFmPresetSettings)persistable);
        }
        catch (IOException iOException) {
            throw new PersistenceException("Error while serializing.", iOException);
        }
    }

    private byte[] serializeCommonData(AmFmPresetSettings amFmPresetSettings) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        dataOutputStream.writeShort(1);
        return byteArrayOutputStream.toByteArray();
    }

    private byte[] serializeUserSpecificData(AmFmPresetSettings amFmPresetSettings) {
        PersistableSerializer persistableSerializer;
        Persistable persistable;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        dataOutputStream.writeShort(1);
        dataOutputStream.writeInt(amFmPresetSettings.getAmPresets().size());
        Iterator iterator = amFmPresetSettings.getAmPresets().iterator();
        while (iterator.hasNext()) {
            persistable = (Persistable)iterator.next();
            dataOutputStream.writeBoolean(persistable == null);
            if (persistable == null) continue;
            persistableSerializer = this.factory.createSerializer(3);
            dataOutputStream.write(persistableSerializer.serializeCommonData(persistable));
        }
        dataOutputStream.writeInt(amFmPresetSettings.getFmPresets().size());
        iterator = amFmPresetSettings.getFmPresets().iterator();
        while (iterator.hasNext()) {
            persistable = (Persistable)iterator.next();
            dataOutputStream.writeBoolean(persistable == null);
            if (persistable == null) continue;
            persistableSerializer = this.factory.createSerializer(3);
            dataOutputStream.write(persistableSerializer.serializeCommonData(persistable));
        }
        dataOutputStream.writeInt(amFmPresetSettings.getCurrentBankIndexAm());
        dataOutputStream.writeInt(amFmPresetSettings.getCurrentBankIndexFm());
        dataOutputStream.writeInt(amFmPresetSettings.getCurrentIndexAm());
        dataOutputStream.writeInt(amFmPresetSettings.getCurrentIndexFm());
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
        $assertionsDisabled = !(class$de$vw$mib$asl$amfm$persistence$AmFmPresetSettingsSerializer == null ? (class$de$vw$mib$asl$amfm$persistence$AmFmPresetSettingsSerializer = AmFmPresetSettingsSerializer.class$("de.vw.mib.asl.amfm.persistence.AmFmPresetSettingsSerializer")) : class$de$vw$mib$asl$amfm$persistence$AmFmPresetSettingsSerializer).desiredAssertionStatus();
    }
}

