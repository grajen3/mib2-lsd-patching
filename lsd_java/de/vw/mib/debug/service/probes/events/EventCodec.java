/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.service.probes.events;

import de.vw.mib.app.framework.AppDefinition;
import de.vw.mib.debugmanager.internal.AbstractProbeCodec;
import de.vw.mib.debugmanager.probes.ProbeSystemServices;
import de.vw.mib.event.AnimationEvent;
import de.vw.mib.event.BooleanValueEvent;
import de.vw.mib.event.ContextChangeEvent;
import de.vw.mib.event.DatapoolUpdateEvent;
import de.vw.mib.event.DisplayEvent;
import de.vw.mib.event.DynamicStateEvent;
import de.vw.mib.event.HMIEvent;
import de.vw.mib.event.IntegerValueEvent;
import de.vw.mib.event.InvocationEvent;
import de.vw.mib.event.LSChangeEvent;
import de.vw.mib.event.ListItemControlUpdateEvent;
import de.vw.mib.event.ListItemEvent;
import de.vw.mib.event.PointEvent;
import de.vw.mib.event.PopupStackChangeEvent;
import de.vw.mib.event.PopupViewEvent;
import de.vw.mib.event.PowerStateEvent;
import de.vw.mib.event.ProximityEvent;
import de.vw.mib.event.RepaintEvent;
import de.vw.mib.event.RestoreFactorySettingsEvent;
import de.vw.mib.event.RotationEvent;
import de.vw.mib.event.SpellerValueEvent;
import de.vw.mib.event.StartupEvent;
import de.vw.mib.event.StringValueEvent;
import de.vw.mib.event.SystemEvent;
import de.vw.mib.event.TouchEvent;
import de.vw.mib.event.ViewAnimationEvent;
import de.vw.mib.event.ViewChangeEvent;
import de.vw.mib.event.internal.AbstractEvent;
import de.vw.mib.log4mib.BinaryMessage;
import edu.emory.mathcs.backport.java.util.Arrays;

