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
package de.vw.mib.reflection.impl.ca;

import de.vw.mib.reflection.impl.Constants;
import java.lang.reflect.Constructor;
import org.objectweb.asm.Label;
import org.objectweb.asm.Type;
import org.objectweb.asm.commons.GeneratorAdapter;
import org.objectweb.asm.commons.Method;
import org.objectweb.asm.commons.TableSwitchGenerator;

public final class NewInstanceSwitchGenerator
implements TableSwitchGenerator,
Constants {
    private final Type asmType;
    private final Constructor[] javaConstructors;
    private final GeneratorAdapter generator;

    public NewInstanceSwitchGenerator(Type type, Constructor[] constructorArray, GeneratorAdapter generatorAdapter) {
        this.asmType = type;
        this.javaConstructors = constructorArray;
        this.generator = generatorAdapter;
    }

    public void generateCase(int n, Label label) {
        this.generator.newInstance(this.asmType);
        this.generator.dup();
        Class[] classArray = this.javaConstructors[n].getParameterTypes();
        for (int i2 = 0; i2 < classArray.length; ++i2) {
            this.generator.loadArg(1);
            this.generator.push(i2);
            this.generator.arrayLoad(OBJ_ASM_T);
            this.generator.unbox(Type.getType((Class)classArray[i2]));
        }
        Method method = Method.getMethod((Constructor)this.javaConstructors[n]);
        this.generator.invokeConstructor(this.asmType, method);
        this.generator.returnValue();
    }

    public void generateDefault() {
        this.generator.push((String)null);
        this.generator.returnValue();
    }
}

