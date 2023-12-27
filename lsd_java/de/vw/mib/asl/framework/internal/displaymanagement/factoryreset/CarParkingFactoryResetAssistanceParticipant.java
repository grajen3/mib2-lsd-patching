/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.displaymanagement.factoryreset;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.api.system.ASLSystemAPI;
import de.vw.mib.asl.api.system.factoryreset.AbstractFactoryResetParticipant;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetCallback;
import de.vw.mib.asl.framework.internal.displaymanagement.DisplayManagementServices;
import de.vw.mib.asl.framework.internal.displaymanagement.DisplayTimer;
import de.vw.mib.log4mib.Logger;
import org.dsi.ifc.displaymanagement.DSIDisplayManagement;

public class CarParkingFactoryResetAssistanceParticipant
extends AbstractFactoryResetParticipant {
    private static final String LOGGING_DELIM;
    private final ASLPropertyManager aslPropertyManager;
    private final ASLSystemAPI aslSystemApi;
    private final DisplayTimer displayTimer;
    private final DSIDisplayManagement dsiDisplayManagement;
    private boolean flagRVCAvailable;
    private final Logger logger;

    public CarParkingFactoryResetAssistanceParticipant(DisplayManagementServices displayManagementServices, DSIDisplayManagement dSIDisplayManagement) {
        this.checkConstructorArguments(displayManagementServices, dSIDisplayManagement);
        this.dsiDisplayManagement = dSIDisplayManagement;
        this.aslPropertyManager = displayManagementServices.getAslPropertyManager();
        this.aslSystemApi = displayManagementServices.getAslSystemApi();
        this.displayTimer = displayManagementServices.getDisplayTimer();
        this.logger = displayManagementServices.getLogger();
    }

    @Override
    public void reset(FactoryResetCallback factoryResetCallback, int n) {
        this.revertCarSettings();
        factoryResetCallback.notifyResetDone();
    }

    public void setFlagRVCAvailable(boolean bl) {
        this.flagRVCAvailable = bl;
    }

    private void checkConstructorArguments(DisplayManagementServices displayManagementServices, DSIDisplayManagement dSIDisplayManagement) {
        if (displayManagementServices == null) {
            throw new IllegalArgumentException("Display management services must be provided.");
        }
        if (dSIDisplayManagement == null) {
            throw new IllegalArgumentException("DSI display management must be provided.");
        }
    }

    private boolean isTraceEnabled() {
        return this.logger.isTraceEnabled(4096);
    }

    private void resetDsiBrightness(int n) {
        int n2 = this.aslSystemApi.mapValue(n, 0, 100, -128, 127);
        this.dsiDisplayManagement.setBrightness(17, n2);
        this.dsiDisplayManagement.getBrightness(17);
    }

    private void resetDsiColor(int n) {
        int n2 = this.aslSystemApi.mapValue(n, 0, 100, -128, 127);
        this.dsiDisplayManagement.setColor(17, n2);
        this.dsiDisplayManagement.getColor(17);
    }

    private void resetDsiContrast(int n) {
        int n2 = this.aslSystemApi.mapValue(n, 0, 100, -128, 127);
        this.dsiDisplayManagement.setContrast(17, n2);
        this.dsiDisplayManagement.getContrast(17);
    }

    private void resetRVCDisplayableData() {
        int n = 50;
        int n2 = 50;
        int n3 = 50;
        this.resetDsiBrightness(n);
        this.aslPropertyManager.valueChangedInteger(10181, n);
        this.resetDsiContrast(n2);
        this.aslPropertyManager.valueChangedInteger(10183, n2);
        this.resetDsiColor(n3);
        this.aslPropertyManager.valueChangedInteger(10182, n3);
        this.displayTimer.triggerDisplayResponseTimer();
    }

    private void revertCarSettings() {
        if (this.isTraceEnabled()) {
            this.trace("revertCarSettings");
        }
        if (this.flagRVCAvailable) {
            this.resetRVCDisplayableData();
        }
    }

    private void trace(String string) {
        this.logger.trace(4096, new StringBuffer().append("[CarParkingAssistanceParticipant] ").append(string).toString());
    }
}

