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
import org.objectweb.asm.Label;
import org.objectweb.asm.Type;
import org.objectweb.asm.commons.GeneratorAdapter;
import org.objectweb.asm.commons.Method;
import org.objectweb.asm.commons.TableSwitchGenerator;

public final class NewInstanceSwitchGenerator
implements TableSwitchGenerator,
Constants {
    private final Type asmGeneratedType;
    private final Method[] asmNewInstanceSegmentMethods;
    private final GeneratorAdapter generator;

    public NewInstanceSwitchGenerator(Type type, Method[] methodArray, GeneratorAdapter generatorAdapter) {
        this.asmGeneratedType = type;
        this.asmNewInstanceSegmentMethods = methodArray;
        this.generator = generatorAdapter;
    }

    public void generateCase(int n, Label label) {
        this.generator.loadThis();
        this.generator.loadArgs();
        this.generator.invokeVirtual(this.asmGeneratedType, this.asmNewInstanceSegmentMethods[n]);
        this.generator.returnValue();
    }

    public void generateDefault() {
        this.generator.push((String)null);
        this.generator.returnValue();
    }
}

