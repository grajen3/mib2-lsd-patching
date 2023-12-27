/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.smartphoneintegration.transformer;

import de.vw.mib.asl.internal.smartphoneintegration.common.SmartPhoneIntegrationHelper;
import de.vw.mib.asl.internal.smartphoneintegration.transformer.SmartPhoneIntegrationDeviceListCollector;
import generated.de.vw.mib.asl.internal.smartphoneintegration.transformer.AbstractSmartPhoneIntegrationDeviceListsTransformer;

public class SmartPhoneIntegrationDeviceListsTransformer
extends AbstractSmartPhoneIntegrationDeviceListsTransformer {
    @Override
    public String getString(int n, Object object) {
        SmartPhoneIntegrationDeviceListCollector smartPhoneIntegrationDeviceListCollector = (SmartPhoneIntegrationDeviceListCollector)object;
        if (smartPhoneIntegrationDeviceListCollector != null && n == 0) {
            String string = smartPhoneIntegrationDeviceListCollector.getDeviceName();
            return string;
        }
        return "";
    }

    @Override
    public boolean getBoolean(int n, Object object) {
        SmartPhoneIntegrationDeviceListCollector smartPhoneIntegrationDeviceListCollector = (SmartPhoneIntegrationDeviceListCollector)object;
        if (smartPhoneIntegrationDeviceListCollector != null) {
            if (n == 2) {
                boolean bl = false;
                bl = SmartPhoneIntegrationHelper.isConnectionMethodSupported(smartPhoneIntegrationDeviceListCollector.getDeviceConnectionMethod(), 2) || SmartPhoneIntegrationHelper.isConnectionMethodSupported(smartPhoneIntegrationDeviceListCollector.getDeviceConnectionMethod(), 4);
                return bl;
            }
            if (n == 1) {
                boolean bl = false;
                bl = SmartPhoneIntegrationHelper.isConnectionMethodSupported(smartPhoneIntegrationDeviceListCollector.getDeviceConnectionMethod(), 1);
                return bl;
            }
            if (n == 3) {
                boolean bl = false;
                bl = SmartPhoneIntegrationHelper.isConnectionMethodSupported(smartPhoneIntegrationDeviceListCollector.getDeviceConnectionMethod(), 8);
                return bl;
            }
            if (n == 4) {
                boolean bl = false;
                bl = SmartPhoneIntegrationHelper.isConnectionMethodSupported(smartPhoneIntegrationDeviceListCollector.getDeviceConnectionMethod(), 32);
                return bl;
            }
        }
        return false;
    }
}

