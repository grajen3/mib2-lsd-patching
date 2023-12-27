/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navmaptile.api.impl;

import de.vw.mib.asl.api.navmaptile.ASLNavMapTileAPI;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navmaptile.NavMapTileTargetHSM;
import de.vw.mib.asl.internal.navmaptile.api.impl.NavMapTilePreStartupTarget;
import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.genericevents.GenericEvents;
import java.util.ArrayList;

public class ASLNavMapTileAPIImpl
implements ASLNavMapTileAPI {
    private ArrayList myTargetList = new ArrayList();

    public void addTarget(AbstractTarget abstractTarget) {
        this.myTargetList.add(abstractTarget);
    }

    public void createTargets() {
        GenericEvents genericEvents = ServiceManager.eventMain;
        String string = "hsmtask";
        this.addTarget(new NavMapTileTargetHSM(genericEvents, 877665024, string));
    }

    public void powerOnTargets() {
        for (int i2 = 0; i2 < this.myTargetList.size(); ++i2) {
            AbstractTarget abstractTarget = (AbstractTarget)this.myTargetList.get(i2);
            abstractTarget.triggerIt(abstractTarget.getTargetId(), 106);
        }
    }

    static {
        try {
            new NavMapTilePreStartupTarget(ServiceManager.eventMain, 860887808, "hsmtask");
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }
}

