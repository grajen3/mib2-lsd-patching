/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.globalsetupwizard;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.api.globalsetupwizard.wizard.WizardService;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetService;
import de.vw.mib.asl.api.system.systemstate.SystemStateService;
import de.vw.mib.asl.framework.api.startupv7r.startupstate.StartupStateService;
import de.vw.mib.asl.globalsetupwizard.persistence.GlobalSetupWizardPersistenceService;
import de.vw.mib.asl.internal.list.ASLListManager;
import de.vw.mib.cio.CioDictionary;
import de.vw.mib.cio.CioDispatcher;
import de.vw.mib.cio.CioFactory;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.ServiceRegister;
import de.vw.mib.log4mib.Logger;

public interface GlobalSetupWizardServices {
    default public ASLListManager getListManager() {
    }

    default public CioDictionary getCioDictionary() {
    }

    default public ASLPropertyManager getAslPropertyManager() {
    }

    default public Logger getLogger() {
    }

    default public GenericEvents getGenericEvents() {
    }

    default public ServiceRegister getServiceRegister() {
    }

    default public CioFactory getCioFactory() {
    }

    default public CioDispatcher getCioDispatcher() {
    }

    default public GlobalSetupWizardPersistenceService getGlobalSetupWirzadPersistenceService() {
    }

    default public FactoryResetService getFactoryResetService() {
    }

    default public StartupStateService getStartupStateService() {
    }

    default public SystemStateService getSystemStateService() {
    }

    default public WizardService getWizardService() {
    }
}

