package model;

import java.time.LocalDateTime;
import java.util.Objects;

public class TimeTable extends Entity<Long> {
    private LocalDateTime dateTime;
    private Client client;
    private Procedure procedure;

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Procedure getProcedure() {
        return procedure;
    }

    public void setProcedure(Procedure procedure) {
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
