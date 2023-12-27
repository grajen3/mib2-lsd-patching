/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.common.api.onlinev10.data;

public class OnlineNetworkSupportedServices
implements de.vw.mib.asl.api.ocu.onlinev10.data.OnlineNetworkSupportedServices {
    private final boolean pairMainUserSupported;
    private final boolean restoreFactorySettingsSupported;
    private final boolean confirmServiceExpiryWarningSupported;
    private final boolean networkOnlineServicesAccessible;

    public OnlineNetworkSupportedServices(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        this.pairMainUserSupported = bl;
        this.restoreFactorySettingsSupported = bl2;
        this.confirmServiceExpiryWarningSupported = bl3;
        this.networkOnlineServicesAccessible = bl4;
    }

    @Override
    public boolean isPairMainUserSupported() {
        return this.pairMainUserSupported;
    }

    @Override
    public boolean isRestoreFactorySettingsSupported() {
        return this.restoreFactorySettingsSupported;
    }

    @Override
    public boolean isConfirmServiceExpiryWarningSupported() {
        return this.confirmServiceExpiryWarningSupported;
    }

    @Override
    public boolean isNetworkOnlineServicesAccessible() {
        return this.networkOnlineServicesAccessible;
    }

    public boolean equals(Object object) {
        OnlineNetworkSupportedServices onlineNetworkSupportedServices = (OnlineNetworkSupportedServices)object;
        return onlineNetworkSupportedServices.pairMainUserSupported == this.pairMainUserSupported && onlineNetworkSupportedServices.restoreFactorySettingsSupported == this.restoreFactorySettingsSupported && onlineNetworkSupportedServices.confirmServiceExpiryWarningSupported == this.confirmServiceExpiryWarningSupported && onlineNetworkSupportedServices.networkOnlineServicesAccessible == this.networkOnlineServicesAccessible;
    }

    public OnlineNetworkSupportedServices setNetworkOnlineServicesAccessible(boolean bl) {
        return new OnlineNetworkSupportedServices(this.pairMainUserSupported, this.restoreFactorySettingsSupported, this.confirmServiceExpiryWarningSupported, bl);
    }

    public int hashCode() {
        return super.hashCode();
    }
}

