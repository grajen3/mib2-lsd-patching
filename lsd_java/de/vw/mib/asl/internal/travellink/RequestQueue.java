/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.travellink.TLinkServiceManager;
import de.vw.mib.asl.internal.travellink.dsi.RequestToAppParameter;
import org.dsi.ifc.travellink.GenericProperty;

public final class RequestQueue {
    private boolean[] isRequestBlocked = new boolean[60];
    private RequestToAppParameter[] requestToAppParameter = new RequestToAppParameter[60];

    public RequestQueue() {
        this.cleanRequestQueue();
    }

    public void cleanRequestQueue() {
        if (ServiceManager.logger2.isTraceEnabled(2)) {
            ServiceManager.logger2.trace(2).append("RequestQueue - cleanRequestQueue()").log();
        }
        if (null != this.isRequestBlocked && null != this.requestToAppParameter) {
            for (int i2 = 0; i2 < this.isRequestBlocked.length; ++i2) {
                this.isRequestBlocked[i2] = false;
                this.requestToAppParameter[i2] = null;
            }
        }
    }

    public boolean isRequestBlocked(int n) {
        boolean bl = false;
        if (n > -1 && n < this.isRequestBlocked.length) {
            bl = this.isRequestBlocked[n];
        }
        if (ServiceManager.logger2.isTraceEnabled(2)) {
            ServiceManager.logger2.trace(2).append("RequestQueue - isRequestBlocked() - requestType = ").append(n).append(", requestBlocked = ").append(bl).log();
        }
        return bl;
    }

    public void setRequestIsBlocked(int n, boolean bl) {
        if (ServiceManager.logger2.isTraceEnabled(2)) {
            ServiceManager.logger2.trace(2).append("RequestQueue - setRequestIsBlocked( ").append(n).append(", ").append(bl).append(" )").log();
        }
        if (n > -1 && n < this.isRequestBlocked.length) {
            this.isRequestBlocked[n] = bl;
        }
    }

    public void blockRequest(int n) {
        if (ServiceManager.logger2.isTraceEnabled(2)) {
            ServiceManager.logger2.trace(2).append("RequestQueue - blockRequest( ").append(n).append(" )").log();
        }
        this.setRequestIsBlocked(n, true);
        this.deleteRequestToAppParameter(n);
        switch (n) {
            case 30: {
                TLinkServiceManager.getServiceManager().getTargetMain().stopTimer(-1450835712);
                TLinkServiceManager.getServiceManager().getTargetMain().startTimer(-1450835712, (long)0, false);
                break;
            }
        }
    }

    public void setRequestToAppParameter(int n, int n2, GenericProperty[] genericPropertyArray, int n3, int n4, int n5) {
        if (ServiceManager.logger2.isTraceEnabled(2)) {
            ServiceManager.logger2.trace(2).append("RequestQueue - setRequestToAppParameter() - requestType = ").append(n).log();
        }
        if (n > -1 && n < this.requestToAppParameter.length) {
            this.requestToAppParameter[n] = new RequestToAppParameter(n, n2, genericPropertyArray, n3, n4, n5, 0);
        }
    }

    public void deleteRequestToAppParameter(int n) {
        if (ServiceManager.logger2.isTraceEnabled(2)) {
            ServiceManager.logger2.trace(2).append("RequestQueue - deleteRequestToAppParameter( ").append(n).append(" )").log();
        }
        if (n > -1 && n < this.requestToAppParameter.length) {
            this.requestToAppParameter[n] = null;
        }
    }

    public void startPendingRequests(int n) {
        if (ServiceManager.logger2.isTraceEnabled(2)) {
            ServiceManager.logger2.trace(2).append("RequestQueue - startPendingRequests( ").append(n).append(" )").log();
        }
        this.setRequestIsBlocked(n, false);
        if (n > -1 && n < this.requestToAppParameter.length && null != this.requestToAppParameter[n]) {
            GenericProperty[] genericPropertyArray = this.requestToAppParameter[n].functionParams;
            switch (n) {
                case 30: {
                    int n2;
                    if (genericPropertyArray == null || genericPropertyArray.length != 1 || null == genericPropertyArray[0].valuesLong || genericPropertyArray[0].valuesLong.length != 1 || 2 != (n2 = TLinkServiceManager.getServiceManager().getCurrentViewId())) break;
                    TLinkServiceManager.getServiceManager().getDsiTravelLinkFuelAdapter().requestFuelStationDetails(genericPropertyArray[0].valuesLong[0]);
                    break;
                }
            }
        }
        this.deleteRequestToAppParameter(n);
    }

    public void stopTimer(int n) {
        if (ServiceManager.logger2.isTraceEnabled(2)) {
            ServiceManager.logger2.trace(2).append("RequestQueue - stopTimer( ").append(n).append(" )").log();
        }
        switch (n) {
            case 30: {
                TLinkServiceManager.getServiceManager().getTargetMain().stopTimer(-1450835712);
                break;
            }
        }
    }
}

