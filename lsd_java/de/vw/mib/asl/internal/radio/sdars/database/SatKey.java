/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.database;

import de.vw.mib.asl.internal.radio.sat.transformer.SimilarContentCollector;
import de.vw.mib.asl.internal.radio.sdars.database.IAslPool;
import de.vw.mib.asl.internal.radio.sdars.database.IAslPoolRecord;
import de.vw.mib.asl.internal.radio.sdars.helper.SatConfig;
import generated.de.vw.mib.asl.internal.radio.sat.ASLRadioSATPropertyManager;

public class SatKey {
    public static final int DSI_AUDIOSTATUS;
    public static final int DSI_SUBSCRIPTIONSTATUS;
    public static final int DSI_ANTENNASTATUS;
    public static final int DSI_DEVICETYPE;
    public static final int DSI_AVAILABILITY;
    public static final int DSI_DATA_SUBSCRIPTION;
    public static final int DSI_DATA_UPDATE_STATUS;
    public static final int DSI_LIST_UPDATE_STATUS;
    public static final int DSI_LIST_UPDATE_PERCENTAGE;
    public static final int DSI_SUBSCRIPTION_UPDATE_STATUS;
    public static final int DSI_ITUNES_SXM_URL;
    public static final int DSI_AFFILIATE_ID;
    public static final int DSI_RADIO_TEXT;
    public static final int DSI_USER_RADIO_TEXT;
    public static final int DISPLAYED_CHANNEL;
    public static final int TUNE_RESPONSE_COUNTER;
    public static final int TUNE_RESULT;
    public static final int TUNED_CHANNEL_SID;
    public static final int TUNED_CHANNEL;
    public static final int SECOND;
    public static final int PLAYING_CHANNEL;
    public static final int PREVIEWED_CHANNEL;
    public static final int USER_CHANNEL;
    public static final int USER_FILTER_ACTIVE;
    public static final int DISPLAYED_CHANNEL_SHORT_DESCRIPTION;
    public static final int DISPLAYED_CHANNEL_LONG_DESCRIPTION;
    public static final int VIEW_SPELLER;
    public static final int SCAN;
    public static final int VIEW_LIST;
    public static final int VIEW_FILTER_LIST;
    public static final int NAME_DB;
    public static final int LAST_INVALID_CHANNEL_SID;
    public static final int SCOPE_OF_ARROW_KEYS;
    public static final int PERSISTENCE_DIRTY_FLAG;
    public static final int CHANNEL_FILTER_CHANGED;
    public static final int TUNER_ACTIVE;
    public static final int MAIN_HSM_STATE;
    public static final int LIST_HSM_STATE;
    public static final int DSI_HSM_STATE;
    public static final int TRAFFIC_HSM_STATE;
    public static final int EVENT_ACTIVATE;
    public static final int EVENT_DEACTIVATE;
    public static final int BOOT_MESSAGE;
    public static final int DSI_UPDATE;
    public static final int MODEL_SUBSCRIPTION_PHONE_NUMBER;
    public static final int MODEL_SUBSCRIPTION_REASON_CODE;
    public static final int MODEL_SUBSCRIPTION_REASON_TEXT;
    public static final int NO_SIGNAL_NO_ARTIST;
    public static final int DDS_USED_BY_DEBUG;
    public static final int DDS;
    public static final int DDS_PRESS;
    public static final int CHANNEL_LIST;
    public static final int SHOW_POPUP_SUBSCRIPTION_CHANGED;
    public static final int TIMEOUT_CHECK_RESPONSE;
    public static final int TIMEOUT_DSI_RESPONSE;
    public static final int TIMEOUT_SCAN;
    public static final int TIMEOUT_NO_SIGNAL_NO_ARTIST;
    public static final int TIMEOUT_SPELLER_ADVISORY;
    public static final int MUTE;
    public static final int MAIN_TARGET;
    public static final int PAINT;
    public static final int SCAN_INTERRUPTED_DUE_TO_STATUS;
    public static final int PRESET_LIST_UPDATED;
    public static final int TIMESTAMP_DSI;
    public static final int TIMESTAMP_HMI;
    public static final int RESET_COUNTER;
    public static final int NOTIFY_CATEGORY_LIST_UPDATED;
    public static final int CONFIG_DELETE_INVALID_PRESETS_ON_LISTUPDATE;
    public static final int TEMP_DISPLAY_CHANNEL_HANDLER;
    public static final int TEMP_DISPLAYED_CHANNEL;
    public static final int HIDE_TEMP_DISPLAY_CHANNEL;
    public static final int TEMP_DISPLAY_CHANNEL_TIMER_EVENT;
    public static final int NOTIFY_PRESET_STORED;
    public static final int NOTIFY_PRESET_DELETED;
    public static final int NOTIFY_PRESET_RECALL;
    public static final int AUDIO_OPENED_COUNTER;
    public static final int CHANNEL_VIA_DSI;
    public static final int STATUS_FUNCTIONAL_REACHED_COUNTER;
    public static final int LAST_UNSUBSCRIBED_CHANNEL_SID;
    public static final int TIME_AT_STARTUP;
    public static final int LAST_TUNE_ACTION;
    public static final int SDARS_ACTIVE_STATE;
    public static final int NEW_RADIO_TEXT_STORED;
    public static final int DSI_START;
    public static final int DSI_SEEK_POSSIBILITY;
    public static final int DSI_SEEK_LIST;
    public static final int DSI_LEAGUE_LIST;
    public static final int DSI_TEAM_LIST;
    public static final int DSI_TRAFFICWEATHER_LIST;
    public static final int DSI_SEEK_ALERT;
    public static final int DSI_RESPONSE_SEEK_COMMAND;
    public static final int DSI_RESPONSE_MANAGE_SEEK;
    public static final int DSI_SEEK_ASYNC_EXCEPTION;
    private static final int DEBUG_START;
    public static final int DEBUG_MUTE_FREQUENTLY;
    public static final int DEBUG_MUTE_ALWAYS;
    public static final int DEBUG_TIMEOUT_FORCE_MUTE;
    public static final int LOG;
    public static final int LOG_RECORD;
    private static final int MODEL_START;
    public static final int MODEL_SAT_CHANNEL_DESCRIPTION;
    public static final int MODEL_TEAM_A_STORABLE;
    public static final int MODEL_TEAM_B_STORABLE;
    public static final int MODEL_SPORT_PROGRAM;
    public static final int MODEL_SONG_STORABLE;
    public static final int MODEL_ARTIST_STORABLE;
    public static final int MODEL_SAT_CHANNEL_SHORT_NAME_TO_STORE_ON_PRESET;
    public static final int MODEL_TUNER_STATE;
    public static final int MODEL_VIRTUAL_CHANNEL_BROWSED_PLAYING;
    public static final int MODEL_PREVIEW_MODE;
    public static final int MODEL_SORTING;
    public static final int MODEL_VIEW_MODE;
    public static final int MODEL_SIRIUS_SEEK_ALERTS_ENABLED;
    public static final int MODEL_ACTIVE_CATEGORY_INDEX;
    public static final int MODEL_ACTIVE_CHANNEL_INDEX;
    public static final int MODEL_FIRST_SIRIUS_PRESET_BANK_WITH_EMPTY_ELEMENT;
    public static final int MODEL_INDEX_OF_ACTIVATED_SIRIUS_PRESET;
    public static final int MODEL_INDEX_OF_FIRST_OCCUPIED_SIRIUS_PRESET;
    public static final int MODEL_INDEX_OF_PRESET_BANK_SIRIUS;
    public static final int MODEL_CURRENT_TRAFFIC_MARKET_LONG_NAME;
    public static final int MODEL_CURRENT_TRAFFIC_MARKET_SHORT_NAME;
    public static final int MODEL_SAT_SHORT_CHANNEL_DESCRIPTION;
    public static final int MODEL_SIRIUS_ID;
    public static final int MODEL_STORE_ITEM_NAME;
    public static final int MODEL_INDEX_OF_SELECTED_TRAFFIC_MARKET;
    public static final int MODEL_SELECTION_STATE;
    public static final int MODEL_SUBSCRIPTION_INFO_AUDIO_EXPIRE_DATE_DAY;
    public static final int MODEL_SUBSCRIPTION_INFO_AUDIO_EXPIRE_DATE_MONTH;
    public static final int MODEL_SUBSCRIPTION_INFO_AUDIO_EXPIRE_DATE_YEAR;
    public static final int MODEL_SUBSCRIPTION_INFO_TRAFFIC_EXPIRE_DATE_DAY;
    public static final int MODEL_SUBSCRIPTION_INFO_TRAFFIC_EXPIRE_DATE_MONTH;
    public static final int MODEL_SUBSCRIPTION_INFO_TRAFFIC_EXPIRE_DATE_YEAR;
    public static final int MODEL_SUBSCRIPTION_STATE;
    public static final int MODEL_TRAFFIC_CHANEL_JUMP_STATE;
    public static final int MODEL_ALERT_LIST_NOT_EMPTY;
    public static final int MODEL_CHANNEL_FILTER_ACTIVATED;
    public static final int MODEL_SELECTED_TRAFFIC_MARKET_ON_AIR;
    public static final int MODEL_IS_DEBUG;
    public static final int MODEL_TRAFFIC_MARKET_LIST_UPDATING;
    public static final int MODEL_SIMILAR_CONTENT_LIST_NOT_EMPTY;
    public static final int MODEL_CHANNEL_ART_IMAGE;
    public static final int MODEL_SIMILAR_CHANNEL_LIST;
    public static final int MODEL_IS_SPELLER_CHANNEL_VALID;
    public static final int MODEL_SUBSCRIPTION_TRAFFIC_STATE;
    public static final int MODEL_IS_SIRIUS_SEEK_FEATURE_AVAILABLE;
    public static final int MODEL_TUNER_STATION_LIST_LOADED;
    public static final int MODEL_SIRIUS_URL;
    public static final int CHOSEN_TRAFFIC_MARKET;
    public static final int MODEL_TEAM_A_NAME;
    public static final int MODEL_TEAM_B_NAME;
    public static final int MODEL_DSI_SEEK_ALERT_LIST_AVAILABLE;
    public static final int SEEKID_CHOSEN_TRAFFIC_MARKET;
    public static final int MODEL_SUBSCRIPTION_STATE_GRAPHIC_WEATHER;
    public static final int MODEL_SUBSCRIPTION_STATE_TABULAR_WEATHER;
    public static final int MODEL_SUBSCRIPTION_STATE_FUEL_PRICE;
    public static final int MODEL_SUBSCRIPTION_STATE_MOVIE;
    public static final int MODEL_SUBSCRIPTION_STATE_SPORT;
    public static final int MODEL_ARTIST_OR_TEAMA_STORED;
    public static final int MODEL_TITLE_STORED;
    public static final int MODEL_TEAMB_STORED;
    public static final int MODEL_SXM_SEEK_ALERT_COUNT;
    public static final int MODEL_SXM_UNSUBSCRIBED_CHANNEL_INFO;
    public static final int MODEL_SXM_UNSUBSCRIBED_POPUP_TRIGGER;
    public static final int MODEL_DISABLE_ARTIST_SEEK_BUTTONS;
    public static final int MODEL_DISABLE_TRAFFIC_MARKET_BUTTONS;
    public static final int MODEL_DISABLE_SONG_SEEK_BUTTONS;
    public static final int MODEL_CHANNEL_FILTER_SELECTED_NONE;
    public static final int MODEL_ALL_CHANNELS_FILTERED;
    public static final int NOTIFY_TRAFFIC_SUBSCRIPTION_NAVI;
    public static final int STORED_SEEKSID_TO_REPLACE;
    public static final int STORED_SEEKTYPE_TO_REPLACE;
    public static final int SEEK_ALERT_LIST;
    public static final int MUTE_ON_TIMER;
    public static final int SORTED_CHANNEL_LIST;

