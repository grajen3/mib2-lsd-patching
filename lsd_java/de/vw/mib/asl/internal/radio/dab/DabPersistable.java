/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.dab;

import de.vw.mib.asl.amfm.persistence.AmFmPersistenceService;
import de.vw.mib.asl.amfm.persistence.ComponentPersistence;
import de.vw.mib.asl.amfm.persistence.DabPersistence;
import de.vw.mib.asl.amfm.persistence.DabPresetPersistence;
import de.vw.mib.asl.amfm.persistence.EnsemblePersistence;
import de.vw.mib.asl.amfm.persistence.FrequencyPersistence;
import de.vw.mib.asl.amfm.persistence.ServicePersistence;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioCodingAdapter;
import de.vw.mib.asl.internal.radio.RadioConstants;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.RadioServiceManager;
import de.vw.mib.asl.internal.radio.RadioUtil;
import de.vw.mib.asl.internal.radio.dab.presets.DabPreset;
import de.vw.mib.asl.internal.radio.dab.presets.DabPresetApi;
import de.vw.mib.asl.internal.radio.dab.presets.DabPresetList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.dsi.ifc.radio.ComponentInfo;
import org.dsi.ifc.radio.EnsembleInfo;
import org.dsi.ifc.radio.FrequencyInfo;
import org.dsi.ifc.radio.ServiceInfo;

public class DabPersistable {
    private FrequencyInfo mCurrentFrequency = null;
    private EnsembleInfo mCurrentEnsemble = null;
    private ServiceInfo mCurrentService = null;
    private EnsembleInfo mLinkingEnsemble = null;
    private ServiceInfo mLinkingService = null;
    private ComponentInfo mCurrentComponent = null;
    private boolean mLBandOptionState = true;
    private boolean mOtherAnnouncementOption = true;
    private boolean mTrafficAnnouncementOption = true;
    private boolean mDabFollowing = true;
    private boolean mFmLinking = true;
    private boolean softLinkingOption = true;
    private int mViewMode = 0;
    public DabPreset[] mPresets;
    private int mVisibleBankIndex = 0;
    private int mCurrentPresetIndexSelectedByHmi = -1;
    private boolean mLsmSupportsSlideshow = false;
    private int mCurrentBand1 = 2;
    private int mCurrentBand2 = 1;
    private boolean isWriteAccessBlocked = true;

    public DabPersistable() {
        this.clear();
    }

    public EnsembleInfo getCurrentEnsemble() {
        return this.mCurrentEnsemble;
    }

    public ServiceInfo getCurrentService() {
        return this.mCurrentService;
    }

    public int getViewMode() {
        return this.mViewMode;
    }

    public ComponentInfo getCurrentComponent() {
        return this.mCurrentComponent;
    }

    boolean getLBandOptionState() {
        return this.mLBandOptionState;
    }

    boolean getOtherAnnouncementOption() {
        return this.mOtherAnnouncementOption;
    }

    boolean getTrafficAnnouncementOption() {
        return this.mTrafficAnnouncementOption;
    }

    boolean getDabFollowing() {
        return this.mDabFollowing;
    }

    boolean getFmLinking() {
        return this.mFmLinking;
    }

    public int getCurrentPresetIndexSelectedByHmi() {
        return this.mCurrentPresetIndexSelectedByHmi;
    }

    public int getVisibleBankIndex() {
        return this.mVisibleBankIndex;
    }

    public boolean lsmSupportsSlideShow() {
        return this.mLsmSupportsSlideshow;
    }

    public int getBand1() {
        return this.mCurrentBand1;
    }

    public int getBand2() {
        return this.mCurrentBand2;
    }

