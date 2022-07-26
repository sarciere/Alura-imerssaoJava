import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        /*
         * 1. Capturar os dados do IMBD, por http, via GET;
         * 2. Fazer o parse dos dados armazenados(Titulo, poster, classificação)
         * 3. Mostrar para o usuário o dado tratado;
         */

        URI endereco = URI.create(Url.ROTA);                
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String Body = response.body();
        JsonParser parser = new JsonParser();        
        List<Map<String, String>> listaDeFilmes = parser.parse(Body);
        
        for (Map<String,String> map : listaDeFilmes) { 
            Double Nota =  Math.floor(Double.parseDouble(map.get("imDbRating")));           
            GeradorDeIcones.GerarEImprimir("\u2B50", Nota);           
            System.out.println(String.format("\u001b[1m%s", map.get("title")));
            System.out.println(map.get("image"));            
            System.out.println(map.get("imDbRating"));
            System.out.println("");
        }

        /*
         * Desafios desta aula
         * 1. Consumir o endpoint de filmes mais populares da API do IMDB. Procure também, na documentação da API do IMDB, o endpoint que retorna as melhores séries e o que retorna as séries mais populares.
         * 2. Usar sua criatividade para deixar a saída dos dados mais bonitinha: usar emojis com código UTF-8, mostrar a nota do filme como estrelinhas, decorar o terminal com cores, negrito e itálico usando códigos ANSI, e mais!
         * 3. Colocar a chave da API do IMDB em algum lugar fora do código como um arquivo de configuração (p. ex, um arquivo .properties) ou uma variável de ambiente
         * 4. Mudar o JsonParser para usar uma biblioteca de parsing de JSON como Jackson ou GSON
         * 5. Desafio supremo: criar alguma maneira para você dar uma avaliação ao filme, puxando de algum arquivo de configuração OU pedindo a avaliação para o usuário digitar no terminal.
         */

    }
}
