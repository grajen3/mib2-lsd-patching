/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.online;

import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.online.OSRApplication;
import org.dsi.ifc.online.OSRDevice;
import org.dsi.ifc.online.OSRLicense;
import org.dsi.ifc.online.OSRNotifyProperties;
import org.dsi.ifc.online.OSRNotifyPropertiesSL;
import org.dsi.ifc.online.OSRServiceListEntry;
import org.dsi.ifc.online.OSRServiceRegistration;
import org.dsi.ifc.online.OSRServiceState;
import org.dsi.ifc.online.OSRUser;

public interface DSIOnlineServiceRegistrationReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void getOnlineApplicationListResponse(OSRApplication[] oSRApplicationArray) {
    }

    default public void getOnlineApplicationResponse(OSRApplication oSRApplication) {
    }

    default public void activateLicenseResponse(OSRLicense oSRLicense, int n) {
    }

    default public void setCredentialResponse(String string, int n) {
    }

    default public void downloadResponse(String string, String string2, String string3, int n) {
    }

    default public void downloadRawResponse(String string, String string2, String string3, ResourceLocator resourceLocator, int n) {
    }

    default public void validateOwnerResponse(int n) {
    }

    default public void checkOwnersVerificationResponse(int n) {
    }

    default public void createUserWithPairingCodeResponse(String string, OSRUser oSRUser, int n) {
    }

    default public void createUserWithUserPasswordResponse(String string, OSRUser oSRUser, int n) {
    }

    default public void checkPasswordResponse(OSRUser oSRUser, int n) {
    }

    default public void checkPairingCodeResponse(OSRUser oSRUser, int n) {
    }

    default public void setPrivacyFlagsResponse(OSRUser oSRUser) {
    }

    default public void setAutoLoginResponse(OSRUser oSRUser, OSRDevice[] oSRDeviceArray, int[] nArray) {
    }

    default public void loginResponse(OSRUser oSRUser, int n) {
    }

    default public void logoutResponse(OSRUser oSRUser, int n) {
    }

    default public void logoutAuthSchemeResult(String string, OSRUser[] oSRUserArray, int[] nArray) {
    }

    default public void getUsersResponse(OSRUser[] oSRUserArray) {
    }

    default public void removeUserResponse(OSRUser oSRUser, int n) {
    }

    default public void performPortalRegistrationResponse(String string, int n) {
    }

    default public void precheckOnlineServiceServiceIDResponse(String string, OSRServiceState oSRServiceState) {
    }

    default public void precheckOnlineServiceSymbolicNameResponse(String string, OSRServiceState oSRServiceState) {
    }

    default public void precheckOnlineServiceResponse(String string, OSRServiceState[] oSRServiceStateArray) {
    }

    default public void getLicenseResponse(int n, OSRLicense oSRLicense) {
    }

    default public void getLicensesResponse(int n, boolean bl, boolean bl2, OSRLicense[] oSRLicenseArray) {
    }

    default public void getProfileFolderResponse(int n, String string, OSRUser oSRUser, String string2) {
    }

    default public void getCredentialsFromHeaderResponse(int n, int n2, int n3, String string, String string2, String string3) {
    }

    default public void getCredentialsFromAuthSchemeResponse(int n, int n2, String string, String string2, String string3) {
    }

    default public void getServiceURLResponse(int n, String string, String string2) {
    }

    default public void resetToFactorySettingsResponse(String string, int n) {
    }

    default public void updateApplicationState(OSRNotifyProperties[] oSRNotifyPropertiesArray, int n) {
    }

    default public void updateServices(OSRNotifyPropertiesSL[] oSRNotifyPropertiesSLArray, int n) {
    }

    default public void updateCoreProfileInfo(OSRUser oSRUser, int n, int n2) {
    }

    default public void updateExternalProfileInfo(String string, OSRUser oSRUser, int n, int n2) {
    }

    default public void updateDeviceEnumerator(OSRDevice oSRDevice, int n, int n2) {
    }

    default public void updateServiceState(int n, int n2) {
    }

    default public void updateServiceList(OSRServiceListEntry[] oSRServiceListEntryArray, int n) {
    }

    default public void updateServiceRegistration(String string, OSRServiceRegistration oSRServiceRegistration, int n, int n2) {
    }

    default public void setServiceStateResponse(OSRServiceState oSRServiceState) {
    }

    default public void setDemandStateServiceIDResponse(String string, int n) {
    }

    default public void setServiceStateSymbolicNameResponse(OSRServiceState oSRServiceState) {
    }

    default public void setActivePrivacyCategoryMaskResponse(int n) {
    }

    default public void submitServiceStateChangesToBackendResponse(int n) {
    }

    default public void updateProfileState(int n, int n2, int n3) {
    }

    default public void profileChanged(int n, int n2) {
    }

    default public void profileCopied(int n, int n2, int n3) {
    }

    default public void profileReset(int n, int n2) {
    }

    default public void profileResetAll(int n) {
    }

    default public void setGPSUseModeResponse(int n) {
    }

    default public void setInventoryFinishedResponse(int n) {
    }

    default public void updateSPINRequired(String string, String string2, int n) {
    }

    default public void setSPINResponse(String string, String string2, int n, int n2) {
    }

    default public void getSPINHashResult(String string, String string2, int n, String string3, String string4, int n2) {
    }

    default public void asyncException(int n, String string, int n2) {
    }

    default public void yyIndication(String string, String string2) {
    }
}

