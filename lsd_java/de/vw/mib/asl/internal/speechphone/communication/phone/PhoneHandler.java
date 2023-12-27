/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechphone.communication.phone;

import de.vw.mib.asl.api.phone.PhoneService;
import de.vw.mib.asl.api.phone.callback.ContactlistUpdates;
import de.vw.mib.asl.api.phone.callback.PhoneConnectedUpdate;
import de.vw.mib.asl.api.speechengine.messenger.slot.SlotStateConsumer;
import de.vw.mib.asl.api.speechengine.messenger.slot.SlotStateRouter;
import de.vw.mib.asl.internal.speechphone.utils.ServiceFunctions;
import de.vw.mib.asl.internal.speechphone.utils.SpeechPhoneLogger2;

public class PhoneHandler
implements PhoneConnectedUpdate,
ContactlistUpdates,
SlotStateConsumer {
    private final SpeechPhoneLogger2 logger;
    protected PhoneService phoneService;
    private boolean phoneConnected;
    private int contactlistState;
    protected int slotState;
    protected final ServiceFunctions serviceFunctions;

    public PhoneHandler(ServiceFunctions serviceFunctions, SlotStateRouter slotStateRouter, PhoneService phoneService) {
        this.logger = serviceFunctions.createLogger("PhoneHandler");
        this.serviceFunctions = serviceFunctions;
        this.contactlistState = 0;
        this.phoneConnected = false;
        this.phoneService = phoneService;
        phoneService.registerPhoneConnectedUpdates(this);
        phoneService.registerContactlistUpdates(this);
    }

    private void deriveUsageOfDialContactGarbageCommand() {
        boolean bl = this.phoneConnected && this.contactlistState == 3 && (this.slotState == 1 || this.slotState == 4);
        this.serviceFunctions.writeBooleanToDatapool(1906916096, !bl);
        if (this.logger.isTraceEnabled()) {
            if (bl) {
                this.logger.trace("Now contact slot command is available");
            } else {
                this.logger.trace("Now contact garbage slot command is available");
            }
        }
    }

    public boolean isPhoneAvailable() {
        if (!this.phoneConnected) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("Phone availability request: phone is not available!!!");
            }
            this.serviceFunctions.sendHMIEvent(-1968620800);
        }
        return this.phoneConnected;
    }

    public boolean isPhoneAvailable(int n) {
        if (!this.phoneConnected) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("Phone availability request: phone is not available!!!");
            }
            this.serviceFunctions.writeIntegerToDatapool(2057911040, n);
            this.serviceFunctions.sendHMIEvent(-1968620800);
        }
        return this.phoneConnected;
    }

    public boolean areContactsAvailable() {
        switch (this.contactlistState) {
            case 1: {
                if (this.logger.isTraceEnabled()) {
                    this.logger.trace("Contact status request: The contactlist is currently being downloaded!!!");
                }
                this.serviceFunctions.sendHMIEvent(-1196868864);
                return false;
            }
            case 2: {
                if (this.logger.isTraceEnabled()) {
                    this.logger.trace("Contact status request: The contactlist is downloaded and deemed empty!!!");
                }
                this.serviceFunctions.sendHMIEvent(-1180091648);
                return false;
            }
            case 3: {
                switch (this.slotState) {
                    case 2: {
                        if (this.logger.isTraceEnabled()) {
                            this.logger.trace("Contact status request: The contactname slot state is compiling");
                        }
                        this.serviceFunctions.sendHMIEvent(-1146537216);
                        return false;
                    }
                    case 1: {
                        if (this.logger.isTraceEnabled()) {
                            this.logger.trace("Contact status request: The contactname slot state is available");
                        }
                        return true;
                    }
                    case 4: {
                        if (this.logger.isTraceEnabled()) {
                            this.logger.trace("Contact status request: The contactname slot state is partial available");
                        }
                        return true;
                    }
                }
                if (this.logger.isTraceEnabled()) {
                    this.logger.trace("Contact status request: The contactname slot state is somehow unavailable");
                }
                this.serviceFunctions.sendHMIEvent(-1129760000);
                return false;
            }
            case 4: {
                if (this.logger.isTraceEnabled()) {
                    this.logger.trace("Contact status request: The contactlist is downloaded, non-empty, but no contact has a phone number!!!");
                }
                this.serviceFunctions.sendHMIEvent(-1163314432);
                return false;
            }
        }
        this.logger.error("Contact status request: no contactlist constant matches !?!");
        return false;
    }

    @Override
    public void onChange(boolean bl) {
        if (this.logger.isTraceEnabled()) {
            if (bl) {
                this.logger.trace("phone was connected");
            } else {
                this.logger.trace("phone was disconnected, sending disattached system event");
            }
        }
        this.phoneConnected = bl;
        if (!bl) {
            this.serviceFunctions.sendHMIEvent(-1901511936);
        }
        this.deriveUsageOfDialContactGarbageCommand();
    }

    @Override
    public void onDownloadStatus(int n) {
        if (this.logger.isTraceEnabled()) {
            switch (n) {
                case 1: {
                    this.logger.trace("The contactlist is currently being downloaded.");
                    break;
                }
                case 2: {
                    this.logger.trace("The contactlist is downloaded and deemed empty.");
                    break;
                }
                case 3: {
                    this.logger.trace("The contactlist is downloaded, at least one contact has a phone number.");
                    break;
                }
                case 4: {
                    this.logger.trace("The contactlist is downloaded, non-empty, but no contact has a phone number.");
                    break;
                }
                default: {
                    this.logger.error("No contactlist constant matches !?!");
                }
            }
        }
        this.contactlistState = n;
        this.deriveUsageOfDialContactGarbageCommand();
    }

    @Override
    public void onSlotStateChanged(int n, int n2) {
        this.slotState = n2;
        switch (n2) {
            case 1: {
                this.serviceFunctions.writeIntegerToDatapool(2007579392, 0);
                break;
            }
            case 4: {
                this.serviceFunctions.writeIntegerToDatapool(2007579392, 1);
                break;
            }
            default: {
                this.serviceFunctions.writeIntegerToDatapool(2007579392, 2);
            }
        }
        this.deriveUsageOfDialContactGarbageCommand();
        if (this.logger.isTraceEnabled()) {
            String string = Integer.toString(n);
            switch (n2) {
                case -1: {
                    this.logger.trace(new StringBuffer().append("The slot (ID").append(string).append(") state is unknown").toString());
                    break;
                }
                case 1: {
                    this.logger.trace(new StringBuffer().append("The slot (ID").append(string).append(") state is available").toString());
                    break;
                }
                case 2: {
                    this.logger.trace(new StringBuffer().append("The slot (ID").append(string).append(") state is compiling").toString());
                    break;
                }
                case 3: {
                    this.logger.trace(new StringBuffer().append("The slot (ID").append(string).append(") state is unavailable").toString());
                    break;
                }
                case 4: {
                    this.logger.trace(new StringBuffer().append("The slot (ID").append(string).append(") state has a partial compilation failure").toString());
                    break;
                }
                case 5: {
                    this.logger.trace(new StringBuffer().append("The slot (ID").append(string).append(") state has a complete compilation failure").toString());
                    break;
                }
            }
        }
    }
}

