/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.api.impl;

import de.vw.mib.asl.api.radio.ASLRadioAPI;
import de.vw.mib.asl.api.radio.ASLRadioTargetIds;
import de.vw.mib.asl.api.radio.AppAdapterTunerAutoStoreGlobalWizardPageCallback;
import de.vw.mib.asl.api.radio.AppAdapterTunerTileLCallback;
import de.vw.mib.asl.api.radio.RadioSDARSChannelInfo;
import de.vw.mib.asl.framework.api.entertainmentmanager.ASLEntertainmentmanagerFactory;
import de.vw.mib.asl.framework.api.entertainmentmanager.EntertainmentManagerResponder;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.id.PreRegisteredIds;
import de.vw.mib.asl.internal.radio.RadioCodingAdapter;
import de.vw.mib.asl.internal.radio.RadioCurrentWaveband;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.RadioServiceManager;
import de.vw.mib.asl.internal.radio.appadapter.ApiAppAdapterGlobalSetupWizard;
import de.vw.mib.asl.internal.radio.appadapter.ApiAppAdapterTunerTileL;
import de.vw.mib.asl.internal.radio.autostore.ApiAutostorePresets;
import de.vw.mib.asl.internal.radio.dab.DabDatabase;
import de.vw.mib.asl.internal.radio.has.RadioHASUpdater;
import de.vw.mib.asl.internal.radio.manager.ManagerTarget;
import de.vw.mib.asl.internal.radio.sdars.helper.SatDb;
import de.vw.mib.log4mib.LogMessage;
import java.util.ArrayList;
import org.dsi.ifc.sdars.RadioText;
import org.dsi.ifc.sdars.StationInfo;

