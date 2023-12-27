/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechphone.speechphone.start;

import de.vw.mib.asl.api.speechengine.dialogmanager.DialogBackstack;
import de.vw.mib.asl.api.speechengine.messenger.dialog.DialogStateRouter;
import de.vw.mib.asl.api.speechengine.result.handling.ResultControllerRouter;
import de.vw.mib.asl.api.speechengine.result.handling.ResultItemHandler;
import de.vw.mib.asl.api.speechengine.slots.SlotUpdater;
import de.vw.mib.asl.internal.speechphone.communication.mainmenu.MainMenuRequestHandler;
import de.vw.mib.asl.internal.speechphone.communication.phone.CallstackNumberHandler;
import de.vw.mib.asl.internal.speechphone.communication.teleprompter.TeleprompterStateHandler;
import de.vw.mib.asl.internal.speechphone.controller.AbstractCombinedAction;
import de.vw.mib.asl.internal.speechphone.controller.AdjustmentController;
import de.vw.mib.asl.internal.speechphone.controller.DialEmergencyAction;
import de.vw.mib.asl.internal.speechphone.controller.DialInformationAction;
import de.vw.mib.asl.internal.speechphone.controller.DialMailboxAction;
import de.vw.mib.asl.internal.speechphone.controller.DialNumberCorrectAction;
import de.vw.mib.asl.internal.speechphone.controller.DialNumberDeleteAction;
import de.vw.mib.asl.internal.speechphone.controller.DialNumberDialingAction;
import de.vw.mib.asl.internal.speechphone.controller.DialNumberGlobalAction;
import de.vw.mib.asl.internal.speechphone.controller.DialNumberNoCorrectController;
import de.vw.mib.asl.internal.speechphone.controller.DialNumberRowNumberController;
import de.vw.mib.asl.internal.speechphone.controller.DialNumberXDialogController;
import de.vw.mib.asl.internal.speechphone.controller.DialNumberXGlobalController;
import de.vw.mib.asl.internal.speechphone.controller.DialServiceAction;
import de.vw.mib.asl.internal.speechphone.controller.RequestVisibilityAction;
import de.vw.mib.asl.internal.speechphone.controller.SimpleCheckedPhoneAction;
import de.vw.mib.asl.internal.speechphone.controller.TriggerDialingAction;
import de.vw.mib.asl.internal.speechphone.controller.callstacks.CallstackListController;
import de.vw.mib.asl.internal.speechphone.controller.callstacks.CallstackNbestController;
import de.vw.mib.asl.internal.speechphone.controller.callstacks.RedialAction;
import de.vw.mib.asl.internal.speechphone.controller.contact.ContactNBestController;
import de.vw.mib.asl.internal.speechphone.controller.contact.DialContactAction;
import de.vw.mib.asl.internal.speechphone.controller.contact.ImmediateSelectedContactHandler;
import de.vw.mib.asl.internal.speechphone.controller.contact.LocTypeIndexHandler;
import de.vw.mib.asl.internal.speechphone.controller.contact.NumberListController;
import de.vw.mib.asl.internal.speechphone.controller.contact.PropagatingSelectedContactHandler;
import de.vw.mib.asl.internal.speechphone.controller.contact.SelectedNumberHandler;
import de.vw.mib.asl.internal.speechphone.controller.contact.TriggerDialingContactAction;
import de.vw.mib.asl.internal.speechphone.service.ContactAdditionalDataService;
import de.vw.mib.asl.internal.speechphone.service.NumberDataService;
import de.vw.mib.asl.internal.speechphone.speechphone.start.SpeechPhoneParameters;
import de.vw.mib.asl.internal.speechphone.utils.ServiceFunctions;
import de.vw.mib.asl.internal.speechphone.utils.SpeechPhoneLogger2;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.Target;

