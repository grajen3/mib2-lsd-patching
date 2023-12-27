/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechtuner.controller.lists;

import de.vw.mib.asl.api.radio.speech.TuningResponse;
import de.vw.mib.asl.api.speechengine.result.handling.ResultListHandler;
import de.vw.mib.asl.api.speechengine.result.handling.ResultListNBestControllerBase;
import de.vw.mib.asl.api.speechengine.result.router.ModelEventConsumer;
import de.vw.mib.asl.api.speechengine.result.router.RecognizedEventConsumer;
import de.vw.mib.asl.api.speechengine.result.service.AdditionalDataService;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.speechtuner.behavior.listadjustment.ListAdjustmentHandler;
import de.vw.mib.asl.internal.speechtuner.behavior.problemhandling.StationListProblemHandler;
import de.vw.mib.asl.internal.speechtuner.communication.dialogstate.DialogStateHandler;
import de.vw.mib.asl.internal.speechtuner.communication.entertainmentmanager.EntertainmentSourceHandler;
import de.vw.mib.asl.internal.speechtuner.communication.tuner.RadioInterfaceHandler;
import de.vw.mib.asl.internal.speechtuner.data.internal.SpeechTunerNbestText;
import de.vw.mib.asl.internal.speechtuner.data.internal.SpeechTunerStation;
import de.vw.mib.asl.internal.speechtuner.utils.SpeechTunerLogger;
import de.vw.mib.asl.internal.speechtuner.utils.SpeechTunerServiceManager;
import de.vw.mib.asl.internal.speechtuner.utils.callbacks.EntertainmentSourceCallback;
import de.vw.mib.asl.internal.speechtuner.utils.callbacks.TuningCallback;
import de.vw.mib.genericevents.EventGeneric;

