/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.kombipictureserver.common.services;

import de.vw.mib.genericevents.Target;
import de.vw.mib.genericevents.hsm.Hsm;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.base.DSIListener;

public interface DsiServiceProvider {
    default public DSIBase getDsiService(Target target, Class clazz) {
    }

    default public DSIBase getDsiService(Hsm hsm, Class clazz) {
    }

    default public DSIListener addDsiServiceResponder(Target target, DSIBase dSIBase, Class clazz, int[] nArray) {
    }

    default public DSIListener addDsiServiceResponder(Hsm hsm, DSIBase dSIBase, Class clazz, int[] nArray) {
    }

    default public void removeDsiServiceResponder(Target target, Class clazz, DSIListener dSIListener, int[] nArray, DSIBase dSIBase) {
    }

    default public void removeDsiServiceResponder(Hsm hsm, Class clazz, DSIListener dSIListener, int[] nArray, DSIBase dSIBase) {
    }
}

