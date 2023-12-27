/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreInterfaces.adapter;

import de.vw.mib.asl.internal.online.coreInterfaces.adapter.CoreServiceAdapterListener;
import de.vw.mib.asl.internal.online.coreInterfaces.adapter.CoreServiceAdapterUpdateListener;
import de.vw.mib.asl.internal.online.coreInterfaces.core.server.User;

public interface CoreServiceAdapter {
    public static final int UNKNOWN_FUNCTION_ID;
    public static final int LANGUAGE_FUNCTION_ID;
    public static final int FACTORY_RESET_FUNCTION_ID;
    public static final int VALIDATE_OWNER_FUNCTION_ID;
    public static final int FORCE_OWNER_VALIDATION_FUNCTION_ID;
    public static final int SERVICE_STATE_FUNCTION_ID;
    public static final int AUTHENTICATION_FUNCTION_ID;
    public static final int VERIFY_USER_FUNCTION_ID;
    public static final int SET_MAIN_DEVICE_ID;
    public static final int SET_ROAMING_ID;
    public static final int SET_PRIVACY_MODE;
    public static final int SET_STATUS_TO_BACKEND;

    default public void setAsMainDevice(int n) {
    }

    default public void setLanguage(String string) {
    }

    default public void resetToFactorySettings(String string, CoreServiceAdapterListener coreServiceAdapterListener) {
    }

    default public void resetToFactorySettingsWithServiceName(String string, CoreServiceAdapterListener coreServiceAdapterListener) {
    }

    default public void validateOwner(User user, String string, CoreServiceAdapterListener coreServiceAdapterListener) {
    }

    default public void forceOwnerValidation(boolean bl, CoreServiceAdapterListener coreServiceAdapterListener) {
    }

    default public void verifyOwner(User user, CoreServiceAdapterListener coreServiceAdapterListener) {
    }

    default public void setServiceState(String string, int n, CoreServiceAdapterListener coreServiceAdapterListener) {
    }

    default public void activateGroup(int n, int n2, CoreServiceAdapterListener coreServiceAdapterListener) {
    }

    default public void checkServiceStatus(String string, User user, CoreServiceAdapterListener coreServiceAdapterListener) {
    }

    default public void setRoamingEnabled(boolean bl) {
    }

    default public void sendPrivacyModeStatus(boolean bl, CoreServiceAdapterListener coreServiceAdapterListener) {
    }

    default public void submitCurrentServicesStateToBackend() {
    }

    default public void addUpdateListener(CoreServiceAdapterUpdateListener coreServiceAdapterUpdateListener) {
    }

    default public void removeUpdateListener(CoreServiceAdapterUpdateListener coreServiceAdapterUpdateListener) {
    }

    default public int[] getSupportedFuntions() {
    }

    default public boolean isFuntionSupported(int n) {
    }
}

