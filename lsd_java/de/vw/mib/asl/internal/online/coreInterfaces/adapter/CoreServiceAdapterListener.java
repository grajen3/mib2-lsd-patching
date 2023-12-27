/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreInterfaces.adapter;

import de.vw.mib.asl.internal.online.coreInterfaces.core.server.Service;
import de.vw.mib.asl.internal.online.coreInterfaces.core.server.User;

public interface CoreServiceAdapterListener {
    default public void resetToFactorySettingsResponse(int n, String string, int n2) {
    }

    default public void resetToFactorSettingsWithServiceNameResponse(int n, String string, int n2) {
    }

    default public void validateOwnerResponse(User user, int n) {
    }

    default public void forceOwnerValidationResponse(int n) {
    }

    default public void verifyOwnerResponse(int n) {
    }

    default public void serviceStateResponse(Service service) {
    }

    default public void checkServiceStatusResponse(String string, int n) {
    }

    default public void getServiceURLResponse(String string, String string2, int n) {
    }

    default public void sendPrivacyModeStatusResponse(int n, int n2) {
    }
}

