/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechtuner.controller.lists;

import de.vw.mib.asl.api.speechengine.result.handling.ResultListHandler;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.speechtuner.behavior.listadjustment.ListAdjustmentHandler;
import de.vw.mib.asl.internal.speechtuner.behavior.problemhandling.StationListProblemHandler;
import de.vw.mib.asl.internal.speechtuner.communication.dialogstate.DialogStateHandler;
import de.vw.mib.asl.internal.speechtuner.communication.entertainmentmanager.EntertainmentSourceHandler;
import de.vw.mib.asl.internal.speechtuner.communication.tuner.AmFmInterfaceHandler;
import de.vw.mib.asl.internal.speechtuner.controller.lists.TunerNbestListController;
import de.vw.mib.asl.internal.speechtuner.data.internal.SpeechTunerFMStation;
import de.vw.mib.asl.internal.speechtuner.utils.SpeechTunerServiceManager;

public class SelectFMStationController
extends TunerNbestListController {
    public SelectFMStationController(SpeechTunerServiceManager speechTunerServiceManager, EntertainmentSourceHandler entertainmentSourceHandler, StationListProblemHandler stationListProblemHandler, DialogStateHandler dialogStateHandler, AmFmInterfaceHandler amFmInterfaceHandler, ResultListHandler resultListHandler, ListAdjustmentHandler listAdjustmentHandler) {
        super(speechTunerServiceManager, entertainmentSourceHandler, stationListProblemHandler, dialogStateHandler, amFmInterfaceHandler, amFmInterfaceHandler, resultListHandler, listAdjustmentHandler, 3);
    }

    @Override
    public int getListIdTopLevel() {
        return -752731648;
    }

    @Override
    public int getListIdDetailLevel() {
        return -735954432;
    }

    @Override
    public int getListIdSelectedItem() {
        return -719177216;
    }

    @Override
    public int getSelectionEvent() {
        return -906282688;
    }

    @Override
    protected int getSuccessEvent() {
        return -383632896;
    }

    @Override
    public void notifyAmbiguousItemsRequested() {
        super.notifyAmbiguousItemsRequested();
        this.serviceManager.getModelServices().sendEventToModel(-366855680);
    }

    @Override
    protected void tuneBandSpecific(Object object) {
        if (!(object instanceof SpeechTunerFMStation)) {
            this.serviceManager.getModelServices().sendEventToModel(-182306304);
        }
        SpeechTunerFMStation speechTunerFMStation = (SpeechTunerFMStation)object;
        ((AmFmInterfaceHandler)this.radioInterface).tuneFmStation(this, speechTunerFMStation);
    }

    @Override
    public void notifyGroupExpanded(int n) {
        GenericASLList genericASLList = this.serviceManager.getModelServices().getGenericASLList(this.getListIdTopLevel());
        if (genericASLList != null) {
            SpeechTunerFMStation speechTunerFMStation = (SpeechTunerFMStation)genericASLList.getDSIObjects()[n];
            GenericASLList genericASLList2 = this.serviceManager.getModelServices().getGenericASLList(this.getListIdSelectedItem());
            if (genericASLList2 != null) {
                genericASLList2.updateList(new SpeechTunerFMStation[]{speechTunerFMStation});
            } else {
                this.logger.error("ASL list for nbest select item was null.");
            }
        } else {
            this.logger.error("ASL list for nbest toplevel result was null.");
        }
        super.notifyGroupExpanded(n);
    }
}

