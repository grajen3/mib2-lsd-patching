/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.configuration;

import de.vw.mib.bap.mqbab2.common.api.configuration.ConfigurationService;

public interface ConfigurationServiceListener {
    public static final int CONFIGURATION_SERVICE__SDS_SWAP_SELECTED;
    public static final int CONFIGURATION_SERVICE__MAP_SWITCH_SELECTED;

    default public void updateConfigurationData(ConfigurationService configurationService, int n) {
    }
}

