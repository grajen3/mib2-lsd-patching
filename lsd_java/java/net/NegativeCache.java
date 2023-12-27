/*
 * Decompiled with CFR 0.152.
 */
package java.net;

import com.ibm.oti.util.PriviAction;
import java.net.NegCacheElement;
import java.security.AccessController;
import java.util.LinkedHashMap;
import java.util.Map$Entry;

class NegativeCache
extends LinkedHashMap {
    static NegativeCache negCache = null;
    static final int MAX_NEGATIVE_ENTRIES;
    static final float LOADING;

    NegativeCache(int n, float f2, boolean bl) {
        super(n, f2, bl);
    }

    @Override
    protected boolean removeEldestEntry(Map$Entry map$Entry) {
        return this.size() > 5;
    }

    static void put(String string, String string2) {
        NegativeCache.checkCacheExists();
        negCache.put(string, new NegCacheElement(string2));
    }

    static String getFailedMessage(String string) {
        NegativeCache.checkCacheExists();
        NegCacheElement negCacheElement = (NegCacheElement)negCache.get(string);
        if (negCacheElement != null) {
            String string2 = (String)AccessController.doPrivileged(new PriviAction("networkaddress.cache.negative.ttl"));
            int n = 10;
            try {
                if (string2 != null) {
                    n = Integer.decode(string2);
                }
            }
            catch (NumberFormatException numberFormatException) {}
            if (n == 0) {
                negCache.clear();
                negCacheElement = null;
            } else if (n != -1 && negCacheElement.timeAdded + (long)(n * 1000) < System.currentTimeMillis()) {
                negCache.remove(string);
                negCacheElement = null;
            }
        }
        if (negCacheElement != null) {
            return negCacheElement.hostName();
        }
        return null;
    }

    static void checkCacheExists() {
        if (negCache == null) {
            negCache = new NegativeCache(6, 16447, true);
        }
    }
}

