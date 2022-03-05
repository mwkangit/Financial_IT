package comento.financial_it.domain;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class stock_info {
    @Id
    private String code;
    private String stock_market;
    private String category0;
    private String market_class0;
    private String market_class1;
    private String category1;
    private String audit;
    private String margin;
    private String remarks;
    private String thema_code;
    private String thema_name;

}
