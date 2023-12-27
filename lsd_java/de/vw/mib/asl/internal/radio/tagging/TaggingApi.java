/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.tagging;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.amfm.common.AmFmConstants;
import de.vw.mib.asl.internal.radio.amfm.main.HsmTarget;
import de.vw.mib.asl.internal.radio.sdars.helper.SatDb;
import de.vw.mib.asl.internal.radio.tagging.TaggingTarget;
import org.dsi.ifc.radio.HdStationInfo;
import org.dsi.ifc.sdars.RadioText;
import org.dsi.ifc.sdars.StationInfo;

public final class TaggingApi {
    private static TaggingTarget mController;

    public static void startModule(HsmTarget hsmTarget) {
        try {
            mController = new TaggingTarget(hsmTarget);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static void notifyChannelTuned(StationInfo stationInfo) {
        try {
            if (null != mController) {
                mController.prepareRadioTextITag(stationInfo);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static void notifyAMFMStationChanged() {
        try {
            if (null != mController) {
                mController.setStationChanged(true);
                mController.prepareHdStationInfoForITag(AmFmConstants.EMPTY_HDSTATIONINFO, false);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static void notifyHDStationInfoChanged(HdStationInfo hdStationInfo, boolean bl) {
        try {
            if (null != mController) {
                mController.prepareHdStationInfoForITag(hdStationInfo, bl);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static void notifyRadioTextChange(RadioText radioText) {
        try {
            if (radioText != null && null != mController) {
                StationInfo stationInfo = SatDb.getInstance().getPool().getChannel(23);
                if (stationInfo != null && stationInfo.getSID() == radioText.getSID()) {
                    mController.prepareRadioTextITag(false);
                    return;
                }
                stationInfo = SatDb.getInstance().getPreviewHandler().getPreviewChannel();
                if (stationInfo != null && stationInfo.getSID() == radioText.getSID()) {
                    mController.prepareRadioTextITag(false);
                }
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static void notifyRadioTextEmpty(boolean bl) {
        try {
            if (null != mController) {
                mController.prepareRadioTextITag(bl);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static void requestTagInstance(boolean bl) {
        try {
            if (mController != null) {
                mController.requestTaggingInstance(bl);
            } else if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("TaggingTarget is NULL ").log();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static void stopAmbiguousTagging() {
        try {
            if (mController != null) {
                mController.stopAmbiguousTagging();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static void setSXMTagInformation(String string, String string2) {
        try {
            if (mController != null) {
                mController.setSXMTagInformation(string, string2);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static void resetInstance() {
        try {
            if (mController != null) {
                mController.resetInstance();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }
}

