package org.acme.camelConfigurations;

import org.acme.dtos.DataPayCardDTO;
import org.acme.models.DataPayCard;
import org.apache.camel.Exchange;
import org.apache.camel.builder.endpoint.EndpointRouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.model.dataformat.JsonLibrary;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class CamelRoutes extends EndpointRouteBuilder {
        private JacksonDataFormat jacksonDataFormat;

        public CamelRoutes() {
                jacksonDataFormat = new JacksonDataFormat(DataPayCard.class);
        }

        @Override
        public void configure() throws Exception {

                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);

                from("timer:foo?repeatCount=1") // Esto es solo para iniciar la ruta, podrías cambiarlo según tu
                                                // necesidad
                                .to("https://api.restful-api.dev/objects") // Aquí especificas la URL de la API REST que
                                                                           // deseas consumir
                                .to("log:result") // Esto es solo para registrar la respuesta en la consola
                                .to("direct:hello");

                from("direct:hello")
                                .log("body = ${body}");

                /*
                 * from("jetty:http://localhost:5356/card/CardSave?httpMethodRestrict=POST")
                 * .to("log:input");
                 */

                /*
                 * from("jetty:http://0.0.0.0:4546/card/CardSave")
                 * .routeId("cardSaveRoute")
                 * .log("Received POST request: ${body}")
                 * // Agrega aquí la lógica adicional para procesar los datos de la tarjeta
                 * .end();
                 */

                /*
                 * from("platform-http:/card/saveCard")
                 * .routeId("cardSaveRoute")
                 * .log("Received POST request: ${body}")
                 * .setHeader(Exchange.HTTP_METHOD, constant("POST"))
                 * .setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
                 * .marshal(jacksonDataFormat);
                 */
                /* .marshal().json(JsonLibrary.Jackson, ObjectMapper.class); */
                /* .to("http://localhost:4545/card/CardSave"); */

               /*  restConfiguration()
                                .component("netty-http")
                                .host("")
                                .port(7575);

                rest("/card")
                                .get("/users")
                                .to("direct:users");

                from("direct:users")
                                .log("Received GET request for users")
                                .setBody(constant("Hello World"));

                rest("/card")
                                .post("/saveCard")
                                .consumes("application/json")
                                .type(DataPayCardDTO.class)
                                .to("direct:saveCard");

                from("direct:saveCard")
                                .log("Received POST request: ${body}")
                                .setHeader(Exchange.HTTP_METHOD, constant("POST"))
                                .setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
                                .process(new CardProcessor())         
                                               
                                .log("processing message: ${body}")
                                .setHeader(Exchange.HTTP_METHOD, constant("POST"))
                                .to("http://localhost:4545/card/CardSave?bridgeEndpoint=true");  */                     

               

        }

}
