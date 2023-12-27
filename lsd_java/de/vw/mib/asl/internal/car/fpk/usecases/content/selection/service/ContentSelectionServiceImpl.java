/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.fpk.usecases.content.selection.service;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.internal.car.fpk.ServiceBase;
import de.vw.mib.asl.internal.car.fpk.api.CarFPKSetupAPI;
import de.vw.mib.asl.internal.car.fpk.commons.AppLogger;
import de.vw.mib.asl.internal.car.fpk.commons.BapArrayLoggerImpl;
import de.vw.mib.asl.internal.car.fpk.usecases.content.selection.arrays.ContentSelectionBAPElement;
import de.vw.mib.asl.internal.car.fpk.usecases.content.selection.arrays.ContentSelectionBAPListDelegate;
import de.vw.mib.asl.internal.car.fpk.usecases.content.selection.arrays.ContentSelectionBAPListFactory;
import de.vw.mib.asl.internal.car.fpk.usecases.content.selection.arrays.ContentSelectionBAPListNotifier;
import de.vw.mib.asl.internal.car.fpk.usecases.content.selection.arrays.ContentSelectionDSIListenerImpl;
import de.vw.mib.asl.internal.car.fpk.usecases.content.selection.model.ContentSelection;
import de.vw.mib.asl.internal.car.fpk.usecases.content.selection.model.ContentSelectionDebounce;
import de.vw.mib.asl.internal.car.fpk.usecases.content.selection.service.ContentSelectionChangeListener;
import de.vw.mib.asl.internal.car.fpk.usecases.content.selection.service.ContentSelectionService;
import de.vw.mib.asl.internal.car.fpk.usecases.content.setup.model.DisplayElement;
import de.vw.mib.asl.internal.car.fpk.usecases.content.setup.model.DisplayElements;
import de.vw.mib.asl.internal.car.fpk.usecases.presets.model.Preset;
import de.vw.mib.asl.internal.list.ASLListManager;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.bap.array.asg.ASGArrayList;
import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.collections.ObjectArrayList;
import de.vw.mib.genericevents.EventGeneric;
import generated.de.vw.mib.asl.internal.car.fpk.transformer.CarFPKCurrentElementContentSelectionDisplay1_1Collector;
import generated.de.vw.mib.asl.internal.car.fpk.transformer.CarFPKCurrentElementContentSelectionDisplay2_1Collector;
import org.dsi.ifc.carkombi.DCElementContentSelectionListRA1;
import org.dsi.ifc.carkombi.DCElementContentSelectionListRA2;
import org.dsi.ifc.carkombi.DCElementContentSelectionListUpdateInfo;
import org.dsi.ifc.carkombi.DCViewOptions;

