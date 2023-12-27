/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.memory.search;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.memory.search.AbstractMSState;
import de.vw.mib.asl.internal.navigation.memory.search.HsmTargetMemorySearch;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.organizer.DataSet;

public final class StateMSAddSpellerChar
extends AbstractMSState {
    private EventGeneric addCharEvent;
    private String multipleCharsToAdd = null;
    private int nextMultipleCharToAddIndex = -1;
    private int initialCursorPos = -1;
    private boolean isPendingSpellerResult = false;

    public StateMSAddSpellerChar(HsmTargetMemorySearch hsmTargetMemorySearch, String string, HsmState hsmState) {
        super(hsmTargetMemorySearch, string, hsmState);
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.handleEntry();
                break;
            }
            case 3: {
                this.handleSpellerSetChar();
                break;
            }
            case 1073742457: {
                this.handleSpellerSetChar(eventGeneric);
                break;
            }
            case 1074841879: {
                this.handleSpellerSetChar(eventGeneric);
                break;
            }
            case 1073742443: {
                this.handleInitSearchSpeller(eventGeneric);
                break;
            }
            case 4: {
                this.handleExit();
                break;
            }
            default: {
                this.handleDefault(eventGeneric);
                return this.myParent;
            }
        }
        return null;
    }

    private void handleInitSearchSpeller(EventGeneric eventGeneric) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("handleInitSearchSpeller()");
        }
        this.target.transStateInitAndForwardEvent(eventGeneric);
    }

    @Override
    public HsmState dsiAdbListSpellerResult(int n, int n2, DataSet[] dataSetArray, int n3, String string, String string2) {
        if (n == 0 && !this.getDataPool().isSpellerStopped() && (this.isPendingSpellerResult || this.getDataPool().isHwrEnabled())) {
            this.getDataPool().setReplaceCharacters(null);
            this.onUpdateSpellerChar(n, n2, dataSetArray, n3, string, string2);
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("StateMSAdd.dsiAdbListSpellerResult.setPendingSpellerResult(false )");
            }
            this.isPendingSpellerResult = false;
            boolean bl = this.reduceRemainingMultipleCharactersToAdd();
            if (!bl) {
                this.addMultipleCharacters();
            }
        }
        this.target.trace(new StringBuffer().append("Result type: ").append(n).toString());
        this.target.trace(new StringBuffer().append("isSpellerStopped?: ").append(this.getDataPool().isSpellerStopped()).toString());
        this.target.trace(new StringBuffer().append("isPendingSpellerResult?: ").append(this.isPendingSpellerResult).toString());
        this.target.trace(new StringBuffer().append("isHWREnabled?: ").append(this.getDataPool().isHwrEnabled()).toString());
        return null;
    }

    public HsmState dsiAdbListStopSpellerResult(int n, int n2) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("dsiAdbListStopSpellerResult()");
        }
        this.getDataPool().setSpellerStopped(false);
        this.getDataPool().setInvalidCharactersCount(0);
        if (n == 0) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("StateMSAdd.dsiAdbListStopSpellerResult.setPendingSpellerResult(false )");
            }
            this.isPendingSpellerResult = false;
        }
        return null;
    }

    @Override
    protected void onUpdateSpellerChar(int n, int n2, DataSet[] dataSetArray, int n3, String string, String string2) {
        int n4 = string2.length();
        if (n == 0 && (this.getDataPool().getSpellerHandle() == -2 || this.getDataPool().getSpellerHandle() == n2)) {
            int n5 = this.getDataPool().getSpellerData().getSelectionEnd() - this.getDataPool().getSpellerData().getSelectionStart();
            if (this.getDataPool().isHwrEnabled() && n5 > 0 && n5 < string2.length()) {
                n4 = this.getDataPool().getSpellerData().getSelectionEnd();
                this.getDataPool().getSpellerData().setSelectionEnd(string2.length());
            }
        }
        this.onUpdateSpellerChar(n, n2, dataSetArray, n3, string, string2, n4, this.reduceRemainingMultipleCharactersToAdd());
    }

    void setAddCharEvent(EventGeneric eventGeneric) {
        this.addCharEvent = eventGeneric;
    }

    private boolean reduceRemainingMultipleCharactersToAdd() {
        boolean bl = true;
        if (this.nextMultipleCharToAddIndex >= 0 && this.multipleCharsToAdd != null && this.nextMultipleCharToAddIndex < this.multipleCharsToAdd.length() && this.initialCursorPos >= 0) {
            int n = this.getDataPool().getSpellerData().getCursorPosition();
            this.nextMultipleCharToAddIndex = n - this.initialCursorPos;
            boolean bl2 = bl = this.nextMultipleCharToAddIndex <= 0 || this.nextMultipleCharToAddIndex >= this.multipleCharsToAdd.length();
        }
        if (bl) {
            this.multipleCharsToAdd = null;
            this.nextMultipleCharToAddIndex = -1;
            this.initialCursorPos = -1;
        }
        return bl;
    }

    private void handleSpellerSetChar() {
        this.handleSpellerSetChar(this.addCharEvent);
        this.setAddCharEvent(null);
    }

    private void handleSpellerSetChar(EventGeneric eventGeneric) {
        String string = "";
        int n = 0;
        int n2 = 0;
        int n3 = 0;
        if (this.getDataPool().isHwrEnabled()) {
            string = eventGeneric.getString(0);
            n = eventGeneric.getInt(1);
            n2 = eventGeneric.getInt(2);
            n3 = eventGeneric.getInt(3);
        } else {
            string = eventGeneric.getString(0);
            n = this.getDataPool().getSpellerData().getCursorPosition();
            n2 = this.getDataPool().getSpellerData().getSelectionStart();
            n3 = this.getDataPool().getSpellerData().getSelectionEnd();
        }
        if (this.target.isTraceEnabled()) {
            this.target.trace(new StringBuffer().append("handleSpellerSetChar - newChars: ").append(string).append(", cursorPos: ").append(n).append(", selectionStart: ").append(n2).append(", selectionEnd: ").append(n3).append(", Event: ").append(eventGeneric).toString());
        }
        this.handleSpellerSetChar(eventGeneric, string, n, n2, n3);
    }

    private void handleSpellerSetChar(EventGeneric eventGeneric, String string, int n, int n2, int n3) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("handleSpellerSetChar()...");
        }
        this.adjustInternalSpellerData();
        boolean bl = true;
        String string2 = this.getDataPool().getSpellerData().getEnteredText();
        int n4 = this.getDataPool().getSpellerData().getSelectionStart();
        int n5 = this.getDataPool().getSpellerData().getSelectionEnd();
        if (this.isReplaceRequired(string)) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("Add speller char requires a replace...");
            }
            this.getDataPool().setReplaceCharacters(string);
            EventGeneric eventGeneric2 = ServiceManager.mGenericEventFactory.newEvent(eventGeneric.getSenderTargetId(), eventGeneric.getReceiverTargetId(), 2013397056);
            this.target.transStateDeleteSpellerChar(eventGeneric2);
        } else if (this.isAddingMultiplePinyinCharsRequired(n4, n5, string)) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("Add speller char requires adding multiple chars...");
            }
            bl = false;
            this.multipleCharsToAdd = string;
            this.nextMultipleCharToAddIndex = 0;
            this.initialCursorPos = string2.length();
            this.addMultipleCharacters();
        } else if (n5 - n4 == 0 || " ".equals(string)) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("Add speller char requires adding on single char in pinyin speller...");
            }
            if (" ".equals(string) && string2.length() == 0) {
                return;
            }
            if (n4 != n5 && " ".equals(string)) {
                n2 = 0;
                n3 = 0;
            }
            this.addSingleCharacter(string);
            n = string2.length() + string.length();
            this.updateDataPoolOnSpellerSetChar(new StringBuffer().append(string2).append(string).toString(), n, n2, n3);
        } else {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("Add speller char detected same character entered again, so just remove selection...");
            }
            n = string2.length();
            this.getDataPool().getSpellerData().setAvailableCharacters("");
            this.updateDataPoolOnSpellerSetChar(string2, n, 0, 0);
        }
        if (bl) {
            this.getDataPool().updateListItems(this.getDataPool().getLastSearchResults(), this.getDataPool().getLastSearchResults().length);
        }
        this.getDataPool().storeSpellerData();
    }

    private boolean isAddingMultiplePinyinCharsRequired(int n, int n2, String string) {
        return !this.getDataPool().isHwrEnabled() && n == n2 && string.length() > 0;
    }

    private boolean isReplaceRequired(String string) {
        int n;
        int n2 = this.getDataPool().getSpellerData().getSelectionStart();
        if (n2 >= (n = this.getDataPool().getSpellerData().getSelectionEnd())) {
            return false;
        }
        if (!this.getDataPool().isHwrEnabled()) {
            String string2 = this.getDataPool().getSpellerData().getEnteredText();
            string2 = string2 != null ? string2 : "";
            n = Math.min(this.getDataPool().getSpellerData().getSelectionEnd(), string2.length());
            return !string2.substring(n2, n).startsWith(string);
        }
        return string != null && string.length() > 0;
    }

    private void addMultipleCharacters() {
        if (this.multipleCharsToAdd != null && this.nextMultipleCharToAddIndex >= 0 && this.nextMultipleCharToAddIndex < this.multipleCharsToAdd.length()) {
            String string = String.valueOf(this.multipleCharsToAdd.charAt(this.nextMultipleCharToAddIndex));
            this.addSingleCharacter(string);
            this.updateDataPoolOnSpellerSetChar(this.getDataPool().getSpellerData().getEnteredText().length(), 0, 0);
        }
    }

    private void addSingleCharacter(String string) {
        String string2 = new StringBuffer().append(this.getDataPool().getSpellerData().getAvailableCharacters().toLowerCase()).append(this.getDataPool().getSpellerData().getAvailableCharacters().toUpperCase()).toString();
        StringBuffer stringBuffer = new StringBuffer(this.getDataPool().getSpellerData().getEnteredText());
        stringBuffer.append(string);
        this.getDataPool().getSpellerData().setEnteredText(stringBuffer.toString());
        this.target.trace(new StringBuffer().append("invalid chars count: ").append(this.getDataPool().getInvalidCharactersCount()).toString());
        this.target.trace(new StringBuffer().append("availableChars: ").append(string2).toString());
        if (this.getDataPool().getInvalidCharactersCount() <= 0 && string2.indexOf(string) != -1) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("StateMSAdd.handleSpellerSetChar.setPendingSpellerResult(true)");
            }
            this.isPendingSpellerResult = true;
            this.target.dsiAdbList.addSpellerChars(this.getDataPool().getSpellerHandle(), string);
        } else {
            this.getDataPool().setInvalidCharactersCount(this.getDataPool().getInvalidCharactersCount() + 1);
            this.getDataPool().clearResultList();
            this.getDataPool().getSpellerData().setCursorPosition(this.getDataPool().getSpellerData().getCursorPosition() + 1);
            boolean bl = this.reduceRemainingMultipleCharactersToAdd();
            if (!bl) {
                this.addMultipleCharacters();
            }
        }
    }
}

