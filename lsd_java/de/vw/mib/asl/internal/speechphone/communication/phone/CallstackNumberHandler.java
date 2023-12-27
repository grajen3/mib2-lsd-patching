/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechphone.communication.phone;

import de.vw.mib.asl.api.phone.PhoneService;
import de.vw.mib.asl.api.phone.model.PhoneNumber;
import de.vw.mib.asl.api.phone.services.callstack.CallstackEntry;
import de.vw.mib.asl.api.phone.services.callstack.CallstackService;
import de.vw.mib.asl.api.phone.services.callstack.CallstackUpdates;
import de.vw.mib.asl.api.speechengine.audio.AudioAccessor;
import de.vw.mib.asl.api.speechengine.messenger.dialog.DialogStateRouter;
import de.vw.mib.asl.api.speechengine.messenger.slot.SlotStateRouter;
import de.vw.mib.asl.api.speechengine.result.model.ResultItem;
import de.vw.mib.asl.api.speechengine.result.service.AdditionalDataService;
import de.vw.mib.asl.api.speechengine.result.service.AsyncCallback;
import de.vw.mib.asl.api.speechengine.result.service.DataService;
import de.vw.mib.asl.api.speechengine.slots.SlotEntry;
import de.vw.mib.asl.api.speechengine.slots.SlotUpdater;
import de.vw.mib.asl.internal.speechphone.communication.phone.ContactNumberHandler;
import de.vw.mib.asl.internal.speechphone.communication.phone.DialFunction;
import de.vw.mib.asl.internal.speechphone.communication.phone.DialHandler;
import de.vw.mib.asl.internal.speechphone.data.internal.CallstackEntryModel;
import de.vw.mib.asl.internal.speechphone.utils.ServiceFunctions;
import de.vw.mib.asl.internal.speechphone.utils.SpeechPhoneLogger2;
import de.vw.mib.collections.longs.LongObjectMap;
import de.vw.mib.collections.longs.LongObjectOptHashMap;
import java.util.ArrayList;
import java.util.List;

