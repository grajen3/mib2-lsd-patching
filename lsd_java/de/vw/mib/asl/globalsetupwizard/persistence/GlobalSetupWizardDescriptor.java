/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.globalsetupwizard.persistence;

import de.vw.mib.asl.framework.api.persistence2.Persistable;
import java.util.Map;

public interface GlobalSetupWizardDescriptor
extends Persistable {
    default public Map getMapWizardPages() {
    }

    default public boolean isDontShowAgain() {
    }

    default public void setDontShowAgain(boolean bl) {
    }
}

