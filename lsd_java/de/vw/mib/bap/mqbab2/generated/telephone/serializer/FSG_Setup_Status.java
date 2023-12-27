/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.FSG_Setup_Status$PhoneCharacteristics;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class FSG_Setup_Status
implements StatusProperty {
    public final FSG_Setup_Status$PhoneCharacteristics phoneCharacteristics = new FSG_Setup_Status$PhoneCharacteristics();
    public int mobileConnectionType;
    public static final int MOBILE_CONNECTION_TYPE_NO_CONNECTION;
    public static final int MOBILE_CONNECTION_TYPE_INTERNAL_SIM_CARD_READER;
    public static final int MOBILE_CONNECTION_TYPE_CABLE_CONNECTION;
    public static final int MOBILE_CONNECTION_TYPE_HANDS_FREE_PROFILE;
    public static final int MOBILE_CONNECTION_TYPE_REMOTE_SIM_ACCESS_PROFILE;
    public static final int MOBILE_CONNECTION_TYPE_APPLE_LINK_DF4_2;
    public static final int MOBILE_CONNECTION_TYPE_GOOGLE_LINK_DF4_2;

    public FSG_Setup_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public FSG_Setup_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.mobileConnectionType = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.phoneCharacteristics.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        FSG_Setup_Status fSG_Setup_Status = (FSG_Setup_Status)bAPEntity;
        return this.phoneCharacteristics.equalTo(fSG_Setup_Status.phoneCharacteristics) && this.mobileConnectionType == fSG_Setup_Status.mobileConnectionType;
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
        this.phoneCharacteristics.serialize(bitStream);
        bitStream.pushByte((byte)this.mobileConnectionType);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 14;
    }

    @Override
    public int getFunctionId() {
        return FSG_Setup_Status.functionId();
    }
}