    public void setCurrentEnsemble(EnsembleInfo ensembleInfo) {
        if (ensembleInfo == null || ensembleInfo.ensID > 0) {
            this.mCurrentEnsemble = ensembleInfo;
            if (null != this.mCurrentEnsemble) {
                this.mCurrentEnsemble.fullName = this.mCurrentEnsemble.fullName.trim();
                RadioData.getDabDatabase().dabPresetList.correctEmptyEnsembleNameByPresetEnsembleName(this.mCurrentEnsemble);
            }
            if (RadioServiceManager.getServiceManager().getAdapterAslPersistence().isProfileChangeStarted()) {
                if (ServiceManager.logger.isTraceEnabled(256)) {
                    ServiceManager.logger.trace(256).append("DabPersistable - setCurrentEnsemble() - isProfileChangeStarted() == true").log();
                }
                return;
            }
            if (this.isPersistenceWriteAccessBlocked()) {
                return;
            }
            DabPersistence dabPersistence = RadioServiceManager.getServiceManager().getAdapterAslPersistence().getDabPersistence();
            AmFmPersistenceService amFmPersistenceService = RadioServiceManager.getServiceManager().getAdapterAslPersistence().getRadioPersistenceService();
            if (null != dabPersistence && null != amFmPersistenceService) {
                EnsemblePersistence ensemblePersistence = dabPersistence.getCurrentEnsemble();
                if (null == ensemblePersistence) {
                    ensemblePersistence = amFmPersistenceService.createEnsemblePersistence();
                }
                RadioServiceManager.getServiceManager().getAdapterAslPersistence().initEnsemblePersistence(ensemblePersistence, this.mCurrentEnsemble);
                dabPersistence.setCurrentEnsemble(ensemblePersistence);
                if (ServiceManager.logger.isTraceEnabled(256)) {
                    if (null == this.mCurrentEnsemble) {
                        ServiceManager.logger.trace(256).append("DabPersistable - toPersistence() - null == mCurrentEnsemble").log();
                    } else {
                        ServiceManager.logger.trace(256).append("DabPersistable - toPersistence() - mCurrentEnsemble = ").append(this.mCurrentEnsemble.toString()).log();
                    }
                }
            }
        }
    }

    public void setCurrentService(ServiceInfo serviceInfo) {
        if (serviceInfo == null || serviceInfo.sID > 0L) {
            this.mCurrentService = serviceInfo;
            RadioData.getDabDatabase().dabPresetList.correctEmptyServiceNameByPresetServiceName(this.mCurrentService);
            if (RadioServiceManager.getServiceManager().getAdapterAslPersistence().isProfileChangeStarted()) {
                if (ServiceManager.logger.isTraceEnabled(256)) {
                    ServiceManager.logger.trace(256).append("DabPersistable - setCurrentService() - isProfileChangeStarted() == true").log();
                }
                return;
            }
            if (this.isPersistenceWriteAccessBlocked()) {
                return;
            }
            DabPersistence dabPersistence = RadioServiceManager.getServiceManager().getAdapterAslPersistence().getDabPersistence();
            AmFmPersistenceService amFmPersistenceService = RadioServiceManager.getServiceManager().getAdapterAslPersistence().getRadioPersistenceService();
            if (null != dabPersistence && null != amFmPersistenceService) {
                ServicePersistence servicePersistence = dabPersistence.getCurrentService();
                if (null == servicePersistence) {
                    servicePersistence = amFmPersistenceService.createServicePersistence();
                }
                RadioServiceManager.getServiceManager().getAdapterAslPersistence().initServicePersistence(servicePersistence, this.mCurrentService);
                dabPersistence.setCurrentService(servicePersistence);
                if (ServiceManager.logger.isTraceEnabled(256)) {
                    if (null == this.mCurrentService) {
                        ServiceManager.logger.info(256).append("DabPersistable - toPersistence() - null == mCurrentService").log();
                    } else {
                        ServiceManager.logger.trace(256).append("DabPersistable - toPersistence() - mCurrentService = ").append(this.mCurrentService.toString()).log();
                    }
                }
            }
        }
    }

    public void setLinkingService(EnsembleInfo ensembleInfo, ServiceInfo serviceInfo) {
        if (serviceInfo == null || serviceInfo.sID > 0L) {
            this.mLinkingEnsemble = ensembleInfo;
            this.mLinkingService = serviceInfo;
            this.toPersistence();
        }
    }

    public ServiceInfo getLinkingService() {
        return this.mLinkingService;
    }

