/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation.traffic;

import de.vw.mib.asl.api.navigation.traffic.INavRectangle;
import de.vw.mib.asl.api.navigation.traffic.INavigationTunerData;
import de.vw.mib.asl.api.navigation.traffic.IResourceLocatorExtern;
import de.vw.mib.asl.api.navigation.traffic.ITmcMessage;
import de.vw.mib.asl.api.navigation.traffic.ITrafficSource;
import de.vw.mib.asl.api.navigation.traffic.NavigationTrafficListener;

public class NavigationTrafficListenerAdapter
implements NavigationTrafficListener {
    @Override
    public void updateReceivableStations(INavigationTunerData[] iNavigationTunerDataArray, boolean bl) {
    }

    @Override
    public void updateTrafficSourceInformation(ITrafficSource[] iTrafficSourceArray, boolean bl) {
    }

    @Override
    public void updateUrgentMessages(ITmcMessage[] iTmcMessageArray, boolean bl) {
    }

    @Override
    public void indicateTrafficEventNoticeMap(ITmcMessage iTmcMessage, INavRectangle iNavRectangle, int n) {
    }

    @Override
    public void updateResourceIdForTMCEventIcon(IResourceLocatorExtern iResourceLocatorExtern) {
    }

    @Override
    public void updateResourceIdForAreaWarningIconResult(IResourceLocatorExtern iResourceLocatorExtern) {
    }
}

