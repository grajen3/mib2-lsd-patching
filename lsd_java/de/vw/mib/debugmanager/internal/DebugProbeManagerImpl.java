/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debugmanager.internal;

import de.vw.mib.collections.ObjectObjectMap$Entry;
import de.vw.mib.collections.ObjectObjectOptHashMap;
import de.vw.mib.collections.SyncObjectObjectOptHashMap;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.configuration.ConfigurationManager;
import de.vw.mib.configuration.NvListener;
import de.vw.mib.debug.common.core.ByteArrayReader;
import de.vw.mib.debug.common.probes.configuration.DebugProbeConfigurationCodec;
import de.vw.mib.debug.common.probes.configuration.DebugProbeConfigurationDecoderListener;
import de.vw.mib.debug.common.probes.configuration.DebugProbeManagerConfiguration;
import de.vw.mib.debugmanager.internal.DebugProbeManagerImpl$1;
import de.vw.mib.debugmanager.internal.DebugProbeManagerImpl$2;
import de.vw.mib.debugmanager.internal.DebugProbeManagerServices;
import de.vw.mib.debugmanager.internal.ProbeSystemServiceImpl;
import de.vw.mib.debugmanager.probes.DebugProbe;
import de.vw.mib.debugmanager.probes.DebugProbeFactory;
import de.vw.mib.debugmanager.probes.DebugProbeManager;
import de.vw.mib.debugmanager.unifiedlogging.BinaryLogger;
import de.vw.mib.debugmanager.unifiedlogging.UnifiedLoggingCallbackListener;
import de.vw.mib.debugmanager.unifiedlogging.UnifiedLoggingScopeListener;
import de.vw.mib.log4mib.LogHeartbeatInformationProvider;
import de.vw.mib.log4mib.LogManagerDiag;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.util.StringBuilder;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceReference;

