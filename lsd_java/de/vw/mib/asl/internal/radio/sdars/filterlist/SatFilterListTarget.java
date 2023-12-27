/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.filterlist;

import de.vw.mib.asl.internal.radio.sdars.database.IAslPool;
import de.vw.mib.asl.internal.radio.sdars.filterlist.SatFilterListModel;
import de.vw.mib.asl.internal.radio.sdars.helper.SatDb;
import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.Target;

final class SatFilterListTarget
extends AbstractTarget {
    private final SatFilterListModel mModel;
    private final IAslPool mPool;

    SatFilterListTarget(Target target, SatFilterListModel satFilterListModel) {
        super(target.getMainObject());
        this.mModel = satFilterListModel;
        this.mPool = this.mModel.getDb().getPool();
        String string = this.getEventDispatcher().getTaskId(target.getTargetId());
        this.getEventDispatcher().registerTarget(this, string);
    }

    @Override
    public int getClassifier() {
        return 1;
    }

    @Override
    public int getSubClassifier() {
        return 512;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        SatDb.logEvent("FilterList", eventGeneric);
        switch (eventGeneric.getReceiverEventId()) {
            case 8: {
                this.addObserver(2030305344);
                this.addObserver(2047082560);
                this.addObserver(1543766080);
                this.addObserver(1526988864);
                this.addObserver(0x66040040);
                this.addObserver(1728315456);
                this.addObserver(0x54040040);
                this.addObserver(0x55040040);
                this.addObserver(1745092672);
                this.addObserver(1761869888);
                this.addObserver(-2147221440);
                break;
            }
            case 9: {
                this.removeObserver(2030305344);
                this.removeObserver(2047082560);
                this.removeObserver(1543766080);
                this.removeObserver(1526988864);
                this.removeObserver(0x66040040);
                this.removeObserver(1728315456);
                this.removeObserver(0x54040040);
                this.removeObserver(0x55040040);
                this.removeObserver(1745092672);
                this.removeObserver(1761869888);
                this.removeObserver(-2147221440);
                break;
            }
            case 1073742969: {
                int n = eventGeneric.getInt(0);
                this.mModel.toggleCategory(n);
                break;
            }
            case 1073742970: {
                int n = eventGeneric.getInt(0);
                this.mModel.toggleChannel(n);
                break;
            }
            case 1073742940: {
                int n = eventGeneric.getInt(0);
                this.mModel.openCategoryByIndex(n);
                break;
            }
            case 1073742939: {
                if (!this.mModel.isListShown()) break;
                short s = (short)eventGeneric.getLong(0);
                this.mModel.openCategoryById(s);
                break;
            }
            case 0x40000466: {
                this.mModel.getDb().getPool().setBoolean(32, true);
                this.mModel.setListShown(true);
                break;
            }
            case 1073742951: {
                this.mModel.setListShown(false);
                this.mModel.getDb().getPool().setBoolean(32, false);
                break;
            }
            case 0x40000454: {
                this.mPool.setBoolean(175, true);
                break;
            }
            case 0x40000455: {
                this.mPool.setBoolean(175, false);
                break;
            }
            case 1073742952: {
                this.mModel.selectAll();
                this.mModel.getDb().getPool().setInt(165, 0);
                break;
            }
            case 1073742953: {
                this.mModel.selectNone();
                this.mModel.getDb().getPool().setInt(165, 1);
                break;
            }
            case 0x40000480: {
                break;
            }
            default: {
                SatDb.logEvent("-FilterList", eventGeneric);
            }
        }
    }
}

