/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mostkombi.navinfo.functions;

import de.vw.mib.asl.internal.mostkombi.navinfo.api.navi.asl.NavInfoDelegate;
import de.vw.mib.asl.internal.mostkombi.navinfo.api.navi.asl.NavInfoEstimatedTimeOfArrival;
import de.vw.mib.asl.internal.mostkombi.navinfo.api.navi.asl.NavInfoService;
import de.vw.mib.asl.internal.mostkombi.navinfo.functions.NavInfoFunction;
import org.dsi.ifc.komonavinfo.DSIKOMONavInfo;

public class EstimatedTimeArrival
extends NavInfoFunction
implements NavInfoDelegate {
    private DSIKOMONavInfo _komoNavInfo;
    private static final int[] NAV_INFO_SERVICES = new int[]{750};
    static /* synthetic */ Class class$de$vw$mib$asl$internal$mostkombi$navinfo$api$navi$asl$NavInfoService;
    static /* synthetic */ Class class$org$dsi$ifc$komonavinfo$DSIKOMONavInfo;

    @Override
    public void initialize() {
        this.getCategoryDelegate().registerServiceListener(this, class$de$vw$mib$asl$internal$mostkombi$navinfo$api$navi$asl$NavInfoService == null ? (class$de$vw$mib$asl$internal$mostkombi$navinfo$api$navi$asl$NavInfoService = EstimatedTimeArrival.class$("de.vw.mib.asl.internal.mostkombi.navinfo.api.navi.asl.NavInfoService")) : class$de$vw$mib$asl$internal$mostkombi$navinfo$api$navi$asl$NavInfoService, NAV_INFO_SERVICES);
    }

    @Override
    public void uninitialize() {
        this.getCategoryDelegate().removeServiceListener(this, class$de$vw$mib$asl$internal$mostkombi$navinfo$api$navi$asl$NavInfoService == null ? (class$de$vw$mib$asl$internal$mostkombi$navinfo$api$navi$asl$NavInfoService = EstimatedTimeArrival.class$("de.vw.mib.asl.internal.mostkombi.navinfo.api.navi.asl.NavInfoService")) : class$de$vw$mib$asl$internal$mostkombi$navinfo$api$navi$asl$NavInfoService, NAV_INFO_SERVICES);
    }

    private DSIKOMONavInfo getKomboNavInfo() {
        if (this._komoNavInfo == null) {
            this._komoNavInfo = (DSIKOMONavInfo)this.getCategoryDelegate().getDsiService(this, class$org$dsi$ifc$komonavinfo$DSIKOMONavInfo == null ? (class$org$dsi$ifc$komonavinfo$DSIKOMONavInfo = EstimatedTimeArrival.class$("org.dsi.ifc.komonavinfo.DSIKOMONavInfo")) : class$org$dsi$ifc$komonavinfo$DSIKOMONavInfo);
        }
        return this._komoNavInfo;
    }

    @Override
    public int getIdentifier() {
        return 1857820160;
    }

    @Override
    public void executeSequence() {
    }

    @Override
    public void updateNavInfo(NavInfoService navInfoService, int n, Object object) {
        NavInfoEstimatedTimeOfArrival navInfoEstimatedTimeOfArrival = navInfoService.getEstimatedTimeArrival();
        this.getKomboNavInfo().setETA(navInfoEstimatedTimeOfArrival.getEstimatedTimeOfArrivalTimeFormat(), (short)navInfoEstimatedTimeOfArrival.getEstimatedTimeOfArrivalDay(), (short)navInfoEstimatedTimeOfArrival.getEstimatedTimeOfArrivalHour(), (short)navInfoEstimatedTimeOfArrival.getEstimatedTimeOfArrivalMin(), navInfoEstimatedTimeOfArrival.getEstimatedTimeOfArrivalValidity(), false);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

