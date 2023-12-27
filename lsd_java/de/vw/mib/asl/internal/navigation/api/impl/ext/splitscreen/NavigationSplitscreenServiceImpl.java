/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.api.impl.ext.splitscreen;

import de.vw.mib.asl.api.navigation.INavigationPosPosition;
import de.vw.mib.asl.api.navigation.IOverlayData;
import de.vw.mib.asl.api.navigation.splitscreen.ASLManeuverViewElement;
import de.vw.mib.asl.api.navigation.splitscreen.ASLNavigationSplitscreenFactory;
import de.vw.mib.asl.api.navigation.splitscreen.NavigationSplitscreenListener;
import de.vw.mib.asl.api.navigation.splitscreen.NavigationSplitscreenService;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.api.impl.ext.INavigationLocationImpl;
import de.vw.mib.asl.internal.navigation.api.impl.ext.INavigationPosPositionImpl;
import de.vw.mib.asl.internal.navigation.api.impl.ext.NavigationExtServiceImpl;
import de.vw.mib.asl.internal.navigation.util.WeakIdentityHashSet;
import java.util.Iterator;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.PosPosition;

public class NavigationSplitscreenServiceImpl
implements NavigationSplitscreenService {
    final NavigationSplitscreenListener navigationSplitscreenListener;
    private static WeakIdentityHashSet serviceInstances = new WeakIdentityHashSet();
    private static IExtLogger LOGGER = null;

    public NavigationSplitscreenServiceImpl(NavigationSplitscreenListener navigationSplitscreenListener) {
        this.navigationSplitscreenListener = navigationSplitscreenListener;
        serviceInstances.add(this);
    }

    public NavigationSplitscreenServiceImpl(NavigationSplitscreenListener navigationSplitscreenListener, NavigationExtServiceImpl navigationExtServiceImpl) {
        this.navigationSplitscreenListener = navigationSplitscreenListener;
        serviceInstances.add(this);
    }

    public static void setOverlayIndex(int n) {
        NavigationSplitscreenServiceImpl.getLOGGER().trace("setOverlayIndex");
        Iterator iterator = serviceInstances.iterator();
        while (iterator.hasNext()) {
            NavigationSplitscreenServiceImpl navigationSplitscreenServiceImpl = (NavigationSplitscreenServiceImpl)iterator.next();
            if (navigationSplitscreenServiceImpl == null || navigationSplitscreenServiceImpl.navigationSplitscreenListener == null) continue;
            navigationSplitscreenServiceImpl.navigationSplitscreenListener.updateOverlayIndex(n);
        }
    }

    public static void setOverlayData(IOverlayData iOverlayData) {
        NavigationSplitscreenServiceImpl.getLOGGER().trace("setOverlayData");
        Iterator iterator = serviceInstances.iterator();
        while (iterator.hasNext()) {
            NavigationSplitscreenServiceImpl navigationSplitscreenServiceImpl = (NavigationSplitscreenServiceImpl)iterator.next();
            if (navigationSplitscreenServiceImpl == null || navigationSplitscreenServiceImpl.navigationSplitscreenListener == null) continue;
            navigationSplitscreenServiceImpl.navigationSplitscreenListener.updateOverlayData(iOverlayData);
        }
    }

    public static void setOverlayCount(int n) {
        NavigationSplitscreenServiceImpl.getLOGGER().trace("setOverlayCurrentCount");
        Iterator iterator = serviceInstances.iterator();
        while (iterator.hasNext()) {
            NavigationSplitscreenServiceImpl navigationSplitscreenServiceImpl = (NavigationSplitscreenServiceImpl)iterator.next();
            if (navigationSplitscreenServiceImpl == null || navigationSplitscreenServiceImpl.navigationSplitscreenListener == null) continue;
            navigationSplitscreenServiceImpl.navigationSplitscreenListener.updateOverlayCount(n);
        }
    }

    public static void setOverlayCurrentContent(int n) {
        NavigationSplitscreenServiceImpl.getLOGGER().trace("setOverlayCurrentContent");
        Iterator iterator = serviceInstances.iterator();
        while (iterator.hasNext()) {
            NavigationSplitscreenServiceImpl navigationSplitscreenServiceImpl = (NavigationSplitscreenServiceImpl)iterator.next();
            if (navigationSplitscreenServiceImpl == null || navigationSplitscreenServiceImpl.navigationSplitscreenListener == null) continue;
            navigationSplitscreenServiceImpl.navigationSplitscreenListener.updateOverlayCurrentContent(n);
        }
    }

    public static void setCompassDegree(int n) {
        NavigationSplitscreenServiceImpl.getLOGGER().trace("setCompassDegree");
        Iterator iterator = serviceInstances.iterator();
        while (iterator.hasNext()) {
            NavigationSplitscreenServiceImpl navigationSplitscreenServiceImpl = (NavigationSplitscreenServiceImpl)iterator.next();
            if (navigationSplitscreenServiceImpl == null || navigationSplitscreenServiceImpl.navigationSplitscreenListener == null) continue;
            navigationSplitscreenServiceImpl.navigationSplitscreenListener.updateCompassDegree(n);
        }
    }

    public static void setCompassStreet(String string) {
        NavigationSplitscreenServiceImpl.getLOGGER().trace("setCompassStreet");
        Iterator iterator = serviceInstances.iterator();
        while (iterator.hasNext()) {
            NavigationSplitscreenServiceImpl navigationSplitscreenServiceImpl = (NavigationSplitscreenServiceImpl)iterator.next();
            if (navigationSplitscreenServiceImpl == null || navigationSplitscreenServiceImpl.navigationSplitscreenListener == null) continue;
            navigationSplitscreenServiceImpl.navigationSplitscreenListener.updateCompassStreet(string);
        }
    }

    public static void setLocationInfo(NavLocation navLocation) {
        NavigationSplitscreenServiceImpl.getLOGGER().trace("setLocationInfo");
        Iterator iterator = serviceInstances.iterator();
        while (iterator.hasNext()) {
            NavigationSplitscreenServiceImpl navigationSplitscreenServiceImpl = (NavigationSplitscreenServiceImpl)iterator.next();
            if (navigationSplitscreenServiceImpl == null || navigationSplitscreenServiceImpl.navigationSplitscreenListener == null) continue;
            INavigationLocationImpl iNavigationLocationImpl = new INavigationLocationImpl(navLocation);
            navigationSplitscreenServiceImpl.navigationSplitscreenListener.updateLocationInfo(iNavigationLocationImpl);
        }
    }

    public static void setPositionInfo(PosPosition posPosition) {
        NavigationSplitscreenServiceImpl.getLOGGER().trace("setPositionInfo");
        Iterator iterator = serviceInstances.iterator();
        while (iterator.hasNext()) {
            NavigationSplitscreenServiceImpl navigationSplitscreenServiceImpl = (NavigationSplitscreenServiceImpl)iterator.next();
            if (navigationSplitscreenServiceImpl == null || navigationSplitscreenServiceImpl.navigationSplitscreenListener == null) continue;
            INavigationPosPositionImpl iNavigationPosPositionImpl = new INavigationPosPositionImpl(posPosition);
            navigationSplitscreenServiceImpl.navigationSplitscreenListener.updatePositionInfo(iNavigationPosPositionImpl);
        }
    }

    public static void setRMLInformation(ASLManeuverViewElement[] aSLManeuverViewElementArray) {
        NavigationSplitscreenServiceImpl.getLOGGER().trace("setRMLInformation");
        Iterator iterator = serviceInstances.iterator();
        while (iterator.hasNext()) {
            NavigationSplitscreenServiceImpl navigationSplitscreenServiceImpl = (NavigationSplitscreenServiceImpl)iterator.next();
            if (navigationSplitscreenServiceImpl == null || navigationSplitscreenServiceImpl.navigationSplitscreenListener == null) continue;
            navigationSplitscreenServiceImpl.navigationSplitscreenListener.updateRMLInformation(aSLManeuverViewElementArray);
        }
    }

    private static IExtLogger getLOGGER() {
        if (LOGGER == null) {
            LOGGER = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(16384, "[NavigationSplitscreenServiceImpl]");
        }
        return LOGGER;
    }

    @Override
    public void freeService() {
        serviceInstances.remove(this);
    }

    @Override
    public INavigationPosPosition getCurrentPosition() {
        return new INavigationPosPositionImpl(ASLNavigationSplitscreenFactory.getNavigationSplitscreenApi().getCurrentPosition());
    }

    @Override
    public void setSplitScreenContent(int n) {
        ASLNavigationSplitscreenFactory.getNavigationSplitscreenApi().setSplitScreenContent(n);
    }
}

