/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.global.sm.internal;

import de.vw.mib.sm.internal.statemachine.StatemachineActivationGuardEvaluator;
import generated.de.vw.mib.global.sm.internal.activity.StatemachineHandlerBase;

public class StatemachineActivationGuardEvaluatorImpl
extends StatemachineHandlerBase
implements StatemachineActivationGuardEvaluator {
    @Override
    public boolean statemachineShallBeStarted(int n) {
        switch (n) {
            case 554: {
                return this.getInteger(17141) == 0;
            }
            case 556: {
                return this.getInteger(1437532160) == 0;
            }
            case 559: {
                return this.getInteger(31672) == 0;
            }
            case 566: {
                return this.getInteger(-690749440) == 0;
            }
            case 569: {
                return this.getInteger(0x10180100) == 0;
            }
            case 570: {
                return this.getInteger(-911343616) == 0;
            }
            case 571: {
                return this.getInteger(-1307901696) == 0;
            }
            case 576: {
                return this.getInteger(-351534848) == 0;
            }
            case 577: {
                return this.getInteger(19157) == 0;
            }
            case 579: {
                return false;
            }
            case 580: {
                return this.getInteger(0x9B0000) == 0;
            }
            case 584: {
                return this.getInteger(-487391232) == 0;
            }
            case 586: {
                return this.getInteger(19247) == 0;
            }
            case 588: {
                return this.getInteger(-728367104) == 0;
            }
            case 592: {
                return this.getInteger(18271) == 0;
            }
            case 602: {
                return this.getInteger(453116160) == 0;
            }
            case 603: {
                return this.getInteger(1527709952) == 0;
            }
            case 604: {
                return this.getInteger(1527709952) == 0;
            }
            case 605: {
                return this.getInteger(-420610048) == 0;
            }
            case 606: {
                return this.getInteger(1484849152) == 0;
            }
            case 608: {
                return this.getInteger(-418840320) == 0;
            }
            case 611: {
                return this.getInteger(-356843520) == 0;
            }
            case 613: {
                return this.getInteger(16651) == 0;
            }
            case 614: {
                return this.getInteger(21641) == 0;
            }
            case 615: {
                return this.getInteger(388169984) == 0;
            }
            case 617: {
                return this.getInteger(-351534848) == 0;
            }
            case 619: {
                return this.getInteger(-418840320) == 0;
            }
        }
        return true;
    }
}

