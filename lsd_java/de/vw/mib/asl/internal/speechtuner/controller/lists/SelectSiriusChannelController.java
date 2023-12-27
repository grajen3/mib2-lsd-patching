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
import de.vw.mib.asl.internal.speechtuner.communication.tuner.SiriusInterfaceHandler;
import de.vw.mib.asl.internal.speechtuner.controller.lists.TunerNbestListController;
import de.vw.mib.asl.internal.speechtuner.data.internal.SpeechTunerSiriusChannel;
import de.vw.mib.asl.internal.speechtuner.utils.SpeechTunerServiceManager;

public class SelectSiriusChannelController
extends TunerNbestListController {
    public SelectSiriusChannelController(SpeechTunerServiceManager speechTunerServiceManager, EntertainmentSourceHandler entertainmentSourceHandler, StationListProblemHandler stationListProblemHandler, DialogStateHandler dialogStateHandler, SiriusInterfaceHandler siriusInterfaceHandler, ResultListHandler resultListHandler, ListAdjustmentHandler listAdjustmentHandler) {
        super(speechTunerServiceManager, entertainmentSourceHandler, stationListProblemHandler, dialogStateHandler, siriusInterfaceHandler, siriusInterfaceHandler, resultListHandler, listAdjustmentHandler, 6);
    }

    @Override
    public int getListIdTopLevel() {
        return -517850624;
    }

    @Override
    public int getListIdDetailLevel() {
        return -501073408;
    }

    @Override
    public int getListIdSelectedItem() {
        return -484296192;
    }

    @Override
    public int getSelectionEvent() {
        return -520406720;
    }

    @Override
    protected int getSuccessEvent() {
        return 136526336;
    }

    @Override
    public void notifyAmbiguousItemsRequested() {
        super.notifyAmbiguousItemsRequested();
        this.serviceManager.getModelServices().sendEventToModel(153303552);
    }

    @Override
    protected void tuneBandSpecific(Object object) {
        if (!(object instanceof SpeechTunerSiriusChannel)) {
            this.serviceManager.getModelServices().sendEventToModel(-182306304);
        }
        SpeechTunerSiriusChannel speechTunerSiriusChannel = (SpeechTunerSiriusChannel)object;
        ((SiriusInterfaceHandler)this.radioInterface).tuneSiriusChannel(this, speechTunerSiriusChannel);
    }

    @Override
    public void notifyGroupExpanded(int n) {
        GenericASLList genericASLList = this.serviceManager.getModelServices().getGenericASLList(this.getListIdTopLevel());
        if (genericASLList != null) {
            SpeechTunerSiriusChannel speechTunerSiriusChannel = (SpeechTunerSiriusChannel)genericASLList.getDSIObjects()[n];
            GenericASLList genericASLList2 = this.serviceManager.getModelServices().getGenericASLList(this.getListIdSelectedItem());
            if (genericASLList2 != null) {
                genericASLList2.updateList(new SpeechTunerSiriusChannel[]{speechTunerSiriusChannel});
            } else {
                this.logger.error("ASL list for nbest select item was null.");
            }
        } else {
            this.logger.error("ASL list for nbest toplevel result was null.");
        }
        super.notifyGroupExpanded(n);
    }
}

