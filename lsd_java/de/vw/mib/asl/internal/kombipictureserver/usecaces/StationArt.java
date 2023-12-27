/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.kombipictureserver.usecaces;

import de.vw.mib.asl.internal.kombipictureserver.common.api.bap.audiosd.BapAudioSdDelegate;
import de.vw.mib.asl.internal.kombipictureserver.common.api.bap.audiosd.BapAudioSdService;
import de.vw.mib.asl.internal.kombipictureserver.common.api.radio.asl.RadioStationArtDelegate;
import de.vw.mib.asl.internal.kombipictureserver.common.api.radio.asl.RadioStationArtService;
import de.vw.mib.asl.internal.kombipictureserver.common.api.tvtuner.asl.TvTunerStationArtDelegate;
import de.vw.mib.asl.internal.kombipictureserver.common.api.tvtuner.asl.TvTunerStationArtService;
import de.vw.mib.asl.internal.kombipictureserver.common.services.KombiPictureServerServices;
import de.vw.mib.asl.internal.kombipictureserver.common.services.KombiPictureServerServicesProvider;
import de.vw.mib.asl.internal.kombipictureserver.common.services.LoggerFacade;
import de.vw.mib.asl.internal.kombipictureserver.common.util.KombiPictureServerUtil;
import de.vw.mib.asl.internal.kombipictureserver.usecaces.PictureServerUseCase;
import de.vw.mib.asl.internal.kombipictureserver.usecaces.StationArtBandChangeDelay;
import de.vw.mib.asl.internal.kombipictureserver.usecaces.StationArtData;
import de.vw.mib.asl.internal.kombipictureserver.usecaces.StationArtServices;
import org.dsi.ifc.global.ResourceLocator;

