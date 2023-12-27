/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.api.impl.ext.locationinput;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.api.navigation.memory.ITbmResultListener;
import de.vw.mib.asl.internal.navigation.api.impl.ext.INavigationLocationImpl;
import de.vw.mib.asl.internal.navigation.api.impl.ext.locationinput.NavigationLocationinputServiceImpl;
import org.dsi.ifc.navigation.TryBestMatchResultData;

class NavigationLocationinputServiceImpl$3
implements ITbmResultListener {
    private final /* synthetic */ NavigationLocationinputServiceImpl this$0;

    NavigationLocationinputServiceImpl$3(NavigationLocationinputServiceImpl navigationLocationinputServiceImpl) {
        this.this$0 = navigationLocationinputServiceImpl;
    }

    @Override
    public void handleResultTbm(TryBestMatchResultData[] tryBestMatchResultDataArray, Object object) {
        INavigationLocation[] iNavigationLocationArray = new INavigationLocation[tryBestMatchResultDataArray.length];
        for (int i2 = 0; i2 < tryBestMatchResultDataArray.length; ++i2) {
            iNavigationLocationArray[i2] = new INavigationLocationImpl(tryBestMatchResultDataArray[i2].getLocation());
        }
        this.this$0.listener.resolveContactResult(iNavigationLocationArray, object);
    }
}

