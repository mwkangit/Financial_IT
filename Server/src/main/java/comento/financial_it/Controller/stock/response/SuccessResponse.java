package comento.financial_it.Controller.stock.response;

import lombok.Data;

@Data
public class SuccessResponse<T> extends DefaultResponse {

    private String status;
    private String result = "success";
    private String description;
    private T data;

    public SuccessResponse(String status, String description, T data) {
        this.status = status;
        this.description = description;
        this.data = data;
    }
}
