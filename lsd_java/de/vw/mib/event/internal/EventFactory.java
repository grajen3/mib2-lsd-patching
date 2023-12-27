/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event.internal;

import de.vw.mib.app.framework.AppDefinition;
import de.vw.mib.configuration.ConfigurationManager;
import de.vw.mib.event.consumer.ViewAnimationEventConsumer;
import de.vw.mib.event.internal.AnimationEventImpl;
import de.vw.mib.event.internal.BooleanValueEventImpl;
import de.vw.mib.event.internal.ContextChangeEventImpl;
import de.vw.mib.event.internal.DatapoolUpdateEventImpl;
import de.vw.mib.event.internal.DisplayEventImpl;
import de.vw.mib.event.internal.DynamicStateEventImpl;
import de.vw.mib.event.internal.EventFactory$1;
import de.vw.mib.event.internal.EventFactory$10;
import de.vw.mib.event.internal.EventFactory$11;
import de.vw.mib.event.internal.EventFactory$12;
import de.vw.mib.event.internal.EventFactory$13;
import de.vw.mib.event.internal.EventFactory$14;
import de.vw.mib.event.internal.EventFactory$15;
import de.vw.mib.event.internal.EventFactory$16;
import de.vw.mib.event.internal.EventFactory$17;
import de.vw.mib.event.internal.EventFactory$18;
import de.vw.mib.event.internal.EventFactory$19;
import de.vw.mib.event.internal.EventFactory$2;
import de.vw.mib.event.internal.EventFactory$20;
import de.vw.mib.event.internal.EventFactory$21;
import de.vw.mib.event.internal.EventFactory$22;
import de.vw.mib.event.internal.EventFactory$23;
import de.vw.mib.event.internal.EventFactory$24;
import de.vw.mib.event.internal.EventFactory$25;
import de.vw.mib.event.internal.EventFactory$26;
import de.vw.mib.event.internal.EventFactory$27;
import de.vw.mib.event.internal.EventFactory$28;
import de.vw.mib.event.internal.EventFactory$3;
import de.vw.mib.event.internal.EventFactory$4;
import de.vw.mib.event.internal.EventFactory$5;
import de.vw.mib.event.internal.EventFactory$6;
import de.vw.mib.event.internal.EventFactory$7;
import de.vw.mib.event.internal.EventFactory$8;
import de.vw.mib.event.internal.EventFactory$9;
import de.vw.mib.event.internal.EventPool;
import de.vw.mib.event.internal.HMIEventImpl;
import de.vw.mib.event.internal.IntegerValueEventImpl;
import de.vw.mib.event.internal.InvocationEventImpl;
import de.vw.mib.event.internal.LSChangeEventImpl;
import de.vw.mib.event.internal.ListItemControlUpdateEventImpl;
import de.vw.mib.event.internal.ListItemEventImpl;
import de.vw.mib.event.internal.ListReadoutEventImpl;
import de.vw.mib.event.internal.PointEventImpl;
import de.vw.mib.event.internal.PopupStackChangeEventImpl;
import de.vw.mib.event.internal.PopupViewEventImpl;
import de.vw.mib.event.internal.PowerStateEventImpl;
import de.vw.mib.event.internal.ProximityEventImpl;
import de.vw.mib.event.internal.ReadoutListSelectionEventImpl;
import de.vw.mib.event.internal.RepaintEventImpl;
import de.vw.mib.event.internal.RestoreFactorySettingsEventImpl;
import de.vw.mib.event.internal.RotationEventImpl;
import de.vw.mib.event.internal.SpeechCommandEventImpl;
import de.vw.mib.event.internal.SpeechEventImpl;
import de.vw.mib.event.internal.SpeechStateEventImpl;
import de.vw.mib.event.internal.SpellerValueEventImpl;
import de.vw.mib.event.internal.StartupEventImpl;
import de.vw.mib.event.internal.StringValueEventImpl;
import de.vw.mib.event.internal.SystemEventImpl;
import de.vw.mib.event.internal.TouchEventImpl;
import de.vw.mib.event.internal.ViewAnimationEventImpl;
import de.vw.mib.event.internal.ViewChangeEventImpl;
import de.vw.mib.list.update.ListItemControlUpdater;

