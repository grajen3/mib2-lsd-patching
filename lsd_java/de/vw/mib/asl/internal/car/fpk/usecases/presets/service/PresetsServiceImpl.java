/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.fpk.usecases.presets.service;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.internal.car.fpk.ServiceBase;
import de.vw.mib.asl.internal.car.fpk.api.CarFPKSetupAPI;
import de.vw.mib.asl.internal.car.fpk.commons.AppLogger;
import de.vw.mib.asl.internal.car.fpk.commons.BapArrayLoggerImpl;
import de.vw.mib.asl.internal.car.fpk.usecases.content.selection.model.ContentSelection;
import de.vw.mib.asl.internal.car.fpk.usecases.presets.arrays.PresetsBAPElement;
import de.vw.mib.asl.internal.car.fpk.usecases.presets.arrays.PresetsBAPListDSIListener;
import de.vw.mib.asl.internal.car.fpk.usecases.presets.arrays.PresetsBAPListDSIListenerImpl;
import de.vw.mib.asl.internal.car.fpk.usecases.presets.arrays.PresetsBAPListDelegate;
import de.vw.mib.asl.internal.car.fpk.usecases.presets.arrays.PresetsBAPListFactory;
import de.vw.mib.asl.internal.car.fpk.usecases.presets.arrays.PresetsBAPListNotifier;
import de.vw.mib.asl.internal.car.fpk.usecases.presets.model.Preset;
import de.vw.mib.asl.internal.car.fpk.usecases.presets.service.PresetsChangeListener;
import de.vw.mib.asl.internal.car.fpk.usecases.presets.service.PresetsService;
import de.vw.mib.asl.internal.car.fpk.usecases.presets.service.PresetsServiceImpl$1;
import de.vw.mib.asl.internal.list.ASLListManager;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.bap.array.asg.ASGArrayList;
import de.vw.mib.collections.ObjectArrayList;
import de.vw.mib.genericevents.EventGeneric;
import edu.emory.mathcs.backport.java.util.Collections;
import java.util.ArrayList;
import org.dsi.ifc.carkombi.DCDisplayDependency;
import org.dsi.ifc.carkombi.DCDisplayPresetsListRecord;
import org.dsi.ifc.carkombi.DCViewOptions;
import org.dsi.ifc.global.CarArrayListUpdateInfo;

