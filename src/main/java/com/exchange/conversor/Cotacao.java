package com.exchange.conversor;

public record Cotacao(String result, String base_code, String target_code, 
double conversion_rate, double conversion_result, String error_type) {
 
}
