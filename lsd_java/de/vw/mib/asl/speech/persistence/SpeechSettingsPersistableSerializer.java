/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.speech.persistence;

import de.vw.mib.asl.framework.api.persistence2.AbstractPersistableSerializer;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistableSerializerFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistenceException;
import de.vw.mib.asl.speech.persistence.SpeechSettingsPersistable;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

class SpeechSettingsPersistableSerializer
extends AbstractPersistableSerializer {
    final PersistableSerializerFactory factory;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$asl$speech$persistence$SpeechSettingsPersistableSerializer;

    SpeechSettingsPersistableSerializer(PersistableSerializerFactory persistableSerializerFactory) {
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
            return this.serializeCommonData((SpeechSettingsPersistable)persistable);
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
            return this.serializeUserSpecificData((SpeechSettingsPersistable)persistable);
        }
        catch (IOException iOException) {
            throw new PersistenceException("Error while serializing.", iOException);
        }
    }

    private byte[] serializeCommonData(SpeechSettingsPersistable speechSettingsPersistable) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        dataOutputStream.writeShort(1);
        dataOutputStream.writeInt(speechSettingsPersistable.getCurrentVoiceType());
        return byteArrayOutputStream.toByteArray();
    }

    private byte[] serializeUserSpecificData(SpeechSettingsPersistable speechSettingsPersistable) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        dataOutputStream.writeShort(1);
        dataOutputStream.writeBoolean(speechSettingsPersistable.isIsDisplayAvailableCommandsOnHeadunitActivated());
        dataOutputStream.writeBoolean(speechSettingsPersistable.isIsDisplayAvailableCommandsOnICActivated());
        dataOutputStream.writeBoolean(speechSettingsPersistable.isIsUseSpeechSessionStartToneActivated());
        dataOutputStream.writeBoolean(speechSettingsPersistable.isIsUseSpeechSessionEndToneActivated());
        dataOutputStream.writeBoolean(speechSettingsPersistable.isIsRecognizerReadyToneActivated());
        dataOutputStream.writeBoolean(speechSettingsPersistable.isIsRecognizerEndToneActivated());
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
        $assertionsDisabled = !(class$de$vw$mib$asl$speech$persistence$SpeechSettingsPersistableSerializer == null ? (class$de$vw$mib$asl$speech$persistence$SpeechSettingsPersistableSerializer = SpeechSettingsPersistableSerializer.class$("de.vw.mib.asl.speech.persistence.SpeechSettingsPersistableSerializer")) : class$de$vw$mib$asl$speech$persistence$SpeechSettingsPersistableSerializer).desiredAssertionStatus();
    }
}

