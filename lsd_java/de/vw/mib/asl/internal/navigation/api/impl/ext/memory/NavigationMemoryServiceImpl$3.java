/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.api.impl.ext.memory;

import de.vw.mib.asl.api.navigation.memory.IListResultListener;
import de.vw.mib.asl.api.navigation.memory.INavigationContactListElement;
import de.vw.mib.asl.internal.navigation.api.impl.ext.memory.INavigationContactListElementImpl;
import de.vw.mib.asl.internal.navigation.api.impl.ext.memory.NavigationMemoryServiceImpl;
import org.dsi.ifc.organizer.DataSet;

class NavigationMemoryServiceImpl$3
implements IListResultListener {
    private final /* synthetic */ NavigationMemoryServiceImpl this$0;

    NavigationMemoryServiceImpl$3(NavigationMemoryServiceImpl navigationMemoryServiceImpl) {
        this.this$0 = navigationMemoryServiceImpl;
    }

    @Override
    public void handleResultList(int n, DataSet[] dataSetArray, int n2, Object object) {
        INavigationContactListElement[] iNavigationContactListElementArray = new INavigationContactListElement[dataSetArray.length];
        for (int i2 = 0; i2 < dataSetArray.length; ++i2) {
            iNavigationContactListElementArray[i2] = new INavigationContactListElementImpl(dataSetArray[i2]);
        }
        this.this$0.listener.getContactListBlockResult(iNavigationContactListElementArray, object);
    }
}

