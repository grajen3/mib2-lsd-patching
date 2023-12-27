/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asia;

import de.vw.mib.asia.AsiaListener;
import org.dsi.ifc.asiainput.UserDefinedEntry;
import org.dsi.ifc.asiainput.WordDatabase;

public interface AsiaInput {
    public static final int INPUTMODE_BPMF;
    public static final int INPUTMODE_CANGJIE;
    public static final int INPUTMODE_PINYIN;
    public static final int INPUTMODE_QUICKCANGJIE;
    public static final int INPUTMODE_STROKE;
    public static final int LANGUAGE_CHINA;
    public static final int LANGUAGE_JAPAN;
    public static final int PARAMETER_FIRSTLETTER;
    public static final int PARAMETER_INPUTMODE;
    public static final int PARAMETER_NAMEINPUT;
    public static final int PARAMETER_SMARTPUNCT;
    public static final int PARAMETER_TYPE;
    public static final int TYPE_HONGKONG;
    public static final int TYPE_SIMPLIFIED;
    public static final int TYPE_SINGAPURE;
    public static final int TYPE_TRADITIONAL;
    public static final int UDBSTATE_OFF;
    public static final int UDBSTATE_ON;
    public static final int UDBSTATE_RESET;

    default public void addAsiaListener(AsiaListener asiaListener) {
    }

    default public void addSymbol(char c2) {
    }

    default public void addSymbols(String string) {
    }

    default public void addUserDefinedEntry(UserDefinedEntry userDefinedEntry) {
    }

    default public void buildCandidates() {
    }

    default public void clear() {
    }

    default public void clearPredictionContext() {
    }

    default public void getBooleanParameter(int n) {
    }

    default public void getCandidates(int n) {
    }

    default public void getIntParameter(int n) {
    }

    default public void getSegmentation(String string) {
    }

    default public void getSpelling() {
    }

    default public void getStringParameter(int n) {
    }

    default public void initialize(int n) {
    }

    default public void removeAllSymbols() {
    }

    default public void removeAsiaListener(AsiaListener asiaListener) {
    }

    default public void removeSymbol() {
    }

    default public void selectCandidate(int n) {
    }

    default public void setAdditionalWordDatabases(WordDatabase[] wordDatabaseArray) {
    }

    default public void setBooleanParameter(int n, boolean bl) {
    }

    default public void setIntParameter(int n, int n2) {
    }

    default public void setPredictionContext(String string) {
    }

    default public void setStringParameter(int n, String string) {
    }

    default public void setUserDatabaseState(int n, int n2) {
    }
}

