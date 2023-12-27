/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.FSG_Setup_ReceptionList_AutoUpdate;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.FSG_Setup_Setup_Extensions;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.FSG_Setup_SupportedVolumeTypes;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class FSG_Setup_Status
implements StatusProperty {
    public int maxVolume;
    public static final int MAX_VOLUME_MIN;
    public FSG_Setup_SupportedVolumeTypes supportedVolumeTypes = new FSG_Setup_SupportedVolumeTypes();
    public FSG_Setup_ReceptionList_AutoUpdate receptionList_AutoUpdate = new FSG_Setup_ReceptionList_AutoUpdate();
    public FSG_Setup_Setup_Extensions setup_Extensions = new FSG_Setup_Setup_Extensions();

    public FSG_Setup_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public FSG_Setup_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.maxVolume = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.supportedVolumeTypes.reset();
        this.receptionList_AutoUpdate.reset();
        this.setup_Extensions.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        FSG_Setup_Status fSG_Setup_Status = (FSG_Setup_Status)bAPEntity;
        return this.maxVolume == fSG_Setup_Status.maxVolume && this.supportedVolumeTypes.equalTo(fSG_Setup_Status.supportedVolumeTypes) && this.receptionList_AutoUpdate.equalTo(fSG_Setup_Status.receptionList_AutoUpdate) && this.setup_Extensions.equalTo(fSG_Setup_Status.setup_Extensions);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "FSG_Setup_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.maxVolume);
        this.supportedVolumeTypes.serialize(bitStream);
        this.receptionList_AutoUpdate.serialize(bitStream);
        this.setup_Extensions.serialize(bitStream);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.maxVolume = bitStream.popFrontByte();
        this.supportedVolumeTypes.deserialize(bitStream);
        this.receptionList_AutoUpdate.deserialize(bitStream);
        this.setup_Extensions.deserialize(bitStream);
    }

    public static int functionId() {
        return 14;
    }

    @Override
    public int getFunctionId() {
        return FSG_Setup_Status.functionId();
    }
}

