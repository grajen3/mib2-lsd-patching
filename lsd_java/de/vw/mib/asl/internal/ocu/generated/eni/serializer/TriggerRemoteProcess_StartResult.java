/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.generated.eni.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.requests.StartResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class TriggerRemoteProcess_StartResult
implements StartResultMethod {
    public int commandType;
    public static final int COMMAND_TYPE_LOGBOOK_TRIP_CONTROL_DF3_6;
    public static final int COMMAND_TYPE_CONFIRM_FO_D_DEACTIVATION_DF3_6;
    public static final int COMMAND_TYPE_CONFIRM_FO_D_ACTIVATION_DF3_6;
    public static final int COMMAND_TYPE_SUBMIT_CHANGES_TO_BACKEND_DF3_6;
    public static final int COMMAND_TYPE_CONFIRM_WITHDRAWN_UPDATE_DF3_6;
    public static final int COMMAND_TYPE_SIGN_UP_AS_MY_AUDI_VW_CAR_NET_VW_FLEET_USER_PAIRING_CODE_DF3_6;
    public static final int COMMAND_TYPE_SIGN_UP_AS_MY_AUDI_VW_CAR_NET_VW_FLEET_USER_PASSWORD_DF3_6;
    public static final int COMMAND_TYPE_CONFIRM_UPDATE_ERROR_DF3_6;
    public static final int COMMAND_TYPE_CONFIRM_ECU_UPDATE_FINISHED_SUCCESSFULLY_DF3_6;
    public static final int COMMAND_TYPE_GET_CHALLENGE_DF3_6;
    public static final int COMMAND_TYPE_DEACTIVATE_ACTIVATE_PRIVACY_MODE_DF3_5;
    public static final int COMMAND_TYPE_DEACTIVATE_ACTIVATE_RADIO_MODULE_DF3_5;
    public static final int COMMAND_TYPE_REQUEST_NEW_LANGUAGE_DF3_4;
    public static final int COMMAND_TYPE_POSTPONE_ECU_UPDATE_DF3_4;
    public static final int COMMAND_TYPE_REJECT_ECU_UPDATE_DF3_4;
    public static final int COMMAND_TYPE_CONFIRM_ECU_UPDATE_DF3_4;
    public static final int COMMAND_TYPE_AUTHENTICATE_MAIN_USER_S_PIN_DF3_4;
    public static final int COMMAND_TYPE_POSTPONE_ONLINE_UPDATE_DOWNLOAD_DF3_4;
    public static final int COMMAND_TYPE_REJECT_ONLINE_UPDATE_DOWNLOAD_DF3_4;
    public static final int COMMAND_TYPE_CONFIRM_ONLINE_UPDATE_DOWNLOAD_DF3_4;
    public static final int COMMAND_TYPE_GET_V_TAN_DF3_4;
    public static final int COMMAND_TYPE_GET_MOBILE_DEVICE_KEY_COUNT_DF3_4;
    public static final int COMMAND_TYPE_TERMINATE_REMOTE_PROCESS;
    public static final int COMMAND_TYPE_CONFIRM_SERVICE_EXPIRY_WARNING;
    public static final int COMMAND_TYPE_PAIR_MAIN_USER_VEHICLE_PIN;
    public static final int COMMAND_TYPE_PAIR_MAIN_USER_PAIRING_CODE;
    public static final int COMMAND_TYPE_REMOTE_DELETE_USER_LIST;
    public static final int COMMAND_TYPE_REMOTE_UPDATE_USER_LIST;
    public int param1;
    public static final int PARAM1_MIN;
    public final BAPString param2 = new BAPString(243);
    private static final int MAX_PARAM2_LENGTH;
    public final BAPString param3 = new BAPString(101);
    private static final int MAX_PARAM3_LENGTH;

    public TriggerRemoteProcess_StartResult() {
        this.internalReset();
        this.customInitialization();
    }

    public TriggerRemoteProcess_StartResult(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.commandType = 0;
        this.param1 = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.param2.reset();
        this.param3.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        TriggerRemoteProcess_StartResult triggerRemoteProcess_StartResult = (TriggerRemoteProcess_StartResult)bAPEntity;
        return this.commandType == triggerRemoteProcess_StartResult.commandType && this.param1 == triggerRemoteProcess_StartResult.param1 && this.param2.equalTo(triggerRemoteProcess_StartResult.param2) && this.param3.equalTo(triggerRemoteProcess_StartResult.param3);
    }

    private void customInitialization() {
        this.param3.setRawContent();
    }

    @Override
    public String toString() {
        return "TriggerRemoteProcess_StartResult:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.commandType);
        bitStream.pushShort((short)this.param1);
        this.param2.serialize(bitStream);
        this.param3.serialize(bitStream);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.commandType = bitStream.popFrontByte();
        this.param1 = bitStream.popFrontShort();
        this.param2.deserialize(bitStream);
        this.param3.deserialize(bitStream);
    }

    public static int functionId() {
        return 18;
    }

    @Override
    public int getFunctionId() {
        return TriggerRemoteProcess_StartResult.functionId();
    }
}

