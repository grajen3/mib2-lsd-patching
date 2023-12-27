/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.configuration;

import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.bap.mqbab2.common.api.APIFactoryInterface;
import de.vw.mib.bap.mqbab2.common.api.asl.ASLDataPoolAdapter;
import de.vw.mib.bap.mqbab2.common.api.configuration.ConfigurationAdapter$1;
import de.vw.mib.bap.mqbab2.common.api.configuration.ConfigurationAdapter$2;
import de.vw.mib.bap.mqbab2.common.api.configuration.ConfigurationAdapter$3;
import de.vw.mib.bap.mqbab2.common.api.configuration.ConfigurationService;
import de.vw.mib.bap.mqbab2.common.api.configuration.ConfigurationServiceLanguageChangeListener;
import de.vw.mib.bap.mqbab2.common.api.configuration.ConfigurationServiceListener;
import de.vw.mib.configuration.ConfigurationManager;
import de.vw.mib.configuration.ConfigurationManagerAsyncValueSetterService;
import de.vw.mib.configuration.NvListener;
import de.vw.mib.configuration.RtMethodListener;
import de.vw.mib.datapool.ASLDatapool;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class ConfigurationAdapter
extends ASLDataPoolAdapter
implements ConfigurationService,
NvListener,
ServiceTrackerCustomizer,
RtMethodListener {
    private APIFactoryInterface apiFactory;
    private ConfigurationManager configurationManager;
    private ConfigurationManagerAsyncValueSetterService configurationManagerAsyncSetterService;
    protected static int LIST_INITIAL_CAPACITY = 20;
    protected List languageChangeListeners;
    protected List configurationListeners;
    private boolean instrumentClusterDisplaySizeWasAlreadySet = false;
    private int updatedInstrumentClusterDisplaySize = 0;
    static /* synthetic */ Class class$de$vw$mib$configuration$ConfigurationManagerAsyncValueSetterService;

    public ConfigurationAdapter(ConfigurationManager configurationManager, APIFactoryInterface aPIFactoryInterface, ASLDatapool aSLDatapool) {
        super(aSLDatapool);
        this.apiFactory = aPIFactoryInterface;
        this.configurationManager = configurationManager;
        this.configurationManager.addNvListener(this, 2);
        ServiceTracker serviceTracker = new ServiceTracker(ASLFrameworkFactory.getASLFrameworkAPI().getServices().getBundleContext(), (class$de$vw$mib$configuration$ConfigurationManagerAsyncValueSetterService == null ? (class$de$vw$mib$configuration$ConfigurationManagerAsyncValueSetterService = ConfigurationAdapter.class$("de.vw.mib.configuration.ConfigurationManagerAsyncValueSetterService")) : class$de$vw$mib$configuration$ConfigurationManagerAsyncValueSetterService).getName(), (ServiceTrackerCustomizer)this);
        serviceTracker.open();
        this.configurationManager.addRtMethodListener(this);
    }

    protected APIFactoryInterface getAPIFactory() {
        return this.apiFactory;
    }

    protected List getLanguageChangeListeners() {
        if (this.languageChangeListeners == null) {
            this.languageChangeListeners = new ArrayList(LIST_INITIAL_CAPACITY);
        }
        return this.languageChangeListeners;
    }

    @Override
    public void addLanguageChangeListener(ConfigurationServiceLanguageChangeListener configurationServiceLanguageChangeListener) {
        List list = this.getLanguageChangeListeners();
        if (!list.contains(configurationServiceLanguageChangeListener)) {
            list.add(configurationServiceLanguageChangeListener);
        }
    }

    @Override
    public void removeLanguageChangeListener(ConfigurationServiceLanguageChangeListener configurationServiceLanguageChangeListener) {
        List list = this.getLanguageChangeListeners();
        list.remove(configurationServiceLanguageChangeListener);
    }

    @Override
    public void addConfigurationListener(ConfigurationServiceListener configurationServiceListener, int[] nArray) {
        this.registerServiceListener((Object)configurationServiceListener, nArray);
    }

    @Override
    public void removeConfigurationListener(ConfigurationServiceListener configurationServiceListener, int[] nArray) {
        this.removeServiceListener(configurationServiceListener, nArray);
    }

    @Override
    public boolean isTvFeatureSelected() {
        return this.configurationManager.isFeatureFlagSet(425);
    }

    @Override
    public boolean isWLANFeatureSelected() {
        return this.configurationManager.isFeatureFlagSet(479);
    }

    @Override
    public boolean isJapanVariantSelected() {
        return this.configurationManager.isFeatureFlagSet(75);
    }

    @Override
    public boolean isNARVariantSelected() {
        return this.configurationManager.isFeatureFlagSet(2);
    }

    @Override
    public boolean isChinaVariantSelected() {
        return this.configurationManager.isFeatureFlagSet(26);
    }

    @Override
    public boolean isNavigationFeatureSelected() {
        return this.configurationManager.isFeatureFlagSet(367);
    }

    @Override
    public boolean isSpeechStartupFeatureSelected() {
        return this.configurationManager.isFeatureFlagSet(368);
    }

    @Override
    public boolean isSpeechFeatureBuiltIn() {
        return this.configurationManager.isFeatureFlagSet(534);
    }

    @Override
    public boolean isSpeechCoded() {
        return this.configurationManager.isFeatureFlagSet(535);
    }

    @Override
    public boolean isSpeechFeatureSWAPSelected() {
        return this.configurationManager.isFeatureFlagSet(582);
    }

    @Override
    public boolean isSpeechFeatureSelected() {
        return this.configurationManager.isFeatureFlagSet(533);
    }

    @Override
    public boolean isExboxFeatureSelected() {
        return this.configurationManager.isFeatureFlagSet(60);
    }

    @Override
    public String getCurrentGUILanguage() {
        return this.configurationManager.getCurrentGuiLanguage();
    }

    @Override
    public int getAvailableNumberOfSDCardSlots() {
        return this.configurationManager.getNumberOfSDSlots();
    }

    @Override
    public boolean isBAPTunerDABDoubleTunerAvailable() {
        return this.configurationManager.getBAPTUNERDABDoubleTuner();
    }

    @Override
    public int getBAPFsgFcVersion() {
        return this.configurationManager.getBAPFsgFcVersion();
    }

    @Override
    public boolean isMapSwitchingFeatureSelected() {
        return this.configurationManager.isFeatureFlagSet(139);
    }

    @Override
    public boolean isAppConnectFeatureSelected() {
        return this.configurationManager.isFeatureFlagSet(451);
    }

    @Override
    public boolean isCarLifeFeatureSelected() {
        boolean bl = this.configurationManager.isFeatureFlagSet(23);
        boolean bl2 = this.configurationManager.isFeatureFlagSet(24);
        return bl || bl2;
    }

    @Override
    public boolean isCarPlayFeatureSelected() {
        return this.configurationManager.isFeatureFlagSet(25);
    }

    @Override
    public boolean isAndroidAutoFeatureSelected() {
        return this.configurationManager.isFeatureFlagSet(4);
    }

    @Override
    public int mapInstrumentClusterDisplaySizeFromBAPToSystem(int n) {
        switch (n) {
            case 1: 
            case 2: {
                return 1;
            }
        }
        return 0;
    }

    @Override
    public void setInstrumentClusterDisplaySize(int n) {
        if (this.configurationManagerAsyncSetterService == null) {
            this.instrumentClusterDisplaySizeWasAlreadySet = true;
            this.updatedInstrumentClusterDisplaySize = n;
        } else {
            this.configurationManagerAsyncSetterService.setInstrumentClusterSize(n);
        }
    }

    @Override
    public void notifyNvListener(int n) {
        this.getAPIFactory().getThreadSwitchingService().enqueue(new ConfigurationAdapter$1(this));
    }

    private void notifyNvListenerInternal() {
        List list = this.getLanguageChangeListeners();
        for (int i2 = 0; i2 < list.size(); ++i2) {
            ConfigurationServiceLanguageChangeListener configurationServiceLanguageChangeListener = (ConfigurationServiceLanguageChangeListener)list.get(i2);
            configurationServiceLanguageChangeListener.languageChanged();
        }
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = ASLFrameworkFactory.getASLFrameworkAPI().getServices().getBundleContext().getService(serviceReference);
        this.configurationManagerAsyncSetterService = (ConfigurationManagerAsyncValueSetterService)object;
        if (this.instrumentClusterDisplaySizeWasAlreadySet) {
            this.instrumentClusterDisplaySizeWasAlreadySet = false;
            this.configurationManagerAsyncSetterService.setInstrumentClusterSize(this.updatedInstrumentClusterDisplaySize);
        }
        return this.configurationManagerAsyncSetterService;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void onRtMethodValueChanged(String string) {
        if ("ASL.Configuration.isSdsSwAP".equals(string)) {
            this.getAPIFactory().getThreadSwitchingService().enqueue(new ConfigurationAdapter$2(this));
        } else if ("ASL.Configuration.isNavMapSwitch".equals(string)) {
            this.getAPIFactory().getThreadSwitchingService().enqueue(new ConfigurationAdapter$3(this));
        }
    }

    private void _notifyServiceDelegates(int n) {
        List list = this.getRegisteredServiceDelegates(n);
        if (list != null) {
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                ConfigurationServiceListener configurationServiceListener = (ConfigurationServiceListener)iterator.next();
                configurationServiceListener.updateConfigurationData(this, n);
            }
        }
    }

    @Override
    public void datapoolValueChanged(int n) {
        this._notifyServiceDelegates(n);
    }

    @Override
    protected int[] getPropertyIds() {
        return null;
    }

    @Override
    protected int[] getListIds() {
        return null;
    }

    @Override
    protected void listValueChanged(int n) {
        this._notifyServiceDelegates(n);
    }

    @Override
    public boolean isHighVariant() {
        return this.configurationManager.isFeatureFlagSet(70);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ void access$000(ConfigurationAdapter configurationAdapter) {
        configurationAdapter.notifyNvListenerInternal();
    }

    static /* synthetic */ void access$100(ConfigurationAdapter configurationAdapter, int n) {
        configurationAdapter._notifyServiceDelegates(n);
    }
}

