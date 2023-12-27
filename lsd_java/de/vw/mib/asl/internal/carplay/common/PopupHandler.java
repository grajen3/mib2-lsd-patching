/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.carplay.common;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.carplay.common.CarPlayGlobalProperies;
import de.vw.mib.asl.internal.carplay.common.CarPlayModeHandling;
import de.vw.mib.asl.internal.carplay.target.HsmTarget;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.popup.PopupInformationHandler;

public class PopupHandler
implements PopupInformationHandler {
    private final String classname;
    private final HsmTarget target;
    private final CarPlayGlobalProperies properties;
    private final CarPlayModeHandling modehandling;
    private boolean lastReportedPopupState;

    public PopupHandler(HsmTarget hsmTarget, CarPlayGlobalProperies carPlayGlobalProperies, CarPlayModeHandling carPlayModeHandling) {
        this.classname = "PopupInformationHandler";
        this.target = hsmTarget;
        this.properties = carPlayGlobalProperies;
        this.modehandling = carPlayModeHandling;
        this.lastReportedPopupState = carPlayGlobalProperies.isPopupOpen();
    }

    @Override
    public void onPopupInformationChanged(int n) {
        if (this.target.isTraceEnabled()) {
            LogMessage logMessage = this.target.trace();
            logMessage.append("PopupInformationHandler").append(".onPopupInformationChanged(popupInfo=").append(n).append(")").log();
        }
        this.lastReportedPopupState = n == 2;
        this.target.retriggerOrStartTimer(-1350172416, (long)0, false);
    }

    public void popupTimerElapsed() {
        this.properties.setPopupOpen(this.lastReportedPopupState);
        this.checkPopupState();
    }

    public void checkPopupState() {
        LogMessage logMessage;
        boolean bl;
        boolean bl2 = bl = this.properties.isPopupOpen() || this.properties.isSdsOpen();
        if (this.target.isTraceEnabled()) {
            logMessage = this.target.trace();
            logMessage.append("PopupInformationHandler").append(new StringBuffer().append(".checkPopupState(popupOpen=").append(this.properties.isPopupOpen()).append(", SDSopen=").append(this.properties.isSdsOpen()).append(" => isDimmed=").append(bl).toString()).log();
        }
        ServiceManager.aslPropertyManager.valueChangedBoolean(929508352, bl);
        if (this.target.isTraceEnabled()) {
            logMessage = this.target.trace();
            logMessage.append("PopupInformationHandler").append(new StringBuffer().append(".checkPopupState: isConnected: ").append(this.properties.isConnected()).append(", isDimed: ").append(bl).append(", properties.isCanvasDimed()").append(this.properties.isCanvasDimed()).append(", properties.getCurrentScreenSource(): ").append(this.properties.getCurrentScreenSource()).append(", properties.isCanvasVisible(): ").append(this.properties.isCanvasVisible()).append(", properties.isVideoBorrowState(): ").append(this.properties.isVideoBorrowState()).toString()).log();
        }
        if (this.properties.isConnected() && bl != this.properties.isCanvasDimed()) {
            if (bl) {
                this.modehandling.borrowScreen("Borrow Screen: Popup was opended");
            } else if (!bl && this.properties.isCanvasVisible() && this.properties.isVideoBorrowState()) {
                this.modehandling.unborrowScreen("Unborrow Screen: Popup was closed");
            }
        }
        this.properties.setCanvasDimed(bl);
    }
}

