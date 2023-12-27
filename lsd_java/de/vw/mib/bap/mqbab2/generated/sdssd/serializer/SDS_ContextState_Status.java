/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.sdssd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.mqbab2.generated.sdssd.serializer.SDS_ContextState_Status$AdditionalInfo;
import de.vw.mib.bap.mqbab2.generated.sdssd.serializer.SDS_ContextState_Status$Attributes;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class SDS_ContextState_Status
implements StatusProperty {
    public int sds_ContextState;
    public static final int SDS_CONTEXT_STATE_IDLE_NOT_ACTIVE;
    public static final int SDS_CONTEXT_STATE_GLOBAL_TELEPROMPTER;
    public static final int SDS_CONTEXT_STATE_TOPIC_TELEPROMPTER;
    public static final int SDS_CONTEXT_STATE_USE_CASE_TELEPROMPTER;
    public static final int SDS_CONTEXT_STATE_DIALOG_TELEPROMPTER;
    public int sds_ContextType;
    public static final int SDS_CONTEXT_TYPE_ANY_TYPE_UNKNOWN;
    public static final int SDS_CONTEXT_TYPE_NAVIGATION;
    public static final int SDS_CONTEXT_TYPE_TELEPHONE;
    public static final int SDS_CONTEXT_TYPE_MEDIA;
    public static final int SDS_CONTEXT_TYPE_TUNER_RADIO;
    public static final int SDS_CONTEXT_TYPE_MESSAGING;
    public static final int SDS_CONTEXT_TYPE_ONLINE_SERVICES;
    public final SDS_ContextState_Status$Attributes attributes = new SDS_ContextState_Status$Attributes();
    public final SDS_ContextState_Status$AdditionalInfo additionalInfo = new SDS_ContextState_Status$AdditionalInfo();
    public static final int EXTENSION_MIN;
    public int extension;

    public SDS_ContextState_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public SDS_ContextState_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.sds_ContextState = 0;
        this.sds_ContextType = 0;
        this.extension = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.attributes.reset();
        this.additionalInfo.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        SDS_ContextState_Status sDS_ContextState_Status = (SDS_ContextState_Status)bAPEntity;
        return this.sds_ContextState == sDS_ContextState_Status.sds_ContextState && this.sds_ContextType == sDS_ContextState_Status.sds_ContextType && this.attributes.equalTo(sDS_ContextState_Status.attributes) && this.additionalInfo.equalTo(sDS_ContextState_Status.additionalInfo) && this.extension == sDS_ContextState_Status.extension;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "SDS_ContextState_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.sds_ContextState);
        bitStream.pushByte((byte)this.sds_ContextType);
        this.attributes.serialize(bitStream);
        this.additionalInfo.serialize(bitStream);
        bitStream.pushByte((byte)this.extension);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 17;
    }

    @Override
    public int getFunctionId() {
        return SDS_ContextState_Status.functionId();
    }
}

