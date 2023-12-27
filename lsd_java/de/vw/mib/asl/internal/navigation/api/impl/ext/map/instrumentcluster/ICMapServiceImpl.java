/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.api.impl.ext.map.instrumentcluster;

import de.vw.mib.asl.api.navigation.map.instrumentcluster.ICMapListener;
import de.vw.mib.asl.api.navigation.map.instrumentcluster.ICMapService;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.api.impl.ext.NavigationExtServiceImpl;
import de.vw.mib.asl.internal.navigation.util.WeakIdentityHashSet;
import java.util.Iterator;

public class ICMapServiceImpl
implements ICMapService {
    private static WeakIdentityHashSet serviceInstances = new WeakIdentityHashSet();
    public ICMapListener listener;
    public NavigationExtServiceImpl navigationExtServiceImpl;

    public ICMapServiceImpl(ICMapListener iCMapListener, NavigationExtServiceImpl navigationExtServiceImpl) {
        this.listener = iCMapListener;
        this.navigationExtServiceImpl = navigationExtServiceImpl;
        serviceInstances.add(this);
    }

    @Override
    public void setMapSwitchState(int n) {
        this.navigationExtServiceImpl.mainMapService.setMapSwitchState(n);
    }

    public static void notifyUpdateKombiMapStatus(int n) {
        Iterator iterator = serviceInstances.iterator();
        while (iterator.hasNext()) {
            ICMapServiceImpl iCMapServiceImpl = (ICMapServiceImpl)iterator.next();
            if (iCMapServiceImpl == null || iCMapServiceImpl.listener == null) continue;
            try {
                iCMapServiceImpl.listener.updateKombiMapStatus(n);
            }
            catch (Exception exception) {
                ServiceManager.errorHandler.handleError(exception);
            }
        }
    }

    public static void notifyUpdateKombiMapVisibility(int n) {
        Iterator iterator = serviceInstances.iterator();
        while (iterator.hasNext()) {
            ICMapServiceImpl iCMapServiceImpl = (ICMapServiceImpl)iterator.next();
            if (iCMapServiceImpl == null || iCMapServiceImpl.listener == null) continue;
            try {
                iCMapServiceImpl.listener.updateKombiMapVisibility(n);
            }
            catch (Exception exception) {
                ServiceManager.errorHandler.handleError(exception);
            }
        }
    }

    public static void notifyUpdateMapSwitchState(int n) {
        Iterator iterator = serviceInstances.iterator();
        while (iterator.hasNext()) {
            ICMapServiceImpl iCMapServiceImpl = (ICMapServiceImpl)iterator.next();
            if (iCMapServiceImpl == null || iCMapServiceImpl.listener == null) continue;
            try {
                iCMapServiceImpl.listener.updateMapSwitchState(n);
            }
            catch (Exception exception) {
                ServiceManager.errorHandler.handleError(exception);
            }
        }
    }

    public static void notifyUpdateNavigationMapInAbtVisibility(int n) {
        Iterator iterator = serviceInstances.iterator();
        while (iterator.hasNext()) {
            ICMapServiceImpl iCMapServiceImpl = (ICMapServiceImpl)iterator.next();
            if (iCMapServiceImpl == null || iCMapServiceImpl.listener == null) continue;
            try {
                iCMapServiceImpl.listener.updateNavigationMapInAbtVisibility(n);
            }
            catch (Exception exception) {
                ServiceManager.errorHandler.handleError(exception);
            }
        }
    }

    public static void notifyUpdateICMapServiceState(int n) {
        Iterator iterator = serviceInstances.iterator();
        while (iterator.hasNext()) {
            ICMapServiceImpl iCMapServiceImpl = (ICMapServiceImpl)iterator.next();
            if (iCMapServiceImpl == null || iCMapServiceImpl.listener == null) continue;
            try {
                iCMapServiceImpl.listener.updateICMapServiceState(n);
            }
            catch (Exception exception) {
                ServiceManager.errorHandler.handleError(exception);
            }
        }
    }

    public static void notifySwitchMapToAbt() {
        Iterator iterator = serviceInstances.iterator();
        while (iterator.hasNext()) {
            ICMapServiceImpl iCMapServiceImpl = (ICMapServiceImpl)iterator.next();
            if (iCMapServiceImpl == null || iCMapServiceImpl.listener == null) continue;
            try {
                iCMapServiceImpl.listener.switchMapToAbt();
            }
            catch (Exception exception) {
                ServiceManager.errorHandler.handleError(exception);
            }
        }
    }

    public static void notifySwitchMapToKombi() {
        Iterator iterator = serviceInstances.iterator();
        while (iterator.hasNext()) {
            ICMapServiceImpl iCMapServiceImpl = (ICMapServiceImpl)iterator.next();
            if (iCMapServiceImpl == null || iCMapServiceImpl.listener == null) continue;
            try {
                iCMapServiceImpl.listener.switchMapToKombi();
            }
            catch (Exception exception) {
                ServiceManager.errorHandler.handleError(exception);
            }
        }
    }

    @Override
    public void freeService() {
        serviceInstances.remove(this);
    }

    @Override
    public int getMapSwitchState() {
        return this.navigationExtServiceImpl.getMapSwitchState();
    }

    @Override
    public boolean getMapVisibilityForFPKSwitch() {
        return this.navigationExtServiceImpl.getMapVisibilityForFPKSwitch();
    }

    @Override
    public void failedToPerformSwitch() {
    }

    @Override
    public int getMapVisibilityInAbt() {
        boolean bl = this.navigationExtServiceImpl.getMapVisibilityForFPKSwitch();
        if (bl) {
            return 1;
        }
        return 0;
    }

    @Override
    public int getICMapServiceState() {
        return this.navigationExtServiceImpl.getICMapServiceState();
    }

    @Override
    public boolean isMapSwitchFunctionAvailableInKombi() {
        return this.navigationExtServiceImpl.isMapSwitchFunctionAvailableInKombi();
    }

    @Override
    public void setMapSwitchFunctionAvailableInKombi(boolean bl) {
        this.navigationExtServiceImpl.setMapSwitchFunctionAvailableInKombi(bl);
    }

    @Override
    public boolean isMapTemporarilyInABT() {
        return this.navigationExtServiceImpl.isMapTemporarilyInABT();
    }
}

