/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.globalsetupwizard.persistence;

import de.vw.mib.asl.framework.api.persistence2.ModulePersistenceService;
import de.vw.mib.asl.globalsetupwizard.persistence.GlobalSetupWizardDescriptor;

public interface GlobalSetupWizardPersistenceService
extends ModulePersistenceService {
    default public GlobalSetupWizardDescriptor loadGlobalSetupWizardDescriptor() {
    }

    default public GlobalSetupWizardDescriptor createGlobalSetupWizardDescriptor() {
    }
}

