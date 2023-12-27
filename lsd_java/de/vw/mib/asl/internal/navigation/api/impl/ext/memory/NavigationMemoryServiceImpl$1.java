/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.api.impl.ext.memory;

import de.vw.mib.asl.api.navigation.guidance.IOnlineTourImportListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.api.impl.ext.memory.NavigationMemoryServiceImpl;
import java.util.Iterator;
import org.dsi.ifc.navigation.NavRmRouteListArrayData;

final class NavigationMemoryServiceImpl$1
implements IOnlineTourImportListener {
    NavigationMemoryServiceImpl$1() {
    }

    @Override
    public void onTourDownload() {
        Iterator iterator = NavigationMemoryServiceImpl.serviceInstances.iterator();
        if (ServiceManager.logger.isTraceEnabled(16384)) {
            ServiceManager.logger.trace(16384, new StringBuffer().append("Number of registered NavigationMemoryServiceImpl = ").append(NavigationMemoryServiceImpl.serviceInstances.size()).toString());
        }
        while (iterator.hasNext()) {
            NavigationMemoryServiceImpl navigationMemoryServiceImpl = (NavigationMemoryServiceImpl)iterator.next();
            if (navigationMemoryServiceImpl != null && navigationMemoryServiceImpl.listener != null) {
                try {
                    if (ServiceManager.logger.isTraceEnabled(16384)) {
                        ServiceManager.logger.trace(16384, "doTourDownload()");
                    }
                    navigationMemoryServiceImpl.listener.doTourDownload();
                    if (!ServiceManager.logger.isTraceEnabled(16384)) continue;
                    ServiceManager.logger.trace(16384, "doTourDownload() -  was called.");
                }
                catch (Exception exception) {
                    ServiceManager.errorHandler.handleError(exception);
                }
                continue;
            }
            if (!ServiceManager.logger.isTraceEnabled(16384)) continue;
            ServiceManager.logger.warn(16384, "NavigationMemoryServiceImpl was null");
        }
    }

    @Override
    public void abortTourDownload() {
        NavigationMemoryServiceImpl.handleAbortDownload();
    }

    @Override
    public void importToursFromGpxResult(int n) {
        Iterator iterator = NavigationMemoryServiceImpl.serviceInstances.iterator();
        while (iterator.hasNext()) {
            NavigationMemoryServiceImpl navigationMemoryServiceImpl = (NavigationMemoryServiceImpl)iterator.next();
            if (navigationMemoryServiceImpl == null || navigationMemoryServiceImpl.listener == null) continue;
            try {
                navigationMemoryServiceImpl.listener.importToursFromGpxResult(n);
            }
            catch (Exception exception) {
                ServiceManager.errorHandler.handleError(exception);
            }
        }
    }

    @Override
    public void updateTourMemoryCapacity() {
        this.updateTourMemoryCapacityManually(null);
    }

    @Override
    public void updateTourList(NavRmRouteListArrayData navRmRouteListArrayData) {
        NavigationMemoryServiceImpl.notifyTourMemoryCapacity();
    }

    @Override
    public void updateTourMemoryCapacityManually(Integer n) {
        if (ServiceManager.logger.isTraceEnabled(16384)) {
            ServiceManager.logger.trace(16384, new StringBuffer().append("updateTourMemoryCapacityManually( Integer newCapacity = ").append(n).append(") + ").toString());
        }
        Iterator iterator = NavigationMemoryServiceImpl.serviceInstances.iterator();
        while (iterator.hasNext()) {
            NavigationMemoryServiceImpl navigationMemoryServiceImpl = (NavigationMemoryServiceImpl)iterator.next();
            if (navigationMemoryServiceImpl == null || navigationMemoryServiceImpl.listener == null) continue;
            try {
                int n2;
                int n3 = n2 = n == null ? navigationMemoryServiceImpl.getTourMemoryCapacity() : n.intValue();
                if (ServiceManager.logger.isTraceEnabled(16384)) {
                    ServiceManager.logger.trace(16384, new StringBuffer().append("calling updateTourMemoryCapacity( int tourMemoryCapacity = ").append(n2).append(") + ").toString());
                }
                navigationMemoryServiceImpl.listener.updateTourMemoryCapacity(n2);
            }
            catch (Exception exception) {
                ServiceManager.errorHandler.handleError(exception);
            }
        }
    }
}

