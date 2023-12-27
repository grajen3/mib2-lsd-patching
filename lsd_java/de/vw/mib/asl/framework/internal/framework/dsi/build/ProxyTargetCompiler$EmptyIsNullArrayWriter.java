/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.objectweb.asm.commons.GeneratorAdapter
 */
package de.vw.mib.asl.framework.internal.framework.dsi.build;

import de.vw.mib.asl.framework.internal.framework.reflection.build.StandardArrayWriter;
import org.objectweb.asm.commons.GeneratorAdapter;

class ProxyTargetCompiler$EmptyIsNullArrayWriter
extends StandardArrayWriter {
    ProxyTargetCompiler$EmptyIsNullArrayWriter() {
    }

    @Override
    public void pushEmptyArray(GeneratorAdapter generatorAdapter, Class clazz, Object object) {
        this.pushNullArray(generatorAdapter, clazz);
    }
}

