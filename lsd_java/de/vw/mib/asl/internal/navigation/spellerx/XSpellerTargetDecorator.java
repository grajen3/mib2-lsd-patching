/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.spellerx;

import de.vw.mib.asl.api.navigation.guidance.ASLNavigationGuidanceFactory;
import de.vw.mib.asl.api.navigation.guidance.IPersistedDestInputSetup;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.api.navigation.util.factoryreset.FactoryResetParticipantWithCallback;
import de.vw.mib.asl.api.navigation.util.factoryreset.TargetForFullFactoryReset;
import de.vw.mib.asl.internal.navigation.gateway.AbstractNavGatewayTarget;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdDmLastDestinationsDeleteAll;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdGetLocationDescriptionTransform;
import de.vw.mib.asl.internal.navigation.spellerx.XSpellerTarget;
import de.vw.mib.collections.ints.IntIntOptHashMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.PosPosition;

public class XSpellerTargetDecorator
extends AbstractNavGatewayTarget
implements TargetForFullFactoryReset {
    static IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(16384, "XSpellerTargetDecorator");
    XSpellerTarget realTarget;
    public static int currentUseCase = 0;
    public static final int INIT_FIELD_STREET1ST_STREET;
    public static final int INIT_FIELD_STREET1ST_CITY;
    public static final int INIT_FIELD_STREET1ST_ZIP;
    final IPersistedDestInputSetup PERS_DESTINPUT_SETUP = ASLNavigationGuidanceFactory.getNavigationGuidanceApi().getDestInputSetup();
    IntObjectOptHashMap usecaseInitFieldMap = new IntObjectOptHashMap();
    private FactoryResetParticipantWithCallback fullFactoryResetParticipant;
    private static final int[] ASL_OBSERVER;

    public XSpellerTargetDecorator(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        this.realTarget = new XSpellerTarget(genericEvents, -1840573440, string);
        this.realTarget.getEventDispatcher().unregisterTarget(this.realTarget.getTargetId(), false);
        this.register(this.getMainObject(), this.realTarget.getTargetId(), string);
        this.addFieldMapping(2, 1, 112);
        this.addFieldMapping(2, 10, 111);
        this.addFieldMapping(2, 2, 113);
        this.addFieldMapping(4, 1, 112);
        this.addFieldMapping(4, 10, 111);
        this.addFieldMapping(4, 2, 113);
        this.addObservers(ASL_OBSERVER);
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        if (this.realTarget == null) {
            this.warn("XSpellerTargetDecorator not yet started");
            return;
        }
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                if (this.fullFactoryResetParticipant == null) {
                    this.fullFactoryResetParticipant = ASLNavigationUtilFactory.getNavigationUtilApi().createFactoryResetParticipantForFullFactoryResetAndAddToService(this);
                }
                this.realTarget.gotEvent(eventGeneric);
                break;
            }
            case 107: {
                if (this.fullFactoryResetParticipant != null) {
                    ASLNavigationUtilFactory.getNavigationUtilApi().removeFullFactoryResetParticipantFromService(this.fullFactoryResetParticipant);
                    this.fullFactoryResetParticipant = null;
                }
                this.realTarget.gotEvent(eventGeneric);
                break;
            }
            case 1073744456: {
                currentUseCase = eventGeneric.getInt(0);
                this.realTarget.gotEvent(eventGeneric);
                break;
            }
            case 1073743980: {
                if (currentUseCase != 0 && currentUseCase != 1 && currentUseCase != 5) {
                    eventGeneric.setInt(0, this.resolveFieldId(eventGeneric.getInt(0)));
                }
                this.realTarget.gotEvent(eventGeneric);
                break;
            }
            default: {
                this.realTarget.gotEvent(eventGeneric);
            }
        }
    }

    private int resolveFieldId(int n) {
        IntIntOptHashMap intIntOptHashMap = (IntIntOptHashMap)this.usecaseInitFieldMap.get(currentUseCase);
        if (intIntOptHashMap != null && intIntOptHashMap.containsKey(n)) {
            return intIntOptHashMap.get(n);
        }
        return n;
    }

    private void addFieldMapping(int n, int n2, int n3) {
        IntIntOptHashMap intIntOptHashMap = (IntIntOptHashMap)this.usecaseInitFieldMap.get(n);
        if (intIntOptHashMap == null) {
            intIntOptHashMap = new IntIntOptHashMap();
            this.usecaseInitFieldMap.put(n, intIntOptHashMap);
        }
        intIntOptHashMap.put(n2, n3);
    }

    @Override
    public void handleFullFacotryReset() {
        XSpellerTargetDecorator.printTrace("gotEventResetNavigationSettings()");
        new CmdDmLastDestinationsDeleteAll(this).execute();
        this.PERS_DESTINPUT_SETUP.setDemoDest(ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getDefaultLocation());
        this.PERS_DESTINPUT_SETUP.setLastDest(null);
        ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setSpellerLocation(null);
        ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setDestInputLocation(null);
        ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setMemoryLocation(null);
        PosPosition posPosition = ASLNavigationUtilFactory.getNavigationUtilApi().getNavGateway().getSoPosPosition();
        NavLocation navLocation = null;
        if (posPosition.latitude != 0 && posPosition.longitude != 0) {
            navLocation = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(posPosition.latitude, posPosition.longitude).getLocation();
            XSpellerTargetDecorator.printTrace(new StringBuffer().append("CmdGetLocationDescriptionTransform for ccp coordinates: ").append(navLocation.latitude).append(navLocation.longitude).toString());
        } else {
            int n = ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getDefaultLocation().latitude;
            int n2 = ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getDefaultLocation().longitude;
            navLocation = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(n, n2).getLocation();
            XSpellerTargetDecorator.printTrace(new StringBuffer().append("CmdGetLocationDescriptionTransform for default location coordinates: ").append(navLocation.latitude).append(navLocation.longitude).toString());
        }
        new CmdGetLocationDescriptionTransform(this, navLocation).execute();
    }

    @Override
    public void handleCommandCmdGetLocationDescriptionTransform(CmdGetLocationDescriptionTransform cmdGetLocationDescriptionTransform) {
        NavLocation navLocation = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper().getLocation();
        navLocation.positionValid = true;
        if (cmdGetLocationDescriptionTransform.liGetLocationDescriptionTransformResult_NavLocation.country == null || cmdGetLocationDescriptionTransform.liGetLocationDescriptionTransformResult_NavLocation.country.equals("")) {
            XSpellerTargetDecorator.printTrace("After handleNavigationSettingsReset received handleCommandCmdGetLocationDescriptionTransform with empty country. Taking default location");
        } else {
            navLocation.country = cmdGetLocationDescriptionTransform.liGetLocationDescriptionTransformResult_NavLocation.country;
            navLocation.countryAbbreviation = cmdGetLocationDescriptionTransform.liGetLocationDescriptionTransformResult_NavLocation.countryAbbreviation;
            XSpellerTargetDecorator.printTrace(new StringBuffer().append("After handleNavigationSettingsReset received handleCommandCmdGetLocationDescriptionTransform with country=").append(cmdGetLocationDescriptionTransform.liGetLocationDescriptionTransformResult_NavLocation.getCountry()).append(" and countrycode=").append(cmdGetLocationDescriptionTransform.liGetLocationDescriptionTransformResult_NavLocation.getCountryAbbreviation()).toString());
        }
        XSpellerTarget.changeExtLocation(navLocation, new int[0], false);
        this.fullFactoryResetParticipant.notifyResetDone();
    }

    static void printTrace(String string) {
        if (logger.isTraceEnabled()) {
            logger.makeTrace().append(string).log();
        }
    }

    static {
        ASL_OBSERVER = new int[0];
    }
}

