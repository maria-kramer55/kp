package model;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Objects;

public class TimeTable extends Entity<Long> {
    private Date dateTime;
    private long client;
    private long procedure;

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public long getClient() {
        return client;
    }

    public void setClient(long client) {
        this.client = client;
    }

    public long getProcedure() {
        return procedure;
    }

    public void setProcedure(long procedure) {
        this.procedure = procedure;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TimeTable timeTable = (TimeTable) o;
        return Objects.equals(dateTime, timeTable.dateTime) &&
                Objects.equals(client, timeTable.client) &&
                Objects.equals(procedure, timeTable.procedure);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), dateTime, client, procedure);
    }

    @Override
    public String toString() {
        return "TimeTable{" +
                "dateTime=" + dateTime +
                ", client=" + client +
                ", procedure=" + procedure +
                '}';
    }
}
