/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.navigation;

import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.navigation.DSINavigationVWImpl;
import de.vw.mib.genericevents.AbstractTarget;
import org.dsi.ifc.navigation.DSINavigation;
import org.dsi.ifc.navigation.DSINavigationListener;

public class DSINavigationTargetData {
    private int[] attributes;
    private DSINavigation dsiNavigation;
    private DSINavigationListener dsiNavigationListener;
    private AbstractTarget target;
    private DSINavigationVWImpl dsiNavigationVW;

    public int[] getAttributes() {
        return this.attributes;
    }

    public DSINavigation getDsiNavigation() {
        return this.dsiNavigation;
    }

    public DSINavigationListener getDsiNavigationListener() {
        return this.dsiNavigationListener;
    }

    public DSINavigationVWImpl getDsiNavigationVW() {
        return this.dsiNavigationVW;
    }

    public AbstractTarget getTarget() {
        return this.target;
    }

    public void setAttributes(int[] nArray) {
        this.attributes = nArray;
    }

    public void setDsiNavigation(DSINavigation dSINavigation) {
        this.dsiNavigation = dSINavigation;
    }

    public void setDsiNavigationListener(DSINavigationListener dSINavigationListener) {
        this.dsiNavigationListener = dSINavigationListener;
    }

    public void setDsiNavigationVW(DSINavigationVWImpl dSINavigationVWImpl) {
        this.dsiNavigationVW = dSINavigationVWImpl;
    }

    public void setTarget(AbstractTarget abstractTarget) {
        this.target = abstractTarget;
    }
}

