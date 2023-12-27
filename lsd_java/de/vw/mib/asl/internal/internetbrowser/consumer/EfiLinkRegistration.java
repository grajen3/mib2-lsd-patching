/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.internetbrowser.consumer;

import de.vw.mib.asl.internal.internetbrowser.consumer.EfiLinkConsumer;
import de.vw.mib.collections.ints.IntArrayList;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.util.Util;
import java.util.Iterator;

public final class EfiLinkRegistration {
    private final IntObjectOptHashMap _registrationMap = new IntObjectOptHashMap();

    public boolean registerConsumer(int n, String string) {
        boolean bl = false;
        EfiLinkConsumer efiLinkConsumer = (EfiLinkConsumer)this._registrationMap.get(n);
        if (efiLinkConsumer == null) {
            efiLinkConsumer = new EfiLinkConsumer(n);
            this._registrationMap.put(n, efiLinkConsumer);
        }
        if (!Util.isNullOrEmpty(string)) {
            bl = efiLinkConsumer.addAction(string);
        }
        return bl;
    }

    public boolean unregisterConsumer(int n, String string) {
        boolean bl = false;
        boolean bl2 = false;
        EfiLinkConsumer efiLinkConsumer = (EfiLinkConsumer)this._registrationMap.get(n);
        if (efiLinkConsumer != null) {
            if (Util.isNullOrEmpty(string)) {
                bl2 = true;
            } else {
                bl = bl2 = efiLinkConsumer.removeAction(string);
            }
            if (bl2 && this._registrationMap.remove(n) != null) {
                bl = true;
            }
        }
        return bl;
    }

    public IntArrayList getConsumerForAction(String string) {
        IntArrayList intArrayList = new IntArrayList();
        Iterator iterator = this._registrationMap.values().iterator();
        try {
            while (iterator.hasNext()) {
                EfiLinkConsumer efiLinkConsumer = (EfiLinkConsumer)iterator.next();
                if (efiLinkConsumer == null || !efiLinkConsumer.isAction(string)) continue;
                intArrayList.add(efiLinkConsumer.getTargetId());
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        return intArrayList;
    }
}

