package comento.financial_it.Controller.stock.response;

import lombok.Getter;

@Getter
public enum StatusEnum {

    OK("200", "OK"),
    BAD_REQUEST("400", "BAD_REQUEST"),
    NOT_FOUND("404", "NOT_FOUND"),
    INTERNAL_SERVER_ERROR("500", "INTERNAL_SERVER_ERR0R");

    private String codeNumber;
    private String codeMessage;

    StatusEnum(String codeNumber, String codeMessage) {
        this.codeNumber = codeNumber;
        this.codeMessage = codeMessage;
    }
}
