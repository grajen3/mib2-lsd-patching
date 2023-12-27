/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event.internal.dispatcher;

import de.vw.mib.app.framework.AppDefinition;
import de.vw.mib.event.HMIEvent;
import de.vw.mib.event.consumer.ViewAnimationEventConsumer;
import de.vw.mib.event.dispatcher.DatapoolEventDispatcher;
import de.vw.mib.event.dispatcher.FrameworkEventDispatcher;
import de.vw.mib.event.dispatcher.GestureEventDispatcher;
import de.vw.mib.event.dispatcher.StartupEventDispatcher;
import de.vw.mib.event.dispatcher.StatemachineEventDispatcher;
import de.vw.mib.event.dispatcher.SystemEventDispatcher;
import de.vw.mib.event.dispatcher.ViewEventDispatcher;
import de.vw.mib.list.update.ListItemControlUpdater;

public class EmptyEventDispatcher
implements DatapoolEventDispatcher,
FrameworkEventDispatcher,
StartupEventDispatcher,
StatemachineEventDispatcher,
SystemEventDispatcher,
ViewEventDispatcher,
GestureEventDispatcher {
    @Override
    public void createAndSubmitAnimationEvent(int n) {
    }

    @Override
    public void createAndSubmitBooleanValueEvent(int n, boolean bl) {
    }

    @Override
    public void createAndSubmitContextChangeEvent(String string) {
    }

    @Override
    public void createAndSubmitDatapoolUpdateEvent(int n, boolean bl) {
    }

    @Override
    public void createAndSubmitDatapoolUpdateEvent(int n, float f2) {
    }

    @Override
    public void createAndSubmitDatapoolUpdateEvent(int n, int n2) {
    }

    @Override
    public void createAndSubmitDatapoolUpdateEvent(int n, long l) {
    }

    @Override
    public void createAndSubmitDatapoolUpdateEvent(int n, Object object) {
    }

    @Override
    public void createAndSubmitDisplayEvent(int n) {
    }

    @Override
    public void createAndSubmitDpChangedEvent(int n) {
    }

    @Override
    public void createAndSubmitDynamicStateEvent(int n, int n2) {
    }

    @Override
    public void createAndSubmitDynamicStateEvent(int n, int n2, int n3) {
    }

    @Override
    public void createAndSubmitHardkeyEvent(int n) {
    }

    @Override
    public void createAndSubmitHMIEvent(int n) {
    }

    @Override
    public void createAndSubmitIntegerValueEvent(int n, int n2) {
    }

    @Override
    public void createAndSubmitListItemControlUpdateEvent_activatedIndexChanged(ListItemControlUpdater listItemControlUpdater, int n) {
    }

    @Override
    public void createAndSubmitListItemControlUpdateEvent_itemsChanged(ListItemControlUpdater listItemControlUpdater, int n, int n2) {
    }

    @Override
    public void createAndSubmitListItemControlUpdateEvent_itemsInserted(ListItemControlUpdater listItemControlUpdater, int n, int n2, int n3) {
    }

    @Override
    public void createAndSubmitListItemControlUpdateEvent_itemsRemoved(ListItemControlUpdater listItemControlUpdater, int n, int n2, int n3) {
    }

    @Override
    public void createAndSubmitListItemControlUpdateEvent_listChanged(ListItemControlUpdater listItemControlUpdater, int n) {
    }

    @Override
    public void createAndSubmitListItemControlUpdateEvent_listContentChanged(ListItemControlUpdater listItemControlUpdater) {
    }

    @Override
    public void createAndSubmitListItemControlUpdateEvent_stringIndexChanged(ListItemControlUpdater listItemControlUpdater) {
    }

    @Override
    public void createAndSubmitListItemEvent(int n, int n2, int n3, int n4, int n5, String string, long l) {
    }

    @Override
    public void createAndSubmitListReadoutEvent(int n, int n2, int n3) {
    }

    @Override
    public void createAndSubmitLSChangeEvent(int n) {
    }

    @Override
    public void createAndSubmitPointEvent(int n, int n2, int n3, int n4, int n5) {
    }

    @Override
    public void createAndSubmitPopupStackChangeEvent(int n, int n2) {
    }

    @Override
    public void createAndSubmitPopupViewEvent(int n, String string, int n2) {
    }

    @Override
    public void createAndSubmitPopupViewEvent(int n, String string, int n2, int n3) {
    }

    @Override
    public void createAndSubmitPowerStateEvent(int n) {
    }

    @Override
    public void createAndSubmitProximityEvent(boolean bl, int n) {
    }

    @Override
    public void createAndSubmitReadoutSelectionEvent(int n, int[] nArray, int n2, int n3) {
    }

    @Override
    public void createAndSubmitRepaintEvent() {
    }

    @Override
    public void createAndSubmitRestoreFactorySettingsEvent() {
    }

    public void createAndSubmitRotationEvent(int n, int n2) {
    }

    @Override
    public void createAndSubmitRotationEvent(int n, int n2, int n3) {
    }

    @Override
    public void createAndSubmitSpeechCommandEvent(int n) {
    }

    @Override
    public void createAndSubmitSpeechEvent(int n, long l, int n2, String string, int n3) {
    }

    @Override
    public void createAndSubmitSpeechStateEvent(int n) {
    }

    @Override
    public void createAndSubmitSpellerValueEvent(int n, String string, int n2, int n3, int n4) {
    }

    @Override
    public void createAndSubmitStartupEvent(int n) {
    }

    @Override
    public void createAndSubmitStringValueEvent(int n, String string) {
    }

    public void createAndSubmitTouchEventClick(int n, int n2, int n3) {
    }

    @Override
    public void createAndSubmitTouchEventClick(int n, int n2, int n3, int n4) {
    }

    public void createAndSubmitTouchEventDrag(int n, int n2, int n3, int n4) {
    }

    @Override
    public void createAndSubmitTouchEventDrag(int n, int n2, int n3, int n4, int n5) {
    }

    public void createAndSubmitTouchEventDrag2(int n, int n2, int n3, int n4, int n5) {
    }

    @Override
    public void createAndSubmitTouchEventDrag2(int n, int n2, int n3, int n4, int n5, int n6) {
    }

    public void createAndSubmitTouchEventFlick(int n, int n2, int n3, int n4) {
    }

    @Override
    public void createAndSubmitTouchEventFlick(int n, int n2, int n3, int n4, int n5) {
    }

    public void createAndSubmitTouchEventFlick2(int n, int n2, int n3, int n4, int n5) {
    }

    @Override
    public void createAndSubmitTouchEventFlick2(int n, int n2, int n3, int n4, int n5, int n6) {
    }

    public void createAndSubmitTouchEventMousePosition(int n, int n2) {
    }

    @Override
    public void createAndSubmitTouchEventMousePosition(int n, int n2, int n3) {
    }

    public void createAndSubmitTouchEventPress(int n, int n2) {
    }

    @Override
    public void createAndSubmitTouchEventPress(int n, int n2, int n3) {
    }

    public void createAndSubmitTouchEventPress2(int n, int n2, int n3) {
    }

    @Override
    public void createAndSubmitTouchEventPress2(int n, int n2, int n3, int n4) {
    }

    public void createAndSubmitTouchEventRelease(int n, int n2) {
    }

    @Override
    public void createAndSubmitTouchEventRelease(int n, int n2, int n3) {
    }

    public void createAndSubmitTouchEventRightClick(int n, int n2) {
    }

    @Override
    public void createAndSubmitTouchEventRightClick(int n, int n2, int n3) {
    }

    public void createAndSubmitTouchEventRotation(int n) {
    }

    @Override
    public void createAndSubmitTouchEventRotation(int n, int n2) {
    }

    public void createAndSubmitTouchEventZoom(int n, int n2, int n3, int n4) {
    }

    @Override
    public void createAndSubmitTouchEventZoom(int n, int n2, int n3, int n4, int n5) {
    }

    @Override
    public void createAndSubmitViewAnimationEvent(ViewAnimationEventConsumer viewAnimationEventConsumer, int n) {
    }

    public void createAndSubmitViewChangeEvent(int n, String string, boolean bl, int n2) {
    }

    @Override
    public void createAndSubmitViewChangeEvent(int n, String string, boolean bl, int n2, int n3) {
    }

    @Override
    public void invoke(Runnable runnable) {
    }

    @Override
    public void submitEvent(HMIEvent hMIEvent) {
    }

    @Override
    public void createAndSubmitTouchEvent(int n, int n2, int n3, int n4, int n5, int n6, int n7) {
    }

    @Override
    public void createAndSubmitProximityEvent(int n, int n2, int n3, float f2, float f3, float f4, float f5, float f6, int n4) {
    }

    @Override
    public void createAndSubmitBooleanValueEvent(AppDefinition appDefinition, AppDefinition appDefinition2, int n, boolean bl) {
    }

    @Override
    public void createAndSubmitDpChangedEvent(AppDefinition appDefinition, AppDefinition appDefinition2, int n) {
    }

    @Override
    public void createAndSubmitHMIEvent(AppDefinition appDefinition, AppDefinition appDefinition2, int n) {
    }

    @Override
    public void createAndSubmitIntegerValueEvent(AppDefinition appDefinition, AppDefinition appDefinition2, int n, int n2) {
    }

    @Override
    public void createAndSubmitPointEvent(AppDefinition appDefinition, AppDefinition appDefinition2, int n, int n2, int n3, int n4, int n5) {
    }

    @Override
    public void createAndSubmitSpellerValueEvent(AppDefinition appDefinition, AppDefinition appDefinition2, int n, String string, int n2, int n3, int n4) {
    }

    @Override
    public void createAndSubmitStringValueEvent(AppDefinition appDefinition, AppDefinition appDefinition2, int n, String string) {
    }

    @Override
    public void createAndSubmitListItemEvent(AppDefinition appDefinition, AppDefinition appDefinition2, int n, int n2, int n3, int n4, int n5, String string, long l) {
    }
}

