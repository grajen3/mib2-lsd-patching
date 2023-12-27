/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.navigation;

import de.esolutions.fw.comm.asi.hmisync.navigation.DestinationInfo;
import de.vw.mib.asi.ASIService;
import de.vw.mib.asi.navigation.ASINavigationListener;
import de.vw.mib.asi.navigation.ASINavigationResponse;

public interface ASINavigation
extends ASIService {
    default public ASINavigationListener getASINavigationListener() {
    }

    default public void setASINavigationListener(ASINavigationListener aSINavigationListener) {
    }

    default public void startGuidanceToDestinations(DestinationInfo[] destinationInfoArray, ASINavigationResponse aSINavigationResponse) {
    }
}

