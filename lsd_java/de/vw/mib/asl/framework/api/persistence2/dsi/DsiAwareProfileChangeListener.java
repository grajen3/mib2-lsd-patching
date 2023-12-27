/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.api.persistence2.dsi;

import de.vw.mib.asl.framework.api.persistence2.dsi.DsiAwareProfileChangeListenerCallback;

public interface DsiAwareProfileChangeListener {
    default public void prepareForProfileChange(DsiAwareProfileChangeListenerCallback dsiAwareProfileChangeListenerCallback) {
    }

    default public void changeProfilePreDsi(DsiAwareProfileChangeListenerCallback dsiAwareProfileChangeListenerCallback) {
    }

    default public void changeProfilePostDsi(DsiAwareProfileChangeListenerCallback dsiAwareProfileChangeListenerCallback) {
    }
}

