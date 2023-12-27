/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.sdssd.controller;

import de.vw.mib.bap.marshalling.BAPFunctionRegistry;
import de.vw.mib.bap.marshalling.BAPIndicationMarshaller;
import de.vw.mib.bap.marshalling.BAPServiceListener;
import de.vw.mib.bap.mqbab2.common.HsmContextDelegate;
import de.vw.mib.bap.mqbab2.common.api.BAPFunctionControlUnitExt;
import de.vw.mib.bap.mqbab2.common.api.adapter.AbstractBAPDataPool;
import de.vw.mib.bap.mqbab2.common.controller.GenericFunctionControlUnit;
import de.vw.mib.bap.mqbab2.generated.sdssd.BAPSDSSDDataPool;
import de.vw.mib.bap.mqbab2.generated.sdssd.SDSSDBindingFactory;
import de.vw.mib.bap.mqbab2.generated.sdssd.SDSSDDemarshaller;
import de.vw.mib.bap.mqbab2.generated.sdssd.SDSSDMarshaller;
import de.vw.mib.bap.mqbab2.sdssd.functions.SDSSDBindingFactoryAll;
import de.vw.mib.bap.mqbab2.sdssd.states.SDSSDHsmContextDelegate;

class SDSSDFunctionControlUnit
extends GenericFunctionControlUnit
implements BAPFunctionControlUnitExt {
    private final HsmContextDelegate _contextDelegate;
    private BAPIndicationMarshaller _sdsSdMarhaller;
    private BAPServiceListener _sdsSdDemarshaller;
    private BAPSDSSDDataPool _dataPool;
    private SDSSDBindingFactory _sdsSdBindingFactory;

    public SDSSDFunctionControlUnit(SDSSDHsmContextDelegate sDSSDHsmContextDelegate) {
        super(sDSSDHsmContextDelegate);
        this._contextDelegate = sDSSDHsmContextDelegate;
    }

    @Override
    protected HsmContextDelegate getContextDelegate() {
        return this._contextDelegate;
    }

    private SDSSDBindingFactory getBindingFactory() {
        if (this._sdsSdBindingFactory == null) {
            this._sdsSdBindingFactory = new SDSSDBindingFactoryAll();
        }
        return this._sdsSdBindingFactory;
    }

    @Override
    protected void resetBindingFactory() {
        this._sdsSdBindingFactory = null;
        if (this.isInitialized()) {
            this.getSDSSDFunctionRegistry().uninitialize();
            this.getSDSSDFunctionRegistry().setFactory(this.getBindingFactory());
            this.getSDSSDFunctionRegistry().initialize();
        } else {
            this.getSDSSDFunctionRegistry().setFactory(this.getBindingFactory());
        }
    }

    @Override
    public BAPIndicationMarshaller getBAPMarshaller() {
        if (this._sdsSdMarhaller == null) {
            this._sdsSdMarhaller = new SDSSDMarshaller(this.getBAPServiceProxy(), this.getBitStreamTransformer());
        }
        return this._sdsSdMarhaller;
    }

    @Override
    public AbstractBAPDataPool getContextDataPool() {
        return this.getSDSSDFunctionRegistry();
    }

    @Override
    public BAPServiceListener getBAPDemarshaller() {
        if (this._sdsSdDemarshaller == null) {
            this._sdsSdDemarshaller = new SDSSDDemarshaller(this.getContextDataPool(), this.getContextDataPool(), this.getBitStreamTransformer());
        }
        return this._sdsSdDemarshaller;
    }

    @Override
    public BAPFunctionRegistry getFunctionRegistry() {
        return this.getSDSSDFunctionRegistry();
    }

    private BAPSDSSDDataPool getSDSSDFunctionRegistry() {
        if (this._dataPool == null) {
            this._dataPool = new BAPSDSSDDataPool(this.getContextDelegate());
            this._dataPool.setFactory(this.getBindingFactory());
        }
        return this._dataPool;
    }

    @Override
    public void reinitialize() {
        this.getSDSSDFunctionRegistry().reinitialize();
    }

    @Override
    public void uninitialize() {
    }

    @Override
    public String getLogicalControlUnitName() {
        return "SDS_SD";
    }

    @Override
    public int getLogicalControlUnitID() {
        return 70;
    }
}

