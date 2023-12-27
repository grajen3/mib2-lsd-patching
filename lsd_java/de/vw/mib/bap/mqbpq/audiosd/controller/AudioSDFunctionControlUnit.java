/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.audiosd.controller;

import de.vw.mib.bap.marshalling.BAPFunctionRegistry;
import de.vw.mib.bap.marshalling.BAPIndicationMarshaller;
import de.vw.mib.bap.marshalling.BAPServiceListener;
import de.vw.mib.bap.mqbpq.ServiceManager;
import de.vw.mib.bap.mqbpq.audiosd.functions.AudioSDBindingFactoryAll;
import de.vw.mib.bap.mqbpq.audiosd.functions.AudioSDBindingFactoryArabic;
import de.vw.mib.bap.mqbpq.audiosd.functions.AudioSDBindingFactoryChina;
import de.vw.mib.bap.mqbpq.audiosd.functions.AudioSDBindingFactoryNar;
import de.vw.mib.bap.mqbpq.audiosd.states.AudioSdHsmContextDelegate;
import de.vw.mib.bap.mqbpq.common.HsmContextDelegate;
import de.vw.mib.bap.mqbpq.common.api.BAPFunctionControlUnitExt;
import de.vw.mib.bap.mqbpq.common.api.adapter.AbstractBAPDataPool;
import de.vw.mib.bap.mqbpq.common.controller.GenericFunctionControlUnit;
import de.vw.mib.bap.mqbpq.generated.audiosd.AudioSDBindingFactory;
import de.vw.mib.bap.mqbpq.generated.audiosd.AudioSDDemarshaller;
import de.vw.mib.bap.mqbpq.generated.audiosd.AudioSDMarshaller;
import de.vw.mib.bap.mqbpq.generated.audiosd.BAPAudioSDDataPool;

class AudioSDFunctionControlUnit
extends GenericFunctionControlUnit
implements BAPFunctionControlUnitExt {
    private final HsmContextDelegate _contextDelegate;
    private BAPIndicationMarshaller _audioSdMarhaller;
    private BAPServiceListener _audioSdDemarshaller;
    private BAPAudioSDDataPool _dataPool;
    private AudioSDBindingFactory _audioSdBindingFactory;

    public AudioSDFunctionControlUnit(AudioSdHsmContextDelegate audioSdHsmContextDelegate) {
        super(audioSdHsmContextDelegate);
        this._contextDelegate = audioSdHsmContextDelegate;
    }

    @Override
    protected HsmContextDelegate getContextDelegate() {
        return this._contextDelegate;
    }

    private AudioSDBindingFactory getBindingFactory() {
        if (this._audioSdBindingFactory == null) {
            this._audioSdBindingFactory = this.isArabic() ? new AudioSDBindingFactoryArabic() : (ServiceManager.serviceManager.configurationManager.isFeatureFlagSet(2) ? new AudioSDBindingFactoryNar() : (ServiceManager.serviceManager.configurationManager.isFeatureFlagSet(26) ? new AudioSDBindingFactoryChina() : new AudioSDBindingFactoryAll()));
        }
        return this._audioSdBindingFactory;
    }

    @Override
    protected void resetBindingFactory() {
        this._audioSdBindingFactory = null;
        if (this.isInitialized()) {
            this.getAudioSdFunctionRegistry().uninitialize();
            this.getAudioSdFunctionRegistry().setFactory(this.getBindingFactory());
            this.getAudioSdFunctionRegistry().initialize();
        } else {
            this.getAudioSdFunctionRegistry().setFactory(this.getBindingFactory());
        }
    }

    @Override
    public BAPIndicationMarshaller getBAPMarshaller() {
        if (this._audioSdMarhaller == null) {
            this._audioSdMarhaller = new AudioSDMarshaller(this.getBAPServiceProxy(), this.getBitStreamTransformer());
        }
        return this._audioSdMarhaller;
    }

    @Override
    public AbstractBAPDataPool getContextDataPool() {
        return this.getAudioSdFunctionRegistry();
    }

    @Override
    public BAPServiceListener getBAPDemarshaller() {
        if (this._audioSdDemarshaller == null) {
            this._audioSdDemarshaller = new AudioSDDemarshaller(this.getContextDataPool(), this.getContextDataPool(), this.getBitStreamTransformer());
        }
        return this._audioSdDemarshaller;
    }

    @Override
    public BAPFunctionRegistry getFunctionRegistry() {
        return this.getAudioSdFunctionRegistry();
    }

    private BAPAudioSDDataPool getAudioSdFunctionRegistry() {
        if (this._dataPool == null) {
            this._dataPool = new BAPAudioSDDataPool(this.getContextDelegate());
            this._dataPool.setFactory(this.getBindingFactory());
        }
        return this._dataPool;
    }

    @Override
    public void reinitialize() {
        this.getAudioSdFunctionRegistry().reinitialize();
    }

    @Override
    public void uninitialize() {
    }

    @Override
    public String getLogicalControlUnitName() {
        return "AudioSD";
    }

    @Override
    public int getLogicalControlUnitID() {
        return 49;
    }
}

