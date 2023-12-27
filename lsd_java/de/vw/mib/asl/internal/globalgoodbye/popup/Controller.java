/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.globalgoodbye.popup;

import de.vw.mib.asl.api.system.powerstate.ClampSignalService;
import de.vw.mib.asl.internal.globalgoodbye.logging.GlobalGoodByeLogger;
import de.vw.mib.asl.internal.globalgoodbye.popup.Controller$1;
import de.vw.mib.asl.internal.globalgoodbye.popup.DatapoolUpdater;
import de.vw.mib.asl.internal.globalgoodbye.popup.InformationCollector;
import de.vw.mib.asl.internal.globalgoodbye.popup.InformationContainer;
import de.vw.mib.asl.internal.globalgoodbye.popup.Switcher;
import de.vw.mib.hmi.utils.Preconditions;
import de.vw.mib.log4mib.Logger;

public class Controller {
    private boolean isClampSActive;
    private final GlobalGoodByeLogger logger;
    private final Switcher switcher;
    private final InformationCollector infoCollector;
    private final DatapoolUpdater datapoolUpdater;
    private final ClampSignalService clampSignalService;
    static /* synthetic */ Class class$de$vw$mib$log4mib$Logger;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$globalgoodbye$popup$InformationCollector;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$globalgoodbye$popup$DatapoolUpdater;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$globalgoodbye$popup$Switcher;
    static /* synthetic */ Class class$de$vw$mib$asl$api$system$powerstate$ClampSignalService;

    public Controller(Logger logger, InformationCollector informationCollector, DatapoolUpdater datapoolUpdater, Switcher switcher, ClampSignalService clampSignalService) {
        Preconditions.checkNotNull(logger, new StringBuffer().append("The given instance of class ").append((class$de$vw$mib$log4mib$Logger == null ? (class$de$vw$mib$log4mib$Logger = Controller.class$("de.vw.mib.log4mib.Logger")) : class$de$vw$mib$log4mib$Logger).getName()).append(" must not be null!").toString());
        Preconditions.checkNotNull(informationCollector, new StringBuffer().append("The given instance of class ").append((class$de$vw$mib$asl$internal$globalgoodbye$popup$InformationCollector == null ? (class$de$vw$mib$asl$internal$globalgoodbye$popup$InformationCollector = Controller.class$("de.vw.mib.asl.internal.globalgoodbye.popup.InformationCollector")) : class$de$vw$mib$asl$internal$globalgoodbye$popup$InformationCollector).getName()).append(" must not be null!").toString());
        Preconditions.checkNotNull(datapoolUpdater, new StringBuffer().append("The given instance of class ").append((class$de$vw$mib$asl$internal$globalgoodbye$popup$DatapoolUpdater == null ? (class$de$vw$mib$asl$internal$globalgoodbye$popup$DatapoolUpdater = Controller.class$("de.vw.mib.asl.internal.globalgoodbye.popup.DatapoolUpdater")) : class$de$vw$mib$asl$internal$globalgoodbye$popup$DatapoolUpdater).getName()).append(" must not be null!").toString());
        Preconditions.checkNotNull(switcher, new StringBuffer().append("The given instance of class ").append((class$de$vw$mib$asl$internal$globalgoodbye$popup$Switcher == null ? (class$de$vw$mib$asl$internal$globalgoodbye$popup$Switcher = Controller.class$("de.vw.mib.asl.internal.globalgoodbye.popup.Switcher")) : class$de$vw$mib$asl$internal$globalgoodbye$popup$Switcher).getName()).append(" must not be null!").toString());
        Preconditions.checkNotNull(clampSignalService, new StringBuffer().append("The given instance of class ").append((class$de$vw$mib$asl$api$system$powerstate$ClampSignalService == null ? (class$de$vw$mib$asl$api$system$powerstate$ClampSignalService = Controller.class$("de.vw.mib.asl.api.system.powerstate.ClampSignalService")) : class$de$vw$mib$asl$api$system$powerstate$ClampSignalService).getName()).append(" must not be null!").toString());
        this.logger = new GlobalGoodByeLogger(logger, super.getClass());
        this.switcher = switcher;
        this.infoCollector = informationCollector;
        this.datapoolUpdater = datapoolUpdater;
        this.clampSignalService = clampSignalService;
        this.isClampSActive = clampSignalService.isCurrentClampSActivated();
        this.createClampSignalServiceListener();
    }

    private void createClampSignalServiceListener() {
        this.clampSignalService.addListener(new Controller$1(this));
    }

    void processClampSChange(boolean bl) {
        if (this.clampSGotSwitchedOff(bl)) {
            this.logger.trace("Clamp S got switched off. Collecting pop up information now ...");
            InformationContainer informationContainer = this.infoCollector.collect();
            if (informationContainer.isAtLeastOneSectionToBeDisplayed()) {
                this.logger.trace("At least one section is to be displayed. Activating pop up now ...");
                this.datapoolUpdater.update(informationContainer);
                this.switcher.activate();
            } else {
                this.logger.trace("No section is to be displayed. No activation of pop up will be triggered.");
            }
        } else if (this.clampSGotSwitchedOn(bl)) {
            this.logger.trace("Clamp S got switched on. Deactivating pop up now ...");
            this.switcher.deactivate();
        }
        this.isClampSActive = bl;
    }

    private boolean clampSGotSwitchedOff(boolean bl) {
        return this.isClampSActive && !bl;
    }

    private boolean clampSGotSwitchedOn(boolean bl) {
        return !this.isClampSActive && bl;
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