public final class EventFactory {
    private final EventPool animationEventPool = new EventFactory$1(this, 10);
    private final EventPool booleanValueEventPool;
    private final EventPool contextChangeEventPool;
    private final EventPool datapoolUpdateEventPool;
    private final EventPool dynamicStateEventPool;
    private final EventPool hmiEventPool;
    private final EventPool integerValueEventPool;
    private final EventPool invocationEventPool;
    private final EventPool listItemControlUpdateEventPool;
    private final EventPool listItemEventPool;
    private final EventPool listReadoutEventPool;
    private final EventPool pointEventPool;
    private final EventPool popupStackChangeEventPool;
    private final EventPool popupViewEventPool;
    private final EventPool readoutListSelectionEventPool;
    private final EventPool repaintEventPool;
    private final EventPool restoreFactorySettingsEventPool;
    private final EventPool rotationEventPool;
    private final EventPool speechCommandEventPool;
    private final EventPool speechEventPool;
    private final EventPool speechStateEventPool;
    private final EventPool spellerValueEventPool;
    private final EventPool stringValueEventPool;
    private final EventPool systemEventPool;
    private final EventPool touchEventPool;
    private final EventPool viewAnimationEventPool;
    private final EventPool viewChangeEventPool;
    private final EventPool proximityEventPool;

    public EventFactory(ConfigurationManager configurationManager) {
        this.booleanValueEventPool = new EventFactory$2(this, configurationManager.getEventPoolSize(8));
        this.contextChangeEventPool = new EventFactory$3(this, configurationManager.getEventPoolSize(18));
        this.datapoolUpdateEventPool = new EventFactory$4(this, configurationManager.getEventPoolSize(0));
        this.dynamicStateEventPool = new EventFactory$5(this, configurationManager.getEventPoolSize(22));
        this.hmiEventPool = new EventFactory$6(this, configurationManager.getEventPoolSize(17));
        this.integerValueEventPool = new EventFactory$7(this, configurationManager.getEventPoolSize(14));
        this.invocationEventPool = new EventFactory$8(this, configurationManager.getEventPoolSize(5));
        this.listItemControlUpdateEventPool = new EventFactory$9(this, configurationManager.getEventPoolSize(2));
        this.listItemEventPool = new EventFactory$10(this, configurationManager.getEventPoolSize(2));
        this.listReadoutEventPool = new EventFactory$11(this, configurationManager.getEventPoolSize(7));
        this.pointEventPool = new EventFactory$12(this, configurationManager.getEventPoolSize(13));
        this.popupStackChangeEventPool = new EventFactory$13(this, configurationManager.getEventPoolSize(16));
        this.popupViewEventPool = new EventFactory$14(this, configurationManager.getEventPoolSize(12));
        this.readoutListSelectionEventPool = new EventFactory$15(this, configurationManager.getEventPoolSize(9));
        this.repaintEventPool = new EventFactory$16(this, configurationManager.getEventPoolSize(25));
        this.restoreFactorySettingsEventPool = new EventFactory$17(this, 10);
        this.rotationEventPool = new EventFactory$18(this, configurationManager.getEventPoolSize(24));
        this.speechCommandEventPool = new EventFactory$19(this, configurationManager.getEventPoolSize(10));
        this.speechEventPool = new EventFactory$20(this, configurationManager.getEventPoolSize(25));
        this.speechStateEventPool = new EventFactory$21(this, 10);
        this.spellerValueEventPool = new EventFactory$22(this, configurationManager.getEventPoolSize(23));
        this.stringValueEventPool = new EventFactory$23(this, configurationManager.getEventPoolSize(14));
        this.systemEventPool = new EventFactory$24(this, configurationManager.getEventPoolSize(1));
        this.touchEventPool = new EventFactory$25(this, configurationManager.getEventPoolSize(4));
        this.viewAnimationEventPool = new EventFactory$26(this, configurationManager.getEventPoolSize(3));
        this.viewChangeEventPool = new EventFactory$27(this, configurationManager.getEventPoolSize(3));
        this.proximityEventPool = new EventFactory$28(this, configurationManager.getEventPoolSize(25));
    }

