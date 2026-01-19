package com.roomservice.resolver;

import com.roomservice.model.*;
import com.roomservice.service.RoomServiceService;
import org.springframework.graphql.data.federation.EntityMapping;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.Map;

@Controller
public class RoomServiceController {

    private final RoomServiceService roomServiceService;

    public RoomServiceController(RoomServiceService roomServiceService) {
        this.roomServiceService = roomServiceService;
    }

    @QueryMapping
    //@SchemaMapping(typeName = "Sailing", field = "roomServiceCart")
    public RoomServiceCart roomServiceCart(@Argument String accountId, @Argument String shipCode, @Argument String sailDate, @Argument Integer itemCount, @Argument Integer subTotalMinor) {
        return roomServiceService.getRoomServiceCart(accountId, shipCode, sailDate, itemCount, subTotalMinor);
    }
    
    @SchemaMapping(typeName = "Sailing", field = "roomServiceCart")
    public RoomServiceCart getRoomServiceCart(@Argument String accountId, Sailing sailing) {
        return roomServiceService.getRoomServiceCartForSailing(sailing.getShipCode(), sailing.getSailDate(), accountId);
    }
    
    @EntityMapping
    public Sailing sailing(Map<String, Object> key) {
        String shipCode = (String) key.get("shipCode");
        String sailDate = (String) key.get("sailDate");
        // Since it's extended, return a Sailing with the extended fields
        // But actually, the base fields are from guest, but in Java, Sailing is from guest model?
        // Wait, Sailing is in guest, but for room-service, we need to import or something.
        // Since federated, the Sailing type is shared, but in code, since separate, perhaps define Sailing in room-service too.
        // Wait, in guest, Sailing is defined, but for extension, we need the class.
        // To avoid duplication, perhaps import from guest, but since separate projects, can't.
        // So, need to define Sailing in room-service model as well.
        // Yes, that's common in federation, each subgraph has its own model classes.

        // So, I need to create Sailing.java in room-service model.
        // Let's do that first.
        return new Sailing(shipCode, sailDate, SailingStatus.UPCOMING, false);
    }

    @EntityMapping
    public RoomServiceCart roomServiceCart(Map<String, Object> key) {
        String cartId = (String) key.get("cartId");
        // Mock implementation
        return roomServiceService.getRoomServiceCartById(cartId);
    }

    @QueryMapping
    public UnifiedCartSummary unifiedCartSummary(@Argument String accountId) {
        return roomServiceService.getUnifiedCartSummary(accountId);
    }

    
}
