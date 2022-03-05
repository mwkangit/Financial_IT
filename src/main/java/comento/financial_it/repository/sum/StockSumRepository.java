package comento.financial_it.repository.sum;

import comento.financial_it.repository.sum.StockSumDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class StockSumRepository {

    private final EntityManager em;

    public StockSumDto marketCapSum(String market){
        Optional<StockSumDto> result = em.createQuery("select new comento.financial_it.repository.sum.StockSumDto(sum(market_cap)) " +
                        "from stock_finance " +
                        "where code in (select code from stock_info where stock_market= :market) " +
                        "order by market_cap desc", StockSumDto.class)
                .setMaxResults(5)
                .setParameter("market", market)
                .getResultList()
                .stream().findFirst();
//        System.out.println("result = " + result);
        StockSumDto stockSumDto = result.orElse(null);
        if(stockSumDto.getMarketCapSum() == null){
            return null;
        }else{
            return stockSumDto;
        }
    }

}