public class StationArt
extends PictureServerUseCase
implements BapAudioSdDelegate,
RadioStationArtDelegate,
TvTunerStationArtDelegate {
    private final StationArtBandChangeDelay dsiDelayDelegate;
    private final StationArtServices stationArtServices = new StationArtServices();
    private StationArtData lastSendData = new StationArtData();
    private int lastReceivedBapPresetID = -1;
    private int lastReceivedSourceType = 0;
    private boolean waitForValidStationArt = false;
    private final LoggerFacade logger;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$kombipictureserver$common$api$bap$audiosd$BapAudioSdService;

    public StationArt() {
        KombiPictureServerServices kombiPictureServerServices = KombiPictureServerServicesProvider.getKombiPictureServerServices();
        this.logger = kombiPictureServerServices.createLoggerFacade(super.getClass(), 2);
        this.dsiDelayDelegate = new StationArtBandChangeDelay(kombiPictureServerServices);
    }

    @Override
    public void initialize() {
        this.setBapActiveSourceType(this.stationArtServices.getBapAudioSdService(this).getActiveSource().getActiveSourceSourceType());
    }

    @Override
    public int getIdentifier() {
        return 1133843968;
    }

    @Override
    public void executeSequence() {
        this.registerListeners();
        this.dsiDelayDelegate.initialize(this.stationArtServices.getKombiPictureServer(this));
        this.getCategoryDelegate().updateAllServiceListeners(class$de$vw$mib$asl$internal$kombipictureserver$common$api$bap$audiosd$BapAudioSdService == null ? (class$de$vw$mib$asl$internal$kombipictureserver$common$api$bap$audiosd$BapAudioSdService = StationArt.class$("de.vw.mib.asl.internal.kombipictureserver.common.api.bap.audiosd.BapAudioSdService")) : class$de$vw$mib$asl$internal$kombipictureserver$common$api$bap$audiosd$BapAudioSdService);
    }

    private void registerListeners() {
        this.stationArtServices.getKombiPictureServer(this);
        this.stationArtServices.getRadioStationArtService(this);
        this.stationArtServices.getTvTunerStationArtService(this);
        this.stationArtServices.getBapAudioSdService(this);
    }

    private void setBAPPresetID(int n) {
        int n2 = this.lastReceivedBapPresetID;
        this.lastReceivedBapPresetID = n;
        if (n2 != n) {
            this._updateStationArt();
        }
    }

    private boolean isPresetChangeActive() {
        return this.lastSendData.getRadioPresetID() != this.stationArtServices.getRadioStationArtService(this).getCurrentlyActiveRadioPresetIndex();
    }

    private void setBapActiveSourceType(int n) {
        if (this.lastReceivedSourceType != n) {
            this.lastReceivedSourceType = n;
            this._updateStationArt();
        } else {
            this.logger.trace(new Object[]{"setBapActiveSourceType() type still: ", new Integer(this.lastReceivedSourceType)});
        }
    }

    public void dsiKombiPictureServerIndicationStationArt(long l, int n, int n2) {
        boolean bl;
        this.logger.trace(new StringBuffer().append("DSI requested station art address: ").append(l).append(" type: ").append(n).append(" source ").append(n2).toString());
        boolean bl2 = l == 0L && n == 0 && n2 == 255;
        boolean bl3 = bl = bl2 || l == (long)this.stationArtServices.getBapAudioSdService(this).getCurrentStationHandle().getCurrentStationHandlePresetListReference() && n == 0 && n2 == this.lastReceivedSourceType;
        if (bl) {
            ResourceLocator resourceLocator = this.getResourceLocatorForSourceType(this.lastReceivedSourceType);
            if (resourceLocator != null) {
                this.stationArtServices.getKombiPictureServer(this).responseStationArt(this.lastReceivedBapPresetID, 0, this.lastReceivedSourceType, 1, resourceLocator);
            } else {
                this.stationArtServices.getKombiPictureServer(this).responseStationArt(this.lastReceivedBapPresetID, 0, this.lastReceivedSourceType, 0, null);
            }
        } else {
            this.stationArtServices.getKombiPictureServer(this).responseStationArt(l, n, n2, 2, null);
            this.logger.warn(new StringBuffer().append("Fallback raw sending address: ").append(l).append(" type: ").append(n).append(" source ").append(n2).toString());
        }
    }

    private static boolean isActiveSourceSupportingStationArt(int n) {
        switch (n) {
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 9: 
            case 17: {
                return true;
            }
        }
        return false;
    }

    private ResourceLocator getResourceLocatorForSourceType(int n) {
        ResourceLocator resourceLocator;
        switch (n) {
            case 2: 
            case 17: {
                resourceLocator = this.stationArtServices.getRadioStationArtService(this).getCurrentAmStationArt();
                break;
            }
            case 1: {
                resourceLocator = this.stationArtServices.getRadioStationArtService(this).getCurrentFmStationArt();
                break;
            }
            case 3: {
                resourceLocator = this.stationArtServices.getRadioStationArtService(this).getCurrentDabStationArt();
                break;
            }
            case 9: {
                resourceLocator = this.stationArtServices.getTvTunerStationArtService(this).getCurrentTvStationArt();
                break;
            }
            case 4: 
            case 5: {
                resourceLocator = this.stationArtServices.getRadioStationArtService(this).getCurrentSdarsStationArt();
                break;
            }
            default: {
                resourceLocator = null;
            }
        }
        return resourceLocator;
    }

    private boolean isResourceLocatorValidForSourceType(int n) {
        boolean bl;
        switch (n) {
            case 2: 
            case 17: {
                bl = this.stationArtServices.getRadioStationArtService(this).isCurrentAmStationArtValid();
                break;
            }
            case 1: {
                bl = this.stationArtServices.getRadioStationArtService(this).isCurrentFmStationArtValid();
                break;
            }
            case 3: {
                bl = this.stationArtServices.getRadioStationArtService(this).isCurrentDabStationArtValid();
                break;
            }
            case 9: {
                bl = this.stationArtServices.getTvTunerStationArtService(this).isCurrentTvStationArtValid();
                break;
            }
            case 4: 
            case 5: {
                bl = this.stationArtServices.getRadioStationArtService(this).isCurrentSdarsStationArtValid();
                break;
            }
            default: {
                bl = false;
            }
        }
        return bl;
    }

    private void _resourceLocatorChanged() {
        ResourceLocator resourceLocator = this.getResourceLocatorForSourceType(this.lastReceivedSourceType);
        if (!KombiPictureServerUtil.compareResourceLocator(resourceLocator, this.lastSendData.getResourceLocator()) && !this.isPresetChangeActive()) {
            this._updateStationArt();
        }
    }

    private void _resourceLocatorValidFlagChanged() {
        if (this.waitForValidStationArt && this.isResourceLocatorValidForSourceType(this.lastReceivedSourceType)) {
            this._updateStationArt();
        }
    }

    private void _updateStationArt() {
        if (StationArt.isActiveSourceSupportingStationArt(this.lastReceivedSourceType)) {
            if (this.isResourceLocatorValidForSourceType(this.lastReceivedSourceType)) {
                boolean bl;
                boolean bl2;
                ResourceLocator resourceLocator = this.getResourceLocatorForSourceType(this.lastReceivedSourceType);
                int n = this.stationArtServices.getRadioStationArtService(this).getCurrentlyActiveRadioPresetIndex();
                StationArtData stationArtData = new StationArtData(this.lastReceivedBapPresetID, n, this.lastReceivedSourceType, resourceLocator);
                this.logger.trace(new Object[]{"updateStationArt() Checking new station data: ", stationArtData});
                boolean bl3 = bl2 = this.lastReceivedSourceType == 1 || this.lastReceivedSourceType == 5 || this.lastReceivedSourceType == 4;
                boolean bl4 = bl2 ? this.lastReceivedBapPresetID == -1 : (bl = this.lastReceivedBapPresetID == 0 || this.lastReceivedBapPresetID == -1);
                if (resourceLocator != null && bl) {
                    this.logger.trace("updateStationArt() avoid update with invalid Id.");
                    return;
                }
                this.logger.trace(new StringBuffer().append("updateStationArt() Comparing old station data: ").append(this.lastSendData).toString());
                if (this.lastSendData == null || !this.lastSendData.equals(stationArtData)) {
                    this.dsiDelayDelegate.processLastReceivedData(stationArtData);
                    this.lastSendData = stationArtData;
                    this.waitForValidStationArt = false;
                }
            } else {
                this.waitForValidStationArt = true;
                this.logger.normal(new StringBuffer().append("Waiting for valid station art as received source is invalid: ").append(this.lastReceivedSourceType).toString());
            }
        } else {
            this.logger.warn(new StringBuffer().append("Invalid updateStationArt state with lastReceivedSourceType: ").append(this.lastReceivedSourceType).toString());
            this.lastSendData.setResourceLocator(null);
            this.lastSendData.setSourceType(this.lastReceivedSourceType);
            this.waitForValidStationArt = false;
        }
    }

    @Override
    public void updateBapAudioSd(BapAudioSdService bapAudioSdService, int n) {
        switch (n) {
            case 16: {
                this.logger.trace("Active source changed.");
                this.setBapActiveSourceType(bapAudioSdService.getActiveSource().getActiveSourceSourceType());
                break;
            }
            case 22: {
                this.logger.trace("Current station handle changed.");
                this.setBAPPresetID(bapAudioSdService.getCurrentStationHandle().getCurrentStationHandlePresetListReference());
                break;
            }
        }
    }

    @Override
    public void updateTvTunerStationArt(TvTunerStationArtService tvTunerStationArtService, int n) {
        this.logger.trace("TV update");
        switch (n) {
            case 2494: {
                this.logger.trace("TV tuner station art resource changed.");
                this._resourceLocatorChanged();
                break;
            }
            case -1: {
                this.logger.trace("TV tuner station art valid changed.");
                this._resourceLocatorValidFlagChanged();
                break;
            }
        }
    }

    @Override
    public void updateRadioStationArt(RadioStationArtService radioStationArtService, int n) {
        switch (n) {
            case -5: {
                this.logger.trace("Tuner station art AM resource changed.");
                if (this.lastReceivedSourceType != 2 && this.lastReceivedSourceType != 17) break;
                this._resourceLocatorChanged();
                break;
            }
            case -1: {
                this.logger.trace("Tuner station art FM resource changed.");
                if (this.lastReceivedSourceType != 1) break;
                this._resourceLocatorChanged();
                break;
            }
            case -3: {
                this.logger.trace("Tuner station art DAB resource changed.");
                if (this.lastReceivedSourceType != 3) break;
                this._resourceLocatorChanged();
                break;
            }
            case -7: {
                this.logger.trace("Tuner station art SDARS resource changed.");
                if (this.lastReceivedSourceType != 5 && this.lastReceivedSourceType != 4) break;
                this._resourceLocatorChanged();
                break;
            }
            case -6: {
                this.logger.trace("Tuner station art AM valid changed.");
                if (this.lastReceivedSourceType != 2 && this.lastReceivedSourceType != 17) break;
                this._resourceLocatorValidFlagChanged();
                break;
            }
            case -2: {
                this.logger.trace("Tuner station art FM valid changed.");
                if (this.lastReceivedSourceType != 1) break;
                this._resourceLocatorValidFlagChanged();
                break;
            }
            case -4: {
                this.logger.trace("Tuner station art DAB valid changed.");
                if (this.lastReceivedSourceType != 3) break;
                this._resourceLocatorValidFlagChanged();
                break;
            }
            case -8: {
                this.logger.trace("Tuner station art SDARS valid changed.");
                if (this.lastReceivedSourceType != 5 && this.lastReceivedSourceType != 4) break;
                this._resourceLocatorValidFlagChanged();
                break;
            }
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

