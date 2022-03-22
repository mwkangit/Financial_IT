package comento.financial_it.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class stock_price {

    private String date;
    private String check_item;
    @Id
    private String code;
    private String code_name;
    private String d1_diff_rate;
    private String close;
    private String open;
    private String high;
    private String low;
    private String volume;

}
