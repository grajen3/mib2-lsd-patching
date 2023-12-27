/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.carlife.common;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.carlife.CarlifeHSMTarget;
import de.vw.mib.asl.internal.carlife.common.CarLifeGlobalProperties;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.popup.PopupInformationHandler;

public class PopupHandler
implements PopupInformationHandler {
    private final String classname;
    private final CarlifeHSMTarget target;
    private final CarLifeGlobalProperties properties;

    public PopupHandler(CarlifeHSMTarget carlifeHSMTarget, CarLifeGlobalProperties carLifeGlobalProperties) {
        this.classname = "PopupInformationHandler";
        this.target = carlifeHSMTarget;
        this.properties = carLifeGlobalProperties;
    }

    @Override
    public void onPopupInformationChanged(int n) {
        if (this.target.isTraceEnabled()) {
            LogMessage logMessage = this.target.trace();
            logMessage.append("PopupInformationHandler").append(".onPopupInformationChanged(popupInfo=").append(n).append(")").log();
        }
        this.properties.setPopupOpen(n == 2);
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
        ServiceManager.aslPropertyManager.valueChangedBoolean(1298607104, bl);
        if (this.target.isTraceEnabled()) {
            logMessage = this.target.trace();
            logMessage.append("PopupInformationHandler").append(new StringBuffer().append(".checkPopupState: isConnected: ").append(this.properties.isConnected()).append(", isDimmed: ").append(bl).append(", properties.isCanvasDimmed()").append(this.properties.isCanvasDimmed()).append(", properties.getCurrentScreenSource(): ").append(this.properties.getCurrentScreenOwner()).append(", properties.isCanvasVisible(): ").append(this.properties.isCanvasVisible()).toString()).log();
        }
        this.properties.setCanvasDimed(bl);
    }
}