    public EnsembleInfo getLinkingEnsemble() {
        return this.mLinkingEnsemble;
    }

    public void setViewMode(int n) {
        if (this.mViewMode != n) {
            this.mViewMode = n;
            this.toPersistence();
        }
    }

    public void setCurrentComponent(ComponentInfo componentInfo) {
        if (componentInfo == null || componentInfo.ensID > 0 && componentInfo.sID > 0L) {
            this.mCurrentComponent = componentInfo;
            if (RadioServiceManager.getServiceManager().getAdapterAslPersistence().isProfileChangeStarted()) {
                if (ServiceManager.logger.isTraceEnabled(256)) {
                    ServiceManager.logger.trace(256).append("DabPersistable - setCurrentComponent() - isProfileChangeStarted() == true").log();
                }
                return;
            }
            if (this.isPersistenceWriteAccessBlocked()) {
                return;
            }
            DabPersistence dabPersistence = RadioServiceManager.getServiceManager().getAdapterAslPersistence().getDabPersistence();
            AmFmPersistenceService amFmPersistenceService = RadioServiceManager.getServiceManager().getAdapterAslPersistence().getRadioPersistenceService();
            if (null != dabPersistence && null != amFmPersistenceService) {
                ComponentPersistence componentPersistence = dabPersistence.getCurrentComponent();
                if (null == componentPersistence) {
                    componentPersistence = amFmPersistenceService.createComponentPersistence();
                }
                RadioServiceManager.getServiceManager().getAdapterAslPersistence().initComponentPersistence(componentPersistence, this.mCurrentComponent);
                dabPersistence.setCurrentComponent(componentPersistence);
                if (ServiceManager.logger.isTraceEnabled(256)) {
                    if (null == this.mCurrentComponent) {
                        ServiceManager.logger.trace(256).append("DabPersistable - toPersistence() - null == mCurrentComponent").log();
                    } else {
                        ServiceManager.logger.trace(256).append("DabPersistable - toPersistence() - mCurrentComponent = ").append(this.mCurrentComponent.toString()).log();
                    }
                }
            }
        }
    }

    public void setLBandOptionState(boolean bl) {
        if (bl != this.mLBandOptionState) {
            this.mLBandOptionState = bl;
            this.toPersistence();
        }
    }

    public void setDabFollowing(boolean bl) {
        if (bl != this.mDabFollowing) {
            this.mDabFollowing = bl;
            this.toPersistence();
        }
    }

    public void setOtherAnnouncementOption(boolean bl) {
        if (bl != this.mOtherAnnouncementOption) {
            this.mOtherAnnouncementOption = bl;
            this.toPersistence();
        }
    }

    public void setTrafficAnnouncementOption(boolean bl) {
        if (bl != this.mTrafficAnnouncementOption) {
            this.mTrafficAnnouncementOption = bl;
            this.toPersistence();
        }
    }

    public void setFmLinking(boolean bl) {
        if (bl != this.mFmLinking) {
            this.mFmLinking = bl;
            this.toPersistence();
        }
    }

    public void setCurrentPresetIndexSelectedByHmi(int n) {
        this.mCurrentPresetIndexSelectedByHmi = n;
        this.toPersistence();
    }

    public void setVisibleBankIndex(int n) {
        this.mVisibleBankIndex = n;
        this.toPersistence();
    }

    public void setLsmSupportsSlideshow(boolean bl) {
        this.mLsmSupportsSlideshow = bl;
        this.toPersistence();
    }

    public void setCurrentBand1(int n) {
        this.mCurrentBand1 = n;
        this.toPersistence();
    }

    public void setCurrentBand2(int n) {
        this.mCurrentBand2 = n;
        this.toPersistence();
    }

    public DabPreset getPreset(int n) {
        if (n > -1 && n < this.mPresets.length) {
            return this.mPresets[n];
        }
        return null;
    }

