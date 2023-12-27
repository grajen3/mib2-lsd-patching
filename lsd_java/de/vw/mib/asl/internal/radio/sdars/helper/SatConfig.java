/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.helper;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.sdars.helper.ChannelFilter;
import de.vw.mib.asl.internal.radio.sdars.helper.ChannelFilterDefaultChannel;
import de.vw.mib.asl.internal.radio.sdars.helper.ChannelFilterSubscription;
import de.vw.mib.asl.internal.radio.sdars.helper.ChannelFilterValidity;
import de.vw.mib.asl.internal.radio.sdars.helper.ChannelFilterZeroChannel;
import de.vw.mib.asl.internal.radio.sdars.helper.ComparatorChannelCategory;
import de.vw.mib.asl.internal.radio.sdars.helper.ComparatorChannelFulllabel;
import de.vw.mib.asl.internal.radio.sdars.helper.ComparatorChannelNumber;
import java.util.Comparator;
import org.dsi.ifc.sdars.CategoryInfo;
import org.dsi.ifc.sdars.StationInfo;

public final class SatConfig {
    public static int mMaxPresetBanks = 3;
    public static int mMaxPresetsPerBank = ServiceManager.configManagerDiag.getTUNERFirstItemPresetBank2();
    public static final int MAX_CHANNEL_NO;
    public static final int MAX_CHANNELS;
    public static final short INVALID_CATEGORY_NO;
    public static final int INVALID_INDEX;
    public static final short DEFAULT_CHANNEL_NO;
    public static final int DEFAULT_CHANNEL_SID;
    public static final int DEFAULT_CHANNEL_SUBSCRIPTION;
    public static final String DEFAULT_CHANNEL_NAME;
    public static final short CAT_NO_DEFAULT_CHANNEL;
    public static final short ZERO_CHANNEL_NO;
    public static final short ZERO_CHANNEL_SID;
    public static final String ZERO_CHANNEL_NAME;
    public static final String ZERO_CHANNEL_ARTIST_NAME;
    public static final short CAT_NO_ZERO_CHANNEL;
    public static final short CAT_NO_SIMILAR_CHANNEL;
    public static int TIMEOUT_CHECK_PLAYING_CHANNEL;
    public static int TIMEOUT_DSI_RESPONSE_SELECT_STATION;
    public static int TIMEOUT_SCAN;
    public static int TIMEOUT_NO_SIGNAL_NO_ARTIST;
    public static int TIMEOUT_SPELLER_ADVISORY;
    public static int TIMEOUT_SELECT_STATION_BEFORE_FIRST_AUDIO;
    public static boolean mShowEmptyCategories;
    public static boolean mShowUnsubscribed;
    public static boolean mShowEveryChannel;
    public static boolean DEFAULT_SEEK_ENABLED;
    public static final String PHONENUMBER;
    public static final String SIRIUSURL;
    public static final String AFFILIATEID;
    public static boolean mDefaultUseLateRtNotification;
    public static final ChannelFilter FILTER_VALIDITY;
    public static final ChannelFilter FILTER_SUBSCRIPTION;
    public static final ChannelFilter FILTER_CHANNEL_ZERO;
    public static final ChannelFilter FILTER_CHANNEL_DEFAULT;
    public static final Comparator COMP_NAME;
    public static final Comparator COMP_NO;
    public static final Comparator COMP_CATEGORY;
    public static final CategoryInfo CATEGORY_ZERO;
    public static final StationInfo ZERO_CHANNEL;
    public static final StationInfo DEFAULT_CHANNEL;
    public static final CategoryInfo CATEGORY_SIMILAR;

    private SatConfig() {
    }

    static {
        TIMEOUT_CHECK_PLAYING_CHANNEL = 0;
        TIMEOUT_DSI_RESPONSE_SELECT_STATION = 1000;
        TIMEOUT_SCAN = 8000;
        TIMEOUT_NO_SIGNAL_NO_ARTIST = 30000;
        TIMEOUT_SPELLER_ADVISORY = 5000;
        TIMEOUT_SELECT_STATION_BEFORE_FIRST_AUDIO = -1059847936;
        mShowEmptyCategories = false;
        mShowUnsubscribed = false;
        mShowEveryChannel = false;
        DEFAULT_SEEK_ENABLED = false;
        mDefaultUseLateRtNotification = true;
        FILTER_VALIDITY = new ChannelFilterValidity();
        FILTER_SUBSCRIPTION = new ChannelFilterSubscription();
        FILTER_CHANNEL_ZERO = new ChannelFilterZeroChannel();
        FILTER_CHANNEL_DEFAULT = new ChannelFilterDefaultChannel();
        COMP_NAME = new ComparatorChannelFulllabel();
        COMP_NO = new ComparatorChannelNumber();
        COMP_CATEGORY = new ComparatorChannelCategory();
        CATEGORY_ZERO = new CategoryInfo(10000, "Channel 0", "Channel 0");
        ZERO_CHANNEL = new StationInfo(0, 0, "Channel 0", "Channel 0", 0, 10000, false, null);
        DEFAULT_CHANNEL = new StationInfo(1, 1, "Preview", "Preview", 2, 1, false, null);
        CATEGORY_SIMILAR = new CategoryInfo(10001, "Similar content", "Similar content");
    }
}

