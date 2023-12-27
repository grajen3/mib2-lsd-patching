/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.systemcommon.persistence;

import de.vw.mib.asl.framework.api.persistence2.AbstractPersistableSerializer;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistableSerializerFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistenceException;
import de.vw.mib.asl.systemcommon.persistence.SystemCommon;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

class SystemCommonSerializer
extends AbstractPersistableSerializer {
    final PersistableSerializerFactory factory;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$asl$systemcommon$persistence$SystemCommonSerializer;

    SystemCommonSerializer(PersistableSerializerFactory persistableSerializerFactory) {
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
            return this.serializeCommonData((SystemCommon)persistable);
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
            return this.serializeUserSpecificData((SystemCommon)persistable);
        }
        catch (IOException iOException) {
            throw new PersistenceException("Error while serializing.", iOException);
        }
    }

    private byte[] serializeCommonData(SystemCommon systemCommon) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        dataOutputStream.writeShort(1);
        dataOutputStream.writeBoolean(systemCommon.isValetParkingActive());
        dataOutputStream.writeBoolean(systemCommon.isRearSeatControlLocked());
        dataOutputStream.writeBoolean(systemCommon.isOnlineAvailable());
        dataOutputStream.writeBoolean(systemCommon.isClimateECUhasMenuHK());
        return byteArrayOutputStream.toByteArray();
    }

    private byte[] serializeUserSpecificData(SystemCommon systemCommon) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        dataOutputStream.writeShort(1);
        dataOutputStream.writeInt(systemCommon.getDisplayBrightness());
        dataOutputStream.writeBoolean(systemCommon.isShowClock());
        dataOutputStream.writeInt(systemCommon.getOffclockLayout());
        dataOutputStream.writeInt(systemCommon.getSpellerLayout());
        dataOutputStream.writeLong(systemCommon.getBitfieldLanguagesThatWereSetBefore());
        dataOutputStream.writeBoolean(systemCommon.isAcousticTouchscreenFeedback());
        dataOutputStream.writeBoolean(systemCommon.isProximityEnabled());
        dataOutputStream.writeInt(systemCommon.getMenuMode());
        dataOutputStream.writeBoolean(systemCommon.isAcousticSensorButtonFeedback());
        dataOutputStream.writeBoolean(systemCommon.isGestureActive());
        dataOutputStream.writeBoolean(systemCommon.isGestureInformationActive());
        dataOutputStream.writeBoolean(systemCommon.isGestureSoundeffectActive());
        dataOutputStream.writeBoolean(systemCommon.getLastContentId() == null);
        if (systemCommon.getLastContentId() != null) {
            byte[] byArray = systemCommon.getLastContentId().getBytes();
            dataOutputStream.writeInt(byArray.length);
            dataOutputStream.write(byArray);
        }
        dataOutputStream.writeBoolean(systemCommon.isDisplayOffClock());
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
        $assertionsDisabled = !(class$de$vw$mib$asl$systemcommon$persistence$SystemCommonSerializer == null ? (class$de$vw$mib$asl$systemcommon$persistence$SystemCommonSerializer = SystemCommonSerializer.class$("de.vw.mib.asl.systemcommon.persistence.SystemCommonSerializer")) : class$de$vw$mib$asl$systemcommon$persistence$SystemCommonSerializer).desiredAssertionStatus();
    }
}

