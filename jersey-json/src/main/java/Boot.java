import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;


public class Boot {
	
	public static void main(String[] args) throws URISyntaxException, IOException {
		URI uri = new URI("http://localhost:9090/");
		ResourceConfig config = new ResourceConfig().packages("br.com.gustavorodrigues.cinema");
		HttpServer server = GrizzlyHttpServerFactory.createHttpServer(uri, config);
		
		server.start();
		
		System.in.read();
        server.stop();
	}

}
