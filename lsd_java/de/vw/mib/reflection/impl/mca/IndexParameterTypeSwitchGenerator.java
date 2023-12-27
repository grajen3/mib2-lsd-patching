/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.objectweb.asm.Label
 *  org.objectweb.asm.commons.GeneratorAdapter
 *  org.objectweb.asm.commons.TableSwitchGenerator
 */
package de.vw.mib.reflection.impl.mca;

import de.vw.mib.reflection.impl.Constants;
import org.objectweb.asm.Label;
import org.objectweb.asm.commons.GeneratorAdapter;
import org.objectweb.asm.commons.TableSwitchGenerator;

public final class IndexParameterTypeSwitchGenerator
implements TableSwitchGenerator,
Constants {
    private final int[] keys;
    private final int[] typeHashsKeysMap;
    private final GeneratorAdapter generator;

    public IndexParameterTypeSwitchGenerator(int[] nArray, int[] nArray2, GeneratorAdapter generatorAdapter) {
        this.keys = nArray;
        this.typeHashsKeysMap = nArray2;
        this.generator = generatorAdapter;
    }

    public void generateCase(int n, Label label) {
        int n2 = -1;
        for (int i2 = 0; i2 < this.keys.length; ++i2) {
            if (n != this.keys[i2]) continue;
            n2 = i2;
            break;
        }
        this.generator.push(this.typeHashsKeysMap[n2]);
        this.generator.returnValue();
    }

    public void generateDefault() {
        this.generator.push(-1);
        this.generator.returnValue();
    }
}

