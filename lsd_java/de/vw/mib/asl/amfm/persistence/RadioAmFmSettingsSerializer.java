/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.amfm.persistence;

import de.vw.mib.asl.amfm.persistence.RadioAmFmSettings;
import de.vw.mib.asl.framework.api.persistence2.AbstractPersistableSerializer;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistableSerializer;
import de.vw.mib.asl.framework.api.persistence2.PersistableSerializerFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistenceException;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

class RadioAmFmSettingsSerializer
extends AbstractPersistableSerializer {
    final PersistableSerializerFactory factory;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$asl$amfm$persistence$RadioAmFmSettingsSerializer;

    RadioAmFmSettingsSerializer(PersistableSerializerFactory persistableSerializerFactory) {
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
            return this.serializeCommonData((RadioAmFmSettings)persistable);
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
            return this.serializeUserSpecificData((RadioAmFmSettings)persistable);
        }
        catch (IOException iOException) {
            throw new PersistenceException("Error while serializing.", iOException);
        }
    }

    private byte[] serializeCommonData(RadioAmFmSettings radioAmFmSettings) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        dataOutputStream.writeShort(1);
        dataOutputStream.writeBoolean(radioAmFmSettings.isRdsValueInCoding());
        dataOutputStream.writeBoolean(radioAmFmSettings.isAfValueInCoding());
        dataOutputStream.writeInt(radioAmFmSettings.getAmRangeOption());
        dataOutputStream.writeInt(radioAmFmSettings.getFmRange());
        dataOutputStream.writeInt(radioAmFmSettings.getAmFmNoOfPresets());
        dataOutputStream.writeInt(radioAmFmSettings.getDabNoOfPresets());
        return byteArrayOutputStream.toByteArray();
    }

    private byte[] serializeUserSpecificData(RadioAmFmSettings radioAmFmSettings) {
        PersistableSerializer persistableSerializer;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        dataOutputStream.writeShort(1);
        dataOutputStream.writeBoolean(radioAmFmSettings.isRadiotextOption());
        dataOutputStream.writeBoolean(radioAmFmSettings.isTpOption());
        dataOutputStream.writeBoolean(radioAmFmSettings.isRdsOption());
        dataOutputStream.writeBoolean(radioAmFmSettings.isAfOption());
        dataOutputStream.writeInt(radioAmFmSettings.getRegOption());
        dataOutputStream.writeInt(radioAmFmSettings.getScopeOfArrowButton());
        dataOutputStream.writeInt(radioAmFmSettings.getWaveBand());
        dataOutputStream.writeBoolean(radioAmFmSettings.isPty31Option());
        dataOutputStream.writeInt(radioAmFmSettings.getFmViewState());
        dataOutputStream.writeInt(radioAmFmSettings.getAmViewState());
        dataOutputStream.writeBoolean(radioAmFmSettings.isAmHdOption());
        dataOutputStream.writeBoolean(radioAmFmSettings.isRadioTextPlusOption());
        dataOutputStream.writeInt(radioAmFmSettings.getFmStationListSortOrder());
        dataOutputStream.writeBoolean(radioAmFmSettings.isAutoStoreStationLogosActive());
        dataOutputStream.writeBoolean(radioAmFmSettings.isAutoStoreStationLogosActiveChangedByUser());
        dataOutputStream.writeBoolean(radioAmFmSettings.isAfOnBeforeRdsOff());
        dataOutputStream.writeBoolean(radioAmFmSettings.isRegFixBeforeRdsOff());
        dataOutputStream.writeBoolean(radioAmFmSettings.isRadiotextOnBeforeRdsOff());
        dataOutputStream.writeBoolean(radioAmFmSettings.isTpOnBeforeRdsOff());
        dataOutputStream.writeBoolean(radioAmFmSettings.isAutoStoreStationLogosActiveBeforeRdsOff());
        dataOutputStream.writeBoolean(radioAmFmSettings.isEnhancedRadioTextActive());
        dataOutputStream.writeBoolean(radioAmFmSettings.isEnhancedRadioTextActiveBeforeRdsOff());
        dataOutputStream.writeBoolean(radioAmFmSettings.isHomeCountryAutoSelectionActive());
        dataOutputStream.writeBoolean(radioAmFmSettings.isFmHdOption());
        dataOutputStream.writeBoolean(radioAmFmSettings.isFmHdFilter());
        dataOutputStream.writeBoolean(radioAmFmSettings.isAmHdFilter());
        dataOutputStream.writeBoolean(radioAmFmSettings.getCurrentFmStation() == null);
        if (radioAmFmSettings.getCurrentFmStation() != null) {
            persistableSerializer = this.factory.createSerializer(2);
            dataOutputStream.write(persistableSerializer.serializeCommonData(radioAmFmSettings.getCurrentFmStation()));
        }
        dataOutputStream.writeBoolean(radioAmFmSettings.getCurrentAmStation() == null);
        if (radioAmFmSettings.getCurrentAmStation() != null) {
            persistableSerializer = this.factory.createSerializer(2);
            dataOutputStream.write(persistableSerializer.serializeCommonData(radioAmFmSettings.getCurrentAmStation()));
        }
        dataOutputStream.writeInt(radioAmFmSettings.getJapanTiFrequency());
        dataOutputStream.writeInt(radioAmFmSettings.getUserSelectedHomeCountry());
        dataOutputStream.writeInt(radioAmFmSettings.getCalculatedHomeCountry());
        dataOutputStream.writeInt(radioAmFmSettings.getDatabaseVersionMajor());
        dataOutputStream.writeInt(radioAmFmSettings.getDatabaseVersionMinor());
        dataOutputStream.writeInt(radioAmFmSettings.getDatabaseVersionRevision());
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
        $assertionsDisabled = !(class$de$vw$mib$asl$amfm$persistence$RadioAmFmSettingsSerializer == null ? (class$de$vw$mib$asl$amfm$persistence$RadioAmFmSettingsSerializer = RadioAmFmSettingsSerializer.class$("de.vw.mib.asl.amfm.persistence.RadioAmFmSettingsSerializer")) : class$de$vw$mib$asl$amfm$persistence$RadioAmFmSettingsSerializer).desiredAssertionStatus();
    }
}

