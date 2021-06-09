package edu.utn.Parcial.api.dolar;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "Dolar", url = "${api.dolar.url}")
public interface DolarClient {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    List<DolarResponse> getDolarEnchages();


}