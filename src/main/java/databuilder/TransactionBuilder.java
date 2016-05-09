package databuilder;

/**
 * Created by eduard on 1/11/16.
 */
public class TransactionBuilder {

    private long id;
    private State state;
    private boolean retryAllowed;
    private String message;
    private String billingId;

    public TransactionBuilder withId(long id){
        this.id=id;
        return this;
    }

    public TransactionBuilder withState(State state){
        this.state=state;
        return this;
    }
    public TransactionBuilder withRetryAllowed(boolean allowed){
        this.retryAllowed=allowed;
        return this;
    }
    public TransactionBuilder withMessage(String message){
        this.message=message;
        return this;
    }

    public TransactionBuilder withBillingId(String id){
        this.billingId=id;
        return this;
    }

    public Transaction build(){
        return new Transaction(id, state,
                retryAllowed, message, billingId);
    }
}
