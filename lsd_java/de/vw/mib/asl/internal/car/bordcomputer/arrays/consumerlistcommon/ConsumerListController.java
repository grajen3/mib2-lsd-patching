/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.bordcomputer.arrays.consumerlistcommon;

import de.vw.mib.asl.api.car.logger.CarLogger;
import de.vw.mib.asl.internal.car.bordcomputer.arrays.consumerlistcommon.ConsumerListContext;
import de.vw.mib.asl.internal.car.bordcomputer.arrays.consumerlistcommon.ConsumerListElementAdapter;
import de.vw.mib.asl.internal.car.framework.arrays.BapArrayFactory;
import de.vw.mib.bap.array.asg.ASGArrayList;
import de.vw.mib.bap.array.asg.ASGArrayListDelegate;
import de.vw.mib.bap.array.asg.ASGArrayListFactory;
import de.vw.mib.bap.array.logger.Logger;
import de.vw.mib.bap.array.requests.BAPGetArray;
import de.vw.mib.bap.array.requests.BAPSetGetArray;
import de.vw.mib.bap.array.timer.Timer;
import de.vw.mib.bap.array.timer.TimerNotifier;
import de.vw.mib.bap.datatypes.BAPArrayElement;

public abstract class ConsumerListController
implements ASGArrayListFactory,
ASGArrayListDelegate,
Logger {
    private ConsumerListContext _context;
    private boolean _listAvailable;

    public ConsumerListController(ConsumerListContext consumerListContext) {
        this._context = consumerListContext;
    }

    protected abstract ASGArrayList getConsumerArrayList() {
    }

    public void setListAvailable(boolean bl) {
        if (this._listAvailable != bl) {
            this._listAvailable = bl;
            if (!bl) {
                this.getConsumerArrayList().stopFetchingData();
            }
        }
    }

    public boolean isListAvailable() {
        return this._listAvailable;
    }

    protected ConsumerListContext getContext() {
        return this._context;
    }

    protected CarLogger getContextLoger() {
        return this.getContext().getCarLogger();
    }

    @Override
    public BAPGetArray createGetArrayRequest(ASGArrayList aSGArrayList) {
        return BapArrayFactory.getInstance().createBapGetArray();
    }

    @Override
    public BAPSetGetArray createSetGetArrayRequest(ASGArrayList aSGArrayList) {
        return null;
    }

    @Override
    public BAPArrayElement createEmptyElement(ASGArrayList aSGArrayList) {
        return new ConsumerListElementAdapter();
    }

    @Override
    public Timer createTimer(ASGArrayList aSGArrayList, TimerNotifier timerNotifier, long l) {
        return BapArrayFactory.getInstance().createBapArrayTimer(timerNotifier, l);
    }

    @Override
    public void requestTimeout(ASGArrayList aSGArrayList, int n, boolean bl) {
        this.getContextLoger().error("ConsumerList: Request time out for consumer list");
    }

    @Override
    public boolean continueLoading(ASGArrayList aSGArrayList) {
        return true;
    }

    @Override
    public Logger getLogger(ASGArrayList aSGArrayList) {
        return this;
    }

    @Override
    public void log(ASGArrayList aSGArrayList, int n, String string) {
        String string2 = new StringBuffer().append("ConsumerList: ").append(string).toString();
        switch (n) {
            case 1: {
                this.getContextLoger().fatal(string2);
                break;
            }
            case 2: {
                this.getContextLoger().error(string2);
                break;
            }
            case 4: {
                this.getContextLoger().warn(string2);
                break;
            }
            case 8: {
                this.getContextLoger().info(string2);
                break;
            }
            case 12: {
                this.getContextLoger().normal(string2);
                break;
            }
            case 16: {
                if (!this.getContextLoger().isTraceEnabled()) break;
                this.getContextLoger().trace(string2);
                break;
            }
            default: {
                this.getContextLoger().error("ConsumerList: Unknown log message called");
            }
        }
    }
}

