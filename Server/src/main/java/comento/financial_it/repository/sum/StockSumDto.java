package comento.financial_it.repository.sum;

import lombok.Data;

@Data
public class StockSumDto {

    private Double marketCapSum;

    public StockSumDto(Double marketCapSum) {
        this.marketCapSum = marketCapSum;
    }
}
