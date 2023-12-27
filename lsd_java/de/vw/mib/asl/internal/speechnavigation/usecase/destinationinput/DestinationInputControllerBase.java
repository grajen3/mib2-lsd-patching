/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.api.speechengine.result.handling.ResultListHandler;
import de.vw.mib.asl.api.speechengine.result.service.AdditionalDataService;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.DestinationInputService;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.NavigationDestinationInputServiceAdapter;
import de.vw.mib.asl.internal.speechnavigation.usecase.application.ApplicationVariant;
import de.vw.mib.asl.internal.speechnavigation.usecase.application.ApplicationVariantImpl;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.Framework;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.lists.ApplicationNBestListControllerBase;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.ViewModelItem;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.controller.DestinationInputDetailController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.DestinationInputJpnFormatter;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.speechnavigation.controller.destinationinput.transformer.SpeechNavigationControllerDestinationInputLocationCollector;

public abstract class DestinationInputControllerBase
extends ApplicationNBestListControllerBase {
    public static final int SYSTEM_SPEECH_NAVIGATION_CONTROLLER_DESTINATION_INPUT_VDE_NOT_SUPPORTED;
    public DestinationInputService destinationInputService = NavigationDestinationInputServiceAdapter.getService();
    protected final ApplicationVariant variantService = new ApplicationVariantImpl();

    protected DestinationInputControllerBase(AdditionalDataService additionalDataService, ResultListHandler resultListHandler) {
        super(additionalDataService, resultListHandler);
    }

    @Override
    public void onRecognizedEvent(int n) {
        switch (n) {
            case 1077141912: 
            case 1077141913: 
            case 1077141914: {
                DestinationInputDetailController.startGuidanceWithDetailView(this.destinationInputService.getCurrentInput());
                break;
            }
            default: {
                super.onRecognizedEvent(n);
            }
        }
    }

    @Override
    public int getListIdTopLevel() {
        return 1627927552;
    }

    @Override
    public int getListIdDetailLevel() {
        return 1644704768;
    }

    @Override
    public int getListIdSelectedItem() {
        return 1661481984;
    }

    @Override
    public void notifyGroupExpanded(int n) {
        if (n >= 0 && n < ListManager.getGenericASLList(this.getListIdTopLevel()).getDSIObjects().length) {
            ViewModelItem viewModelItem = (ViewModelItem)ListManager.getGenericASLList(this.getListIdTopLevel()).getDSIObjects()[n];
            Framework.updateUIValue(1594373120, viewModelItem.recognizedString);
        }
        super.notifyGroupExpanded(n);
    }

    public void notifyGroupExpandedOneshot(int n) {
        super.notifyGroupExpanded(n);
    }

    @Override
    public void notifyItemSelected() {
        ViewModelItem viewModelItem = (ViewModelItem)ListManager.getGenericASLList(this.getListIdSelectedItem()).getDSIObjects()[0];
        Framework.updateUIValue(1594373120, viewModelItem.recognizedString);
        super.notifyItemSelected();
    }

    public void notifyItemSelectedOneshot() {
        super.notifyItemSelected();
    }

    public void updateLocation(INavigationLocation iNavigationLocation) {
        SpeechNavigationControllerDestinationInputLocationCollector speechNavigationControllerDestinationInputLocationCollector = new SpeechNavigationControllerDestinationInputLocationCollector();
        speechNavigationControllerDestinationInputLocationCollector.speechnavigation_controller_destinationinput_location_country = this.validateValue(iNavigationLocation.getCountry());
        speechNavigationControllerDestinationInputLocationCollector.speechnavigation_controller_destinationinput_location_city = this.validateValue(iNavigationLocation.getTown());
        speechNavigationControllerDestinationInputLocationCollector.speechnavigation_controller_destinationinput_location_postal_code = this.validateValue(iNavigationLocation.getZipCode());
        speechNavigationControllerDestinationInputLocationCollector.speechnavigation_controller_destinationinput_location_street = this.validateValue(iNavigationLocation.getStreet());
        speechNavigationControllerDestinationInputLocationCollector.speechnavigation_controller_destinationinput_location_housenumber = this.validateValue(iNavigationLocation.getHousenumber());
        speechNavigationControllerDestinationInputLocationCollector.speechnavigation_controller_destinationinput_location_crossing = this.validateValue(iNavigationLocation.getJunction());
        speechNavigationControllerDestinationInputLocationCollector.speechnavigation_controller_destinationinput_location_country_code = this.validateValue(iNavigationLocation.getCountryAbbreviation());
        speechNavigationControllerDestinationInputLocationCollector.speechnavigation_controller_destinationinput_location_guideable = iNavigationLocation.isValid();
        speechNavigationControllerDestinationInputLocationCollector.speechnavigation_controller_destinationinput_location_province = this.validateValue(iNavigationLocation.getState());
        speechNavigationControllerDestinationInputLocationCollector.speechnavigation_controller_destinationinput_location_state = this.validateValue(iNavigationLocation.getState());
        speechNavigationControllerDestinationInputLocationCollector.speechnavigation_controller_destinationinput_location_prefecture = this.validateValue(iNavigationLocation.getPrefecture());
        speechNavigationControllerDestinationInputLocationCollector.speechnavigation_controller_destinationinput_location_municipality = this.validateValue(DestinationInputJpnFormatter.getCompleteMunicipality(iNavigationLocation));
        speechNavigationControllerDestinationInputLocationCollector.speechnavigation_controller_destinationinput_location_place = this.validateValue(iNavigationLocation.getPlace());
        speechNavigationControllerDestinationInputLocationCollector.speechnavigation_controller_destinationinput_location_chome = this.validateValue(iNavigationLocation.getChome());
        ListManager.getGenericASLList(1560818688).updateList(new SpeechNavigationControllerDestinationInputLocationCollector[]{speechNavigationControllerDestinationInputLocationCollector});
    }

    public ApplicationVariant getVariant() {
        return this.variantService;
    }

    @Override
    public void onActionNotAvailable() {
        Framework.fireUIEvent(-938986496);
    }

    private String validateValue(String string) {
        return string == null ? "" : string;
    }
}

