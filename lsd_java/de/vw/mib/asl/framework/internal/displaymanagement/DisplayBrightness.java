/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.displaymanagement;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.api.system.ASLSystemAPI;
import de.vw.mib.asl.framework.internal.displaymanagement.DisplayManagementServices;
import de.vw.mib.asl.framework.internal.displaymanagement.DisplayTimer;
import de.vw.mib.asl.framework.internal.displaymanagement.DisplayableComponentData;
import de.vw.mib.asl.framework.internal.displaymanagement.PersistableDisplayManagementData;
import de.vw.mib.log4mib.Logger;
import org.dsi.ifc.displaymanagement.DSIDisplayManagement;

class DisplayBrightness {
    private static final String LOGGING_DELIM;
    private final ASLPropertyManager aslPropertyManager;
    private final ASLSystemAPI aslSystemApi;
    private final DisplayTimer displayTimer;
    private DSIDisplayManagement dsiDisplayManagement;
    private boolean isDisplayBrightnessPending;
    private boolean isHmiReadyBeenAckowledged;
    private final Logger logger;
    private int pendingDisplayBrightnessPercentage = -1;
    private final PersistableDisplayManagementData persistableData;

    DisplayBrightness(PersistableDisplayManagementData persistableDisplayManagementData, DisplayManagementServices displayManagementServices) {
        this.checkConstructorArtguments(persistableDisplayManagementData, displayManagementServices);
        this.persistableData = persistableDisplayManagementData;
        this.displayTimer = displayManagementServices.getDisplayTimer();
        this.logger = displayManagementServices.getLogger();
        this.aslPropertyManager = displayManagementServices.getAslPropertyManager();
        this.aslSystemApi = displayManagementServices.getAslSystemApi();
    }

    void changeBrightness(boolean bl, DisplayableComponentData displayableComponentData) {
        if (this.isTraceEnabled()) {
            this.trace(new StringBuffer().append("changeBrightnessForVideo increase ").append(bl).toString());
            if (this.isTraceEnabled()) {
                this.trace(new StringBuffer().append("activeVideoDisplayableId ").append(displayableComponentData.isVideoOrTvDisplayableComponent()).toString());
            }
        }
        if (displayableComponentData.isDisplayableComponentIDSet()) {
            int n;
            if (!displayableComponentData.isCachedBrightnessSet()) {
                displayableComponentData.setCachedBrightness(this.getBrightnessFromPersistence(displayableComponentData.getDisplayableComponentId()));
            }
            int n2 = n = displayableComponentData.getCachedBrightness();
            if (bl) {
                if (n < 127) {
                    ++n;
                }
            } else if (n > -128) {
                --n;
            }
            if (n != n2) {
                displayableComponentData.setCachedBrightness(n);
                this.setBrightness(displayableComponentData, true);
            }
        }
    }

    int getBrightnessFromPersistence(int n) {
        return this.persistableData.getVideoDisplayableBrightness(n);
    }

    void setBrightness(DisplayableComponentData displayableComponentData, boolean bl) {
        if (this.isTraceEnabled()) {
            this.trace(new StringBuffer().append("setDisplayableBrightness id ").append(displayableComponentData.getDisplayableComponentId()).append(" brightness ").append(displayableComponentData.getCachedBrightness()).toString());
        }
        if (bl) {
            if (displayableComponentData.isVideoOrTvDisplayableComponent()) {
                this.aslPropertyManager.valueChangedInteger(116, displayableComponentData.getCachedBrightness());
            } else {
                this.aslPropertyManager.valueChangedInteger(10181, displayableComponentData.getCachedBrightness());
            }
            this.displayTimer.triggerDisplaySetupTimer();
        } else {
            this.writeDisplayableComponentBrightnessToDsi(displayableComponentData);
            if (!displayableComponentData.isVideoOrTvDisplayableComponent()) {
                this.aslPropertyManager.valueChangedInteger(10181, displayableComponentData.getCachedBrightness());
            }
        }
    }

    void setDsiDisplayManagement(DSIDisplayManagement dSIDisplayManagement) {
        this.dsiDisplayManagement = dSIDisplayManagement;
    }

    void setHmiReadyBeenAckowledged(boolean bl) {
        this.isHmiReadyBeenAckowledged = bl;
    }

    void writeDefaultDisplayBrightnessToDsi(int n) {
        if (this.isHmiReadyBeenAckowledged) {
            this.writeDefaultDisplayBrightnessToDsiInternal(n);
        } else {
            if (this.isTraceEnabled()) {
                this.trace(new StringBuffer().append("Set pending Display Brightness to: ").append(n).toString());
            }
            this.isDisplayBrightnessPending = true;
            this.pendingDisplayBrightnessPercentage = n;
        }
    }

    void writeDisplayableComponentBrightnessToDsi(DisplayableComponentData displayableComponentData) {
        if (this.dsiDisplayManagement == null) {
            this.error("Can not write displayable component brightness. DSIDisplayMangement is missing.");
            return;
        }
        if (this.isTraceEnabled()) {
            this.trace(new StringBuffer().append("writeDisplayableBrightnessToDSI displayableComponentId ").append(displayableComponentData.getDisplayableComponentId()).append(" brightness ").append(displayableComponentData.getCachedBrightness()).toString());
        }
        int n = displayableComponentData.isVideoOrTvDisplayableComponent() ? displayableComponentData.getCachedBrightness() : this.aslSystemApi.mapValue(displayableComponentData.getCachedBrightness(), 0, 100, -128, 127);
        this.dsiDisplayManagement.setBrightness(displayableComponentData.getDisplayableComponentId(), n);
        this.dsiDisplayManagement.getBrightness(displayableComponentData.getDisplayableComponentId());
        this.displayTimer.triggerDisplayResponseTimer();
    }

    void writePendingDisplayBrightnessToDsi() {
        if (this.isDisplayBrightnessPending) {
            if (this.dsiDisplayManagement == null) {
                this.error("Can not flush display brightness. DSIDisplayMangement is missing.");
                return;
            }
            if (!this.isHmiReadyBeenAckowledged) {
                this.error("Can not flush display brightness. HMI is not ready.");
                return;
            }
            this.isDisplayBrightnessPending = false;
            this.writeDefaultDisplayBrightnessToDsiInternal(this.pendingDisplayBrightnessPercentage);
        }
    }

    private void checkConstructorArtguments(PersistableDisplayManagementData persistableDisplayManagementData, DisplayManagementServices displayManagementServices) {
        if (persistableDisplayManagementData == null) {
            throw new IllegalArgumentException("PersistableDisplayManagementData must not be null.");
        }
        if (displayManagementServices == null) {
            throw new IllegalArgumentException("Services must not be null.");
        }
    }

    private void error(String string) {
        this.logger.error(4096, new StringBuffer().append("[DisplayBrightness] ").append(string).toString());
    }

    private boolean isTraceEnabled() {
        return this.logger.isTraceEnabled(4096);
    }

    private void trace(String string) {
        this.logger.trace(4096, new StringBuffer().append("[DisplayBrightness] ").append(string).toString());
    }

    private void writeDefaultDisplayBrightnessToDsiInternal(int n) {
        if (this.dsiDisplayManagement == null) {
            this.error("Can not write display brightness. DSIDisplayMangement is missing.");
            return;
        }
        this.dsiDisplayManagement.setDisplayBrightness(0, n);
        this.dsiDisplayManagement.getDisplayBrightness(0);
    }
}

