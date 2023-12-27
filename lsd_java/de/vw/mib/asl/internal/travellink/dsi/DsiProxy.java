/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.dsi;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.travellink.TLinkServiceManager;
import de.vw.mib.asl.internal.travellink.dsi.RequestToAppParameter;
import de.vw.mib.asl.internal.travellink.list.GenericPropertyTraces;
import org.dsi.ifc.travellink.GenericProperty;

public final class DsiProxy {
    public static final int NO_UPDATE_LIMIT;
    public static final boolean UPDATE_TYPE_TRUE;
    public static final boolean UPDATE_TYPE_FALSE;
    private RequestToAppParameter[] requestParamValues = new RequestToAppParameter[60];

    public void resetRequestParamValues(int n) {
        if (n > -1 && n < this.requestParamValues.length) {
            this.requestParamValues[n] = null;
        }
    }

    public boolean isUpdateActive(int n) {
        if (n > -1 && n < this.requestParamValues.length) {
            return this.requestParamValues[n] != null;
        }
        return false;
    }

    public boolean requestToApp(int n, int n2, GenericProperty[] genericPropertyArray, int n3, int n4, int n5, int n6) {
        if (n < 0 || n >= 60) {
            if (ServiceManager.logger2.isTraceEnabled(2)) {
                ServiceManager.logger2.error(2).append("DsiProxy - requestToApp(), ERROR! requestType = ").append(n).log();
            }
            return false;
        }
        if (null == genericPropertyArray) {
            genericPropertyArray = new GenericProperty[]{};
        }
        if (ServiceManager.logger2.isTraceEnabled(2)) {
            ServiceManager.logger2.info(2).append(new StringBuffer().append("DsiProxy - requestToApp(), requestType = ").append(TLinkServiceManager.getServiceManager().getTravelLinkTrace().getRequestTypeAsString(n)).append(" , sessionId = ").toString()).append(n6).append(" , properties.length = ").append(genericPropertyArray.length).append(" , maxItemCount = ").append(n3).log();
            GenericPropertyTraces.printData(genericPropertyArray);
        }
        RequestToAppParameter requestToAppParameter = new RequestToAppParameter(n, n2, genericPropertyArray, n3, n4, n5, 0);
        if (n > -1 && n < this.requestParamValues.length) {
            this.requestParamValues[n] = requestToAppParameter;
        }
        TLinkServiceManager.getServiceManager().getDSITravelLinkCommon().requestToApp(n, n2, genericPropertyArray, n3, n4, n5, n6);
        return true;
    }

    public boolean checkIfDsiCallIsRedundant(int n, int n2, GenericProperty[] genericPropertyArray, int n3, int n4, int n5) {
        boolean bl = false;
        if (null == genericPropertyArray) {
            genericPropertyArray = new GenericProperty[]{};
        }
        RequestToAppParameter requestToAppParameter = new RequestToAppParameter(n, n2, genericPropertyArray, n3, n4, n5, 0);
        if (ServiceManager.logger2.isTraceEnabled(2)) {
            ServiceManager.logger2.info(2).append(new StringBuffer().append("DsiProxy - checkIfDsiCallIsRedundant(), requestType = ").append(TLinkServiceManager.getServiceManager().getTravelLinkTrace().getRequestTypeAsString(n)).append(" , properties.length = ").toString()).append(genericPropertyArray.length).append(" , maxItemCount = ").append(n3).log();
            GenericPropertyTraces.printData(genericPropertyArray);
        }
        if (this.checkIfDsiCallIsRedundant(requestToAppParameter)) {
            bl = true;
            if (ServiceManager.logger2.isTraceEnabled(2)) {
                ServiceManager.logger2.trace(2).append("DsiProxy - checkIfDsiCallIsRedundant(), the request is redundant!").log();
            }
        }
        return bl;
    }

    private boolean checkIfDsiCallIsRedundant(RequestToAppParameter requestToAppParameter) {
        if (requestToAppParameter.requestType > -1 && requestToAppParameter.requestType < this.requestParamValues.length) {
            if (null == this.requestParamValues[requestToAppParameter.requestType]) {
                return false;
            }
            boolean bl = requestToAppParameter.equals(this.requestParamValues[requestToAppParameter.requestType]);
            if (bl) {
                return requestToAppParameter.updateCount == -1;
            }
            return false;
        }
        return false;
    }
}

