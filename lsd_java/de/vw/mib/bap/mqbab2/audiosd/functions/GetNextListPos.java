/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.audiosd.functions;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.Method;
import de.vw.mib.bap.functions.MethodListener;
import de.vw.mib.bap.mqbab2.audiosd.api.ASLAudioSDConstants;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayList;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayListComplete;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayListWindowed;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.GetNextListPos_Result;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.GetNextListPos_StartResult;

public final class GetNextListPos
extends Function
implements Method,
ASLAudioSDConstants {
    private static final int NEXT_POSITION_IS_UNKNOWN;
    private static final int CURRENT_POSITION_MAX_VALUE;
    private static final int MIN_BAP_ID;
    private int numberOfSourceListElements = 0;
    private FsgArrayListComplete fullReceptionList = null;
    private FsgArrayListComplete fullRadioTVPresetList = null;
    private FsgArrayListComplete fullTPMemoList = null;
    private FsgArrayListWindowed _currentMediaBrowserArrayList;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$GetNextListPos_Result;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        return null;
    }

    protected GetNextListPos_Result dequeueBAPEntity() {
        return (GetNextListPos_Result)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$GetNextListPos_Result == null ? (class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$GetNextListPos_Result = GetNextListPos.class$("de.vw.mib.bap.mqbab2.generated.audiosd.serializer.GetNextListPos_Result")) : class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$GetNextListPos_Result);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
        switch (bAPStage.getFunctionId()) {
            case 27: {
                this.setFullTPMemoList((FsgArrayListComplete)object);
                break;
            }
            case 32: {
                this.setNumberOfSourceListElements((Integer)object);
                break;
            }
            case 23: {
                this.setFullReceptionList((FsgArrayListComplete)object);
                break;
            }
            case 33: {
                this.setFullPresetList((FsgArrayListComplete)object);
                break;
            }
            case 36: {
                this.setCurrentMediaBrowserArrayList((FsgArrayListWindowed)object);
                break;
            }
        }
    }

    @Override
    public int getFunctionId() {
        return 44;
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
            int n3;
            GetNextListPos_Result getNextListPos_Result = this.dequeueBAPEntity();
            getNextListPos_Result.currentPos = getNextListPos_StartResult.currentPos;
            switch (getNextListPos_StartResult.listType) {
                case 0: 
                case 1: 
                case 3: 
                case 4: {
                    FsgArrayList fsgArrayList = getNextListPos_StartResult.listType == 3 ? this.fullRadioTVPresetList : (getNextListPos_StartResult.listType == 0 ? this.fullReceptionList : (getNextListPos_StartResult.listType == 1 ? this.fullTPMemoList : (getNextListPos_StartResult.listType == 4 ? this.getCurrentMediaBrowserArrayList() : null)));
                    n3 = -1;
                    n2 = -1;
                    if (fsgArrayList != null) {
                        n3 = fsgArrayList.nextBapPosID(getNextListPos_StartResult.currentPos, getNextListPos_StartResult.offset);
                        if (n3 != 0) {
                            n2 = fsgArrayList.getIndexOfBapPosId(n3);
                            n2 = n2 != -1 ? n2 + 1 : n2;
                        } else {
                            n3 = -1;
                            n2 = -1;
                        }
                        n = fsgArrayList.getSize();
                        break;
                    }
                    n = 0;
                    break;
                }
                case 2: {
                    n2 = n3 = getNextListPos_StartResult.currentPos + getNextListPos_StartResult.offset;
                    n = this.numberOfSourceListElements;
                    break;
                }
                default: {
                    n2 = n3 = -1;
                    n = -1;
                }
            }
            if (n3 < 0 || n2 > n) {
                n3 = -1;
                getNextListPos_Result.nextPos = -1;
                getNextListPos_Result.absoluteListPos = -1;
                getNextListPos_Result.getNextListPos_Result = 1;
            } else {
                getNextListPos_Result.nextPos = n3;
                getNextListPos_Result.absoluteListPos = n2;
                getNextListPos_Result.getNextListPos_Result = n3 != -1 ? 0 : 1;
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
    }

    private static boolean inputParametersValid(GetNextListPos_StartResult getNextListPos_StartResult) {
        boolean bl;
        switch (getNextListPos_StartResult.listType) {
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 4: {
                bl = true;
                break;
            }
            default: {
                bl = false;
            }
        }
        return bl && getNextListPos_StartResult.currentPos <= -16842752;
    }

    protected void setNumberOfSourceListElements(Integer n) {
        this.numberOfSourceListElements = n;
    }

    protected void setFullReceptionList(FsgArrayListComplete fsgArrayListComplete) {
        this.fullReceptionList = fsgArrayListComplete;
    }

    protected void setFullPresetList(FsgArrayListComplete fsgArrayListComplete) {
        this.fullRadioTVPresetList = fsgArrayListComplete;
    }

    protected void setFullTPMemoList(FsgArrayListComplete fsgArrayListComplete) {
        this.fullTPMemoList = fsgArrayListComplete;
    }

    protected void setCurrentMediaBrowserArrayList(FsgArrayListWindowed fsgArrayListWindowed) {
        this._currentMediaBrowserArrayList = fsgArrayListWindowed;
    }

    private FsgArrayListWindowed getCurrentMediaBrowserArrayList() {
        return this._currentMediaBrowserArrayList;
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

