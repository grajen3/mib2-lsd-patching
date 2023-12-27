/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.thinkbluetiles.sm;

import de.vw.mib.sm.internal.statemachine.TopStatemachine;
import generated.de.vw.mib.global.sm.internal.activity.StatemachineActivityBase;

public class ThinkBlueTileSActivity
extends StatemachineActivityBase {
    public ThinkBlueTileSActivity(TopStatemachine topStatemachine, int n, int n2, int n3, int n4, int n5) {
        super(topStatemachine, n2, n3, n4, n5);
    }

    @Override
    public void performStateEntryAction(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 6: {
                if (this.getInteger(-438763520) == 0) {
                    this.setInteger(511967232, this.getInteger(32344));
                    this.setInteger(337903872, this.getInteger(32344));
                    if (this.getInteger(32344) == 4) {
                        this.setBoolean(144769024, false);
                    }
                    if (this.getInteger(32344) == 4) {
                        this.setBoolean(416874496, false);
                    }
                    if (this.getInteger(32344) != 4) {
                        this.setBoolean(144769024, true);
                    }
                    if (this.getInteger(32344) != 4) {
                        this.setInteger(1912406016, this.getInteger(0x33130100));
                    }
                    if (this.getInteger(32344) == 1 && this.getInteger(32344) != 4) {
                        this.fireModelApiDownEvent(this.createModelApiDownEvent(38));
                    }
                }
                this.showView("Ctstm", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 7: {
                this.showView("Tbtslc", bl, this.getIncludeDdpGroupId());
                break;
            }
        }
    }

    @Override
    public void performStateExitAction(int n) {
        switch (n - this.S_OFFSET) {
            case 6: {
                this.hideView("Ctstm");
                if (this.getInteger(-438763520) != 0) break;
                ThinkBlueTileSActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1315474761);
                ThinkBlueTileSActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1365806409);
                if (this.getInteger(32344) != 2 && this.getInteger(32344) != 0 && this.getInteger(32344) != 4) {
                    this.fireModelApiDownEvent(this.createModelApiDownEvent(37));
                }
                this.setBoolean(416874496, false);
                this.setBoolean(144769024, false);
                this.setInteger(511967232, 4);
                this.setInteger(337903872, 4);
                break;
            }
            case 7: {
                this.hideView("Tbtslc");
                break;
            }
        }
    }

    @Override
    public boolean evalInternalTransitionGuard(int n) {
        switch (n - this.IT_OFFSET) {
            case 1: {
                return this.getInteger(-438763520) == 0;
            }
            case 2: {
                return this.getInteger(32344) != 2 && this.getInteger(32344) != 0 && this.getInteger(-438763520) == 0;
            }
            case 3: {
                return this.getInteger(32344) == 4 && this.getInteger(-438763520) == 0;
            }
            case 4: {
                return this.getInteger(337903872) == this.getInteger(511967232) && this.getInteger(32344) != 4 && this.getInteger(-438763520) == 0;
            }
            case 5: {
                return this.getInteger(32344) != 4 && this.getInteger(337903872) != this.getInteger(511967232) && this.getInteger(-438763520) == 0;
            }
            case 6: {
                return this.getInteger(32344) == 4 && !this.getBoolean(416874496) && this.getInteger(-438763520) == 0;
            }
            case 7: {
                return this.getInteger(32344) != 4 && this.getBoolean(416874496) && this.getInteger(-438763520) == 0;
            }
            case 8: {
                return this.getInteger(32344) != 4 && !this.getBoolean(416874496) && this.getInteger(-438763520) == 0;
            }
        }
        return true;
    }

    @Override
    public void performInternalTransitionAction(int n) {
        this.performInternalTransitionAction0(n);
    }

    private void performInternalTransitionAction0(int n) {
        switch (n - this.IT_OFFSET) {
            case 1: {
                if (this.getInteger(32344) == 4) break;
                ThinkBlueTileSActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1349029193);
                this.setBoolean(416874496, true);
                break;
            }
            case 2: {
                this.setBoolean(144769024, false);
                this.fireModelApiDownEvent(this.createModelApiDownEvent(37));
                break;
            }
            case 3: {
                this.setBoolean(144769024, false);
                this.setBoolean(416874496, false);
                break;
            }
            case 4: {
                ThinkBlueTileSActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1298697545);
                this.setBoolean(416874496, false);
                break;
            }
            case 5: {
                this.setBoolean(416874496, true);
                this.setInteger(1912406016, this.getInteger(0x33130100));
                ThinkBlueTileSActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1349029193);
                this.setInteger(511967232, this.getInteger(337903872));
                break;
            }
            case 6: {
                ThinkBlueTileSActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1315474761);
                this.setInteger(511967232, this.getInteger(32344));
                this.setInteger(337903872, this.getInteger(32344));
                this.setBoolean(144769024, false);
                break;
            }
            case 7: {
                this.setInteger(337903872, this.getInteger(32344));
                break;
            }
            case 8: {
                ThinkBlueTileSActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1315474761);
                this.setBoolean(144769024, true);
                this.setInteger(511967232, this.getInteger(32344));
                this.setInteger(337903872, this.getInteger(511967232));
                this.setInteger(1912406016, this.getInteger(0x33130100));
                this.setBoolean(416874496, true);
                if (this.getInteger(32344) == 1) {
                    this.fireModelApiDownEvent(this.createModelApiDownEvent(38));
                }
                ThinkBlueTileSActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1349029193);
                break;
            }
            case 9: {
                this.setInteger(-438763520, ThinkBlueTileSActivity.evIntegerValueValue());
                if (this.getInteger(-438763520) == 0) {
                    this.setInteger(511967232, this.getInteger(32344));
                    this.setInteger(337903872, this.getInteger(32344));
                    if (this.getInteger(32344) == 4) {
                        this.setBoolean(144769024, false);
                    }
                    if (this.getInteger(32344) == 4) {
                        this.setBoolean(416874496, false);
                    }
                    if (this.getInteger(32344) != 4) {
                        this.setBoolean(144769024, true);
                    }
                    if (this.getInteger(32344) != 4) {
                        this.setInteger(1912406016, this.getInteger(0x33130100));
                    }
                    if (this.getInteger(32344) == 1 && this.getInteger(32344) != 4) {
                        this.fireModelApiDownEvent(this.createModelApiDownEvent(38));
                    }
                    if (this.getInteger(32344) != 4) {
                        ThinkBlueTileSActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1349029193);
                        this.setBoolean(416874496, true);
                    }
                }
                if (this.getInteger(-438763520) == 0) break;
                ThinkBlueTileSActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1315474761);
                ThinkBlueTileSActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1365806409);
                if (this.getInteger(32344) != 2 && this.getInteger(32344) != 0 && this.getInteger(32344) != 4) {
                    this.fireModelApiDownEvent(this.createModelApiDownEvent(37));
                }
                this.setBoolean(416874496, false);
                this.setBoolean(144769024, false);
                this.setInteger(511967232, 4);
                this.setInteger(337903872, 4);
                break;
            }
        }
    }

    @Override
    public boolean evalUntriggeredTransitionGuard(int n) {
        switch (n - this.UT_OFFSET) {
            case 1: {
                return this.getInteger(1307770880) == 1;
            }
        }
        return true;
    }
}

