/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.vicsetc.setup;

public interface ASLVICSETCSetupPropertyManager {
    public static final int CARD_READER_INFORMATION__CARD_READER_INFORMATION_MESSAGE_TYPE_NAME;
    public static final String CARD_READER_INFORMATION__CARD_READER_INFORMATION_MESSAGE_TYPE_NAME__DEFAULT_VALUE;
    public static final int CARD_READER_INFORMATION__CARD_READER_INFORMATION_MESSAGE_MANUFACTURER_NAME;
    public static final String CARD_READER_INFORMATION__CARD_READER_INFORMATION_MESSAGE_MANUFACTURER_NAME__DEFAULT_VALUE;
    public static final int CARD_READER_INFORMATION__CARD_READER_INFORMATION_IDENTIFICATION_NUMBER;
    public static final String CARD_READER_INFORMATION__CARD_READER_INFORMATION_IDENTIFICATION_NUMBER__DEFAULT_VALUE;
    public static final int CARD_READER_INFORMATION__CARD_READER_INFORMATION_MESSAGE_REGISTERED_NAME;
    public static final String CARD_READER_INFORMATION__CARD_READER_INFORMATION_MESSAGE_REGISTERED_NAME__DEFAULT_VALUE;
    public static final int CARD_READER_INFORMATION__CARD_READER_INFORMATION_MESSAGE_SERIAL_PRODUCTION_NUMBER;
    public static final String CARD_READER_INFORMATION__CARD_READER_INFORMATION_MESSAGE_SERIAL_PRODUCTION_NUMBER__DEFAULT_VALUE;
    public static final int SETUP_VICS_STATION_INFORMATION__SETUP_VICS_STATION_INFORMATION_RECEPTION_STATUS;
    public static final int SETUP_VICS_STATION_INFORMATION__SETUP_VICS_STATION_INFORMATION_RECEPTION_STATUS__DEFAULT_VALUE;
    public static final int SETUP_VICS_STATION_INFORMATION__SETUP_VICS_STATION_INFORMATION_RECEPTION_STATUS__C0_NOT_RECEIVED;
    public static final int SETUP_VICS_STATION_INFORMATION__SETUP_VICS_STATION_INFORMATION_RECEPTION_STATUS__C1_DETECTING;
    public static final int SETUP_VICS_STATION_INFORMATION__SETUP_VICS_STATION_INFORMATION_RECEPTION_STATUS__C2_RECEIVED;
    public static final int SETUP_VICS_STATION_INFORMATION__SETUP_VICS_STATION_INFORMATION_SELECTED_PREFECTURE;
    public static final String SETUP_VICS_STATION_INFORMATION__SETUP_VICS_STATION_INFORMATION_SELECTED_PREFECTURE__DEFAULT_VALUE;
    public static final int SETUP_VICS_STATION_INFORMATION__SETUP_VICS_STATION_INFORMATION_RECEIVED_FREQUENCY;
    public static final String SETUP_VICS_STATION_INFORMATION__SETUP_VICS_STATION_INFORMATION_RECEIVED_FREQUENCY__DEFAULT_VALUE;
    public static final int SETUP_VICS_STATION_INFORMATION__SETUP_VICS_STATION_INFORMATION_ONLINE_VICS_STATUS;
    public static final int SETUP_VICS_STATION_INFORMATION__SETUP_VICS_STATION_INFORMATION_ONLINE_VICS_STATUS__DEFAULT_VALUE;
    public static final int SETUP_VICS_STATION_INFORMATION__SETUP_VICS_STATION_INFORMATION_ONLINE_VICS_STATUS__C0_ACTIVATED;
    public static final int SETUP_VICS_STATION_INFORMATION__SETUP_VICS_STATION_INFORMATION_ONLINE_VICS_STATUS__C1_DEACTIVATED;
    public static final int SETUP_VICS_STATION_INFORMATION__SETUP_VICS_STATION_INFORMATION_RECEPTION_MODE;
    public static final int SETUP_VICS_STATION_INFORMATION__SETUP_VICS_STATION_INFORMATION_RECEPTION_MODE__DEFAULT_VALUE;
    public static final int SETUP_VICS_STATION_INFORMATION__SETUP_VICS_STATION_INFORMATION_RECEPTION_MODE__C0_AUTOMATIC;
    public static final int SETUP_VICS_STATION_INFORMATION__SETUP_VICS_STATION_INFORMATION_RECEPTION_MODE__C1_MANUAL;
    public static final int ACTION_RESULT;
    public static final int ACTION_RESULT__DEFAULT_VALUE;
    public static final int ACTION_RESULT__C0_OK;
    public static final int ACTION_RESULT__C1_ERROR;
    public static final int VICS_EVENT_NOTICE_MAP_ACTIVE;
    public static final boolean VICS_EVENT_NOTICE_MAP_ACTIVE__DEFAULT_VALUE;
    public static final boolean VICS_EVENT_NOTICE_MAP_ACTIVE__C0_FALSE;
    public static final boolean VICS_EVENT_NOTICE_MAP_ACTIVE__C1_TRUE;
    public static final int DATA_UPLOAD_ACTIVE;
    public static final boolean DATA_UPLOAD_ACTIVE__DEFAULT_VALUE;
    public static final boolean DATA_UPLOAD_ACTIVE__C0_FALSE;
    public static final boolean DATA_UPLOAD_ACTIVE__C1_TRUE;
    public static final int TOLL_FEE_POPUP_ACTIVE;
    public static final boolean TOLL_FEE_POPUP_ACTIVE__DEFAULT_VALUE;
    public static final boolean TOLL_FEE_POPUP_ACTIVE__C0_FALSE;
    public static final boolean TOLL_FEE_POPUP_ACTIVE__C1_TRUE;
    public static final int TOLL_FEE_ANNOUNCEMENT_ACTIVE;
    public static final boolean TOLL_FEE_ANNOUNCEMENT_ACTIVE__DEFAULT_VALUE;
    public static final boolean TOLL_FEE_ANNOUNCEMENT_ACTIVE__C0_FALSE;
    public static final boolean TOLL_FEE_ANNOUNCEMENT_ACTIVE__C1_TRUE;
    public static final int ETC_CARD_NOT_INSERTED_ACTIVE;
    public static final boolean ETC_CARD_NOT_INSERTED_ACTIVE__DEFAULT_VALUE;
    public static final boolean ETC_CARD_NOT_INSERTED_ACTIVE__C0_FALSE;
    public static final boolean ETC_CARD_NOT_INSERTED_ACTIVE__C1_TRUE;
    public static final int ETC_CARD_REMINDER_ACTIVE;
    public static final boolean ETC_CARD_REMINDER_ACTIVE__DEFAULT_VALUE;
    public static final boolean ETC_CARD_REMINDER_ACTIVE__C0_FALSE;
    public static final boolean ETC_CARD_REMINDER_ACTIVE__C1_TRUE;
    public static final int POPUP_DURATION_TIME;
    public static final int POPUP_DURATION_TIME__DEFAULT_VALUE;
    public static final int POPUP_DURATION_TIME__C0_FIVE;
    public static final int POPUP_DURATION_TIME__C1_TEN;
    public static final int POPUP_DURATION_TIME__C2_FIFTEEN;
    public static final int POPUP_VICS_BEACON_MESSAGES;
    public static final boolean POPUP_VICS_BEACON_MESSAGES__DEFAULT_VALUE;
    public static final boolean POPUP_VICS_BEACON_MESSAGES__C0_FALSE;
    public static final boolean POPUP_VICS_BEACON_MESSAGES__C1_TRUE;
    public static final int POPUP_VICS_BEACON_GRAPHICS;
    public static final boolean POPUP_VICS_BEACON_GRAPHICS__DEFAULT_VALUE;
    public static final boolean POPUP_VICS_BEACON_GRAPHICS__C0_FALSE;
    public static final boolean POPUP_VICS_BEACON_GRAPHICS__C1_TRUE;
    public static final int POPUP_ETC_DRIVING_SUPPORT;
    public static final boolean POPUP_ETC_DRIVING_SUPPORT__DEFAULT_VALUE;
    public static final boolean POPUP_ETC_DRIVING_SUPPORT__C0_FALSE;
    public static final boolean POPUP_ETC_DRIVING_SUPPORT__C1_TRUE;
    public static final int POPUP_ETC_TRAFFIC_INFORMATION;
    public static final boolean POPUP_ETC_TRAFFIC_INFORMATION__DEFAULT_VALUE;
    public static final boolean POPUP_ETC_TRAFFIC_INFORMATION__C0_FALSE;
    public static final boolean POPUP_ETC_TRAFFIC_INFORMATION__C1_TRUE;
    public static final int POPUP_ETC_TRAFFIC_ANNOUNCEMENT;
    public static final boolean POPUP_ETC_TRAFFIC_ANNOUNCEMENT__DEFAULT_VALUE;
    public static final boolean POPUP_ETC_TRAFFIC_ANNOUNCEMENT__C0_FALSE;
    public static final boolean POPUP_ETC_TRAFFIC_ANNOUNCEMENT__C1_TRUE;
    public static final int MESSAGE_AVAILABLE;
    public static final boolean MESSAGE_AVAILABLE__DEFAULT_VALUE;
    public static final boolean MESSAGE_AVAILABLE__C0_FALSE;
    public static final boolean MESSAGE_AVAILABLE__C1_TRUE;
    public static final int SETUP_VICS_PREFECTURE_LIST;
    public static final String SETUP_VICS_PREFECTURE_LIST__DEFAULT_VALUE;
}

