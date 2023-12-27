/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mapviewer;

import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mapviewer.DSIMapViewerControlVWImpl;
import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.genericevents.hsm.Hsm;
import org.dsi.ifc.map.DSIMapViewerControl;
import org.dsi.ifc.map.DSIMapViewerControlListener;

public class DSIMapViewerManagerClientData {
    public static final int INDEX_ONBOARD;
    public static final int INDEX_GOOGLE_EARTH;
    private int[] attributes;
    private DSIMapViewerControlVWImpl dsiMapViewerControlVW;
    private Hsm hsm;
    private DSIMapViewerControl[] mapViewerControlAvailable;
    private DSIMapViewerControlListener[] mapViewerControlListenerAvailable;
    private AbstractTarget target;

    public int[] getAttributes() {
        return this.attributes;
    }

    public DSIMapViewerControlVWImpl getDsiMapViewerControlVW() {
        return this.dsiMapViewerControlVW;
    }

    public Hsm getHsm() {
        return this.hsm;
    }

    public DSIMapViewerControl[] getMapViewerControlAvailable() {
        return this.mapViewerControlAvailable;
    }

    public DSIMapViewerControlListener[] getMapViewerControlListenerAvailable() {
        return this.mapViewerControlListenerAvailable;
    }

    public AbstractTarget getTarget() {
        return this.target;
    }

    public void setAttributes(int[] nArray) {
        this.attributes = nArray;
    }

    public void setDsiMapViewerControlVW(DSIMapViewerControlVWImpl dSIMapViewerControlVWImpl) {
        this.dsiMapViewerControlVW = dSIMapViewerControlVWImpl;
    }

    public void setHsm(Hsm hsm) {
        this.hsm = hsm;
    }

    public void setMapViewerControlAvailable(DSIMapViewerControl[] dSIMapViewerControlArray) {
        this.mapViewerControlAvailable = dSIMapViewerControlArray;
    }

    public void setMapViewerControlListenerAvailable(DSIMapViewerControlListener[] dSIMapViewerControlListenerArray) {
        this.mapViewerControlListenerAvailable = dSIMapViewerControlListenerArray;
    }

    public void setTarget(AbstractTarget abstractTarget) {
        this.target = abstractTarget;
    }
}