public final class DebugProbeManagerImpl
implements UnifiedLoggingCallbackListener,
UnifiedLoggingScopeListener,
DebugProbeConfigurationDecoderListener,
LogHeartbeatInformationProvider,
NvListener,
DebugProbeManager {
    public static final boolean DEBUG_SPI_KEEP_ALIVE_PING_ENABLED = System.getProperty("de.vw.mib.debugprobe.keep_alive_ping_enabled", "true").equals("true");
    private static final String[] ALWAYS_ON_PROBES = new String[]{"DSIEVENTS"};
    private static final String KEY_DIRECT_FILE_CONFIG_PATH;
    private static final String DIRECT_FILE_CONFIG_PATH;
    private static final String KEY_PROBE_CONFIG_PATH;
    private static final String PROBE_CONFIG_PATH;
    private static final String ALL_CONFIG_FILES_STARTS_WITH;
    private static final int START_PONT_OF_IDENTIFIER;
    private static final int LENGHT_OF_IDENTIFIER;
    private final Logger logger;
    private final DebugProbeConfigurationCodec codec = new DebugProbeConfigurationCodec();
    private IntObjectMap classifierToFilenames;
    final DebugProbeManagerConfiguration debugProbeManagerConfig = new DebugProbeManagerConfiguration();
    Map probeConfigurationsMap = null;
    final BinaryLogger binaryMessageLogger;
    private final ByteArrayReader reader;
    private final ConfigurationManager configurationManager;
    private static final Object MUTEX;
    SyncObjectObjectOptHashMap probes = new SyncObjectObjectOptHashMap(new ObjectObjectOptHashMap(), MUTEX);
    private BundleContext bundleContext;
    private DebugProbeManagerServices services;
    private boolean debugInterfaceReady;
    static /* synthetic */ Class class$de$vw$mib$debugmanager$unifiedlogging$UnifiedLoggingCallbackListener;
    static /* synthetic */ Class class$de$vw$mib$debugmanager$unifiedlogging$UnifiedLoggingScopeListener;

    public DebugProbeManagerImpl(DebugProbeManagerServices debugProbeManagerServices) {
        this.reader = new ByteArrayReader();
        this.logger = debugProbeManagerServices.getLogger();
        this.binaryMessageLogger = debugProbeManagerServices.getBinaryLogger();
        this.bundleContext = debugProbeManagerServices.getBundleContext();
        Hashtable hashtable = new Hashtable();
        ((Dictionary)hashtable).put("message.type", new short[]{0, 1, 2, 4, 5});
        this.bundleContext.registerService((class$de$vw$mib$debugmanager$unifiedlogging$UnifiedLoggingCallbackListener == null ? (class$de$vw$mib$debugmanager$unifiedlogging$UnifiedLoggingCallbackListener = DebugProbeManagerImpl.class$("de.vw.mib.debugmanager.unifiedlogging.UnifiedLoggingCallbackListener")) : class$de$vw$mib$debugmanager$unifiedlogging$UnifiedLoggingCallbackListener).getName(), (Object)this, (Dictionary)hashtable);
        this.bundleContext.registerService((class$de$vw$mib$debugmanager$unifiedlogging$UnifiedLoggingScopeListener == null ? (class$de$vw$mib$debugmanager$unifiedlogging$UnifiedLoggingScopeListener = DebugProbeManagerImpl.class$("de.vw.mib.debugmanager.unifiedlogging.UnifiedLoggingScopeListener")) : class$de$vw$mib$debugmanager$unifiedlogging$UnifiedLoggingScopeListener).getName(), (Object)this, null);
        this.logger.normal(4).append("[DebugProbeManager] starting DebugProbeManager ...").log();
        debugProbeManagerServices.getLogManager().addHeartbeatInformationProvider("active.debug.probes", this);
        this.configurationManager = debugProbeManagerServices.getConfigurationManager();
        this.configurationManager.addNvListener(this, 0);
        this.services = debugProbeManagerServices;
        int n = this.configurationManager.getDynamicTmDebugProbesCfg();
        if (n == -3) {
            n = -2;
        }
        this.logger.normal(4).append("[DebugProbeManager] loading test mode trace settings '").append(n).append("' ...").log();
        this.applyConfigFromConfigurationManager(n);
    }

    public void sendReady() {
        this.binaryMessageLogger.getBinaryMessage((short)6).send();
        this.debugInterfaceReady = true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public String getInformation(String string) {
        if (!"active.debug.probes".equals(string)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Object object = MUTEX;
        synchronized (object) {
            Iterator iterator = this.probes.entrySet().iterator();
            while (iterator.hasNext()) {
                ObjectObjectMap$Entry objectObjectMap$Entry = (ObjectObjectMap$Entry)iterator.next();
                DebugProbe debugProbe = (DebugProbe)objectObjectMap$Entry.getValue();
                if (!debugProbe.isActive()) continue;
                arrayList.add(objectObjectMap$Entry.getKey());
            }
        }
        if (arrayList.isEmpty()) {
            return "NONE";
        }
        return arrayList.toString();
    }

    private void messageDecoded(byte by, ByteArrayReader byteArrayReader) {
        try {
            this.codec.decode(by, byteArrayReader, this);
        }
        catch (IOException iOException) {
            this.logger.error(4, "[DebugProbeManager] error while reading debug spi message!", iOException);
        }
    }

    @Override
    public void notifyNvListener(int n) {
        this.logger.trace(4, "[DebugProbeManager] configuration for DebugProbeManager was changed in test mode screen");
        int n2 = this.configurationManager.getDynamicTmDebugProbesCfg();
        this.applyConfigFromConfigurationManager(n2);
    }

    @Override
    public void probeConfigurationBinaryDecoded(String string, byte[] byArray) {
        DebugProbe debugProbe;
        if (this.logger.isTraceEnabled(4)) {
            this.logger.trace(4).append("[DebugProbeManager] configuration for probe ").append(string).append(" received").log();
        }
        if ((debugProbe = (DebugProbe)this.probes.get(string)) != null) {
            debugProbe.activate(byArray);
        } else if (this.logger.isTraceEnabled(4)) {
            this.logger.trace(4).append("[DebugProbeManager] configuration for inactive probe '").append(string).append("' ignored!").log();
        }
        ((LogManagerDiag)this.services.getLogManager()).updateLogManagerDiagListener(null);
    }

    @Override
    public void probeConfigurationPropertiesDecoded(byte[] byArray) {
        if (this.logger.isTraceEnabled(4)) {
            this.logger.trace(4).append("[DebugProbeManager] configuration (as properties map) received").log();
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byArray);
        try {
            this.probeConfigurationsMap = DebugProbeConfigurationCodec.loadConfiguration(byteArrayInputStream);
            this.applyConfiguration(this.probeConfigurationsMap);
        }
        catch (IOException iOException) {
            this.logger.warn(4, "[DebugProbeManager] new configuration couldn't be read!");
        }
        ((LogManagerDiag)this.services.getLogManager()).updateLogManagerDiagListener(null);
    }

    @Override
    public void probeManagerConfigurationDecoded(byte[] byArray) {
        if (this.logger.isTraceEnabled(4)) {
            this.logger.trace(4).append("[DebugProbeManager] configuration for DebugProbeManager received").log();
        }
        try {
            this.debugProbeManagerConfig.load(byArray);
            this.configureProbesFromConfig(this.probeConfigurationsMap);
        }
        catch (IOException iOException) {
            this.logger.error(4).append("[DebugProbeManager] error while activating probes!").log();
        }
    }

    @Override
    public void probeRequestProbemanagerActiveDecoded() {
        if (this.logger.isTraceEnabled(4)) {
            this.logger.trace(4).append("[DebugProbeManager] 'is DebugProbeManager active' request received").log();
        }
        if (this.debugInterfaceReady) {
            this.sendReady();
        }
    }

    @Override
    public void requestConfigurationDecoded(String string) {
        if (this.logger.isTraceEnabled(4)) {
            this.logger.trace(4).append("[DebugProbeManager] request for configuration of probe ").append(string).append(" received").log();
        }
        DebugProbe debugProbe = (DebugProbe)this.probes.get(string);
        debugProbe.responseConfigurationRequest();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("DebugProbeManager").append(DebugProbeConfigurationCodec.LINEFEED);
        stringBuffer.append("  sinks:  ");
        if (this.debugProbeManagerConfig.isFileSinkEnabled()) {
            stringBuffer.append("FILE, ");
        }
        if (this.debugProbeManagerConfig.isSerialSinkEnabled()) {
            stringBuffer.append("SERIAL, ");
        }
        if (this.debugProbeManagerConfig.isTcpSinkEnabled()) {
            stringBuffer.append("TCP");
        }
        stringBuffer.append(DebugProbeConfigurationCodec.LINEFEED);
        stringBuffer.append("debug probes: ");
        Object object = MUTEX;
        synchronized (object) {
            Iterator iterator = this.probes.entrySet().iterator();
            while (iterator.hasNext()) {
                ObjectObjectMap$Entry objectObjectMap$Entry = (ObjectObjectMap$Entry)iterator.next();
                String string = (String)objectObjectMap$Entry.getKey();
                stringBuffer.append(DebugProbeConfigurationCodec.LINEFEED);
                stringBuffer.append("  ").append(string).append(" - ").append(this.probes.get(string)).append(": ").append(objectObjectMap$Entry.getValue() == null ? "inactive" : "active");
            }
        }
        return stringBuffer.toString();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    synchronized void configureProbesFromConfig(Map map) {
        Object object;
        Object[] objectArray = this.debugProbeManagerConfig.getActiveDebugProbes();
        if (this.logger.isTraceEnabled(4)) {
            object = this.logger.trace(4).append("[DebugProbeManager] applying new DebugProbeManager configuration - active probes: ");
            if (objectArray.length == 0) {
                object.append("none");
            } else {
                object.append((String)objectArray[0]);
                for (int i2 = 1; i2 < objectArray.length; ++i2) {
                    object.append(", ").append((String)objectArray[i2]);
                }
            }
            object.log();
        }
        object = Arrays.asList(objectArray);
        Object object2 = MUTEX;
        synchronized (object2) {
            Iterator iterator = this.probes.entrySet().iterator();
            while (iterator.hasNext()) {
                ObjectObjectMap$Entry objectObjectMap$Entry = (ObjectObjectMap$Entry)iterator.next();
                String string = (String)objectObjectMap$Entry.getKey();
                DebugProbe debugProbe = (DebugProbe)objectObjectMap$Entry.getValue();
                if (object.contains(string)) {
                    Properties properties = null;
                    if (map != null) {
                        properties = (Properties)map.get(string);
                    }
                    if (properties == null) {
                        if (debugProbe.isActive()) continue;
                        properties = new Properties();
                    }
                    if (this.logger.isTraceEnabled(4)) {
                        this.logger.trace(4).append("[DebugProbeManager] initialize probe '").append(string).append("' ...").log();
                    }
                    if (debugProbe.activate(properties)) continue;
                    this.logger.warn(4).append("[DebugProbeManager] initialization of probe '").append(string).append("' failed!").log();
                    continue;
                }
                if (this.logger.isTraceEnabled(4)) {
                    this.logger.trace(4).append("[DebugProbeManager] clean up probe '").append(string).append("' ...").log();
                }
                debugProbe.deactivate();
            }
        }
        if (this.logger.isTraceEnabled(4)) {
            this.logger.trace(4).append("[DebugProbeManager] new DebugProbeManager configuration applied! ").append(this).log();
        }
    }

    private void applyConfiguration(Map map) {
        Properties properties = (Properties)map.remove("PROBES");
        if (properties != null) {
            this.debugProbeManagerConfig.load(properties);
            this.configureProbesFromConfig(map);
        } else {
            Iterator iterator = map.keySet().iterator();
            while (iterator.hasNext()) {
                String string = (String)iterator.next();
                DebugProbe debugProbe = (DebugProbe)this.probes.get(string);
                if (debugProbe != null) {
                    Properties properties2 = (Properties)map.get(string);
                    if (debugProbe.activate(properties2)) continue;
                    this.logger.warn(4).append("[DebugProbeManager] configuration for probe '").append(string).append("' failed!").log();
                    continue;
                }
                this.logger.warn(4).append("[DebugProbeManager] configuration for inactive probe '").append(string).append("' ignored!").log();
            }
        }
    }

    private void applyConfigFromConfigurationManager(int n) {
        if (DIRECT_FILE_CONFIG_PATH != null) {
            this.logger.normal(4).append("[DebugProbeManager] Reading debug probe configuration '").append(DIRECT_FILE_CONFIG_PATH).append("' (specified by system property '").append("debugprobes.config").append("')").log();
            this.readConfigurationFromFile(DIRECT_FILE_CONFIG_PATH);
            return;
        }
        if (PROBE_CONFIG_PATH == null) {
            this.logger.error(4, "[DebugProbeManager] No directory set for debug probe configuration files!");
            this.logger.error(4).append("[DebugProbeManager] Please set system property '").append("debugprobes.config.path").append("'!").log();
            this.logger.error(4, "[DebugProbeManager] All debug probes keep deactivated!");
            return;
        }
        switch (n) {
            case -3: {
                this.logger.normal(4, "[DebugProbeManager] Using probe configuration received from HMIMonitor!");
                return;
            }
            case -2: {
                this.logger.warn(4, "[DebugProbeManager] Deactivating all debug probes (specified in TESTMODE) ...");
                this.debugProbeManagerConfig.setActiveDebugProbes(ALWAYS_ON_PROBES);
                this.configureProbesFromConfig(this.probeConfigurationsMap);
                return;
            }
            case -1: {
                for (int i2 = 0; i2 < this.configurationManager.getNumberOfSDSlots(); ++i2) {
                    String string = this.configurationManager.getSdMountName(i2);
                    if (!new File(new StringBuffer().append(string).append("/debugprobes.config").toString()).exists()) continue;
                    this.logger.normal(4).append("[DebugProbeManager] Reading debug probe configuration from SD card: '").append(string).append("/debugprobes.config' (specified in TESTMODE) ...").log();
                    this.readConfigurationFromFile(string);
                    return;
                }
                this.logger.warn(4, "[DebugProbeManager] No debug probe configuration found on any SD card! Deactivating all debug probes!");
                this.applyConfigFromConfigurationManager(-2);
                break;
            }
            default: {
                String string;
                if (this.classifierToFilenames == null) {
                    this.buildFilenameMap();
                }
                if ((string = (String)this.classifierToFilenames.get(n)) == null) {
                    this.logger.warn(4, new StringBuffer().append("[DebugProbeManager] No debug probe configuration file specified for config type '").append(n).append("'!").toString());
                    this.applyConfigFromConfigurationManager(-2);
                    return;
                }
                String string2 = new StringBuffer().append(PROBE_CONFIG_PATH).append(File.separator).append(string).toString();
                if (new File(string2).exists()) {
                    this.logger.normal(4).append("[DebugProbeManager] Reading debug probe configuration '").append(string2).append("' (given by the configuration manager)").log();
                    this.readConfigurationFromFile(string2);
                    return;
                }
                this.logger.warn(4, new StringBuffer().append("[DebugProbeManager] Debug probe configuration '").append(string2).append("' (given by system property '").append("debugprobes.config.path").append("' and the configuration manager) not found!").toString());
                this.applyConfigFromConfigurationManager(-2);
                break;
            }
        }
    }

    private void buildFilenameMap() {
        File file;
        File[] fileArray;
        this.classifierToFilenames = new IntObjectOptHashMap();
        if (PROBE_CONFIG_PATH != null && (fileArray = (file = new File(PROBE_CONFIG_PATH)).listFiles(new DebugProbeManagerImpl$1(this))).length > 0) {
            for (int i2 = 0; i2 < fileArray.length; ++i2) {
                String string = fileArray[i2].getName();
                String string2 = string.substring(START_PONT_OF_IDENTIFIER, START_PONT_OF_IDENTIFIER + 3);
                try {
                    int n = Integer.parseInt(string2);
                    this.classifierToFilenames.put(n, string);
                    continue;
                }
                catch (NumberFormatException numberFormatException) {
                    // empty catch block
                }
            }
        }
    }

    private void readConfigurationFromFile(String string) {
        try {
            FileInputStream fileInputStream = new FileInputStream(string);
            this.probeConfigurationsMap = DebugProbeConfigurationCodec.loadConfiguration(fileInputStream);
            this.applyConfiguration(this.probeConfigurationsMap);
        }
        catch (Exception exception) {
            this.logger.error(4, "[DebugProbeManager] the configuration file couldn't be read!", exception);
        }
    }

    @Override
    public void registerDebugProbe(DebugProbeFactory debugProbeFactory) {
        if (this.probes.containsKey(debugProbeFactory.getName())) {
            this.logger.warn(4).append("[DebugProbeManager] Debug probe ").append(debugProbeFactory.getName()).append(" already registered.").log();
        }
        this.createProbe(debugProbeFactory);
        this.waitForService(debugProbeFactory);
    }

    private void waitForService(DebugProbeFactory debugProbeFactory) {
        Object[] objectArray;
        String string = debugProbeFactory.getName();
        DebugProbe debugProbe = (DebugProbe)this.probes.get(string);
        if (this.logger.isTraceEnabled(4)) {
            this.logger.trace(4).append("Debug probe factory registered: ").append(string).log();
        }
        if ((objectArray = debugProbeFactory.getMandatoryServiceNames()) == null || objectArray.length == 0) {
            debugProbe.init();
            this.initialConfigureProbe(debugProbeFactory, debugProbe);
            return;
        }
        List list = Arrays.asList(objectArray);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(|");
        for (int i2 = 0; i2 < list.size(); ++i2) {
            stringBuilder.append("(").append("objectClass").append("=").append(list.get(i2)).append(")");
        }
        stringBuilder.append(")");
        String string2 = stringBuilder.toString();
        try {
            DebugProbeManagerImpl$2 debugProbeManagerImpl$2 = new DebugProbeManagerImpl$2(this, list, debugProbe, debugProbeFactory);
            ServiceReference[] serviceReferenceArray = this.bundleContext.getServiceReferences(null, string2);
            for (int i3 = 0; i3 < serviceReferenceArray.length; ++i3) {
                debugProbeManagerImpl$2.serviceChanged(new ServiceEvent(1, serviceReferenceArray[i3]));
            }
            this.bundleContext.addServiceListener(debugProbeManagerImpl$2, string2);
        }
        catch (InvalidSyntaxException invalidSyntaxException) {
            this.logger.error(4).append("[DebugProbeManager] Couldn't register service listener for debug probe ").append(string).append("!").append(invalidSyntaxException).log();
        }
    }

    void initialConfigureProbe(DebugProbeFactory debugProbeFactory, DebugProbe debugProbe) {
        if (this.debugProbeManagerConfig.isDebugProbeActive(debugProbeFactory.getName())) {
            Properties properties = this.probeConfigurationsMap == null || !this.probeConfigurationsMap.containsKey(debugProbeFactory.getName()) ? new Properties() : (Properties)this.probeConfigurationsMap.get(debugProbeFactory.getName());
            if (this.logger.isTraceEnabled(4)) {
                this.logger.trace(4).append("[DebugProbeManager] activate probe '").append(debugProbeFactory.getName()).append("' ...").log();
            }
            if (!debugProbe.activate(properties)) {
                this.logger.warn(4).append("[DebugProbeManager] activation of probe '").append(debugProbeFactory.getName()).append("' failed!").log();
            }
        }
    }

    private DebugProbe createProbe(DebugProbeFactory debugProbeFactory) {
        ProbeSystemServiceImpl probeSystemServiceImpl = new ProbeSystemServiceImpl(this.services.getLoggerFactory(), this.services.getBinaryLogger(), this.services.getTimerManager(), this.bundleContext, debugProbeFactory);
        DebugProbe debugProbe = debugProbeFactory.createProbe(probeSystemServiceImpl);
        this.probes.put(debugProbeFactory.getName(), debugProbe);
        return debugProbe;
    }

    @Override
    public void unregisterDebugProbe(DebugProbeFactory debugProbeFactory) {
        DebugProbe debugProbe = (DebugProbe)this.probes.remove(debugProbeFactory.getName());
        if (debugProbe != null) {
            debugProbe.cleanUp();
        }
    }

    @Override
    public void onBinaryMessageReceived(short s, byte[] byArray, int n, int n2) {
        this.reader.reset(byArray, n);
        this.messageDecoded((byte)s, this.reader);
    }

    @Override
    public void onLogLevelChanged(int n, int[] nArray, int[] nArray2) {
    }

    @Override
    public void onLogSinkStateChanged(int n, boolean bl) {
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
        DIRECT_FILE_CONFIG_PATH = System.getProperty("debugprobes.config");
        PROBE_CONFIG_PATH = System.getProperty("debugprobes.config.path");
        START_PONT_OF_IDENTIFIER = "debugprobes_".length();
        MUTEX = new Object();
    }
}

