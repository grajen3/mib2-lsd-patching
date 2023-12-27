/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.download;

import de.vw.mib.asl.internal.download.SoftwareDownloadServices;
import de.vw.mib.asl.internal.impl.download.SoftwareDownloadServicesImpl;

public class SoftwareDownloadServicesProvider {
    private static SoftwareDownloadServices softwareDownloadServices;

    public static SoftwareDownloadServices getSoftwareDownloadServices() {
        if (softwareDownloadServices == null) {
            softwareDownloadServices = new SoftwareDownloadServicesImpl();
        }
        return softwareDownloadServices;
    }

    public static void setHomeScreenServices(SoftwareDownloadServices softwareDownloadServices) {
        SoftwareDownloadServicesProvider.softwareDownloadServices = softwareDownloadServices;
    }
}

