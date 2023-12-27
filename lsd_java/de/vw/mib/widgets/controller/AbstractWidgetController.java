/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.collections.ObjectIntMap;
import de.vw.mib.collections.ObjectIntOptHashMap;
import de.vw.mib.collections.copyonwrite.CowList;
import de.vw.mib.event.HMIEvent;
import de.vw.mib.event.ProximityEvent;
import de.vw.mib.event.TouchEvent;
import de.vw.mib.event.dispatcher.apps.ViewEventDispatcher;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.pool.PooledObject;
import de.vw.mib.widgets.controller.WidgetController;
import de.vw.mib.widgets.event.OutEventListener;
import de.vw.mib.widgets.event.ViewChangedListener;
import de.vw.mib.widgets.internal.ServiceManager;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.models.WidgetModel;

public abstract class AbstractWidgetController
implements WidgetController,
PooledObject {
    private static final int OUT_EVENT_MAP_INITIAL_CAPACITY;
    protected static Logger LOGGER;
    private WidgetModel widget;
    private CowList outEventListeners;
    private ObjectIntMap outEventMap;

    public AbstractWidgetController() {
        if (LOGGER == null) {
            LOGGER = ServiceManager.loggerFactory.getLogger(2048);
        }
        this.reset();
    }

    protected void reset() {
        this.widget = null;
        this.outEventMap = null;
        this.outEventListeners = CowList.EMPTY;
    }

    @Override
    public final void backToPool() {
        this.reset();
    }

    @Override
    public void init() {
    }

    @Override
    public void deInit() {
        this.removeAllOutEventListeners();
        if (this.outEventMap != null) {
            this.outEventMap.clear();
        }
    }

    @Override
    public void activate() {
    }

    @Override
    public void deActivate() {
    }

    @Override
    public final WidgetModel getWidget() {
        return this.widget;
    }

    @Override
    public final void setWidget(WidgetModel widgetModel) {
        this.widget = widgetModel;
    }

    @Override
    public void setOutEventMapping(String string, int n) {
        if (this.outEventMap == null) {
            this.outEventMap = new ObjectIntOptHashMap(2);
        }
        this.outEventMap.put(string, n);
    }

    @Override
    public int getOutEventMapping(String string) {
        int n = -1;
        if (this.outEventMap != null && this.outEventMap.containsKey(string)) {
            n = this.outEventMap.get(string);
        }
        return n;
    }

    @Override
    public int getTouchForwardingMode() {
        return 0;
    }

    private ViewEventDispatcher getViewEventDispatcher() {
        ViewModel viewModel = this.widget.getView();
        ViewEventDispatcher viewEventDispatcher = viewModel != null && viewModel.getViewEventDispatcher() != null ? viewModel.getViewEventDispatcher() : ServiceManager.eventDispatcher;
        return viewEventDispatcher;
    }

    @Override
    public final void addOutEventListener(OutEventListener outEventListener) {
        this.outEventListeners = this.outEventListeners.addIfAbsent(outEventListener);
    }

    @Override
    public final void removeOutEventListener(OutEventListener outEventListener) {
        this.outEventListeners = this.outEventListeners.remove(outEventListener);
    }

    @Override
    public final void removeAllOutEventListeners() {
        this.outEventListeners = CowList.EMPTY;
    }

    protected final void deregisterViewChangedHandler(WidgetModel widgetModel, ViewChangedListener viewChangedListener) {
        if (widgetModel != null && widgetModel.getView() != null && viewChangedListener != null) {
            ViewModel viewModel = widgetModel.getView();
            viewModel.removeViewChangedListener(viewChangedListener);
        }
    }

    protected final void registerViewChangedHandler(WidgetModel widgetModel, ViewChangedListener viewChangedListener) {
        this.registerViewChangedHandler(widgetModel, viewChangedListener, false);
    }

    protected final void registerViewChangedHandler(WidgetModel widgetModel, ViewChangedListener viewChangedListener, boolean bl) {
        if (widgetModel != null && widgetModel.getView() != null && viewChangedListener != null) {
            ViewModel viewModel = widgetModel.getView();
            if (bl) {
                this.deregisterViewChangedHandler(widgetModel, viewChangedListener);
            }
            viewModel.addViewChangedListener(viewChangedListener);
        }
    }

    @Override
    public abstract boolean consumeHMIEvent(HMIEvent hMIEvent, String string) {
    }

    @Override
    public abstract boolean consumeTouchEvent(TouchEvent touchEvent) {
    }

    @Override
    public boolean consumeProximityEvent(ProximityEvent proximityEvent) {
        return false;
    }

    protected final void fireHMIEvent(String string) {
        int n = this.getOutEventMapping(string);
        if (n != -1) {
            if (LOGGER.isTraceEnabled(1)) {
                LOGGER.trace(1).append("Widget '").append(this.getWidget().getQualifiedName()).append("': fireHMIEvent: eventName='").append(string).append("', eventId=").append(n).log();
            }
            this.getViewEventDispatcher().createAndSubmitHMIEvent(n);
        }
        for (CowList cowList = this.outEventListeners; cowList != CowList.EMPTY; cowList = cowList.tail()) {
            OutEventListener outEventListener = (OutEventListener)cowList.head();
            outEventListener.outHMIEventFired(string);
        }
    }

    protected final void fireBooleanEvent(String string, boolean bl) {
        int n = this.getOutEventMapping(string);
        if (n != -1) {
            if (LOGGER.isTraceEnabled(1)) {
                LOGGER.trace(1).append("Widget '").append(this.getWidget().getQualifiedName()).append("': fireBooleanEvent: eventName='").append(string).append("', eventId=").append(n).append(", value=").append(bl).log();
            }
            this.getViewEventDispatcher().createAndSubmitBooleanValueEvent(n, bl);
        }
        for (CowList cowList = this.outEventListeners; cowList != CowList.EMPTY; cowList = cowList.tail()) {
            OutEventListener outEventListener = (OutEventListener)cowList.head();
            outEventListener.outBooleanEventFired(string, bl);
        }
    }

    protected final void fireIntegerEvent(String string, int n) {
        int n2 = this.getOutEventMapping(string);
        if (n2 != -1) {
            if (LOGGER.isTraceEnabled(1)) {
                LOGGER.trace(1).append("Widget '").append(this.getWidget().getQualifiedName()).append("': fireIntegerEvent: eventName='").append(string).append("', eventId=").append(n2).append(", value=").append(n).log();
            }
            this.getViewEventDispatcher().createAndSubmitIntegerValueEvent(n2, n);
        }
        for (CowList cowList = this.outEventListeners; cowList != CowList.EMPTY; cowList = cowList.tail()) {
            OutEventListener outEventListener = (OutEventListener)cowList.head();
            outEventListener.outIntegerEventFired(string, n);
        }
    }

    protected final void fireStringEvent(String string, String string2) {
        int n = this.getOutEventMapping(string);
        if (n != -1) {
            if (LOGGER.isTraceEnabled(1)) {
                LOGGER.trace(1).append("Widget '").append(this.getWidget().getQualifiedName()).append("': fireStringEvent: eventName='").append(string).append("', eventId=").append(n).append(", value='").append(string2).append("'").log();
            }
            this.getViewEventDispatcher().createAndSubmitStringValueEvent(n, string2);
        }
        for (CowList cowList = this.outEventListeners; cowList != CowList.EMPTY; cowList = cowList.tail()) {
            OutEventListener outEventListener = (OutEventListener)cowList.head();
            outEventListener.outStringEventFired(string, string2);
        }
    }

    protected final void firePointEvent(String string, int n, int n2, int n3, int n4) {
        int n5 = this.getOutEventMapping(string);
        if (n5 != -1) {
            if (LOGGER.isTraceEnabled(1)) {
                LOGGER.trace(1).append("Widget '").append(this.getWidget().getQualifiedName()).append("': firePointEvent: eventName='").append(string).append("', eventId=").append(n5).append(", x=").append(n).append(", y=").append(n2).append(", gestureParam1=").append(n3).append(", gestureParam2=").append(n4).log();
            }
            this.getViewEventDispatcher().createAndSubmitPointEvent(n5, n, n2, n3, n4);
        }
        for (CowList cowList = this.outEventListeners; cowList != CowList.EMPTY; cowList = cowList.tail()) {
            OutEventListener outEventListener = (OutEventListener)cowList.head();
            outEventListener.outPointEventFired(string, n, n2, n3, n4);
        }
    }

    protected final void fireListItemEvent(String string, int n, int n2, int n3, int n4, String string2, long l) {
        int n5 = this.getOutEventMapping(string);
        if (n5 != -1) {
            if (LOGGER.isTraceEnabled(1)) {
                LOGGER.trace(1).append("Widget '").append(this.getWidget().getQualifiedName()).append("': fireListItemEvent: eventName='").append(string).append("', eventId=").append(n5).append(", absIndex=").append(n).append(", actionIndex=").append(n2).append(", destIndex=").append(n3).append(", dropDownIndex=").append(n4).append(", eventSender=").append(string2).append(", objectId=").append(l).log();
            }
            this.getViewEventDispatcher().createAndSubmitListItemEvent(n5, n, n2, n3, n4, string2, l);
        }
        for (CowList cowList = this.outEventListeners; cowList != CowList.EMPTY; cowList = cowList.tail()) {
            OutEventListener outEventListener = (OutEventListener)cowList.head();
            outEventListener.outListItemEventFired(string, n, n2, n3, n4, string2, l);
        }
    }

    protected final void fireSpellerEvent(String string, String string2, int n, int n2, int n3) {
        int n4 = this.getOutEventMapping(string);
        if (n4 != -1) {
            if (LOGGER.isTraceEnabled(1)) {
                LOGGER.trace(1).append("Widget '").append(this.getWidget().getQualifiedName()).append("': fireSpellerValueEvent: eventName='").append(string).append("', eventId=").append(n4).append(", pressedChar='").append(string2).append("', cursorPosition=").append(n).append(", selectionStart=").append(n2).append(", selectionEnd=").append(n3).log();
            }
            this.getViewEventDispatcher().createAndSubmitSpellerValueEvent(n4, string2, n, n2, n3);
        }
        for (CowList cowList = this.outEventListeners; cowList != CowList.EMPTY; cowList = cowList.tail()) {
            OutEventListener outEventListener = (OutEventListener)cowList.head();
            outEventListener.outSpellerEventFired(string, string2, n, n2, n3);
        }
    }
}

