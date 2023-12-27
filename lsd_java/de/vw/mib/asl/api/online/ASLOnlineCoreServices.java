/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.online;

import de.vw.mib.asl.api.online.ASLOnlineApplicationLicenseStatusCallBack;
import de.vw.mib.asl.api.online.ASLOnlineCoreServicesCallbackVersion4;
import de.vw.mib.asl.api.online.ASLOnlineServiceAvailabilityListener;
import de.vw.mib.asl.api.online.ASLOnlineServiceCallback;
import de.vw.mib.asl.api.online.ASLOnlineServiceCallback1;
import de.vw.mib.asl.api.online.ASLOnlineServiceIdentifier;
import de.vw.mib.asl.api.online.ASLOnlineServiceListener;
import org.dsi.ifc.global.ResourceLocator;

public interface ASLOnlineCoreServices {
    public static final int PROVIDERLOGO_IMAGE;
    public static final int PROVIDERLOGO_IMAGE_VOICE;
    public static final int PROVIDERLOGO_IMAGE_MAP;
    public static final int BRAND_ICON;
    public static final int ONLINE_SERVICES_AVAILABILITY_UNKNOWN;
    public static final int ONLINE_SERVICES_AVAILABILITY_AVAILABLE;
    public static final int ONLINE_SERVICES_AVAILABILITY_NOT_AVAILABLE;
    public static final int DOWNLOAD_TYPE_AUTO;
    public static final int DOWNLOAD_TYPE_AUTO_LATER;
    public static final int DOWNLOAD_TYPE_DESTINATION;
    public static final int DOWNLOAD_TYPE_DESTINATION_LATER;

    default public String getServiceIDWithNumericServiceID(int n) {
    }

    default public String getServiceIDWithNumericServiceID(int n, int n2) {
    }

    default public String getServiceIDWithIdentifier(String string) {
    }

    default public int getOnlineServicesAvailabilityStatus() {
    }

    default public void registerForOnlineServicesAvailabilityStatus(ASLOnlineServiceAvailabilityListener aSLOnlineServiceAvailabilityListener) {
    }

    default public boolean getSetCustomerDownloadIndicationStatus(boolean bl, int n, boolean bl2) {
    }

    default public void registerForServiceUpdate(String string, ASLOnlineServiceListener aSLOnlineServiceListener) {
    }

    default public void unRegisterForServiceUpdate(String string, ASLOnlineServiceListener aSLOnlineServiceListener) {
    }

    default public void checkOnlineServiceStatus(String string, ASLOnlineServiceListener aSLOnlineServiceListener) {
    }

    default public boolean isOCUService(String string) {
    }

    default public ResourceLocator getOnlineImage(int n, String string, int n2, String string2, String string3, ASLOnlineServiceCallback1 aSLOnlineServiceCallback1) {
    }

    default public void getServiceURL(String string, ASLOnlineServiceCallback1 aSLOnlineServiceCallback1) {
    }

    default public boolean isServiceAvailable(String string) {
    }

    default public int getApplicationState(int n) {
    }

    default public void applicationCodingValueChanged(int n, boolean bl) {
    }

    default public void applicationRegistration(int n, boolean bl) {
    }

    default public ResourceLocator getOnlineImage(ASLOnlineCoreServicesCallbackVersion4 aSLOnlineCoreServicesCallbackVersion4, int n, int n2, String string, String string2) {
    }

    default public void getApplicationServiceURLs(ASLOnlineCoreServicesCallbackVersion4 aSLOnlineCoreServicesCallbackVersion4, int n) {
    }

    default public void checkOnlineApplicationAuthenticationLicense(ASLOnlineApplicationLicenseStatusCallBack aSLOnlineApplicationLicenseStatusCallBack, int n) {
    }

    default public boolean isBackEndConnectionAvailable() {
    }

    default public boolean isServiceConfigured(ASLOnlineServiceIdentifier aSLOnlineServiceIdentifier) {
    }

    default public void checkOnlineServiceStatus(ASLOnlineServiceIdentifier aSLOnlineServiceIdentifier, ASLOnlineServiceCallback aSLOnlineServiceCallback) {
    }

    default public boolean isOCUService(ASLOnlineServiceIdentifier aSLOnlineServiceIdentifier) {
    }

    default public ResourceLocator getOnlineImage(ASLOnlineServiceIdentifier aSLOnlineServiceIdentifier, int n, String string, String string2, ASLOnlineServiceCallback aSLOnlineServiceCallback) {
    }

    default public void getServiceURL(ASLOnlineServiceIdentifier aSLOnlineServiceIdentifier, ASLOnlineServiceCallback aSLOnlineServiceCallback) {
    }
}

