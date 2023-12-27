/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.dab.stationList;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.dab.DabTunerState;
import de.vw.mib.asl.internal.radio.dab.presets.DabPreset;
import de.vw.mib.asl.internal.radio.transformer.DABAdditionalServicesListCollector;
import de.vw.mib.asl.internal.radio.transformer.DABServiceListItemInfoCollector;
import de.vw.mib.asl.internal.radio.transformer.DABStationListInfoCollector;
import java.util.TreeSet;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.radio.ComponentInfo;
import org.dsi.ifc.radio.EnsembleInfo;
import org.dsi.ifc.radio.FrequencyInfo;
import org.dsi.ifc.radio.ServiceInfo;

public class HmiDabListManager {
    private boolean mOpened = false;
    private boolean mServiceActivatedInOpenedEnsemble;
    private int mOpenedEnsembleIndex = -1;
    private int mOpenedServiceIndex = -1;
    private int mActiveEnsembleIndex = -1;
    private int mActiveServiceIndex = -1;
    private int mActiveComponentIndex = -1;
    private DABStationListInfoCollector[] mEnsembleList = new DABStationListInfoCollector[0];
    private DABServiceListItemInfoCollector[] mServiceList = new DABServiceListItemInfoCollector[0];
    private DABAdditionalServicesListCollector[] mAdditionalServiceList = new DABAdditionalServicesListCollector[0];