public class PresetsServiceImpl
extends ServiceBase
implements PresetsService,
PresetsChangeListener {
    private int selectedPresetId = -1;
    private Preset[] presets = new Preset[0];
    private final PresetsBAPListDSIListener dsiListener;
    private boolean oldState = false;
    private static final int[] DSI_NOTIFICATION_IDS = new int[]{97, 96, 99, 98};
    private static final int[] ASL_EVENT_IDS = new int[]{1158479936, 1175257152};

    public PresetsServiceImpl(CarFPKSetupAPI carFPKSetupAPI) {
        super(carFPKSetupAPI);
        PresetsBAPListDelegate presetsBAPListDelegate = new PresetsBAPListDelegate(new BapArrayLoggerImpl(".DCDisplayPresetsList"), this.dsiCarKombi);
        PresetsBAPListNotifier presetsBAPListNotifier = new PresetsBAPListNotifier(this);
        this.dsiListener = new PresetsBAPListDSIListenerImpl(PresetsBAPListFactory.createList(presetsBAPListDelegate, presetsBAPListNotifier));
        this.listenOnModelEvents(ASL_EVENT_IDS);
    }

    @Override
    protected void updateServiceState(DCViewOptions dCViewOptions) {
        boolean bl = this.isServiceAvailable(dCViewOptions.getDisplayPresetsList());
        if (this.oldState != bl) {
            this.dsiListener.onServiceStateChanged(bl);
            if (bl) {
                this.listenOnDSIUpdates(DSI_NOTIFICATION_IDS);
                this.listenOnDSIResponses(this);
            } else {
                this.unlistenOnDSIUpdates(DSI_NOTIFICATION_IDS);
                this.unlistenOnDSIResponses(this);
            }
            super.updateServiceState(dCViewOptions);
            this.oldState = bl;
        }
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        if (1158479936 == eventGeneric.getReceiverEventId()) {
            long l = eventGeneric.getLong(0);
            this.selectPresetById((int)l);
        } else if (1175257152 == eventGeneric.getReceiverEventId()) {
            if (this.isPredefinedPresetSelected()) {
                return;
            }
            long l = eventGeneric.getLong(0);
            ContentSelection contentSelection = this.getCarFPKSetupAPI().getContentSelectionService().getSelectedElement(1);
            ContentSelection contentSelection2 = this.getCarFPKSetupAPI().getContentSelectionService().getSelectedElement(2);
            this.savePreset((int)l, new ContentSelection[]{contentSelection, contentSelection2});
        } else {
            super.gotEvent(eventGeneric);
        }
    }

    public void dsiCarKombiUpdateDCDisplayPresetsListUpdateInfo(CarArrayListUpdateInfo carArrayListUpdateInfo, DCDisplayPresetsListRecord[] dCDisplayPresetsListRecordArray, int n) {
        this.dsiListener.dsiCarKombiUpdateDCDisplayPresetsListUpdateInfo(carArrayListUpdateInfo, dCDisplayPresetsListRecordArray, n);
    }

    public void dsiCarKombiUpdateDCDisplayPresetsListTotalNumberOfElements(int n, int n2) {
        this.dsiListener.dsiCarKombiUpdateDCDisplayPresetsListTotalNumberOfElements(n, n2);
    }

    public void dsiCarKombiResponseDCDisplayPresetsList(CarArrayListUpdateInfo carArrayListUpdateInfo, DCDisplayPresetsListRecord[] dCDisplayPresetsListRecordArray) {
        this.dsiListener.dsiCarKombiResponseDCDisplayPresetsList(carArrayListUpdateInfo, dCDisplayPresetsListRecordArray);
    }

    public void dsiCarKombiUpdateDCActiveDisplayPreset(int n, int n2) {
        AppLogger.info(this, new StringBuffer().append(".dsiCarKombiUpdateDCActiveDisplayPreset( presetId = ").append(n).append(", valid = ").append(n2).append(" )").toString());
        this.selectedPresetId = n;
        this.onPresetSelected(n);
    }

    public void dsiCarKombiUpdateDCDisplayDependencySetup(DCDisplayDependency dCDisplayDependency, int n) {
        AppLogger.info(this, new StringBuffer().append(".dsiCarKombiUpdateDCDisplayDependencySetup( setup = ").append(dCDisplayDependency.toString()).append(", valid = ").append(n).append(" )").toString());
    }

    @Override
    public void savePreset(int n, ContentSelection[] contentSelectionArray) {
        PresetsBAPElement presetsBAPElement = this.getPresetById(n);
        if (presetsBAPElement == null) {
            AppLogger.error(this, new StringBuffer().append(".savePreset( presetId = ").append(n).append(", selectedElements = .. ), no preset found for given identifier").toString());
            return;
        }
        presetsBAPElement.setModelBy(contentSelectionArray);
        ASGArrayList aSGArrayList = ((PresetsBAPListDSIListenerImpl)this.dsiListener).getList();
        aSGArrayList.modifyArrayElement(presetsBAPElement, 2);
    }

    @Override
    public void selectPresetById(int n) {
        Preset preset;
        PresetsBAPElement presetsBAPElement = this.getPresetById(n);
        if (presetsBAPElement != null && presetsBAPElement.getModel().getType() == 3) {
            this.toggleDrivingProfileDependency();
        }
        if ((preset = this.getSelectedPreset()) != null && preset.getModel().getType() == 3) {
            this.toggleDrivingProfileDependency();
        }
        this.dsiCarKombi.setDCActiveDisplayPreset(n);
    }

    @Override
    public void selectPresetByIndex(int n) {
        PresetsBAPElement presetsBAPElement = this.getPresetByIndex(n);
        if (presetsBAPElement != null) {
            this.dsiCarKombi.setDCActiveDisplayPreset(presetsBAPElement.getPos());
        }
    }

    @Override
    public void onPresetsUpdated(Preset[] presetArray) {
        AppLogger.trace(this, new StringBuffer().append(".onPresetsUpdated( presets = ").append(this.toString(presetArray)).append(" )").toString());
        this.presets = presetArray;
        this.onPresetsChanged(presetArray);
    }

    @Override
    public Preset getSelectedPreset() {
        return this.getPresetById(this.selectedPresetId);
    }

    @Override
    public Preset[] getPresets() {
        return this.presets;
    }

    @Override
    public boolean isPredefinedPresetSelected() {
        Preset preset = this.getSelectedPreset();
        if (null == preset) {
            return false;
        }
        return preset.getModel().getState() == 1;
    }

    private PresetsBAPElement getPresetById(int n) {
        ASGArrayList aSGArrayList = ((PresetsBAPListDSIListenerImpl)this.dsiListener).getList();
        for (int i2 = 0; i2 < aSGArrayList.getBapArrayListSize(); ++i2) {
            PresetsBAPElement presetsBAPElement = (PresetsBAPElement)aSGArrayList.get(i2);
            if (presetsBAPElement.getModel().getPos() != n) continue;
            return presetsBAPElement;
        }
        return null;
    }

    private PresetsBAPElement getPresetByIndex(int n) {
        ASGArrayList aSGArrayList = ((PresetsBAPListDSIListenerImpl)this.dsiListener).getList();
        if (n >= 0 && n < aSGArrayList.getBapArrayListSize()) {
            return (PresetsBAPElement)aSGArrayList.get(n);
        }
        return null;
    }

    private void toggleDrivingProfileDependency() {
        Preset preset = this.getSelectedPreset();
        if (preset != null) {
            if (preset.getModel().getType() == 3) {
                this.dsiCarKombi.setDCDisplayDependencySetup(new DCDisplayDependency(false));
            } else {
                this.dsiCarKombi.setDCDisplayDependencySetup(new DCDisplayDependency(true));
            }
        } else {
            this.dsiCarKombi.setDCDisplayDependencySetup(new DCDisplayDependency(true));
        }
    }

    private void onPresetSelected(int n) {
        AppLogger.trace(this, new StringBuffer().append(".onPresetSelected( ").append(n).append(")").toString());
        ASLPropertyManager aSLPropertyManager = this.getAslPropertyManager();
        PresetsBAPElement presetsBAPElement = this.getPresetById(n);
        if (null != this.getCarFPKSetupAPI().getContentSelectionService()) {
            AppLogger.trace(this, new StringBuffer().append(".onPresetSelected( ").append(n).append("), invoking 'validateAndUpdatePredefinedPresetContent'").toString());
            this.getCarFPKSetupAPI().getContentSelectionService().validateAndUpdatePredefinedPresetContent();
        }
        if (null == presetsBAPElement) {
            aSLPropertyManager.valueChangedLong(10862, -1L);
            aSLPropertyManager.valueChangedLong(10861, -1L);
        } else if (presetsBAPElement.getModel().getState() == 1) {
            aSLPropertyManager.valueChangedLong(10862, presetsBAPElement.getPos());
            aSLPropertyManager.valueChangedLong(10861, -1L);
        } else {
            aSLPropertyManager.valueChangedLong(10862, -1L);
            aSLPropertyManager.valueChangedLong(10861, presetsBAPElement.getPos());
        }
    }

    private void onPresetsChanged(Preset[] presetArray) {
        ASLListManager aSLListManager = this.getAslListManager();
        GenericASLList genericASLList = aSLListManager.getGenericASLList(10863);
        GenericASLList genericASLList2 = aSLListManager.getGenericASLList(10860);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < presetArray.length; ++i2) {
            if (presetArray[i2].getModel().getState() == 1) {
                arrayList.add(presetArray[i2]);
                Collections.sort(arrayList, new PresetsServiceImpl$1(this));
                continue;
            }
            arrayList2.add(presetArray[i2]);
        }
        genericASLList.updateList(arrayList.toArray());
        genericASLList2.updateList(arrayList2.toArray());
        this.onPresetSelected(this.selectedPresetId);
    }

    private String toString(Preset[] presetArray) {
        ObjectArrayList objectArrayList = new ObjectArrayList(presetArray.length);
        for (int i2 = 0; i2 < presetArray.length; ++i2) {
            objectArrayList.add(presetArray[i2]);
        }
        return objectArrayList.toString();
    }
}

