package adoption.entities;

public class DNI {

    private String series;

    private int num;

    public DNI(String series, int num) {
        this.series = series;
        this.num = num;
    }

    public DNI() {
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return series + num;
    }
    

}
