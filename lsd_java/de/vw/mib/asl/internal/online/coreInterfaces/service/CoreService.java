/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreInterfaces.service;

import de.vw.mib.asl.internal.online.coreInterfaces.core.client.OnlineUser;
import de.vw.mib.asl.internal.online.coreInterfaces.service.CoreServiceListener;
import de.vw.mib.asl.internal.online.coreInterfaces.service.CoreServiceUpdateListener;

public interface CoreService {
    default public void setLanguage(String string) {
    }

    default public void resetToFactorySettings(String string, CoreServiceListener coreServiceListener) {
    }

    default public void resetToFactorySettingsWithServiceName(String string, CoreServiceListener coreServiceListener) {
    }

    default public void getUserList(CoreServiceListener coreServiceListener) {
    }

    default public void setActiveUser(OnlineUser onlineUser, CoreServiceListener coreServiceListener) {
    }

    default public void getActiveUser(CoreServiceListener coreServiceListener) {
    }

    default public void validatePin(OnlineUser onlineUser, String string, CoreServiceListener coreServiceListener) {
    }

    default public void verifyUser(OnlineUser onlineUser, CoreServiceListener coreServiceListener) {
    }

    default public void checkServiceStatus(String string, OnlineUser onlineUser, CoreServiceListener coreServiceListener) {
    }

    default public void getService(String string, CoreServiceListener coreServiceListener) {
    }

    default public void getServiceURL(String string, CoreServiceListener coreServiceListener) {
    }

    default public void setState(String string, int n, CoreServiceListener coreServiceListener) {
    }

    default public void sendPrivacyModeStatus(boolean bl, CoreServiceListener coreServiceListener) {
    }

    default public void submitCurrentServicesStateToBackend() {
    }

    default public void setTrackingServicesValidity(boolean bl) {
    }

    default public void isReady() {
    }

    default public void setRoamingEnabled(boolean bl) {
    }

    default public void addUpdateListener(CoreServiceUpdateListener coreServiceUpdateListener) {
    }

    default public void removeUpdateListener(CoreServiceUpdateListener coreServiceUpdateListener) {
    }
}

