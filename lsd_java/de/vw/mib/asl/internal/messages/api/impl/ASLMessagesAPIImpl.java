/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.messages.api.impl;

import de.vw.mib.asl.api.messages.ASLMessagesAPI;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.id.PreRegisteredIds;
import de.vw.mib.asl.internal.messages.TargetASLMessagesService;
import de.vw.mib.genericevents.GenericEvents;

public class ASLMessagesAPIImpl
implements ASLMessagesAPI {
    @Override
    public void createTargets(GenericEvents genericEvents, String string) {
        new TargetASLMessagesService(genericEvents, string);
    }

    static {
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(97) || ServiceManager.configManagerDiag.isFeatureFlagSet(94)) {
            PreRegisteredIds.addServiceOrObserverToArray(2, 5273, 1694564416);
            PreRegisteredIds.addServiceOrObserverToArray(2, 5273, 1711341632);
            PreRegisteredIds.addServiceOrObserverToArray(2, 5273, 1744896064);
            PreRegisteredIds.addServiceOrObserverToArray(2, 5273, 1761673280);
            PreRegisteredIds.addServiceOrObserverToArray(2, 5273, 1778450496);
            PreRegisteredIds.addServiceOrObserverToArray(2, 5273, 1862336576);
            PreRegisteredIds.addServiceOrObserverToArray(2, 5273, 1879113792);
            PreRegisteredIds.addServiceOrObserverToArray(2, 5273, 1912668224);
            PreRegisteredIds.addServiceOrObserverToArray(2, 5273, 1929445440);
            PreRegisteredIds.addServiceOrObserverToArray(2, 5273, 1962999872);
            PreRegisteredIds.addServiceOrObserverToArray(2, 5273, 1996554304);
            PreRegisteredIds.addServiceOrObserverToArray(2, 5273, 453640256);
            PreRegisteredIds.addServiceOrObserverToArray(2, 5273, 1979777088);
            PreRegisteredIds.addServiceOrObserverToArray(2, 5273, 2013331520);
            PreRegisteredIds.addServiceOrObserverToArray(2, 5273, -1346695872);
            PreRegisteredIds.addServiceOrObserverToArray(2, 5273, 2030108736);
            PreRegisteredIds.addServiceOrObserverToArray(2, 5273, -1564799680);
            PreRegisteredIds.addServiceOrObserverToArray(2, 5273, 2046885952);
            PreRegisteredIds.addServiceOrObserverToArray(2, 5273, 2063663168);
            PreRegisteredIds.addServiceOrObserverToArray(2, 5273, -1246032576);
            PreRegisteredIds.addServiceOrObserverToArray(2, 5273, 1812004928);
            PreRegisteredIds.addServiceOrObserverToArray(2, 5273, 436863040);
            PreRegisteredIds.addServiceOrObserverToArray(2, 5273, 1795227712);
            PreRegisteredIds.addServiceOrObserverToArray(2, 5273, 1728118848);
            PreRegisteredIds.addServiceOrObserverToArray(2, 5273, 1828782144);
            PreRegisteredIds.addServiceOrObserverToArray(2, 5273, 1895891008);
            PreRegisteredIds.addServiceOrObserverToArray(2, 5273, -1329918656);
            PreRegisteredIds.addServiceOrObserverToArray(2, 5273, -1313141440);
            PreRegisteredIds.addServiceOrObserverToArray(2, 5273, -2080309184);
            PreRegisteredIds.addServiceOrObserverToArray(2, 5273, -2046754752);
            PreRegisteredIds.addServiceOrObserverToArray(2, 5273, -2029977536);
            PreRegisteredIds.addServiceOrObserverToArray(2, 5273, -1229255360);
            PreRegisteredIds.addServiceOrObserverToArray(2, 5273, -1979645888);
            PreRegisteredIds.addServiceOrObserverToArray(2, 5273, -1962868672);
            PreRegisteredIds.addServiceOrObserverToArray(2, 5273, -2063531968);
            PreRegisteredIds.addServiceOrObserverToArray(2, 5273, -2013200320);
            PreRegisteredIds.addServiceOrObserverToArray(2, 5273, -1996423104);
            PreRegisteredIds.addServiceOrObserverToArray(2, 5273, -1627324352);
            PreRegisteredIds.addServiceOrObserverToArray(2, 5273, -1593769920);
            PreRegisteredIds.addServiceOrObserverToArray(2, 5273, -1576992704);
            PreRegisteredIds.addServiceOrObserverToArray(2, 5273, -1363473088);
            PreRegisteredIds.addServiceOrObserverToArray(2, 5273, -1560215488);
            PreRegisteredIds.addServiceOrObserverToArray(2, 5273, -1380250304);
            PreRegisteredIds.addServiceOrObserverToArray(2, 5273, -1526661056);
            PreRegisteredIds.addServiceOrObserverToArray(2, 5273, -1610547136);
            PreRegisteredIds.addServiceOrObserverToArray(2, 5273, -1212478144);
            PreRegisteredIds.addServiceOrObserverToArray(2, 5273, -1929314240);
            PreRegisteredIds.addServiceOrObserverToArray(2, 5273, -1581576896);
            PreRegisteredIds.addServiceOrObserverToArray(2, 5273, -1712441856);
            PreRegisteredIds.addServiceOrObserverToArray(2, 5273, -1427229184);
            PreRegisteredIds.addServiceOrObserverToArray(2, 5273, -1444006400);
            PreRegisteredIds.addServiceOrObserverToArray(2, 5273, -1410451968);
        }
    }
}

