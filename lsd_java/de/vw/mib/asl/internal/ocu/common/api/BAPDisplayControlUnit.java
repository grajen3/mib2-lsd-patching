/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.common.api;

import de.vw.mib.asl.api.bap.lcu.BAPLogicalControlUnit;
import de.vw.mib.bap.marshalling.BAPFunctionListenerRegistry;
import de.vw.mib.bap.marshalling.BAPFunctionRegistry;
import de.vw.mib.bap.marshalling.BAPRequestMarshaller;
import de.vw.mib.bap.marshalling.BAPService;
import de.vw.mib.bap.marshalling.BAPServiceListener;
import de.vw.mib.bap.stream.BitStreamTransformer;

public interface BAPDisplayControlUnit
extends BAPLogicalControlUnit {
    default public void reinitialize() {
    }

    default public void uninitialize() {
    }

    default public BAPFunctionListenerRegistry getFunctionListenerRegistry() {
    }

    default public BAPFunctionRegistry getFunctionRegistry() {
    }

    default public BitStreamTransformer getBitStreamTransformer() {
    }

    default public BAPServiceListener getBAPDemarshaller() {
    }

    default public BAPRequestMarshaller getBAPMarshaller() {
    }

    default public BAPService getBAPService() {
    }
}

