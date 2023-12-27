/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.api.persistence2;

import de.vw.mib.asl.framework.api.persistence2.PersistableSerializer;

public interface PersistableSerializerFactory {
    default public PersistableSerializer createSerializer(int n) {
    }
}

