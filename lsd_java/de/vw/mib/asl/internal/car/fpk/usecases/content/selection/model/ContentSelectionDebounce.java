/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.fpk.usecases.content.selection.model;

import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.internal.car.fpk.commons.AppLogger;
import de.vw.mib.asl.internal.car.fpk.usecases.content.selection.model.ContentSelection;
import de.vw.mib.asl.internal.car.fpk.usecases.content.selection.service.ContentSelectionServiceImpl;
import de.vw.mib.asl.internal.car.fpk.usecases.content.setup.model.DisplayElements;
import de.vw.mib.asl.internal.list.ASLListManager;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.genericevents.EventGeneric;
import generated.de.vw.mib.asl.internal.car.fpk.transformer.CarFPKCurrentElementContentSelectionDisplay1_1Collector;
import generated.de.vw.mib.asl.internal.car.fpk.transformer.CarFPKCurrentElementContentSelectionDisplay2_1Collector;

public class ContentSelectionDebounce {
    private static int START_EVENT_ID = -1601830656;
    private static final long SETUP_TIMER_DURATION;
    private static final long RESPONSE_TIMER_DURATION;
    private final int ev_setup_timer;
    private final int ev_response_timer;
    private boolean setupTimerActive = false;
    private boolean responseTimerActive = false;
    private int debounceForDisplayId;
    private int currentElementContentId;
    private int cachedElementContentId;
    private int pendingElementContentId;
    private ContentSelectionServiceImpl contentSelectionService;

    public ContentSelectionDebounce(ContentSelectionServiceImpl contentSelectionServiceImpl, int n) {
        this.contentSelectionService = contentSelectionServiceImpl;
        this.debounceForDisplayId = n;
        this.pendingElementContentId = -1;
        this.ev_setup_timer = START_EVENT_ID++;
        this.ev_response_timer = START_EVENT_ID++;
    }

    public boolean isManaged(EventGeneric eventGeneric) {
        int n = eventGeneric.getReceiverEventId();
        if (1192034368 == n) {
            int n2 = eventGeneric.getInt(0);
            return this.debounceForDisplayId == n2;
        }
        return this.ev_setup_timer == n || this.ev_response_timer == n;
    }

