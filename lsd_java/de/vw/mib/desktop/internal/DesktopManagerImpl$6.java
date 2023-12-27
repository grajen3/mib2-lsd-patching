/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.desktop.internal;

import de.vw.mib.desktop.internal.DesktopManagerImpl;
import java.util.Comparator;
import java.util.Map$Entry;

class DesktopManagerImpl$6
implements Comparator {
    private final /* synthetic */ DesktopManagerImpl this$0;

    DesktopManagerImpl$6(DesktopManagerImpl desktopManagerImpl) {
        this.this$0 = desktopManagerImpl;
    }

    @Override
    public int compare(Object object, Object object2) {
        return ((Map$Entry)object2).getKey().toString().length() - ((Map$Entry)object).getKey().toString().length();
    }
}

