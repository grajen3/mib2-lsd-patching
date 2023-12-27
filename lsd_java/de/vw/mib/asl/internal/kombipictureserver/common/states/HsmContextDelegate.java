/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.kombipictureserver.common.states;

import de.vw.mib.asl.internal.kombipictureserver.common.controller.Controller;
import de.vw.mib.asl.internal.kombipictureserver.common.services.AslServiceProvider;
import de.vw.mib.asl.internal.kombipictureserver.common.services.DsiServiceProvider;
import de.vw.mib.log4mib.Logger;

public interface HsmContextDelegate {
    default public void initialize() {
    }

    default public void addObservers(int[] nArray) {
    }

    default public Controller getController() {
    }

    default public AslServiceProvider getServiceProvider() {
    }

    default public DsiServiceProvider getDsiServiceProvider() {
    }

    default public Logger getLogger() {
    }

    default public int getSubClassifier() {
    }
}

