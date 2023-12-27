/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.api.framework.component;

import de.vw.mib.asl.framework.api.framework.component.ASLComponent;
import de.vw.mib.asl.framework.api.framework.component.ASLComponentAPICallback;

public interface ASLComponentRegistry {
    default public void registerASLComponent(ASLComponent aSLComponent) {
    }

    default public ASLComponent getASLComponent(String string) {
    }

    default public void registerAPI(Class clazz, Object object) {
    }

    default public Object getAPIInstance(Class clazz) {
    }

    default public void requestAPI(Class clazz, ASLComponentAPICallback aSLComponentAPICallback) {
    }
}

