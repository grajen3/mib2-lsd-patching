/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navservicesapi;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.navservicesapi.AddressDataSDIS;

public interface DSINavAsiaSDISListener
extends DSIListener {
    default public void updateRouteGuidanceActive(boolean bl, int n) {
    }

    default public void updateCarPosition(double d2, double d3, int n, int n2, int n3, int n4) {
    }

    default public void updateDestinationInfo(AddressDataSDIS[] addressDataSDISArray, int n) {
    }

    default public void updateNextDestinationInfo(int n, int n2, int n3, int n4) {
    }

    default public void startGuidanceToDestinationsResult(int n) {
    }
}

