/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.smartphoneintegration;

import de.vw.mib.asl.api.smartphoneintegration.ASLSmartphoneIntegrationAPI;
import de.vw.mib.asl.framework.api.framework.ASLFactoryBase;

public class ASLSmartphoneIntegrationFactory
extends ASLFactoryBase {
    private static ASLSmartphoneIntegrationAPI apiInstance = null;
    static /* synthetic */ Class class$de$vw$mib$asl$api$smartphoneintegration$ASLSmartphoneIntegrationAPI;

    public static ASLSmartphoneIntegrationAPI getSmartphoneIntegrationApi() {
        if (apiInstance == null) {
            apiInstance = (ASLSmartphoneIntegrationAPI)ASLSmartphoneIntegrationFactory.createServiceInstance(class$de$vw$mib$asl$api$smartphoneintegration$ASLSmartphoneIntegrationAPI == null ? (class$de$vw$mib$asl$api$smartphoneintegration$ASLSmartphoneIntegrationAPI = ASLSmartphoneIntegrationFactory.class$("de.vw.mib.asl.api.smartphoneintegration.ASLSmartphoneIntegrationAPI")) : class$de$vw$mib$asl$api$smartphoneintegration$ASLSmartphoneIntegrationAPI, "de.vw.mib.asl.internal.smartphoneintegration.api.impl.ASLSmartphoneIntegrationAPIImpl");
        }
        return apiInstance;
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

