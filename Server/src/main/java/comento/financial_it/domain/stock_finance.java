package comento.financial_it.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class stock_finance {

    private String date;
    @Id
    private String code;
    private String settlement_month;
    private float par_value;
    private float capital_stock;
    private float listed_stock;
    private float credit_rate;
    private float year_highest;
    private float year_lowest;
    private float market_cap;
    private float ROE;
    private float EPS;
    private float foreign_rate;
    private float sub_price;
    private float PER;
    private float PBR;
    private float EV;
    private float BPS;
    private float gross_fit;
    private float operation_income;
    private float net_income;

    @Column(name = "250highest")
    private float highest250;
    @Column(name = "250lowest")
    private float lowest250;

    private float upper_limit;
    private float lower_limit;
    private float standard_price;

    @Column(name = "250highest_date")
    private String highest_date250;
    @Column(name = "250lowest_date")
    private String lowest_date250;
    @Column(name = "250lowest_rate")
    private float lowest_rate250;

    private float trading_rate;
    private float outstanding_stock;
    private float outstanding_rate;

}
