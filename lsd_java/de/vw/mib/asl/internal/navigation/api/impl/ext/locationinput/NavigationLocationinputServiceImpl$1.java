/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.api.impl.ext.locationinput;

import de.vw.mib.asl.api.navigation.locationinput.IHnrFlags;
import de.vw.mib.asl.api.navigation.locationinput.ILocationinputResultListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.api.impl.ext.locationinput.NavigationLocationinputServiceImpl;
import java.util.Iterator;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueList;

final class NavigationLocationinputServiceImpl$1
implements ILocationinputResultListener {
    NavigationLocationinputServiceImpl$1() {
    }

    @Override
    public void updateState(NavLocation navLocation, int[] nArray, boolean bl, boolean bl2, boolean bl3) {
        block2: {
            if (NavigationLocationinputServiceImpl.logger.isTraceEnabled()) {
                NavigationLocationinputServiceImpl.logger.makeTrace().append("NavigationLocationinputServiceImpl: updateState with location ").append(navLocation).log();
            }
            NavigationLocationinputServiceImpl.currentLocation = navLocation;
            Iterator iterator = NavigationLocationinputServiceImpl.serviceInstances.iterator();
            if (!iterator.hasNext()) break block2;
            NavigationLocationinputServiceImpl navigationLocationinputServiceImpl = (NavigationLocationinputServiceImpl)iterator.next();
            if (navigationLocationinputServiceImpl.navigationExtServiceImpl.locationInputLockOwner != null && navigationLocationinputServiceImpl.navigationExtServiceImpl.locationInputLockOwner instanceof NavigationLocationinputServiceImpl) {
                ((NavigationLocationinputServiceImpl)navigationLocationinputServiceImpl.navigationExtServiceImpl.locationInputLockOwner).notifyInputState(navLocation, nArray, bl, bl2, bl3);
            }
        }
    }

    @Override
    public void updateInputActive(boolean bl) {
        Iterator iterator = NavigationLocationinputServiceImpl.serviceInstances.iterator();
        while (iterator.hasNext()) {
            NavigationLocationinputServiceImpl navigationLocationinputServiceImpl = (NavigationLocationinputServiceImpl)iterator.next();
            if (navigationLocationinputServiceImpl.listener == null) continue;
            navigationLocationinputServiceImpl.listener.updateInputActive(bl);
        }
    }

    @Override
    public void updateValueList(LIValueList lIValueList, long l, IHnrFlags iHnrFlags) {
        block1: {
            Iterator iterator = NavigationLocationinputServiceImpl.serviceInstances.iterator();
            if (!iterator.hasNext()) break block1;
            NavigationLocationinputServiceImpl navigationLocationinputServiceImpl = (NavigationLocationinputServiceImpl)iterator.next();
            if (navigationLocationinputServiceImpl.navigationExtServiceImpl.locationInputLockOwner != null && navigationLocationinputServiceImpl.navigationExtServiceImpl.locationInputLockOwner instanceof NavigationLocationinputServiceImpl) {
                ((NavigationLocationinputServiceImpl)navigationLocationinputServiceImpl.navigationExtServiceImpl.locationInputLockOwner).notifyValueList(lIValueList, l, iHnrFlags);
            }
        }
    }

    @Override
    public void haptikTakesOwnership() {
        block3: {
            Iterator iterator = NavigationLocationinputServiceImpl.serviceInstances.iterator();
            if (!iterator.hasNext()) break block3;
            NavigationLocationinputServiceImpl navigationLocationinputServiceImpl = (NavigationLocationinputServiceImpl)iterator.next();
            if (navigationLocationinputServiceImpl.navigationExtServiceImpl.locationInputLockOwner != null) {
                try {
                    navigationLocationinputServiceImpl.navigationExtServiceImpl.locationInputLockOwner.unlock();
                }
                catch (Exception exception) {
                    ServiceManager.errorHandler.handleError(exception);
                }
            }
        }
    }
}

