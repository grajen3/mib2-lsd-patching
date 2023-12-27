/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.adbedit;

import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.adbedit.DSIAdbEditVWImpl;
import de.vw.mib.genericevents.AbstractTarget;
import org.dsi.ifc.organizer.DSIAdbEdit;
import org.dsi.ifc.organizer.DSIAdbEditListener;

public class DSIAdbEditTargetData {
    private int[] attributes;
    private DSIAdbEdit dsiAdbEdit;
    private DSIAdbEditListener dsiAdbEditListener;
    private DSIAdbEditVWImpl dsiAdbEditVW;
    private AbstractTarget target;

    public int[] getAttributes() {
        return this.attributes;
    }

    public DSIAdbEdit getDsiAdbEdit() {
        return this.dsiAdbEdit;
    }

    public DSIAdbEditListener getDsiAdbEditListener() {
        return this.dsiAdbEditListener;
    }

    public DSIAdbEditVWImpl getDsiAdbEditVW() {
        return this.dsiAdbEditVW;
    }

    public AbstractTarget getTarget() {
        return this.target;
    }

    public void setAttributes(int[] nArray) {
        this.attributes = nArray;
    }

    public void setDsiAdbEdit(DSIAdbEdit dSIAdbEdit) {
        this.dsiAdbEdit = dSIAdbEdit;
    }

    public void setDsiAdbEditListener(DSIAdbEditListener dSIAdbEditListener) {
        this.dsiAdbEditListener = dSIAdbEditListener;
    }

    public void setDsiAdbEditVW(DSIAdbEditVWImpl dSIAdbEditVWImpl) {
        this.dsiAdbEditVW = dSIAdbEditVWImpl;
    }

    public void setTarget(AbstractTarget abstractTarget) {
        this.target = abstractTarget;
    }
}

