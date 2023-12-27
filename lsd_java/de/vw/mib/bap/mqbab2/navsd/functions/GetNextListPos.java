/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.navsd.functions;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.Method;
import de.vw.mib.bap.functions.MethodListener;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.GetNextListPos_Result;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.GetNextListPos_StartResult;
import de.vw.mib.bap.mqbab2.navsd.api.ASLNavSDConstants;
import java.util.Iterator;

public final class GetNextListPos
extends Function
implements Method,
ASLNavSDConstants {
    private static final int NEXT_POSITION_IS_UNKNOWN;
    private static final int CURRENT_POSITION_MAX_VALUE;
    private int numberOfAddressListEntries = 0;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$GetNextListPos_Result;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        return null;
    }

    protected GetNextListPos_Result dequeueBAPEntity() {
        return (GetNextListPos_Result)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$GetNextListPos_Result == null ? (class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$GetNextListPos_Result = GetNextListPos.class$("de.vw.mib.bap.mqbab2.generated.navsd.serializer.GetNextListPos_Result")) : class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$GetNextListPos_Result);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
        switch (bAPStage.getFunctionId()) {
            case 33: {
                this.setNumberOfAddressListEntries((Integer)object);
                break;
            }
        }
    }

    @Override
    public int getFunctionId() {
        return 41;
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
            int n;
            int n2;
            GetNextListPos_Result getNextListPos_Result = this.dequeueBAPEntity();
            getNextListPos_Result.currentPos = getNextListPos_StartResult.currentPos;
            switch (getNextListPos_StartResult.listType) {
                case 3: {
                    n2 = getNextListPos_StartResult.currentPos + getNextListPos_StartResult.offset;
                    n = this.numberOfAddressListEntries;
                    break;
                }
                case 1: {
                    n2 = getNextListPos_StartResult.currentPos + getNextListPos_StartResult.offset;
                    n = this.getNavigationService().getFavoriteDestinationsNumberOfEntries();
                    break;
                }
                case 0: {
                    n2 = getNextListPos_StartResult.currentPos + getNextListPos_StartResult.offset;
                    int n3 = 0;
                    Iterator iterator = this.getNavigationService().getLastDestinations();
                    while (iterator.hasNext()) {
                        iterator.next();
                        ++n3;
                    }
                    n = n3;
                    break;
                }
                case 2: {
                    n2 = getNextListPos_StartResult.currentPos + getNextListPos_StartResult.offset;
                    n = this.getAddressbookService().getNavBookNumberOfEntries();
                    break;
                }
                default: {
                    n2 = -1;
                    n = 0;
                }
            }
            if (n2 < 0 || n2 > n) {
                n2 = -1;
                getNextListPos_Result.nextPos = -1;
                getNextListPos_Result.absoluteListPos = -1;
                getNextListPos_Result.getNextListPos_Result = 1;
            } else {
                getNextListPos_Result.nextPos = n2;
                getNextListPos_Result.absoluteListPos = n2;
                getNextListPos_Result.getNextListPos_Result = 0;
            }
            methodListener.result(getNextListPos_Result, this);
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
    }

    private static boolean inputParametersValid(GetNextListPos_StartResult getNextListPos_StartResult) {
        boolean bl;
        switch (getNextListPos_StartResult.listType) {
            case 0: 
            case 1: 
            case 2: 
            case 3: {
                bl = true;
                break;
            }
            default: {
                bl = false;
            }
        }
        return bl && getNextListPos_StartResult.currentPos <= -16842752;
    }

    protected void setNumberOfAddressListEntries(Integer n) {
        this.numberOfAddressListEntries = n;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

