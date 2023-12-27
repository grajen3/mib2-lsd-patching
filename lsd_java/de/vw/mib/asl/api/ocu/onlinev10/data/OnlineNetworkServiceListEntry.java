/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.ocu.onlinev10.data;

import de.vw.mib.asl.api.ocu.onlinev10.data.OnlineNetworkServiceListEntry$ServiceLicenseState;
import java.util.Date;

public interface OnlineNetworkServiceListEntry {
    public static final Date SERVICE_DATE_INVALID = new Date(0L);

    default public String getServiceId() {
    }

    default public String getServiceName() {
    }

    default public String getServiceVersion() {
    }

    default public boolean isServiceEnabled() {
    }

    default public boolean isServiceRoamingAllowed() {
    }

    default public boolean isServiceLicenseExpirationWarningActive() {
    }

    default public boolean isServiceBlockingProtected() {
    }

    default public boolean isServiceNotBlockedByDriver() {
    }

    default public ServiceLicenseState getServiceLicenseState() {
    }

    default public String getServiceLicenseId() {
    }

    default public Date getPeriodOfValidityDate() {
    }

    default public Date getExpirationDate() {
    }

    default public Date getActivationDate() {
    }
}

