/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation.locationinput;

import de.vw.mib.asl.api.navigation.INavigationListElement;
import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.api.navigation.locationinput.IHnrFlags;
import de.vw.mib.asl.api.navigation.locationinput.NavigationLocationinputListener;
import org.dsi.ifc.global.ResourceLocator;

public class NavigationLocationinputListenerAdapter
implements NavigationLocationinputListener {
    @Override
    public void updateLockTimeout(int n, boolean bl) {
    }

    @Override
    public void updateInputState(int n, INavigationLocation iNavigationLocation, boolean bl, int[] nArray) {
    }

    @Override
    public void updateInputState(int n, INavigationLocation iNavigationLocation, boolean bl, int[] nArray, boolean bl2, boolean bl3) {
        this.updateInputState(n, iNavigationLocation, bl, nArray);
    }

    @Override
    public void updateInputActive(boolean bl) {
    }

    @Override
    public void valueListBlock(INavigationListElement[] iNavigationListElementArray, int n) {
    }

    @Override
    public void updateLock(boolean bl) {
        this.updateLockTimeout(0, bl);
    }

    @Override
    public void resolveContactResult(INavigationLocation[] iNavigationLocationArray, Object object) {
    }

    @Override
    public void updateSpecialFlags(IHnrFlags iHnrFlags) {
    }

    @Override
    public void valueListBlock(INavigationListElement[] iNavigationListElementArray, int n, IHnrFlags iHnrFlags) {
        this.valueListBlock(iNavigationListElementArray, n);
        this.updateSpecialFlags(iHnrFlags);
    }

    @Override
    public void updateCountryIcon(INavigationLocation iNavigationLocation, ResourceLocator resourceLocator) {
    }
}

