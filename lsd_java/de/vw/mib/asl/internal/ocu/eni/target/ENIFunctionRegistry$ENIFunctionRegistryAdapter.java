/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.eni.target;

import de.vw.mib.asl.internal.ocu.eni.target.ENIFunctionRegistry$ENIFunctionRegistryAdapter$1;
import de.vw.mib.asl.internal.ocu.eni.target.ENIFunctionRegistry$FunctionRegistryAdapter;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.ArrayListener;
import de.vw.mib.bap.functions.BAPFunctionList;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.MethodListener;
import de.vw.mib.bap.functions.PropertyListener;
import de.vw.mib.bap.marshalling.BAPRequestMarshaller;
import de.vw.mib.log4mib.Logger;

class ENIFunctionRegistry$ENIFunctionRegistryAdapter
implements ENIFunctionRegistry$FunctionRegistryAdapter {
    private final BAPRequestMarshaller _bapMarshaller;
    private final BAPFunctionList _functionList;
    private final Logger _logger;
    private int _fctID;

    public ENIFunctionRegistry$ENIFunctionRegistryAdapter(BAPRequestMarshaller bAPRequestMarshaller, BAPFunctionList bAPFunctionList, Logger logger) {
        this._bapMarshaller = bAPRequestMarshaller;
        this._functionList = bAPFunctionList;
        this._logger = logger;
    }

    private BAPRequestMarshaller getBapMarshaller() {
        return this._bapMarshaller;
    }

    private BAPFunctionList getFunctionList() {
        return this._functionList;
    }

    Logger getLogger() {
        return this._logger;
    }

    private void setFctID(int n) {
        this._fctID = n;
    }

    int getFctID() {
        return this._fctID;
    }

    public ENIFunctionRegistry$FunctionRegistryAdapter getRegistryAdapter(int n) {
        ENIFunctionRegistry$FunctionRegistryAdapter eNIFunctionRegistry$FunctionRegistryAdapter;
        if (this.getFunctionList().containsFunction(n)) {
            this.setFctID(n);
            eNIFunctionRegistry$FunctionRegistryAdapter = this;
        } else {
            eNIFunctionRegistry$FunctionRegistryAdapter = new ENIFunctionRegistry$ENIFunctionRegistryAdapter$1(this);
        }
        return eNIFunctionRegistry$FunctionRegistryAdapter;
    }

    @Override
    public void indicationError(int n, BAPFunctionListener bAPFunctionListener) {
        throw new UnsupportedOperationException("indicationError not supported in ASG");
    }

    @Override
    public void getProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        this.getBapMarshaller().getEntity(this.getFctID(), bAPEntity);
    }

    @Override
    public void setGetProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        this.getBapMarshaller().setGetEntity(this.getFctID(), bAPEntity);
    }

    @Override
    public void ackProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        this.getBapMarshaller().ackEntity(this.getFctID(), bAPEntity);
    }

    @Override
    public void startResult(BAPEntity bAPEntity, MethodListener methodListener) {
        this.getBapMarshaller().startResult(this.getFctID(), bAPEntity);
    }

    @Override
    public void abortResult(BAPEntity bAPEntity, MethodListener methodListener) {
        this.getBapMarshaller().abortResult(this.getFctID(), bAPEntity);
    }

    @Override
    public void getArray(BAPEntity bAPEntity, ArrayListener arrayListener) {
        this.getBapMarshaller().getEntity(this.getFctID(), bAPEntity);
    }

    @Override
    public void setGetArray(BAPEntity bAPEntity, ArrayListener arrayListener) {
        this.getBapMarshaller().setGetEntity(this.getFctID(), bAPEntity);
    }

    @Override
    public void requestAcknowledge() {
        throw new UnsupportedOperationException("requestAcknowledge not supported in ASG");
    }

    @Override
    public void errorAcknowledge() {
        throw new UnsupportedOperationException("errorAcknowledge not supported in ASG");
    }
}

