/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.globalsetupwizard.transformer;

import de.vw.mib.asl.internal.impl.globalsetupwizard.WizardPageDescriptor;
import generated.de.vw.mib.asl.internal.globalsetupwizard.transformer.AbstractGlobalSetupWizardProgressListTransformer;

public class GlobalSetupWizardProgressListTransformer
extends AbstractGlobalSetupWizardProgressListTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        WizardPageDescriptor wizardPageDescriptor = (WizardPageDescriptor)object;
        return wizardPageDescriptor.isFinished();
    }

    @Override
    public long getLong(int n, Object object) {
        WizardPageDescriptor wizardPageDescriptor = (WizardPageDescriptor)object;
        return wizardPageDescriptor.getCioIntent().getCioIntentId();
    }
}

