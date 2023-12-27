/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.ResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class RG_ActDeact_Result
implements ResultMethod {
    public int rg_ActDeact_Result;
    public static final int RG_ACT_DEACT_RESULT_SUCCESSFUL;
    public static final int RG_ACT_DEACT_RESULT_NOT_SUCCESSFUL;
    public static final int RG_ACT_DEACT_RESULT_ABORT_SUCCESSFUL;
    public static final int RG_ACT_DEACT_RESULT_ABORT_NOT_SUCCESSFUL;
    public static final int RG_ACT_DEACT_RESULT_RG_NOT_ACTIVE;
    public static final int RG_ACT_DEACT_RESULT_RG_ALREADY_ACTIVE;
    public static final int RG_ACT_DEACT_RESULT_NOT_SUCCESSFUL_CONTROL_INFORMATION_DOES_NOT_MATCH_TO_FSG_INTERNAL_DESTINATION;
    public static final int RG_ACT_DEACT_RESULT_NOT_SUCCESSFUL_DESTINATION_ADDRESS_NEEDS_TO_BE_REFINED_DETAILED_AT_HEAD_UNIT;
    public static final int RG_ACT_DEACT_RESULT_NOT_SUCCESSFUL_HOME_ADDRESS_NOT_SPECIFIED_IN_FSG;
    public static final int RG_ACT_DEACT_RESULT_NOT_SUCCESSFUL_SELECT_ROUTE_AT_FSG;
    public static final int RG_ACT_DEACT_RESULT_NOT_SUCCESSFUL_SELECT_HOME_ADDRESS_AT_FSG;
    public static final int RG_ACT_DEACT_RESULT_NOT_SUCCESSFUL_NO_NAVIGATION_DATA_AVAILABLE;
    public static final int RG_ACT_DEACT_RESULT_NOT_SUCCESSFUL_NO_SEMI_DYNAMIC_ROUTE_AVAILABLE_DF4_1;
    public static final int RG_ACT_DEACT_RESULT_NOT_SUCCESSFUL_SELECT_SEMI_DYNAMIC_ROUTE_AT_FSG;

    @Override
    public int getResultCode() {
        return this.rg_ActDeact_Result;
    }

    public RG_ActDeact_Result() {
        this.internalReset();
        this.customInitialization();
    }

    public RG_ActDeact_Result(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.rg_ActDeact_Result = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        RG_ActDeact_Result rG_ActDeact_Result = (RG_ActDeact_Result)bAPEntity;
        return this.rg_ActDeact_Result == rG_ActDeact_Result.rg_ActDeact_Result;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "RG_ActDeact_Result:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.rg_ActDeact_Result);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 34;
    }

    @Override
    public int getFunctionId() {
        return RG_ActDeact_Result.functionId();
    }
}

