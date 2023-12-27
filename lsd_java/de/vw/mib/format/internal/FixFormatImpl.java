/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.format.internal;

import de.vw.mib.format.FixFormat;
import de.vw.mib.format.FixFormat4Asl;
import de.vw.mib.format.FixFormat4Bap;
import de.vw.mib.format.FixFormatConfiguration;
import de.vw.mib.format.internal.ConditionEvaluator;
import de.vw.mib.format.internal.FixFormatBaseImpl;
import de.vw.mib.format.internal.FixFormatImpl$Rule;
import de.vw.mib.format.internal.OutputSynthesizer;
import de.vw.mib.format.internal.ServiceManager;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.FixFormatterFieldDataImpl;
import de.vw.mib.util.StringBuilder;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map$Entry;
import java.util.Properties;
import java.util.StringTokenizer;

public class FixFormatImpl
extends FixFormatBaseImpl
implements FixFormat,
FixFormat4Bap,
FixFormat4Asl {
    private static final int RULEIDOFFSET_CHN;
    public static final int TYPE_STRING;
    public static final int TYPE_BOOLEAN;
    public static final int TYPE_INTEGER;
    public static final int TYPE_LONG;
    private static final String FILENAME_FIELDSET;
    private static final FixFormatterFieldData DEFAULT_FIELDDATA;
    protected HashMap rulesets;
    protected HashMap fieldtypes;
    private HashMap longitudeData = new HashMap();
    private HashMap latitudeData = new HashMap();

    private void readFieldTypesFromFile() {
        Object object;
        this.fieldtypes = new HashMap();
        File file = null;
        String string = ServiceManager.configurationManager.getConfigurationFilePath("fieldset.properties");
        if (string.equals("fieldset.properties")) {
            object = FixFormatConfiguration.RULESET_DIRECTORY;
            if (object != null) {
                file = new File((String)object, "fieldset.properties");
            }
        } else {
            file = new File(string);
        }
        if (file != null && file.exists()) {
            object = null;
            try {
                String string2;
                FileReader fileReader = new FileReader(file);
                object = new BufferedReader(fileReader);
                while ((string2 = ((BufferedReader)object).readLine()) != null) {
                    int n = string2.indexOf(58);
                    if (n <= 0) continue;
                    this.fieldtypes.put(string2.subSequence(0, n), Integer.valueOf(string2.substring(n + 1).trim()));
                }
            }
            catch (FileNotFoundException fileNotFoundException) {
                this.logger.error(2, new StringBuffer().append("Fieldset file '").append(file).append("' not found!").toString());
            }
            catch (IOException iOException) {
                this.logger.error(2, new StringBuffer().append("Fieldset file '").append(file).append("' could not be read!").toString());
            }
            if (object != null) {
                try {
                    ((BufferedReader)object).close();
                }
                catch (IOException iOException) {
                    this.logger.warn(2, new StringBuffer().append("Fieldset file '").append(file).append("' could not be closed!").toString());
                }
            }
        }
    }

    private void readFieldTypesAsResource() {
        this.fieldtypes = new HashMap();
        String string = FixFormatConfiguration.RULESET_RESOURCES;
        if (string != null) {
            InputStream inputStream = super.getClass().getResourceAsStream(new StringBuffer().append(string).append("/").append("fieldset.properties").toString());
            if (inputStream != null) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                try {
                    String string2;
                    while ((string2 = bufferedReader.readLine()) != null) {
                        int n = string2.indexOf(58);
                        if (n <= 0) continue;
                        this.fieldtypes.put(string2.subSequence(0, n), Integer.valueOf(string2.substring(n + 1).trim()));
                    }
                }
                catch (IOException iOException) {
                    this.logger.error(2, new StringBuffer().append("Fieldset resource '").append(string).append("' could not be read!").toString());
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    }
                    catch (IOException iOException) {
                        this.logger.warn(2, new StringBuffer().append("Fieldset resource '").append(string).append("' could not be closed!").toString());
                    }
                }
            } else {
                this.logger.error(2, new StringBuffer().append("Fieldset resource '").append(string).append("' not found!").toString());
            }
        }
    }

    private void readFieldTypes() {
        this.readFieldTypesAsResource();
        if (this.fieldtypes.size() <= 0) {
            this.readFieldTypesFromFile();
        }
        if (this.fieldtypes.size() <= 0) {
            this.logger.error(2, "No valid file 'fieldset.properties' found!!! The rule based fixformats may throw NPEs!!!");
        }
    }

    private void loadRulesets(Properties properties, String string) {
        this.rulesets = new HashMap();
        Iterator iterator = properties.entrySet().iterator();
        while (iterator.hasNext()) {
            Map$Entry map$Entry = (Map$Entry)iterator.next();
            String string2 = (String)map$Entry.getKey();
            String string3 = (String)map$Entry.getValue();
            StringTokenizer stringTokenizer = new StringTokenizer(string2, ".");
            if (stringTokenizer.countTokens() != 3) continue;
            String string4 = stringTokenizer.nextToken();
            String string5 = stringTokenizer.nextToken();
            String string6 = stringTokenizer.nextToken();
            if (!string4.startsWith("ruleset")) continue;
            String string7 = string4.substring("ruleset".length());
            HashMap hashMap = (HashMap)this.rulesets.get(string7);
            if (hashMap == null) {
                hashMap = new HashMap();
                this.rulesets.put(string7, hashMap);
            }
            if (!string5.startsWith("rule")) continue;
            String string8 = string5.substring("rule".length());
            FixFormatImpl$Rule fixFormatImpl$Rule = (FixFormatImpl$Rule)hashMap.get(string8);
            if (fixFormatImpl$Rule == null) {
                fixFormatImpl$Rule = new FixFormatImpl$Rule(this);
                hashMap.put(string8, fixFormatImpl$Rule);
            }
            if (string6.equals("condition")) {
                fixFormatImpl$Rule.setCondition(string3);
                continue;
            }
            if (string6.equals("output")) {
                fixFormatImpl$Rule.setOutput(string3);
                continue;
            }
            this.logger.error(2, new StringBuffer().append("Illegal key in Ruleset file '").append(string).append("': '").append(string2).append("'").toString());
        }
    }

    private void readRulesetsAsResource() {
        String string = FixFormatConfiguration.RULESET_RESOURCES;
        if (string != null) {
            String string2 = new StringBuffer().append(string).append("/locationformattingrules_").append(ServiceManager.configurationManager.getCurrentGuiLanguage()).append(".properties").toString();
            InputStream inputStream = super.getClass().getResourceAsStream(string2);
            if (inputStream != null) {
                Properties properties = new Properties();
                try {
                    properties.load(inputStream);
                    this.loadRulesets(properties, string2);
                }
                catch (IOException iOException) {
                    this.logger.error(2, new StringBuffer().append("Ruleset file '").append(string2).append("' could not be read!").toString());
                }
                try {
                    inputStream.close();
                }
                catch (IOException iOException) {
                    this.logger.warn(2, new StringBuffer().append("Ruleset file '").append(string2).append("' could not be closed!").toString());
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void readRulesetsFromFile() {
        int n;
        Object object;
        String string = ServiceManager.configurationManager.getConfigurationPath();
        if (string == null && (string = FixFormatConfiguration.RULESET_DIRECTORY) == null && (object = FixFormatConfiguration.RULESETS) != null && (n = ((String)object).indexOf("locationformattingrules")) > 0) {
            string = ((String)object).substring(0, n - 1);
        }
        if (string != null) {
            object = new File(string, new StringBuffer().append("locationformattingrules_").append(ServiceManager.configurationManager.getCurrentGuiLanguage()).append(".properties").toString());
            if (!((File)object).exists()) {
                String string2 = FixFormatConfiguration.RULESETS;
                if (string2 != null) {
                    object = new File(string2);
                }
                if (!((File)object).exists() && !((File)(object = new File(string, "locationformattingrules_en_US.properties"))).exists()) {
                    object = new File(string, "locationformattingrules_en_us.properties");
                }
            }
            if (((File)object).exists()) {
                Properties properties = new Properties();
                FileInputStream fileInputStream = null;
                try {
                    fileInputStream = new FileInputStream((File)object);
                    properties.load(fileInputStream);
                }
                catch (FileNotFoundException fileNotFoundException) {
                    this.logger.error(2, new StringBuffer().append("Ruleset file '").append(object).append("' not found!").toString());
                }
                catch (IOException iOException) {
                    this.logger.error(2, new StringBuffer().append("Ruleset file '").append(object).append("' could not be read!").toString());
                }
                finally {
                    if (fileInputStream != null) {
                        try {
                            ((InputStream)fileInputStream).close();
                        }
                        catch (IOException iOException) {
                            this.logger.warn(2, new StringBuffer().append("Ruleset file '").append(object).append("' could not be closed!").toString());
                        }
                    }
                }
                this.loadRulesets(properties, ((File)object).toString());
            } else {
                this.logger.warn(2, new StringBuffer().append("[FixFormat4Asl] Cannot find ruleset definitions ('locationformattingrules_xx_XX.properties' in '").append(string).append("'). Don't expect getRulesetBasedFormattedString(...) to do anything useful!-)").toString());
            }
        } else {
            this.logger.warn(2, "[FixFormat4Asl] No ruleset directory defined (Neither -Dde.vw.mib.format.4asl.rulesets.directory=... nor -Dde.vw.mib.format.4asl.rulesets=...). Don't expect getRulesetBasedFormattedString(...) to do anything useful!-)");
        }
    }

    private void readRulesets() {
        this.readRulesetsAsResource();
        if (this.rulesets == null) {
            this.readRulesetsFromFile();
        }
    }

    private void initialize() {
        if (this.fieldtypes == null) {
            this.readFieldTypes();
        }
        if (this.rulesets == null) {
            this.readRulesets();
        }
    }

    private String trim(String string) {
        if (string == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer(string.length());
        boolean bl = true;
        int n = 0;
        int n2 = -1;
        int n3 = 0;
        do {
            String string2 = (n2 = string.indexOf("\\n", n)) >= 0 ? string.substring(n, n2) : string.substring(n);
            if ((string2 = string2.trim()).length() == 0) {
                if (!bl) {
                    ++n3;
                }
            } else {
                bl = false;
                while (n3 > 0) {
                    stringBuffer.append("\\n");
                    --n3;
                }
                stringBuffer.append(string2);
                ++n3;
            }
            n = n2 + "\\n".length();
        } while (n2 >= 0);
        return stringBuffer.toString();
    }

    @Override
    public String getRulesetBasedFormattedString(int n, HashMap hashMap) {
        if (n < 10000) {
            n += ServiceManager.configurationManager.getNaviCommonOptionDefault(1);
        }
        if (hashMap == null) {
            hashMap = new HashMap();
        }
        this.initialize();
        HashMap hashMap2 = (HashMap)this.rulesets.get(String.valueOf(n));
        if (hashMap2 == null) {
            this.logger.error(2, new StringBuffer().append("Invalid ruleset ID '").append(n).append("'").toString());
        } else {
            ConditionEvaluator conditionEvaluator = new ConditionEvaluator();
            int n2 = 1;
            FixFormatImpl$Rule fixFormatImpl$Rule = null;
            do {
                Boolean bl;
                if ((fixFormatImpl$Rule = (FixFormatImpl$Rule)hashMap2.get(String.valueOf(n2))) != null && (bl = conditionEvaluator.evaluate(fixFormatImpl$Rule.getCondition(), hashMap)) != null && bl.booleanValue()) {
                    if (this.logger.isTraceEnabled(2)) {
                        this.logger.trace(2, new StringBuffer().append("[getRulesetBasedFormattedString] rule set ").append(n).append(": Condition '").append(fixFormatImpl$Rule.getCondition()).append("' matched to the field data.").toString());
                    }
                    OutputSynthesizer outputSynthesizer = new OutputSynthesizer(this.logger);
                    String string = this.trim(outputSynthesizer.evaluate(fixFormatImpl$Rule.getOutput(), hashMap, this));
                    if ("ar_SA".equals(ServiceManager.configurationManager.getCurrentGuiLanguage())) {
                        StringBuilder stringBuilder = new StringBuilder();
                        if (string.length() > 0) {
                            stringBuilder.append('\u200f');
                            for (int i2 = 0; i2 < string.length(); ++i2) {
                                char c2 = string.charAt(i2);
                                stringBuilder.append(c2);
                                if (c2 != ',') continue;
                                stringBuilder.append('\u200f');
                            }
                            return stringBuilder.toString();
                        }
                    }
                    return string;
                }
                ++n2;
            } while (fixFormatImpl$Rule != null);
            if (this.logger.isTraceEnabled(2)) {
                this.logger.trace(2, new StringBuffer().append("[getRulesetBasedFormattedString] No match found in rule set ").append(n).toString());
            }
        }
        return "";
    }

    @Override
    public String fmtRulesetBasedString(int n, FixFormatterFieldData fixFormatterFieldData) {
        if (n < 10000) {
            n += ServiceManager.configurationManager.getNaviCommonOptionDefault(1);
        }
        if (fixFormatterFieldData == null) {
            fixFormatterFieldData = DEFAULT_FIELDDATA;
        }
        this.initialize();
        HashMap hashMap = (HashMap)this.rulesets.get(String.valueOf(n));
        if (hashMap == null) {
            this.logger.error(2, new StringBuffer().append("Invalid ruleset ID '").append(n).append("'").toString());
        } else {
            ConditionEvaluator conditionEvaluator = new ConditionEvaluator();
            int n2 = 1;
            FixFormatImpl$Rule fixFormatImpl$Rule = null;
            do {
                Boolean bl;
                if ((fixFormatImpl$Rule = (FixFormatImpl$Rule)hashMap.get(String.valueOf(n2))) != null && (bl = conditionEvaluator.evaluate(fixFormatImpl$Rule.getCondition(), fixFormatterFieldData, this.fieldtypes)) != null && bl.booleanValue()) {
                    if (this.logger.isTraceEnabled(2)) {
                        this.logger.trace(2, new StringBuffer().append("[getRulesetBasedFormattedString] rule set ").append(n).append(": Condition '").append(fixFormatImpl$Rule.getCondition()).append("' matched to the field data.").toString());
                    }
                    OutputSynthesizer outputSynthesizer = new OutputSynthesizer(this.logger);
                    String string = this.trim(outputSynthesizer.evaluate(fixFormatImpl$Rule.getOutput(), fixFormatterFieldData, this.fieldtypes, this));
                    if ("ar_SA".equals(ServiceManager.configurationManager.getCurrentGuiLanguage())) {
                        StringBuilder stringBuilder = new StringBuilder();
                        if (string.length() > 0) {
                            stringBuilder.append('\u200f');
                            for (int i2 = 0; i2 < string.length(); ++i2) {
                                char c2 = string.charAt(i2);
                                stringBuilder.append(c2);
                                if (c2 != ',') continue;
                                stringBuilder.append('\u200f');
                            }
                            return stringBuilder.toString();
                        }
                    }
                    return string;
                }
                ++n2;
            } while (fixFormatImpl$Rule != null);
            if (this.logger.isTraceEnabled(2)) {
                this.logger.trace(2, new StringBuffer().append("[getRulesetBasedFormattedString] No match found in rule set ").append(n).toString());
            }
        }
        return "";
    }

    @Override
    protected void onLanguageChanged() {
        super.onLanguageChanged();
        this.rulesets = null;
    }

    @Override
    public String fmtGeoCoordinatesLongitude(double d2) {
        boolean bl;
        boolean bl2 = bl = d2 < 0.0;
        if (bl) {
            d2 = -d2;
        }
        int n = (int)d2;
        double d3 = (d2 - (double)n) * 60.0;
        int n2 = (int)d3;
        int n3 = (int)((d3 - (double)n2) * 600.0);
        this.longitudeData.put("LongitudeDegrees", String.valueOf(bl ? -n : n));
        this.longitudeData.put("LongitudeMinutes", String.valueOf(n2));
        this.longitudeData.put("LongitudeSeconds", String.valueOf(n3));
        return this.getRulesetBasedFormattedString(9500, this.longitudeData);
    }

    @Override
    public String fmtGeoCoordinatesLatitude(double d2) {
        boolean bl;
        boolean bl2 = bl = d2 < 0.0;
        if (bl) {
            d2 = -d2;
        }
        int n = (int)d2;
        double d3 = (d2 - (double)n) * 60.0;
        int n2 = (int)d3;
        int n3 = (int)((d3 - (double)n2) * 600.0);
        this.latitudeData.put("LatitudeDegrees", String.valueOf(bl ? -n : n));
        this.latitudeData.put("LatitudeMinutes", String.valueOf(n2));
        this.latitudeData.put("LatitudeSeconds", String.valueOf(n3));
        return this.getRulesetBasedFormattedString(9500, this.latitudeData);
    }

    static {
        DEFAULT_FIELDDATA = new FixFormatterFieldDataImpl();
    }
}

