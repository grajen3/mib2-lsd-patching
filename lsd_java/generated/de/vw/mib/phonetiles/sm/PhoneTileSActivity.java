/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.phonetiles.sm;

import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.sm.internal.statemachine.TopStatemachine;
import generated.de.vw.mib.global.sm.internal.activity.StatemachineActivityBase;

public class PhoneTileSActivity
extends StatemachineActivityBase {
    private final int subStatemachineId;

    public PhoneTileSActivity(TopStatemachine topStatemachine, int n, int n2, int n3, int n4, int n5) {
        super(topStatemachine, n2, n3, n4, n5);
        this.subStatemachineId = n;
    }

    @Override
    public void performStateEntryAction(int n, boolean bl) {
        switch (this.subStatemachineId) {
            case 560: {
                this.performStateEntryAction_SubPopupPoPhonetilesWaitstateTransparentDynState(n, bl);
                break;
            }
            case 34: {
                this.performStateEntryAction_SubHapticPhonetilesDynState(n, bl);
                break;
            }
            default: {
                return;
            }
        }
    }

    @Override
    public void performStateExitAction(int n) {
        switch (this.subStatemachineId) {
            case 560: {
                this.performStateExitAction_SubPopupPoPhonetilesWaitstateTransparentDynState(n);
                break;
            }
            case 34: {
                this.performStateExitAction_SubHapticPhonetilesDynState(n);
                break;
            }
            default: {
                return;
            }
        }
    }

    @Override
    public void performStateFocusGainedAction(int n) {
        switch (this.subStatemachineId) {
            default: 
        }
    }

    @Override
    public void performStateFocusLostAction(int n) {
        switch (this.subStatemachineId) {
            default: 
        }
    }

    @Override
    public boolean evalInternalTransitionGuard(int n) {
        switch (this.subStatemachineId) {
            case 34: {
                return this.evalInternalTransitionGuard_SubHapticPhonetilesDynState(n);
            }
        }
        return true;
    }

    @Override
    public void performInternalTransitionAction(int n) {
        switch (this.subStatemachineId) {
            case 34: {
                this.performInternalTransitionAction_SubHapticPhonetilesDynState(n);
                break;
            }
            default: {
                return;
            }
        }
    }

    @Override
    public boolean evalTriggeredTransitionGuard(int n) {
        switch (this.subStatemachineId) {
            case 34: {
                return this.evalTriggeredTransitionGuard_SubHapticPhonetilesDynState(n);
            }
        }
        return true;
    }

    @Override
    public void performTriggeredTransitionAction(int n) {
        switch (this.subStatemachineId) {
            case 34: {
                this.performTriggeredTransitionAction_SubHapticPhonetilesDynState(n);
                break;
            }
            default: {
                return;
            }
        }
    }

    @Override
    public boolean evalUntriggeredTransitionGuard(int n) {
        switch (this.subStatemachineId) {
            case 34: {
                return this.evalUntriggeredTransitionGuard_SubHapticPhonetilesDynState(n);
            }
        }
        return true;
    }

    @Override
    public void performUntriggeredTransitionAction(int n) {
        switch (this.subStatemachineId) {
            default: 
        }
    }

    private void performStateEntryAction_SubPopupPoPhonetilesWaitstateTransparentDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 2: {
                this.enterPopupView("Ppwt_721E", 560, 2);
                break;
            }
        }
    }

    private void performStateExitAction_SubPopupPoPhonetilesWaitstateTransparentDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 0: {
                PhoneTileSActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 2, this.topStatemachine.getPopupInfoId());
                break;
            }
            case 2: {
                this.leavePopupView("Ppwt_721E");
                break;
            }
        }
    }

    private void performStateEntryAction_SubHapticPhonetilesDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 5: {
                this.showView("Pstl", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 6: {
                this.setBoolean(-922943488, true);
                EventGeneric eventGeneric = PhoneTileSActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(-922943488));
                this.triggerObserver(-147102144, eventGeneric);
                break;
            }
            case 8: {
                this.showView("Pstnp", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 10: {
                this.enterWaitaphoreForProperty(0x101A0100, 477, 587, 1097436489, 1080659273);
                break;
            }
            case 12: {
                this.showView("Pstc", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 13: {
                this.setInteger(1493041152, 6);
                if (this.getBoolean(1989541888)) {
                    this.setInteger(1493041152, 6);
                }
                if (this.getBoolean(32205)) {
                    this.setInteger(1493041152, 10);
                }
                if (this.getBoolean(690422016)) {
                    this.setInteger(1493041152, 10);
                }
                EventGeneric eventGeneric = PhoneTileSActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(1493041152));
                this.triggerObserver(-381983168, eventGeneric);
                if (this.getBoolean(839778560)) {
                    this.setInteger(31597, 5);
                }
                if (this.getBoolean(839778560)) {
                    eventGeneric = PhoneTileSActivity.newEvent();
                    eventGeneric.setInt(0, this.getInteger(31597));
                    this.triggerObserver(-398760384, eventGeneric);
                }
                this.showView("Pstf", bl, this.getIncludeDdpGroupId());
                break;
            }
        }
    }

    private void performStateExitAction_SubHapticPhonetilesDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 5: {
                this.hideView("Pstl");
                break;
            }
            case 6: {
                this.setBoolean(-922943488, false);
                EventGeneric eventGeneric = PhoneTileSActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(-922943488));
                this.triggerObserver(-147102144, eventGeneric);
                break;
            }
            case 8: {
                this.hideView("Pstnp");
                break;
            }
            case 10: {
                this.leaveWaitaphore();
                break;
            }
            case 12: {
                this.hideView("Pstc");
                break;
            }
            case 13: {
                this.hideView("Pstf");
                break;
            }
        }
    }

    private boolean evalInternalTransitionGuard_SubHapticPhonetilesDynState(int n) {
        switch (n - this.IT_OFFSET) {
            case 7: {
                return !this.getBoolean(-708378624);
            }
            case 8: {
                return this.getBoolean(-708378624);
            }
            case 9: {
                return !this.getBoolean(-1313341440);
            }
            case 10: {
                return this.getBoolean(-1313341440);
            }
            case 15: {
                return this.getLicValue(-94214656, 6, this.getInteger(1108345088), false);
            }
        }
        return true;
    }

    private void performInternalTransitionAction_SubHapticPhonetilesDynState(int n) {
        this.performInternalTransitionAction_SubHapticPhonetilesDynState00(n);
    }

    private void performInternalTransitionAction_SubHapticPhonetilesDynState00(int n) {
        switch (n - this.IT_OFFSET) {
            case 1: {
                this.triggerObserver(-331651520);
                break;
            }
            case 2: {
                this.triggerObserver(-214211008);
                break;
            }
            case 3: {
                this.triggerObserver(-247765440);
                break;
            }
            case 4: {
                this.triggerObserver(-314874304);
                break;
            }
            case 5: {
                this.triggerObserver(-264542656);
                break;
            }
            case 6: {
                this.triggerObserver(-281319872);
                break;
            }
            case 7: {
                this.setBoolean(28557, true);
                EventGeneric eventGeneric = PhoneTileSActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(28557));
                this.triggerObserver(-348428736, eventGeneric);
                break;
            }
            case 8: {
                this.setBoolean(28557, false);
                EventGeneric eventGeneric = PhoneTileSActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(28557));
                this.triggerObserver(-348428736, eventGeneric);
                break;
            }
            case 9: {
                this.setBoolean(-1659961088, true);
                EventGeneric eventGeneric = PhoneTileSActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(-1659961088));
                this.triggerObserver(-365205952, eventGeneric);
                break;
            }
            case 10: {
                this.setBoolean(-1659961088, false);
                EventGeneric eventGeneric = PhoneTileSActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(-1659961088));
                this.triggerObserver(-365205952, eventGeneric);
                break;
            }
            case 11: {
                this.triggerObserver(-298097088);
                break;
            }
            case 12: {
                this.triggerObserver(-230988224);
                break;
            }
            case 13: {
                this.setInteger(-955973376, 0);
                EventGeneric eventGeneric = PhoneTileSActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-955973376));
                this.triggerObserver(-197433792, eventGeneric);
                break;
            }
            case 14: {
                this.setInteger(1108345088, PhoneTileSActivity.evListItemActionIndex());
                this.setInteger(0x5B50000, this.getInteger(1108345088));
                EventGeneric eventGeneric = PhoneTileSActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(0x5B50000));
                this.triggerObserver(-180656576, eventGeneric);
                break;
            }
            case 15: {
                this.setInteger(13743, 0);
                this.setInteger(-522518528, 11);
                this.setInteger(1021706240, 0);
                PhoneTileSActivity.fireHMIEvent(ANY, BROADCAST, 1465945417);
                break;
            }
        }
    }

    private boolean evalTriggeredTransitionGuard_SubHapticPhonetilesDynState(int n) {
        switch (n - this.TT_OFFSET) {
            case 9: {
                return !this.getLicValue(-94214656, 6, this.getInteger(1108345088), false);
            }
        }
        return true;
    }

    private void performTriggeredTransitionAction_SubHapticPhonetilesDynState(int n) {
        this.performTriggeredTransitionAction_SubHapticPhonetilesDynState0(n);
    }

    private void performTriggeredTransitionAction_SubHapticPhonetilesDynState0(int n) {
        switch (n - this.TT_OFFSET) {
            case 7: {
                this.setLong(-544604160, 0L);
                this.setInteger(29056, this.getLicValue(-94214656, 0, this.getInteger(1108345088), 0));
                this.setInteger(-1180631040, this.getLicValue(-94214656, 0, this.getInteger(1108345088), 0));
                this.setString(1461190912, this.getLicValue(-94214656, 3, this.getInteger(1108345088), ""));
                this.setInteger(1620967424, this.getInteger(1108345088));
                this.setString(950992896, this.getLicValue(-94214656, 3, this.getInteger(1108345088), ""));
                this.setInteger(13743, 2);
                PhoneTileSActivity.fireHMIEvent(ANY, BROADCAST, 1465945417);
                break;
            }
            case 8: {
                if (this.getInteger(0x101A0100) != 1) {
                    this.setLong(-544604160, 0L);
                    this.setInteger(29056, this.getLicValue(-94214656, 0, this.getInteger(1108345088), 0));
                    this.setInteger(-1180631040, this.getLicValue(-94214656, 0, this.getInteger(1108345088), 0));
                    this.setString(1461190912, this.getLicValue(-94214656, 3, this.getInteger(1108345088), ""));
                    this.setInteger(1620967424, this.getInteger(1108345088));
                    this.setString(950992896, this.getLicValue(-94214656, 3, this.getInteger(1108345088), ""));
                    this.setInteger(13743, 2);
                    PhoneTileSActivity.fireHMIEvent(ANY, BROADCAST, 1465945417);
                }
                if (this.getInteger(0x101A0100) != 1) break;
                this.setLong(-544604160, 0L);
                this.setInteger(29056, this.getLicValue(-94214656, 0, this.getInteger(1108345088), 0));
                this.setInteger(-1180631040, this.getLicValue(-94214656, 0, this.getInteger(1108345088), 0));
                this.setString(1461190912, this.getLicValue(-94214656, 3, this.getInteger(1108345088), ""));
                this.setInteger(1620967424, this.getInteger(1108345088));
                EventGeneric eventGeneric = PhoneTileSActivity.newEvent();
                eventGeneric.setLong(0, this.getLong(-544604160));
                eventGeneric.setString(1, this.getString(1461190912));
                eventGeneric.setInt(2, this.getInteger(29056));
                eventGeneric.setInt(3, this.getInteger(-1180631040));
                eventGeneric.setInt(4, this.getInteger(1620967424));
                this.triggerObserver(-430172864, eventGeneric);
                break;
            }
            case 9: {
                this.setString(-125698048, this.getLicValue(-94214656, 3, this.getInteger(1108345088), ""));
                PhoneTileSActivity.lockWaitaphore(0x101A0100, 1000);
                EventGeneric eventGeneric = PhoneTileSActivity.newEvent();
                eventGeneric.setString(0, this.getString(-125698048));
                this.triggerObserver(-163879360, eventGeneric);
                break;
            }
        }
    }

    private boolean evalUntriggeredTransitionGuard_SubHapticPhonetilesDynState(int n) {
        switch (n - this.UT_OFFSET) {
            case 4: {
                return this.getInteger(16652) == 0;
            }
            case 6: {
                return this.getInteger(-2131820544) != 5 || this.getInteger(-370802688) != 2;
            }
            case 8: {
                return this.getInteger(2123956224) == 0 || this.getInteger(2123956224) == 2;
            }
        }
        return true;
    }
}

