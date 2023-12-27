/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.fpk.usecases.content.setup.service;

import de.vw.mib.asl.internal.car.fpk.ServiceBase;
import de.vw.mib.asl.internal.car.fpk.api.CarFPKSetupAPI;
import de.vw.mib.asl.internal.car.fpk.commons.AppLogger;
import de.vw.mib.asl.internal.car.fpk.usecases.content.selection.service.ContentSelectionService;
import de.vw.mib.asl.internal.car.fpk.usecases.content.setup.model.DisplayElement;
import de.vw.mib.asl.internal.car.fpk.usecases.content.setup.model.DisplayElements;
import de.vw.mib.asl.internal.car.fpk.usecases.content.setup.service.DisplaySetupService;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import org.dsi.ifc.carkombi.DCAdditionalInfo;
import org.dsi.ifc.carkombi.DCDisplayedAdditionalInfos;
import org.dsi.ifc.carkombi.DCMainItems;
import org.dsi.ifc.carkombi.DCViewOptions;

public class DisplaySetupServiceImpl
extends ServiceBase
implements DisplaySetupService {
    private DisplayElements display1Elements;
    private DisplayElements display2Elements;
    private static final int[] DSI_NOTIFICATION_IDS = new int[]{86, 87};

    public DisplaySetupServiceImpl(CarFPKSetupAPI carFPKSetupAPI) {
        super(carFPKSetupAPI);
        this.listenOnDSIUpdates(DSI_NOTIFICATION_IDS);
    }

    @Override
    protected void updateServiceState(DCViewOptions dCViewOptions) {
        boolean bl;
        boolean bl2 = bl = this.isServiceAvailable(dCViewOptions.getDisplay1Setup()) && this.isServiceAvailable(dCViewOptions.getDisplay2Setup());
        if (bl) {
            this.listenOnDSIUpdates(DSI_NOTIFICATION_IDS);
        } else {
            this.unlistenOnDSIUpdates(DSI_NOTIFICATION_IDS);
            this.onDisplayElementsChanged(1, null);
            this.onDisplayElementsChanged(2, null);
        }
        super.updateServiceState(dCViewOptions);
    }

    public void dsiCarKombiUpdateDCDisplay1Setup(DCMainItems dCMainItems, DCDisplayedAdditionalInfos dCDisplayedAdditionalInfos, DCAdditionalInfo dCAdditionalInfo, DCAdditionalInfo dCAdditionalInfo2, int n) {
        AppLogger.info(this, new StringBuffer().append(".dsiCarKombiUpdateDCDisplay1Setup( valid = ").append(n).append(" )").toString());
        this.display1Elements = new DisplayElements(1, dCDisplayedAdditionalInfos, dCAdditionalInfo, dCAdditionalInfo2);
        this.onDisplayElementsChanged(1, this.display1Elements);
    }

    public void dsiCarKombiUpdateDCDisplay2Setup(DCMainItems dCMainItems, DCDisplayedAdditionalInfos dCDisplayedAdditionalInfos, DCAdditionalInfo dCAdditionalInfo, DCAdditionalInfo dCAdditionalInfo2, int n) {
        AppLogger.info(this, new StringBuffer().append(".dsiCarKombiUpdateDCDisplay2Setup( valid = ").append(n).append(" )").toString());
        this.display2Elements = new DisplayElements(2, dCDisplayedAdditionalInfos, dCAdditionalInfo, dCAdditionalInfo2);
        this.onDisplayElementsChanged(2, this.display2Elements);
    }

    private void onDisplayElementsChanged(int n, DisplayElements displayElements) {
        if (null == displayElements) {
            GenericASLList genericASLList = this.getAslListManager().getGenericASLList(10883);
            GenericASLList genericASLList2 = this.getAslListManager().getGenericASLList(10884);
            genericASLList.updateList(this.createDefaultElements(1));
            genericASLList2.updateList(this.createDefaultElements(2));
            ContentSelectionService contentSelectionService = this.getCarFPKSetupAPI().getContentSelectionService();
            contentSelectionService.setElementContentToModel(1, 0, 0);
            contentSelectionService.setElementContentToModel(2, 0, 0);
        } else {
            if (this.getCarFPKSetupAPI().getPresetsService().isPredefinedPresetSelected()) {
                return;
            }
            int n2 = n == 1 ? 10883 : 10884;
            GenericASLList genericASLList = this.getAslListManager().getGenericASLList(n2);
            genericASLList.updateList(displayElements.getElements());
        }
    }

    @Override
    public DisplayElements getDisplayElements(int n) {
        return n == 1 ? this.display1Elements : this.display2Elements;
    }

    private DisplayElement[] createDefaultElements(int n) {
        DisplayElement[] displayElementArray = new DisplayElement[2];
        DCDisplayedAdditionalInfos dCDisplayedAdditionalInfos = new DCDisplayedAdditionalInfos(true, false);
        boolean bl = false;
        displayElementArray[0] = new DisplayElement(DisplayElements.getElementAslId(0), n, dCDisplayedAdditionalInfos, 0);
        displayElementArray[1] = new DisplayElement(DisplayElements.getElementAslId(0), n, dCDisplayedAdditionalInfos, 0);
        return displayElementArray;
    }
}

