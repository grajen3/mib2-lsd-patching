/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.telephone2.controller;

import de.vw.mib.bap.marshalling.BAPFunctionRegistry;
import de.vw.mib.bap.marshalling.BAPIndicationMarshaller;
import de.vw.mib.bap.marshalling.BAPServiceListener;
import de.vw.mib.bap.mqbab2.common.HsmContextDelegate;
import de.vw.mib.bap.mqbab2.common.api.BAPFunctionControlUnitExt;
import de.vw.mib.bap.mqbab2.common.api.adapter.AbstractBAPDataPool;
import de.vw.mib.bap.mqbab2.common.controller.GenericFunctionControlUnit;
import de.vw.mib.bap.mqbab2.generated.telephone2.BAPTelephone2DataPool;
import de.vw.mib.bap.mqbab2.generated.telephone2.Telephone2BindingFactory;
import de.vw.mib.bap.mqbab2.generated.telephone2.Telephone2Demarshaller;
import de.vw.mib.bap.mqbab2.generated.telephone2.Telephone2Marshaller;
import de.vw.mib.bap.mqbab2.telephone2.functions.Telephone2BindingFactoryAll;
import de.vw.mib.bap.mqbab2.telephone2.states.Telephone2HsmContextDelegate;

class Telephone2FunctionControlUnit
extends GenericFunctionControlUnit
implements BAPFunctionControlUnitExt {
    private final HsmContextDelegate _contextDelegate;
    private BAPIndicationMarshaller _telephone2Marhaller;
    private BAPServiceListener _telephone2Demarshaller;
    private BAPTelephone2DataPool _dataPool;
    private Telephone2BindingFactory _telephone2BindingFactory;

    public Telephone2FunctionControlUnit(Telephone2HsmContextDelegate telephone2HsmContextDelegate) {
        super(telephone2HsmContextDelegate);
        this._contextDelegate = telephone2HsmContextDelegate;
    }

    @Override
    protected HsmContextDelegate getContextDelegate() {
        return this._contextDelegate;
    }

    private Telephone2BindingFactory getBindingFactory() {
        if (this._telephone2BindingFactory == null) {
            this._telephone2BindingFactory = new Telephone2BindingFactoryAll();
        }
        return this._telephone2BindingFactory;
    }

    @Override
    protected void resetBindingFactory() {
    }

    @Override
    public BAPIndicationMarshaller getBAPMarshaller() {
        if (this._telephone2Marhaller == null) {
            this._telephone2Marhaller = new Telephone2Marshaller(this.getBAPServiceProxy(), this.getBitStreamTransformer());
        }
        return this._telephone2Marhaller;
    }

    @Override
    public AbstractBAPDataPool getContextDataPool() {
        return this.getTelephone2FunctionRegistry();
    }

    @Override
    public BAPServiceListener getBAPDemarshaller() {
        if (this._telephone2Demarshaller == null) {
            this._telephone2Demarshaller = new Telephone2Demarshaller(this.getContextDataPool(), this.getContextDataPool(), this.getBitStreamTransformer());
        }
        return this._telephone2Demarshaller;
    }

    @Override
    public BAPFunctionRegistry getFunctionRegistry() {
        return this.getTelephone2FunctionRegistry();
    }

    private BAPTelephone2DataPool getTelephone2FunctionRegistry() {
        if (this._dataPool == null) {
            this._dataPool = new BAPTelephone2DataPool(this.getContextDelegate());
            this._dataPool.setFactory(this.getBindingFactory());
        }
        return this._dataPool;
    }

    @Override
    public void reinitialize() {
        this.getTelephone2FunctionRegistry().reinitialize();
    }

    @Override
    public void uninitialize() {
    }

    @Override
    public String getLogicalControlUnitName() {
        return "Telephone2";
    }

    @Override
    public int getLogicalControlUnitID() {
        return 41;
    }
}