public abstract class TunerNbestListController
extends ResultListNBestControllerBase
implements RecognizedEventConsumer,
ModelEventConsumer,
TuningCallback,
EntertainmentSourceCallback {
    private static final String LOGGER_PREFIX;
    protected SpeechTunerServiceManager serviceManager;
    protected SpeechTunerLogger logger;
    protected final DialogStateHandler dialogStateHandler;
    protected final StationListProblemHandler problemHandler;
    protected final ResultListHandler resultHandler;
    protected final ListAdjustmentHandler listAdjustmentHandler;
    protected final int usecase;
    protected int continuedEvent;
    protected final RadioInterfaceHandler radioInterface;
    protected final EntertainmentSourceHandler entertainmentSourceHandler;

    protected TunerNbestListController(SpeechTunerServiceManager speechTunerServiceManager, EntertainmentSourceHandler entertainmentSourceHandler, StationListProblemHandler stationListProblemHandler, DialogStateHandler dialogStateHandler, RadioInterfaceHandler radioInterfaceHandler, AdditionalDataService additionalDataService, ResultListHandler resultListHandler, ListAdjustmentHandler listAdjustmentHandler, int n) {
        super(additionalDataService, resultListHandler, speechTunerServiceManager.getModelServices().getListManager());
        this.serviceManager = speechTunerServiceManager;
        this.logger = speechTunerServiceManager.createSpeechTunerLogger("[TunerNbestListController] ");
        this.entertainmentSourceHandler = entertainmentSourceHandler;
        this.problemHandler = stationListProblemHandler;
        this.dialogStateHandler = dialogStateHandler;
        this.radioInterface = radioInterfaceHandler;
        this.resultHandler = resultListHandler;
        this.listAdjustmentHandler = listAdjustmentHandler;
        this.usecase = n;
    }

    protected boolean doProblemCheck(int n) {
        this.continuedEvent = n;
        this.problemHandler.updateCacheState(this.radioInterface.isCacheEmpty());
        return this.problemHandler.isProblemCheckSuccessful();
    }

    protected abstract int getSelectionEvent() {
    }

    protected abstract int getSuccessEvent() {
    }

    @Override
    public void onEvent(EventGeneric eventGeneric) {
        int n = eventGeneric.getReceiverEventId();
        if (n == this.getSelectionEvent()) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace(new StringBuffer().append(this.entertainmentSourceHandler.getCurrentBandText()).append(" station has been selected by name inside the dialog").toString());
            }
            super.onRequestItems();
        } else {
            switch (n) {
                case 1077541841: {
                    if (this.logger.isTraceEnabled()) {
                        this.logger.trace(new StringBuffer().append(this.entertainmentSourceHandler.getCurrentBandText()).append("nbest list item selected by index").toString());
                    }
                    int n2 = eventGeneric.getInt(0);
                    super.onSelectItem(n2);
                    break;
                }
                case 1077541842: {
                    if (this.logger.isTraceEnabled()) {
                        this.logger.trace(new StringBuffer().append(this.entertainmentSourceHandler.getCurrentBandText()).append("nbest list subitem selected by index").toString());
                    }
                    int n3 = eventGeneric.getInt(0);
                    super.onSelectSubItem(n3);
                    break;
                }
            }
        }
    }

    @Override
    public void onActivateRadio() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("continue nbest list use case since radio is active now (radio was active after continue request)");
        }
        if (this.dialogStateHandler.isDialogActive()) {
            this.onRecognizedEvent(this.continuedEvent);
        } else {
            this.logger.warn("radio is active now but dialog has been closed meanwhile, do not send anything to model");
        }
    }

    @Override
    public void onRecognizedEvent(int n) {
        if (!this.entertainmentSourceHandler.isRadioCurrentEntertainmentSource()) {
            this.entertainmentSourceHandler.registerForNextSourceChange(this);
            this.doProblemCheck(n);
        } else if (n == this.getSelectionEvent()) {
            this.problemHandler.setCurrentUseCase(this.usecase);
            if (this.logger.isTraceEnabled()) {
                this.logger.trace(new StringBuffer().append(this.entertainmentSourceHandler.getCurrentBandText()).append(" station has been selected by name with direct command").toString());
            }
            if (this.doProblemCheck(this.getSelectionEvent())) {
                super.onRequestItems();
            }
        } else {
            switch (n) {
                case 1077541840: {
                    if (this.logger.isTraceEnabled()) {
                        this.logger.trace(new StringBuffer().append(this.entertainmentSourceHandler.getCurrentBandText()).append(" nbest item selected by name").toString());
                    }
                    super.onSelectItem();
                    break;
                }
                case 1077541839: {
                    if (this.logger.isTraceEnabled()) {
                        this.logger.trace(new StringBuffer().append(this.entertainmentSourceHandler.getCurrentBandText()).append(" nbest item selected by rownumber").toString());
                    }
                    super.onRecognizeRowNumber();
                    break;
                }
                case 1077541838: {
                    if (this.logger.isTraceEnabled()) {
                        this.logger.trace(new StringBuffer().append(this.entertainmentSourceHandler.getCurrentBandText()).append(" nbest item selected by saying yes to the proposed first item").toString());
                    }
                    super.onSelectItem(0);
                    break;
                }
                case 1077541844: {
                    if (this.logger.isTraceEnabled()) {
                        this.logger.trace(new StringBuffer().append("user said no to the proposed first ").append(this.entertainmentSourceHandler.getCurrentBandText()).append(" item").toString());
                    }
                    this.notifyNo();
                    break;
                }
                case 1077541845: {
                    if (this.logger.isTraceEnabled()) {
                        this.logger.trace(new StringBuffer().append("user wants to enter the ").append(this.entertainmentSourceHandler.getCurrentBandText()).append(" value again").toString());
                    }
                    this.notifyEnterAgain();
                    break;
                }
                case 1077541836: {
                    if (this.logger.isTraceEnabled()) {
                        this.logger.trace(new StringBuffer().append("first page of ").append(this.entertainmentSourceHandler.getCurrentBandText()).append(" nbest list requested").toString());
                    }
                    this.notifyFirstPage();
                    break;
                }
                case 1077541837: {
                    if (this.logger.isTraceEnabled()) {
                        this.logger.trace(new StringBuffer().append("last page of ").append(this.entertainmentSourceHandler.getCurrentBandText()).append(" nbest list requested").toString());
                    }
                    this.notifyLastPage();
                    break;
                }
                case 1077541834: {
                    if (this.logger.isTraceEnabled()) {
                        this.logger.trace(new StringBuffer().append("next page of ").append(this.entertainmentSourceHandler.getCurrentBandText()).append(" nbest list requested").toString());
                    }
                    this.notifyNextPage();
                    break;
                }
                case 1077541835: {
                    if (this.logger.isTraceEnabled()) {
                        this.logger.trace(new StringBuffer().append("previous page of ").append(this.entertainmentSourceHandler.getCurrentBandText()).append(" nbest list requested").toString());
                    }
                    this.notifyPrevPage();
                    break;
                }
            }
        }
    }

    @Override
    public void notifyGroupExpanded(int n) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(new StringBuffer().append("group of ").append(this.entertainmentSourceHandler.getCurrentBandText()).append(" nbest list expanded").toString());
        }
        this.serviceManager.getModelServices().writeIntegerToDatapool(-702400000, n);
        this.serviceManager.getModelServices().sendEventToModel(-266192384);
    }

    @Override
    public void notifyGroupCollapsed(int n) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(new StringBuffer().append("group of ").append(this.entertainmentSourceHandler.getCurrentBandText()).append(" nbest list collapsed").toString());
        }
        this.serviceManager.getModelServices().writeIntegerToDatapool(-702400000, -1);
        this.serviceManager.getModelServices().sendEventToModel(-249415168);
    }

    @Override
    public void notifyRowNumberRecognized(int n) {
        this.serviceManager.getModelServices().writeIntegerToDatapool(-685622784, n);
    }

    protected void notifyFirstPage() {
        this.serviceManager.getModelServices().sendEventToModel(-316524032);
    }

    protected void notifyLastPage() {
        this.serviceManager.getModelServices().sendEventToModel(-299746816);
    }

    protected void notifyNextPage() {
        this.serviceManager.getModelServices().sendEventToModel(-350078464);
    }

    protected void notifyPrevPage() {
        this.serviceManager.getModelServices().sendEventToModel(-333301248);
    }

    protected void notifyNo() {
        this.serviceManager.getModelServices().sendEventToModel(-215860736);
    }

    protected void notifyEnterAgain() {
        this.radioInterface.writeAnyStationIntoSelectedItem();
        this.serviceManager.getModelServices().sendEventToModel(-199083520);
    }

    @Override
    public void notifyItemSelected() {
        this.tuneStation();
    }

    @Override
    public void notifyItemsRequested() {
        this.tuneStation();
    }

    @Override
    public void notifyAmbiguousItemsRequested() {
        SpeechTunerStation speechTunerStation = (SpeechTunerStation)this.serviceManager.getModelServices().getGenericASLList(this.getListIdTopLevel()).getRowItem(0);
        SpeechTunerStation speechTunerStation2 = (SpeechTunerStation)this.serviceManager.getModelServices().getGenericASLList(this.getListIdTopLevel()).getRowItem(1);
        if (speechTunerStation != null && speechTunerStation2 != null) {
            SpeechTunerNbestText speechTunerNbestText = new SpeechTunerNbestText(speechTunerStation.getName(), speechTunerStation2.getName());
            GenericASLList genericASLList = this.serviceManager.getModelServices().getGenericASLList(-467518976);
            if (genericASLList != null) {
                genericASLList.updateList(new SpeechTunerNbestText[]{speechTunerNbestText});
            } else {
                this.logger.error("ASL list for nbest text was null.");
            }
        } else {
            this.logger.error("View model items in nbest list were null.");
        }
    }

    protected void tuneStation() {
        Object[] objectArray = this.serviceManager.getModelServices().getGenericASLList(this.getListIdSelectedItem()).getDSIObjects();
        if (objectArray == null || objectArray.length != 1) {
            this.serviceManager.getModelServices().sendEventToModel(-182306304);
        } else {
            this.tuneBandSpecific(objectArray[0]);
        }
    }

    protected abstract void tuneBandSpecific(Object object) {
    }

    @Override
    public void onTuningResponse(TuningResponse tuningResponse) {
        if (this.dialogStateHandler.isDialogActive()) {
            if (tuningResponse == null) {
                this.serviceManager.getModelServices().sendEventToModel(-182306304);
            } else if (tuningResponse.getResultState() == 1) {
                this.serviceManager.getModelServices().sendEventToModel(this.getSuccessEvent());
            } else {
                this.serviceManager.getModelServices().sendEventToModel(-182306304);
            }
        } else {
            this.logger.warn("tuning response for station has arrived but dialog has been closed meanwhile, do not send anything to model");
        }
    }
}