    public AnimationEventImpl createAnimationEvent(int n) {
        AnimationEventImpl animationEventImpl = (AnimationEventImpl)this.animationEventPool.borrowObject();
        animationEventImpl.setContent(n);
        return animationEventImpl;
    }

    public BooleanValueEventImpl createBooleanValueEvent(AppDefinition appDefinition, AppDefinition appDefinition2, int n, boolean bl) {
        BooleanValueEventImpl booleanValueEventImpl = (BooleanValueEventImpl)this.booleanValueEventPool.borrowObject();
        booleanValueEventImpl.setSender(appDefinition);
        booleanValueEventImpl.setReceiver(appDefinition2);
        booleanValueEventImpl.setContent(n, bl, 4);
        return booleanValueEventImpl;
    }

    public ContextChangeEventImpl createContextChangeEvent(String string) {
        ContextChangeEventImpl contextChangeEventImpl = (ContextChangeEventImpl)this.contextChangeEventPool.borrowObject();
        contextChangeEventImpl.setContent(string);
        return contextChangeEventImpl;
    }

    public DatapoolUpdateEventImpl createDatapoolUpdateEvent(int n, boolean bl) {
        DatapoolUpdateEventImpl datapoolUpdateEventImpl = (DatapoolUpdateEventImpl)this.datapoolUpdateEventPool.borrowObject();
        datapoolUpdateEventImpl.setContent(n, bl);
        return datapoolUpdateEventImpl;
    }

    public DatapoolUpdateEventImpl createDatapoolUpdateEvent(int n, float f2) {
        DatapoolUpdateEventImpl datapoolUpdateEventImpl = (DatapoolUpdateEventImpl)this.datapoolUpdateEventPool.borrowObject();
        datapoolUpdateEventImpl.setContent(n, f2);
        return datapoolUpdateEventImpl;
    }

    public DatapoolUpdateEventImpl createDatapoolUpdateEvent(int n, int n2) {
        DatapoolUpdateEventImpl datapoolUpdateEventImpl = (DatapoolUpdateEventImpl)this.datapoolUpdateEventPool.borrowObject();
        datapoolUpdateEventImpl.setContent(n, n2);
        return datapoolUpdateEventImpl;
    }

    public DatapoolUpdateEventImpl createDatapoolUpdateEvent(int n, long l) {
        DatapoolUpdateEventImpl datapoolUpdateEventImpl = (DatapoolUpdateEventImpl)this.datapoolUpdateEventPool.borrowObject();
        datapoolUpdateEventImpl.setContent(n, l);
        return datapoolUpdateEventImpl;
    }

    public DatapoolUpdateEventImpl createDatapoolUpdateEvent(int n, Object object) {
        DatapoolUpdateEventImpl datapoolUpdateEventImpl = (DatapoolUpdateEventImpl)this.datapoolUpdateEventPool.borrowObject();
        datapoolUpdateEventImpl.setContent(n, object);
        return datapoolUpdateEventImpl;
    }

    public DisplayEventImpl createDisplayEvent(int n) {
        return new DisplayEventImpl(n);
    }

    public DynamicStateEventImpl createDynamicStateEvent(int n, int n2, int n3) {
        DynamicStateEventImpl dynamicStateEventImpl = (DynamicStateEventImpl)this.dynamicStateEventPool.borrowObject();
        dynamicStateEventImpl.setContent(n, n2, n3);
        return dynamicStateEventImpl;
    }

    public SystemEventImpl createHardkeyEvent(int n, int n2) {
        SystemEventImpl systemEventImpl = (SystemEventImpl)this.systemEventPool.borrowObject();
        systemEventImpl.setContent(2, n, n2);
        return systemEventImpl;
    }

