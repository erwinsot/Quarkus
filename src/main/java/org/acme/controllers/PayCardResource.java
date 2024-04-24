package org.acme.controllers;

import java.util.Optional;

import org.acme.dtos.CardTransactionResponseDTO;
import org.acme.dtos.DataPayCardDTO;
import org.acme.dtos.DataPayCardMapper;
import org.acme.models.DataPayCard;
import org.acme.service.DataPayCardService;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/card")
public class PayCardResource {

    private DataPayCardMapper dataPayCardMapper;
    private DataPayCardService dataPayCardService;

    @Inject
    public PayCardResource(DataPayCardMapper dataPayCardMapper, DataPayCardService dataPayCardService) {
        this.dataPayCardMapper = dataPayCardMapper;
        this.dataPayCardService = dataPayCardService;
    }

    @POST
    @Path("/CardSave")
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public Response processPaymentWithCardData(DataPayCardDTO dataPayCardDTO) {
        try {

            // Convertir DTO a entidad de datos
            DataPayCard dataPayCard = dataPayCardMapper.toDataPayCard(dataPayCardDTO);

            // Guardar los datos de la tarjeta de crédito
            Optional<DataPayCard> savedDataPayCard = dataPayCardService.save(dataPayCard);

            // Devolver una respuesta exitosa con la entidad guardada
            return Response.ok(savedDataPayCard).build();
        } catch (Exception e) {
            // Manejar excepciones y devolver una respuesta de error
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Ocurrió un error al procesar el pago")
                    .build();
        }
    }

    @GET
    @Path("/CardTransaction/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTransaction(@PathParam("id") Long id) {
        try {
            // Buscar la transacción por ID
            Optional<CardTransactionResponseDTO> optionalCardTransaction = dataPayCardService.findById(id);
            if (optionalCardTransaction.isPresent()) {
                // Devolver una respuesta con el objeto DataPayCard contenido en el Optional
                CardTransactionResponseDTO dataPayCard = optionalCardTransaction.get();
                return Response.ok(dataPayCard).build();
            } else {
                // Devolver una respuesta de error si no se encuentra la transacción
                return Response.status(Response.Status.NOT_FOUND).entity("No se encontró la transacción").build();
            }
        } catch (Exception e) {
            // Manejar excepciones y devolver una respuesta de error
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Ocurrió un error al buscar la transacción").build();
        }
    }

    @GET
    @Path("/CardAllTransactions")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response getAllTransactions() {
        try {
            // Buscar todas las transacciones
            return Response.ok(dataPayCardService.findAll()).build();
        } catch (Exception e) {
            // Devolver una respuesta
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Ocurrió un error al buscar las transacciones").build();
        }
    }

}
