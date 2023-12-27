/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.desktop.internal.popup;

import de.vw.mib.collections.copyonwrite.CowList;
import de.vw.mib.collections.ints.IntIterator;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.desktop.internal.DesktopManagerConfiguration;
import de.vw.mib.desktop.internal.common.ServiceManager;
import de.vw.mib.desktop.internal.popup.DynamicStateData;
import de.vw.mib.desktop.internal.popup.PopupEntry;
import de.vw.mib.desktop.internal.popup.PopupStackManager;
import de.vw.mib.desktop.internal.popup.TimeoutListener;
import de.vw.mib.desktop.internal.viewhandler.SmartViewHandler;
import de.vw.mib.error.HMIDumpInformationProvider;
import de.vw.mib.event.BooleanValueEvent;
import de.vw.mib.event.ContextChangeEvent;
import de.vw.mib.event.DynamicStateEvent;
import de.vw.mib.event.HMIEvent;
import de.vw.mib.event.PopupViewEvent;
import de.vw.mib.event.PowerStateEvent;
import de.vw.mib.event.TouchEvent;
import de.vw.mib.event.consumer.PopupStackManagerEventConsumer;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.popup.PopupInformationHandler;
import de.vw.mib.popup.PopupSpeechInfoReceiver;
import de.vw.mib.popup.PopupSpeechSegueService;
import de.vw.mib.widgets.models.PopupViewModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.osgi.framework.ServiceReference;