    public HMIEventImpl createHMIEvent(AppDefinition appDefinition, AppDefinition appDefinition2, int n) {
        HMIEventImpl hMIEventImpl = (HMIEventImpl)this.hmiEventPool.borrowObject();
        hMIEventImpl.setSender(appDefinition);
        hMIEventImpl.setReceiver(appDefinition2);
        hMIEventImpl.setContent(n, 1);
        return hMIEventImpl;
    }

    public IntegerValueEventImpl createIntegerValueEvent(AppDefinition appDefinition, AppDefinition appDefinition2, int n, int n2) {
        IntegerValueEventImpl integerValueEventImpl = (IntegerValueEventImpl)this.integerValueEventPool.borrowObject();
        integerValueEventImpl.setSender(appDefinition);
        integerValueEventImpl.setReceiver(appDefinition2);
        integerValueEventImpl.setContent(n, n2);
        return integerValueEventImpl;
    }

    public InvocationEventImpl createInvocationEvent(Runnable runnable) {
        InvocationEventImpl invocationEventImpl = (InvocationEventImpl)this.invocationEventPool.borrowObject();
        invocationEventImpl.setContent(runnable);
        return invocationEventImpl;
    }

    public ListItemControlUpdateEventImpl createListItemControlUpdateEvent(ListItemControlUpdater listItemControlUpdater, int n, int n2, int n3, int n4) {
        ListItemControlUpdateEventImpl listItemControlUpdateEventImpl = (ListItemControlUpdateEventImpl)this.listItemControlUpdateEventPool.borrowObject();
        listItemControlUpdateEventImpl.setContent(listItemControlUpdater, n, n2, n3, n4);
        return listItemControlUpdateEventImpl;
    }

    public ListItemEventImpl createListItemEvent(AppDefinition appDefinition, AppDefinition appDefinition2, int n, int n2, int n3, int n4, int n5, String string, long l) {
        ListItemEventImpl listItemEventImpl = (ListItemEventImpl)this.listItemEventPool.borrowObject();
        listItemEventImpl.setSender(appDefinition);
        listItemEventImpl.setReceiver(appDefinition2);
        listItemEventImpl.setContent(n, n2, n3, n4, n5, string, l);
        return listItemEventImpl;
    }

    public ListReadoutEventImpl createListReadoutEvent(int n, int n2, int n3) {
        ListReadoutEventImpl listReadoutEventImpl = (ListReadoutEventImpl)this.listReadoutEventPool.borrowObject();
        listReadoutEventImpl.setContent(n, n2, n3);
        return listReadoutEventImpl;
    }

    public LSChangeEventImpl createLSChangeEvent(int n) {
        return new LSChangeEventImpl(n);
    }

    public PointEventImpl createPointEvent(AppDefinition appDefinition, AppDefinition appDefinition2, int n, int n2, int n3, int n4, int n5) {
        PointEventImpl pointEventImpl = (PointEventImpl)this.pointEventPool.borrowObject();
        pointEventImpl.setSender(appDefinition);
        pointEventImpl.setReceiver(appDefinition2);
        pointEventImpl.setContent(n, n2, n3, n4, n5);
        return pointEventImpl;
    }

    public PopupStackChangeEventImpl createPopupStackChangeEvent(int n, int n2) {
        PopupStackChangeEventImpl popupStackChangeEventImpl = (PopupStackChangeEventImpl)this.popupStackChangeEventPool.borrowObject();
        popupStackChangeEventImpl.setContent(n, n2);
        return popupStackChangeEventImpl;
    }

    public PopupViewEventImpl createPopupViewEvent(int n, String string, int n2, int n3) {
        PopupViewEventImpl popupViewEventImpl = (PopupViewEventImpl)this.popupViewEventPool.borrowObject();
        popupViewEventImpl.setContent(n, string, n2, n3);
        return popupViewEventImpl;
    }

    public PowerStateEventImpl createPowerStateEvent(int n) {
        return new PowerStateEventImpl(n);
    }

    public BooleanValueEventImpl createProximityEvent(boolean bl, int n) {
        BooleanValueEventImpl booleanValueEventImpl = (BooleanValueEventImpl)this.booleanValueEventPool.borrowObject();
        booleanValueEventImpl.setContent(n, bl, 8);
        return booleanValueEventImpl;
    }

