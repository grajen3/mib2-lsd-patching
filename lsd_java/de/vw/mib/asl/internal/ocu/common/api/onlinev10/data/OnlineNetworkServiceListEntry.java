/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.common.api.onlinev10.data;

import de.vw.mib.asl.api.ocu.onlinev10.data.OnlineNetworkServiceListEntry$ServiceLicenseState;
import de.vw.mib.asl.internal.ocu.common.api.onlinev10.mapping.ServiceMapping;
import de.vw.mib.asl.internal.ocu.generated.eni.serializer.ServiceList_Data;
import java.util.Date;

public class OnlineNetworkServiceListEntry
implements de.vw.mib.asl.api.ocu.onlinev10.data.OnlineNetworkServiceListEntry {
    private final String serviceId;
    private final String serviceName;
    private final String serviceVersion;
    private final boolean serviceEnabled;
    private final boolean serviceRoamingAllowed;
    private final boolean serviceLicenseExpirationWarningActive;
    private final boolean serviceBlockingProtected;
    private final boolean serviceNotBlockedByDriver;
    private final OnlineNetworkServiceListEntry$ServiceLicenseState serviceLicenseState;
    private final String serviceLicenseId;
    private final Date periodOfValidityDate;
    private final Date expirationDate;
    private final Date activationDate;

    public OnlineNetworkServiceListEntry(ServiceList_Data serviceList_Data) {
        this.serviceId = serviceList_Data.serviceId.toString();
        this.serviceName = serviceList_Data.serviceName.toString();
        this.serviceVersion = serviceList_Data.serviceVersion.toString();
        this.serviceEnabled = serviceList_Data.serviceState.serviceEnabled;
        this.serviceRoamingAllowed = serviceList_Data.serviceState.roamingAllowed;
        this.serviceLicenseExpirationWarningActive = serviceList_Data.serviceState.licenseExpirationWarning;
        this.serviceBlockingProtected = !serviceList_Data.serviceState.disablingByDriverAllowedDf3_3;
        this.serviceNotBlockedByDriver = serviceList_Data.userSettings.serviceActivatedAllowedByDriver;
        this.serviceLicenseState = ServiceMapping.mapBapLicenseState(serviceList_Data.licenseState);
        this.serviceLicenseId = serviceList_Data.licenseId.toString();
        this.periodOfValidityDate = ServiceMapping.mapBapEniServiceDate(serviceList_Data.periodOfValidity.toString());
        this.expirationDate = ServiceMapping.mapBapEniServiceDate(serviceList_Data.dateOfExpiry.toString());
        this.activationDate = ServiceMapping.mapBapEniServiceDate(serviceList_Data.dateOfActivation.toString());
    }

    @Override
    public String getServiceId() {
        return this.serviceId;
    }

    @Override
    public String getServiceName() {
        return this.serviceName;
    }

    @Override
    public String getServiceVersion() {
        return this.serviceVersion;
    }

    @Override
    public boolean isServiceEnabled() {
        return this.serviceEnabled;
    }

    @Override
    public boolean isServiceRoamingAllowed() {
        return this.serviceRoamingAllowed;
    }

    @Override
    public boolean isServiceLicenseExpirationWarningActive() {
        return this.serviceLicenseExpirationWarningActive;
    }

    @Override
    public boolean isServiceBlockingProtected() {
        return this.serviceBlockingProtected;
    }

    @Override
    public boolean isServiceNotBlockedByDriver() {
        return this.serviceNotBlockedByDriver;
    }

    @Override
    public OnlineNetworkServiceListEntry$ServiceLicenseState getServiceLicenseState() {
        return this.serviceLicenseState;
    }

    @Override
    public String getServiceLicenseId() {
        return this.serviceLicenseId;
    }

    @Override
    public Date getPeriodOfValidityDate() {
        return this.periodOfValidityDate;
    }

    @Override
    public Date getExpirationDate() {
        return this.expirationDate;
    }

    @Override
    public Date getActivationDate() {
        return this.activationDate;
    }
}

