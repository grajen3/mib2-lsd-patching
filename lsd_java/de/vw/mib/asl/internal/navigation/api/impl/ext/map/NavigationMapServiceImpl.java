/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.api.impl.ext.map;

import de.vw.mib.asl.api.navigation.map.ASLNavigationMapConfiguration;
import de.vw.mib.asl.api.navigation.map.ASLNavigationMapFactory;
import de.vw.mib.asl.api.navigation.map.NavigationMapListener;
import de.vw.mib.asl.api.navigation.map.NavigationMapService;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.api.impl.ext.NavigationExtServiceImpl;
import de.vw.mib.asl.internal.navigation.util.WeakIdentityHashSet;
import java.util.Iterator;
import org.dsi.ifc.map.Point;

public class NavigationMapServiceImpl
implements NavigationMapService {
    private static WeakIdentityHashSet serviceInstances = new WeakIdentityHashSet();
    private static int activeMapType = 1;
    private static int lastMapType = 1;
    public NavigationMapListener listener;
    public NavigationExtServiceImpl navigationExtServiceImpl;

    public static void notifyMapType(int n) {
        activeMapType = n;
        Iterator iterator = serviceInstances.iterator();
        while (iterator.hasNext()) {
            NavigationMapServiceImpl navigationMapServiceImpl = (NavigationMapServiceImpl)iterator.next();
            if (navigationMapServiceImpl == null || navigationMapServiceImpl.listener == null) continue;
            try {
                navigationMapServiceImpl.listener.updateMapType(n);
            }
            catch (Exception exception) {
                ServiceManager.errorHandler.handleError(exception);
            }
        }
    }

    public static void notifyLastMapType(int n) {
        lastMapType = n;
        Iterator iterator = serviceInstances.iterator();
        while (iterator.hasNext()) {
            NavigationMapServiceImpl navigationMapServiceImpl = (NavigationMapServiceImpl)iterator.next();
            if (navigationMapServiceImpl == null || navigationMapServiceImpl.listener == null) continue;
            try {
                navigationMapServiceImpl.listener.updateLastMapType(n);
            }
            catch (Exception exception) {
                ServiceManager.errorHandler.handleError(exception);
            }
        }
    }

    public static void notifyClientUsedMapService(Object object) {
        Iterator iterator = serviceInstances.iterator();
        while (iterator.hasNext()) {
            NavigationMapServiceImpl navigationMapServiceImpl = (NavigationMapServiceImpl)iterator.next();
            if (navigationMapServiceImpl == null || navigationMapServiceImpl.listener == null) continue;
            try {
                navigationMapServiceImpl.listener.updateMapViewerUsedBy(object);
            }
            catch (Exception exception) {
                ServiceManager.errorHandler.handleError(exception);
            }
        }
    }

    public static void notifyHeadingValueChanged(int n) {
        Iterator iterator = serviceInstances.iterator();
        while (iterator.hasNext()) {
            NavigationMapServiceImpl navigationMapServiceImpl = (NavigationMapServiceImpl)iterator.next();
            if (navigationMapServiceImpl == null || navigationMapServiceImpl.listener == null) continue;
            try {
                navigationMapServiceImpl.listener.updateHeadingValue(n);
            }
            catch (Exception exception) {
                ServiceManager.errorHandler.handleError(exception);
            }
        }
    }

    public static void notifyZoomValueChanged(int n) {
        Iterator iterator = serviceInstances.iterator();
        while (iterator.hasNext()) {
            NavigationMapServiceImpl navigationMapServiceImpl = (NavigationMapServiceImpl)iterator.next();
            if (navigationMapServiceImpl == null || navigationMapServiceImpl.listener == null) continue;
            try {
                navigationMapServiceImpl.listener.updateZoomValue(n);
            }
            catch (Exception exception) {
                ServiceManager.errorHandler.handleError(exception);
            }
        }
    }

    public static void notifyAltitudeValueChanged(int n) {
        Iterator iterator = serviceInstances.iterator();
        while (iterator.hasNext()) {
            NavigationMapServiceImpl navigationMapServiceImpl = (NavigationMapServiceImpl)iterator.next();
            if (navigationMapServiceImpl == null || navigationMapServiceImpl.listener == null) continue;
            try {
                navigationMapServiceImpl.listener.updateAltitudeValue(n);
            }
            catch (Exception exception) {
                ServiceManager.errorHandler.handleError(exception);
            }
        }
    }

    public static void notifyAutozoomStatusChanged(boolean bl) {
        Iterator iterator = serviceInstances.iterator();
        while (iterator.hasNext()) {
            NavigationMapServiceImpl navigationMapServiceImpl = (NavigationMapServiceImpl)iterator.next();
            if (navigationMapServiceImpl == null || navigationMapServiceImpl.listener == null) continue;
            try {
                navigationMapServiceImpl.listener.updateAutozoom(bl);
            }
            catch (Exception exception) {
                ServiceManager.errorHandler.handleError(exception);
            }
        }
    }

    public static void notifyOrientationChanged(int n) {
        Iterator iterator = serviceInstances.iterator();
        while (iterator.hasNext()) {
            NavigationMapServiceImpl navigationMapServiceImpl = (NavigationMapServiceImpl)iterator.next();
            if (navigationMapServiceImpl == null || navigationMapServiceImpl.listener == null) continue;
            try {
                navigationMapServiceImpl.listener.updateOrientation(n);
            }
            catch (Exception exception) {
                ServiceManager.errorHandler.handleError(exception);
            }
        }
    }

    public static void notifyViewTypeChanged(int n) {
        Iterator iterator = serviceInstances.iterator();
        while (iterator.hasNext()) {
            NavigationMapServiceImpl navigationMapServiceImpl = (NavigationMapServiceImpl)iterator.next();
            if (navigationMapServiceImpl == null || navigationMapServiceImpl.listener == null) continue;
            try {
                navigationMapServiceImpl.listener.updateViewType(n);
            }
            catch (Exception exception) {
                ServiceManager.errorHandler.handleError(exception);
            }
        }
    }

    public static void notifyMapModeChanged(int n) {
        Iterator iterator = serviceInstances.iterator();
        while (iterator.hasNext()) {
            NavigationMapServiceImpl navigationMapServiceImpl = (NavigationMapServiceImpl)iterator.next();
            if (navigationMapServiceImpl == null || navigationMapServiceImpl.listener == null) continue;
            try {
                navigationMapServiceImpl.listener.updateMapMode(n);
            }
            catch (Exception exception) {
                ServiceManager.errorHandler.handleError(exception);
            }
        }
    }

    public static void notifyMapPerspectiveChanged(int n) {
        Iterator iterator = serviceInstances.iterator();
        while (iterator.hasNext()) {
            NavigationMapServiceImpl navigationMapServiceImpl = (NavigationMapServiceImpl)iterator.next();
            if (navigationMapServiceImpl == null || navigationMapServiceImpl.listener == null) continue;
            try {
                navigationMapServiceImpl.listener.updateMapPerspective(n);
            }
            catch (Exception exception) {
                ServiceManager.errorHandler.handleError(exception);
            }
        }
    }

    public static void notifyGoogleEarthDataStatusChanged(int n) {
        Iterator iterator = serviceInstances.iterator();
        while (iterator.hasNext()) {
            NavigationMapServiceImpl navigationMapServiceImpl = (NavigationMapServiceImpl)iterator.next();
            if (navigationMapServiceImpl == null || navigationMapServiceImpl.listener == null) continue;
            try {
                navigationMapServiceImpl.listener.updateGoogleEarthDataStatus(n);
            }
            catch (Exception exception) {
                ServiceManager.errorHandler.handleError(exception);
            }
        }
    }

    public static void notifyMapViewerSwitchRunning(boolean bl) {
        Iterator iterator = serviceInstances.iterator();
        while (iterator.hasNext()) {
            NavigationMapServiceImpl navigationMapServiceImpl = (NavigationMapServiceImpl)iterator.next();
            if (navigationMapServiceImpl == null || navigationMapServiceImpl.listener == null) continue;
            try {
                navigationMapServiceImpl.listener.updateMapViewerSwitchRunning(bl);
            }
            catch (Exception exception) {
                ServiceManager.errorHandler.handleError(exception);
            }
        }
    }

    public NavigationMapServiceImpl(NavigationMapListener navigationMapListener, NavigationExtServiceImpl navigationExtServiceImpl) {
        this.listener = navigationMapListener;
        this.navigationExtServiceImpl = navigationExtServiceImpl;
        serviceInstances.add(this);
    }

    @Override
    public void clickInMap(int n, int n2) {
        this.navigationExtServiceImpl.checkLockMapViewer(this);
        this.navigationExtServiceImpl.mainMapService.clickInMap(new Point(n, n2));
    }

    @Override
    public void dragMap(short s, short s2) {
        this.navigationExtServiceImpl.checkLockMapViewer(this);
        this.navigationExtServiceImpl.mainMapService.dragMap(s, s2);
    }

    @Override
    public void dragMapStop() {
        this.navigationExtServiceImpl.checkLockMapViewer(this);
        this.navigationExtServiceImpl.mainMapService.dragMapStop();
    }

    @Override
    public void goToLocation(ASLNavigationMapConfiguration aSLNavigationMapConfiguration) {
        this.navigationExtServiceImpl.checkLockMapViewer(this);
        this.navigationExtServiceImpl.mainMapService.goToLocation(aSLNavigationMapConfiguration, true);
    }

    @Override
    public void goToLocationWithoutLocking(ASLNavigationMapConfiguration aSLNavigationMapConfiguration) {
        this.navigationExtServiceImpl.mainMapService.goToLocation(aSLNavigationMapConfiguration, false);
    }

    @Override
    public void lockMapViewer() {
        this.navigationExtServiceImpl.tryLockMapViwer(this);
    }

    @Override
    public void setTrafficIncidents(boolean bl) {
        this.navigationExtServiceImpl.checkLockMapViewer(this);
        this.navigationExtServiceImpl.mainMapService.setTrafficIncidents(bl);
    }

    @Override
    public void unlockMapViewer() {
        this.navigationExtServiceImpl.unlockMapViewer(this);
    }

    @Override
    public void zoomIn() {
        this.navigationExtServiceImpl.checkLockMapViewer(this);
        this.navigationExtServiceImpl.mainMapService.zoomIn();
    }

    @Override
    public void zoomOut() {
        this.navigationExtServiceImpl.checkLockMapViewer(this);
        this.navigationExtServiceImpl.mainMapService.zoomOut();
    }

    @Override
    public void zoomTwoFingers(int n, int n2, int n3, int n4) {
        this.navigationExtServiceImpl.checkLockMapViewer(this);
        this.navigationExtServiceImpl.mainMapService.zoomTwoFingers(n, n2, n3, n4);
    }

    @Override
    public void zoomTwoFingersStop() {
        this.navigationExtServiceImpl.checkLockMapViewer(this);
        this.navigationExtServiceImpl.mainMapService.zoomTwoFingersStop();
    }

    @Override
    public boolean isMapServiceReady() {
        return this.navigationExtServiceImpl.isMapServiceReady();
    }

    @Override
    public boolean isMapServiceLocked() {
        return this.navigationExtServiceImpl.isMapServiceLocked();
    }

    @Override
    public boolean isMapServiceLockedByMe() {
        return this.navigationExtServiceImpl.isMapServiceLockedByMe(this);
    }

    @Override
    public void freeService() {
        serviceInstances.remove(this);
    }

    @Override
    public void configureVicsEventNoticeMap(long l) {
        this.navigationExtServiceImpl.checkLockMapViewer(this);
        this.navigationExtServiceImpl.mainMapService.configureVicsEventNoticeMap(l);
    }

    @Override
    public void setGeneralPoiVisibility(boolean bl) {
        this.navigationExtServiceImpl.checkLockMapViewer(this);
        this.navigationExtServiceImpl.mainMapService.setGeneralPoiVisibility(bl);
    }

    @Override
    public void releaseView() {
        this.navigationExtServiceImpl.mainMapService.releaseView();
    }

    @Override
    public void mapVisibleInOtherContext(boolean bl) {
        ASLNavigationMapFactory.getNavigationMapApi().sendEvMapVisibleInAnotherContext(bl);
    }

    @Override
    public void activateOverviewZoom() {
        ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainActivateOverviewZoom();
    }

    @Override
    public void deactivateOverviewZoom() {
        this.navigationExtServiceImpl.mainMapService.deactivateOverviewZoom();
    }

    @Override
    public void setHotPoint(int n, int n2) {
        ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainHotPointChanged(n, n2);
    }

    @Override
    public void setCarsorPosition(int n, int n2) {
        ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainCarsorPositionChanged(n, n2);
    }

    @Override
    public void setManeuverViewStyle(int n) {
    }

    @Override
    public int getMapType() {
        return activeMapType;
    }

    @Override
    public int getMainMapZoomLevel() {
        return this.navigationExtServiceImpl.mainMapService.getMainMapZoomLevel();
    }

    @Override
    public void viewSetVisible() {
        this.navigationExtServiceImpl.mainMapService.viewSetVisible();
    }

    @Override
    public void viewSetInvisible() {
        this.navigationExtServiceImpl.mainMapService.viewSetInvisible();
    }

    @Override
    public void ensureTMCVisibility(long l) {
        this.navigationExtServiceImpl.mainMapService.ensureTMCVisibility(l);
    }

    @Override
    public boolean isAutozoomActivated() {
        return ASLNavigationMapFactory.getNavigationMapApi().isAutozoomActivated();
    }

    @Override
    public void autozoomForcedByOtherContext(boolean bl) {
        ASLNavigationMapFactory.getNavigationMapApi().sendEvAutozoomForcedByOtherContext(bl);
    }

    @Override
    public void setZoomArea(int n, int n2, int n3, int n4) {
        ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainSetZoomArea(n, n2, n3, n4);
    }

    @Override
    public int getLastMapType() {
        return lastMapType;
    }

    @Override
    public int getMainMapPerspective() {
        return this.navigationExtServiceImpl.mainMapService.getMainMapPerspective();
    }

    @Override
    public boolean isAutozoomDeactivatedWhileDrag() {
        return ASLNavigationMapFactory.getNavigationMapApi().isAutozoomDeactivatedWhileDrag();
    }

    @Override
    public int getHeadingValue() {
        return this.navigationExtServiceImpl.mainMapService.getHeadingValue();
    }
}

