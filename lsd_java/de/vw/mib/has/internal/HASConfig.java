/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.has.internal;

final class HASConfig {
    private static final int MIN_TIMER_INTERVAL;
    private static final int DEFAULT_TIMER_INTERVAL;
    private static final int TIMER_INTERVAL;
    private static final int MIN_PROPERTY_UPDATE_INTERVAL;
    private static final int DEFAULT_PROPERTY_UPDATE_INTERVAL;
    private static final int PROPERTY_UPDATE_INTERVAL;
    private static final int MIN_CALL_TTL;
    private static final int DEFAULT_CALL_TTL;
    private static final int CALL_TTL;
    private static final int MIN_LIST_PAGESIZE;
    private static final int DEFAULT_LIST_PAGESIZE;
    private static final int LIST_PAGESIZE;
    private static final int MIN_LIST_REQUEST_TTL;
    private static final int DEFAULT_LIST_REQUEST_TTL;
    private static final int LIST_REQUEST_TTL;
    private static final int MIN_FETCH_TTL;
    private static final int DEFAULT_FETCH_TTL;
    private static final int FETCH_TTL;
    private static final int MIN_MAX_LIST_REQUESTS;
    private static final int DEFAULT_MAX_LIST_REQUESTS;
    private static final int MAX_LIST_REQUESTS;

    HASConfig() {
    }

    private static int getLowerBoundIntProperty(String string, int n, int n2) {
        return Math.max(n2, Integer.getInteger(string, n));
    }

    static int getTimerInterval() {
        return TIMER_INTERVAL;
    }

    static int getPropertyUpdateInterval() {
        return PROPERTY_UPDATE_INTERVAL;
    }

    static int getCallTTL() {
        return CALL_TTL;
    }

    static int getListPageSize() {
        return LIST_PAGESIZE;
    }

    static int getListRequestTTL() {
        return LIST_REQUEST_TTL;
    }

    static int getFetchTTL() {
        return FETCH_TTL;
    }

    static int getMaxListRequest() {
        return MAX_LIST_REQUESTS;
    }

    static {
        TIMER_INTERVAL = HASConfig.getLowerBoundIntProperty("de.vw.mib.has.timerInterval", 1000, 100);
        PROPERTY_UPDATE_INTERVAL = HASConfig.getLowerBoundIntProperty("de.vw.mib.has.propertyUpdateInterval", 1000, 100);
        CALL_TTL = HASConfig.getLowerBoundIntProperty("de.vw.mib.has.callTTL", 20000, 1000);
        LIST_PAGESIZE = HASConfig.getLowerBoundIntProperty("de.vw.mib.has.listPageSize", 20, 5);
        LIST_REQUEST_TTL = HASConfig.getLowerBoundIntProperty("de.vw.mib.has.listRequestTTL", 20000, 1000);
        FETCH_TTL = HASConfig.getLowerBoundIntProperty("de.vw.mib.has.fetchTTL", 5000, 500);
        MAX_LIST_REQUESTS = HASConfig.getLowerBoundIntProperty("de.vw.mib.has.maxListRequests", 10, 1);
    }
}

