/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.generated.ecall.serializer;

import de.vw.mib.asl.internal.ocu.generated.ecall.serializer.FSG_Setup_GeneralSettings;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class FSG_Setup_Status
implements StatusProperty {
    public FSG_Setup_GeneralSettings generalSettings = new FSG_Setup_GeneralSettings();
    public int extension2;
    public static final int EXTENSION2_MIN;
    public int extension3;
    public static final int EXTENSION3_MIN;

    public FSG_Setup_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public FSG_Setup_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.extension2 = 0;
        this.extension3 = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.generalSettings.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        FSG_Setup_Status fSG_Setup_Status = (FSG_Setup_Status)bAPEntity;
        return this.generalSettings.equalTo(fSG_Setup_Status.generalSettings) && this.extension2 == fSG_Setup_Status.extension2 && this.extension3 == fSG_Setup_Status.extension3;
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
        this.generalSettings.serialize(bitStream);
        bitStream.pushByte((byte)this.extension2);
        bitStream.pushByte((byte)this.extension3);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.generalSettings.deserialize(bitStream);
        this.extension2 = bitStream.popFrontByte();
        this.extension3 = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 14;
    }

    @Override
    public int getFunctionId() {
        return FSG_Setup_Status.functionId();
    }
}

