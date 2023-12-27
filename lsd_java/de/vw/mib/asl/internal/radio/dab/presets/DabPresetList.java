/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.dab.presets;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.util.StringUtil;
import de.vw.mib.asl.internal.radio.GuiApiDab;
import de.vw.mib.asl.internal.radio.RadioConstants;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.RadioServiceManager;
import de.vw.mib.asl.internal.radio.dab.DabDatabase;
import de.vw.mib.asl.internal.radio.dab.DabPersistable;
import de.vw.mib.asl.internal.radio.dab.DabTunerState;
import de.vw.mib.asl.internal.radio.dab.main.DabMainApi;
import de.vw.mib.asl.internal.radio.dab.presets.DabPreset;
import de.vw.mib.asl.internal.radio.dab.presets.DabPresetApi;
import de.vw.mib.asl.internal.radio.dab.presets.SelectedStationHighlighting;
import de.vw.mib.asl.internal.radio.presets.PresetManualPictureStore;
import de.vw.mib.asl.internal.radio.radiodata.RadioDataApi;
import java.util.Arrays;
import java.util.Vector;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.radio.EnsembleInfo;
import org.dsi.ifc.radio.FrequencyInfo;
import org.dsi.ifc.radio.ServiceInfo;
import org.dsi.ifc.radiodata.RadioStationData;
import org.dsi.ifc.radiodata.RadioStationDataRequest;
import org.dsi.ifc.radiodata.RadioStationLogoResponse;

public class DabPresetList {
    public static int MAX_VISIBLE_BANK_INDEX = 0;
    private int mImageIdx = -1;

    public int getVisibleBankIndex() {
        return RadioData.getDabDatabase().mPersistable.getVisibleBankIndex();
    }

    public DabPreset getCurrentPreset() {
        return RadioData.getDabDatabase().mPersistable.getPreset(RadioData.getDabDatabase().mPersistable.getCurrentPresetIndexSelectedByHmi());
    }

    public DabPreset getLastTunedPreset() {
        int n = RadioData.getDabDatabase().mPersistable.getCurrentPresetIndexSelectedByHmi();
        return RadioData.getDabDatabase().mPersistable.getPreset(n);
    }

    public int getLastTunedIndex() {
        return RadioData.getDabDatabase().mPersistable.getCurrentPresetIndexSelectedByHmi();
    }

    public boolean setVisibleBankIndex(int n) {
        if (n >= 0 && n < RadioConstants.PRESETS_PER_BANK * 3 && n != RadioData.getDabDatabase().mPersistable.getVisibleBankIndex()) {
            RadioData.getDabDatabase().mPersistable.setVisibleBankIndex(n);
            this.notifyHmiAboutVisibleBank();
            this.autoCompare();
            return true;
        }
        return false;
    }

    public void setLabels(ServiceInfo serviceInfo) {
    }

