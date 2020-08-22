package ebay.com.persistance;

/**
 * Payment
 */
public class Payment {

    private int payment_id;
    private String payment_method;
    private String payment_status;

    public Payment(){

    }

    public Payment(int payment_id, String payment_method, String payment_status){
        this.payment_id=payment_id;
        this.payment_method=payment_method;
        this.payment_status=payment_status;
    }
    public int getPayment_id() {
        return payment_id;
    }
    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
    }
    public String getPayment_method() {
        return payment_method;
    }
    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }
    public String getPayment_status() {
        return payment_status;
    }
    public void setPayment_status(String payment_status) {
        this.payment_status = payment_status;
    }
}
