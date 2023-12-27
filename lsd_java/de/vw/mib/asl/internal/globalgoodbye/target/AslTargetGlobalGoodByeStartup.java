/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.globalgoodbye.target;

import de.vw.mib.asl.api.online.ASLOnlineFactory;
import de.vw.mib.asl.api.online.services.authenticate.OnlineAuthentication;
import de.vw.mib.asl.api.phone.ASLPhoneAPI;
import de.vw.mib.asl.api.phone.ASLPhoneFactory;
import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.api.system.powerstate.ClampSignalService;
import de.vw.mib.asl.internal.globalgoodbye.logging.GlobalGoodByeLogger;
import de.vw.mib.asl.internal.globalgoodbye.popup.Controller;
import de.vw.mib.asl.internal.globalgoodbye.popup.DatapoolUpdater;
import de.vw.mib.asl.internal.globalgoodbye.popup.InformationCollector;
import de.vw.mib.asl.internal.globalgoodbye.popup.Switcher;
import de.vw.mib.asl.internal.globalgoodbye.services.GlobalGoodByeServices;
import de.vw.mib.asl.internal.globalgoodbye.services.GlobalGoodByeServicesProvider;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.Target;
import de.vw.mib.hmi.utils.Preconditions;
import de.vw.mib.log4mib.Logger;

public class AslTargetGlobalGoodByeStartup
implements Target {
    private final GlobalGoodByeLogger logger;
    private final GenericEvents genericEvents;
    private final GlobalGoodByeServices services;
    static /* synthetic */ Class class$de$vw$mib$genericevents$GenericEvents;
    static /* synthetic */ Class class$java$lang$String;

    public AslTargetGlobalGoodByeStartup(GenericEvents genericEvents, String string) {
        Preconditions.checkNotNull(genericEvents, new StringBuffer().append((class$de$vw$mib$genericevents$GenericEvents == null ? (class$de$vw$mib$genericevents$GenericEvents = AslTargetGlobalGoodByeStartup.class$("de.vw.mib.genericevents.GenericEvents")) : class$de$vw$mib$genericevents$GenericEvents).getName()).append(" must not be null!").toString());
        Preconditions.checkNotNull(string, new StringBuffer().append((class$java$lang$String == null ? (class$java$lang$String = AslTargetGlobalGoodByeStartup.class$("java.lang.String")) : class$java$lang$String).getName()).append(" must not be null!").toString());
        this.services = GlobalGoodByeServicesProvider.getGlobalGoodByeServices();
        this.logger = new GlobalGoodByeLogger(this.services.getLogger(), super.getClass());
        this.genericEvents = genericEvents;
        genericEvents.getEventDispatcher().registerTarget(this.getTargetId(), this, string);
    }

    @Override
    public GenericEvents getMainObject() {
        return this.genericEvents;
    }

    @Override
    public int getTargetId() {
        return 851516672;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        int n = eventGeneric.getReceiverEventId();
        switch (n) {
            case 106: {
                this.logger.info("IdEvent.POWER_ON received.");
                this.createPopUpController();
                break;
            }
        }
    }

    private void createPopUpController() {
        Logger logger = this.services.getLogger();
        OnlineAuthentication onlineAuthentication = ASLOnlineFactory.getAuthenticationService();
        ASLPhoneAPI aSLPhoneAPI = ASLPhoneFactory.getPhoneApi();
        InformationCollector informationCollector = new InformationCollector(logger, onlineAuthentication, aSLPhoneAPI);
        ClampSignalService clampSignalService = ASLSystemFactory.getSystemApi().getClampSignalService();
        DatapoolUpdater datapoolUpdater = new DatapoolUpdater(this.services.getAslPropertyManager());
        Switcher switcher = new Switcher(this.services.getSystemEventDispatcher());
        new Controller(logger, informationCollector, datapoolUpdater, switcher, clampSignalService);
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

