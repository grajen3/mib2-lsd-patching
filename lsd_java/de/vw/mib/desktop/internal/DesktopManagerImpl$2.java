/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.desktop.internal;

import de.vw.mib.desktop.internal.DesktopManagerImpl;
import java.util.Comparator;

class DesktopManagerImpl$2
implements Comparator {
    private final /* synthetic */ DesktopManagerImpl this$0;

    DesktopManagerImpl$2(DesktopManagerImpl desktopManagerImpl) {
        this.this$0 = desktopManagerImpl;
    }

    @Override
    public int compare(Object object, Object object2) {
        return object2.toString().length() - object.toString().length();
    }
}

