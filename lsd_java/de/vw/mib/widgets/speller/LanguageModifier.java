/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller;

import de.vw.mib.widgets.internal.ServiceManager;
import de.vw.mib.widgets.models.SpellerModel;
import de.vw.mib.widgets.speller.LCIDs;
import de.vw.mib.widgets.speller.LanguageModifier$Tuple;
import edu.emory.mathcs.backport.java.util.Collections;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LanguageModifier {
    private static final List LANGUAGES_TO_ADD = new ArrayList();

    public static String[] modifyLanguageList(String[] stringArray) {
        ArrayList arrayList = new ArrayList(LANGUAGES_TO_ADD);
        LanguageModifier.removeAlreadyContaining(arrayList, stringArray);
        ArrayList arrayList2 = new ArrayList();
        Collections.addAll(arrayList2, stringArray);
        String string = ServiceManager.configurationManager.getCurrentGuiLanguage();
        Iterator iterator = arrayList.iterator();
        block0: while (iterator.hasNext()) {
            LanguageModifier$Tuple languageModifier$Tuple = (LanguageModifier$Tuple)iterator.next();
            String string2 = languageModifier$Tuple.getKey();
            if (string != null && string.equalsIgnoreCase(string2)) {
                arrayList2.add(arrayList2.size(), languageModifier$Tuple.getValue());
                continue;
            }
            for (int i2 = 0; i2 < arrayList2.size(); ++i2) {
                if (!string2.equalsIgnoreCase((String)arrayList2.get(i2))) continue;
                arrayList2.add(arrayList2.size(), languageModifier$Tuple.getValue());
                continue block0;
            }
        }
        return (String[])arrayList2.toArray(new String[arrayList2.size()]);
    }

    private static void changeLcidsToIsos(List list) {
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            LanguageModifier$Tuple languageModifier$Tuple = (LanguageModifier$Tuple)iterator.next();
            String string = languageModifier$Tuple.getKey();
            String string2 = languageModifier$Tuple.getValue();
            String string3 = LCIDs.convertLcidToIso(string);
            if (string3 == null) {
                iterator.remove();
                continue;
            }
            languageModifier$Tuple.setKey(string3);
            String string4 = LCIDs.convertLcidToIso(string2);
            if (string4 != null) {
                languageModifier$Tuple.setValue(string4);
                continue;
            }
            iterator.remove();
        }
    }

    private static void removeAlreadyContaining(List list, String[] stringArray) {
        Iterator iterator = list.iterator();
        block0: while (iterator.hasNext()) {
            String string = ((LanguageModifier$Tuple)iterator.next()).getValue();
            if (string == null) continue;
            for (int i2 = 0; i2 < stringArray.length; ++i2) {
                if (!string.equalsIgnoreCase(stringArray[i2])) continue;
                iterator.remove();
                continue block0;
            }
        }
    }

    public static int adjustIndexForAdditionalLanguage(SpellerModel spellerModel) {
        LanguageModifier$Tuple languageModifier$Tuple = LanguageModifier.getCurrentLanguageToTuple(spellerModel.getCurrentLanguageName());
        if (languageModifier$Tuple != null) {
            return LanguageModifier.getIndexForLanguageName(spellerModel.get_languageList(), languageModifier$Tuple.getValue());
        }
        return -1;
    }

    private static LanguageModifier$Tuple getCurrentLanguageToTuple(String string) {
        Iterator iterator = LANGUAGES_TO_ADD.iterator();
        while (iterator.hasNext()) {
            LanguageModifier$Tuple languageModifier$Tuple = (LanguageModifier$Tuple)iterator.next();
            String string2 = languageModifier$Tuple.getKey();
            if (!string.equalsIgnoreCase(string2)) continue;
            return languageModifier$Tuple;
        }
        return null;
    }

    private static int getIndexForLanguageName(String[] stringArray, String string) {
        if (stringArray != null && string != null) {
            for (int i2 = 0; i2 < stringArray.length; ++i2) {
                if (!string.equalsIgnoreCase(stringArray[i2])) continue;
                return i2;
            }
        }
        return -1;
    }

    static {
        LANGUAGES_TO_ADD.add(new LanguageModifier$Tuple("081A", "0C1A"));
        LanguageModifier.changeLcidsToIsos(LANGUAGES_TO_ADD);
    }
}

