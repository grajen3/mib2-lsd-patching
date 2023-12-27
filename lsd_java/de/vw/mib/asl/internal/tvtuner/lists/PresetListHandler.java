/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.tvtuner.lists;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.tvtuner.accessor.TVTunerObjectAccessor;
import de.vw.mib.asl.internal.tvtuner.collector.PresetListCollector;
import de.vw.mib.asl.internal.tvtuner.collector.TVPresetStoreAndDeletionListCollector;
import de.vw.mib.asl.internal.tvtuner.common.TVTunerConstants;
import de.vw.mib.asl.internal.tvtuner.common.TVTunerHelper;
import de.vw.mib.asl.internal.tvtuner.lists.AbstractListHandler;
import de.vw.mib.asl.internal.tvtuner.lists.TVTunerPreset;
import de.vw.mib.collections.ints.IntOptHashSet;
import de.vw.mib.collections.ints.IntSet;
import generated.de.vw.mib.asl.internal.ListManager;
import java.util.Arrays;
import org.dsi.ifc.tvtuner.ServiceInfo;

public class PresetListHandler
extends AbstractListHandler {
    private TVTunerPreset[] presetList = new TVTunerPreset[99];
    private IntSet tvNormAreaSublist = new IntOptHashSet();
    private int currentPresetPosition;

    public int getPresetPosition(ServiceInfo serviceInfo) {
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace(new StringBuffer().append("PresetListHandler#getPresetPositon called - service ").append(serviceInfo.getName()).toString());
        }
        for (int i2 = 0; i2 < this.presetList.length; ++i2) {
            if (this.presetList[i2] == null) continue;
            if (TVTunerObjectAccessor.getTvTunerSettings().isServiceLinking()) {
                if (this.presetList[i2].namePID != serviceInfo.namePID) continue;
                if (TVTunerHelper.isTraceEnabled()) {
                    TVTunerHelper.trace(new StringBuffer().append("PresetListHandler#getPresetPositon - preset position for ").append(serviceInfo.getName()).append("is ").append(i2).toString());
                }
                return i2;
            }
            if (this.presetList[i2].namePID != serviceInfo.namePID || this.presetList[i2].servicePID != serviceInfo.servicePID) continue;
            if (TVTunerHelper.isTraceEnabled()) {
                TVTunerHelper.trace(new StringBuffer().append("PresetListHandler#getPresetPositon - preset position for ").append(serviceInfo.getName()).append("is ").append(i2).toString());
            }
            return i2;
        }
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace(new StringBuffer().append("PresetListHandler#getPresetPositon - ").append(serviceInfo.getName()).append(" not stored in presets ").toString());
        }
        return -1;
    }

    public void activateSelectedPreset(int n) {
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace(new StringBuffer().append("PresetListHandler#activateSelectedStation called - SelectedIndex = ").append(n).toString());
        }
        this.activateSelectedService(this.presetList[n]);
    }

    public boolean areMoreThanOnePresetAvailable() {
        int n = 0;
        for (int i2 = 0; i2 < this.presetList.length; ++i2) {
            if (this.presetList[i2].getSType() == -1 || ++n <= 1) continue;
            return true;
        }
        return false;
    }

    public void updatePresetList(TVTunerPreset[] tVTunerPresetArray) {
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace("PresetListHandler#updatePresetList called - presetlist updated");
        }
        this.presetList = tVTunerPresetArray;
        Object[] objectArray = new PresetListCollector[this.presetList.length];
        Object[] objectArray2 = new TVPresetStoreAndDeletionListCollector[this.presetList.length];
        boolean bl = false;
        boolean bl2 = true;
        for (int i2 = 0; i2 < this.presetList.length; ++i2) {
            bl = this.presetList[i2].getSType() != -1;
            objectArray[i2] = new PresetListCollector(i2 + 1, this.presetList[i2].getName(), this.presetList[i2].getSType());
            objectArray2[i2] = new TVPresetStoreAndDeletionListCollector(i2 + 1, this.presetList[i2].getName(), bl);
            if (!bl) continue;
            this.tvNormAreaSublist.add(this.presetList[i2].getTvNormArea());
            bl2 = false;
        }
        ListManager.getGenericASLList(2710).updateList(objectArray);
        ListManager.getGenericASLList(2715).updateList(objectArray2);
        ListManager.getGenericASLList(2749).updateList(objectArray2);
        ServiceManager.aslPropertyManager.valueChangedBoolean(-1219746304, bl2);
        TVTunerObjectAccessor.getTvTunerSettings().setTVNormAreaSublist(TVTunerHelper.convertIntSet2IntArray(this.tvNormAreaSublist));
        ServiceInfo serviceInfo = TVTunerObjectAccessor.getTVInfo().getCurrentServiceInfo();
        if (serviceInfo != null) {
            this.setPresetListIndex(serviceInfo);
        }
    }

    public void saveStationAtPresetPosition(int n) {
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace("PresetListHandler#saveStationAtPresetPosition called");
        }
        TVTunerPreset tVTunerPreset = new TVTunerPreset(TVTunerObjectAccessor.getTVInfo().getCurrentServiceInfo(), TVTunerObjectAccessor.getTVInfo().getCurrentNormArea());
        this.removeMultipleAllocationsOfPreset(tVTunerPreset);
        this.presetList[n] = tVTunerPreset;
        TVTunerObjectAccessor.getTvTunerDB().getTvPresetPersistable().savePresets(this.presetList);
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace(new StringBuffer().append("PresetListHandler#saveStationAtPresetPosition - Station ").append(this.presetList[n].getName()).append(" stored at Presetposition ").append(n + 1).toString());
        }
        this.updatePresetList(this.presetList);
        TVTunerObjectAccessor.getStationListHandler().updateServiceInfo();
    }

    public void savePresetAtPosition(TVTunerPreset tVTunerPreset, int n) {
        this.removeMultipleAllocationsOfPreset(tVTunerPreset);
        this.presetList[n] = tVTunerPreset;
        TVTunerObjectAccessor.getTvTunerDB().getTvPresetPersistable().savePresets(this.presetList);
        this.updatePresetList(this.presetList);
        TVTunerObjectAccessor.getStationListHandler().updateServiceInfo();
    }

    private void removeMultipleAllocationsOfPreset(TVTunerPreset tVTunerPreset) {
        for (int i2 = 0; i2 < this.presetList.length; ++i2) {
            if (this.presetList[i2].getNamePID() != tVTunerPreset.namePID) continue;
            this.presetList[i2] = TVTunerConstants.EMPTY_PRESET;
        }
    }

    public void deletePresetAtPosition(int n) {
        this.presetList[n] = TVTunerConstants.EMPTY_PRESET;
        TVTunerObjectAccessor.getTvTunerDB().getTvPresetPersistable().savePresets(this.presetList);
        this.updatePresetList(this.presetList);
        TVTunerObjectAccessor.getStationListHandler().updateServiceInfo();
    }

    public void deleteAllPresets() {
        Arrays.fill(this.presetList, TVTunerConstants.EMPTY_PRESET);
        TVTunerObjectAccessor.getTvTunerDB().getTvPresetPersistable().savePresets(this.presetList);
        this.updatePresetList(this.presetList);
        TVTunerObjectAccessor.getStationListHandler().updateServiceInfo();
    }

    public void setPresetListIndex(ServiceInfo serviceInfo) {
        this.setPresetListIndex(new TVTunerPreset(serviceInfo));
    }

    public void setPresetListIndex(TVTunerPreset tVTunerPreset) {
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace(new StringBuffer().append("PresetListHandler#setPresetListIndex called - service ").append(tVTunerPreset.getName()).toString());
        }
        int n = -1;
        for (int i2 = 0; i2 < this.presetList.length; ++i2) {
            if (this.presetList[i2].getNamePID() != tVTunerPreset.getNamePID()) continue;
            n = i2;
            break;
        }
        if (n != -1) {
            if (TVTunerHelper.isTraceEnabled()) {
                TVTunerHelper.trace(new StringBuffer().append("PresetListHandler#setPresetListIndex - presetListIndex = ").append(n).toString());
            }
        } else if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace(new StringBuffer().append("PresetListHandler#setStationListIndex - service ").append(tVTunerPreset.getName()).append(" not present in presetlist").toString());
        }
        this.currentPresetPosition = n;
        ServiceManager.aslPropertyManager.valueChangedInteger(2709, n);
    }

    public void selectNextPresetService(int n) {
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace(new StringBuffer().append("PresetListHandler#selectNextPresetService called - direction = ").append(n).toString());
        }
        if (this.arePresetsAvailable()) {
            if (TVTunerHelper.isTraceEnabled()) {
                TVTunerHelper.trace(new StringBuffer().append("PresetListHandler#selectNextPresetService called - direction = ").append(n).toString());
            }
            ServiceInfo serviceInfo = TVTunerObjectAccessor.getTVInfo().getCurrentServiceInfo();
            int n2 = this.getIndexOfService(serviceInfo);
            int n3 = 0;
            if (n2 != -1) {
                n3 = n == 1 ? (n2 == this.presetList.length - 1 ? 0 : n2 + 1) : (n2 == 0 ? this.presetList.length - 1 : n2 - 1);
            } else {
                n = 1;
            }
            do {
                if (this.presetList[n3].getSType() != -1) {
                    this.activateSelectedPreset(n3);
                    break;
                }
                if (n == 1) {
                    if (++n3 != this.presetList.length) continue;
                    n3 = 0;
                    continue;
                }
                if (--n3 != -1) continue;
                n3 = this.presetList.length - 1;
            } while (n3 != n2);
        } else if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace("PresetListHandler#selectNextPresetService called - but no presets available - do nothing");
        }
    }

    private int getIndexOfService(ServiceInfo serviceInfo) {
        for (int i2 = 0; i2 < this.presetList.length; ++i2) {
            if (this.presetList[i2].getNamePID() != serviceInfo.getNamePID()) continue;
            return i2;
        }
        return -1;
    }

    public boolean arePresetsAvailable() {
        for (int i2 = 0; i2 < this.presetList.length; ++i2) {
            if (this.presetList[i2].getSType() == -1) continue;
            return true;
        }
        return false;
    }

    public String getPresetStationName(long l, int n) {
        String string = null;
        if (this.arePresetsAvailable()) {
            for (int i2 = 0; i2 < this.presetList.length; ++i2) {
                if (l != this.presetList[i2].getNamePID()) continue;
                string = this.presetList[i2].getName();
                break;
            }
        }
        return string;
    }

    public int getPresetSType(long l, int n) {
        int n2 = -1;
        if (this.arePresetsAvailable()) {
            for (int i2 = 0; i2 < this.presetList.length; ++i2) {
                if (l != this.presetList[i2].getNamePID()) continue;
                n2 = this.presetList[i2].getSType();
                break;
            }
        }
        return n2;
    }

    public int getCurrentPresetPosition() {
        return this.currentPresetPosition;
    }
}