    public ReadoutListSelectionEventImpl createReadoutSelectionEvent(int n, int[] nArray, int n2, int n3) {
        ReadoutListSelectionEventImpl readoutListSelectionEventImpl = (ReadoutListSelectionEventImpl)this.readoutListSelectionEventPool.borrowObject();
        readoutListSelectionEventImpl.setContent(n, nArray, n2, n3);
        return readoutListSelectionEventImpl;
    }

    public RepaintEventImpl createRepaintEvent() {
        return (RepaintEventImpl)this.repaintEventPool.borrowObject();
    }

    public RestoreFactorySettingsEventImpl createRestoreFactorySettingsEvent() {
        return (RestoreFactorySettingsEventImpl)this.restoreFactorySettingsEventPool.borrowObject();
    }

    public RotationEventImpl createRotationEvent(AppDefinition appDefinition, AppDefinition appDefinition2, int n, int n2, int n3) {
        RotationEventImpl rotationEventImpl = (RotationEventImpl)this.rotationEventPool.borrowObject();
        rotationEventImpl.setSender(appDefinition);
        rotationEventImpl.setReceiver(appDefinition2);
        rotationEventImpl.setContent(n, n2, n3);
        return rotationEventImpl;
    }

    public SpeechCommandEventImpl createSpeechCommandEvent(int n) {
        SpeechCommandEventImpl speechCommandEventImpl = (SpeechCommandEventImpl)this.speechCommandEventPool.borrowObject();
        speechCommandEventImpl.setContent(n);
        return speechCommandEventImpl;
    }

    public SpeechEventImpl createSpeechEvent(int n, long l, int n2, String string, int n3) {
        SpeechEventImpl speechEventImpl = (SpeechEventImpl)this.speechEventPool.borrowObject();
        speechEventImpl.setContent(n, l, n2, string, n3);
        return speechEventImpl;
    }

    public SpeechStateEventImpl createSpeechStateEvent(int n) {
        SpeechStateEventImpl speechStateEventImpl = (SpeechStateEventImpl)this.speechStateEventPool.borrowObject();
        speechStateEventImpl.setContent(n);
        return speechStateEventImpl;
    }

    public SpellerValueEventImpl createSpellerValueEvent(AppDefinition appDefinition, AppDefinition appDefinition2, int n, String string, int n2, int n3, int n4) {
        SpellerValueEventImpl spellerValueEventImpl = (SpellerValueEventImpl)this.spellerValueEventPool.borrowObject();
        spellerValueEventImpl.setSender(appDefinition);
        spellerValueEventImpl.setReceiver(appDefinition2);
        spellerValueEventImpl.setContent(n, string, n2, n3, n4);
        return spellerValueEventImpl;
    }

    public StartupEventImpl createStartupEvent(int n) {
        return new StartupEventImpl(n);
    }

    public StringValueEventImpl createStringValueEvent(AppDefinition appDefinition, AppDefinition appDefinition2, int n, String string) {
        StringValueEventImpl stringValueEventImpl = (StringValueEventImpl)this.stringValueEventPool.borrowObject();
        stringValueEventImpl.setSender(appDefinition);
        stringValueEventImpl.setReceiver(appDefinition2);
        stringValueEventImpl.setContent(n, string);
        return stringValueEventImpl;
    }

    public SystemEventImpl createSystemEvent(AppDefinition appDefinition, AppDefinition appDefinition2, int n, int n2) {
        SystemEventImpl systemEventImpl = (SystemEventImpl)this.systemEventPool.borrowObject();
        systemEventImpl.setSender(appDefinition);
        systemEventImpl.setReceiver(appDefinition2);
        systemEventImpl.setContent(1, n, n2);
        return systemEventImpl;
    }

    public TouchEventImpl createTouchEvent(int n, int n2, int n3, int n4, int n5, int n6, int n7) {
        TouchEventImpl touchEventImpl = (TouchEventImpl)this.touchEventPool.borrowObject();
        touchEventImpl.setContent(n, n2, n3, n4, n5, n6, n7);
        return touchEventImpl;
    }