public class ContentSelectionServiceImpl
extends ServiceBase
implements ContentSelectionService,
ContentSelectionChangeListener {
    private ContentSelection display1ContentSelection;
    private ContentSelection display2ContentSelection;
    private final ContentSelectionDSIListenerImpl dsiListener;
    private final ContentSelectionDebounce display1SelectionUpdater = new ContentSelectionDebounce(this, 1);
    private final ContentSelectionDebounce display2SelectionUpdater = new ContentSelectionDebounce(this, 2);
    private boolean oldState = false;
    private static final int[] DSI_NOTIFICATION_IDS = new int[]{92, 85};
    private static final int[] ASL_EVENT_IDS = new int[]{1192034368};

    public ContentSelectionServiceImpl(CarFPKSetupAPI carFPKSetupAPI) {
        super(carFPKSetupAPI);
        ContentSelectionBAPListDelegate contentSelectionBAPListDelegate = new ContentSelectionBAPListDelegate(new BapArrayLoggerImpl(".DCElementContentSelectionList"), this.dsiCarKombi);
        ContentSelectionBAPListNotifier contentSelectionBAPListNotifier = new ContentSelectionBAPListNotifier(this);
        ASGArrayList aSGArrayList = ContentSelectionBAPListFactory.createList(contentSelectionBAPListDelegate, contentSelectionBAPListNotifier);
        this.dsiListener = new ContentSelectionDSIListenerImpl(aSGArrayList);
        this.listenOnModelEvents(ASL_EVENT_IDS);
    }

    @Override
    protected void updateServiceState(DCViewOptions dCViewOptions) {
        boolean bl = this.isServiceAvailable(dCViewOptions.getElementContentSelectionList());
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
        AppLogger.trace(this, new StringBuffer().append(".gotEvent (").append(eventGeneric).append(")").toString());
        if (null == this.getCarFPKSetupAPI() || null == this.getCarFPKSetupAPI().getPresetsService() || this.getCarFPKSetupAPI().getPresetsService().isPredefinedPresetSelected()) {
            super.gotEvent(eventGeneric);
            return;
        }
        if (null != this.display1SelectionUpdater && this.display1SelectionUpdater.isManaged(eventGeneric)) {
            this.display1SelectionUpdater.gotEvent(eventGeneric);
        } else if (null != this.display2SelectionUpdater && this.display2SelectionUpdater.isManaged(eventGeneric)) {
            this.display2SelectionUpdater.gotEvent(eventGeneric);
        } else {
            super.gotEvent(eventGeneric);
        }
    }

    public void dsiCarKombiUpdateDCElementContentSelectionListUpdateInfo(DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo, int[] nArray, int n) {
        this.dsiListener.dsiCarKombiUpdateDCElementContentSelectionListUpdateInfo(dCElementContentSelectionListUpdateInfo, nArray, n);
    }

    public void dsiCarKombiUpdateDCElementContentSelectionListTotalNumberOfElements(int n, int n2) {
        this.dsiListener.dsiCarKombiUpdateDCElementContentSelectionListTotalNumberOfElements(n, n2);
    }

    public void dsiCarKombiResponseDCElementContentSelectionListRA1(DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo, DCElementContentSelectionListRA1[] dCElementContentSelectionListRA1Array) {
        this.dsiListener.dsiCarKombiResponseDCElementContentSelectionListRA1(dCElementContentSelectionListUpdateInfo, dCElementContentSelectionListRA1Array);
    }

    public void dsiCarKombiResponseDCElementContentSelectionListRA2(DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo, DCElementContentSelectionListRA2[] dCElementContentSelectionListRA2Array) {
        this.dsiListener.dsiCarKombiResponseDCElementContentSelectionListRA2(dCElementContentSelectionListUpdateInfo, dCElementContentSelectionListRA2Array);
    }

    public void dsiCarKombiResponseDCElementContentSelectionListRAF(DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo, int[] nArray) {
        this.dsiListener.dsiCarKombiResponseDCElementContentSelectionListRAF(dCElementContentSelectionListUpdateInfo, nArray);
    }

    @Override
    public ContentSelection getSelectedElement(int n) {
        return n == 1 ? this.display1ContentSelection : this.display2ContentSelection;
    }

    @Override
    public void selectElement(int n, int n2, int n3) {
        AppLogger.trace(this, new StringBuffer().append(".selectElement( displayId = ").append(n).append(", elementIndex = ").append(n2).append(" )").toString());
        int n4 = this.getCarFPKSetupAPI().getDisplaySetupService().getDisplayElements(n).getElementIdForIndex(n2);
        ContentSelection contentSelection = this.getSelectedElement(n);
        if (contentSelection != null && n4 == contentSelection.getElementContent()) {
            AppLogger.trace(this, ".selectElement(..), element is already selected");
            return;
        }
        if (null == contentSelection) {
            AppLogger.trace(this, ".selectElement(..), no position information available");
            this.display1SelectionUpdater.stopDebounceAndWaitForElementContentSelectionUpdate();
            this.display2SelectionUpdater.stopDebounceAndWaitForElementContentSelectionUpdate();
            this.triggerFakeElementContentSelectionFRU();
            return;
        }
        ContentSelectionBAPElement contentSelectionBAPElement = this.createSelectionBy(n, n4, n3);
        if (contentSelectionBAPElement == null) {
            AppLogger.error(this, ".selectElement(..), no element found for given identifier");
            return;
        }
        ASGArrayList aSGArrayList = this.dsiListener.getList();
        aSGArrayList.modifyArrayElement(contentSelectionBAPElement, 1);
    }

    @Override
    public void setElementContentToModel(int n, int n2, int n3) {
        ASLListManager aSLListManager = this.getAslListManager();
        ASLPropertyManager aSLPropertyManager = this.getAslPropertyManager();
        int n4 = (int)DisplayElements.getElementAslId(n2);
        if (1 == n) {
            CarFPKCurrentElementContentSelectionDisplay1_1Collector carFPKCurrentElementContentSelectionDisplay1_1Collector = new CarFPKCurrentElementContentSelectionDisplay1_1Collector();
            carFPKCurrentElementContentSelectionDisplay1_1Collector.car_fpk_current_element_content_selection_id_display1__1 = n4;
            carFPKCurrentElementContentSelectionDisplay1_1Collector.car_fpk_current_element_content_selection_index_display1__1 = n3;
            GenericASLList genericASLList = aSLListManager.getGenericASLList(10885);
            genericASLList.updateList(new CarFPKCurrentElementContentSelectionDisplay1_1Collector[]{carFPKCurrentElementContentSelectionDisplay1_1Collector});
            aSLPropertyManager.valueChangedInteger(10901, n4);
        } else if (2 == n) {
            CarFPKCurrentElementContentSelectionDisplay2_1Collector carFPKCurrentElementContentSelectionDisplay2_1Collector = new CarFPKCurrentElementContentSelectionDisplay2_1Collector();
            carFPKCurrentElementContentSelectionDisplay2_1Collector.car_fpk_current_element_content_selection_id_display2__1 = n4;
            carFPKCurrentElementContentSelectionDisplay2_1Collector.car_fpk_current_element_content_selection_index_display2__1 = n3;
            GenericASLList genericASLList = aSLListManager.getGenericASLList(10886);
            genericASLList.updateList(new CarFPKCurrentElementContentSelectionDisplay2_1Collector[]{carFPKCurrentElementContentSelectionDisplay2_1Collector});
            aSLPropertyManager.valueChangedInteger(10902, n4);
        }
    }

    @Override
    public boolean validateAndUpdatePredefinedPresetContent() {
        AppLogger.trace(this, new StringBuffer().append(".validateAndUpdatePredefinedPresetContent(..), DISPLAY1 = ").append(this.display1ContentSelection).append(" DISPLAY2 = ").append(this.display2ContentSelection).toString());
        if (null == this.getCarFPKSetupAPI().getPresetsService()) {
            AppLogger.trace(this, ".validatePredefinedPresetContent(..), preset service is null");
            return false;
        }
        if (this.getCarFPKSetupAPI().getPresetsService().isPredefinedPresetSelected()) {
            int n;
            Preset preset = this.getCarFPKSetupAPI().getPresetsService().getSelectedPreset();
            boolean bl = false;
            if (null != preset && (preset.getModel().getType() == 2 || preset.getModel().getType() == 3)) {
                bl = null != this.display1ContentSelection && this.display1ContentSelection.getElementContent() == 0 && null != this.display2ContentSelection && this.display2ContentSelection.getElementContent() == 0;
                AppLogger.trace(this, new StringBuffer().append(".validateAndUpdatePredefinedPresetContent(..), Classic preset with blank/blank = ").append(bl).toString());
            }
            ASLPropertyManager aSLPropertyManager = this.getAslPropertyManager();
            if (null != this.display1ContentSelection) {
                n = bl ? 43 : this.display1ContentSelection.getElementContent();
                aSLPropertyManager.valueChangedInteger(10901, (int)DisplayElements.getElementAslId(n));
            }
            if (null != this.display2ContentSelection) {
                n = bl ? 38 : this.display2ContentSelection.getElementContent();
                aSLPropertyManager.valueChangedInteger(10902, (int)DisplayElements.getElementAslId(n));
            }
            return true;
        }
        return false;
    }

    @Override
    public void onSelectionUpdated(ContentSelection[] contentSelectionArray) {
        int n;
        AppLogger.trace(this, new StringBuffer().append(".onSelectionUpdated(..), ").append(this.toString(contentSelectionArray)).toString());
        for (n = 0; n < contentSelectionArray.length; ++n) {
            if (contentSelectionArray[n].getDisplay() == 1) {
                this.display1ContentSelection = contentSelectionArray[n];
                continue;
            }
            if (contentSelectionArray[n].getDisplay() == 2) {
                this.display2ContentSelection = contentSelectionArray[n];
                continue;
            }
            AppLogger.warn(this, ".onSelectionUpdated(..), display id is not refered in the content selection");
        }
        if (!this.validateAndUpdatePredefinedPresetContent()) {
            for (n = 0; n < contentSelectionArray.length; ++n) {
                if (contentSelectionArray[n].getDisplay() == 1) {
                    this.display1SelectionUpdater.onSelectionUpdated(this.display1ContentSelection);
                    continue;
                }
                if (contentSelectionArray[n].getDisplay() != 2) continue;
                this.display2SelectionUpdater.onSelectionUpdated(this.display2ContentSelection);
            }
        }
    }

    private ContentSelectionBAPElement createSelectionBy(int n, int n2, int n3) {
        DisplayElement[] displayElementArray = this.getCarFPKSetupAPI().getDisplaySetupService().getDisplayElements(n).getElements();
        for (int i2 = 0; i2 < displayElementArray.length; ++i2) {
            if (displayElementArray[i2].displayId != n || displayElementArray[i2].elementId != n2) continue;
            DCElementContentSelectionListRA1 dCElementContentSelectionListRA1 = new DCElementContentSelectionListRA1();
            dCElementContentSelectionListRA1.pos = this.getContentSelectionPosByDisplayId(n);
            dCElementContentSelectionListRA1.display = displayElementArray[i2].displayId;
            dCElementContentSelectionListRA1.additionalInfo = n3;
            dCElementContentSelectionListRA1.element = 1;
            dCElementContentSelectionListRA1.elementContent = displayElementArray[i2].elementId;
            ArrayHeader arrayHeader = new ArrayHeader();
            arrayHeader.mode.arrayPositionIsTransmitted = true;
            arrayHeader.setRecordAddress(1);
            arrayHeader.start = i2;
            return new ContentSelectionBAPElement(arrayHeader, dCElementContentSelectionListRA1);
        }
        return null;
    }

    private int getContentSelectionPosByDisplayId(int n) {
        ContentSelection contentSelection = this.getSelectedElement(n);
        return contentSelection != null ? this.getSelectedElement(n).getPos() : ContentSelection.getPosByDisplayId(n);
    }

    private void triggerFakeElementContentSelectionFRU() {
        DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo = new DCElementContentSelectionListUpdateInfo(1, 0, 0, 255, 0, 0);
        this.dsiCarKombiUpdateDCElementContentSelectionListUpdateInfo(dCElementContentSelectionListUpdateInfo, new int[0], 1);
    }

    private String toString(ContentSelection[] contentSelectionArray) {
        ObjectArrayList objectArrayList = new ObjectArrayList(contentSelectionArray.length);
        for (int i2 = 0; i2 < contentSelectionArray.length; ++i2) {
            objectArrayList.add(contentSelectionArray[i2]);
        }
        return objectArrayList.toString();
    }
}

