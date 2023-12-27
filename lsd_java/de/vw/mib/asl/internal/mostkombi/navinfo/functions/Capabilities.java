/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mostkombi.navinfo.functions;

import de.vw.mib.asl.internal.mostkombi.common.api.adaption.asl.AdaptationDelegate;
import de.vw.mib.asl.internal.mostkombi.common.api.adaption.asl.AdaptationService;
import de.vw.mib.asl.internal.mostkombi.navinfo.api.navi.asl.NavInfoDelegate;
import de.vw.mib.asl.internal.mostkombi.navinfo.api.navi.asl.NavInfoService;
import de.vw.mib.asl.internal.mostkombi.navinfo.functions.NavInfoFunction;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.komonavinfo.DSIKOMONavInfo;

public class Capabilities
extends NavInfoFunction
implements NavInfoDelegate,
AdaptationDelegate {
    private DSIKOMONavInfo _komoNavInfo;
    private DSIListener _komoNavInfoServiceResponder;
    private AdaptationService _adaptationService;
    private static final int[] ADAPTATION_SERVICES = AdaptationDelegate.ADAPTATION_PROPERTIES;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$mostkombi$common$api$adaption$asl$AdaptationService;
    static /* synthetic */ Class class$org$dsi$ifc$komonavinfo$DSIKOMONavInfoListener;
    static /* synthetic */ Class class$org$dsi$ifc$komonavinfo$DSIKOMONavInfo;

    @Override
    public void initialize() {
        this.executeSequence();
    }

    @Override
    public void uninitialize() {
        this.getCategoryDelegate().removeServiceListener(this, class$de$vw$mib$asl$internal$mostkombi$common$api$adaption$asl$AdaptationService == null ? (class$de$vw$mib$asl$internal$mostkombi$common$api$adaption$asl$AdaptationService = Capabilities.class$("de.vw.mib.asl.internal.mostkombi.common.api.adaption.asl.AdaptationService")) : class$de$vw$mib$asl$internal$mostkombi$common$api$adaption$asl$AdaptationService, ADAPTATION_SERVICES);
        this.getCategoryDelegate().removeDsiServiceResponder(this, class$org$dsi$ifc$komonavinfo$DSIKOMONavInfoListener == null ? (class$org$dsi$ifc$komonavinfo$DSIKOMONavInfoListener = Capabilities.class$("org.dsi.ifc.komonavinfo.DSIKOMONavInfoListener")) : class$org$dsi$ifc$komonavinfo$DSIKOMONavInfoListener, this.getKomoNavInfoResponder(), null, (DSIBase)this._komoNavInfo);
    }

    private DSIKOMONavInfo getKomboNavInfo() {
        if (this._komoNavInfo == null) {
            this._komoNavInfo = (DSIKOMONavInfo)this.getCategoryDelegate().getDsiService(this, class$org$dsi$ifc$komonavinfo$DSIKOMONavInfo == null ? (class$org$dsi$ifc$komonavinfo$DSIKOMONavInfo = Capabilities.class$("org.dsi.ifc.komonavinfo.DSIKOMONavInfo")) : class$org$dsi$ifc$komonavinfo$DSIKOMONavInfo);
            this._komoNavInfoServiceResponder = this.getCategoryDelegate().addDsiServiceResponder(this, (DSIBase)this._komoNavInfo, class$org$dsi$ifc$komonavinfo$DSIKOMONavInfoListener == null ? (class$org$dsi$ifc$komonavinfo$DSIKOMONavInfoListener = Capabilities.class$("org.dsi.ifc.komonavinfo.DSIKOMONavInfoListener")) : class$org$dsi$ifc$komonavinfo$DSIKOMONavInfoListener, null);
        }
        return this._komoNavInfo;
    }

    private DSIListener getKomoNavInfoResponder() {
        return this._komoNavInfoServiceResponder;
    }

    private AdaptationService getAdaptationService() {
        if (this._adaptationService == null) {
            this._adaptationService = (AdaptationService)this.getCategoryDelegate().getService(this, class$de$vw$mib$asl$internal$mostkombi$common$api$adaption$asl$AdaptationService == null ? (class$de$vw$mib$asl$internal$mostkombi$common$api$adaption$asl$AdaptationService = Capabilities.class$("de.vw.mib.asl.internal.mostkombi.common.api.adaption.asl.AdaptationService")) : class$de$vw$mib$asl$internal$mostkombi$common$api$adaption$asl$AdaptationService);
            this.getCategoryDelegate().registerServiceListener(this, class$de$vw$mib$asl$internal$mostkombi$common$api$adaption$asl$AdaptationService == null ? (class$de$vw$mib$asl$internal$mostkombi$common$api$adaption$asl$AdaptationService = Capabilities.class$("de.vw.mib.asl.internal.mostkombi.common.api.adaption.asl.AdaptationService")) : class$de$vw$mib$asl$internal$mostkombi$common$api$adaption$asl$AdaptationService, ADAPTATION_SERVICES);
        }
        return this._adaptationService;
    }

    @Override
    public int getIdentifier() {
        return 1757156864;
    }

    @Override
    public void executeSequence() {
        boolean[] blArray = new boolean[]{this.getAdaptationService().getMostCapabilityForKdk() == 2, this.getAdaptationService().getMostCapabilityForMap() == 2};
        this.getKomboNavInfo().setCapabilities(blArray);
    }

    @Override
    public void updateNavInfo(NavInfoService navInfoService, int n, Object object) {
    }

    public void dsiKOMONavInfoSetCapabilitiesResult(int n) {
    }

    @Override
    public void updateAdaptation(AdaptationService adaptationService, int n) {
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

