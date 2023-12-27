/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.telephone2.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class PhoneModuleState_Status
implements StatusProperty {
    public int moduleState;
    public static final int MODULE_STATE_PHONE_MODULE_NOT_INSTALLED;
    public static final int MODULE_STATE_PHONE_MODULE_OFF;
    public static final int MODULE_STATE_PHONE_MODULE_ON;
    public static final int MODULE_STATE_PHONE_MODULE_SWITCHING_OFF;
    public static final int MODULE_STATE_PHONE_MODULE_SWITCHING_ON;
    public static final int MODULE_STATE_PHONE_MODULE_NOT_FUNCTIONAL;
    public static final int MODULE_STATE_PHONE_MODULE_OFF_HIGH_TEMPERATURE;
    public int moduleSupportedServices;
    public static final int MODULE_SUPPORTED_SERVICES_INVALID_UNKNOWN;
    public static final int MODULE_SUPPORTED_SERVICES_TELEPHONE_AND_DATA_SERVICE_SUPPORTED;
    public static final int MODULE_SUPPORTED_SERVICES_TELEPHONE_ONLY_SUPPORTED;
    public static final int MODULE_SUPPORTED_SERVICES_DATA_SERVICE_ONLY_SUPPORTED;
    public int moduleActiveServices;
    public static final int MODULE_ACTIVE_SERVICES_I_HW_IS_NOT_BEING_USED;
    public static final int MODULE_ACTIVE_SERVICES_HW_IS_BEING_USED_FOR_TELEPHONY_AND_DATA_SERVICE;
    public static final int MODULE_ACTIVE_SERVICES_HW_IS_BEING_USED_FOR_TELEPHONY;
    public static final int MODULE_ACTIVE_SERVICES_HW_IS_BEING_USED_FOR_DATA_SERVICE;
    public int simstate;
    public static final int SIM_STATE_INVALID_UNKNOWN;
    public static final int SIM_STATE_NO_SIM_INSERTED;
    public static final int SIM_STATE_SIM_INSERTED;
    public static final int EXTENSION_1_MIN;
    public int extension_1;

    public PhoneModuleState_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public PhoneModuleState_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.moduleState = 0;
        this.moduleSupportedServices = 0;
        this.moduleActiveServices = 0;
        this.simstate = 0;
        this.extension_1 = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        PhoneModuleState_Status phoneModuleState_Status = (PhoneModuleState_Status)bAPEntity;
        return this.moduleState == phoneModuleState_Status.moduleState && this.moduleSupportedServices == phoneModuleState_Status.moduleSupportedServices && this.moduleActiveServices == phoneModuleState_Status.moduleActiveServices && this.simstate == phoneModuleState_Status.simstate && this.extension_1 == phoneModuleState_Status.extension_1;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "PhoneModuleState_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.moduleState);
        bitStream.pushByte((byte)this.moduleSupportedServices);
        bitStream.pushByte((byte)this.moduleActiveServices);
        bitStream.pushByte((byte)this.simstate);
        bitStream.pushByte((byte)this.extension_1);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 23;
    }

    @Override
    public int getFunctionId() {
        return PhoneModuleState_Status.functionId();
    }
}

