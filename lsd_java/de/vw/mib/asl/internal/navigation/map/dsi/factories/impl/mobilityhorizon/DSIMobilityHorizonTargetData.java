/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mobilityhorizon;

import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mobilityhorizon.DSIMobilityHorizonVWImpl;
import de.vw.mib.genericevents.AbstractTarget;
import org.dsi.ifc.mobilityhorizon.DSIMobilityHorizon;
import org.dsi.ifc.mobilityhorizon.DSIMobilityHorizonListener;

public class DSIMobilityHorizonTargetData {
    private int[] attributes;
    private DSIMobilityHorizonListener dsiMobilityHorizonListener;
    private DSIMobilityHorizonVWImpl dsiMobilityHorizonVW;
    private DSIMobilityHorizon dsiMobilityHorizon;
    private AbstractTarget target;

    public int[] getAttributes() {
        return this.attributes;
    }

    public DSIMobilityHorizon getDsiMobilityHorizon() {
        return this.dsiMobilityHorizon;
    }

    public DSIMobilityHorizonListener getDsiMobilityHorizonListener() {
        return this.dsiMobilityHorizonListener;
    }

    public DSIMobilityHorizonVWImpl getDsiMobilityHorizonVW() {
        return this.dsiMobilityHorizonVW;
    }

    public AbstractTarget getTarget() {
        return this.target;
    }

    public void setAttributes(int[] nArray) {
        this.attributes = nArray;
    }

    public void setDsiMobilityHorizon(DSIMobilityHorizon dSIMobilityHorizon) {
        this.dsiMobilityHorizon = dSIMobilityHorizon;
    }

    public void setDsiMobilityHorizonListener(DSIMobilityHorizonListener dSIMobilityHorizonListener) {
        this.dsiMobilityHorizonListener = dSIMobilityHorizonListener;
    }

    public void setDsiMobilityHorizonVW(DSIMobilityHorizonVWImpl dSIMobilityHorizonVWImpl) {
        this.dsiMobilityHorizonVW = dSIMobilityHorizonVWImpl;
    }

    public void setTarget(AbstractTarget abstractTarget) {
        this.target = abstractTarget;
    }
}