    public static void initialize(IAslPool iAslPool) {
        IAslPoolRecord iAslPoolRecord = iAslPool.registerRecord(1, 1, "DsiAudioStatus");
        iAslPoolRecord.setInt(0);
        iAslPoolRecord = iAslPool.registerRecord(2, 1, "DsiSubscriptionStatus");
        iAslPoolRecord.setInt(0);
        iAslPoolRecord = iAslPool.registerRecord(3, 1, "DsiAntennaStatus");
        iAslPoolRecord.setInt(0);
        iAslPoolRecord = iAslPool.registerRecord(4, 1, "DsiDeviceType");
        iAslPoolRecord.setInt(0);
        iAslPoolRecord = iAslPool.registerRecord(5, 2, "DsiAvailability");
        iAslPoolRecord.setBoolean(false);
        iAslPoolRecord = iAslPool.registerRecord(6, 1, "DsiDataSubscription");
        iAslPoolRecord.setInt(0);
        iAslPoolRecord = iAslPool.registerRecord(7, 1, "DsiDataUpdateStatus");
        iAslPoolRecord.setInt(0);
        iAslPoolRecord = iAslPool.registerRecord(8, 1, "DsiListUpdateStatus");
        iAslPoolRecord.setInt(0);
        iAslPoolRecord = iAslPool.registerRecord(9, 1, "DsiListUpdatePercentage");
        iAslPoolRecord.setInt(0);
        iAslPoolRecord = iAslPool.registerRecord(10, 1, "DsiSubscriptionUpdateStatus");
        iAslPoolRecord.setInt(0);
        iAslPoolRecord = iAslPool.registerRecord(11, 3, "DsiiTunesSxmUrl");
        iAslPoolRecord.setString("");
        iAslPoolRecord = iAslPool.registerRecord(12, 3, "DsiAffiliateID");
        iAslPoolRecord.setString("1l3v43Q");
        iAslPoolRecord = iAslPool.registerRecord(13, 5, "DsiRadioText");
        iAslPoolRecord.setRadioText(null);
        iAslPoolRecord = iAslPool.registerRecord(85, 5, "NewRadioTextStored");
        iAslPoolRecord.setRadioText(null);
        iAslPoolRecord = iAslPool.registerRecord(14, 5, "DsiCurrentRadioText");
        iAslPoolRecord.setRadioText(null);
        iAslPoolRecord = iAslPool.registerRecord(15, 6, "DisplayedChannel");
        iAslPoolRecord.setChannel(SatConfig.DEFAULT_CHANNEL);
        iAslPoolRecord.enableNotificationsWithoutChange();
        iAslPoolRecord = iAslPool.registerRecord(16, 1, "TuneResponseCounter");
        iAslPoolRecord.setInt(0);
        iAslPoolRecord = iAslPool.registerRecord(17, 1, "TuneResult");
        iAslPoolRecord.setInt(0);
        iAslPoolRecord.setNameDbType(9);
        iAslPoolRecord = iAslPool.registerRecord(18, 1, "TunedChannelSID");
        iAslPoolRecord.setInt(0);
        iAslPoolRecord = iAslPool.registerRecord(19, 6, "TunedChannel");
        iAslPoolRecord.setChannel(SatConfig.DEFAULT_CHANNEL);
        iAslPoolRecord = iAslPool.registerRecord(20, 8, "Second");
        iAslPoolRecord.setLong(0L);
        iAslPoolRecord = iAslPool.registerRecord(21, 6, "PlayingChannel");
        iAslPoolRecord.setChannel(SatConfig.DEFAULT_CHANNEL);
        iAslPoolRecord = iAslPool.registerRecord(79, 6, "ChannelViaDsi");
        iAslPoolRecord.setChannel(SatConfig.DEFAULT_CHANNEL);
        iAslPoolRecord.enableNotificationsWithoutChange();
        iAslPoolRecord = iAslPool.registerRecord(22, 6, "PreviewedChannel");
        iAslPoolRecord = iAslPool.registerRecord(23, 6, "UserChannel");
        iAslPoolRecord.setChannel(SatConfig.DEFAULT_CHANNEL);
        iAslPoolRecord = iAslPool.registerRecord(24, 2, "UserFilterActive");
        iAslPoolRecord.setBoolean(false);
        iAslPoolRecord = iAslPool.registerRecord(25, 3, "DisplayedChannelShortDescription");
        iAslPoolRecord.setString("");
        iAslPoolRecord = iAslPool.registerRecord(26, 3, "DisplayedChannelLongDescription");
        iAslPoolRecord.setString("");
        iAslPoolRecord = iAslPool.registerRecord(29, 2, "ViewSpeller");
        iAslPoolRecord.setBoolean(false);
        iAslPoolRecord = iAslPool.registerRecord(30, 2, "Scan");
        iAslPoolRecord.setBoolean(false);
        iAslPoolRecord = iAslPool.registerRecord(31, 2, "ViewList");
        iAslPoolRecord.setBoolean(false);
        iAslPoolRecord = iAslPool.registerRecord(32, 2, "ViewFilterList");
        iAslPoolRecord.setBoolean(false);
        iAslPoolRecord = iAslPool.registerRecord(33, 10, "NameDb");
        iAslPoolRecord.setObject(null);
        iAslPoolRecord = iAslPool.registerRecord(34, 1, "LastInvalidChannelSID");
        iAslPoolRecord.setInt(0);
        iAslPoolRecord = iAslPool.registerRecord(35, 1, "ScopeOfArrowKeys");
        iAslPoolRecord.setInt(0);
        iAslPoolRecord = iAslPool.registerRecord(140, 3, "ModelSatChannelDescription");
        iAslPoolRecord.setString("");
        iAslPoolRecord = iAslPool.registerRecord(141, 2, "ModelTeamAStorable");
        iAslPoolRecord.setBoolean(false);
        iAslPoolRecord = iAslPool.registerRecord(142, 2, "ModelTeamBStorable");
        iAslPoolRecord.setBoolean(false);
        iAslPoolRecord = iAslPool.registerRecord(143, 2, "ModelSportProgram");
        iAslPoolRecord.setBoolean(false);
        iAslPoolRecord = iAslPool.registerRecord(144, 2, "ModelSongStorable");
        iAslPoolRecord.setBoolean(false);
        iAslPoolRecord = iAslPool.registerRecord(145, 2, "ModelArtistStorable");
        iAslPoolRecord.setBoolean(false);
        iAslPoolRecord = iAslPool.registerRecord(146, 3, "ModelSatChannelShortNameToStoreOnPreset");
        iAslPoolRecord.setString("");
        iAslPoolRecord = iAslPool.registerRecord(147, 1, "ModelTunerState");
        iAslPoolRecord.setInt(-1);
        iAslPoolRecord = iAslPool.registerRecord(148, 2, "ModelVirtualChannelBrowsedPlaying");
        iAslPoolRecord.setBoolean(false);
        iAslPoolRecord = iAslPool.registerRecord(149, 2, "ModelPreviewMode");
        iAslPoolRecord.setBoolean(false);
        iAslPoolRecord = iAslPool.registerRecord(150, 1, "Sorting");
        iAslPoolRecord.setInt(2);
        iAslPoolRecord = iAslPool.registerRecord(151, 1, "ModelViewMode");
        iAslPoolRecord.setInt(0);
        iAslPoolRecord = iAslPool.registerRecord(152, 2, "SiriusSeekAlertsEnabled");
        iAslPoolRecord.setBoolean(true);
        iAslPoolRecord = iAslPool.registerRecord(153, 1, "ModelActiveCategoryIndex");
        iAslPoolRecord.setInt(-1);
        iAslPoolRecord.enableNotificationsWithoutChange();
        iAslPoolRecord = iAslPool.registerRecord(154, 1, "ModelActiveChannelIndex");
        iAslPoolRecord.setInt(-1);
        iAslPoolRecord.enableNotificationsWithoutChange();
        iAslPoolRecord = iAslPool.registerRecord(155, 1, "ModelFirstSiriusPresetBankWithEmptyElement");
        iAslPoolRecord.setInt(0);
        iAslPoolRecord = iAslPool.registerRecord(156, 1, "ModelIndexOfActivatedSiriusPreset");
        iAslPoolRecord.setInt(-1);
        iAslPoolRecord = iAslPool.registerRecord(157, 1, "ModelIndexOfFirstOccupiedSiriusPreset");
        iAslPoolRecord.setInt(-1);
        iAslPoolRecord = iAslPool.registerRecord(158, 1, "ModelIndexOfPresetBankSirius");
        iAslPoolRecord.setInt(0);
        iAslPoolRecord = iAslPool.registerRecord(159, 3, "ModelCurrentTrafficMarketLongName");
        iAslPoolRecord.setString("");
        iAslPoolRecord = iAslPool.registerRecord(160, 3, "ModelCurrentTrafficMarketShortName");
        iAslPoolRecord.setString("");
        iAslPoolRecord = iAslPool.registerRecord(161, 3, "ModelSatShortChannelDescription");
        iAslPoolRecord.setString("");
        iAslPoolRecord = iAslPool.registerRecord(162, 3, "ModelSiriusId");
        iAslPoolRecord.setString("");
        iAslPoolRecord = iAslPool.registerRecord(163, 3, "ModelStoreItemName");
        iAslPoolRecord.setString("");
        iAslPoolRecord = iAslPool.registerRecord(164, 1, "ModelIndexOfSelectedTrafficMarket");
        iAslPoolRecord.setInt(-1);
        iAslPoolRecord = iAslPool.registerRecord(165, 1, "ModelSelectionState");
        iAslPoolRecord.setInt(1);
        iAslPoolRecord = iAslPool.registerRecord(166, 1, "ModelSubscriptionInfoAudioExpireDateDay");
        iAslPoolRecord.setInt(-1);
        iAslPoolRecord = iAslPool.registerRecord(167, 1, "ModelSubscriptionInfoAudioExpireDateMonth");
        iAslPoolRecord.setInt(-1);
        iAslPoolRecord = iAslPool.registerRecord(168, 1, "ModelSubscriptionInfoAudioExpireDateYear");
        iAslPoolRecord.setInt(-1);
        iAslPoolRecord = iAslPool.registerRecord(169, 1, "ModelSubscriptionInfoTrafficExpireDateDay");
        iAslPoolRecord.setInt(0);
        iAslPoolRecord = iAslPool.registerRecord(170, 1, "ModelSubscriptionInfoTrafficExpireDateMonth");
        iAslPoolRecord.setInt(0);
        iAslPoolRecord = iAslPool.registerRecord(171, 1, "ModelSubscriptionInfoTrafficExpireDateYear");
        iAslPoolRecord.setInt(0);
        iAslPoolRecord = iAslPool.registerRecord(172, 1, "ModelSubscriptionState");
        iAslPoolRecord.setInt(1);
        iAslPoolRecord = iAslPool.registerRecord(173, 1, "ModelTrafficChannelJumpState");
        iAslPoolRecord.setInt(0);
        iAslPoolRecord = iAslPool.registerRecord(190, 2, "ModelAlertListNotEmpty");
        iAslPoolRecord.setBoolean(false);
        iAslPoolRecord = iAslPool.registerRecord(174, 2, "ModelAlertListNotEmpty");
        iAslPoolRecord.setBoolean(false);
        iAslPoolRecord = iAslPool.registerRecord(175, 2, "ModelChannelFilterActivated");
        iAslPoolRecord.setBoolean(false);
        iAslPoolRecord = iAslPool.registerRecord(176, 2, "ModelSelectedTrafficMarketOnAir");
        iAslPoolRecord.setBoolean(false);
        iAslPoolRecord = iAslPool.registerRecord(177, 2, "ModelIsDebug");
        iAslPoolRecord.setBoolean(false);
        iAslPoolRecord = iAslPool.registerRecord(178, 2, "ModelTrafficMarketListUpdating");
        iAslPoolRecord.setBoolean(false);
        iAslPoolRecord = iAslPool.registerRecord(179, 2, "ModelSimilarContentListNotEmpty");
        iAslPoolRecord.setBoolean(false);
        iAslPoolRecord = iAslPool.registerRecord(180, 9, "ModelChannelArtImage");
        iAslPoolRecord.setResourceLocator(ASLRadioSATPropertyManager.CHANNEL_ART_IMAGE__DEFAULT_VALUE);
        iAslPoolRecord.enableNotificationsWithoutChange();
        iAslPoolRecord = iAslPool.registerRecord(36, 2, "PersistenceDirtyFlag");
        iAslPoolRecord.setBoolean(false);
        iAslPoolRecord = iAslPool.registerRecord(37, 2, "ChannelFilterChanged");
        iAslPoolRecord.setBoolean(false);
        iAslPoolRecord.enableNotificationsWithoutChange();
        iAslPoolRecord = iAslPool.registerRecord(181, 11, "ModelSimilarChannelList");
        iAslPoolRecord.setObjectArray(new SimilarContentCollector[0]);
        iAslPoolRecord.enableNotificationsWithoutChange();
        iAslPoolRecord = iAslPool.registerRecord(182, 2, "ModelIsSpellerChannelValid");
        iAslPoolRecord.setBoolean(false);
        iAslPoolRecord.enableNotificationsWithoutChange();
        iAslPoolRecord = iAslPool.registerRecord(38, 2, "TunerActive");
        iAslPoolRecord.setBoolean(false);
        iAslPoolRecord = iAslPool.registerRecord(39, 3, "MainHsmState");
        iAslPoolRecord.setString("");
        iAslPoolRecord = iAslPool.registerRecord(40, 3, "ListHsmState");
        iAslPoolRecord.setString("");
        iAslPoolRecord = iAslPool.registerRecord(41, 3, "DsiHsmState");
        iAslPoolRecord.setString("");
        iAslPoolRecord = iAslPool.registerRecord(42, 3, "TrafficHsmState");
        iAslPoolRecord.setString("");
        iAslPoolRecord = iAslPool.registerRecord(43, 12, "EventActivate");
        iAslPoolRecord.setEvent(null);
        iAslPoolRecord = iAslPool.registerRecord(44, 12, "EventDeactivate");
        iAslPoolRecord.setEvent(null);
        iAslPoolRecord = iAslPool.registerRecord(45, 3, "BootMessage");
        iAslPoolRecord.setString("");
        iAslPoolRecord = iAslPool.registerRecord(46, 3, "DsiUpdate");
        iAslPoolRecord.setString("");
        iAslPoolRecord.enableNotificationsWithoutChange();
        iAslPoolRecord = iAslPool.registerRecord(47, 3, "SubscriptionPhoneNumber");
        iAslPoolRecord.setString("");
        iAslPoolRecord = iAslPool.registerRecord(186, 3, "ModelSiriusURL");
        iAslPoolRecord.setString("");
        iAslPoolRecord = iAslPool.registerRecord(48, 1, "SubscriptionReasonCode");
        iAslPoolRecord.setInt(0);
        iAslPoolRecord = iAslPool.registerRecord(49, 3, "SubscriptionReasonText");
        iAslPoolRecord.setString("");
        iAslPoolRecord = iAslPool.registerRecord(183, 1, "SubscriptionTraffic");
        iAslPoolRecord.setInt(0);
        iAslPoolRecord = iAslPool.registerRecord(50, 2, "NoSignalNoArtist");
        iAslPoolRecord.setBoolean(false);
        iAslPoolRecord = iAslPool.registerRecord(51, 2, "DdsUsedByDebug");
        iAslPoolRecord.setBoolean(false);
        iAslPoolRecord = iAslPool.registerRecord(52, 1, "DDS");
        iAslPoolRecord.setInt(0);
        iAslPoolRecord.enableNotificationsWithoutChange();
        iAslPoolRecord = iAslPool.registerRecord(53, 1, "DdsPress");
        iAslPoolRecord.setInt(0);
        iAslPoolRecord.enableNotificationsWithoutChange();
        iAslPoolRecord = iAslPool.registerRecord(54, 11, "ChannelList");
        iAslPoolRecord.setObjectArray(null);
        iAslPoolRecord.enableNotificationsWithoutChange();
        iAslPoolRecord = iAslPool.registerRecord(55, 2, "ShowPopupSubscriptionChanged");
        iAslPoolRecord.setBoolean(false);
        iAslPoolRecord = iAslPool.registerRecord(56, 1, "TimeoutCheckResponse(4000)");
        iAslPoolRecord.setInt(0);
        iAslPoolRecord = iAslPool.registerRecord(57, 1, "TimeoutDsiResponse(7000)");
        iAslPoolRecord.setInt(0);
        iAslPoolRecord = iAslPool.registerRecord(58, 1, "TimeoutScan(8000)");
        iAslPoolRecord.setInt(0);
        iAslPoolRecord = iAslPool.registerRecord(59, 1, "TimeoutNoSignalNoArtist(30000)");
        iAslPoolRecord.setInt(0);
        iAslPoolRecord = iAslPool.registerRecord(60, 1, "TimeoutSpellerAdvisory(5000)");
        iAslPoolRecord.setInt(0);
        iAslPoolRecord = iAslPool.registerRecord(101, 10, "DsiSeekPossibility");
        iAslPoolRecord.setObject(null);
        iAslPoolRecord.enableNotificationsWithoutChange();
        iAslPoolRecord = iAslPool.registerRecord(102, 11, "DsiSeekList");
        iAslPoolRecord.setObjectArray(null);
        iAslPoolRecord.enableNotificationsWithoutChange();
        iAslPoolRecord = iAslPool.registerRecord(103, 11, "DsiLeagueList");
        iAslPoolRecord.setObjectArray(null);
        iAslPoolRecord.enableNotificationsWithoutChange();
        iAslPoolRecord = iAslPool.registerRecord(104, 11, "DsiTeamList");
        iAslPoolRecord.setObjectArray(null);
        iAslPoolRecord.enableNotificationsWithoutChange();
        iAslPoolRecord = iAslPool.registerRecord(105, 11, "DsiTrafficWeatherList");
        iAslPoolRecord.setObjectArray(null);
        iAslPoolRecord.enableNotificationsWithoutChange();
        iAslPoolRecord = iAslPool.registerRecord(106, 10, "DsiSeekAlert");
        iAslPoolRecord.setObject(null);
        iAslPoolRecord.enableNotificationsWithoutChange();
        iAslPoolRecord = iAslPool.registerRecord(107, 1, "DsiResponseSeekCommand");
        iAslPoolRecord.setInt(0);
        iAslPoolRecord.enableNotificationsWithoutChange();
        iAslPoolRecord = iAslPool.registerRecord(108, 1, "DsiResponseManageSeek");
        iAslPoolRecord.setInt(0);
        iAslPoolRecord.enableNotificationsWithoutChange();
        iAslPoolRecord = iAslPool.registerRecord(109, 10, "DsiSeekAsyncException");
        iAslPoolRecord.setObject(null);
        iAslPoolRecord.enableNotificationsWithoutChange();
        iAslPoolRecord = iAslPool.registerRecord(61, 2, "Mute");
        iAslPoolRecord.setBoolean(false);
        iAslPoolRecord = iAslPool.registerRecord(62, 10, "MainTarget");
        iAslPoolRecord.setObject(null);
        iAslPoolRecord = iAslPool.registerRecord(121, 2, "DebugMuteFrequently");
        iAslPoolRecord.setBoolean(false);
        iAslPoolRecord = iAslPool.registerRecord(122, 2, "DebugMuteAlways");
        iAslPoolRecord.setBoolean(false);
        iAslPoolRecord = iAslPool.registerRecord(123, 1, "DebugTimeoutForceMute");
        iAslPoolRecord.setInt(0);
        iAslPoolRecord = iAslPool.registerRecord(63, 1, "Paint");
        iAslPoolRecord.setInt(0);
        iAslPoolRecord = iAslPool.registerRecord(64, 2, "ScanInterruptedDueToStatus");
        iAslPoolRecord.setBoolean(false);
        iAslPoolRecord = iAslPool.registerRecord(65, 1, "PresetListUpdated");
        iAslPoolRecord.setInt(0);
        iAslPoolRecord = iAslPool.registerRecord(66, 8, "TimestampDSI");
        iAslPoolRecord.setLong(0L);
        iAslPoolRecord = iAslPool.registerRecord(67, 8, "TimestampHMI");
        iAslPoolRecord.setLong(0L);
        iAslPoolRecord = iAslPool.registerRecord(184, 2, "ModelSeekEnabled");
        iAslPoolRecord.setBoolean(true);
        iAslPoolRecord = iAslPool.registerRecord(185, 1, "ModelTunerStationListLoaded");
        iAslPoolRecord.setInt(0);
        iAslPoolRecord = iAslPool.registerRecord(68, 1, "ResetCounter");
        iAslPoolRecord.setInt(0);
        iAslPoolRecord = iAslPool.registerRecord(124, 10, "Log");
        iAslPoolRecord.setObject(null);
        iAslPoolRecord = iAslPool.registerRecord(125, 10, "LogRecord");
        iAslPoolRecord.setObject(null);
        iAslPoolRecord = iAslPool.registerRecord(69, 11, "DsiCategoryList");
        iAslPoolRecord.setObjectArray(null);
        iAslPoolRecord.enableNotificationsWithoutChange();
        iAslPoolRecord = iAslPool.registerRecord(70, 2, "ConfigDeleteInvalidPresetsOnListUpdate");
        boolean bl = Boolean.getBoolean("de.vw.mib.asl.internal.radio.sdars.delete_invalid_presets");
        iAslPoolRecord.setBoolean(bl);
        iAslPoolRecord = iAslPool.registerRecord(72, 6, "TempDisplayedChannel");
        iAslPoolRecord.setChannel(null);
        iAslPoolRecord.enableNotificationsWithoutChange();
        iAslPoolRecord = iAslPool.registerRecord(71, 10, "TempDisplayChannelHandler");
        iAslPoolRecord.setObject(null);
        iAslPoolRecord = iAslPool.registerRecord(73, 1, "HideTempDisplayChannel");
        iAslPoolRecord.setInt(0);
        iAslPoolRecord.enableNotificationsWithoutChange();
        iAslPoolRecord = iAslPool.registerRecord(74, 1, "TempDisplayChannelTimerEvent");
        iAslPoolRecord.setInt(0);
        iAslPoolRecord.enableNotificationsWithoutChange();
        iAslPoolRecord = iAslPool.registerRecord(75, 10, "NotifyPresetStored");
        iAslPoolRecord.setObject(null);
        iAslPoolRecord = iAslPool.registerRecord(76, 1, "NotifyPresetDeleted");
        iAslPoolRecord.setInt(-1);
        iAslPoolRecord = iAslPool.registerRecord(77, 10, "NotifyPresetRecall");
        iAslPoolRecord.setObject(null);
        iAslPoolRecord.enableNotificationsWithoutChange();
        iAslPoolRecord = iAslPool.registerRecord(78, 1, "AudioOpenedCounter");
        iAslPoolRecord.setInt(0);
        iAslPoolRecord = iAslPool.registerRecord(80, 1, "StatusFunctionalReachedCounter");
        iAslPoolRecord.setInt(0);
        iAslPoolRecord = iAslPool.registerRecord(81, 1, "LastUnsubscribedChannelSID");
        iAslPoolRecord.setInt(0);
        iAslPoolRecord = iAslPool.registerRecord(82, 8, "TimeAtStartup");
        iAslPoolRecord.setLong(0L);
        iAslPoolRecord = iAslPool.registerRecord(83, 1, "LastTuneAction");
        iAslPoolRecord.setInt(0);
        iAslPoolRecord = iAslPool.registerRecord(84, 2, "SDARS_ACTIVE_STATE");
        iAslPoolRecord.setBoolean(false);
        iAslPoolRecord = iAslPool.registerRecord(187, 10, "ChosenTrafficMarket");
        iAslPoolRecord.setObject(null);
        iAslPoolRecord.enableNotificationsWithoutChange();
        iAslPoolRecord = iAslPool.registerRecord(188, 3, "SeekTeamAName");
        iAslPoolRecord.setString("");
        iAslPoolRecord = iAslPool.registerRecord(189, 3, "SeekTeamBName");
        iAslPoolRecord.setString("");
        iAslPoolRecord = iAslPool.registerRecord(191, 1, "SeekIDChosenTrafficMarket");
        iAslPoolRecord.setInt(-1);
        iAslPoolRecord = iAslPool.registerRecord(192, 1, "SubscriptionStateGraphicWeather");
        iAslPoolRecord.setInt(-1);
        iAslPoolRecord.enableNotificationsWithoutChange();
        iAslPoolRecord = iAslPool.registerRecord(193, 1, "SubscriptionStateTabularWeather");
        iAslPoolRecord.setInt(-1);
        iAslPoolRecord.enableNotificationsWithoutChange();
        iAslPoolRecord = iAslPool.registerRecord(194, 1, "SubscriptionStateFuelPrice");
        iAslPoolRecord.setInt(-1);
        iAslPoolRecord.enableNotificationsWithoutChange();
        iAslPoolRecord = iAslPool.registerRecord(195, 1, "SubscriptionStateMovie");
        iAslPoolRecord.setInt(-1);
        iAslPoolRecord.enableNotificationsWithoutChange();
        iAslPoolRecord = iAslPool.registerRecord(196, 1, "SubscriptionStateSport");
        iAslPoolRecord.setInt(-1);
        iAslPoolRecord.enableNotificationsWithoutChange();
        iAslPoolRecord = iAslPool.registerRecord(197, 2, "TeamAorArtistStored");
        iAslPoolRecord.setBoolean(false);
        iAslPoolRecord = iAslPool.registerRecord(198, 2, "TitleStored");
        iAslPoolRecord.setBoolean(false);
        iAslPoolRecord = iAslPool.registerRecord(199, 2, "TeamBStored");
        iAslPoolRecord.setBoolean(false);
        iAslPoolRecord = iAslPool.registerRecord(200, 1, "SXMSeekAlertCount");
        iAslPoolRecord.setInt(0);
        iAslPoolRecord = iAslPool.registerRecord(201, 3, "UnsubscribedChannelInfo");
        iAslPoolRecord.setString("");
        iAslPoolRecord = iAslPool.registerRecord(202, 2, "UnsubscribedPopupTrigger");
        iAslPoolRecord.setBoolean(false);
        iAslPoolRecord = iAslPool.registerRecord(203, 2, "DisableSeekButtons");
        iAslPoolRecord.setBoolean(false);
        iAslPoolRecord = iAslPool.registerRecord(205, 2, "DisableSeekButtons");
        iAslPoolRecord.setBoolean(false);
        iAslPoolRecord = iAslPool.registerRecord(204, 2, "DisableTrafficMarketButtons");
        iAslPoolRecord.setBoolean(false);
        iAslPoolRecord = iAslPool.registerRecord(206, 2, "ChannelFilterSelectedNone");
        iAslPoolRecord.setBoolean(false);
        iAslPoolRecord = iAslPool.registerRecord(207, 2, "AllChannelsFiltered");
        iAslPoolRecord.setBoolean(false);
        iAslPoolRecord = iAslPool.registerRecord(208, 1, "NotifySDARSTrafficSubscriptionToNavi");
        iAslPoolRecord.setInt(-1);
        iAslPoolRecord = iAslPool.registerRecord(209, 1, "SeekSIDToReplace");
        iAslPoolRecord.setInt(-1);
        iAslPoolRecord = iAslPool.registerRecord(210, 1, "SeekTypeToReplace");
        iAslPoolRecord.setInt(-1);
        iAslPoolRecord = iAslPool.registerRecord(211, 11, "DSISeekAlertList");
        iAslPoolRecord.setObjectArray(null);
        iAslPoolRecord.enableNotificationsWithoutChange();
        iAslPoolRecord = iAslPool.registerRecord(212, 2, "MuteOnTimer");
        iAslPoolRecord.setBoolean(false);
        iAslPoolRecord = iAslPool.registerRecord(213, 11, "SortedChannelList");
        iAslPoolRecord.setObjectArray(null);
        iAslPoolRecord.enableNotificationsWithoutChange();
    }
}

