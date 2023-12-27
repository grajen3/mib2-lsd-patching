/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.telephone2.controller;

import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.bap.mqbab2.common.api.APIFactory;
import de.vw.mib.bap.mqbab2.common.api.BAPFunctionControlUnitExt;
import de.vw.mib.bap.mqbab2.common.api.FSGService;
import de.vw.mib.bap.mqbab2.common.api.FSGServiceProxy;
import de.vw.mib.bap.mqbab2.telephone2.api.Telephone2ServiceProxy;
import de.vw.mib.bap.mqbab2.telephone2.api.Telephone2ServiceProxyMarshaller;
import de.vw.mib.bap.mqbab2.telephone2.controller.Telephone2FunctionControlUnit;
import de.vw.mib.bap.mqbab2.telephone2.states.Telephone2HsmContext;
import de.vw.mib.bap.mqbab2.telephone2.states.Telephone2HsmContextDelegate;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.log4mib.Logger;

public class Telephone2Target
extends AbstractASLHsmTarget
implements Telephone2HsmContextDelegate {
    private Telephone2HsmContext _hsmContext;
    private Telephone2FunctionControlUnit _functionControlUnit;
    private Telephone2ServiceProxy _telephone2ServiceProxy;

    public Telephone2Target(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
    }

    @Override
    public int getDefaultTargetId() {
        return -1518397696;
    }

    private Telephone2HsmContext getHsmContext() {
        if (this._hsmContext == null) {
            this._hsmContext = new Telephone2HsmContext(this.getHsm(), this.getWorkStateParent());
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
        return 128;
    }

    private Telephone2FunctionControlUnit getTelephone2FunctionControlUnit() {
        if (this._functionControlUnit == null) {
            this._functionControlUnit = new Telephone2FunctionControlUnit(this);
        }
        return this._functionControlUnit;
    }

    @Override
    public BAPFunctionControlUnitExt getLogicalControlUnit() {
        return this.getTelephone2FunctionControlUnit();
    }

    @Override
    public FSGServiceProxy getFsgServiceProxy() {
        if (this._telephone2ServiceProxy == null) {
            this._telephone2ServiceProxy = new Telephone2ServiceProxyMarshaller();
        }
        return this._telephone2ServiceProxy;
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

