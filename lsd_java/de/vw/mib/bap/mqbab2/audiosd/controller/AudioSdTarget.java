/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.audiosd.controller;

import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.bap.mqbab2.audiosd.api.AudioSDServiceProxy;
import de.vw.mib.bap.mqbab2.audiosd.api.AudioSDServiceProxyMarshaller;
import de.vw.mib.bap.mqbab2.audiosd.controller.AudioSDFunctionControlUnit;
import de.vw.mib.bap.mqbab2.audiosd.states.AudioSdHsmContext;
import de.vw.mib.bap.mqbab2.audiosd.states.AudioSdHsmContextDelegate;
import de.vw.mib.bap.mqbab2.common.api.APIFactory;
import de.vw.mib.bap.mqbab2.common.api.BAPFunctionControlUnitExt;
import de.vw.mib.bap.mqbab2.common.api.FSGService;
import de.vw.mib.bap.mqbab2.common.api.FSGServiceProxy;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.log4mib.Logger;

public class AudioSdTarget
extends AbstractASLHsmTarget
implements AudioSdHsmContextDelegate {
    private AudioSdHsmContext _hsmContext;
    private AudioSDFunctionControlUnit _functionControlUnit;
    private AudioSDServiceProxy _audioSdServiceProxy;

    public AudioSdTarget(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
    }

    @Override
    public int getDefaultTargetId() {
        return -1568729344;
    }

    private AudioSdHsmContext getHsmContext() {
        if (this._hsmContext == null) {
            this._hsmContext = new AudioSdHsmContext(this.getHsm(), this.getWorkStateParent());
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
    public HsmState getDefaultState() {
        return this.getHsmContext().getStartState();
    }
}