    public void clear() {
        this.mCurrentFrequency = null;
        this.mCurrentEnsemble = null;
        this.mCurrentService = null;
        this.mLinkingEnsemble = null;
        this.mLinkingService = null;
        this.mCurrentComponent = null;
        this.mCurrentPresetIndexSelectedByHmi = -1;
        this.mLsmSupportsSlideshow = false;
        if (null != this.mPresets) {
            Arrays.fill(this.mPresets, null);
        }
        this.mVisibleBankIndex = 0;
        this.mOtherAnnouncementOption = true;
        this.mTrafficAnnouncementOption = true;
        this.mDabFollowing = true;
        this.mFmLinking = true;
        this.softLinkingOption = true;
        this.mLBandOptionState = true;
        this.mViewMode = 0;
        this.mCurrentBand1 = 2;
        this.mCurrentBand2 = 1;
    }

    public void fromPersistence() {
        try {
            DabPersistence dabPersistence = RadioServiceManager.getServiceManager().getAdapterAslPersistence().getDabPersistence();
            if (null != dabPersistence) {
                List list;
                FrequencyPersistence frequencyPersistence = dabPersistence.getCurrentFrequency();
                this.mCurrentFrequency = RadioServiceManager.getServiceManager().getAdapterAslPersistence().createFrequencyHmi(frequencyPersistence);
                if (ServiceManager.logger.isTraceEnabled(256)) {
                    if (null == this.mCurrentFrequency) {
                        ServiceManager.logger.trace(256).append("DabPersistable - fromPersistence() - null == mCurrentFrequency").log();
                    } else {
                        ServiceManager.logger.trace(256).append("DabPersistable - fromPersistence() - mCurrentFrequency = ").append(this.mCurrentFrequency.toString()).log();
                    }
                }
                EnsemblePersistence ensemblePersistence = dabPersistence.getCurrentEnsemble();
                this.mCurrentEnsemble = RadioServiceManager.getServiceManager().getAdapterAslPersistence().createEnsembleHmi(ensemblePersistence);
                if (ServiceManager.logger.isTraceEnabled(256)) {
                    if (null == this.mCurrentEnsemble) {
                        ServiceManager.logger.trace(256).append("DabPersistable - fromPersistence() - null == mCurrentEnsemble").log();
                    } else {
                        ServiceManager.logger.trace(256).append("DabPersistable - fromPersistence() - mCurrentEnsemble = ").append(this.mCurrentEnsemble.toString()).log();
                    }
                }
                ServicePersistence servicePersistence = dabPersistence.getCurrentService();
                this.mCurrentService = RadioServiceManager.getServiceManager().getAdapterAslPersistence().createServiceHmi(servicePersistence);
                if (ServiceManager.logger.isTraceEnabled(256)) {
                    if (null == this.mCurrentService) {
                        ServiceManager.logger.info(256).append("DabPersistable - fromPersistence() - null == mCurrentService").log();
                    } else {
                        ServiceManager.logger.trace(256).append("DabPersistable - fromPersistence() - mCurrentService = ").append(this.mCurrentService.toString()).log();
                    }
                }
                ComponentPersistence componentPersistence = dabPersistence.getCurrentComponent();
                this.mCurrentComponent = RadioServiceManager.getServiceManager().getAdapterAslPersistence().createComponentHmi(componentPersistence);
                if (ServiceManager.logger.isTraceEnabled(256)) {
                    if (null == this.mCurrentComponent) {
                        ServiceManager.logger.trace(256).append("DabPersistable - fromPersistence() - null == mCurrentComponent").log();
                    } else {
                        ServiceManager.logger.trace(256).append("DabPersistable - fromPersistence() - mCurrentComponent = ").append(this.mCurrentComponent.toString()).log();
                    }
                }
                EnsemblePersistence ensemblePersistence2 = dabPersistence.getLinkingEnsemble();
                ServicePersistence servicePersistence2 = dabPersistence.getLinkingService();
                if (null != servicePersistence2 && null != ensemblePersistence2 && ensemblePersistence2.getEnsId() > -1) {
                    this.mLinkingEnsemble = RadioServiceManager.getServiceManager().getAdapterAslPersistence().createEnsembleHmi(ensemblePersistence2);
                    this.mLinkingService = RadioServiceManager.getServiceManager().getAdapterAslPersistence().createServiceHmi(servicePersistence2);
                } else {
                    this.mLinkingService = null;
                    this.mLinkingEnsemble = null;
                }
                if (ServiceManager.logger.isTraceEnabled(256)) {
                    if (null == this.mLinkingService) {
                        ServiceManager.logger.trace(256).append("DabPersistable - fromPersistence() - null == mLinkingService").log();
                    } else {
                        ServiceManager.logger.trace(256).append("DabPersistable - fromPersistence() - mLinkingService = ").append(this.mLinkingService.toString()).log();
                    }
                    if (null == this.mLinkingEnsemble) {
                        ServiceManager.logger.trace(256).append("DabPersistable - fromPersistence() - null == mLinkingEnsemble").log();
                    } else {
                        ServiceManager.logger.trace(256).append("DabPersistable - fromPersistence() - mLinkingEnsemble = ").append(this.mLinkingEnsemble.toString()).log();
                    }
                }
                this.mLBandOptionState = dabPersistence.isLBandOptionState();
                this.mOtherAnnouncementOption = dabPersistence.isOtherAnnouncementOption();
                this.mTrafficAnnouncementOption = dabPersistence.isTrafficAnnouncementOption();
                this.mDabFollowing = dabPersistence.isDabFollowing();
                this.mFmLinking = dabPersistence.isFmLinking();
                this.mViewMode = dabPersistence.getViewMode();
                this.mLsmSupportsSlideshow = dabPersistence.isLsmSupportsSlideshow();
                this.mCurrentBand1 = dabPersistence.getCurrentBand1();
                this.mCurrentBand2 = dabPersistence.getCurrentBand2();
                this.mCurrentPresetIndexSelectedByHmi = dabPersistence.getCurrentPresetIndexSelectedByHmi();
                DabPresetList.MAX_VISIBLE_BANK_INDEX = 2 * RadioConstants.PRESETS_PER_BANK;
                this.mVisibleBankIndex = dabPersistence.getVisibleBankIndex();
                if (this.mVisibleBankIndex < 0 || this.mVisibleBankIndex > DabPresetList.MAX_VISIBLE_BANK_INDEX) {
                    this.mVisibleBankIndex = 0;
                }
                if (ServiceManager.logger.isTraceEnabled(256)) {
                    ServiceManager.logger.trace(256).append("DabPersistable - fromPersistence() - mVisibleBankIndex = ").append(this.mVisibleBankIndex).log();
                }
                if (null != (list = dabPersistence.getDabPresets())) {
                    Iterator iterator = list.iterator();
                    if (null != iterator) {
                        for (int i2 = 0; iterator.hasNext() && i2 < this.mPresets.length; ++i2) {
                            DabPresetPersistence dabPresetPersistence = (DabPresetPersistence)iterator.next();
                            this.mPresets[i2] = RadioServiceManager.getServiceManager().getAdapterAslPersistence().createDabPresetHmi(dabPresetPersistence);
                        }
                    }
                }
                this.softLinkingOption = dabPersistence.isSoftLinkingOption();
                if (ServiceManager.logger.isTraceEnabled(256)) {
                    ServiceManager.logger.trace(256).append("DabPersistable - fromPersistence() - softLinkingOption = ").append(this.softLinkingOption).log();
                }
            }
        }
        catch (Exception exception) {
            this.clear();
            ServiceManager.errorHandler.handleError(exception);
        }
        DabPresetApi.setDabPresetsLoadedAndInitialized(true);
        DabPresetApi.createNewDabPresets();
    }

