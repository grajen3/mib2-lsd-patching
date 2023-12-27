/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package de.vw.mib.asl.internal.internetbrowser.common;

import de.vw.mib.asl.api.navigation.ASLNavigationFactory;
import de.vw.mib.asl.api.navigation.ASLNavigationServices;
import de.vw.mib.asl.api.navigation.ASLNavigationServicesListener;
import de.vw.mib.asl.api.navigation.NavAddress;
import de.vw.mib.asl.api.online.ASLOnlineFactory;
import de.vw.mib.asl.api.online.servicebridge.ASLOnlineServiceBridgeFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.internetbrowser.IBrowserController;
import de.vw.mib.asl.internal.internetbrowser.common.EfiConstants;
import de.vw.mib.asl.internal.internetbrowser.common.EfiLinkHandler$1;
import de.vw.mib.asl.internal.internetbrowser.hasServiceBridge.BrowserServiceBridge;
import de.vw.mib.asl.internal.internetbrowser.states.IBrowserTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.has.HAS;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.util.Util;
import generated.de.vw.mib.has.containers.AddressContainer;
import generated.de.vw.mib.has.containers.ContactContainer;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public final class EfiLinkHandler
implements EfiConstants,
ASLNavigationServicesListener {
    static IBrowserTarget _target;
    private String actualEfiLink = "";
    String backUri = null;
    private String frameType2Set = null;
    private int contextID4ModelSwitch = -1;
    private double inputLat = 0.0;
    private double inputLon = 0.0;
    private boolean queueingFrameSwitch = false;
    final String _classname = super.getClass().getName();
    private static ASLNavigationServices navService;
    private static EfiLinkHandler efiHandler;

    public static EfiLinkHandler initializeEfiHandler(Logger logger) {
        if (efiHandler == null) {
            efiHandler = new EfiLinkHandler();
        }
        return efiHandler;
    }

    public void setTarget(IBrowserTarget iBrowserTarget) {
        _target = iBrowserTarget;
    }

    public void setSettings() {
        navService = ASLNavigationFactory.getNavigationApi().getASLNavigationServices(this);
    }

    IBrowserTarget getTarget() {
        return _target;
    }

    private IBrowserController getController() {
        return this.getTarget().getController();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void reportEfiLink(String string) {
        if (!Util.isNullOrEmpty(string)) {
            if (!string.toLowerCase().startsWith("action")) {
                if (!this.getTarget().isTraceEnabled()) return;
                LogMessage logMessage = _target.trace();
                logMessage.append(this._classname).append(" no valid efi link ").append(string).log();
                return;
            } else {
                int n = string.indexOf("?");
                if (n == -1) {
                    n = string.length();
                }
                String string2 = string.substring(string.indexOf(":") + 1, n);
                this.actualEfiLink = string;
                try {
                    this.findActionCommand(string2);
                    if (!this.getTarget().isTraceEnabled()) return;
                    LogMessage logMessage = _target.trace();
                    logMessage.append(this._classname).append(".reportEfiLink() Notify registered consumer of EFI link action '").append(string2).append("'").log();
                    return;
                }
                catch (Exception exception) {
                    LogMessage logMessage = _target.info();
                    logMessage.append(this._classname).append(".reportEfiLink() Extract EFI link failed [").append(string).append("]").log();
                    return;
                }
            }
        } else {
            LogMessage logMessage = _target.info();
            logMessage.append(this._classname).append(".reportEfiLink() Invalid EFI link").log();
        }
    }

    private void findActionCommand(String string) {
        if (this.getTarget().isTraceEnabled()) {
            LogMessage logMessage = _target.trace();
            logMessage.append(this._classname).append(" findActionCommand: ").append(string).log();
        }
        this.actualEfiLink = this.actualEfiLink.substring(this.actualEfiLink.indexOf(63) + 1);
        int n = _target.getController().getCurrentBrowserState();
        if (string.equals("open_url")) {
            try {
                this.actualEfiLink = this.actualEfiLink.substring(this.actualEfiLink.indexOf("url=") + "url=".length());
                this.actualEfiLink = URLDecoder.decode(this.actualEfiLink, "UTF-8");
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {
                _target.error().append(this._classname).append("EFI was not properly UTF-8 coded > ").append(this.actualEfiLink).log();
            }
            this.replaceEfiVariablesWhereNecessary();
            _target.getDSIBrowser().loadUrl(this.actualEfiLink);
        } else if (string.equals("quit") || string.indexOf("quit") > -1) {
            this.getController().getHMINotifier().sendWizardStatus(false);
        } else if (string.equals("open_wizard")) {
            int n2 = this.actualEfiLink.indexOf("paircode=");
            if (n2 > -1) {
                String string2 = null;
                int n3 = this.actualEfiLink.indexOf(61, n2) + 1;
                int n4 = this.actualEfiLink.indexOf(38);
                if (n4 == -1) {
                    n4 = this.actualEfiLink.length();
                }
                string2 = this.actualEfiLink.substring(n3, n4);
                if (_target.isTraceEnabled()) {
                    _target.trace().append(this._classname).append(new StringBuffer().append("CarNetPin = ").append(Util.isNullOrEmpty(string2) ? "NULL" : string2).toString()).log();
                }
                if (!Util.isNullOrEmpty(string2)) {
                    ASLOnlineFactory.getCarNetPinVerificationService().verifyCarNetPin(string2, new EfiLinkHandler$1(this));
                }
            }
        } else if (string.equals("use_address")) {
            try {
                this.actualEfiLink = URLDecoder.decode(this.actualEfiLink, "UTF-8");
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {
                _target.error().append(this._classname).append("EFI was not properly UTF-8 coded > ").append(this.actualEfiLink).log();
            }
            AddressContainer addressContainer = (AddressContainer)HAS.getInstance().getFactory().createContainer(1);
            this.extractInformationFromEfi(addressContainer, 1);
            ASLOnlineServiceBridgeFactory.getInstance().getServiceBridge().startGuidance(addressContainer);
        } else if (string.equals("use_phone_number")) {
            try {
                this.actualEfiLink = URLDecoder.decode(this.actualEfiLink, "UTF-8");
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {
                _target.error().append(this._classname).append("EFI was not properly UTF-8 coded > ").append(this.actualEfiLink).log();
            }
            ContactContainer contactContainer = (ContactContainer)HAS.getInstance().getFactory().createContainer(8);
            this.extractInformationFromEfi(contactContainer, 8);
            ASLOnlineServiceBridgeFactory.getInstance().getServiceBridge().callContact(contactContainer);
            if (this.getTarget().isTraceEnabled()) {
                LogMessage logMessage = _target.trace();
                logMessage.append(this._classname).append(" call contact ").append(contactContainer.getName()).append(" - ").append(contactContainer.getTelephoneNumber()).log();
            }
        } else if (!string.equals("tts_output")) {
            if (string.equals("request_location")) {
                this.getTarget().sendHMIEvent(-682751744);
                try {
                    this.actualEfiLink = this.actualEfiLink.substring(this.actualEfiLink.indexOf("url=") + "url=".length());
                    this.actualEfiLink = URLDecoder.decode(this.actualEfiLink, "UTF-8");
                    this.getController().setNavInputURL(this.actualEfiLink);
                }
                catch (UnsupportedEncodingException unsupportedEncodingException) {
                    _target.error().append(this._classname).append("EFI was not properly UTF-8 coded > ").append(this.actualEfiLink).log();
                }
            } else if (string.equals("set_frame_type")) {
                String string3 = null;
                int n5 = this.actualEfiLink.indexOf(61) + 1;
                int n6 = this.actualEfiLink.indexOf(38);
                if (n6 == -1) {
                    n6 = this.actualEfiLink.length();
                }
                this.frameType2Set = string3 = this.actualEfiLink.substring(n5, n6);
                if (n == 0) {
                    this.queueingFrameSwitch = true;
                } else {
                    this.queueingFrameSwitch = false;
                    if (string3.equals("MOS_MAIN_PAGE")) {
                        this.notifyHMIIsCurrentPageHome(true);
                        this.notifyHMICurrentFrameType(0);
                    } else if (string3.equals("MOS_MAIN_PAGE_MODELED_FRAME")) {
                        this.notifyHMIIsCurrentPageHome(false);
                        this.notifyHMICurrentFrameType(1);
                    } else if (string3.equals("MOS_WIZARD_PAGE")) {
                        this.notifyHMIIsCurrentPageHome(false);
                        this.notifyHMICurrentFrameType(2);
                    } else if (string3.equals("MOS_WIZARD_PAGE_WITH_HTML_FOOTER")) {
                        this.notifyHMIIsCurrentPageHome(false);
                        this.notifyHMICurrentFrameType(3);
                    } else {
                        LogMessage logMessage = _target.info();
                        logMessage.append(this._classname).append(" setFrameType failed due to unknown FRAME TYPE: ").append(string3).log();
                    }
                }
            } else if (string.equals("set_back_uri")) {
                int n7 = this.actualEfiLink.indexOf(61) + 1;
                int n8 = this.actualEfiLink.length();
                if (n8 == -1) {
                    n8 = this.actualEfiLink.length() - 1;
                }
                this.actualEfiLink = this.actualEfiLink.substring(n7, n8);
                this.replaceEfiVariablesWhereNecessary();
                this.setBackURI(this.actualEfiLink);
            } else if (string.equals("switch_context")) {
                String string4 = null;
                boolean bl = false;
                int n9 = -1;
                int n10 = this.actualEfiLink.indexOf(61) + 1;
                int n11 = this.actualEfiLink.indexOf(38);
                if (n11 == -1) {
                    n11 = this.actualEfiLink.length();
                } else {
                    n9 = this.parseSubCategory(this.actualEfiLink.substring(n11 + 1, this.actualEfiLink.length()));
                }
                string4 = this.actualEfiLink.substring(n10, n11);
                this.parseContext(string4);
                bl = n9 != -1 ? this.ckeckCategory(n9) : true;
                if (bl) {
                    _target.sendHMIEvent(-716306176);
                }
                if (this.getTarget().isTraceEnabled()) {
                    LogMessage logMessage = _target.trace();
                    logMessage.append(this._classname).append(" Context Switch is triggerd: ").append(string4).append(" - CategoryID: ").append(n9).log();
                }
            } else {
                LogMessage logMessage = _target.info();
                logMessage.append(this._classname).append(" no valid efi action: ").append(string).log();
            }
        }
        if (this.getTarget().isTraceEnabled()) {
            LogMessage logMessage = _target.trace();
            logMessage.append(this._classname).append(" new efi ").append(this.actualEfiLink).log();
        }
    }

    private void replaceEfiVariablesWhereNecessary() {
        int n = 0;
        int n2 = -1;
        String string = this.actualEfiLink.substring(this.actualEfiLink.indexOf(63) + 1);
        String string2 = "";
        n2 = string.indexOf(38);
        while (n2 != -1) {
            string2 = string.substring(n, n2);
            this.replaceEfiPlaceholdersWithData(string2);
            n = n2 + 1;
            n2 = string.indexOf(38, n2 + 1);
        }
        string2 = string.substring(n);
        this.replaceEfiPlaceholdersWithData(string2);
    }

    private void replaceEfiPlaceholdersWithData(String string) {
        StringBuffer stringBuffer = new StringBuffer(this.actualEfiLink.length());
        String string2 = "";
        try {
            string = string.substring(string.indexOf(36));
        }
        catch (Exception exception) {
            string2 = string;
        }
        int n = this.actualEfiLink.indexOf(string);
        if (n != 0) {
            stringBuffer.append(this.actualEfiLink.substring(0, n));
            if (string.equals("$(formDate)")) {
                string2 = BrowserServiceBridge.getBrowserServiceBridgeController().getFormatDate();
            } else if (string.equals("$(lan)")) {
                string2 = !Util.isNullOrEmpty(BrowserServiceBridge.getBrowserServiceBridgeController().getLanguageInfo()) ? BrowserServiceBridge.getBrowserServiceBridgeController().getLanguageInfo() : (!Util.isNullOrEmpty(this.getController().getCurrentLanguage()) ? this.getController().getCurrentLanguage() : "de_DE");
            } else if (string.equals("$(cur_lat)")) {
                string2 = BrowserServiceBridge.getBrowserServiceBridgeController().getCurrentLocation() != null ? Double.toString((double)BrowserServiceBridge.getBrowserServiceBridgeController().getCurrentLocation().getLatitude()) : Double.toString((double)0.0);
            } else if (string.equals("$(cur_lon)")) {
                string2 = BrowserServiceBridge.getBrowserServiceBridgeController().getCurrentLocation() != null ? Double.toString((double)BrowserServiceBridge.getBrowserServiceBridgeController().getCurrentLocation().getLongitude()) : Double.toString((double)0.0);
            } else if (string.equals("$(in_lat)")) {
                string2 = Double.toString((double)this.inputLat);
            } else if (string.equals("$(in_lon)")) {
                string2 = Double.toString((double)this.inputLon);
            } else if (string.equals("$(dest_lat)")) {
                string2 = BrowserServiceBridge.getBrowserServiceBridgeController().getDestinationLocation() != null ? Double.toString((double)BrowserServiceBridge.getBrowserServiceBridgeController().getDestinationLocation().getLatitude()) : Double.toString((double)0.0);
            } else if (string.equals("$(dest_lon)")) {
                string2 = BrowserServiceBridge.getBrowserServiceBridgeController().getDestinationLocation() != null ? Double.toString((double)BrowserServiceBridge.getBrowserServiceBridgeController().getDestinationLocation().getLongitude()) : Double.toString((double)0.0);
            } else if (string.equals("$(day)")) {
                switch (BrowserServiceBridge.getBrowserServiceBridgeController().getDayNightState()) {
                    case 0: {
                        string2 = "day";
                        break;
                    }
                    case 1: {
                        string2 = "night";
                        break;
                    }
                    default: {
                        string2 = "day";
                    }
                }
                string2 = new Integer(BrowserServiceBridge.getBrowserServiceBridgeController().getDayNightState()).toString();
            } else if (string.equals("$(formTime)")) {
                string2 = new Integer(BrowserServiceBridge.getBrowserServiceBridgeController().getFormatTime()).toString();
            } else if (string.equals("$(cur_heading)")) {
                string2 = Integer.toString(BrowserServiceBridge.getBrowserServiceBridgeController().getHeading());
            } else if (string.equals("$(hu_region)")) {
                string2 = "eu_rdw";
            } else if (string.equals("$(oem)")) {
                string2 = !Util.isNullOrEmpty(BrowserServiceBridge.getBrowserServiceBridgeController().getOriginalEquipmentManufacturer()) ? BrowserServiceBridge.getBrowserServiceBridgeController().getOriginalEquipmentManufacturer() : "vw";
            } else if (string.equals("$(rev)")) {
                string2 = "rev1";
            } else if (string.equals("$(unitDist)")) {
                string2 = !Util.isNullOrEmpty(BrowserServiceBridge.getBrowserServiceBridgeController().getUnitDistance()) ? BrowserServiceBridge.getBrowserServiceBridgeController().getUnitDistance() : "km";
            } else if (string.equals("$(unitFuel)")) {
                if (!Util.isNullOrEmpty(BrowserServiceBridge.getBrowserServiceBridgeController().getUnitFuelConsumption())) {
                    int n2 = BrowserServiceBridge.getBrowserServiceBridgeController().getUnitFuelConsumption().indexOf(47, 0);
                    if (n2 != -1) {
                        try {
                            string2 = URLEncoder.encode(BrowserServiceBridge.getBrowserServiceBridgeController().getUnitFuelConsumption(), "UTF-8");
                        }
                        catch (UnsupportedEncodingException unsupportedEncodingException) {
                            _target.error().append(this._classname).append(" unitFuel can't be encoded ").append(BrowserServiceBridge.getBrowserServiceBridgeController().getUnitFuelConsumption()).log();
                        }
                    } else {
                        string2 = BrowserServiceBridge.getBrowserServiceBridgeController().getUnitFuelConsumption();
                    }
                } else {
                    string2 = "l%2F100km";
                }
            } else if (string.equals("$(unitPress)")) {
                string2 = !Util.isNullOrEmpty(BrowserServiceBridge.getBrowserServiceBridgeController().getUnitPressure()) ? BrowserServiceBridge.getBrowserServiceBridgeController().getUnitPressure() : "bar";
            } else if (string.equals("$(unitTemp)")) {
                string2 = !Util.isNullOrEmpty(BrowserServiceBridge.getBrowserServiceBridgeController().getUnitTemperature()) ? BrowserServiceBridge.getBrowserServiceBridgeController().getUnitTemperature() : "C";
            } else if (string.equals("$(unitVel)")) {
                if (!Util.isNullOrEmpty(BrowserServiceBridge.getBrowserServiceBridgeController().getUnitVelocity())) {
                    int n3 = BrowserServiceBridge.getBrowserServiceBridgeController().getUnitVelocity().indexOf(47, 0);
                    if (n3 != -1) {
                        try {
                            string2 = URLEncoder.encode(BrowserServiceBridge.getBrowserServiceBridgeController().getUnitVelocity(), "UTF-8");
                        }
                        catch (UnsupportedEncodingException unsupportedEncodingException) {
                            _target.error().append(this._classname).append(" unitVelo can't be encoded ").append(BrowserServiceBridge.getBrowserServiceBridgeController().getUnitVelocity()).log();
                        }
                    } else {
                        string2 = BrowserServiceBridge.getBrowserServiceBridgeController().getUnitVelocity();
                    }
                } else {
                    string2 = "km%2Fh";
                }
            } else {
                string2 = string.equals("$(vin)") ? (!Util.isNullOrEmpty(BrowserServiceBridge.getBrowserServiceBridgeController().getVehicleIdentificationNumber()) ? BrowserServiceBridge.getBrowserServiceBridgeController().getVehicleIdentificationNumber() : "") : string;
            }
            stringBuffer.append(string2);
            stringBuffer.append(this.actualEfiLink.substring(n + string.length()));
            if (this.getTarget().isTraceEnabled()) {
                LogMessage logMessage = this.getTarget().trace();
                logMessage.append(this._classname).append("Efi Param: ").append(string.toString()).append(" with Value: ").append(string2.toString()).log();
            }
        } else {
            LogMessage logMessage = this.getTarget().info();
            logMessage.append(this._classname).append("NO EFI PARAMETERS OR NOT REQUIRED").log();
            stringBuffer.append(string2);
        }
        this.actualEfiLink = stringBuffer.toString();
    }

    private void parseContext(String string) {
        if (string.equals("TARGET_POI_SEARCH")) {
            this.contextID4ModelSwitch = 2;
        } else if (string.equals("TARGET_PERSONAL_POI")) {
            this.contextID4ModelSwitch = 4;
        } else if (string.equals("TARGET_DYNAMIC_POI")) {
            this.contextID4ModelSwitch = 3;
        } else if (string.equals("TARGET_DESTINATION_LIST")) {
            this.contextID4ModelSwitch = 5;
        } else if (string.equals("TARGET_TOUR_LIST")) {
            this.contextID4ModelSwitch = 6;
        }
        ServiceManager.aslPropertyManager.valueChangedInteger(-481425152, this.contextID4ModelSwitch);
    }

    private void extractInformationFromEfi(Object object, int n) {
        int n2 = 0;
        int n3 = -1;
        String string = this.actualEfiLink;
        String string2 = "";
        n3 = string.indexOf(38);
        while (n3 != -1) {
            string2 = string.substring(n2, n3);
            this.parseEfiVariableInGenericWay(object, string2, n);
            n2 = n3 + 1;
            n3 = string.indexOf(38, n3 + 1);
        }
        string2 = string.substring(n2);
        this.parseEfiVariableInGenericWay(object, string2, n);
    }

    void parseEfiVariableInGenericWay(Object object, String string, int n) {
        switch (n) {
            case 8: {
                if (string.startsWith("phone=")) {
                    ((ContactContainer)object).setTelephoneNumber(string.substring("phone=".length()));
                    break;
                }
                if (string.startsWith("name=")) {
                    ((ContactContainer)object).setName(string.substring("name=".length()));
                    break;
                }
                LogMessage logMessage = this.getTarget().info();
                logMessage.append(this._classname).append(".parseEfiVariableInGenericWay() EFI LINK variable not recognized for the phone contact: ").append(string).log();
                break;
            }
            case 1: {
                if (string.startsWith("city=")) {
                    ((AddressContainer)object).setCity(string.substring("city=".length()));
                    break;
                }
                if (string.startsWith("country=")) {
                    ((AddressContainer)object).setCountry(string.substring("country=".length()));
                    break;
                }
                if (string.startsWith("lat=")) {
                    ((AddressContainer)object).setLatitude(Double.parseDouble((String)string.substring("lat=".length())));
                    break;
                }
                if (string.startsWith("lon=")) {
                    ((AddressContainer)object).setLongitude(Double.parseDouble((String)string.substring("lon=".length())));
                    break;
                }
                if (string.startsWith("street=")) {
                    ((AddressContainer)object).setStreet(string.substring("street=".length()));
                    break;
                }
                if (string.startsWith("zip=")) {
                    ((AddressContainer)object).setZip(string.substring("zip=".length()));
                    break;
                }
                LogMessage logMessage = this.getTarget().info();
                logMessage.append(this._classname).append(".parseEfiVariableInGenericWay() EFI LINK variable not recognized for the address: ").append(string).log();
                break;
            }
            default: {
                LogMessage logMessage = this.getTarget().info();
                logMessage.append(this._classname).append(".parseEfiVariableInGenericWay() Unhandled container type: ").append(n).log();
                break;
            }
        }
    }

    public void notifyHMIIsCurrentPageHome(boolean bl) {
        this.getController().getHMINotifier().setCurrentPageHome(bl);
    }

    public void notifyHMICurrentFrameType(int n) {
        this.getController().getHMINotifier().setCurrentPageFrameType(n);
    }

    private int parseSubCategory(String string) {
        int n = string.indexOf(61) + 1;
        int n2 = string.indexOf(38);
        if (n2 == -1) {
            n2 = string.length();
        }
        int n3 = Integer.parseInt(string.substring(n, n2));
        return n3;
    }

    private boolean ckeckCategory(int n) {
        if (navService.isValidOnlinePoiCategory(n)) {
            ServiceManager.aslPropertyManager.valueChangedInteger(-498202368, n);
            return true;
        }
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(121522432);
        _target.sendSafe(eventGeneric);
        return false;
    }

    public void getLocationAndSendToBE() {
        this.getController().getHMINotifier().setCurrentPageLoadingState(0, "getLocationAndSendToBE.enter()");
        if (navService != null) {
            NavAddress navAddress = navService.getLocationInputAddress();
            if (navAddress != null && navAddress.isValid()) {
                this.inputLat = navAddress.getLatitudeDecimal();
                this.inputLon = navAddress.getLongitudeDecimal();
                this.actualEfiLink = this.getController().getNavInputURL();
                this.replaceEfiVariablesWhereNecessary();
                _target.getDSIBrowser().loadUrl(this.actualEfiLink);
                if (this.getTarget().isTraceEnabled()) {
                    LogMessage logMessage = _target.trace();
                    logMessage.append(this._classname).append("insert Location is valid: Lat = ").append(this.inputLat).append(" and Lon = ").append(this.inputLon).log();
                }
                return;
            }
            if (this.getTarget().isTraceEnabled()) {
                LogMessage logMessage = _target.trace();
                logMessage.append(this._classname).append("insert Location is not valid").log();
            }
        }
        this.getController().getHMINotifier().setCurrentPageLoadingState(4, "getLocationAndSendToBE.exit()");
    }

    @Override
    public void importContactResult(int n) {
    }

    @Override
    public void updateContactCapacity(int n) {
    }

    @Override
    public void updateGuidanceActive(boolean bl) {
    }

    @Override
    public void updateServiceAvailable(boolean bl) {
    }

    private void setBackURI(String string) {
        this.backUri = string;
    }

    public String getBackURI() {
        return this.backUri;
    }

    public boolean isFrameTypeSwitchingPending() {
        return this.queueingFrameSwitch;
    }

    public void setFrameTypeSwitchingQueue(boolean bl) {
        this.queueingFrameSwitch = bl;
    }

    public String getFrameType2Set() {
        return this.frameType2Set;
    }

    static /* synthetic */ IBrowserController access$000(EfiLinkHandler efiLinkHandler) {
        return efiLinkHandler.getController();
    }
}

