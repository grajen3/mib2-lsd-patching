/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StartResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class RG_ActDeact_StartResult
implements StartResultMethod {
    public int controlType;
    private static final int CONTROL_TYPE_BITSIZE;
    public static final int CONTROL_TYPE_START_ROUTE_GUIDANCE;
    public static final int CONTROL_TYPE_STOP_ROUTE_GUIDANCE;
    public static final int CONTROL_TYPE_SUSPEND_ROUTE_GUIDANCE_DF4_1;
    public static final int CONTROL_TYPE_RESUME_ROUTE_GUIDANCE_DF4_1;
    public int ci_Type;
    private static final int CI_TYPE_BITSIZE;
    public static final int CI_TYPE_INVALID;
    public static final int CI_TYPE_LAST_DESTINATIONS_LIST_FUNCTION_0X1D;
    public static final int CI_TYPE_FAVORITE_DESTINATIONS_LIST_FUNCTION_0X1E;
    public static final int CI_TYPE_TEL_ADDRESSBOOK_DEFAULT_ADDRESS;
    public static final int CI_TYPE_HOME_HOME_ADDRESS;
    public static final int CI_TYPE_NAV_BOOK_FUNCTION_0X20;
    public static final int CI_TYPE_SEMIDYNAMIC_ROUTE_DF4_1;
    public static final int CI_TYPE_POI_LIST_DF4_1;
    public int controlInformation;

    public RG_ActDeact_StartResult() {
        this.internalReset();
        this.customInitialization();
    }

    public RG_ActDeact_StartResult(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.controlType = 0;
        this.ci_Type = 0;
        this.controlInformation = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        RG_ActDeact_StartResult rG_ActDeact_StartResult = (RG_ActDeact_StartResult)bAPEntity;
        return this.controlType == rG_ActDeact_StartResult.controlType && this.ci_Type == rG_ActDeact_StartResult.ci_Type && this.controlInformation == rG_ActDeact_StartResult.controlInformation;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "RG_ActDeact_StartResult:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.controlType = bitStream.popFrontBits(4);
        this.ci_Type = bitStream.popFrontBits(4);
        this.controlInformation = bitStream.popFrontShort();
    }

    public static int functionId() {
        return 34;
    }

    @Override
    public int getFunctionId() {
        return RG_ActDeact_StartResult.functionId();
    }
}

