/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia.china;

import de.vw.mib.properties.values.SpellerData;
import de.vw.mib.widgets.speller.asia.china.ChinaStateMachine;
import de.vw.mib.widgets.speller.asia.china.HWRMatchState;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class HWRMatchNVCState
extends HWRMatchState {
    public HWRMatchNVCState(ChinaStateMachine chinaStateMachine) {
        super(chinaStateMachine);
    }

    private String[] getFilteredNextValidCharacters(String string) {
        char[] cArray = string.trim().toCharArray();
        int n = cArray.length;
        Object[] objectArray = new String[n];
        for (int i2 = 0; i2 < cArray.length; ++i2) {
            if (Character.isSpaceChar(cArray[i2])) {
                --n;
                continue;
            }
            objectArray[i2] = String.valueOf(cArray[i2]);
        }
        if (objectArray.length != n) {
            ArrayList arrayList = new ArrayList(Arrays.asList(objectArray));
            arrayList.removeAll(Collections.singleton(null));
            objectArray = (String[])arrayList.toArray(new String[n]);
        }
        return objectArray;
    }

    @Override
    public String toString() {
        return new StringBuffer().append("HWRMatchNVC[").append(super.toString()).append("]").toString();
    }

    @Override
    public boolean hwrCharactersRecognized(String[] stringArray) {
        if (stringArray != null && stringArray.length > 0) {
            this.setStateId(4);
        }
        return super.hwrCharactersRecognized(stringArray);
    }

    @Override
    public void setSpellerData(SpellerData spellerData) {
        String string = spellerData.getAvailableCharacters();
        String string2 = spellerData.getEnteredText();
        if (string != null && !string.equals("\u0007")) {
            if (string2 != null && string2.length() > 0) {
                String[] stringArray = this.getFilteredNextValidCharacters(string);
                this.speller.setNextValidCharacters(stringArray);
            } else {
                this.speller.setNextValidCharacters(null);
            }
        }
        this.hwrPhraseBuffer.setPhrases(string2);
    }
}

