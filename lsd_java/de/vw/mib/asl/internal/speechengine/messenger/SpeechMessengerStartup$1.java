/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.messenger;

import de.vw.mib.asl.api.speechengine.messenger.application.ApplicationStateRouter;
import de.vw.mib.asl.api.speechengine.messenger.backstack.BackstackStateRouter;
import de.vw.mib.asl.api.speechengine.messenger.dialog.DialogStateRouter;
import de.vw.mib.asl.api.speechengine.messenger.indicator.IndicatorStateRouter;
import de.vw.mib.asl.api.speechengine.messenger.slot.SlotStateRouter;
import de.vw.mib.asl.internal.speechengine.messenger.BackstackStatePublisher;
import de.vw.mib.asl.internal.speechengine.messenger.BackstackStateRouterImpl;
import de.vw.mib.asl.internal.speechengine.messenger.DialogSystemPublisher;
import de.vw.mib.asl.internal.speechengine.messenger.DialogSystemRouterImpl;
import de.vw.mib.asl.internal.speechengine.messenger.HmiEventPublisher;
import de.vw.mib.asl.internal.speechengine.messenger.HmiEventRouterImpl;
import de.vw.mib.asl.internal.speechengine.messenger.SpeechMessengerStartup;
import de.vw.mib.asl.internal.speechengine.messenger.start.SpeechMessengerServices;

class SpeechMessengerStartup$1
implements SpeechMessengerServices {
    private final /* synthetic */ DialogSystemRouterImpl val$dialogSystemRouter;
    private final /* synthetic */ HmiEventRouterImpl val$hmiEventRouter;
    private final /* synthetic */ BackstackStateRouterImpl val$backstackRouter;
    private final /* synthetic */ SpeechMessengerStartup this$0;

    SpeechMessengerStartup$1(SpeechMessengerStartup speechMessengerStartup, DialogSystemRouterImpl dialogSystemRouterImpl, HmiEventRouterImpl hmiEventRouterImpl, BackstackStateRouterImpl backstackStateRouterImpl) {
        this.this$0 = speechMessengerStartup;
        this.val$dialogSystemRouter = dialogSystemRouterImpl;
        this.val$hmiEventRouter = hmiEventRouterImpl;
        this.val$backstackRouter = backstackStateRouterImpl;
    }

    @Override
    public DialogSystemPublisher getDialogSystemPublisher() {
        return this.val$dialogSystemRouter;
    }

    @Override
    public IndicatorStateRouter getIndicatorStateRouter() {
        return this.val$dialogSystemRouter;
    }

    @Override
    public HmiEventPublisher getHmiEventPublisher() {
        return this.val$hmiEventRouter;
    }

    @Override
    public DialogStateRouter getDialogStateRouter() {
        return this.val$dialogSystemRouter;
    }

    @Override
    public BackstackStatePublisher getBackstackStatePublisher() {
        return this.val$backstackRouter;
    }

    @Override
    public BackstackStateRouter getBackstackStateRouter() {
        return this.val$backstackRouter;
    }

    @Override
    public SlotStateRouter getSlotStateRouter() {
        return this.val$dialogSystemRouter;
    }

    @Override
    public ApplicationStateRouter getApplicationStateRouter() {
        return this.val$dialogSystemRouter;
    }
}

