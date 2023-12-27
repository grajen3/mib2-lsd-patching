/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class BAP_Config_Status
implements StatusProperty {
    public static final int BAP_VERSION_MAJOR_MIN;
    public int bap_Version_major;
    public static final int BAP_VERSION_MINOR_MIN;
    public int bap_Version_minor;
    public static final int LSG_CLASS_MIN;
    public int lsgClass;
    public static final int LSG_SUB_CLASS_MIN;
    public int lsgSubClass;
    public static final int LSG_VERSION_MAJOR_MIN;
    public int lsgVersion_major;
    public static final int LSG_VERSION_MINOR_MAX;
    public static final int LSG_VERSION_MINOR_MIN;
    public int lsgVersion_minor;

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
        this.lsgClass = 49;
        this.lsgSubClass = 0;
        this.lsgVersion_major = 3;
        this.lsgVersion_minor = 1;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        BAP_Config_Status bAP_Config_Status = (BAP_Config_Status)bAPEntity;
        return this.bap_Version_major == bAP_Config_Status.bap_Version_major && this.bap_Version_minor == bAP_Config_Status.bap_Version_minor && this.lsgClass == bAP_Config_Status.lsgClass && this.lsgSubClass == bAP_Config_Status.lsgSubClass && this.lsgVersion_major == bAP_Config_Status.lsgVersion_major && this.lsgVersion_minor == bAP_Config_Status.lsgVersion_minor;
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
        bitStream.pushByte((byte)this.lsgClass);
        bitStream.pushByte((byte)this.lsgSubClass);
        bitStream.pushByte((byte)this.lsgVersion_major);
        bitStream.pushByte((byte)this.lsgVersion_minor);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 2;
    }

    @Override
    public int getFunctionId() {
        return BAP_Config_Status.functionId();
    }
}