public final class EventCodec
extends AbstractProbeCodec {
    public EventCodec(ProbeSystemServices probeSystemServices) {
        super(probeSystemServices);
    }

    public void encode(byte by, byte by2, AnimationEvent animationEvent) {
        BinaryMessage binaryMessage = this.createMessage((byte)34, (AbstractEvent)((Object)animationEvent), by, by2);
        binaryMessage.append(animationEvent.getAnimationId());
        binaryMessage.send();
    }

    public void encode(byte by, byte by2, BooleanValueEvent booleanValueEvent) {
        int n = booleanValueEvent.getType();
        BinaryMessage binaryMessage = n == 8 ? this.createMessage((byte)18, (AbstractEvent)((Object)booleanValueEvent), by, by2) : this.createMessage((byte)2, (AbstractEvent)((Object)booleanValueEvent), by, by2);
        this.appendAppDefinition(binaryMessage, booleanValueEvent.getSender());
        this.appendAppDefinition(binaryMessage, booleanValueEvent.getReceiver());
        binaryMessage.append(booleanValueEvent.getId());
        binaryMessage.append(booleanValueEvent.getValue());
        binaryMessage.send();
    }

    public void encode(byte by, byte by2, ContextChangeEvent contextChangeEvent) {
        BinaryMessage binaryMessage = this.createMessage((byte)3, (AbstractEvent)((Object)contextChangeEvent), by, by2);
        binaryMessage.append(contextChangeEvent.getContext());
        binaryMessage.send();
    }

    public void encode(byte by, byte by2, DatapoolUpdateEvent datapoolUpdateEvent) {
        BinaryMessage binaryMessage = this.createMessage((byte)33, (AbstractEvent)((Object)datapoolUpdateEvent), by, by2);
        binaryMessage.append(datapoolUpdateEvent.getPropertyId());
        String string = null;
        switch (datapoolUpdateEvent.getType()) {
            case 0: {
                string = Integer.toString(datapoolUpdateEvent.getIntegerValue());
                break;
            }
            case 1: {
                string = Boolean.toString(datapoolUpdateEvent.getBooleanValue());
                break;
            }
            case 2: {
                Object object = datapoolUpdateEvent.getObjectValue();
                if (object == null) {
                    string = "null";
                    break;
                }
                if (object.getClass().isArray()) {
                    if (object instanceof boolean[]) {
                        string = Arrays.toString((boolean[])object);
                        break;
                    }
                    if (object instanceof int[]) {
                        string = Arrays.toString((int[])object);
                        break;
                    }
                    if (object instanceof long[]) {
                        string = Arrays.toString((long[])object);
                        break;
                    }
                    if (object instanceof float[]) {
                        string = Arrays.toString((float[])object);
                        break;
                    }
                    string = Arrays.toString((Object[])object);
                    break;
                }
                string = object.toString();
                break;
            }
            case 3: {
                string = Long.toString(datapoolUpdateEvent.getLongValue());
                break;
            }
            case 4: {
                string = Float.toString(datapoolUpdateEvent.getFloatValue());
                break;
            }
            default: {
                string = "unknown value type";
            }
        }
        binaryMessage.append(string);
        binaryMessage.send();
    }

    public void encode(byte by, byte by2, DisplayEvent displayEvent) {
        BinaryMessage binaryMessage = this.createMessage((byte)38, (AbstractEvent)((Object)displayEvent), by, by2);
        binaryMessage.append(displayEvent.getState());
        binaryMessage.send();
    }

    public void encode(byte by, byte by2, DynamicStateEvent dynamicStateEvent) {
        BinaryMessage binaryMessage = this.createMessage((byte)4, (AbstractEvent)((Object)dynamicStateEvent), by, by2);
        binaryMessage.append(dynamicStateEvent.getCommand());
        binaryMessage.append(dynamicStateEvent.getDynamicStateId());
        binaryMessage.append(dynamicStateEvent.getPopupInfoId());
        binaryMessage.send();
    }

    public void encode(byte by, byte by2, HMIEvent hMIEvent) {
        BinaryMessage binaryMessage = this.createMessage((byte)6, (AbstractEvent)((Object)hMIEvent), by, by2);
        this.appendAppDefinition(binaryMessage, hMIEvent.getSender());
        this.appendAppDefinition(binaryMessage, hMIEvent.getReceiver());
        binaryMessage.append(hMIEvent.getId());
        binaryMessage.send();
    }

    public void encode(byte by, byte by2, IntegerValueEvent integerValueEvent) {
        BinaryMessage binaryMessage = this.createMessage((byte)7, (AbstractEvent)((Object)integerValueEvent), by, by2);
        this.appendAppDefinition(binaryMessage, integerValueEvent.getSender());
        this.appendAppDefinition(binaryMessage, integerValueEvent.getReceiver());
        binaryMessage.append(integerValueEvent.getId());
        binaryMessage.append(integerValueEvent.getValue());
        binaryMessage.send();
    }

    public void encode(byte by, byte by2, InvocationEvent invocationEvent) {
        BinaryMessage binaryMessage = this.createMessage((byte)8, (AbstractEvent)((Object)invocationEvent), by, by2);
        binaryMessage.append(invocationEvent.getRunnableName());
        binaryMessage.send();
    }

    public void encode(byte by, byte by2, ListItemControlUpdateEvent listItemControlUpdateEvent) {
        BinaryMessage binaryMessage = this.createMessage((byte)10, (AbstractEvent)((Object)listItemControlUpdateEvent), by, by2);
        binaryMessage.append(listItemControlUpdateEvent.getListItemControlUpdater().toString());
        binaryMessage.append(listItemControlUpdateEvent.getParameter_1());
        binaryMessage.append(listItemControlUpdateEvent.getParameter_2());
        binaryMessage.append(listItemControlUpdateEvent.getParameter_3());
        binaryMessage.append(listItemControlUpdateEvent.getType());
        binaryMessage.send();
    }

    public void encode(byte by, byte by2, ListItemEvent listItemEvent) {
        BinaryMessage binaryMessage = this.createMessage((byte)9, (AbstractEvent)((Object)listItemEvent), by, by2);
        this.appendAppDefinition(binaryMessage, listItemEvent.getSender());
        this.appendAppDefinition(binaryMessage, listItemEvent.getReceiver());
        binaryMessage.append(listItemEvent.getAbsoluteIndex());
        binaryMessage.append(listItemEvent.getActionIndex());
        binaryMessage.append(listItemEvent.getDestinationIndex());
        binaryMessage.append(listItemEvent.getDropDownIndex());
        binaryMessage.append(listItemEvent.getEventSender());
        binaryMessage.append(listItemEvent.getId());
        binaryMessage.append(listItemEvent.getObjectId());
        binaryMessage.send();
    }

    public void encode(byte by, byte by2, LSChangeEvent lSChangeEvent) {
        BinaryMessage binaryMessage = this.createMessage((byte)12, (AbstractEvent)((Object)lSChangeEvent), by, by2);
        binaryMessage.append(lSChangeEvent.getCommand());
        binaryMessage.send();
    }

    public void encode(byte by, byte by2, PointEvent pointEvent) {
        BinaryMessage binaryMessage = this.createMessage((byte)13, (AbstractEvent)((Object)pointEvent), by, by2);
        this.appendAppDefinition(binaryMessage, pointEvent.getSender());
        this.appendAppDefinition(binaryMessage, pointEvent.getReceiver());
        binaryMessage.append(pointEvent.getGestureParam1());
        binaryMessage.append(pointEvent.getGestureParam2());
        binaryMessage.append(pointEvent.getId());
        binaryMessage.append(pointEvent.getX());
        binaryMessage.append(pointEvent.getY());
        binaryMessage.send();
    }

    public void encode(byte by, byte by2, PopupStackChangeEvent popupStackChangeEvent) {
        BinaryMessage binaryMessage = this.createMessage((byte)14, (AbstractEvent)((Object)popupStackChangeEvent), by, by2);
        binaryMessage.append(popupStackChangeEvent.getNumberOfPopups());
        binaryMessage.append(popupStackChangeEvent.getNumberOfUserPerceivedOffPopups());
        binaryMessage.send();
    }

    public void encode(byte by, byte by2, PopupViewEvent popupViewEvent) {
        BinaryMessage binaryMessage = this.createMessage((byte)15, (AbstractEvent)((Object)popupViewEvent), by, by2);
        binaryMessage.append(popupViewEvent.getCommand());
        binaryMessage.append(popupViewEvent.getDynamicStateId());
        binaryMessage.append(popupViewEvent.getPopupViewId());
        binaryMessage.append(popupViewEvent.getPopupInfoId());
        binaryMessage.send();
    }

    public void encode(byte by, byte by2, PowerStateEvent powerStateEvent) {
        BinaryMessage binaryMessage = this.createMessage((byte)16, (AbstractEvent)((Object)powerStateEvent), by, by2);
        binaryMessage.append(powerStateEvent.getState());
        binaryMessage.send();
    }

    public void encode(byte by, byte by2, RepaintEvent repaintEvent) {
        BinaryMessage binaryMessage = this.createMessage((byte)20, (AbstractEvent)((Object)repaintEvent), by, by2);
        binaryMessage.send();
    }

    public void encode(byte by, byte by2, RestoreFactorySettingsEvent restoreFactorySettingsEvent) {
        BinaryMessage binaryMessage = this.createMessage((byte)39, (AbstractEvent)((Object)restoreFactorySettingsEvent), by, by2);
        binaryMessage.send();
    }

    public void encode(byte by, byte by2, RotationEvent rotationEvent) {
        BinaryMessage binaryMessage = this.createMessage((byte)21, (AbstractEvent)((Object)rotationEvent), by, by2);
        this.appendAppDefinition(binaryMessage, rotationEvent.getSender());
        this.appendAppDefinition(binaryMessage, rotationEvent.getReceiver());
        binaryMessage.append(rotationEvent.getId());
        binaryMessage.append(rotationEvent.getTicks());
        binaryMessage.append(rotationEvent.getTimestamp());
        binaryMessage.send();
    }

    public void encode(byte by, byte by2, SpellerValueEvent spellerValueEvent) {
        BinaryMessage binaryMessage = this.createMessage((byte)26, (AbstractEvent)((Object)spellerValueEvent), by, by2);
        this.appendAppDefinition(binaryMessage, spellerValueEvent.getSender());
        this.appendAppDefinition(binaryMessage, spellerValueEvent.getReceiver());
        binaryMessage.append(spellerValueEvent.getCursorPosition());
        binaryMessage.append(spellerValueEvent.getId());
        binaryMessage.append(spellerValueEvent.getPressedChar());
        binaryMessage.append(spellerValueEvent.getSelectionEnd());
        binaryMessage.append(spellerValueEvent.getSelectionStart());
        binaryMessage.send();
    }

    public void encode(byte by, byte by2, StartupEvent startupEvent) {
        BinaryMessage binaryMessage = this.createMessage((byte)27, (AbstractEvent)((Object)startupEvent), by, by2);
        binaryMessage.append(startupEvent.getEventId());
        binaryMessage.send();
    }

    public void encode(byte by, byte by2, StringValueEvent stringValueEvent) {
        BinaryMessage binaryMessage = this.createMessage((byte)37, (AbstractEvent)((Object)stringValueEvent), by, by2);
        this.appendAppDefinition(binaryMessage, stringValueEvent.getSender());
        this.appendAppDefinition(binaryMessage, stringValueEvent.getReceiver());
        binaryMessage.append(stringValueEvent.getId());
        binaryMessage.append(stringValueEvent.getValue());
        binaryMessage.send();
    }

    public void encode(byte by, byte by2, SystemEvent systemEvent) {
        BinaryMessage binaryMessage;
        switch (systemEvent.getType()) {
            case 2: {
                binaryMessage = this.createMessage((byte)5, (AbstractEvent)((Object)systemEvent), by, by2);
                break;
            }
            case 1: {
                binaryMessage = this.createMessage((byte)28, (AbstractEvent)((Object)systemEvent), by, by2);
                break;
            }
            default: {
                binaryMessage = this.createMessage((byte)6, (AbstractEvent)((Object)systemEvent), by, by2);
            }
        }
        this.appendAppDefinition(binaryMessage, systemEvent.getSender());
        this.appendAppDefinition(binaryMessage, systemEvent.getReceiver());
        binaryMessage.append(systemEvent.getId());
        binaryMessage.send();
    }

    public void encode(byte by, byte by2, TouchEvent touchEvent) {
        BinaryMessage binaryMessage = this.createMessage((byte)29, (AbstractEvent)((Object)touchEvent), by, by2);
        binaryMessage.append(touchEvent.getGestureParam1());
        binaryMessage.append(touchEvent.getGestureParam2());
        binaryMessage.append(touchEvent.getType());
        binaryMessage.append(touchEvent.getX());
        binaryMessage.append(touchEvent.getY());
        binaryMessage.append(touchEvent.getZDelta());
        binaryMessage.append(touchEvent.getTimestamp());
        binaryMessage.send();
    }

    public void encode(byte by, byte by2, ViewAnimationEvent viewAnimationEvent) {
        BinaryMessage binaryMessage = this.createMessage((byte)30, (AbstractEvent)((Object)viewAnimationEvent), by, by2);
        binaryMessage.append(viewAnimationEvent.getAnimationType());
        binaryMessage.send();
    }

    public void encode(byte by, byte by2, ViewChangeEvent viewChangeEvent) {
        BinaryMessage binaryMessage = this.createMessage((byte)31, (AbstractEvent)((Object)viewChangeEvent), by, by2);
        binaryMessage.append(viewChangeEvent.getCommand());
        String string = viewChangeEvent.getFollowingView();
        if (string == null) {
            string = "";
        }
        binaryMessage.append(string);
        binaryMessage.append(viewChangeEvent.shouldResetView());
        binaryMessage.append(viewChangeEvent.getSequenceNumber());
        binaryMessage.send();
    }

    public void encode(byte by, byte by2, ProximityEvent proximityEvent) {
        BinaryMessage binaryMessage = this.createMessage((byte)40, (AbstractEvent)((Object)proximityEvent), by, by2);
        binaryMessage.append(proximityEvent.getType());
        binaryMessage.append(proximityEvent.getProximityArea());
        binaryMessage.append(proximityEvent.getObjectId());
        binaryMessage.append(proximityEvent.getX());
        binaryMessage.append(proximityEvent.getY());
        binaryMessage.append(proximityEvent.getWidth());
        binaryMessage.append(proximityEvent.getHeight());
        binaryMessage.append(proximityEvent.getDistance());
        binaryMessage.append(proximityEvent.getTimestamp());
        binaryMessage.send();
    }

    private BinaryMessage createMessage(byte by, AbstractEvent abstractEvent, byte by2, byte by3) {
        BinaryMessage binaryMessage = this.createMessage(by);
        this.appendInvocation(binaryMessage, abstractEvent.getInvocationContext());
        binaryMessage.append(by2);
        binaryMessage.append(by3);
        return binaryMessage;
    }

    private void appendAppDefinition(BinaryMessage binaryMessage, AppDefinition appDefinition) {
        if (appDefinition == null) {
            binaryMessage.append(-1);
        } else {
            binaryMessage.append(appDefinition.getAppInstanceId());
        }
    }

    @Override
    protected byte getCodecVersion() {
        return -10;
    }

    @Override
    protected short getConfigurationMessageType() {
        return 53;
    }

    @Override
    protected short getMessageType() {
        return 263;
    }
}