public class CallstackNumberHandler
extends ContactNumberHandler
implements CallstackUpdates,
DataService,
AdditionalDataService,
DialFunction {
    private final SpeechPhoneLogger2 logger;
    public static final int CALLSTACKTYPE_MIXED;
    public static final int CALLSTACKTYPE_MISSED;
    public static final int CALLSTACKTYPE_DIALED;
    public static final int CALLSTACKTYPE_ACCEPTED;
    public static final String[] CALLSTACKTYPE_TEXTS;
    private final SlotUpdater slotUpdater;
    private CallstackEntryModel[] mixedCallstack;
    private CallstackEntryModel[] missedCalls;
    private CallstackEntryModel[] dialedNumbers;
    private CallstackEntryModel[] acceptedCalls;
    private LongObjectMap callstackEntries = new LongObjectOptHashMap();
    private int slotStateMixed = -1;
    private int slotStateMissed = -1;
    private int slotStateDialed = -1;
    private int slotStateAccepted = -1;
    private int currentCallstackType = 0;
    private CallstackEntryModel lastSelectedItem;
    private DialHandler dialHandler;

    public CallstackNumberHandler(ServiceFunctions serviceFunctions, SlotStateRouter slotStateRouter, SlotUpdater slotUpdater, PhoneService phoneService, CallstackService callstackService, AudioAccessor audioAccessor, DialogStateRouter dialogStateRouter) {
        super(serviceFunctions, slotStateRouter, phoneService, audioAccessor);
        this.slotUpdater = slotUpdater;
        this.logger = serviceFunctions.createLogger("CallstackNumberHandler");
        callstackService.registerCallstackUpdates(this);
        slotStateRouter.register(80, this);
        slotStateRouter.register(30, this);
        slotStateRouter.register(31, this);
        slotStateRouter.register(33, this);
        slotStateRouter.register(32, this);
        this.dialHandler = new DialHandler(this, dialogStateRouter, this);
    }

    public void setCurrentCallstackType(int n) {
        this.currentCallstackType = n;
    }

    public int getCurrentCallstackType() {
        return this.currentCallstackType;
    }

    public int getCurrentUseCaseId() {
        if (this.currentCallstackType == 1) {
            return 8;
        }
        if (this.currentCallstackType == 2) {
            return 9;
        }
        if (this.currentCallstackType == 3) {
            return 10;
        }
        return 7;
    }

    public boolean isCurrentCallstackEmpty() {
        if (this.currentCallstackType == 1) {
            return this.missedCalls == null || this.missedCalls.length == 0;
        }
        if (this.currentCallstackType == 2) {
            return this.dialedNumbers == null || this.dialedNumbers.length == 0;
        }
        if (this.currentCallstackType == 3) {
            return this.acceptedCalls == null || this.acceptedCalls.length == 0;
        }
        return this.mixedCallstack == null || this.mixedCallstack.length == 0;
    }

    public boolean isCurrentCallstackCompiling() {
        if (this.currentCallstackType == 1) {
            return this.slotStateMissed == 2;
        }
        if (this.currentCallstackType == 2) {
            return this.slotStateDialed == 2;
        }
        if (this.currentCallstackType == 3) {
            return this.slotStateAccepted == 2;
        }
        return this.slotStateMixed == 2;
    }

    private boolean isCallstackContainingNames(CallstackEntryModel[] callstackEntryModelArray) {
        for (int i2 = 0; i2 < callstackEntryModelArray.length; ++i2) {
            if (!callstackEntryModelArray[i2].isContactInformationAvailable()) continue;
            if (this.logger.isTraceEnabled()) {
                this.logger.trace(new StringBuffer().append("Checked callstack ").append(CALLSTACKTYPE_TEXTS[this.currentCallstackType]).append(" contains names.").toString());
            }
            return true;
        }
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(new StringBuffer().append("Checked callstack ").append(CALLSTACKTYPE_TEXTS[this.currentCallstackType]).append(" does not contain names.").toString());
        }
        return false;
    }

    public boolean isCurrentCallstackContainingNames() {
        if (this.currentCallstackType == 1) {
            return this.isCallstackContainingNames(this.missedCalls);
        }
        if (this.currentCallstackType == 2) {
            return this.isCallstackContainingNames(this.dialedNumbers);
        }
        if (this.currentCallstackType == 3) {
            return this.isCallstackContainingNames(this.acceptedCalls);
        }
        return this.isCallstackContainingNames(this.mixedCallstack);
    }

    private boolean isCallstackContainingKnownNumbers(CallstackEntryModel[] callstackEntryModelArray) {
        for (int i2 = 0; i2 < callstackEntryModelArray.length; ++i2) {
            if (!callstackEntryModelArray[i2].isKnownNumber()) continue;
            if (this.logger.isTraceEnabled()) {
                this.logger.trace(new StringBuffer().append("Checked callstack ").append(CALLSTACKTYPE_TEXTS[this.currentCallstackType]).append(" contains known numbers.").toString());
            }
            return true;
        }
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(new StringBuffer().append("Checked callstack ").append(CALLSTACKTYPE_TEXTS[this.currentCallstackType]).append(" does not contain a known number.").toString());
        }
        return false;
    }

    public boolean isCurrentCallstackContainingKnownNumbers() {
        if (this.currentCallstackType == 1) {
            return this.isCallstackContainingKnownNumbers(this.missedCalls);
        }
        if (this.currentCallstackType == 2) {
            return this.isCallstackContainingKnownNumbers(this.dialedNumbers);
        }
        if (this.currentCallstackType == 3) {
            return this.isCallstackContainingKnownNumbers(this.acceptedCalls);
        }
        return this.isCallstackContainingKnownNumbers(this.mixedCallstack);
    }

    private String getFirstFoundContactNameOrNumber(CallstackEntryModel[] callstackEntryModelArray) {
        if (callstackEntryModelArray.length > 0) {
            String string = null;
            String string2 = null;
            for (int i2 = 0; i2 < callstackEntryModelArray.length; ++i2) {
                if (string == null && callstackEntryModelArray[i2].isKnownNumber()) {
                    string = callstackEntryModelArray[i2].getNumber();
                }
                if (callstackEntryModelArray[i2].isContactInformationAvailable() && callstackEntryModelArray[i2].isKnownNumber()) {
                    string2 = callstackEntryModelArray[i2].getName();
                }
                if (string2 == null) continue;
                if (this.logger.isTraceEnabled()) {
                    this.logger.trace(new StringBuffer().append("Found first name from ").append(CALLSTACKTYPE_TEXTS[this.currentCallstackType]).append(" for displaying: ").append(string2).toString());
                }
                return string2;
            }
            if (string != null) {
                if (this.logger.isTraceEnabled()) {
                    this.logger.trace(new StringBuffer().append("Found no name but first number from ").append(CALLSTACKTYPE_TEXTS[this.currentCallstackType]).append(" for displaying: ").append(string).toString());
                }
                return string;
            }
        }
        this.logger.warn(new StringBuffer().append("Found no name or number for displaying in ").append(CALLSTACKTYPE_TEXTS[this.currentCallstackType]).append(".").toString());
        return "";
    }

    public String getCurrentCallstackFirstFoundContactNameOrNumber() {
        if (this.currentCallstackType == 1) {
            return this.getFirstFoundContactNameOrNumber(this.missedCalls);
        }
        if (this.currentCallstackType == 2) {
            return this.getFirstFoundContactNameOrNumber(this.dialedNumbers);
        }
        if (this.currentCallstackType == 3) {
            return this.getFirstFoundContactNameOrNumber(this.acceptedCalls);
        }
        return this.getFirstFoundContactNameOrNumber(this.mixedCallstack);
    }

    public CallstackEntryModel getLastDialedNumber() {
        if (this.dialedNumbers != null && this.dialedNumbers.length > 0) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace(new StringBuffer().append("returning last dialed number, which is ").append(this.dialedNumbers[0].getNumber()).toString());
            }
            return this.dialedNumbers[0];
        }
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("returning a last dialed number not possible");
        }
        return null;
    }

    public void setLastSelectedItem(CallstackEntryModel callstackEntryModel) {
        this.lastSelectedItem = callstackEntryModel;
    }

    public void refillMixedList() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("Refilling mixed callstack list.");
        }
        if (!this.serviceFunctions.updateList(-1951843584, this.mixedCallstack)) {
            this.logger.error("ASL list for mixed callstack was null.");
        }
    }

    public void fillSelectedCallstackEntryIntoModel(CallstackEntryModel callstackEntryModel) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("Writing callstack entry into selected item for prompting.");
        }
        Object[] objectArray = new CallstackEntryModel[]{callstackEntryModel};
        if (!this.serviceFunctions.updateList(-1935066368, objectArray)) {
            this.logger.error("ASL list for selected callstack item was null.");
        }
    }

    public boolean isSpecialNumber() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("Checking if the callstack entry is a special number.");
        }
        PhoneNumber phoneNumber = this.lastSelectedItem.getPhoneNumber();
        this.numberToCall = phoneNumber.getNumber();
        return this.checkForSpecialNumber() != 0;
    }

    public void dialPreCheck() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("do the dial callstack entry precheck to check if it is a special number and maybe trigger special number call");
        }
        if (!this.isSpecialNumber()) {
            if (this.lastSelectedItem.isContactInformationAvailable() && (this.slotState == 1 || this.slotState == 4)) {
                if (this.logger.isTraceEnabled()) {
                    this.logger.trace("the chosen callstack entry is a normal number from a contact");
                }
                this.serviceFunctions.sendHMIEvent(-995542272);
            } else {
                if (this.logger.isTraceEnabled()) {
                    this.logger.trace("the chosen callstack entry is a normal number without a contact");
                }
                String string = this.lastSelectedItem.getNumber();
                String string2 = "";
                string2 = this.lastSelectedItem.getNumber().length() < 6 ? string : string.substring(0, 6);
                this.serviceFunctions.writeStringToDatapool(-1666630912, string2);
                this.serviceFunctions.sendHMIEvent(-1012319488);
            }
        } else {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("the chosen callstack entry was a special number");
            }
            this.triggerDialing();
        }
    }

    public void triggerDialing() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("Dialing the phone number from the contact entry.");
        }
        if (this.isPhoneAvailable() && !this.isSpecialNumberAndTriggerSystemEvents(this.lastSelectedItem.getPhoneNumber())) {
            this.dialHandler.handleDialing();
        }
    }

    @Override
    public void dial() {
        this.dialNumber(this.lastSelectedItem.getPhoneNumber());
    }

    private CallstackEntryModel[] updateCallstackList(List list, int n) {
        int n2 = n == 1 ? 31 : (n == 2 ? 33 : (n == 3 ? 32 : 30));
        CallstackEntryModel[] callstackEntryModelArray = new CallstackEntryModel[list.size()];
        ArrayList arrayList = new ArrayList();
        if (n == 0) {
            this.callstackEntries.clear();
        }
        for (int i2 = 0; i2 < list.size(); ++i2) {
            CallstackEntry callstackEntry = (CallstackEntry)list.get(i2);
            if (this.entryHasValidPhoneNumber(callstackEntry)) {
                if (this.entryHasValidName(callstackEntry)) {
                    arrayList.add(this.slotUpdater.createSlotEntry(callstackEntry.getCallstackId(), callstackEntry.getCombinedName()));
                    if (this.logger.isTraceEnabled()) {
                        this.logger.trace(new StringBuffer().append("... add callstack entry ").append(callstackEntry.getCallstackId()).append(" as ").append(callstackEntry.getCombinedName()).append(" to slot ").append(n2).toString());
                    }
                } else {
                    arrayList.add(this.slotUpdater.createSlotEntry(callstackEntry.getCallstackId(), callstackEntry.getPhoneNumber().getNumber()));
                    if (this.logger.isTraceEnabled()) {
                        this.logger.trace(new StringBuffer().append("... add callstack entry ").append(callstackEntry.getCallstackId()).append(" as ").append(callstackEntry.getPhoneNumber().getNumber()).append(" to slot ").append(n2).toString());
                    }
                }
            }
            if (n == 0) {
                this.callstackEntries.put(callstackEntry.getCallstackId(), callstackEntry);
            }
            callstackEntryModelArray[i2] = new CallstackEntryModel(callstackEntry);
        }
        Object[] objectArray = new SlotEntry[arrayList.size()];
        arrayList.toArray(objectArray);
        this.slotUpdater.updateSlotData(n2, 1, (SlotEntry[])objectArray);
        return callstackEntryModelArray;
    }

    private boolean entryHasValidPhoneNumber(CallstackEntry callstackEntry) {
        return callstackEntry.getPhoneNumber() != null && callstackEntry.getPhoneNumber().getNumber() != null && callstackEntry.getPhoneNumber().getNumber().length() > 0;
    }

    private boolean entryHasValidName(CallstackEntry callstackEntry) {
        return callstackEntry.getCombinedName() != null && !callstackEntry.getCombinedName().equals("");
    }

    @Override
    public void onUpdateMixed(List list) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(new StringBuffer().append("received a new ").append(CALLSTACKTYPE_TEXTS[0]).append(" and writes it into the slot").toString());
        }
        this.mixedCallstack = this.updateCallstackList(list, 0);
    }

    @Override
    public void onUpdateMissed(List list) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(new StringBuffer().append("received a new ").append(CALLSTACKTYPE_TEXTS[1]).append(" list and writes it into the slot").toString());
        }
        this.missedCalls = this.updateCallstackList(list, 1);
    }

    @Override
    public void onUpdateDialed(List list) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(new StringBuffer().append("received a new ").append(CALLSTACKTYPE_TEXTS[2]).append(" list and writes it into the slot").toString());
        }
        this.dialedNumbers = this.updateCallstackList(list, 2);
    }

    @Override
    public void onUpdateAccepted(List list) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(new StringBuffer().append("received a new ").append(CALLSTACKTYPE_TEXTS[3]).append(" list and writes it into the slot").toString());
        }
        this.acceptedCalls = this.updateCallstackList(list, 3);
    }

    @Override
    public void onSlotStateChanged(int n, int n2) {
        if (n == 80) {
            super.onSlotStateChanged(n, n2);
        } else if (n == 30) {
            this.slotStateMixed = n2;
            if (this.logger.isTraceEnabled()) {
                this.logger.trace(new StringBuffer().append("received new slotstate for ").append(CALLSTACKTYPE_TEXTS[0]).append(": ").append(n2).toString());
            }
        } else if (n == 31) {
            this.slotStateMissed = n2;
            if (this.logger.isTraceEnabled()) {
                this.logger.trace(new StringBuffer().append("received new slotstate for ").append(CALLSTACKTYPE_TEXTS[1]).append(": ").append(n2).toString());
            }
        } else if (n == 33) {
            this.slotStateDialed = n2;
            if (this.logger.isTraceEnabled()) {
                this.logger.trace(new StringBuffer().append("received new slotstate for ").append(CALLSTACKTYPE_TEXTS[2]).append(": ").append(n2).toString());
            }
        } else if (n == 32) {
            this.slotStateAccepted = n2;
            if (this.logger.isTraceEnabled()) {
                this.logger.trace(new StringBuffer().append("received new slotstate for ").append(CALLSTACKTYPE_TEXTS[3]).append(": ").append(n2).toString());
            }
        }
    }

    @Override
    public void getDataRequest(AsyncCallback asyncCallback) {
        if (this.currentCallstackType == 1) {
            asyncCallback.onResponse(this.missedCalls);
        } else if (this.currentCallstackType == 2) {
            asyncCallback.onResponse(this.dialedNumbers);
        } else if (this.currentCallstackType == 3) {
            asyncCallback.onResponse(this.acceptedCalls);
        } else {
            asyncCallback.onResponse(this.mixedCallstack);
        }
    }

    @Override
    public void getDataRequest(AsyncCallback asyncCallback, ResultItem[] resultItemArray) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("adding additional data for callstack nbest list");
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < resultItemArray.length; ++i2) {
            ResultItem resultItem = resultItemArray[i2];
            CallstackEntryModel callstackEntryModel = null;
            if (resultItem.isGroup()) {
                callstackEntryModel = new CallstackEntryModel(resultItem.getText(), resultItem.getSize());
            } else {
                CallstackEntry callstackEntry = (CallstackEntry)this.callstackEntries.get(resultItem.getIdentifier().getObjectId());
                if (callstackEntry == null) {
                    this.logger.error(new StringBuffer().append("tried to fetch callstack entry with id ").append(resultItem.getIdentifier().getObjectId()).append(" which does not exist anymore").toString());
                } else {
                    callstackEntryModel = new CallstackEntryModel(callstackEntry);
                }
            }
            if (callstackEntryModel == null) continue;
            arrayList.add(callstackEntryModel);
        }
        Object[] objectArray = new CallstackEntryModel[arrayList.size()];
        arrayList.toArray(objectArray);
        asyncCallback.onResponse(objectArray);
    }

    static {
        CALLSTACKTYPE_TEXTS = new String[]{"mixed callstack", "missed calls", "dialed numbers", "accepted calls"};
    }
}

