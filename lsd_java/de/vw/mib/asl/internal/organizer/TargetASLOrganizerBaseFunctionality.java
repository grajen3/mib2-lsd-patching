/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.organizer;

import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetCallback;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetComponent;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetComponents;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.organizer.TargetASLOrganizerBaseFunctionality$1;
import de.vw.mib.asl.internal.organizer.TargetASLOrganizerBaseFunctionality$2;
import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.organizer.DSIAdbInit;
import org.dsi.ifc.organizer.DSIAdbSetup;
import org.dsi.ifc.organizer.DSIAdbUserProfile;

public class TargetASLOrganizerBaseFunctionality
extends AbstractTarget {
    DSIAdbInit dsiAdbInit;
    DSIAdbSetup dsiAdbSetup;
    DSIAdbUserProfile dsiAdbUserProfile;
    DSIListener dsiAdbSetupListener;
    DSIListener dsiAdbInitListener;
    DSIListener dsiAdbUserProfileListener;
    private int lscTransactionId = -1;
    private String lscLanguageCode;
    private FactoryResetCallback resetCallback;
    boolean factoryResetActivated = false;
    private boolean alreadyRegistered = false;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbInit;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbSetup;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbUserProfile;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbSetupListener;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbInitListener;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbUserProfileListener;

    public TargetASLOrganizerBaseFunctionality(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
    }

    @Override
    public int getDefaultTargetId() {
        return 5308;
    }

    protected void init() {
        if (!this.alreadyRegistered) {
            DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
            this.dsiAdbInit = (DSIAdbInit)dSIProxy.getService(this, class$org$dsi$ifc$organizer$DSIAdbInit == null ? (class$org$dsi$ifc$organizer$DSIAdbInit = TargetASLOrganizerBaseFunctionality.class$("org.dsi.ifc.organizer.DSIAdbInit")) : class$org$dsi$ifc$organizer$DSIAdbInit);
            this.dsiAdbSetup = (DSIAdbSetup)dSIProxy.getService(this, class$org$dsi$ifc$organizer$DSIAdbSetup == null ? (class$org$dsi$ifc$organizer$DSIAdbSetup = TargetASLOrganizerBaseFunctionality.class$("org.dsi.ifc.organizer.DSIAdbSetup")) : class$org$dsi$ifc$organizer$DSIAdbSetup);
            this.dsiAdbUserProfile = (DSIAdbUserProfile)dSIProxy.getService(this, class$org$dsi$ifc$organizer$DSIAdbUserProfile == null ? (class$org$dsi$ifc$organizer$DSIAdbUserProfile = TargetASLOrganizerBaseFunctionality.class$("org.dsi.ifc.organizer.DSIAdbUserProfile")) : class$org$dsi$ifc$organizer$DSIAdbUserProfile);
            this.dsiAdbSetupListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$organizer$DSIAdbSetupListener == null ? (class$org$dsi$ifc$organizer$DSIAdbSetupListener = TargetASLOrganizerBaseFunctionality.class$("org.dsi.ifc.organizer.DSIAdbSetupListener")) : class$org$dsi$ifc$organizer$DSIAdbSetupListener);
            this.dsiAdbInitListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$organizer$DSIAdbInitListener == null ? (class$org$dsi$ifc$organizer$DSIAdbInitListener = TargetASLOrganizerBaseFunctionality.class$("org.dsi.ifc.organizer.DSIAdbInitListener")) : class$org$dsi$ifc$organizer$DSIAdbInitListener);
            this.dsiAdbUserProfileListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$organizer$DSIAdbUserProfileListener == null ? (class$org$dsi$ifc$organizer$DSIAdbUserProfileListener = TargetASLOrganizerBaseFunctionality.class$("org.dsi.ifc.organizer.DSIAdbUserProfileListener")) : class$org$dsi$ifc$organizer$DSIAdbUserProfileListener);
            dSIProxy.addResponseListener(this, class$org$dsi$ifc$organizer$DSIAdbSetupListener == null ? (class$org$dsi$ifc$organizer$DSIAdbSetupListener = TargetASLOrganizerBaseFunctionality.class$("org.dsi.ifc.organizer.DSIAdbSetupListener")) : class$org$dsi$ifc$organizer$DSIAdbSetupListener, this.dsiAdbSetupListener);
            dSIProxy.addResponseListener(this, class$org$dsi$ifc$organizer$DSIAdbInitListener == null ? (class$org$dsi$ifc$organizer$DSIAdbInitListener = TargetASLOrganizerBaseFunctionality.class$("org.dsi.ifc.organizer.DSIAdbInitListener")) : class$org$dsi$ifc$organizer$DSIAdbInitListener, this.dsiAdbInitListener);
            dSIProxy.addResponseListener(this, class$org$dsi$ifc$organizer$DSIAdbUserProfileListener == null ? (class$org$dsi$ifc$organizer$DSIAdbUserProfileListener = TargetASLOrganizerBaseFunctionality.class$("org.dsi.ifc.organizer.DSIAdbUserProfileListener")) : class$org$dsi$ifc$organizer$DSIAdbUserProfileListener, this.dsiAdbUserProfileListener);
            ASLSystemFactory.getSystemApi().getFactoryResetService().addParticipant(new TargetASLOrganizerBaseFunctionality$1(this), FactoryResetComponents.FULL);
            ASLSystemFactory.getSystemApi().getFactoryResetService().addParticipant(new TargetASLOrganizerBaseFunctionality$2(this), FactoryResetComponent.createChild(FactoryResetComponents.PHONE, "Organizer"));
            this.addObserver(1134297088);
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(1083965440);
            eventGeneric.setInt(0, this.getTargetId());
            eventGeneric.setInt(1, 9);
            eventGeneric.setString(2, "NO_LANGUAGE");
            eventGeneric.setString(3, "de.vw.mib.asl.internal.organizer.TargetASLOrganizerBaseFunctionality");
            this.sendSafe(eventGeneric);
        }
        this.alreadyRegistered = true;
    }

    private void setNotification() {
        this.dsiAdbSetup.setNotification(1, this.dsiAdbSetupListener);
        this.dsiAdbInit.setNotification(7, this.dsiAdbInitListener);
        this.dsiAdbUserProfile.setNotification(10, this.dsiAdbUserProfileListener);
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                this.init();
                this.setNotification();
                break;
            }
            case 40003: {
                this.lscTransactionId = eventGeneric.getInt(0);
                this.lscLanguageCode = eventGeneric.getString(1);
                this.dsiAdbSetup.setLanguage(ServiceManager.configManagerDiag.getLanguageReplacement(this.lscLanguageCode));
                break;
            }
        }
    }

    public void dsiAdbSetupUpdateAdbState(int n, int n2) {
        if (n == 1) {
            this.dsiAdbInit.setAutoProfileAllocation(true);
            this.dsiAdbInit.setOnlineDestinationEnabled(ServiceManager.configManagerDiag.isFeatureFlagSet(649));
            this.dsiAdbInit.setNumericalSpellerEnabled(true);
            this.dsiAdbInit.setMaxSpeedDialEntries(15);
            this.dsiAdbInit.setDefaultPublicProfileVisibility(false);
            this.dsiAdbInit.setSpeedDialType(1);
            this.dsiAdbInit.setProfileHandlingType(1);
            this.dsiAdbInit.setDefaultSortOrder(this.getASLNameRepresentationFromConfigManager(ServiceManager.configManagerDiag.getPhoneDefaultContactNameRepresentation()));
            this.dsiAdbInit.setDefaultSOSButton(true);
            this.dsiAdbInit.finalizeConfiguration();
        }
        if (n == 2) {
            this.dsiAdbSetup.setPublicProfileVisibility(false);
        }
    }

    public void dsiAdbSetupSetLanguageResult(int n) {
        if (this.lscTransactionId != -1) {
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(1151074304);
            eventGeneric.setInt(0, this.lscTransactionId);
            eventGeneric.setBoolean(1, n == 0);
            eventGeneric.setString(2, this.lscLanguageCode);
            ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
            this.lscTransactionId = -1;
        }
    }

    public void dsiAdbSetupResetToFactorySettingsResult(int n) {
        if (n == 0) {
            this.dsiAdbSetup.setPublicProfileVisibility(false);
            this.dsiAdbSetup.setSortOrder(this.getASLNameRepresentationFromConfigManager(ServiceManager.configManagerDiag.getPhoneDefaultContactNameRepresentation()));
            this.sendSafe(ServiceManager.mGenericEventFactory.newEvent(-429443840));
        }
        if (this.resetCallback != null) {
            this.resetCallback.notifyResetDone();
            this.resetCallback = null;
        }
    }

    public void dsiAdbInitSetDefaultSOSButtonResult(int n) {
        if (n != 0) {
            this.warn("Result of SetDefaultSOSButtonResult != OK");
        }
    }

    public int getASLNameRepresentationFromConfigManager(int n) {
        switch (n) {
            case 0: {
                return 2;
            }
            case 1: {
                return 1;
            }
            case 2: {
                return 3;
            }
        }
        this.error("unknown sort order set");
        return 0;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ FactoryResetCallback access$002(TargetASLOrganizerBaseFunctionality targetASLOrganizerBaseFunctionality, FactoryResetCallback factoryResetCallback) {
        targetASLOrganizerBaseFunctionality.resetCallback = factoryResetCallback;
        return targetASLOrganizerBaseFunctionality.resetCallback;
    }
}