public class ASLRadioAPIImpl
implements ASLRadioAPI {
    private static final int TRAVELLINK_UNSUBSCRIPTION;
    private static final int TRAVELLINK_SUBSCRIPTION;
    private static final int SERVICESTATUS_SUBSCRIBED;
    private static int subscriptionStateGraphicWeather;
    private static int subscriptionStateTabularWeather;
    private static int subscriptionStateFuelPrice;
    private static int subscriptionStateMovie;
    private static int subscriptionStateSport;

    @Override
    public void updateStationIndices(long l, int n) {
        try {
            if (RadioData.amFmTunerIsInitialized) {
                RadioServiceManager.getServiceManager().getGuiBapApi().updateBapCurrentStationIndices(n, l);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    @Override
    public boolean isWavebandAvailable(int n) {
        try {
            switch (n) {
                case 0: {
                    if (RadioData.amFmTunerIsInitialized) {
                        return !RadioCodingAdapter.isAmDisabled();
                    }
                    return false;
                }
                case 2: {
                    DabDatabase dabDatabase = RadioData.getDabDatabase();
                    if (null == dabDatabase) {
                        return false;
                    }
                    return RadioData.getDabDatabase().isDabTunerIsInitialized() && RadioData.getDabDatabase().getDabDeviceFitted() && RadioData.getDabDatabase().getDabTunerAvailability() == 2;
                }
                case 3: {
                    return 3 == SatDb.getInstance().getPool().getInt(4) && SatDb.getInstance().getPool().getBoolean(5);
                }
                case 4: {
                    return ServiceManager.configManagerDiag.isFeatureFlagSet(424);
                }
                case 1: {
                    return RadioData.amFmTunerIsInitialized;
                }
            }
            return false;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return false;
        }
    }

    @Override
    public int convertRadioBandHAS2ASL(int n) {
        try {
            return RadioHASUpdater.convertRadioBandHAS2ASL(n);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            int n2 = -1;
            return -1;
        }
    }

    @Override
    public void tuneSDARSStation(int n) {
        try {
            StationInfo stationInfo;
            if (this.isWavebandAvailable(3) && null != (stationInfo = SatDb.getInstance().getChannels().getChannelBySID(n))) {
                SatDb.getInstance().getTuneHandler().tuneChannelSafe(18, stationInfo, false);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    @Override
    public boolean isChannelAvailable(int n) {
        try {
            if (this.isWavebandAvailable(3)) {
                return SatDb.getInstance().getChannels().isChannelValid(n);
            }
            return false;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return false;
        }
    }

    @Override
    public void prepareRadioText(boolean bl, ArrayList arrayList) {
        try {
            if (this.isWavebandAvailable(3)) {
                SatDb.getInstance().setPrepareStatus(bl);
                SatDb.getInstance().setSidList(arrayList);
                LogMessage logMessage = SatDb.getInstance().getLogHandler().getLogMsg();
                if (logMessage != null) {
                    logMessage.append("PrepareRadioText from TL: ").append(bl).log();
                }
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    @Override
    public ArrayList getSDARSChannelInfo(ArrayList arrayList) {
        try {
            if (this.isWavebandAvailable(3)) {
                RadioSDARSChannelInfo radioSDARSChannelInfo = null;
                StationInfo stationInfo = null;
                RadioText radioText = null;
                ArrayList arrayList2 = new ArrayList();
                for (int i2 = 0; i2 < arrayList.size(); ++i2) {
                    radioSDARSChannelInfo = new RadioSDARSChannelInfo();
                    stationInfo = SatDb.getInstance().getChannels().getChannelBySID((Integer)arrayList.get(i2));
                    if (null == stationInfo) continue;
                    radioSDARSChannelInfo.setChannelName(stationInfo.getFullLabel());
                    radioSDARSChannelInfo.setChannelNumber(stationInfo.getStationNumber());
                    radioSDARSChannelInfo.setServiceID(stationInfo.getSID());
                    if (null != SatDb.getInstance().getImageDb()) {
                        radioSDARSChannelInfo.setChannelLogo(SatDb.getInstance().getImageDb().getImage(stationInfo.getSID()));
                    } else {
                        radioSDARSChannelInfo.setChannelLogo(stationInfo.getChannelArt());
                    }
                    radioText = SatDb.getInstance().getRadioTextHandler().get(stationInfo.getSID());
                    if (null != radioText) {
                        radioSDARSChannelInfo.setArtist(radioText.getLongArtistName());
                        radioSDARSChannelInfo.setTitle(radioText.getLongProgramTitle());
                    }
                    arrayList2.add(radioSDARSChannelInfo);
                }
                return arrayList2;
            }
            return null;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return null;
        }
    }

    @Override
    public void updateTravelLinkSubscriptions(int n, int n2, int n3, int n4, int n5) {
        try {
            subscriptionStateGraphicWeather = n;
            subscriptionStateTabularWeather = n2;
            subscriptionStateFuelPrice = n3;
            subscriptionStateMovie = n4;
            subscriptionStateSport = n5;
            this.updateTravelLinkSubscriptionValues(n, n2, n3, n4, n5);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    @Override
    public void updateTravelLinkSubscriptions() {
        try {
            this.updateTravelLinkSubscriptionValues(subscriptionStateGraphicWeather, subscriptionStateTabularWeather, subscriptionStateFuelPrice, subscriptionStateMovie, subscriptionStateSport);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    private void updateTravelLinkSubscriptionValues(int n, int n2, int n3, int n4, int n5) {
        try {
            if (2 == n) {
                SatDb.getInstance().getPool().setInt(192, 1);
            } else {
                SatDb.getInstance().getPool().setInt(192, 0);
            }
            if (2 == n2) {
                SatDb.getInstance().getPool().setInt(193, 1);
            } else {
                SatDb.getInstance().getPool().setInt(193, 0);
            }
            if (2 == n3) {
                SatDb.getInstance().getPool().setInt(194, 1);
            } else {
                SatDb.getInstance().getPool().setInt(194, 0);
            }
            if (2 == n4) {
                SatDb.getInstance().getPool().setInt(195, 1);
            } else {
                SatDb.getInstance().getPool().setInt(195, 0);
            }
            if (2 == n5) {
                SatDb.getInstance().getPool().setInt(196, 1);
            } else {
                SatDb.getInstance().getPool().setInt(196, 0);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    @Override
    public void startInitialAutostore() {
        ApiAutostorePresets.startInitialAutostore();
    }

    @Override
    public void stopInitialAutostore() {
        ApiAutostorePresets.stopInitialAutostore();
    }

    @Override
    public void activateWaveband(int n) {
        try {
            EntertainmentManagerResponder entertainmentManagerResponder;
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("ASLRadioAPIImpl - activateWaveband(").append(n).append(")").log();
            }
            if (null != (entertainmentManagerResponder = ASLEntertainmentmanagerFactory.getEntertainmentmanagerApi().createEntertainmentManagerResponder(1, ASLRadioTargetIds.ASL_RADIO_MANAGER))) {
                entertainmentManagerResponder.weakRequest(n);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    @Override
    public void activateWavebandAlways(int n) {
        try {
            EntertainmentManagerResponder entertainmentManagerResponder;
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("ASLRadioAPIImpl - activateWavebandAlways(").append(n).append(")").log();
            }
            if (null != (entertainmentManagerResponder = ASLEntertainmentmanagerFactory.getEntertainmentmanagerApi().createEntertainmentManagerResponder(1, ASLRadioTargetIds.ASL_RADIO_MANAGER))) {
                entertainmentManagerResponder.sourceAdded(n);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    @Override
    public void setAppAdapterTunerAutoStoreGlobalWizardPageCallbackInstance(AppAdapterTunerAutoStoreGlobalWizardPageCallback appAdapterTunerAutoStoreGlobalWizardPageCallback) {
        try {
            ApiAppAdapterGlobalSetupWizard.appAdapterTunerAutoStoreCallbackInstance = appAdapterTunerAutoStoreGlobalWizardPageCallback;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    @Override
    public boolean isTaggedStationChanged() {
        boolean bl = false;
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(2)) {
            if (RadioCurrentWaveband.get() == 3) {
                if (RadioServiceManager.getServiceManager().getTaggingSatChannel().sID != SatDb.getInstance().getPool().getChannel((int)23).sID) {
                    bl = true;
                }
            } else if (RadioServiceManager.getServiceManager().getTaggingStationInfo().frequency != RadioData.getAmfmDatabase().getCurrentHDStation().frequency || RadioServiceManager.getServiceManager().getTaggingStationInfo().serviceId != RadioData.getAmfmDatabase().getCurrentHDStation().serviceId) {
                bl = true;
            }
        }
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(" isTagStationChanged - ").append(bl).log();
        }
        return bl;
    }

    @Override
    public void setAppAdapterTunerTileLCallbackInstance(AppAdapterTunerTileLCallback appAdapterTunerTileLCallback) {
        try {
            ApiAppAdapterTunerTileL.appAdapterTunerTileLCallback = appAdapterTunerTileLCallback;
            if (!RadioServiceManager.getServiceManager().isRadioTileLNextWavebandInitializedAfterStartup()) {
                ApiAppAdapterTunerTileL.setWaveband();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    @Override
    public void radioTileLCioIntentRegistrationFinished() {
        RadioServiceManager.getServiceManager().setRadioTileLCioIntentRegistrationFinished(true);
        if (!RadioServiceManager.getServiceManager().isRadioTileLNextWavebandInitializedAfterStartup()) {
            ApiAppAdapterTunerTileL.setWaveband();
        }
    }

    @Override
    public boolean isRadioActive() {
        return ManagerTarget.isRadioActive;
    }

    static {
        subscriptionStateGraphicWeather = 0;
        subscriptionStateTabularWeather = 0;
        subscriptionStateFuelPrice = 0;
        subscriptionStateMovie = 0;
        subscriptionStateSport = 0;
        PreRegisteredIds.addServiceOrObserverToArray(0, ASLRadioTargetIds.ASL_RADIO_HSMTARGET_AMFM, 1635924736);
        PreRegisteredIds.addServiceOrObserverToArray(0, ASLRadioTargetIds.ASL_RADIO_HSMTARGET_AMFM, 557853696);
        PreRegisteredIds.addServiceOrObserverToArray(0, ASLRadioTargetIds.ASL_RADIO_HSMTARGET_AMFM, -660733952);
        PreRegisteredIds.addServiceOrObserverToArray(0, ASLRadioTargetIds.ASL_RADIO_HSMTARGET_AMFM, -509739008);
        PreRegisteredIds.addServiceOrObserverToArray(0, ASLRadioTargetIds.ASL_RADIO_HSMTARGET_AMFM, -425852928);
        PreRegisteredIds.addServiceOrObserverToArray(1, ASLRadioTargetIds.ASL_RADIO_HSMTARGET_DAB, -1113718784);
        PreRegisteredIds.addServiceOrObserverToArray(1, ASLRadioTargetIds.ASL_RADIO_HSMTARGET_DAB, -1516371968);
        PreRegisteredIds.addServiceOrObserverToArray(2, ASLRadioTargetIds.ASL_RADIO_HSMTARGET_AUTOSTORE, -838598592);
        PreRegisteredIds.addServiceOrObserverToArray(2, ASLRadioTargetIds.ASL_RADIO_HSMTARGET_AUTOSTORE, -704380864);
        PreRegisteredIds.addServiceOrObserverToArray(2, ASLRadioTargetIds.ASL_RADIO_MANAGER, -2096889792);
        PreRegisteredIds.addServiceOrObserverToArray(2, ASLRadioTargetIds.ASL_RADIO_MANAGER, 1635924736);
        PreRegisteredIds.addServiceOrObserverToArray(0, ASLRadioTargetIds.ASL_SDARS_MAIN_TARGET, -711065600, true);
        PreRegisteredIds.addServiceOrObserverToArray(2, ASLRadioTargetIds.ASL_RADIO_MANAGER, 544618496);
    }
}

