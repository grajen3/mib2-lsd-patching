/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class FSG_Setup_ReceptionList_AutoUpdate
implements BAPEntity {
    public boolean onlineRadioReceptionListIsAutomaticallyUpdatedDf4_1;
    public boolean tvDvbReceptionListIsAutomaticallyUpdated;
    public boolean amSwReceptionListIsAutomaticallyUpdated;
    public boolean amLwReceptionListIsAutomaticallyUpdated;
    public boolean sdarsReceptionListIsAutomaticallyUpdated;
    public boolean dabReceptionListIsAutomaticallyUpdated;
    public boolean amReceptionListIsAutomaticallyUpdated;
    public boolean fmReceptionListIsAutomaticallyUpdated;

    public FSG_Setup_ReceptionList_AutoUpdate() {
        this.internalReset();
        this.customInitialization();
    }

    public FSG_Setup_ReceptionList_AutoUpdate(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.onlineRadioReceptionListIsAutomaticallyUpdatedDf4_1 = false;
        this.tvDvbReceptionListIsAutomaticallyUpdated = false;
        this.amSwReceptionListIsAutomaticallyUpdated = false;
        this.amLwReceptionListIsAutomaticallyUpdated = false;
        this.sdarsReceptionListIsAutomaticallyUpdated = false;
        this.dabReceptionListIsAutomaticallyUpdated = false;
        this.amReceptionListIsAutomaticallyUpdated = false;
        this.fmReceptionListIsAutomaticallyUpdated = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        FSG_Setup_ReceptionList_AutoUpdate fSG_Setup_ReceptionList_AutoUpdate = (FSG_Setup_ReceptionList_AutoUpdate)bAPEntity;
        return this.onlineRadioReceptionListIsAutomaticallyUpdatedDf4_1 == fSG_Setup_ReceptionList_AutoUpdate.onlineRadioReceptionListIsAutomaticallyUpdatedDf4_1 && this.tvDvbReceptionListIsAutomaticallyUpdated == fSG_Setup_ReceptionList_AutoUpdate.tvDvbReceptionListIsAutomaticallyUpdated && this.amSwReceptionListIsAutomaticallyUpdated == fSG_Setup_ReceptionList_AutoUpdate.amSwReceptionListIsAutomaticallyUpdated && this.amLwReceptionListIsAutomaticallyUpdated == fSG_Setup_ReceptionList_AutoUpdate.amLwReceptionListIsAutomaticallyUpdated && this.sdarsReceptionListIsAutomaticallyUpdated == fSG_Setup_ReceptionList_AutoUpdate.sdarsReceptionListIsAutomaticallyUpdated && this.dabReceptionListIsAutomaticallyUpdated == fSG_Setup_ReceptionList_AutoUpdate.dabReceptionListIsAutomaticallyUpdated && this.amReceptionListIsAutomaticallyUpdated == fSG_Setup_ReceptionList_AutoUpdate.amReceptionListIsAutomaticallyUpdated && this.fmReceptionListIsAutomaticallyUpdated == fSG_Setup_ReceptionList_AutoUpdate.fmReceptionListIsAutomaticallyUpdated;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "FSG_Setup_Empty:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushBoolean(this.onlineRadioReceptionListIsAutomaticallyUpdatedDf4_1);
        bitStream.pushBoolean(this.tvDvbReceptionListIsAutomaticallyUpdated);
        bitStream.pushBoolean(this.amSwReceptionListIsAutomaticallyUpdated);
        bitStream.pushBoolean(this.amLwReceptionListIsAutomaticallyUpdated);
        bitStream.pushBoolean(this.sdarsReceptionListIsAutomaticallyUpdated);
        bitStream.pushBoolean(this.dabReceptionListIsAutomaticallyUpdated);
        bitStream.pushBoolean(this.amReceptionListIsAutomaticallyUpdated);
        bitStream.pushBoolean(this.fmReceptionListIsAutomaticallyUpdated);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.onlineRadioReceptionListIsAutomaticallyUpdatedDf4_1 = bitStream.popFrontBoolean();
        this.tvDvbReceptionListIsAutomaticallyUpdated = bitStream.popFrontBoolean();
        this.amSwReceptionListIsAutomaticallyUpdated = bitStream.popFrontBoolean();
        this.amLwReceptionListIsAutomaticallyUpdated = bitStream.popFrontBoolean();
        this.sdarsReceptionListIsAutomaticallyUpdated = bitStream.popFrontBoolean();
        this.dabReceptionListIsAutomaticallyUpdated = bitStream.popFrontBoolean();
        this.amReceptionListIsAutomaticallyUpdated = bitStream.popFrontBoolean();
        this.fmReceptionListIsAutomaticallyUpdated = bitStream.popFrontBoolean();
    }
}

