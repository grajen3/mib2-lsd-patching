/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mostkombi.navinfo.functions;

import de.vw.mib.asl.internal.mostkombi.navinfo.api.navi.asl.NavInfoDelegate;
import de.vw.mib.asl.internal.mostkombi.navinfo.api.navi.asl.NavInfoService;
import de.vw.mib.asl.internal.mostkombi.navinfo.functions.NavInfoFunction;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.komonavinfo.DSIKOMONavInfo;

public class RouteGuidanceMode
extends NavInfoFunction
implements NavInfoDelegate {
    private DSIKOMONavInfo _komoNavInfo;
    private DSIListener _komoNavInfoServiceResponder;
    private static final int[] NAV_INFO_SERVICES = new int[]{39};
    static /* synthetic */ Class class$de$vw$mib$asl$internal$mostkombi$navinfo$api$navi$asl$NavInfoService;
    static /* synthetic */ Class class$org$dsi$ifc$komonavinfo$DSIKOMONavInfoListener;
    static /* synthetic */ Class class$org$dsi$ifc$komonavinfo$DSIKOMONavInfo;

    @Override
    public void initialize() {
        this.getCategoryDelegate().registerServiceListener(this, class$de$vw$mib$asl$internal$mostkombi$navinfo$api$navi$asl$NavInfoService == null ? (class$de$vw$mib$asl$internal$mostkombi$navinfo$api$navi$asl$NavInfoService = RouteGuidanceMode.class$("de.vw.mib.asl.internal.mostkombi.navinfo.api.navi.asl.NavInfoService")) : class$de$vw$mib$asl$internal$mostkombi$navinfo$api$navi$asl$NavInfoService, NAV_INFO_SERVICES);
    }

    @Override
    public void uninitialize() {
        this.getCategoryDelegate().removeServiceListener(this, class$de$vw$mib$asl$internal$mostkombi$navinfo$api$navi$asl$NavInfoService == null ? (class$de$vw$mib$asl$internal$mostkombi$navinfo$api$navi$asl$NavInfoService = RouteGuidanceMode.class$("de.vw.mib.asl.internal.mostkombi.navinfo.api.navi.asl.NavInfoService")) : class$de$vw$mib$asl$internal$mostkombi$navinfo$api$navi$asl$NavInfoService, NAV_INFO_SERVICES);
        this.getCategoryDelegate().removeDsiServiceResponder(this, class$org$dsi$ifc$komonavinfo$DSIKOMONavInfoListener == null ? (class$org$dsi$ifc$komonavinfo$DSIKOMONavInfoListener = RouteGuidanceMode.class$("org.dsi.ifc.komonavinfo.DSIKOMONavInfoListener")) : class$org$dsi$ifc$komonavinfo$DSIKOMONavInfoListener, this.getKomoNavInfoResponder(), null, (DSIBase)this._komoNavInfo);
    }

    private DSIKOMONavInfo getKomoNavInfo() {
        if (this._komoNavInfo == null) {
            this._komoNavInfo = (DSIKOMONavInfo)this.getCategoryDelegate().getDsiService(this, class$org$dsi$ifc$komonavinfo$DSIKOMONavInfo == null ? (class$org$dsi$ifc$komonavinfo$DSIKOMONavInfo = RouteGuidanceMode.class$("org.dsi.ifc.komonavinfo.DSIKOMONavInfo")) : class$org$dsi$ifc$komonavinfo$DSIKOMONavInfo);
            this._komoNavInfoServiceResponder = this.getCategoryDelegate().addDsiServiceResponder(this, (DSIBase)this._komoNavInfo, class$org$dsi$ifc$komonavinfo$DSIKOMONavInfoListener == null ? (class$org$dsi$ifc$komonavinfo$DSIKOMONavInfoListener = RouteGuidanceMode.class$("org.dsi.ifc.komonavinfo.DSIKOMONavInfoListener")) : class$org$dsi$ifc$komonavinfo$DSIKOMONavInfoListener, null);
        }
        return this._komoNavInfo;
    }

    private DSIListener getKomoNavInfoResponder() {
        return this._komoNavInfoServiceResponder;
    }

    private NavInfoService getNavInfoService() {
        return (NavInfoService)this.getCategoryDelegate().getService(this, class$de$vw$mib$asl$internal$mostkombi$navinfo$api$navi$asl$NavInfoService == null ? (class$de$vw$mib$asl$internal$mostkombi$navinfo$api$navi$asl$NavInfoService = RouteGuidanceMode.class$("de.vw.mib.asl.internal.mostkombi.navinfo.api.navi.asl.NavInfoService")) : class$de$vw$mib$asl$internal$mostkombi$navinfo$api$navi$asl$NavInfoService);
    }

    @Override
    public int getIdentifier() {
        return 1874597376;
    }

    @Override
    public void executeSequence() {
        this.getKomoNavInfo().setRgSelect(this.getNavInfoService().getRouteGuidanceMode());
    }

    @Override
    public void updateNavInfo(NavInfoService navInfoService, int n, Object object) {
        this.getKomoNavInfo().setRgSelect(navInfoService.getRouteGuidanceMode());
    }

    public void dsiKOMONavInfoSetRgSelectResult(int n) {
        if (this.isPartOfOtherSequence()) {
            this.getSequenceDelegate().sequenceDone(this);
        }
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

