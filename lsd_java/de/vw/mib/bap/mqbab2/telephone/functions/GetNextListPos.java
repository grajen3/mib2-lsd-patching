/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.telephone.functions;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.Method;
import de.vw.mib.bap.functions.MethodListener;
import de.vw.mib.bap.mqbab2.common.api.addressbook.AddressbookService;
import de.vw.mib.bap.mqbab2.common.api.addressbook.AddressbookServiceListener;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.GetNextListPos_Result;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.GetNextListPos_StartResult;
import de.vw.mib.bap.mqbab2.telephone.api.ASLTelephoneConstants;

public final class GetNextListPos
extends Function
implements Method,
ASLTelephoneConstants,
AddressbookServiceListener {
    private static final int NEXT_POSITION_IS_UNKNOWN;
    private static final int CURRENT_POSITION_MAX_VALUE;
    protected static final int[] ADDRESSBOOK_LISTENER_IDS;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$GetNextListPos_Result;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getAddressbookService().addAddressbookServiceListener(this, ADDRESSBOOK_LISTENER_IDS);
        return null;
    }

    protected GetNextListPos_Result dequeueBAPEntity() {
        return (GetNextListPos_Result)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$GetNextListPos_Result == null ? (class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$GetNextListPos_Result = GetNextListPos.class$("de.vw.mib.bap.mqbab2.generated.telephone.serializer.GetNextListPos_Result")) : class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$GetNextListPos_Result);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
    }

    @Override
    public int getFunctionId() {
        return 54;
    }

    @Override
    public void process(int n) {
    }

    @Override
    public void abortResult(BAPEntity bAPEntity, MethodListener methodListener) {
        methodListener.requestError(80, this);
    }

    @Override
    public void startResult(BAPEntity bAPEntity, MethodListener methodListener) {
        GetNextListPos_StartResult getNextListPos_StartResult = (GetNextListPos_StartResult)bAPEntity;
        if (GetNextListPos.inputParametersValid(getNextListPos_StartResult)) {
            GetNextListPos_Result getNextListPos_Result = this.dequeueBAPEntity();
            getNextListPos_Result.currentPos = getNextListPos_StartResult.currentPos;
            switch (getNextListPos_StartResult.listType) {
                case 0: {
                    int n = getNextListPos_StartResult.currentPos + getNextListPos_StartResult.offset;
                    if (n < 0 || n > this.getAddressbookService().getPhoneBookNumberOEntries()) {
                        getNextListPos_Result.nextPos = -1;
                        getNextListPos_Result.absoluteListPos = -1;
                        getNextListPos_Result.getNextListPos_Result = 1;
                        break;
                    }
                    getNextListPos_Result.nextPos = n;
                    getNextListPos_Result.absoluteListPos = n;
                    getNextListPos_Result.getNextListPos_Result = 0;
                    break;
                }
                default: {
                    getNextListPos_Result.nextPos = -1;
                    getNextListPos_Result.absoluteListPos = -1;
                    getNextListPos_Result.getNextListPos_Result = 1;
                }
            }
            this.getDelegate().getMethodListener(this).result(getNextListPos_Result, this);
        } else {
            methodListener.requestError(65, this);
        }
    }

    @Override
    public void indicationError(int n, BAPFunctionListener bAPFunctionListener) {
    }

    @Override
    public void requestAcknowledge() {
    }

    @Override
    public void errorAcknowledge() {
    }

    @Override
    public void initialize(boolean bl) {
    }

    @Override
    public void uninitialize() {
        this.getAddressbookService().removeAddressbookServiceListener(this, ADDRESSBOOK_LISTENER_IDS);
    }

    private static boolean inputParametersValid(GetNextListPos_StartResult getNextListPos_StartResult) {
        return getNextListPos_StartResult.listType == 0 && getNextListPos_StartResult.currentPos <= -16842752;
    }

    @Override
    public void processHMIEvent(int n) {
    }

    @Override
    public void updateAddressbookData(AddressbookService addressbookService, int n) {
        this.process(-1);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        ADDRESSBOOK_LISTENER_IDS = new int[]{1108};
    }
}

