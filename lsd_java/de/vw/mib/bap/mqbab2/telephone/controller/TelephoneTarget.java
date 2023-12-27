/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.telephone.controller;

import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.bap.mqbab2.common.api.APIFactory;
import de.vw.mib.bap.mqbab2.common.api.BAPFunctionControlUnitExt;
import de.vw.mib.bap.mqbab2.common.api.FSGService;
import de.vw.mib.bap.mqbab2.common.api.FSGServiceProxy;
import de.vw.mib.bap.mqbab2.telephone.api.TelephoneServiceProxy;
import de.vw.mib.bap.mqbab2.telephone.api.TelephoneServiceProxyMarshaller;
import de.vw.mib.bap.mqbab2.telephone.controller.TelephoneFunctionControlUnit;
import de.vw.mib.bap.mqbab2.telephone.states.TelephoneHsmContext;
import de.vw.mib.bap.mqbab2.telephone.states.TelephoneHsmContextDelegate;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.log4mib.Logger;

public class TelephoneTarget
extends AbstractASLHsmTarget
implements TelephoneHsmContextDelegate {
    private TelephoneHsmContext _hsmContext;
    private TelephoneFunctionControlUnit _functionControlUnit;
    private TelephoneServiceProxy _telephoneServiceProxy;

    public TelephoneTarget(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
    }

    @Override
    public int getDefaultTargetId() {
        return -1535174912;
    }

    private TelephoneHsmContext getHsmContext() {
        if (this._hsmContext == null) {
            this._hsmContext = new TelephoneHsmContext(this.getHsm(), this.getWorkStateParent());
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
        return 32;
    }

    private TelephoneFunctionControlUnit getTelephoneFunctionControlUnit() {
        if (this._functionControlUnit == null) {
            this._functionControlUnit = new TelephoneFunctionControlUnit(this);
        }
        return this._functionControlUnit;
    }

    @Override
    public BAPFunctionControlUnitExt getLogicalControlUnit() {
        return this.getTelephoneFunctionControlUnit();
    }

    @Override
    public FSGServiceProxy getFsgServiceProxy() {
        if (this._telephoneServiceProxy == null) {
            this._telephoneServiceProxy = new TelephoneServiceProxyMarshaller();
        }
        return this._telephoneServiceProxy;
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

