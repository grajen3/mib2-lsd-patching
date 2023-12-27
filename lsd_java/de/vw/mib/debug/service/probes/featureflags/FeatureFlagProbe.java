/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.service.probes.featureflags;

import de.vw.mib.configuration.ConfigurationManagerDiag;
import de.vw.mib.debug.service.probes.featureflags.ConfigurationManagerObserverHelper;
import de.vw.mib.debugmanager.probes.AbstractDebugProbe;
import de.vw.mib.debugmanager.probes.ProbeSystemServices;

public final class FeatureFlagProbe
extends AbstractDebugProbe {
    private ConfigurationManagerDiag configurationManager;
    private ConfigurationManagerObserverHelper configurationManagerObserverHelper;
    static /* synthetic */ Class class$de$vw$mib$configuration$ConfigurationManagerDiag;

    public FeatureFlagProbe(ProbeSystemServices probeSystemServices) {
        super(probeSystemServices);
    }

    @Override
    protected boolean initProbe() {
        this.configurationManager = (ConfigurationManagerDiag)this.probeSystemServices.getService((class$de$vw$mib$configuration$ConfigurationManagerDiag == null ? (class$de$vw$mib$configuration$ConfigurationManagerDiag = FeatureFlagProbe.class$("de.vw.mib.configuration.ConfigurationManagerDiag")) : class$de$vw$mib$configuration$ConfigurationManagerDiag).getName());
        this.configurationManagerObserverHelper = new ConfigurationManagerObserverHelper(this.configurationManager, this.probeSystemServices);
        this.configurationManagerObserverHelper.sendAllFeatureFlags();
        return true;
    }

    @Override
    protected boolean deactivateProbe() {
        this.configurationManager.removeObserver();
        return true;
    }

    @Override
    protected boolean activateProbe() {
        this.configurationManager.setObserver(this.configurationManagerObserverHelper);
        return true;
    }

    @Override
    protected boolean configureProbe() {
        this.configurationManagerObserverHelper.sendAllFeatureFlags();
        return true;
    }

    @Override
    protected boolean cleanUpProbe() {
        return true;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

