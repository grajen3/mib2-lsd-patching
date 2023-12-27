/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r.operation;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListenerAdapter;
import de.vw.mib.asl.framework.api.startupv7r.DSIInfo;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.startupv7r.AbstractTimedStartupTask;
import de.vw.mib.asl.framework.internal.startupv7r.ContextInfo;
import de.vw.mib.asl.framework.internal.startupv7r.StartupServices;
import de.vw.mib.asl.framework.internal.startupv7r.operation.StartDsisOperation$1;
import edu.emory.mathcs.backport.java.util.Arrays;
import java.util.ArrayList;

public class StartDsisOperation
extends AbstractTimedStartupTask {
    private static final int DSI_TIMEOUT = Integer.getInteger("dsiTimeout", 10000);
    private final ArrayList failedDsis = new ArrayList(3);
    private final ContextInfo contextInfo = new ContextInfo();
    private final StartupServices startupServices;
    private final DSIProxy dsiProxy;
    private final DSIServiceStateListenerAdapter serviceStateListener;
    private final int[] dsisToStart;
    private final boolean[] dsiDoNotWaitFlags;
    private final boolean useOldDsiDefinition;
    private DSIInfo[] awaitedDSIInfos;
    private boolean[] dsiLoadStatus;

    public StartDsisOperation(StartupServices startupServices, int[] nArray, boolean[] blArray, boolean bl) {
        super(startupServices.getLogger(), startupServices.getTimerManager(), startupServices.getAslThreadSwitchingTarget());
        this.startupServices = startupServices;
        this.dsisToStart = nArray;
        this.dsiDoNotWaitFlags = blArray;
        this.useOldDsiDefinition = bl;
        this.serviceStateListener = this.createServiceStateListener();
        this.dsiProxy = startupServices.getDSIProxy();
    }

    public ArrayList getFailedDsis() {
        return this.failedDsis;
    }

    @Override
    protected void runTask() {
        int n;
        int n2;
        this.dsiProxy.addServiceStateListener(this.serviceStateListener);
        int[] nArray = this.contextInfo.filterForAllowedDsis(this.dsisToStart, this.useOldDsiDefinition);
        boolean[] blArray = this.contextInfo.filterForAllowedDsis(this.dsisToStart, this.dsiDoNotWaitFlags, this.useOldDsiDefinition);
        DSIInfo[] dSIInfoArray = this.contextInfo.getDSIInfoBeforeStart(nArray, this.useOldDsiDefinition);
        this.awaitedDSIInfos = dSIInfoArray;
        this.dsiLoadStatus = new boolean[dSIInfoArray.length];
        Arrays.fill(this.dsiLoadStatus, false);
        for (int i2 = 0; i2 < dSIInfoArray.length; ++i2) {
            if (dSIInfoArray[i2] != null) continue;
            this.dsiLoadStatus[i2] = true;
        }
        boolean[] blArray2 = this.contextInfo.startDSIByIds(nArray, this.useOldDsiDefinition);
        for (n2 = 0; n2 < blArray2.length; ++n2) {
            if (!blArray2[n2]) {
                this.dsiLoadStatus[n2] = true;
                continue;
            }
            if (this.startupServices.getPerfService() == null) continue;
            this.startupServices.getPerfService().performanceLogDSI(dSIInfoArray[n2].interfaceName, 0);
        }
        for (n2 = 0; n2 < blArray.length; ++n2) {
            n = blArray[n2];
            if (n == 0) continue;
            this.dsiLoadStatus[n2] = true;
            String string = ServiceManager.configManagerDiag.getServiceName(nArray[n2 * 2]);
            this.trace(new StringBuffer().append("It will not be waited for ").append(string).append(" to respond!").toString());
        }
        if (blArray2.length == 1 && !blArray2[0]) {
            this.dsiCallback(dSIInfoArray[0].interfaceName, dSIInfoArray[0].instanceId);
        }
        n2 = 1;
        for (n = 0; n < this.dsiLoadStatus.length; ++n) {
            n2 &= this.dsiLoadStatus[n];
        }
        if (n2 != 0) {
            this.info("All DSIs were skipped, moving on directly...");
            this.awaitedDSIInfos = null;
            this.finish();
        }
    }

    @Override
    protected long getTimeout() {
        return DSI_TIMEOUT;
    }

    @Override
    protected void handleTimeout() {
        if (this.awaitedDSIInfos != null) {
            int n = 0;
            StringBuffer stringBuffer = new StringBuffer(50);
            stringBuffer.append("(SOUTHSIDE)DSI timeout for {");
            for (int i2 = 0; i2 < this.awaitedDSIInfos.length; ++i2) {
                if (this.dsiLoadStatus[i2] || this.awaitedDSIInfos[i2].interfaceName.equals("excluded")) continue;
                ++n;
                this.addToFailedDSI(this.awaitedDSIInfos[i2]);
                stringBuffer.append(this.awaitedDSIInfos[i2]).append("|");
                if (this.startupServices.getPerfService() == null) continue;
                this.startupServices.getPerfService().performanceLogDSI(this.awaitedDSIInfos[i2].interfaceName, 2);
            }
            stringBuffer.append("}");
            if (n != 0) {
                ServiceManager.errorHandler.handleStartupError(new Exception(stringBuffer.toString()));
            }
            this.awaitedDSIInfos = null;
            this.finish();
        }
    }

    @Override
    protected void cleanUp() {
        this.dsiProxy.removeServiceStateListener(this.serviceStateListener);
    }

    void onDSIRegistration(String string, int n) {
        if (this.awaitedDSIInfos != null) {
            try {
                this.dsiCallback(string, n);
            }
            catch (Exception exception) {
                this.error(exception.getMessage(), exception);
            }
        } else {
            this.addToFailedDSI(new DSIInfo(string, n));
        }
    }

    private void dsiCallback(String string, int n) {
        int n2;
        this.trace(new StringBuffer().append("[ASLStartup v8]>>>dsiCallback|dsiInterface:").append(string).append(", instance ").append(n).toString());
        if (this.startupServices.getPerfService() != null) {
            this.startupServices.getPerfService().performanceLogDSI(string, 1);
        }
        boolean bl = false;
        for (n2 = 0; !bl && n2 < this.awaitedDSIInfos.length; ++n2) {
            DSIInfo dSIInfo = this.awaitedDSIInfos[n2];
            if (dSIInfo == null) continue;
            boolean bl2 = bl = dSIInfo.interfaceName.equals(string) && dSIInfo.instanceId == n;
            if (!bl) continue;
            this.dsiLoadStatus[n2] = bl;
        }
        if (!bl) {
            this.trace(new StringBuffer().append("[ASLStartup v8]Wrong Dsi returned; awaited: ").append(Arrays.toString(this.awaitedDSIInfos)).append(" actual: ").append(string).append(", instance ").append(n).toString());
            this.failedDsis.add(new DSIInfo(string, n));
        } else {
            n2 = 1;
            for (int i2 = 0; n2 != 0 && i2 < this.dsiLoadStatus.length; ++i2) {
                n2 = this.dsiLoadStatus[i2];
            }
            if (n2 != 0) {
                this.awaitedDSIInfos = null;
                this.finish();
            }
        }
    }

    private void addToFailedDSI(DSIInfo dSIInfo) {
        this.failedDsis.add(dSIInfo);
    }

    private DSIServiceStateListenerAdapter createServiceStateListener() {
        return new StartDsisOperation$1(this);
    }
}

