/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.guidance.destination.details;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.api.speechengine.result.router.ModelEventConsumer;
import de.vw.mib.asl.api.speechengine.result.router.RecognizedEventConsumer;
import de.vw.mib.asl.internal.speechnavigation.common.AppLogger;
import de.vw.mib.asl.internal.speechnavigation.common.SpeechServices;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.guidance.GuidanceService;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.guidance.NavigationGuidanceServiceAdapter;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.map.NavigationMapServiceAdapter;
import de.vw.mib.asl.internal.speechnavigation.usecase.application.ApplicationVariant;
import de.vw.mib.asl.internal.speechnavigation.usecase.application.ApplicationVariantImpl;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.ApplicationErrorHandlerBase;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.Framework;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.actions.ActionInvoker;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.DestinationInputJpnFormatter;
import de.vw.mib.asl.internal.speechnavigation.usecase.guidance.actions.StartGuidanceAction;
import de.vw.mib.asl.internal.speechnavigation.usecase.guidance.destination.details.DestinationDetailController$1;
import de.vw.mib.asl.internal.speechnavigation.usecase.guidance.destination.details.DestinationDetailController$2;
import de.vw.mib.asl.internal.speechnavigation.usecase.guidance.destination.details.DestinationDetailListener;
import de.vw.mib.asl.internal.speechnavigation.usecase.guidance.destination.details.DestinationDetailListenerImpl;
import de.vw.mib.asl.internal.speechnavigation.usecase.guidance.destination.details.formatters.AddressFormatter;
import de.vw.mib.asl.internal.speechnavigation.usecase.guidance.destination.details.formatters.AddressFormatterImpl;
import de.vw.mib.genericevents.EventGeneric;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.speechnavigation.controller.destinationdetails.transformer.SpeechNavigationControllerDestinationDetailsDestinationDetailCollector;
import org.dsi.ifc.map.Rect;

