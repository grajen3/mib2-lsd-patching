/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.abtfeatures;

import de.vw.mib.asl.api.system.factoryreset.FactoryResetCallback;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetComponents;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetParticipant;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.internal.system.SystemServices;
import de.vw.mib.asl.internal.system.abtfeatures.AbtFeatureParser;
import de.vw.mib.asl.internal.system.abtfeatures.AbtFeatureServiceImpl;
import de.vw.mib.asl.internal.system.abtfeatures.AbtFeatureUpdater$1;
import de.vw.mib.asl.internal.system.abtfeatures.AbtFeatureUpdater$2;
import de.vw.mib.asl.internal.system.abtfeatures.AbtFeatureUpdater$3;
import de.vw.mib.asl.internal.system.abtfeatures.FeatureDataLocation;
import de.vw.mib.asl.internal.system.abtfeatures.ValueSetterFactory;
import de.vw.mib.asl.internal.system.persistence.PersistenceDefaults;
import de.vw.mib.asl.internal.system.util.IntStringMap;
import de.vw.mib.asl.internal.system.util.Preconditions;
import de.vw.mib.asl.internal.system.util.SystemLogger;
import de.vw.mib.asl.systemcommon.persistence.AbtFeatures;
import de.vw.mib.configuration.ConfigurationManagerDiag;
import de.vw.mib.configuration.RtMethodListener;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.threads.AsyncServiceFactory;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.keypanel.DSIKeyPanel;
import org.dsi.ifc.keypanel.DSIKeyPanelListener;

public class AbtFeatureUpdater {
    static final int DEFAULT_NAMESPACE;
    static final int DEFAULT_KEY;
    private final AbtFeatureParser abtFeatureParser;
    private DSIKeyPanel dsiKeyPanel;
    final SystemLogger systemLogger;
    final AbtFeatures abtFeatures;
    final AbtFeatureServiceImpl abtFeatureServiceImpl;
    protected FactoryResetCallback factoryResetCallback;
    private boolean firstGetPropertyReceived;
    private boolean updateInputPanelReadySeen;
    static final IntStringMap GET_PROPERTY_RESULT_TO_STRING_MAP;
    static /* synthetic */ Class class$org$dsi$ifc$keypanel$DSIKeyPanel;
    static /* synthetic */ Class class$org$dsi$ifc$keypanel$DSIKeyPanelListener;

    public AbtFeatureUpdater(SystemServices systemServices) {
        Preconditions.checkArgumentNotNull(systemServices, "The given instance of SystemServices must not be null.");
        Logger logger = systemServices.getAsl1Logger();
        this.systemLogger = new SystemLogger(logger, super.getClass());
        this.abtFeatures = systemServices.getSystemCommonPersistenceService().loadAbtFeatures();
        this.abtFeatureParser = this.createFeatureParser(this.abtFeatures, logger);
        this.abtFeatureServiceImpl = systemServices.getAbtFeatureServiceImpl();
        this.systemLogger.trace(this.abtFeatureServiceImpl.getRuntimeAbtFeaturesAsString());
        AsyncServiceFactory asyncServiceFactory = systemServices.getAsyncServiceFactory();
        ConfigurationManagerDiag configurationManagerDiag = systemServices.getConfigManagerDiag();
        configurationManagerDiag.addRtMethodListener(this.createRunTimeMethodListener(asyncServiceFactory, this.abtFeatures));
        if (configurationManagerDiag.isFeatureFlagSet(391)) {
            this.connectToDsi(systemServices.getDsiProxy(), configurationManagerDiag);
        }
        systemServices.getFactoryResetService().addParticipant(this.createFactoryResetParticipant(), FactoryResetComponents.SYSTEM);
    }

    private void processPropertyUpdate(byte[] byArray) {
        FeatureDataLocation featureDataLocation = this.abtFeatureParser.parse(byArray);
        if (featureDataLocation.hasData()) {
            this.requestAbtProperties(featureDataLocation.getNamespace(), featureDataLocation.getKey());
        } else {
            if (this.factoryResetCallback != null) {
                this.factoryResetCallback.notifyResetDone();
                this.factoryResetCallback = null;
            }
            this.systemLogger.trace(this.abtFeatureServiceImpl.getNextStartupAbtFeaturesAsString());
        }
    }

    void requestAbtProperties(int n, int n2) {
        this.dsiKeyPanel.getProperty(13, n, n2);
    }

