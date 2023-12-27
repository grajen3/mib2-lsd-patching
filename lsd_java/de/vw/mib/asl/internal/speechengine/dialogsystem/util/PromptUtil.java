/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.util;

import de.vw.mib.asl.api.speechengine.features.model.Prompt;
import de.vw.mib.asl.api.speechengine.features.model.PromptReference;
import org.dsi.ifc.tts.DynamicTTSPromptPart;

public final class PromptUtil {
    private PromptUtil() {
    }

    public static int[] getPromptPartIds(Prompt[] promptArray) {
        int[] nArray = new int[promptArray.length];
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            nArray[i2] = promptArray[i2].getPromptId();
        }
        return nArray;
    }

    public static DynamicTTSPromptPart[] getDynamicPromptParts(Prompt[] promptArray) {
        int n = 0;
        DynamicTTSPromptPart[][] dynamicTTSPromptPartArray = new DynamicTTSPromptPart[promptArray.length][1];
        for (int i2 = 0; i2 < promptArray.length; ++i2) {
            dynamicTTSPromptPartArray[i2] = PromptUtil.getDynamicPromptParts(promptArray[i2]);
            if (dynamicTTSPromptPartArray[i2] == null) continue;
            n += dynamicTTSPromptPartArray[i2].length;
        }
        DynamicTTSPromptPart[] dynamicTTSPromptPartArray2 = new DynamicTTSPromptPart[n];
        int n2 = 0;
        for (int i3 = 0; i3 < dynamicTTSPromptPartArray.length; ++i3) {
            if (dynamicTTSPromptPartArray[i3] == null) continue;
            System.arraycopy((Object)dynamicTTSPromptPartArray[i3], 0, (Object)dynamicTTSPromptPartArray2, n2, dynamicTTSPromptPartArray[i3].length);
            n2 += dynamicTTSPromptPartArray[i3].length;
        }
        return dynamicTTSPromptPartArray2;
    }

    private static DynamicTTSPromptPart[] getDynamicPromptParts(Prompt prompt) {
        PromptReference[] promptReferenceArray = prompt.getPromptReferences();
        if (promptReferenceArray != null && promptReferenceArray.length > 0) {
            DynamicTTSPromptPart[] dynamicTTSPromptPartArray = new DynamicTTSPromptPart[promptReferenceArray.length];
            for (int i2 = 0; i2 < promptReferenceArray.length; ++i2) {
                DynamicTTSPromptPart dynamicTTSPromptPart;
                dynamicTTSPromptPartArray[i2] = dynamicTTSPromptPart = new DynamicTTSPromptPart(promptReferenceArray[i2].getKey(), promptReferenceArray[i2].getValue(), promptReferenceArray[i2].getAlternative());
            }
            return dynamicTTSPromptPartArray;
        }
        return null;
    }
}

