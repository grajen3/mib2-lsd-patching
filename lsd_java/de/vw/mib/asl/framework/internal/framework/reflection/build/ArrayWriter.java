/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.objectweb.asm.commons.GeneratorAdapter
 */
package de.vw.mib.asl.framework.internal.framework.reflection.build;

import org.objectweb.asm.commons.GeneratorAdapter;

public interface ArrayWriter {
    default public void pushArray(GeneratorAdapter generatorAdapter, Class clazz, Object object) {
    }

    default public void pushNullArray(GeneratorAdapter generatorAdapter, Class clazz) {
    }

    default public void pushEmptyArray(GeneratorAdapter generatorAdapter, Class clazz, Object object) {
    }

    default public void pushNonEmptyArray(GeneratorAdapter generatorAdapter, Class clazz, Object object, int n) {
    }
}

