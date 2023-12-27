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
import de.vw.mib.asl.internal.speechtuner.communication.tuner.DabInterfaceHandler;
import de.vw.mib.asl.internal.speechtuner.controller.lists.TunerNbestListController;
import de.vw.mib.asl.internal.speechtuner.data.internal.SpeechTunerDABService;
import de.vw.mib.asl.internal.speechtuner.utils.SpeechTunerServiceManager;

public class SelectDABServiceController
extends TunerNbestListController {
    public SelectDABServiceController(SpeechTunerServiceManager speechTunerServiceManager, EntertainmentSourceHandler entertainmentSourceHandler, StationListProblemHandler stationListProblemHandler, DialogStateHandler dialogStateHandler, DabInterfaceHandler dabInterfaceHandler, ResultListHandler resultListHandler, ListAdjustmentHandler listAdjustmentHandler) {
        super(speechTunerServiceManager, entertainmentSourceHandler, stationListProblemHandler, dialogStateHandler, dabInterfaceHandler, dabInterfaceHandler, resultListHandler, listAdjustmentHandler, 3);
    }

    @Override
    public int getListIdTopLevel() {
        return -635291136;
    }

    @Override
    public int getListIdDetailLevel() {
        return -618513920;
    }

    @Override
    public int getListIdSelectedItem() {
        return -601736704;
    }

    @Override
    public int getSelectionEvent() {
        return -688178880;
    }

    @Override
    protected int getSuccessEvent() {
        return -148751872;
    }

    @Override
    public void notifyAmbiguousItemsRequested() {
        super.notifyAmbiguousItemsRequested();
        this.serviceManager.getModelServices().sendEventToModel(-131974656);
    }

    @Override
    protected void tuneBandSpecific(Object object) {
        if (!(object instanceof SpeechTunerDABService)) {
            this.serviceManager.getModelServices().sendEventToModel(-182306304);
        }
        SpeechTunerDABService speechTunerDABService = (SpeechTunerDABService)object;
        ((DabInterfaceHandler)this.radioInterface).tuneDabService(this, speechTunerDABService);
    }

    @Override
    public void notifyGroupExpanded(int n) {
        GenericASLList genericASLList = this.serviceManager.getModelServices().getGenericASLList(this.getListIdTopLevel());
        if (genericASLList != null) {
            SpeechTunerDABService speechTunerDABService = (SpeechTunerDABService)genericASLList.getDSIObjects()[n];
            GenericASLList genericASLList2 = this.serviceManager.getModelServices().getGenericASLList(this.getListIdSelectedItem());
            if (genericASLList2 != null) {
                genericASLList2.updateList(new SpeechTunerDABService[]{speechTunerDABService});
            } else {
                this.logger.error("ASL list for nbest select item was null.");
            }
        } else {
            this.logger.error("ASL list for nbest toplevel result was null.");
        }
        super.notifyGroupExpanded(n);
    }
}

