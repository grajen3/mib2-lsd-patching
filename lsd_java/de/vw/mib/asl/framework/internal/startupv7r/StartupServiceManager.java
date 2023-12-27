/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r;

import de.vw.mib.asl.framework.api.startupv7r.StartupServiceManagerConstants;

public final class StartupServiceManager
implements StartupServiceManagerConstants {
    public static final String STARTUP_VERSION_TRACE_LITERAL;
    public static boolean aslNavStartupWasDoneAlready;
    public static boolean startupDone;
    public static boolean swdlPowerstateDetected;
    public static boolean komoNavIsAllowedByCoding;
    public static boolean pictureServerStartAllowed;
    public static boolean isHighActivatorStarted;
    public static boolean nonCustomerSwdlIsInProgress;
    private static int currentSupplier;

    public static void setCurrentVariantInformation(int n) {
        currentSupplier = n;
    }

    public static int getSupplier() {
        return currentSupplier;
    }

    static {
        aslNavStartupWasDoneAlready = false;
        startupDone = false;
        swdlPowerstateDetected = false;
        komoNavIsAllowedByCoding = true;
        pictureServerStartAllowed = false;
        currentSupplier = -1;
    }
}

