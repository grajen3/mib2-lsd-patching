/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.globalgoodbye.popup;

import de.vw.mib.asl.api.online.services.authenticate.OnlineAuthentication;
import de.vw.mib.asl.api.phone.ASLPhoneAPI;
import de.vw.mib.asl.internal.globalgoodbye.logging.GlobalGoodByeLogger;
import de.vw.mib.asl.internal.globalgoodbye.popup.InformationContainer;
import de.vw.mib.asl.internal.globalgoodbye.popup.InformationContainerFactory;
import de.vw.mib.hmi.utils.Preconditions;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.util.Util;

public class InformationCollector {
    private final GlobalGoodByeLogger logger;
    private InformationContainer infoContainer;
    private final OnlineAuthentication authenticationService;
    private final ASLPhoneAPI aslPhoneApi;
    static /* synthetic */ Class class$de$vw$mib$log4mib$Logger;
    static /* synthetic */ Class class$de$vw$mib$asl$api$online$services$authenticate$OnlineAuthentication;
    static /* synthetic */ Class class$de$vw$mib$asl$api$phone$ASLPhoneAPI;

    public InformationCollector(Logger logger, OnlineAuthentication onlineAuthentication, ASLPhoneAPI aSLPhoneAPI) {
        Preconditions.checkNotNull(logger, new StringBuffer().append("The given instance of class ").append((class$de$vw$mib$log4mib$Logger == null ? (class$de$vw$mib$log4mib$Logger = InformationCollector.class$("de.vw.mib.log4mib.Logger")) : class$de$vw$mib$log4mib$Logger).getName()).append(" must not be null!").toString());
        Preconditions.checkNotNull(onlineAuthentication, new StringBuffer().append("The given instance of class ").append((class$de$vw$mib$asl$api$online$services$authenticate$OnlineAuthentication == null ? (class$de$vw$mib$asl$api$online$services$authenticate$OnlineAuthentication = InformationCollector.class$("de.vw.mib.asl.api.online.services.authenticate.OnlineAuthentication")) : class$de$vw$mib$asl$api$online$services$authenticate$OnlineAuthentication).getName()).append(" must not be null!").toString());
        Preconditions.checkNotNull(aSLPhoneAPI, new StringBuffer().append("The given instance of class ").append((class$de$vw$mib$asl$api$phone$ASLPhoneAPI == null ? (class$de$vw$mib$asl$api$phone$ASLPhoneAPI = InformationCollector.class$("de.vw.mib.asl.api.phone.ASLPhoneAPI")) : class$de$vw$mib$asl$api$phone$ASLPhoneAPI).getName()).append(" must not be null!").toString());
        this.logger = new GlobalGoodByeLogger(logger, super.getClass());
        this.authenticationService = onlineAuthentication;
        this.aslPhoneApi = aSLPhoneAPI;
    }

    InformationContainer collect() {
        this.infoContainer = InformationContainerFactory.create();
        this.collectOnlineInformation();
        this.collectPhoneInformation();
        return this.infoContainer;
    }

    private void collectOnlineInformation() {
        String string = this.authenticationService.getMainUserName();
        if (!Util.isNullOrEmpty(string)) {
            this.logger.trace(new Object[]{"Enrolled online user name is: ", string});
            this.infoContainer.setShowOnlineSection(true);
            this.infoContainer.setNameOfEnrolledUser(string);
        } else {
            this.logger.trace(new Object[]{"Show online section: false"});
            this.infoContainer.setShowOnlineSection(false);
        }
    }

    private void collectPhoneInformation() {
        boolean bl = this.aslPhoneApi.isPhoneReminderPopupRequired();
        this.logger.trace(new Object[]{"Show phone section: ", new Boolean(bl)});
        this.infoContainer.setShowPhoneSection(bl);
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

