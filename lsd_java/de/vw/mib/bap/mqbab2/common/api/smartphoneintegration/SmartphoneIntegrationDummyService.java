/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.smartphoneintegration;

import de.vw.mib.bap.mqbab2.common.api.smartphoneintegration.SmartphoneIntegrationService;
import de.vw.mib.bap.mqbab2.common.api.smartphoneintegration.SmartphoneIntegrationServiceListener;

public class SmartphoneIntegrationDummyService
implements SmartphoneIntegrationService {
    @Override
    public void addSmartphoneIntegrationServiceListener(SmartphoneIntegrationServiceListener smartphoneIntegrationServiceListener, int[] nArray) {
    }

    @Override
    public void removeSmartphoneIntegrationServiceListener(SmartphoneIntegrationServiceListener smartphoneIntegrationServiceListener, int[] nArray) {
    }

    @Override
    public int getSmarphoneIntegrationActiveConnectionType() {
        return 0;
    }
}