public abstract class DestinationDetailController
extends ApplicationErrorHandlerBase
implements RecognizedEventConsumer,
ModelEventConsumer {
    protected final GuidanceService guidanceService;
    protected final ActionInvoker actionInvoker;
    protected final ApplicationVariant variantService;
    protected final DestinationDetailListener destinationInputListener;
    protected final AddressFormatter addressFormatter;
    protected INavigationLocation destinationDetail;

    protected DestinationDetailController(DestinationDetailListener destinationDetailListener) {
        this.destinationInputListener = destinationDetailListener;
        this.guidanceService = NavigationGuidanceServiceAdapter.getGuidanceService();
        this.addressFormatter = new AddressFormatterImpl();
        this.variantService = new ApplicationVariantImpl();
        this.actionInvoker = new ActionInvoker(SpeechServices.getDialogStateService());
    }

    protected DestinationDetailController() {
        this(new DestinationDetailListenerImpl());
    }

    @Override
    public void onEvent(EventGeneric eventGeneric) {
        int n = eventGeneric.getReceiverEventId();
        switch (n) {
            case 1077141898: {
                AppLogger.trace(this, new StringBuffer().append(".onEvent( event = CHANGE_MAP_WINDOW_SIZE [").append(eventGeneric.toString()).append("] )").toString());
                Rect rect = new Rect();
                rect.kordX = eventGeneric.getInt(0);
                rect.kordY = eventGeneric.getInt(1);
                rect.diffX = eventGeneric.getInt(3);
                rect.diffY = eventGeneric.getInt(2);
                if (this.destinationDetail == null) break;
                this.onMapCanvasChanged(this.destinationDetail, rect);
                break;
            }
            default: {
                AppLogger.error(this, new StringBuffer().append(".onEvent( event = ").append(eventGeneric.toString()).append(" ), is not handled.").toString());
            }
        }
    }

    @Override
    public void onRecognizedEvent(int n) {
        switch (n) {
            case 1077141838: 
            case 1077141840: {
                this.onConfirmStartGuidanceCommand();
                break;
            }
            case 1077141839: {
                this.onAbortStartGuidanceCommand();
                break;
            }
            case 1077141841: {
                this.onReEnterAddressCommand();
                break;
            }
            default: {
                AppLogger.error(new StringBuffer().append(super.getClass().getName()).append(".onRecognizedEvent( eventId = ").append(n).append("), is not handled.").toString());
            }
        }
    }

    protected void showDestinationAddressDetails(INavigationLocation iNavigationLocation, int n) {
        this.destinationDetail = iNavigationLocation;
        this.showDestinationAddressDetails(this.destinationDetail, null, n);
    }

    private void showDestinationAddressDetails(INavigationLocation iNavigationLocation, Rect rect, int n) {
        try {
            this.updateLocationAddressDetails(iNavigationLocation);
            NavigationMapServiceAdapter.getMapService().showAddressOnMap(new DestinationDetailController$1(this), iNavigationLocation, rect);
            Framework.fireUIEvent(n);
        }
        catch (NavigationServiceException navigationServiceException) {
            this.onActionFailed();
        }
    }

    private void onMapCanvasChanged(INavigationLocation iNavigationLocation, Rect rect) {
        try {
            NavigationMapServiceAdapter.getMapService().showAddressOnMap(new DestinationDetailController$2(this), iNavigationLocation, rect);
        }
        catch (NavigationServiceException navigationServiceException) {
            this.onActionFailed();
        }
    }

    @Override
    public void onActionNotAvailable() {
    }

    private void updateLocationAddressDetails(INavigationLocation iNavigationLocation) {
        SpeechNavigationControllerDestinationDetailsDestinationDetailCollector speechNavigationControllerDestinationDetailsDestinationDetailCollector = new SpeechNavigationControllerDestinationDetailsDestinationDetailCollector();
        speechNavigationControllerDestinationDetailsDestinationDetailCollector.speechnavigation_controller_destinationdetails_detail_c_home = DestinationDetailController.toString(iNavigationLocation.getChome());
        speechNavigationControllerDestinationDetailsDestinationDetailCollector.speechnavigation_controller_destinationdetails_detail_city = DestinationDetailController.toString(iNavigationLocation.getTown());
        speechNavigationControllerDestinationDetailsDestinationDetailCollector.speechnavigation_controller_destinationdetails_detail_district = DestinationDetailController.toString(iNavigationLocation.getDistrict());
        speechNavigationControllerDestinationDetailsDestinationDetailCollector.speechnavigation_controller_destinationdetails_detail_house_number = DestinationDetailController.toString(iNavigationLocation.getHousenumber());
        speechNavigationControllerDestinationDetailsDestinationDetailCollector.speechnavigation_controller_destinationdetails_detail_crossing = DestinationDetailController.toString(iNavigationLocation.getJunction());
        speechNavigationControllerDestinationDetailsDestinationDetailCollector.speechnavigation_controller_destinationdetails_detail_municipality = DestinationDetailController.toString(DestinationInputJpnFormatter.getCompleteMunicipality(iNavigationLocation));
        speechNavigationControllerDestinationDetailsDestinationDetailCollector.speechnavigation_controller_destinationdetails_detail_place = DestinationDetailController.toString(iNavigationLocation.getPlace());
        speechNavigationControllerDestinationDetailsDestinationDetailCollector.speechnavigation_controller_destinationdetails_detail_prefecture = DestinationDetailController.toString(iNavigationLocation.getPrefecture());
        speechNavigationControllerDestinationDetailsDestinationDetailCollector.speechnavigation_controller_destinationdetails_detail_state = DestinationDetailController.toString(iNavigationLocation.getState());
        speechNavigationControllerDestinationDetailsDestinationDetailCollector.speechnavigation_controller_destinationdetails_detail_street = DestinationDetailController.toString(iNavigationLocation.getStreet());
        speechNavigationControllerDestinationDetailsDestinationDetailCollector.speechnavigation_controller_destinationdetails_detail_town_ship = "tbd-township";
        speechNavigationControllerDestinationDetailsDestinationDetailCollector.speechnavigation_controller_destinationdetails_detail_zip = DestinationDetailController.toString(iNavigationLocation.getZipCode());
        speechNavigationControllerDestinationDetailsDestinationDetailCollector.speechnavigation_controller_destinationdetails_detail_address_for_fix_formatter = this.addressFormatter.toFixFormatter(iNavigationLocation);
        speechNavigationControllerDestinationDetailsDestinationDetailCollector.speechnavigation_controller_destinationdetails_short_address = this.addressFormatter.toShortAddressString(iNavigationLocation);
        String[] stringArray = this.addressFormatter.toLongAddressString(iNavigationLocation);
        speechNavigationControllerDestinationDetailsDestinationDetailCollector.speechnavigation_controller_destinationdetails_long_address_line1 = stringArray[0];
        speechNavigationControllerDestinationDetailsDestinationDetailCollector.speechnavigation_controller_destinationdetails_long_address_line2 = stringArray[1];
        speechNavigationControllerDestinationDetailsDestinationDetailCollector.speechnavigation_controller_destinationdetails_long_address = new StringBuffer().append(stringArray[0]).append(" ").append(stringArray[1]).toString();
        ListManager.getGenericASLList(1544041472).updateList(new SpeechNavigationControllerDestinationDetailsDestinationDetailCollector[]{speechNavigationControllerDestinationDetailsDestinationDetailCollector});
    }

    private void onConfirmStartGuidanceCommand() {
        this.destinationInputListener.onResetCounter();
        this.notifyStartGuidanceSucceeded();
        this.actionInvoker.invokeWhenSdsSessionEnds(new StartGuidanceAction(this.guidanceService, this.destinationDetail));
    }

    private void notifyStartGuidanceSucceeded() {
        Framework.fireUIEvent(1594373120);
    }

    private void onAbortStartGuidanceCommand() {
        this.notifyAbortStartGuidance();
    }

    protected void onReEnterAddressCommand() {
        this.destinationInputListener.onReEnterAddress(true);
    }

    private void notifyAbortStartGuidance() {
        Framework.fireUIEvent(1695036416);
    }

    private static String toString(String string) {
        return string != null && string.length() > 0 ? string : "";
    }
}

