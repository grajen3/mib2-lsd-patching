/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.displaymanagement.factoryreset;

import de.vw.mib.asl.framework.internal.displaymanagement.DisplayManagementServices;
import de.vw.mib.asl.framework.internal.displaymanagement.DisplayTimer;
import de.vw.mib.asl.framework.internal.displaymanagement.DisplayableComponentData;
import de.vw.mib.log4mib.Logger;
import org.dsi.ifc.displaymanagement.DSIDisplayManagement;

class TvAndVideoDisplayableFactoryResetPersistanceWriter {
    private final DisplayTimer displayTimer;
    private final DSIDisplayManagement dsiDisplayManagement;
    private final Logger logger;
    private String LOGGING_DELIM = "[AbstractDisplayManagementResetParticipant] ";

    TvAndVideoDisplayableFactoryResetPersistanceWriter(DisplayManagementServices displayManagementServices, DSIDisplayManagement dSIDisplayManagement) {
        this.checkConstructorArguments(displayManagementServices, dSIDisplayManagement);
        this.dsiDisplayManagement = dSIDisplayManagement;
        this.logger = displayManagementServices.getLogger();
        this.displayTimer = displayManagementServices.getDisplayTimer();
    }

    void applyDefaultVideoOrTvDisplayableData(int n) {
        DisplayableComponentData displayableComponentData = new DisplayableComponentData(n);
        if (!displayableComponentData.isVideoOrTvDisplayableComponent()) {
            this.error(new StringBuffer().append("The ID >").append(n).append("< represents no TV or video displayable component. It will not be reseted.").toString());
            return;
        }
        if (this.isTraceEnabled()) {
            this.trace("sendPersistedVideoOrTvDisplayableData send default video displayable data to DSI");
        }
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        this.writeDisplayableBrightnessToDsi(n, n2);
        this.writeDisplayableContrastToDSI(n, n3);
        this.writeDisplayableColorToDSI(n, n4);
        this.writeDisplayableTintToDSI(n, n5);
        this.displayTimer.triggerDisplayResponseTimer();
    }

    private void checkConstructorArguments(DisplayManagementServices displayManagementServices, DSIDisplayManagement dSIDisplayManagement) {
        if (displayManagementServices == null) {
            throw new IllegalArgumentException("Display management services must not be null.");
        }
        if (dSIDisplayManagement == null) {
            throw new IllegalArgumentException("DSI display management must not be null");
        }
    }

    private void error(String string) {
        this.logger.error(4096, new StringBuffer().append(this.LOGGING_DELIM).append(string).toString());
    }

    private boolean isTraceEnabled() {
        return this.logger.isTraceEnabled(4096);
    }

    private void trace(String string) {
        this.logger.trace(4096, new StringBuffer().append(this.LOGGING_DELIM).append(string).toString());
    }

    private void writeDisplayableBrightnessToDsi(int n, int n2) {
        this.dsiDisplayManagement.setBrightness(n, n2);
        this.dsiDisplayManagement.getBrightness(n);
    }

    private void writeDisplayableColorToDSI(int n, int n2) {
        this.dsiDisplayManagement.setColor(n, n2);
        this.dsiDisplayManagement.getColor(n);
    }

    private void writeDisplayableContrastToDSI(int n, int n2) {
        this.dsiDisplayManagement.setContrast(n, n2);
        this.dsiDisplayManagement.getContrast(n);
    }

    private void writeDisplayableTintToDSI(int n, int n2) {
        this.dsiDisplayManagement.setTint(n, n2);
        this.dsiDisplayManagement.getTint(n);
    }
}

