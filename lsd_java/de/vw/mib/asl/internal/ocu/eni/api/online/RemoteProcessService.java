/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.eni.api.online;

import de.vw.mib.asl.internal.ocu.common.api.services.InternalServiceProvider;

public interface RemoteProcessService
extends InternalServiceProvider {
    public static final int[] SERVICE_CONSTANTS = new int[]{-1299840768, -1199177472, -1215954688, -1249509120, -1383726848, -1366949632, -1266286336, -1232731904, -1132068608, -1400504064, -1316617984, -1283063552, -1148845824, -1350172416, -1333395200, -1115291392};

    default public void authenticateOnlineDownload(String string) {
    }

    default public void confirmDownloadError(String string) {
    }

    default public void confirmInstallationError(String string) {
    }

    default public void confirmInstallationFinished(String string) {
    }

    default public void confirmServiceExpiryWarning(String string) {
    }

    default public void confirmServiceExpiryWarnings() {
    }

    default public void confirmUpdateInstallation(String string) {
    }

    default public void confirmUpdateWithdrawn(String string) {
    }

    default public void getChallenge() {
    }

    default public void pairMainUser(String string, String string2) {
    }

    default public void postponeOnlineDownload(String string, String string2) {
    }

    default public void postponeUpdateInstallation(String string, String string2) {
    }

    default public void requestNewLanguage(String string, int n) {
    }

    default public void restoreFactorySettings() {
    }

    default public void sendLocalServiceStateListRequest() {
    }

    default public void setPrivacyModeActive(boolean bl) {
    }
}

