/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.adapter;

import de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.AdapterHandlerRegistry;
import org.dsi.ifc.base.DSIBase;

public interface DSIAdapter {
    default public DSIBase getDSIProxy() {
    }

    default public void initDSIProxy() {
    }

    default public void uninitDSIProxy() {
    }

    default public int getInstanceId() {
    }

    default public void trackSwapState() {
    }

    default public AdapterHandlerRegistry getAdapterHandlerRegistry() {
    }
}

