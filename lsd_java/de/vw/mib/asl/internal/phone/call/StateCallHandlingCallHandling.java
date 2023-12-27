/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.call;

import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.phone.ASLPhoneData;
import de.vw.mib.asl.internal.phone.call.DialSpellerCacheItem;
import de.vw.mib.asl.internal.phone.call.HsmPhoneCallHandling;
import de.vw.mib.asl.internal.phone.call.SpellerBlockItem;
import de.vw.mib.asl.internal.phone.call.transformer.PhoneCallInformationCollector;
import de.vw.mib.asl.internal.phone.util.PhoneUtil;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.properties.values.SpellerData;
import de.vw.mib.util.Util;
import generated.de.vw.mib.asl.internal.ListManager;
import java.util.ArrayList;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.DataSet;
import org.dsi.ifc.organizer.PhoneData;

public class StateCallHandlingCallHandling
extends AbstractHsmState {
    private final HsmPhoneCallHandling target;
    private static final int EV_ASL_INT_RESP_GET_ENTRY_RESULT;
    private static final int EV_ASL_INT_RESP_GET_CALL_CONTACT_RESULT;
    private boolean spellerUsableBySpellerResult = false;
    private final ArrayList spellerCachedActions = new ArrayList();
    SpellerData spellerData = null;
    int spellerActionsToBeDone = 0;
    private String lastDeliveredValidChars = "";
    private int invalidlyEnteredCharactersAmount = 0;
    private int lastDeliveredTotalHits = 0;
    private String charsToAdd = "";
    public static String selectedNumber;

    public StateCallHandlingCallHandling(HsmPhoneCallHandling hsmPhoneCallHandling, GenericEvents genericEvents, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = hsmPhoneCallHandling;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 1073742768: {
                if (this.target.spellerHandle != -1 && this.target.spellerHandle != -2) {
                    if (this.target.isMatchingAvailableLastSetByModel) {
                        this.target.dsiAdbListTelephone.stopSpeller(this.target.spellerHandle);
                    }
                    this.target.spellerHandle = -1;
                }
                this.target.stopTimer(-1601830656);
                this.target.isMatchingAvailable = false;
                break;
            }
            case 1073742771: {
                this.handleSpellerClear();
                break;
            }
            case 0x40000AA4: {
                String string = PhoneUtil.filterWidgetMarkers(eventGeneric.getString(0));
                this.target.isMatchingAvailableLastSetByModel = this.target.isMatchingAvailable = eventGeneric.getBoolean(1);
                this.target.spellerSelectionStart = 0;
                this.target.spellerSelectionEnd = 0;
                if (Util.isNullOrEmpty(string) || this.spellerData != null && !string.equals(this.spellerData.getEnteredText())) {
                    ListManager.getGenericASLList(1169).updateList(new Object[0]);
                    ListManager.getGenericASLList(1168).updateList(new Object[0]);
                    PhoneUtil.updateShortDialMatchingSize(0);
                }
                this.initSpeller(string);
                break;
            }
            case 1073742773: {
                this.selectNumber(this.spellerData.getEnteredText(), false);
                break;
            }
            case 1073742778: {
                String string = eventGeneric.getString(0);
                this.handleSpellerSetCharacterBlock(string, true, true);
                break;
            }
            case 1075141843: {
                String string = eventGeneric.getString(0);
                if (this.target.spellerSelectionStart == this.target.spellerSelectionEnd) {
                    this.handleSpellerSetCharacterBlock(string, true, true);
                } else {
                    EventGeneric eventGeneric2 = ServiceManager.mGenericEventFactory.newEvent(this.target.getTargetId(), this.target.getTargetId(), -1325203392, -1325203392);
                    this.target.send(eventGeneric2);
                    eventGeneric2 = ServiceManager.mGenericEventFactory.newEvent(this.target.getTargetId(), this.target.getTargetId(), -748939968, -748939968);
                    eventGeneric2.setString(0, string);
                    eventGeneric2.setInt(1, 0);
                    eventGeneric2.setInt(2, 0);
                    this.target.send(eventGeneric2);
                }
                this.target.spellerSelectionStart = eventGeneric.getInt(1);
                this.target.spellerSelectionEnd = eventGeneric.getInt(2);
                break;
            }
            case 1075141835: {
                boolean bl = eventGeneric.getBoolean(0);
                AbstractASLHsmTarget.writeBooleanToDatapool(1127358464, bl);
                break;
            }
            case 1073742776: {
                String string = eventGeneric.getString(0);
                this.handleSpellerSetCharacterBlock(string, true, true);
                break;
            }
            case 1073742769: {
                this.handleSpellerDeleteCharacter();
                break;
            }
            case 1073742770: {
                this.handleSpellerDeleteCharacterBlock();
                break;
            }
            case 1080441846: {
                this.selectNumber(eventGeneric.getString(0), true);
                break;
            }
            case 1073742761: {
                this.selectNumber(eventGeneric.getString(0), false);
                break;
            }
            case 1073742777: {
                int n = eventGeneric.getInt(0);
                if (n > this.spellerData.getEnteredText().length()) {
                    n = this.spellerData.getEnteredText().length();
                }
                this.target.spellerSelectionStart = n;
                this.target.spellerSelectionEnd = n;
                this.spellerData.setCursorPosition(n);
                AbstractASLHsmTarget.writeSpellerDataToDatapool(1163, this.spellerData);
                break;
            }
            case 1073742765: {
                int n = eventGeneric.getInt(0);
                PhoneCallInformationCollector phoneCallInformationCollector = (PhoneCallInformationCollector)ListManager.getGenericASLList(1160).getRowItem(n);
                PhoneUtil.getContactsDetails(this.target, 5254, -796458752, phoneCallInformationCollector.callInformation.telRemEntryId, true);
                break;
            }
            case 1073742760: {
                int n = eventGeneric.getInt(0);
                PhoneCallInformationCollector phoneCallInformationCollector = (PhoneCallInformationCollector)ListManager.getGenericASLList(1158).getRowItem(n);
                PhoneUtil.getContactsDetails(this.target, 5254, -796458752, phoneCallInformationCollector.callInformation.telRemEntryId, true);
                break;
            }
            case 100304: {
                AdbEntry adbEntry = (AdbEntry)eventGeneric.getObject(1);
                PhoneUtil.updateSelectedContactData(adbEntry, this.target);
                break;
            }
            case 1073742767: {
                boolean bl;
                int n = eventGeneric.getInt(0);
                DataSet dataSet = (DataSet)ListManager.getGenericASLList(1169).getRowItem(n);
                boolean bl2 = bl = !ListManager.getGenericASLList(1169).getListTransformer().getBoolean(4, ListManager.getGenericASLList(1169).getRowItem(n));
                if (!bl) {
                    ListManager.getGenericASLList(1168).updateList(new PhoneData[0]);
                    PhoneUtil.getContactsDetails(this.target, 5261, -813235968, dataSet.getEntryId(), true);
                    break;
                }
                ASLPhoneData.getInstance().dataSetContactsCached = dataSet;
                AbstractASLHsmTarget.writeStringToDatapool(1151, dataSet.getGeneralDescription2());
                break;
            }
            case 100303: {
                AdbEntry adbEntry;
                if (eventGeneric.getResult() != 0) break;
                ASLPhoneData.getInstance().adbEntryContactsCached = adbEntry = (AdbEntry)eventGeneric.getObject(1);
                ListManager.getGenericASLList(1168).updateList(PhoneUtil.ripADBPhoneData(adbEntry.phoneData));
                PhoneUtil.updateSelectedContactData(adbEntry, this.target);
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    private void selectNumber(String string, boolean bl) {
        HsmPhoneCallHandling.selectNumberHappenedBeforeDial = true;
        selectedNumber = string;
        if (this.target.isTraceEnabled()) {
            this.target.trace().append("select number received with number: ").append(selectedNumber).log();
        }
        PhoneUtil.checkNumber(selectedNumber, bl);
    }

    private void initSpeller(String string) {
        this.spellerActionsToBeDone = 1;
        this.spellerUsableBySpellerResult = !this.target.isMatchingAvailable;
        this.lastDeliveredValidChars = "";
        this.invalidlyEnteredCharactersAmount = 0;
        this.setSpellerData(string);
        if (this.target.isMatchingAvailable) {
            this.target.dsiAdbListTelephone.startSpeller(1, 20, 4);
            this.spellerUsableBySpellerResult = false;
            this.target.spellerHandle = -2;
        }
    }

    private void handleSpellerDeleteCharacter() {
        boolean bl = false;
        if (!Util.isNullOrEmpty(this.spellerData.getEnteredText())) {
            boolean bl2 = ((SpellerBlockItem)this.target.spellerBlocks.get((int)(this.target.spellerBlocks.size() - 1))).knownToApplication;
            if (this.spellerUsableBySpellerResult) {
                String string;
                if (bl2) {
                    if (this.invalidlyEnteredCharactersAmount == 0) {
                        ++this.spellerActionsToBeDone;
                        if (this.spellerData.getCursorPosition() < this.spellerData.getEnteredText().length()) {
                            this.target.isMatchingAvailable = false;
                            PhoneUtil.updateShortDialMatchingSize(0);
                            AbstractASLHsmTarget.writeBooleanToDatapool(-310176512, true);
                        }
                        if (this.target.isMatchingAvailable) {
                            this.target.dsiAdbListTelephone.removeSpellerChar(this.target.spellerHandle);
                            bl = true;
                            this.spellerUsableBySpellerResult = false;
                            AbstractASLHsmTarget.writeBooleanToDatapool(-310176512, false);
                        }
                    } else {
                        if (this.target.isMatchingAvailable && --this.invalidlyEnteredCharactersAmount == 0) {
                            PhoneUtil.updateShortDialMatchingSize(this.lastDeliveredTotalHits);
                        }
                        if (this.spellerData.getCursorPosition() > 0 && this.spellerData.getCursorPosition() < this.spellerData.getEnteredText().length()) {
                            PhoneUtil.updateShortDialMatchingSize(0);
                            AbstractASLHsmTarget.writeBooleanToDatapool(-310176512, true);
                        }
                    }
                }
                if (this.target.spellerBlocks.size() > 0) {
                    if (((SpellerBlockItem)this.target.spellerBlocks.get((int)(this.target.spellerBlocks.size() - 1))).text.length() > 1) {
                        string = ((SpellerBlockItem)this.target.spellerBlocks.get((int)(this.target.spellerBlocks.size() - 1))).text;
                        this.target.spellerBlocks.remove(this.target.spellerBlocks.get(this.target.spellerBlocks.size() - 1));
                        for (int i2 = 0; i2 < string.length() - 1; ++i2) {
                            this.target.spellerBlocks.add(new SpellerBlockItem(string.substring(i2, i2 + 1), bl2));
                        }
                    } else if (this.spellerData.getCursorPosition() > 0) {
                        this.target.spellerBlocks.remove(this.target.spellerBlocks.size() - 1);
                    }
                }
                string = this.spellerData.getEnteredText();
                String string2 = "";
                if (this.spellerData.getCursorPosition() > 0) {
                    string2 = new StringBuffer().append(string.substring(0, this.spellerData.getCursorPosition() - 1)).append(string.substring(this.spellerData.getCursorPosition(), this.spellerData.getEnteredText().length())).toString();
                    this.spellerData.setEnteredText(string2);
                    this.spellerData.setCursorPosition(this.spellerData.getCursorPosition() - 1);
                }
                this.spellerData.setSelectionStart(0);
                this.spellerData.setSelectionEnd(0);
                if (!this.target.isMatchingAvailable && this.target.isMatchingAvailableLastSetByModel && Util.isNullOrEmpty(this.spellerData.getEnteredText())) {
                    this.target.isMatchingAvailable = this.target.isMatchingAvailableLastSetByModel;
                    this.initSpeller("");
                }
                AbstractASLHsmTarget.writeSpellerDataToDatapool(1163, this.spellerData);
            } else {
                this.spellerCachedActions.add(new DialSpellerCacheItem(2, new SpellerBlockItem(" ", bl2), true));
                bl = true;
            }
            if (this.target.isTraceEnabled()) {
                this.target.trace().append("DialSpellerString: ").append(this.spellerData.getEnteredText()).append(" (DeleteCharacter)").log();
            }
        }
        if (!bl) {
            this.handleNextQueuedItem();
        }
    }

    private void handleSpellerDeleteCharacterBlock() {
        boolean bl = false;
        if (!Util.isNullOrEmpty(this.spellerData.getEnteredText())) {
            if (this.spellerUsableBySpellerResult) {
                this.target.spellerBlocks.remove(this.target.spellerBlocks.size() - 1);
                this.trans(this.target.stateCallHandlingReinitializeSpeller);
                EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(5254, 5254, -1341980608);
                this.target.send(eventGeneric);
                bl = true;
            } else {
                DialSpellerCacheItem dialSpellerCacheItem = new DialSpellerCacheItem(2, (SpellerBlockItem)this.target.spellerBlocks.get(this.target.spellerBlocks.size() - 1), true);
                this.spellerCachedActions.add(dialSpellerCacheItem);
                bl = true;
                if (this.target.isTraceEnabled()) {
                    this.target.trace().append("Speller action not executed immediately, caching: ").append(dialSpellerCacheItem).log();
                }
            }
        }
        if (!bl) {
            this.handleNextQueuedItem();
        }
    }

    private void handleSpellerClear() {
        if (this.spellerData != null && !Util.isNullOrEmpty(this.spellerData.getEnteredText())) {
            if (this.target.isTraceEnabled()) {
                this.target.trace("StateCallHandlingCallHandling.handleSpellerClear()");
            }
            this.target.spellerBlocks.clear();
            this.target.spellerSelectionStart = 0;
            this.target.spellerSelectionEnd = 0;
            this.spellerCachedActions.clear();
            this.lastDeliveredValidChars = "";
            this.invalidlyEnteredCharactersAmount = 0;
            this.trans(this.target.stateCallHandlingReinitializeSpeller);
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(5254, 5254, -1341980608);
            this.target.send(eventGeneric);
        }
    }

    private void handleSpellerSetCharacterBlock(String string, boolean bl, boolean bl2) {
        boolean bl3 = false;
        String string2 = "";
        for (int i2 = 0; i2 < string.length(); ++i2) {
            if (string.charAt(i2) == ' ') continue;
            string2 = new StringBuffer().append(string2).append(string.charAt(i2)).toString();
        }
        if (this.spellerData.getCursorPosition() < this.spellerData.getEnteredText().length()) {
            AbstractASLHsmTarget.writeBooleanToDatapool(-310176512, true);
            this.target.isMatchingAvailable = false;
            this.target.dsiAdbListTelephone.stopSpeller(this.target.spellerHandle);
        } else {
            AbstractASLHsmTarget.writeBooleanToDatapool(-310176512, !this.target.isMatchingAvailable);
        }
        if (this.target.isTraceEnabled()) {
            this.target.trace().append("StateCallHandlingCallHandling.handleSpellerSetCharacterBlock() spellerUsableBySpellerResult: ").append(this.spellerUsableBySpellerResult).log();
        }
        if (this.spellerUsableBySpellerResult) {
            if (string2.length() > 0) {
                if (bl) {
                    this.charsToAdd = new StringBuffer().append(this.charsToAdd).append(string2).toString();
                    bl3 = this.addAnotherCharToSpellerIfAvailable();
                }
                if (bl2) {
                    this.target.spellerBlocks.add(new SpellerBlockItem(string2, bl));
                }
            }
            String string3 = this.spellerData.getEnteredText().substring(0, this.spellerData.getCursorPosition());
            String string4 = this.spellerData.getEnteredText().substring(this.spellerData.getCursorPosition(), this.spellerData.getEnteredText().length());
            this.spellerData.setEnteredText(new StringBuffer().append(string3).append(string2).append(string4).toString());
            this.spellerData.setCursorPosition(string3.length() + string2.length());
            this.spellerData.setSelectionStart(this.target.spellerSelectionStart);
            this.spellerData.setSelectionEnd(this.target.spellerSelectionEnd);
            AbstractASLHsmTarget.writeSpellerDataToDatapool(1163, this.spellerData);
            if (this.target.isTraceEnabled()) {
                this.target.trace().append("DialSpellerString: ").append(this.spellerData.getEnteredText()).append(" (SetCharacterBlock)").log();
            }
        } else {
            DialSpellerCacheItem dialSpellerCacheItem = new DialSpellerCacheItem(1, new SpellerBlockItem(string, bl), bl2);
            this.spellerCachedActions.add(dialSpellerCacheItem);
            bl3 = true;
            if (this.target.isTraceEnabled()) {
                this.target.trace().append("Speller action not executed immediately, caching: ").append(dialSpellerCacheItem).log();
            }
        }
        if (!bl3) {
            this.handleNextQueuedItem();
        }
    }

    private void setSpellerData(String string) {
        this.spellerData = new SpellerData();
        String string2 = "";
        boolean bl = false;
        for (int i2 = 0; i2 < this.target.spellerBlocks.size(); ++i2) {
            string2 = new StringBuffer().append(string2).append(((SpellerBlockItem)this.target.spellerBlocks.get((int)i2)).text).toString();
        }
        if (!string2.equals(string)) {
            this.target.spellerBlocks.clear();
            bl = true;
        }
        if (string.length() > 0) {
            this.handleSpellerSetCharacterBlock(string, true, bl);
        } else {
            this.spellerData.setSelectionStart(this.target.spellerSelectionStart);
            this.spellerData.setSelectionEnd(this.target.spellerSelectionEnd);
            AbstractASLHsmTarget.writeSpellerDataToDatapool(1163, this.spellerData);
            if (this.target.isTraceEnabled()) {
                this.target.trace().append("DialSpellerString: ").append(this.spellerData.getEnteredText()).append(" (setSpellerData)").log();
            }
        }
    }

    private boolean addAnotherCharToSpellerIfAvailable() {
        if (this.charsToAdd.length() > 0) {
            int n;
            boolean bl = false;
            String string = this.lastDeliveredValidChars.toUpperCase();
            String string2 = this.charsToAdd.toUpperCase();
            for (n = 0; this.invalidlyEnteredCharactersAmount == 0 && n < this.lastDeliveredValidChars.length(); n += 1) {
                if (string.charAt(n) != string2.charAt(0)) continue;
                bl = true;
            }
            if (bl) {
                ++this.spellerActionsToBeDone;
                n = 0;
                if (this.spellerData.getCursorPosition() != this.spellerData.getEnteredText().length()) {
                    this.target.isMatchingAvailable = false;
                    PhoneUtil.updateShortDialMatchingSize(0);
                }
                if (this.target.isMatchingAvailable) {
                    this.target.dsiAdbListTelephone.addSpellerChars(this.target.spellerHandle, this.charsToAdd.substring(0, 1));
                    this.spellerUsableBySpellerResult = false;
                    n = 1;
                }
                this.charsToAdd = this.charsToAdd.substring(1);
                return n != 0;
            }
            if (this.target.isTraceEnabled()) {
                this.target.trace().append("StateCallHandlingCallHandling.addAnotherCharToSpellerIfAvailable() char not valid: ").append(this.charsToAdd).append(", valid: ").append(string).log();
            }
            this.invalidlyEnteredCharactersAmount += this.charsToAdd.length();
            PhoneUtil.updateShortDialMatchingSize(0);
            this.charsToAdd = "";
        }
        return false;
    }

    private void handleNextQueuedItem() {
        int n = this.spellerCachedActions.size();
        if (this.target.isTraceEnabled()) {
            this.target.trace().append("StateCallHandlingCallHandling.handleNextQueuedItem() cached size: ").append(n).log();
        }
        if (n > 0) {
            DialSpellerCacheItem dialSpellerCacheItem = (DialSpellerCacheItem)this.spellerCachedActions.remove(0);
            if (this.target.isTraceEnabled()) {
                this.target.trace().append("StateCallHandlingCallHandling.handleNextQueuedItem() handling: ").append(dialSpellerCacheItem).log();
            }
            switch (dialSpellerCacheItem.action) {
                case 1: {
                    this.handleSpellerSetCharacterBlock(dialSpellerCacheItem.spellerBlockItem.text, dialSpellerCacheItem.spellerBlockItem.knownToApplication, dialSpellerCacheItem.touchSpellerBlocks);
                    break;
                }
                case 2: {
                    if (dialSpellerCacheItem.spellerBlockItem.text.length() > 1) {
                        this.handleSpellerDeleteCharacterBlock();
                        break;
                    }
                    this.handleSpellerDeleteCharacter();
                    break;
                }
            }
        }
        if (this.spellerCachedActions.size() >= n && n != 0) {
            this.target.error("StateCallHandlingCallHandling.writeDownSpeller() elements added while handling cached items!");
        }
    }

    public void dsiAdbListSpellerResult(int n, int n2, DataSet[] dataSetArray, int n3, String string, String string2) {
        if (n == 0) {
            this.target.spellerResultDataSets = dataSetArray;
            if (this.target.isTraceEnabled()) {
                this.target.trace().append("valid characters: ").append(string.toUpperCase()).log();
            }
            this.lastDeliveredValidChars = string;
            this.lastDeliveredTotalHits = n3;
            this.spellerUsableBySpellerResult = true;
            boolean bl = false;
            if (this.target.spellerHandle != -2) {
                bl = this.addAnotherCharToSpellerIfAvailable();
            }
            if (!(bl || n2 != this.target.spellerHandle && this.target.spellerHandle != -2)) {
                this.target.spellerHandle = n2;
                if (this.spellerUsableBySpellerResult) {
                    this.handleNextQueuedItem();
                }
            }
        }
        if (this.spellerActionsToBeDone > 0) {
            --this.spellerActionsToBeDone;
        }
        if (this.spellerActionsToBeDone == 0) {
            PhoneUtil.updateShortDialMatchingSize(Util.isNullOrEmpty(string2) || this.invalidlyEnteredCharactersAmount > 0 ? 0 : n3);
        }
    }

    public void dsiAdbListGetSpellerViewWindowResult(int n, int n2, DataSet[] dataSetArray, int n3) {
        if (n == 0) {
            if (!Util.isNullOrEmpty(dataSetArray) && this.spellerData.getCursorPosition() > 0) {
                ListManager.getGenericASLList(1169).updateListItems(dataSetArray[0].entryPosition, dataSetArray);
            } else {
                ListManager.getGenericASLList(1169).setSize(0);
            }
        }
    }

    public void dsiAdbListInvalidData(int n) {
        if (this.target.spellerHandle != -1 && this.target.spellerHandle != -2) {
            this.trans(this.target.stateCallHandlingReinitializeSpeller);
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(5254, 5254, -1341980608);
            this.target.send(eventGeneric);
        }
    }

    static {
        selectedNumber = "";
    }
}

