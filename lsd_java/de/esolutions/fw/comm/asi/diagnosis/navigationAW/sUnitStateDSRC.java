/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.navigationAW;

public class sUnitStateDSRC {
    public long msg_id;
    public int cardPlugInState;
    public int cardAuthState;
    public int cardWritingState;
    public int cardReadingState;
    public int cardAnormalState;
    public int etcBarState;
    public short retryCounterEtcComm;
    public short errorCounterEtcComm;
    public boolean dateTimeValid;
    public short yearLastErrorComm;
    public short monthLastErrorComm;
    public short dayLastErrorComm;
    public short hourLastErrorComm;
    public short minuteLastErrorComm;
    public short secondsLastErrorComm;
    public int cardType;

    public long getMsg_id() {
        return this.msg_id;
    }

    public void setMsg_id(long l) {
        this.msg_id = l;
    }

    public int getCardPlugInState() {
        return this.cardPlugInState;
    }

    public void setCardPlugInState(int n) {
        this.cardPlugInState = n;
    }

    public int getCardAuthState() {
        return this.cardAuthState;
    }

    public void setCardAuthState(int n) {
        this.cardAuthState = n;
    }

    public int getCardWritingState() {
        return this.cardWritingState;
    }

    public void setCardWritingState(int n) {
        this.cardWritingState = n;
    }

    public int getCardReadingState() {
        return this.cardReadingState;
    }

    public void setCardReadingState(int n) {
        this.cardReadingState = n;
    }

    public int getCardAnormalState() {
        return this.cardAnormalState;
    }

    public void setCardAnormalState(int n) {
        this.cardAnormalState = n;
    }

    public int getEtcBarState() {
        return this.etcBarState;
    }

    public void setEtcBarState(int n) {
        this.etcBarState = n;
    }

    public short getRetryCounterEtcComm() {
        return this.retryCounterEtcComm;
    }

    public void setRetryCounterEtcComm(short s) {
        this.retryCounterEtcComm = s;
    }

    public short getErrorCounterEtcComm() {
        return this.errorCounterEtcComm;
    }

    public void setErrorCounterEtcComm(short s) {
        this.errorCounterEtcComm = s;
    }

    public boolean isDateTimeValid() {
        return this.dateTimeValid;
    }

    public void setDateTimeValid(boolean bl) {
        this.dateTimeValid = bl;
    }

    public short getYearLastErrorComm() {
        return this.yearLastErrorComm;
    }

    public void setYearLastErrorComm(short s) {
        this.yearLastErrorComm = s;
    }

    public short getMonthLastErrorComm() {
        return this.monthLastErrorComm;
    }

    public void setMonthLastErrorComm(short s) {
        this.monthLastErrorComm = s;
    }

    public short getDayLastErrorComm() {
        return this.dayLastErrorComm;
    }

    public void setDayLastErrorComm(short s) {
        this.dayLastErrorComm = s;
    }

    public short getHourLastErrorComm() {
        return this.hourLastErrorComm;
    }

    public void setHourLastErrorComm(short s) {
        this.hourLastErrorComm = s;
    }

    public short getMinuteLastErrorComm() {
        return this.minuteLastErrorComm;
    }

    public void setMinuteLastErrorComm(short s) {
        this.minuteLastErrorComm = s;
    }

    public short getSecondsLastErrorComm() {
        return this.secondsLastErrorComm;
    }

    public void setSecondsLastErrorComm(short s) {
        this.secondsLastErrorComm = s;
    }

    public int getCardType() {
        return this.cardType;
    }

    public void setCardType(int n) {
        this.cardType = n;
    }

    public sUnitStateDSRC() {
    }

    public sUnitStateDSRC(long l, int n, int n2, int n3, int n4, int n5, int n6, short s, short s2, boolean bl, short s3, short s4, short s5, short s6, short s7, short s8, int n7) {
        this.msg_id = l;
        this.cardPlugInState = n;
        this.cardAuthState = n2;
        this.cardWritingState = n3;
        this.cardReadingState = n4;
        this.cardAnormalState = n5;
        this.etcBarState = n6;
        this.retryCounterEtcComm = s;
        this.errorCounterEtcComm = s2;
        this.dateTimeValid = bl;
        this.yearLastErrorComm = s3;
        this.monthLastErrorComm = s4;
        this.dayLastErrorComm = s5;
        this.hourLastErrorComm = s6;
        this.minuteLastErrorComm = s7;
        this.secondsLastErrorComm = s8;
        this.cardType = n7;
    }

    public String toString() {
        return new StringBuffer("sUnitStateDSRC{").append("msg_id=").append(this.msg_id).append(", cardPlugInState=").append(this.cardPlugInState).append(", cardAuthState=").append(this.cardAuthState).append(", cardWritingState=").append(this.cardWritingState).append(", cardReadingState=").append(this.cardReadingState).append(", cardAnormalState=").append(this.cardAnormalState).append(", etcBarState=").append(this.etcBarState).append(", retryCounterEtcComm=").append(this.retryCounterEtcComm).append(", errorCounterEtcComm=").append(this.errorCounterEtcComm).append(", dateTimeValid=").append(this.dateTimeValid).append(", yearLastErrorComm=").append(this.yearLastErrorComm).append(", monthLastErrorComm=").append(this.monthLastErrorComm).append(", dayLastErrorComm=").append(this.dayLastErrorComm).append(", hourLastErrorComm=").append(this.hourLastErrorComm).append(", minuteLastErrorComm=").append(this.minuteLastErrorComm).append(", secondsLastErrorComm=").append(this.secondsLastErrorComm).append(", cardType=").append(this.cardType).append("}").toString();
    }
}

