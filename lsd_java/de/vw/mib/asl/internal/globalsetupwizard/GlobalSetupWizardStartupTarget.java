/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.globalsetupwizard;

import de.vw.mib.asl.api.globalsetupwizard.ASLGlobalSetupWizardFactory;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.internal.globalsetupwizard.api.impl.ASLGlobalSetupWizardAPIImpl;
import de.vw.mib.asl.internal.impl.globalsetupwizard.AbstractGlobalSetupWizardTarget;
import de.vw.mib.asl.internal.impl.globalsetupwizard.GlobalSetupWizardServicesImpl;
import de.vw.mib.asl.internal.impl.globalsetupwizard.WizardPageManager;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;

public class GlobalSetupWizardStartupTarget
extends AbstractGlobalSetupWizardTarget {
    public GlobalSetupWizardStartupTarget(GenericEvents genericEvents, String string) {
        super(genericEvents, ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger(), -2095899648);
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                this.processPowerOn();
                break;
            }
        }
    }

    private void processPowerOn() {
        GlobalSetupWizardServicesImpl globalSetupWizardServicesImpl = new GlobalSetupWizardServicesImpl();
        WizardPageManager wizardPageManager = new WizardPageManager(globalSetupWizardServicesImpl);
        globalSetupWizardServicesImpl.setWizardService(wizardPageManager);
        ASLGlobalSetupWizardAPIImpl aSLGlobalSetupWizardAPIImpl = (ASLGlobalSetupWizardAPIImpl)ASLGlobalSetupWizardFactory.getGlobalSetupWizardApi();
        aSLGlobalSetupWizardAPIImpl.injectGlobalSetupWizardServices(globalSetupWizardServicesImpl);
    }
}

