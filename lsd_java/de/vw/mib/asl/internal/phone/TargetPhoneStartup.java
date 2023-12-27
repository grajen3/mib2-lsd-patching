/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone;

import de.vw.mib.asl.api.messages.ASLMessagesFactory;
import de.vw.mib.asl.api.phone.PhoneConstants;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.startupv7r.ASLStartupv7rFactory;
import de.vw.mib.asl.framework.api.startupv7r.DSIInfo;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.dsi.util.RuntimeGeneratedConstants;
import de.vw.mib.asl.internal.phone.TargetASLPhoneFeatures;
import de.vw.mib.asl.internal.phone.TargetPhoneStartup$1;
import de.vw.mib.asl.internal.phone.call.CallHandling;
import de.vw.mib.asl.internal.phone.util.TripleMobileEquipment$TopologyUsage;
import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.util.Util;
import edu.emory.mathcs.backport.java.util.Arrays;
import java.util.ArrayList;
import java.util.Iterator;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.startup.DSIStartup;
import org.dsi.ifc.telephoneng.DSIMobileEquipmentTopology;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class TargetPhoneStartup
extends AbstractTarget
implements DSIServiceStateListener {
    private static int dsisRegistered = 0;
    private DSIStartup mDsiStartup;
    private DSIListener mDsiStartupListener;
    private boolean mTargetsAndListenersReady = false;
    private boolean mRecoveryInProgress = false;
    private ArrayList failedDsis = null;
    private DSIMobileEquipmentTopology mDsiMobileEquipmentTopology;
    private DSIListener mDsiMobileEquipmentTopologyListener;
    private int numberOfMobileEquipmentInstances = 0;
    private boolean gotUsage = false;
    static /* synthetic */ Class class$org$dsi$ifc$startup$DSIStartup;
    static /* synthetic */ Class class$org$dsi$ifc$startup$DSIStartupListener;
    static /* synthetic */ Class class$org$dsi$ifc$telephoneng$DSIMobileEquipmentTopology;
    static /* synthetic */ Class class$org$dsi$ifc$telephoneng$DSIMobileEquipmentTopologyListener;
    static /* synthetic */ Class class$de$vw$mib$asl$api$speechengine$PromptEngine;
    static /* synthetic */ Class class$org$dsi$ifc$bluetooth$DSIBluetooth;
    static /* synthetic */ Class class$org$dsi$ifc$bluetooth$DSIObexAuthentication;
    static /* synthetic */ Class class$org$dsi$ifc$messaging$DSIMessaging;
    static /* synthetic */ Class class$org$dsi$ifc$messaging$DSIMessagingServiceConfiguration;
    static /* synthetic */ Class class$org$dsi$ifc$networking$DSIWLAN;
    static /* synthetic */ Class class$org$dsi$ifc$networking$DSIDataConfiguration;
    static /* synthetic */ Class class$org$dsi$ifc$networking$DSIDataConnection;
    static /* synthetic */ Class class$org$dsi$ifc$telephoneng$DSIMobileEquipment;

    public TargetPhoneStartup(GenericEvents genericEvents, String string) {
        super(genericEvents);
        genericEvents.getEventDispatcher().registerTarget(this.getDefaultTargetId(), this, string);
    }

    @Override
    public int getDefaultTargetId() {
        return 5280;
    }

    @Override
    public int getClassifier() {
        return 1;
    }

    @Override
    public int getSubClassifier() {
        return 4;
    }

    public void registerDSI() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.mDsiStartup = (DSIStartup)dSIProxy.getService(this, class$org$dsi$ifc$startup$DSIStartup == null ? (class$org$dsi$ifc$startup$DSIStartup = TargetPhoneStartup.class$("org.dsi.ifc.startup.DSIStartup")) : class$org$dsi$ifc$startup$DSIStartup);
        this.mDsiStartupListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$startup$DSIStartupListener == null ? (class$org$dsi$ifc$startup$DSIStartupListener = TargetPhoneStartup.class$("org.dsi.ifc.startup.DSIStartupListener")) : class$org$dsi$ifc$startup$DSIStartupListener);
        this.mDsiStartup.setNotification(5, this.mDsiStartupListener);
    }

    private void registerTopology() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.mDsiMobileEquipmentTopology = (DSIMobileEquipmentTopology)dSIProxy.getService(this, class$org$dsi$ifc$telephoneng$DSIMobileEquipmentTopology == null ? (class$org$dsi$ifc$telephoneng$DSIMobileEquipmentTopology = TargetPhoneStartup.class$("org.dsi.ifc.telephoneng.DSIMobileEquipmentTopology")) : class$org$dsi$ifc$telephoneng$DSIMobileEquipmentTopology);
        this.mDsiMobileEquipmentTopologyListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$telephoneng$DSIMobileEquipmentTopologyListener == null ? (class$org$dsi$ifc$telephoneng$DSIMobileEquipmentTopologyListener = TargetPhoneStartup.class$("org.dsi.ifc.telephoneng.DSIMobileEquipmentTopologyListener")) : class$org$dsi$ifc$telephoneng$DSIMobileEquipmentTopologyListener);
        this.mDsiMobileEquipmentTopology.setNotification(2, this.mDsiMobileEquipmentTopologyListener);
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                this.failedDsis = (ArrayList)eventGeneric.getObject(2);
                this.handleFailedDsis();
                this.registerDSI();
                ServiceTracker serviceTracker = new ServiceTracker(ASLFrameworkFactory.getASLFrameworkAPI().getServices().getBundleContext(), (class$de$vw$mib$asl$api$speechengine$PromptEngine == null ? (class$de$vw$mib$asl$api$speechengine$PromptEngine = TargetPhoneStartup.class$("de.vw.mib.asl.api.speechengine.PromptEngine")) : class$de$vw$mib$asl$api$speechengine$PromptEngine).getName(), (ServiceTrackerCustomizer)new TargetPhoneStartup$1(this));
                serviceTracker.open();
                if (!this.isTraceEnabled()) break;
                this.trace("TargetPhoneStartup -> POWERED ON");
                break;
            }
        }
    }

    private void handleFailedDsis() {
        Iterator iterator = this.failedDsis.iterator();
        while (iterator.hasNext()) {
            DSIInfo dSIInfo = (DSIInfo)iterator.next();
            for (int i2 = 0; i2 < PhoneConstants.NEEDED_PHONE_DSIS.length; ++i2) {
                String string = PhoneConstants.NEEDED_PHONE_DSIS[i2];
                if (!dSIInfo.interfaceName.equals(string)) continue;
                if (this.isTraceEnabled()) {
                    this.trace().append("TargetPhoneStartup.handleFailedDsis() ").append(dSIInfo.interfaceName).log();
                }
                this.registered(dSIInfo.interfaceName, dSIInfo.instanceId);
            }
        }
    }

    private void createTargets() {
        GenericEvents genericEvents = ServiceManager.eventMain;
        String string = "hsmtask";
        for (int i2 = 0; i2 < PhoneConstants.NEEDED_PHONE_TARGETS.length; ++i2) {
            int n = PhoneConstants.NEEDED_PHONE_TARGETS[i2];
            try {
                switch (n) {
                    case 1350003: {
                        new TargetASLPhoneFeatures(genericEvents, "hsmtask");
                        break;
                    }
                    case 1350002: {
                        new CallHandling(genericEvents, "hsmtask");
                        break;
                    }
                    case 1300001: {
                        ASLMessagesFactory.getMessagesApi().createTargets(genericEvents, "hsmtask");
                        break;
                    }
                    default: {
                        ASLStartupv7rFactory.getStartupv7rApi().startTargetByNamedId(n);
                        break;
                    }
                }
                continue;
            }
            catch (Exception exception) {
                this.error(exception);
            }
        }
    }

    private void registerServiceListeners() {
        if (this.isTraceEnabled()) {
            this.trace().append("PHONE TARGETS ~ register PHONE DSI State Listener").log();
        }
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        dSIProxy.addServiceStateListener(class$org$dsi$ifc$telephoneng$DSIMobileEquipmentTopology == null ? (class$org$dsi$ifc$telephoneng$DSIMobileEquipmentTopology = TargetPhoneStartup.class$("org.dsi.ifc.telephoneng.DSIMobileEquipmentTopology")) : class$org$dsi$ifc$telephoneng$DSIMobileEquipmentTopology, this);
        dSIProxy.addServiceStateListener(class$org$dsi$ifc$bluetooth$DSIBluetooth == null ? (class$org$dsi$ifc$bluetooth$DSIBluetooth = TargetPhoneStartup.class$("org.dsi.ifc.bluetooth.DSIBluetooth")) : class$org$dsi$ifc$bluetooth$DSIBluetooth, this);
        dSIProxy.addServiceStateListener(class$org$dsi$ifc$bluetooth$DSIObexAuthentication == null ? (class$org$dsi$ifc$bluetooth$DSIObexAuthentication = TargetPhoneStartup.class$("org.dsi.ifc.bluetooth.DSIObexAuthentication")) : class$org$dsi$ifc$bluetooth$DSIObexAuthentication, this);
        if (PhoneConstants.isFeatureFlagsDsiMessagingXXX()) {
            dSIProxy.addServiceStateListener(class$org$dsi$ifc$messaging$DSIMessaging == null ? (class$org$dsi$ifc$messaging$DSIMessaging = TargetPhoneStartup.class$("org.dsi.ifc.messaging.DSIMessaging")) : class$org$dsi$ifc$messaging$DSIMessaging, this);
            dSIProxy.addServiceStateListener(class$org$dsi$ifc$messaging$DSIMessagingServiceConfiguration == null ? (class$org$dsi$ifc$messaging$DSIMessagingServiceConfiguration = TargetPhoneStartup.class$("org.dsi.ifc.messaging.DSIMessagingServiceConfiguration")) : class$org$dsi$ifc$messaging$DSIMessagingServiceConfiguration, this);
        }
        if (PhoneConstants.isFeatureFlagsDsiWLAN()) {
            dSIProxy.addServiceStateListener(class$org$dsi$ifc$networking$DSIWLAN == null ? (class$org$dsi$ifc$networking$DSIWLAN = TargetPhoneStartup.class$("org.dsi.ifc.networking.DSIWLAN")) : class$org$dsi$ifc$networking$DSIWLAN, this);
        }
        if (PhoneConstants.isFeatureFlagsDsiDataXXX()) {
            dSIProxy.addServiceStateListener(class$org$dsi$ifc$networking$DSIDataConfiguration == null ? (class$org$dsi$ifc$networking$DSIDataConfiguration = TargetPhoneStartup.class$("org.dsi.ifc.networking.DSIDataConfiguration")) : class$org$dsi$ifc$networking$DSIDataConfiguration, this);
            dSIProxy.addServiceStateListener(class$org$dsi$ifc$networking$DSIDataConnection == null ? (class$org$dsi$ifc$networking$DSIDataConnection = TargetPhoneStartup.class$("org.dsi.ifc.networking.DSIDataConnection")) : class$org$dsi$ifc$networking$DSIDataConnection, this);
        }
    }

    private void registerServiceListenersMobileEquipment(int n) {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        dSIProxy.addServiceStateListener(class$org$dsi$ifc$telephoneng$DSIMobileEquipment == null ? (class$org$dsi$ifc$telephoneng$DSIMobileEquipment = TargetPhoneStartup.class$("org.dsi.ifc.telephoneng.DSIMobileEquipment")) : class$org$dsi$ifc$telephoneng$DSIMobileEquipment, n, this);
    }

    public void dsiStartupUpdateDomainStatusPhone(int n, int n2) {
        if (this.isTraceEnabled()) {
            this.trace().append("PHONE TARGETS ~ Domain Status Phone: ").append(n).log();
        }
        if (!this.mTargetsAndListenersReady) {
            this.createTargets();
            this.registerServiceListeners();
            this.mTargetsAndListenersReady = true;
        } else if (ServiceManager.configManagerDiag.isFeatureFlagSet(378)) {
            if (n == 0) {
                ServiceManager.aslPropertyManager.valueChangedInteger(1680, 0);
                ServiceManager.aslPropertyManager.valueChangedInteger(-43883008, 0);
                this.info("Setting PHONE_DOMAIN_AVAILABLE (as well as PhoneTileS... DOMAIN_AVAILABLE) to not available due to phone domain restart!");
                this.mRecoveryInProgress = true;
            } else if (this.mRecoveryInProgress && (n < 0 || n > 16) && Util.isBitSet(PhoneConstants.DOMAIN_RUN_LEVEL, n)) {
                this.info().append("PHONE TARGETS ~ Phone domain state all needed bits set: Recovery finished!").log();
                for (int i2 = 0; i2 < PhoneConstants.NEEDED_PHONE_DSIS.length; ++i2) {
                    String string = PhoneConstants.NEEDED_PHONE_DSIS[i2];
                    this.info().append("PHONE TARGETS ~ starting ").append(string).log();
                    ServiceManager.dsiServiceAdmin.startService(string, PhoneConstants.NEEDED_PHONE_DSI_IDS[i2] == 139 ? 1 : 0);
                }
                this.mRecoveryInProgress = false;
            }
        }
    }

    @Override
    public void registered(String string, int n) {
        ++dsisRegistered;
        if (this.isTraceEnabled()) {
            this.trace().append("TargetPhoneStartup.registered() ").append(string).append('[').append(n).append("], ").append(dsisRegistered).append(" of ").append(PhoneConstants.NEEDED_PHONE_DSIS.length - 1).append(" + ").append(this.gotUsage ? Integer.toString(this.numberOfMobileEquipmentInstances) : "?").log();
        }
        if (dsisRegistered == PhoneConstants.NEEDED_PHONE_DSIS.length - 1) {
            this.registerTopology();
        }
        if (this.gotUsage && dsisRegistered == PhoneConstants.NEEDED_PHONE_DSIS.length + this.numberOfMobileEquipmentInstances - 1) {
            this.powerOnTargets();
        }
    }

    public void dsiMobileEquipmentTopologyUpdateUsage(int[] nArray, int n) {
        int n2;
        this.info().append("dsiMobileEquipmentTopologyUpdateUsage(usage=").append(Arrays.toString(nArray)).append(", validFlag=").append(n).log();
        if (n != 1) {
            return;
        }
        if (this.gotUsage) {
            this.warn().append("Only one update expected! Ignore...").log();
            return;
        }
        this.gotUsage = true;
        boolean bl = false;
        this.numberOfMobileEquipmentInstances = 0;
        for (n2 = 0; n2 < nArray.length; ++n2) {
            if (!TripleMobileEquipment$TopologyUsage.isUsed(nArray[n2])) continue;
            ++this.numberOfMobileEquipmentInstances;
            bl = true;
        }
        for (n2 = 0; n2 < nArray.length; ++n2) {
            if (!TripleMobileEquipment$TopologyUsage.isUsed(nArray[n2])) continue;
            ServiceManager.dsiServiceAdmin.startService(RuntimeGeneratedConstants.SERVICE_TS_NS[139], n2);
            this.registerServiceListenersMobileEquipment(n2);
        }
        if (!bl) {
            this.powerOnTargets();
        }
    }

    private void powerOnTargets() {
        for (int i2 = 0; i2 < PhoneConstants.NEEDED_PHONE_TARGETS.length; ++i2) {
            int n = PhoneConstants.NEEDED_PHONE_TARGETS[i2];
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this.getTargetId(), n, 106);
            this.sendSafe(eventGeneric);
        }
    }

    @Override
    public void unregistered(String string, int n) {
        if (dsisRegistered == PhoneConstants.NEEDED_PHONE_DSIS.length + this.numberOfMobileEquipmentInstances - 1) {
            for (int i2 = 0; i2 < PhoneConstants.NEEDED_PHONE_TARGETS.length; ++i2) {
                int n2 = PhoneConstants.NEEDED_PHONE_TARGETS[i2];
                this.shutdownTarget(n2);
            }
        }
        --dsisRegistered;
        if (this.isTraceEnabled()) {
            this.trace().append("TargetPhoneStartup.unregistered() ").append(string).append(", ").append(dsisRegistered).append(" of ").append(PhoneConstants.NEEDED_PHONE_DSIS.length).log();
        }
    }

    private void shutdownTarget(int n) {
        this.sendSafe(ServiceManager.mGenericEventFactory.newEvent(this.getTargetId(), n, 107));
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

