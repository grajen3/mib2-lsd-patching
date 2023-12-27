/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.memory.search;

import de.vw.mib.asl.internal.navigation.memory.search.AbstractMSState;
import de.vw.mib.asl.internal.navigation.memory.search.HsmTargetMemorySearch;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.HsmState;

public final class StateMSMain
extends AbstractMSState {
    public StateMSMain(HsmTargetMemorySearch hsmTargetMemorySearch, String string, HsmState hsmState) {
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
                this.handleStart();
                break;
            }
            case 4: {
                this.handleExit();
                break;
            }
            case 1073742457: {
                this.handleSpellerSetChar(eventGeneric);
                break;
            }
            case 1074841879: {
                this.handleSpellerSetCharHwr(eventGeneric);
                break;
            }
            case 1073742456: {
                this.handleSpellerDeleteChar(eventGeneric);
                break;
            }
            case 1074841880: {
                this.handleSpellerDeleteAllChars(eventGeneric);
                break;
            }
            case 1073742458: {
                this.handleSpellerSetString(eventGeneric);
                break;
            }
            case 1073742454: {
                this.handleSearchContactListSpeller();
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
            case 100100: {
                this.handleStopSearchSpeller();
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

    private void handleSpellerSetChar(EventGeneric eventGeneric) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("handleSpellerSetChar()");
        }
        this.target.transStateAddSpellerChar(eventGeneric);
    }

    private void handleSpellerSetCharHwr(EventGeneric eventGeneric) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("handleSpellerSetCharHwr()");
        }
        this.target.transStateAddSpellerChar(eventGeneric);
    }

    private void handleSpellerDeleteChar(EventGeneric eventGeneric) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("handleSpellerDeleteChar()");
        }
        this.target.transStateDeleteSpellerChar(eventGeneric);
    }

    private void handleSpellerDeleteAllChars(EventGeneric eventGeneric) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("handleSpellerDeleteAllChars()");
        }
        this.target.transStateDeleteSpellerChar(eventGeneric);
    }

    private void handleSearchContactListSpeller() {
        this.logger.warn("handleSearchContactListSpeller(): ASL_NAVIGATION_MEMORY_SEARCH_CONTACT_LIST_SPELLER - not handled");
    }

    private void handleSpellerSetString(EventGeneric eventGeneric) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("handleSpellerSetString()");
        }
        this.prepareSpellerSetString(eventGeneric);
        this.getDataPool().storeSpellerData();
        this.target.dsiAdbList.addSpellerChars(this.getDataPool().getSpellerHandle(), this.getDataPool().getSpellerData().getEnteredText());
    }

    public HsmState dsiAdbListStopSpellerResult(int n, int n2) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("dsiAdbListStopSpellerResult()");
            this.logger.trace("StateMSMain.dsiAdbListStopSpellerResult.setPendingSpellerResult(false )");
        }
        this.getDataPool().setSpellerStopped(false);
        this.getDataPool().setInvalidCharactersCount(0);
        if (n == 0) {
            if (this.getDataPool().getSpellerHandle() == n2) {
                this.getDataPool().setSpellerHandle(-2);
            }
            String string = "";
            this.getDataPool().getSpellerData().setMatchCount(0);
            this.getDataPool().getSpellerData().setMatchText("");
            this.getDataPool().getSpellerData().setAvailableCharacters("");
            if (this.getDataPool().isRestartSearchSpeller()) {
                string = this.getDataPool().getSpellerString();
                this.target.dsiAdbList.startSpeller(this.getDataPool().getLastUsedSearchType(), 10, this.target.getDataPool().getAdbSearchMode());
                this.getDataPool().setRestartSearchSpeller(false);
                this.isRepeatSearchAfterSpellerRestart = true;
            }
            this.updateDataPoolOnSpellerSetChar(string, 0, 0, 0);
            this.getDataPool().requestStoreSpellerData();
            this.getDataPool().storeSpellerData();
            this.getDataPool().updateSearchResultListHeadline();
        }
        return null;
    }
}

