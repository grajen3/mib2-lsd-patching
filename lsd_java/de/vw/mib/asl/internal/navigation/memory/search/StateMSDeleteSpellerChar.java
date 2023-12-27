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

public final class StateMSDeleteSpellerChar
extends AbstractMSState {
    private EventGeneric deleteEvent;

    public StateMSDeleteSpellerChar(HsmTargetMemorySearch hsmTargetMemorySearch, String string, HsmState hsmState) {
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
                this.handleSpellerDeleteChar();
                break;
            }
            case 1073742456: {
                this.handleSpellerDeleteLastChar();
                break;
            }
            case 1074841880: {
                this.handleSpellerDeleteAllChars();
                break;
            }
            case 1074841870: {
                this.handleHwrEnabledMode(eventGeneric);
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

    private void handleSpellerDeleteChar() {
        switch (this.deleteEvent.getReceiverEventId()) {
            case 1073742456: {
                this.handleSpellerDeleteLastChar();
                break;
            }
            case 1074841880: {
                this.handleSpellerDeleteAllChars();
                break;
            }
        }
        this.setDeleteCharEvent(null);
    }

    private void handleSpellerDeleteLastChar() {
        if (this.getDataPool().getSpellerData().getEnteredText().length() > 0) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("handleSpellerDeleteLastChar()");
            }
            if (this.getDataPool().getReplaceCharacters() == null) {
                this.prepareSpellerDeleteChar();
            }
            if (this.getDataPool().getInvalidCharactersCount() <= 0) {
                if (this.logger.isTraceEnabled()) {
                    this.logger.trace("StateMSDelete.handleSpellerDeleteLastChar.setPendingSpellerResult(true )");
                }
                this.target.dsiAdbList.removeSpellerChar(this.getDataPool().getSpellerHandle());
                this.getDataPool().getSpellerData().setAvailableCharacters("");
                this.getDataPool().getSpellerData().resetSelection();
            } else {
                this.getDataPool().setInvalidCharactersCount(this.getDataPool().getInvalidCharactersCount() - 1);
                this.getDataPool().restoreLastValidResultList();
            }
            this.getDataPool().storeSpellerData();
        }
    }

    private void handleSpellerDeleteAllChars() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("handleSpellerDeleteAllChars()");
        }
        this.restartSpeller(true);
    }

    @Override
    public HsmState dsiAdbListSpellerResult(int n, int n2, DataSet[] dataSetArray, int n3, String string, String string2) {
        if (n == 0 && !this.getDataPool().isSpellerStopped()) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("StateMSDelete.dsiAdbListSpellerResult.setPendingSpellerResult(false )");
            }
            if (this.getDataPool().getReplaceCharacters() != null) {
                this.target.dsiAdbList.addSpellerChars(this.getDataPool().getSpellerHandle(), this.getDataPool().getReplaceCharacters());
                this.getDataPool().setReplaceCharacters(null);
                EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(0, 0, 399052864);
                this.target.transStateAddSpellerChar(eventGeneric);
            } else {
                this.onUpdateSpellerChar(n, n2, dataSetArray, n3, string, string2);
            }
        }
        return null;
    }

    public HsmState dsiAdbListStopSpellerResult(int n, int n2) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("dsiAdbListStopSpellerResult()");
        }
        this.getDataPool().setSpellerStopped(false);
        this.getDataPool().setInvalidCharactersCount(0);
        if (n == 0) {
            if (this.getDataPool().getSpellerHandle() == n2) {
                this.getDataPool().setSpellerHandle(-2);
            }
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("StateMSDelete.dsiAdbListStopSpellerResult.setPendingSpellerResult(false )");
            }
            this.getDataPool().getSpellerData().setMatchCount(0);
            this.getDataPool().getSpellerData().setMatchText("");
            this.getDataPool().getSpellerData().setAvailableCharacters("");
            this.updateDataPoolOnSpellerSetChar("", 0, 0, 0);
            this.getDataPool().updateSearchResultListHeadline();
            this.target.dsiAdbList.startSpeller(this.getDataPool().getLastUsedSearchType(), 10, this.target.getDataPool().getAdbSearchMode());
            this.getDataPool().setRestartSearchSpeller(false);
            this.isRepeatSearchAfterSpellerRestart = true;
        }
        return null;
    }

    void setDeleteCharEvent(EventGeneric eventGeneric) {
        this.deleteEvent = eventGeneric;
    }
}

