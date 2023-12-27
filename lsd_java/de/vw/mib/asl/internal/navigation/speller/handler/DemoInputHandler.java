/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.speller.handler;

import de.vw.mib.asl.api.navigation.ILocationWrapper;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.gateway.AbstractNavGatewayTarget;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdGetLocationDescriptionTransform;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdRgSetPosition;
import de.vw.mib.asl.internal.navigation.speller.SpellerContext;
import de.vw.mib.asl.internal.navigation.speller.SpellerHandler;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.log4mib.LogMessage;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.PosPosition;

public class DemoInputHandler
extends AbstractNavGatewayTarget
implements SpellerHandler,
DSIServiceStateListener {
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigation;

    public DemoInputHandler(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
    }

    @Override
    public void registered(String string, int n) {
    }

    @Override
    public void unregistered(String string, int n) {
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                this.addObserver(-654180288);
                ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = DemoInputHandler.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation, this);
                break;
            }
            case 1073742553: {
                this.handleSetupDemoStartLocationSetCCP();
                break;
            }
        }
    }

    private void handleSetupDemoStartLocationSetCCP() {
        PosPosition posPosition = ASLNavigationUtilFactory.getNavigationUtilApi().getNavGateway().getSoPosPosition();
        int n = posPosition.getLatitude();
        int n2 = posPosition.getLongitude();
        ILocationWrapper iLocationWrapper = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(n, n2);
        NavLocation navLocation = iLocationWrapper.getLocation();
        if (this.isTraceEnabled()) {
            LogMessage logMessage = ServiceManager.logger.trace(16384);
            logMessage.append("DemoInputHandler: transform ccp as demo start location, ccp is: ");
            ASLNavigationUtilFactory.getNavigationUtilApi().getExtLoggerHelper().appendLocation(logMessage, navLocation);
            logMessage.log();
        }
        new CmdGetLocationDescriptionTransform(this, navLocation).execute();
    }

    @Override
    public void onActivated(SpellerContext spellerContext) {
        ServiceManager.aslPropertyManager.valueChangedInteger(3658, 1);
        NavLocation navLocation = ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getDemoLocation();
        if (this.isTraceEnabled()) {
            LogMessage logMessage = ServiceManager.logger.trace(16384);
            logMessage.append("DemoInputHandler: activating with location ");
            ASLNavigationUtilFactory.getNavigationUtilApi().getExtLoggerHelper().appendLocation(logMessage, navLocation);
            logMessage.log();
        }
        spellerContext.setLocation(navLocation);
    }

    @Override
    public void onLocationDiscarded(SpellerContext spellerContext) {
        NavLocation navLocation = ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getDemoLocation();
        if (this.isTraceEnabled()) {
            LogMessage logMessage = ServiceManager.logger.trace(16384);
            logMessage.append("DemoInputHandler: discarding with location ");
            ASLNavigationUtilFactory.getNavigationUtilApi().getExtLoggerHelper().appendLocation(logMessage, navLocation);
            logMessage.log();
        }
        spellerContext.setLocation(navLocation);
    }

    @Override
    public void onLocationSaved(SpellerContext spellerContext) {
        NavLocation navLocation = spellerContext.getLocation();
        NavLocation navLocation2 = ASLNavigationUtilFactory.getNavigationUtilApi().cloneLocation(navLocation);
        ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setDemoLocation(navLocation2);
        new CmdRgSetPosition(this, navLocation2).execute();
    }

    @Override
    public void onContext(SpellerContext spellerContext) {
        NavLocation navLocation = ASLNavigationUtilFactory.getNavigationUtilApi().cloneLocation(spellerContext.getLocation());
        ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setSpellerLocation(ASLNavigationUtilFactory.getNavigationUtilApi().cloneLocation(navLocation));
        String string = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationFormatter().createDetailString(7, navLocation);
        ServiceManager.aslPropertyManager.valueChangedString(766, string);
    }

    @Override
    public void handleCommandCmdGetLocationDescriptionTransform(CmdGetLocationDescriptionTransform cmdGetLocationDescriptionTransform) {
        NavLocation navLocation = cmdGetLocationDescriptionTransform.liGetLocationDescriptionTransformResult_NavLocation;
        this.trace("DemoInputHandler: setting transformed ccp as demostart location");
        ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setDemoLocation(navLocation);
        new CmdRgSetPosition(this, navLocation).execute();
    }

    @Override
    public int getSubClassifier() {
        return 16384;
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

