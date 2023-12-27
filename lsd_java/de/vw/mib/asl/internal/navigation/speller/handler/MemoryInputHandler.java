/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.speller.handler;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.speller.SpellerContext;
import de.vw.mib.asl.internal.navigation.speller.SpellerHandler;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.log4mib.LogMessage;
import org.dsi.ifc.global.NavLocation;

public class MemoryInputHandler
extends AbstractASLTarget
implements SpellerHandler {
    public MemoryInputHandler(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                this.addObserver(1778516032);
                this.addObserver(1895956544);
                this.addObserver(1711407168);
                this.addObserver(1761738816);
                break;
            }
        }
    }

    @Override
    public void onActivated(SpellerContext spellerContext) {
        NavLocation navLocation = ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getMemoryLocation();
        ServiceManager.aslPropertyManager.valueChangedInteger(3658, 6);
        if (this.isTraceEnabled()) {
            LogMessage logMessage = ServiceManager.logger.trace(16384);
            logMessage.append("MemoryInputHandler: activating location ");
            ASLNavigationUtilFactory.getNavigationUtilApi().getExtLoggerHelper().appendLocation(logMessage, navLocation);
            logMessage.log();
        }
        spellerContext.setLocation(navLocation);
    }

    @Override
    public void onLocationDiscarded(SpellerContext spellerContext) {
        if (this.isTraceEnabled()) {
            this.trace("MemoryInputHandler: discarding location");
        }
        NavLocation navLocation = ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getMemoryLocation();
        spellerContext.setLocation(navLocation);
        if (this.isTraceEnabled()) {
            LogMessage logMessage = ServiceManager.logger.trace(16384);
            logMessage.append("MemoryInputHandler: discarding location ");
            ASLNavigationUtilFactory.getNavigationUtilApi().getExtLoggerHelper().appendLocation(logMessage, navLocation);
            logMessage.log();
        }
    }

    @Override
    public void onLocationSaved(SpellerContext spellerContext) {
        NavLocation navLocation = spellerContext.getLocation();
        NavLocation navLocation2 = ASLNavigationUtilFactory.getNavigationUtilApi().cloneLocation(navLocation);
        if (this.isTraceEnabled()) {
            LogMessage logMessage = ServiceManager.logger.trace(16384);
            logMessage.append("MemoryInputHandler: saving location ");
            ASLNavigationUtilFactory.getNavigationUtilApi().getExtLoggerHelper().appendLocation(logMessage, navLocation2);
            logMessage.log();
        }
        ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setMemoryLocation(ASLNavigationUtilFactory.getNavigationUtilApi().cloneLocation(navLocation2));
        ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setDestInputLocation(ASLNavigationUtilFactory.getNavigationUtilApi().cloneLocation(navLocation2));
    }

    @Override
    public void onContext(SpellerContext spellerContext) {
        NavLocation navLocation = ASLNavigationUtilFactory.getNavigationUtilApi().cloneLocation(spellerContext.getLocation());
        if (navLocation != null && navLocation.isPositionValid()) {
            ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setSpellerLocation(ASLNavigationUtilFactory.getNavigationUtilApi().cloneLocation(navLocation));
        }
        if (this.isTraceEnabled()) {
            LogMessage logMessage = ServiceManager.logger.trace(16384);
            logMessage.append("MemoryInputHandler: location changed to ");
            ASLNavigationUtilFactory.getNavigationUtilApi().getExtLoggerHelper().appendLocation(logMessage, navLocation);
            logMessage.log();
        }
        ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setMemoryLocation(ASLNavigationUtilFactory.getNavigationUtilApi().cloneLocation(navLocation));
        ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setDestInputLocation(ASLNavigationUtilFactory.getNavigationUtilApi().cloneLocation(navLocation));
    }

    @Override
    public int getSubClassifier() {
        return 16384;
    }
}

