/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.dsi;

import de.vw.mib.asl.api.radio.ASLRadioTargetIds;
import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.api.travellink.ASLTravelLinkAPI;
import de.vw.mib.asl.api.travellink.ASLTravelLinkFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioCodingAdapter;
import de.vw.mib.asl.internal.radio.RadioCurrentWaveband;
import de.vw.mib.asl.internal.radio.RadioServiceManager;
import de.vw.mib.asl.internal.radio.sdars.database.IAslPool;
import de.vw.mib.asl.internal.radio.sdars.dsi.DsiProxy;
import de.vw.mib.asl.internal.radio.sdars.helper.SatConfig;
import de.vw.mib.asl.internal.radio.sdars.helper.SatDb;
import de.vw.mib.asl.internal.radio.sdars.helper.SatUtil;
import de.vw.mib.asl.internal.radio.sdars.helper.StatusHandler;
import de.vw.mib.asl.internal.radio.tile.list.TileStationList;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventException;
import de.vw.mib.log4mib.LogMessage;
import java.io.File;
import java.util.ArrayList;
import org.dsi.ifc.global.DateTime;
import org.dsi.ifc.sdars.CategoryInfo;
import org.dsi.ifc.sdars.DSISDARSTunerListener;
import org.dsi.ifc.sdars.EPGDescription;
import org.dsi.ifc.sdars.EPGShortInfo;
import org.dsi.ifc.sdars.ImageInformation;
import org.dsi.ifc.sdars.RadioText;
import org.dsi.ifc.sdars.ServiceStatus3;
import org.dsi.ifc.sdars.SignalQuality;
import org.dsi.ifc.sdars.StationDescription;
import org.dsi.ifc.sdars.StationInfo;
import org.dsi.ifc.sdars.SubscriptionStatus;

