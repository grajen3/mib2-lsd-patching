/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.objectweb.asm.Type
 *  org.objectweb.asm.commons.GeneratorAdapter
 */
package de.vw.mib.asl.framework.internal.framework.dsi.build;

import de.vw.mib.asl.framework.internal.framework.dsi.build.ProxyTargetCompiler;
import de.vw.mib.asl.framework.internal.framework.reflection.build.Compiler;
import de.vw.mib.asl.framework.internal.framework.reflection.build.StandardArrayWriter;
import org.objectweb.asm.Type;
import org.objectweb.asm.commons.GeneratorAdapter;

class ProxyTargetCompiler$EmptyRefArrayWriter
extends StandardArrayWriter {
    private final Type classType;

    ProxyTargetCompiler$EmptyRefArrayWriter(Type type) {
        this.classType = type;
    }

    @Override
    public void pushNullArray(GeneratorAdapter generatorAdapter, Class clazz) {
        if ((ProxyTargetCompiler.array$I == null ? (ProxyTargetCompiler.array$I = ProxyTargetCompiler.class$("[I")) : ProxyTargetCompiler.array$I) == clazz) {
            generatorAdapter.getStatic(this.classType, "_ZIA", Compiler.INT_A_TYPE);
        } else if ((ProxyTargetCompiler.array$$I == null ? (ProxyTargetCompiler.array$$I = ProxyTargetCompiler.class$("[[I")) : ProxyTargetCompiler.array$$I) == clazz) {
            generatorAdapter.getStatic(this.classType, "_ZI2A", Compiler.INT_2A_TYPE);
        } else {
            super.pushNullArray(generatorAdapter, clazz);
        }
    }

    @Override
    public void pushEmptyArray(GeneratorAdapter generatorAdapter, Class clazz, Object object) {
        if ((ProxyTargetCompiler.array$I == null ? (ProxyTargetCompiler.array$I = ProxyTargetCompiler.class$("[I")) : ProxyTargetCompiler.array$I) == clazz) {
            generatorAdapter.getStatic(this.classType, "_ZIA", Compiler.INT_A_TYPE);
        } else if ((ProxyTargetCompiler.array$$I == null ? (ProxyTargetCompiler.array$$I = ProxyTargetCompiler.class$("[[I")) : ProxyTargetCompiler.array$$I) == clazz) {
            generatorAdapter.getStatic(this.classType, "_ZI2A", Compiler.INT_2A_TYPE);
        } else {
            super.pushEmptyArray(generatorAdapter, clazz, object);
        }
    }
}

