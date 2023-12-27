/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.navsd.controller;

import de.vw.mib.bap.mqbpq.ServiceManager;
import de.vw.mib.bap.mqbpq.common.api.BAPFunctionControlUnitExt;
import de.vw.mib.bap.mqbpq.common.api.FSGService;
import de.vw.mib.bap.mqbpq.common.api.FSGServiceProxy;
import de.vw.mib.bap.mqbpq.navsd.api.NavSDServiceProxy;
import de.vw.mib.bap.mqbpq.navsd.api.NavSDServiceProxyMarshaller;
import de.vw.mib.bap.mqbpq.navsd.controller.NavSDFunctionControlUnit;
import de.vw.mib.bap.mqbpq.navsd.states.NavSdHsmContext;
import de.vw.mib.bap.mqbpq.navsd.states.NavSdHsmContextDelegate;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.log4mib.Logger;

public class NavSdTarget
implements NavSdHsmContextDelegate {
    private NavSdHsmContext _hsmContext;
    private NavSDFunctionControlUnit _functionControlUnit;
    private NavSDServiceProxy _navSdServiceProxy;
    private Hsm _hsm;

    private NavSdHsmContext getHsmContext() {
        if (this._hsmContext == null) {
            this._hsmContext = new NavSdHsmContext(this.getHsm(), this.getWorkStateParent());
            this._hsmContext.setDelegate(this);
        }
        return this._hsmContext;
    }

    private String getMyShortName() {
        String string = super.getClass().getName();
        int n = string.lastIndexOf(46);
        if (n != -1) {
            string = string.substring(n + 1);
        }
        if (string == null || string.length() == 0) {
            string = "hsm";
        }
        return string;
    }

    private HsmState getWorkStateParent() {
        return null;
    }

    @Override
    public Logger getLogger() {
        return ServiceManager.serviceManager.logger;
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
    public Hsm getHsm() {
        if (this._hsm == null) {
            this._hsm = new Hsm(this.getMyShortName(), null);
        }
        return this._hsm;
    }

    @Override
    public HsmState getDefaultState() {
        return this.getHsmContext().getStartState();
    }
}

