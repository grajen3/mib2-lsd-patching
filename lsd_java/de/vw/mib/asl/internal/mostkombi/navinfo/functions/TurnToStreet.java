/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mostkombi.navinfo.functions;

import de.vw.mib.asl.internal.mostkombi.navinfo.api.navi.asl.NavInfoDelegate;
import de.vw.mib.asl.internal.mostkombi.navinfo.api.navi.asl.NavInfoService;
import de.vw.mib.asl.internal.mostkombi.navinfo.api.navi.asl.NavInfoTurnToInfo;
import de.vw.mib.asl.internal.mostkombi.navinfo.functions.NavInfoFunction;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.komonavinfo.DSIKOMONavInfo;

public class TurnToStreet
extends NavInfoFunction
implements NavInfoDelegate {
    private DSIKOMONavInfo _komoNavInfo;
    private DSIListener _komoNavInfoServiceResponder;
    private static final int[] NAV_INFO_SERVICES = new int[]{20};
    static /* synthetic */ Class class$de$vw$mib$asl$internal$mostkombi$navinfo$api$navi$asl$NavInfoService;
    static /* synthetic */ Class class$org$dsi$ifc$komonavinfo$DSIKOMONavInfoListener;
    static /* synthetic */ Class class$org$dsi$ifc$komonavinfo$DSIKOMONavInfo;

    @Override
    public void initialize() {
        this.getCategoryDelegate().registerServiceListener(this, class$de$vw$mib$asl$internal$mostkombi$navinfo$api$navi$asl$NavInfoService == null ? (class$de$vw$mib$asl$internal$mostkombi$navinfo$api$navi$asl$NavInfoService = TurnToStreet.class$("de.vw.mib.asl.internal.mostkombi.navinfo.api.navi.asl.NavInfoService")) : class$de$vw$mib$asl$internal$mostkombi$navinfo$api$navi$asl$NavInfoService, NAV_INFO_SERVICES);
    }

    @Override
    public void uninitialize() {
        this.getCategoryDelegate().removeServiceListener(this, class$de$vw$mib$asl$internal$mostkombi$navinfo$api$navi$asl$NavInfoService == null ? (class$de$vw$mib$asl$internal$mostkombi$navinfo$api$navi$asl$NavInfoService = TurnToStreet.class$("de.vw.mib.asl.internal.mostkombi.navinfo.api.navi.asl.NavInfoService")) : class$de$vw$mib$asl$internal$mostkombi$navinfo$api$navi$asl$NavInfoService, NAV_INFO_SERVICES);
        this.getCategoryDelegate().removeDsiServiceResponder(this, class$org$dsi$ifc$komonavinfo$DSIKOMONavInfoListener == null ? (class$org$dsi$ifc$komonavinfo$DSIKOMONavInfoListener = TurnToStreet.class$("org.dsi.ifc.komonavinfo.DSIKOMONavInfoListener")) : class$org$dsi$ifc$komonavinfo$DSIKOMONavInfoListener, this.getKomoNavInfoResponder(), null, (DSIBase)this._komoNavInfo);
    }

    private DSIKOMONavInfo getKomboNavInfo() {
        if (this._komoNavInfo == null) {
            this._komoNavInfo = (DSIKOMONavInfo)this.getCategoryDelegate().getDsiService(this, class$org$dsi$ifc$komonavinfo$DSIKOMONavInfo == null ? (class$org$dsi$ifc$komonavinfo$DSIKOMONavInfo = TurnToStreet.class$("org.dsi.ifc.komonavinfo.DSIKOMONavInfo")) : class$org$dsi$ifc$komonavinfo$DSIKOMONavInfo);
            this._komoNavInfoServiceResponder = this.getCategoryDelegate().addDsiServiceResponder(this, (DSIBase)this._komoNavInfo, class$org$dsi$ifc$komonavinfo$DSIKOMONavInfoListener == null ? (class$org$dsi$ifc$komonavinfo$DSIKOMONavInfoListener = TurnToStreet.class$("org.dsi.ifc.komonavinfo.DSIKOMONavInfoListener")) : class$org$dsi$ifc$komonavinfo$DSIKOMONavInfoListener, null);
        }
        return this._komoNavInfo;
    }

    private DSIListener getKomoNavInfoResponder() {
        return this._komoNavInfoServiceResponder;
    }

    @Override
    public int getIdentifier() {
        return 1924929024;
    }

    @Override
    public void executeSequence() {
    }

    @Override
    public void updateNavInfo(NavInfoService navInfoService, int n, Object object) {
        NavInfoTurnToInfo navInfoTurnToInfo = navInfoService.getTurnToInfo();
        this.getKomboNavInfo().setTurnToStreet(navInfoTurnToInfo.getTurnToInfoStreet(), navInfoTurnToInfo.getTurnToInfoSignPost());
    }

    public void dsiKOMONavInfoSetTurnToStreetResult(int n) {
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

