/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.tvtuner.common;

import de.vw.mib.asl.internal.tvtuner.accessor.TVTunerObjectAccessor;
import de.vw.mib.asl.internal.tvtuner.common.TVTunerHelper;
import de.vw.mib.cio.CioActionParameters;
import de.vw.mib.cio.CioDispatcher;
import de.vw.mib.cio.CioIntent;
import de.vw.mib.cio.CioParametersCreator;
import org.dsi.ifc.tvtuner.ServiceInfo;

public class TVTunerCioHandler {
    public void fire3DGestureCio(int n) {
        boolean bl = this.checkFailOrSuccess();
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace(new StringBuffer().append("TVTunerCioHandler#fire3DGestureCio -  Success: ").append(bl).toString());
        }
        CioDispatcher cioDispatcher = TVTunerObjectAccessor.getCioHelper().getCioDispatcher();
        CioIntent cioIntent = null;
        if (n == 0) {
            if (TVTunerHelper.isTraceEnabled()) {
                TVTunerHelper.trace("TVTunerCioHandler#fire3DGestureCio - Direction: Left");
            }
            cioIntent = TVTunerObjectAccessor.getCioHelper().getCioDictionary().getCioIntent("ShowSpaceGestureRecognitionFeedback", "RightToLeft");
        } else {
            if (TVTunerHelper.isTraceEnabled()) {
                TVTunerHelper.trace("TVTunerCioHandler#fire3DGestureCio -  Direction: Right");
            }
            cioIntent = TVTunerObjectAccessor.getCioHelper().getCioDictionary().getCioIntent("ShowSpaceGestureRecognitionFeedback", "LeftToRight");
        }
        CioParametersCreator cioParametersCreator = TVTunerObjectAccessor.getCioHelper().getCioFactory().createActionParameters(cioIntent);
        cioParametersCreator.setBoolean("Success", bl);
        CioActionParameters cioActionParameters = cioParametersCreator.finishActionParams();
        cioDispatcher.dispatch(cioIntent, cioActionParameters);
    }

    public void activate3DGesture() {
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace("TVTunerCioHandler#activate3DGesture - activate 3D Gestures");
        }
        CioDispatcher cioDispatcher = TVTunerObjectAccessor.getCioHelper().getCioDispatcher();
        CioIntent cioIntent = TVTunerObjectAccessor.getCioHelper().getCioDictionary().getCioIntent("ShowSpaceGestureIndication");
        cioDispatcher.dispatch(cioIntent);
    }

    private boolean checkFailOrSuccess() {
        if (TVTunerObjectAccessor.getTvTunerSettings().getCasStatus() != 5 && TVTunerObjectAccessor.getTargetTVTunerDSI().getTunerWaitState() != 0 && TVTunerObjectAccessor.getTargetTVTunerDSI().getTunerActiveState() != 0) {
            int n = TVTunerObjectAccessor.getTuningHandler().getButtonMode();
            switch (n) {
                case 0: {
                    if (TVTunerHelper.isTraceEnabled()) {
                        TVTunerHelper.trace("TVTunerCioHandler#checkFailOrSuccess - Buttonmode: PresetList");
                    }
                    return this.checkPresetList();
                }
                case 1: {
                    if (TVTunerHelper.isTraceEnabled()) {
                        TVTunerHelper.trace("TVTunerCioHandler#checkFailOrSuccess - Buttonmode: StationList");
                    }
                    return this.checkStationList();
                }
            }
            return false;
        }
        return false;
    }

    private boolean checkPresetList() {
        boolean bl = false;
        if (TVTunerObjectAccessor.getPresetListHandler().areMoreThanOnePresetAvailable()) {
            bl = true;
        } else if (TVTunerObjectAccessor.getPresetListHandler().arePresetsAvailable()) {
            ServiceInfo serviceInfo = TVTunerObjectAccessor.getTVInfo().getCurrentServiceInfo();
            int n = TVTunerObjectAccessor.getPresetListHandler().getPresetPosition(serviceInfo);
            if (n != TVTunerObjectAccessor.getPresetListHandler().getCurrentPresetPosition()) {
                bl = true;
            }
        }
        return bl;
    }

    private boolean checkStationList() {
        ServiceInfo serviceInfo;
        boolean bl = false;
        ServiceInfo[] serviceInfoArray = TVTunerObjectAccessor.getStationListHandler().getStationList();
        if (serviceInfoArray.length > 1) {
            bl = true;
        } else if (serviceInfoArray.length == 1 && (serviceInfo = TVTunerObjectAccessor.getTVInfo().getCurrentServiceInfo()).getSType() != 15 && serviceInfo.getSType() != 0 && serviceInfoArray[0] != serviceInfo) {
            bl = true;
        }
        return bl;
    }
}

