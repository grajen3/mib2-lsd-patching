/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.cio.internal;

import de.vw.mib.cio.CioIntent;
import de.vw.mib.cio.internal.Dictionary;
import java.util.Comparator;

class Dictionary$1
implements Comparator {
    private final /* synthetic */ Dictionary this$0;

    Dictionary$1(Dictionary dictionary) {
        this.this$0 = dictionary;
    }

    @Override
    public int compare(Object object, Object object2) {
        CioIntent cioIntent = (CioIntent)object;
        CioIntent cioIntent2 = (CioIntent)object2;
        return cioIntent.getCioIntentName().compareTo(cioIntent2.getCioIntentName());
    }
}

