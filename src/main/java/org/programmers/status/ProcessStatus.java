package org.programmers.status;

public enum ProcessStatus {
    ONGOING,
    FINISH;

    public boolean isOngoing() {
        return this.equals(ONGOING);
    }

    public boolean isFinish() {
        return this.equals(FINISH);
    }

}
