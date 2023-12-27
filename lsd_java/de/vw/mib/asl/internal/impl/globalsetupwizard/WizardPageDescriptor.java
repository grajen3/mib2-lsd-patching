/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.globalsetupwizard;

import de.vw.mib.cio.CioIntent;

public class WizardPageDescriptor {
    private final CioIntent cioIntent;
    private final boolean isFinished;

    public WizardPageDescriptor(CioIntent cioIntent, boolean bl) {
        this.cioIntent = cioIntent;
        this.isFinished = bl;
    }

    public CioIntent getCioIntent() {
        return this.cioIntent;
    }

    public boolean isFinished() {
        return this.isFinished;
    }

    public int hashCode() {
        int n = 31;
        int n2 = 1;
        n2 = 31 * n2 + (this.cioIntent == null ? 0 : this.cioIntent.hashCode());
        n2 = 31 * n2 + (this.isFinished ? 1231 : 1237);
        return n2;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (super.getClass() != object.getClass()) {
            return false;
        }
        WizardPageDescriptor wizardPageDescriptor = (WizardPageDescriptor)object;
        if (this.cioIntent == null ? wizardPageDescriptor.cioIntent != null : !this.cioIntent.equals(wizardPageDescriptor.cioIntent)) {
            return false;
        }
        return this.isFinished == wizardPageDescriptor.isFinished;
    }
}

