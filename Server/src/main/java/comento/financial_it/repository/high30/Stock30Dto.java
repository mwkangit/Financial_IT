package comento.financial_it.repository.high30;

import lombok.Data;

import java.util.List;

@Data
public class Stock30Dto {

    private String code;
    private String code_name;

    public Stock30Dto(String code, String code_name) {
        this.code = code;
        this.code_name = code_name;
    }
}


