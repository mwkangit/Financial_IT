package comento.financial_it.repository.detail;

import lombok.Data;

@Data
public class StockDetailDto {

    private String code;
    private String code_name;
    private String thema_name;
    private Float sub_price;
    private Float ROE;
    private Float PER;

    public StockDetailDto(String code, String code_name, String thema_name, Float sub_price, Float ROE, Float PER) {
        this.code = code;
        this.code_name = code_name;
        this.thema_name = thema_name;
        this.sub_price = sub_price;
        this.ROE = ROE;
        this.PER = PER;
    }
}
