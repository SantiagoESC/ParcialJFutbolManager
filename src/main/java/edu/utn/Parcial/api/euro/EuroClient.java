package edu.utn.Parcial.api.euro;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "Euro", url = "${api.euro.url}")// --> en properties api.euro.url="url"
public interface EuroClient {


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    EuroResponse getEuroEnchages();

}
