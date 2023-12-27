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
package de.vw.mib.reflection.impl.ma;

import de.vw.mib.reflection.impl.ClassGenerator;
import de.vw.mib.reflection.impl.Constants;
import java.lang.reflect.Modifier;
import org.objectweb.asm.Label;
import org.objectweb.asm.Type;
import org.objectweb.asm.commons.GeneratorAdapter;
import org.objectweb.asm.commons.Method;
import org.objectweb.asm.commons.TableSwitchGenerator;

public final class InvokeSwitchGenerator
implements TableSwitchGenerator,
Constants {
    private final Class type;
    private final Type asmType;
    private final java.lang.reflect.Method[] javaMethods;
    private final Method[] asmMethods;
    private final GeneratorAdapter generator;

    public InvokeSwitchGenerator(Class clazz, java.lang.reflect.Method[] methodArray, Method[] methodArray2, GeneratorAdapter generatorAdapter) {
        this.type = clazz;
        this.asmType = Type.getType((Class)clazz);
        this.javaMethods = methodArray;
        this.asmMethods = methodArray2;
        this.generator = generatorAdapter;
    }

    public void generateCase(int n, Label label) {
        if (!Modifier.isStatic(this.javaMethods[n].getModifiers())) {
            this.generator.loadArg(1);
            this.generator.checkCast(this.asmType);
        }
        Class[] classArray = this.javaMethods[n].getParameterTypes();
        for (int i2 = 0; i2 < classArray.length; ++i2) {
            this.generator.loadArg(2);
            this.generator.push(i2);
            this.generator.arrayLoad(OBJ_ASM_T);
            this.generator.unbox(Type.getType((Class)classArray[i2]));
        }
        if (this.type.isInterface()) {
            this.generator.invokeInterface(this.asmType, this.asmMethods[n]);
        } else if (!Modifier.isStatic(this.javaMethods[n].getModifiers())) {
            this.generator.invokeVirtual(this.asmType, this.asmMethods[n]);
        } else {
            this.generator.invokeStatic(this.asmType, this.asmMethods[n]);
        }
        Type type = this.asmMethods[n].getReturnType();
        if (type.getSort() != 0) {
            ClassGenerator.box(type, this.generator);
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

