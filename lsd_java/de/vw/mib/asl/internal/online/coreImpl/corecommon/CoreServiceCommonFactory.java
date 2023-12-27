/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreImpl.corecommon;

import de.vw.mib.asl.internal.online.coreImpl.corecommon.CoreServiceFeatureFlagMap;
import de.vw.mib.asl.internal.online.coreImpl.corecommon.DeviceImpl;
import de.vw.mib.asl.internal.online.coreImpl.corecommon.LicenseImpl;
import de.vw.mib.asl.internal.online.coreImpl.corecommon.ServiceImpl;
import de.vw.mib.asl.internal.online.coreImpl.corecommon.TrackingServiceImpl;
import de.vw.mib.asl.internal.online.coreImpl.corecommon.UserImpl;
import de.vw.mib.asl.internal.online.coreInterfaces.core.server.Device;
import de.vw.mib.asl.internal.online.coreInterfaces.core.server.License;
import de.vw.mib.asl.internal.online.coreInterfaces.core.server.Service;
import de.vw.mib.asl.internal.online.coreInterfaces.core.server.TrackingService;
import de.vw.mib.asl.internal.online.coreInterfaces.core.server.User;

public final class CoreServiceCommonFactory {
    private static CoreServiceFeatureFlagMap _featureFlagMap;

    public static Device getDeviceInstance(int n, String string) {
        return new DeviceImpl(n, string);
    }

    public static Device[] getDeviceListInstance(int n) {
        DeviceImpl[] deviceImplArray = null;
        if (n > 0) {
            deviceImplArray = new DeviceImpl[n];
        }
        return deviceImplArray;
    }

    public static CoreServiceFeatureFlagMap getFeatureFlagMap() {
        if (_featureFlagMap == null) {
            _featureFlagMap = new CoreServiceFeatureFlagMap();
        }
        return _featureFlagMap;
    }

    public static TrackingService getTrackingServiceInstance() {
        return new TrackingServiceImpl();
    }

    public static TrackingService[] getTrackingServiceListInstance(int n) {
        TrackingServiceImpl[] trackingServiceImplArray = null;
        if (n > 0) {
            trackingServiceImplArray = new TrackingServiceImpl[n];
            for (int i2 = 0; i2 < n; ++i2) {
                trackingServiceImplArray[i2] = CoreServiceCommonFactory.getTrackingServiceInstance();
            }
        }
        return trackingServiceImplArray;
    }

    public static Service getServiceInstance() {
        return new ServiceImpl();
    }

    public static Service[] getServiceListInstance(int n) {
        ServiceImpl[] serviceImplArray = null;
        if (n > 0) {
            serviceImplArray = new ServiceImpl[n];
            for (int i2 = 0; i2 < n; ++i2) {
                serviceImplArray[i2] = CoreServiceCommonFactory.getServiceInstance();
            }
        }
        return serviceImplArray;
    }

    public static License getLicenseInstance() {
        return new LicenseImpl();
    }

    public static License[] getLicenseListInstance(int n) {
        LicenseImpl[] licenseImplArray = null;
        if (n > 0) {
            licenseImplArray = new LicenseImpl[n];
            for (int i2 = 0; i2 < n; ++i2) {
                licenseImplArray[i2] = CoreServiceCommonFactory.getLicenseInstance();
            }
        }
        return licenseImplArray;
    }

    public static User getUserInstance() {
        return new UserImpl();
    }

    public static User[] getUserListInstance(int n) {
        UserImpl[] userImplArray = null;
        if (n > 0) {
            userImplArray = new UserImpl[n];
            for (int i2 = 0; i2 < n; ++i2) {
                userImplArray[i2] = CoreServiceCommonFactory.getUserInstance();
            }
        }
        return userImplArray;
    }
}

