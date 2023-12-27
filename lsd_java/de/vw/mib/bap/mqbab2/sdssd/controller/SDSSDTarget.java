/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.sdssd.controller;

import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.bap.mqbab2.common.api.APIFactory;
import de.vw.mib.bap.mqbab2.common.api.BAPFunctionControlUnitExt;
import de.vw.mib.bap.mqbab2.common.api.FSGService;
import de.vw.mib.bap.mqbab2.common.api.FSGServiceProxy;
import de.vw.mib.bap.mqbab2.sdssd.api.SDSSDServiceProxy;
import de.vw.mib.bap.mqbab2.sdssd.api.SDSSDServiceProxyMarshaller;
import de.vw.mib.bap.mqbab2.sdssd.controller.SDSSDFunctionControlUnit;
import de.vw.mib.bap.mqbab2.sdssd.states.SDSSDHsmContext;
import de.vw.mib.bap.mqbab2.sdssd.states.SDSSDHsmContextDelegate;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.log4mib.Logger;

public class SDSSDTarget
extends AbstractASLHsmTarget
implements SDSSDHsmContextDelegate {
    private SDSSDHsmContext _hsmContext;
    private SDSSDFunctionControlUnit _functionControlUnit;
    private SDSSDServiceProxy _sdsSdServiceProxy;

    public SDSSDTarget(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
    }

    @Override
    public int getDefaultTargetId() {
        return -1501620480;
    }

    private SDSSDHsmContext getHsmContext() {
        if (this._hsmContext == null) {
            this._hsmContext = new SDSSDHsmContext(this.getHsm(), this.getWorkStateParent());
            this._hsmContext.setDelegate(this);
        }
        return this._hsmContext;
    }

    @Override
    public Logger getLogger() {
        return APIFactory.getAPIFactory().getLogger();
    }

    @Override
    public int getSubClassifier() {
        return 1024;
    }

    private SDSSDFunctionControlUnit getSDSSDFunctionControlUnit() {
        if (this._functionControlUnit == null) {
            this._functionControlUnit = new SDSSDFunctionControlUnit(this);
        }
        return this._functionControlUnit;
    }

    @Override
    public BAPFunctionControlUnitExt getLogicalControlUnit() {
        return this.getSDSSDFunctionControlUnit();
    }

    @Override
    public FSGServiceProxy getFsgServiceProxy() {
        if (this._sdsSdServiceProxy == null) {
            this._sdsSdServiceProxy = new SDSSDServiceProxyMarshaller();
        }
        return this._sdsSdServiceProxy;
    }

    @Override
    public FSGService getFsgService() {
        return (FSGService)((Object)this.getHsm().getState());
    }

    @Override
    public HsmState getDefaultState() {
        return this.getHsmContext().getStartState();
    }
}

