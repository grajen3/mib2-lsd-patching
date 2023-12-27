/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.sdssd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class BAP_Config_Reset
implements BAPEntity {
    public static final int BAP_VERSION_MAJOR_MIN;
    public int bap_VersionMajor;
    public static final int BAP_VERSION_MINOR_MIN;
    public int bap_VersionMinor;
    public static final int LSG_CLASS_MIN;
    public int lsg_Class;
    public static final int LSG_SUB_CLASS_MIN;
    public int lsg_SubClass;
    public static final int LSG_VERSION_MAJOR_MIN;
    public int lsg_VersionMajor;
    public static final int LSG_VERSION_MINOR_MIN;
    public int lsg_VersionMinor;

    public BAP_Config_Reset() {
        this.internalReset();
        this.customInitialization();
    }

    public BAP_Config_Reset(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.bap_VersionMajor = 3;
        this.bap_VersionMinor = 0;
        this.lsg_Class = 70;
        this.lsg_SubClass = 0;
        this.lsg_VersionMajor = 3;
        this.lsg_VersionMinor = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        BAP_Config_Reset bAP_Config_Reset = (BAP_Config_Reset)bAPEntity;
        return this.bap_VersionMajor == bAP_Config_Reset.bap_VersionMajor && this.bap_VersionMinor == bAP_Config_Reset.bap_VersionMinor && this.lsg_Class == bAP_Config_Reset.lsg_Class && this.lsg_SubClass == bAP_Config_Reset.lsg_SubClass && this.lsg_VersionMajor == bAP_Config_Reset.lsg_VersionMajor && this.lsg_VersionMinor == bAP_Config_Reset.lsg_VersionMinor;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "BAP_Config_Reset:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.bap_VersionMajor);
        bitStream.pushByte((byte)this.bap_VersionMinor);
        bitStream.pushByte((byte)this.lsg_Class);
        bitStream.pushByte((byte)this.lsg_SubClass);
        bitStream.pushByte((byte)this.lsg_VersionMajor);
        bitStream.pushByte((byte)this.lsg_VersionMinor);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 2;
    }

    public int getFunctionId() {
        return BAP_Config_Reset.functionId();
    }
}