    void installDefaultProximitySensor(AbtFeatures abtFeatures) {
        if (!this.abtFeatureParser.wasFeatureApplied(1)) {
            int n = PersistenceDefaults.getDefaultProximitySensor();
            abtFeatures.setProximitySensor(n);
            this.systemLogger.info(new StringBuffer().append("Updating default value for proximity sensor to ").append(n).toString());
        }
    }

    private RtMethodListener createRunTimeMethodListener(AsyncServiceFactory asyncServiceFactory, AbtFeatures abtFeatures) {
        AbtFeatureUpdater$1 abtFeatureUpdater$1 = new AbtFeatureUpdater$1(this, abtFeatures);
        return (RtMethodListener)asyncServiceFactory.create(abtFeatureUpdater$1);
    }

    private AbtFeatureParser createFeatureParser(AbtFeatures abtFeatures, Logger logger) {
        ValueSetterFactory valueSetterFactory = new ValueSetterFactory(abtFeatures);
        return new AbtFeatureParser(valueSetterFactory, logger);
    }

    private void connectToDsi(DSIProxy dSIProxy, ConfigurationManagerDiag configurationManagerDiag) {
        int n = configurationManagerDiag.getSystemKeyPanelInstance();
        this.dsiKeyPanel = (DSIKeyPanel)dSIProxy.getService(null, class$org$dsi$ifc$keypanel$DSIKeyPanel == null ? (class$org$dsi$ifc$keypanel$DSIKeyPanel = AbtFeatureUpdater.class$("org.dsi.ifc.keypanel.DSIKeyPanel")) : class$org$dsi$ifc$keypanel$DSIKeyPanel, n);
        DSIKeyPanelListener dSIKeyPanelListener = this.createKeyPanelListener();
        dSIProxy.addResponseListener(null, class$org$dsi$ifc$keypanel$DSIKeyPanelListener == null ? (class$org$dsi$ifc$keypanel$DSIKeyPanelListener = AbtFeatureUpdater.class$("org.dsi.ifc.keypanel.DSIKeyPanelListener")) : class$org$dsi$ifc$keypanel$DSIKeyPanelListener, n, dSIKeyPanelListener);
        this.dsiKeyPanel.setNotification(26, (DSIListener)dSIKeyPanelListener);
    }

    private DSIKeyPanelListener createKeyPanelListener() {
        return new AbtFeatureUpdater$2(this);
    }

    void processGetProperty(int n, byte[] byArray) {
        if (!this.firstGetPropertyReceived && n == 0) {
            this.firstGetPropertyReceived = true;
            this.abtFeatures.resetToDefaults();
        }
        if (n == 0) {
            this.processPropertyUpdate(byArray);
        } else if (this.factoryResetCallback != null) {
            this.systemLogger.error("getProperty returned without success while factory reset.");
        } else {
            String string = "Southside callback for getProperty returned without success. ";
            string = new StringBuffer().append(string).append("Result code: ").append(n).append(" (").append(GET_PROPERTY_RESULT_TO_STRING_MAP.get(n)).append(").").toString();
            this.systemLogger.warn(string);
        }
    }

    void processUpdateInputPanelReady() {
        this.updateInputPanelReadySeen = true;
        this.firstGetPropertyReceived = false;
        this.requestAbtProperties(33, 1);
    }

    private FactoryResetParticipant createFactoryResetParticipant() {
        return new AbtFeatureUpdater$3(this);
    }

    void processReset(FactoryResetCallback factoryResetCallback) {
        this.factoryResetCallback = factoryResetCallback;
        if (this.updateInputPanelReadySeen) {
            this.systemLogger.trace("updateInputPanelReady seen. Reset current and request new ABT features.");
            this.firstGetPropertyReceived = false;
            this.abtFeatures.resetToDefaults();
            this.requestAbtProperties(33, 1);
        } else {
            this.systemLogger.trace("No updateInputPanelReady seen so far. Only resetting persisted ABT features. No request for new ones.");
            this.abtFeatures.resetToDefaults();
            this.factoryResetCallback.notifyResetDone();
            this.factoryResetCallback = null;
        }
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
        GET_PROPERTY_RESULT_TO_STRING_MAP = new IntStringMap("unknown", new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 255}, new String[]{"SUCCESS", "UNKNOWN_OPERATION", "UNKNOWN_NAMESPACE", "UNKNOWN_PROPERTYKEY", "WRONG_DATA_LENGTH", "WRONG_CHECKSUM", "DEVICE_NOT_READY", "READ_WRITE_FAILURE", "UNKNOWN_ERROR", "TIMEOUT"});
    }
}

