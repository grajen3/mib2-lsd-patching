/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.online;

import org.dsi.ifc.online.OSRApplicationProperties;
import org.dsi.ifc.online.OSRDevice;
import org.dsi.ifc.online.OSRLicense;
import org.dsi.ifc.online.OSRUser;

public interface DSIOnlineServiceRegistrationC {
    default public void getOnlineApplicationList() {
    }

    default public void getOnlineApplication(String string) {
    }

    default public void setOnlineApplicationState(String string, int n) {
    }

    default public void activateLicense(OSRLicense oSRLicense) {
    }

    default public void setDemandState(String string, boolean bl) {
    }

    default public void setDemandStateServiceID(String string, boolean bl) {
    }

    default public void setApplicationProperties(String string, OSRApplicationProperties[] oSRApplicationPropertiesArray) {
    }

    default public void addOrUpdateApplicationProperty(String string, OSRApplicationProperties oSRApplicationProperties) {
    }

    default public void setCredential(String string, String string2, String string3) {
    }

    default public void download(String string, String string2, String string3, long l, long l2) {
    }

    default public void downloadRaw(String string, String string2, String string3, long l, long l2) {
    }

    default public void validateOwner(String string) {
    }

    default public void validateOwnerForce(boolean bl) {
    }

    default public void checkOwnersVerification() {
    }

    default public void createUserWithPairingCode(String string, String string2) {
    }

    default public void createUserWithUserPassword(String string, String string2, String string3) {
    }

    default public void checkPassword(OSRUser oSRUser, String string, boolean bl) {
    }

    default public void checkPairingCode(OSRUser oSRUser, String string, boolean bl) {
    }

    default public void setPrivacyFlags(OSRUser oSRUser, int n) {
    }

    default public void setAutoLogin(OSRUser oSRUser, OSRDevice[] oSRDeviceArray) {
    }

    default public void login(OSRUser oSRUser) {
    }

    default public void logout(OSRUser oSRUser) {
    }

    default public void logoutAuthScheme(String string) {
    }

    default public void getUsers(String string) {
    }

    default public void removeUser(OSRUser oSRUser) {
    }

    default public void performPortalRegistration(String string) {
    }

    default public void getLicense(String string) {
    }

    default public void getLicenses(boolean bl, boolean bl2) {
    }

    default public void precheckOnlineServiceServiceID(String string, String string2) {
    }

    default public void precheckOnlineServiceSymbolicName(String string, String string2) {
    }

    default public void precheckOnlineService(String string) {
    }

    default public void getProfileFolder(OSRUser oSRUser, String string) {
    }

    default public void getCredentialsFromHeader(int n, String[] stringArray) {
    }

    default public void getCredentialsFromAuthScheme(int n) {
    }

    default public void getServiceURL(String string) {
    }

    default public void resetToFactorySettings(String string) {
    }

    default public void setLanguage(String string) {
    }

    default public void setServiceState(String string, int n) {
    }

    default public void setServiceStateSymbolicName(String string, int n) {
    }

    default public void setActivePrivacyCategoryMask(int n) {
    }

    default public void submitServiceStateChangesToBackend() {
    }

    default public void profileChange(int n) {
    }

    default public void profileCopy(int n, int n2) {
    }

    default public void profileReset(int n) {
    }

    default public void profileResetAll() {
    }

    default public void setGPSUseMode(int n) {
    }

    default public void setInventoryFinished(boolean bl) {
    }

    default public void setSPIN(String string, String string2, String string3) {
    }

    default public void getSPINHash(String string, String string2, int n, String string3) {
    }

    default public void setNotification(int[] nArray) {
    }

    default public void setNotification(int n) {
    }

    default public void setNotification() {
    }

    default public void clearNotification(int[] nArray) {
    }

    default public void clearNotification(int n) {
    }

    default public void clearNotification() {
    }

    default public void yySet(String string, String string2) {
    }
}