    public void toPersistence() {
        try {
            if (RadioServiceManager.getServiceManager().getAdapterAslPersistence().isProfileChangeStarted()) {
                if (ServiceManager.logger.isTraceEnabled(256)) {
                    ServiceManager.logger.trace(256).append("DabPersistable - toPersistence() - isProfileChangeStarted() == true").log();
                }
                return;
            }
            if (this.isPersistenceWriteAccessBlocked()) {
                return;
            }
            DabPersistence dabPersistence = RadioServiceManager.getServiceManager().getAdapterAslPersistence().getDabPersistence();
            AmFmPersistenceService amFmPersistenceService = RadioServiceManager.getServiceManager().getAdapterAslPersistence().getRadioPersistenceService();
            if (null != dabPersistence && null != amFmPersistenceService) {
                ServicePersistence servicePersistence;
                EnsemblePersistence ensemblePersistence = dabPersistence.getLinkingEnsemble();
                if (null == ensemblePersistence) {
                    ensemblePersistence = amFmPersistenceService.createEnsemblePersistence();
                }
                if (null == (servicePersistence = dabPersistence.getLinkingService())) {
                    servicePersistence = amFmPersistenceService.createServicePersistence();
                }
                if (this.mLinkingService == null || this.mLinkingEnsemble == null) {
                    servicePersistence.setServiceId(-1L);
                    ensemblePersistence.setEnsId(-1);
                } else {
                    RadioServiceManager.getServiceManager().getAdapterAslPersistence().initEnsemblePersistence(ensemblePersistence, this.mLinkingEnsemble);
                    RadioServiceManager.getServiceManager().getAdapterAslPersistence().initServicePersistence(servicePersistence, this.mLinkingService);
                }
                dabPersistence.setLinkingEnsemble(ensemblePersistence);
                dabPersistence.setLinkingService(servicePersistence);
                dabPersistence.setLBandOptionState(this.mLBandOptionState);
                dabPersistence.setOtherAnnouncementOption(this.mOtherAnnouncementOption);
                dabPersistence.setTrafficAnnouncementOption(this.mTrafficAnnouncementOption);
                dabPersistence.setDabFollowing(this.mDabFollowing);
                dabPersistence.setFmLinking(this.mFmLinking);
                dabPersistence.setViewMode(this.mViewMode);
                dabPersistence.setLsmSupportsSlideshow(this.mLsmSupportsSlideshow);
                dabPersistence.setCurrentBand1(this.mCurrentBand1);
                dabPersistence.setCurrentBand2(this.mCurrentBand2);
                dabPersistence.setSoftLinkingOption(this.softLinkingOption);
                dabPersistence.setCurrentPresetIndexSelectedByHmi(this.mCurrentPresetIndexSelectedByHmi);
                dabPersistence.setVisibleBankIndex(this.mVisibleBankIndex);
                List list = dabPersistence.getDabPresets();
                if (DabPresetApi.isDabPresetsLoadedAndInitialized() && null != this.mPresets && null != list) {
                    list.clear();
                    for (int i2 = 0; i2 < this.mPresets.length; ++i2) {
                        DabPresetPersistence dabPresetPersistence = RadioServiceManager.getServiceManager().getAdapterAslPersistence().createDabPresetPersistence(this.mPresets[i2]);
                        list.add(dabPresetPersistence);
                    }
                }
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void clearUnknownValues(short s) {
    }

    public FrequencyInfo getCurrentFrequency() {
        return this.mCurrentFrequency;
    }

    public void setCurrentFrequency(FrequencyInfo frequencyInfo) {
        if (frequencyInfo == null || frequencyInfo.frequency > 0L && frequencyInfo.label.length() > 0) {
            this.mCurrentFrequency = frequencyInfo;
            if (null != this.mCurrentFrequency) {
                this.mCurrentFrequency.label = this.mCurrentFrequency.label.trim();
            }
            if (RadioServiceManager.getServiceManager().getAdapterAslPersistence().isProfileChangeStarted()) {
                if (ServiceManager.logger.isTraceEnabled(256)) {
                    ServiceManager.logger.trace(256).append("DabPersistable - setCurrentFrequency() - isProfileChangeStarted() == true").log();
                }
                return;
            }
            if (this.isPersistenceWriteAccessBlocked()) {
                return;
            }
            DabPersistence dabPersistence = RadioServiceManager.getServiceManager().getAdapterAslPersistence().getDabPersistence();
            AmFmPersistenceService amFmPersistenceService = RadioServiceManager.getServiceManager().getAdapterAslPersistence().getRadioPersistenceService();
            if (null != dabPersistence && null != amFmPersistenceService) {
                FrequencyPersistence frequencyPersistence = dabPersistence.getCurrentFrequency();
                if (null == frequencyPersistence) {
                    frequencyPersistence = amFmPersistenceService.createFrequencyPersistence();
                }
                RadioServiceManager.getServiceManager().getAdapterAslPersistence().initFrequencyPersistence(frequencyPersistence, this.mCurrentFrequency);
                dabPersistence.setCurrentFrequency(frequencyPersistence);
                if (ServiceManager.logger.isTraceEnabled(256)) {
                    if (null == this.mCurrentFrequency) {
                        ServiceManager.logger.trace(256).append("DabPersistable - setCurrentFrequency() - null == mCurrentFrequency").log();
                    } else {
                        ServiceManager.logger.trace(256).append("DabPersistable - setCurrentFrequency() - mCurrentFrequency = ").append(this.mCurrentFrequency.toString()).log();
                    }
                }
            }
        }
    }

    public boolean getSoftLinking() {
        return this.softLinkingOption;
    }

    public void setSoftLinking(boolean bl) {
        this.softLinkingOption = bl;
        this.toPersistence();
    }

    public void setWriteAccessBlocked(boolean bl) {
        this.isWriteAccessBlocked = bl;
    }

    private boolean isPersistenceWriteAccessBlocked() {
        return this.isWriteAccessBlocked;
    }

    public static boolean getDefaultLBandOptionStateValue() {
        return true;
    }

    public static boolean getDefaultOtherAnnouncementOptionValue() {
        return true;
    }

    public static boolean getDefaultTrafficAnnouncementOptionValue() {
        return true;
    }

    public static boolean getDefaultDabFollowingValue() {
        return true;
    }

    public static boolean getDefaultFmLinkingValue() {
        return true;
    }

    public static int getDefaultDabViewModeValue() {
        return 0;
    }

    public static boolean getDefaultLsmSupportsSlideshowValue() {
        return false;
    }

    public static int getDefaultCurrentBand1Value() {
        return 2;
    }

    public static int getDefaultCurrentBand2Value() {
        return 1;
    }

    public static boolean getDefaultSoftLinkingOptionValue() {
        return true;
    }

    public static int getDefaultDabBand1Setting() {
        int n = 1;
        if (RadioCodingAdapter.mAmFmCodingData == null) {
            if (ServiceManager.logger.isTraceEnabled(256)) {
                ServiceManager.logger.trace(256).append(RadioUtil.LOG_PREFIX_AMFM_CODING).append("RadioCodingAdapter.mAmFmCodingData == null").log();
            }
        } else if (RadioCodingAdapter.mAmFmCodingData.contains(47)) {
            n = RadioCodingAdapter.mAmFmCodingData.getValue(47);
        }
        if (ServiceManager.logger.isTraceEnabled(256)) {
            ServiceManager.logger.trace(256).append(RadioUtil.LOG_PREFIX_AMFM_CODING).append("DabPersistable - getDabBand1Setting() - DabBand1Settings = ").append(n).log();
        }
        return n;
    }

    public static int getDefaultDabBand2Setting() {
        int n = 1;
        if (RadioCodingAdapter.mAmFmCodingData == null) {
            if (ServiceManager.logger.isTraceEnabled(256)) {
                ServiceManager.logger.trace(256).append(RadioUtil.LOG_PREFIX_AMFM_CODING).append("RadioCodingAdapter.mAmFmCodingData == null").log();
            }
        } else if (RadioCodingAdapter.mAmFmCodingData.contains(48)) {
            n = RadioCodingAdapter.mAmFmCodingData.getValue(48);
        }
        if (ServiceManager.logger.isTraceEnabled(256)) {
            ServiceManager.logger.trace(256).append(RadioUtil.LOG_PREFIX_AMFM_CODING).append("DabPersistable - getDabBand2Setting() - DabBand2Settings = ").append(n).log();
        }
        return n;
    }
}

