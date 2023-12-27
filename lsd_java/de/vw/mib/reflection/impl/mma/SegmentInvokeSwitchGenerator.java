/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.objectweb.asm.Label
 *  org.objectweb.asm.Type
 *  org.objectweb.asm.commons.GeneratorAdapter
 *  org.objectweb.asm.commons.Method
 *  org.objectweb.asm.commons.TableSwitchGenerator
 */
package de.vw.mib.reflection.impl.mma;

import de.vw.mib.reflection.impl.ClassGenerator;
import de.vw.mib.reflection.impl.Constants;
import java.lang.reflect.Modifier;
import org.objectweb.asm.Label;
import org.objectweb.asm.Type;
import org.objectweb.asm.commons.GeneratorAdapter;
import org.objectweb.asm.commons.Method;
import org.objectweb.asm.commons.TableSwitchGenerator;

public final class SegmentInvokeSwitchGenerator
implements TableSwitchGenerator,
Constants {
    private final Class[] javaTypes;
    private final Type[] asmTypes;
    private final java.lang.reflect.Method[][] javaMethods;
    private final Method[][] asmMethods;
    private final int[][] keysMethodsMap;
    private final GeneratorAdapter generator;

    public SegmentInvokeSwitchGenerator(Class[] classArray, Type[] typeArray, java.lang.reflect.Method[][] methodArray, Method[][] methodArray2, int[][] nArray, GeneratorAdapter generatorAdapter) {
        this.javaTypes = classArray;
        this.asmTypes = typeArray;
        this.javaMethods = methodArray;
        this.asmMethods = methodArray2;
        this.keysMethodsMap = nArray;
        this.generator = generatorAdapter;
    }

    public void generateCase(int n, Label label) {
        int n2 = this.keysMethodsMap[n][0];
        int n3 = this.keysMethodsMap[n][1];
        Class clazz = this.javaTypes[n2];
        Type type = this.asmTypes[n2];
        java.lang.reflect.Method method = this.javaMethods[n2][n3];
        Method method2 = this.asmMethods[n2][n3];
        if (!Modifier.isStatic(method.getModifiers())) {
            this.generator.loadArg(1);
            this.generator.checkCast(type);
        }
        Type[] typeArray = method2.getArgumentTypes();
        for (int i2 = 0; i2 < typeArray.length; ++i2) {
            this.generator.loadArg(2);
            this.generator.push(i2);
            this.generator.arrayLoad(OBJ_ASM_T);
            this.generator.unbox(typeArray[i2]);
        }
        if (clazz.isInterface()) {
            this.generator.invokeInterface(type, method2);
        } else if (!Modifier.isStatic(method.getModifiers())) {
            this.generator.invokeVirtual(type, method2);
        } else {
            this.generator.invokeStatic(type, method2);
        }
        Type type2 = method2.getReturnType();
        if (type2.getSort() != 0) {
            ClassGenerator.box(type2, this.generator);
        } else {
            this.generator.push((String)null);
        }
        this.generator.returnValue();
    }

    public void generateDefault() {
        this.generator.push((String)null);
        this.generator.returnValue();
    }
}

