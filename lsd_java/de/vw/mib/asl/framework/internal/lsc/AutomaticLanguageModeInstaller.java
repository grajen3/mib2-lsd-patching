/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.lsc;

import de.vw.mib.asl.framework.api.persistence.IPersistableEarlyData;

public interface AutomaticLanguageModeInstaller {
    default public void activateAutomaticLanguageMode(boolean bl) {
    }

    default public boolean isPqLscAutomaticModeAktive() {
    }

    default public void setPqLscAutomaticModeAktive(boolean bl) {
    }

    default public int getLastUpdatedLanguageforPqCase() {
    }

    default public void setLastUpdatedLanguageforPqCase(int n) {
    }

    default public IPersistableEarlyData getPersistableData() {
    }
}

