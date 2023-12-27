/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r.operation;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.internal.startupv7r.AbstractTimedStartupTask;
import de.vw.mib.asl.framework.internal.startupv7r.StartupConfiguration;
import de.vw.mib.asl.framework.internal.startupv7r.StartupServices;
import de.vw.mib.asl.framework.internal.startupv7r.model.DomainStates;
import de.vw.mib.asl.framework.internal.startupv7r.operation.StartDomainsOperation$1;
import de.vw.mib.collections.ints.IntArrayList;
import de.vw.mib.collections.ints.IntIntOptHashMap;
import de.vw.mib.collections.ints.IntIterator;
import de.vw.mib.error.ErrorHandler;
import de.vw.mib.perf.service.PerfService;
import de.vw.mib.util.Util;
import org.dsi.ifc.startup.DSIStartup;
import org.dsi.ifc.startup.DSIStartupListener;

public class StartDomainsOperation
extends AbstractTimedStartupTask {
    private static final int DOMAIN_TIMEOUT = Integer.getInteger("domainTimeout", 1083965440);
    private final IntIntOptHashMap lastRequestedDomains = new IntIntOptHashMap(2);
    private final PerfService perfService;
    private final ErrorHandler errorHandler;
    private final DSIProxy dsiProxy;
    private final DomainStates domainStatesModel;
    private final int[] domains;
    private final int[] domainStates;
    private DSIStartup dsiStartup;
    private DSIStartupListener dsiStartupListener;
    static /* synthetic */ Class class$org$dsi$ifc$startup$DSIStartup;
    static /* synthetic */ Class class$org$dsi$ifc$startup$DSIStartupListener;

    public StartDomainsOperation(StartupServices startupServices, int[] nArray, int[] nArray2) {
        super(startupServices.getLogger(), startupServices.getTimerManager(), startupServices.getAslThreadSwitchingTarget());
        this.domains = nArray;
        this.domainStates = nArray2;
        startupServices.getEventDispatcher();
        this.perfService = startupServices.getPerfService();
        this.errorHandler = startupServices.getAslFrameworkServices().getErrorHandler();
        this.dsiProxy = startupServices.getDSIProxy();
        startupServices.getRestartHandler();
        this.domainStatesModel = startupServices.getDomainStates();
    }

    @Override
    public void runTask() {
        this.connectToDsi();
        IntArrayList intArrayList = new IntArrayList(this.domains.length);
        IntArrayList intArrayList2 = new IntArrayList(this.domainStates.length);
        for (int i2 = 0; i2 < this.domains.length; ++i2) {
            if (StartupConfiguration.isDomainAllowedForStart(this.domains[i2])) {
                intArrayList.add(this.domains[i2]);
                intArrayList2.add(this.domainStates[i2]);
                continue;
            }
            this.info(new StringBuffer().append("Skipping Domain: ").append(this.domains[i2]).append(", state: ").append(this.domainStates[i2]).append("; because FeatureFlag was not set").toString());
        }
        int[] nArray = new int[intArrayList2.size()];
        this.lastRequestedDomains.clear();
        boolean bl = true;
        for (int i3 = 0; i3 < nArray.length; ++i3) {
            nArray[i3] = this.domainStatesModel.getRequestedState(intArrayList.get(i3));
            if (nArray[i3] >= intArrayList2.get(i3) && nArray[i3] < 16) continue;
            this.trace(new StringBuffer().append("Requesting Domain: ").append(intArrayList.get(i3)).append(" Req. Domainstate: ").append(intArrayList2.get(i3)).toString());
            if (this.perfService != null) {
                this.perfService.performanceLogDomain(intArrayList.get(i3), 0, intArrayList2.get(i3));
            }
            bl = false;
            this.domainStatesModel.setRequestedState(intArrayList.get(i3), intArrayList2.get(i3));
            this.lastRequestedDomains.put(intArrayList.get(i3), intArrayList2.get(i3));
            this.dsiStartup.startDomain(intArrayList.get(i3), intArrayList2.get(i3));
        }
        if (bl) {
            this.info("Domain(s) already reached requested state or higher, moving on...");
            this.finish();
        }
    }

    @Override
    protected long getTimeout() {
        return DOMAIN_TIMEOUT;
    }

    @Override
    protected void handleTimeout() {
        StringBuffer stringBuffer = new StringBuffer(80);
        IntIterator intIterator = this.lastRequestedDomains.keyIterator();
        int[] nArray = new int[this.lastRequestedDomains.size()];
        int[] nArray2 = new int[nArray.length];
        int n = 0;
        while (intIterator.hasNext()) {
            nArray[n] = intIterator.next();
            nArray2[n] = this.lastRequestedDomains.get(nArray[n++]);
        }
        stringBuffer.append("(SOUTHSIDE)Domain timeout(s) for: ");
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            stringBuffer.append(nArray[i2]).append("[").append(this.resolveDomainName(nArray[i2])).append("] (state: ").append(nArray2[i2]).append("),");
            this.domainCallback(nArray[i2], nArray2[i2], true);
            if (this.perfService == null) continue;
            this.perfService.performanceLogDomain(nArray[i2], 2, nArray2[i2]);
        }
        this.errorHandler.handleStartupError(new Exception(stringBuffer.toString()));
    }

    void domainCallback(int n, int n2, boolean bl) {
        this.trace(new StringBuffer().append("[ASLStartup v8]>>>domainCallback|domain: ").append(n).append("|domainState: ").append(n2).toString());
        int n3 = this.domainStatesModel.getRequestedState(n);
        if (n3 == -1) {
            this.domainStatesModel.setRequestedState(n, n2);
        } else if (!this.lastRequestedDomains.containsKey(n)) {
            this.trace(new StringBuffer().append("Another domain updated out-of-order: ").append(n).toString());
        } else if (!this.isRequestedBitInDomainStateSet(n2, n3) || n2 > n3 && n2 < 128) {
            this.warn(new StringBuffer().append("Returned domainstate was lower than expected, or error:").append(n2).append("; awaited:").append(n3).append("; domain: ").append(n).toString());
            if (bl) {
                this.lastRequestedDomains.remove(n);
            }
            if (this.lastRequestedDomains.isEmpty()) {
                if (bl) {
                    this.info("All requested domains ready(although with errors), trying to move on nevertheless...");
                    this.finish();
                }
            } else {
                this.trace("Not all requested Domains have answered yet or did not achieve their timeout, continue waiting for them...");
            }
        } else {
            if (!bl) {
                this.trace("Returned Domain is OK!");
            } else {
                this.trace("Returned Domain had timed out!");
            }
            this.lastRequestedDomains.remove(n);
            if (this.perfService != null) {
                this.perfService.performanceLogDomain(n, 1, n2);
            }
            if (this.lastRequestedDomains.isEmpty()) {
                this.trace("All requested domains ready, moving on...");
                this.finish();
            } else {
                this.trace("Not all requested Domains have answered yet, continue waiting for them...");
            }
        }
    }

    private boolean isRequestedBitInDomainStateSet(int n, int n2) {
        return Util.isBitSet(n2, n);
    }

    @Override
    protected void cleanUp() {
        super.cleanUp();
        this.disconnectFromDsi();
    }

    private String resolveDomainName(int n) {
        switch (n) {
            case 4: {
                return "DOMAINID_STARTUP_DOMAIN_ADDRESSBOOK";
            }
            case 31: {
                return "DOMAINID_STARTUP_DOMAIN_ASIA_LANGUAGE_SUPPORT";
            }
            case 9: {
                return "DOMAINID_STARTUP_DOMAIN_AUDIO";
            }
            case 18: {
                return "DOMAINID_STARTUP_DOMAIN_BAPKOMBI";
            }
            case 19: {
                return "DOMAINID_STARTUP_DOMAIN_BLUETOOTH";
            }
            case 20: {
                return "DOMAINID_STARTUP_DOMAIN_BROWSER";
            }
            case 22: {
                return "DOMAINID_STARTUP_DOMAIN_CALENDAR";
            }
            case 8: {
                return "DOMAINID_STARTUP_DOMAIN_CAR";
            }
            case 14: {
                return "DOMAINID_STARTUP_DOMAIN_COMMUNICATION";
            }
            case 30: {
                return "DOMAINID_STARTUP_DOMAIN_DIAGNOSIS";
            }
            case 12: {
                return "DOMAINID_STARTUP_DOMAIN_EARLY_APPS";
            }
            case 26: {
                return "DOMAINID_STARTUP_DOMAIN_EXBOXM";
            }
            case 32: {
                return "DOMAINID_STARTUP_DOMAIN_EXLAP";
            }
            case 21: {
                return "DOMAINID_STARTUP_DOMAIN_EXPLORER";
            }
            case 17: {
                return "DOMAINID_STARTUP_DOMAIN_GEMMI";
            }
            case 7: {
                return "DOMAINID_STARTUP_DOMAIN_INFO";
            }
            case 16: {
                return "DOMAINID_STARTUP_DOMAIN_IPSERVICES";
            }
            case 3: {
                return "DOMAINID_STARTUP_DOMAIN_MEDIA";
            }
            case 34: {
                return "DOMAINID_STARTUP_DOMAIN_MEDIA_ONLINE";
            }
            case 35: {
                return "DOMAINID_STARTUP_DOMAIN_MEDIA_ROUTER";
            }
            case 27: {
                return "DOMAINID_STARTUP_DOMAIN_MIRRORLINK";
            }
            case 25: {
                return "DOMAINID_STARTUP_DOMAIN_MOBILITYHORIZON";
            }
            case 6: {
                return "DOMAINID_STARTUP_DOMAIN_NAV";
            }
            case 5: {
                return "DOMAINID_STARTUP_DOMAIN_PHONE";
            }
            case 23: {
                return "DOMAINID_STARTUP_DOMAIN_PICTURESTORE";
            }
            case 13: {
                return "DOMAINID_STARTUP_DOMAIN_POST";
            }
            case 1: {
                return "DOMAINID_STARTUP_DOMAIN_ROOT";
            }
            case 10: {
                return "DOMAINID_STARTUP_DOMAIN_SDS";
            }
            case 29: {
                return "DOMAINID_STARTUP_DOMAIN_SEARCH";
            }
            case 28: {
                return "DOMAINID_STARTUP_DOMAIN_SFA";
            }
            case 24: {
                return "DOMAINID_STARTUP_DOMAIN_STREETVIEW";
            }
            case 11: {
                return "DOMAINID_STARTUP_DOMAIN_SWDL";
            }
            case 2: {
                return "DOMAINID_STARTUP_DOMAIN_TUNER";
            }
            case 33: {
                return "DOMAINID_STARTUP_DOMAIN_TVTUNER";
            }
            case 36: {
                return "DOMAINID_STARTUP_DOMAIN_RADIODATA_SERVER";
            }
            case 37: {
                return "DOMAINID_STARTUP_DOMAIN_SMARTPHONE_INTEGRATION";
            }
            case 38: {
                return "DOMAINID_STARTUP_DOMAIN_WIRELESS_CHARGER";
            }
            case 0: {
                return "DOMAINID_STARTUP_DOMAIN_UNKNOWN";
            }
        }
        return "UNKNOWN";
    }

    private void connectToDsi() {
        this.dsiStartup = (DSIStartup)this.dsiProxy.getService(null, class$org$dsi$ifc$startup$DSIStartup == null ? (class$org$dsi$ifc$startup$DSIStartup = StartDomainsOperation.class$("org.dsi.ifc.startup.DSIStartup")) : class$org$dsi$ifc$startup$DSIStartup);
        this.dsiStartupListener = this.createDsiStartupListener();
        this.dsiProxy.addResponseListener(null, class$org$dsi$ifc$startup$DSIStartupListener == null ? (class$org$dsi$ifc$startup$DSIStartupListener = StartDomainsOperation.class$("org.dsi.ifc.startup.DSIStartupListener")) : class$org$dsi$ifc$startup$DSIStartupListener, this.dsiStartupListener);
        this.dsiStartup.setNotification(this.dsiStartupListener);
    }

    private void disconnectFromDsi() {
        this.dsiProxy.removeResponseListener(null, class$org$dsi$ifc$startup$DSIStartupListener == null ? (class$org$dsi$ifc$startup$DSIStartupListener = StartDomainsOperation.class$("org.dsi.ifc.startup.DSIStartupListener")) : class$org$dsi$ifc$startup$DSIStartupListener, this.dsiStartupListener);
        this.dsiStartup.clearNotification(this.dsiStartupListener);
    }

    private DSIStartupListener createDsiStartupListener() {
        return new StartDomainsOperation$1(this);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

