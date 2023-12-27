/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.system;

import de.vw.mib.genericevents.Target;
import org.dsi.ifc.keypanel.DSIKeyPanelListener;

public interface ASLSystemKeyPanelHandling
extends DSIKeyPanelListener,
Target {
    default public void updateEncoder(int n, int n2, int n3, int n4) {
    }

    default public void updateKey(int n, int n2, int n3, int n4) {
    }
}