    public ViewAnimationEventImpl createViewAnimationEvent(ViewAnimationEventConsumer viewAnimationEventConsumer, int n) {
        if (viewAnimationEventConsumer == null) {
            throw new IllegalArgumentException("The ViewAnimationEventConsumer must not be null!");
        }
        ViewAnimationEventImpl viewAnimationEventImpl = (ViewAnimationEventImpl)this.viewAnimationEventPool.borrowObject();
        viewAnimationEventImpl.setContent(viewAnimationEventConsumer, n);
        return viewAnimationEventImpl;
    }

    public ViewChangeEventImpl createViewChangeEvent(int n, String string, boolean bl, int n2) {
        return this.createViewChangeEvent(n, string, bl, n2, -1);
    }

    public ViewChangeEventImpl createViewChangeEvent(int n, String string, boolean bl, int n2, int n3) {
        ViewChangeEventImpl viewChangeEventImpl = (ViewChangeEventImpl)this.viewChangeEventPool.borrowObject();
        viewChangeEventImpl.setContent(n, string, bl, n2, n3);
        return viewChangeEventImpl;
    }

    public ProximityEventImpl createProximityEvent(int n, int n2, int n3, float f2, float f3, float f4, float f5, float f6, int n4) {
        ProximityEventImpl proximityEventImpl = (ProximityEventImpl)this.proximityEventPool.borrowObject();
        proximityEventImpl.setContent(n, n2, n3, f2, f3, f4, f5, f6, n4);
        return proximityEventImpl;
    }

    EventPool getAnimationEventPool() {
        return this.animationEventPool;
    }

    EventPool getBooleanValueEventPool() {
        return this.booleanValueEventPool;
    }

    EventPool getContextChangeEventPool() {
        return this.contextChangeEventPool;
    }

    EventPool getDatapoolUpdateEventPool() {
        return this.datapoolUpdateEventPool;
    }

    EventPool getDynamicStateEventPool() {
        return this.dynamicStateEventPool;
    }

    EventPool getHMIEventPool() {
        return this.hmiEventPool;
    }

    EventPool getIntegerValueEventPool() {
        return this.integerValueEventPool;
    }

    EventPool getInvocationEventPool() {
        return this.invocationEventPool;
    }

    EventPool getListItemControlUpdateEventPool() {
        return this.listItemControlUpdateEventPool;
    }

    EventPool getListItemEventPool() {
        return this.listItemEventPool;
    }

    EventPool getListReadoutEventPool() {
        return this.listReadoutEventPool;
    }

    EventPool getPointEventPool() {
        return this.pointEventPool;
    }

    EventPool getPopupStackChangeEventPool() {
        return this.popupStackChangeEventPool;
    }

    EventPool getPopupViewEventPool() {
        return this.popupViewEventPool;
    }

    EventPool getReadoutListSelectionEventPool() {
        return this.readoutListSelectionEventPool;
    }

    EventPool getRestoreFactorySettingsEventPool() {
        return this.restoreFactorySettingsEventPool;
    }

    EventPool getRotationEventPool() {
        return this.rotationEventPool;
    }

    EventPool getSpeechCommandEventPool() {
        return this.speechCommandEventPool;
    }

    EventPool getSpeechEventPool() {
        return this.speechEventPool;
    }

    EventPool getSpeechStateEventPool() {
        return this.speechEventPool;
    }

    EventPool getSpellerValueEventPool() {
        return this.spellerValueEventPool;
    }

    EventPool getStringValueEventPool() {
        return this.stringValueEventPool;
    }

    EventPool getSystemEventPool() {
        return this.systemEventPool;
    }

    EventPool getTouchEventPool() {
        return this.touchEventPool;
    }

    EventPool getViewAnimationEventPool() {
        return this.viewAnimationEventPool;
    }

    EventPool getViewChangeEventPool() {
        return this.viewChangeEventPool;
    }

    EventPool getProximityEventPool() {
        return this.proximityEventPool;
    }
}

