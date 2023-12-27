/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.telephone.functions;

import de.vw.mib.bap.array.requests.BAPGetArray;
import de.vw.mib.bap.array.requests.BAPSetGetArray;
import de.vw.mib.bap.array.requests.BAPStatusArray;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.Array;
import de.vw.mib.bap.functions.ArrayListener;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageContext;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;

public class GenericEmptyArray
implements BAPStage,
Array {
    private final Class _bapStatusArrayClass;
    private final int _fctId;

    public GenericEmptyArray(Class clazz, int n) {
        this._bapStatusArrayClass = clazz;
        this._fctId = n;
    }

    @Override
    public void initialize(boolean bl) {
    }

    @Override
    public void uninitialize() {
    }

    @Override
    public int getFunctionId() {
        return this._fctId;
    }

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        return null;
    }

    @Override
    public void setDelegate(BAPStageContext bAPStageContext) {
    }

    @Override
    public boolean hmiEvent(int n) {
        return false;
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
    }

    @Override
    public void process(int n) {
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
    public void getArray(BAPEntity bAPEntity, ArrayListener arrayListener) {
        arrayListener.statusArray(this.createStatusArray((BAPGetArray)bAPEntity), this);
    }

    @Override
    public void setGetArray(BAPEntity bAPEntity, ArrayListener arrayListener) {
        arrayListener.statusArray(this.createStatusArray((BAPSetGetArray)bAPEntity), this);
    }

    private BAPStatusArray createStatusArray(BAPGetArray bAPGetArray) {
        BAPStatusArray bAPStatusArray;
        try {
            bAPStatusArray = (BAPStatusArray)this._bapStatusArrayClass.newInstance();
        }
        catch (Exception exception) {
            throw new RuntimeException(exception);
        }
        bAPStatusArray.setAsgId(bAPGetArray.getAsgId());
        bAPStatusArray.setTransactionId(bAPGetArray.getTransactionId());
        bAPStatusArray.setArrayHeader(bAPGetArray.getArrayHeader());
        bAPStatusArray.getArrayHeader().elements = 0;
        return bAPStatusArray;
    }
}

