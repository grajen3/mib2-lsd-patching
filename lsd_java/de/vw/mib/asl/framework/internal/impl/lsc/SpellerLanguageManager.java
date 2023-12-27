/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.impl.lsc;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.framework.internal.impl.lsc.Preconditions;
import de.vw.mib.asl.framework.internal.lsc.LanguageComparator;
import de.vw.mib.asl.framework.internal.lsc.LanguageHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SpellerLanguageManager {
    private static final int CURRENT_GUI_LANGUAGE;
    private int currentSpellerLanguageIndex = -1;
    private List additionalLanguages = Collections.EMPTY_LIST;
    private ASLPropertyManager aslPropertyManager;
    private String[] variantLanguages;

    public SpellerLanguageManager(ASLPropertyManager aSLPropertyManager) {
        Preconditions.checkArgumentNotNull(aSLPropertyManager);
        this.aslPropertyManager = aSLPropertyManager;
    }

    public void setVariantLanguages(String[] stringArray) {
        Preconditions.checkArgumentNotNull(stringArray);
        this.variantLanguages = stringArray;
    }

    public void updateAdditionalSpellerLanguages(boolean[] blArray, String string) {
        Preconditions.checkArgumentNotNull(blArray);
        int n = LanguageHelper.getMenuLanguage(string);
        blArray[n] = true;
        this.additionalLanguages = new ArrayList();
        for (int i2 = 0; i2 < blArray.length; ++i2) {
            boolean bl;
            boolean bl2 = blArray[i2];
            boolean bl3 = bl = i2 == n;
            if (!bl2 || bl) continue;
            this.additionalLanguages.add(LanguageHelper.getIsoCodeOfMenuLanguage(i2));
        }
        this.removeUnavailableLanguages(this.additionalLanguages);
        Collections.sort(this.additionalLanguages, LanguageComparator.LANGUAGE_COMPARATOR);
    }

    private void removeUnavailableLanguages(List list) {
        list.retainAll(Arrays.asList(this.variantLanguages));
    }

    public void toggleSpellerLanguage(String string) {
        String string2;
        ++this.currentSpellerLanguageIndex;
        if (this.currentSpellerLanguageIndex >= this.additionalLanguages.size()) {
            this.currentSpellerLanguageIndex = -1;
            string2 = string;
        } else {
            string2 = this.getCurrentAdditionalSpellerLanguage();
        }
        this.updateDatapoolCurrentSpellerLanguage(string2);
        this.updateDatapoolSpellerLanguageIndex(this.currentSpellerLanguageIndex);
    }

    private String getCurrentAdditionalSpellerLanguage() {
        return (String)this.additionalLanguages.get(this.currentSpellerLanguageIndex);
    }

    public void updateSpellerProperties() {
        this.updateDatapoolAdditionalSpellerLanguage(this.additionalLanguages);
        this.updateDatapoolSpellerLanguageIndex(-1);
    }

    private void updateDatapoolAdditionalSpellerLanguage(List list) {
        String[] stringArray = (String[])list.toArray(new String[list.size()]);
        this.aslPropertyManager.valueChangedStringVector(1577, stringArray);
    }

    private void updateDatapoolSpellerLanguageIndex(int n) {
        boolean bl = n < this.additionalLanguages.size();
        boolean bl2 = n >= -1;
        Preconditions.checkArgument(bl && bl2, new StringBuffer().append("The >spellerIindex< is out of bounds! Got:").append(n).toString());
        this.aslPropertyManager.valueChangedInteger(1591, n);
    }

    public void updateDatapoolCurrentSpellerLanguage(String string) {
        Preconditions.checkArgumentNotNull(string);
        this.aslPropertyManager.valueChangedString(2622, string);
    }
}

