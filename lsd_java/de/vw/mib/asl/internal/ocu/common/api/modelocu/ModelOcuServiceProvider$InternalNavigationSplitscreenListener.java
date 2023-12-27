/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.common.api.modelocu;

import de.vw.mib.asl.api.navigation.ASLNavigationFactory;
import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.api.navigation.INavigationPosPosition;
import de.vw.mib.asl.api.navigation.splitscreen.NavigationSplitscreenListenerAdapter;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;

public final class ModelOcuServiceProvider$InternalNavigationSplitscreenListener
extends NavigationSplitscreenListenerAdapter {
    private boolean locationReceived;

    @Override
    public void updateLocationInfo(INavigationLocation iNavigationLocation) {
        this.locationReceived = true;
        ServiceManager.aslPropertyManager.valueChangedFixFormatterFieldData(42210560, iNavigationLocation.getLocationFormatter());
    }

    @Override
    public void updateCompassDegree(int n) {
        int n2 = n < 23 ? 1 : (n < 68 ? 8 : (n < 113 ? 7 : (n < 158 ? 6 : (n < 203 ? 5 : (n < 248 ? 4 : (n < 293 ? 3 : (n < 338 ? 2 : 1)))))));
        ServiceManager.aslPropertyManager.valueChangedInteger(159651072, n2);
    }

    @Override
    public void updatePositionInfo(INavigationPosPosition iNavigationPosPosition) {
        if (!this.locationReceived) {
            ServiceManager.aslPropertyManager.valueChangedFixFormatterFieldData(42210560, ASLNavigationFactory.getNavigationApi().createNavigationLocation(iNavigationPosPosition.getLatitude(), iNavigationPosPosition.getLongitude()).getLocationFormatter());
        }
    }
}

