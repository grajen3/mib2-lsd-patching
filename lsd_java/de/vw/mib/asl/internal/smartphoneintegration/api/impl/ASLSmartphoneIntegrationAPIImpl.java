/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.smartphoneintegration.api.impl;

import de.vw.mib.asl.api.smartphoneintegration.ASLSmartphoneIntegrationAPI;
import de.vw.mib.asl.api.smartphoneintegration.ASLSmartphoneIntegrationAppConnectAppAdapter;
import de.vw.mib.asl.framework.internal.framework.id.PreRegisteredIds;
import de.vw.mib.asl.internal.smartphoneintegration.common.SmartPhoneIntegrationGlobalProperyAccessor;

public class ASLSmartphoneIntegrationAPIImpl
implements ASLSmartphoneIntegrationAPI {
    @Override
    public void registerAppConnectAppAdapter(ASLSmartphoneIntegrationAppConnectAppAdapter aSLSmartphoneIntegrationAppConnectAppAdapter) {
        SmartPhoneIntegrationGlobalProperyAccessor.getInstance().setAppAdapterInterface(aSLSmartphoneIntegrationAppConnectAppAdapter);
    }

    @Override
    public double getPixelDimensionWidth() {
        double d2 = SmartPhoneIntegrationGlobalProperyAccessor.getInstance().getPixelDimensionWidth();
        return d2 > 0.0 ? d2 : 0.177;
    }

    @Override
    public double getPixelDimensionHeight() {
        double d2 = SmartPhoneIntegrationGlobalProperyAccessor.getInstance().getPixelDimensionHeight();
        return d2 > 0.0 ? d2 : 0.177;
    }

    static {
        PreRegisteredIds.addServiceOrObserverToArray(2, -501540864, 792734784);
        PreRegisteredIds.addServiceOrObserverToArray(2, -501540864, 843066432);
        PreRegisteredIds.addServiceOrObserverToArray(2, -501540864, 1010838592);
        PreRegisteredIds.addServiceOrObserverToArray(2, -501540864, 759180352);
        PreRegisteredIds.addServiceOrObserverToArray(2, -501540864, 859843648);
        PreRegisteredIds.addServiceOrObserverToArray(2, -501540864, 876620864);
        PreRegisteredIds.addServiceOrObserverToArray(2, -501540864, 893398080);
        PreRegisteredIds.addServiceOrObserverToArray(0, -501540864, 554982656);
        PreRegisteredIds.addServiceOrObserverToArray(0, -501540864, 622091520);
        PreRegisteredIds.addServiceOrObserverToArray(0, -501540864, 588537088);
        PreRegisteredIds.addServiceOrObserverToArray(0, -501540864, 571759872);
        PreRegisteredIds.addServiceOrObserverToArray(0, -501540864, 638868736);
        PreRegisteredIds.addServiceOrObserverToArray(0, -501540864, 605314304);
        PreRegisteredIds.addServiceOrObserverToArray(0, -501540864, 655645952);
        PreRegisteredIds.addServiceOrObserverToArray(0, -501540864, 672423168);
        PreRegisteredIds.addServiceOrObserverToArray(0, -501540864, 739532032);
        PreRegisteredIds.addServiceOrObserverToArray(0, -501540864, 840195328);
        PreRegisteredIds.addServiceOrObserverToArray(0, -501540864, 856972544);
        PreRegisteredIds.addServiceOrObserverToArray(0, -501540864, 722754816);
        PreRegisteredIds.addServiceOrObserverToArray(0, -501540864, 924081408);
        PreRegisteredIds.addServiceOrObserverToArray(0, -501540864, 940858624);
        PreRegisteredIds.addServiceOrObserverToArray(0, -501540864, 756309248);
        PreRegisteredIds.addServiceOrObserverToArray(0, -501540864, 957635840);
        PreRegisteredIds.addServiceOrObserverToArray(0, -501540864, 991190272);
        PreRegisteredIds.addServiceOrObserverToArray(0, -501540864, 1024744704);
        PreRegisteredIds.addServiceOrObserverToArray(0, -501540864, 806640896);
        PreRegisteredIds.addServiceOrObserverToArray(0, -501540864, 773086464);
        PreRegisteredIds.addServiceOrObserverToArray(0, -501540864, 890526976);
        PreRegisteredIds.addServiceOrObserverToArray(0, -501540864, 823418112);
        PreRegisteredIds.addServiceOrObserverToArray(0, -501540864, 789863680);
        PreRegisteredIds.addServiceOrObserverToArray(0, -501540864, 907304192);
        PreRegisteredIds.addServiceOrObserverToArray(0, -501540864, 1007967488);
        PreRegisteredIds.addServiceOrObserverToArray(0, -501540864, 705977600);
        PreRegisteredIds.addServiceOrObserverToArray(0, -501540864, 689200384);
        PreRegisteredIds.addServiceOrObserverToArray(0, -501540864, 1142185216);
        PreRegisteredIds.addServiceOrObserverToArray(0, -501540864, 1158962432);
    }
}

