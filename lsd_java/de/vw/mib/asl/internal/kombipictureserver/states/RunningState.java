/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.kombipictureserver.states;

import de.vw.mib.asl.internal.kombipictureserver.common.api.adaptation.asl.AdaptationService;
import de.vw.mib.asl.internal.kombipictureserver.states.PictureServerHsmContext;
import de.vw.mib.asl.internal.kombipictureserver.states.PictureServerState;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.kombipictureserver.DSIKombiPictureServer;

final class RunningState
extends PictureServerState {
    private DSIKombiPictureServer _kombiPictureServer;
    private AdaptationService _adaptationService;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$kombipictureserver$states$RunningState;
    static /* synthetic */ Class class$org$dsi$ifc$kombipictureserver$DSIKombiPictureServer;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$kombipictureserver$common$api$adaptation$asl$AdaptationService;

    public RunningState(PictureServerHsmContext pictureServerHsmContext, HsmState hsmState) {
        super(pictureServerHsmContext, (class$de$vw$mib$asl$internal$kombipictureserver$states$RunningState == null ? (class$de$vw$mib$asl$internal$kombipictureserver$states$RunningState = RunningState.class$("de.vw.mib.asl.internal.kombipictureserver.states.RunningState")) : class$de$vw$mib$asl$internal$kombipictureserver$states$RunningState).getName(), hsmState);
    }

    private DSIKombiPictureServer getKombiPictureServer() {
        if (this._kombiPictureServer == null) {
            this._kombiPictureServer = (DSIKombiPictureServer)this.getContextDelegate().getDsiServiceProvider().getDsiService(this.getHsmContext().getHsm(), class$org$dsi$ifc$kombipictureserver$DSIKombiPictureServer == null ? (class$org$dsi$ifc$kombipictureserver$DSIKombiPictureServer = RunningState.class$("org.dsi.ifc.kombipictureserver.DSIKombiPictureServer")) : class$org$dsi$ifc$kombipictureserver$DSIKombiPictureServer);
        }
        return this._kombiPictureServer;
    }

    private AdaptationService getAdaptationService() {
        if (this._adaptationService == null) {
            this._adaptationService = (AdaptationService)this.getContextDelegate().getServiceProvider().getService(this, class$de$vw$mib$asl$internal$kombipictureserver$common$api$adaptation$asl$AdaptationService == null ? (class$de$vw$mib$asl$internal$kombipictureserver$common$api$adaptation$asl$AdaptationService = RunningState.class$("de.vw.mib.asl.internal.kombipictureserver.common.api.adaptation.asl.AdaptationService")) : class$de$vw$mib$asl$internal$kombipictureserver$common$api$adaptation$asl$AdaptationService);
        }
        return this._adaptationService;
    }

    @Override
    public void stateEntry() {
    }

    @Override
    public void stateStart() {
        boolean bl = this.getAdaptationService().isMostCapabilityCallPictureSet();
        boolean bl2 = this.getAdaptationService().isMostCapabilityCoverArtSet();
        boolean bl3 = this.getAdaptationService().isMostCapabilityStationArtSet();
        if (bl || bl2) {
            int n = (bl ? 8 : 0) | (bl2 || bl3 ? 2 : 0);
            this.getKombiPictureServer().responsePictureServerAbilities(n);
            this.getKombiPictureServer().setKombiHmiReady();
        }
        if (bl2) {
            this.getContextDelegate().getController().getSequence(1100289536).executeSequence();
        }
        if (bl) {
            this.getContextDelegate().getController().getSequence(1117066752).executeSequence();
        }
        if (bl3) {
            this.getContextDelegate().getController().getSequence(1133843968).executeSequence();
        }
    }

    @Override
    public void stateExit() {
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

