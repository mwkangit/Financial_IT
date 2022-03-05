package comento.financial_it.Controller.stock.response;

import lombok.Data;

@Data
public class ErrorResponse extends DefaultResponse {

    private String status;
    private String result = "fail";
    private String description;

    public ErrorResponse(String status, String description) {
        this.status = status;
        this.description = description;
    }
}
