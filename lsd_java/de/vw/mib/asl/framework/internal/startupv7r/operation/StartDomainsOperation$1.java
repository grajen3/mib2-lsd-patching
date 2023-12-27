/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r.operation;

import de.vw.mib.asl.framework.internal.startupv7r.operation.StartDomainsOperation;
import org.dsi.ifc.startup.DSIStartupListener;

class StartDomainsOperation$1
implements DSIStartupListener {
    private final /* synthetic */ StartDomainsOperation this$0;

    StartDomainsOperation$1(StartDomainsOperation startDomainsOperation) {
        this.this$0 = startDomainsOperation;
    }

    @Override
    public void asyncException(int n, String string, int n2) {
    }

    @Override
    public void updateDomainStatusWirelessCharger(int n, int n2) {
        this.this$0.domainCallback(38, n, false);
    }

    @Override
    public void updateDomainStatusTuner(int n, int n2) {
        this.this$0.domainCallback(2, n, false);
    }

    @Override
    public void updateDomainStatusTVTuner(int n, int n2) {
        this.this$0.domainCallback(33, n, false);
    }

    @Override
    public void updateDomainStatusStreetView(int n, int n2) {
        this.this$0.domainCallback(24, n, false);
    }

    @Override
    public void updateDomainStatusSmartphoneIntegration(int n, int n2) {
        this.this$0.domainCallback(37, n, false);
    }

    @Override
    public void updateDomainStatusSearch(int n, int n2) {
        this.this$0.domainCallback(29, n, false);
    }

    @Override
    public void updateDomainStatusSWDL(int n, int n2) {
        this.this$0.domainCallback(11, n, false);
    }

    @Override
    public void updateDomainStatusSFA(int n, int n2) {
        this.this$0.domainCallback(28, n, false);
    }

    @Override
    public void updateDomainStatusSDS(int n, int n2) {
        this.this$0.domainCallback(10, n, false);
    }

    @Override
    public void updateDomainStatusRoot(int n, int n2) {
        this.this$0.domainCallback(1, n, false);
    }

    @Override
    public void updateDomainStatusRadioDataServer(int n, int n2) {
        this.this$0.domainCallback(36, n, false);
    }

    @Override
    public void updateDomainStatusPostStartup(int n, int n2) {
        this.this$0.domainCallback(13, n, false);
    }

    @Override
    public void updateDomainStatusPictureStore(int n, int n2) {
        this.this$0.domainCallback(23, n, false);
    }

    @Override
    public void updateDomainStatusPhone(int n, int n2) {
        this.this$0.domainCallback(5, n, false);
    }

    @Override
    public void updateDomainStatusNav(int n, int n2) {
        this.this$0.domainCallback(6, n, false);
    }

    @Override
    public void updateDomainStatusMobilityHorizon(int n, int n2) {
        this.this$0.domainCallback(25, n, false);
    }

    @Override
    public void updateDomainStatusMirrorLink(int n, int n2) {
        this.this$0.domainCallback(27, n, false);
    }

    @Override
    public void updateDomainStatusMediaRouter(int n, int n2) {
        this.this$0.domainCallback(35, n, false);
    }

    @Override
    public void updateDomainStatusMediaOnline(int n, int n2) {
        this.this$0.domainCallback(34, n, false);
    }

    @Override
    public void updateDomainStatusMedia(int n, int n2) {
        this.this$0.domainCallback(3, n, false);
    }

    @Override
    public void updateDomainStatusIpServices(int n, int n2) {
        this.this$0.domainCallback(16, n, false);
    }

    @Override
    public void updateDomainStatusInfo(int n, int n2) {
        this.this$0.domainCallback(7, n, false);
    }

    @Override
    public void updateDomainStatusGEMMI(int n, int n2) {
        this.this$0.domainCallback(17, n, false);
    }

    @Override
    public void updateDomainStatusExplorer(int n, int n2) {
        this.this$0.domainCallback(21, n, false);
    }

    @Override
    public void updateDomainStatusExLAP(int n, int n2) {
        this.this$0.domainCallback(32, n, false);
    }

    @Override
    public void updateDomainStatusExBoxM(int n, int n2) {
        this.this$0.domainCallback(26, n, false);
    }

    @Override
    public void updateDomainStatusEarlyApps(int n, int n2) {
        this.this$0.domainCallback(12, n, false);
    }

    @Override
    public void updateDomainStatusDiagnosis(int n, int n2) {
        this.this$0.domainCallback(30, n, false);
    }

    @Override
    public void updateDomainStatusCommunication(int n, int n2) {
        this.this$0.domainCallback(14, n, false);
    }

    @Override
    public void updateDomainStatusCar(int n, int n2) {
        this.this$0.domainCallback(8, n, false);
    }

    @Override
    public void updateDomainStatusCalendar(int n, int n2) {
        this.this$0.domainCallback(22, n, false);
    }

    @Override
    public void updateDomainStatusBrowser(int n, int n2) {
        this.this$0.domainCallback(20, n, false);
    }

    @Override
    public void updateDomainStatusBluetooth(int n, int n2) {
        this.this$0.domainCallback(19, n, false);
    }

    @Override
    public void updateDomainStatusBapkombi(int n, int n2) {
        this.this$0.domainCallback(18, n, false);
    }

    @Override
    public void updateDomainStatusAudio(int n, int n2) {
        this.this$0.domainCallback(9, n, false);
    }

    @Override
    public void updateDomainStatusAsiaLanguageSupport(int n, int n2) {
        this.this$0.domainCallback(31, n, false);
    }

    @Override
    public void updateDomainStatusAddressbook(int n, int n2) {
        this.this$0.domainCallback(4, n, false);
    }

    @Override
    public void startDomain(int n, int n2) {
    }
}

