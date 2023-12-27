/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.memory.search;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.navigation.memory.search.MemorySearchSpellerFilter;
import de.vw.mib.properties.values.SpellerData;
import generated.de.vw.mib.asl.internal.ListManager;
import org.dsi.ifc.organizer.DataSet;

final class MemorySearchDataPool {
    private static final MemorySearchDataPool INSTANCE = new MemorySearchDataPool();
    private final IExtLogger LOGGER = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(16384, "[MemorySearchDataPool]");
    static final String SPACE;
    static final int INVALID_SPELLER_HANDLE;
    static final int SEARCH_WINDOW_SIZE;
    static final int SWITCH_TO_LIST_RESULT_LIMIT;
    private final GenericASLList resultList = ListManager.getGenericASLList(906);
    private final SpellerData spellerData = new SpellerData();
    private final MemorySearchSpellerFilter spellerFilter = new MemorySearchSpellerFilter();
    private int searchType;
    private int spellerHandle = -2;
    private String spellerString = "";
    private boolean restartSearchSpeller;
    private int lastUsedSearchType;
    private int adbSearchMode;
    private boolean isHwrEnabled;
    private String replaceCharacters;
    private DataSet[] lastSearchResults;
    private int invalidCharactersCount = 0;
    private boolean isStoreSpellerDataRequested = false;
    private boolean isSpellerStopped = false;

    private MemorySearchDataPool() {
    }

    static MemorySearchDataPool getInstance() {
        return INSTANCE;
    }

    void updateSpellerReady(boolean bl) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(889, bl);
    }

    void updateSearchResultListHeadline() {
        String string = this.getSpellerData().getEnteredText();
        ServiceManager.aslPropertyManager.valueChangedString(886, string);
    }

    void storeSpellerData() {
        if (this.isStoreSpellerDataRequested) {
            AbstractASLHsmTarget.writeSpellerDataToDatapool(888, this.getSpellerData());
            this.isStoreSpellerDataRequested = false;
            if (this.LOGGER.isTraceEnabled()) {
                this.LOGGER.trace(new StringBuffer().append("Store speller data: ").append(this.getSpellerData().toString()).toString());
            }
        }
    }

    boolean isHwrEnabled() {
        return this.isHwrEnabled;
    }

    void setHwrEnabled(boolean bl) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(1127358464, bl);
        this.isHwrEnabled = bl;
    }

    int getSearchType() {
        return this.searchType;
    }

    void setSearchType(int n) {
        this.searchType = n;
    }

    int getSpellerHandle() {
        return this.spellerHandle;
    }

    void setSpellerHandle(int n) {
        this.spellerHandle = n;
    }

    String getSpellerString() {
        return this.spellerString;
    }

    void setSpellerString(String string) {
        this.spellerString = string;
    }

    boolean isRestartSearchSpeller() {
        return this.restartSearchSpeller;
    }

    void setRestartSearchSpeller(boolean bl) {
        this.restartSearchSpeller = bl;
    }

    int getLastUsedSearchType() {
        return this.lastUsedSearchType;
    }

    void setLastUsedSearchType(int n) {
        this.lastUsedSearchType = n;
    }

    int getAdbSearchMode() {
        return this.adbSearchMode;
    }

    void setAdbSearchMode(int n) {
        this.adbSearchMode = n;
    }

    GenericASLList getResultList() {
        return this.resultList;
    }

    SpellerData getSpellerData() {
        return this.spellerData;
    }

    String getReplaceCharacters() {
        return this.replaceCharacters;
    }

    void setReplaceCharacters(String string) {
        if (string != null && string.length() == 0) {
            string = null;
        }
        this.replaceCharacters = string;
    }

    DataSet[] getLastSearchResults() {
        return this.lastSearchResults;
    }

    void setLastSearchResults(DataSet[] dataSetArray) {
        if (dataSetArray == null) {
            dataSetArray = new DataSet[]{};
        }
        this.lastSearchResults = dataSetArray;
    }

    MemorySearchSpellerFilter getSpellerFilter() {
        return this.spellerFilter;
    }

    int getInvalidCharactersCount() {
        return this.invalidCharactersCount;
    }

    void setInvalidCharactersCount(int n) {
        this.invalidCharactersCount = Math.max(0, n);
    }

    void updateListItems(Object[] objectArray, int n) {
        if (objectArray == null) {
            objectArray = new Object[]{};
        }
        this.getResultList().setSize(n);
        this.getResultList().updateListItems(0, (Object[])objectArray.clone());
    }

    void clearResultList() {
        this.updateListItems(new Object[0], 0);
    }

    void restoreLastValidResultList() {
        if (this.getInvalidCharactersCount() == 0) {
            this.updateListItems(this.lastSearchResults, this.lastSearchResults.length);
        }
    }

    void requestStoreSpellerData() {
        this.isStoreSpellerDataRequested = true;
    }

    void resetRequestStoreSpellerData() {
        this.isStoreSpellerDataRequested = false;
    }

    public void setSpellerStopped(boolean bl) {
        if (ServiceManager.logger.isTraceEnabled(16384)) {
            ServiceManager.logger.trace(16384, new StringBuffer().append("setSpellerStopped() - old value: ").append(this.isSpellerStopped).append(", new value: ").append(bl).toString());
        }
        this.isSpellerStopped = bl;
    }

    public boolean isSpellerStopped() {
        if (ServiceManager.logger.isTraceEnabled(16384)) {
            ServiceManager.logger.trace(16384, new StringBuffer().append("isSpellerStopped() - ").append(this.isSpellerStopped).toString());
        }
        return this.isSpellerStopped;
    }

    static {
        SWITCH_TO_LIST_RESULT_LIMIT = ServiceManager.configManagerDiag.getNaviCommonOptionDefault(0);
    }
}

