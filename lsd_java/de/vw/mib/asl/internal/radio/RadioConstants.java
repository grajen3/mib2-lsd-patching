/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio;

import de.vw.mib.asl.api.radio.IRadioConstants;
import de.vw.mib.asl.internal.radio.amfm.common.AmFmStation;
import java.text.DecimalFormat;
import org.dsi.ifc.radio.FrequencyInfo;
import org.dsi.ifc.radio.ServiceInfo;
import org.dsi.ifc.radio.Station;
import org.dsi.ifc.radio.TIMMessage;
import org.dsi.ifc.radio.WavebandInfo;

public final class RadioConstants
implements IRadioConstants {
    public static final int SERVICE_ID_FOR_ANALOG_STATION;
    public static final int TUNER_UNDEFINED;
    public static final int TUNER_AMFM;
    public static final int TUNER_DAB;
    public static final int NO_OF_PRESET_BANKS;
    public static int[] AMFM_RT_PLUS_TAGS;
    public static int PRESETS_PER_BANK;
    public static final int EMERGENCY_THRESHOLD;
    public static final int SKIP_NEXT;
    public static final int SKIP_PREV;
    public static final int UP;
    public static final int DOWN;
    public static final int DIRECTION_UNDEFINED;
    public static final int INIT_INVALID_HDSTRUCT;
    public static final int AM_BAND_START;
    public static final int AM_BAND_START_NAR;
    static final int SUBSCRIPTION;
    public static final AmFmStation AM_DEFAULT_STATION;
    public static final WavebandInfo FM_BANDRANGE_EU_RDW;
    public static final int FM_BANDRANGE_EU_RDW_CONST;
    public static final AmFmStation FM_DEFAULT_STATION_EU_RDW;
    public static final ServiceInfo DAB_DEFAULT_SERVICE;
    public static final FrequencyInfo DAB_BAND_START;
    public static final ServiceInfo DAB_DEFAULT_SERVICE_REAL;
    public static final TIMMessage[] DEFAULT_TP_MEMO;
    public static final int BAND_OFF;
    public static final int EU_BAND_III_N;
    public static final int EU_BAND_III;
    public static final int CANADA_LBAND;
    public static final int KOREA_BAND_III;
    public static final int CHINA_BAND_III;
    public static final int NEWZEALAND_BAND_III;
    public static final int L_BAND;
    public static final int BAND_UNKNOWN;
    public static final int AM_BANDRANGE_UNDEFINED;
    public static final WavebandInfo AM_BANDRANGE_EU_RDW;
    public static final WavebandInfo AM_BANDRANGE_NAR;
    public static final WavebandInfo AM_BANDRANGE_JP;
    public static final WavebandInfo AM_BANDRANGE_EU_LW;
    public static final int AM_BANDRANGE_EU_LW_CONST;
    public static final WavebandInfo AM_BANDRANGE_AUS;
    public static final WavebandInfo AM_BANDRANGE_EU;
    public static final int FM_BANDRANGE_UNDEFINED;
    public static final WavebandInfo FM_BANDRANGE_NAR;
    public static final int FM_BANDRANGE_NAR_CONST;
    public static final AmFmStation FM_DEFAULT_STATION_NAR;
    public static final AmFmStation AM_DEFAULT_STATION_NAR;
    public static final WavebandInfo FM_BANDRANGE_JP;
    public static final int FM_BANDRANGE_JP_CONST;
    public static final WavebandInfo FM_BANDRANGE_KOR;
    public static final int FM_BANDRANGE_KOR_CONST;
    public static final WavebandInfo FM_BANDRANGE_CHINA;
    public static final int FM_BANDRANGE_CHINA_CONST;
    public static final WavebandInfo FM_BANDRANGE_JP_EXTENDED;
    public static final int FM_BANDRANGE_JP_EXTENDED_CONST;
    public static final int INVALID_ENSEMBLE_ID;
    public static final long INVALID_SERVICE_ID;
    public static final int INVALID_ENSEMBLE_ECC;
    public static final int INVALID_SCIDI;
    public static final long INVALID_FREQUENCY;
    public static final int INVALID_DSI_INDEX;
    public static final int START_FREQ_INDEX;
    public static final DecimalFormat DAB_DUMMY_NO_FORMATTER;
    public static final String DAB_DUMMY_ENSEMBLE_NAME_LONG;
    public static final String DAB_DUMMY_ENSEMBLE_NAME_SHORT;
    public static final String DAB_DUMMY_SERVICE_NAME_LONG;
    public static final String DAB_DUMMY_SERVICE_NAME_SHORT;
    public static final String DAB_DUMMY_COMPONENT_NAME_LONG;
    public static final String DAB_DUMMY_COMPONENT_NAME_SHORT;
    public static final int TIMEOUT_SLS_SIGNAL_LOST;
    public static final int TIMEOUT_RT_CLEAR_AFTER_SYNC_LOST;
    public static final int TIMEOUT_ENSEMBLE_INVALID;
    public static final int PI_BIT_SIZE;
    public static final int FREQUENCY_BIT_SIZE;
    public static final int CHANNEL_NUMBER_BIT_SIZE;
    public static final int STATION_ID_TYPE_BIT_SIZE;
    public static final String EMPTY_STRING;
    public static final int MANUAL_PICTURE_STORE_CONTEXT_ID_AM_FM;
    public static final int MANUAL_PICTURE_STORE_CONTEXT_ID_DAB;
    public static final int GENERIC_STATION_LOGO_FREQUENCY;
    public static final int STATION_LOGO_TYPE_NOT_AVAILABLE;
    public static final int STATION_LOGO_TYPE_MANUAL;
    public static final int STATION_LOGO_TYPE_DATABASE_USER_SELECTED;
    public static final int STATION_LOGO_TYPE_DATABASE_HOME_COUNTRY;
    public static final int STATION_LOGO_TYPE_DATABASE_NEIGHBORING_COUNTRY;
    public static final int STATION_LOGO_TYPE_DATABASE_GENERIC;
    public static final int AUTO_HOME_COUNTRY_CALCULATION;

    private RadioConstants() {
    }

    static {
        AMFM_RT_PLUS_TAGS = new int[]{4, 1};
        PRESETS_PER_BANK = 5;
        AM_DEFAULT_STATION = new AmFmStation(new Station("", 0, 0, 0, 0, 3, false, false, false, false, false, false, "", false, "", "", false, 0, 1, false, false, null));
        FM_BANDRANGE_EU_RDW = new WavebandInfo(1, 0, 0, 0, 0);
        FM_DEFAULT_STATION_EU_RDW = new AmFmStation(1, (int)FM_BANDRANGE_EU_RDW.getLowerLimit());
        DAB_DEFAULT_SERVICE = new ServiceInfo(0, 0, 0L, "Station", "Station", new byte[8], false, false);
        DAB_BAND_START = new FrequencyInfo(0, "5A");
        DAB_DEFAULT_SERVICE_REAL = new ServiceInfo(4099, 0, 0, "DEAU", "DEUTSCHLANDFUNK", null, false, false);
        DEFAULT_TP_MEMO = new TIMMessage[]{new TIMMessage("", 0, 0L, 0, 0, 0, 0, 0, 0, 0, 0, 0)};
        AM_BANDRANGE_EU_RDW = new WavebandInfo(3, 0, 0, 0, 0);
        AM_BANDRANGE_NAR = new WavebandInfo(3, 0, 0, 0, 0);
        AM_BANDRANGE_JP = new WavebandInfo(3, 0, 0, 0, 0);
        AM_BANDRANGE_EU_LW = new WavebandInfo(3, 0, 0, 0, 0);
        AM_BANDRANGE_AUS = new WavebandInfo(3, 0, 0, 0, 0);
        AM_BANDRANGE_EU = new WavebandInfo(3, 0, 0, 0, 0);
        FM_BANDRANGE_NAR = new WavebandInfo(1, 0, 0, 0, 0);
        FM_DEFAULT_STATION_NAR = new AmFmStation(1, (int)FM_BANDRANGE_NAR.getLowerLimit());
        AM_DEFAULT_STATION_NAR = new AmFmStation(new Station("", RadioConstants.AM_BANDRANGE_NAR.lowerLimit, 0, 0, 0, 3, false, false, false, false, false, false, "", false, "", "", false, 0, 1, false, false, null));
        FM_BANDRANGE_JP = new WavebandInfo(1, 0, 0, 0, 0);
        FM_BANDRANGE_KOR = new WavebandInfo(1, 0, 0, 0, 0);
        FM_BANDRANGE_CHINA = new WavebandInfo(1, 0, 0, 0, 0);
        FM_BANDRANGE_JP_EXTENDED = new WavebandInfo(1, 0, 0, 0, 0);
        DAB_DUMMY_NO_FORMATTER = new DecimalFormat("00");
    }
}

