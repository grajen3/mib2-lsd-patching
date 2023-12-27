/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.tvtuner.lists;

import de.vw.mib.asl.internal.tvtuner.accessor.TVTunerObjectAccessor;
import de.vw.mib.asl.internal.tvtuner.common.TVTunerHelper;
import org.dsi.ifc.tvtuner.ServiceInfo;

public abstract class AbstractListHandler {
    protected void activateSelectedService(ServiceInfo serviceInfo) {
        long l = serviceInfo.getNamePID();
        int n = serviceInfo.getServicePID();
        int n2 = serviceInfo.getSType();
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace(new StringBuffer().append(super.getClass().getName()).append("#activateSelectedService - call DSITVTuner#selectService for service: ").append(serviceInfo.toString()).toString());
        }
        TVTunerObjectAccessor.getTargetTVTunerDSI().getDSITVTuner().selectService(l, n, n2);
    }

    protected int getListindexForServiceInfo(ServiceInfo serviceInfo, ServiceInfo[] serviceInfoArray, boolean bl) {
        int n = -1;
        for (int i2 = 0; i2 < serviceInfoArray.length; ++i2) {
            if (bl) {
                if (serviceInfoArray[i2].getNamePID() != serviceInfo.getNamePID() || serviceInfoArray[i2].getServicePID() != serviceInfo.getServicePID()) continue;
                n = i2;
                break;
            }
            if (serviceInfoArray[i2].getNamePID() != serviceInfo.getNamePID()) continue;
            n = i2;
            break;
        }
        return n;
    }

    protected ServiceInfo[] addServiceInfoAtPosition(int n, ServiceInfo[] serviceInfoArray, ServiceInfo serviceInfo) {
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace(new StringBuffer().append("StationListHandler#addServiceInfoAtFirstPosition called - ServiceInfo = ").append(serviceInfo.toString()).toString());
        }
        ServiceInfo[] serviceInfoArray2 = new ServiceInfo[serviceInfoArray.length + 1];
        serviceInfoArray2[0] = serviceInfo;
        for (int i2 = 1; i2 < serviceInfoArray2.length; ++i2) {
            serviceInfoArray2[i2] = serviceInfoArray[i2 - 1];
        }
        return serviceInfoArray2;
    }
}

