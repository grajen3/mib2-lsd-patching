/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreInterfaces.service;

import de.vw.mib.asl.internal.online.coreInterfaces.core.client.OnlineService;
import de.vw.mib.asl.internal.online.coreInterfaces.core.client.OnlineUser;

public interface CoreServiceListener {
    default public void resetToFactorySettingsResponse(int n, String string, int n2) {
    }

    default public void resetToFactorySettingsWithServiceNameResponse(int n, String string, int n2) {
    }

    default public void getUserListResponse(OnlineUser[] onlineUserArray, int n) {
    }

    default public void setActiveUserResponse(OnlineUser onlineUser, int n) {
    }

    default public void getActiveUserResponse(OnlineUser onlineUser, int n) {
    }

    default public void validatePinResponse(OnlineUser onlineUser, int n) {
    }

    default public void verifyUserResponse(int n) {
    }

    default public void checkServiceStatusResponse(String string, int n) {
    }

    default public void checkServiceStatusWithServiceNameResponse(String string, int n) {
    }

    default public void getOnlineServiceListResponse(OnlineService[] onlineServiceArray, int n) {
    }

    default public void getServiceResponse(String string, OnlineService onlineService, int n) {
    }

    default public void getServiceWithServiceNameResponse(String string, OnlineService onlineService, int n) {
    }

    default public void getServiceURLResponse(String string, String string2, int n) {
    }

    default public void getServiceURLWithServiceNameResponse(String string, String string2, int n) {
    }

    default public void setStateResponse(String string, OnlineService onlineService) {
    }

    default public void setStateWithServiceNameResponse(String string, OnlineService onlineService) {
    }

    default public void sendPrivacyModeStatusResponse(int n) {
    }
}