public class SpeechPhoneInternalStartTarget
implements Target {
    private final SpeechPhoneLogger2 logger;
    private final ResultControllerRouter registry;
    private final GenericEvents genericEvents;
    private final TeleprompterStateHandler teleprompterStateHandler;
    private final CallstackNumberHandler callstackNumberHandler;
    static /* synthetic */ Class class$de$vw$mib$asl$api$speechengine$contexts$SpeechContext;

    public SpeechPhoneInternalStartTarget(SpeechPhoneParameters speechPhoneParameters) {
        ServiceFunctions serviceFunctions = new ServiceFunctions(speechPhoneParameters, this.getTargetId());
        this.logger = serviceFunctions.createLogger("SpeechPhoneInternalStartTarget");
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("starting up..");
        }
        this.genericEvents = speechPhoneParameters.genericEvents();
        try {
            speechPhoneParameters.eventDispatcher().registerTarget(this.getTargetId(), this, speechPhoneParameters.taskId());
        }
        catch (Exception exception) {
            this.logger.error("Couldn't register internal target");
        }
        this.registry = speechPhoneParameters.resultControllerRouter();
        this.teleprompterStateHandler = new TeleprompterStateHandler(serviceFunctions, speechPhoneParameters.teleprompterManager());
        this.callstackNumberHandler = new CallstackNumberHandler(serviceFunctions, speechPhoneParameters.slotStateRouter(), speechPhoneParameters.slotUpdater(), speechPhoneParameters.phoneService(), speechPhoneParameters.callstackService(), speechPhoneParameters.audioAccessor(), speechPhoneParameters.dialogStateRouter());
        speechPhoneParameters.serviceRegister().addObserver(2005023552, this.getTargetId());
        this.registerControllers(speechPhoneParameters, serviceFunctions);
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("fire event: SYSTEM_SPEECH_PHONE_READY.");
        }
        serviceFunctions.sendHMIEvent(1957247744);
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        if (eventGeneric.getReceiverEventId() == 2005023552) {
            this.teleprompterStateHandler.teleprompterButtonPressed();
        } else if (this.registry != null) {
            this.registry.onEvent(eventGeneric);
        }
    }

    protected void registerControllers(SpeechPhoneParameters speechPhoneParameters, ServiceFunctions serviceFunctions) {
        ResultItemHandler resultItemHandler = speechPhoneParameters.resultItemHandler();
        SlotUpdater slotUpdater = speechPhoneParameters.slotUpdater();
        DialogStateRouter dialogStateRouter = speechPhoneParameters.dialogStateRouter();
        DialogBackstack dialogBackstack = speechPhoneParameters.dialogBackstack();
        SimpleCheckedPhoneAction simpleCheckedPhoneAction = new SimpleCheckedPhoneAction(serviceFunctions, 1974024960, 1, this.callstackNumberHandler);
        this.registerPhoneAction(serviceFunctions, 1619147584, simpleCheckedPhoneAction);
        MainMenuRequestHandler mainMenuRequestHandler = new MainMenuRequestHandler(serviceFunctions, simpleCheckedPhoneAction);
        speechPhoneParameters.bundleContext().registerService(new String[]{(class$de$vw$mib$asl$api$speechengine$contexts$SpeechContext == null ? (class$de$vw$mib$asl$api$speechengine$contexts$SpeechContext = SpeechPhoneInternalStartTarget.class$("de.vw.mib.asl.api.speechengine.contexts.SpeechContext")) : class$de$vw$mib$asl$api$speechengine$contexts$SpeechContext).getName()}, (Object)mainMenuRequestHandler, null);
        serviceFunctions.addObserver(-1568523456);
        this.registry.register(new RequestVisibilityAction(speechPhoneParameters.cioDictionary(), speechPhoneParameters.cioDispatcher()), -1568523456, 0);
        AdjustmentController adjustmentController = new AdjustmentController(speechPhoneParameters.dialogManager());
        this.registry.register(adjustmentController, -1551746240, 0);
        this.registerSimpleCommandAction(serviceFunctions, 1635924800, 2, 1990802176);
        this.registerSimpleCommandAction(serviceFunctions, 1652702016, 5, 2007579392);
        this.registerSimpleCommandAction(serviceFunctions, 1669479232, 3, 2024356608);
        this.registerSimpleCommandAction(serviceFunctions, 1686256448, 7, 2041133824);
        this.registerSimpleCommandAction(serviceFunctions, 1703033664, 6, 2057911040);
        this.registerSimpleCommandAction(serviceFunctions, 1719810880, 11, 2074688256);
        this.registerSimpleCommandAction(serviceFunctions, 1736588096, 4, 2091465472);
        this.registerSimpleCommandAction(serviceFunctions, 1753365312, 12, 2108242688);
        this.registerSimpleCommandAction(serviceFunctions, 1770142528, 13, 2125019904);
        this.registerSimpleCommandAction(serviceFunctions, 1786919744, 14, 2141797120);
        this.registerPhoneAction(serviceFunctions, 1803696960, new DialNumberGlobalAction(serviceFunctions, this.callstackNumberHandler));
        this.registerPhoneAction(serviceFunctions, 1971469120, new DialNumberXGlobalController(serviceFunctions, this.callstackNumberHandler, resultItemHandler));
        this.registerPhoneAction(serviceFunctions, 2122464064, new DialNumberXDialogController(serviceFunctions, this.callstackNumberHandler, resultItemHandler));
        this.registerPhoneAction(serviceFunctions, 2139241280, new DialNumberNoCorrectController(serviceFunctions, this.callstackNumberHandler, resultItemHandler));
        this.registerPhoneAction(serviceFunctions, -2071839936, new DialNumberRowNumberController(serviceFunctions, this.callstackNumberHandler, resultItemHandler));
        this.registerPhoneAction(serviceFunctions, -2138948800, new DialNumberCorrectAction(serviceFunctions, this.callstackNumberHandler));
        this.registerPhoneAction(serviceFunctions, -2122171584, new DialNumberDeleteAction(serviceFunctions, this.callstackNumberHandler));
        this.registerSimpleCommandAction(serviceFunctions, -2105394368, 3, -1683408128);
        this.registerPhoneAction(serviceFunctions, -2088617152, new DialNumberDialingAction(serviceFunctions, this.callstackNumberHandler));
        this.registerPhoneAction(serviceFunctions, 2072132416, new TriggerDialingAction(this.callstackNumberHandler, dialogStateRouter));
        this.registerPhoneAction(serviceFunctions, 1820474176, new RedialAction(serviceFunctions, this.callstackNumberHandler));
        this.registerPhoneAction(serviceFunctions, 1837251392, new DialContactAction(serviceFunctions, this.callstackNumberHandler, dialogBackstack, -2102838528));
        this.registerPhoneAction(serviceFunctions, -1753072832, new DialContactAction(serviceFunctions, this.callstackNumberHandler, dialogBackstack, -1112982784));
        LocTypeIndexHandler locTypeIndexHandler = new LocTypeIndexHandler(serviceFunctions, resultItemHandler);
        SelectedNumberHandler selectedNumberHandler = new SelectedNumberHandler(serviceFunctions, this.callstackNumberHandler);
        ContactNBestController contactNBestController = new ContactNBestController(serviceFunctions, new ContactAdditionalDataService(serviceFunctions, speechPhoneParameters.contactDetailsService()), speechPhoneParameters.resultListHandler(), new PropagatingSelectedContactHandler(serviceFunctions, locTypeIndexHandler, selectedNumberHandler, slotUpdater), this.callstackNumberHandler);
        this.registry.register(contactNBestController, 1988246336);
        this.registry.register(contactNBestController, 1854028608);
        this.registry.register(new NumberListController(serviceFunctions, new NumberDataService(serviceFunctions), speechPhoneParameters.resultListHandler(), new ImmediateSelectedContactHandler(serviceFunctions, locTypeIndexHandler, selectedNumberHandler), dialogBackstack, resultItemHandler), -1719518400);
        this.registerPhoneAction(serviceFunctions, -1769850048, new TriggerDialingContactAction(this.callstackNumberHandler, dialogStateRouter, selectedNumberHandler));
        CallstackListController callstackListController = new CallstackListController(serviceFunctions, this.callstackNumberHandler, speechPhoneParameters.resultItemRowNumberHandler());
        this.registry.register(callstackListController, 1870805824);
        this.registry.register(callstackListController, 2021800768);
        this.registry.register(callstackListController, 2038577984);
        this.registry.register(callstackListController, 2055355200);
        this.registry.register(callstackListController, -1618855104);
        this.registry.register(callstackListController, 1870805824);
        this.registry.register(callstackListController, 2021800768);
        this.registry.register(callstackListController, 2038577984);
        this.registry.register(callstackListController, 2055355200);
        CallstackNbestController callstackNbestController = new CallstackNbestController(serviceFunctions, this.callstackNumberHandler, speechPhoneParameters.resultListHandler());
        this.registry.register(callstackNbestController, -1685963968);
        this.registerPhoneAction(serviceFunctions, 1887583040, new DialMailboxAction(serviceFunctions, this.callstackNumberHandler));
        this.registerPhoneAction(serviceFunctions, 1921137472, new DialEmergencyAction(serviceFunctions, this.callstackNumberHandler));
        this.registerPhoneAction(serviceFunctions, 1937914688, new DialServiceAction(serviceFunctions, this.callstackNumberHandler));
        this.registerPhoneAction(serviceFunctions, 1954691904, new DialInformationAction(serviceFunctions, this.callstackNumberHandler));
        speechPhoneParameters.serviceRegister().addObserver(new int[]{-1870513344, -1853736128, -1719518400, -1685963968, -1669186752, 1870805824, 2021800768, 2038577984, 2055355200, -1551746240}, this.getTargetId());
    }

    private void registerSimpleCommandAction(ServiceFunctions serviceFunctions, int n, int n2, int n3) {
        SimpleCheckedPhoneAction simpleCheckedPhoneAction = new SimpleCheckedPhoneAction(serviceFunctions, n3, n2, this.callstackNumberHandler);
        serviceFunctions.addObserver(n);
        this.registry.register(simpleCheckedPhoneAction, n);
        this.registry.register(simpleCheckedPhoneAction, n);
    }

    private void registerPhoneAction(ServiceFunctions serviceFunctions, int n, AbstractCombinedAction abstractCombinedAction) {
        serviceFunctions.addObserver(n);
        this.registry.register(abstractCombinedAction, n);
        this.registry.register(abstractCombinedAction, n);
    }

    @Override
    public GenericEvents getMainObject() {
        return this.genericEvents;
    }

    @Override
    public int getTargetId() {
        return 1683233024;
    }

    @Override
    public void setTargetId(int n) {
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

