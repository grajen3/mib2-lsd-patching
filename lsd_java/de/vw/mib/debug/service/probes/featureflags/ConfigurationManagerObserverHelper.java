/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.service.probes.featureflags;

import de.vw.mib.configuration.ConfigurationManagerDiag;
import de.vw.mib.configuration.ConfigurationManagerObserver;
import de.vw.mib.debug.service.probes.featureflags.FeatureFlagCodec;
import de.vw.mib.debugmanager.probes.ProbeSystemServices;

public class ConfigurationManagerObserverHelper
implements ConfigurationManagerObserver {
    private ConfigurationManagerDiag configurationManager;
    private ProbeSystemServices probeSystemServices;

    public ConfigurationManagerObserverHelper(ConfigurationManagerDiag configurationManagerDiag, ProbeSystemServices probeSystemServices) {
        this.configurationManager = configurationManagerDiag;
        this.probeSystemServices = probeSystemServices;
    }

    void sendAllFeatureFlags() {
        String[] stringArray = this.configurationManager.getAllFeatureFlagNames();
        int[] nArray = this.getFeatureFlagTypes(stringArray.length);
        boolean[] blArray = this.getFeatureFlagValues();
        FeatureFlagCodec featureFlagCodec = (FeatureFlagCodec)this.probeSystemServices.borrowCodec();
        featureFlagCodec.encodeWholeFeatureFlagList(stringArray, nArray, blArray);
        this.probeSystemServices.releaseCodec(featureFlagCodec);
    }

    private int[] getFeatureFlagTypes(int n) {
        int[] nArray = new int[n];
        for (int i2 = 0; i2 < n; ++i2) {
            nArray[i2] = 0;
        }
        return nArray;
    }

    private boolean[] getFeatureFlagValues() {
        String[] stringArray = this.configurationManager.getAllFeatureFlagValuesAsString();
        int n = stringArray.length;
        boolean[] blArray = new boolean[n];
        for (int i2 = 0; i2 < n; ++i2) {
            blArray[i2] = Boolean.valueOf(stringArray[i2]);
        }
        return blArray;
    }

    @Override
    public void receiveFeatureFlagUpdate(int n, String string) {
        String string2 = this.configurationManager.getAllFeatureFlagNames()[n];
        byte by = this.configurationManager.getAllFeatureFlagTypes()[n];
        boolean bl = Boolean.valueOf(string);
        FeatureFlagCodec featureFlagCodec = (FeatureFlagCodec)this.probeSystemServices.borrowCodec();
        featureFlagCodec.encodeFeatureFlagUpdate(string2, by, bl);
        this.probeSystemServices.releaseCodec(featureFlagCodec);
    }
}

