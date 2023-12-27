/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.widgets.Instruments;
import de.vw.mib.widgets.Instruments$HaloInputValues$InputValue;

class Instruments$HaloInputValues {
    private static final int ANGLE_OFFSET_TO_ZERO;
    private static final int INPUT_VALUE_COUNT;
    Instruments$HaloInputValues$InputValue[] inputValues = new Instruments$HaloInputValues$InputValue[3];
    int readPos = 0;
    int writePos = 0;
    private final /* synthetic */ Instruments this$0;

    public Instruments$HaloInputValues(Instruments instruments) {
        this.this$0 = instruments;
        for (int i2 = this.inputValues.length - 1; i2 >= 0; --i2) {
            this.inputValues[i2] = new Instruments$HaloInputValues$InputValue(this);
        }
    }

    void addInput(int n, float f2, int n2) {
        this.inputValues[this.writePos].timeDelta = n2;
        float f3 = (float)this.this$0.get_radiusDrawingArea() / (float)this.this$0.get_valueMax();
        float f4 = (float)Math.toRadians(f2 + 46146);
        this.inputValues[this.writePos].posX = (float)(Math.cos(f4) * (double)n * (double)f3);
        this.inputValues[this.writePos].posY = (float)(Math.sin(f4) * (double)n * (double)f3);
        this.this$0.trace(new StringBuffer().append("HaloKindFreePositioning#addHaloValues() : added new x=").append(this.inputValues[this.writePos].posX).append(" and y=").append(this.inputValues[this.writePos].posY).toString());
        this.incrementWritePos();
    }

    private void incrementWritePos() {
        this.writePos = this.writePos + 1 != 3 ? this.writePos + 1 : 0;
    }

    void incrementReadPos() {
        this.readPos = this.readPos + 1 != 3 ? this.readPos + 1 : 0;
    }

    boolean isRingOverflow() {
        this.this$0.trace(new StringBuffer().append("HaloInputValues#isRingOverflow() : Ring-Overflow: rp=").append(this.readPos).append(" wp=").append(this.writePos).toString());
        return this.readPos == this.writePos;
    }

    void adjustLastInput(float f2, float f3) {
        this.inputValues[this.readPos].posX = f2;
        this.inputValues[this.readPos].posY = f3;
        this.incrementReadPos();
    }

    float currentX() {
        return this.inputValues[this.readPos].posX;
    }

    float currentY() {
        return this.inputValues[this.readPos].posY;
    }

    float previousX() {
        return this.inputValues[this.previousReadPos()].posX;
    }

    float previousY() {
        return this.inputValues[this.previousReadPos()].posY;
    }

    int previousTimeDelta() {
        return this.inputValues[this.previousReadPos()].timeDelta;
    }

    private int previousReadPos() {
        return this.readPos == 0 ? 2 : this.readPos - 1;
    }

    float currentTimeDelta() {
        return this.inputValues[this.readPos].timeDelta;
    }
}

