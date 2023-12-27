/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.api.impl.ext.locationinput;

import de.vw.mib.asl.api.navigation.locationinput.IHnrFlags;
import de.vw.mib.asl.api.navigation.locationinput.ILocationinputResultListener;
import de.vw.mib.asl.api.navigation.locationinput.NavigationLocationinputListener;
import de.vw.mib.asl.internal.navigation.api.impl.ext.INavigationLocationImpl;
import de.vw.mib.asl.internal.navigation.api.impl.ext.locationinput.NavigationLocationinputServiceImpl;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueList;

class NavigationLocationinputServiceImpl$5
implements ILocationinputResultListener {
    private final /* synthetic */ NavigationLocationinputListener val$listener;
    private final /* synthetic */ NavigationLocationinputServiceImpl this$0;

    NavigationLocationinputServiceImpl$5(NavigationLocationinputServiceImpl navigationLocationinputServiceImpl, NavigationLocationinputListener navigationLocationinputListener) {
        this.this$0 = navigationLocationinputServiceImpl;
        this.val$listener = navigationLocationinputListener;
    }

    @Override
    public void updateInputActive(boolean bl) {
    }

    @Override
    public void updateState(NavLocation navLocation, int[] nArray, boolean bl, boolean bl2, boolean bl3) {
        this.val$listener.updateInputState(-1, new INavigationLocationImpl(navLocation), bl, nArray, bl2, bl3);
    }

    @Override
    public void updateValueList(LIValueList lIValueList, long l, IHnrFlags iHnrFlags) {
    }

    @Override
    public void haptikTakesOwnership() {
    }
}

