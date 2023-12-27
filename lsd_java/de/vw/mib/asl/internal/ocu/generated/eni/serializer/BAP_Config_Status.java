/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.generated.eni.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class BAP_Config_Status
implements StatusProperty {
    public int bap_Version_major;
    public static final int BAP_VERSION_MAJOR_MIN;
    public int bap_Version_minor;
    public static final int BAP_VERSION_MINOR_MIN;
    public int lsg_Class;
    public static final int LSG_CLASS_MIN;
    public int lsg_Sub_Class;
    public static final int LSG_SUB_CLASS_MIN;
    public int lsg_Version_major;
    public static final int LSG_VERSION_MAJOR_MIN;
    public int lsg_Version_minor;
    public static final int LSG_VERSION_MINOR_MIN;

    public BAP_Config_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public BAP_Config_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.bap_Version_major = 3;
        this.bap_Version_minor = 0;
        this.lsg_Class = 55;
        this.lsg_Sub_Class = 0;
        this.lsg_Version_major = 3;
        this.lsg_Version_minor = 6;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        BAP_Config_Status bAP_Config_Status = (BAP_Config_Status)bAPEntity;
        return this.bap_Version_major == bAP_Config_Status.bap_Version_major && this.bap_Version_minor == bAP_Config_Status.bap_Version_minor && this.lsg_Class == bAP_Config_Status.lsg_Class && this.lsg_Sub_Class == bAP_Config_Status.lsg_Sub_Class && this.lsg_Version_major == bAP_Config_Status.lsg_Version_major && this.lsg_Version_minor == bAP_Config_Status.lsg_Version_minor;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "BAP_Config_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.bap_Version_major);
        bitStream.pushByte((byte)this.bap_Version_minor);
        bitStream.pushByte((byte)this.lsg_Class);
        bitStream.pushByte((byte)this.lsg_Sub_Class);
        bitStream.pushByte((byte)this.lsg_Version_major);
        bitStream.pushByte((byte)this.lsg_Version_minor);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.bap_Version_major = bitStream.popFrontByte();
        this.bap_Version_minor = bitStream.popFrontByte();
        this.lsg_Class = bitStream.popFrontByte();
        this.lsg_Sub_Class = bitStream.popFrontByte();
        this.lsg_Version_major = bitStream.popFrontByte();
        this.lsg_Version_minor = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 2;
    }

    @Override
    public int getFunctionId() {
        return BAP_Config_Status.functionId();
    }
}

