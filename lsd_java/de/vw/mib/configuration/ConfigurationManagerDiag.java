/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.configuration;

import de.vw.mib.configuration.ConfigurationManagerObserver;
import de.vw.mib.configuration.ConfigurationManagerValueSetter;
import java.io.File;
import java.io.InputStream;

public interface ConfigurationManagerDiag
extends ConfigurationManagerValueSetter {
    public static final int PROMPTMODE_NOVICE;
    public static final int PROMPTMODE_EXPERT;

    @Override
    default public String getCurrentAlphabetPath() {
    }

    default public void setCurrentAlphabetPath(String string) {
    }

    @Override
    default public String getCommonDataPath() {
    }

    default public void setCommonDataPath(String string) {
    }

    @Override
    default public String getCurrentFontPath() {
    }

    default public void setCurrentFontPath(String string) {
    }

    default public void setAvailableSkins(int[] nArray) {
    }

    default public void removeObserver() {
    }

    default public void setObserver(ConfigurationManagerObserver configurationManagerObserver) {
    }

    default public InputStream getSpeechPrompts(String string, int n, int n2) {
    }

    default public File[] getAllSpeechPrompts() {
    }

    default public InputStream getSpeechCommands(String string, int n) {
    }

    default public File[] getAllSpeechCommands() {
    }

    default public InputStream getCurrentGrammarReferenceTable() {
    }

    default public File getTheGrammarReferenceTable() {
    }

    default public InputStream getTheGrammarReferenceTableDtd() {
    }

    default public File getTheGrammarReferenceTableDtdFile() {
    }

    default public InputStream getTheGrammarMetaTable() {
    }

    default public File getTheGrammarMetaTableFile() {
    }

    default public String[] getSupportedVehicleTypes() {
    }

    default public byte[] getDriverDistractionPreventionConfig() {
    }
}

