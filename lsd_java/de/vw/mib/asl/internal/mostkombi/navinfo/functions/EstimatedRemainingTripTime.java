/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mostkombi.navinfo.functions;

import de.vw.mib.asl.internal.mostkombi.navinfo.api.navi.asl.NavInfoDelegate;
import de.vw.mib.asl.internal.mostkombi.navinfo.api.navi.asl.NavInfoEstimatedRemainingTripTime;
import de.vw.mib.asl.internal.mostkombi.navinfo.api.navi.asl.NavInfoService;
import de.vw.mib.asl.internal.mostkombi.navinfo.functions.NavInfoFunction;
import org.dsi.ifc.komonavinfo.DSIKOMONavInfo;

public class EstimatedRemainingTripTime
extends NavInfoFunction
implements NavInfoDelegate {
    private DSIKOMONavInfo _komoNavInfo;
    private static final int[] NAV_INFO_SERVICES = new int[]{753930240};
    static /* synthetic */ Class class$de$vw$mib$asl$internal$mostkombi$navinfo$api$navi$asl$NavInfoService;
    static /* synthetic */ Class class$org$dsi$ifc$komonavinfo$DSIKOMONavInfo;

    @Override
    public void initialize() {
        this.getCategoryDelegate().registerServiceListener(this, class$de$vw$mib$asl$internal$mostkombi$navinfo$api$navi$asl$NavInfoService == null ? (class$de$vw$mib$asl$internal$mostkombi$navinfo$api$navi$asl$NavInfoService = EstimatedRemainingTripTime.class$("de.vw.mib.asl.internal.mostkombi.navinfo.api.navi.asl.NavInfoService")) : class$de$vw$mib$asl$internal$mostkombi$navinfo$api$navi$asl$NavInfoService, NAV_INFO_SERVICES);
    }

    @Override
    public void uninitialize() {
        this.getCategoryDelegate().removeServiceListener(this, class$de$vw$mib$asl$internal$mostkombi$navinfo$api$navi$asl$NavInfoService == null ? (class$de$vw$mib$asl$internal$mostkombi$navinfo$api$navi$asl$NavInfoService = EstimatedRemainingTripTime.class$("de.vw.mib.asl.internal.mostkombi.navinfo.api.navi.asl.NavInfoService")) : class$de$vw$mib$asl$internal$mostkombi$navinfo$api$navi$asl$NavInfoService, NAV_INFO_SERVICES);
    }

    private DSIKOMONavInfo getKomboNavInfo() {
        if (this._komoNavInfo == null) {
            this._komoNavInfo = (DSIKOMONavInfo)this.getCategoryDelegate().getDsiService(this, class$org$dsi$ifc$komonavinfo$DSIKOMONavInfo == null ? (class$org$dsi$ifc$komonavinfo$DSIKOMONavInfo = EstimatedRemainingTripTime.class$("org.dsi.ifc.komonavinfo.DSIKOMONavInfo")) : class$org$dsi$ifc$komonavinfo$DSIKOMONavInfo);
        }
        return this._komoNavInfo;
    }

    @Override
    public int getIdentifier() {
        return 1841042944;
    }

    @Override
    public void executeSequence() {
    }

    @Override
    public void updateNavInfo(NavInfoService navInfoService, int n, Object object) {
        NavInfoEstimatedRemainingTripTime navInfoEstimatedRemainingTripTime = navInfoService.getEstimatedRemainingTripTime();
        this.getKomboNavInfo().setRTT((short)navInfoEstimatedRemainingTripTime.getEstimatedRemainingTripTimeHour(), (short)navInfoEstimatedRemainingTripTime.getEstimatedRemainingTripTimeMin(), navInfoEstimatedRemainingTripTime.getEstimatedRemainingTripTimeValidity());
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

