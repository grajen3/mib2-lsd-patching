/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.memory.search;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.memory.search.HsmTargetMemorySearch;
import de.vw.mib.asl.internal.navigation.memory.search.MemorySearchDataPool;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.properties.values.SpellerData;
import org.dsi.ifc.organizer.DataSet;

public abstract class AbstractMSState
extends AbstractHsmState {
    protected final IExtLogger logger;
    protected static final int EV_STOP_SEARCH_SPELLER;
    protected final HsmTargetMemorySearch target;
    protected boolean isRepeatSearchAfterSpellerRestart = false;
    private int expectedSpellerResultsAfterRestart;

    public AbstractMSState(HsmTargetMemorySearch hsmTargetMemorySearch, String string, HsmState hsmState) {
        super(hsmTargetMemorySearch.getHsm(), string, hsmState);
        String string2 = string != null ? new StringBuffer().append("[").append(string).append("]").toString() : "[MemorySearchState]";
        this.logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(16384, string2);
        this.target = hsmTargetMemorySearch;
    }

    protected void handleEntry() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("handleEntry()");
        }
    }

    protected void handleStart() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("handleStart()");
        }
    }

    protected void handleExit() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("handleExit()");
        }
    }

    protected void handleDefault(EventGeneric eventGeneric) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleDefault()").append(eventGeneric).log();
        }
    }

    protected void handleStopSearchSpeller() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("handleStopSearchSpeller()");
        }
        if (this.getDataPool().getSpellerHandle() != -2) {
            this.getDataPool().setSpellerStopped(true);
            this.target.dsiAdbList.stopSpeller(this.getDataPool().getSpellerHandle());
            this.getDataPool().setRestartSearchSpeller(false);
        } else if (this.logger.isTraceEnabled()) {
            this.logger.trace("handleStopSearchSpeller(): Invalid request to stop search speller. No valid speller handle.");
        }
    }

    protected void handleHwrEnabledMode(EventGeneric eventGeneric) {
        boolean bl = eventGeneric.getBoolean(0);
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(new StringBuffer().append("handleHwrEnabledMode(): enabled = ").append(bl).toString());
        }
        this.getDataPool().setHwrEnabled(bl);
    }

    protected void onUpdateSpellerChar(int n, int n2, DataSet[] dataSetArray, int n3, String string, String string2) {
        this.onUpdateSpellerChar(n, n2, dataSetArray, n3, string, string2, string2.length(), true);
    }

    protected void onUpdateSpellerChar(int n, int n2, DataSet[] dataSetArray, int n3, String string, String string2, int n4, boolean bl) {
        if (n == 0 && (this.getDataPool().getSpellerHandle() == -2 || this.getDataPool().getSpellerHandle() == n2)) {
            this.getDataPool().setSpellerHandle(n2);
            if (this.expectedSpellerResultsAfterRestart <= 0) {
                this.getDataPool().setLastSearchResults(dataSetArray);
                this.getDataPool().updateListItems(dataSetArray, n3);
                if (string2 == null) {
                    string2 = "";
                }
                String string3 = this.getDataPool().getSpellerData().getEnteredText();
                this.getDataPool().getSpellerData().setAvailableCharacters(string);
                this.getDataPool().getSpellerData().setEnteredText(string2);
                this.getDataPool().getSpellerData().setCursorPosition(n4);
                this.getDataPool().requestStoreSpellerData();
                this.getDataPool().storeSpellerData();
                this.getDataPool().updateSearchResultListHeadline();
                this.getDataPool().updateSpellerReady(true);
                if (bl) {
                    this.switchToResultListIfRequired(string3, dataSetArray.length);
                }
            }
        }
    }

    protected final void switchToResultListIfRequired(String string, int n) {
        if (!this.getDataPool().isHwrEnabled() && string != null && string.trim().length() > 0 && n > 0 && n <= MemorySearchDataPool.SWITCH_TO_LIST_RESULT_LIMIT) {
            this.target.sendHMIEvent(99);
        }
    }

    protected final void prepareInitSearchSpeller(EventGeneric eventGeneric) {
        if (eventGeneric == null) {
            return;
        }
        this.getDataPool().setAdbSearchMode(0);
        this.getDataPool().updateSpellerReady(false);
        this.expectedSpellerResultsAfterRestart = 0;
        this.getDataPool().setSearchType(eventGeneric.getInt(0));
        this.getDataPool().setSpellerString("");
        this.getDataPool().getSpellerData().setEnteredText("");
        this.getDataPool().getSpellerData().setMatchCount(0);
        this.getDataPool().getSpellerData().setCursorPosition(0);
        this.getDataPool().setInvalidCharactersCount(0);
        this.getDataPool().updateSearchResultListHeadline();
        this.getDataPool().setRestartSearchSpeller(false);
        this.getDataPool().setLastSearchResults(null);
        this.getDataPool().getResultList().clear();
        this.getDataPool().clearResultList();
        this.getDataPool().requestStoreSpellerData();
    }

    protected final void updateDataPoolOnSpellerSetChar(String string, int n, int n2, int n3) {
        this.getDataPool().setSpellerString(string);
        this.getDataPool().getSpellerData().setEnteredText(string);
        this.updateDataPoolOnSpellerSetChar(n, n2, n3);
    }

    protected final void updateDataPoolOnSpellerSetChar(int n, int n2, int n3) {
        this.getDataPool().getSpellerData().setCursorPosition(n);
        this.getDataPool().getSpellerData().setSelectionStart(n2);
        this.getDataPool().getSpellerData().setSelectionEnd(n3);
        this.getDataPool().requestStoreSpellerData();
        this.getDataPool().updateSearchResultListHeadline();
    }

    protected final void prepareSpellerDeleteChar() {
        String string = this.getDataPool().getSpellerData().getEnteredText();
        if (string.length() > 0) {
            string = string.substring(0, string.length() - 1);
            this.getDataPool().setSpellerString(string);
            this.getDataPool().getSpellerData().setEnteredText(string);
            this.getDataPool().getSpellerData().setCursorPosition(string.length());
            this.getDataPool().requestStoreSpellerData();
            this.getDataPool().updateSearchResultListHeadline();
        }
    }

    protected final void prepareSpellerSetString(EventGeneric eventGeneric) {
        String string = eventGeneric.getString(0);
        this.getDataPool().setSpellerString(string);
        this.getDataPool().getSpellerData().setEnteredText(string);
        this.getDataPool().updateSearchResultListHeadline();
        this.getDataPool().getSpellerData().setAvailableCharacters("");
        this.getDataPool().requestStoreSpellerData();
    }

    protected void adjustInternalSpellerData() {
        SpellerData spellerData = this.getDataPool().getSpellerData();
        int n = spellerData.getEnteredText().length();
        spellerData.setSelectionEnd(Math.min(n, this.getDataPool().getSpellerData().getSelectionEnd()));
        spellerData.setCursorPosition(Math.min(n, spellerData.getCursorPosition()));
        this.getDataPool().requestStoreSpellerData();
    }

    public HsmState dsiAdbListSpellerResult(int n, int n2, DataSet[] dataSetArray, int n3, String string, String string2) {
        if (!(n != 0 || this.getDataPool().isSpellerStopped() || this.getDataPool().getSpellerHandle() != -2 && this.getDataPool().getSpellerHandle() != n2)) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("AbstractMSState.dsiAdbListSpellerResult.setPendingSpellerResult(false )");
            }
            this.getDataPool().setSpellerHandle(n2);
            if (this.isRepeatSearchAfterSpellerRestart) {
                for (int i2 = 0; i2 < this.getDataPool().getSpellerString().length(); ++i2) {
                    this.target.dsiAdbList.addSpellerChars(n2, String.valueOf(this.getDataPool().getSpellerString().charAt(i2)));
                }
                this.expectedSpellerResultsAfterRestart = this.getDataPool().getSpellerString().length();
                this.isRepeatSearchAfterSpellerRestart = false;
            } else if (this.expectedSpellerResultsAfterRestart > 0) {
                --this.expectedSpellerResultsAfterRestart;
            }
            if (this.expectedSpellerResultsAfterRestart <= 0) {
                this.onUpdateSpellerChar(n, n2, dataSetArray, n3, string, string2);
            }
        }
        return null;
    }

    public HsmState dsiAdbListGetSpellerViewWindowResult(int n, int n2, DataSet[] dataSetArray, int n3) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("dsiAdbListGetSpellerViewWindowResult(...)");
        }
        if (n == 0 && dataSetArray != null && dataSetArray.length > 0 && dataSetArray[0] != null) {
            this.getDataPool().getResultList().updateListItems(dataSetArray[0].entryPosition, (DataSet[])dataSetArray.clone());
        }
        this.getDataPool().getResultList().setSize(n3);
        return null;
    }

    public HsmState dsiAdbListInvalidData(int n) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("dsiAdbListInvalidData(...)");
        }
        this.restartSpeller(true);
        return null;
    }

    protected void restartSpeller(boolean bl) {
        this.getDataPool().setRestartSearchSpeller(bl);
        int n = this.getDataPool().getSpellerHandle();
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(new StringBuffer().append("restartSpeller(...): restHandledByResultMethod = ").append(bl).append(", spellerHandle (invalid == -2) = ").append(n).toString());
        }
        if (n != -2) {
            this.getDataPool().setSpellerStopped(true);
            this.target.dsiAdbList.stopSpeller(n);
        }
        if (!bl) {
            this.target.dsiAdbList.startSpeller(this.getDataPool().getLastUsedSearchType(), 10, this.getDataPool().getAdbSearchMode());
        }
    }

    protected MemorySearchDataPool getDataPool() {
        return this.target.getDataPool();
    }
}

