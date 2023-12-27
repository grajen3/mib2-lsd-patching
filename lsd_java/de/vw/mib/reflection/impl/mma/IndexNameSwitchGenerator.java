/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.objectweb.asm.Label
 *  org.objectweb.asm.commons.GeneratorAdapter
 *  org.objectweb.asm.commons.TableSwitchGenerator
 */
package de.vw.mib.reflection.impl.mma;

import de.vw.mib.reflection.impl.Constants;
import org.objectweb.asm.Label;
import org.objectweb.asm.commons.GeneratorAdapter;
import org.objectweb.asm.commons.TableSwitchGenerator;

public final class IndexNameSwitchGenerator
implements TableSwitchGenerator,
Constants {
    private final int[] typeMethodsNamesHash;
    private final int[][][] typeHashsKeysMap;
    private final int resultLocal;
    private final GeneratorAdapter generator;

    public IndexNameSwitchGenerator(int[] nArray, int[][][] nArray2, int n, GeneratorAdapter generatorAdapter) {
        this.typeMethodsNamesHash = nArray;
        this.typeHashsKeysMap = nArray2;
        this.resultLocal = n;
        this.generator = generatorAdapter;
    }

    public void generateCase(int n, Label label) {
        int n2 = -1;
        for (int i2 = 0; i2 < this.typeMethodsNamesHash.length; ++i2) {
            if (n != this.typeMethodsNamesHash[i2]) continue;
            n2 = i2;
            break;
        }
        int[][] nArray = this.typeHashsKeysMap[n2];
        Label label2 = this.generator.newLabel();
        this.generator.loadArg(1);
        this.generator.ifZCmp(153, label2);
        for (int i3 = 0; i3 < nArray.length; ++i3) {
            Label label3 = this.generator.newLabel();
            this.generator.loadArg(2);
            this.generator.push(nArray[i3][0]);
            this.generator.ifICmp(154, label3);
            this.generator.push(nArray[i3][1]);
            this.generator.storeLocal(this.resultLocal);
            this.generator.goTo(label);
            this.generator.mark(label3);
        }
        this.generator.goTo(label);
        this.generator.mark(label2);
        this.generator.push(nArray[0][1]);
        this.generator.storeLocal(this.resultLocal);
        this.generator.goTo(label);
    }

    public void generateDefault() {
    }
}

