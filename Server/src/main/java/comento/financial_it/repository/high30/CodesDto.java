package comento.financial_it.repository.high30;

import lombok.Data;

@Data
public class CodesDto {

    private String code;
    private String code_name;

    public CodesDto(String code, String code_name) {
        this.code = code;
        this.code_name = code_name;
    }
}
