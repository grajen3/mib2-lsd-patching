/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.audiosd.controller;

import de.vw.mib.bap.mqbpq.ServiceManager;
import de.vw.mib.bap.mqbpq.audiosd.api.AudioSDServiceProxy;
import de.vw.mib.bap.mqbpq.audiosd.api.AudioSDServiceProxyMarshaller;
import de.vw.mib.bap.mqbpq.audiosd.controller.AudioSDFunctionControlUnit;
import de.vw.mib.bap.mqbpq.audiosd.states.AudioSdHsmContext;
import de.vw.mib.bap.mqbpq.audiosd.states.AudioSdHsmContextDelegate;
import de.vw.mib.bap.mqbpq.common.api.BAPFunctionControlUnitExt;
import de.vw.mib.bap.mqbpq.common.api.FSGService;
import de.vw.mib.bap.mqbpq.common.api.FSGServiceProxy;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.log4mib.Logger;

public class AudioSdTarget
implements AudioSdHsmContextDelegate {
    private AudioSdHsmContext _hsmContext;
    private AudioSDFunctionControlUnit _functionControlUnit;
    private AudioSDServiceProxy _audioSdServiceProxy;
    private Hsm _hsm;

    private AudioSdHsmContext getHsmContext() {
        if (this._hsmContext == null) {
            this._hsmContext = new AudioSdHsmContext(this.getHsm(), this.getWorkStateParent());
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
        return 8;
    }

    private AudioSDFunctionControlUnit getAudioSdFunctionControlUnit() {
        if (this._functionControlUnit == null) {
            this._functionControlUnit = new AudioSDFunctionControlUnit(this);
        }
        return this._functionControlUnit;
    }

    @Override
    public BAPFunctionControlUnitExt getLogicalControlUnit() {
        return this.getAudioSdFunctionControlUnit();
    }

    @Override
    public FSGServiceProxy getFsgServiceProxy() {
        if (this._audioSdServiceProxy == null) {
            this._audioSdServiceProxy = new AudioSDServiceProxyMarshaller();
        }
        return this._audioSdServiceProxy;
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

