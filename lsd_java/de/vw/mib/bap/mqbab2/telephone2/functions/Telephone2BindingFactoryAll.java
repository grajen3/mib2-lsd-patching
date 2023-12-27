/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.telephone2.functions;

import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.generated.telephone2.Telephone2BindingFactory;
import de.vw.mib.bap.mqbab2.telephone2.functions.AutomaticCallForwarding;
import de.vw.mib.bap.mqbab2.telephone2.functions.ConnectionState;
import de.vw.mib.bap.mqbab2.telephone2.functions.DataConnectionIndication;
import de.vw.mib.bap.mqbab2.telephone2.functions.EmailState;
import de.vw.mib.bap.mqbab2.telephone2.functions.FSGOperationStateHandling;
import de.vw.mib.bap.mqbab2.telephone2.functions.FunctionList;
import de.vw.mib.bap.mqbab2.telephone2.functions.LockState;
import de.vw.mib.bap.mqbab2.telephone2.functions.MobileServiceSupport;
import de.vw.mib.bap.mqbab2.telephone2.functions.NetworkProvider;
import de.vw.mib.bap.mqbab2.telephone2.functions.PhoneModuleState;
import de.vw.mib.bap.mqbab2.telephone2.functions.PhonebookDownloadProgress;
import de.vw.mib.bap.mqbab2.telephone2.functions.RegisterState;
import de.vw.mib.bap.mqbab2.telephone2.functions.SignalQuality;

public class Telephone2BindingFactoryAll
implements Telephone2BindingFactory {
    @Override
    public BAPStage createNewFunctionListStage() {
        return new FunctionList();
    }

    @Override
    public BAPStage createNewFSGOperationStateStage() {
        return new FSGOperationStateHandling();
    }

    @Override
    public BAPStage createNewMobileServiceSupportStage() {
        return new MobileServiceSupport();
    }

    @Override
    public BAPStage createNewRegisterStateStage() {
        return new RegisterState();
    }

    @Override
    public BAPStage createNewLockStateStage() {
        return new LockState();
    }

    @Override
    public BAPStage createNewNetworkProviderStage() {
        return new NetworkProvider();
    }

    @Override
    public BAPStage createNewSignalQualityStage() {
        return new SignalQuality();
    }

    @Override
    public BAPStage createNewDataConnectionIndicationStage() {
        return new DataConnectionIndication();
    }

    @Override
    public BAPStage createNewEmailStateStage() {
        return new EmailState();
    }

    @Override
    public BAPStage createNewPhoneModuleStateStage() {
        return new PhoneModuleState();
    }

    @Override
    public BAPStage createNewConnectionStateStage() {
        return new ConnectionState();
    }

    @Override
    public BAPStage createNewAutomaticCallForwardingStage() {
        return new AutomaticCallForwarding();
    }

    @Override
    public BAPStage createNewPhonebookDownloadProgressStage() {
        return new PhonebookDownloadProgress();
    }
}

