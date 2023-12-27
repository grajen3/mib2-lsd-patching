/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation.locationinput;

import de.vw.mib.asl.api.navigation.INavigationListElement;
import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.api.navigation.locationinput.IHnrFlags;
import org.dsi.ifc.global.ResourceLocator;

public interface NavigationLocationinputListener {
    default public void updateLockTimeout(int n, boolean bl) {
    }

    default public void updateLock(boolean bl) {
    }

    default public void updateInputState(int n, INavigationLocation iNavigationLocation, boolean bl, int[] nArray) {
    }

    default public void updateInputState(int n, INavigationLocation iNavigationLocation, boolean bl, int[] nArray, boolean bl2, boolean bl3) {
    }

    default public void updateCountryIcon(INavigationLocation iNavigationLocation, ResourceLocator resourceLocator) {
    }

    default public void updateInputActive(boolean bl) {
    }

    default public void valueListBlock(INavigationListElement[] iNavigationListElementArray, int n, IHnrFlags iHnrFlags) {
    }

    default public void valueListBlock(INavigationListElement[] iNavigationListElementArray, int n) {
    }

    default public void resolveContactResult(INavigationLocation[] iNavigationLocationArray, Object object) {
    }

    default public void updateSpecialFlags(IHnrFlags iHnrFlags) {
    }
}

