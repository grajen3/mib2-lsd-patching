/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.audiosd.functions;

import de.vw.mib.bap.mqbab2.audiosd.functions.CurrentStationHandle;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.CurrentStation_Handle_Status;

public class CurrentStationHandleNar
extends CurrentStationHandle {
    private void duplicatePresetListInMediaBrowser(CurrentStation_Handle_Status currentStation_Handle_Status) {
        if (currentStation_Handle_Status.presetList_Ref != 0) {
            currentStation_Handle_Status.fsgHandle = currentStation_Handle_Status.presetList_Ref;
            currentStation_Handle_Status.fsgHandle_absolutePosition = currentStation_Handle_Status.presetList_absolutePosition;
        }
    }

    @Override
    protected void setStationHandlesForRadio(CurrentStation_Handle_Status currentStation_Handle_Status) {
        super.setStationHandlesForRadio(currentStation_Handle_Status);
        if (this.getRadioService().getScopeOfArrowKeyMode() == 0) {
            this.duplicatePresetListInMediaBrowser(currentStation_Handle_Status);
        }
    }

    @Override
    protected void setCurrentStationHandlesForTV(CurrentStation_Handle_Status currentStation_Handle_Status) {
        super.setCurrentStationHandlesForTV(currentStation_Handle_Status);
        if (this.getTvTunerService().getTvScopeOfArrowKeyMode() == 0) {
            this.duplicatePresetListInMediaBrowser(currentStation_Handle_Status);
        }
    }
}

