/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.properties.values;

public class SpellerData
implements Cloneable {
    private static final String[] EMPTY_STRING_ARRAY = new String[0];
    public static final String AVAILABLE_CHARACTERS_ALL;
    private String availableCharacters;
    private int cursorPosition;
    private String enteredText;
    private String matchCompletion;
    private int matchCount;
    private String matchText;
    private int selectionEnd;
    private int selectionStart;
    private String unavailableCharacters;
    private String[] wordDatabaseNames;

    public SpellerData() {
        this("", "", 0, "", "", 0, "", 0, 0, EMPTY_STRING_ARRAY);
    }

    public SpellerData(String string, String string2, int n, int n2, int n3, int n4, String string3) {
        this("", string3, n2, string, "", n, string2, n3, n4, EMPTY_STRING_ARRAY);
    }

    public SpellerData(String string, String string2, String string3, int n, int n2, int n3, int n4) {
        this(string, "", n2, string2, "", n, string3, n3, n4, EMPTY_STRING_ARRAY);
    }

    public SpellerData(String string, String string2, String string3, String string4, int n, int n2, int n3, int n4) {
        this(string, "", n2, string2, string3, n, string4, n3, n4, EMPTY_STRING_ARRAY);
    }

    private SpellerData(String string, String string2, int n, String string3, String string4, int n2, String string5, int n3, int n4, String[] stringArray) {
        this.availableCharacters = string;
        this.unavailableCharacters = string2;
        this.cursorPosition = n;
        this.enteredText = string3;
        this.matchCompletion = string4;
        this.matchCount = n2;
        this.matchText = string5;
        this.selectionStart = n3;
        this.selectionEnd = n4;
        this.wordDatabaseNames = stringArray;
    }

    public Object clone() {
        try {
            return super.clone();
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new RuntimeException(cloneNotSupportedException);
        }
    }

    public String getAvailableCharacters() {
        return this.availableCharacters;
    }

    public int getCursorPosition() {
        return this.cursorPosition;
    }

    public String getEnteredText() {
        return this.enteredText;
    }

    public String getMatchCompletion() {
        return this.matchCompletion;
    }

    public int getMatchCount() {
        return this.matchCount;
    }

    public String getMatchText() {
        return this.matchText;
    }

    public int getSelectionEnd() {
        return this.selectionEnd;
    }

    public int getSelectionStart() {
        return this.selectionStart;
    }

    public String getUnavailableCharacters() {
        return this.unavailableCharacters;
    }

    public String[] getWordDatabaseNames() {
        return this.wordDatabaseNames;
    }

    public void setAvailableCharacters(String string) {
        this.availableCharacters = null != string ? string : "";
    }

    public void setCursorPosition(int n) {
        this.cursorPosition = n;
    }

    public void setEnteredText(String string) {
        this.enteredText = null != string ? string : "";
    }

    public void setMatchCompletion(String string) {
        this.matchCompletion = null != string ? string : "";
    }

    public void setMatchCount(int n) {
        this.matchCount = n;
    }

    public void setMatchText(String string) {
        this.matchText = null != string ? string : "";
    }

    public void setSelectionEnd(int n) {
        this.selectionEnd = n;
    }

    public void setSelectionStart(int n) {
        this.selectionStart = n;
    }

    public void setUnavailableCharacters(String string) {
        this.unavailableCharacters = null != string ? string : "";
    }

    public void setWordDatabaseNames(String[] stringArray) {
        this.wordDatabaseNames = stringArray;
    }

    public void copyFrom(SpellerData spellerData) {
        this.availableCharacters = spellerData.availableCharacters;
        this.cursorPosition = spellerData.cursorPosition;
        this.enteredText = spellerData.enteredText;
        this.matchCompletion = spellerData.matchCompletion;
        this.matchCount = spellerData.matchCount;
        this.matchText = spellerData.matchText;
        this.selectionEnd = spellerData.selectionEnd;
        this.selectionStart = spellerData.selectionStart;
        this.unavailableCharacters = spellerData.unavailableCharacters;
        this.wordDatabaseNames = spellerData.wordDatabaseNames;
    }

    public void resetSelection() {
        this.selectionEnd = -1;
        this.selectionStart = -1;
    }

    public boolean isSelectionActive() {
        return this.selectionStart < this.selectionEnd;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(256);
        stringBuffer.append("SpellerData(");
        stringBuffer.append("availableCharacters='").append(this.availableCharacters).append("',");
        stringBuffer.append("unavailableCharacters='").append(this.unavailableCharacters).append("',");
        stringBuffer.append("enteredText='").append(this.enteredText).append("',");
        stringBuffer.append("matchText='").append(this.matchText).append("',");
        stringBuffer.append("matchCompletion='").append(this.matchCompletion).append("',");
        stringBuffer.append("matchCount=").append(this.matchCount).append(",");
        stringBuffer.append("cursorPosition=").append(this.cursorPosition).append(",");
        stringBuffer.append("selectionStart=").append(this.selectionStart).append(",");
        stringBuffer.append("selectionEnd=").append(this.selectionEnd).append(",");
        stringBuffer.append("wordDatabaseNames=[");
        if (this.wordDatabaseNames != null && this.wordDatabaseNames.length > 0) {
            stringBuffer.append("'").append(this.wordDatabaseNames[0]).append("'");
            for (int i2 = 1; i2 < this.wordDatabaseNames.length; ++i2) {
                stringBuffer.append(",").append("'").append(this.wordDatabaseNames[i2]).append("'");
            }
        }
        stringBuffer.append("]").append(")");
        return stringBuffer.toString();
    }
}

