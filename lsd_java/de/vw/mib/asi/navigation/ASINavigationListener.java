/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.navigation;

import de.esolutions.fw.comm.asi.hmisync.navigation.CarPosition;
import de.esolutions.fw.comm.asi.hmisync.navigation.DestinationInfo;
import de.esolutions.fw.comm.asi.hmisync.navigation.NextDestinationInfo;
import de.vw.mib.asi.ASIListener;

public interface ASINavigationListener
extends ASIListener {
    default public void updateCarPosition(CarPosition carPosition, boolean bl) {
    }

    default public void updateDestinationInfo(DestinationInfo[] destinationInfoArray, boolean bl) {
    }

    default public void updateDestinationsForGuidance(DestinationInfo[] destinationInfoArray, boolean bl) {
    }

    default public void updateNextDestinationInfo(NextDestinationInfo nextDestinationInfo, boolean bl) {
    }

    default public void updateNightDesignRequested(boolean bl, boolean bl2) {
    }

    default public void updateRouteGuidanceActive(boolean bl, boolean bl2) {
    }
}

