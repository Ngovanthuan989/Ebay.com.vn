package ebay.com.persistance;

/**
 * Options
 */
public class Options {

    private int tbl_options_id;
    private String tbl_options_name;
    private String tbl_options_date;


    public Options(){

    }
    public Options(int tbl_options_id, String tbl_options_name,String tbl_options_date){

        this.tbl_options_id = tbl_options_id;
        this.tbl_options_name = tbl_options_name;
        this.tbl_options_date = tbl_options_date;
    }
    public int getTbl_options_id() {
        return tbl_options_id;
    }
    public void setTbl_options_id(int tbl_options_id) {
        this.tbl_options_id = tbl_options_id;
    }
    public String getTbl_options_name() {
        return tbl_options_name;
    }
    public void setTbl_options_name(String tbl_options_name) {
        this.tbl_options_name = tbl_options_name;
    }
    public String getTbl_options_date() {
        return tbl_options_date;
    }
    public void setTbl_options_date(String tbl_options_date) {
        this.tbl_options_date = tbl_options_date;
    }
}
