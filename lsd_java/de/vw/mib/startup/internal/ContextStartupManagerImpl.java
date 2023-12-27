/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.startup.internal;

import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.startup.ASLStartupManager;
import de.vw.mib.startup.ContextStartupManager;
import de.vw.mib.startup.DatapoolStartupManager;
import de.vw.mib.startup.InstrumentClusterStartupManager;
import de.vw.mib.startup.internal.ContextStartupManagerImpl$1;
import de.vw.mib.startup.internal.ServiceManager;

public final class ContextStartupManagerImpl
implements ContextStartupManager {
    private static Logger logger = ServiceManager.loggerFactory.getLogger(16384);
    private ASLStartupManager aslStartupMgr;
    private DatapoolStartupManager dpStartupMgr = new ContextStartupManagerImpl$1(this);
    private InstrumentClusterStartupManager instrumentClusterStartupMgr;

    @Override
    public void contextReady(int n) {
        this.instrumentClusterStartupMgr.startContext(n);
    }

    @Override
    public void registerASLStartupManager(ASLStartupManager aSLStartupManager) {
        this.aslStartupMgr = aSLStartupManager;
    }

    @Override
    public void registerDatapoolStartupManager(DatapoolStartupManager datapoolStartupManager) {
        this.dpStartupMgr = datapoolStartupManager;
    }

    @Override
    public void registerInstrumentClusterStartupManager(InstrumentClusterStartupManager instrumentClusterStartupManager) {
        this.instrumentClusterStartupMgr = instrumentClusterStartupManager;
    }

    @Override
    public void startContext(int n) {
        if (logger.isTraceEnabled(16)) {
            LogMessage logMessage = logger.trace(16);
            logMessage.append("starting context ").append(n);
            logMessage.log();
        }
        this.dpStartupMgr.initProperties(n);
        this.aslStartupMgr.startContext(n);
        this.instrumentClusterStartupMgr.initContext(n);
    }
}

