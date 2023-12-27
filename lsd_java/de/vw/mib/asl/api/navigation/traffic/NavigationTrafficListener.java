/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation.traffic;

import de.vw.mib.asl.api.navigation.traffic.INavRectangle;
import de.vw.mib.asl.api.navigation.traffic.INavigationTunerData;
import de.vw.mib.asl.api.navigation.traffic.IResourceLocatorExtern;
import de.vw.mib.asl.api.navigation.traffic.ITmcMessage;
import de.vw.mib.asl.api.navigation.traffic.ITrafficSource;

public interface NavigationTrafficListener {
    default public void updateReceivableStations(INavigationTunerData[] iNavigationTunerDataArray, boolean bl) {
    }

    default public void updateTrafficSourceInformation(ITrafficSource[] iTrafficSourceArray, boolean bl) {
    }

    default public void updateUrgentMessages(ITmcMessage[] iTmcMessageArray, boolean bl) {
    }

    default public void indicateTrafficEventNoticeMap(ITmcMessage iTmcMessage, INavRectangle iNavRectangle, int n) {
    }

    default public void updateResourceIdForTMCEventIcon(IResourceLocatorExtern iResourceLocatorExtern) {
    }

    default public void updateResourceIdForAreaWarningIconResult(IResourceLocatorExtern iResourceLocatorExtern) {
    }
}

