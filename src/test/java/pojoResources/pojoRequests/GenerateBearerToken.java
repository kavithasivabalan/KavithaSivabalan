package pojoResources.pojoRequests;

public class GenerateBearerToken {
    private String clientName;
    private String clientEmail;

    public GenerateBearerToken(String name, String email){
        clientName = name;
        clientEmail = email;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }
}
