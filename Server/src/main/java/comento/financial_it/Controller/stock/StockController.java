package comento.financial_it.Controller.stock;

import comento.financial_it.Controller.stock.response.ErrorResponse;
import comento.financial_it.Controller.stock.response.DefaultResponse;
import comento.financial_it.Controller.stock.response.StatusEnum;
import comento.financial_it.Controller.stock.response.SuccessResponse;
import comento.financial_it.repository.detail.StockDetailDto;
import comento.financial_it.repository.sum.StockSumDto;
import comento.financial_it.repository.high30.Stock30Dto;
import comento.financial_it.repository.theme.StockThemeDto;
import comento.financial_it.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("stock")
@RequiredArgsConstructor
public class StockController {

    private final StockService stockService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public String welcome(){
        return "Welcome Stock";
    }

    @RequestMapping("/theme")
    @GetMapping
    public ResponseEntity<? extends DefaultResponse> theme(@RequestParam String codeName){
        if(codeName.length() == 0){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorResponse(StatusEnum.BAD_REQUEST.getCodeNumber(), StatusEnum.BAD_REQUEST.getCodeMessage()));
        }

        StockThemeDto stockThemeDto = stockService.findThemeName(codeName);

        if(stockThemeDto == null){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new ErrorResponse(StatusEnum.NOT_FOUND.getCodeNumber(), StatusEnum.NOT_FOUND.getCodeMessage()));
        } else{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new SuccessResponse<String>(StatusEnum.OK.getCodeNumber(), StatusEnum.OK.getCodeMessage(), stockThemeDto.getThema_name()));
        }

    }

    @RequestMapping("/marketcap/sum")
    @GetMapping
    public ResponseEntity<? extends DefaultResponse> marketCapSum(@RequestParam String market){
        if(market.length() == 0){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorResponse(StatusEnum.BAD_REQUEST.getCodeNumber(), StatusEnum.BAD_REQUEST.getCodeMessage()));
        }

        StockSumDto stockSumDto = stockService.findMarketCapSum(market);

        if(stockSumDto == null){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new ErrorResponse(StatusEnum.NOT_FOUND.getCodeNumber(), StatusEnum.NOT_FOUND.getCodeMessage()));
        } else{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new SuccessResponse<Double>(StatusEnum.OK.getCodeNumber(), StatusEnum.OK.getCodeMessage(), stockSumDto.getMarketCapSum()));
        }
    }

    @RequestMapping("/code/30")
    @GetMapping
    public ResponseEntity<? extends DefaultResponse> market30(@RequestParam String market){
        if(market.length() == 0){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorResponse(StatusEnum.BAD_REQUEST.getCodeNumber(), StatusEnum.BAD_REQUEST.getCodeMessage()));
        }

        List<Stock30Dto> stock30Dto = stockService.findMarket30(market);

        if(stock30Dto == null){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new ErrorResponse(StatusEnum.NOT_FOUND.getCodeNumber(), StatusEnum.NOT_FOUND.getCodeMessage()));
        } else{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new SuccessResponse<List<Stock30Dto>>(StatusEnum.OK.getCodeNumber(), StatusEnum.OK.getCodeMessage(), stock30Dto));
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping("/code/detail")
    @GetMapping
    public ResponseEntity<? extends DefaultResponse> codeDetail(@RequestParam String code){
        if(code.length() == 0){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorResponse(StatusEnum.BAD_REQUEST.getCodeNumber(), StatusEnum.BAD_REQUEST.getCodeMessage()));
        }

        StockDetailDto codeDetail = stockService.findCodeDetail(code);

        if(codeDetail == null){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new ErrorResponse(StatusEnum.NOT_FOUND.getCodeNumber(), StatusEnum.NOT_FOUND.getCodeMessage()));
        } else{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new SuccessResponse<StockDetailDto>(StatusEnum.OK.getCodeNumber(), StatusEnum.OK.getCodeMessage(), codeDetail));
        }
    }

}
