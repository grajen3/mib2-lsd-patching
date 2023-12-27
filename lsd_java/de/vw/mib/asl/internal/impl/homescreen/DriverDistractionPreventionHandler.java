/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.homescreen;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.api.system.DriverDistractionPreventionThresholdListener;
import de.vw.mib.asl.internal.impl.homescreen.tileselection.TileInstaller;
import de.vw.mib.configuration.ConfigurationManager;

public class DriverDistractionPreventionHandler
implements DriverDistractionPreventionThresholdListener {
    private final ASLPropertyManager aslPropertyManager;
    private final TileInstaller tileInstaller;
    private final ConfigurationManager configurationManager;

    public DriverDistractionPreventionHandler(ASLPropertyManager aSLPropertyManager, TileInstaller tileInstaller, ConfigurationManager configurationManager) {
        this.aslPropertyManager = aSLPropertyManager;
        this.tileInstaller = tileInstaller;
        this.configurationManager = configurationManager;
    }

    @Override
    public void onDriverDistractionPreventionRequired(boolean bl) {
        boolean bl2 = this.overrideDdpByFeatureFlag(bl);
        this.aslPropertyManager.valueChangedBoolean(-1108653568, bl2);
        if (bl2) {
            this.tileInstaller.deactivateSelectionTile();
        }
    }

    private boolean overrideDdpByFeatureFlag(boolean bl) {
        if (!this.configurationManager.isFeatureFlagSet(179)) {
            return false;
        }
        return bl;
    }
}

