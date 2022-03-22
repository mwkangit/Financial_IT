package comento.financial_it.repository.theme;

import lombok.Builder;
import lombok.Data;

@Data
public class StockThemeDto {

    private String  code;
    private String thema_name;

    public StockThemeDto(String code, String thema_name) {
        this.code = code;
        this.thema_name = thema_name;
    }
}

