package comento.financial_it.service;

import comento.financial_it.repository.detail.StockDetailRepository;
import comento.financial_it.repository.high30.Stock30Repository;
import comento.financial_it.repository.sum.StockSumRepository;
import comento.financial_it.repository.detail.StockDetailDto;
import comento.financial_it.repository.sum.StockSumDto;
import comento.financial_it.repository.theme.StockThemeDto;
import comento.financial_it.repository.theme.ThemeRepository;
import comento.financial_it.repository.high30.Stock30Dto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class StockService {

    private final ThemeRepository themeRepository;
    private final StockSumRepository stockSumRepository;
    private final Stock30Repository stock30Repository;
    private final StockDetailRepository stockDetailRepository;

    public StockThemeDto findThemeName(String codeName){
        StockThemeDto result = themeRepository.themeName(codeName);
        return result;
    }

    public StockSumDto findMarketCapSum(String market){
        StockSumDto result = stockSumRepository.marketCapSum(market);
        return result;
    }

    public List<Stock30Dto> findMarket30(String market){
        List<Stock30Dto> result = null;
        if (market.equals("코스닥")){
            result = stock30Repository.market30Kosdaq(market);
        } else if(market.equals("코스피")){
            result = stock30Repository.market30Kospi(market);
        }

        return result;
    }

    public StockDetailDto findCodeDetail(String code){
        StockDetailDto result = stockDetailRepository.codeDetail(code);
        return result;
    }



}
