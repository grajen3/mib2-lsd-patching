/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.smartphoneintegration;

import de.vw.mib.bap.mqbab2.common.api.smartphoneintegration.SmartphoneIntegrationServiceListener;

public interface SmartphoneIntegrationService {
    default public void addSmartphoneIntegrationServiceListener(SmartphoneIntegrationServiceListener smartphoneIntegrationServiceListener, int[] nArray) {
    }

    default public void removeSmartphoneIntegrationServiceListener(SmartphoneIntegrationServiceListener smartphoneIntegrationServiceListener, int[] nArray) {
    }

    default public int getSmarphoneIntegrationActiveConnectionType() {
    }
}

