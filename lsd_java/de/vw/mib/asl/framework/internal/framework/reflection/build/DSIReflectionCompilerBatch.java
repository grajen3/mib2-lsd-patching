/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.framework.reflection.build;

import de.vw.mib.asl.framework.internal.framework.reflection.build.DSIReflectionCompiler;
import de.vw.mib.asl.framework.internal.framework.reflection.build.DSIReflectionDebugCompiler;

public class DSIReflectionCompilerBatch {
    private static final int DSI_REFLECTION_COMPILER_ARGS_COUNT;
    private static final int DSI_REFLECTION_DEBUG_COMPILER_ARGS_COUNT;

    public static void main(String[] stringArray) {
        String[] stringArray2 = new String[2];
        System.arraycopy((Object)stringArray, 0, (Object)stringArray2, 0, 2);
        DSIReflectionCompiler.main(stringArray2);
        String[] stringArray3 = new String[2];
        System.arraycopy((Object)stringArray, 2, (Object)stringArray3, 0, 2);
        DSIReflectionDebugCompiler.main(stringArray3);
    }
}

