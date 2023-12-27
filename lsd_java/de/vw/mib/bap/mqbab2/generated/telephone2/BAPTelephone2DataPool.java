/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.telephone2;

import de.vw.mib.bap.mqbab2.common.HsmContextDelegate;
import de.vw.mib.bap.mqbab2.common.api.adapter.AbstractBAPDataPool;
import de.vw.mib.bap.mqbab2.generated.telephone2.Telephone2BindingFactory;

public class BAPTelephone2DataPool
extends AbstractBAPDataPool {
    private Telephone2BindingFactory _factory;

    public BAPTelephone2DataPool(HsmContextDelegate hsmContextDelegate) {
        super(hsmContextDelegate);
    }

    public Telephone2BindingFactory getFactory() {
        return this._factory;
    }

    public void setFactory(Telephone2BindingFactory telephone2BindingFactory) {
        this._factory = telephone2BindingFactory;
    }

    @Override
    public final void initialize() {
        this.initializeInternal(this._factory);
        super.initialize();
        this._factory = null;
    }

    public final void reinitialize(Telephone2BindingFactory telephone2BindingFactory) {
        super.uninitialize();
        this.initializeInternal(telephone2BindingFactory);
        super.initialize();
        this._factory = null;
    }

    private void initializeInternal(Telephone2BindingFactory telephone2BindingFactory) {
        this.addStage(telephone2BindingFactory.createNewFunctionListStage(), 3, 1, "FunctionList");
        this.addStage(telephone2BindingFactory.createNewFSGOperationStateStage(), 0, 1, "FSGOperationState");
        this.addStage(telephone2BindingFactory.createNewMobileServiceSupportStage(), 3, 1, "MobileServiceSupport");
        this.addStage(telephone2BindingFactory.createNewRegisterStateStage(), 3, 1, "RegisterState");
        this.addStage(telephone2BindingFactory.createNewLockStateStage(), 0, 1, "LockState");
        this.addStage(telephone2BindingFactory.createNewNetworkProviderStage(), 3, 1, "NetworkProvider");
        this.addStage(telephone2BindingFactory.createNewSignalQualityStage(), 0, 1, "SignalQuality");
        this.addStage(telephone2BindingFactory.createNewDataConnectionIndicationStage(), 3, 1, "DataConnectionIndication");
        this.addStage(telephone2BindingFactory.createNewEmailStateStage(), 3, 1, "EmailState");
        this.addStage(telephone2BindingFactory.createNewPhoneModuleStateStage(), 3, 1, "PhoneModuleState");
        this.addStage(telephone2BindingFactory.createNewConnectionStateStage(), 3, 1, "ConnectionState");
        this.addStage(telephone2BindingFactory.createNewAutomaticCallForwardingStage(), 1, 1, "AutomaticCallForwarding");
        this.addStage(telephone2BindingFactory.createNewPhonebookDownloadProgressStage(), 3, 1, "PhonebookDownloadProgress");
    }
}

