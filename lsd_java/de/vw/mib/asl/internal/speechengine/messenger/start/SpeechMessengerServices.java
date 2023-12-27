/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.messenger.start;

import de.vw.mib.asl.api.speechengine.messenger.application.ApplicationStateRouter;
import de.vw.mib.asl.api.speechengine.messenger.backstack.BackstackStateRouter;
import de.vw.mib.asl.api.speechengine.messenger.dialog.DialogStateRouter;
import de.vw.mib.asl.api.speechengine.messenger.indicator.IndicatorStateRouter;
import de.vw.mib.asl.api.speechengine.messenger.slot.SlotStateRouter;
import de.vw.mib.asl.internal.speechengine.messenger.BackstackStatePublisher;
import de.vw.mib.asl.internal.speechengine.messenger.DialogSystemPublisher;
import de.vw.mib.asl.internal.speechengine.messenger.HmiEventPublisher;

public interface SpeechMessengerServices {
    default public BackstackStatePublisher getBackstackStatePublisher() {
    }

    default public DialogSystemPublisher getDialogSystemPublisher() {
    }

    default public ApplicationStateRouter getApplicationStateRouter() {
    }

    default public HmiEventPublisher getHmiEventPublisher() {
    }

    default public BackstackStateRouter getBackstackStateRouter() {
    }

    default public DialogStateRouter getDialogStateRouter() {
    }

    default public IndicatorStateRouter getIndicatorStateRouter() {
    }

    default public SlotStateRouter getSlotStateRouter() {
    }
}

