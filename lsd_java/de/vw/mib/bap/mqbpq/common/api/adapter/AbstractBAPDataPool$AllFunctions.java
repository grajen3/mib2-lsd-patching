/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.common.api.adapter;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.Array;
import de.vw.mib.bap.functions.ArrayListener;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.Method;
import de.vw.mib.bap.functions.MethodListener;
import de.vw.mib.bap.functions.Property;
import de.vw.mib.bap.functions.PropertyListener;
import de.vw.mib.bap.mqbpq.common.HsmContextDelegate;

class AbstractBAPDataPool$AllFunctions
implements Property,
Method,
Array {
    private final int _fctID;
    private final HsmContextDelegate _delegate;

    public AbstractBAPDataPool$AllFunctions(int n, HsmContextDelegate hsmContextDelegate) {
        this._fctID = n;
        this._delegate = hsmContextDelegate;
    }

    private void error(String string) {
        this._delegate.getLogger().error(this._delegate.getSubClassifier()).append(string).append(" with fctID = ").append(this._fctID).append(" could not be processed, because function does not exists").log();
    }

    @Override
    public void requestAcknowledge() {
        this.error("requestAcknowledge");
    }

    @Override
    public void indicationError(int n, BAPFunctionListener bAPFunctionListener) {
        this.error("indicationError");
    }

    @Override
    public void errorAcknowledge() {
        this.error("errorAcknowledge");
    }

    @Override
    public void getProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        this.error("getProperty");
    }

    @Override
    public void setGetProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        this.error("setGetProperty");
    }

    @Override
    public void ackProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        this.error("ackProperty");
    }

    @Override
    public void startResult(BAPEntity bAPEntity, MethodListener methodListener) {
        this.error("startResult");
    }

    @Override
    public void abortResult(BAPEntity bAPEntity, MethodListener methodListener) {
        this.error("abortResult");
    }

    @Override
    public void getArray(BAPEntity bAPEntity, ArrayListener arrayListener) {
        this.error("getArray");
    }

    @Override
    public void setGetArray(BAPEntity bAPEntity, ArrayListener arrayListener) {
        this.error("setGetArray");
    }
}

