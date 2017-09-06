/**
 * Created by Evan on 12/5/2016.
 */
public class Class {
    private String title, times, days, building, type, prof;

    public Class(String title, String times,  String prof, String days) {
        this.title = title;
        this.times = times;
        this.days = days;
        this.prof = prof;
    }

    public Class(String title, String times) {
        this.title = title;
        this.times = times;
    }

    public Class(String title, String times, String prof) {
        this.title = title;
        this.times = times;
        this.prof = prof;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProf() {
        return prof;
    }

    public void setProf(String prof) {
        this.prof = prof;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Class)) return false;

        Class aClass = (Class) o;

        if (title != null ? !title.equals(aClass.title) : aClass.title != null) return false;
        if (times != null ? !times.equals(aClass.times) : aClass.times != null) return false;
        if (days != null ? !days.equals(aClass.days) : aClass.days != null) return false;
        if (building != null ? !building.equals(aClass.building) : aClass.building != null) return false;
        if (type != null ? !type.equals(aClass.type) : aClass.type != null) return false;
        return prof != null ? prof.equals(aClass.prof) : aClass.prof == null;

    }


    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (times != null ? times.hashCode() : 0);
        result = 31 * result + (days != null ? days.hashCode() : 0);
        result = 31 * result + (building != null ? building.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (prof != null ? prof.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Class{" +
                "title='" + title + '\'' +
                ", times='" + times + '\'' +
                ", days='" + days + '\'' +
                ", prof='" + prof + '\'' +
                '}';
    }
}
