/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl;

import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl.ModuleDescriptor;

public interface PersistableModuleAddedListener {
    default public void onPersistableModuleAdded(ModuleDescriptor moduleDescriptor) {
    }
}

