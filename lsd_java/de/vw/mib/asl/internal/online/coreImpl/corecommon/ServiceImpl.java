/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreImpl.corecommon;

import de.vw.mib.asl.internal.online.coreImpl.corecommon.CoreServiceCommonFactory;
import de.vw.mib.asl.internal.online.coreInterfaces.core.server.License;
import de.vw.mib.asl.internal.online.coreInterfaces.core.server.Service;
import de.vw.mib.util.Util;
import edu.emory.mathcs.backport.java.util.Arrays;

public class ServiceImpl
implements Service {
    private String _serviceID;
    private String _serviceName;
    private int _deviceID;
    private boolean _invisible;
    private int _serviceState = 2;
    private int _enabledState = 1;
    private boolean _disabledActivation;
    private License _mainLicense;
    private boolean _licenseAvailable;
    private boolean _trackingService;
    private boolean _trackingActive;
    private int _apn;
    private boolean _eSIMUsageAllowed;
    private boolean _termsAndConditionsRequired;
    private boolean _primaryUserRequired;
    private boolean _disablingBlocked;
    private int _serviceType;
    private int[] _privacyGroup;
    private int[] _packages;
    private int[] _categories;
    private boolean _serviceChanged;

    @Override
    public void setServiceID(String string) {
        this._serviceID = string;
    }

    @Override
    public String getServiceID() {
        return this._serviceID;
    }

    @Override
    public void setServiceName(String string) {
        this._serviceName = string;
    }

    @Override
    public String getServiceName() {
        return this._serviceName;
    }

    @Override
    public void setDeviceID(int n) {
        this._deviceID = n;
    }

    @Override
    public int getDeviceID() {
        return this._deviceID;
    }

    @Override
    public void setInvisible(boolean bl) {
        this._invisible = bl;
    }

    @Override
    public boolean isInvisible() {
        return this._invisible;
    }

    @Override
    public void setMainLicense(License license) {
        this._mainLicense = license;
    }

    @Override
    public License getMainLicense() {
        return this._mainLicense;
    }

    @Override
    public void setServiceState(int n) {
        if (this._serviceState != n) {
            this.setServiceChanged(this._serviceState != n);
            this._serviceState = n;
        }
    }

    @Override
    public int getServiceState() {
        return this._serviceState;
    }

    @Override
    public void setEnabledState(int n) {
        this._enabledState = n;
    }

    @Override
    public int getEnabledState() {
        return this._enabledState;
    }

    @Override
    public void setDisabledActivation(boolean bl) {
        this._disabledActivation = bl;
    }

    @Override
    public boolean isDisabledActivation() {
        return this._disabledActivation;
    }

    @Override
    public void setLicenseAvailability(boolean bl) {
        this._licenseAvailable = bl;
    }

    @Override
    public boolean isLicenseAvailable() {
        return this._licenseAvailable;
    }

    @Override
    public void setTrackingService(boolean bl) {
        this._trackingService = bl;
    }

    @Override
    public boolean isTrackingService() {
        return this._trackingService;
    }

    @Override
    public void setTrackingToActive(boolean bl) {
        this._trackingActive = bl;
    }

    @Override
    public boolean isTrackingActive() {
        return this._trackingActive;
    }

    @Override
    public void setServiceType(int n) {
        this._serviceType = n;
    }

    @Override
    public int getServiceType() {
        return this._serviceType;
    }

    @Override
    public void setServiceDisablingBlocked(boolean bl) {
        this._disablingBlocked = bl;
    }

    @Override
    public boolean isServiceDisablingBlocked() {
        return this._disablingBlocked;
    }

    @Override
    public void setPrimaryUserRequired(boolean bl) {
        this._primaryUserRequired = bl;
    }

    @Override
    public boolean isPrimaryUserRequired() {
        return this._primaryUserRequired;
    }

    @Override
    public void setTermsAndConditionsRequired(boolean bl) {
        this._termsAndConditionsRequired = bl;
    }

    @Override
    public boolean isTermsAndConditionsRequired() {
        return this._termsAndConditionsRequired;
    }

    @Override
    public void setESIMUsageAllowed(boolean bl) {
        this._eSIMUsageAllowed = bl;
    }

    @Override
    public boolean isESIMUsageAllowed() {
        return this._eSIMUsageAllowed;
    }

    @Override
    public void setAPN(int n) {
        this._apn = n;
    }

    @Override
    public int getAPN() {
        return this._apn;
    }

    @Override
    public void setPrivacyGroups(int[] nArray) {
        this._privacyGroup = nArray;
    }

    @Override
    public int[] getPrivacyGroups() {
        return this._privacyGroup;
    }

    @Override
    public void setServicePackage(int[] nArray) {
        this._packages = nArray;
    }

    @Override
    public int[] getServicePackages() {
        return this._packages;
    }

    @Override
    public void setCategories(int[] nArray) {
        this._categories = nArray;
    }

    @Override
    public int[] getCategories() {
        return this._categories;
    }

    @Override
    public boolean isServiceChanged() {
        return this._serviceChanged;
    }

    @Override
    public void setServiceChanged(boolean bl) {
        this._serviceChanged = bl;
    }

    @Override
    public void copyTo(Service service) {
        if (service != null && this != service) {
            this._serviceID = new String(service.getServiceID());
            this._serviceState = service.getServiceState();
            this._invisible = service.isInvisible();
            this._enabledState = service.getEnabledState();
            this._disabledActivation = service.isDisabledActivation();
            this._licenseAvailable = service.isLicenseAvailable();
            if (service.getMainLicense() != null) {
                if (this._mainLicense == null) {
                    this._mainLicense = CoreServiceCommonFactory.getLicenseInstance();
                }
                this._mainLicense.copyTo(service.getMainLicense());
            } else {
                this._mainLicense = null;
            }
            this._deviceID = service.getDeviceID();
            this._trackingService = service.isTrackingService();
            this._trackingActive = service.isTrackingActive();
            this._serviceName = Util.isNullOrEmpty(service.getServiceName()) ? "" : new String(service.getServiceName());
            this._apn = service.getAPN();
            this._eSIMUsageAllowed = service.isESIMUsageAllowed();
            this._termsAndConditionsRequired = service.isTermsAndConditionsRequired();
            this._primaryUserRequired = this.isPrimaryUserRequired();
            this._disablingBlocked = service.isServiceDisablingBlocked();
            this._serviceType = service.getServiceType();
            this._privacyGroup = service.getPrivacyGroups();
            this._serviceChanged = service.isServiceChanged();
            this._privacyGroup = Util.isNullOrEmpty(service.getPrivacyGroups()) ? null : Arrays.copyOf(service.getPrivacyGroups(), service.getPrivacyGroups().length);
            this._categories = Util.isNullOrEmpty(service.getCategories()) ? null : Arrays.copyOf(service.getCategories(), service.getCategories().length);
            this._packages = Util.isNullOrEmpty(service.getServicePackages()) ? null : Arrays.copyOf(service.getServicePackages(), service.getServicePackages().length);
        }
    }

    public String toString() {
        int n;
        StringBuffer stringBuffer = new StringBuffer(300);
        stringBuffer.append("Service");
        stringBuffer.append('(');
        stringBuffer.append("ServiceID");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(!Util.isNullOrEmpty(this._serviceID) ? this._serviceID : "");
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("DeviceID");
        stringBuffer.append('=');
        stringBuffer.append(this._deviceID);
        stringBuffer.append(',');
        stringBuffer.append("Invisible");
        stringBuffer.append('=');
        stringBuffer.append(this._invisible);
        stringBuffer.append(',');
        stringBuffer.append("State");
        stringBuffer.append('=');
        stringBuffer.append(this._serviceState);
        stringBuffer.append(',');
        stringBuffer.append("EnabledState");
        stringBuffer.append('=');
        stringBuffer.append(this._enabledState);
        stringBuffer.append(',');
        stringBuffer.append("DisabledActivation");
        stringBuffer.append('=');
        stringBuffer.append(this._disabledActivation);
        stringBuffer.append(',');
        stringBuffer.append("LicenseAvailable");
        stringBuffer.append('=');
        stringBuffer.append(this._licenseAvailable);
        stringBuffer.append(',');
        stringBuffer.append("MainLicense");
        stringBuffer.append('=');
        stringBuffer.append(this._mainLicense);
        stringBuffer.append(',');
        stringBuffer.append("TrackingService");
        stringBuffer.append('=');
        stringBuffer.append(this._trackingService);
        stringBuffer.append(',');
        stringBuffer.append("TrackingActive");
        stringBuffer.append('=');
        stringBuffer.append(this._trackingActive);
        stringBuffer.append(',');
        stringBuffer.append("ServiceName");
        stringBuffer.append('=');
        stringBuffer.append(!Util.isNullOrEmpty(this._serviceName) ? this._serviceName : "");
        stringBuffer.append(',');
        stringBuffer.append("APN");
        stringBuffer.append('=');
        stringBuffer.append(this._apn);
        stringBuffer.append(',');
        stringBuffer.append("ESIMUsageAllowed");
        stringBuffer.append('=');
        stringBuffer.append(this._eSIMUsageAllowed);
        stringBuffer.append(',');
        stringBuffer.append("TermsAndConditionsRequired");
        stringBuffer.append('=');
        stringBuffer.append(this._termsAndConditionsRequired);
        stringBuffer.append(',');
        stringBuffer.append("PrimaryUserRequired");
        stringBuffer.append('=');
        stringBuffer.append(this._primaryUserRequired);
        stringBuffer.append(',');
        stringBuffer.append("DisablingBlocked");
        stringBuffer.append('=');
        stringBuffer.append(this._disablingBlocked);
        stringBuffer.append(',');
        stringBuffer.append("ServiceType");
        stringBuffer.append('=');
        stringBuffer.append(this._serviceType);
        stringBuffer.append(',');
        stringBuffer.append("PrivacyGroup");
        stringBuffer.append('=');
        stringBuffer.append(this._privacyGroup);
        stringBuffer.append(',');
        stringBuffer.append("ServiceChanged");
        stringBuffer.append('=');
        stringBuffer.append(this._serviceChanged);
        stringBuffer.append(',');
        stringBuffer.append("PrivacyGroups");
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (!Util.isNullOrEmpty(this._privacyGroup)) {
            for (n = 0; n < this._privacyGroup.length; ++n) {
                stringBuffer.append(new StringBuffer().append(this._privacyGroup[n]).append(", ").toString());
            }
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("Categories");
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (!Util.isNullOrEmpty(this._categories)) {
            for (n = 0; n < this._categories.length; ++n) {
                stringBuffer.append(new StringBuffer().append(this._categories[n]).append(", ").toString());
            }
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("Packages");
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (!Util.isNullOrEmpty(this._packages)) {
            for (n = 0; n < this._packages.length; ++n) {
                stringBuffer.append(new StringBuffer().append(this._packages[n]).append(", ").toString());
            }
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }

    @Override
    public boolean equalsTo(Service service) {
        if (service == null) {
            return false;
        }
        if (!this._serviceID.equalsIgnoreCase(service.getServiceID())) {
            return false;
        }
        if (this._serviceState != service.getServiceState()) {
            return false;
        }
        if (this._invisible != service.isInvisible()) {
            return false;
        }
        if (this._enabledState != service.getEnabledState()) {
            return false;
        }
        if (this._disabledActivation != service.isDisabledActivation()) {
            return false;
        }
        if (this._licenseAvailable != service.isLicenseAvailable()) {
            return false;
        }
        if (this._deviceID != service.getDeviceID()) {
            return false;
        }
        if (this._trackingService != service.isTrackingService()) {
            return false;
        }
        if (this._trackingActive != service.isTrackingActive()) {
            return false;
        }
        if (this._eSIMUsageAllowed != service.isESIMUsageAllowed()) {
            return false;
        }
        if (this._termsAndConditionsRequired != service.isTermsAndConditionsRequired()) {
            return false;
        }
        if (this._primaryUserRequired != this.isPrimaryUserRequired()) {
            return false;
        }
        if (this._disablingBlocked != service.isServiceDisablingBlocked()) {
            return false;
        }
        if (this._serviceType != service.getServiceType()) {
            return false;
        }
        if (this._serviceChanged != service.isServiceChanged()) {
            return false;
        }
        if (this._apn != service.getAPN()) {
            return false;
        }
        if (Util.isNullOrEmpty(this._serviceName) && !Util.isNullOrEmpty(service.getServiceName()) || !Util.isNullOrEmpty(this._serviceName) && Util.isNullOrEmpty(service.getServiceName())) {
            return false;
        }
        if (!(Util.isNullOrEmpty(this._serviceName) || Util.isNullOrEmpty(service.getServiceName()) || this._serviceName.equalsIgnoreCase(service.getServiceName()))) {
            return false;
        }
        if (Util.isNullOrEmpty(this._privacyGroup) && !Util.isNullOrEmpty(service.getPrivacyGroups()) || !Util.isNullOrEmpty(this._privacyGroup) && Util.isNullOrEmpty(service.getPrivacyGroups())) {
            return false;
        }
        if (!Util.isNullOrEmpty(this._privacyGroup) && !Util.isNullOrEmpty(service.getPrivacyGroups()) && this._privacyGroup.length != service.getPrivacyGroups().length) {
            return false;
        }
        if (Util.isNullOrEmpty(this._categories) && !Util.isNullOrEmpty(service.getCategories()) || !Util.isNullOrEmpty(this._categories) && Util.isNullOrEmpty(service.getCategories())) {
            return false;
        }
        if (!Util.isNullOrEmpty(this._categories) && !Util.isNullOrEmpty(service.getCategories()) && this._categories.length != service.getCategories().length) {
            return false;
        }
        if (Util.isNullOrEmpty(this._packages) && !Util.isNullOrEmpty(service.getServicePackages()) || !Util.isNullOrEmpty(this._packages) && Util.isNullOrEmpty(service.getServicePackages())) {
            return false;
        }
        if (!Util.isNullOrEmpty(this._packages) && !Util.isNullOrEmpty(service.getServicePackages()) && this._packages.length != service.getServicePackages().length) {
            return false;
        }
        if (this._mainLicense != null && service.getMainLicense() != null && !this._mainLicense.equalsTo(service.getMainLicense())) {
            return false;
        }
        return (this._mainLicense == null || service.getMainLicense() != null) && (this._mainLicense != null || service.getMainLicense() == null);
    }
}

