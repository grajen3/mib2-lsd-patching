/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.activity;

public final class ActivityType {
    private final String name;
    public static final ActivityType STARTUP = new ActivityType("Startup");
    public static final ActivityType DIALOG_SDS = new ActivityType("SpeechDialog");
    public static final ActivityType DIALOG_PROMPT = new ActivityType("PromptDialog");
    public static final ActivityType GRAMMAR_UPDATE = new ActivityType("GrammarUpdate");
    public static final ActivityType LANGUAGE_CHANGE = new ActivityType("LanguageChange");
    public static final ActivityType RESTART_ASR = new ActivityType("AsrRestart");
    public static final ActivityType RESTART_TTS = new ActivityType("TtsRestart");

    private ActivityType(String string) {
        this.name = string;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ActivityType (name=");
        stringBuffer.append(this.name);
        stringBuffer.append(")");
        return stringBuffer.toString();
    }

    public int hashCode() {
        int n = 31;
        int n2 = 1;
        n2 = 31 * n2 + (this.name == null ? 0 : this.name.hashCode());
        return n2;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (super.getClass() != object.getClass()) {
            return false;
        }
        ActivityType activityType = (ActivityType)object;
        return !(this.name == null ? activityType.name != null : !this.name.equals(activityType.name));
    }
}