public class PopupStackManagerImpl
implements PopupStackManager,
PopupStackManagerEventConsumer,
TimeoutListener,
HMIDumpInformationProvider,
PopupSpeechSegueService {
    private static final int INITIAL_SPACE_FOR_POPUPVIEWS;
    private static final int HK_MEDIA_PRESSED;
    private static final int HK_MEDIA_LONGPRESSED;
    private final Logger logger;
    private static final String SYSTEM_CONTEXT;
    private static final String DONT_COUNT_POPUPNAME;
    private boolean speechDialogActive = false;
    private final IntObjectOptHashMap dynStateId2DynamicStateData = new IntObjectOptHashMap();
    private final List dynStateStack = Collections.synchronizedList(new ArrayList());
    private final List popupList = Collections.synchronizedList(new ArrayList());
    private final ArrayList popupViewHandlers = new ArrayList(8);
    private boolean opaque = false;
    private SmartViewHandler opaqueViewHandler;
    private int nrOfBlockingPopups = 0;
    private String upperPopupViewHandlerName = null;
    private PopupEntry genericPopupBackgroundPopupEntry = null;
    private boolean genericPopupBackgroundViewHandlerinitialized = false;
    private boolean genericPopupBackgroundShouldBeVisible = false;
    private boolean suppressGenericPopupBackgroundStartAnimation = false;
    private boolean releaseResourcesForSkinChangeIsActive = false;
    private String currentContext = "System";
    private String nextContext = null;
    private boolean approximated = false;
    private boolean userPerceivedOn = true;
    private int topVisibleDynamicStateId;
    private int numberOfPopups = -1;
    private int numberOfUserPerceivedOffPopups = -1;
    private boolean suppressPopups = false;
    private boolean vipPresent = false;
    private int currentPopupInfo = 0;
    private CowList popupSpeechInfoReceivers = CowList.EMPTY;
    private int popupViewHandlerIndex;

    public PopupStackManagerImpl() {
        this.logger = ServiceManager.loggerFactory.getLogger(1024);
        ServiceManager.errorHandler.addHMIDumpInformationProvider(this);
    }

    private int getTopVisibleDynamicStateId() {
        for (int i2 = 0; i2 < this.dynStateStack.size(); ++i2) {
            DynamicStateData dynamicStateData = (DynamicStateData)this.dynStateStack.get(i2);
            int n = dynamicStateData.getDynamicStateId();
            if (!this.isDynamicStateVisibleInContext(n, this.getLogicalContext(), true)) continue;
            return n;
        }
        return 0;
    }

    private void generateFocusEvent(int n, boolean bl) {
        if (this.logger.isTraceEnabled(4)) {
            this.logger.trace(4).append("dynamic state ").append(n).append(' ').append(bl ? "gained" : "lost").append(" focus").log();
        }
        if (bl) {
            ServiceManager.statemachineManager.focusGainedPopup(n);
        } else {
            ServiceManager.statemachineManager.focusLostPopup(n);
        }
    }

    private void checkFocus() {
        int n = this.getTopVisibleDynamicStateId();
        if (n != this.topVisibleDynamicStateId) {
            DynamicStateData dynamicStateData;
            PopupEntry popupEntry;
            if (!(n == 0 || (popupEntry = (dynamicStateData = (DynamicStateData)this.dynStateId2DynamicStateData.get(n)).getCurrentPopupEntry()) != null && popupEntry.hasViewHandler())) {
                this.topVisibleDynamicStateId = n;
                return;
            }
            if (this.topVisibleDynamicStateId != 0) {
                this.generateFocusEvent(this.topVisibleDynamicStateId, false);
            }
            if (n != 0) {
                this.generateFocusEvent(n, true);
            }
            this.topVisibleDynamicStateId = n;
        }
    }

    private void updateStackState() {
        this.checkFocus();
        int n = 0;
        int n2 = 0;
        for (int i2 = 0; i2 < this.popupList.size(); ++i2) {
            PopupEntry popupEntry = (PopupEntry)this.popupList.get(i2);
            if (!popupEntry.isAvailableAndVisibleAndActive() || popupEntry.getDynamicStateData().isSuppressedBySpeech() || popupEntry.getViewHandlerName().equals("PoDisplayCurrentlyOffViewHandler") || popupEntry.equals(this.getGenericPopupBackGroundPopupEntry())) continue;
            ++n;
            if (!ServiceManager.popupInformationTable.isActiveInUserPerceivedOffMode(popupEntry.getPopupInfoId())) continue;
            ++n2;
        }
        if (n != this.numberOfPopups || n2 != this.numberOfUserPerceivedOffPopups) {
            this.numberOfPopups = n;
            this.numberOfUserPerceivedOffPopups = n2;
            ServiceManager.eventDispatcher.createAndSubmitPopupStackChangeEvent(this.numberOfPopups, this.numberOfUserPerceivedOffPopups);
        }
    }

    @Override
    public void consumeEvent(ContextChangeEvent contextChangeEvent) {
        this.logger.info(4).append("consumeEvent (ContextChangeEvent): ").append(contextChangeEvent).log();
        this.nextContext = contextChangeEvent.getContext();
    }

    @Override
    public void consumeEvent(DynamicStateEvent dynamicStateEvent) {
        this.logger.info(4).append("consumeEvent (DynamicState): ").append(dynamicStateEvent).log();
        int n = dynamicStateEvent.getDynamicStateId();
        switch (dynamicStateEvent.getCommand()) {
            case 0: {
                this.onDynamicStateOpen(n, dynamicStateEvent.getPopupInfoId());
                break;
            }
            case 1: {
                this.onDynamicStateRequestClose(n);
                break;
            }
            case 2: {
                this.onDynamicStateClosed(n);
                break;
            }
            case 3: {
                this.onDynamicStateTimeoutRestart(n);
                break;
            }
        }
    }

    private boolean isEventConsumedByDynamicState(int n, int n2) {
        DynamicStateData dynamicStateData = (DynamicStateData)this.dynStateId2DynamicStateData.get(n2);
        int[] nArray = ServiceManager.popupInformationTable.getConsumeEventIds(dynamicStateData.getPopupInfoId());
        for (int i2 = nArray.length - 1; i2 >= 0; --i2) {
            int n3 = nArray[i2];
            if (n3 == -1 || n3 != n) continue;
            return true;
        }
        return false;
    }

    private boolean dispatch(HMIEvent hMIEvent) {
        for (int i2 = 0; i2 < this.dynStateStack.size(); ++i2) {
            DynamicStateData dynamicStateData = (DynamicStateData)this.dynStateStack.get(i2);
            int n = dynamicStateData.getDynamicStateId();
            PopupEntry popupEntry = dynamicStateData.getCurrentPopupEntry();
            if (!this.isDynamicStateVisibleInContext(n, this.getLogicalContext(), true) || dynamicStateData.isSuppressedBySpeech()) continue;
            if (popupEntry != null && popupEntry.isActive() && popupEntry.consumeEvent(hMIEvent)) {
                return true;
            }
            if (ServiceManager.statemachineManager.consumeEvent(n, hMIEvent)) {
                return true;
            }
            if (hMIEvent.getType() == 2 && ServiceManager.popupInformationTable.shallCloseOnHk(dynamicStateData.getPopupInfoId(), hMIEvent.getId())) {
                String[] stringArray = ServiceManager.popupInformationTable.getHomeContextIdsByEventId(hMIEvent.getId());
                boolean bl = stringArray != null && stringArray.length >= 1 && stringArray[0].equals("ignoreCloseOnHK");
                boolean bl2 = bl = bl || ServiceManager.configurationManager.isDevelopmentBuild() && (hMIEvent.getId() == 326 || hMIEvent.getId() == 328);
                if (!bl) {
                    this.doClose(dynamicStateData);
                    if (stringArray != null) {
                        for (int i3 = 0; i3 < stringArray.length; ++i3) {
                            if (!this.currentContext.equals(stringArray[i3])) continue;
                            hMIEvent.setConsumed(true);
                            return true;
                        }
                    }
                }
            }
            if (!this.isEventConsumedByDynamicState(hMIEvent.getId(), n)) continue;
            hMIEvent.setConsumed(true);
            return true;
        }
        return false;
    }

    @Override
    public boolean consumeEvent(HMIEvent hMIEvent) {
        boolean bl;
        if (hMIEvent.getType() == 8 && (bl = ((BooleanValueEvent)hMIEvent).getValue()) != this.approximated) {
            this.approximated = bl;
            this.onApproximationChange();
        }
        bl = this.dispatch(hMIEvent);
        return bl;
    }

    @Override
    public void consumeEvent(PowerStateEvent powerStateEvent) {
        this.logger.info(4).append("consumeEvent (PowerStateEvent): ").append(powerStateEvent).log();
        switch (powerStateEvent.getState()) {
            case 0: 
            case 2: 
            case 5: 
            case 6: {
                this.onPerceivementChange(false);
                break;
            }
            case 1: {
                this.onPerceivementChange(true);
                break;
            }
        }
        this.updateStackState();
    }

    @Override
    public void consumeEvent(PopupViewEvent popupViewEvent) {
        this.logger.info(4).append("consumeEvent (PopupViewEvent): ").append(popupViewEvent).log();
        int n = popupViewEvent.getDynamicStateId();
        switch (popupViewEvent.getCommand()) {
            case 0: {
                this.onPopupViewOpen(n, popupViewEvent.getPopupInfoId(), popupViewEvent.getPopupViewId());
                break;
            }
            case 1: {
                this.onPopupViewClosed(n);
                break;
            }
            case 2: {
                this.onPopupViewSuspend(n);
                break;
            }
            case 3: {
                this.onPopupViewResume(n);
                break;
            }
        }
        this.updateStackState();
    }

    @Override
    public boolean consumeEvent(TouchEvent touchEvent) {
        for (int i2 = 0; i2 < this.popupList.size(); ++i2) {
            PopupEntry popupEntry = (PopupEntry)this.popupList.get(i2);
            if (popupEntry.isLeaveAnimationRunning() || !popupEntry.isAvailableAndVisibleAndActive() || popupEntry.getDynamicStateData().isSuppressedBySpeech() || !this.userPerceivedOn && !ServiceManager.popupInformationTable.isVisibleInUserPerceivedOffMode(popupEntry.getPopupInfoId())) continue;
            if (!popupEntry.consumeEvent(touchEvent)) {
                if (ServiceManager.popupInformationTable.shallCloseOnTouch(popupEntry.getPopupInfoId()) && (touchEvent.getType() == 1 || touchEvent.getType() == 6)) {
                    this.doClose(popupEntry.getDynamicStateData());
                }
                if (ServiceManager.popupInformationTable.shallForwardTouchEvent(popupEntry.getPopupInfoId())) continue;
                return true;
            }
            return true;
        }
        return false;
    }

    private void openPopupViewHandlerList() {
        this.popupViewHandlerIndex = 0;
    }

    private void addPopupViewHandlerToList(SmartViewHandler smartViewHandler) {
        if (this.popupViewHandlerIndex >= this.popupViewHandlers.size()) {
            this.popupViewHandlers.add(smartViewHandler);
        } else if (!smartViewHandler.equals(this.popupViewHandlers.get(this.popupViewHandlerIndex))) {
            this.popupViewHandlers.set(this.popupViewHandlerIndex, smartViewHandler);
            int n = this.popupViewHandlers.size() - 1;
            while (n > this.popupViewHandlerIndex) {
                this.popupViewHandlers.remove(n--);
            }
        }
        ++this.popupViewHandlerIndex;
    }

    private void closePopupViewHandlerList() {
        if (this.popupViewHandlerIndex != this.popupViewHandlers.size()) {
            int n = this.popupViewHandlers.size() - 1;
            while (n >= this.popupViewHandlerIndex) {
                this.popupViewHandlers.remove(n--);
            }
        }
    }

    @Override
    public ArrayList getPopupViewHandlers(SmartViewHandler smartViewHandler) {
        this.openPopupViewHandlerList();
        this.opaque = false;
        this.opaqueViewHandler = null;
        this.vipPresent = false;
        if (!this.suppressPopups) {
            PopupEntry popupEntry;
            if (smartViewHandler != null) {
                this.addPopupViewHandlerToList(smartViewHandler);
            }
            this.upperPopupViewHandlerName = null;
            this.nrOfBlockingPopups = 0;
            boolean bl = false;
            for (int i2 = 0; i2 < this.popupList.size(); ++i2) {
                PopupEntry popupEntry2 = (PopupEntry)this.popupList.get(i2);
                if (!popupEntry2.isAvailableAndVisible()) continue;
                String string = popupEntry2.getViewHandlerName();
                if (popupEntry2.getDynamicStateData().isSuppressedBySpeech()) continue;
                boolean bl2 = this.vipPresent = this.vipPresent || ServiceManager.popupInformationTable.shallShowDuringExBox(popupEntry2.getPopupInfoId());
                if (!this.userPerceivedOn && !ServiceManager.popupInformationTable.isVisibleInUserPerceivedOffMode(popupEntry2.getPopupInfoId())) continue;
                if (this.upperPopupViewHandlerName == null) {
                    this.upperPopupViewHandlerName = string;
                }
                boolean bl3 = ServiceManager.popupInformationTable.shallForwardTouchEvent(popupEntry2.getPopupInfoId());
                popupEntry2.getViewHandler().setTouchForwardingMode(bl3 ? 0 : 2);
                this.addPopupViewHandlerToList(popupEntry2.getViewHandler());
                if (!bl3) {
                    ++this.nrOfBlockingPopups;
                    if (!popupEntry2.isLeaveAnimationRunning() && !ServiceManager.popupInformationTable.hasInvisibleInactiveArea(popupEntry2.getPopupInfoId())) {
                        bl = true;
                    }
                }
                if (!popupEntry2.isViewOpaque()) continue;
                if (this.logger.isTraceEnabled(4)) {
                    this.logger.trace(4).append("popup entry ").append(popupEntry2.getPresentationString()).append(": opaque").log();
                }
                this.opaque = true;
                this.opaqueViewHandler = popupEntry2.getViewHandler();
                break;
            }
            if ((popupEntry = this.getGenericPopupBackGroundPopupEntry()) != null) {
                if (bl) {
                    if (!this.genericPopupBackgroundShouldBeVisible) {
                        if (!this.suppressGenericPopupBackgroundStartAnimation) {
                            popupEntry.show(false);
                        }
                        this.genericPopupBackgroundShouldBeVisible = true;
                    }
                } else if (this.genericPopupBackgroundShouldBeVisible) {
                    popupEntry.hide();
                    this.genericPopupBackgroundShouldBeVisible = false;
                }
                if (!this.opaque && (popupEntry.isShowing() || this.genericPopupBackgroundShouldBeVisible)) {
                    this.addPopupViewHandlerToList(popupEntry.getViewHandler());
                }
            }
        }
        this.closePopupViewHandlerList();
        return this.popupViewHandlers;
    }

    @Override
    public boolean isOpaque() {
        return this.opaque;
    }

    @Override
    public SmartViewHandler getOpaqueViewHandler() {
        return this.opaqueViewHandler;
    }

    @Override
    public boolean isVipPresent() {
        return this.vipPresent;
    }

    @Override
    public boolean isTouchThrough() {
        return this.nrOfBlockingPopups <= 0;
    }

    @Override
    public String getNameOfUpmostPopupViewHandler() {
        return this.upperPopupViewHandlerName;
    }

    private PopupEntry getGenericPopupBackGroundPopupEntry() {
        if (this.genericPopupBackgroundPopupEntry == null && !this.releaseResourcesForSkinChangeIsActive && !this.genericPopupBackgroundViewHandlerinitialized) {
            SmartViewHandler smartViewHandler = ServiceManager.smartViewHandlerProvider.getPopupBackgroundViewHandler();
            if (smartViewHandler == null) {
                return null;
            }
            this.genericPopupBackgroundPopupEntry = new PopupEntry(null, null, 0, "PopupBackground");
            this.genericPopupBackgroundPopupEntry.setPopupViewHandler(smartViewHandler);
            this.genericPopupBackgroundPopupEntry.initViewHandler();
            this.genericPopupBackgroundPopupEntry.activateViewHandler();
            this.genericPopupBackgroundViewHandlerinitialized = true;
        }
        return this.genericPopupBackgroundPopupEntry;
    }

    private void onDynamicStateOpen(int n, int n2) {
        if (!this.userPerceivedOn && !ServiceManager.popupInformationTable.isActiveInUserPerceivedOffMode(n2)) {
            ServiceManager.statemachineManager.deactivatePopup(n);
            return;
        }
        DynamicStateData dynamicStateData = (DynamicStateData)this.dynStateId2DynamicStateData.get(n);
        if (dynamicStateData != null) {
            return;
        }
        dynamicStateData = new DynamicStateData(n, n2, this);
        this.dynStateId2DynamicStateData.put(n, dynamicStateData);
        int n3 = this.getDynStatePosition4Priority(ServiceManager.popupInformationTable.getPriority(n2));
        this.dynStateStack.add(n3, dynamicStateData);
        dynamicStateData.activate();
        int n4 = ServiceManager.popupInformationTable.getPriority(n2);
        Iterator iterator = this.dynStateId2DynamicStateData.values().iterator();
        boolean bl = this.isDynamicStateVisibleInContext(n, this.getLogicalContext(), true);
        if (bl) {
            while (iterator.hasNext()) {
                DynamicStateData dynamicStateData2 = (DynamicStateData)iterator.next();
                if (!this.isDynamicStateVisibleInContext(dynamicStateData2.getDynamicStateId(), this.getLogicalContext(), true) || ServiceManager.popupInformationTable.getPriority(dynamicStateData2.getPopupInfoId()) >= n4) continue;
                bl = false;
                break;
            }
        }
        this.generateFocusEvent(n, bl);
        if (this.speechDialogActive) {
            int n5 = 0;
            while (n5 < this.dynStateStack.size()) {
                DynamicStateData dynamicStateData3 = (DynamicStateData)this.dynStateStack.get(n5++);
                dynamicStateData3.setSpeechDialogActive(this.speechDialogActive);
            }
        }
        if (this.logger.isTraceEnabled(4)) {
            this.logger.trace(4).append("open dynamic state ").append(n).log();
        }
    }

    private String getLogicalContext() {
        return this.nextContext != null ? this.nextContext : this.currentContext;
    }

    private void onPopupViewOpen(int n, int n2, String string) {
        int n3;
        int n4;
        DynamicStateData dynamicStateData = (DynamicStateData)this.dynStateId2DynamicStateData.get(n);
        if (dynamicStateData == null) {
            ServiceManager.errorHandler.handleViewCreationError(new Throwable(new StringBuffer().append("Found no dynamic state data for dynamic state ID ").append(n).toString()), false);
            return;
        }
        dynamicStateData.stopTimers();
        PopupEntry popupEntry = null;
        for (n4 = 0; n4 < this.popupList.size(); ++n4) {
            if (!((PopupEntry)this.popupList.get(n4)).getPopupViewName().equals(string)) continue;
            popupEntry = (PopupEntry)this.popupList.get(n4);
            popupEntry.stopPendingAnimations();
            break;
        }
        if (popupEntry == null) {
            popupEntry = new PopupEntry(this, dynamicStateData, n2, string);
        } else {
            popupEntry.setDynamicStateData(dynamicStateData);
            popupEntry.setPopupInfoId(n2);
        }
        popupEntry.setActive(true);
        dynamicStateData.setCurrentPopupEntry(popupEntry);
        popupEntry.setPopupViewName(string);
        this.popupList.remove(popupEntry);
        n4 = ServiceManager.popupInformationTable.getPriority(dynamicStateData.getPopupInfoId());
        int n5 = this.getPosition4Priority(n4);
        boolean bl = false;
        for (n3 = n5 - 1; n3 >= 0; --n3) {
            PopupEntry popupEntry2 = (PopupEntry)this.popupList.get(n3);
            if (popupEntry2 == null) {
                ServiceManager.errorHandler.handleViewCreationError(new Throwable(new StringBuffer().append("(superseded check) Null entry in popup list when opening the popup view ").append(this.formatString(string)).append(" in dynamic state ").append(n).toString()), false);
                return;
            }
            if (!popupEntry2.isAvailableAndVisibleAndActive()) continue;
            bl = true;
        }
        if (bl && ServiceManager.popupInformationTable.shallCloseWhenSuperseded(dynamicStateData.getPopupInfoId())) {
            this.doClose(dynamicStateData);
        } else {
            Object object;
            int n6;
            int n7;
            for (n7 = n3 = this.dynStateStack.indexOf(dynamicStateData); n7 > 0 && (n6 = ServiceManager.popupInformationTable.getPriority(((DynamicStateData)(object = (DynamicStateData)this.dynStateStack.get(n7 - 1))).getPopupInfoId())) >= n4; --n7) {
                this.dynStateStack.set(n7, object);
            }
            if (n7 < n3) {
                this.dynStateStack.set(n7, dynamicStateData);
            } else {
                while (n7 < this.dynStateStack.size() - 1 && (n6 = ServiceManager.popupInformationTable.getPriority(((DynamicStateData)(object = (DynamicStateData)this.dynStateStack.get(n7 + 1))).getPopupInfoId())) < n4) {
                    this.dynStateStack.set(n7, object);
                    ++n7;
                }
                if (n7 > n3) {
                    this.dynStateStack.set(n7, dynamicStateData);
                }
            }
            this.popupList.add(n5, popupEntry);
            if (this.logger.isTraceEnabled(4)) {
                this.logger.trace(4).append("open popup ").append(n).append(" (").append(popupEntry.getPopupViewName()).append(")").log();
            }
            if (!dynamicStateData.isSuppressedBySpeech()) {
                ++n5;
                while (n5 < this.popupList.size()) {
                    object = (PopupEntry)this.popupList.get(n5);
                    if (object == null) {
                        ServiceManager.errorHandler.handleViewCreationError(new Throwable(new StringBuffer().append("(close on superseded) Null entry in popup list when opening the popup view ").append(this.formatString(string)).append(" in dynamic state ").append(n).toString()), false);
                        return;
                    }
                    if (ServiceManager.popupInformationTable.shallCloseWhenSuperseded(((PopupEntry)object).getPopupInfoId()) && ((PopupEntry)object).isAvailableAndVisibleAndActive()) {
                        this.doClose(((PopupEntry)object).getDynamicStateData());
                    }
                    ++n5;
                }
            }
            boolean bl2 = true;
            if (!ServiceManager.popupInformationTable.isGlobalPopup(dynamicStateData.getPopupInfoId())) {
                bl2 = this.containsContext(ServiceManager.popupInformationTable.getHomeContextId(dynamicStateData.getPopupInfoId()), this.currentContext);
            }
            popupEntry.setVisible(bl2);
            SmartViewHandler smartViewHandler = ServiceManager.smartViewHandlerProvider.getPopupViewHandler(string);
            popupEntry.setPopupViewHandler(smartViewHandler);
            popupEntry.initViewHandler();
            if (!this.genericPopupBackgroundShouldBeVisible) {
                this.suppressGenericPopupBackgroundStartAnimation = true;
            }
            ServiceManager.desktopManager.evaluatePopupStack();
            if (this.suppressGenericPopupBackgroundStartAnimation) {
                if (this.genericPopupBackgroundShouldBeVisible) {
                    this.getGenericPopupBackGroundPopupEntry().show(false);
                }
                this.suppressGenericPopupBackgroundStartAnimation = false;
            }
            if (popupEntry.isAvailableAndVisibleAndActive()) {
                popupEntry.show(false);
                if (ServiceManager.popupInformationTable.isStopsSpeech(popupEntry.getPopupInfoId())) {
                    this.notifyPopupSpeechInfoReceivers();
                }
            } else {
                popupEntry.suspend(true);
            }
            this.deactivateMainViewHandlerIfNeeded();
        }
        this.refresh();
    }

    private boolean isDynamicStateVisibleInContext(int n, String string, boolean bl) {
        DynamicStateData dynamicStateData = (DynamicStateData)this.dynStateId2DynamicStateData.get(n);
        if (ServiceManager.popupInformationTable.isGlobalPopup(dynamicStateData.getPopupInfoId())) {
            if (!ServiceManager.popupInformationTable.shallMoveToHomeContext(dynamicStateData.getPopupInfoId())) {
                return true;
            }
            if (!dynamicStateData.hasMovedToHomeContext()) {
                return true;
            }
        }
        return this.containsContext(ServiceManager.popupInformationTable.getHomeContextId(dynamicStateData.getPopupInfoId()), string) && (!bl || !dynamicStateData.isSuspended());
    }

    private void onContextChange(boolean bl) {
        int n = 0;
        if (this.logger.isTraceEnabled(4)) {
            this.logger.trace(4).append("context change to '").append(this.nextContext).append("'").log();
        }
        while (n < this.popupList.size()) {
            PopupEntry popupEntry = (PopupEntry)this.popupList.get(n);
            int n2 = popupEntry.getDynamicStateId();
            DynamicStateData dynamicStateData = (DynamicStateData)this.dynStateId2DynamicStateData.get(n2);
            if (dynamicStateData != null) {
                boolean bl2 = false;
                if (ServiceManager.popupInformationTable.isGlobalPopup(popupEntry.getPopupInfoId()) && ServiceManager.popupInformationTable.shallMoveToHomeContext(popupEntry.getPopupInfoId())) {
                    if (ServiceManager.popupInformationTable.shallCloseWhenMovedToHomeContext(popupEntry.getPopupInfoId())) {
                        this.doClose(dynamicStateData);
                        bl2 = true;
                    } else {
                        dynamicStateData.setMovedToHomeContext(true);
                    }
                }
                if (!bl2) {
                    boolean bl3 = this.isDynamicStateVisibleInContext(n2, this.nextContext, false);
                    if (popupEntry.isActive() && bl3 != popupEntry.isAvailableAndVisibleAndActive()) {
                        if (bl3) {
                            if (bl) {
                                popupEntry.resume(true);
                                popupEntry.setVisible(true);
                                if (ServiceManager.popupInformationTable.isStopsSpeech(popupEntry.getPopupInfoId())) {
                                    this.notifyPopupSpeechInfoReceivers();
                                }
                            }
                        } else {
                            popupEntry.suspend(true);
                            popupEntry.setVisible(false);
                        }
                    }
                }
            }
            ++n;
        }
        if (bl) {
            this.currentContext = this.nextContext;
            this.nextContext = null;
        }
        ServiceManager.desktopManager.evaluatePopupStack();
        this.refresh();
    }

    private void onApproximationChange() {
        if (this.logger.isTraceEnabled(4)) {
            this.logger.trace(4).append("approximation change to '").append(this.approximated ? "approximated" : "unapproximated").append("'").log();
        }
        boolean bl = false;
        if (this.approximated) {
            for (int i2 = 0; i2 < this.popupList.size(); ++i2) {
                PopupEntry popupEntry = (PopupEntry)this.popupList.get(i2);
                if (!ServiceManager.popupInformationTable.shallCloseOnProximity(popupEntry.getPopupInfoId())) continue;
                this.onDynamicStateRequestClose(popupEntry.getDynamicStateId());
                bl = true;
            }
        }
        if (bl) {
            this.refresh();
        }
    }

    private void onPerceivementChange(boolean bl) {
        this.userPerceivedOn = bl;
        if (this.logger.isTraceEnabled(4)) {
            this.logger.trace(4).append("perceivement change to '").append(bl ? "on" : "off").append("'").log();
        }
        if (this.userPerceivedOn) {
            return;
        }
        boolean bl2 = false;
        for (int i2 = 0; i2 < this.dynStateStack.size(); ++i2) {
            DynamicStateData dynamicStateData = (DynamicStateData)this.dynStateStack.get(i2);
            if (ServiceManager.popupInformationTable.isActiveInUserPerceivedOffMode(dynamicStateData.getPopupInfoId())) continue;
            this.doClose(dynamicStateData);
            bl2 = true;
        }
        if (bl2) {
            this.refresh();
        }
    }

    private void onPopupViewSuspend(int n) {
        if (this.logger.isTraceEnabled(4)) {
            this.logger.trace(4).append("suspend dynamic state ").append(n).log();
        }
        ((DynamicStateData)this.dynStateId2DynamicStateData.get(n)).getCurrentPopupEntry().suspend(false);
        this.refresh();
    }

    private void onPopupViewResume(int n) {
        if (this.logger.isTraceEnabled(4)) {
            this.logger.trace(4).append("resume dynamic state ").append(n).log();
        }
        ((DynamicStateData)this.dynStateId2DynamicStateData.get(n)).getCurrentPopupEntry().resume(false);
        this.refresh();
    }

    private void onDynamicStateRequestClose(int n) {
        if (this.logger.isTraceEnabled(4)) {
            this.logger.trace(4).append("close request for dynamic state ").append(n).log();
        }
        if (this.dynStateId2DynamicStateData.containsKey(n)) {
            DynamicStateData dynamicStateData = (DynamicStateData)this.dynStateId2DynamicStateData.get(n);
            if (dynamicStateData.hasMinTimeExpired()) {
                PopupEntry popupEntry = dynamicStateData.getCurrentPopupEntry();
                if (popupEntry != null && popupEntry.hasViewHandler()) {
                    popupEntry.close();
                }
                this.doClose(dynamicStateData);
            } else {
                dynamicStateData.requestCloseAfterMinTimeExpired();
            }
        }
    }

    private void activateMainViewHandlerIfNeeded(String string) {
        boolean bl = true;
        if (!this.suppressPopups) {
            for (int i2 = 0; i2 < this.popupList.size(); ++i2) {
                PopupEntry popupEntry = (PopupEntry)this.popupList.get(i2);
                if (popupEntry.getPopupViewName().equals(string) || !popupEntry.hasViewHandler() || !popupEntry.isViewVisible() || !popupEntry.isAvailableAndVisibleAndActive() || popupEntry.isLeaveAnimationRunning() || !popupEntry.isViewOpaque()) continue;
                popupEntry.deactivateViewHandler();
                popupEntry.activateViewHandler();
                bl = false;
                break;
            }
        }
        if (bl) {
            ServiceManager.desktopManager.activateMainViewHandler();
        }
    }

    private void deactivateMainViewHandlerIfNeeded() {
        boolean bl = false;
        if (!this.suppressPopups) {
            for (int i2 = 0; i2 < this.popupList.size(); ++i2) {
                PopupEntry popupEntry = (PopupEntry)this.popupList.get(i2);
                if (!popupEntry.hasViewHandler() || !popupEntry.isViewVisible() || !popupEntry.isAvailableAndVisibleAndActive() || popupEntry.isLeaveAnimationRunning() || !popupEntry.isViewOpaque()) continue;
                bl = true;
                break;
            }
        }
        if (bl) {
            ServiceManager.desktopManager.deactivateMainViewHandler();
        }
    }

    private void onPopupViewClosed(int n) {
        DynamicStateData dynamicStateData = (DynamicStateData)this.dynStateId2DynamicStateData.get(n);
        PopupEntry popupEntry = dynamicStateData.getCurrentPopupEntry();
        popupEntry.setActive(false);
        if (popupEntry.hasViewHandler()) {
            if (popupEntry.isViewOpaque()) {
                ServiceManager.desktopManager.signalClosingOpaquePopup();
            }
            if (popupEntry.isViewOpaque() && !DesktopManagerConfiguration.DISABLE_MAINVIEWREACTIVATION) {
                popupEntry.close();
                this.activateMainViewHandlerIfNeeded(popupEntry.getPopupViewName());
            } else {
                popupEntry.close();
            }
        }
        this.refresh();
        if (this.logger.isTraceEnabled(4)) {
            this.logger.trace(4).append("close popup ").append(n).append(" (").append(popupEntry.getPopupViewName()).append(")").log();
        }
    }

    private void onDynamicStateClosed(int n) {
        DynamicStateData dynamicStateData = (DynamicStateData)this.dynStateId2DynamicStateData.get(n);
        dynamicStateData.dispose();
        this.dynStateId2DynamicStateData.remove(n);
        this.dynStateStack.remove(dynamicStateData);
        if (this.logger.isTraceEnabled(4)) {
            this.logger.trace(4).append("closed dynamic state ").append(n).log();
        }
        this.checkFocus();
    }

    private void onDynamicStateTimeoutRestart(int n) {
        DynamicStateData dynamicStateData = (DynamicStateData)this.dynStateId2DynamicStateData.get(n);
        if (dynamicStateData != null) {
            dynamicStateData.restartTimeout();
            if (this.logger.isTraceEnabled(4)) {
                this.logger.trace(4).append("restart time for dynamic state ").append(n).log();
            }
        } else {
            this.logger.warn(4).append("onDynamicStateTimeoutRestart(").append(n).append("); Ignored. Dynamic state is not active!!!");
        }
    }

    private void doClose(DynamicStateData dynamicStateData) {
        if (dynamicStateData != null) {
            if (dynamicStateData.getCurrentPopupEntry() != null) {
                dynamicStateData.getCurrentPopupEntry().setActive(false);
            }
            dynamicStateData.deactivate();
        }
    }

    private void refresh() {
        ServiceManager.desktopManager.updateDisplay();
    }

    @Override
    public void onTimeout(int n) {
        ServiceManager.eventDispatcher.createAndSubmitDynamicStateEvent(n, 1);
    }

    private int getDynStatePosition4Priority(int n) {
        DynamicStateData dynamicStateData;
        int n2;
        int n3;
        for (n3 = 0; n3 < this.dynStateStack.size() && (n2 = ServiceManager.popupInformationTable.getPriority((dynamicStateData = (DynamicStateData)this.dynStateStack.get(n3)).getPopupInfoId())) < n; ++n3) {
        }
        return n3;
    }

    private int getPosition4Priority(int n) {
        PopupEntry popupEntry;
        int n2;
        int n3;
        for (n3 = 0; n3 < this.popupList.size() && (n2 = ServiceManager.popupInformationTable.getPriority((popupEntry = (PopupEntry)this.popupList.get(n3)).getPopupInfoId())) < n; ++n3) {
        }
        return n3;
    }

    @Override
    public void propagateSkinMode() {
        if (this.genericPopupBackgroundPopupEntry != null) {
            this.genericPopupBackgroundPopupEntry.invalidate();
        }
        for (int i2 = 0; i2 < this.popupList.size(); ++i2) {
            PopupEntry popupEntry = (PopupEntry)this.popupList.get(i2);
            popupEntry.invalidate();
        }
    }

    @Override
    public void releaseResourcesForSkinChange() {
        this.releaseResourcesForSkinChangeIsActive = true;
        if (this.genericPopupBackgroundPopupEntry != null) {
            this.genericPopupBackgroundPopupEntry.stopPendingAnimations();
            this.genericPopupBackgroundPopupEntry.deactivateViewHandler();
            this.genericPopupBackgroundPopupEntry.deinitViewHandler();
            this.genericPopupBackgroundPopupEntry.setPopupViewHandler(SmartViewHandler.EMPTY_SMART_VIEWHANDLER);
            this.genericPopupBackgroundPopupEntry = null;
            this.genericPopupBackgroundViewHandlerinitialized = false;
        }
        for (int i2 = this.popupList.size() - 1; i2 >= 0; --i2) {
            PopupEntry popupEntry = (PopupEntry)this.popupList.get(i2);
            popupEntry.release();
        }
        this.releaseResourcesForSkinChangeIsActive = false;
    }

    @Override
    public void restoreResourcesForSkinChange(SmartViewHandler smartViewHandler) {
        PopupEntry popupEntry;
        int n;
        for (n = 0; n < this.popupList.size(); ++n) {
            popupEntry = (PopupEntry)this.popupList.get(n);
            popupEntry.getViewHandler().reload();
        }
        if (smartViewHandler != null) {
            smartViewHandler.reload();
        }
        for (n = 0; n < this.popupList.size(); ++n) {
            popupEntry = (PopupEntry)this.popupList.get(n);
            popupEntry.getViewHandler().restore();
        }
        if (smartViewHandler != null) {
            smartViewHandler.restore();
        }
        ServiceManager.desktopManager.evaluatePopupStack();
    }

    private boolean containsContext(String string, String string2) {
        int n = string.indexOf(string2);
        boolean bl = true;
        boolean bl2 = true;
        if (n >= 0) {
            bl = n == 0 || string.charAt(n - 1) == ' ' || string.charAt(n - 1) == ',';
            int n2 = n + string2.length();
            bl2 = n2 >= string.length() || string.charAt(n2) == ' ' || string.charAt(n2) == ',';
            return bl && bl2;
        }
        return false;
    }

    public void removeFromStack(PopupEntry popupEntry) {
        ServiceManager.smartViewHandlerProvider.free(popupEntry.getPopupViewName());
        popupEntry.setPopupViewHandler(SmartViewHandler.EMPTY_SMART_VIEWHANDLER);
        this.popupList.remove(popupEntry);
        ServiceManager.desktopManager.evaluatePopupStack();
    }

    @Override
    public void hideAll() {
        if (this.nextContext != null) {
            this.onContextChange(false);
        }
        if (DesktopManagerConfiguration.AGITATE_POPUPS) {
            for (int i2 = 0; i2 < this.popupList.size(); ++i2) {
                PopupEntry popupEntry = (PopupEntry)this.popupList.get(i2);
                popupEntry.hide();
            }
        }
    }

    @Override
    public void showAll() {
        if (this.nextContext != null) {
            this.onContextChange(true);
            this.updateStackState();
            this.suppressPopups = this.currentContext.equals("Testmode");
        }
        for (int i2 = 0; i2 < this.popupList.size(); ++i2) {
            PopupEntry popupEntry = (PopupEntry)this.popupList.get(i2);
            popupEntry.show(true);
        }
    }

    @Override
    public void clearDumpInformation() {
    }

    private String formatString(String string) {
        if (string == null) {
            return "null";
        }
        return new StringBuffer().append("'").append(string).append("'").toString();
    }

    @Override
    public String[] getDumpInformation() {
        String string;
        Object object;
        int n;
        String[] stringArray = new String[2 + this.dynStateId2DynamicStateData.size() + this.popupList.size()];
        int n2 = 0;
        stringArray[n2++] = "DynState List";
        IntIterator intIterator = this.dynStateId2DynamicStateData.keySet().iterator();
        while (intIterator.hasNext()) {
            n = intIterator.next();
            object = (DynamicStateData)this.dynStateId2DynamicStateData.get(n);
            string = new StringBuffer().append(" ").append(n).append(" - ").toString();
            if (object == null) {
                string = new StringBuffer().append(string).append("null").toString();
            } else {
                PopupEntry popupEntry = ((DynamicStateData)object).getCurrentPopupEntry();
                if (popupEntry == null) {
                    string = new StringBuffer().append(string).append("popupEntry: null").toString();
                } else {
                    string = new StringBuffer().append(string).append(" popupEntry.popupViewName: ").append(this.formatString(popupEntry.getPopupViewName())).append(" popupEntry.popupViewHandler: ").toString();
                    string = new StringBuffer().append(string).append(popupEntry.hasViewHandler() ? this.formatString(popupEntry.getPopupViewName()) : " null").toString();
                }
            }
            stringArray[n2++] = string;
        }
        stringArray[n2++] = "Popup List";
        for (n = 0; n < this.popupList.size(); ++n) {
            object = (PopupEntry)this.popupList.get(n);
            string = new StringBuffer().append(" ").append(n).append(". ").toString();
            if (object == null) {
                string = new StringBuffer().append(string).append("popupEntry: null").toString();
                continue;
            }
            string = new StringBuffer().append(string).append(" popupEntry.popupViewName: ").append(this.formatString(((PopupEntry)object).getPopupViewName())).append(" popupEntry.popupViewHandler: ").toString();
            string = new StringBuffer().append(string).append(((PopupEntry)object).hasViewHandler() ? this.formatString(((PopupEntry)object).getPopupViewName()) : " null").toString();
        }
        return stringArray;
    }

    @Override
    public String getName() {
        return "PopupStackManagerImpl - Lists:";
    }

    @Override
    public void updatePopupInfo() {
        int n = 0;
        for (int i2 = 0; i2 < this.popupViewHandlers.size(); ++i2) {
            PopupViewModel popupViewModel = (PopupViewModel)((SmartViewHandler)this.popupViewHandlers.get(i2)).getView();
            if (popupViewModel == null) continue;
            if (n == 0) {
                n = 1;
            }
            if (n == 2 || popupViewModel.get_restrictionMode() != 1) continue;
            n = 2;
            if (!this.logger.isTraceEnabled(4)) continue;
            this.logger.trace(4).append(popupViewModel.get_name()).append(": BUTTONS!!!").log();
        }
        if (n != this.currentPopupInfo) {
            if (this.logger.isTraceEnabled(4)) {
                this.logger.trace(4).append("updatePopupInfo() new: ").append(n).append(" was: ").append(this.currentPopupInfo).log();
            }
            this.currentPopupInfo = n;
            Object[] objectArray = ServiceManager.popupInformationHandlerServiceTracker.getServices();
            if (objectArray != null) {
                for (int i3 = 0; i3 < objectArray.length; ++i3) {
                    ((PopupInformationHandler)objectArray[i3]).onPopupInformationChanged(this.currentPopupInfo);
                }
            }
        }
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        PopupInformationHandler popupInformationHandler = (PopupInformationHandler)ServiceManager.bundleContext.getService(serviceReference);
        popupInformationHandler.onPopupInformationChanged(this.currentPopupInfo);
        return popupInformationHandler;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void addPopupSpeechInfoReceiver(PopupSpeechInfoReceiver popupSpeechInfoReceiver) {
        this.popupSpeechInfoReceivers = this.popupSpeechInfoReceivers.add(popupSpeechInfoReceiver);
    }

    @Override
    public void removePopupSpeechInfoReceiver(PopupSpeechInfoReceiver popupSpeechInfoReceiver) {
        this.popupSpeechInfoReceivers = this.popupSpeechInfoReceivers.remove(popupSpeechInfoReceiver);
    }

    private void notifyPopupSpeechInfoReceivers() {
        for (CowList cowList = this.popupSpeechInfoReceivers; cowList != CowList.EMPTY; cowList = cowList.tail()) {
            PopupSpeechInfoReceiver popupSpeechInfoReceiver = (PopupSpeechInfoReceiver)cowList.head();
            popupSpeechInfoReceiver.receiveStopSpeech();
        }
    }

    @Override
    public void receiveSpeechApplicantActive(boolean bl) {
        if (this.logger.isTraceEnabled(4)) {
            this.logger.trace(4).append("receiveSpeechApplicantActive(").append(bl).append(")").log();
        }
        if (bl != this.speechDialogActive) {
            this.speechDialogActive = bl;
            int n = 0;
            while (n < this.dynStateStack.size()) {
                DynamicStateData dynamicStateData = (DynamicStateData)this.dynStateStack.get(n++);
                dynamicStateData.setSpeechDialogActive(this.speechDialogActive);
            }
            ServiceManager.desktopManager.evaluatePopupStack();
            this.refresh();
        }
    }
}

