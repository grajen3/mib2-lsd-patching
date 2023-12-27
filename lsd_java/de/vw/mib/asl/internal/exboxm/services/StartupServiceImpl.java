/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.exboxm.services;

import de.vw.mib.asl.internal.exboxm.services.ExboxServicesProvider;
import de.vw.mib.asl.internal.exboxm.services.StartupListener;
import de.vw.mib.asl.internal.exboxm.services.StartupService;
import de.vw.mib.asl.internal.exboxm.services.StartupServiceImpl$1;
import de.vw.mib.genericevents.ThreadSwitchingTarget;
import de.vw.mib.log4mib.Logger;
import java.util.ArrayList;
import java.util.Iterator;

public class StartupServiceImpl
implements StartupService {
    private final ArrayList listeners = new ArrayList();
    private final Logger logger;
    private boolean powerOnOccured;

    public StartupServiceImpl(Logger logger) {
        this.checkConstructorArguments(logger);
        this.logger = logger;
    }

    @Override
    public void addStartupListener(StartupListener startupListener) {
        if (startupListener == null) {
            throw new IllegalArgumentException("Listener must not be null.");
        }
        if (this.powerOnOccured) {
            this.notifyPowerOn(startupListener);
        } else {
            if (this.listeners.contains(startupListener)) {
                throw new IllegalArgumentException("Listener already registered.");
            }
            this.listeners.add(startupListener);
        }
    }

    @Override
    public boolean isPowerOnEventSent() {
        return this.powerOnOccured;
    }

    void processPowerOnOccured() {
        this.logger.trace(8, "[StartupServiceImpl] Startup service recived power on.");
        this.powerOnOccured = true;
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            StartupListener startupListener = (StartupListener)iterator.next();
            this.notifyPowerOn(startupListener);
        }
        this.listeners.clear();
    }

    private void checkConstructorArguments(Logger logger) {
        if (logger == null) {
            throw new IllegalArgumentException("Logger must not be null");
        }
    }

    private void notifyPowerOn(StartupListener startupListener) {
        ThreadSwitchingTarget threadSwitchingTarget = ExboxServicesProvider.getExBoxServices().getAslThreadSwitchingTarget();
        threadSwitchingTarget.invoke(new StartupServiceImpl$1(this, startupListener));
    }
}

