/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mostkombi.master.states;

import de.vw.mib.asl.internal.mostkombi.common.controller.Controller;
import de.vw.mib.asl.internal.mostkombi.common.states.HsmContextDelegate;

public interface MostKombiHsmContextDelegate
extends HsmContextDelegate {
    default public void addStartedKombiController(Controller controller) {
    }
}

