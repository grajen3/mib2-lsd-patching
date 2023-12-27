/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreInterfaces.external;

import de.vw.mib.asl.internal.online.coreInterfaces.external.CoreServiceExternalListener;

public interface CoreServiceExternal {
    public static final int UNKNOWN_FUNCTION_ID;
    public static final int SERVICE_URL_FUNCTION_ID;
    public static final int DOWNLOAD_IMAGE_FUNCTION_ID;
    public static final int TRACKING_VALID_FUNCTION_ID;
    public static final int SPIN_HASH_FUNCTION_ID;
    public static final int SET_SPIN_FUNCTION_ID;

    default public void getServiceURL(String string, CoreServiceExternalListener coreServiceExternalListener) {
    }

    default public void downloadImage(String string, String string2, String string3, boolean bl, CoreServiceExternalListener coreServiceExternalListener) {
    }

    default public void setTrackingServicesUpdateValid(boolean bl) {
    }

    default public void calculateSPinHash(String string, String string2, String string3, String string4, int n, CoreServiceExternalListener coreServiceExternalListener) {
    }

    default public int[] getSupportedFunctions() {
    }

    default public boolean isFuntionSupported(int n) {
    }

    default public void setSPin(String string, String string2, CoreServiceExternalListener coreServiceExternalListener) {
    }
}

