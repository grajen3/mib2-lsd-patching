/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api;

import de.vw.mib.asl.api.bap.lcu.BAPFunctionControlUnit;
import de.vw.mib.bap.marshalling.BAPFunctionRegistry;
import de.vw.mib.bap.marshalling.BAPIndicationMarshaller;
import de.vw.mib.bap.marshalling.BAPServiceListener;
import de.vw.mib.bap.mqbab2.common.api.adapter.AbstractBAPDataPool;

public interface BAPFunctionControlUnitExt
extends BAPFunctionControlUnit {
    default public void reinitialize() {
    }

    default public void uninitialize() {
    }

    default public AbstractBAPDataPool getContextDataPool() {
    }

    default public BAPFunctionRegistry getFunctionRegistry() {
    }

    default public BAPIndicationMarshaller getBAPMarshaller() {
    }

    default public BAPServiceListener getBAPDemarshaller() {
    }
}

