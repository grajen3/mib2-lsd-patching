/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online;

import de.vw.mib.asl.api.navigation.ASLNavigationFactory;
import de.vw.mib.asl.api.navigation.ASLNavigationServices;
import de.vw.mib.asl.internal.online.OnlineCallCenterServiceController$1;
import de.vw.mib.asl.internal.online.states.OnlineCallCenterServiceTarget;
import de.vw.mib.log4mib.LogMessage;
import java.util.List;
import org.dsi.ifc.online.OperatorCallAddressEntry;
import org.dsi.ifc.online.OperatorCallResult;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.AddressData;

public class OnlineCallCenterServiceController {
    private final String _classname = super.getClass().getName();
    private final OnlineCallCenterServiceTarget target;
    private boolean active;
    private List operatorCallResults;
    private ASLNavigationServices navServices;
    private int navSuccessful = 0;
    private int navFailed = 0;

    public OnlineCallCenterServiceController(OnlineCallCenterServiceTarget onlineCallCenterServiceTarget) {
        this.target = onlineCallCenterServiceTarget;
    }

    private OnlineCallCenterServiceTarget getTarget() {
        return this.target;
    }

    public void requestPhoneNumberOfTheCallCenter(boolean bl) {
    }

    public void responseOperatorCallResult(int n, OperatorCallResult[] operatorCallResultArray) {
        if (this.getTarget().isTraceEnabled()) {
            LogMessage logMessage = this.getTarget().trace();
            logMessage.append(this._classname).append(".responseOperatorCallResult(").append(n).append(")").log();
        }
    }

    private ASLNavigationServices getNavServices() {
        if (this.navServices == null) {
            ASLNavigationFactory.getNavigationApi().getASLNavigationServices(new OnlineCallCenterServiceController$1(this));
        }
        return this.navServices;
    }

    private void relayResultsToNav() {
        if (!this.operatorCallResults.isEmpty()) {
            AdbEntry adbEntry = this.createAdbEntryFromOperatorCallResult((OperatorCallResult)this.operatorCallResults.remove(0));
            this.getNavServices().importContact(adbEntry, 1, true);
        } else {
            this.getNavServices().importContactSummary(this.navSuccessful, this.navFailed, 0, 1);
            this.navSuccessful = 0;
            this.navFailed = 0;
        }
    }

    private AdbEntry createAdbEntryFromOperatorCallResult(OperatorCallResult operatorCallResult) {
        AdbEntry adbEntry = new AdbEntry();
        adbEntry.combinedName = operatorCallResult.name;
        adbEntry.addressData = new AddressData[]{this.createAddressDataFromOperatorCallAddressEntry(operatorCallResult.address)};
        return adbEntry;
    }

    private AddressData createAddressDataFromOperatorCallAddressEntry(OperatorCallAddressEntry operatorCallAddressEntry) {
        AddressData addressData = new AddressData();
        addressData.country = operatorCallAddressEntry.country;
        addressData.locality = operatorCallAddressEntry.city;
        addressData.postalCode = operatorCallAddressEntry.zip;
        addressData.region = operatorCallAddressEntry.region;
        addressData.street = operatorCallAddressEntry.street;
        return addressData;
    }

    public void responseOperatorPhoneNumber(int n, String string, String[] stringArray, int n2) {
        if (this.getTarget().isTraceEnabled()) {
            LogMessage logMessage = this.getTarget().trace();
            logMessage.append(this._classname).append(".responseOperatorPhoneNumber(").append(n).append(", ").append(string).append(")").log();
        }
        boolean bl = false;
    }

    public void errorHandling(int n, int n2) {
        if (this.getTarget().isTraceEnabled()) {
            LogMessage logMessage = this.getTarget().trace();
            logMessage.append(this._classname).append(".errorHandling(").append(n).append(", ").append(n2).append(")").log();
        }
        if (n == 8304) {
            switch (n2) {
                case 1000: {
                    break;
                }
                case 1001: {
                    break;
                }
                case 1002: {
                    break;
                }
            }
        } else {
            switch (n) {
                case 8300: {
                    break;
                }
                case 8301: {
                    break;
                }
                case 8302: {
                    break;
                }
                case 8303: {
                    break;
                }
                case 8305: {
                    break;
                }
                case 10001: {
                    break;
                }
            }
        }
    }

    public boolean isActive() {
        return this.active;
    }

    public void setActive(boolean bl) {
        this.active = bl;
    }

    public void voiceCallResult() {
    }

    static /* synthetic */ int access$008(OnlineCallCenterServiceController onlineCallCenterServiceController) {
        return onlineCallCenterServiceController.navSuccessful++;
    }

    static /* synthetic */ int access$108(OnlineCallCenterServiceController onlineCallCenterServiceController) {
        return onlineCallCenterServiceController.navFailed++;
    }

    static /* synthetic */ void access$200(OnlineCallCenterServiceController onlineCallCenterServiceController) {
        onlineCallCenterServiceController.relayResultsToNav();
    }
}