    public void gotEvent(EventGeneric eventGeneric) {
        AppLogger.trace(this, new StringBuffer().append(".gotEvent ( ").append(eventGeneric).append(") - display = ").append(this.debounceForDisplayId).toString());
        if (1192034368 == eventGeneric.getReceiverEventId()) {
            int n = eventGeneric.getInt(0);
            int n2 = eventGeneric.getInt(1);
            this.processAslDownEvent(n, n2);
        } else if (eventGeneric.getReceiverEventId() == this.ev_setup_timer) {
            this.processSetupTimer();
        } else if (eventGeneric.getReceiverEventId() == this.ev_response_timer) {
            this.processResponseTimer();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void onSelectionUpdated(ContentSelection contentSelection) {
        if (contentSelection.getDisplay() != this.debounceForDisplayId) {
            return;
        }
        if (this.responseTimerActive) {
            AppLogger.trace(this, new StringBuffer().append(".onSelectionUpdated, stopTimer (ev_response_timer) - display = ").append(this.debounceForDisplayId).toString());
            this.responseTimerActive = false;
            this.contentSelectionService.stopTimer(this.ev_response_timer);
        }
        if (contentSelection.getDisplay() == this.debounceForDisplayId) {
            int n = contentSelection.getElementContent();
            try {
                if (this.pendingElementContentId >= 0 && n != this.pendingElementContentId) {
                    DisplayElements displayElements = this.contentSelectionService.getCarFPKSetupAPI().getDisplaySetupService().getDisplayElements(this.debounceForDisplayId);
                    if (null == displayElements) {
                        return;
                    }
                    this.processAslDownEvent(this.debounceForDisplayId, displayElements.getIndexOfElementContent(this.pendingElementContentId));
                } else {
                    this.currentElementContentId = n;
                    if (!this.setupTimerActive) {
                        DisplayElements displayElements = this.contentSelectionService.getCarFPKSetupAPI().getDisplaySetupService().getDisplayElements(this.debounceForDisplayId);
                        if (null == displayElements) {
                            return;
                        }
                        this.writeElementContentSelectionToDatapool(displayElements.getIndexOfElementContent(this.currentElementContentId));
                    }
                }
            }
            finally {
                this.pendingElementContentId = -1;
            }
        }
    }

    public void stopDebounceAndWaitForElementContentSelectionUpdate() {
        if (this.responseTimerActive) {
            AppLogger.trace(this, new StringBuffer().append(".onSelectionUpdated, stopTimer (ev_response_timer) - display = ").append(this.debounceForDisplayId).toString());
            this.responseTimerActive = false;
            this.contentSelectionService.stopTimer(this.ev_response_timer);
            this.pendingElementContentId = this.cachedElementContentId;
        } else if (this.pendingElementContentId >= 0) {
            this.pendingElementContentId = this.cachedElementContentId;
        }
    }

    public void stopDebounce() {
        if (this.responseTimerActive) {
            AppLogger.trace(this, new StringBuffer().append(".onSelectionUpdated, stopTimer (ev_response_timer) - display = ").append(this.debounceForDisplayId).toString());
            this.responseTimerActive = false;
            this.contentSelectionService.stopTimer(this.ev_response_timer);
        }
    }

    private void processAslDownEvent(int n, int n2) {
        if (n != this.debounceForDisplayId) {
            return;
        }
        AppLogger.trace(this, new StringBuffer().append(".processAslDownEvent ( displayId=").append(n).append(", elementContentIndex=").append(n2).append(" ) - display = ").append(this.debounceForDisplayId).toString());
        if (this.writeElementContentSelectionToDatapool(n2)) {
            this.triggerSetupTimer();
        }
    }

    private void triggerSetupTimer() {
        if (this.setupTimerActive) {
            AppLogger.trace(this, new StringBuffer().append(".triggerSetupTimer, retriggerTimer (ev_setup_timer) - display = ").append(this.debounceForDisplayId).toString());
            this.contentSelectionService.retriggerTimer(this.ev_setup_timer);
        } else {
            AppLogger.trace(this, new StringBuffer().append(".triggerSetupTimer, startTimer (ev_setup_timer) - display = ").append(this.debounceForDisplayId).toString());
            this.contentSelectionService.startTimer(this.ev_setup_timer, (long)0, false);
            this.setupTimerActive = true;
        }
    }

    private void processSetupTimer() {
        if (this.setupTimerActive) {
            this.setupTimerActive = false;
            if (this.responseTimerActive) {
                AppLogger.trace(this, new StringBuffer().append(".processSetupTimer, retrigger (ev_response_timer) - display = ").append(this.debounceForDisplayId).toString());
                this.contentSelectionService.retriggerTimer(this.ev_response_timer);
            } else {
                AppLogger.trace(this, new StringBuffer().append(".processSetupTimer, startTimer (ev_response_timer) - display = ").append(this.debounceForDisplayId).toString());
                this.contentSelectionService.startTimer(this.ev_response_timer, (long)0, false);
                this.responseTimerActive = true;
            }
            DisplayElements displayElements = this.contentSelectionService.getCarFPKSetupAPI().getDisplaySetupService().getDisplayElements(this.debounceForDisplayId);
            if (null == displayElements) {
                return;
            }
            this.contentSelectionService.selectElement(this.debounceForDisplayId, displayElements.getIndexOfElementContent(this.cachedElementContentId), 1);
        }
    }

    private void processResponseTimer() {
        if (this.responseTimerActive) {
            this.responseTimerActive = false;
            DisplayElements displayElements = this.contentSelectionService.getCarFPKSetupAPI().getDisplaySetupService().getDisplayElements(this.debounceForDisplayId);
            if (null == displayElements) {
                return;
            }
            this.cachedElementContentId = this.currentElementContentId;
            this.writeElementContentSelectionToDatapool(displayElements.getIndexOfElementContent(this.currentElementContentId));
        }
    }

    private boolean writeElementContentSelectionToDatapool(int n) {
        Object object;
        DisplayElements displayElements = this.contentSelectionService.getCarFPKSetupAPI().getDisplaySetupService().getDisplayElements(this.debounceForDisplayId);
        if (null == displayElements) {
            return false;
        }
        this.cachedElementContentId = displayElements.getElementIdForIndex(n);
        ASLListManager aSLListManager = ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLListManager();
        if (1 == this.debounceForDisplayId) {
            object = new CarFPKCurrentElementContentSelectionDisplay1_1Collector();
            ((CarFPKCurrentElementContentSelectionDisplay1_1Collector)object).car_fpk_current_element_content_selection_id_display1__1 = (int)DisplayElements.getElementAslId(this.cachedElementContentId);
            ((CarFPKCurrentElementContentSelectionDisplay1_1Collector)object).car_fpk_current_element_content_selection_index_display1__1 = n;
            GenericASLList genericASLList = aSLListManager.getGenericASLList(10885);
            genericASLList.updateList(new CarFPKCurrentElementContentSelectionDisplay1_1Collector[]{object});
        } else if (2 == this.debounceForDisplayId) {
            object = new CarFPKCurrentElementContentSelectionDisplay2_1Collector();
            ((CarFPKCurrentElementContentSelectionDisplay2_1Collector)object).car_fpk_current_element_content_selection_id_display2__1 = (int)DisplayElements.getElementAslId(this.cachedElementContentId);
            ((CarFPKCurrentElementContentSelectionDisplay2_1Collector)object).car_fpk_current_element_content_selection_index_display2__1 = n;
            GenericASLList genericASLList = aSLListManager.getGenericASLList(10886);
            genericASLList.updateList(new CarFPKCurrentElementContentSelectionDisplay2_1Collector[]{object});
        }
        object = this.contentSelectionService.getSelectedElement(this.debounceForDisplayId);
        if (object != null && ((ContentSelection)object).getElementContent() == this.cachedElementContentId) {
            AppLogger.trace(this, new StringBuffer().append(".writeElementContentSelectionToDatapool ( ").append(n).append(" ), already selected - display = ").append(this.debounceForDisplayId).toString());
            return false;
        }
        return true;
    }
}

