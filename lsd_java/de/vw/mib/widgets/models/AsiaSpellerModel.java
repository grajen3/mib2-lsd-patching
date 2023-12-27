/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.models;

import de.vw.mib.widgets.models.AbstractSpellerModel;
import de.vw.mib.widgets.models.ContainerModel;
import de.vw.mib.widgets.models.ListItemModel;
import de.vw.mib.widgets.models.TemplateListModel;
import de.vw.mib.widgets.models.TouchAreaModel;
import de.vw.mib.widgets.models.WidgetModel;
import de.vw.mib.widgets.speller.asia.AsiaInputInitializer;

public interface AsiaSpellerModel
extends AbstractSpellerModel {
    public static final int PID_BASE;
    public static final int PID_ALPHABET_MAPPING;
    public static final int PID_ASIA_CONVERSION_ENABLED;
    public static final int PID_FILTER_ID;
    public static final int PID_HWR_AREA_REF;
    public static final int PID_HWR_ENABLED;
    public static final int PID_HWR_HIDDEN_CONTENT_REFS;
    public static final int PID_HWR_INFO_TEXT_REFS;
    public static final int PID_HWR_MODE;
    public static final int PID_HWR_VISIBLE_CONTENT_REFS;
    public static final int PID_INPUT_TYPE;
    public static final int PID_LIST_ITEM_LIMITATIONS;
    public static final int PID_LIST_ITEM_NOTIFICATIONS;
    public static final int PID_LIST_ITEM_REF_CONTENTS;
    public static final int PID_LIST_ITEM_REFS;
    public static final int PID_LIST_REFS;
    public static final int PID_FIRST_LETTER_INPUT;
    public static final int PID_NAME_INPUT;
    public static final int PID_SYLLABLEWISE_INPUT;
    public static final int PID_USER_DATABASE_ENABLED;
    public static final int PID_WORD_SEGMENTATION_ENABLED;
    public static final int PID_COUNT_ASIA_SPELLER;
    public static final int SID_BASE;
    public static final int SID_ASIA_CONVERSION_ENABLED;
    public static final int SID_HWR_ENABLED;
    public static final int SID_PREVIEWLINE_EXPANDED;
    public static final int SID_FIRST_LETTER_INPUT;
    public static final int SID_NAME_INPUT;
    public static final int SID_SYLLABLEWISE_INPUT;
    public static final int SID_USER_DATABASE_ENABLED;
    public static final int SID_WORD_SEGMENTATION_ENABLED;
    public static final int SID_COUNT_ASIA_SPELLER;
    public static final int ALPHABET_MAPPING_INDEX_BASE;
    public static final int ALPHABET_MAPPING_INDEX_HIRAGANA;
    public static final int ALPHABET_MAPPING_INDEX_ROMAJI;
    public static final int ALPHABET_MAPPING_INDEX_PINYIN;
    public static final int ALPHABET_MAPPING_INDEX_HWR;
    public static final int ALPHABET_MAPPING_INDEX_ZHUYIN;
    public static final int ALPHABET_MAPPING_INDEX_HWR_TRADITIONAL;
    public static final int ALPHABET_MAPPING_INDEX_JAMO;
    public static final int ALPHABET_MAPPING_INDEX_JAMO_SEQ;
    public static final int ALPHABET_MAPPING_INDEX_COUNT_ASIA_SPELLER;
    public static final int FILTER_ID_NONE;
    public static final int FILTER_ID_PHONE_CONTACTS;
    public static final int FILTER_ID_MESSAGE_CONTACTS;
    public static final int FILTER_ID_DESTINPUT_MATCH_TEXT;
    public static final int FILTER_ID_DESTINPUT_MATCH_TEXT_NUMBER;
    public static final int FILTER_ID_POI_SEARCH_MATCH;
    public static final int HWR_MODE_OFF;
    public static final int HWR_MODE_FREETEXT;
    public static final int HWR_MODE_LETTER_FIRST;
    public static final int HWR_MODE_NUMBER_FIRST;
    public static final int HWR_MODE_NUMBER_FIRST_HOUSE_NUM;
    public static final int HWR_MODE_NUMBER_FIRST_TEL;
    public static final int HWR_MODE_NUMBER_FIRST_ZIP;
    public static final int INPUT_TYPE_BASE;
    public static final int INPUT_TYPE_NONE;
    public static final int INPUT_TYPE_CHINA;
    public static final int INPUT_TYPE_JAPAN;
    public static final int INPUT_TYPE_KOREA;
    public static final int INPUT_TYPE_COUNT_ASIA_SPELLER;
    public static final int LIST_ITEM_REF_CONTENT_BASE;
    public static final int LIST_ITEM_REF_CONTENT_UNKNOWN;
    public static final int LIST_ITEM_REF_CONTENT_HISTORY;
    public static final int LIST_ITEM_REF_CONTENT_PREVIEW;
    public static final int LIST_ITEM_REF_CONTENT_RESULT;
    public static final int LIST_ITEM_REF_CONTENT_PREDICTION;
    public static final int LIST_ITEM_REF_CONTENT_COUNT_ASIA_SPELLER;
    public static final int MID_BASE;
    public static final int MID_HWRMATCH;
    public static final int MID_HWRFREE;
    public static final int MID_HWRPREV;
    public static final int MID_COUNT_ASIA_SPELLER;
    public static final int MODE_HWRMATCH;
    public static final int MODE_HWRFREE;
    public static final int MODE_HWRPREV;

    default public int[] get_alphabetMapping() {
    }

    default public void set_alphabetMapping(int[] nArray) {
    }

    default public boolean is_asiaConversionEnabled() {
    }

    default public void set_asiaConversionEnabled(boolean bl) {
    }

    default public int get_filterId() {
    }

    default public void set_filterId(int n) {
    }

    default public boolean is_firstLetterInput() {
    }

    default public void set_firstLetterInput(boolean bl) {
    }

    default public TouchAreaModel get_hwrAreaRef() {
    }

    default public void set_hwrAreaRef(TouchAreaModel touchAreaModel) {
    }

    default public boolean is_hwrEnabled() {
    }

    default public void set_hwrEnabled(boolean bl) {
    }

    default public ContainerModel[] get_hwrHiddenContentRefs() {
    }

    default public void set_hwrHiddenContentRefs(ContainerModel[] containerModelArray) {
    }

    default public int get_hwrMode() {
    }

    default public void set_hwrMode(int n) {
    }

    default public ContainerModel[] get_hwrVisibleContentRefs() {
    }

    default public void set_hwrVisibleContentRefs(ContainerModel[] containerModelArray) {
    }

    default public WidgetModel[] get_hwrInfoTextRefs() {
    }

    default public void set_hwrInfoTextRefs(WidgetModel[] widgetModelArray) {
    }

    default public int get_inputType() {
    }

    default public void set_inputType(int n) {
    }

    default public int[] get_listItemLimitations() {
    }

    default public void set_listItemLimitations(int[] nArray) {
    }

    default public boolean[] get_listItemNotifications() {
    }

    default public void set_listItemNotifications(boolean[] blArray) {
    }

    default public ListItemModel[] get_listItemRefs() {
    }

    default public void set_listItemRefs(ListItemModel[] listItemModelArray) {
    }

    default public int[] get_listItemRefContents() {
    }

    default public void set_listItemRefContents(int[] nArray) {
    }

    default public TemplateListModel[] get_listRefs() {
    }

    default public void set_listRefs(TemplateListModel[] templateListModelArray) {
    }

    default public boolean is_nameInput() {
    }

    default public void set_nameInput(boolean bl) {
    }

    default public boolean is_syllablewiseInput() {
    }

    default public void set_syllablewiseInput(boolean bl) {
    }

    default public boolean is_userDatabaseEnabled() {
    }

    default public void set_userDatabaseEnabled(boolean bl) {
    }

    default public boolean is_wordSegmentationEnabled() {
    }

    default public void set_wordSegmentationEnabled(boolean bl) {
    }

    default public boolean isInHiraganaAlphabet() {
    }

    default public boolean isInHwrAlphabet() {
    }

    default public boolean isInJamoAlphabet() {
    }

    default public boolean isInLatinAlphabet() {
    }

    default public boolean isInPinyinAlphabet() {
    }

    default public boolean isInRomajiAlphabet() {
    }

    default public boolean isInZhuyinAlphabet() {
    }

    default public AsiaInputInitializer getAsiaInputInitializer() {
    }

    default public String getSpelling() {
    }

    default public int getSpellingPosition() {
    }

    default public String[] getWordDatabaseNames() {
    }

    default public void setCandidates(String[] stringArray) {
    }

    default public void setNextValidCharacters(String[] stringArray) {
    }

    default public void setPrediction(String[] stringArray) {
    }

    default public void setRecognizedCharacters(String[] stringArray) {
    }

    default public void clearHwrArea() {
    }

    default public void updateInputField(String string, String string2, int n) {
    }

    default public void updateInputField(String string, String string2, int n, int n2, int n3) {
    }

    default public void updateInputField(String string, String string2, int n, int n2, int n3, int n4) {
    }

    default public void updateSpellerButtons(String string, String string2) {
    }
}

