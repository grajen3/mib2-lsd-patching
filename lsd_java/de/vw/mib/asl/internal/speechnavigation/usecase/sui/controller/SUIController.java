/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.sui.controller;

import de.vw.mib.asl.api.speechengine.result.handling.ResultListHandler;
import de.vw.mib.asl.api.speechengine.result.router.ModelEventConsumer;
import de.vw.mib.asl.api.speechengine.result.router.RecognizedEventConsumer;
import de.vw.mib.asl.api.speechengine.result.service.AdditionalDataService;
import de.vw.mib.asl.internal.speechnavigation.usecase.application.ApplicationVariantImpl;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.Framework;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.lists.ApplicationNBestListControllerBase;
import de.vw.mib.asl.internal.speechnavigation.usecase.contacts.controller.NavigateContactXController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.oneshot.controller.DestinationInputOneshotJpnMainController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.oneshot.model.OneShotJpnModel;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.oneshot.controller.DestinationInputOneshotMainController;
import de.vw.mib.asl.internal.speechnavigation.usecase.onboardpoi.controller.OnboardPOIEnterPOIXController;
import de.vw.mib.asl.internal.speechnavigation.usecase.sui.model.SUIModel;
import de.vw.mib.genericevents.EventGeneric;
import generated.de.vw.mib.asl.internal.ListManager;

public class SUIController
extends ApplicationNBestListControllerBase
implements ModelEventConsumer,
RecognizedEventConsumer {
    public static final int RESUME_CMD_NAVIGATE_SUI;
    public static final int CMD_DLG_STATE_AGAIN_NBEST_SUI;

    public SUIController(AdditionalDataService additionalDataService, ResultListHandler resultListHandler) {
        super(additionalDataService, resultListHandler);
    }

    public static void navigateAsSUI() {
        Framework.fireEvent(1879447808);
    }

    @Override
    public int getListIdTopLevel() {
        return -2146946048;
    }

    @Override
    public int getListIdDetailLevel() {
        return -2130168832;
    }

    @Override
    public int getListIdSelectedItem() {
        return -2113391616;
    }

    @Override
    public void onEvent(EventGeneric eventGeneric) {
        int n = eventGeneric.getReceiverEventId();
        switch (n) {
            case 1640048: {
                super.onRequestItems();
                break;
            }
            default: {
                super.onEvent(eventGeneric);
            }
        }
    }

    @Override
    public void onRecognizedEvent(int n) {
        if (n == -1126091968) {
            this.onEnterSUIAgain();
        } else {
            super.onRecognizedEvent(n);
        }
    }

    @Override
    public void notifyAmbiguousItemsRequested() {
        Framework.fireUIEvent(604582912);
    }

    @Override
    public void notifyGroupExpanded(int n) {
        if (n >= 0 && n < ListManager.getGenericASLList(this.getListIdTopLevel()).getDSIObjects().length) {
            SUIModel sUIModel = (SUIModel)ListManager.getGenericASLList(this.getListIdTopLevel()).getDSIObjects()[n];
            Framework.updateUIValue(1594373120, sUIModel.getItemTitle());
        }
        super.notifyGroupExpanded(n);
    }

    @Override
    public void notifyItemSelected() {
        SUIModel sUIModel = (SUIModel)ListManager.getGenericASLList(this.getListIdSelectedItem()).getDSIObjects()[0];
        ApplicationVariantImpl applicationVariantImpl = new ApplicationVariantImpl();
        if (sUIModel.isContact()) {
            NavigateContactXController.selectContact(sUIModel.getContact());
        } else if (sUIModel.isPOICategory()) {
            OnboardPOIEnterPOIXController.selectPOICategory(sUIModel.getPOICategory());
        } else if (applicationVariantImpl.isJPNVariant()) {
            DestinationInputOneshotJpnMainController.selectSUIAddress((OneShotJpnModel)sUIModel.getAddress());
        } else {
            DestinationInputOneshotMainController.selectSUIAddress(sUIModel.getAddress());
        }
    }

    @Override
    public void notifyItemsRequested() {
        this.notifyItemSelected();
    }

    private void onEnterSUIAgain() {
        Framework.fireUIEvent(621360128);
    }
}

