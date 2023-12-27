/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ugdo;

import de.vw.mib.asl.api.car.logger.CarLogger;
import de.vw.mib.asl.internal.ugdo.ButtonListContext;
import de.vw.mib.asl.internal.ugdo.ButtonListController;
import de.vw.mib.asl.internal.ugdo.HsmTargetUGDO;
import de.vw.mib.genericevents.EventGeneric;
import org.dsi.ifc.carcomfort.DSICarComfort;
import org.dsi.ifc.carcomfort.UGDOButtonListRA0;
import org.dsi.ifc.carcomfort.UGDOButtonListRA1;
import org.dsi.ifc.carcomfort.UGDOButtonListRA2;
import org.dsi.ifc.carcomfort.UGDOButtonListRA3;
import org.dsi.ifc.carcomfort.UGDOButtonListRA4;
import org.dsi.ifc.carcomfort.UGDOButtonListRA5;
import org.dsi.ifc.carcomfort.UGDOButtonListUpdateInfo;
import org.dsi.ifc.carcomfort.UGDOViewOptions;

public class UGDOMainController
implements ButtonListContext {
    private UGDOViewOptions currentViewOptions;
    private HsmTargetUGDO ugdoTarget;
    private ButtonListController buttonListController;

    public UGDOMainController(HsmTargetUGDO hsmTargetUGDO) {
        this.ugdoTarget = hsmTargetUGDO;
    }

    public void handle(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 1076441842: {
                break;
            }
            case 1076441831: {
                break;
            }
            case 13701: {
                break;
            }
            case 1076441832: {
                break;
            }
            case 1076441833: {
                break;
            }
            case 1076441826: {
                break;
            }
            case 1076441827: {
                break;
            }
            case 1076441828: {
                break;
            }
            case 1076441834: {
                break;
            }
            case 1076441846: {
                break;
            }
            case 1076441829: {
                break;
            }
        }
    }

    @Override
    public DSICarComfort getCarComfort() {
        return this.ugdoTarget.dsiCarComfort;
    }

    @Override
    public void buttonListUpdate() {
    }

    void updateUGDOButtonListUpdateInfo(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, int n) {
    }

    void updateUGDOButtonListTotalNumberOfElements(int n, int n2) {
    }

    void dsiCarComfortResponseUGDOButtonListRA0(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA0[] uGDOButtonListRA0Array) {
    }

    void dsiCarComfortResponseUGDOButtonListRA1(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA1[] uGDOButtonListRA1Array) {
    }

    void dsiCarComfortResponseUGDOButtonListRA2(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA2[] uGDOButtonListRA2Array) {
    }

    void dsiCarComfortResponseUGDOButtonListRA3(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA3[] uGDOButtonListRA3Array) {
    }

    void dsiCarComfortResponseUGDOButtonListRA4(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA4[] uGDOButtonListRA4Array) {
    }

    void dsiCarComfortResponseUGDOButtonListRA5(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA5[] uGDOButtonListRA5Array) {
    }

    void dsiCarComfortResponseUGDOButtonListRAF(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, int[] nArray) {
    }

    @Override
    public CarLogger getCarLogger() {
        return this.ugdoTarget;
    }

    public ButtonListController getButtonListController() {
        if (this.buttonListController == null) {
            this.buttonListController = new ButtonListController(this);
        }
        return this.buttonListController;
    }
}

