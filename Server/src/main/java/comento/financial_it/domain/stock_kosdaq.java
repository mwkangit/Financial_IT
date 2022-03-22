package comento.financial_it.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class stock_kosdaq {
    @Id
    private String code;
    private String code_name;
    private int check_item;

}
