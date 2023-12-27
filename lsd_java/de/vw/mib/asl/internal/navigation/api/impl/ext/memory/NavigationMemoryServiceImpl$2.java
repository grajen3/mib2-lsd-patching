/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.api.impl.ext.memory;

import de.vw.mib.asl.api.navigation.memory.IEntriesResultListener;
import de.vw.mib.asl.api.navigation.memory.INavigationContact;
import de.vw.mib.asl.internal.navigation.api.impl.ext.memory.INavigationContactImpl;
import de.vw.mib.asl.internal.navigation.api.impl.ext.memory.NavigationMemoryServiceImpl;
import org.dsi.ifc.organizer.AdbEntry;

class NavigationMemoryServiceImpl$2
implements IEntriesResultListener {
    private final /* synthetic */ NavigationMemoryServiceImpl this$0;

    NavigationMemoryServiceImpl$2(NavigationMemoryServiceImpl navigationMemoryServiceImpl) {
        this.this$0 = navigationMemoryServiceImpl;
    }

    @Override
    public void handleResultEntries(int n, AdbEntry[] adbEntryArray, Object object) {
        INavigationContact[] iNavigationContactArray = new INavigationContact[adbEntryArray.length];
        for (int i2 = 0; i2 < iNavigationContactArray.length; ++i2) {
            iNavigationContactArray[i2] = new INavigationContactImpl(adbEntryArray[i2]);
        }
        this.this$0.listener.getContactsResult(n, iNavigationContactArray, object);
    }
}

