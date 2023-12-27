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

public final class IndexTypeSwitchGenerator
implements TableSwitchGenerator,
Constants {
    private final int[] keys;
    private final Type asmGeneratedType;
    private final Method[] asmTypesGetIndexMethods;
    private final int[][] hashsKeysMap;
    private final int checkPtsLocal;
    private final int pTpsHashLocal;
    private final int resultLocal;
    private final GeneratorAdapter generator;

    public IndexTypeSwitchGenerator(int[] nArray, Type type, Method[] methodArray, int[][] nArray2, int n, int n2, int n3, GeneratorAdapter generatorAdapter) {
        this.keys = nArray;
        this.asmGeneratedType = type;
        this.asmTypesGetIndexMethods = methodArray;
        this.hashsKeysMap = nArray2;
        this.checkPtsLocal = n;
        this.pTpsHashLocal = n2;
        this.resultLocal = n3;
        this.generator = generatorAdapter;
    }

    public void generateCase(int n, Label label) {
        int n2 = -1;
        for (int i2 = 0; i2 < this.keys.length; ++i2) {
            if (n != this.keys[i2]) continue;
            n2 = i2;
            break;
        }
        Label label2 = this.generator.newLabel();
        this.generator.loadLocal(this.checkPtsLocal);
        this.generator.ifZCmp(153, label2);
        this.generator.loadThis();
        this.generator.loadLocal(this.pTpsHashLocal);
        this.generator.invokeVirtual(this.asmGeneratedType, this.asmTypesGetIndexMethods[n2]);
        this.generator.storeLocal(this.resultLocal);
        this.generator.goTo(label);
        this.generator.mark(label2);
        this.generator.push(this.hashsKeysMap[n2][0]);
        this.generator.storeLocal(this.resultLocal);
        this.generator.goTo(label);
    }

    public void generateDefault() {
    }
}