public final class SatTunerListener
implements DSISDARSTunerListener {
    private final SatDb mDb;
    private final DsiProxy mProxy;
    private final IAslPool mPool;
    private static final int SUBSCRIPTION_MODEL;
    private static final int UNSUBSCRIPTION_MODEL;
    public static boolean isMuteTimerOn;

    public SatTunerListener(DsiProxy dsiProxy, SatDb satDb) {
        this.mProxy = dsiProxy;
        this.mDb = satDb;
        this.mPool = this.mDb.getPool();
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        EventGeneric eventGeneric = this.mDb.newEvent();
        eventGeneric.setReceiverEventId(193396992);
        eventGeneric.setInt(0, n);
        eventGeneric.setString(1, string);
        eventGeneric.setInt(2, n2);
        this.send(eventGeneric);
    }

    @Override
    public void responseTime(DateTime dateTime) {
        if (dateTime != null && dateTime.time != 0L) {
            long l = ASLSystemFactory.getSystemApi().getCurrentTimestamp();
            this.mPool.setLong(66, dateTime.getTime());
            this.mPool.setLong(67, l);
        }
    }

    @Override
    public void selectStationStatus(int n) {
        SatDb.selectedStationStatus = n;
        EventGeneric eventGeneric = this.mDb.newEvent();
        eventGeneric.setReceiverEventId(176619776);
        eventGeneric.setInt(0, n);
        this.send(eventGeneric);
    }

    @Override
    public void updateAvailability(int n, int n2) {
        if (n2 == 1) {
            int n3;
            ServiceManager.logger.info(512).append("SatTunerListener - updateAvailability() - ").append(n).log();
            this.mPool.setString(46, "UPDATE_AVAILABILITY");
            String string = System.getProperty("de.vw.mib.asl.internal.radio.sdars.test_dsi_available");
            if (string == null) {
                File file;
                n3 = 2;
                String string2 = System.getProperty("de.vw.mib.patch.sdarsflagfile");
                if ((string2 = SatUtil.getTrimmed(string2)) != null && (file = new File(string2)).exists()) {
                    n3 = 1;
                }
                this.mPool.setBoolean(5, n == n3);
            } else {
                n3 = Boolean.getBoolean("de.vw.mib.asl.internal.radio.sdars.test_dsi_available") ? 1 : 0;
                this.mPool.setBoolean(5, n3 != 0);
            }
            RadioServiceManager.getServiceManager().getAdapterAslSpeech().updateSiriusChannelListToSpeech();
            if (SatDb.mLSMTuneFailed && this.mPool.getBoolean(5)) {
                try {
                    SatDb.mLSMTuneFailed = false;
                    EventGeneric eventGeneric = this.mDb.newEvent();
                    eventGeneric.setReceiverTargetId(ASLRadioTargetIds.ASL_SDARS_MAIN_TARGET);
                    eventGeneric.setReceiverEventId(-1232731904);
                    this.mDb.getMainTarget().send(eventGeneric);
                }
                catch (Exception exception) {
                    // empty catch block
                }
            }
        }
    }

    @Override
    public void updateCategoryList(CategoryInfo[] categoryInfoArray, int n) {
        if (n == 1) {
            this.mPool.setString(46, "UPDATE_CATEGORY_LIST");
            this.mDb.getCategories().setCategoryList(categoryInfoArray);
            this.mDb.getListApi().updateCategoryList();
            this.mDb.getRadioTextHandler().updatePDT();
            this.mProxy.addOtherNotifications(2);
            this.mDb.getSatPrepareChannelList().showCurrentChannel();
        }
    }

    @Override
    public void updateDetectedDevice(int n, int n2) {
        if (n2 == 1) {
            ServiceManager.logger.info(512).append("SatTunerListener - updateDetectedDevice() - ").append(n).log();
            this.mPool.setString(46, "UPDATE_DETECTED_DEVICE");
            String string = System.getProperty("de.vw.mib.asl.internal.radio.sdars.test_dsi_devicetype");
            if (string == null) {
                this.mPool.setInt(4, n);
            } else {
                int n3 = Integer.parseInt(string);
                this.mPool.setInt(4, n3);
            }
            RadioServiceManager.getServiceManager().getAdapterAslSpeech().updateSiriusChannelListToSpeech();
        }
    }

    @Override
    public void updateElectronicSerialCode(String string, int n) {
        if (n == 1) {
            this.mPool.setString(46, "UPDATE_ELECTRONIC_SERIAL_CODE");
            this.mPool.setString(162, string);
        }
    }

    public void updateRadioText(RadioText radioText, int n) {
    }

    @Override
    public void updateSelectedStation(StationInfo stationInfo, int n) {
        if (n == 1) {
            this.mPool.setString(46, "UPDATE_SELECTED_STATION");
            if (stationInfo != null && stationInfo.sID != 0 && stationInfo.stationNumber != 0) {
                StationInfo stationInfo2;
                Object object;
                Object object2;
                if (stationInfo.getSubscription() != 2) {
                    object2 = stationInfo.getFullLabel();
                    short s = stationInfo.getStationNumber();
                    object = new StringBuffer().append(Integer.toString(s)).append(" ").append((String)object2).toString();
                    this.mPool.setString(201, (String)object);
                }
                if (null != stationInfo && stationInfo.getSubscription() != 2) {
                    this.mPool.setBoolean(202, true);
                }
                if ((stationInfo2 = this.mDb.getChannels().getChannelBySID(stationInfo.getSID())) != null) {
                    object2 = stationInfo2;
                    this.mDb.getImageDb().addImage(stationInfo.sID, stationInfo.channelArt);
                    object = SatUtil.getTrimmed(stationInfo.fullLabel);
                    if (object != null) {
                        stationInfo2.fullLabel = object;
                    }
                    if ((object = SatUtil.getTrimmed(stationInfo.shortLabel)) != null) {
                        stationInfo2.shortLabel = object;
                    }
                    stationInfo2.categoryNumber = stationInfo.categoryNumber;
                    stationInfo2.mature = stationInfo.mature;
                    stationInfo2.stationNumber = stationInfo.stationNumber;
                    stationInfo2.subscription = stationInfo.subscription;
                } else {
                    object2 = stationInfo;
                }
                this.mDb.getPresetApi().notifyChannelTuned();
                this.mDb.getMainTarget().startTimerCheckPlayingChannel();
                if (((StationInfo)object2).subscription == 2) {
                    this.mPool.setChannel(21, (StationInfo)object2);
                    object = this.mPool.getChannel(23);
                    if (((StationInfo)object2).sID != ((StationInfo)object).sID) {
                        // empty if block
                    }
                }
                if (((StationInfo)object2).subscription != 2) {
                    try {
                        ServiceManager.logger.info(512).append("SatTunerListener - updateSelectedStation: Default channel is set ").log();
                        this.mDb.getTuneHandler().tuneChannel(5, SatConfig.DEFAULT_CHANNEL, false);
                        this.mPool.setBoolean(202, false);
                    }
                    catch (Exception exception) {
                        // empty catch block
                    }
                }
                if (!RadioServiceManager.getServiceManager().isSdarsStationOverridenNotAllowed()) {
                    this.mPool.setChannel(79, stationInfo);
                    this.mPool.setChannel(15, stationInfo);
                    this.mPool.setChannel(23, stationInfo);
                }
            } else {
                LogMessage logMessage = this.mDb.getLogHandler().getLogMsg();
                if (logMessage != null) {
                    logMessage.append("Could not take over invalid selected Station from DSI: ").append(stationInfo == null ? "null" : stationInfo.toString()).log();
                }
            }
        }
    }

    @Override
    public void updateServiceStatus3(ServiceStatus3 serviceStatus3, int n) {
        if (n == 1) {
            this.mPool.setString(46, "UPDATE_SERVICE_STATUS3");
            this.mPool.setInt(3, serviceStatus3.antennaStatus);
            if (serviceStatus3.audioStatus != 2) {
                isMuteTimerOn = true;
                this.mPool.setBoolean(212, true);
            } else {
                isMuteTimerOn = false;
                this.mPool.setBoolean(212, false);
                this.mPool.setInt(1, serviceStatus3.audioStatus);
            }
            if (serviceStatus3.dataSubscription == 2) {
                this.mPool.setInt(6, 2);
            } else {
                this.mPool.setInt(6, 1);
            }
            this.mPool.setInt(208, serviceStatus3.dataSubscription);
            StatusHandler.lastTrafficSubscriptionStatus = this.mPool.getInt(208);
            this.mPool.setInt(7, serviceStatus3.dataUpdateStatus);
            this.mPool.setInt(8, serviceStatus3.listUpdateStatus);
            this.mPool.setInt(10, serviceStatus3.subscriptionUpdateStatus);
            this.mPool.setInt(9, serviceStatus3.listUpdatePercentage);
            LogMessage logMessage = this.mDb.getLogHandler().getLogMsg();
            if (logMessage != null && null != serviceStatus3) {
                logMessage.append("updateServiceStatus3(): ").append("AntennaStatus: ").append(serviceStatus3.antennaStatus).append("AudioStatus: ").append(serviceStatus3.audioStatus).append("DataSubscription (Traffic): ").append(serviceStatus3.dataSubscription).append("DataUpdateStatus: ").append(serviceStatus3.dataUpdateStatus).append("ListUpdateStatus").append(serviceStatus3.listUpdateStatus).append("subscriptionUpdateStatus: ").append(serviceStatus3.subscriptionUpdateStatus).append("ListUpdatePercentage: ").append(serviceStatus3.listUpdatePercentage).log();
            }
        }
    }

    @Override
    public void updateSignalQuality(SignalQuality signalQuality, int n) {
        this.mPool.setString(46, "UPDATE_SIGNAL_QUALITY");
    }

    @Override
    public void updateStaticTaggingInfo(String string, String string2, int n) {
        if (n == 1) {
            this.mPool.setString(46, new StringBuffer().append("UPDATE_STATIC_TAGGING_INFO (from Southside: not used): ").append(string).append(" - ").append(string2).toString());
        }
    }

    @Override
    public void updateStationDescription(StationDescription[] stationDescriptionArray, int n) {
        if (n == 1) {
            this.mPool.setString(46, "UPDATE_STATION_DESCRIPTION");
            this.mDb.getStationDescriptionHandler().updateStationDescription(stationDescriptionArray);
        }
    }

    @Override
    public void updateStationList(StationInfo[] stationInfoArray, int n) {
        if (n == 1) {
            this.mPool.setString(46, "UPDATE_STATION_LIST");
            this.mDb.getChannels().setChannelList(stationInfoArray);
            this.mProxy.addOtherNotifications(1);
            this.mProxy.getTime();
            this.mDb.getSatPrepareChannelList().updateSdarsSpeechData();
            try {
                TileStationList tileStationList;
                if (RadioCodingAdapter.isRadioTileFeatureActivated() && RadioCurrentWaveband.isSdars() && null != (tileStationList = RadioServiceManager.getServiceManager().getTileStationList())) {
                    tileStationList.initTiles();
                }
            }
            catch (Exception exception) {
                ServiceManager.errorHandler.handleError(exception);
            }
        }
    }

    @Override
    public void updateSubscriptionStatus(SubscriptionStatus subscriptionStatus, int n) {
        if (n == 1 && subscriptionStatus != null) {
            String string;
            this.mPool.setString(46, "UPDATE_SUSCRIPTION_STATUS");
            ServiceManager.logger.info(512).append("SatTunerListener - updateSubscriptionStatus() - ").append(subscriptionStatus.getSubscription()).log();
            ASLTravelLinkAPI aSLTravelLinkAPI = ASLTravelLinkFactory.getTravelLinkApi();
            if (subscriptionStatus.getSubscription() == 2 || subscriptionStatus.getSubscription() == 3) {
                this.mPool.setInt(2, 2);
                this.mPool.setInt(172, 1);
                if (null != aSLTravelLinkAPI) {
                    aSLTravelLinkAPI.updateAudioSubscription(2);
                }
            } else if (subscriptionStatus.getSubscription() != 0) {
                this.mPool.setInt(2, 1);
                this.mPool.setInt(172, 0);
                if (null != aSLTravelLinkAPI) {
                    aSLTravelLinkAPI.updateAudioSubscription(1);
                }
            }
            if ((string = SatUtil.getTrimmed(subscriptionStatus.phoneNumber)) != null) {
                this.mPool.setString(47, string);
            }
            this.mPool.setInt(48, subscriptionStatus.reasonCode);
            this.mPool.setString(49, subscriptionStatus.reasonText);
            this.mPool.setInt(166, subscriptionStatus.suspendDay);
            this.mPool.setInt(167, subscriptionStatus.suspendMonth);
            this.mPool.setInt(168, subscriptionStatus.suspendYear);
        }
    }

    private void send(EventGeneric eventGeneric) {
        eventGeneric.setReceiverTargetId(ASLRadioTargetIds.ASL_SDARS_DSI_TARGET);
        eventGeneric.setSenderTargetId(ASLRadioTargetIds.ASL_SDARS_DSI_TARGET);
        try {
            this.mDb.getEventContext().getEventDispatcher().send(eventGeneric);
        }
        catch (GenericEventException genericEventException) {
            this.mDb.getLogHandler().logError().append("Can't send selectStationStatus: ").append(genericEventException).log();
        }
    }

    public void updateRadioText2(RadioText[] radioTextArray, int n) {
    }

    @Override
    public void informationRadioText(RadioText radioText) {
    }

    @Override
    public void informationRadioText2(RadioText[] radioTextArray) {
        int n;
        if (null == radioTextArray) {
            return;
        }
        if (this.mDb.isPrepareStatus()) {
            ArrayList arrayList = new ArrayList();
            for (n = 0; n < radioTextArray.length; ++n) {
                if (null == radioTextArray[n]) continue;
                arrayList.add(radioTextArray[n]);
            }
            if (arrayList.size() > 0) {
                ASLTravelLinkAPI aSLTravelLinkAPI = ASLTravelLinkFactory.getTravelLinkApi();
                aSLTravelLinkAPI.updateRadioText(arrayList);
            }
        }
        this.mPool.setString(46, "UPDATE_RADIO_TEXT");
        for (int i2 = 0; i2 < radioTextArray.length; ++i2) {
            if (radioTextArray[i2] == null || (n = (int)radioTextArray[i2].getSID()) < 0) continue;
            StationInfo stationInfo = this.mPool.getChannel(15);
            this.mPool.setRadioText(13, radioTextArray[i2]);
            if (stationInfo.getSID() != radioTextArray[i2].getSID()) continue;
            this.mPool.setRadioText(14, radioTextArray[i2]);
        }
        SatDb.getInstance().getSeekApi().refreshAlertList();
    }

    @Override
    public void responseEPG24Hour(EPGShortInfo ePGShortInfo) {
    }

    @Override
    public void responseEPGDescription(EPGDescription ePGDescription) {
    }

    @Override
    public void informationEPGChannelList(EPGShortInfo[] ePGShortInfoArray) {
    }

    @Override
    public void informationChannelArt(ImageInformation[] imageInformationArray) {
        if (null != this.mDb.getChannels() && null != imageInformationArray) {
            this.mDb.getChannels().storeChannelArt(imageInformationArray);
        }
    }

    @Override
    public void informationBackgroundArt(ImageInformation[] imageInformationArray) {
    }

    @Override
    public void informationAlbumArt(ImageInformation[] imageInformationArray) {
    }

    @Override
    public void informationGenreArt(ImageInformation[] imageInformationArray) {
    }

    @Override
    public void informationStudioArt(ImageInformation[] imageInformationArray) {
    }

    @Override
    public void profileChanged(int n, int n2) {
    }

    @Override
    public void profileCopied(int n, int n2, int n3) {
    }

    @Override
    public void profileReset(int n, int n2) {
    }

    @Override
    public void profileResetAll(int n) {
    }

    @Override
    public void updateProfileState(int n, int n2, int n3) {
    }

    static {
        isMuteTimerOn = false;
    }
}

