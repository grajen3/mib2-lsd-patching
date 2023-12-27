/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.common.functions;

import de.vw.mib.bap.functions.BAPDisplayFunctionControllerDelegate;
import de.vw.mib.bap.functions.BAPFunctionController;
import de.vw.mib.bap.functions.BAPFunctionListener;

public interface BAPOcuFunctionControllerDelegate
extends BAPDisplayFunctionControllerDelegate {
    default public void registerServiceListener(BAPFunctionController bAPFunctionController, Class clazz, int[] nArray) {
    }

    default public void unregisterServiceListener(BAPFunctionController bAPFunctionController, Class clazz, int[] nArray) {
    }

    default public void registerServiceProvider(BAPFunctionController bAPFunctionController, Class clazz, int[] nArray) {
    }

    default public void unRegisterServiceProvider(BAPFunctionController bAPFunctionController, Class clazz, int[] nArray) {
    }

    default public void registerServiceProviderListener(BAPFunctionController bAPFunctionController, Class clazz, int[] nArray) {
    }

    default public void unRegisterServiceProviderListener(BAPFunctionController bAPFunctionController, Class clazz, int[] nArray) {
    }

    default public Object getService(Class clazz) {
    }

    default public BAPFunctionListener getBAPFunctionListener(int n) {
    }

    default public boolean isInitialized(BAPFunctionController bAPFunctionController) {
    }
}

