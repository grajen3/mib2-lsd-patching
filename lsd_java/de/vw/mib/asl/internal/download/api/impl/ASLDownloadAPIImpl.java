/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.download.api.impl;

import de.vw.mib.asl.api.download.ASLDownloadAPI;
import de.vw.mib.asl.api.download.DownloadStateService;
import de.vw.mib.asl.framework.internal.framework.id.PreRegisteredIds;
import de.vw.mib.asl.internal.download.SoftwareDownloadServices;
import de.vw.mib.asl.internal.download.swdl2.AslTargetCarWorkshopDownload;
import de.vw.mib.asl.internal.download.swdl2.AslTargetCustomerDownload;
import de.vw.mib.asl.internal.impl.download.PropagatingDownloadStateService;
import de.vw.mib.asl.internal.impl.download.SoftwareDownloadServicesProvider;

public class ASLDownloadAPIImpl
implements ASLDownloadAPI {
    private PropagatingDownloadStateService downloadStateService;

    private static void addServiceOrObserver(int n, int n2) {
        PreRegisteredIds.addServiceOrObserverToArray(2, n2, 570490944);
        PreRegisteredIds.addServiceOrObserverToArray(2, n2, 587268160);
        PreRegisteredIds.addServiceOrObserverToArray(2, n2, 604045376);
        PreRegisteredIds.addServiceOrObserverToArray(2, n2, 620822592);
        PreRegisteredIds.addServiceOrObserverToArray(2, n2, 637599808);
        PreRegisteredIds.addServiceOrObserverToArray(2, n2, 654377024);
        PreRegisteredIds.addServiceOrObserverToArray(2, n2, 671154240);
        PreRegisteredIds.addServiceOrObserverToArray(2, n2, 687931456);
        PreRegisteredIds.addServiceOrObserverToArray(2, n2, 704708672);
        PreRegisteredIds.addServiceOrObserverToArray(2, n2, -1241055168);
        PreRegisteredIds.addServiceOrObserverToArray(2, n2, -1224277952);
        PreRegisteredIds.addServiceOrObserverToArray(2, n2, 721485888);
        PreRegisteredIds.addServiceOrObserverToArray(2, n2, 738263104);
        PreRegisteredIds.addServiceOrObserverToArray(2, n2, 755040320);
        PreRegisteredIds.addServiceOrObserverToArray(2, n2, 771817536);
        PreRegisteredIds.addServiceOrObserverToArray(2, n2, 788594752);
        PreRegisteredIds.addServiceOrObserverToArray(2, n2, 822149184);
        PreRegisteredIds.addServiceOrObserverToArray(2, n2, 838926400);
        PreRegisteredIds.addServiceOrObserverToArray(2, n2, 855703616);
        PreRegisteredIds.addServiceOrObserverToArray(2, n2, 872480832);
        PreRegisteredIds.addServiceOrObserverToArray(2, n2, 889258048);
        PreRegisteredIds.addServiceOrObserverToArray(2, n2, 906035264);
        PreRegisteredIds.addServiceOrObserverToArray(2, n2, 922812480);
        PreRegisteredIds.addServiceOrObserverToArray(2, n2, 956366912);
        PreRegisteredIds.addServiceOrObserverToArray(2, n2, 973144128);
        PreRegisteredIds.addServiceOrObserverToArray(2, n2, 989921344);
        PreRegisteredIds.addServiceOrObserverToArray(2, n2, 1006698560);
        PreRegisteredIds.addServiceOrObserverToArray(2, n2, 1023475776);
        PreRegisteredIds.addServiceOrObserverToArray(2, n2, 1040252992);
        PreRegisteredIds.addServiceOrObserverToArray(2, n2, 1191837760);
        PreRegisteredIds.addServiceOrObserverToArray(2, n2, 1175060544);
        PreRegisteredIds.addServiceOrObserverToArray(0, n, 1612194560);
        PreRegisteredIds.addServiceOrObserverToArray(0, n, 1628971776);
        PreRegisteredIds.addServiceOrObserverToArray(0, n, 1645748992);
        PreRegisteredIds.addServiceOrObserverToArray(0, n, 1662526208);
    }

    public ASLDownloadAPIImpl() {
        SoftwareDownloadServices softwareDownloadServices = SoftwareDownloadServicesProvider.getSoftwareDownloadServices();
        this.downloadStateService = softwareDownloadServices.getDownloadStateService();
    }

    @Override
    public boolean swdlHighOmitPowerStateChangeIndicationUntilStartSwdlWasCalled() {
        return AslTargetCarWorkshopDownload.swdlHighOmitPowerStateChangeIndicationUntilStartSwdlWasCalled;
    }

    @Override
    public boolean getCurrentCustomerDownloadActivityState() {
        return AslTargetCustomerDownload.customerSwdlStateIsActive;
    }

    @Override
    public DownloadStateService getDownloadStateService() {
        return this.downloadStateService;
    }

    static {
        ASLDownloadAPIImpl.addServiceOrObserver(-1583541760, -1566764544);
    }
}

