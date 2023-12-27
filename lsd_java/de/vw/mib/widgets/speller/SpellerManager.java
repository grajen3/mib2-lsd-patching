/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller;

import de.vw.mib.collections.ObjectObjectOptHashMap;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.util.StringBuilder;
import de.vw.mib.widgets.FeatureToggles;
import de.vw.mib.widgets.internal.ServiceManager;
import de.vw.mib.widgets.log.Loggable;
import de.vw.mib.widgets.log.Logger;
import de.vw.mib.widgets.log.SpellerLogger;
import de.vw.mib.widgets.models.AbstractSpellerModel;
import de.vw.mib.widgets.speller.Alphabet;
import de.vw.mib.widgets.speller.BaseAlphabet;
import de.vw.mib.widgets.speller.LCIDs;
import de.vw.mib.widgets.speller.SpellerManager$SpellerManagerHolder;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public final class SpellerManager
implements Loggable {
    private static final String LOG_PREFIX;
    private static final String SPLA_PROPERTY;
    private static final String SPLA_PATH_PROPERTY;
    private static final String SPLA_FILENAME;
    private final Map alphabets = new ObjectObjectOptHashMap();
    private String oldLocaleISO;

    public static void clearCache() {
        SpellerManager$SpellerManagerHolder.SPELLERMANAGER.alphabets.clear();
    }

    public static Alphabet getAlphabet(AbstractSpellerModel abstractSpellerModel) {
        String string = abstractSpellerModel.getCurrentAlphabetName();
        String string2 = SpellerManager$SpellerManagerHolder.SPELLERMANAGER.buildAlphabetFilename(abstractSpellerModel.get_lowerUpper(), string, abstractSpellerModel.getCurrentLanguageName());
        Alphabet alphabet = null;
        if (string != null && string.length() > 0) {
            try {
                alphabet = SpellerManager$SpellerManagerHolder.SPELLERMANAGER.getAlphabet(string, string2);
            }
            catch (IOException iOException) {
                // empty catch block
            }
        }
        return alphabet;
    }

    public static String getISOToName(String string) {
        return LCIDs.getLanguageByIso(string);
    }

    public static String[] getLanguageNames() {
        Object[] objectArray = LCIDs.getAllLanguages();
        Arrays.sort(objectArray);
        return objectArray;
    }

    public static List getLCIDs() {
        ArrayList arrayList = new ArrayList();
        Iterator iterator = LCIDs.iterator();
        while (iterator.hasNext()) {
            arrayList.add(iterator.next());
        }
        return arrayList;
    }

    public static String getLCIDToName(String string) {
        return LCIDs.getLanguageByLcid(string);
    }

    public static String getNameToISO(String string) {
        return LCIDs.getIsoByLanguage(string);
    }

    public static String getNameToLCID(String string) {
        return LCIDs.getLcidByLanguage(string);
    }

    static SpellerManager getSpellerManager() {
        return SpellerManager$SpellerManagerHolder.SPELLERMANAGER;
    }

    private static String getSPLAPath() {
        StringBuilder stringBuilder = new StringBuilder();
        if (SPLA_PATH_PROPERTY == null) {
            stringBuilder.append(ServiceManager.configurationManager.getCurrentAlphabetPath());
        } else {
            stringBuilder.append(SPLA_PATH_PROPERTY);
        }
        stringBuilder.append("/").append(SPLA_FILENAME);
        return stringBuilder.toString();
    }

    protected SpellerManager() {
    }

    protected String buildAlphabetFilename(int n, String string, String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        switch (n) {
            case 0: {
                stringBuilder.append("LowerCase");
                break;
            }
            case 1: {
                stringBuilder.append("UpperCase");
                break;
            }
        }
        stringBuilder.append("_").append(string);
        string2 = string2.indexOf("_") != -1 ? this.ensureLanguageNameIsLCID(string2) : this.ensureLanguageNameIsISO(string2);
        stringBuilder.append("_").append(string2);
        return stringBuilder.toString();
    }

    private String ensureLanguageNameIsISO(String string) {
        String string2 = string;
        if (string != null && (string.charAt(2) != '_' || string.charAt(3) != '_')) {
            try {
                string = LCIDs.convertLcidToIso(string);
            }
            catch (IllegalArgumentException illegalArgumentException) {
                this.error(SpellerLogger.getLogger()).append("[SpellerManager]: ").append("Illegal LCID language code: '").append(string2).append("'").log();
            }
        }
        return string;
    }

    private String ensureLanguageNameIsLCID(String string) {
        String string2 = string;
        if (string != null && (string.charAt(2) == '_' || string.charAt(3) == '_')) {
            try {
                string = LCIDs.convertIsoToLcid(string);
            }
            catch (IllegalArgumentException illegalArgumentException) {
                this.error(SpellerLogger.getLogger()).append("[SpellerManager]: ").append("Illegal ISO language code: '").append(string2).append("'").log();
            }
        }
        return string;
    }

    protected Alphabet getAlphabet(String string, String string2) {
        String string3 = ServiceManager.configurationManager.getCurrentGuiLanguage();
        if (this.oldLocaleISO == null || !this.oldLocaleISO.equals(string3)) {
            this.oldLocaleISO = string3;
            this.alphabets.clear();
        }
        if (this.alphabets.containsKey(string2)) {
            Alphabet alphabet = (Alphabet)this.alphabets.get(string2);
            if (FeatureToggles.isFeatureToggleEnabled("de.vw.mib.widgets.spellermanager.alphabet.caching.disabled")) {
                this.alphabets.clear();
            }
            return alphabet;
        }
        if (this.readAlphabet(string, string2)) {
            return this.getAlphabet(string, string2);
        }
        throw new IOException(new StringBuffer().append("Unable to get alphabet! [alphabetName='").append(string).append("' alphabetFileName='").append(string2).append("']").toString());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    Alphabet[] getAllAlphabets() {
        ArrayList arrayList = new ArrayList();
        String string = SpellerManager.getSPLAPath();
        if (new File(string).exists()) {
            ZipFile zipFile = null;
            try {
                zipFile = new ZipFile(string);
                Enumeration enumeration = zipFile.entries();
                while (enumeration.hasMoreElements()) {
                    ZipEntry zipEntry = (ZipEntry)enumeration.nextElement();
                    String string2 = zipEntry.getName().substring(zipEntry.getName().indexOf("_") + 1, zipEntry.getName().lastIndexOf("_"));
                    String string3 = zipEntry.getName().substring(0, zipEntry.getName().lastIndexOf("."));
                    BaseAlphabet baseAlphabet = new BaseAlphabet(string2, string3);
                    InputStream inputStream = null;
                    try {
                        inputStream = zipFile.getInputStream(zipEntry);
                        baseAlphabet.deserialize(inputStream);
                        arrayList.add(baseAlphabet);
                    }
                    catch (IOException iOException) {}
                    continue;
                    finally {
                        if (inputStream == null) continue;
                        try {
                            inputStream.close();
                        }
                        catch (IOException iOException) {}
                        inputStream = null;
                    }
                }
            }
            catch (IOException iOException) {
            }
            finally {
                if (zipFile != null) {
                    try {
                        zipFile.close();
                    }
                    catch (IOException iOException) {}
                    zipFile = null;
                }
            }
        }
        return (Alphabet[])arrayList.toArray(new Alphabet[arrayList.size()]);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean readAlphabet(String string, String string2) {
        BaseAlphabet baseAlphabet;
        String string3 = SpellerManager.getSPLAPath();
        if (!new File(string3).exists()) {
            this.warn(SpellerLogger.getLogger()).append("[SpellerManager]: ").append("Can't find '").append(SPLA_FILENAME).append("'! [splaPath='").append(string3).append("']").log();
            return false;
        }
        ZipFile zipFile = null;
        try {
            zipFile = new ZipFile(string3);
            ZipEntry zipEntry = zipFile.getEntry(new StringBuffer().append(string2).append(".spl").toString());
            if (zipEntry != null) {
                baseAlphabet = new BaseAlphabet(string, string2);
                InputStream inputStream = null;
                try {
                    inputStream = zipFile.getInputStream(zipEntry);
                    baseAlphabet.deserialize(inputStream);
                }
                catch (IOException iOException) {
                    boolean bl = false;
                    if (zipFile == null) return bl;
                    try {
                        zipFile.close();
                    }
                    catch (IOException iOException2) {
                        // empty catch block
                    }
                    zipFile = null;
                    return bl;
                }
                finally {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        }
                        catch (IOException iOException) {}
                        inputStream = null;
                    }
                }
            }
            this.warn(SpellerLogger.getLogger()).append("[SpellerManager]: ").append("Can't find SPLA entry! [alphabetName='").append(string).append("', alphabetFileName='").append(string2).append("', splaPath='").append(string3).append("']").log();
            boolean bl = false;
            return bl;
            this.alphabets.put(string2, baseAlphabet);
        }
        catch (IOException iOException) {
            boolean bl = false;
            return bl;
        }
        this.normal(SpellerLogger.getLogger()).append("[SpellerManager]: ").append("Alphabet loaded. [alphabetName='").append(baseAlphabet.getName()).append("', alphabetFileName='").append(string2).append("', splaPath='").append(string3).append("']").log();
        return true;
        finally {
            if (zipFile != null) {
                try {
                    zipFile.close();
                }
                catch (IOException iOException) {}
                zipFile = null;
            }
        }
    }

    @Override
    public LogMessage error(Logger logger) {
        return logger.error();
    }

    @Override
    public LogMessage normal(Logger logger) {
        return logger.normal();
    }

    @Override
    public LogMessage trace(Logger logger) {
        return logger.trace();
    }

    @Override
    public LogMessage warn(Logger logger) {
        return logger.warn();
    }

    static {
        SPLA_PROPERTY = System.getProperty("de.vw.mib.widgets.speller.spla");
        SPLA_PATH_PROPERTY = System.getProperty("de.vw.mib.widgets.speller.splaPath");
        SPLA_FILENAME = SPLA_PROPERTY != null ? SPLA_PROPERTY : "alphabets.spla";
    }
}

