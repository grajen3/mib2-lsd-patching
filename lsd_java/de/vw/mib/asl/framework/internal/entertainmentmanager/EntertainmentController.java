/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.entertainmentmanager;

import de.vw.mib.asl.framework.api.entertainmentmanager.EntertainmentActivation;
import de.vw.mib.asl.framework.api.entertainmentmanager.EntertainmentManagerUpdates;
import de.vw.mib.asl.framework.api.entertainmentmanager.core.ActivationRequest;
import de.vw.mib.asl.framework.api.entertainmentmanager.participant.EntertainmentManagerParticipantService;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.internal.entertainmentmanager.DnUpQueue;
import de.vw.mib.asl.framework.internal.entertainmentmanager.EntertainmentManagerLastmodes;
import de.vw.mib.asl.framework.internal.entertainmentmanager.EntertainmentManagerListeners;
import de.vw.mib.asl.framework.internal.entertainmentmanager.LegacyActivation;
import de.vw.mib.asl.framework.internal.entertainmentmanager.LegacyActivationStartup;
import de.vw.mib.asl.framework.internal.entertainmentmanager.LegacyCallbackReceiver;
import de.vw.mib.asl.framework.internal.entertainmentmanager.TargetRegistry;
import de.vw.mib.asl.framework.internal.entertainmentmanager.activations.AbsoluteActivation;
import de.vw.mib.asl.framework.internal.entertainmentmanager.api.impl.ASLEntertainmentmanagerAPIImpl;
import de.vw.mib.asl.framework.internal.entertainmentmanager.core.EntertainmentCore;
import de.vw.mib.asl.framework.internal.entertainmentmanager.has.EntertainmentManagerServicesAdapterImpl;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Loggable;

