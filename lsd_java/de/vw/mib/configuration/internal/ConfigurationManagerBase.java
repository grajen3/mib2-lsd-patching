/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.configuration.internal;

import de.vw.mib.collections.copyonwrite.CowList;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.configuration.ConfigurationManagerObserver;
import de.vw.mib.configuration.FeatureFlagValueChangeReceiver;
import de.vw.mib.configuration.RtMethodListener;
import de.vw.mib.configuration.internal.ConfigurationManagerBase$1;
import de.vw.mib.configuration.internal.ServiceManager;
import de.vw.mib.log4mib.Logger;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationManagerBase {
    private static final String SYSTEMPROPERTY_INSTALLATION_DIRECTORY;
    private static final String SYSTEMPROPERTY_CONFIGURATION_DIRECTORY;
    private static final String SYSTEMPROPERTY_CONFIGURATION_RESOURCES_DIRECTORY;
    private static final String SYSTEMPROPERTY_RESOURCES_DIRECTORY;
    private static final int OBJSWAP_APP_ASSEMBLY_STRINGS_INDEX;
    private static final int OBJSWAP_APP_ASSEMBLY_INTS_INDEX;
    private static final ConfigurationManagerObserver DEFAULT_OBSERVER;
    protected int[] availableSkins;
    private String installationPath = null;
    private String configurationPath = null;
    private String configurationResourcesPath = null;
    private String resourcesPath = null;
    protected Object[] objectSwapperData = null;
    protected boolean objectSwapperDataIsInitialized = false;
    protected Logger logger;
    protected String mediaCountryCodeHmi = null;
    protected CowList rtMethodListeners;
    protected ConfigurationManagerObserver observer;
    private final IntObjectOptHashMap featureFlagValueChangeReceivers = new IntObjectOptHashMap();

    public ConfigurationManagerBase() {
        this.rtMethodListeners = CowList.EMPTY;
        this.observer = DEFAULT_OBSERVER;
        this.initServices();
    }

    protected void initServices() {
        this.logger = ServiceManager.loggerFactory.getLogger(4);
    }

    void setProperties(Properties properties) {
        new Exception("You shouldn't call this!").printStackTrace();
    }

    public void addRtMethodListener(RtMethodListener rtMethodListener) {
        this.rtMethodListeners = this.rtMethodListeners.add(rtMethodListener);
    }

    public void removeRtMethodListener(RtMethodListener rtMethodListener) {
        this.rtMethodListeners = this.rtMethodListeners.remove(rtMethodListener);
    }

    public void addFeatureFlagValueChangeReceiver(FeatureFlagValueChangeReceiver featureFlagValueChangeReceiver, int n) {
        CowList cowList = (CowList)this.featureFlagValueChangeReceivers.get(n);
        if (cowList == null) {
            cowList = CowList.EMPTY;
        }
        cowList = cowList.add(featureFlagValueChangeReceiver);
        this.featureFlagValueChangeReceivers.put(n, cowList);
    }

    public void removeFeatureFlagValueChangeReceiver(FeatureFlagValueChangeReceiver featureFlagValueChangeReceiver, int n) {
        CowList cowList = (CowList)this.featureFlagValueChangeReceivers.get(n);
        if (cowList != null) {
            cowList = cowList.remove(featureFlagValueChangeReceiver);
            this.featureFlagValueChangeReceivers.put(n, cowList);
        }
    }

    protected void notifyFeatureFlagValueChangeReceivers(int n, boolean bl) {
        CowList cowList = (CowList)this.featureFlagValueChangeReceivers.get(n);
        if (cowList != null) {
            for (CowList cowList2 = cowList; cowList2 != CowList.EMPTY; cowList2 = cowList2.tail()) {
                ((FeatureFlagValueChangeReceiver)cowList2.head()).receiveFeatureFlagValue(n, bl);
            }
        }
    }

    protected void notifyRtMethodListeners(String string) {
        for (CowList cowList = this.rtMethodListeners; cowList != CowList.EMPTY; cowList = cowList.tail()) {
            ((RtMethodListener)cowList.head()).onRtMethodValueChanged(string);
        }
    }

    public void removeObserver() {
        this.observer = DEFAULT_OBSERVER;
    }

    public void setObserver(ConfigurationManagerObserver configurationManagerObserver) {
        this.observer = configurationManagerObserver;
    }

    protected void sendFeatureFlagUpdate(int n, String string) {
        this.observer.receiveFeatureFlagUpdate(n, string);
    }

    protected String getResourcesPath() {
        if (this.resourcesPath == null) {
            this.resourcesPath = System.getProperty("de.vw.mib.resources.directory", new StringBuffer().append(ServiceManager.fileManager.getFileForRelativePath("").getAbsolutePath()).append("/").toString());
            if (!this.resourcesPath.endsWith("/") && !this.resourcesPath.endsWith("\\")) {
                this.resourcesPath = new StringBuffer().append(this.resourcesPath).append("/").toString();
            }
        }
        return this.resourcesPath;
    }

    public String getConfigurationPath() {
        if (this.configurationPath == null) {
            this.configurationPath = System.getProperty("de.vw.mib.configuration.directory");
            if (this.configurationPath != null && !this.configurationPath.endsWith("/") && !this.configurationPath.endsWith("\\")) {
                this.configurationPath = new StringBuffer().append(this.configurationPath).append("/").toString();
            }
        }
        return this.configurationPath;
    }

    protected String getConfigurationResourcesPath() {
        if (this.configurationResourcesPath == null) {
            this.configurationResourcesPath = System.getProperty("vw.mib.resources");
            if (this.configurationResourcesPath != null && !this.configurationResourcesPath.endsWith("/") && !this.configurationResourcesPath.endsWith("\\")) {
                this.configurationResourcesPath = new StringBuffer().append(this.configurationResourcesPath).append("/").toString();
            }
        }
        return this.configurationResourcesPath;
    }

    public String getConfigurationResourceFilePath(String string) {
        if (this.getConfigurationResourcesPath() == null) {
            this.logger.error(2).append("Undefined system property \"").append("vw.mib.resources").append("\"").log();
            return string;
        }
        return new StringBuffer().append(this.getConfigurationResourcesPath()).append(string).toString();
    }

    protected String getInstallationPath() {
        if (this.installationPath == null) {
            this.installationPath = System.getProperty("de.vw.mib.installation.directory");
            if (!this.installationPath.endsWith("/") && !this.installationPath.endsWith("\\")) {
                this.installationPath = new StringBuffer().append(this.installationPath).append("/").toString();
            }
        }
        return this.installationPath;
    }

    public String getConfigurationFilePath(String string) {
        if (this.getConfigurationPath() == null) {
            this.logger.error(2).append("Undefined system property \"").append("de.vw.mib.configuration.directory").append("\"").log();
            return string;
        }
        return new StringBuffer().append(this.getConfigurationPath()).append(string).toString();
    }

    public Object[] readDataFromObjectSwapperFile(String string) {
        File file = new File(string);
        if (ServiceManager.fileManager != null) {
            try {
                Object[] objectArray = ServiceManager.fileManager.readDataFromObjectSwapperFile(file);
                return objectArray;
            }
            catch (IOException iOException) {
                ServiceManager.loggerFactory.getLogger(4).warn(2).append("Couldn't read the configuration file '").append(file.getAbsolutePath()).append("'.").attachThrowable(iOException).log();
            }
        }
        return null;
    }

    protected boolean isObjectSwapperDataAvailable(int n) {
        if (!this.objectSwapperDataIsInitialized) {
            this.objectSwapperData = this.readDataFromObjectSwapperFile(this.getConfigurationResourceFilePath("configurationmanager.res"));
            this.objectSwapperDataIsInitialized = true;
        }
        return this.objectSwapperData != null && n < this.objectSwapperData.length;
    }

    protected void checkArrayIndex(int n, int n2) {
        if (n < 0 || n > n2) {
            throw new RuntimeException(new StringBuffer().append("Index ").append(n).append(" is out of range (0..").append(n2).append(")!").toString());
        }
    }

    public String[] getAppAssemblyStringData() {
        if (this.isObjectSwapperDataAvailable(25)) {
            return (String[])this.objectSwapperData[25];
        }
        return null;
    }

    public int[] getAppAssemblyIntData() {
        if (this.isObjectSwapperDataAvailable(26)) {
            return (int[])this.objectSwapperData[26];
        }
        return null;
    }

    static {
        DEFAULT_OBSERVER = new ConfigurationManagerBase$1();
    }
}

