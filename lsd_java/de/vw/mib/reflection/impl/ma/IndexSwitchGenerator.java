/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.objectweb.asm.Label
 *  org.objectweb.asm.commons.GeneratorAdapter
 *  org.objectweb.asm.commons.TableSwitchGenerator
 */
package de.vw.mib.reflection.impl.ma;

import de.vw.mib.reflection.impl.Constants;
import org.objectweb.asm.Label;
import org.objectweb.asm.commons.GeneratorAdapter;
import org.objectweb.asm.commons.TableSwitchGenerator;

public final class IndexSwitchGenerator
implements TableSwitchGenerator,
Constants {
    private final int[] keys;
    private final int[][][] hashsKeysMap;
    private final int checkPtsLocal;
    private final int pTpsHashLocal;
    private final int resultLocal;
    private final GeneratorAdapter generator;

    public IndexSwitchGenerator(int[] nArray, int[][][] nArray2, int n, int n2, int n3, GeneratorAdapter generatorAdapter) {
        this.keys = nArray;
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
        int[][] nArray = this.hashsKeysMap[n2];
        Label label2 = this.generator.newLabel();
        this.generator.loadLocal(this.checkPtsLocal);
        this.generator.ifZCmp(153, label2);
        for (int i3 = 0; i3 < nArray.length; ++i3) {
            Label label3 = this.generator.newLabel();
            this.generator.loadLocal(this.pTpsHashLocal);
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