public final class EntertainmentController
implements LegacyCallbackReceiver,
Loggable {
    public static final int STARTUP2_ANSWER;
    public static final int EV_ADD_UPDATES;
    public static final int WAIT_FOR_ACTIVATED_TIME;
    private AbsoluteActivation switchingActivate;
    private EntertainmentManagerLastmodes lastmodes;
    private final TargetRegistry targetRegistry = new TargetRegistry();
    private final DnUpQueue dnUpQueue = new DnUpQueue();
    private final EntertainmentManagerServicesAdapterImpl hasService;
    private final EntertainmentCore core;
    private final EntertainmentManagerParticipantService participantService;
    private static final int[] OBSERVER_MEDIA_SOURCE_ACTIVATION;
    private Runnable onActivated;
    private Runnable onDeactivated;
    static /* synthetic */ Class class$de$vw$mib$asl$framework$api$entertainmentmanager$participant$EntertainmentManagerParticipantService;

    private static boolean isTraceEnabled() {
        return ServiceManager.logger2.isTraceEnabled(16);
    }

    private static LogMessage trace() {
        return ServiceManager.logger2.trace(16);
    }

    private static void trace(String string) {
        if (ServiceManager.logger2.isTraceEnabled(16)) {
            ServiceManager.logger2.trace(16, string);
        }
    }

    private static void warn(String string, int n) {
        ServiceManager.logger2.warn(16).append(string).append(n).log();
    }

    public EntertainmentController(EntertainmentCore entertainmentCore, EntertainmentManagerParticipantService entertainmentManagerParticipantService) {
        this.core = entertainmentCore;
        this.participantService = entertainmentManagerParticipantService;
        this.hasService = new EntertainmentManagerServicesAdapterImpl();
        this.hasService.register();
    }

    public TargetRegistry getTargetRegistry() {
        return this.targetRegistry;
    }

    public int[] getActivationEvents() {
        return OBSERVER_MEDIA_SOURCE_ACTIVATION;
    }

    public boolean checkActivate(String string, EventGeneric eventGeneric) {
        AbsoluteActivation absoluteActivation;
        boolean bl = true;
        switch (eventGeneric.getReceiverEventId()) {
            case 1400009: 
            case 1400014: {
                if (EntertainmentController.isTraceEnabled()) {
                    EntertainmentController.trace().append(string).append("State: Received REQUEST_INDEPENDENT_BROWSING/MEDIA_SOURCE_ADDED. subcontext=").append(eventGeneric.getInt(0)).log();
                }
                absoluteActivation = EntertainmentController.activationFromSourceChange(eventGeneric);
                break;
            }
            case 1400021: {
                absoluteActivation = (AbsoluteActivation)eventGeneric.getObject(-1067707136);
                if (absoluteActivation.equals(this.lastmodes.getActive()) && absoluteActivation.getContext() == 1) {
                    absoluteActivation.setCause(eventGeneric.getReceiverEventId());
                    this.reportSuccessToHAS(absoluteActivation, true);
                    return false;
                }
                if (!EntertainmentController.isTraceEnabled()) break;
                EntertainmentController.trace().append(string).append("State: Received REQUEST_ACTIVATION_HAS. aslDeviceId=").append(absoluteActivation).log();
                break;
            }
            case 1400020: {
                absoluteActivation = EntertainmentController.activationFromSourceChange(eventGeneric);
                EntertainmentController.trace(new StringBuffer().append(string).append("State: Received ASLEntertainmentmanagerServiceIds.WEAK_REQUEST. ").append(absoluteActivation).toString());
                this.resetContext(absoluteActivation);
                if (!this.lastmodes.getActive().isContextChangeRequired(absoluteActivation)) break;
                return false;
            }
            case 1073743087: {
                int n = eventGeneric.getInt(0);
                if (this.core.getLastRequestedContext() == n) {
                    if (EntertainmentController.isTraceEnabled()) {
                        EntertainmentController.trace().append(string).append("State: Received CURRENT_AUDIO_COMPONENT. context = ").append(n).append(" -> ignoring").log();
                    }
                    return false;
                }
                absoluteActivation = this.lastmodes.getContextLastmode(n);
                absoluteActivation.setExplicitContextRequest(true);
                if (!EntertainmentController.isTraceEnabled()) break;
                EntertainmentController.trace().append(string).append("State: Received CURRENT_AUDIO_COMPONENT. context = ").append(n).log();
                break;
            }
            case 1073742979: {
                int n = eventGeneric.getInt(0);
                EntertainmentController.trace(new StringBuffer().append(string).append("State: Received ACTIVATE_BAND. band = ").append(n).toString());
                absoluteActivation = new AbsoluteActivation(1, n);
                if (!this.targetRegistry.isContextRegistered(1)) break;
                this.targetRegistry.get(1).setDatapoolValue(n);
                break;
            }
            case 1073744047: {
                if (EntertainmentController.isTraceEnabled()) {
                    EntertainmentController.trace().append(string).append("State: Received ASLTVTunerServiceConstants.TV_CONTEXT_ENTERED").log();
                }
                absoluteActivation = this.lastmodes.getContextLastmode(5);
                break;
            }
            case 1400025: {
                if (EntertainmentController.isTraceEnabled()) {
                    EntertainmentController.trace().append(string).append("State: Received ASLEntertainmentmanagerServiceIds.ACTIVATE_CONTEXT").log();
                }
                int n = eventGeneric.getInt(0);
                absoluteActivation = this.lastmodes.getContextLastmode(n);
                bl = false;
                if (!EntertainmentController.isTraceEnabled()) break;
                EntertainmentController.trace().append(string).append("State: Received ACTIVATE_CONTEXT. context = ").append(n).log();
                break;
            }
            case 0x155CCC: {
                if (EntertainmentController.isTraceEnabled()) {
                    EntertainmentController.trace().append(string).append("State: Received EXBOX_REQUESTED, subcontext=").append(eventGeneric.getInt(0)).log();
                }
                absoluteActivation = new AbsoluteActivation(4, eventGeneric.getInt(0));
                break;
            }
            case 1400017: {
                AbsoluteActivation absoluteActivation2 = EntertainmentController.activationFromSourceChange(eventGeneric);
                if (EntertainmentController.isTraceEnabled()) {
                    EntertainmentController.trace().append(string).append("State: Received REQUESTSOURCE_BTN_DN for ").append(absoluteActivation2).log();
                }
                this.dnUpQueue.add(absoluteActivation2);
                return false;
            }
            case 1400018: {
                absoluteActivation = EntertainmentController.activationFromSourceChange(eventGeneric);
                if (EntertainmentController.isTraceEnabled()) {
                    EntertainmentController.trace().append(string).append("State: Received REQUESTSOURCE_BTN_UP for ").append(absoluteActivation).log();
                }
                if (this.dnUpQueue.pop(absoluteActivation)) break;
                return false;
            }
            case 1400019: {
                if (EntertainmentController.isTraceEnabled()) {
                    EntertainmentController.trace().append(string).append("State: Received EMTPY_DN_UP_QUEUE for ").log();
                }
                this.dnUpQueue.empty();
                return false;
            }
            default: {
                return false;
            }
        }
        if (absoluteActivation.getContext() == 2 && absoluteActivation.getSubcontext() == this.lastmodes.getActive().getSubcontext() && absoluteActivation.getSubcontext() >> 16 != 0) {
            if (EntertainmentController.isTraceEnabled()) {
                EntertainmentController.trace().append(string).append("State: Activation (").append(absoluteActivation).append(" ) == persistence.getActive() (").append(this.lastmodes.getActive()).append(") -> Ignoring!").log();
            }
            return false;
        }
        if (eventGeneric.getReceiverEventId() != -765717248) {
            this.dnUpQueue.empty();
        }
        if (this.isRegistered(absoluteActivation) && !this.targetRegistry.get(absoluteActivation.getContext()).preActivate(absoluteActivation.getSubcontext(), bl)) {
            if (!absoluteActivation.isExplicitContextRequest()) {
                return false;
            }
            absoluteActivation = new AbsoluteActivation(absoluteActivation.getContext(), 0);
        }
        if (absoluteActivation.isContextChangeRequired(this.lastmodes.getActive()) && this.isRegistered(absoluteActivation)) {
            this.targetRegistry.get(absoluteActivation.getContext()).changeView();
        }
        absoluteActivation.setCause(eventGeneric.getReceiverEventId());
        this.saveContexts(absoluteActivation);
        if (this.participantService.isRegistered(absoluteActivation.getContext())) {
            this.participantService.requestContext(absoluteActivation.getContext());
        }
        return true;
    }

    private void reportToSuperior(boolean bl) {
        this.reportSuccessToHAS(this.switchingActivate, bl);
    }

    private void reportSuccessToHAS(AbsoluteActivation absoluteActivation, boolean bl) {
        if (absoluteActivation.getCause() == -715385600) {
            this.hasService.respond(absoluteActivation.getContext(), absoluteActivation.getCallId(), bl);
        }
    }

    public void initPersistence() {
        this.lastmodes = new EntertainmentManagerLastmodes();
        this.lastmodes.initPersistence();
        ASLEntertainmentmanagerAPIImpl.getInstance().setActive(this.lastmodes.getActive());
        this.core.powerOn(this.lastmodes);
        ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLComponentRegistry().registerAPI(class$de$vw$mib$asl$framework$api$entertainmentmanager$participant$EntertainmentManagerParticipantService == null ? (class$de$vw$mib$asl$framework$api$entertainmentmanager$participant$EntertainmentManagerParticipantService = EntertainmentController.class$("de.vw.mib.asl.framework.api.entertainmentmanager.participant.EntertainmentManagerParticipantService")) : class$de$vw$mib$asl$framework$api$entertainmentmanager$participant$EntertainmentManagerParticipantService, this.participantService);
    }

    private void saveContexts(AbsoluteActivation absoluteActivation) {
        EntertainmentManagerListeners.getInstance().updateEntertainmentSource(absoluteActivation.getEntertainmentManagerListenerConstant());
        this.lastmodes.setContextLastmode(absoluteActivation);
        this.lastmodes.setLastmodes(absoluteActivation);
        ASLEntertainmentmanagerAPIImpl.getInstance().setActive(absoluteActivation);
        if (ServiceManager.logger2.isTraceEnabled(16)) {
            ServiceManager.logger2.trace(16).append("EntertainmentManagerTarget.saveLastContext() ").append(this).log();
        }
    }

    private void resetContext(AbsoluteActivation absoluteActivation) {
        this.lastmodes.resetContext(absoluteActivation);
    }

    public AbsoluteActivation getContextLastmode(int n) {
        if (this.lastmodes.getActive().getContext() == n) {
            return this.lastmodes.getActive();
        }
        return this.lastmodes.getContextLastmode(n);
    }

    public static AbsoluteActivation activationFromSourceChange(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(1);
        AbsoluteActivation absoluteActivation = new AbsoluteActivation(n, eventGeneric.getInt(0));
        if (n == 6) {
            absoluteActivation.setTargetId(eventGeneric.getSenderTargetId());
        }
        return absoluteActivation;
    }

    private int getTargetId(EntertainmentActivation entertainmentActivation) {
        int n = entertainmentActivation.getContext();
        int n2 = this.targetRegistry.getTargetIdForContext(n);
        if (n2 <= 0) {
            EntertainmentController.warn("EntertainmentController.getTargetId() no target registered for context ", n);
        }
        return n2;
    }

    private boolean isRegistered(EntertainmentActivation entertainmentActivation) {
        return entertainmentActivation != null && this.targetRegistry.isContextRegistered(entertainmentActivation.getContext());
    }

    public boolean sendRestoreLsmStartup(int n, int n2) {
        boolean bl;
        int n3 = this.lastmodes.getActive().getContext();
        if (this.switchingActivate == null) {
            this.switchingActivate = this.lastmodes.getActive();
        }
        LegacyActivationStartup legacyActivationStartup = new LegacyActivationStartup(this, n2, this.lastmodes.getContextLastmode(n3));
        int n4 = this.lastmodes.getContextLastmode(n).getSubcontext();
        if (n4 != -1) {
            this.targetRegistry.get(n).setDatapoolValue(n4);
        }
        if (EntertainmentController.isTraceEnabled()) {
            EntertainmentController.trace().append("sending Restore LSM to context ").append(n).append(" activeContext=").append(n3).append(" active subcontext=").append(this.lastmodes.getActive().getSubcontext()).log();
        }
        boolean bl2 = bl = n == n3;
        if (bl) {
            this.targetRegistry.get(n).changeView();
            legacyActivationStartup.context = n3;
            legacyActivationStartup.yoursubcontext = this.lastmodes.getContextLastmode(n).getSubcontext();
            this.core.request(legacyActivationStartup);
        } else {
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(272503040, this.targetRegistry.getTargetIdForContext(n), -1000598272);
            eventGeneric.setInt(0, n3);
            eventGeneric.setInt(1, n4);
            ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
        }
        return bl;
    }

    public void sendStartup2(int n) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(272503040, Math.abs(this.targetRegistry.getTargetIdForContext(n)), -799271680);
        boolean bl = this.lastmodes.getActive().getContext() == n;
        eventGeneric.setBoolean(0, bl);
        eventGeneric.setInt(1, this.lastmodes.getContextLastmode(n).getSubcontext());
        eventGeneric.setInt(2, n);
        eventGeneric.setSenderEventId(-1568276224);
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
        if (EntertainmentController.isTraceEnabled()) {
            EntertainmentController.trace().append("sending STARTUP2/ Restore LSM to context ").append(n).append(" activeContext=").append(bl).append(" active subcontext=").append(this.lastmodes.getActive().getSubcontext()).log();
        }
    }

    public void startup2Answer(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(2);
        this.targetRegistry.finishHandshake(n);
        AbsoluteActivation absoluteActivation = this.lastmodes.getActive();
        if (absoluteActivation.getContext() == n) {
            absoluteActivation.setExplicitContextRequest(false);
            this.core.request(new LegacyActivation(this, this.targetRegistry.getTargetIdForContext(n), absoluteActivation));
        }
    }

    @Override
    public void toString(LogMessage logMessage) {
        logMessage.append("Controller state: switching=").append(this.switchingActivate).append(this.lastmodes);
    }

    public void addUpdates(EntertainmentManagerUpdates entertainmentManagerUpdates) {
        this.lastmodes.addUpdates(entertainmentManagerUpdates);
    }

    @Override
    public void setOnActivated(Runnable runnable, AbsoluteActivation absoluteActivation) {
        this.switchingActivate = absoluteActivation;
        this.onActivated = runnable;
    }

    @Override
    public void setOnDeactivated(Runnable runnable) {
        this.onDeactivated = runnable;
    }

    public void activated() {
        this.reportToSuperior(true);
        if (this.onActivated != null) {
            Runnable runnable = this.onActivated;
            this.onActivated = null;
            runnable.run();
        }
    }

    public void deactivated() {
        if (this.onDeactivated != null) {
            Runnable runnable = this.onDeactivated;
            this.onDeactivated = null;
            runnable.run();
        }
    }

    public void activate(ActivationRequest activationRequest) {
        this.core.request(activationRequest);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        WAIT_FOR_ACTIVATED_TIME = Integer.getInteger("de.vw.mib.asl.entertainmentmanager.WAIT_FOR_ACTIVATED_TIME", -1059847936);
        OBSERVER_MEDIA_SOURCE_ACTIVATION = new int[]{0x2000040, 738852928, 0x5000040, 0x8000040, -2091970048, -284950464, -2096889792, -1358430144};
    }
}

