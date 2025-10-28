package com.exchange.conversor;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;

public class Conversor {

    public static void convertePorOpcao(String opcao) {

        String codigoPar = "";
        String url = "";

        switch (opcao) {

            case "1" -> {
                System.out.println("Você escolheu Dólar para Peso Argentino: ");
                System.out.println("");

                codigoPar = "USD/ARS";
            }
            case "2" -> {
                System.out.println("Você escolheu Peso Argentino para Dólar");
                System.out.println("");
                codigoPar = "ARS/USD";
            }
            case "3" -> {
                System.out.println("Você escolheu Dólar para Real Brasileiro");
                System.out.println("");
                codigoPar = "USD/BRL";
            }
            case "4" -> {
                System.out.println("Você escolheu Real Brasileiro para Dólar");
                System.out.println("");
                codigoPar = "BRL/USD";
            }
            case "5" -> System.out.println("Finalizando");
            default -> System.out.println("Opção inválida!");
        }
        
        if (!codigoPar.isEmpty()) {

            String chaveAPI = "c5ac3e2c16bf404389533e9b";
            url = "https://v6.exchangerate-api.com/v6/" + chaveAPI + "/pair/" + codigoPar;

            try {

                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();

                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();

                Gson gson = new Gson();
                Cotacao cotacao = gson.fromJson(json, Cotacao.class);

                if ("success".equals(cotacao.result())) {

                    System.out.println("Taxa de câmbio: " + cotacao.conversion_rate());
                    System.out.println("1 " + cotacao.base_code() + " = " +
                            cotacao.conversion_rate() + " " + cotacao.target_code());
                } else {

                    System.out.println("Erro na conversão: " + cotacao.error_type());
                }

            } catch (Exception e) {

                System.out.println("Erro: " + e.getMessage());
            }
        } else if (!opcao.equals("5")) {
            
            System.out.println("Digite um valor");
        }
    }
}
