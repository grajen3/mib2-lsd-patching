/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.globalsetupwizard;

import de.vw.mib.asl.globalsetupwizard.persistence.GlobalSetupWizardDescriptor;
import de.vw.mib.asl.internal.globalsetupwizard.GlobalSetupWizardServices;
import de.vw.mib.cio.CioIntent;
import java.util.Map;

public class GlobalSetupWizardPersistence {
    private static final boolean PAGE_NOT_FINISHED;
    private final GlobalSetupWizardDescriptor globalSetupWizardDescriptor;
    private Map mapWizardPages;

    public GlobalSetupWizardPersistence(GlobalSetupWizardServices globalSetupWizardServices) {
        this.globalSetupWizardDescriptor = globalSetupWizardServices.getGlobalSetupWirzadPersistenceService().loadGlobalSetupWizardDescriptor();
        this.mapWizardPages = this.globalSetupWizardDescriptor.getMapWizardPages();
    }

    void pagesDontShowAgain(boolean bl) {
        this.globalSetupWizardDescriptor.setDontShowAgain(bl);
    }

    boolean isDontShowAgain() {
        return this.globalSetupWizardDescriptor.isDontShowAgain();
    }

    void addPageIntent(CioIntent cioIntent) {
        Long l = new Long(cioIntent.getCioIntentId());
        if (!this.mapWizardPages.containsKey(l)) {
            this.mapWizardPages.put(l, new Boolean(false));
        }
    }

    void removePageIntent(CioIntent cioIntent) {
        Long l = new Long(cioIntent.getCioIntentId());
        if (this.mapWizardPages.containsKey(l)) {
            this.mapWizardPages.remove(l);
        }
    }

    boolean isPageFinished(long l) {
        Long l2 = new Long(l);
        if (this.mapWizardPages.containsKey(l2)) {
            return (Boolean)this.mapWizardPages.get(l2);
        }
        return false;
    }

    boolean isAllSettingsNotSuccessfulFinished() {
        return this.mapWizardPages.containsValue(false);
    }

    void reset() {
        this.mapWizardPages.clear();
        this.globalSetupWizardDescriptor.setDontShowAgain(false);
    }

    void storeFinishedState(long l, boolean bl) {
        Long l2 = new Long(l);
        if (this.mapWizardPages.containsKey(l2)) {
            this.mapWizardPages.put(l2, new Boolean(bl));
        }
    }
}

