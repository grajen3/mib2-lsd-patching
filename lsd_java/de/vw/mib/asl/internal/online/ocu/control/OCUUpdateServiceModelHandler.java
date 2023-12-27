/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.ocu.control;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.online.ocu.common.OCUUpdateService;
import de.vw.mib.log4mib.LogMessage;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.online.transformer.OnlineOnlineOCUUpdateCollector;
import org.dsi.ifc.global.ResourceLocator;

public class OCUUpdateServiceModelHandler {
    public void setPropertyBoolean(int n, boolean bl) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(n, bl);
    }

    public void setPropertyInteger(int n, int n2) {
        ServiceManager.aslPropertyManager.valueChangedInteger(n, n2);
    }

    public void setPropertyLong(int n, long l) {
        ServiceManager.aslPropertyManager.valueChangedLong(n, l);
    }

    public void setPropertyString(int n, String string) {
        ServiceManager.aslPropertyManager.valueChangedString(n, string);
    }

    public void setPropertyResourceLocator(int n, ResourceLocator resourceLocator) {
        ServiceManager.aslPropertyManager.valueChangedResourceLocator(n, resourceLocator);
    }

    public void sendSystemEvent(int n) {
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(n);
    }

    public void sendOCUUpdateInfo(OCUUpdateService oCUUpdateService) {
        if (oCUUpdateService != null) {
            Object[] objectArray = new OnlineOnlineOCUUpdateCollector[]{new OnlineOnlineOCUUpdateCollector()};
            objectArray[0].online_online_ocu_update_name = oCUUpdateService.getUpdateID();
            objectArray[0].online_online_ocu_update_customer_name = oCUUpdateService.getUserName();
            objectArray[0].online_online_ocu_update_vin = oCUUpdateService.getVINNumber();
            objectArray[0].online_online_ocu_update_disclaimer_text = oCUUpdateService.getDescription();
            objectArray[0].online_online_ocu_update_duration = Integer.toString(oCUUpdateService.getEstimatedDuration());
            ListManager.getGenericASLList(1778193152).updateList(objectArray);
        }
    }

    public void sendOCUUpdateServiceState(int n) {
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger2.trace(16384);
            logMessage.append("OCUUpdateServiceModelHandler").append(new StringBuffer().append(".sendOCUUpdateServiceState(State = ").append(n).append(")").toString()).log();
        }
        this.setPropertyInteger(1811747584, n);
    }

    public void hidePopupType(int n) {
        switch (n) {
            case 1: {
                this.sendSystemEvent(1660752640);
                break;
            }
            case 2: {
                this.sendSystemEvent(1677529856);
                break;
            }
            case 3: {
                this.sendSystemEvent(1694307072);
                break;
            }
            case 4: {
                this.sendSystemEvent(1711084288);
                break;
            }
        }
    }
}

