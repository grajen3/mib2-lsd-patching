/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.systemcommon.persistence;

import de.vw.mib.asl.framework.api.persistence2.AbstractPersistableSerializer;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistableSerializerFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistenceException;
import de.vw.mib.asl.systemcommon.persistence.AbtFeatures;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

class AbtFeaturesSerializer
extends AbstractPersistableSerializer {
    final PersistableSerializerFactory factory;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$asl$systemcommon$persistence$AbtFeaturesSerializer;

    AbtFeaturesSerializer(PersistableSerializerFactory persistableSerializerFactory) {
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
            return this.serializeCommonData((AbtFeatures)persistable);
        }
        catch (IOException iOException) {
            throw new PersistenceException("Error while serializing.", iOException);
        }
    }

    @Override
    public byte[] serializeUserSpecificData(Persistable persistable) {
        throw new PersistenceException("AbtFeatures does not conatain any user specific data");
    }

    private byte[] serializeCommonData(AbtFeatures abtFeatures) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        dataOutputStream.writeShort(1);
        dataOutputStream.writeInt(abtFeatures.getProximitySensor());
        dataOutputStream.writeBoolean(abtFeatures.isHandWritingRecognition());
        dataOutputStream.writeBoolean(abtFeatures.isHapticFeedback());
        dataOutputStream.writeInt(abtFeatures.getDisplayResolutionX());
        dataOutputStream.writeInt(abtFeatures.getDisplayResolutionY());
        dataOutputStream.writeInt(abtFeatures.getAbtType());
        dataOutputStream.writeInt(abtFeatures.getDisplayShape());
        dataOutputStream.writeInt(abtFeatures.getNubmerOfHardKeys());
        dataOutputStream.writeInt(abtFeatures.getButtonTechnology());
        dataOutputStream.writeInt(abtFeatures.getRotaryEncoderType());
        dataOutputStream.writeInt(abtFeatures.getTouchController());
        dataOutputStream.writeInt(abtFeatures.getTouchMultiplicatorX());
        dataOutputStream.writeInt(abtFeatures.getTouchMultiplicatorY());
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
        $assertionsDisabled = !(class$de$vw$mib$asl$systemcommon$persistence$AbtFeaturesSerializer == null ? (class$de$vw$mib$asl$systemcommon$persistence$AbtFeaturesSerializer = AbtFeaturesSerializer.class$("de.vw.mib.asl.systemcommon.persistence.AbtFeaturesSerializer")) : class$de$vw$mib$asl$systemcommon$persistence$AbtFeaturesSerializer).desiredAssertionStatus();
    }
}

