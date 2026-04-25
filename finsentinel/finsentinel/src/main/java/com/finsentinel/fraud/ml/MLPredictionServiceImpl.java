package com.finsentinel.fraud.ml;

import com.finsentinel.model.Transaction;

import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class MLPredictionServiceImpl implements MLPredictionService {
    private final RestTemplate restTemplate = new RestTemplate();

    public double getFraudProbability(Transaction tx){
        String url = "http://127.0.0.1:5000/predict";

        Map<String, Object> request = Map.of(
                "amount", tx.getAmount(),
                "location", tx.getLocation(),
                "merchantCategory", tx.getMerchantCategory()
        );

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(request, headers);

        ResponseEntity<Map> response = restTemplate.postForEntity(url, entity, Map.class);

        return ((Number) response.getBody().get("fraudProbability")).doubleValue();
    }
}
