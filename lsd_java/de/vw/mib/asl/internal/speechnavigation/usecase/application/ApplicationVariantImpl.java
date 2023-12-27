/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.application;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.speechnavigation.usecase.application.ApplicationVariant;

public class ApplicationVariantImpl
implements ApplicationVariant {
    @Override
    public boolean isCHNVariant() {
        return ServiceManager.configManagerDiag.isFeatureFlagSet(111) && !ServiceManager.configManagerDiag.isFeatureFlagSet(168);
    }

    @Override
    public boolean isNARVariant() {
        return ServiceManager.configManagerDiag.isFeatureFlagSet(140);
    }

    @Override
    public boolean isEUVariant() {
        return ServiceManager.configManagerDiag.isFeatureFlagSet(122);
    }

    @Override
    public boolean isJPNVariant() {
        return ServiceManager.configManagerDiag.isFeatureFlagSet(125);
    }

    @Override
    public boolean isTWNVariant() {
        return ServiceManager.configManagerDiag.isFeatureFlagSet(168);
    }

    @Override
    public boolean isKORVariant() {
        return ServiceManager.configManagerDiag.isFeatureFlagSet(138);
    }

    @Override
    public boolean isOneshotAvailable() {
        return ServiceManager.configManagerDiag.isFeatureFlagSet(637);
    }
}

