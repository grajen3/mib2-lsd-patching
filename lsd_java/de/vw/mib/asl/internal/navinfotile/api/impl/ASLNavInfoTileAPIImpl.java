/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navinfotile.api.impl;

import de.vw.mib.asl.api.navinfotile.ASLNavInfoTileAPI;
import de.vw.mib.asl.api.navinfotile.ASLNavInfoTileGuidanceListener;
import de.vw.mib.asl.api.navinfotile.ASLNavInfoTilePersistenceListener;
import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navinfotile.NavInfoTileDatapool;
import de.vw.mib.asl.internal.navinfotile.NavInfoTileTarget;
import de.vw.mib.asl.internal.navinfotile.maneuverview.NavInfoTileManeuverViewTarget;
import de.vw.mib.asl.internal.navinfotile.overlay.NavInfoTileOverlayTarget;
import de.vw.mib.asl.internal.navinfotile.pnav.NavInfoTilePnavTarget;
import de.vw.mib.asl.internal.navinfotile.tenpluszero.NavInfoTile10Plus0Target;
import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.genericevents.GenericEvents;
import java.util.ArrayList;
import java.util.Observer;

public class ASLNavInfoTileAPIImpl
implements ASLNavInfoTileAPI {
    private final ArrayList myTargetList = new ArrayList();

    public void addTarget(AbstractTarget abstractTarget) {
        this.myTargetList.add(abstractTarget);
    }

    public void createTargets() {
        AbstractASLTarget abstractASLTarget;
        GenericEvents genericEvents = ServiceManager.eventMain;
        String string = "hsmtask";
        NavInfoTileTarget navInfoTileTarget = new NavInfoTileTarget(genericEvents, 1419647744, "hsmtask");
        this.addTarget(navInfoTileTarget);
        if (this.isTenPlusZero()) {
            abstractASLTarget = new NavInfoTile10Plus0Target(genericEvents, 1436424960, "hsmtask");
            navInfoTileTarget.registerAsObserver((Observer)((Object)abstractASLTarget));
            this.addTarget(abstractASLTarget);
        } else if (this.isManeuverView()) {
            abstractASLTarget = new NavInfoTileManeuverViewTarget(genericEvents, 1453202176, "hsmtask");
            navInfoTileTarget.registerAsObserver((Observer)((Object)abstractASLTarget));
            this.addTarget(abstractASLTarget);
        }
        abstractASLTarget = new NavInfoTilePnavTarget(genericEvents, 1486756608, "hsmtask");
        navInfoTileTarget.registerAsObserver((Observer)((Object)abstractASLTarget));
        this.addTarget(abstractASLTarget);
        NavInfoTileOverlayTarget navInfoTileOverlayTarget = new NavInfoTileOverlayTarget(genericEvents, 1469979392, "hsmtask");
        navInfoTileTarget.registerAsObserver(navInfoTileOverlayTarget);
        this.addTarget(navInfoTileOverlayTarget);
    }

    public void powerOnTargets() {
        for (int i2 = 0; i2 < this.myTargetList.size(); ++i2) {
            AbstractTarget abstractTarget = (AbstractTarget)this.myTargetList.get(i2);
            abstractTarget.triggerIt(abstractTarget.getTargetId(), 106);
        }
    }

    private boolean isTenPlusZero() {
        return ServiceManager.configManagerDiag.isFeatureFlagSet(162);
    }

    private boolean isManeuverView() {
        return ServiceManager.configManagerDiag.isFeatureFlagSet(161);
    }

    @Override
    public void setPersistedPage(int n) {
        NavInfoTileDatapool.getInstance().setPersistedPage(n);
    }

    @Override
    public int getPersistedPage() {
        return NavInfoTileDatapool.getInstance().getPersistedPage();
    }

    @Override
    public void registerPersistenceListener(ASLNavInfoTilePersistenceListener aSLNavInfoTilePersistenceListener) {
        NavInfoTileDatapool.getInstance().addPersistenceListener(aSLNavInfoTilePersistenceListener);
    }

    @Override
    public void registerGuidanceListener(ASLNavInfoTileGuidanceListener aSLNavInfoTileGuidanceListener) {
        NavInfoTileDatapool.getInstance().addGuidanceListener(aSLNavInfoTileGuidanceListener);
    }
}

