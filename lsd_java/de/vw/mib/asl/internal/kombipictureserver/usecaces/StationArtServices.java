/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.kombipictureserver.usecaces;

import de.vw.mib.asl.internal.kombipictureserver.common.api.bap.audiosd.BapAudioSdService;
import de.vw.mib.asl.internal.kombipictureserver.common.api.radio.asl.RadioStationArtDelegate;
import de.vw.mib.asl.internal.kombipictureserver.common.api.radio.asl.RadioStationArtService;
import de.vw.mib.asl.internal.kombipictureserver.common.api.tvtuner.asl.TvTunerStationArtDelegate;
import de.vw.mib.asl.internal.kombipictureserver.common.api.tvtuner.asl.TvTunerStationArtService;
import de.vw.mib.asl.internal.kombipictureserver.usecaces.StationArt;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.kombipictureserver.DSIKombiPictureServer;

class StationArtServices {
    private DSIKombiPictureServer kombiPictureServer;
    private RadioStationArtService radioStationArtService;
    private TvTunerStationArtService tvTunerStationArtService;
    private BapAudioSdService bapAudioSdService;
    static final int[] BAP_AUDIO_SD_SERVICES = new int[]{16, 22};
    static /* synthetic */ Class class$de$vw$mib$asl$internal$kombipictureserver$common$api$bap$audiosd$BapAudioSdService;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$kombipictureserver$common$api$tvtuner$asl$TvTunerStationArtService;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$kombipictureserver$common$api$radio$asl$RadioStationArtService;
    static /* synthetic */ Class class$org$dsi$ifc$kombipictureserver$DSIKombiPictureServer;
    static /* synthetic */ Class class$org$dsi$ifc$kombipictureserver$DSIKombiPictureServerListener;

    BapAudioSdService getBapAudioSdService(StationArt stationArt) {
        if (this.bapAudioSdService == null) {
            this.bapAudioSdService = (BapAudioSdService)stationArt.getCategoryDelegate().getService(stationArt, class$de$vw$mib$asl$internal$kombipictureserver$common$api$bap$audiosd$BapAudioSdService == null ? (class$de$vw$mib$asl$internal$kombipictureserver$common$api$bap$audiosd$BapAudioSdService = StationArtServices.class$("de.vw.mib.asl.internal.kombipictureserver.common.api.bap.audiosd.BapAudioSdService")) : class$de$vw$mib$asl$internal$kombipictureserver$common$api$bap$audiosd$BapAudioSdService);
            stationArt.getCategoryDelegate().registerServiceListener(stationArt, class$de$vw$mib$asl$internal$kombipictureserver$common$api$bap$audiosd$BapAudioSdService == null ? (class$de$vw$mib$asl$internal$kombipictureserver$common$api$bap$audiosd$BapAudioSdService = StationArtServices.class$("de.vw.mib.asl.internal.kombipictureserver.common.api.bap.audiosd.BapAudioSdService")) : class$de$vw$mib$asl$internal$kombipictureserver$common$api$bap$audiosd$BapAudioSdService, BAP_AUDIO_SD_SERVICES);
        }
        return this.bapAudioSdService;
    }

    TvTunerStationArtService getTvTunerStationArtService(StationArt stationArt) {
        if (this.tvTunerStationArtService == null) {
            this.tvTunerStationArtService = (TvTunerStationArtService)stationArt.getCategoryDelegate().getService(stationArt, class$de$vw$mib$asl$internal$kombipictureserver$common$api$tvtuner$asl$TvTunerStationArtService == null ? (class$de$vw$mib$asl$internal$kombipictureserver$common$api$tvtuner$asl$TvTunerStationArtService = StationArtServices.class$("de.vw.mib.asl.internal.kombipictureserver.common.api.tvtuner.asl.TvTunerStationArtService")) : class$de$vw$mib$asl$internal$kombipictureserver$common$api$tvtuner$asl$TvTunerStationArtService);
            stationArt.getCategoryDelegate().registerServiceListener(stationArt, class$de$vw$mib$asl$internal$kombipictureserver$common$api$tvtuner$asl$TvTunerStationArtService == null ? (class$de$vw$mib$asl$internal$kombipictureserver$common$api$tvtuner$asl$TvTunerStationArtService = StationArtServices.class$("de.vw.mib.asl.internal.kombipictureserver.common.api.tvtuner.asl.TvTunerStationArtService")) : class$de$vw$mib$asl$internal$kombipictureserver$common$api$tvtuner$asl$TvTunerStationArtService, TvTunerStationArtDelegate.TV_TUNER_STATION_ART_PROPERTIES);
        }
        return this.tvTunerStationArtService;
    }

    RadioStationArtService getRadioStationArtService(StationArt stationArt) {
        if (this.radioStationArtService == null) {
            this.radioStationArtService = (RadioStationArtService)stationArt.getCategoryDelegate().getService(stationArt, class$de$vw$mib$asl$internal$kombipictureserver$common$api$radio$asl$RadioStationArtService == null ? (class$de$vw$mib$asl$internal$kombipictureserver$common$api$radio$asl$RadioStationArtService = StationArtServices.class$("de.vw.mib.asl.internal.kombipictureserver.common.api.radio.asl.RadioStationArtService")) : class$de$vw$mib$asl$internal$kombipictureserver$common$api$radio$asl$RadioStationArtService);
            stationArt.getCategoryDelegate().registerServiceListener(stationArt, class$de$vw$mib$asl$internal$kombipictureserver$common$api$radio$asl$RadioStationArtService == null ? (class$de$vw$mib$asl$internal$kombipictureserver$common$api$radio$asl$RadioStationArtService = StationArtServices.class$("de.vw.mib.asl.internal.kombipictureserver.common.api.radio.asl.RadioStationArtService")) : class$de$vw$mib$asl$internal$kombipictureserver$common$api$radio$asl$RadioStationArtService, RadioStationArtDelegate.RADIO_STATION_ART_PROPERTIES);
        }
        return this.radioStationArtService;
    }

    DSIKombiPictureServer getKombiPictureServer(StationArt stationArt) {
        if (this.kombiPictureServer == null) {
            this.kombiPictureServer = (DSIKombiPictureServer)stationArt.getCategoryDelegate().getDsiService(stationArt, class$org$dsi$ifc$kombipictureserver$DSIKombiPictureServer == null ? (class$org$dsi$ifc$kombipictureserver$DSIKombiPictureServer = StationArtServices.class$("org.dsi.ifc.kombipictureserver.DSIKombiPictureServer")) : class$org$dsi$ifc$kombipictureserver$DSIKombiPictureServer);
            stationArt.getCategoryDelegate().addDsiServiceResponder(stationArt, (DSIBase)this.kombiPictureServer, class$org$dsi$ifc$kombipictureserver$DSIKombiPictureServerListener == null ? (class$org$dsi$ifc$kombipictureserver$DSIKombiPictureServerListener = StationArtServices.class$("org.dsi.ifc.kombipictureserver.DSIKombiPictureServerListener")) : class$org$dsi$ifc$kombipictureserver$DSIKombiPictureServerListener, null);
        }
        return this.kombiPictureServer;
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