    public void loadEnsembleList() {
        try {
            this.mOpened = true;
            this.mServiceActivatedInOpenedEnsemble = true;
            EnsembleInfo ensembleInfo = RadioData.getDabDatabase().mTunerState.getCurrentEnsemble();
            ServiceInfo serviceInfo = RadioData.getDabDatabase().mTunerState.getCurrentService();
            ComponentInfo componentInfo = RadioData.getDabDatabase().mTunerState.getCurrentComponent();
            this.calcEnsembleList(ensembleInfo, serviceInfo);
            this.calcActiveEnsembleIndex(ensembleInfo);
            this.mOpenedEnsembleIndex = this.mActiveEnsembleIndex;
            this.calcServiceList(serviceInfo);
            this.calcActiveServiceIndex(serviceInfo);
            this.calcComponentList();
            if (null != componentInfo) {
                this.mOpenedServiceIndex = this.mActiveServiceIndex;
                this.calcActiveComponentIndex(serviceInfo, componentInfo);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public DABStationListInfoCollector[] getCurrentEnsembleList() {
        return this.mEnsembleList;
    }

    public void resetList() {
        this.resetOpenedService();
        this.resetOpenedEnsemble();
        this.mOpened = false;
        this.mOpenedServiceIndex = -1;
        this.mActiveEnsembleIndex = -1;
        this.mEnsembleList = new DABStationListInfoCollector[0];
    }

    public void setOpenedEnsemble(int n) {
        if (this.mOpenedEnsembleIndex != n) {
            this.mServiceActivatedInOpenedEnsemble = false;
        }
        this.mOpenedEnsembleIndex = n;
        ServiceInfo serviceInfo = RadioData.getDabDatabase().mTunerState.getCurrentService();
        this.calcServiceList(serviceInfo);
        this.calcActiveServiceIndex(serviceInfo);
    }

    public boolean setOpenedEnsemble(EnsembleInfo ensembleInfo) {
        for (int i2 = 0; i2 < this.mEnsembleList.length; ++i2) {
            EnsembleInfo ensembleInfo2 = this.mEnsembleList[i2].getEnsemble();
            if (ensembleInfo2 == null || !this.compare(ensembleInfo2, ensembleInfo)) continue;
            this.setOpenedEnsemble(i2);
            return true;
        }
        return false;
    }

    private boolean compare(EnsembleInfo ensembleInfo, EnsembleInfo ensembleInfo2) {
        if (ensembleInfo.ensECC != 0 && ensembleInfo2.ensECC != 0 && ensembleInfo.ensECC != ensembleInfo2.ensECC) {
            return false;
        }
        return ensembleInfo.ensID == ensembleInfo2.ensID;
    }

    public ServiceInfo getNextService() {
        if (this.mServiceList == null || this.mServiceList.length == 0 || this.mActiveServiceIndex == -1) {
            return null;
        }
        ++this.mActiveServiceIndex;
        if (this.mActiveServiceIndex >= this.mServiceList.length) {
            ServiceInfo[] serviceInfoArray;
            this.mActiveServiceIndex = 0;
            EnsembleInfo ensembleInfo = this.getNextEnsemble();
            if (ensembleInfo != null && (serviceInfoArray = RadioData.getDabDatabase().mTunerState.getServicesByEnsemble(ensembleInfo)).length > 0) {
                return serviceInfoArray[this.mActiveServiceIndex];
            }
        }
        return this.mServiceList[this.mActiveServiceIndex].getService();
    }

    public ServiceInfo getPreviousService() {
        ServiceInfo[] serviceInfoArray;
        EnsembleInfo ensembleInfo;
        if (this.mServiceList == null || this.mServiceList.length == 0 || this.mActiveServiceIndex == -1) {
            return null;
        }
        --this.mActiveServiceIndex;
        if (this.mActiveServiceIndex < 0 && (ensembleInfo = this.getPreviousEnsemble()) != null && (serviceInfoArray = RadioData.getDabDatabase().mTunerState.getServicesByEnsemble(ensembleInfo)).length > 0) {
            this.mActiveServiceIndex = serviceInfoArray.length - 1;
            return serviceInfoArray[this.mActiveServiceIndex];
        }
        return this.mServiceList[this.mActiveServiceIndex].getService();
    }

    public EnsembleInfo getNextEnsemble() {
        if (this.mEnsembleList == null || this.mEnsembleList.length == 0 || this.mActiveEnsembleIndex == -1) {
            return null;
        }
        ++this.mActiveEnsembleIndex;
        if (this.mActiveEnsembleIndex >= this.mEnsembleList.length) {
            this.mActiveEnsembleIndex = 0;
        }
        return this.mEnsembleList[this.mActiveEnsembleIndex].getEnsemble();
    }

    public EnsembleInfo getPreviousEnsemble() {
        if (this.mEnsembleList == null || this.mEnsembleList.length == 0 || this.mActiveEnsembleIndex == -1) {
            return null;
        }
        --this.mActiveEnsembleIndex;
        if (this.mActiveEnsembleIndex < 0) {
            this.mActiveEnsembleIndex = this.mEnsembleList.length - 1;
        }
        return this.mEnsembleList[this.mActiveEnsembleIndex].getEnsemble();
    }

    public DABServiceListItemInfoCollector[] getCurrentServiceList() {
        return this.mServiceList;
    }

    private void resetOpenedEnsemble() {
        this.mOpenedEnsembleIndex = -1;
        this.mActiveServiceIndex = -1;
        this.mServiceList = new DABServiceListItemInfoCollector[0];
    }

    public void setOpenedService(int n) {
        this.mOpenedServiceIndex = n;
        ServiceInfo serviceInfo = RadioData.getDabDatabase().mTunerState.getCurrentService();
        ComponentInfo componentInfo = RadioData.getDabDatabase().mTunerState.getCurrentComponent();
        this.calcComponentList();
        this.calcActiveComponentIndex(serviceInfo, componentInfo);
    }

    public DABAdditionalServicesListCollector[] getCurrentAdditionalServiceList() {
        return this.mAdditionalServiceList;
    }

    public void resetOpenedService() {
        this.mOpenedServiceIndex = -1;
        this.mAdditionalServiceList = new DABAdditionalServicesListCollector[0];
        this.mActiveComponentIndex = -1;
    }

    public void updateEnsembleAndServiceList() {
        if (this.mOpened) {
            DABStationListInfoCollector dABStationListInfoCollector = this.getOpenedEnsembleItem();
            DABServiceListItemInfoCollector dABServiceListItemInfoCollector = this.getOpenedServiceItem();
            EnsembleInfo ensembleInfo = RadioData.getDabDatabase().mTunerState.getCurrentEnsemble();
            ServiceInfo serviceInfo = RadioData.getDabDatabase().mTunerState.getCurrentService();
            this.calcEnsembleList(ensembleInfo, serviceInfo);
            this.calcActiveEnsembleIndex(ensembleInfo);
            this.calcOpenedEnsembleIndex(dABStationListInfoCollector);
            this.calcServiceList(serviceInfo);
            this.calcActiveServiceIndex(serviceInfo);
            this.calcOpenedServiceIndex(dABServiceListItemInfoCollector);
        }
    }

    public void updateAdditionalServiceList() {
        if (this.mOpenedServiceIndex >= 0) {
            this.calcComponentList();
            ServiceInfo serviceInfo = RadioData.getDabDatabase().mTunerState.getCurrentService();
            ComponentInfo componentInfo = RadioData.getDabDatabase().mTunerState.getCurrentComponent();
            this.calcActiveComponentIndex(serviceInfo, componentInfo);
        }
    }

    public void updatePresetBank() {
        if (this.mOpened) {
            for (int i2 = 0; i2 < this.mServiceList.length; ++i2) {
                this.mServiceList[i2].calcAutocompare();
            }
        }
    }

    public void updateCurrentStationInfo() {
        if (this.mOpened) {
            if (this.mActiveServiceIndex != -1) {
                this.mServiceActivatedInOpenedEnsemble = true;
            }
            DABStationListInfoCollector dABStationListInfoCollector = this.getOpenedEnsembleItem();
            DABServiceListItemInfoCollector dABServiceListItemInfoCollector = this.getOpenedServiceItem();
            EnsembleInfo ensembleInfo = RadioData.getDabDatabase().mTunerState.getCurrentEnsemble();
            ServiceInfo serviceInfo = RadioData.getDabDatabase().mTunerState.getCurrentService();
            ComponentInfo componentInfo = RadioData.getDabDatabase().mTunerState.getCurrentComponent();
            this.calcEnsembleList(ensembleInfo, serviceInfo);
            this.calcActiveEnsembleIndex(ensembleInfo);
            this.calcOpenedEnsembleIndex(dABStationListInfoCollector);
            this.calcServiceList(serviceInfo);
            this.calcActiveServiceIndex(serviceInfo);
            this.calcOpenedServiceIndex(dABServiceListItemInfoCollector);
            this.calcComponentList();
            this.calcActiveComponentIndex(serviceInfo, componentInfo);
        }
    }

    public void setActiveService(EnsembleInfo ensembleInfo, ServiceInfo serviceInfo) {
        this.mServiceActivatedInOpenedEnsemble = true;
        this.resetOpenedService();
        this.calcEnsembleList(ensembleInfo, serviceInfo);
        this.calcActiveEnsembleIndex(ensembleInfo);
        this.mOpenedEnsembleIndex = this.mActiveEnsembleIndex;
        this.calcServiceList(serviceInfo);
        this.calcActiveServiceIndex(serviceInfo);
    }

    public void setActiveComponent(EnsembleInfo ensembleInfo, ServiceInfo serviceInfo, ComponentInfo componentInfo) {
        this.mServiceActivatedInOpenedEnsemble = true;
        this.calcEnsembleList(ensembleInfo, serviceInfo);
        this.calcActiveEnsembleIndex(ensembleInfo);
        this.mOpenedEnsembleIndex = this.mActiveEnsembleIndex;
        this.calcServiceList(serviceInfo);
        this.calcActiveServiceIndex(serviceInfo);
        this.mOpenedServiceIndex = this.mActiveServiceIndex;
        this.calcComponentList();
        this.calcActiveComponentIndex(serviceInfo, componentInfo);
    }

    public void updateSyncState() {
        for (int i2 = 0; i2 < this.mEnsembleList.length; ++i2) {
            this.mEnsembleList[i2].calcEnsembleState();
            this.mEnsembleList[i2].calcReceptionState();
        }
    }

    public void updateLanguage() {
        if (this.mOpened) {
            DABStationListInfoCollector dABStationListInfoCollector = this.getOpenedEnsembleItem();
            DABServiceListItemInfoCollector dABServiceListItemInfoCollector = this.getOpenedServiceItem();
            EnsembleInfo ensembleInfo = RadioData.getDabDatabase().mTunerState.getCurrentEnsemble();
            ServiceInfo serviceInfo = RadioData.getDabDatabase().mTunerState.getCurrentService();
            ComponentInfo componentInfo = RadioData.getDabDatabase().mTunerState.getCurrentComponent();
            this.calcEnsembleList(ensembleInfo, serviceInfo);
            this.calcActiveEnsembleIndex(ensembleInfo);
            this.calcOpenedEnsembleIndex(dABStationListInfoCollector);
            this.calcServiceList(serviceInfo);
            this.calcActiveServiceIndex(serviceInfo);
            this.calcOpenedServiceIndex(dABServiceListItemInfoCollector);
            this.calcComponentList();
            this.calcActiveComponentIndex(serviceInfo, componentInfo);
        }
    }

    public boolean isEnsembleOpened() {
        return this.mOpenedEnsembleIndex > -1;
    }

    public boolean isServiceOpened() {
        return this.mOpenedServiceIndex > -1;
    }

    public int getOpenedEnsembleIndex() {
        return this.mOpenedEnsembleIndex;
    }

    public EnsembleInfo getOpenedEnsemble() {
        DABStationListInfoCollector dABStationListInfoCollector = this.getOpenedEnsembleItem();
        if (dABStationListInfoCollector != null) {
            return dABStationListInfoCollector.getEnsemble();
        }
        return null;
    }

    public ServiceInfo getOpenedService() {
        DABServiceListItemInfoCollector dABServiceListItemInfoCollector = this.getOpenedServiceItem();
        if (dABServiceListItemInfoCollector != null) {
            return dABServiceListItemInfoCollector.getService();
        }
        return null;
    }

    public ServiceInfo getService(int n) {
        if (n >= 0 && n < this.mServiceList.length) {
            return this.mServiceList[n].getService();
        }
        return null;
    }

    public int getNextComponentIdx() {
        if (this.mAdditionalServiceList.length > 0) {
            return (this.mActiveComponentIndex + 1) % this.mAdditionalServiceList.length;
        }
        return -1;
    }

    public int getPreviousComponentIdx() {
        if (this.mAdditionalServiceList.length > 0) {
            int n = this.mActiveComponentIndex - 1;
            if (n < 0) {
                n = this.mAdditionalServiceList.length - 1;
            }
            return n;
        }
        return -1;
    }

    public ComponentInfo getComponent(int n) {
        if (n >= 0 && n < this.mAdditionalServiceList.length) {
            return this.mAdditionalServiceList[n].getComponent();
        }
        return null;
    }

    public int getOpenedServiceIndex() {
        return this.mOpenedEnsembleIndex;
    }

    public int getActiveEnsembleIndex() {
        return this.mActiveEnsembleIndex;
    }

    public int getActiveServiceIndex() {
        return this.mActiveServiceIndex;
    }

    public boolean isLoaded() {
        return this.mOpened;
    }

    public void updateDataServiceList() {
        for (int i2 = 0; i2 < this.mServiceList.length; ++i2) {
            this.mServiceList[i2].calcSlsAvailable();
        }
    }

    public int getActiveComponentIndex() {
        return this.mActiveComponentIndex;
    }

    private DABStationListInfoCollector getOpenedEnsembleItem() {
        if (this.mOpenedEnsembleIndex >= 0 && this.mOpenedEnsembleIndex < this.mEnsembleList.length) {
            return this.mEnsembleList[this.mOpenedEnsembleIndex];
        }
        return null;
    }

    private DABServiceListItemInfoCollector getOpenedServiceItem() {
        if (this.mOpenedServiceIndex >= 0 && this.mOpenedServiceIndex < this.mServiceList.length) {
            return this.mServiceList[this.mOpenedServiceIndex];
        }
        return null;
    }

    private void calcEnsembleList(EnsembleInfo ensembleInfo, ServiceInfo serviceInfo) {
        RadioData.getDabDatabase().dabPresetList.correctEmptyEnsembleNameByPresetEnsembleName(ensembleInfo);
        EnsembleInfo[] ensembleInfoArray = RadioData.getDabDatabase().mTunerState.getEnsembleList();
        FrequencyInfo frequencyInfo = RadioData.getDabDatabase().mTunerState.getCurrentFrequencyInfo();
        boolean bl = serviceInfo == null && ensembleInfo == null && frequencyInfo != null;
        boolean bl2 = ensembleInfo != null && RadioData.getDabDatabase().mTunerState.getEnsembleById(ensembleInfo.ensID, ensembleInfo.ensECC) == null;
        TreeSet treeSet = new TreeSet(RadioData.getDabDatabase().mTunerState.getEnsembleNameComparator());
        if (bl2) {
            DABStationListInfoCollector dABStationListInfoCollector = new DABStationListInfoCollector(ensembleInfo);
            treeSet.add(dABStationListInfoCollector);
        }
        if (bl) {
            treeSet.add(new DABStationListInfoCollector(frequencyInfo));
        }
        for (int i2 = 0; i2 < ensembleInfoArray.length; ++i2) {
            EnsembleInfo ensembleInfo2 = ensembleInfoArray[i2];
            DABStationListInfoCollector dABStationListInfoCollector = new DABStationListInfoCollector(ensembleInfo2);
            treeSet.add(dABStationListInfoCollector);
        }
        this.mEnsembleList = new DABStationListInfoCollector[treeSet.size()];
        treeSet.toArray(this.mEnsembleList);
    }

    private void calcServiceList(ServiceInfo serviceInfo) {
        boolean bl;
        RadioData.getDabDatabase().dabPresetList.correctEmptyServiceNameByPresetServiceName(serviceInfo);
        DABStationListInfoCollector dABStationListInfoCollector = null;
        if (this.mOpenedEnsembleIndex >= 0 && this.mOpenedEnsembleIndex < this.mEnsembleList.length) {
            dABStationListInfoCollector = this.mEnsembleList[this.mOpenedEnsembleIndex];
        }
        boolean bl2 = bl = this.mOpenedEnsembleIndex == this.mActiveEnsembleIndex;
        if (dABStationListInfoCollector != null) {
            EnsembleInfo ensembleInfo = dABStationListInfoCollector.getEnsemble();
            if (ensembleInfo != null) {
                TreeSet treeSet = new TreeSet(RadioData.getDabDatabase().mTunerState.getServiceComparator());
                ServiceInfo[] serviceInfoArray = RadioData.getDabDatabase().mTunerState.getServicesByEnsemble(ensembleInfo);
                if (serviceInfoArray != null && serviceInfoArray.length > 0) {
                    for (int i2 = 0; i2 < serviceInfoArray.length; ++i2) {
                        DABServiceListItemInfoCollector dABServiceListItemInfoCollector = new DABServiceListItemInfoCollector(serviceInfoArray[i2], this.mServiceActivatedInOpenedEnsemble);
                        treeSet.add(dABServiceListItemInfoCollector);
                        HmiDabListManager.setPresetImage(serviceInfoArray[i2], dABServiceListItemInfoCollector);
                    }
                    if (serviceInfo != null && bl && !RadioData.getDabDatabase().mTunerState.isServiceInList(serviceInfo)) {
                        DABServiceListItemInfoCollector dABServiceListItemInfoCollector = new DABServiceListItemInfoCollector(serviceInfo);
                        HmiDabListManager.setPresetImage(serviceInfo, dABServiceListItemInfoCollector);
                        treeSet.add(dABServiceListItemInfoCollector);
                    }
                } else if (bl && serviceInfo != null) {
                    DABServiceListItemInfoCollector dABServiceListItemInfoCollector = new DABServiceListItemInfoCollector(serviceInfo);
                    HmiDabListManager.setPresetImage(serviceInfo, dABServiceListItemInfoCollector);
                    treeSet.add(dABServiceListItemInfoCollector);
                }
                this.mServiceList = new DABServiceListItemInfoCollector[treeSet.size()];
                treeSet.toArray(this.mServiceList);
            } else {
                this.mServiceList = new DABServiceListItemInfoCollector[0];
            }
        }
    }

    private void calcComponentList() {
        ServiceInfo serviceInfo;
        DABServiceListItemInfoCollector dABServiceListItemInfoCollector = null;
        this.mAdditionalServiceList = new DABAdditionalServicesListCollector[0];
        if (this.mOpenedServiceIndex >= 0 && this.mOpenedServiceIndex < this.mServiceList.length) {
            dABServiceListItemInfoCollector = this.mServiceList[this.mOpenedServiceIndex];
        }
        if (dABServiceListItemInfoCollector != null && (serviceInfo = dABServiceListItemInfoCollector.getService()) != null) {
            ComponentInfo[] componentInfoArray = RadioData.getDabDatabase().mTunerState.getComponentsByService(serviceInfo);
            this.mAdditionalServiceList = new DABAdditionalServicesListCollector[componentInfoArray.length + 1];
            this.mAdditionalServiceList[0] = new DABAdditionalServicesListCollector(serviceInfo);
            if (componentInfoArray.length > 0) {
                for (int i2 = 1; i2 < this.mAdditionalServiceList.length; ++i2) {
                    this.mAdditionalServiceList[i2] = new DABAdditionalServicesListCollector(componentInfoArray[i2 - 1]);
                }
            }
        }
    }

    private void calcOpenedEnsembleIndex(DABStationListInfoCollector dABStationListInfoCollector) {
        this.mOpenedEnsembleIndex = -1;
        if (dABStationListInfoCollector != null) {
            EnsembleInfo ensembleInfo = dABStationListInfoCollector.getEnsemble();
            if (ensembleInfo != null) {
                for (int i2 = 0; i2 < this.mEnsembleList.length; ++i2) {
                    EnsembleInfo ensembleInfo2 = this.mEnsembleList[i2].getEnsemble();
                    if (ensembleInfo2 == null || !this.compare(ensembleInfo, ensembleInfo2)) continue;
                    this.mOpenedEnsembleIndex = i2;
                    break;
                }
            } else {
                this.mOpenedEnsembleIndex = 0;
            }
            if (this.mOpenedEnsembleIndex < 0) {
                this.mOpenedEnsembleIndex = this.mActiveEnsembleIndex;
            }
        } else {
            this.mOpenedEnsembleIndex = -1;
        }
    }

    private void calcActiveEnsembleIndex(EnsembleInfo ensembleInfo) {
        this.mActiveEnsembleIndex = -1;
        if (ensembleInfo == null) {
            this.mActiveEnsembleIndex = 0;
        } else {
            for (int i2 = 0; i2 < this.mEnsembleList.length; ++i2) {
                EnsembleInfo ensembleInfo2 = this.mEnsembleList[i2].getEnsemble();
                if (ensembleInfo2 == null || !this.compare(ensembleInfo2, ensembleInfo)) continue;
                this.mActiveEnsembleIndex = i2;
                break;
            }
        }
    }

    private void calcOpenedServiceIndex(DABServiceListItemInfoCollector dABServiceListItemInfoCollector) {
        if (dABServiceListItemInfoCollector != null) {
            this.mOpenedServiceIndex = -1;
            ServiceInfo serviceInfo = dABServiceListItemInfoCollector.getService();
            for (int i2 = 0; i2 < this.mServiceList.length; ++i2) {
                ServiceInfo serviceInfo2 = this.mServiceList[i2].getService();
                if (!DabTunerState.compare(serviceInfo, serviceInfo2)) continue;
                this.mOpenedServiceIndex = i2;
                break;
            }
        }
    }

    private void calcActiveServiceIndex(ServiceInfo serviceInfo) {
        this.mActiveServiceIndex = -1;
        if (serviceInfo != null) {
            for (int i2 = 0; i2 < this.mServiceList.length; ++i2) {
                ServiceInfo serviceInfo2 = this.mServiceList[i2].getService();
                if (serviceInfo2 == null || !DabTunerState.compare(serviceInfo2, serviceInfo)) continue;
                this.mActiveServiceIndex = i2;
                break;
            }
        }
    }

    private void calcActiveComponentIndex(ServiceInfo serviceInfo, ComponentInfo componentInfo) {
        if (this.mOpenedServiceIndex >= 0) {
            this.mActiveComponentIndex = -1;
            if (componentInfo != null) {
                for (int i2 = 0; i2 < this.mAdditionalServiceList.length; ++i2) {
                    ComponentInfo componentInfo2 = this.mAdditionalServiceList[i2].getComponent();
                    if (componentInfo2 == null || !DabTunerState.compare(componentInfo2, componentInfo)) continue;
                    this.mActiveComponentIndex = i2;
                    break;
                }
            } else if (serviceInfo != null && DabTunerState.compare(serviceInfo, this.mAdditionalServiceList[0].getService())) {
                this.mActiveComponentIndex = 0;
            }
        }
    }

    public static void setPresetImage(ServiceInfo serviceInfo, DABServiceListItemInfoCollector dABServiceListItemInfoCollector) {
        ResourceLocator resourceLocator = null;
        DabPreset dabPreset = RadioData.getDabDatabase().dabPresetList.find(serviceInfo);
        if (dabPreset != null) {
            resourceLocator = dabPreset.getImage();
        }
        dABServiceListItemInfoCollector.setImage(resourceLocator);
    }
}

