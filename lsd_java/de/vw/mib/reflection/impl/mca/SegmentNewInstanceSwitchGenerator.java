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
package de.vw.mib.reflection.impl.mca;

import de.vw.mib.reflection.impl.Constants;
import java.lang.reflect.Constructor;
import org.objectweb.asm.Label;
import org.objectweb.asm.Type;
import org.objectweb.asm.commons.GeneratorAdapter;
import org.objectweb.asm.commons.Method;
import org.objectweb.asm.commons.TableSwitchGenerator;

public class SegmentNewInstanceSwitchGenerator
implements TableSwitchGenerator,
Constants {
    private final Type[] asmTypes;
    private final Constructor[][] javaConstructors;
    private final int[][] keysConstructorsMap;
    private final GeneratorAdapter generator;

    public SegmentNewInstanceSwitchGenerator(Type[] typeArray, Constructor[][] constructorArray, int[][] nArray, GeneratorAdapter generatorAdapter) {
        this.asmTypes = typeArray;
        this.javaConstructors = constructorArray;
        this.keysConstructorsMap = nArray;
        this.generator = generatorAdapter;
    }

    public void generateCase(int n, Label label) {
        Type type = this.asmTypes[this.keysConstructorsMap[n][0]];
        Constructor constructor = this.javaConstructors[this.keysConstructorsMap[n][0]][this.keysConstructorsMap[n][1]];
        this.generator.newInstance(type);
        this.generator.dup();
        Class[] classArray = constructor.getParameterTypes();
        for (int i2 = 0; i2 < classArray.length; ++i2) {
            this.generator.loadArg(1);
            this.generator.push(i2);
            this.generator.arrayLoad(OBJ_ASM_T);
            this.generator.unbox(Type.getType((Class)classArray[i2]));
        }
        Method method = Method.getMethod((Constructor)constructor);
        this.generator.invokeConstructor(type, method);
        this.generator.returnValue();
    }

    public void generateDefault() {
        this.generator.push((String)null);
        this.generator.returnValue();
    }
}