    public void changePresetName(ServiceInfo serviceInfo) {
        try {
            if (null == serviceInfo) {
                ServiceManager.logger.error(256).append("DabPresetList - changePresetName() - null == service").log();
                return;
            }
            boolean bl = false;
            for (int i2 = 0; i2 < RadioData.getAmfmDatabase().getSettingsPersistable().getDabNoOfPresets(); ++i2) {
                DabPreset dabPreset = RadioData.getDabDatabase().mPersistable.mPresets[i2];
                if (dabPreset == null || !DabTunerState.compare(serviceInfo, dabPreset.getService())) continue;
                ServiceInfo serviceInfo2 = dabPreset.getService();
                if (serviceInfo2.shortName.equals(serviceInfo.shortName.trim())) continue;
                serviceInfo2.shortName = new String(serviceInfo.shortName.trim());
                serviceInfo2.fullName = new String(serviceInfo.fullName.trim());
                bl = true;
            }
            if (bl) {
                RadioData.getDabDatabase().mPersistable.toPersistence();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public ServiceInfo get(int n) {
        try {
            if (null != RadioData.getDabDatabase().mPersistable.mPresets && n >= 0 && n < RadioData.getAmfmDatabase().getSettingsPersistable().getDabNoOfPresets() && RadioData.getDabDatabase().mPersistable.mPresets[n] != null) {
                return RadioData.getDabDatabase().mPersistable.mPresets[n].getService();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
        return null;
    }

    public boolean hasContent(int n) {
        return RadioData.getDabDatabase().mPersistable.mPresets[n] != null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean setPreset(EnsembleInfo ensembleInfo, ServiceInfo serviceInfo, int n, boolean bl, boolean bl2) {
        block7: {
            try {
                if (ensembleInfo == null || serviceInfo == null || serviceInfo.sID <= 0L || serviceInfo.fullName == null || serviceInfo.fullName.length() == 0) break block7;
                DabPersistable dabPersistable = RadioData.getDabDatabase().mPersistable;
                synchronized (dabPersistable) {
                    if (bl) {
                        this.mImageIdx = n;
                    }
                    RadioData.getDabDatabase().mPersistable.mPresets[n] = new DabPreset(serviceInfo, ensembleInfo);
                    ResourceLocator resourceLocator = DabPresetApi.getImage(serviceInfo);
                    RadioData.getDabDatabase().mPersistable.mPresets[n].setPicture(resourceLocator);
                    if (bl2 && null == resourceLocator) {
                        RadioData.getDabDatabase().mPersistable.mPresets[n].getStationLogosFromDatabaseSouthSide(serviceInfo);
                    }
                    RadioData.getDabDatabase().mPersistable.setCurrentPresetIndexSelectedByHmi(n);
                    RadioData.getDabDatabase().mPersistable.toPersistence();
                    RadioDataApi.requestPersistStationLogosInSouthSideDb();
                }
                return true;
            }
            catch (Exception exception) {
                ServiceManager.errorHandler.handleError(exception);
            }
        }
        return false;
    }

    public void setAutoStoreLogoFromList(String string) {
        try {
            DabPreset dabPreset;
            if (null != string && this.mImageIdx > -1 && (dabPreset = RadioData.getDabDatabase().mPersistable.mPresets[this.mImageIdx]) != null) {
                dabPreset.setAutoStoreLogo(string);
            }
            this.mImageIdx = -1;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public DabPreset[] getPresets() {
        return RadioData.getDabDatabase().mPersistable.mPresets;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void deletePreset(int n) {
        try {
            DabPersistable dabPersistable = RadioData.getDabDatabase().mPersistable;
            synchronized (dabPersistable) {
                RadioData.getDabDatabase().mPersistable.mPresets[n] = null;
                if (n == RadioData.getDabDatabase().mPersistable.getCurrentPresetIndexSelectedByHmi()) {
                    RadioData.getDabDatabase().mPersistable.setCurrentPresetIndexSelectedByHmi(-1);
                }
                RadioData.getDabDatabase().mPersistable.toPersistence();
                RadioDataApi.requestPersistStationLogosInSouthSideDb();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void deleteAllPresets() {
        try {
            DabPersistable dabPersistable = RadioData.getDabDatabase().mPersistable;
            synchronized (dabPersistable) {
                Arrays.fill(RadioData.getDabDatabase().mPersistable.mPresets, null);
                RadioData.getDabDatabase().mPersistable.setCurrentPresetIndexSelectedByHmi(-1);
                RadioData.getDabDatabase().mPersistable.toPersistence();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public int getFirstPresetBankWithEmptyElement() {
        try {
            int n = RadioData.getAmfmDatabase().getSettingsPersistable().getDabNoOfPresets();
            for (int i2 = 0; i2 < n; ++i2) {
                if (null == RadioData.getDabDatabase().mPersistable.mPresets || RadioData.getDabDatabase().mPersistable.mPresets[i2] != null) continue;
                return i2 / RadioConstants.PRESETS_PER_BANK * RadioConstants.PRESETS_PER_BANK;
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
        return 0;
    }

    public int getNextOccupiedPreset() {
        try {
            int n;
            int n2;
            int n3 = RadioData.getDabDatabase().mPersistable.getCurrentPresetIndexSelectedByHmi();
            if (n3 == -1) {
                n2 = -1;
                n = RadioData.getAmfmDatabase().getSettingsPersistable().getDabNoOfPresets() - 1;
            } else {
                n2 = n3;
                n = n3;
            }
            int n4 = n2;
            do {
                if (++n4 >= RadioData.getAmfmDatabase().getSettingsPersistable().getDabNoOfPresets()) {
                    n4 = 0;
                }
                if (RadioData.getDabDatabase().mPersistable.mPresets[n4] == null) continue;
                return n4;
            } while (n4 != n);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
        return -1;
    }

    public int getPreviousOccupiedPreset() {
        try {
            int n;
            int n2;
            int n3 = RadioData.getDabDatabase().mPersistable.getCurrentPresetIndexSelectedByHmi();
            if (n3 == -1) {
                n2 = RadioData.getAmfmDatabase().getSettingsPersistable().getDabNoOfPresets();
                n = 0;
            } else {
                n2 = n3;
                n = n3;
            }
            int n4 = n2;
            do {
                if (--n4 < 0) {
                    n4 = RadioData.getAmfmDatabase().getSettingsPersistable().getDabNoOfPresets() - 1;
                }
                if (RadioData.getDabDatabase().mPersistable.mPresets[n4] == null) continue;
                return n4;
            } while (n4 != n);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
        return -1;
    }

    public String toString() {
        try {
            StringBuffer stringBuffer = new StringBuffer(300);
            stringBuffer.append("DabPresetBank{");
            for (int i2 = 0; i2 < RadioData.getAmfmDatabase().getSettingsPersistable().getDabNoOfPresets(); ++i2) {
                if (i2 > 0) {
                    stringBuffer.append(",");
                }
                if (RadioData.getDabDatabase().mPersistable.mPresets[i2] != null) {
                    stringBuffer.append(RadioData.getDabDatabase().mPersistable.mPresets[i2].toString());
                    continue;
                }
                stringBuffer.append("EMPTY");
            }
            stringBuffer.append("}");
            return stringBuffer.toString();
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return "";
        }
    }

    public void notifyFriendsAboutList() {
        DabMainApi.notifyDabPresetsUpdate();
    }

    public void notifyHmi() {
        GuiApiDab.updatePresetList();
        int n = this.getFirstPresetBankWithEmptyElement();
        GuiApiDab.setFirstPresetBankWithEmptyElement(n);
        GuiApiDab.setActivePreset(RadioData.getDabDatabase().mPersistable.getCurrentPresetIndexSelectedByHmi());
    }

    public void notifyHmiAboutVisibleBank() {
        GuiApiDab.setActivePresetBank(RadioData.getDabDatabase().mPersistable.getVisibleBankIndex());
    }

    public void notifyHmiAboutHighlightedPreset() {
        GuiApiDab.setActivePreset(RadioData.getDabDatabase().mPersistable.getCurrentPresetIndexSelectedByHmi());
    }

    public void setCurrentVisibleIndex(int n, boolean bl) {
        int n2 = RadioData.getDabDatabase().mPersistable.getCurrentPresetIndexSelectedByHmi();
        if (n != n2 || bl) {
            RadioData.getDabDatabase().mPersistable.setCurrentPresetIndexSelectedByHmi(n);
            this.notifyHmiAboutHighlightedPreset();
        }
    }

    public int getCurrentVisibleIndex() {
        return RadioData.getDabDatabase().mPersistable.getCurrentPresetIndexSelectedByHmi();
    }

    public ServiceInfo getCurrentService() {
        int n = RadioData.getDabDatabase().mPersistable.getCurrentPresetIndexSelectedByHmi();
        if (n == -1) {
            return null;
        }
        return this.get(n);
    }

    public EnsembleInfo getCurrentEnsemble() {
        int n = RadioData.getDabDatabase().mPersistable.getCurrentPresetIndexSelectedByHmi();
        if (n == -1) {
            return null;
        }
        DabPreset dabPreset = this.getPreset(n);
        if (dabPreset != null) {
            return dabPreset.getEnsemble();
        }
        return null;
    }

    public boolean isPresetVisible(int n) {
        int n2 = RadioData.getDabDatabase().mPersistable.getVisibleBankIndex();
        int n3 = RadioData.getDabDatabase().mPersistable.getVisibleBankIndex() + (RadioConstants.PRESETS_PER_BANK - 1);
        boolean bl = n >= n2 && n <= n3;
        return bl;
    }

    public int getBankOfPreset(int n) {
        if (n < 0 || n >= RadioData.getAmfmDatabase().getSettingsPersistable().getDabNoOfPresets()) {
            return -1;
        }
        return n / RadioConstants.PRESETS_PER_BANK;
    }

    public void autoCompare() {
        if (SelectedStationHighlighting.getSelectedStationHighlightingIsActive()) {
            return;
        }
        int n = RadioData.getDabDatabase().mPersistable.getCurrentPresetIndexSelectedByHmi();
        ServiceInfo serviceInfo = RadioData.getDabDatabase().mTunerState.getCurrentService();
        FrequencyInfo frequencyInfo = RadioData.getDabDatabase().mTunerState.getCurrentFrequencyInfo();
        DabPreset dabPreset = this.getCurrentPreset();
        if (frequencyInfo == null || dabPreset == null || !DabTunerState.compare(serviceInfo, dabPreset.getService()) || dabPreset.mFrequency.frequency != frequencyInfo.frequency || !this.isPresetVisible(n)) {
            if (serviceInfo != null) {
                int n2 = this.autocompareNew(frequencyInfo, serviceInfo, true);
                this.setCurrentVisibleIndex(n2, false);
            } else {
                this.setCurrentVisibleIndex(-1, true);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void reset() {
        DabPersistable dabPersistable = RadioData.getDabDatabase().mPersistable;
        synchronized (dabPersistable) {
            Arrays.fill(RadioData.getDabDatabase().mPersistable.mPresets, null);
            RadioData.getDabDatabase().mPersistable.toPersistence();
        }
        RadioData.getDabDatabase().mPersistable.setVisibleBankIndex(0);
    }

    public int autocompareNew(FrequencyInfo frequencyInfo, ServiceInfo serviceInfo, boolean bl) {
        int n = -1;
        int n2 = -1;
        DabPreset dabPreset = null;
        int n3 = RadioData.getDabDatabase().mPersistable.getVisibleBankIndex();
        DabPreset[] dabPresetArray = RadioData.getDabDatabase().mPersistable.mPresets;
        if (null != serviceInfo && null != dabPresetArray) {
            int n4;
            int n5;
            int n6;
            if (n3 != -1) {
                n6 = n3;
                n5 = n6 + (RadioConstants.PRESETS_PER_BANK - 1);
                if (n5 > RadioData.getAmfmDatabase().getSettingsPersistable().getDabNoOfPresets() - 1) {
                    n5 = RadioData.getAmfmDatabase().getSettingsPersistable().getDabNoOfPresets() - 1;
                }
                for (n4 = n6; n4 <= n5; ++n4) {
                    dabPreset = dabPresetArray[n4];
                    if (dabPreset == null) continue;
                    if (frequencyInfo != null && dabPreset.getEnsemble() != null && DabTunerState.compare(serviceInfo, dabPreset.getService()) && frequencyInfo.frequency == (long)dabPreset.getEnsemble().frequencyValue) {
                        return n4;
                    }
                    if (n == -1) {
                        if (DabTunerState.compare(dabPreset.getService(), serviceInfo)) {
                            n = n4;
                        } else if (n2 == -1) {
                            int n7 = dabPreset.getService().getEnsECC();
                            int n8 = serviceInfo.getEnsECC();
                            if (serviceInfo.sID == dabPreset.getService().sID && (n8 == 0 || n7 == 0 || n8 == n7)) {
                                n2 = n4;
                            }
                        }
                    }
                    dabPreset = null;
                }
                if (n > -1) {
                    dabPreset = RadioData.getDabDatabase().mPersistable.mPresets[n];
                } else if (n2 > -1) {
                    dabPreset = RadioData.getDabDatabase().mPersistable.mPresets[n2];
                }
            }
            if (dabPreset == null && bl) {
                for (n6 = 0; n6 < RadioData.getAmfmDatabase().getSettingsPersistable().getDabNoOfPresets(); ++n6) {
                    dabPreset = dabPresetArray[n6];
                    if (dabPreset == null) continue;
                    if (frequencyInfo != null && dabPreset.getEnsemble() != null && DabTunerState.compare(serviceInfo, dabPreset.getService()) && frequencyInfo.frequency == (long)dabPreset.getEnsemble().frequencyValue) {
                        return n6;
                    }
                    if (n == -1) {
                        if (DabTunerState.compare(dabPreset.getService(), serviceInfo)) {
                            n = n6;
                        } else if (n2 == -1) {
                            n5 = dabPreset.getService().getEnsECC();
                            n4 = serviceInfo.getEnsECC();
                            if (serviceInfo.sID == dabPreset.getService().sID && (n4 == 0 || n5 == 0 || n4 == n5)) {
                                n2 = n6;
                            }
                        }
                    }
                    dabPreset = null;
                }
                if (n > -1) {
                    dabPreset = RadioData.getDabDatabase().mPersistable.mPresets[n];
                } else if (n2 > -1) {
                    dabPreset = RadioData.getDabDatabase().mPersistable.mPresets[n2];
                }
            }
        }
        return n > -1 ? n : n2;
    }

    public DabPreset find(ServiceInfo serviceInfo) {
        int n = RadioData.getAmfmDatabase().getSettingsPersistable().getDabNoOfPresets();
        for (int i2 = 0; i2 < n; ++i2) {
            DabPreset[] dabPresetArray = RadioData.getDabDatabase().mPersistable.mPresets;
            DabPreset dabPreset = dabPresetArray[i2];
            if (dabPreset == null || dabPreset.getService().getSID() != serviceInfo.sID) continue;
            return dabPresetArray[i2];
        }
        return null;
    }

    public boolean serviceIsOnPreset(ServiceInfo serviceInfo) {
        try {
            for (int i2 = 0; i2 < RadioData.getAmfmDatabase().getSettingsPersistable().getDabNoOfPresets(); ++i2) {
                ServiceInfo serviceInfo2;
                DabPreset[] dabPresetArray = RadioData.getDabDatabase().mPersistable.mPresets;
                DabPreset dabPreset = dabPresetArray[i2];
                if (dabPreset == null || null == (serviceInfo2 = dabPreset.getService()) || null == serviceInfo || serviceInfo2.sID != serviceInfo.sID) continue;
                if (serviceInfo2.ensID > 0 && serviceInfo.ensID > 0 && serviceInfo2.ensID == serviceInfo.ensID) {
                    return true;
                }
                if (serviceInfo2.ensECC == 0 || serviceInfo.ensECC == 0 || serviceInfo2.ensECC != serviceInfo.ensECC) continue;
                return true;
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
        return false;
    }

    public void setCurrentSelectedPreset(DabPreset dabPreset) {
        try {
            if (dabPreset != null) {
                DabPreset[] dabPresetArray = RadioData.getDabDatabase().mPersistable.mPresets;
                for (int i2 = 0; i2 < dabPresetArray.length; ++i2) {
                    if (dabPreset != dabPresetArray[i2]) continue;
                    RadioData.getDabDatabase().mPersistable.setCurrentPresetIndexSelectedByHmi(i2);
                    this.setCurrentVisibleIndex(i2, false);
                    this.notifyHmiAboutHighlightedPreset();
                    return;
                }
            }
            RadioData.getDabDatabase().mPersistable.setCurrentPresetIndexSelectedByHmi(-1);
            this.setCurrentVisibleIndex(-1, false);
            this.notifyHmiAboutHighlightedPreset();
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public Boolean[] getImageStates() {
        int n = RadioData.getAmfmDatabase().getSettingsPersistable().getDabNoOfPresets();
        Boolean[] booleanArray = new Boolean[n];
        for (int i2 = 0; i2 < n; ++i2) {
            DabPreset dabPreset = RadioData.getDabDatabase().mPersistable.mPresets[i2];
            booleanArray[i2] = dabPreset != null && dabPreset.hasPicture() ? Boolean.TRUE : Boolean.FALSE;
        }
        return booleanArray;
    }

    public void deletePresetPicture(int n) {
        try {
            DabPreset dabPreset = RadioData.getDabDatabase().mPersistable.mPresets[n];
            if (dabPreset != null) {
                ResourceLocator resourceLocator = dabPreset.getImage();
                if (null != resourceLocator) {
                    ResourceLocator resourceLocator2 = new ResourceLocator(resourceLocator.getId(), resourceLocator.getUrl());
                    dabPreset.setPicture(null);
                    if (resourceLocator2 != null && !this.isResourceLocatorUsed(resourceLocator2, dabPreset.getService())) {
                        PresetManualPictureStore.deletePicture(new ResourceLocator[]{resourceLocator2}, DabDatabase.mDabMainTarget);
                        RadioDataApi.deleteDabLogoFromHmiLogoBuffer(dabPreset.getService());
                    }
                }
                if (n == RadioData.getDabDatabase().mPersistable.getCurrentPresetIndexSelectedByHmi()) {
                    RadioServiceManager.getServiceManager().getGuiBapApi().changeInPresets();
                }
                RadioData.getDabDatabase().mPersistable.toPersistence();
                this.notifyHmi();
                RadioDataApi.requestPersistStationLogosInSouthSideDb();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public ServiceInfo deletePresetPictureForAllMatchingServices(int n) {
        ServiceInfo serviceInfo = null;
        try {
            DabPreset dabPreset = RadioData.getDabDatabase().mPersistable.mPresets[n];
            if (dabPreset != null && null != (serviceInfo = dabPreset.getService())) {
                for (int i2 = 0; i2 < RadioData.getAmfmDatabase().getSettingsPersistable().getDabNoOfPresets(); ++i2) {
                    ServiceInfo serviceInfo2;
                    DabPreset dabPreset2 = RadioData.getDabDatabase().mPersistable.mPresets[i2];
                    if (dabPreset2 == null || null == (serviceInfo2 = dabPreset2.getService()) || serviceInfo2.getSID() != serviceInfo.getSID() || serviceInfo2.getEnsECC() != serviceInfo.getEnsECC()) continue;
                    ResourceLocator resourceLocator = dabPreset2.getImage();
                    if (null != resourceLocator) {
                        ResourceLocator resourceLocator2 = new ResourceLocator(resourceLocator.getId(), resourceLocator.getUrl());
                        dabPreset2.setPicture(null);
                        if (resourceLocator2 != null && !this.isResourceLocatorUsed(resourceLocator2, dabPreset2.getService())) {
                            PresetManualPictureStore.deletePicture(new ResourceLocator[]{resourceLocator2}, DabDatabase.mDabMainTarget);
                            RadioDataApi.deleteDabLogoFromHmiLogoBuffer(dabPreset2.getService());
                        }
                    }
                    if (i2 != RadioData.getDabDatabase().mPersistable.getCurrentPresetIndexSelectedByHmi()) continue;
                    RadioServiceManager.getServiceManager().getGuiBapApi().changeInPresets();
                }
                RadioData.getDabDatabase().mPersistable.toPersistence();
                this.notifyHmi();
                RadioDataApi.requestPersistStationLogosInSouthSideDb();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
        return serviceInfo;
    }

    public void deleteAllPresetLogos() {
        try {
            if (!DabPresetApi.isDabPresetsLoadedAndInitialized()) {
                DabPresetApi.setDeletePresetsLogoRequested(true);
                return;
            }
            if (null == RadioData.getDabDatabase().mPersistable.mPresets) {
                if (ServiceManager.logger.isTraceEnabled(256)) {
                    ServiceManager.logger.error(256).append("RadioData.getDabDatabase().mPersistable.mPresets is null").log();
                }
                return;
            }
            for (int i2 = 0; i2 < RadioData.getAmfmDatabase().getSettingsPersistable().getDabNoOfPresets(); ++i2) {
                DabPreset dabPreset = RadioData.getDabDatabase().mPersistable.mPresets[i2];
                if (dabPreset == null) continue;
                ResourceLocator resourceLocator = dabPreset.getImage();
                if (null != resourceLocator) {
                    ResourceLocator resourceLocator2 = new ResourceLocator(resourceLocator.getId(), resourceLocator.getUrl());
                    dabPreset.setPicture(null);
                    if (resourceLocator2 != null && !this.isResourceLocatorUsed(resourceLocator2, dabPreset.getService())) {
                        PresetManualPictureStore.deletePicture(new ResourceLocator[]{resourceLocator2}, DabDatabase.mDabMainTarget);
                        RadioDataApi.deleteDabLogoFromHmiLogoBuffer(dabPreset.getService());
                    }
                }
                if (i2 != RadioData.getDabDatabase().mPersistable.getCurrentPresetIndexSelectedByHmi()) continue;
                RadioServiceManager.getServiceManager().getGuiBapApi().changeInPresets();
            }
            RadioData.getDabDatabase().mPersistable.toPersistence();
            this.notifyHmi();
            RadioDataApi.requestPersistStationLogosInSouthSideDb();
            DabPresetApi.setDeletePresetsLogoRequested(false);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void deleteAllDatabaseStationIds() {
        try {
            if (!DabPresetApi.isDabPresetsLoadedAndInitialized()) {
                DabPresetApi.setDeletePresetsDatabaseIdsRequested(true);
                return;
            }
            if (null == RadioData.getDabDatabase().mPersistable.mPresets) {
                if (ServiceManager.logger.isTraceEnabled(256)) {
                    ServiceManager.logger.error(256).append("RadioData.getDabDatabase().mPersistable.mPresets is null").log();
                }
                return;
            }
            for (int i2 = 0; i2 < RadioData.getAmfmDatabase().getSettingsPersistable().getDabNoOfPresets(); ++i2) {
                DabPreset dabPreset = RadioData.getDabDatabase().mPersistable.mPresets[i2];
                if (dabPreset == null) continue;
                dabPreset.deleteDatabaseStationId();
            }
            DabPresetApi.setDeletePresetsDatabaseIdsRequested(false);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public DabPreset getPreset(int n) {
        return RadioData.getDabDatabase().mPersistable.mPresets[n];
    }

    public ResourceLocator getCurrentImage() {
        try {
            DabPreset dabPreset;
            this.autoCompare();
            if (this.getCurrentVisibleIndex() > -1 && this.getCurrentVisibleIndex() < RadioData.getDabDatabase().mPersistable.mPresets.length && null != (dabPreset = this.getPreset(this.getCurrentVisibleIndex()))) {
                return dabPreset.getImage();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return null;
        }
        return null;
    }

    public ServiceInfo setManualAssignedPresetLogo(int n, ResourceLocator resourceLocator) {
        DabPreset dabPreset = RadioData.getDabDatabase().mPersistable.mPresets[n];
        ServiceInfo serviceInfo = null;
        if (dabPreset != null) {
            serviceInfo = dabPreset.getService();
            dabPreset.setPicture(resourceLocator);
            if (n == RadioData.getDabDatabase().mPersistable.getCurrentPresetIndexSelectedByHmi()) {
                RadioServiceManager.getServiceManager().getGuiBapApi().changeInPresets();
            }
            RadioData.getDabDatabase().mPersistable.toPersistence();
        }
        return serviceInfo;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void resetPictures() {
        DabPersistable dabPersistable = RadioData.getDabDatabase().mPersistable;
        synchronized (dabPersistable) {
            DabPreset[] dabPresetArray = RadioData.getDabDatabase().mPersistable.mPresets;
            if (null == dabPresetArray) {
                return;
            }
            Vector vector = new Vector();
            for (int i2 = 0; i2 < dabPresetArray.length; ++i2) {
                if (dabPresetArray[i2] == null) continue;
                ResourceLocator resourceLocator = dabPresetArray[i2].getImage();
                if (null != resourceLocator) {
                    ResourceLocator resourceLocator2 = new ResourceLocator(resourceLocator.getId(), resourceLocator.getUrl());
                    dabPresetArray[i2].setPicture(null);
                    if (resourceLocator2 != null && !this.isResourceLocatorUsed(resourceLocator2, dabPresetArray[i2].getService())) {
                        vector.add(resourceLocator2);
                        RadioDataApi.deleteDabLogoFromHmiLogoBuffer(dabPresetArray[i2].getService());
                    }
                }
                if (i2 != RadioData.getDabDatabase().mPersistable.getCurrentPresetIndexSelectedByHmi()) continue;
                RadioServiceManager.getServiceManager().getGuiBapApi().changeInPresets();
            }
            Object[] objectArray = new ResourceLocator[vector.size()];
            vector.toArray(objectArray);
            PresetManualPictureStore.deletePicture((ResourceLocator[])objectArray, DabDatabase.mDabMainTarget);
            RadioData.getDabDatabase().mPersistable.toPersistence();
        }
    }

    public int getIndexById(long l) {
        DabPreset[] dabPresetArray = RadioData.getDabDatabase().mPersistable.mPresets;
        for (int i2 = 0; i2 < dabPresetArray.length; ++i2) {
            if (dabPresetArray[i2] == null) continue;
            ServiceInfo serviceInfo = dabPresetArray[i2].getService();
            long l2 = DabTunerState.calcServiceId(serviceInfo.ensID, serviceInfo.ensECC, serviceInfo.sID);
            if (l2 != l) continue;
            return i2;
        }
        return -1;
    }

    public int getIndexByDatabaseStationId(long l) {
        DabPreset[] dabPresetArray = RadioData.getDabDatabase().mPersistable.mPresets;
        for (int i2 = 0; i2 < dabPresetArray.length; ++i2) {
            if (dabPresetArray[i2] == null || dabPresetArray[i2].getDatabaseStationId() != l) continue;
            return i2;
        }
        return -1;
    }

    void setDabStationLogoFromDatabaseSouthSide(ResourceLocator resourceLocator, RadioStationDataRequest radioStationDataRequest, int n) {
        try {
            if (null != RadioData.getDabDatabase().mPersistable.mPresets && null != radioStationDataRequest && null != resourceLocator) {
                for (int i2 = 0; i2 < RadioData.getDabDatabase().mPersistable.mPresets.length; ++i2) {
                    ServiceInfo serviceInfo;
                    DabPreset dabPreset = RadioData.getDabDatabase().mPersistable.mPresets[i2];
                    if (dabPreset == null || (serviceInfo = dabPreset.getService()) == null || (n != 5 || null != dabPreset.getImage()) && (serviceInfo.getSID() != (long)radioStationDataRequest.getPiSid() || serviceInfo.getEnsECC() != radioStationDataRequest.getExtendedCountryCode() || radioStationDataRequest.getPiSid() == -1)) continue;
                    dabPreset.setLogoFromDatabaseSouthSide(resourceLocator);
                }
                RadioData.getDabDatabase().mPersistable.toPersistence();
                this.notifyHmi();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    void setDatabaseDataForDabPreset(RadioStationLogoResponse radioStationLogoResponse, RadioStationDataRequest radioStationDataRequest, int n) {
        try {
            if (null != RadioData.getDabDatabase().mPersistable.mPresets && null != radioStationDataRequest && null != radioStationLogoResponse) {
                ResourceLocator[] resourceLocatorArray = radioStationLogoResponse.getResourceLocators();
                RadioStationData[] radioStationDataArray = radioStationLogoResponse.getRadioStationData();
                ResourceLocator resourceLocator = null;
                if (null != resourceLocatorArray && resourceLocatorArray.length > 0) {
                    resourceLocator = resourceLocatorArray[0];
                }
                for (int i2 = 0; i2 < RadioData.getDabDatabase().mPersistable.mPresets.length; ++i2) {
                    ServiceInfo serviceInfo;
                    DabPreset dabPreset = RadioData.getDabDatabase().mPersistable.mPresets[i2];
                    if (dabPreset == null || (serviceInfo = dabPreset.getService()) == null) continue;
                    if (n == 5 && null == dabPreset.getImage() || serviceInfo.getSID() == (long)radioStationDataRequest.getPiSid() && serviceInfo.getEnsECC() == radioStationDataRequest.getExtendedCountryCode() && radioStationDataRequest.getPiSid() != -1) {
                        dabPreset.setLogoFromDatabaseSouthSide(resourceLocator);
                        if (i2 == RadioData.getDabDatabase().mPersistable.getCurrentPresetIndexSelectedByHmi()) {
                            RadioServiceManager.getServiceManager().getGuiBapApi().changeInPresets();
                        }
                    }
                    if (serviceInfo.getSID() != (long)radioStationDataRequest.getPiSid() || serviceInfo.getEnsECC() != radioStationDataRequest.getExtendedCountryCode() || null == radioStationDataArray || radioStationDataArray.length <= 0 || null == radioStationDataArray[0]) continue;
                    dabPreset.setDatabaseStationId(radioStationDataArray[0].getStationId());
                }
                RadioData.getDabDatabase().mPersistable.toPersistence();
                this.notifyHmi();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    void setManualAssignedDabStationLogoForAllPresets(ResourceLocator resourceLocator, ServiceInfo serviceInfo) {
        try {
            if (null != RadioData.getDabDatabase().mPersistable.mPresets) {
                for (int i2 = 0; i2 < RadioData.getDabDatabase().mPersistable.mPresets.length; ++i2) {
                    ServiceInfo serviceInfo2;
                    DabPreset dabPreset = RadioData.getDabDatabase().mPersistable.mPresets[i2];
                    if (dabPreset == null || (serviceInfo2 = dabPreset.getService()) == null || serviceInfo2.getSID() != serviceInfo.getSID() || serviceInfo2.getEnsECC() != serviceInfo.getEnsECC() || serviceInfo.getSID() == -1L) continue;
                    dabPreset.setLogoFromDatabaseSouthSide(resourceLocator);
                }
                RadioData.getDabDatabase().mPersistable.toPersistence();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void createNewNoOfPresets() {
        DabPreset[] dabPresetArray = RadioData.getDabDatabase().mPersistable.mPresets;
        RadioData.getDabDatabase().mPersistable.mPresets = new DabPreset[RadioData.getAmfmDatabase().getSettingsPersistable().getDabNoOfPresets()];
        for (int i2 = 0; i2 < RadioData.getDabDatabase().mPersistable.mPresets.length; ++i2) {
            RadioData.getDabDatabase().mPersistable.mPresets[i2] = null != dabPresetArray && i2 < dabPresetArray.length && null != dabPresetArray[i2] ? new DabPreset(dabPresetArray[i2]) : null;
        }
        if (RadioData.getDabDatabase().mPersistable.getCurrentPresetIndexSelectedByHmi() >= RadioData.getDabDatabase().mPersistable.mPresets.length) {
            this.setCurrentVisibleIndex(-1, false);
        }
    }

    public void updateStationLogoFromDatabase(RadioStationData radioStationData, ResourceLocator resourceLocator) {
        try {
            DabPreset[] dabPresetArray = RadioData.getDabDatabase().mPersistable.mPresets;
            if (null != dabPresetArray && null != radioStationData) {
                for (int i2 = 0; i2 < dabPresetArray.length; ++i2) {
                    ServiceInfo serviceInfo;
                    DabPreset dabPreset = RadioData.getDabDatabase().mPersistable.mPresets[i2];
                    if (dabPreset == null || (serviceInfo = dabPreset.getService()) == null || serviceInfo.getSID() != (long)radioStationData.getPiSid() || serviceInfo.getEnsECC() != radioStationData.getExtendedCountryCode()) continue;
                    if (null != resourceLocator) {
                        dabPreset.setLogoFromDatabaseSouthSide(resourceLocator);
                    } else {
                        dabPreset.setPicture(null);
                    }
                    if (i2 != RadioData.getDabDatabase().mPersistable.getCurrentPresetIndexSelectedByHmi()) continue;
                    RadioServiceManager.getServiceManager().getGuiBapApi().changeInPresets();
                }
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public ResourceLocator getImage(ServiceInfo serviceInfo) {
        try {
            DabPreset[] dabPresetArray = RadioData.getDabDatabase().mPersistable.mPresets;
            if (null != dabPresetArray && null != serviceInfo) {
                for (int i2 = 0; i2 < dabPresetArray.length; ++i2) {
                    ServiceInfo serviceInfo2;
                    if (dabPresetArray[i2] == null || (serviceInfo2 = dabPresetArray[i2].getService()) == null || serviceInfo2.getSID() != serviceInfo.getSID() || serviceInfo2.getEnsECC() != serviceInfo.getEnsECC() || serviceInfo.getSID() <= 0L) continue;
                    return dabPresetArray[i2].getImage();
                }
            }
            return null;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return null;
        }
    }

    private boolean isResourceLocatorUsed(ResourceLocator resourceLocator, ServiceInfo serviceInfo) {
        try {
            if (null == resourceLocator || null == serviceInfo || null == RadioData.getDabDatabase().mPersistable.mPresets) {
                return false;
            }
            DabPreset[] dabPresetArray = RadioData.getDabDatabase().mPersistable.mPresets;
            if (null == dabPresetArray) {
                return false;
            }
            for (int i2 = 0; i2 < dabPresetArray.length; ++i2) {
                if (dabPresetArray[i2] == null) continue;
                ServiceInfo serviceInfo2 = dabPresetArray[i2].getService();
                ResourceLocator resourceLocator2 = dabPresetArray[i2].getImage();
                if (serviceInfo2 == null || serviceInfo2.getSID() != serviceInfo.getSID() || serviceInfo2.getEnsECC() != serviceInfo.getEnsECC() || serviceInfo.getSID() == -1L || null == resourceLocator2 || resourceLocator2.id != resourceLocator.id || !StringUtil.equals(resourceLocator2.getUrl(), resourceLocator.getUrl())) continue;
                return true;
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
        return false;
    }

    public void correctEmptyServiceNameByPresetServiceName(ServiceInfo serviceInfo) {
        ServiceInfo serviceInfo2;
        DabPreset dabPreset;
        if (null == serviceInfo) {
            return;
        }
        if ((null == serviceInfo.fullName || serviceInfo.fullName.length() < 1) && null != (dabPreset = this.getCurrentPreset()) && null != (serviceInfo2 = dabPreset.getService()) && DabTunerState.compare(serviceInfo, serviceInfo2)) {
            serviceInfo.fullName = serviceInfo2.fullName;
            serviceInfo.shortName = serviceInfo2.shortName;
        }
    }

    public void correctEmptyEnsembleNameByPresetEnsembleName(EnsembleInfo ensembleInfo) {
        EnsembleInfo ensembleInfo2;
        DabPreset dabPreset;
        if (null == ensembleInfo) {
            return;
        }
        if ((null == ensembleInfo.fullName || ensembleInfo.fullName.length() < 1) && null != (dabPreset = this.getCurrentPreset()) && null != (ensembleInfo2 = dabPreset.getEnsemble()) && DabTunerState.compare(ensembleInfo, ensembleInfo2)) {
            ensembleInfo.fullName = ensembleInfo2.fullName;
            ensembleInfo.shortName = ensembleInfo2.shortName;
        }
    }
}

