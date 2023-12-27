/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.contacts;

import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.phone.ASLPhoneData;
import de.vw.mib.asl.internal.phone.contacts.HsmPhoneContactsSearchHandling;
import de.vw.mib.asl.internal.phone.contacts.PhoneSearchFetcher;
import de.vw.mib.asl.internal.phone.util.PhoneUtil;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.util.Util;
import generated.de.vw.mib.asl.internal.ListManager;
import org.dsi.ifc.organizer.DataSet;

public class StateContactsSearchHandlingSearchHandling
extends AbstractHsmState {
    private final HsmPhoneContactsSearchHandling target;
    private int currentSpellerTypeDSI = -1;

    public StateContactsSearchHandlingSearchHandling(HsmPhoneContactsSearchHandling hsmPhoneContactsSearchHandling, GenericEvents genericEvents, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = hsmPhoneContactsSearchHandling;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 1073742798: {
                AbstractASLHsmTarget.writeBooleanToDatapool(1192, true);
                ListManager.getGenericASLList(1190).updateStringIndex(ASLPhoneData.getInstance().defaultCharacterInfo.getIndices(), ASLPhoneData.getInstance().defaultCharacterInfo.getCharacters());
                boolean bl = PhoneUtil.updateContactsSize(this.target.phoneContactsSize);
                if (this.target.phoneContactsSize == 0) {
                    AbstractASLHsmTarget.writeBooleanToDatapool(3230, false);
                    AbstractASLHsmTarget.writeBooleanToDatapool(-1260253952, false);
                    if (!this.target.isTraceEnabled()) break;
                    this.target.trace().append("PHONE_CONTACTS_IS_CONTACT_LIST_LOADING set to false by setSearchFilter(phoneContactsSize=0)").log();
                    break;
                }
                AbstractASLHsmTarget.writeBooleanToDatapool(3230, bl);
                AbstractASLHsmTarget.writeBooleanToDatapool(-1260253952, bl);
                if (!this.target.isTraceEnabled()) break;
                this.target.trace().append("PHONE_CONTACTS_IS_CONTACT_LIST_LOADING set to true by setSearchFilter(phoneContactsSize!=0)").log();
                break;
            }
            case 1075141844: {
                if (this.target.operationPending) break;
                String string = eventGeneric.getString(0);
                if (this.target.selectionStart == this.target.selectionEnd) {
                    this.target.operationPending = true;
                    this.target.spellerData.setAvailableCharacters("");
                    AbstractASLHsmTarget.writeSpellerDataToDatapool(1191, this.target.spellerData);
                    if (string.length() > 1) {
                        for (int i2 = 1; i2 < string.length(); ++i2) {
                            this.target.cachedCharacters.add(new Character(string.charAt(i2)));
                        }
                        string = string.substring(0, 1);
                    }
                    this.target.addedCharacterIndex = this.target.uniqueChars.length();
                    this.target.selectionStart = eventGeneric.getInt(1);
                    this.target.selectionEnd = eventGeneric.getInt(2);
                    this.target.cursorPosition = eventGeneric.getInt(3);
                    if (this.target.selectionEnd - this.target.selectionEnd > 1 || this.target.selectionEnd - this.target.selectionEnd < 0) {
                        this.target.error("More than one character selected or selectionEnd smaller than selectionStart!");
                    }
                    this.writeSpellerChar(string);
                    break;
                }
                if (!this.target.spellerData.getEnteredText().substring(this.target.selectionStart, this.target.selectionEnd).equals(string) && !this.target.spellerData.getEnteredText().substring(this.target.spellerData.getSelectionStart(), this.target.spellerData.getSelectionEnd()).equals(string)) {
                    this.target.replaceChar = string;
                    this.trans(this.target.stateRemoveCharacter);
                    this.target.spellerData.setSelectionStart(eventGeneric.getInt(1));
                    this.target.spellerData.setSelectionEnd(eventGeneric.getInt(2));
                    this.target.spellerData.setCursorPosition(this.target.spellerData.getEnteredText().length());
                    AbstractASLHsmTarget.writeSpellerDataToDatapool(1191, this.target.spellerData);
                    break;
                }
                this.target.selectionEnd = 0;
                this.target.selectionStart = 0;
                this.target.spellerData.setSelectionStart(this.target.selectionStart);
                this.target.spellerData.setSelectionEnd(this.target.selectionEnd);
                this.target.spellerData.setCursorPosition(this.target.spellerData.getEnteredText().length());
                AbstractASLHsmTarget.writeSpellerDataToDatapool(1191, this.target.spellerData);
                break;
            }
            case 1073742793: {
                if (this.target.operationPending) break;
                this.target.selectionEnd = 0;
                this.target.selectionStart = 0;
                this.target.spellerData.setSelectionEnd(this.target.selectionEnd);
                this.target.spellerData.setSelectionStart(this.target.selectionStart);
                this.target.spellerData.setAvailableCharacters("");
                AbstractASLHsmTarget.writeSpellerDataToDatapool(1191, this.target.spellerData);
                this.removeSpellerChar();
                break;
            }
            case 1073744620: {
                int n = eventGeneric.getInt(1);
                int n2 = -1;
                switch (n) {
                    case 0: {
                        n2 = 0;
                        break;
                    }
                    case 1: {
                        n2 = 1;
                        break;
                    }
                }
                if (n2 != -1) {
                    if (this.currentSpellerTypeDSI != n2) {
                        if (PhoneSearchFetcher.spellerHandle <= -1) {
                            this.target.dsiAdbList.startSpeller(1, 20, n2);
                            this.target.spellerData.setAvailableCharacters("");
                            PhoneSearchFetcher.spellerHandle = -2;
                        } else {
                            this.target.restartSpellerMode = n2;
                            this.target.restartSpeller = true;
                            this.stopSpeller();
                        }
                    } else {
                        AbstractASLHsmTarget.writeSpellerDataToDatapool(1191, this.target.spellerData);
                    }
                    this.currentSpellerTypeDSI = n2;
                    break;
                }
                this.target.error("SPELLER_INIT__1 ignored due to unmatched speller type: ", n);
                break;
            }
            case 1073742791: {
                ListManager.getGenericASLList(1190).updateStringIndex(ASLPhoneData.getInstance().characterInfos.getIndices(), ASLPhoneData.getInstance().characterInfos.getCharacters());
                AbstractASLHsmTarget.writeBooleanToDatapool(1192, false);
                this.target.restartSpeller = false;
                this.stopSpeller();
                break;
            }
            case 1073742794: {
                this.target.selectionEnd = 0;
                this.target.selectionStart = 0;
                this.target.restartSpeller = true;
                this.stopSpeller();
                break;
            }
            case 1073742792: {
                this.target.selectionEnd = 0;
                this.target.selectionStart = 0;
                break;
            }
            case 1075141831: {
                boolean bl;
                this.target.isHWRActive = bl = eventGeneric.getBoolean(0);
                AbstractASLHsmTarget.writeBooleanToDatapool(1127358464, bl);
                break;
            }
            case 1073744461: {
                PhoneUtil.updateContactsSize(this.target.spellerData.getMatchCount());
                AbstractASLHsmTarget.writeBooleanToDatapool(1192, true);
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    private void stopSpeller() {
        switch (PhoneSearchFetcher.spellerHandle) {
            case -2: 
            case -1: {
                this.target.restartSpeller = false;
                break;
            }
            default: {
                AbstractASLHsmTarget.writeBooleanToDatapool(3230, true);
                AbstractASLHsmTarget.writeBooleanToDatapool(-1260253952, true);
                if (this.target.isTraceEnabled()) {
                    this.target.trace().append("PHONE_CONTACTS_IS_CONTACT_LIST_LOADING set to true by stopSpeller").log();
                }
                this.target.dsiAdbList.stopSpeller(PhoneSearchFetcher.spellerHandle);
                this.target.spellerData.setAvailableCharacters("");
                PhoneSearchFetcher.spellerHandle = -1;
                PhoneUtil.updateContactsSize(0);
            }
        }
        this.currentSpellerTypeDSI = -1;
        this.target.cachedCharacters.clear();
    }

    public void dsiAdbListSpellerResult(int n, int n2, DataSet[] dataSetArray, int n3, String string, String string2) {
        this.target.operationPending = false;
        if (n == 0 && (n2 == PhoneSearchFetcher.spellerHandle || PhoneSearchFetcher.spellerHandle == -2)) {
            PhoneSearchFetcher.spellerHandle = n2;
            PhoneSearchFetcher.spelleredListSize = n3;
            this.target.spellerData.setMatchCount(n3);
            this.target.spellerData.setAvailableCharacters(string);
            this.target.spellerData.setEnteredText(string2);
            this.target.validChars = string;
            this.target.uniqueChars = string2;
            if (!Util.isNullOrEmpty(dataSetArray)) {
                ServiceManager.aslPropertyManager.valueChangedLong(-394062592, dataSetArray[0].getEntryId());
                this.target.spellerData.setMatchText(dataSetArray[0].generalDescription1);
                this.target.southsideDataSets = dataSetArray;
                this.target.southsideValidChars = string;
                this.target.southsideTotalHits = n3;
                this.target.southsideUniqueChars = string2;
                if (this.target.isHWRActive) {
                    if (this.target.spellerData.getEnteredText().length() == 0) {
                        ListManager.getGenericASLList(3683).clear();
                        ListManager.getGenericASLList(3899).clear();
                    } else {
                        ListManager.getGenericASLList(3683).updateList(dataSetArray);
                        ListManager.getGenericASLList(3899).updateList(dataSetArray);
                    }
                }
            } else {
                this.target.spellerData.setMatchText("");
            }
            this.target.spellerData.setSelectionStart(this.target.selectionStart);
            if (this.target.selectionEnd != this.target.selectionStart) {
                this.target.spellerData.setSelectionEnd(this.target.spellerData.getEnteredText().length());
                this.target.spellerData.setCursorPosition(this.target.selectionEnd);
            } else {
                this.target.spellerData.setSelectionEnd(this.target.selectionEnd);
                this.target.spellerData.setCursorPosition(string2.length());
            }
            AbstractASLHsmTarget.writeSpellerDataToDatapool(1191, this.target.spellerData);
            if (n3 > 0) {
                this.target.phoneContactsSize = n3;
            }
            if (this.target.cachedCharacters.size() > 0) {
                while (this.target.addedCharacterIndex != string2.length() - 1) {
                    if (((Character)this.target.cachedCharacters.get(0)).toString().toUpperCase().equals(string2.substring(this.target.addedCharacterIndex + 1, this.target.addedCharacterIndex + 2).toUpperCase())) {
                        this.target.cachedCharacters.remove(0);
                        ++this.target.addedCharacterIndex;
                        continue;
                    }
                    this.target.uniqueChars = string2.substring(0, this.target.addedCharacterIndex + 1);
                    break;
                }
                if (this.target.cachedCharacters.size() > 0) {
                    ++this.target.addedCharacterIndex;
                    this.writeSpellerChar(((Character)this.target.cachedCharacters.remove(0)).toString());
                }
            }
        }
    }

    public void dsiAdbListStopSpellerResult(int n, int n2) {
        this.target.invalidCharacters = 0;
        this.target.uniqueChars = "";
        this.target.validChars = "";
        this.target.southsideDataSets = null;
        this.target.southsideValidChars = "";
        this.target.southsideTotalHits = 0;
        this.target.southsideUniqueChars = "";
        this.target.addedCharacterIndex = 0;
        if (this.target.phoneContactsSize == 0) {
            AbstractASLHsmTarget.writeBooleanToDatapool(3230, false);
            AbstractASLHsmTarget.writeBooleanToDatapool(-1260253952, false);
            if (this.target.isTraceEnabled()) {
                this.target.trace().append("PHONE_CONTACTS_IS_CONTACT_LIST_LOADING set to false by stopSpellerResult(phoneContactsSize=0)").log();
            }
        }
        if (this.target.restartSpeller) {
            this.target.restartSpeller = false;
            PhoneSearchFetcher.spellerHandle = -2;
            this.target.dsiAdbList.startSpeller(1, 20, this.target.restartSpellerMode);
        } else {
            PhoneSearchFetcher.spellerHandle = -1;
        }
        PhoneUtil.updateContactsSize(0);
        PhoneUtil.updateContactsSize(this.target.phoneContactsSize);
    }

    public void dsiAdbListInvalidData(int n) {
        this.target.restartSpeller = true;
        this.stopSpeller();
    }

    private void writeSpellerChar(String string) {
        boolean bl = Util.isNullOrEmpty(string);
        boolean bl2 = false;
        if (!bl) {
            String string2 = this.target.validChars.toUpperCase();
            String string3 = string.toUpperCase();
            for (int i2 = 0; i2 < this.target.validChars.length(); ++i2) {
                if (string2.charAt(i2) != string3.charAt(0)) continue;
                bl2 = true;
                break;
            }
        }
        if (bl2) {
            this.target.operationPending = true;
            this.target.dsiAdbList.addSpellerChars(PhoneSearchFetcher.spellerHandle, string);
        } else if (bl) {
            this.dsiAdbListSpellerResult(0, PhoneSearchFetcher.spellerHandle, this.target.southsideDataSets, this.target.southsideTotalHits, this.target.southsideValidChars, this.target.southsideUniqueChars);
        } else {
            ++this.target.invalidCharacters;
            this.dsiAdbListSpellerResult(0, PhoneSearchFetcher.spellerHandle, new DataSet[0], 0, "", new StringBuffer().append(this.target.uniqueChars).append(string).toString());
        }
    }

    private void removeSpellerChar() {
        if (this.target.invalidCharacters > 0) {
            if (--this.target.invalidCharacters == 0) {
                this.dsiAdbListSpellerResult(0, PhoneSearchFetcher.spellerHandle, this.target.southsideDataSets, this.target.southsideTotalHits, this.target.southsideValidChars, this.target.southsideUniqueChars);
            } else {
                this.dsiAdbListSpellerResult(0, PhoneSearchFetcher.spellerHandle, new DataSet[0], 0, "", this.target.uniqueChars.substring(0, this.target.uniqueChars.length() - 1));
            }
        } else {
            this.target.operationPending = true;
            this.target.dsiAdbList.removeSpellerChar(PhoneSearchFetcher.spellerHandle);
        }
    }
}

