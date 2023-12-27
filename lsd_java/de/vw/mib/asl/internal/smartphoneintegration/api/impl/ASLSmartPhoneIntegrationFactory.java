/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.smartphoneintegration.api.impl;

import de.vw.mib.asl.framework.api.framework.ASLFactoryBase;
import de.vw.mib.asl.internal.smartphoneintegration.api.impl.ASLSmartphoneIntegrationAPIImpl;

public class ASLSmartPhoneIntegrationFactory
extends ASLFactoryBase {
    private static ASLSmartphoneIntegrationAPIImpl smartphoneintegrationAPI = null;
    static /* synthetic */ Class class$de$vw$mib$asl$api$smartphoneintegration$ASLSmartphoneIntegrationAPI;

    public static ASLSmartphoneIntegrationAPIImpl getASLSmartphoneIntegrationAPI() {
        if (smartphoneintegrationAPI == null) {
            smartphoneintegrationAPI = (ASLSmartphoneIntegrationAPIImpl)ASLSmartPhoneIntegrationFactory.createServiceInstance(class$de$vw$mib$asl$api$smartphoneintegration$ASLSmartphoneIntegrationAPI == null ? (class$de$vw$mib$asl$api$smartphoneintegration$ASLSmartphoneIntegrationAPI = ASLSmartPhoneIntegrationFactory.class$("de.vw.mib.asl.api.smartphoneintegration.ASLSmartphoneIntegrationAPI")) : class$de$vw$mib$asl$api$smartphoneintegration$ASLSmartphoneIntegrationAPI, "de.vw.mib.asl.internal.smartphoneintegration.api.impl.ASLSmartphoneIntegrationAPIImpl");
        }
        return smartphoneintegrationAPI;
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

