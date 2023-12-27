/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.navsd.controller;

import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.bap.mqbab2.common.api.APIFactory;
import de.vw.mib.bap.mqbab2.common.api.BAPFunctionControlUnitExt;
import de.vw.mib.bap.mqbab2.common.api.FSGService;
import de.vw.mib.bap.mqbab2.common.api.FSGServiceProxy;
import de.vw.mib.bap.mqbab2.navsd.api.NavSDServiceProxy;
import de.vw.mib.bap.mqbab2.navsd.api.NavSDServiceProxyMarshaller;
import de.vw.mib.bap.mqbab2.navsd.controller.NavSDFunctionControlUnit;
import de.vw.mib.bap.mqbab2.navsd.states.NavSdHsmContext;
import de.vw.mib.bap.mqbab2.navsd.states.NavSdHsmContextDelegate;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.log4mib.Logger;

public class NavSdTarget
extends AbstractASLHsmTarget
implements NavSdHsmContextDelegate {
    private NavSdHsmContext _hsmContext;
    private NavSDFunctionControlUnit _functionControlUnit;
    private NavSDServiceProxy _navSdServiceProxy;

    public NavSdTarget(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
    }

    @Override
    public int getDefaultTargetId() {
        return -1551952128;
    }

    private NavSdHsmContext getHsmContext() {
        if (this._hsmContext == null) {
            this._hsmContext = new NavSdHsmContext(this.getHsm(), this.getWorkStateParent());
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
        return 16;
    }

    private NavSDFunctionControlUnit getNavSdFunctionControlUnit() {
        if (this._functionControlUnit == null) {
            this._functionControlUnit = new NavSDFunctionControlUnit(this);
        }
        return this._functionControlUnit;
    }

    @Override
    public BAPFunctionControlUnitExt getLogicalControlUnit() {
        return this.getNavSdFunctionControlUnit();
    }

    @Override
    public FSGServiceProxy getFsgServiceProxy() {
        if (this._navSdServiceProxy == null) {
            this._navSdServiceProxy = new NavSDServiceProxyMarshaller();
        }
        return this._navSdServiceProxy;
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

