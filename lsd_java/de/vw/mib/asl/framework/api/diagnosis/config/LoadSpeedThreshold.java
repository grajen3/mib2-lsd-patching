/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.api.diagnosis.config;

import de.vw.mib.asl.framework.api.diagnosis.config.Access;

public interface LoadSpeedThreshold
extends Access {
    public static final int ID_VIDEO_CUTOFF_THRESHOLD;
    public static final int ID_VIDEO_HYSTERESIS;
    public static final int ID_CARMENU_CUTOFF_THRESHOLD;
    public static final int ID_CARMENU_HYSTERESIS;
    public static final int ID_SLIDESHOW_CUTOFF_THRESHOLD;
    public static final int ID_SLIDESHOW_HYSTERESIS;
    public static final int ID_SLIDESHOW_DISPLAY_DURATION1;
    public static final int ID_SLIDESHOW_DISPLAY_DURATION2;
    public static final int ID_BOARDBOOK_CUTOFF_THRESHOLD;
    public static final int ID_BOARDBOOK_HYSTERESIS;
    public static final int ID_TRAVEL_GUIDE_CUTOFF_THRESHOLD;
    public static final int ID_TRAVEL_GUIDE_HYSTERESIS;
    public static final int ID_BROADCAST_WEBSITE_CUTOFF_THRESHOLD;
    public static final int ID_BROADCAST_WEBSITE_HYSTERESIS;
    public static final int ID_DESTINATION_INPUT_CUTOFF_THRESHOLD;
    public static final int ID_DESTINATION_INPUT_HYSTERESIS;
    public static final int ID_BT_BONDING_CUTOFF_THRESHOLD;
    public static final int ID_BT_BONDING_HYSTERESIS;
    public static final int ID_MESSAGING_TEXT_EDITOR_CUTOFF_THRESHOLD;
    public static final int ID_MESSAGING_TEXT_EDITOR_HYSTERESIS;
    public static final int ID_RADIOTEXT_TOOLTIP_CUTOFF_THRESHOLD;
    public static final int ID_RADIOTEXT_TOOLTIP_HYSTERESIS;
    public static final int ID_RADIOTEXT_TOOLTIP_DISPLAY_DURATION;
    public static final int BOARDBOOK_CUTOFF_THRESHOLD_ALWAYS_ACTIVE;
    public static final int BOARDBOOK_CUTOFF_THRESHOLD_OFF;
    public static final int BROADCAST_WEBSITE_CUTOFF_THRESHOLD_ALWAYS_ACTIVE;
    public static final int BROADCAST_WEBSITE_CUTOFF_THRESHOLD_OFF;
    public static final int BT_BONDING_CUTOFF_THRESHOLD_ALWAYS_ACTIVE;
    public static final int BT_BONDING_CUTOFF_THRESHOLD_OFF;
    public static final int CARMENU_CUTOFF_THRESHOLD_ALWAYS_ACTIVE;
    public static final int CARMENU_CUTOFF_THRESHOLD_OFF;
    public static final int DESTINATION_INPUT_CUTOFF_THRESHOLD_ALWAYS_ACTIVE;
    public static final int DESTINATION_INPUT_CUTOFF_THRESHOLD_OFF;
    public static final int MESSAGING_TEXT_EDITOR_CUTOFF_THRESHOLD_ALWAYS_ACTIVE;
    public static final int MESSAGING_TEXT_EDITOR_CUTOFF_THRESHOLD_OFF;
    public static final int RADIOTEXT_TOOLTIP_CUTOFF_THRESHOLD_ALWAYS_ACTIVE;
    public static final int RADIOTEXT_TOOLTIP_CUTOFF_THRESHOLD_OFF;
    public static final int RADIOTEXT_TOOLTIP_DISPLAY_DURATION_NO_LIMIT;
    public static final int SLIDESHOW_CUTOFF_THRESHOLD_ALWAYS_ACTIVE;
    public static final int SLIDESHOW_CUTOFF_THRESHOLD_OFF;
    public static final int SLIDESHOW_DISPLAY_DURATION1_NO_LIMIT;
    public static final int SLIDESHOW_DISPLAY_DURATION1_OFF;
    public static final int SLIDESHOW_DISPLAY_DURATION2_NO_LIMIT;
    public static final int SLIDESHOW_DISPLAY_DURATION2_OFF;
    public static final int TRAVEL_GUIDE_CUTOFF_THRESHOLD_ALWAYS_ACTIVE;
    public static final int TRAVEL_GUIDE_CUTOFF_THRESHOLD_OFF;
    public static final int VIDEO_CUTOFF_THRESHOLD_ALWAYS_ACTIVE;
    public static final int VIDEO_CUTOFF_THRESHOLD_OFF;

    default public boolean isBoardbookCutoffThresholdAlwaysActive(int n) {
    }

    default public boolean isBoardbookCutoffThresholdOff(int n) {
    }

    default public boolean isBroadcastWebsiteCutoffThresholdAlwaysActive(int n) {
    }

    default public boolean isBroadcastWebsiteCutoffThresholdOff(int n) {
    }

    default public boolean isBtBondingCutoffThresholdAlwaysActive(int n) {
    }

    default public boolean isBtBondingCutoffThresholdOff(int n) {
    }

    default public boolean isCarmenuCutoffThresholdAlwaysActive(int n) {
    }

    default public boolean isCarmenuCutoffThresholdOff(int n) {
    }

    default public boolean isDestinationInputCutoffThresholdAlwaysActive(int n) {
    }

    default public boolean isDestinationInputCutoffThresholdOff(int n) {
    }

    default public boolean isMessagingTextEditorCutoffThresholdAlwaysActive(int n) {
    }

    default public boolean isMessagingTextEditorCutoffThresholdOff(int n) {
    }

    default public boolean isRadiotextTooltipCutoffThresholdAlwaysActive(int n) {
    }

    default public boolean isRadiotextTooltipCutoffThresholdOff(int n) {
    }

    default public boolean isRadiotextTooltipDisplayDurationNoLimit(int n) {
    }

    default public boolean isSlideshowCutoffThresholdAlwaysActive(int n) {
    }

    default public boolean isSlideshowCutoffThresholdOff(int n) {
    }

    default public boolean isSlideshowDisplayDuration1NoLimit(int n) {
    }

    default public boolean isSlideshowDisplayDuration1Off(int n) {
    }

    default public boolean isSlideshowDisplayDuration2NoLimit(int n) {
    }

    default public boolean isSlideshowDisplayDuration2Off(int n) {
    }

    default public boolean isTravelGuideCutoffThresholdAlwaysActive(int n) {
    }

    default public boolean isTravelGuideCutoffThresholdOff(int n) {
    }

    default public boolean isVideoCutoffThresholdAlwaysActive(int n) {
    }

    default public boolean isVideoCutoffThresholdOff(int n) {
    }
}

