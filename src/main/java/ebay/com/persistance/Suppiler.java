package ebay.com.persistance;

public class Suppiler {
    private int suppiler_id;
    private String suppiler_name;
    private String suppiler_address;
    private String suppiler_email;
    private String suppiler_pass;
    private String suppiler_phone;
    private String suppiler_status;


    public Suppiler(){

    }

    public Suppiler(int suppiler_id, String suppiler_name, String suppiler_address, String suppiler_email, String suppiler_pass, String suppiler_phone, String supplier_status){
        this.suppiler_id = suppiler_id;
        this.suppiler_name = suppiler_name;
        this.suppiler_address = suppiler_address;
        this.suppiler_email = suppiler_email;
        this.suppiler_pass = suppiler_pass;
        this.suppiler_phone = suppiler_phone;
        this.suppiler_status = supplier_status;

    }

    public int getSuppiler_id() {
        return suppiler_id;
    }
    public void setSuppiler_id(int suppiler_id) {
        this.suppiler_id = suppiler_id;
    }
    public String getSuppiler_name() {
        return suppiler_name;
    }
    public void setSuppiler_name(String suppiler_name) {
        this.suppiler_name = suppiler_name;
    }
    public String getSuppiler_address() {
        return suppiler_address;
    }
    public void setSuppiler_address(String suppiler_address) {
        this.suppiler_address = suppiler_address;
    }
    public String getSuppiler_email() {
        return suppiler_email;
    }
    public void setSuppiler_email(String suppiler_email) {
        this.suppiler_email = suppiler_email;
    }
    public String getSuppiler_pass() {
        return suppiler_pass;
    }
    public void setSuppiler_pass(String suppiler_pass) {
        this.suppiler_pass = suppiler_pass;
    }
    public String getSuppiler_phone() {
        return suppiler_phone;
    }
    public void setSuppiler_phone(String suppiler_phone) {
        this.suppiler_phone = suppiler_phone;
    }
    public String getSuppiler_status() {
        return suppiler_status;
    }
    public void setSuppiler_status(String suppiler_status) {
        this.suppiler_status = suppiler_status;
    }
}
