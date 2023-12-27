/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.tvtuner.common;

import de.vw.mib.asl.api.radio.ASLRadioFactory;
import de.vw.mib.asl.internal.tvtuner.accessor.TVTunerObjectAccessor;
import de.vw.mib.asl.internal.tvtuner.common.TVTunerHelper;
import generated.de.vw.mib.asl.internal.ListManager;
import org.dsi.ifc.tvtuner.ServiceInfo;

public class TVTunerBAPHandler {
    public void updateBAPIndices() {
        if (TVTunerObjectAccessor.getTargetTVTuner().isTVContextEntered()) {
            if (TVTunerHelper.isTraceEnabled()) {
                TVTunerHelper.trace("TVTunerBAPHandler#updateBAPIndices entered");
            }
            if (TVTunerObjectAccessor.getTvAvSourceHandler().getActiveSource() == 1) {
                TVTunerHelper.trace("TVTunerBAPHandler#updateBAPIndices - active source is AV, send alternative index");
                this.updateStationIndices(-1L, -1);
            } else {
                long l = TVTunerObjectAccessor.getTVInfo().getCurrentStationNamePID();
                int n = TVTunerObjectAccessor.getTVInfo().getCurrentStationServicePID();
                int n2 = TVTunerObjectAccessor.getPresetListHandler().getCurrentPresetPosition();
                if (l != 0L) {
                    if (TVTunerHelper.isTraceEnabled()) {
                        TVTunerHelper.trace("TVTunerBAPHandler#updateBAPIndices - update indices to bap");
                        TVTunerHelper.trace(new StringBuffer().append("TVTunerBAPHandler#updateBAPIndices - namePID = ").append(l).append("; presetIndex = ").append(n2).toString());
                    }
                    this.updateStationIndices(l + (long)n, n2);
                } else if (TVTunerHelper.isTraceEnabled()) {
                    TVTunerHelper.trace("TVTunerBAPHandler#updateBAPIndices - do not update indices to bap because there is currently no active station");
                }
            }
        } else if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace("TVTunerBAPHandler#updateBAPIndices entered - do not update indices because tv is not active ctx");
        }
    }

    private void updateStationIndices(long l, int n) {
        ASLRadioFactory.getRadioApi().updateStationIndices(l, n);
    }

    public void updateBAPStationList() {
        if (TVTunerObjectAccessor.getTargetTVTuner().isTVContextEntered()) {
            if (TVTunerObjectAccessor.getTvAvSourceHandler().getActiveSource() == 1) {
                if (TVTunerHelper.isTraceEnabled()) {
                    TVTunerHelper.trace("TVTunerBAPHandler#updateBAPStationList entered - active source is AV, send alternative list");
                }
                Object[] objectArray = new ServiceInfo[]{};
                ListManager.getGenericASLList(1270).updateList(objectArray);
            } else {
                Object[] objectArray = TVTunerObjectAccessor.getStationListHandler().getStationList();
                if (null != objectArray) {
                    if (TVTunerHelper.isTraceEnabled()) {
                        TVTunerHelper.trace("TVTunerBAPHandler#updateBAPStationList entered - update list to bap");
                    }
                    ListManager.getGenericASLList(1270).updateList(objectArray);
                } else if (TVTunerHelper.isTraceEnabled()) {
                    TVTunerHelper.trace("TVTunerBAPHandler#updateBAPStationList entered - do not update list to bap because its null");
                }
            }
        } else if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace("TVTunerBAPHandler#updateBAPStationList entered - do not update list because tv is not active ctx");
        }
    }

    public void setStationFromBAP(long l, int n) {
        int n2 = TVTunerObjectAccessor.getStationListHandler().activateBAPStation(l, n);
        if (n2 == 1) {
            if (TVTunerHelper.isTraceEnabled()) {
                TVTunerHelper.trace(new StringBuffer().append("TVTunerBAPHandler#setStationFromBAP - setting station ").append(l).append(" successful").toString());
            }
        } else if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace(new StringBuffer().append("TVTunerBAPHandler#setStationFromBAP - setting station ").append(l).append(" not successful - station not found in list").toString());
        }
    }
}

